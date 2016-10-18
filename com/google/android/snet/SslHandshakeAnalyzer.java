package com.google.android.snet;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

class SslHandshakeAnalyzer {
    private static final String CERT_FACTORY_TYPE = "X.509";
    private static final int HTTPS_URL_CONNECTION = 2;
    private static final String RSA_ALGORITHM = "RSA";
    private static final int SSL_PORT = 443;
    private static final int SSL_SOCKET = 1;
    private static final String SYSTEM_CA_STORE_PATH = "/system/etc/security/cacerts";
    private static final String SYSTEM_CA_STORE_PRE_ICS_PATH = "/system/etc/security/cacerts.bks";
    private static final String TAG = SslHandshakeAnalyzer.class.getCanonicalName();
    private static final String USER_ADDED_CA_STORE_PATH_OLD = "/data/misc/keychain/cacerts-added";
    private static Set<X509Certificate> sPreIcsCaStoreCache = new HashSet();
    private final SslHandshakeAnalyzerValues mAnalyzerValues;
    private final Context mContext;
    private final GBundle mGBundle;
    private final SnetLogger mSnetLogger;
    private List<SslInfo> mSslInfo = new ArrayList();

    class C05971 implements HandshakeCompletedListener {
        final /* synthetic */ SslInfo val$sslInfo;

        C05971(SslInfo sslInfo) {
            this.val$sslInfo = sslInfo;
        }

        public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
            SSLSession session = handshakeCompletedEvent.getSession();
            this.val$sslInfo.protocol = session.getProtocol();
            this.val$sslInfo.cipherSuite = session.getCipherSuite();
        }
    }

    public static class CertPinInfo {
        public boolean chainIsTrusted;
        public boolean inCaStore;
        public boolean pinTestError;
        public boolean userAdded;
    }

    private static class MySSLSocketFactory extends SSLSocketFactory {
        private final SSLSocketFactory delegate;
        private HandshakeCompletedListener handshakeListener;

        public MySSLSocketFactory(SSLSocketFactory delegate, HandshakeCompletedListener handshakeListener) {
            this.delegate = delegate;
            this.handshakeListener = handshakeListener;
        }

        public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
            if (this.delegate == null) {
                return null;
            }
            SSLSocket socket = (SSLSocket) this.delegate.createSocket(s, host, port, autoClose);
            addHandshakeCompletedListener(socket);
            return socket;
        }

        public Socket createSocket(String s, int i) throws IOException {
            if (this.delegate == null) {
                return null;
            }
            SSLSocket socket = (SSLSocket) this.delegate.createSocket(s, i);
            addHandshakeCompletedListener(socket);
            return socket;
        }

        public Socket createSocket(String s, int i, InetAddress inetAddress, int i1) throws IOException {
            if (this.delegate == null) {
                return null;
            }
            SSLSocket socket = (SSLSocket) this.delegate.createSocket(s, i);
            addHandshakeCompletedListener(socket);
            return socket;
        }

        public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
            if (this.delegate == null) {
                return null;
            }
            SSLSocket socket = (SSLSocket) this.delegate.createSocket(inetAddress, i);
            addHandshakeCompletedListener(socket);
            return socket;
        }

        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress1, int i1) throws IOException {
            if (this.delegate == null) {
                return null;
            }
            SSLSocket socket = (SSLSocket) this.delegate.createSocket(inetAddress, i, inetAddress1, i1);
            addHandshakeCompletedListener(socket);
            return socket;
        }

        public String[] getDefaultCipherSuites() {
            if (this.delegate == null) {
                return null;
            }
            return this.delegate.getDefaultCipherSuites();
        }

        public String[] getSupportedCipherSuites() {
            if (this.delegate == null) {
                return null;
            }
            return this.delegate.getSupportedCipherSuites();
        }

        private void addHandshakeCompletedListener(SSLSocket socket) {
            if (this.handshakeListener != null && socket != null) {
                socket.addHandshakeCompletedListener(this.handshakeListener);
            }
        }
    }

    public static class SslInfo {
        public boolean certInCaStore;
        public boolean certUserAdded;
        public boolean chainIsTrusted;
        public boolean chainIsValid;
        public String cipherSuite;
        public boolean extendedKeyUsageVerified;
        public String host;
        public boolean hostnameVerificationSucceeded;
        public Certificate[] peerCertificates;
        public boolean pinTestError;
        public String protocol;
        public int sslConnectionMethod;
        public boolean sslConnectionSucceeded;
        public boolean sslPeerCertificatesRetrieved;
        public boolean sslSessionValid;
        public boolean sslSocketCreated;
        public boolean x509TrustManagerAcceptedConnection;
        public boolean x509TrustManagerExists;
    }

    private static class TrustAllX509TrustManager implements X509TrustManager {
        private TrustAllX509TrustManager() {
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    private void httpsConnectionHandshake(java.lang.String r24) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:80)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r23 = this;
        r9 = 0;
        r15 = new com.google.android.snet.SslHandshakeAnalyzer$SslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.<init>();	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r24;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.host = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = 2;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.sslConnectionMethod = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = "TLS";	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r14 = javax.net.ssl.SSLContext.getInstance(r20);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r16 = new com.google.android.snet.SslHandshakeAnalyzer$TrustAllX509TrustManager;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r16;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r1 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.<init>();	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = 1;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = new javax.net.ssl.TrustManager[r0];	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r17 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r17[r20] = r16;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = (javax.net.ssl.KeyManager[]) r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r21 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r21 = (java.security.SecureRandom) r21;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r1 = r17;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r2 = r21;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r14.init(r0, r1, r2);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r18 = new java.net.URL;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = "https";	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r21 = "";	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r18;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r1 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r2 = r24;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r3 = r21;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.<init>(r1, r2, r3);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r18.openConnection();	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r9 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        if (r9 != 0) goto L_0x0071;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
    L_0x005a:
        r20 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.sslConnectionSucceeded = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.add(r15);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        if (r9 == 0) goto L_0x0070;
    L_0x006d:
        r9.disconnect();
    L_0x0070:
        return;
    L_0x0071:
        r20 = 1;
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.sslConnectionSucceeded = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = new com.google.android.snet.SslHandshakeAnalyzer$MySSLSocketFactory;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r21 = r14.getSocketFactory();	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r22 = new com.google.android.snet.SslHandshakeAnalyzer$1;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r22;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r1 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.<init>(r15);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20.<init>(r21, r22);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r9.setSSLSocketFactory(r0);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r9.connect();	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = 1;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.sslSocketCreated = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = 1;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.sslSessionValid = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r13 = 0;
        r13 = r9.getServerCertificates();	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
        if (r13 == 0) goto L_0x00de;	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
    L_0x00a4:
        r0 = r13.length;	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
        r20 = r0;	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
        if (r20 == 0) goto L_0x00de;	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
    L_0x00a9:
        r20 = 1;	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
        r0 = r20;	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
        r15.sslPeerCertificatesRetrieved = r0;	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
        r19 = 0;
        r19 = findX509TrustManager();	 Catch:{ KeyStoreException -> 0x0111, NoSuchAlgorithmException -> 0x0131, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270 }
    L_0x00b5:
        if (r19 == 0) goto L_0x0152;
    L_0x00b7:
        r20 = 1;
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.x509TrustManagerExists = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r8 = 0;
        r0 = r13.length;	 Catch:{ CertificateException -> 0x023c }
        r20 = r0;	 Catch:{ CertificateException -> 0x023c }
        r0 = r20;	 Catch:{ CertificateException -> 0x023c }
        r7 = new java.security.cert.X509Certificate[r0];	 Catch:{ CertificateException -> 0x023c }
        r11 = 0;	 Catch:{ CertificateException -> 0x023c }
        r0 = r13.length;	 Catch:{ CertificateException -> 0x023c }
        r21 = r0;	 Catch:{ CertificateException -> 0x023c }
        r20 = 0;	 Catch:{ CertificateException -> 0x023c }
        r12 = r11;	 Catch:{ CertificateException -> 0x023c }
    L_0x00cc:
        r0 = r20;	 Catch:{ CertificateException -> 0x023c }
        r1 = r21;	 Catch:{ CertificateException -> 0x023c }
        if (r0 >= r1) goto L_0x017e;	 Catch:{ CertificateException -> 0x023c }
    L_0x00d2:
        r5 = r13[r20];	 Catch:{ CertificateException -> 0x023c }
        r11 = r12 + 1;	 Catch:{ CertificateException -> 0x023c }
        r5 = (java.security.cert.X509Certificate) r5;	 Catch:{ CertificateException -> 0x023c }
        r7[r12] = r5;	 Catch:{ CertificateException -> 0x023c }
        r20 = r20 + 1;
        r12 = r11;
        goto L_0x00cc;
    L_0x00de:
        r20 = 0;
        r0 = r20;	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
        r15.sslPeerCertificatesRetrieved = r0;	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
        r0 = r23;	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
        r0 = r0.mSslInfo;	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
        r20 = r0;	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
        r0 = r20;	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
        r0.add(r15);	 Catch:{ SSLPeerUnverifiedException -> 0x00f6, IllegalStateException -> 0x028a, NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d }
        if (r9 == 0) goto L_0x0070;
    L_0x00f1:
        r9.disconnect();
        goto L_0x0070;
    L_0x00f6:
        r20 = move-exception;
        r10 = r20;
    L_0x00f9:
        r20 = 0;
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.sslPeerCertificatesRetrieved = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.add(r15);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        if (r9 == 0) goto L_0x0070;
    L_0x010c:
        r9.disconnect();
        goto L_0x0070;
    L_0x0111:
        r10 = move-exception;
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r0.mSnetLogger;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.writeException(r10);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        goto L_0x00b5;
    L_0x011e:
        r10 = move-exception;
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r0.mSnetLogger;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.writeException(r10);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        if (r9 == 0) goto L_0x0070;
    L_0x012c:
        r9.disconnect();
        goto L_0x0070;
    L_0x0131:
        r10 = move-exception;
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r0.mSnetLogger;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.writeException(r10);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        goto L_0x00b5;
    L_0x013f:
        r10 = move-exception;
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r0.mSnetLogger;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.writeException(r10);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        if (r9 == 0) goto L_0x0070;
    L_0x014d:
        r9.disconnect();
        goto L_0x0070;
    L_0x0152:
        r20 = 0;
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.x509TrustManagerExists = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.add(r15);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = new java.lang.IllegalStateException;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r21 = "No X509TrustManager found";	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20.<init>(r21);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        throw r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
    L_0x016b:
        r10 = move-exception;
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r0.mSnetLogger;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.writeException(r10);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        if (r9 == 0) goto L_0x0070;
    L_0x0179:
        r9.disconnect();
        goto L_0x0070;
    L_0x017e:
        r20 = android.os.Build.VERSION.SDK_INT;	 Catch:{ CertificateException -> 0x023c }
        r21 = 21;	 Catch:{ CertificateException -> 0x023c }
        r0 = r20;	 Catch:{ CertificateException -> 0x023c }
        r1 = r21;	 Catch:{ CertificateException -> 0x023c }
        if (r0 < r1) goto L_0x0220;	 Catch:{ CertificateException -> 0x023c }
    L_0x0188:
        r20 = "RSA";	 Catch:{ CertificateException -> 0x023c }
        r0 = r19;	 Catch:{ CertificateException -> 0x023c }
        r1 = r20;	 Catch:{ CertificateException -> 0x023c }
        r2 = r24;	 Catch:{ CertificateException -> 0x023c }
        r8 = checkServerTrustedPostL(r0, r7, r1, r2);	 Catch:{ CertificateException -> 0x023c }
    L_0x0194:
        r20 = 1;	 Catch:{ CertificateException -> 0x023c }
        r0 = r20;	 Catch:{ CertificateException -> 0x023c }
        r15.chainIsValid = r0;	 Catch:{ CertificateException -> 0x023c }
        r20 = 1;	 Catch:{ CertificateException -> 0x023c }
        r0 = r20;	 Catch:{ CertificateException -> 0x023c }
        r15.x509TrustManagerAcceptedConnection = r0;	 Catch:{ CertificateException -> 0x023c }
        r20 = 1;
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.hostnameVerificationSucceeded = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = new java.security.cert.Certificate[r0];	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r8.toArray(r0);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = (java.security.cert.Certificate[]) r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r1 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r6 = r0.certPinInfo(r1);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r6.chainIsTrusted;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.chainIsTrusted = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r6.pinTestError;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.pinTestError = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r6.userAdded;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.certUserAdded = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r6.inCaStore;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.certInCaStore = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = new java.security.cert.Certificate[r0];	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r8.toArray(r0);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = (java.security.cert.Certificate[]) r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r1 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0.ekuContainsAcceptedOid(r1);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.extendedKeyUsageVerified = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r15.chainIsValid;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        if (r20 == 0) goto L_0x020c;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
    L_0x0200:
        r0 = r15.chainIsTrusted;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        if (r20 == 0) goto L_0x020c;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
    L_0x0206:
        r0 = r15.extendedKeyUsageVerified;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        if (r20 != 0) goto L_0x020e;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
    L_0x020c:
        r15.peerCertificates = r13;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
    L_0x020e:
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.add(r15);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        if (r9 == 0) goto L_0x0070;
    L_0x021b:
        r9.disconnect();
        goto L_0x0070;
    L_0x0220:
        r20 = "RSA";	 Catch:{ CertificateException -> 0x023c }
        r0 = r19;	 Catch:{ CertificateException -> 0x023c }
        r1 = r20;	 Catch:{ CertificateException -> 0x023c }
        r0.checkServerTrusted(r7, r1);	 Catch:{ CertificateException -> 0x023c }
        r4 = new com.google.android.snet.PreLCertificateChainBuilder;	 Catch:{ CertificateException -> 0x023c }
        r0 = r23;	 Catch:{ CertificateException -> 0x023c }
        r0 = r0.mContext;	 Catch:{ CertificateException -> 0x023c }
        r20 = r0;	 Catch:{ CertificateException -> 0x023c }
        r0 = r20;	 Catch:{ CertificateException -> 0x023c }
        r4.<init>(r0);	 Catch:{ CertificateException -> 0x023c }
        r8 = r4.buildCertChain(r7);	 Catch:{ CertificateException -> 0x023c }
        goto L_0x0194;
    L_0x023c:
        r10 = move-exception;
        r20 = 0;
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.chainIsValid = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.x509TrustManagerAcceptedConnection = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r15.peerCertificates = r13;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.add(r15);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        if (r9 == 0) goto L_0x0070;
    L_0x0258:
        r9.disconnect();
        goto L_0x0070;
    L_0x025d:
        r10 = move-exception;
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r0.mSnetLogger;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.writeException(r10);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        if (r9 == 0) goto L_0x0070;
    L_0x026b:
        r9.disconnect();
        goto L_0x0070;
    L_0x0270:
        r10 = move-exception;
        r0 = r23;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r0.mSnetLogger;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r20 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0 = r20;	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        r0.writeException(r10);	 Catch:{ NoSuchAlgorithmException -> 0x011e, KeyManagementException -> 0x013f, MalformedURLException -> 0x016b, IOException -> 0x025d, IllegalStateException -> 0x0270, all -> 0x0283 }
        if (r9 == 0) goto L_0x0070;
    L_0x027e:
        r9.disconnect();
        goto L_0x0070;
    L_0x0283:
        r20 = move-exception;
        if (r9 == 0) goto L_0x0289;
    L_0x0286:
        r9.disconnect();
    L_0x0289:
        throw r20;
    L_0x028a:
        r20 = move-exception;
        r10 = r20;
        goto L_0x00f9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.snet.SslHandshakeAnalyzer.httpsConnectionHandshake(java.lang.String):void");
    }

    List<SslInfo> sslInfoList() {
        return this.mSslInfo;
    }

    SslHandshakeAnalyzer(Context context, SnetLogger snetLog, SslHandshakeAnalyzerValues analyzerValues, GBundle gBundle) {
        this.mContext = context;
        this.mSnetLogger = snetLog;
        this.mAnalyzerValues = analyzerValues;
        this.mGBundle = gBundle;
    }

    void analyzeSslHandshake() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            for (String host : this.mGBundle.getSslHandshakeTestHosts().split(Csv.COMMA)) {
                if (!TextUtils.isEmpty(host)) {
                    sslSocketHandshake(host);
                    httpsConnectionHandshake(host);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sslSocketHandshake(java.lang.String r23) {
        /*
        r22 = this;
        r16 = 0;
        r14 = new com.google.android.snet.SslHandshakeAnalyzer$SslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r14.<init>();	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r23;
        r14.host = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = 1;
        r0 = r20;
        r14.sslConnectionMethod = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = "TLS";
        r13 = javax.net.ssl.SSLContext.getInstance(r20);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r17 = new com.google.android.snet.SslHandshakeAnalyzer$TrustAllX509TrustManager;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = 0;
        r0 = r17;
        r1 = r20;
        r0.<init>();	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = 1;
        r0 = r20;
        r0 = new javax.net.ssl.TrustManager[r0];	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r18 = r0;
        r20 = 0;
        r18[r20] = r17;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = 0;
        r20 = (javax.net.ssl.KeyManager[]) r20;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r21 = 0;
        r21 = (java.security.SecureRandom) r21;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r20;
        r1 = r18;
        r2 = r21;
        r13.init(r0, r1, r2);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r13.getSocketFactory();	 Catch:{ IOException -> 0x00be }
        r21 = 443; // 0x1bb float:6.21E-43 double:2.19E-321;
        r0 = r20;
        r1 = r23;
        r2 = r21;
        r20 = r0.createSocket(r1, r2);	 Catch:{ IOException -> 0x00be }
        r0 = r20;
        r0 = (javax.net.ssl.SSLSocket) r0;	 Catch:{ IOException -> 0x00be }
        r16 = r0;
        r20 = 1;
        r0 = r20;
        r14.sslSocketCreated = r0;	 Catch:{ IOException -> 0x00be }
        r15 = r16.getSession();	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        if (r15 == 0) goto L_0x00dc;
    L_0x0061:
        r20 = r15.isValid();	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        if (r20 == 0) goto L_0x00dc;
    L_0x0067:
        r20 = 1;
        r0 = r20;
        r14.sslSessionValid = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r15.getProtocol();	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r20;
        r14.protocol = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r15.getCipherSuite();	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r20;
        r14.cipherSuite = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r12 = 0;
        r12 = r15.getPeerCertificates();	 Catch:{ SSLPeerUnverifiedException -> 0x011a }
        if (r12 == 0) goto L_0x00fb;
    L_0x0084:
        r0 = r12.length;	 Catch:{ SSLPeerUnverifiedException -> 0x011a }
        r20 = r0;
        if (r20 == 0) goto L_0x00fb;
    L_0x0089:
        r20 = 1;
        r0 = r20;
        r14.sslPeerCertificatesRetrieved = r0;	 Catch:{ SSLPeerUnverifiedException -> 0x011a }
        r19 = 0;
        r19 = findX509TrustManager();	 Catch:{ KeyStoreException -> 0x013a, NoSuchAlgorithmException -> 0x0164, KeyManagementException -> 0x0172 }
    L_0x0095:
        if (r19 == 0) goto L_0x018e;
    L_0x0097:
        r20 = 1;
        r0 = r20;
        r14.x509TrustManagerExists = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r7 = 0;
        r0 = r12.length;	 Catch:{ CertificateException -> 0x0287 }
        r20 = r0;
        r0 = r20;
        r6 = new java.security.cert.X509Certificate[r0];	 Catch:{ CertificateException -> 0x0287 }
        r10 = 0;
        r0 = r12.length;	 Catch:{ CertificateException -> 0x0287 }
        r21 = r0;
        r20 = 0;
        r11 = r10;
    L_0x00ac:
        r0 = r20;
        r1 = r21;
        if (r0 >= r1) goto L_0x01b4;
    L_0x00b2:
        r4 = r12[r20];	 Catch:{ CertificateException -> 0x0287 }
        r10 = r11 + 1;
        r4 = (java.security.cert.X509Certificate) r4;	 Catch:{ CertificateException -> 0x0287 }
        r6[r11] = r4;	 Catch:{ CertificateException -> 0x0287 }
        r20 = r20 + 1;
        r11 = r10;
        goto L_0x00ac;
    L_0x00be:
        r8 = move-exception;
        r20 = 0;
        r0 = r20;
        r14.sslSocketCreated = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r22;
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r0.add(r14);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        if (r16 == 0) goto L_0x00db;
    L_0x00d2:
        r20 = r16.isClosed();
        if (r20 != 0) goto L_0x00db;
    L_0x00d8:
        r16.close();	 Catch:{ IOException -> 0x02d4 }
    L_0x00db:
        return;
    L_0x00dc:
        r20 = 0;
        r0 = r20;
        r14.sslSessionValid = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r22;
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r0.add(r14);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        if (r16 == 0) goto L_0x00db;
    L_0x00ef:
        r20 = r16.isClosed();
        if (r20 != 0) goto L_0x00db;
    L_0x00f5:
        r16.close();	 Catch:{ IOException -> 0x00f9 }
        goto L_0x00db;
    L_0x00f9:
        r20 = move-exception;
        goto L_0x00db;
    L_0x00fb:
        r20 = 0;
        r0 = r20;
        r14.sslPeerCertificatesRetrieved = r0;	 Catch:{ SSLPeerUnverifiedException -> 0x011a }
        r0 = r22;
        r0 = r0.mSslInfo;	 Catch:{ SSLPeerUnverifiedException -> 0x011a }
        r20 = r0;
        r0 = r20;
        r0.add(r14);	 Catch:{ SSLPeerUnverifiedException -> 0x011a }
        if (r16 == 0) goto L_0x00db;
    L_0x010e:
        r20 = r16.isClosed();
        if (r20 != 0) goto L_0x00db;
    L_0x0114:
        r16.close();	 Catch:{ IOException -> 0x0118 }
        goto L_0x00db;
    L_0x0118:
        r20 = move-exception;
        goto L_0x00db;
    L_0x011a:
        r8 = move-exception;
        r20 = 0;
        r0 = r20;
        r14.sslPeerCertificatesRetrieved = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r22;
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r0.add(r14);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        if (r16 == 0) goto L_0x00db;
    L_0x012e:
        r20 = r16.isClosed();
        if (r20 != 0) goto L_0x00db;
    L_0x0134:
        r16.close();	 Catch:{ IOException -> 0x0138 }
        goto L_0x00db;
    L_0x0138:
        r20 = move-exception;
        goto L_0x00db;
    L_0x013a:
        r8 = move-exception;
        r0 = r22;
        r0 = r0.mSnetLogger;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r0.writeException(r8);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        goto L_0x0095;
    L_0x0148:
        r8 = move-exception;
        r0 = r22;
        r0 = r0.mSnetLogger;	 Catch:{ all -> 0x01a7 }
        r20 = r0;
        r0 = r20;
        r0.writeException(r8);	 Catch:{ all -> 0x01a7 }
        if (r16 == 0) goto L_0x00db;
    L_0x0156:
        r20 = r16.isClosed();
        if (r20 != 0) goto L_0x00db;
    L_0x015c:
        r16.close();	 Catch:{ IOException -> 0x0161 }
        goto L_0x00db;
    L_0x0161:
        r20 = move-exception;
        goto L_0x00db;
    L_0x0164:
        r8 = move-exception;
        r0 = r22;
        r0 = r0.mSnetLogger;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r0.writeException(r8);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        goto L_0x0095;
    L_0x0172:
        r8 = move-exception;
        r0 = r22;
        r0 = r0.mSnetLogger;	 Catch:{ all -> 0x01a7 }
        r20 = r0;
        r0 = r20;
        r0.writeException(r8);	 Catch:{ all -> 0x01a7 }
        if (r16 == 0) goto L_0x00db;
    L_0x0180:
        r20 = r16.isClosed();
        if (r20 != 0) goto L_0x00db;
    L_0x0186:
        r16.close();	 Catch:{ IOException -> 0x018b }
        goto L_0x00db;
    L_0x018b:
        r20 = move-exception;
        goto L_0x00db;
    L_0x018e:
        r20 = 0;
        r0 = r20;
        r14.x509TrustManagerExists = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r22;
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r0.add(r14);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = new java.lang.IllegalStateException;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r21 = "No X509TrustManager found";
        r20.<init>(r21);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        throw r20;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
    L_0x01a7:
        r20 = move-exception;
        if (r16 == 0) goto L_0x01b3;
    L_0x01aa:
        r21 = r16.isClosed();
        if (r21 != 0) goto L_0x01b3;
    L_0x01b0:
        r16.close();	 Catch:{ IOException -> 0x02d7 }
    L_0x01b3:
        throw r20;
    L_0x01b4:
        r20 = android.os.Build.VERSION.SDK_INT;	 Catch:{ CertificateException -> 0x0287 }
        r21 = 21;
        r0 = r20;
        r1 = r21;
        if (r0 < r1) goto L_0x026b;
    L_0x01be:
        r20 = "RSA";
        r0 = r19;
        r1 = r20;
        r2 = r23;
        r7 = checkServerTrustedPostL(r0, r6, r1, r2);	 Catch:{ CertificateException -> 0x0287 }
    L_0x01ca:
        r20 = 1;
        r0 = r20;
        r14.chainIsValid = r0;	 Catch:{ CertificateException -> 0x0287 }
        r20 = 1;
        r0 = r20;
        r14.x509TrustManagerAcceptedConnection = r0;	 Catch:{ CertificateException -> 0x0287 }
        r9 = javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier();	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r23;
        r20 = r9.verify(r0, r15);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        if (r20 == 0) goto L_0x02b1;
    L_0x01e2:
        r20 = 1;
        r0 = r20;
        r14.hostnameVerificationSucceeded = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = 0;
        r0 = r20;
        r0 = new java.security.cert.Certificate[r0];	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r20 = r7.toArray(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = (java.security.cert.Certificate[]) r20;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r22;
        r1 = r20;
        r5 = r0.certPinInfo(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r5.chainIsTrusted;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r14.chainIsTrusted = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r5.pinTestError;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r14.pinTestError = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r5.userAdded;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r14.certUserAdded = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r5.inCaStore;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r14.certInCaStore = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = 0;
        r0 = r20;
        r0 = new java.security.cert.Certificate[r0];	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r20 = r7.toArray(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = (java.security.cert.Certificate[]) r20;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r22;
        r1 = r20;
        r20 = r0.ekuContainsAcceptedOid(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r20;
        r14.extendedKeyUsageVerified = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r14.chainIsValid;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        if (r20 == 0) goto L_0x024e;
    L_0x0242:
        r0 = r14.chainIsTrusted;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        if (r20 == 0) goto L_0x024e;
    L_0x0248:
        r0 = r14.extendedKeyUsageVerified;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        if (r20 != 0) goto L_0x0250;
    L_0x024e:
        r14.peerCertificates = r12;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
    L_0x0250:
        r0 = r22;
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r0.add(r14);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        if (r16 == 0) goto L_0x00db;
    L_0x025d:
        r20 = r16.isClosed();
        if (r20 != 0) goto L_0x00db;
    L_0x0263:
        r16.close();	 Catch:{ IOException -> 0x0268 }
        goto L_0x00db;
    L_0x0268:
        r20 = move-exception;
        goto L_0x00db;
    L_0x026b:
        r20 = "RSA";
        r0 = r19;
        r1 = r20;
        r0.checkServerTrusted(r6, r1);	 Catch:{ CertificateException -> 0x0287 }
        r3 = new com.google.android.snet.PreLCertificateChainBuilder;	 Catch:{ CertificateException -> 0x0287 }
        r0 = r22;
        r0 = r0.mContext;	 Catch:{ CertificateException -> 0x0287 }
        r20 = r0;
        r0 = r20;
        r3.<init>(r0);	 Catch:{ CertificateException -> 0x0287 }
        r7 = r3.buildCertChain(r6);	 Catch:{ CertificateException -> 0x0287 }
        goto L_0x01ca;
    L_0x0287:
        r8 = move-exception;
        r20 = 0;
        r0 = r20;
        r14.chainIsValid = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = 0;
        r0 = r20;
        r14.x509TrustManagerAcceptedConnection = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r14.peerCertificates = r12;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r22;
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r0.add(r14);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        if (r16 == 0) goto L_0x00db;
    L_0x02a3:
        r20 = r16.isClosed();
        if (r20 != 0) goto L_0x00db;
    L_0x02a9:
        r16.close();	 Catch:{ IOException -> 0x02ae }
        goto L_0x00db;
    L_0x02ae:
        r20 = move-exception;
        goto L_0x00db;
    L_0x02b1:
        r20 = 0;
        r0 = r20;
        r14.hostnameVerificationSucceeded = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r14.peerCertificates = r12;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r0 = r22;
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        r20 = r0;
        r0 = r20;
        r0.add(r14);	 Catch:{ NoSuchAlgorithmException -> 0x0148, KeyManagementException -> 0x0172 }
        if (r16 == 0) goto L_0x00db;
    L_0x02c6:
        r20 = r16.isClosed();
        if (r20 != 0) goto L_0x00db;
    L_0x02cc:
        r16.close();	 Catch:{ IOException -> 0x02d1 }
        goto L_0x00db;
    L_0x02d1:
        r20 = move-exception;
        goto L_0x00db;
    L_0x02d4:
        r20 = move-exception;
        goto L_0x00db;
    L_0x02d7:
        r21 = move-exception;
        goto L_0x01b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.snet.SslHandshakeAnalyzer.sslSocketHandshake(java.lang.String):void");
    }

    @TargetApi(21)
    private static List<X509Certificate> checkServerTrustedPostL(X509TrustManager x509TrustManager, X509Certificate[] chain, String authType, String host) throws CertificateException {
        if (x509TrustManager != null && chain != null && chain.length != 0 && authType != null && authType.length() != 0) {
            return new X509TrustManagerExtensions(x509TrustManager).checkServerTrusted(chain, authType, host);
        }
        throw new IllegalArgumentException("null or zero-length parameter");
    }

    boolean validChain(Certificate[] peerCertificates) {
        int certIndex = peerCertificates.length - 1;
        while (certIndex >= 0) {
            X509Certificate x509Cert = peerCertificates[certIndex];
            try {
                x509Cert.checkValidity();
                try {
                    ChainStrengthAnalyzer.checkCert(x509Cert);
                    if (certIndex != peerCertificates.length - 1) {
                        X509Certificate parent = peerCertificates[certIndex + 1];
                        int pathLenConstraint = parent.getBasicConstraints();
                        int numCaCertsLeftInChain = certIndex;
                        if (pathLenConstraint == -1 || pathLenConstraint < numCaCertsLeftInChain) {
                            return false;
                        }
                        if (!certSignedByParent(x509Cert, parent)) {
                            return false;
                        }
                    }
                    certIndex--;
                } catch (CertificateException e) {
                    return false;
                }
            } catch (CertificateExpiredException e2) {
                return false;
            } catch (CertificateNotYetValidException e3) {
                return false;
            }
        }
        return true;
    }

    CertPinInfo certPinInfo(Certificate[] peerCertificates) {
        byte[] pinnedIntermediate = this.mAnalyzerValues.getPinnedIntermediate();
        CertPinInfo certPinInfo = new CertPinInfo();
        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-512");
            for (int i = peerCertificates.length - 1; i >= 0; i--) {
                if (!certPinInfo.inCaStore) {
                    certPinInfo.inCaStore = issuerInCaStore(peerCertificates[i]);
                }
                if (!(certPinInfo.inCaStore || certPinInfo.userAdded)) {
                    certPinInfo.userAdded = issuerUserAdded(peerCertificates[i]);
                }
                if (Arrays.equals(digester.digest(peerCertificates[i].getPublicKey().getEncoded()), pinnedIntermediate)) {
                    certPinInfo.chainIsTrusted = true;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            certPinInfo.pinTestError = true;
        }
        return certPinInfo;
    }

    boolean ekuContainsAcceptedOid(Certificate[] peerCertificates) {
        X509Certificate leaf = peerCertificates[0];
        try {
            Set<String> acceptedEkuOidsSet = this.mAnalyzerValues.getAcceptedEkuOidsSet();
            List<String> ekuOids = leaf.getExtendedKeyUsage();
            if (ekuOids == null) {
                return true;
            }
            for (String ekuOid : ekuOids) {
                if (acceptedEkuOidsSet.contains(ekuOid)) {
                    return true;
                }
            }
            return false;
        } catch (CertificateParsingException e) {
            return false;
        }
    }

    private static X509TrustManager findX509TrustManager() throws KeyStoreException, NoSuchAlgorithmException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    static boolean issuerInCaStore(Certificate cert) {
        if (VERSION.SDK_INT < 14) {
            return issuerInCaStorePreIcs(cert);
        }
        return issuerAnchoredInDirectory((X509Certificate) cert, new File(SYSTEM_CA_STORE_PATH));
    }

    static boolean issuerUserAdded(Certificate cert) {
        if (VERSION.SDK_INT >= 21 && (cert instanceof X509Certificate)) {
            return issuerUserAddedPostL((X509Certificate) cert);
        }
        File userAddedDir = new File(USER_ADDED_CA_STORE_PATH_OLD);
        if (userAddedDir.exists() && userAddedDir.isDirectory() && (cert instanceof X509Certificate)) {
            return issuerAnchoredInDirectory((X509Certificate) cert, userAddedDir);
        }
        return false;
    }

    @TargetApi(21)
    private static boolean issuerUserAddedPostL(X509Certificate x509Certificate) {
        X509TrustManager x509TrustManager = null;
        try {
            x509TrustManager = findX509TrustManager();
        } catch (Exception e) {
        }
        if (x509Certificate == null || x509TrustManager == null) {
            return false;
        }
        return new X509TrustManagerExtensions(x509TrustManager).isUserAddedCertificate(x509Certificate);
    }

    private static boolean issuerInCaStorePreIcs(Certificate cert) {
        Throwable th;
        for (X509Certificate cachedRoot : sPreIcsCaStoreCache) {
            if (certSignedByParent(cert, cachedRoot)) {
                return true;
            }
        }
        InputStream inputStream = null;
        try {
            KeyStore bksKeyStore = KeyStore.getInstance("BKS");
            InputStream inputStream2 = new FileInputStream(new File(SYSTEM_CA_STORE_PRE_ICS_PATH));
            try {
                bksKeyStore.load(inputStream2, null);
                Enumeration<String> aliases = bksKeyStore.aliases();
                while (aliases.hasMoreElements()) {
                    X509Certificate storedCert = (X509Certificate) bksKeyStore.getCertificate((String) aliases.nextElement());
                    if (certSignedByParent(cert, storedCert)) {
                        sPreIcsCaStoreCache.add(storedCert);
                        if (inputStream2 == null) {
                            return true;
                        }
                        try {
                            inputStream2.close();
                            return true;
                        } catch (IOException e) {
                            return true;
                        }
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e2) {
                    }
                }
                return false;
            } catch (KeyStoreException e3) {
                inputStream = inputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                return false;
            } catch (IOException e5) {
                inputStream = inputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                    }
                }
                return false;
            } catch (NoSuchAlgorithmException e7) {
                inputStream = inputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e8) {
                    }
                }
                return false;
            } catch (CertificateException e9) {
                inputStream = inputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e10) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e11) {
                    }
                }
                throw th;
            }
        } catch (KeyStoreException e12) {
            if (inputStream != null) {
                inputStream.close();
            }
            return false;
        } catch (IOException e13) {
            if (inputStream != null) {
                inputStream.close();
            }
            return false;
        } catch (NoSuchAlgorithmException e14) {
            if (inputStream != null) {
                inputStream.close();
            }
            return false;
        } catch (CertificateException e15) {
            if (inputStream != null) {
                inputStream.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    private static boolean issuerAnchoredInDirectory(X509Certificate cert, File directory) {
        Throwable th;
        String fileNamePrefix = String.format("%08x", new Object[]{Integer.valueOf(x509NameHashMd5((X500Principal) cert.getIssuerDN()))});
        int index = 0;
        while (true) {
            File certFile = new File(directory, new StringBuilder(String.valueOf(fileNamePrefix).length() + 12).append(fileNamePrefix).append(".").append(index).toString());
            if (!certFile.isFile()) {
                return false;
            }
            if (certFile.length() != 0) {
                InputStream inputStream = null;
                try {
                    CertificateFactory certFactory = CertificateFactory.getInstance(CERT_FACTORY_TYPE);
                    InputStream inputStream2 = new BufferedInputStream(new FileInputStream(certFile));
                    try {
                        X509Certificate storedCert = (X509Certificate) certFactory.generateCertificate(inputStream2);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e) {
                            }
                        }
                        if (certSignedByParent(cert, storedCert)) {
                            return true;
                        }
                    } catch (IOException e2) {
                        inputStream = inputStream2;
                    } catch (CertificateException e3) {
                        inputStream = inputStream2;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                    }
                } catch (IOException e4) {
                } catch (CertificateException e5) {
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            index++;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e6) {
            }
        }
        throw th;
        throw th;
        if (inputStream == null) {
            return false;
        }
        try {
            inputStream.close();
            return false;
        } catch (IOException e7) {
            return false;
        }
        if (inputStream == null) {
            return false;
        }
        try {
            inputStream.close();
            return false;
        } catch (IOException e8) {
            return false;
        }
    }

    private static boolean certSignedByParent(Certificate cert, Certificate parent) {
        Set<TrustAnchor> anchors = Collections.singleton(new TrustAnchor((X509Certificate) parent, null));
        try {
            CertPath certPath = CertificateFactory.getInstance(CERT_FACTORY_TYPE).generateCertPath(Arrays.asList(new Certificate[]{cert}));
            PKIXParameters params = new PKIXParameters(anchors);
            params.setRevocationEnabled(false);
            CertPathValidator.getInstance(CertPathValidator.getDefaultType()).validate(certPath, params);
            return true;
        } catch (NoSuchAlgorithmException e) {
            return false;
        } catch (CertificateException e2) {
            return false;
        } catch (InvalidAlgorithmParameterException e3) {
            return false;
        } catch (CertPathValidatorException e4) {
            return false;
        }
    }

    static int x509NameHashMd5(X500Principal principal) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(principal.getEncoded());
            int offset = 0 + 1;
            int offset2 = offset + 1;
            return ((((digest[0] & 255) << 0) | ((digest[offset] & 255) << 8)) | ((digest[offset2] & 255) << 16)) | ((digest[offset2 + 1] & 255) << 24);
        } catch (NoSuchAlgorithmException e) {
            return 0;
        }
    }
}

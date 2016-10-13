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
import javax.net.ssl.KeyManagerFactory;
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

    public static class CertPinInfo {
        public boolean chainIsTrusted;
        public boolean inCaStore;
        public boolean pinTestError;
        public boolean userAdded;
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
    private void httpsConnectionHandshake(java.lang.String r24) {
        /*
        r23 = this;
        r9 = 0;
        r13 = 0;
        r16 = new com.google.android.snet.SslHandshakeAnalyzer$SslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r16.<init>();	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r24;
        r1 = r16;
        r1.host = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = 2;
        r0 = r21;
        r1 = r16;
        r1.sslConnectionMethod = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = "TLS";
        r15 = javax.net.ssl.SSLContext.getInstance(r21);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r17 = new com.google.android.snet.SslHandshakeAnalyzer$TrustAllX509TrustManager;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = 0;
        r0 = r17;
        r1 = r21;
        r0.<init>();	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = 1;
        r0 = r21;
        r0 = new javax.net.ssl.TrustManager[r0];	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r18 = r0;
        r21 = 0;
        r18[r21] = r17;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = 0;
        r21 = (javax.net.ssl.KeyManager[]) r21;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r22 = 0;
        r22 = (java.security.SecureRandom) r22;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r21;
        r1 = r18;
        r2 = r22;
        r15.init(r0, r1, r2);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r19 = new java.net.URL;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = "https";
        r22 = "";
        r0 = r19;
        r1 = r21;
        r2 = r24;
        r3 = r22;
        r0.<init>(r1, r2, r3);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r19.openConnection();	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r21;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r9 = r0;
        if (r9 != 0) goto L_0x007f;
    L_0x005f:
        r21 = 0;
        r0 = r21;
        r1 = r16;
        r1.sslConnectionSucceeded = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r23;
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        r0 = r21;
        r1 = r16;
        r0.add(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        if (r13 == 0) goto L_0x0079;
    L_0x0076:
        r13.close();	 Catch:{ IOException -> 0x030f }
    L_0x0079:
        if (r9 == 0) goto L_0x007e;
    L_0x007b:
        r9.disconnect();
    L_0x007e:
        return;
    L_0x007f:
        r21 = 1;
        r0 = r21;
        r1 = r16;
        r1.sslConnectionSucceeded = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r15.getSocketFactory();	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r21;
        r9.setSSLSocketFactory(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r9.connect();	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = 1;
        r0 = r21;
        r1 = r16;
        r1.sslSocketCreated = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = 1;
        r0 = r21;
        r1 = r16;
        r1.sslSessionValid = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r13 = r9.getInputStream();	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r9.getResponseCode();	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r15.getProtocol();	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r21;
        r1 = r16;
        r1.protocol = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r9.getCipherSuite();	 Catch:{ IllegalStateException -> 0x0331, NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3 }
        r0 = r21;
        r1 = r16;
        r1.cipherSuite = r0;	 Catch:{ IllegalStateException -> 0x0331, NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3 }
    L_0x00be:
        r14 = 0;
        r14 = r9.getServerCertificates();	 Catch:{ SSLPeerUnverifiedException -> 0x0124, IllegalStateException -> 0x0312, NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3 }
        if (r14 == 0) goto L_0x0103;
    L_0x00c5:
        r0 = r14.length;	 Catch:{ SSLPeerUnverifiedException -> 0x0124, IllegalStateException -> 0x0312, NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3 }
        r21 = r0;
        if (r21 == 0) goto L_0x0103;
    L_0x00ca:
        r21 = 1;
        r0 = r21;
        r1 = r16;
        r1.sslPeerCertificatesRetrieved = r0;	 Catch:{ SSLPeerUnverifiedException -> 0x0124, IllegalStateException -> 0x0312, NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3 }
        r20 = 0;
        r20 = findX509TrustManager();	 Catch:{ KeyStoreException -> 0x0148, NoSuchAlgorithmException -> 0x016d, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
    L_0x00d8:
        if (r20 == 0) goto L_0x0193;
    L_0x00da:
        r21 = 1;
        r0 = r21;
        r1 = r16;
        r1.x509TrustManagerExists = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r8 = 0;
        r0 = r14.length;	 Catch:{ CertificateException -> 0x02a5 }
        r21 = r0;
        r0 = r21;
        r7 = new java.security.cert.X509Certificate[r0];	 Catch:{ CertificateException -> 0x02a5 }
        r11 = 0;
        r0 = r14.length;	 Catch:{ CertificateException -> 0x02a5 }
        r22 = r0;
        r21 = 0;
        r12 = r11;
    L_0x00f1:
        r0 = r21;
        r1 = r22;
        if (r0 >= r1) goto L_0x01c8;
    L_0x00f7:
        r5 = r14[r21];	 Catch:{ CertificateException -> 0x02a5 }
        r11 = r12 + 1;
        r5 = (java.security.cert.X509Certificate) r5;	 Catch:{ CertificateException -> 0x02a5 }
        r7[r12] = r5;	 Catch:{ CertificateException -> 0x02a5 }
        r21 = r21 + 1;
        r12 = r11;
        goto L_0x00f1;
    L_0x0103:
        r21 = 0;
        r0 = r21;
        r1 = r16;
        r1.sslPeerCertificatesRetrieved = r0;	 Catch:{ SSLPeerUnverifiedException -> 0x0124, IllegalStateException -> 0x0312, NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3 }
        r0 = r23;
        r0 = r0.mSslInfo;	 Catch:{ SSLPeerUnverifiedException -> 0x0124, IllegalStateException -> 0x0312, NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3 }
        r21 = r0;
        r0 = r21;
        r1 = r16;
        r0.add(r1);	 Catch:{ SSLPeerUnverifiedException -> 0x0124, IllegalStateException -> 0x0312, NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3 }
        if (r13 == 0) goto L_0x011d;
    L_0x011a:
        r13.close();	 Catch:{ IOException -> 0x0317 }
    L_0x011d:
        if (r9 == 0) goto L_0x007e;
    L_0x011f:
        r9.disconnect();
        goto L_0x007e;
    L_0x0124:
        r21 = move-exception;
        r10 = r21;
    L_0x0127:
        r21 = 0;
        r0 = r21;
        r1 = r16;
        r1.sslPeerCertificatesRetrieved = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r23;
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        r0 = r21;
        r1 = r16;
        r0.add(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        if (r13 == 0) goto L_0x0141;
    L_0x013e:
        r13.close();	 Catch:{ IOException -> 0x031a }
    L_0x0141:
        if (r9 == 0) goto L_0x007e;
    L_0x0143:
        r9.disconnect();
        goto L_0x007e;
    L_0x0148:
        r10 = move-exception;
        r0 = r23;
        r0 = r0.mSnetLogger;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        r0 = r21;
        r0.writeException(r10);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        goto L_0x00d8;
    L_0x0155:
        r10 = move-exception;
        r0 = r23;
        r0 = r0.mSnetLogger;	 Catch:{ all -> 0x0303 }
        r21 = r0;
        r0 = r21;
        r0.writeException(r10);	 Catch:{ all -> 0x0303 }
        if (r13 == 0) goto L_0x0166;
    L_0x0163:
        r13.close();	 Catch:{ IOException -> 0x0322 }
    L_0x0166:
        if (r9 == 0) goto L_0x007e;
    L_0x0168:
        r9.disconnect();
        goto L_0x007e;
    L_0x016d:
        r10 = move-exception;
        r0 = r23;
        r0 = r0.mSnetLogger;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        r0 = r21;
        r0.writeException(r10);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        goto L_0x00d8;
    L_0x017b:
        r10 = move-exception;
        r0 = r23;
        r0 = r0.mSnetLogger;	 Catch:{ all -> 0x0303 }
        r21 = r0;
        r0 = r21;
        r0.writeException(r10);	 Catch:{ all -> 0x0303 }
        if (r13 == 0) goto L_0x018c;
    L_0x0189:
        r13.close();	 Catch:{ IOException -> 0x0325 }
    L_0x018c:
        if (r9 == 0) goto L_0x007e;
    L_0x018e:
        r9.disconnect();
        goto L_0x007e;
    L_0x0193:
        r21 = 0;
        r0 = r21;
        r1 = r16;
        r1.x509TrustManagerExists = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r23;
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        r0 = r21;
        r1 = r16;
        r0.add(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = new java.lang.IllegalStateException;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r22 = "No X509TrustManager found";
        r21.<init>(r22);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        throw r21;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
    L_0x01b0:
        r10 = move-exception;
        r0 = r23;
        r0 = r0.mSnetLogger;	 Catch:{ all -> 0x0303 }
        r21 = r0;
        r0 = r21;
        r0.writeException(r10);	 Catch:{ all -> 0x0303 }
        if (r13 == 0) goto L_0x01c1;
    L_0x01be:
        r13.close();	 Catch:{ IOException -> 0x0328 }
    L_0x01c1:
        if (r9 == 0) goto L_0x007e;
    L_0x01c3:
        r9.disconnect();
        goto L_0x007e;
    L_0x01c8:
        r21 = android.os.Build.VERSION.SDK_INT;	 Catch:{ CertificateException -> 0x02a5 }
        r22 = 21;
        r0 = r21;
        r1 = r22;
        if (r0 < r1) goto L_0x0289;
    L_0x01d2:
        r21 = "RSA";
        r0 = r20;
        r1 = r21;
        r2 = r24;
        r8 = checkServerTrustedPostL(r0, r7, r1, r2);	 Catch:{ CertificateException -> 0x02a5 }
    L_0x01de:
        r21 = 1;
        r0 = r21;
        r1 = r16;
        r1.chainIsValid = r0;	 Catch:{ CertificateException -> 0x02a5 }
        r21 = 1;
        r0 = r21;
        r1 = r16;
        r1.x509TrustManagerAcceptedConnection = r0;	 Catch:{ CertificateException -> 0x02a5 }
        r21 = 1;
        r0 = r21;
        r1 = r16;
        r1.hostnameVerificationSucceeded = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = 0;
        r0 = r21;
        r0 = new java.security.cert.Certificate[r0];	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        r0 = r21;
        r21 = r8.toArray(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = (java.security.cert.Certificate[]) r21;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r23;
        r1 = r21;
        r6 = r0.certPinInfo(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r6.chainIsTrusted;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        r0 = r21;
        r1 = r16;
        r1.chainIsTrusted = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r6.pinTestError;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        r0 = r21;
        r1 = r16;
        r1.pinTestError = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r6.userAdded;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        r0 = r21;
        r1 = r16;
        r1.certUserAdded = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r6.inCaStore;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        r0 = r21;
        r1 = r16;
        r1.certInCaStore = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = 0;
        r0 = r21;
        r0 = new java.security.cert.Certificate[r0];	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        r0 = r21;
        r21 = r8.toArray(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = (java.security.cert.Certificate[]) r21;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r23;
        r1 = r21;
        r21 = r0.ekuContainsAcceptedOid(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r21;
        r1 = r16;
        r1.extendedKeyUsageVerified = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r16;
        r0 = r0.chainIsValid;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        if (r21 == 0) goto L_0x026c;
    L_0x025c:
        r0 = r16;
        r0 = r0.chainIsTrusted;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        if (r21 == 0) goto L_0x026c;
    L_0x0264:
        r0 = r16;
        r0 = r0.extendedKeyUsageVerified;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        if (r21 != 0) goto L_0x0270;
    L_0x026c:
        r0 = r16;
        r0.peerCertificates = r14;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
    L_0x0270:
        r0 = r23;
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        r0 = r21;
        r1 = r16;
        r0.add(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        if (r13 == 0) goto L_0x0282;
    L_0x027f:
        r13.close();	 Catch:{ IOException -> 0x031f }
    L_0x0282:
        if (r9 == 0) goto L_0x007e;
    L_0x0284:
        r9.disconnect();
        goto L_0x007e;
    L_0x0289:
        r21 = "RSA";
        r0 = r20;
        r1 = r21;
        r0.checkServerTrusted(r7, r1);	 Catch:{ CertificateException -> 0x02a5 }
        r4 = new com.google.android.snet.PreLCertificateChainBuilder;	 Catch:{ CertificateException -> 0x02a5 }
        r0 = r23;
        r0 = r0.mContext;	 Catch:{ CertificateException -> 0x02a5 }
        r21 = r0;
        r0 = r21;
        r4.<init>(r0);	 Catch:{ CertificateException -> 0x02a5 }
        r8 = r4.buildCertChain(r7);	 Catch:{ CertificateException -> 0x02a5 }
        goto L_0x01de;
    L_0x02a5:
        r10 = move-exception;
        r21 = 0;
        r0 = r21;
        r1 = r16;
        r1.chainIsValid = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = 0;
        r0 = r21;
        r1 = r16;
        r1.x509TrustManagerAcceptedConnection = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r16;
        r0.peerCertificates = r14;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r0 = r23;
        r0 = r0.mSslInfo;	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        r21 = r0;
        r0 = r21;
        r1 = r16;
        r0.add(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0155, KeyManagementException -> 0x017b, MalformedURLException -> 0x01b0, IOException -> 0x02d3, IllegalStateException -> 0x02eb }
        if (r13 == 0) goto L_0x02cc;
    L_0x02c9:
        r13.close();	 Catch:{ IOException -> 0x031d }
    L_0x02cc:
        if (r9 == 0) goto L_0x007e;
    L_0x02ce:
        r9.disconnect();
        goto L_0x007e;
    L_0x02d3:
        r10 = move-exception;
        r0 = r23;
        r0 = r0.mSnetLogger;	 Catch:{ all -> 0x0303 }
        r21 = r0;
        r0 = r21;
        r0.writeException(r10);	 Catch:{ all -> 0x0303 }
        if (r13 == 0) goto L_0x02e4;
    L_0x02e1:
        r13.close();	 Catch:{ IOException -> 0x032b }
    L_0x02e4:
        if (r9 == 0) goto L_0x007e;
    L_0x02e6:
        r9.disconnect();
        goto L_0x007e;
    L_0x02eb:
        r10 = move-exception;
        r0 = r23;
        r0 = r0.mSnetLogger;	 Catch:{ all -> 0x0303 }
        r21 = r0;
        r0 = r21;
        r0.writeException(r10);	 Catch:{ all -> 0x0303 }
        if (r13 == 0) goto L_0x02fc;
    L_0x02f9:
        r13.close();	 Catch:{ IOException -> 0x032d }
    L_0x02fc:
        if (r9 == 0) goto L_0x007e;
    L_0x02fe:
        r9.disconnect();
        goto L_0x007e;
    L_0x0303:
        r21 = move-exception;
        if (r13 == 0) goto L_0x0309;
    L_0x0306:
        r13.close();	 Catch:{ IOException -> 0x032f }
    L_0x0309:
        if (r9 == 0) goto L_0x030e;
    L_0x030b:
        r9.disconnect();
    L_0x030e:
        throw r21;
    L_0x030f:
        r21 = move-exception;
        goto L_0x0079;
    L_0x0312:
        r21 = move-exception;
        r10 = r21;
        goto L_0x0127;
    L_0x0317:
        r21 = move-exception;
        goto L_0x011d;
    L_0x031a:
        r21 = move-exception;
        goto L_0x0141;
    L_0x031d:
        r21 = move-exception;
        goto L_0x02cc;
    L_0x031f:
        r21 = move-exception;
        goto L_0x0282;
    L_0x0322:
        r21 = move-exception;
        goto L_0x0166;
    L_0x0325:
        r21 = move-exception;
        goto L_0x018c;
    L_0x0328:
        r21 = move-exception;
        goto L_0x01c1;
    L_0x032b:
        r21 = move-exception;
        goto L_0x02e4;
    L_0x032d:
        r21 = move-exception;
        goto L_0x02fc;
    L_0x032f:
        r22 = move-exception;
        goto L_0x0309;
    L_0x0331:
        r21 = move-exception;
        goto L_0x00be;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.snet.SslHandshakeAnalyzer.httpsConnectionHandshake(java.lang.String):void");
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

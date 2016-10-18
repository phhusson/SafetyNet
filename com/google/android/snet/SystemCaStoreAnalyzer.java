package com.google.android.snet;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.snet.nano.IdleLogs.SystemCaStoreWhitelist;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SystemCaStoreAnalyzer {
    private static final String SYSTEM_CA_STORE_PATH = "/system/etc/security/cacerts";
    private static final String SYSTEM_CA_STORE_PRE_ICS_PATH = "/system/etc/security/cacerts.bks";
    private static final String TAG = SystemCaStoreAnalyzer.class.getCanonicalName();
    private final Context mContext;
    private final GBundle mGBundle;
    private Set<Bytes> mRequestedCertsBySha256Set = requestedCertsBySha256Set();
    private Set<Bytes> mSpkiSha256WhitelistSet = spkiSha256Whitelist();

    static class CaCertInfo {
        byte[] cert;
        String issuerDn;
        byte[] sha256;
        byte[] spkiSha256;
        String subjectDn;

        CaCertInfo() {
        }
    }

    SystemCaStoreAnalyzer(Context context, GBundle gBundle) {
        this.mGBundle = gBundle;
        this.mContext = context;
    }

    List<CaCertInfo> getSystemCaCerts(int numCerts) {
        if (numCerts <= 0) {
            return null;
        }
        if (VERSION.SDK_INT < 14) {
            return getSystemCaCertsPreIcs(numCerts);
        }
        return getSystemCaCertsNew(numCerts);
    }

    private List<CaCertInfo> getSystemCaCertsPreIcs(int numCerts) {
        List<CaCertInfo> list;
        Throwable th;
        InputStream inputStream = null;
        try {
            KeyStore bksKeyStore = KeyStore.getInstance("BKS");
            InputStream inputStream2 = new FileInputStream(new File(SYSTEM_CA_STORE_PRE_ICS_PATH));
            try {
                bksKeyStore.load(inputStream2, null);
                if (bksKeyStore.size() == 0) {
                    list = null;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e) {
                        }
                    }
                    inputStream = inputStream2;
                } else {
                    List<Integer> intList = getRandomIndicesPermutation(bksKeyStore.size(), bksKeyStore.size());
                    Enumeration<String> aliases = bksKeyStore.aliases();
                    list = new ArrayList();
                    int numFullRecordsLogged = 0;
                    while (aliases.hasMoreElements()) {
                        X509Certificate cert = (X509Certificate) bksKeyStore.getCertificate((String) aliases.nextElement());
                        CaCertInfo certInfo = new CaCertInfo();
                        if (!this.mSpkiSha256WhitelistSet.isEmpty()) {
                            certInfo.spkiSha256 = compressSha256(Utils.getSha256(cert.getPublicKey().getEncoded()));
                        }
                        byte[] derEncodedCertSha256 = derEncodedCertSha256(cert);
                        if (numFullRecordsLogged < numCerts && certInfo.spkiSha256 != null && certInfo.spkiSha256.length > 4) {
                            numFullRecordsLogged++;
                            if (this.mGBundle.getLogEntireSystemCaCert()) {
                                certInfo.cert = cert.getEncoded();
                            } else {
                                certInfo.subjectDn = cert.getSubjectX500Principal().toString();
                                certInfo.issuerDn = cert.getIssuerX500Principal().toString();
                                certInfo.sha256 = derEncodedCertSha256;
                            }
                        }
                        list.add(certInfo);
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                    inputStream = inputStream2;
                }
            } catch (KeyStoreException e3) {
                inputStream = inputStream2;
            } catch (IOException e4) {
                inputStream = inputStream2;
            } catch (NoSuchAlgorithmException e5) {
                inputStream = inputStream2;
            } catch (CertificateException e6) {
                inputStream = inputStream2;
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStream2;
            }
        } catch (KeyStoreException e7) {
            list = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                }
            }
            return list;
        } catch (IOException e9) {
            list = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                }
            }
            return list;
        } catch (NoSuchAlgorithmException e11) {
            list = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e12) {
                }
            }
            return list;
        } catch (CertificateException e13) {
            list = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e14) {
                }
            }
            return list;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e15) {
                }
            }
            throw th;
        }
        return list;
    }

    private List<CaCertInfo> getSystemCaCertsNew(int numCerts) {
        InputStream inputStream;
        Throwable th;
        File systemCaStoreDir = new File(SYSTEM_CA_STORE_PATH);
        if (!systemCaStoreDir.exists() || !systemCaStoreDir.isDirectory()) {
            return null;
        }
        File[] systemCaCertsArray = systemCaStoreDir.listFiles();
        if (systemCaCertsArray.length == 0) {
            return null;
        }
        List<Integer> intList = getRandomIndicesPermutation(systemCaCertsArray.length, systemCaCertsArray.length);
        try {
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            List<CaCertInfo> certInfoList = new ArrayList();
            int numFullRecordsLogged = 0;
            for (int i = 0; i < systemCaCertsArray.length; i++) {
                inputStream = null;
                try {
                    File certFile = systemCaCertsArray[((Integer) intList.get(i)).intValue()];
                    CaCertInfo certInfo = new CaCertInfo();
                    InputStream inputStream2 = new BufferedInputStream(new FileInputStream(certFile));
                    try {
                        X509Certificate cert = (X509Certificate) certFactory.generateCertificate(inputStream2);
                        if (!this.mSpkiSha256WhitelistSet.isEmpty()) {
                            certInfo.spkiSha256 = compressSha256(Utils.getSha256(cert.getPublicKey().getEncoded()));
                        }
                        if (numFullRecordsLogged < numCerts && certInfo.spkiSha256 != null && certInfo.spkiSha256.length > 4) {
                            numFullRecordsLogged++;
                            if (this.mGBundle.getLogEntireSystemCaCert()) {
                                certInfo.cert = cert.getEncoded();
                            } else {
                                certInfo.issuerDn = cert.getIssuerX500Principal().toString();
                                certInfo.subjectDn = cert.getSubjectX500Principal().toString();
                                certInfo.sha256 = derEncodedCertSha256(cert);
                            }
                        }
                        certInfoList.add(certInfo);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                                inputStream = inputStream2;
                            } catch (IOException e) {
                                inputStream = inputStream2;
                            }
                        }
                    } catch (IOException e2) {
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (CertificateException e4) {
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                    }
                } catch (IOException e6) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (CertificateException e7) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            return certInfoList;
        } catch (CertificateException e8) {
            return null;
        }
        throw th;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e9) {
            }
        }
        throw th;
    }

    private byte[] derEncodedCertSha256(X509Certificate cert) {
        byte[] bArr = null;
        try {
            bArr = MessageDigest.getInstance("SHA-256").digest(cert.getEncoded());
        } catch (NoSuchAlgorithmException e) {
        } catch (CertificateEncodingException e2) {
        }
        return bArr;
    }

    private Set<Bytes> requestedCertsBySha256Set() {
        Set<Bytes> requestedCertsBySha256Set = new HashSet();
        String requestedCertsBySha256 = this.mGBundle.getRequestedCertsBySha256();
        if (!TextUtils.isEmpty(requestedCertsBySha256)) {
            for (String hexStringSha256 : requestedCertsBySha256.split(Csv.COMMA)) {
                requestedCertsBySha256Set.add(new Bytes(Utils.hexStringToByteArray(hexStringSha256)));
            }
        }
        return requestedCertsBySha256Set;
    }

    private Set<Bytes> spkiSha256Whitelist() {
        Set<Bytes> whitelist = new HashSet();
        byte[] whitelistRawProtoBytes = Utils.loadFromResources("/spki_whitelist");
        if (whitelistRawProtoBytes != null) {
            try {
                SystemCaStoreWhitelist whitelistProto = SystemCaStoreWhitelist.parseFrom(whitelistRawProtoBytes);
                if (whitelistProto.subjectPublicKeyInfoSha256 != null) {
                    for (byte[] spkiHash : whitelistProto.subjectPublicKeyInfoSha256) {
                        whitelist.add(new Bytes(spkiHash));
                    }
                }
            } catch (InvalidProtocolBufferNanoException e) {
            }
        }
        return whitelist;
    }

    private byte[] compressSha256(byte[] sha256) {
        if (sha256 == null) {
            return null;
        }
        if (this.mSpkiSha256WhitelistSet.contains(new Bytes(sha256))) {
            return Arrays.copyOfRange(sha256, 0, 4);
        }
        return sha256;
    }

    private void generateWhitelist(List<CaCertInfo> caCertInfoList) {
        SystemCaStoreWhitelist whitelistProto = new SystemCaStoreWhitelist();
        whitelistProto.subjectPublicKeyInfoSha256 = new byte[caCertInfoList.size()][];
        for (int i = 0; i < caCertInfoList.size(); i++) {
            whitelistProto.subjectPublicKeyInfoSha256[i] = ((CaCertInfo) caCertInfoList.get(i)).spkiSha256;
        }
        Utils.writeBytes(MessageNano.toByteArray(whitelistProto), new File(new File(this.mContext.getApplicationInfo().dataDir, "/snet"), "debug_whitelist"));
    }

    List<Integer> getRandomIndicesPermutation(int size, int subsetSize) {
        List<Integer> intList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            intList.add(Integer.valueOf(i));
        }
        Collections.shuffle(intList);
        return intList.subList(0, subsetSize);
    }
}

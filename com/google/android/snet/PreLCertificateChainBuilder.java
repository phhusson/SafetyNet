package com.google.android.snet;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

class PreLCertificateChainBuilder {
    private static final String CERT_FACTORY_TYPE = "X.509";
    private static final boolean DEBUG = false;
    private static final String SYSTEM_CA_STORE_PATH = "/system/etc/security/cacerts";
    private static final String TAG = PreLCertificateChainBuilder.class.getCanonicalName();
    private static final String USER_ADDED_CA_STORE_PATH_BEGIN = "/data/misc/user/";
    private static final String USER_ADDED_CA_STORE_PATH_END = "/cacerts-added";
    private static final String USER_ADDED_CA_STORE_PATH_OLD = "/data/misc/keychain/cacerts-added";
    private Context mContext;

    private interface CertSelector {
        boolean match(X509Certificate x509Certificate);
    }

    PreLCertificateChainBuilder(Context context) {
        this.mContext = context;
    }

    List<X509Certificate> buildCertChain(X509Certificate[] chain) throws CertificateException {
        if (chain == null || chain.length == 0) {
            throw new IllegalArgumentException("null or zero-length parameter");
        }
        Set<TrustAnchor> trustAnchor = new HashSet();
        X509Certificate[] newChain = cleanupCertChainAndFindTrustAnchors(chain, trustAnchor);
        List<X509Certificate> wholeChain = new ArrayList();
        wholeChain.addAll(Arrays.asList(newChain));
        for (TrustAnchor trust : trustAnchor) {
            wholeChain.add(trust.getTrustedCert());
        }
        return wholeChain;
    }

    private X509Certificate[] cleanupCertChainAndFindTrustAnchors(X509Certificate[] chain, Set<TrustAnchor> trustAnchors) {
        X509Certificate[] newChain;
        X509Certificate[] original = chain;
        int currIndex = 0;
        while (currIndex < chain.length) {
            boolean foundNext = DEBUG;
            int nextIndex = currIndex + 1;
            while (nextIndex < chain.length) {
                if (chain[currIndex].getIssuerDN().equals(chain[nextIndex].getSubjectDN())) {
                    foundNext = true;
                    if (nextIndex != currIndex + 1) {
                        if (chain == original) {
                            chain = (X509Certificate[]) original.clone();
                        }
                        X509Certificate tempCertificate = chain[nextIndex];
                        chain[nextIndex] = chain[currIndex + 1];
                        chain[currIndex + 1] = tempCertificate;
                    }
                    if (!foundNext) {
                        break;
                    }
                    currIndex++;
                } else {
                    nextIndex++;
                }
            }
            if (!foundNext) {
                break;
            }
            currIndex++;
        }
        int anchorIndex = 0;
        while (anchorIndex <= currIndex) {
            TrustAnchor trustAnchor = findTrustAnchorBySubjectAndPublicKey(chain[anchorIndex]);
            if (trustAnchor != null) {
                trustAnchors.add(trustAnchor);
                break;
            }
            anchorIndex++;
        }
        int chainLength = anchorIndex;
        if (chainLength == chain.length) {
            newChain = chain;
        } else {
            newChain = (X509Certificate[]) Arrays.copyOf(chain, chainLength);
        }
        if (trustAnchors.isEmpty()) {
            trustAnchor = findTrustAnchorByIssuerAndSignature(newChain[anchorIndex - 1]);
            if (trustAnchor != null) {
                trustAnchors.add(trustAnchor);
            }
        }
        return newChain;
    }

    private TrustAnchor findTrustAnchorByIssuerAndSignature(X509Certificate cert) {
        X509Certificate issuerCert = findIssuer(cert);
        if (issuerCert != null) {
            return new TrustAnchor(issuerCert, null);
        }
        return null;
    }

    private X509Certificate findIssuer(final X509Certificate c) {
        CertSelector selector = new CertSelector() {
            public boolean match(X509Certificate ca) {
                try {
                    c.verify(ca.getPublicKey());
                    return true;
                } catch (Exception e) {
                    return PreLCertificateChainBuilder.DEBUG;
                }
            }
        };
        X500Principal issuer = c.getIssuerX500Principal();
        X509Certificate userAddedCert = (X509Certificate) findCert(userAddedCaCertsDirectory(this.mContext), issuer, selector, X509Certificate.class);
        if (userAddedCert != null) {
            return userAddedCert;
        }
        X509Certificate systemCert = (X509Certificate) findCert(new File(SYSTEM_CA_STORE_PATH), issuer, selector, X509Certificate.class);
        if (systemCert != null) {
            return systemCert;
        }
        return null;
    }

    private TrustAnchor findTrustAnchorBySubjectAndPublicKey(X509Certificate cert) {
        X509Certificate trustedCert = getTrustAnchor(cert);
        if (trustedCert != null) {
            return new TrustAnchor(trustedCert, null);
        }
        return null;
    }

    private X509Certificate getTrustAnchor(final X509Certificate c) {
        CertSelector selector = new CertSelector() {
            public boolean match(X509Certificate ca) {
                return ca.getPublicKey().equals(c.getPublicKey());
            }
        };
        X509Certificate user = (X509Certificate) findCert(userAddedCaCertsDirectory(this.mContext), c.getSubjectX500Principal(), selector, X509Certificate.class);
        if (user != null) {
            return user;
        }
        X509Certificate system = (X509Certificate) findCert(new File(SYSTEM_CA_STORE_PATH), c.getSubjectX500Principal(), selector, X509Certificate.class);
        if (system != null) {
            return system;
        }
        return null;
    }

    private static <T> T findCert(File dir, X500Principal subject, CertSelector selector, Class<T> desiredReturnType) {
        InputStream inputStream;
        Throwable th;
        Object certs = null;
        String fileNamePrefix = String.format("%08x", new Object[]{Integer.valueOf(SslHandshakeAnalyzer.x509NameHashMd5(subject))});
        int index = 0;
        while (true) {
            File certFile = new File(dir, new StringBuilder(String.valueOf(fileNamePrefix).length() + 12).append(fileNamePrefix).append(".").append(index).toString());
            if (!certFile.isFile()) {
                break;
            }
            if (certFile.length() != 0) {
                inputStream = null;
                try {
                    CertificateFactory certFactory = CertificateFactory.getInstance(CERT_FACTORY_TYPE);
                    InputStream inputStream2 = new BufferedInputStream(new FileInputStream(certFile));
                    try {
                        X509Certificate cert = (X509Certificate) certFactory.generateCertificate(inputStream2);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e) {
                            }
                        }
                        if (!selector.match(cert)) {
                            continue;
                        } else if (desiredReturnType == X509Certificate.class && desiredReturnType.isInstance(cert)) {
                            return desiredReturnType.cast(cert);
                        } else {
                            if (desiredReturnType == Set.class) {
                                if (certs == null) {
                                    certs = new HashSet();
                                }
                                certs.add(cert);
                            } else {
                                throw new AssertionError();
                            }
                        }
                    } catch (IOException e2) {
                        inputStream = inputStream2;
                        if (inputStream == null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        index++;
                    } catch (CertificateException e4) {
                        inputStream = inputStream2;
                        if (inputStream == null) {
                            inputStream.close();
                        }
                        index++;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                    }
                } catch (IOException e5) {
                    if (inputStream == null) {
                        inputStream.close();
                    }
                    index++;
                } catch (CertificateException e6) {
                    if (inputStream == null) {
                        inputStream.close();
                    }
                    index++;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            index++;
        }
        if (desiredReturnType == Set.class && desiredReturnType.isInstance(certs)) {
            return desiredReturnType.cast(certs);
        }
        return null;
        throw th;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e7) {
            }
        }
        throw th;
    }

    private static File userAddedCaCertsDirectory(Context context) {
        String userAddedCaStoreDirName;
        if (VERSION.SDK_INT <= 19) {
            userAddedCaStoreDirName = USER_ADDED_CA_STORE_PATH_OLD;
        } else {
            UserHandle userHandle = Process.myUserHandle();
            UserManager userManager = (UserManager) context.getSystemService("user");
            if (userManager == null) {
                return null;
            }
            long userSerialNumber = userManager.getSerialNumberForUser(userHandle);
            String valueOf = String.valueOf(USER_ADDED_CA_STORE_PATH_BEGIN);
            String valueOf2 = String.valueOf(USER_ADDED_CA_STORE_PATH_END);
            userAddedCaStoreDirName = new StringBuilder((String.valueOf(valueOf).length() + 20) + String.valueOf(valueOf2).length()).append(valueOf).append(userSerialNumber).append(valueOf2).toString();
        }
        File userAddedDir = new File(userAddedCaStoreDirName);
        if (userAddedDir.exists() && userAddedDir.isDirectory()) {
            return userAddedDir;
        }
        return null;
    }
}

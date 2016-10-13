package com.google.android.snet;

import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

public final class ChainStrengthAnalyzer {
    private static final int MIN_DSA_P_LEN_BITS = 1024;
    private static final int MIN_DSA_Q_LEN_BITS = 160;
    private static final int MIN_EC_FIELD_SIZE_BITS = 160;
    private static final int MIN_RSA_MODULUS_LEN_BITS = 1024;
    private static final String[] SIGNATURE_ALGORITHM_OID_BLACKLIST = new String[]{"1.2.840.113549.1.1.2", "1.2.840.113549.1.1.3", "1.2.840.113549.1.1.4"};

    public static final void check(X509Certificate[] chain) throws CertificateException {
        int length = chain.length;
        int i = 0;
        while (i < length) {
            X509Certificate cert = chain[i];
            try {
                checkCert(cert);
                i++;
            } catch (CertificateException e) {
                String valueOf = String.valueOf(cert.getSubjectX500Principal());
                throw new CertificateException(new StringBuilder(String.valueOf(valueOf).length() + 26).append("Unacceptable certificate: ").append(valueOf).toString(), e);
            }
        }
    }

    public static final void check(List<X509Certificate> chain) throws CertificateException {
        for (X509Certificate cert : chain) {
            try {
                checkCert(cert);
            } catch (CertificateException e) {
                String valueOf = String.valueOf(cert.getSubjectX500Principal());
                throw new CertificateException(new StringBuilder(String.valueOf(valueOf).length() + 26).append("Unacceptable certificate: ").append(valueOf).toString(), e);
            }
        }
    }

    public static final void checkCert(X509Certificate cert) throws CertificateException {
        checkKeyLength(cert);
        checkSignatureAlgorithm(cert);
    }

    private static final void checkKeyLength(X509Certificate cert) throws CertificateException {
        PublicKey pubkey = cert.getPublicKey();
        if (pubkey instanceof RSAPublicKey) {
            if (((RSAPublicKey) pubkey).getModulus().bitLength() < 1024) {
                throw new CertificateException("RSA modulus is < 1024 bits");
            }
        } else if (pubkey instanceof ECPublicKey) {
            if (((ECPublicKey) pubkey).getParams().getCurve().getField().getFieldSize() < 160) {
                throw new CertificateException("EC key field size is < 160 bits");
            }
        } else if (pubkey instanceof DSAPublicKey) {
            int pLength = ((DSAPublicKey) pubkey).getParams().getP().bitLength();
            int qLength = ((DSAPublicKey) pubkey).getParams().getQ().bitLength();
            if (pLength < 1024 || qLength < 160) {
                throw new CertificateException("DSA key length is < (1024, 160) bits");
            }
        } else {
            String str = "Rejecting unknown key class ";
            String valueOf = String.valueOf(pubkey.getClass().getName());
            throw new CertificateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    private static final void checkSignatureAlgorithm(X509Certificate cert) throws CertificateException {
        String oid = cert.getSigAlgOID();
        for (String blacklisted : SIGNATURE_ALGORITHM_OID_BLACKLIST) {
            if (oid.equals(blacklisted)) {
                String str = "Signature uses an insecure hash function: ";
                String valueOf = String.valueOf(oid);
                throw new CertificateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
    }
}

package com.google.android.gms.common.util;

import android.util.Base64;

public final class zzc {
    public static byte[] decode(String encodedData) {
        return encodedData == null ? null : Base64.decode(encodedData, 0);
    }

    public static String encode(byte[] data) {
        return data == null ? null : Base64.encodeToString(data, 0);
    }

    public static byte[] zzcP(String str) {
        return str == null ? null : Base64.decode(str, 10);
    }

    public static String zzk(byte[] bArr) {
        return bArr == null ? null : Base64.encodeToString(bArr, 10);
    }
}

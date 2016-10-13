package com.google.android.gms.common.util;

public class zzq {
    public static long zzcS(String str) {
        if (str.length() <= 16) {
            return str.length() == 16 ? Long.parseLong(str.substring(8), 16) | (Long.parseLong(str.substring(0, 8), 16) << 32) : Long.parseLong(str, 16);
        } else {
            throw new NumberFormatException("Invalid input: " + str + " exceeds " + 16 + " characters");
        }
    }
}

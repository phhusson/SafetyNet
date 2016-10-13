package com.google.android.gms.people.internal;

import android.util.Log;

public final class zzo {
    private static volatile boolean zzbEL;

    public static void zzG(String str, String str2) {
        if (zzdl(3)) {
            Log.d(str, str2);
        }
    }

    public static void zzI(String str, String str2) {
        if (zzdl(5)) {
            Log.w(str, str2);
        }
    }

    public static void zzJ(String str, String str2) {
        if (zzdl(6)) {
            Log.e(str, str2);
        }
    }

    public static boolean zzJx() {
        return zzdl(3);
    }

    public static boolean zzJy() {
        return zzdl(2);
    }

    public static void zzaj(String str, String str2) {
        if (zzdl(2)) {
            Log.v(str, str2);
        }
    }

    public static void zzb(String str, String str2, Throwable th) {
        if (zzdl(5)) {
            Log.w(str, str2, th);
        }
    }

    public static void zzc(String str, String str2, Throwable th) {
        if (zzdl(6)) {
            Log.e(str, str2, th);
        }
    }

    public static boolean zzdl(int i) {
        return zzbEL || Log.isLoggable("PeopleService", i);
    }
}

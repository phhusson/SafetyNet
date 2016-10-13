package com.google.android.gms.internal;

import java.io.IOException;

public final class zzaiq {
    public static final int[] zzcqA = new int[0];
    public static final long[] zzcqB = new long[0];
    public static final float[] zzcqC = new float[0];
    public static final double[] zzcqD = new double[0];
    public static final boolean[] zzcqE = new boolean[0];
    public static final String[] zzcqF = new String[0];
    public static final byte[][] zzcqG = new byte[0][];
    public static final byte[] zzcqH = new byte[0];

    static int zzW(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean zzb(zzaie com_google_android_gms_internal_zzaie, int i) throws IOException {
        return com_google_android_gms_internal_zzaie.zzsW(i);
    }

    public static final int zzc(zzaie com_google_android_gms_internal_zzaie, int i) throws IOException {
        int i2 = 1;
        int position = com_google_android_gms_internal_zzaie.getPosition();
        com_google_android_gms_internal_zzaie.zzsW(i);
        while (com_google_android_gms_internal_zzaie.zzRp() == i) {
            com_google_android_gms_internal_zzaie.zzsW(i);
            i2++;
        }
        com_google_android_gms_internal_zzaie.zzta(position);
        return i2;
    }

    static int zztr(int i) {
        return i & 7;
    }

    public static int zzts(int i) {
        return i >>> 3;
    }
}

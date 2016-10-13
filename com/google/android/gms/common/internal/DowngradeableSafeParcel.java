package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel implements SafeParcelable {
    private static final Object zzavT = new Object();
    private static ClassLoader zzavU = null;
    private static Integer zzavV = null;
    private boolean zzavW = false;

    private static boolean zza(Class<?> cls) {
        boolean z = false;
        try {
            z = SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e2) {
        }
        return z;
    }

    protected static boolean zzcE(String str) {
        ClassLoader zzqU = zzqU();
        if (zzqU == null) {
            return true;
        }
        try {
            return zza(zzqU.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected static ClassLoader zzqU() {
        ClassLoader classLoader;
        synchronized (zzavT) {
            classLoader = zzavU;
        }
        return classLoader;
    }

    protected static Integer zzqV() {
        Integer num;
        synchronized (zzavT) {
            num = zzavV;
        }
        return num;
    }

    protected boolean zzqW() {
        return this.zzavW;
    }
}

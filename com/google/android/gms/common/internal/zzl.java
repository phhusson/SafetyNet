package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzl {
    private static final Object zzawI = new Object();
    private static zzl zzawJ;

    public static zzl zzav(Context context) {
        synchronized (zzawI) {
            if (zzawJ == null) {
                zzawJ = new zzm(context.getApplicationContext());
            }
        }
        return zzawJ;
    }

    public abstract boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean zza(String str, ServiceConnection serviceConnection, String str2);

    public abstract void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void zzb(String str, ServiceConnection serviceConnection, String str2);
}

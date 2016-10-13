package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class zzi {
    private static IntentFilter zzazh = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzazi;
    private static float zzazj = Float.NaN;

    @TargetApi(20)
    public static int zzay(Context context) {
        int i = 1;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzazh);
        int i2 = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        int i3 = (zzr.zzsq() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 1 : 0) << 1;
        if (i2 == 0) {
            i = 0;
        }
        return i3 | i;
    }

    public static synchronized float zzaz(Context context) {
        float f;
        synchronized (zzi.class) {
            if (SystemClock.elapsedRealtime() - zzazi >= 60000 || zzazj == Float.NaN) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzazh);
                if (registerReceiver != null) {
                    zzazj = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzazi = SystemClock.elapsedRealtime();
                f = zzazj;
            } else {
                f = zzazj;
            }
        }
        return f;
    }
}

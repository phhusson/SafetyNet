package com.google.android.gms.common.util;

import android.os.SystemClock;

public final class zzg implements Clock {
    private static zzg zzazg;

    public static synchronized Clock zzsh() {
        Clock clock;
        synchronized (zzg.class) {
            if (zzazg == null) {
                zzazg = new zzg();
            }
            clock = zzazg;
        }
        return clock;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}

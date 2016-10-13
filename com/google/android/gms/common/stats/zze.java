package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public class zze {
    private final long zzayT;
    private final int zzayU;
    private final SimpleArrayMap<String, Long> zzayV;

    public zze() {
        this.zzayT = 60000;
        this.zzayU = 10;
        this.zzayV = new SimpleArrayMap(10);
    }

    public zze(int i, long j) {
        this.zzayT = j;
        this.zzayU = i;
        this.zzayV = new SimpleArrayMap();
    }

    private void zze(long j, long j2) {
        for (int size = this.zzayV.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.zzayV.valueAt(size)).longValue() > j) {
                this.zzayV.removeAt(size);
            }
        }
    }

    public Long zzcN(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.zzayT;
        synchronized (this) {
            while (this.zzayV.size() >= this.zzayU) {
                zze(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.zzayU + " is not enough. Current durationThreshold is: " + j);
            }
            l = (Long) this.zzayV.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public boolean zzcO(String str) {
        boolean z;
        synchronized (this) {
            z = this.zzayV.remove(str) != null;
        }
        return z;
    }
}

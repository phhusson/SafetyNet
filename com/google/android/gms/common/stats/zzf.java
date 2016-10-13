package com.google.android.gms.common.stats;

public abstract class zzf {
    public abstract long getDurationMillis();

    public abstract int getEventType();

    public abstract long getTimeMillis();

    public String toString() {
        return getTimeMillis() + "\t" + getEventType() + "\t" + getDurationMillis() + zzrT();
    }

    public abstract String zzrT();
}

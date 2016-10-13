package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent extends zzf implements SafeParcelable {
    public static final Creator<ConnectionEvent> CREATOR = new zza();
    final int mVersionCode;
    private final long zzayk;
    private int zzayl;
    private final String zzaym;
    private final String zzayn;
    private final String zzayo;
    private final String zzayp;
    private final String zzayq;
    private final String zzayr;
    private final long zzays;
    private final long zzayt;
    private long zzayu;

    ConnectionEvent(int versionCode, long timeMillis, int eventType, String callingProcess, String callingService, String targetProcess, String targetService, String stackTrace, String connKey, long elapsedRealtime, long heapAlloc) {
        this.mVersionCode = versionCode;
        this.zzayk = timeMillis;
        this.zzayl = eventType;
        this.zzaym = callingProcess;
        this.zzayn = callingService;
        this.zzayo = targetProcess;
        this.zzayp = targetService;
        this.zzayu = -1;
        this.zzayq = stackTrace;
        this.zzayr = connKey;
        this.zzays = elapsedRealtime;
        this.zzayt = heapAlloc;
    }

    public ConnectionEvent(long timeMillis, int eventType, String callingProcess, String callingService, String targetProcess, String targetService, String stackTrace, String connKey, long elapsedRealtime, long heapAlloc) {
        this(1, timeMillis, eventType, callingProcess, callingService, targetProcess, targetService, stackTrace, connKey, elapsedRealtime, heapAlloc);
    }

    public int describeContents() {
        return 0;
    }

    public long getDurationMillis() {
        return this.zzayu;
    }

    public int getEventType() {
        return this.zzayl;
    }

    public long getTimeMillis() {
        return this.zzayk;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public String zzrL() {
        return this.zzaym;
    }

    public String zzrM() {
        return this.zzayn;
    }

    public String zzrN() {
        return this.zzayo;
    }

    public String zzrO() {
        return this.zzayp;
    }

    public String zzrP() {
        return this.zzayq;
    }

    public String zzrQ() {
        return this.zzayr;
    }

    public long zzrR() {
        return this.zzayt;
    }

    public long zzrS() {
        return this.zzays;
    }

    public String zzrT() {
        return "\t" + zzrL() + "/" + zzrM() + "\t" + zzrN() + "/" + zzrO() + "\t" + (this.zzayq == null ? "" : this.zzayq) + "\t" + zzrR();
    }
}

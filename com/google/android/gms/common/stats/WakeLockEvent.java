package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.snet.Csv;
import java.util.List;

public final class WakeLockEvent extends zzf implements SafeParcelable {
    public static final Creator<WakeLockEvent> CREATOR = new zzh();
    private final long mTimeout;
    final int mVersionCode;
    private final String zzayW;
    private final int zzayX;
    private final List<String> zzayY;
    private final String zzayZ;
    private final long zzayk;
    private int zzayl;
    private final long zzays;
    private long zzayu;
    private int zzaza;
    private final String zzazb;
    private final String zzazc;
    private final float zzazd;

    WakeLockEvent(int versionCode, long timeMillis, int eventType, String wakelockName, int wakelockType, List<String> callingPackages, String eventKey, long elapsedRealtime, int deviceState, String secondaryWakeLockName, String hostPackageName, float beginPowerPercentage, long timeout) {
        this.mVersionCode = versionCode;
        this.zzayk = timeMillis;
        this.zzayl = eventType;
        this.zzayW = wakelockName;
        this.zzazb = secondaryWakeLockName;
        this.zzayX = wakelockType;
        this.zzayu = -1;
        this.zzayY = callingPackages;
        this.zzayZ = eventKey;
        this.zzays = elapsedRealtime;
        this.zzaza = deviceState;
        this.zzazc = hostPackageName;
        this.zzazd = beginPowerPercentage;
        this.mTimeout = timeout;
    }

    public WakeLockEvent(long timeMillis, int eventType, String wakelockName, int wakelockType, List<String> callingPackages, String eventKey, long elapsedRealtime, int deviceState, String secondaryWakeLockName, String hostPackageName, float beginPowerPercentage, long timeout) {
        this(1, timeMillis, eventType, wakelockName, wakelockType, callingPackages, eventKey, elapsedRealtime, deviceState, secondaryWakeLockName, hostPackageName, beginPowerPercentage, timeout);
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
        zzh.zza(this, out, flags);
    }

    public String zzrQ() {
        return this.zzayZ;
    }

    public long zzrS() {
        return this.zzays;
    }

    public String zzrT() {
        return "\t" + zzrW() + "\t" + zzrY() + "\t" + (zzrZ() == null ? "" : TextUtils.join(Csv.COMMA, zzrZ())) + "\t" + zzsa() + "\t" + (zzrX() == null ? "" : zzrX()) + "\t" + (zzsb() == null ? "" : zzsb()) + "\t" + zzsc();
    }

    public String zzrW() {
        return this.zzayW;
    }

    public String zzrX() {
        return this.zzazb;
    }

    public int zzrY() {
        return this.zzayX;
    }

    public List<String> zzrZ() {
        return this.zzayY;
    }

    public int zzsa() {
        return this.zzaza;
    }

    public String zzsb() {
        return this.zzazc;
    }

    public float zzsc() {
        return this.zzazd;
    }

    public long zzsd() {
        return this.mTimeout;
    }
}

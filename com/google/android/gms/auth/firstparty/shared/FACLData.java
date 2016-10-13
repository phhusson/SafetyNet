package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLData implements SafeParcelable {
    public static final FACLDataCreator CREATOR = new FACLDataCreator();
    final int version;
    FACLConfig zzaco;
    String zzacp;
    boolean zzacq;
    String zzacr;

    FACLData(int version, FACLConfig faclConfig, String activityText, boolean isSpeedbumpNeeded, String speedbumpText) {
        this.version = version;
        this.zzaco = faclConfig;
        this.zzacp = activityText;
        this.zzacq = isSpeedbumpNeeded;
        this.zzacr = speedbumpText;
    }

    public FACLData(FACLConfig faclConfig, String activityText, String speedbumpText, boolean isSpeedbumpNeeded) {
        this.version = 1;
        this.zzaco = faclConfig;
        this.zzacp = activityText;
        this.zzacr = speedbumpText;
        this.zzacq = isSpeedbumpNeeded;
    }

    public int describeContents() {
        return 0;
    }

    public String getActivityText() {
        return this.zzacp;
    }

    public FACLConfig getFaclConfig() {
        return this.zzaco;
    }

    public String getSpeedbumpText() {
        return this.zzacr;
    }

    public boolean isSpeedbumpNeeded() {
        return this.zzacq;
    }

    public void writeToParcel(Parcel dest, int flags) {
        FACLDataCreator.zza(this, dest, flags);
    }
}

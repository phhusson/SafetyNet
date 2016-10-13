package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountResult implements Result, SafeParcelable {
    public static final Creator<AuthAccountResult> CREATOR = new zza();
    final int mVersionCode;
    private int zzbTQ;
    private Intent zzbTR;

    public AuthAccountResult() {
        this(0, null);
    }

    AuthAccountResult(int versionCode, int connectionResultCode, Intent rawAuthResultionIntent) {
        this.mVersionCode = versionCode;
        this.zzbTQ = connectionResultCode;
        this.zzbTR = rawAuthResultionIntent;
    }

    public AuthAccountResult(int connectionResultCode, Intent rawAuthResolutionIntent) {
        this(2, connectionResultCode, rawAuthResolutionIntent);
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return this.zzbTQ == 0 ? Status.zzaqL : Status.zzaqP;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public int zzLy() {
        return this.zzbTQ;
    }

    public Intent zzLz() {
        return this.zzbTR;
    }
}

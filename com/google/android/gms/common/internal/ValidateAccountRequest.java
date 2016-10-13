package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class ValidateAccountRequest implements SafeParcelable {
    public static final Creator<ValidateAccountRequest> CREATOR = new zzae();
    final int mVersionCode;
    private final String zzXz;
    private final Scope[] zzaqd;
    final IBinder zzavn;
    private final int zzaxi;
    private final Bundle zzaxj;

    ValidateAccountRequest(int versionCode, int clientVersion, IBinder accountAccessorBinder, Scope[] scopes, Bundle extraArgs, String callingPackage) {
        this.mVersionCode = versionCode;
        this.zzaxi = clientVersion;
        this.zzavn = accountAccessorBinder;
        this.zzaqd = scopes;
        this.zzaxj = extraArgs;
        this.zzXz = callingPackage;
    }

    public int describeContents() {
        return 0;
    }

    public String getCallingPackage() {
        return this.zzXz;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzae.zza(this, dest, flags);
    }

    public Scope[] zzrx() {
        return this.zzaqd;
    }

    public int zzry() {
        return this.zzaxi;
    }

    public Bundle zzrz() {
        return this.zzaxj;
    }
}

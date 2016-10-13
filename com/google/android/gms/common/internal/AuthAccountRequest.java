package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountRequest implements SafeParcelable {
    public static final Creator<AuthAccountRequest> CREATOR = new zzc();
    final int mVersionCode;
    final Scope[] zzaqd;
    final IBinder zzavn;
    Integer zzavo;
    Integer zzavp;

    AuthAccountRequest(int versionCode, IBinder accountAccessorBinder, Scope[] scopes, Integer oauthPolicy, Integer policyAction) {
        this.mVersionCode = versionCode;
        this.zzavn = accountAccessorBinder;
        this.zzaqd = scopes;
        this.zzavo = oauthPolicy;
        this.zzavp = policyAction;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}

package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInResponse implements SafeParcelable {
    public static final Creator<SignInResponse> CREATOR = new zzj();
    final int mVersionCode;
    private final ConnectionResult zzaxc;
    private final ResolveAccountResponse zzbTX;

    public SignInResponse(int connectionResultStatusCode) {
        this(new ConnectionResult(connectionResultStatusCode, null), null);
    }

    SignInResponse(int versionCode, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.mVersionCode = versionCode;
        this.zzaxc = connectionResult;
        this.zzbTX = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult result, ResolveAccountResponse resolveAccountResponse) {
        this(1, result, resolveAccountResponse);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    public ResolveAccountResponse zzLD() {
        return this.zzbTX;
    }

    public ConnectionResult zzrs() {
        return this.zzaxc;
    }
}

package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp.zza;

public class ResolveAccountResponse implements SafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR = new zzz();
    final int mVersionCode;
    private boolean zzarG;
    IBinder zzavn;
    private ConnectionResult zzaxc;
    private boolean zzaxd;

    ResolveAccountResponse(int versionCode, IBinder accountAccessorBinder, ConnectionResult connectionResult, boolean saveDefaultAccount, boolean isFromCrossClientAuth) {
        this.mVersionCode = versionCode;
        this.zzavn = accountAccessorBinder;
        this.zzaxc = connectionResult;
        this.zzarG = saveDefaultAccount;
        this.zzaxd = isFromCrossClientAuth;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) o;
        return this.zzaxc.equals(resolveAccountResponse.zzaxc) && zzrr().equals(resolveAccountResponse.zzrr());
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzz.zza(this, dest, flags);
    }

    public zzp zzrr() {
        return zza.zzcs(this.zzavn);
    }

    public ConnectionResult zzrs() {
        return this.zzaxc;
    }

    public boolean zzrt() {
        return this.zzarG;
    }

    public boolean zzru() {
        return this.zzaxd;
    }
}

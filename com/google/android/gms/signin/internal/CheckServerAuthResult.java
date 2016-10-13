package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckServerAuthResult implements SafeParcelable {
    public static final Creator<CheckServerAuthResult> CREATOR = new zzc();
    final int mVersionCode;
    final boolean zzbTS;
    final List<Scope> zzbTT;

    CheckServerAuthResult(int versionCode, boolean newAuthCodeRequired, List<Scope> additionalScopes) {
        this.mVersionCode = versionCode;
        this.zzbTS = newAuthCodeRequired;
        this.zzbTT = additionalScopes;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}

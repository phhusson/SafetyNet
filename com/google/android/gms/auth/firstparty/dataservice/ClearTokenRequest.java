package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ClearTokenRequest implements SafeParcelable {
    public static final ClearTokenRequestCreator CREATOR = new ClearTokenRequestCreator();
    final int version;
    String zzaaC;

    public ClearTokenRequest() {
        this.version = 1;
    }

    ClearTokenRequest(int version, String token) {
        this.version = version;
        this.zzaaC = token;
    }

    public int describeContents() {
        return 0;
    }

    public String getToken() {
        return this.zzaaC;
    }

    public ClearTokenRequest setToken(String token) {
        this.zzaaC = token;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ClearTokenRequestCreator.zza(this, dest, flags);
    }
}

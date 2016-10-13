package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class ClearTokenResponse implements SafeParcelable {
    public static final ClearTokenResponseCreator CREATOR = new ClearTokenResponseCreator();
    final int version;
    final String zzaah;

    ClearTokenResponse(int version, String statusWireCode) {
        this.version = version;
        this.zzaah = statusWireCode;
    }

    public ClearTokenResponse(Status status) {
        this.version = 1;
        this.zzaah = ((Status) zzx.zzD(status)).getWire();
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return Status.fromWireCode(this.zzaah);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ClearTokenResponseCreator.zza(this, dest, flags);
    }
}

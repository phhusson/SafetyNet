package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class CheckRealNameResponse implements SafeParcelable {
    public static final CheckRealNameResponseCreator CREATOR = new CheckRealNameResponseCreator();
    final int version;
    String zzaah;

    CheckRealNameResponse(int version, String statusWireCode) {
        this.version = version;
        this.zzaah = statusWireCode;
    }

    public CheckRealNameResponse(Status status) {
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
        CheckRealNameResponseCreator.zza(this, dest, flags);
    }
}

package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class PlusProfileCreationResponse implements SafeParcelable {
    public static final PlusProfileCreationResponseCreator CREATOR = new PlusProfileCreationResponseCreator();
    final int version;
    String zzacv;

    PlusProfileCreationResponse(int version, String status) {
        this.version = version;
        this.zzacv = status;
    }

    public PlusProfileCreationResponse(Status status) {
        this.version = 1;
        this.zzacv = ((Status) zzx.zzD(status)).getWire();
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return Status.fromWireCode(this.zzacv);
    }

    public void writeToParcel(Parcel dest, int flags) {
        PlusProfileCreationResponseCreator.zza(this, dest, flags);
    }
}

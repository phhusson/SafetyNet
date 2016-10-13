package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class VerifyPinResponse implements SafeParcelable {
    public static final VerifyPinResponseCreator CREATOR = new VerifyPinResponseCreator();
    public final String rapt;
    public final int status;
    final int version;

    public VerifyPinResponse(int errorStatus) {
        this(1, errorStatus, null);
    }

    VerifyPinResponse(int version, int status, String rapt) {
        this.version = version;
        this.status = status;
        this.rapt = rapt;
    }

    public VerifyPinResponse(String rapt) {
        this(1, 0, rapt);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        VerifyPinResponseCreator.zza(this, dest, flags);
    }
}

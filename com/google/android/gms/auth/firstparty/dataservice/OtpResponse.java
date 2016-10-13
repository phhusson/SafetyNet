package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OtpResponse implements SafeParcelable {
    public static final OtpResponseCreator CREATOR = new OtpResponseCreator();
    final int mVersion;
    public final String otp;

    OtpResponse(int version, String otp) {
        this.mVersion = version;
        this.otp = otp;
    }

    public OtpResponse(String otp) {
        this(1, otp);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        OtpResponseCreator.zza(this, dest, flags);
    }
}

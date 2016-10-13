package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetAndAdvanceOtpCounterResponse implements SafeParcelable {
    public static final GetAndAdvanceOtpCounterResponseCreator CREATOR = new GetAndAdvanceOtpCounterResponseCreator();
    public final Long counter;
    final int mVersion;

    GetAndAdvanceOtpCounterResponse(int version, Long counter) {
        this.mVersion = version;
        this.counter = counter;
    }

    public GetAndAdvanceOtpCounterResponse(Long counter) {
        this(1, counter);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        GetAndAdvanceOtpCounterResponseCreator.zza(this, dest, flags);
    }
}

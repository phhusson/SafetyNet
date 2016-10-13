package com.google.android.gms.auth.frp;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UnlockFactoryResetProtectionResponse implements SafeParcelable {
    public static final UnlockFactoryResetProtectionResponseCreator CREATOR = new UnlockFactoryResetProtectionResponseCreator();
    public static final int STATUS_ERROR_INVALID_CREDENTIALS = 3;
    public static final int STATUS_ERROR_NETWORK = 2;
    public static final int STATUS_ERROR_NOT_COMPLIANT = 4;
    public static final int STATUS_ERROR_UNKNOWN = 1;
    public static final int STATUS_OK = 0;
    public final int status;
    final int version;

    public UnlockFactoryResetProtectionResponse(int status) {
        this(1, status);
    }

    UnlockFactoryResetProtectionResponse(int version, int status) {
        this.version = version;
        this.status = status;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        UnlockFactoryResetProtectionResponseCreator.zza(this, dest, flags);
    }
}

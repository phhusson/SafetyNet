package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecoveryWriteResponse implements SafeParcelable {
    public static final RecoveryWriteResponseCreator CREATOR = new RecoveryWriteResponseCreator();
    public String mErrorCode;
    final int mVersionCode;

    public RecoveryWriteResponse() {
        this.mVersionCode = 1;
    }

    RecoveryWriteResponse(int versionCode, String errorCode) {
        this.mVersionCode = versionCode;
        this.mErrorCode = errorCode;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        RecoveryWriteResponseCreator.zza(this, out, flags);
    }
}

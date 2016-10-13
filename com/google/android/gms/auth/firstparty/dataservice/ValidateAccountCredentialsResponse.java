package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValidateAccountCredentialsResponse implements SafeParcelable {
    public static final ValidateAccountCredentialsResponseCreator CREATOR = new ValidateAccountCredentialsResponseCreator();
    public static final int STATUS_ERROR_INVALID_CREDENTIALS = 3;
    public static final int STATUS_ERROR_NETWORK = 2;
    public static final int STATUS_ERROR_UNKNOWN = 1;
    public static final int STATUS_OK = 0;
    public final String accountId;
    public final int status;
    final int version;

    public ValidateAccountCredentialsResponse(int errorStatus) {
        this(1, errorStatus, null);
    }

    ValidateAccountCredentialsResponse(int version, int status, String accountId) {
        this.version = version;
        this.status = status;
        this.accountId = accountId;
    }

    public ValidateAccountCredentialsResponse(String accountId) {
        this(1, 0, accountId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ValidateAccountCredentialsResponseCreator.zza(this, dest, flags);
    }
}

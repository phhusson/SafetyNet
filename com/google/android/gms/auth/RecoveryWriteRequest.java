package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecoveryWriteRequest implements SafeParcelable {
    public static final RecoveryWriteRequestCreator CREATOR = new RecoveryWriteRequestCreator();
    public String mAccount;
    public boolean mIsBroadUse;
    public String mPhoneCountryCode;
    public String mPhoneNumber;
    public String mSecondaryEmail;
    final int mVersionCode;

    public RecoveryWriteRequest() {
        this.mVersionCode = 1;
    }

    RecoveryWriteRequest(int versionCode, String account, String secondaryEmail, String phoneNumber, String phoneCountryCode, boolean isBroadUse) {
        this.mVersionCode = versionCode;
        this.mAccount = account;
        this.mSecondaryEmail = secondaryEmail;
        this.mPhoneNumber = phoneNumber;
        this.mPhoneCountryCode = phoneCountryCode;
        this.mIsBroadUse = isBroadUse;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        RecoveryWriteRequestCreator.zza(this, out, flags);
    }
}

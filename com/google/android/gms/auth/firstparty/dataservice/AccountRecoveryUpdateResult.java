package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.RecoveryResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountRecoveryUpdateResult implements RecoveryResponse, SafeParcelable {
    public static final AccountRecoveryUpdateResultCreator CREATOR = new AccountRecoveryUpdateResultCreator();
    public final String error;
    final int version;

    AccountRecoveryUpdateResult(int version, String error) {
        this.version = version;
        this.error = error;
    }

    public AccountRecoveryUpdateResult(String error) {
        this(0, error);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountRecoveryUpdateResultCreator.zza(this, dest, flags);
    }
}

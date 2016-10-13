package com.google.android.gms.auth.frp;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UnlockFactoryResetProtectionRequest implements SafeParcelable {
    public static final UnlockFactoryResetProtectionRequestCreator CREATOR = new UnlockFactoryResetProtectionRequestCreator();
    public final String accountName;
    public final String accountType;
    public final String password;
    final int version;

    UnlockFactoryResetProtectionRequest(int version, String accountName, String password, String accountType) {
        this.version = version;
        this.accountName = accountName;
        this.password = password;
        this.accountType = accountType;
    }

    public static final UnlockFactoryResetProtectionRequest from(String accountName, String password) {
        return new UnlockFactoryResetProtectionRequest(1, accountName, password, null);
    }

    public static final UnlockFactoryResetProtectionRequest from(String accountName, String password, String accountType) {
        return new UnlockFactoryResetProtectionRequest(1, accountName, password, accountType);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        UnlockFactoryResetProtectionRequestCreator.zza(this, dest, flags);
    }
}

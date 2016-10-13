package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountRecoveryGuidanceRequest implements SafeParcelable {
    public static final AccountRecoveryGuidanceRequestCreator CREATOR = new AccountRecoveryGuidanceRequestCreator();
    public final Account account;
    @Deprecated
    public final String accountName;
    final int version;

    AccountRecoveryGuidanceRequest(int version, String accountName, Account account) {
        this.version = version;
        this.accountName = accountName;
        if (account != null || TextUtils.isEmpty(accountName)) {
            this.account = account;
        } else {
            this.account = new Account(accountName, "com.google");
        }
    }

    public AccountRecoveryGuidanceRequest(Account account) {
        this(1, account.name, account);
    }

    public AccountRecoveryGuidanceRequest(String accountName) {
        this(new Account(accountName, "com.google"));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountRecoveryGuidanceRequestCreator.zza(this, dest, flags);
    }
}

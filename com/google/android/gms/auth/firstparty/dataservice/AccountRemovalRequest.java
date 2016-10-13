package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountRemovalRequest implements SafeParcelable {
    public static final AccountRemovalRequestCreator CREATOR = new AccountRemovalRequestCreator();
    Account account;
    @Deprecated
    String accountName;
    final int version;

    public AccountRemovalRequest() {
        this.version = 2;
    }

    AccountRemovalRequest(int version, String accountName, Account account) {
        this.version = version;
        this.accountName = accountName;
        if (account != null || TextUtils.isEmpty(accountName)) {
            this.account = account;
        } else {
            this.account = new Account(accountName, "com.google");
        }
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.account;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public AccountRemovalRequest setAccount(Account account) {
        this.account = account;
        return this;
    }

    public AccountRemovalRequest setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountRemovalRequestCreator.zza(this, dest, flags);
    }
}

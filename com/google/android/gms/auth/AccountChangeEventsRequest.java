package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final Creator<AccountChangeEventsRequest> CREATOR = new zzb();
    final int mVersion;
    Account zzSX;
    @Deprecated
    String zzWD;
    int zzWF;

    public AccountChangeEventsRequest() {
        this.mVersion = 1;
    }

    AccountChangeEventsRequest(int version, int eventIndex, String accountName, Account account) {
        this.mVersion = version;
        this.zzWF = eventIndex;
        this.zzWD = accountName;
        if (account != null || TextUtils.isEmpty(accountName)) {
            this.zzSX = account;
        } else {
            this.zzSX = new Account(accountName, "com.google");
        }
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzSX;
    }

    public String getAccountName() {
        return this.zzWD;
    }

    public int getEventIndex() {
        return this.zzWF;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzSX = account;
        return this;
    }

    public AccountChangeEventsRequest setAccountName(String accountName) {
        this.zzWD = accountName;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int eventIndex) {
        this.zzWF = eventIndex;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}

package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoogleAccountData implements SafeParcelable {
    public static final GoogleAccountDataCreator CREATOR = new GoogleAccountDataCreator();
    public Account account;
    @Deprecated
    String accountName;
    public String firstName;
    public String lastName;
    public List<String> services;
    final int version;
    boolean zzaaD;

    GoogleAccountData(int version, String accountName, boolean isBrowserFlowRequired, List<String> services, String firstName, String lastName, Account account) {
        this.version = version;
        this.accountName = accountName;
        this.zzaaD = isBrowserFlowRequired;
        this.services = services;
        this.firstName = firstName;
        this.lastName = lastName;
        if (account != null || TextUtils.isEmpty(accountName)) {
            this.account = account;
        } else {
            this.account = new Account(accountName, "com.google");
        }
    }

    public GoogleAccountData(Account account, boolean isBrowserFlowRequired, List<String> services, String firstName, String lastName) {
        this.version = 2;
        this.account = account;
        this.zzaaD = isBrowserFlowRequired;
        this.services = services == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(services));
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Deprecated
    public GoogleAccountData(String accountName, boolean isBrowserFlowRequired, List<String> services, String firstName, String lastName) {
        this(new Account(accountName, "com.google"), isBrowserFlowRequired, (List) services, firstName, lastName);
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.account;
    }

    @Deprecated
    public String getAccountName() {
        return this.account == null ? this.accountName : this.account.name;
    }

    public List<String> getServices() {
        return this.services;
    }

    public boolean isBrowserFlowRequired() {
        return this.zzaaD;
    }

    public void writeToParcel(Parcel dest, int flags) {
        GoogleAccountDataCreator.zza(this, dest, flags);
    }
}

package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConfirmCredentialsWorkflowRequest implements SafeParcelable {
    public static final ConfirmCredentialsWorkflowRequestCreator CREATOR = new ConfirmCredentialsWorkflowRequestCreator();
    Account account;
    @Deprecated
    String accountName;
    AccountAuthenticatorResponse amResponse;
    AppDescription callingAppDescription;
    Bundle options;
    final int version;

    public ConfirmCredentialsWorkflowRequest() {
        this.version = 3;
        this.options = new Bundle();
    }

    ConfirmCredentialsWorkflowRequest(int version, String accountName, AppDescription callingAppDescription, Bundle options, Account account, AccountAuthenticatorResponse amResponse) {
        this.version = version;
        this.accountName = accountName;
        this.callingAppDescription = callingAppDescription;
        this.options = options;
        if (account != null || TextUtils.isEmpty(accountName)) {
            this.account = account;
        } else {
            this.account = new Account(accountName, "com.google");
        }
        this.amResponse = amResponse;
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.account;
    }

    @Deprecated
    public String getAccountName() {
        return this.accountName;
    }

    public AccountAuthenticatorResponse getAmResponse() {
        return this.amResponse;
    }

    public AppDescription getCallingAppDescription() {
        return this.callingAppDescription;
    }

    public Bundle getOptions() {
        return new Bundle(this.options);
    }

    public ConfirmCredentialsWorkflowRequest setAccount(Account account) {
        this.accountName = account == null ? null : account.name;
        this.account = account;
        return this;
    }

    @Deprecated
    public ConfirmCredentialsWorkflowRequest setAccountName(String accountName) {
        this.account = TextUtils.isEmpty(accountName) ? null : new Account(accountName, "com.google");
        this.accountName = accountName;
        return this;
    }

    public ConfirmCredentialsWorkflowRequest setAmResponse(AccountAuthenticatorResponse amResponse) {
        this.amResponse = amResponse;
        return this;
    }

    public ConfirmCredentialsWorkflowRequest setCallingAppDescription(AppDescription appDescription) {
        this.callingAppDescription = appDescription;
        return this;
    }

    public ConfirmCredentialsWorkflowRequest setOptions(Bundle options) {
        this.options.clear();
        if (options != null) {
            this.options.putAll(options);
        }
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ConfirmCredentialsWorkflowRequestCreator.zza(this, dest, flags);
    }
}

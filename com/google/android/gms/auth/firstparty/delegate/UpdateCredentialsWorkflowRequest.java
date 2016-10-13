package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UpdateCredentialsWorkflowRequest implements SafeParcelable {
    public static final UpdateCredentialsWorkflowRequestCreator CREATOR = new UpdateCredentialsWorkflowRequestCreator();
    Account account;
    @Deprecated
    String accountName;
    AccountAuthenticatorResponse amResponse;
    AppDescription callingAppDescription;
    Bundle options;
    final int version;

    public UpdateCredentialsWorkflowRequest() {
        this.version = 3;
        this.options = new Bundle();
    }

    UpdateCredentialsWorkflowRequest(int version, String accountName, AppDescription callingAppDescription, Bundle options, Account account, AccountAuthenticatorResponse amResponse) {
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

    public UpdateCredentialsWorkflowRequest setAccount(Account account) {
        this.accountName = account == null ? null : account.name;
        this.account = account;
        return this;
    }

    @Deprecated
    public UpdateCredentialsWorkflowRequest setAccountName(String accountName) {
        this.account = TextUtils.isEmpty(accountName) ? null : new Account(accountName, "com.google");
        this.accountName = accountName;
        return this;
    }

    public UpdateCredentialsWorkflowRequest setAmResponse(AccountAuthenticatorResponse amResponse) {
        this.amResponse = amResponse;
        return this;
    }

    public UpdateCredentialsWorkflowRequest setCallingAppDescription(AppDescription appDescription) {
        this.callingAppDescription = appDescription;
        return this;
    }

    public UpdateCredentialsWorkflowRequest setOptions(Bundle options) {
        this.options.clear();
        if (options != null) {
            this.options.putAll(options);
        }
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        UpdateCredentialsWorkflowRequestCreator.zza(this, dest, flags);
    }
}

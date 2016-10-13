package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.PACLConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TokenWorkflowRequest implements SafeParcelable {
    public static final TokenWorkflowRequestCreator CREATOR = new TokenWorkflowRequestCreator();
    Account account;
    @Deprecated
    String accountName;
    AccountAuthenticatorResponse amResponse;
    AppDescription callingAppDescription;
    Bundle options;
    final int version;
    boolean zzabO;
    String zzabq;
    FACLConfig zzabr;
    PACLConfig zzabs;

    public TokenWorkflowRequest() {
        this.version = 2;
        this.options = new Bundle();
    }

    TokenWorkflowRequest(int version, String service, String accountName, Bundle options, FACLConfig faclData, PACLConfig paclData, boolean isSuppressingProgressUx, AppDescription callingAppDescription, Account account, AccountAuthenticatorResponse amResponse) {
        this.version = version;
        this.zzabq = service;
        this.accountName = accountName;
        this.options = options;
        this.zzabr = faclData;
        this.zzabs = paclData;
        this.zzabO = isSuppressingProgressUx;
        this.callingAppDescription = callingAppDescription;
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

    public FACLConfig getFaclData() {
        return this.zzabr;
    }

    public Bundle getOptions() {
        return new Bundle(this.options);
    }

    public PACLConfig getPaclData() {
        return this.zzabs;
    }

    public String getService() {
        return this.zzabq;
    }

    public boolean isSuppressingProgressUx() {
        return this.zzabO;
    }

    public TokenWorkflowRequest setAccount(Account account) {
        this.accountName = account == null ? null : account.name;
        this.account = account;
        return this;
    }

    @Deprecated
    public TokenWorkflowRequest setAccountName(String accountName) {
        this.account = TextUtils.isEmpty(accountName) ? null : new Account(accountName, "com.google");
        this.accountName = accountName;
        return this;
    }

    public TokenWorkflowRequest setAmResponse(AccountAuthenticatorResponse amResponse) {
        this.amResponse = amResponse;
        return this;
    }

    public TokenWorkflowRequest setCallingAppDescription(AppDescription appDescription) {
        this.callingAppDescription = appDescription;
        return this;
    }

    public TokenWorkflowRequest setFaclData(FACLConfig faclData) {
        this.zzabr = faclData;
        return this;
    }

    public TokenWorkflowRequest setOptions(Bundle options) {
        this.options.clear();
        if (options != null) {
            this.options.putAll(options);
        }
        return this;
    }

    public TokenWorkflowRequest setPaclData(PACLConfig paclData) {
        this.zzabs = paclData;
        return this;
    }

    public TokenWorkflowRequest setService(String service) {
        this.zzabq = service;
        return this;
    }

    public TokenWorkflowRequest setSuppressingProgressUx(boolean isSuppressingProgressUx) {
        this.zzabO = isSuppressingProgressUx;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        TokenWorkflowRequestCreator.zza(this, dest, flags);
    }
}

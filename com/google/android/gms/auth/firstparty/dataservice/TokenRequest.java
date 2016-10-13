package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.PACLConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class TokenRequest implements SafeParcelable {
    public static final TokenRequestCreator CREATOR = new TokenRequestCreator();
    String accountName;
    String accountType;
    AppDescription callingAppDescription;
    Bundle options;
    final int version;
    CaptchaSolution zzaaf;
    boolean zzaaz;
    boolean zzabg;
    String zzabq;
    FACLConfig zzabr;
    PACLConfig zzabs;
    String zzabt;
    boolean zzabu;
    boolean zzabv;
    int zzabw;
    String zzabx;
    String zzaby;

    public enum Consent {
        UNKNOWN,
        GRANTED,
        REJECTED
    }

    TokenRequest(int version, String service, String accountName, Bundle options, FACLConfig faclData, PACLConfig paclData, boolean isAddingAccount, boolean isCreatingAccount, String consent, AppDescription callingAppDescription, CaptchaSolution optionalCaptchaSolution, boolean isForcingDroidguardRun, boolean isUsingCache, String accountType, int delegationType, String delegateeUserId, String consentCookieWrapper) {
        this.options = new Bundle();
        this.zzabt = Consent.UNKNOWN.toString();
        this.zzabu = false;
        this.zzabv = true;
        this.accountType = "com.google";
        this.zzabw = 0;
        this.version = version;
        this.zzabq = service;
        this.accountName = accountName;
        this.options = options;
        this.zzabr = faclData;
        this.zzabs = paclData;
        this.zzabg = isAddingAccount;
        this.zzaaz = isCreatingAccount;
        this.zzabt = consent;
        this.callingAppDescription = callingAppDescription;
        this.zzaaf = optionalCaptchaSolution;
        this.zzabu = isForcingDroidguardRun;
        this.zzabv = isUsingCache;
        this.accountType = accountType;
        this.zzabw = delegationType;
        this.zzabx = delegateeUserId;
        this.zzaby = consentCookieWrapper;
    }

    public TokenRequest(Account account, String service) {
        this(account.name, account.type, service);
    }

    @Deprecated
    public TokenRequest(@Nullable String accountName, String accountType, String service) {
        this.options = new Bundle();
        this.zzabt = Consent.UNKNOWN.toString();
        this.zzabu = false;
        this.zzabv = true;
        this.accountType = "com.google";
        this.zzabw = 0;
        this.version = 4;
        this.accountName = accountName;
        this.accountType = accountType;
        this.zzabq = service;
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return !TextUtils.isEmpty(this.accountName) ? new Account(this.accountName, this.accountType) : null;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public AppDescription getCallingAppDescription() {
        return this.callingAppDescription;
    }

    public CaptchaSolution getCaptchaSolution() {
        return this.zzaaf;
    }

    public Consent getConsent() {
        return Consent.valueOf(this.zzabt);
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

    public boolean isAddingAccount() {
        return this.zzabg;
    }

    public boolean isCreatingAccount() {
        return this.zzaaz;
    }

    public TokenRequest setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public TokenRequest setAddingAccount(boolean isAdding) {
        this.zzabg = isAdding;
        return this;
    }

    public TokenRequest setCallingAppDescription(AppDescription appDescription) {
        this.callingAppDescription = appDescription;
        return this;
    }

    public TokenRequest setCaptchaSolution(CaptchaSolution captchaSolution) {
        this.zzaaf = captchaSolution;
        return this;
    }

    public TokenRequest setConsent(Consent consent) {
        this.zzabt = ((Consent) zzx.zzb((Object) consent, (Object) " Consent cannot be null")).toString();
        return this;
    }

    public TokenRequest setCreatingAccount(boolean isCreating) {
        this.zzaaz = isCreating;
        return this;
    }

    public TokenRequest setFaclData(FACLConfig faclData) {
        this.zzabr = faclData;
        return this;
    }

    public TokenRequest setOptions(Bundle options) {
        this.options.clear();
        if (options != null) {
            this.options.putAll(options);
        }
        return this;
    }

    public TokenRequest setPaclData(PACLConfig paclData) {
        this.zzabs = paclData;
        return this;
    }

    public TokenRequest setService(String service) {
        this.zzabq = service;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        TokenRequestCreator.zza(this, dest, flags);
    }
}

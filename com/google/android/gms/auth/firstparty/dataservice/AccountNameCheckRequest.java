package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountNameCheckRequest implements SafeParcelable {
    public static final AccountNameCheckRequestCreator CREATOR = new AccountNameCheckRequestCreator();
    AppDescription callingAppDescription;
    final int version;
    @Deprecated
    String zzaac;
    String zzaad;
    String zzaae;
    CaptchaSolution zzaaf;
    Account zzaag;

    public AccountNameCheckRequest() {
        this.version = 2;
    }

    AccountNameCheckRequest(int version, String accountNameToCheck, String optionalFirstName, String optionalLastName, AppDescription callingAppDescription, CaptchaSolution optionalCaptchaSolution, Account accountToCheck) {
        this.version = version;
        this.zzaac = accountNameToCheck;
        this.zzaad = optionalFirstName;
        this.zzaae = optionalLastName;
        this.callingAppDescription = callingAppDescription;
        this.zzaaf = optionalCaptchaSolution;
        if (accountToCheck != null || TextUtils.isEmpty(accountNameToCheck)) {
            this.zzaag = accountToCheck;
        } else {
            this.zzaag = new Account(accountNameToCheck, "com.google");
        }
    }

    public AccountNameCheckRequest(Account account) {
        this.version = 2;
        this.zzaag = account;
    }

    @Deprecated
    public AccountNameCheckRequest(String accountNameToCheck) {
        this.version = 2;
        this.zzaac = accountNameToCheck;
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAccountNameToCheck() {
        return this.zzaac;
    }

    public Account getAccountToCheck() {
        return this.zzaag;
    }

    public AppDescription getCallingAppDescription() {
        return this.callingAppDescription;
    }

    public CaptchaSolution getCaptchaSolution() {
        return this.zzaaf;
    }

    public String getFirstName() {
        return this.zzaad;
    }

    public String getLastName() {
        return this.zzaae;
    }

    @Deprecated
    public AccountNameCheckRequest setAccountNameToCheck(String accountName) {
        this.zzaac = accountName;
        return this;
    }

    public AccountNameCheckRequest setAccountToCheck(Account accountToCheck) {
        this.zzaag = accountToCheck;
        return this;
    }

    public AccountNameCheckRequest setCallingAppDescription(AppDescription appDescription) {
        this.callingAppDescription = appDescription;
        return this;
    }

    public AccountNameCheckRequest setCaptchaSolution(CaptchaSolution captchaSolution) {
        this.zzaaf = captchaSolution;
        return this;
    }

    public AccountNameCheckRequest setFirstName(String optionalFirstName) {
        this.zzaad = optionalFirstName;
        return this;
    }

    public AccountNameCheckRequest setLastName(String optionalLastName) {
        this.zzaae = optionalLastName;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountNameCheckRequestCreator.zza(this, dest, flags);
    }
}

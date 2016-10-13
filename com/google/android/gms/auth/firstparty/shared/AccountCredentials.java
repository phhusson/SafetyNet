package com.google.android.gms.auth.firstparty.shared;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class AccountCredentials implements SafeParcelable {
    public static final AccountCredentialsCreator CREATOR = new AccountCredentialsCreator();
    final String mAccountType;
    final int version;
    String zzWD;
    String zzXI;
    boolean zzabX;
    String zzabY;
    String zzabZ;
    String zzaca;
    String zzacb;

    @Deprecated
    public AccountCredentials() {
        this("com.google");
    }

    AccountCredentials(int version, boolean isBrowserRequired, String accountName, String longLivedLoginToken, String authorizationCode, String password, String verifier, String redirectUri, String accountType) {
        this.version = version;
        this.zzabX = isBrowserRequired;
        this.zzWD = accountName;
        this.zzabY = longLivedLoginToken;
        this.zzabZ = authorizationCode;
        this.zzXI = password;
        this.zzaca = verifier;
        this.zzacb = redirectUri;
        this.mAccountType = accountType;
    }

    public AccountCredentials(Account account) {
        this(account.type);
        this.zzWD = account.name;
    }

    public AccountCredentials(Parcel src) {
        boolean z = true;
        this.version = 2;
        if (src.readInt() != 1) {
            z = false;
        }
        this.zzabX = z;
        this.zzabY = src.readString();
        this.zzWD = src.readString();
        this.zzabZ = src.readString();
        this.zzXI = src.readString();
        this.zzaca = src.readString();
        this.zzacb = src.readString();
        this.mAccountType = src.readString();
    }

    public AccountCredentials(String accountType) {
        this.version = 2;
        this.mAccountType = zzx.zzi(accountType, "Account type can't be empty.");
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return !TextUtils.isEmpty(this.zzWD) ? new Account(this.zzWD, this.mAccountType) : null;
    }

    public String getAccountName() {
        return this.zzWD;
    }

    public String getAccountType() {
        return this.mAccountType;
    }

    public String getAuthorizationCode() {
        return this.zzabZ;
    }

    public String getLongLivedLoginToken() {
        return this.zzabY;
    }

    public String getPassword() {
        return this.zzXI;
    }

    public String getRedirectUri() {
        return this.zzacb;
    }

    public String getVerifier() {
        return this.zzaca;
    }

    public boolean isBrowserAuthenticationRequired() {
        return this.zzabX;
    }

    public AccountCredentials setAccountName(String accountName) {
        this.zzWD = accountName;
        return this;
    }

    public AccountCredentials setAuthorizationCode(String authorizationCode) {
        this.zzabZ = authorizationCode;
        return this;
    }

    public AccountCredentials setBrowserAuthenticationRequired(boolean isRequired) {
        this.zzabX = isRequired;
        return this;
    }

    public AccountCredentials setLongLivedLoginToken(String token) {
        this.zzabY = token;
        return this;
    }

    public AccountCredentials setPassword(String password) {
        this.zzXI = password;
        return this;
    }

    public AccountCredentials setRedirectUri(String redirectUri) {
        this.zzacb = redirectUri;
        return this;
    }

    public AccountCredentials setVerifier(String verifier) {
        this.zzaca = verifier;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountCredentialsCreator.zza(this, dest, flags);
    }
}

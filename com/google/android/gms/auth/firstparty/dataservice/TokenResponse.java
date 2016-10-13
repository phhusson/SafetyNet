package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.TokenData;
import com.google.android.gms.auth.TokenData.zza;
import com.google.android.gms.auth.firstparty.shared.CaptchaChallenge;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.auth.firstparty.shared.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TokenResponse implements SafeParcelable {
    public static final TokenResponseCreator CREATOR = new TokenResponseCreator();
    Account account;
    @Deprecated
    String accountName;
    String firstName;
    String lastName;
    int title;
    final int version;
    @Deprecated
    String zzaaC;
    String zzaah;
    String zzaaj;
    CaptchaChallenge zzaak;
    String zzabA;
    String zzabB;
    boolean zzabC;
    boolean zzabD;
    boolean zzabE;
    boolean zzabF;
    List<ScopeDetail> zzabG;
    boolean zzabH;
    PostSignInData zzabI;
    String zzabJ;
    TokenData zzabK;
    Bundle zzabL;
    String zzabh;
    String zzabm;
    String zzaby;

    public TokenResponse() {
        this.zzabL = new Bundle();
        this.version = 6;
        this.zzabG = new ArrayList();
    }

    TokenResponse(int version, String accountName, String statusWireCode, String token, String signInUrl, String detail, String picasaUser, String firstName, String lastName, boolean isGPlusServiceAllowed, boolean isGPlusServiceEnabled, boolean isEsMobileServiceEnabled, boolean isBrowserSignInSuggested, CaptchaChallenge captcha, List<ScopeDetail> list, String ropText, String ropRevision, boolean hasTitle, int title, PostSignInData postSignInData, Account account, String dmStatus, TokenData tokenData, Bundle dataForLogging, String consentCookieWrapper) {
        this.zzabL = new Bundle();
        this.version = version;
        this.zzaah = statusWireCode;
        this.zzaaC = token;
        this.zzabA = signInUrl;
        this.zzaaj = detail;
        this.zzabB = picasaUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.zzabC = isGPlusServiceAllowed;
        this.zzabD = isGPlusServiceEnabled;
        this.zzabE = isEsMobileServiceEnabled;
        this.zzabF = isBrowserSignInSuggested;
        this.zzaak = captcha;
        if (list == null) {
            list = new ArrayList();
        }
        this.zzabG = list;
        this.zzabm = ropText;
        this.zzabh = ropRevision;
        this.zzabH = hasTitle;
        this.title = title;
        this.zzabI = postSignInData;
        this.zzabJ = dmStatus;
        this.zzabL = dataForLogging;
        this.zzaby = consentCookieWrapper;
        if (account != null) {
            setAccount(account);
        } else {
            setAccountName(accountName);
        }
        if (token != null) {
            zza(new zza().zzbq(token).zzkl());
        } else {
            zza(tokenData);
        }
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.account;
    }

    @Deprecated
    public String getAccountName() {
        Account account = getAccount();
        return account == null ? null : account.name;
    }

    public CaptchaChallenge getCaptchaChallenge() {
        return this.zzaak;
    }

    public String getDetail() {
        return this.zzaaj;
    }

    @Nullable
    public String getDmStatus() {
        return this.zzabJ;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPicasaUser() {
        return this.zzabB;
    }

    public PostSignInData getPostSignInData() {
        return this.zzabI;
    }

    public String getRopRevision() {
        return this.zzabh;
    }

    public String getRopText() {
        return this.zzabm;
    }

    public List<ScopeDetail> getScopeData() {
        return Collections.unmodifiableList(this.zzabG);
    }

    public String getSignInUrl() {
        return this.zzabA;
    }

    public Status getStatus() {
        return Status.fromWireCode(this.zzaah);
    }

    public int getTitle() {
        return this.title;
    }

    public String getToken() {
        return this.zzaaC;
    }

    public boolean hasTitle() {
        return this.zzabH;
    }

    public boolean isBrowserSignInSuggested() {
        return this.zzabF;
    }

    public boolean isEsMobileServiceEnabled() {
        return this.zzabE;
    }

    public boolean isGPlusServiceAllowed() {
        return this.zzabC;
    }

    public boolean isGPlusServiceEnabled() {
        return this.zzabD;
    }

    public TokenResponse setAccount(Account account) {
        this.account = (Account) zzx.zzb((Object) account, (Object) "Account can't be null.");
        this.accountName = account.name;
        return this;
    }

    @Deprecated
    public TokenResponse setAccountName(String accountName) {
        if (!TextUtils.isEmpty(accountName)) {
            return setAccount(new Account(accountName, "com.google"));
        }
        this.accountName = null;
        this.account = null;
        return this;
    }

    public TokenResponse setBrowserSignInSuggested(boolean isSuggested) {
        this.zzabF = isSuggested;
        return this;
    }

    public TokenResponse setCaptchaChallenge(CaptchaChallenge challenge) {
        this.zzaak = challenge;
        return this;
    }

    public TokenResponse setDetail(String detail) {
        this.zzaaj = detail;
        return this;
    }

    public TokenResponse setDmStatus(String dmStatus) {
        this.zzabJ = dmStatus;
        return this;
    }

    public TokenResponse setEsMobileServiceEnabled(boolean isEnabled) {
        this.zzabE = isEnabled;
        return this;
    }

    public TokenResponse setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public TokenResponse setGPlusServiceAllowed(boolean isAllowed) {
        this.zzabC = isAllowed;
        return this;
    }

    public TokenResponse setGPlusServiceEnabled(boolean isEnabled) {
        this.zzabD = isEnabled;
        return this;
    }

    public TokenResponse setHasTitle(boolean hasTitle) {
        this.zzabH = hasTitle;
        return this;
    }

    public TokenResponse setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public TokenResponse setPicasaUser(String picasaUser) {
        this.zzabB = picasaUser;
        return this;
    }

    public TokenResponse setPostSignInData(PostSignInData postSignInData) {
        this.zzabI = postSignInData;
        return this;
    }

    public TokenResponse setRopRevision(String ropRevision) {
        this.zzabh = ropRevision;
        return this;
    }

    public TokenResponse setRopText(String ropText) {
        this.zzabm = ropText;
        return this;
    }

    public TokenResponse setScopeData(List<ScopeDetail> scopeData) {
        this.zzabG.clear();
        this.zzabG.addAll(scopeData);
        return this;
    }

    public TokenResponse setSignInUrl(String url) {
        this.zzabA = url;
        return this;
    }

    public TokenResponse setStatus(Status status) {
        this.zzaah = ((Status) zzx.zzD(status)).getWire();
        return this;
    }

    public TokenResponse setTitle(int title) {
        this.title = title;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        TokenResponseCreator.zza(this, dest, flags);
    }

    public TokenResponse zza(TokenData tokenData) {
        if (tokenData == null) {
            this.zzaaC = null;
            this.zzabK = null;
        } else {
            this.zzaaC = tokenData.getToken();
            this.zzabK = tokenData;
        }
        return this;
    }
}

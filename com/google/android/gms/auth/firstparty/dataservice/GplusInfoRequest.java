package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GplusInfoRequest implements SafeParcelable {
    public static final GplusInfoRequestCreator CREATOR = new GplusInfoRequestCreator();
    Account account;
    String accountName;
    final int version;
    CaptchaSolution zzaaf;

    public GplusInfoRequest() {
        this.version = 2;
    }

    GplusInfoRequest(int version, String accountName, CaptchaSolution optionalCaptchaSolution, Account account) {
        this.version = version;
        this.accountName = accountName;
        this.zzaaf = optionalCaptchaSolution;
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

    public CaptchaSolution getCaptchaSolution() {
        return this.zzaaf;
    }

    public GplusInfoRequest setAccount(Account account) {
        this.account = account;
        return this;
    }

    public GplusInfoRequest setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public GplusInfoRequest setCaptchaSolution(CaptchaSolution captchaSolution) {
        this.zzaaf = captchaSolution;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        GplusInfoRequestCreator.zza(this, dest, flags);
    }
}

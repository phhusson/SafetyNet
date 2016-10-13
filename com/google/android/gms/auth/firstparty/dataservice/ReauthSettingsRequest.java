package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReauthSettingsRequest implements SafeParcelable {
    public static final ReauthSettingsRequestCreator CREATOR = new ReauthSettingsRequestCreator();
    public final Account account;
    @Deprecated
    public final String accountName;
    public String callingPackageName;
    public final boolean force;
    final int version;

    ReauthSettingsRequest(int version, String accountName, boolean force, Account account, String callingPackageName) {
        this.version = version;
        this.accountName = accountName;
        this.force = force;
        if (account != null || TextUtils.isEmpty(accountName)) {
            this.account = account;
        } else {
            this.account = new Account(accountName, "com.google");
        }
        this.callingPackageName = callingPackageName;
    }

    public ReauthSettingsRequest(Account account, boolean force) {
        this(3, null, force, account, null);
    }

    @Deprecated
    public ReauthSettingsRequest(String accountName, boolean force) {
        this(3, accountName, force, null, null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ReauthSettingsRequestCreator.zza(this, dest, flags);
    }

    void zzbQ(String str) {
        this.callingPackageName = str;
    }
}

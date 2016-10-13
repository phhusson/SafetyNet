package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class VerifyPinRequest implements SafeParcelable {
    public static final VerifyPinRequestCreator CREATOR = new VerifyPinRequestCreator();
    public final Account account;
    @Deprecated
    public final String accountName;
    public String callingPackageName;
    public final String pin;
    final int version;

    VerifyPinRequest(int version, String accountName, String pin, Account account, String callingPackageName) {
        this.version = version;
        this.accountName = accountName;
        this.pin = pin;
        if (account != null || TextUtils.isEmpty(accountName)) {
            this.account = account;
        } else {
            this.account = new Account(accountName, "com.google");
        }
        this.callingPackageName = callingPackageName;
    }

    public VerifyPinRequest(Account account, String pin) {
        this(3, null, pin, account, null);
    }

    @Deprecated
    public VerifyPinRequest(String accountName, String pin) {
        this(3, accountName, pin, null, null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        VerifyPinRequestCreator.zza(this, dest, flags);
    }

    void zzbQ(String str) {
        this.callingPackageName = str;
    }
}

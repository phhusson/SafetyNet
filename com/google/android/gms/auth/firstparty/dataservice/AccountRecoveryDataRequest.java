package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class AccountRecoveryDataRequest implements SafeParcelable {
    public static final AccountRecoveryDataRequestCreator CREATOR = new AccountRecoveryDataRequestCreator();
    private static final String zzaav = ("[" + AccountRecoveryDataRequest.class.getSimpleName() + "]");
    public final Account account;
    @Deprecated
    public final String accountName;
    public final AppDescription callingAppDescription;
    public final boolean isClearUpdateSuggested;
    public final String requestDescription;
    final int version;

    AccountRecoveryDataRequest(int version, String accountName, boolean isClearUpdateSuggestion, AppDescription callingAppDescription, String requestDescription, Account account) {
        this.accountName = zzx.zzi(accountName, zzaav + " accountName cannot be empty or null!");
        zzx.zzi(requestDescription, zzaav + " requestDescription cannot be empty or null!");
        this.version = version;
        this.isClearUpdateSuggested = isClearUpdateSuggestion;
        this.callingAppDescription = (AppDescription) zzx.zzD(callingAppDescription);
        this.requestDescription = requestDescription;
        if (account != null || TextUtils.isEmpty(accountName)) {
            this.account = account;
        } else {
            this.account = new Account(accountName, "com.google");
        }
        zzx.zzD(this.account);
    }

    public AccountRecoveryDataRequest(Account account, boolean isClearUpdateSuggestion, AppDescription callingAppDescription, String requestDescription) {
        this(1, account.name, isClearUpdateSuggestion, callingAppDescription, requestDescription, account);
    }

    public AccountRecoveryDataRequest(String accountName, boolean isClearUpdateSuggestion, AppDescription callingAppDescription, String requestDescription) {
        this(new Account(accountName, "com.google"), isClearUpdateSuggestion, callingAppDescription, requestDescription);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountRecoveryDataRequestCreator.zza(this, dest, flags);
    }
}

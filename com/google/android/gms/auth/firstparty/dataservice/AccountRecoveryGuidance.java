package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class AccountRecoveryGuidance implements SafeParcelable {
    public static final AccountRecoveryGuidanceCreator CREATOR = new AccountRecoveryGuidanceCreator();
    public final Account account;
    @Deprecated
    public final String accountName;
    public final boolean isRecoveryInfoNeeded;
    public final boolean isRecoveryInterstitialSuggested;
    public final boolean isRecoveryUpdateAllowed;
    final int version;

    AccountRecoveryGuidance(int version, String accountName, boolean isRecoveryInfoNeeded, boolean isRecoveryInterstitialSuggested, boolean isRecoveryInterstitialAllowed, Account account) {
        this.version = version;
        this.accountName = accountName;
        this.isRecoveryInfoNeeded = isRecoveryInfoNeeded;
        this.isRecoveryInterstitialSuggested = isRecoveryInterstitialSuggested;
        this.isRecoveryUpdateAllowed = isRecoveryInterstitialAllowed;
        if (account != null || TextUtils.isEmpty(accountName)) {
            this.account = account;
        } else {
            this.account = new Account(accountName, "com.google");
        }
    }

    public AccountRecoveryGuidance(Account account, boolean isRecoveryInfoNeeded, boolean isRecoveryInterstitialSuggested, boolean isRecoveryInterstitialAllowed) {
        this(1, zzx.zzcL(account.name), isRecoveryInfoNeeded, isRecoveryInterstitialSuggested, isRecoveryInterstitialAllowed, account);
    }

    @Deprecated
    public AccountRecoveryGuidance(String accountName, boolean isRecoveryInfoNeeded, boolean isRecoveryInterstitialSuggested, boolean isRecoveryInterstitialAllowed) {
        this(new Account(accountName, "com.google"), isRecoveryInfoNeeded, isRecoveryInterstitialSuggested, isRecoveryInterstitialAllowed);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountRecoveryGuidanceCreator.zza(this, dest, flags);
    }
}

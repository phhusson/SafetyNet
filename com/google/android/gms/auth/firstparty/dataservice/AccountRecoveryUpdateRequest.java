package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.RecoveryResponse;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountRecoveryUpdateRequest implements RecoveryResponse, SafeParcelable {
    public static final AccountRecoveryUpdateRequestCreator CREATOR = new AccountRecoveryUpdateRequestCreator();
    public final Account account;
    public final String accountName;
    public final AppDescription callingAppDescription;
    public final boolean isBroadUse;
    public final String phoneCountryCode;
    public final String phoneNumber;
    public final String secondaryEmail;
    final int version;

    public static class Builder {
        private String zzaao;
        private String zzaap;
        private String zzaaq;
        private Account zzaau;
        private String zzaaw;
        private boolean zzaax;
        private AppDescription zzaay;

        public AccountRecoveryUpdateRequest build() {
            return new AccountRecoveryUpdateRequest(1, this.zzaao, this.zzaap, this.zzaaq, this.zzaaw, this.zzaax, this.zzaay, this.zzaau);
        }

        public Builder setAccount(Account account) {
            this.zzaau = account;
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.zzaao = accountName;
            return this;
        }

        public Builder setBroadUse(boolean isBroadUse) {
            this.zzaax = isBroadUse;
            return this;
        }

        public Builder setCallingAppDescription(AppDescription appDescription) {
            this.zzaay = appDescription;
            return this;
        }

        public Builder setPhoneCountryCode(String countryCode) {
            this.zzaaw = countryCode;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.zzaaq = phoneNumber;
            return this;
        }

        public Builder setSecondaryEmail(String secondaryEmail) {
            this.zzaap = secondaryEmail;
            return this;
        }
    }

    AccountRecoveryUpdateRequest(int version, String accountName, String secondaryEmail, String phoneNumber, String phoneCountryCode, boolean isBroadUse, AppDescription callingAppDescription, Account account) {
        this.version = version;
        this.accountName = accountName;
        this.secondaryEmail = secondaryEmail;
        this.phoneNumber = phoneNumber;
        this.phoneCountryCode = phoneCountryCode;
        this.isBroadUse = isBroadUse;
        this.callingAppDescription = callingAppDescription;
        if (account != null || TextUtils.isEmpty(accountName)) {
            this.account = account;
        } else {
            this.account = new Account(accountName, "com.google");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountRecoveryUpdateRequestCreator.zza(this, dest, flags);
    }
}

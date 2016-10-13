package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.Country;
import com.google.android.gms.auth.RecoveryResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountRecoveryData implements RecoveryResponse, SafeParcelable {
    public static final int ACTION_NONE = 3;
    public static final int ACTION_REQUEST_RECOVERY_INFO = 1;
    public static final int ACTION_VERIFY_RECOVERY_INFO = 2;
    public static final AccountRecoveryDataCreator CREATOR = new AccountRecoveryDataCreator();
    public static final int DETAIL_EMAIL_AND_PHONE = 1003;
    public static final int DETAIL_EMAIL_ONLY = 1001;
    public static final int DETAIL_PHONE_ONLY = 1002;
    public final Account account;
    @Deprecated
    public final String accountName;
    public final String action;
    public final String allowedRecoveryOption;
    public final List<Country> countries;
    public final String defaultCountryCode;
    public final String error;
    public final AccountRecoveryGuidance guidance;
    public final String phoneNumber;
    public final String secondaryEmail;
    public final int version;

    public static class Builder {
        private AccountRecoveryGuidance zzaal;
        private String zzaam;
        private String zzaan;
        private String zzaao;
        private String zzaap;
        private String zzaaq;
        private List<Country> zzaar;
        private String zzaas;
        private String zzaat;
        private Account zzaau;

        public AccountRecoveryData build() {
            return new AccountRecoveryData(1, this.zzaal, this.zzaam, this.zzaan, this.zzaao, this.zzaap, this.zzaaq, this.zzaar, this.zzaas, this.zzaat, this.zzaau);
        }

        public Builder setAccount(Account account) {
            this.zzaau = account;
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.zzaao = accountName;
            return this;
        }

        public Builder setAccountRecoveryGuidance(AccountRecoveryGuidance guidance) {
            this.zzaal = guidance;
            return this;
        }

        public Builder setAction(String action) {
            this.zzaam = action;
            return this;
        }

        public Builder setAllowedRecoveryOption(String detail) {
            this.zzaan = detail;
            return this;
        }

        public Builder setCountryList(List<Country> countryList) {
            this.zzaar = Collections.unmodifiableList(new ArrayList(countryList));
            return this;
        }

        public Builder setDefaultCountryCode(String countryCode) {
            this.zzaas = countryCode;
            return this;
        }

        public Builder setError(String error) {
            this.zzaat = error;
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

    AccountRecoveryData(int version, AccountRecoveryGuidance guidance, String action, String detail, String accountName, String secondaryEmail, String phoneNumber, List<Country> countries, String defaultCountryCode, String error, Account account) {
        this.version = version;
        this.guidance = guidance;
        this.action = action;
        this.allowedRecoveryOption = detail;
        this.accountName = accountName;
        this.secondaryEmail = secondaryEmail;
        this.phoneNumber = phoneNumber;
        this.countries = countries == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(countries);
        this.defaultCountryCode = defaultCountryCode;
        this.error = error;
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
        AccountRecoveryDataCreator.zza(this, dest, flags);
    }
}

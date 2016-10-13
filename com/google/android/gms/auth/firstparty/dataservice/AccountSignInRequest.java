package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountSignInRequest implements SafeParcelable {
    public static final AccountSignInRequestCreator CREATOR = new AccountSignInRequestCreator();
    AppDescription callingAppDescription;
    final int version;
    boolean zzaaA;
    AccountCredentials zzaaB;
    CaptchaSolution zzaaf;
    boolean zzaaz;

    public AccountSignInRequest() {
        this.version = 1;
    }

    AccountSignInRequest(int version, AppDescription callingAppDescription, boolean isCreatingAccount, boolean isSetupWizardInProgress, CaptchaSolution optionalCaptchaSolution, AccountCredentials accountCredentials) {
        this.version = version;
        this.callingAppDescription = callingAppDescription;
        this.zzaaz = isCreatingAccount;
        this.zzaaA = isSetupWizardInProgress;
        this.zzaaf = optionalCaptchaSolution;
        this.zzaaB = accountCredentials;
    }

    public int describeContents() {
        return 0;
    }

    public AccountCredentials getAccountCredentials() {
        return this.zzaaB;
    }

    public AppDescription getCallingAppDescription() {
        return this.callingAppDescription;
    }

    public CaptchaSolution getCaptchaSolution() {
        return this.zzaaf;
    }

    public boolean isAccountCreationInProgress() {
        return this.zzaaz;
    }

    public boolean isSetupWizardInProgress() {
        return this.zzaaA;
    }

    public AccountSignInRequest setAccountCreationInProgress(boolean isCreating) {
        this.zzaaz = isCreating;
        return this;
    }

    public AccountSignInRequest setAccountCredentials(AccountCredentials credentials) {
        this.zzaaB = credentials;
        return this;
    }

    public AccountSignInRequest setBackupAccount(boolean isBackupAccount) {
        this.zzaaA = isBackupAccount;
        return this;
    }

    public AccountSignInRequest setCallingAppDescription(AppDescription appDescription) {
        this.callingAppDescription = appDescription;
        return this;
    }

    public AccountSignInRequest setCaptchaSolution(CaptchaSolution captchaSolution) {
        this.zzaaf = captchaSolution;
        return this;
    }

    @Deprecated
    public AccountSignInRequest setSetupWizardInProgress(boolean isInProgress) {
        this.zzaaA = isInProgress;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountSignInRequestCreator.zza(this, dest, flags);
    }
}

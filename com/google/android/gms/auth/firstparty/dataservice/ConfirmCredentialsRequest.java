package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConfirmCredentialsRequest implements SafeParcelable {
    public static final ConfirmCredentialsRequestCreator CREATOR = new ConfirmCredentialsRequestCreator();
    final int version;
    AccountCredentials zzaaB;
    CaptchaSolution zzaaf;

    public ConfirmCredentialsRequest() {
        this.version = 1;
    }

    ConfirmCredentialsRequest(int version, AccountCredentials accountCredentials, CaptchaSolution optionalCaptchaSolution) {
        this.version = version;
        this.zzaaB = accountCredentials;
        this.zzaaf = optionalCaptchaSolution;
    }

    public int describeContents() {
        return 0;
    }

    public AccountCredentials getAccountCredentials() {
        return this.zzaaB;
    }

    public CaptchaSolution getCaptchaSolution() {
        return this.zzaaf;
    }

    public ConfirmCredentialsRequest setAccountCredentials(AccountCredentials accountCredentials) {
        this.zzaaB = accountCredentials;
        return this;
    }

    public ConfirmCredentialsRequest setCaptchaSolution(CaptchaSolution captchaSolution) {
        this.zzaaf = captchaSolution;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ConfirmCredentialsRequestCreator.zza(this, dest, flags);
    }
}

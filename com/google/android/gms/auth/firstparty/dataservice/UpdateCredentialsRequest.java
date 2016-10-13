package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UpdateCredentialsRequest implements SafeParcelable {
    public static final UpdateCredentialsRequestCreator CREATOR = new UpdateCredentialsRequestCreator();
    final int version;
    AccountCredentials zzaaB;
    CaptchaSolution zzaaf;

    public UpdateCredentialsRequest() {
        this.version = 1;
    }

    UpdateCredentialsRequest(int version, AccountCredentials accountCredentials, CaptchaSolution optionalCaptchaSolution) {
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

    public UpdateCredentialsRequest setAccountCredentials(AccountCredentials accountCredentials) {
        this.zzaaB = accountCredentials;
        return this;
    }

    public UpdateCredentialsRequest setCaptchaSolution(CaptchaSolution captchaSolution) {
        this.zzaaf = captchaSolution;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        UpdateCredentialsRequestCreator.zza(this, dest, flags);
    }
}

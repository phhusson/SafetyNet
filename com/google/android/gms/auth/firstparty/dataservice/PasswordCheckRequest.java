package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PasswordCheckRequest implements SafeParcelable {
    public static final PasswordCheckRequestCreator CREATOR = new PasswordCheckRequestCreator();
    String accountName;
    String password;
    final int version;
    String zzaad;
    String zzaae;
    AppDescription zzabo;

    PasswordCheckRequest(int version, String accountName, String password, String optionalFirstName, String optionalLastName, AppDescription appDescription) {
        this.version = version;
        this.accountName = accountName;
        this.password = password;
        this.zzaad = optionalFirstName;
        this.zzaae = optionalLastName;
        this.zzabo = appDescription;
    }

    public PasswordCheckRequest(String accountName, String passwordToCheck) {
        this.version = 1;
        this.accountName = accountName;
        this.password = passwordToCheck;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public AppDescription getCallingAppDescription() {
        return this.zzabo;
    }

    public String getFirstName() {
        return this.zzaad;
    }

    public String getLastName() {
        return this.zzaae;
    }

    public String getPassword() {
        return this.password;
    }

    public PasswordCheckRequest setCallingAppDescription(AppDescription appDescription) {
        this.zzabo = appDescription;
        return this;
    }

    public PasswordCheckRequest setFirstName(String optionalFirstName) {
        this.zzaad = optionalFirstName;
        return this;
    }

    public PasswordCheckRequest setLastName(String optionalLastName) {
        this.zzaae = optionalLastName;
        return this;
    }

    public PasswordCheckRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        PasswordCheckRequestCreator.zza(this, dest, flags);
    }
}

package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PasswordSettings implements SafeParcelable {
    public static final PasswordSettingsCreator CREATOR = new PasswordSettingsCreator();
    public final String status;
    final int version;

    PasswordSettings(int version, String status) {
        this.version = version;
        this.status = status;
    }

    public PasswordSettings(String status) {
        this(1, status);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        PasswordSettingsCreator.zza(this, dest, flags);
    }
}

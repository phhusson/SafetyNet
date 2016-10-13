package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PinSettings implements SafeParcelable {
    public static final PinSettingsCreator CREATOR = new PinSettingsCreator();
    public final int length;
    public final String recoveryUrl;
    public final String resetUrl;
    public final String setupUrl;
    public final String status;
    final int version;

    PinSettings(int version, String status, String resetUrl, String setupUrl, String recoveryUrl, int length) {
        this.version = version;
        this.status = status;
        this.resetUrl = resetUrl;
        this.setupUrl = setupUrl;
        this.recoveryUrl = recoveryUrl;
        this.length = length;
    }

    public PinSettings(String status, String resetUrl, String setupUrl, String recoveryUrl, int length) {
        this(2, status, resetUrl, setupUrl, recoveryUrl, length);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        PinSettingsCreator.zza(this, dest, flags);
    }
}

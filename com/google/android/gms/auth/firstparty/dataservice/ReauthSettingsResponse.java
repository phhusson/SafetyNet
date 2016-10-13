package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReauthSettingsResponse implements SafeParcelable {
    public static final ReauthSettingsResponseCreator CREATOR = new ReauthSettingsResponseCreator();
    public static final String CREDENTIAL_STATUS_ACTIVE = "ACTIVE";
    public static final String CREDENTIAL_STATUS_CONFIGURABLE = "CONFIGURABLE";
    public static final String CREDENTIAL_STATUS_LOCKED = "LOCKED";
    public final PasswordSettings password;
    public final PinSettings pin;
    public final int status;
    final int version;

    public ReauthSettingsResponse(int errorStatus) {
        this(1, errorStatus, null, null);
    }

    ReauthSettingsResponse(int version, int status, PasswordSettings password, PinSettings pin) {
        this.version = version;
        this.status = status;
        this.password = password;
        this.pin = pin;
    }

    public ReauthSettingsResponse(PasswordSettings password, PinSettings pin) {
        this(1, 0, password, pin);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ReauthSettingsResponseCreator.zza(this, dest, flags);
    }
}

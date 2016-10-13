package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class OtpRequest implements SafeParcelable {
    public static final OtpRequestCreator CREATOR = new OtpRequestCreator();
    public final String accountName;
    public final AppDescription callerDescription;
    public final byte[] challenge;
    public final boolean isLegacyRequest;
    final int mVersion;

    OtpRequest(int version, String accountName, AppDescription callerDescription, byte[] challenge, boolean isLegacyRequest) {
        this.mVersion = version;
        this.accountName = accountName;
        this.challenge = challenge;
        this.callerDescription = (AppDescription) zzx.zzb((Object) callerDescription, (Object) "Caller's app description cannot be null!");
        this.isLegacyRequest = isLegacyRequest;
    }

    public OtpRequest(String accountName, AppDescription appDescription) {
        this(1, accountName, appDescription, null, false);
    }

    public OtpRequest(String accountName, AppDescription appDescription, byte[] challenge) {
        this(1, accountName, appDescription, challenge, false);
    }

    public static OtpRequest newLegacyOtpRequest(String accountName, AppDescription appDescription) {
        return new OtpRequest(1, accountName, appDescription, null, true);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        OtpRequestCreator.zza(this, dest, flags);
    }
}

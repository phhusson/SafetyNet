package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class WebSetupConfigRequest implements SafeParcelable {
    public static final WebSetupConfigRequestCreator CREATOR = new WebSetupConfigRequestCreator();
    public final AppDescription callingAppDescription;
    final int version;

    WebSetupConfigRequest(int version, AppDescription callingAppDescription) {
        this.version = version;
        this.callingAppDescription = (AppDescription) zzx.zzD(callingAppDescription);
    }

    public WebSetupConfigRequest(AppDescription callingAppDescription) {
        this(1, callingAppDescription);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        WebSetupConfigRequestCreator.zza(this, dest, flags);
    }
}

package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class WebSetupConfig implements SafeParcelable {
    public static final WebSetupConfigCreator CREATOR = new WebSetupConfigCreator();
    public final String url;
    final int version;

    WebSetupConfig(int version, String url) {
        this.version = version;
        this.url = url;
    }

    public WebSetupConfig(String url) {
        this(1, url);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        WebSetupConfigCreator.zza(this, dest, flags);
    }
}

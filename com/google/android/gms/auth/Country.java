package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Country implements SafeParcelable {
    public static final CountryCreator CREATOR = new CountryCreator();
    public String mCode;
    public String mName;
    final int mVersionCode;

    public Country() {
        this.mVersionCode = 1;
    }

    Country(int versionCode, String name, String code) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.mCode = code;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        CountryCreator.zza(this, out, flags);
    }
}

package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.Phone;

public class PhoneImpl implements SafeParcelable, Phone {
    public static final Creator<PhoneImpl> CREATOR = new zzp();
    final String mValue;
    final int mVersionCode;

    PhoneImpl(int versionCode, String value) {
        this.mVersionCode = versionCode;
        this.mValue = value;
    }

    public int describeContents() {
        return 0;
    }

    public CharSequence getValue() {
        return this.mValue;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzp.zza(this, dest, flags);
    }
}

package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.Email;

public class EmailImpl implements SafeParcelable, Email {
    public static final Creator<EmailImpl> CREATOR = new zzi();
    final String mValue;
    final int mVersionCode;

    EmailImpl(int versionCode, String value) {
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
        zzi.zza(this, dest, flags);
    }
}

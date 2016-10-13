package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.ContactGroupName;

public class ContactGroupNameImpl implements SafeParcelable, ContactGroupName {
    public static final Creator<ContactGroupNameImpl> CREATOR = new zze();
    final String mValue;
    final int mVersionCode;
    final String zzaWt;

    ContactGroupNameImpl(int versionCode, String value, String formattedValue) {
        this.mVersionCode = versionCode;
        this.mValue = value;
        this.zzaWt = formattedValue;
    }

    public int describeContents() {
        return 0;
    }

    public CharSequence getFormattedValue() {
        return this.zzaWt;
    }

    public CharSequence getValue() {
        return this.mValue;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}

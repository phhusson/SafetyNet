package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.Name;

public class NameImpl implements SafeParcelable, Name {
    public static final Creator<NameImpl> CREATOR = new zzk();
    final int mVersionCode;
    final String zzVA;

    NameImpl(int versionCode, String displayName) {
        this.mVersionCode = versionCode;
        this.zzVA = displayName;
    }

    public int describeContents() {
        return 0;
    }

    public CharSequence getDisplayName() {
        return this.zzVA;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}

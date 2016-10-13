package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableLoadContactGroupFieldsOptions implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    final int mVersionCode;
    final String zzbIl;

    ParcelableLoadContactGroupFieldsOptions(int versionCode, String contactGroupId) {
        this.mVersionCode = versionCode;
        this.zzbIl = contactGroupId;
    }

    public ParcelableLoadContactGroupFieldsOptions(String contactGroupId) {
        this(1, contactGroupId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }
}

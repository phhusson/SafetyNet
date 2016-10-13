package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.Substring;

public class SubstringImpl implements SafeParcelable, Substring {
    public static final Creator<SubstringImpl> CREATOR = new zzr();
    final int mLength;
    final int mVersionCode;
    final int zzbIr;

    SubstringImpl(int versionCode, int startIndex, int length) {
        this.mVersionCode = versionCode;
        this.zzbIr = startIndex;
        this.mLength = length;
    }

    public int describeContents() {
        return 0;
    }

    public int getLength() {
        return this.mLength;
    }

    public int getStartIndex() {
        return this.zzbIr;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzr.zza(this, dest, flags);
    }
}

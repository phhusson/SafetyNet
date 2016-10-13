package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.DisplayableField;
import com.google.android.gms.people.Autocomplete.Substring;

public class DisplayableFieldImpl implements SafeParcelable, DisplayableField {
    public static final Creator<DisplayableFieldImpl> CREATOR = new zzh();
    final int mIndex;
    final String mValue;
    final int mVersionCode;
    final int zzUO;
    final SubstringImpl[] zzbIj;

    DisplayableFieldImpl(int versionCode, int type, int index, String value, SubstringImpl[] matchingSubstrings) {
        this.mVersionCode = versionCode;
        this.zzUO = type;
        this.mIndex = index;
        this.mValue = value;
        this.zzbIj = matchingSubstrings;
    }

    public int describeContents() {
        return 0;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public Substring[] getMatchingSubstrings() {
        return this.zzbIj;
    }

    public int getType() {
        return this.zzUO;
    }

    public CharSequence getValue() {
        return this.mValue;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}

package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.ContactPreferredFields;
import com.google.android.gms.people.Autocomplete.GroupExtendedData;

public class GroupExtendedDataImpl implements SafeParcelable, GroupExtendedData {
    public static final Creator<GroupExtendedDataImpl> CREATOR = new zzj();
    final int mVersionCode;
    final ContactPreferredFieldsEntity[] zzbIk;

    GroupExtendedDataImpl(int versionCode, ContactPreferredFieldsEntity[] contactPreferences) {
        this.mVersionCode = versionCode;
        this.zzbIk = contactPreferences;
    }

    public int describeContents() {
        return 0;
    }

    public ContactPreferredFields[] getContactPreferences() {
        return this.zzbIk;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}

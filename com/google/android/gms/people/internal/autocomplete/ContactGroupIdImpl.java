package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.ContactGroupId;

public class ContactGroupIdImpl implements SafeParcelable, ContactGroupId {
    public static final Creator<ContactGroupIdImpl> CREATOR = new zzc();
    final int mVersionCode;
    final String[] zzbIe;
    final String zzyU;

    ContactGroupIdImpl(int versionCode, String id, String[] legacyId) {
        this.mVersionCode = versionCode;
        this.zzyU = id;
        this.zzbIe = legacyId;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzyU;
    }

    public String[] getLegacyId() {
        return this.zzbIe;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}

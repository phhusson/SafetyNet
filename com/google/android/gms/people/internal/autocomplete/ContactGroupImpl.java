package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.ContactGroup;
import com.google.android.gms.people.Autocomplete.ContactGroupId;
import com.google.android.gms.people.Autocomplete.ContactGroupName;
import com.google.android.gms.people.Autocomplete.GroupExtendedData;

public class ContactGroupImpl implements SafeParcelable, ContactGroup {
    public static final Creator<ContactGroupImpl> CREATOR = new zzd();
    final int mVersionCode;
    final ContactGroupIdImpl zzbIf;
    final ContactGroupNameImpl zzbIg;
    final GroupExtendedDataImpl zzbIh;
    final int zzbIi;

    ContactGroupImpl(int versionCode, ContactGroupIdImpl id, ContactGroupNameImpl name, GroupExtendedDataImpl extendedData, int memberCount) {
        this.mVersionCode = versionCode;
        this.zzbIg = name;
        this.zzbIf = id;
        this.zzbIh = extendedData;
        this.zzbIi = memberCount;
    }

    public int describeContents() {
        return 0;
    }

    public GroupExtendedData getExtendedData() {
        return this.zzbIh;
    }

    public ContactGroupId getId() {
        return this.zzbIf;
    }

    public int getMemberCount() {
        return this.zzbIi;
    }

    public ContactGroupName getName() {
        return this.zzbIg;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}

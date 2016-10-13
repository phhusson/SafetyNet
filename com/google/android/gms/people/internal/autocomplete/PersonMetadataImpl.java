package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.PersonMetadata;

public class PersonMetadataImpl implements SafeParcelable, PersonMetadata {
    public static final Creator<PersonMetadataImpl> CREATOR = new zzo();
    final int mVersionCode;
    final String zzbDm;

    PersonMetadataImpl(int versionCode, String ownerId) {
        this.mVersionCode = versionCode;
        this.zzbDm = ownerId;
    }

    public int describeContents() {
        return 0;
    }

    public String getOwnerId() {
        return this.zzbDm;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzo.zza(this, dest, flags);
    }
}

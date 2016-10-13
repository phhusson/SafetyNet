package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.Autocompletion;
import com.google.android.gms.people.Autocomplete.ContactGroup;
import com.google.android.gms.people.Autocomplete.DisplayableField;
import com.google.android.gms.people.Autocomplete.Person;

public class AutocompletionImpl implements SafeParcelable, Autocompletion {
    public static final Creator<AutocompletionImpl> CREATOR = new zzb();
    final int mVersionCode;
    final int zzbIa;
    final PersonImpl zzbIb;
    final ContactGroupImpl zzbIc;
    final DisplayableFieldImpl[] zzbId;

    AutocompletionImpl(int versionCode, int objectType, PersonImpl person, ContactGroupImpl contactGroup, DisplayableFieldImpl[] matches) {
        this.mVersionCode = versionCode;
        this.zzbIa = objectType;
        this.zzbId = matches;
        this.zzbIb = person;
        this.zzbIc = contactGroup;
    }

    public int describeContents() {
        return 0;
    }

    public ContactGroup getContactGroup() {
        return this.zzbIc;
    }

    public DisplayableField[] getMatches() {
        return this.zzbId;
    }

    public int getObjectType() {
        return this.zzbIa;
    }

    public Person getPerson() {
        return this.zzbIb;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}

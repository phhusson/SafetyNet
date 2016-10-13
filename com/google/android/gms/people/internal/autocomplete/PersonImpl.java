package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.Email;
import com.google.android.gms.people.Autocomplete.Name;
import com.google.android.gms.people.Autocomplete.Person;
import com.google.android.gms.people.Autocomplete.PersonMetadata;
import com.google.android.gms.people.Autocomplete.Phone;
import com.google.android.gms.people.Autocomplete.Photo;

public class PersonImpl implements SafeParcelable, Person {
    public static final Creator<PersonImpl> CREATOR = new zzn();
    final int mVersionCode;
    final PersonMetadataImpl zzbIm;
    final NameImpl[] zzbIn;
    final EmailImpl[] zzbIo;
    final PhoneImpl[] zzbIp;
    final PhotoImpl[] zzbIq;

    PersonImpl(int versionCode, PersonMetadataImpl metadata, NameImpl[] names, EmailImpl[] emails, PhoneImpl[] phones, PhotoImpl[] photos) {
        this.mVersionCode = versionCode;
        this.zzbIm = metadata;
        this.zzbIn = names;
        this.zzbIo = emails;
        this.zzbIp = phones;
        this.zzbIq = photos;
    }

    public int describeContents() {
        return 0;
    }

    public Email[] getEmails() {
        return this.zzbIo;
    }

    public PersonMetadata getMetadata() {
        return this.zzbIm;
    }

    public Name[] getNames() {
        return this.zzbIn;
    }

    public Phone[] getPhones() {
        return this.zzbIp;
    }

    public Photo[] getPhotos() {
        return this.zzbIq;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }
}

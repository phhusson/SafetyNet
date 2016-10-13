package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.ContactPreferredFields;

public class ContactPreferredFieldsEntity implements SafeParcelable, ContactPreferredFields {
    public static final Creator<ContactPreferredFieldsEntity> CREATOR = new zzf();
    final String mName;
    final int mVersionCode;
    final String zzYA;

    ContactPreferredFieldsEntity(int versionCode, String email, String name) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzYA = email;
    }

    public ContactPreferredFieldsEntity(zzg contactPreferredFieldsRef) {
        this(zzc(contactPreferredFieldsRef.getEmail()), zzc(contactPreferredFieldsRef.getName()));
    }

    public ContactPreferredFieldsEntity(String email, String name) {
        this(1, email, name);
    }

    private static String zzc(CharSequence charSequence) {
        return charSequence != null ? charSequence.toString() : null;
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return zzJX();
    }

    public CharSequence getEmail() {
        return this.zzYA;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public ContactPreferredFields zzJX() {
        return this;
    }
}

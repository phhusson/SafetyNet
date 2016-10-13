package com.google.android.gms.people.internal.autocomplete;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.people.Autocomplete.ContactPreferredFields;
import com.google.android.gms.people.PeopleConstants.ContactGroupPreferredFields;

public class zzg extends zzc implements ContactPreferredFields {
    public static final String[] zzaYa = new String[]{"email", ContactGroupPreferredFields.NAME};

    public zzg(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public /* synthetic */ Object freeze() {
        return zzJX();
    }

    public CharSequence getEmail() {
        return getString("email");
    }

    public CharSequence getName() {
        return getString(ContactGroupPreferredFields.NAME);
    }

    public ContactPreferredFields zzJX() {
        return new ContactPreferredFieldsEntity(this);
    }
}

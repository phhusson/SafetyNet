package com.google.android.gms.people.model;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.people.Autocomplete.ContactPreferredFields;
import com.google.android.gms.people.internal.autocomplete.zzg;

public class ContactGroupPreferredFieldsBuffer extends AbstractDataBuffer<ContactPreferredFields> {
    public ContactGroupPreferredFieldsBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public ContactPreferredFields get(int position) {
        return new zzg(this.zzarr, position);
    }

    public String toString() {
        return "ContactPreferredFields:size=" + getCount();
    }
}

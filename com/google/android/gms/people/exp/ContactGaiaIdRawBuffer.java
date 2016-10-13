package com.google.android.gms.people.exp;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.people.PeopleConstants.Endpoints;
import com.google.android.gms.people.model.ContactGaiaId;

public class ContactGaiaIdRawBuffer extends zza implements ContactGaiaId {
    public ContactGaiaIdRawBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public String getContactInfo() {
        return getString("value");
    }

    public String getGaiaId() {
        return getString(Endpoints.KEY_TARGET_GAIA_ID);
    }

    public int getType() {
        return getInteger("type");
    }
}

package com.google.android.gms.people.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.people.PeopleConstants.Endpoints;
import com.google.android.gms.people.model.ContactGaiaId;

public class zzd extends zzc implements ContactGaiaId {
    public zzd(DataHolder dataHolder, int i) {
        super(dataHolder, i);
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

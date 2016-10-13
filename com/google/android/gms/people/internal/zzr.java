package com.google.android.gms.people.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.people.cp2.AndroidContactsUtils;
import com.google.android.gms.people.model.PhoneNumberEntry;

public class zzr extends zzc implements PhoneNumberEntry {
    private final Context mContext;
    private final Bundle zzatO;

    public zzr(DataHolder dataHolder, int i, Bundle bundle, Context context) {
        super(dataHolder, i);
        this.zzatO = bundle;
        this.mContext = context;
    }

    public String getFocusContactId() {
        return getString("contact_id");
    }

    public Long getLastUpdateTime() {
        return Long.valueOf(getLong("last_update_time"));
    }

    public String getName() {
        return getString("display_name");
    }

    public String getOwnerAccountName() {
        return this.zzatO.getString("account");
    }

    public String getPhoneNumber() {
        return getString("phone_number");
    }

    public String getPhotoUri() {
        return AndroidContactsUtils.getPhotoUriFromFocusContactId(this.mContext, getOwnerAccountName(), getFocusContactId());
    }
}

package com.google.android.gms.people.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.people.PeopleConstants.ContactGroupPreferredFields;
import com.google.android.gms.people.model.Circle;

public final class zzc extends com.google.android.gms.common.data.zzc implements Circle {
    private final Bundle zzatO;

    public zzc(DataHolder dataHolder, int i, Bundle bundle) {
        super(dataHolder, i);
        this.zzatO = bundle;
    }

    @Deprecated
    public String getAccountName() {
        return getOwnerAccountName();
    }

    public String getCircleId() {
        return getString("circle_id");
    }

    public String getCircleName() {
        int circleType = getCircleType();
        if (circleType != -1) {
            Bundle bundle = this.zzatO.getBundle("localized_group_names");
            if (bundle != null) {
                Object string = bundle.getString(String.valueOf(circleType));
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            }
        }
        return getString(ContactGroupPreferredFields.NAME);
    }

    public int getCircleType() {
        int integer = getInteger("type");
        switch (integer) {
            case -1:
            case 1:
            case 2:
            case 3:
            case 4:
                return integer;
            default:
                return -2;
        }
    }

    public long getLastModifiedTime() {
        return getLong("last_modified");
    }

    public String getOwnerAccountName() {
        return this.zzatO.getString("account");
    }

    public String getOwnerPlusPageId() {
        return this.zzatO.getString("pagegaiaid");
    }

    public int getPeopleCount() {
        return getInteger("people_count");
    }

    @Deprecated
    public String getPlusPageGaiaId() {
        return getOwnerPlusPageId();
    }

    public long getRowId() {
        return getLong("_id");
    }

    public String getSortKey() {
        return getString("sort_key");
    }

    public int getVisibility() {
        Bundle bundle = this.zzatO.getBundle("circlevisibility");
        return (bundle != null && bundle.containsKey(getCircleId())) ? bundle.getInt(getCircleId()) : 0;
    }

    public boolean isEnabledForSharing() {
        return getBoolean("for_sharing");
    }

    public boolean isSyncToContactsEnabled() {
        return getBoolean("sync_to_contacts");
    }
}

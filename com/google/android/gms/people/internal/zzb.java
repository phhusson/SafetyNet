package com.google.android.gms.people.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.people.PeopleConstants.Endpoints;
import com.google.android.gms.people.model.AutocompleteBuffer;
import com.google.android.gms.people.model.AutocompleteEntry;
import com.google.android.gms.people.model.AvatarReference;

public class zzb extends zzc implements AutocompleteEntry {
    private final Bundle zzatO;
    private final AutocompleteBuffer zzbDX;

    public zzb(AutocompleteBuffer autocompleteBuffer, DataHolder dataHolder, int i, Bundle bundle) {
        super(dataHolder, i);
        this.zzatO = bundle;
        this.zzbDX = autocompleteBuffer;
    }

    public long getAndroidContactDataId() {
        return getLong("cp2_data_id");
    }

    public long getAndroidContactId() {
        return getLong("cp2_contact_id");
    }

    public int getAutocompleteItemType() {
        return getInteger("item_type");
    }

    public AvatarReference getAvatarReference() {
        Object string = getString("avatar_location");
        return TextUtils.isEmpty(string) ? null : new AvatarReference(getInteger("avatar_source"), string);
    }

    public int getDataSource() {
        return getInteger("data_source");
    }

    public String getFocusContactId() {
        return getString("contact_id");
    }

    public String getGaiaId() {
        return getString(Endpoints.KEY_TARGET_GAIA_ID);
    }

    public double getItemAffinity1() {
        return getDouble("item_affinity1");
    }

    public double getItemAffinity2() {
        return getDouble("item_affinity2");
    }

    public double getItemAffinity3() {
        return getDouble("item_affinity3");
    }

    public double getItemAffinity4() {
        return getDouble("item_affinity4");
    }

    public double getItemAffinity5() {
        return getDouble("item_affinity5");
    }

    public String getItemLoggingId1() {
        return getString("item_logging_id1");
    }

    public String getItemLoggingId2() {
        return getString("item_logging_id2");
    }

    public String getItemLoggingId3() {
        return getString("item_logging_id3");
    }

    public String getItemLoggingId4() {
        return getString("item_logging_id4");
    }

    public String getItemLoggingId5() {
        return getString("item_logging_id5");
    }

    public String getItemValue() {
        return getString("value");
    }

    public String getItemValueCustomLabel() {
        return getString("custom_label");
    }

    public int getItemValueType() {
        return getInteger("value_type");
    }

    public String getOwnerAccountName() {
        return getString("owner_account");
    }

    public String getOwnerPlusPageId() {
        return getString("owner_page_id");
    }

    public String getPeopleV2Id() {
        return getString("people_v2_id");
    }

    public double getPersonAffinity1() {
        return getDouble("person_affinity1");
    }

    public double getPersonAffinity2() {
        return getDouble("person_affinity2");
    }

    public double getPersonAffinity3() {
        return getDouble("person_affinity3");
    }

    public double getPersonAffinity4() {
        return getDouble("person_affinity4");
    }

    public double getPersonAffinity5() {
        return getDouble("person_affinity5");
    }

    public String getPersonDisplayName() {
        return getString("display_name");
    }

    public String getPersonKey() {
        return getString("person_key");
    }

    public String getPersonLoggingId1() {
        return getString("person_logging_id1");
    }

    public String getPersonLoggingId2() {
        return getString("person_logging_id2");
    }

    public String getPersonLoggingId3() {
        return getString("person_logging_id3");
    }

    public String getPersonLoggingId4() {
        return getString("person_logging_id4");
    }

    public String getPersonLoggingId5() {
        return getString("person_logging_id5");
    }

    public double getPrimarySortedAffinity() {
        return getDouble("primary_affinity_sorted");
    }

    public String getPrimarySortedLoggingId() {
        return getString("primary_logging_id_sorted");
    }

    public int getRowIndex() {
        return zzqv();
    }

    public double getSortedItemAffinity() {
        return getDouble("item_affinity_sorted");
    }

    public String getSortedItemLoggingId() {
        return getString("item_logging_id_sorted");
    }

    public double getSortedPersonAffinity() {
        return getDouble("person_affinity_sorted");
    }

    public String getSortedPersonLoggingId() {
        return getString("person_logging_id_sorted");
    }
}

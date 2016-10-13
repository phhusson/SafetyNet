package com.google.android.gms.people.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.people.PeopleConstants.ContactGroupPreferredFields;
import com.google.android.gms.people.PeopleConstants.Endpoints;
import com.google.android.gms.people.PeopleConstants.PeopleEmail;
import com.google.android.gms.people.internal.agg.PhoneEmailDecoder.EmailDecoder;
import com.google.android.gms.people.internal.agg.PhoneEmailDecoder.PhoneDecoder;
import com.google.android.gms.people.model.EmailAddress;
import com.google.android.gms.people.model.Person;
import com.google.android.gms.people.model.PhoneNumber;

public final class zzq extends zzc implements Person {
    public static final String[] zzaYa = new String[]{"_id", "qualified_id", Endpoints.KEY_TARGET_GAIA_ID, ContactGroupPreferredFields.NAME, "sort_key", "sort_key_irank", "avatar", "profile_type", "v_circle_ids", "blocked", "in_viewer_domain", "last_modified", "name_verified", "given_name", "family_name", PeopleEmail.AFFINITY_1, PeopleEmail.AFFINITY_2, PeopleEmail.AFFINITY_3, PeopleEmail.AFFINITY_4, PeopleEmail.AFFINITY_5, "people_in_common", "v_emails", "v_phones"};
    private final Bundle zzatO;
    private final PhoneDecoder zzbzT;
    private final EmailDecoder zzbzU;
    private final boolean zzbzV = this.zzatO.getBoolean("emails_with_affinities", false);

    public zzq(DataHolder dataHolder, int i, Bundle bundle, PhoneDecoder phoneDecoder, EmailDecoder emailDecoder) {
        super(dataHolder, i);
        this.zzatO = bundle;
        this.zzbzT = phoneDecoder;
        this.zzbzU = emailDecoder;
    }

    @Deprecated
    public String getAccountName() {
        return getOwnerAccountName();
    }

    public double getAffinity1() {
        return getDouble(PeopleEmail.AFFINITY_1);
    }

    public double getAffinity2() {
        return getDouble(PeopleEmail.AFFINITY_2);
    }

    public double getAffinity3() {
        return getDouble(PeopleEmail.AFFINITY_3);
    }

    public double getAffinity4() {
        return getDouble(PeopleEmail.AFFINITY_4);
    }

    public double getAffinity5() {
        return getDouble(PeopleEmail.AFFINITY_5);
    }

    public String getAvatarUrl() {
        return zzm.zzbEa.zzhM(getString("avatar"));
    }

    public String[] getBelongingCircleIds() {
        CharSequence string = getString("v_circle_ids");
        return TextUtils.isEmpty(string) ? zzp.zzbEP : zzp.zzbEQ.split(string, -1);
    }

    public Iterable<EmailAddress> getEmailAddresses() {
        return this.zzbzU.decode(getString("v_emails"), this.zzbzV);
    }

    public String getFamilyName() {
        return getString("family_name");
    }

    public String getGaiaId() {
        return getString(Endpoints.KEY_TARGET_GAIA_ID);
    }

    public String getGivenName() {
        return getString("given_name");
    }

    public int getInViewerDomain() {
        return getInteger("in_viewer_domain");
    }

    public String getInteractionRankSortKey() {
        return getString("sort_key_irank");
    }

    public long getLastModifiedTime() {
        return getLong("last_modified");
    }

    public String getLoggingId1() {
        return getString(PeopleEmail.LOGGING_ID_1);
    }

    public String getLoggingId2() {
        return getString(PeopleEmail.LOGGING_ID_2);
    }

    public String getLoggingId3() {
        return getString(PeopleEmail.LOGGING_ID_3);
    }

    public String getLoggingId4() {
        return getString(PeopleEmail.LOGGING_ID_4);
    }

    public String getLoggingId5() {
        return getString(PeopleEmail.LOGGING_ID_5);
    }

    public String getName() {
        return getString(ContactGroupPreferredFields.NAME);
    }

    public String getNameSortKey() {
        return getString("sort_key");
    }

    public String getOwnerAccountName() {
        return this.zzatO.getString("account");
    }

    public String getOwnerPlusPageId() {
        return this.zzatO.getString("pagegaiaid");
    }

    public Iterable<PhoneNumber> getPhoneNumbers() {
        return this.zzbzT.decode(getString("v_phones"), false);
    }

    @Deprecated
    public String getPlusPageGaiaId() {
        return getOwnerPlusPageId();
    }

    public int getProfileType() {
        return getInteger("profile_type");
    }

    public String getQualifiedId() {
        return getString("qualified_id");
    }

    public long getRowId() {
        return getLong("_id");
    }

    public boolean isBlocked() {
        return getInteger("blocked") != 0;
    }

    public boolean isNameVerified() {
        return getInteger("name_verified") != 0;
    }
}

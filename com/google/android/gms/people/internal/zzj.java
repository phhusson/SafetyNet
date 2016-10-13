package com.google.android.gms.people.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.people.PeopleConstants.Endpoints;
import com.google.android.gms.people.model.AccountMetadata;
import com.google.android.gms.people.model.Owner;

public final class zzj extends zzc implements Owner {
    public zzj(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private AccountMetadata zzJm() {
        Bundle bundle = (Bundle) this.zzarr.zzqt().getParcelable("account_metadata");
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(getClass().getClassLoader());
        return (AccountMetadata) bundle.getParcelable(getAccountName());
    }

    public Owner freeze() {
        throw new UnsupportedOperationException("Method not supported for object Owner");
    }

    @Deprecated
    public String getAccountGaiaId() {
        return getAccountId();
    }

    public String getAccountId() {
        return getString(Endpoints.KEY_TARGET_GAIA_ID);
    }

    public String getAccountName() {
        return getString("account_name");
    }

    public String getAvatarUrl() {
        return zzm.zzbEa.zzhM(getString("avatar"));
    }

    public int getCoverPhotoHeight() {
        return getInteger("cover_photo_height");
    }

    public String getCoverPhotoId() {
        return getString("cover_photo_id");
    }

    public String getCoverPhotoUrl() {
        return zzm.zzbEa.zzhM(getString("cover_photo_url"));
    }

    public int getCoverPhotoWidth() {
        return getInteger("cover_photo_width");
    }

    public String getDasherDomain() {
        return getString("dasher_domain");
    }

    public String getDisplayName() {
        Object string = getString("display_name");
        return TextUtils.isEmpty(string) ? getAccountName() : string;
    }

    public long getLastSuccessfulSyncFinishTimestamp() {
        return getLong("last_successful_sync_time");
    }

    public long getLastSyncFinishTimestamp() {
        return getLong("last_sync_finish_time");
    }

    public long getLastSyncStartTimestamp() {
        return getLong("last_sync_start_time");
    }

    public int getLastSyncStatus() {
        return getInteger("last_sync_status");
    }

    @Deprecated
    public String getPlusPageGaiaId() {
        return getPlusPageId();
    }

    public String getPlusPageId() {
        return getString("page_gaia_id");
    }

    public long getRowId() {
        return getLong("_id");
    }

    public int isDasherAccount() {
        return getInteger("is_dasher");
    }

    public boolean isDataValid() {
        return !this.zzarr.isClosed();
    }

    public boolean isPeriodicSyncEnabled() {
        AccountMetadata zzJm = zzJm();
        return zzJm == null ? false : isPlusPage() ? zzJm.isPagePeriodicSyncEnabled : zzJm.isSyncEnabled;
    }

    public boolean isPlusEnabled() {
        if (isPlusPage()) {
            return true;
        }
        AccountMetadata zzJm = zzJm();
        return zzJm == null ? false : zzJm.isPlusEnabled;
    }

    public boolean isPlusPage() {
        return getPlusPageId() != null;
    }

    public boolean isSyncCirclesToContactsEnabled() {
        return getBoolean("sync_circles_to_contacts");
    }

    public boolean isSyncEnabled() {
        AccountMetadata zzJm = zzJm();
        return zzJm == null ? false : isPlusPage() ? zzJm.isPageTickleSyncEnabled : zzJm.isSyncEnabled;
    }

    public boolean isSyncEvergreenToContactsEnabled() {
        return getBoolean("sync_evergreen_to_contacts");
    }

    public boolean isSyncMeToContactsEnabled() {
        return getBoolean("sync_me_to_contacts");
    }

    @Deprecated
    public boolean isSyncToContactsEnabled() {
        return isSyncCirclesToContactsEnabled();
    }
}

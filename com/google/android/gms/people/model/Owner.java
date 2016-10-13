package com.google.android.gms.people.model;

import com.google.android.gms.common.data.Freezable;

public interface Owner extends Freezable<Owner> {
    Owner freeze();

    @Deprecated
    String getAccountGaiaId();

    String getAccountId();

    String getAccountName();

    String getAvatarUrl();

    int getCoverPhotoHeight();

    String getCoverPhotoId();

    String getCoverPhotoUrl();

    int getCoverPhotoWidth();

    String getDasherDomain();

    String getDisplayName();

    long getLastSuccessfulSyncFinishTimestamp();

    long getLastSyncFinishTimestamp();

    long getLastSyncStartTimestamp();

    int getLastSyncStatus();

    @Deprecated
    String getPlusPageGaiaId();

    String getPlusPageId();

    long getRowId();

    int isDasherAccount();

    boolean isPeriodicSyncEnabled();

    boolean isPlusEnabled();

    boolean isPlusPage();

    boolean isSyncCirclesToContactsEnabled();

    boolean isSyncEnabled();

    boolean isSyncEvergreenToContactsEnabled();

    boolean isSyncMeToContactsEnabled();

    @Deprecated
    boolean isSyncToContactsEnabled();
}

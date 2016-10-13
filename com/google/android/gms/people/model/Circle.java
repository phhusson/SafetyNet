package com.google.android.gms.people.model;

public interface Circle {
    @Deprecated
    String getAccountName();

    String getCircleId();

    String getCircleName();

    int getCircleType();

    long getLastModifiedTime();

    String getOwnerAccountName();

    String getOwnerPlusPageId();

    int getPeopleCount();

    @Deprecated
    String getPlusPageGaiaId();

    long getRowId();

    String getSortKey();

    int getVisibility();

    boolean isEnabledForSharing();

    boolean isSyncToContactsEnabled();
}

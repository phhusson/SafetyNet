package com.google.android.gms.people.model;

public interface AggregatedPerson extends Person {
    @Deprecated
    String getAccountName();

    String getAvatarUrl();

    Iterable<Long> getContactIds();

    String getFamilyName();

    String getGaiaId();

    String getGivenName();

    String getName();

    String getOwnerAccountName();

    String getOwnerPlusPageId();

    @Deprecated
    String getPlusPageGaiaId();

    String getQualifiedId();

    long getRowId();

    boolean hasContact();

    boolean hasPlusPerson();
}

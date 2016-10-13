package com.google.android.gms.people.model;

public interface Person extends Affinities {
    @Deprecated
    String getAccountName();

    double getAffinity1();

    double getAffinity2();

    double getAffinity3();

    double getAffinity4();

    double getAffinity5();

    String getAvatarUrl();

    String[] getBelongingCircleIds();

    Iterable<EmailAddress> getEmailAddresses();

    String getFamilyName();

    String getGaiaId();

    String getGivenName();

    int getInViewerDomain();

    String getInteractionRankSortKey();

    long getLastModifiedTime();

    String getName();

    String getNameSortKey();

    String getOwnerAccountName();

    String getOwnerPlusPageId();

    Iterable<PhoneNumber> getPhoneNumbers();

    @Deprecated
    String getPlusPageGaiaId();

    int getProfileType();

    String getQualifiedId();

    long getRowId();

    boolean isBlocked();

    boolean isNameVerified();
}

package com.google.android.gms.people.model;

public interface AutocompleteEntry {
    long getAndroidContactDataId();

    long getAndroidContactId();

    int getAutocompleteItemType();

    AvatarReference getAvatarReference();

    int getDataSource();

    String getFocusContactId();

    String getGaiaId();

    double getItemAffinity1();

    double getItemAffinity2();

    double getItemAffinity3();

    double getItemAffinity4();

    double getItemAffinity5();

    String getItemLoggingId1();

    String getItemLoggingId2();

    String getItemLoggingId3();

    String getItemLoggingId4();

    String getItemLoggingId5();

    String getItemValue();

    String getItemValueCustomLabel();

    int getItemValueType();

    String getOwnerAccountName();

    String getOwnerPlusPageId();

    String getPeopleV2Id();

    double getPersonAffinity1();

    double getPersonAffinity2();

    double getPersonAffinity3();

    double getPersonAffinity4();

    double getPersonAffinity5();

    String getPersonDisplayName();

    String getPersonKey();

    String getPersonLoggingId1();

    String getPersonLoggingId2();

    String getPersonLoggingId3();

    String getPersonLoggingId4();

    String getPersonLoggingId5();

    double getPrimarySortedAffinity();

    String getPrimarySortedLoggingId();

    int getRowIndex();

    double getSortedItemAffinity();

    String getSortedItemLoggingId();

    double getSortedPersonAffinity();

    String getSortedPersonLoggingId();
}

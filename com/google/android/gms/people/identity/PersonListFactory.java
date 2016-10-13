package com.google.android.gms.people.identity;

import com.google.android.gms.people.identity.PersonFactory.ContactData;
import com.google.android.gms.people.identity.PersonFactory.OfflineDatabaseData;
import com.google.android.gms.people.identity.PersonFactory.ServiceData;

public interface PersonListFactory<PersonType> {

    public interface PersonListItemFactory<PersonType> {
        PersonType get(int i);

        int getCount();

        String getQualifiedId(int i);
    }

    PersonListItemFactory<PersonType> buildList(ServiceData serviceData, ContactData[] contactDataArr, OfflineDatabaseData offlineDatabaseData);
}

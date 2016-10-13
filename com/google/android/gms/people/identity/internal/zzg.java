package com.google.android.gms.people.identity.internal;

import com.google.android.gms.people.identity.PersonFactory.ContactData;
import com.google.android.gms.people.identity.PersonFactory.OfflineDatabaseData;
import com.google.android.gms.people.identity.PersonFactory.ServiceData;
import com.google.android.gms.people.identity.PersonListFactory;
import com.google.android.gms.people.identity.PersonListFactory.PersonListItemFactory;
import java.util.Collections;
import java.util.List;

public abstract class zzg<PersonType> implements PersonListFactory<PersonType> {
    public PersonListItemFactory<PersonType> buildList(ServiceData serviceData, ContactData[] contactData, OfflineDatabaseData offlineDatabaseData) {
        List zza = serviceData != null ? zza(serviceData) : offlineDatabaseData != null ? zza(offlineDatabaseData) : Collections.emptyList();
        final List zza2 = contactData != null ? zza(contactData) : Collections.emptyList();
        return new PersonListItemFactory<PersonType>(this) {
            final /* synthetic */ zzg zzbBl;

            public PersonType get(int index) {
                return index < zza.size() ? zza.get(index) : zza2.get(index - zza.size());
            }

            public int getCount() {
                return zza.size() + zza2.size();
            }

            public String getQualifiedId(int index) {
                return this.zzbBl.zzP(get(index));
            }
        };
    }

    protected abstract String zzP(PersonType personType);

    protected abstract List<PersonType> zza(OfflineDatabaseData offlineDatabaseData);

    protected abstract List<PersonType> zza(ServiceData serviceData);

    protected abstract List<PersonType> zza(ContactData[] contactDataArr);
}

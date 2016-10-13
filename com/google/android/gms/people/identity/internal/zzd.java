package com.google.android.gms.people.identity.internal;

import android.content.Context;
import com.google.android.gms.people.identity.PersonFactory;
import com.google.android.gms.people.identity.PersonFactory.ContactData;
import com.google.android.gms.people.identity.PersonFactory.OfflineDatabaseData;
import com.google.android.gms.people.identity.PersonFactory.ServiceData;
import com.google.android.gms.people.identity.internal.models.PersonImpl;
import com.google.android.gms.people.identity.models.Person;

public final class zzd extends zze<PersonImpl> implements PersonFactory<Person> {
    public /* synthetic */ Object build(Context context, Object obj, ServiceData serviceData, ContactData contactData, OfflineDatabaseData offlineDatabaseData) {
        return super.zza(context, obj, serviceData, contactData, offlineDatabaseData);
    }

    protected PersonImpl zzGn() {
        return new PersonImpl();
    }
}

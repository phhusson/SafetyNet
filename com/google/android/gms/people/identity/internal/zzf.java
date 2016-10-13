package com.google.android.gms.people.identity.internal;

import com.google.android.gms.people.identity.PersonFactory.ContactData;
import com.google.android.gms.people.identity.PersonFactory.OfflineDatabaseData;
import com.google.android.gms.people.identity.PersonFactory.RawContactData;
import com.google.android.gms.people.identity.PersonFactory.ServiceData;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Images;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Names;
import com.google.android.gms.people.identity.internal.models.ImageReferenceImpl;
import com.google.android.gms.people.identity.internal.models.PersonReferenceImpl;
import com.google.android.gms.people.identity.internal.models.zzao;
import com.google.android.gms.people.identity.models.PersonReference;
import com.google.android.gms.people.internal.zzo;
import java.util.ArrayList;
import java.util.List;

public class zzf extends zzg<PersonReference> {
    protected static Names zzJ(List<Names> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (Names names : list) {
            if (names.zzHf() != null && names.zzHf().isPrimary()) {
                return names;
            }
        }
        return (Names) list.get(0);
    }

    protected static Images zzK(List<Images> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (Images images : list) {
            if (images.zzHf() != null && images.zzHf().isPrimary()) {
                return images;
            }
        }
        return (Images) list.get(0);
    }

    protected /* synthetic */ String zzP(Object obj) {
        return zza((PersonReference) obj);
    }

    protected String zza(PersonReference personReference) {
        return personReference.getQualifiedId();
    }

    protected List<PersonReference> zza(OfflineDatabaseData offlineDatabaseData) {
        throw new IllegalStateException("Not Implemented");
    }

    protected List<PersonReference> zza(ServiceData serviceData) {
        List arrayList = new ArrayList();
        if (!(serviceData == null || serviceData.blob == null)) {
            try {
                zzao com_google_android_gms_people_identity_internal_models_zzao = new zzao();
                com_google_android_gms_people_identity_internal_models_zzao.parseNetworkResponse(serviceData.responseCode, serviceData.blob);
                for (DefaultPersonImpl defaultPersonImpl : com_google_android_gms_people_identity_internal_models_zzao.zznY()) {
                    Names zzJ = zzJ(defaultPersonImpl.getNames());
                    Images zzK = zzK(defaultPersonImpl.getImages());
                    PersonReferenceImpl zzhL = new PersonReferenceImpl().zzhL("g:" + defaultPersonImpl.getId());
                    if (zzJ != null) {
                        zzhL.zzhK(zzJ.getDisplayName());
                    }
                    if (zzK != null) {
                        zzhL.zzc(new ImageReferenceImpl().zzfW(zzK.getUrl()));
                    }
                    arrayList.add(zzhL);
                }
            } catch (Throwable e) {
                zzo.zzb("DefaultPersonFactory", "ParseException", e);
            }
        }
        return arrayList;
    }

    protected List<PersonReference> zza(ContactData[] contactDataArr) {
        List<PersonReference> arrayList = new ArrayList(contactDataArr.length);
        for (ContactData rawData : contactDataArr) {
            RawContactData rawContactData = (RawContactData) rawData.getRawData().get(0);
            String zzp = com.google.android.gms.people.identity.internal.zzc.zzf.zzp(rawContactData);
            ImageReferenceImpl imageReferenceImpl = null;
            if (zzp != null) {
                imageReferenceImpl = new ImageReferenceImpl().zzfW(zzp).zzmQ(2);
            }
            arrayList.add(new PersonReferenceImpl().zzhL(zzc.zzfP(com.google.android.gms.people.identity.internal.zzc.zzf.zzn(rawContactData))).zzhK(com.google.android.gms.people.identity.internal.zzc.zzf.zzo(rawContactData)).zzc(imageReferenceImpl));
        }
        return arrayList;
    }
}

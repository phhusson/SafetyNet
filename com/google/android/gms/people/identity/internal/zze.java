package com.google.android.gms.people.identity.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.people.identity.PersonFactory.ContactData;
import com.google.android.gms.people.identity.PersonFactory.OfflineDatabaseData;
import com.google.android.gms.people.identity.PersonFactory.OfflineDatabaseData.AddressData;
import com.google.android.gms.people.identity.PersonFactory.OfflineDatabaseData.Circle;
import com.google.android.gms.people.identity.PersonFactory.OfflineDatabaseData.EmailData;
import com.google.android.gms.people.identity.PersonFactory.OfflineDatabaseData.PhoneData;
import com.google.android.gms.people.identity.PersonFactory.RawContactData;
import com.google.android.gms.people.identity.PersonFactory.ServiceData;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl;
import com.google.android.gms.people.identity.internal.models.ImageReferenceImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.AddressesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.EmailsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.EventsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.ImagesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.InstantMessagingImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MembershipsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.NamesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.NicknamesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.NotesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.OrganizationsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.PersonMetadataImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.PhoneNumbersImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.RelationsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.TaglinesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.UrlsImpl;
import com.google.android.gms.people.identity.internal.models.zzao;
import com.google.android.gms.people.identity.internal.zzc.zza;
import com.google.android.gms.people.identity.internal.zzc.zzb;
import com.google.android.gms.people.identity.internal.zzc.zzc;
import com.google.android.gms.people.identity.internal.zzc.zzd;
import com.google.android.gms.people.identity.internal.zzc.zzg;
import com.google.android.gms.people.identity.internal.zzc.zzh;
import com.google.android.gms.people.identity.internal.zzc.zzi;
import com.google.android.gms.people.identity.internal.zzc.zzj;
import com.google.android.gms.people.identity.internal.zzc.zzk;
import com.google.android.gms.people.identity.internal.zzc.zzl;
import com.google.android.gms.people.identity.internal.zzc.zzm;
import com.google.android.gms.people.internal.zzo;
import java.util.HashSet;

public abstract class zze<PersonType extends PersonImpl> {
    private static MetadataImpl zzH(RawContactData rawContactData) {
        return new MetadataImpl().zzaK(rawContactData.isPrimary()).zzaM(!rawContactData.isReadOnly()).zzgK("cp2").zzgM(rawContactData.getContactId()).zznf(Integer.parseInt(rawContactData.getRawContactId()));
    }

    private NicknamesImpl zzI(RawContactData rawContactData) {
        return new NicknamesImpl().zzl(zzH(rawContactData)).zzha(zzh.zzo(rawContactData)).zzgZ(zzh.zza(rawContactData));
    }

    private OrganizationsImpl zzJ(RawContactData rawContactData) {
        return new OrganizationsImpl().zzo(zzH(rawContactData)).zzhi(zzj.zzo(rawContactData)).zzhn(zzj.zza(rawContactData)).zzhm(zzj.zzz(rawContactData)).zzhd(zzj.zzA(rawContactData)).zzhe(zzj.zzB(rawContactData)).zzhl(zzj.zzC(rawContactData)).zzhj(zzj.zzD(rawContactData)).zzhh(zzj.zzE(rawContactData));
    }

    private NamesImpl zzK(RawContactData rawContactData) {
        return new NamesImpl().zzk(zzH(rawContactData)).zzgO(zzg.zzq(rawContactData)).zzgR(zzg.zzr(rawContactData)).zzgP(zzg.zzs(rawContactData)).zzgS(zzg.zzt(rawContactData)).zzgU(zzg.zzu(rawContactData)).zzgT(zzg.zzv(rawContactData)).zzgW(zzg.zzw(rawContactData)).zzgV(zzg.zzx(rawContactData));
    }

    private UrlsImpl zzL(RawContactData rawContactData) {
        return new UrlsImpl().zzw(zzH(rawContactData)).zzhJ(zzm.zzm(rawContactData)).zzhI(zzm.zza(rawContactData));
    }

    private NotesImpl zzM(RawContactData rawContactData) {
        return new NotesImpl().zzm(zzH(rawContactData)).zzhb(zzi.zzy(rawContactData));
    }

    private ImagesImpl zzN(RawContactData rawContactData) {
        return new ImagesImpl().zzh(zzH(rawContactData)).zzb(new ImageReferenceImpl().zzfW(com.google.android.gms.people.identity.internal.zzc.zze.zzm(rawContactData)).zzmQ(2));
    }

    private void zza(Context context, PersonImpl personImpl, ContactData contactData) {
        HashSet hashSet = new HashSet();
        for (RawContactData rawContactData : contactData.getRawData()) {
            if (!TextUtils.isEmpty(rawContactData.getData(0)) || !TextUtils.isEmpty(rawContactData.getData(13))) {
                if (!hashSet.contains(rawContactData.getContactId())) {
                    hashSet.add(rawContactData.getContactId());
                    personImpl.zza(new MembershipsImpl().zzgI(rawContactData.getContactId()).zzj(zzH(rawContactData)));
                }
                String mimeType = rawContactData.getMimeType();
                int i = -1;
                switch (mimeType.hashCode()) {
                    case -1569536764:
                        if (mimeType.equals("vnd.android.cursor.item/email_v2")) {
                            i = 0;
                            break;
                        }
                        break;
                    case -1328682538:
                        if (mimeType.equals("vnd.android.cursor.item/contact_event")) {
                            i = 1;
                            break;
                        }
                        break;
                    case -1079224304:
                        if (mimeType.equals("vnd.android.cursor.item/name")) {
                            i = 7;
                            break;
                        }
                        break;
                    case -1079210633:
                        if (mimeType.equals("vnd.android.cursor.item/note")) {
                            i = 11;
                            break;
                        }
                        break;
                    case -601229436:
                        if (mimeType.equals("vnd.android.cursor.item/postal-address_v2")) {
                            i = 8;
                            break;
                        }
                        break;
                    case 456415478:
                        if (mimeType.equals("vnd.android.cursor.item/website")) {
                            i = 9;
                            break;
                        }
                        break;
                    case 684173810:
                        if (mimeType.equals("vnd.android.cursor.item/phone_v2")) {
                            i = 5;
                            break;
                        }
                        break;
                    case 689862072:
                        if (mimeType.equals("vnd.android.cursor.item/organization")) {
                            i = 4;
                            break;
                        }
                        break;
                    case 905843021:
                        if (mimeType.equals("vnd.android.cursor.item/photo")) {
                            i = 10;
                            break;
                        }
                        break;
                    case 950831081:
                        if (mimeType.equals("vnd.android.cursor.item/im")) {
                            i = 2;
                            break;
                        }
                        break;
                    case 1409846529:
                        if (mimeType.equals("vnd.android.cursor.item/relation")) {
                            i = 6;
                            break;
                        }
                        break;
                    case 2034973555:
                        if (mimeType.equals("vnd.android.cursor.item/nickname")) {
                            i = 3;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        personImpl.zza(zzd(context, rawContactData));
                        break;
                    case 1:
                        personImpl.zza(zze(context, rawContactData));
                        break;
                    case 2:
                        personImpl.zza(zzf(context, rawContactData));
                        break;
                    case 3:
                        personImpl.zza(zzI(rawContactData));
                        break;
                    case 4:
                        personImpl.zza(zzJ(rawContactData));
                        break;
                    case 5:
                        personImpl.zza(zzg(context, rawContactData));
                        break;
                    case 6:
                        personImpl.zza(zzh(context, rawContactData));
                        break;
                    case 7:
                        personImpl.zza(zzK(rawContactData));
                        break;
                    case 8:
                        personImpl.zza(zzi(context, rawContactData));
                        break;
                    case 9:
                        personImpl.zza(zzL(rawContactData));
                        break;
                    case 10:
                        if (!TextUtils.isEmpty(rawContactData.getData(13))) {
                            personImpl.zza(zzN(rawContactData));
                            break;
                        }
                        break;
                    case 11:
                        personImpl.zza(zzM(rawContactData));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void zza(PersonImpl personImpl, OfflineDatabaseData offlineDatabaseData) {
        if (offlineDatabaseData != null) {
            PersonMetadataImpl zzIL;
            if (personImpl.zzGR()) {
                zzIL = personImpl.zzIL();
            } else {
                PersonMetadataImpl personMetadataImpl = new PersonMetadataImpl();
                personImpl.zza(personMetadataImpl);
                zzIL = personMetadataImpl;
            }
            switch (offlineDatabaseData.getProfileType()) {
                case 1:
                    zzIL.zzhp("person");
                    break;
                case 2:
                    zzIL.zzhp("page");
                    break;
            }
            if (offlineDatabaseData.getCircles() != null) {
                for (Circle circle : offlineDatabaseData.getCircles()) {
                    zzIL.zzho(circle.getId());
                    personImpl.zza(new MembershipsImpl().zzgH(circle.getId()).zzj(new MetadataImpl().zzgK(Scopes.PROFILE).zzgM(offlineDatabaseData.getGaiaId())));
                }
            }
            personImpl.zza(new NamesImpl().zzgO(offlineDatabaseData.getDisplayName()).zzk(new MetadataImpl().zzgK(Scopes.PROFILE).zzaK(true).zzaM(false).zzaL(offlineDatabaseData.getNameVerified()))).zzfZ(offlineDatabaseData.getGaiaId()).zza(new TaglinesImpl().zzhG(offlineDatabaseData.getTagline()).zzv(new MetadataImpl().zzgK(Scopes.PROFILE).zzaK(true).zzaM(false))).zza(new ImagesImpl().zzb(new ImageReferenceImpl().zzfW(offlineDatabaseData.getCompressedAvatarUrl()).zzmQ(1)).zzaI(true).zzh(new MetadataImpl().zzgK(Scopes.PROFILE).zzaK(true).zzaM(false)));
            if (offlineDatabaseData.getAddresses() != null) {
                for (AddressData addressData : offlineDatabaseData.getAddresses()) {
                    personImpl.zza(new AddressesImpl().zzgl(addressData.getAddress()).zzgh(addressData.getType()).zzb(new MetadataImpl().zzgK(Scopes.PROFILE).zzaK(true).zzaM(false)));
                }
            }
            if (offlineDatabaseData.getPhones() != null) {
                for (PhoneData phoneData : offlineDatabaseData.getPhones()) {
                    personImpl.zza(new PhoneNumbersImpl().zzhv(phoneData.getPhone()).zzht(phoneData.getType()).zzp(new MetadataImpl().zzgK(Scopes.PROFILE).zzaK(true).zzaM(false)));
                }
            }
            if (offlineDatabaseData.getEmails() != null) {
                for (EmailData emailData : offlineDatabaseData.getEmails()) {
                    personImpl.zza(new EmailsImpl().zzgv(emailData.getEmailAddress()).zzgt(emailData.getType()).zze(new MetadataImpl().zzgK(Scopes.PROFILE).zzaK(true).zzaM(false)));
                }
            }
        }
    }

    private EmailsImpl zzd(Context context, RawContactData rawContactData) {
        return new EmailsImpl().zze(zzH(rawContactData)).zzgv(zzb.zzi(rawContactData)).zzgu(zzb.zza(rawContactData)).zzgt(zzb.zza(context, rawContactData)).zzne(rawContactData.getTimesUsed());
    }

    private EventsImpl zze(Context context, RawContactData rawContactData) {
        return new EventsImpl().zzf(zzH(rawContactData)).zzgy(zzc.zzj(rawContactData)).zzgx(zzc.zzb(context, rawContactData)).zzgw(zzc.zzk(rawContactData));
    }

    private InstantMessagingImpl zzf(Context context, RawContactData rawContactData) {
        return new InstantMessagingImpl().zzi(zzH(rawContactData)).zzgF(zzd.zzi(rawContactData)).zzgE(zzd.zza(rawContactData)).zzgC(zzd.zza(context, rawContactData)).zzgD(zzd.zzl(rawContactData)).zzgB(zzd.zzc(context, rawContactData));
    }

    private PhoneNumbersImpl zzg(Context context, RawContactData rawContactData) {
        return new PhoneNumbersImpl().zzp(zzH(rawContactData)).zzhv(zzk.zzF(rawContactData)).zzhu(zzk.zza(rawContactData)).zzht(zzk.zza(context, rawContactData)).zzng(rawContactData.getTimesUsed());
    }

    private RelationsImpl zzh(Context context, RawContactData rawContactData) {
        return new RelationsImpl().zzr(zzH(rawContactData)).zzhz(zzl.zzG(rawContactData)).zzhy(zzl.zza(rawContactData)).zzhx(zzl.zza(context, rawContactData));
    }

    private AddressesImpl zzi(Context context, RawContactData rawContactData) {
        return new AddressesImpl().zzb(zzH(rawContactData)).zzgm(zza.zza(rawContactData)).zzgh(zza.zza(context, rawContactData)).zzgl(zza.zzb(rawContactData)).zzgi(zza.zzc(rawContactData)).zzge(zza.zzd(rawContactData)).zzgk(zza.zze(rawContactData)).zzgj(zza.zzf(rawContactData)).zzgf(zza.zzg(rawContactData)).zzgg(zza.zzh(rawContactData));
    }

    protected abstract PersonType zzGn();

    public PersonType zza(Context context, Object obj, ServiceData serviceData, ContactData contactData, OfflineDatabaseData offlineDatabaseData) {
        Object obj2 = null;
        PersonType zzGn = zzGn();
        if (!(serviceData == null || serviceData.blob == null)) {
            try {
                switch (serviceData.format) {
                    case 2:
                        DefaultPersonImpl defaultPersonImpl = new DefaultPersonImpl();
                        defaultPersonImpl.parseNetworkResponse(serviceData.responseCode, serviceData.blob);
                        com.google.android.gms.people.identity.internal.models.zzi.zza(defaultPersonImpl, zzGn);
                        obj2 = 1;
                        break;
                    case 4:
                        zzao com_google_android_gms_people_identity_internal_models_zzao = new zzao();
                        com_google_android_gms_people_identity_internal_models_zzao.parseNetworkResponse(serviceData.responseCode, serviceData.blob);
                        if (com_google_android_gms_people_identity_internal_models_zzao.zzIw() && com_google_android_gms_people_identity_internal_models_zzao.zznY().size() > 0) {
                            com.google.android.gms.people.identity.internal.models.zzi.zza((DefaultPersonImpl) com_google_android_gms_people_identity_internal_models_zzao.zznY().get(0), zzGn);
                            int i = 1;
                            break;
                        }
                    default:
                        zzo.zzI("DefaultPersonFactory", "Unrecognized data format");
                        return null;
                }
            } catch (Throwable e) {
                zzo.zzb("DefaultPersonFactory", "ParseException", e);
                return null;
            }
        }
        if (obj2 == null && offlineDatabaseData != null) {
            zza(zzGn, offlineDatabaseData);
        }
        if (contactData != null) {
            zza(context, zzGn, contactData);
        }
        return zzGn;
    }
}

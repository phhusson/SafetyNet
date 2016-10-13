package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.AboutsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.AddressesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.BirthdaysImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.BraggingRightsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.CoverPhotosImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.CustomFieldsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.EmailsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.EventsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.GendersImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.ImagesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.InstantMessagingImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.LegacyFieldsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MembershipsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.NamesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.NicknamesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.NotesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.OccupationsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.OrganizationsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.PersonMetadataImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.PhoneNumbersImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.PlacesLivedImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.RelationsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.RelationshipInterestsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.RelationshipStatusesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.SkillsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.SortKeysImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.TaglinesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.UrlsImpl;
import com.google.android.gms.playlog.PlayLogger.LogSource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzbd implements Creator<PersonImpl> {
    static void zza(PersonImpl personImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = personImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, personImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, personImpl.zzbCm, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zzc(parcel, 3, personImpl.zzbAh, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, personImpl.zzbCn, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zzc(parcel, 5, personImpl.zzbCo, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zzc(parcel, 6, personImpl.zzbCp, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zzc(parcel, 7, personImpl.zzbCq, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zzc(parcel, 8, personImpl.zzbCr, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zzc(parcel, 9, personImpl.zzbAi, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zza(parcel, 10, personImpl.zzbCs, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            zzb.zzc(parcel, 11, personImpl.zzql, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zzc(parcel, 12, personImpl.zzbCt, true);
        }
        if (set.contains(Integer.valueOf(13))) {
            zzb.zza(parcel, 13, personImpl.zzyU, true);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzb.zzc(parcel, 14, personImpl.zzyw, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            zzb.zzc(parcel, 15, personImpl.zzbCu, true);
        }
        if (set.contains(Integer.valueOf(17))) {
            zzb.zza(parcel, 17, personImpl.zzbDN, i, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            zzb.zza(parcel, 16, personImpl.zzajR, true);
        }
        if (set.contains(Integer.valueOf(19))) {
            zzb.zzc(parcel, 19, personImpl.zzbCx, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            zzb.zzc(parcel, 18, personImpl.zzbCw, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            zzb.zzc(parcel, 21, personImpl.zzbCz, true);
        }
        if (set.contains(Integer.valueOf(20))) {
            zzb.zza(parcel, 20, personImpl.zzbDO, i, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            zzb.zzc(parcel, 23, personImpl.zzbCB, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            zzb.zzc(parcel, 22, personImpl.zzbCA, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            zzb.zzc(parcel, 25, personImpl.zzbCD, true);
        }
        if (set.contains(Integer.valueOf(24))) {
            zzb.zzc(parcel, 24, personImpl.zzbCC, true);
        }
        if (set.contains(Integer.valueOf(27))) {
            zzb.zza(parcel, 27, personImpl.zzbCF, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            zzb.zzc(parcel, 26, personImpl.zzbCE, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            zzb.zzc(parcel, 29, personImpl.zzbCH, true);
        }
        if (set.contains(Integer.valueOf(28))) {
            zzb.zzc(parcel, 28, personImpl.zzbCG, true);
        }
        if (set.contains(Integer.valueOf(31))) {
            zzb.zzc(parcel, 31, personImpl.zzbCJ, true);
        }
        if (set.contains(Integer.valueOf(30))) {
            zzb.zzc(parcel, 30, personImpl.zzbCI, true);
        }
        if (set.contains(Integer.valueOf(34))) {
            zzb.zzc(parcel, 34, personImpl.zzbCM, true);
        }
        if (set.contains(Integer.valueOf(35))) {
            zzb.zzc(parcel, 35, personImpl.zzbDQ, true);
        }
        if (set.contains(Integer.valueOf(32))) {
            zzb.zza(parcel, 32, personImpl.zzbDP, i, true);
        }
        if (set.contains(Integer.valueOf(33))) {
            zzb.zzc(parcel, 33, personImpl.zzbCL, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjh(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznh(i);
    }

    public PersonImpl zzjh(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        List list = null;
        List list2 = null;
        String str = null;
        List list3 = null;
        List list4 = null;
        List list5 = null;
        List list6 = null;
        List list7 = null;
        String str2 = null;
        List list8 = null;
        List list9 = null;
        String str3 = null;
        List list10 = null;
        List list11 = null;
        String str4 = null;
        LegacyFieldsImpl legacyFieldsImpl = null;
        List list12 = null;
        List list13 = null;
        PersonMetadataImpl personMetadataImpl = null;
        List list14 = null;
        List list15 = null;
        List list16 = null;
        List list17 = null;
        List list18 = null;
        List list19 = null;
        String str5 = null;
        List list20 = null;
        List list21 = null;
        List list22 = null;
        List list23 = null;
        SortKeysImpl sortKeysImpl = null;
        List list24 = null;
        List list25 = null;
        List list26 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    list = zza.zzc(parcel, zzbc, AboutsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    list2 = zza.zzc(parcel, zzbc, AddressesImpl.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    list3 = zza.zzc(parcel, zzbc, BirthdaysImpl.CREATOR);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    list4 = zza.zzc(parcel, zzbc, BraggingRightsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    list5 = zza.zzc(parcel, zzbc, CoverPhotosImpl.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    list6 = zza.zzc(parcel, zzbc, CustomFieldsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    list7 = zza.zzc(parcel, zzbc, EmailsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    list8 = zza.zzc(parcel, zzbc, EventsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(11));
                    break;
                case 12:
                    list9 = zza.zzc(parcel, zzbc, GendersImpl.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 13:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    list10 = zza.zzc(parcel, zzbc, ImagesImpl.CREATOR);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    list11 = zza.zzc(parcel, zzbc, InstantMessagingImpl.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    break;
                case 16:
                    str4 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 17:
                    LegacyFieldsImpl legacyFieldsImpl2 = (LegacyFieldsImpl) zza.zza(parcel, zzbc, (Creator) LegacyFieldsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(17));
                    legacyFieldsImpl = legacyFieldsImpl2;
                    break;
                case 18:
                    list12 = zza.zzc(parcel, zzbc, PersonImpl.CREATOR);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case 19:
                    list13 = zza.zzc(parcel, zzbc, MembershipsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    break;
                case 20:
                    PersonMetadataImpl personMetadataImpl2 = (PersonMetadataImpl) zza.zza(parcel, zzbc, (Creator) PersonMetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(20));
                    personMetadataImpl = personMetadataImpl2;
                    break;
                case 21:
                    list14 = zza.zzc(parcel, zzbc, NamesImpl.CREATOR);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    list15 = zza.zzc(parcel, zzbc, NicknamesImpl.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    list16 = zza.zzc(parcel, zzbc, OccupationsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    list17 = zza.zzc(parcel, zzbc, OrganizationsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    list18 = zza.zzc(parcel, zzbc, PhoneNumbersImpl.CREATOR);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case LogSource.ANDROID_CAMERA /*26*/:
                    list19 = zza.zzc(parcel, zzbc, PlacesLivedImpl.CREATOR);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case LogSource.CW /*27*/:
                    str5 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case LogSource.GEL /*28*/:
                    list20 = zza.zzc(parcel, zzbc, RelationsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case LogSource.DNA_PROBER /*29*/:
                    list21 = zza.zzc(parcel, zzbc, RelationshipInterestsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(29));
                    break;
                case LogSource.UDR /*30*/:
                    list22 = zza.zzc(parcel, zzbc, RelationshipStatusesImpl.CREATOR);
                    hashSet.add(Integer.valueOf(30));
                    break;
                case LogSource.GMS_CORE_WALLET /*31*/:
                    list23 = zza.zzc(parcel, zzbc, SkillsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(31));
                    break;
                case 32:
                    SortKeysImpl sortKeysImpl2 = (SortKeysImpl) zza.zza(parcel, zzbc, (Creator) SortKeysImpl.CREATOR);
                    hashSet.add(Integer.valueOf(32));
                    sortKeysImpl = sortKeysImpl2;
                    break;
                case 33:
                    list24 = zza.zzc(parcel, zzbc, TaglinesImpl.CREATOR);
                    hashSet.add(Integer.valueOf(33));
                    break;
                case 34:
                    list25 = zza.zzc(parcel, zzbc, UrlsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(34));
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                    list26 = zza.zzc(parcel, zzbc, NotesImpl.CREATOR);
                    hashSet.add(Integer.valueOf(35));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new PersonImpl(hashSet, i, list, list2, str, list3, list4, list5, list6, list7, str2, list8, list9, str3, list10, list11, str4, legacyFieldsImpl, list12, list13, personMetadataImpl, list14, list15, list16, list17, list18, list19, str5, list20, list21, list22, list23, sortKeysImpl, list24, list25, list26);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public PersonImpl[] zznh(int i) {
        return new PersonImpl[i];
    }
}

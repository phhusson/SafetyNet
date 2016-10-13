package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Abouts;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Addresses;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Birthdays;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.BraggingRights;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.CoverPhotos;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.CustomFields;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Emails;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Events;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Genders;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Images;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.InstantMessaging;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.LegacyFields;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Memberships;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Metadata;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Names;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Nicknames;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Occupations;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Organizations;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.PhoneNumbers;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.PlacesLived;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Relations;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.RelationshipInterests;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.RelationshipStatuses;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Skills;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.SortKeys;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Taglines;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Urls;
import com.google.android.gms.playlog.PlayLogger.LogSource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzj implements Creator<DefaultPersonImpl> {
    static void zza(DefaultPersonImpl defaultPersonImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = defaultPersonImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, defaultPersonImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, defaultPersonImpl.zzbCm, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zzc(parcel, 3, defaultPersonImpl.zzbAh, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, defaultPersonImpl.zzbCn, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zzc(parcel, 5, defaultPersonImpl.zzbCo, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zzc(parcel, 6, defaultPersonImpl.zzbCp, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zzc(parcel, 7, defaultPersonImpl.zzbCq, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zzc(parcel, 8, defaultPersonImpl.zzbCr, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zzc(parcel, 9, defaultPersonImpl.zzbAi, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zza(parcel, 10, defaultPersonImpl.zzbCs, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            zzb.zzc(parcel, 11, defaultPersonImpl.zzql, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zzc(parcel, 12, defaultPersonImpl.zzbCt, true);
        }
        if (set.contains(Integer.valueOf(13))) {
            zzb.zza(parcel, 13, defaultPersonImpl.zzyU, true);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzb.zzc(parcel, 14, defaultPersonImpl.zzyw, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            zzb.zzc(parcel, 15, defaultPersonImpl.zzbCu, true);
        }
        if (set.contains(Integer.valueOf(17))) {
            zzb.zza(parcel, 17, defaultPersonImpl.zzajR, true);
        }
        if (set.contains(Integer.valueOf(19))) {
            zzb.zzc(parcel, 19, defaultPersonImpl.zzbCw, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            zzb.zza(parcel, 18, defaultPersonImpl.zzbCv, i, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            zzb.zza(parcel, 21, defaultPersonImpl.zzbCy, i, true);
        }
        if (set.contains(Integer.valueOf(20))) {
            zzb.zzc(parcel, 20, defaultPersonImpl.zzbCx, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            zzb.zzc(parcel, 23, defaultPersonImpl.zzbCA, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            zzb.zzc(parcel, 22, defaultPersonImpl.zzbCz, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            zzb.zzc(parcel, 25, defaultPersonImpl.zzbCC, true);
        }
        if (set.contains(Integer.valueOf(24))) {
            zzb.zzc(parcel, 24, defaultPersonImpl.zzbCB, true);
        }
        if (set.contains(Integer.valueOf(27))) {
            zzb.zzc(parcel, 27, defaultPersonImpl.zzbCE, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            zzb.zzc(parcel, 26, defaultPersonImpl.zzbCD, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            zzb.zzc(parcel, 29, defaultPersonImpl.zzbCG, true);
        }
        if (set.contains(Integer.valueOf(28))) {
            zzb.zza(parcel, 28, defaultPersonImpl.zzbCF, true);
        }
        if (set.contains(Integer.valueOf(31))) {
            zzb.zzc(parcel, 31, defaultPersonImpl.zzbCI, true);
        }
        if (set.contains(Integer.valueOf(30))) {
            zzb.zzc(parcel, 30, defaultPersonImpl.zzbCH, true);
        }
        if (set.contains(Integer.valueOf(34))) {
            zzb.zzc(parcel, 34, defaultPersonImpl.zzbCL, true);
        }
        if (set.contains(Integer.valueOf(35))) {
            zzb.zzc(parcel, 35, defaultPersonImpl.zzbCM, true);
        }
        if (set.contains(Integer.valueOf(32))) {
            zzb.zzc(parcel, 32, defaultPersonImpl.zzbCJ, true);
        }
        if (set.contains(Integer.valueOf(33))) {
            zzb.zza(parcel, 33, defaultPersonImpl.zzbCK, i, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzio(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmi(i);
    }

    public DefaultPersonImpl zzio(Parcel parcel) {
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
        LegacyFields legacyFields = null;
        List list12 = null;
        List list13 = null;
        Metadata metadata = null;
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
        SortKeys sortKeys = null;
        List list24 = null;
        List list25 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    list = zza.zzc(parcel, zzbc, Abouts.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    list2 = zza.zzc(parcel, zzbc, Addresses.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    list3 = zza.zzc(parcel, zzbc, Birthdays.CREATOR);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    list4 = zza.zzc(parcel, zzbc, BraggingRights.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    list5 = zza.zzc(parcel, zzbc, CoverPhotos.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    list6 = zza.zzc(parcel, zzbc, CustomFields.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    list7 = zza.zzc(parcel, zzbc, Emails.CREATOR);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    list8 = zza.zzc(parcel, zzbc, Events.CREATOR);
                    hashSet.add(Integer.valueOf(11));
                    break;
                case 12:
                    list9 = zza.zzc(parcel, zzbc, Genders.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 13:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    list10 = zza.zzc(parcel, zzbc, Images.CREATOR);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    list11 = zza.zzc(parcel, zzbc, InstantMessaging.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    break;
                case 17:
                    str4 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(17));
                    break;
                case 18:
                    LegacyFields legacyFields2 = (LegacyFields) zza.zza(parcel, zzbc, (Creator) LegacyFields.CREATOR);
                    hashSet.add(Integer.valueOf(18));
                    legacyFields = legacyFields2;
                    break;
                case 19:
                    list12 = zza.zzc(parcel, zzbc, DefaultPersonImpl.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    break;
                case 20:
                    list13 = zza.zzc(parcel, zzbc, Memberships.CREATOR);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    Metadata metadata2 = (Metadata) zza.zza(parcel, zzbc, (Creator) Metadata.CREATOR);
                    hashSet.add(Integer.valueOf(21));
                    metadata = metadata2;
                    break;
                case 22:
                    list14 = zza.zzc(parcel, zzbc, Names.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    list15 = zza.zzc(parcel, zzbc, Nicknames.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    list16 = zza.zzc(parcel, zzbc, Occupations.CREATOR);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    list17 = zza.zzc(parcel, zzbc, Organizations.CREATOR);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case LogSource.ANDROID_CAMERA /*26*/:
                    list18 = zza.zzc(parcel, zzbc, PhoneNumbers.CREATOR);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case LogSource.CW /*27*/:
                    list19 = zza.zzc(parcel, zzbc, PlacesLived.CREATOR);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case LogSource.GEL /*28*/:
                    str5 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case LogSource.DNA_PROBER /*29*/:
                    list20 = zza.zzc(parcel, zzbc, Relations.CREATOR);
                    hashSet.add(Integer.valueOf(29));
                    break;
                case LogSource.UDR /*30*/:
                    list21 = zza.zzc(parcel, zzbc, RelationshipInterests.CREATOR);
                    hashSet.add(Integer.valueOf(30));
                    break;
                case LogSource.GMS_CORE_WALLET /*31*/:
                    list22 = zza.zzc(parcel, zzbc, RelationshipStatuses.CREATOR);
                    hashSet.add(Integer.valueOf(31));
                    break;
                case 32:
                    list23 = zza.zzc(parcel, zzbc, Skills.CREATOR);
                    hashSet.add(Integer.valueOf(32));
                    break;
                case 33:
                    SortKeys sortKeys2 = (SortKeys) zza.zza(parcel, zzbc, (Creator) SortKeys.CREATOR);
                    hashSet.add(Integer.valueOf(33));
                    sortKeys = sortKeys2;
                    break;
                case 34:
                    list24 = zza.zzc(parcel, zzbc, Taglines.CREATOR);
                    hashSet.add(Integer.valueOf(34));
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                    list25 = zza.zzc(parcel, zzbc, Urls.CREATOR);
                    hashSet.add(Integer.valueOf(35));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new DefaultPersonImpl(hashSet, i, list, list2, str, list3, list4, list5, list6, list7, str2, list8, list9, str3, list10, list11, str4, legacyFields, list12, list13, metadata, list14, list15, list16, list17, list18, list19, str5, list20, list21, list22, list23, sortKeys, list24, list25);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public DefaultPersonImpl[] zzmi(int i) {
        return new DefaultPersonImpl[i];
    }
}

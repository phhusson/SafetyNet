package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.PersonMetadataImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.ProfileOwnerStatsImpl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzbe implements Creator<PersonMetadataImpl> {
    static void zza(PersonMetadataImpl personMetadataImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = personMetadataImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, personMetadataImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzb(parcel, 2, personMetadataImpl.zzblg, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zzb(parcel, 3, personMetadataImpl.zzbDe, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zzb(parcel, 4, personMetadataImpl.zzbAk, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zzb(parcel, 5, personMetadataImpl.zzbDg, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zzb(parcel, 6, personMetadataImpl.zzbDi, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zzb(parcel, 7, personMetadataImpl.zzbDk, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, personMetadataImpl.zzaMS, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, personMetadataImpl.zzbDm, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zzb(parcel, 10, personMetadataImpl.zzbDn, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            zzb.zza(parcel, 11, personMetadataImpl.zzbDp, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zza(parcel, 12, personMetadataImpl.zzbDV, i, true);
        }
        if (set.contains(Integer.valueOf(13))) {
            zzb.zza(parcel, 13, personMetadataImpl.zzbDf);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzb.zza(parcel, 14, personMetadataImpl.zzbDh);
        }
        if (set.contains(Integer.valueOf(15))) {
            zzb.zza(parcel, 15, personMetadataImpl.zzbDj);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzji(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzni(i);
    }

    public PersonMetadataImpl zzji(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        List list = null;
        List list2 = null;
        List list3 = null;
        List list4 = null;
        List list5 = null;
        List list6 = null;
        String str = null;
        String str2 = null;
        List list7 = null;
        String str3 = null;
        ProfileOwnerStatsImpl profileOwnerStatsImpl = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    list = zza.zzE(parcel, zzbc);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    list2 = zza.zzE(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    list3 = zza.zzE(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    list4 = zza.zzE(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    list5 = zza.zzE(parcel, zzbc);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    list6 = zza.zzE(parcel, zzbc);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    list7 = zza.zzE(parcel, zzbc);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(11));
                    break;
                case 12:
                    ProfileOwnerStatsImpl profileOwnerStatsImpl2 = (ProfileOwnerStatsImpl) zza.zza(parcel, zzbc, ProfileOwnerStatsImpl.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    profileOwnerStatsImpl = profileOwnerStatsImpl2;
                    break;
                case 13:
                    z = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    z2 = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    z3 = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(15));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new PersonMetadataImpl(hashSet, i, list, list2, list3, list4, list5, list6, str, str2, list7, str3, profileOwnerStatsImpl, z, z2, z3);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public PersonMetadataImpl[] zzni(int i) {
        return new PersonMetadataImpl[i];
    }
}

package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Metadata;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Metadata.Affinities;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Metadata.ProfileOwnerStats;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzx implements Creator<Metadata> {
    static void zza(Metadata metadata, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = metadata.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, metadata.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, metadata.zzbCd, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zzb(parcel, 3, metadata.zzblg, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zzb(parcel, 4, metadata.zzbDe, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, metadata.zzbDf);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zzb(parcel, 6, metadata.zzbAk, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zzb(parcel, 7, metadata.zzbDg, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, metadata.zzbDh);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zzb(parcel, 9, metadata.zzbDi, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zza(parcel, 10, metadata.zzbDj);
        }
        if (set.contains(Integer.valueOf(11))) {
            zzb.zzb(parcel, 11, metadata.zzbDk, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zza(parcel, 12, metadata.zzbDl);
        }
        if (set.contains(Integer.valueOf(13))) {
            zzb.zza(parcel, 13, metadata.zzaMS, true);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzb.zza(parcel, 14, metadata.zzbDm, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            zzb.zzb(parcel, 15, metadata.zzbDn, true);
        }
        if (set.contains(Integer.valueOf(17))) {
            zzb.zza(parcel, 17, metadata.zzbDp, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            zzb.zzc(parcel, 16, metadata.zzbDo, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            zzb.zza(parcel, 18, metadata.zzbDq, i, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmw(i);
    }

    public Metadata zziC(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        List list = null;
        List list2 = null;
        List list3 = null;
        boolean z = false;
        List list4 = null;
        List list5 = null;
        boolean z2 = false;
        List list6 = null;
        boolean z3 = false;
        List list7 = null;
        long j = 0;
        String str = null;
        String str2 = null;
        List list8 = null;
        List list9 = null;
        String str3 = null;
        ProfileOwnerStats profileOwnerStats = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    list = zza.zzc(parcel, zzbc, Affinities.CREATOR);
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
                    z = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    list4 = zza.zzE(parcel, zzbc);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    list5 = zza.zzE(parcel, zzbc);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    z2 = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    list6 = zza.zzE(parcel, zzbc);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    z3 = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    list7 = zza.zzE(parcel, zzbc);
                    hashSet.add(Integer.valueOf(11));
                    break;
                case 12:
                    j = zza.zzi(parcel, zzbc);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 13:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    list8 = zza.zzE(parcel, zzbc);
                    hashSet.add(Integer.valueOf(15));
                    break;
                case 16:
                    list9 = zza.zzc(parcel, zzbc, DefaultPersonImpl.CREATOR);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 17:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(17));
                    break;
                case 18:
                    ProfileOwnerStats profileOwnerStats2 = (ProfileOwnerStats) zza.zza(parcel, zzbc, (Creator) ProfileOwnerStats.CREATOR);
                    hashSet.add(Integer.valueOf(18));
                    profileOwnerStats = profileOwnerStats2;
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new Metadata(hashSet, i, list, list2, list3, z, list4, list5, z2, list6, z3, list7, j, str, str2, list8, list9, str3, profileOwnerStats);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Metadata[] zzmw(int i) {
        return new Metadata[i];
    }
}

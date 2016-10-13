package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Metadata.ProfileOwnerStats;
import java.util.HashSet;
import java.util.Set;

public class zzz implements Creator<ProfileOwnerStats> {
    static void zza(ProfileOwnerStats profileOwnerStats, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = profileOwnerStats.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, profileOwnerStats.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, profileOwnerStats.zzbDr);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, profileOwnerStats.zzbDs);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmy(i);
    }

    public ProfileOwnerStats zziE(Parcel parcel) {
        long j = 0;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzbc);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    j = zza.zzi(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new ProfileOwnerStats(hashSet, i, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ProfileOwnerStats[] zzmy(int i) {
        return new ProfileOwnerStats[i];
    }
}

package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.ProfileOwnerStatsImpl;
import java.util.HashSet;
import java.util.Set;

public class zzbj implements Creator<ProfileOwnerStatsImpl> {
    static void zza(ProfileOwnerStatsImpl profileOwnerStatsImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = profileOwnerStatsImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, profileOwnerStatsImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, profileOwnerStatsImpl.zzbDr);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, profileOwnerStatsImpl.zzbDs);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznm(i);
    }

    public ProfileOwnerStatsImpl zzjm(Parcel parcel) {
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
            return new ProfileOwnerStatsImpl(hashSet, i, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ProfileOwnerStatsImpl[] zznm(int i) {
        return new ProfileOwnerStatsImpl[i];
    }
}

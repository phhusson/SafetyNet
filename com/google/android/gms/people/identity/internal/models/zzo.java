package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.CoverPhotos;
import java.util.HashSet;
import java.util.Set;

public class zzo implements Creator<CoverPhotos> {
    static void zza(CoverPhotos coverPhotos, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = coverPhotos.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, coverPhotos.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, coverPhotos.zzoX);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, coverPhotos.zzyU, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, coverPhotos.zzbCX);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, coverPhotos.zzE, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zzc(parcel, 6, coverPhotos.zzoW);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzit(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmn(i);
    }

    public CoverPhotos zzit(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        boolean z = false;
        String str2 = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i3 = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    z = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new CoverPhotos(hashSet, i3, i2, str2, z, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public CoverPhotos[] zzmn(int i) {
        return new CoverPhotos[i];
    }
}

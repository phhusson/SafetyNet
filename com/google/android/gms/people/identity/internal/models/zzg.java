package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultMetadataImpl.Affinities;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzg implements Creator<DefaultMetadataImpl> {
    static void zza(DefaultMetadataImpl defaultMetadataImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = defaultMetadataImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, defaultMetadataImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, defaultMetadataImpl.zzbCd, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, defaultMetadataImpl.zzbCe, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, defaultMetadataImpl.zzbCf, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, defaultMetadataImpl.zzbCg, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, defaultMetadataImpl.zzbCh);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, defaultMetadataImpl.zzbAo);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, defaultMetadataImpl.zzbCi);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, defaultMetadataImpl.zzbCj, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zza(parcel, 10, defaultMetadataImpl.zzbCk);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzim(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmg(i);
    }

    public DefaultMetadataImpl zzim(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        List list = null;
        int i = 0;
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
                    str4 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    z4 = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    z3 = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    z2 = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    z = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new DefaultMetadataImpl(hashSet, i, list, str4, str3, str2, z4, z3, z2, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public DefaultMetadataImpl[] zzmg(int i) {
        return new DefaultMetadataImpl[i];
    }
}

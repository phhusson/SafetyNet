package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import java.util.HashSet;
import java.util.Set;

public class zzax implements Creator<MetadataImpl> {
    static void zza(MetadataImpl metadataImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = metadataImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, metadataImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, metadataImpl.zzbCe, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, metadataImpl.zzbCf, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, metadataImpl.zzbCg, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, metadataImpl.zzbCj, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, metadataImpl.zzbCh);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, metadataImpl.zzbAo);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, metadataImpl.zzbCi);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, metadataImpl.zzbCk);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zzc(parcel, 10, metadataImpl.zzbDU);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmW(i);
    }

    public MetadataImpl zzjb(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i2 = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str4 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str = zza.zzq(parcel, zzbc);
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
                    z = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new MetadataImpl(hashSet, i2, str4, str3, str2, str, z4, z3, z2, z, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public MetadataImpl[] zzmW(int i) {
        return new MetadataImpl[i];
    }
}

package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Addresses;
import java.util.HashSet;
import java.util.Set;

public class zzl implements Creator<Addresses> {
    static void zza(Addresses addresses, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = addresses.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, addresses.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, addresses.zzbCO, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, addresses.zzbCP, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, addresses.zzbCQ, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, addresses.zzbCR, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, addresses.zzbCN, i, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, addresses.zzbCS, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, addresses.zzbCT, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, addresses.zzbCU, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zza(parcel, 10, addresses.zzbCV, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            zzb.zza(parcel, 11, addresses.zzKj, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zza(parcel, 12, addresses.mValue, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmk(i);
    }

    public Addresses zziq(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        DefaultMetadataImpl defaultMetadataImpl = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str4 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    DefaultMetadataImpl defaultMetadataImpl2 = (DefaultMetadataImpl) zza.zza(parcel, zzbc, DefaultMetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    defaultMetadataImpl = defaultMetadataImpl2;
                    break;
                case 7:
                    str5 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str6 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str7 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    str8 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    str9 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(11));
                    break;
                case 12:
                    str10 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(12));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new Addresses(hashSet, i, str, str2, str3, str4, defaultMetadataImpl, str5, str6, str7, str8, str9, str10);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Addresses[] zzmk(int i) {
        return new Addresses[i];
    }
}

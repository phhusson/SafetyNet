package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Names;
import java.util.HashSet;
import java.util.Set;

public class zzaa implements Creator<Names> {
    static void zza(Names names, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = names.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, names.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, names.zzVA, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, names.zzbDt, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, names.zzbDu, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, names.zzbDv, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, names.zzbDw, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, names.zzbDx, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, names.zzbCN, i, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, names.zzbDy, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zza(parcel, 10, names.zzbDz, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            zzb.zza(parcel, 11, names.zzbDA, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zza(parcel, 12, names.zzbDB, true);
        }
        if (set.contains(Integer.valueOf(13))) {
            zzb.zza(parcel, 13, names.zzbDC, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmz(i);
    }

    public Names zziF(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        DefaultMetadataImpl defaultMetadataImpl = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
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
                    str5 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str6 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    DefaultMetadataImpl defaultMetadataImpl2 = (DefaultMetadataImpl) zza.zza(parcel, zzbc, DefaultMetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    defaultMetadataImpl = defaultMetadataImpl2;
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
                case 13:
                    str11 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(13));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new Names(hashSet, i, str, str2, str3, str4, str5, str6, defaultMetadataImpl, str7, str8, str9, str10, str11);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Names[] zzmz(int i) {
        return new Names[i];
    }
}

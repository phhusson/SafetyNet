package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.NamesImpl;
import java.util.HashSet;
import java.util.Set;

public class zzay implements Creator<NamesImpl> {
    static void zza(NamesImpl namesImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = namesImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, namesImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, namesImpl.zzbDR, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, namesImpl.zzVA, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, namesImpl.zzbDt, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, namesImpl.zzbDu, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, namesImpl.zzbDv, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, namesImpl.zzbDw, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, namesImpl.zzbDx, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, namesImpl.zzbDy, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zza(parcel, 10, namesImpl.zzbDz, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            zzb.zza(parcel, 11, namesImpl.zzbDA, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zza(parcel, 12, namesImpl.zzbDB, true);
        }
        if (set.contains(Integer.valueOf(13))) {
            zzb.zza(parcel, 13, namesImpl.zzbDC, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjc(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmX(i);
    }

    public NamesImpl zzjc(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        MetadataImpl metadataImpl = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
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
                    MetadataImpl metadataImpl2 = (MetadataImpl) zza.zza(parcel, zzbc, MetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    metadataImpl = metadataImpl2;
                    break;
                case 3:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str4 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(6));
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
            return new NamesImpl(hashSet, i, metadataImpl, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public NamesImpl[] zzmX(int i) {
        return new NamesImpl[i];
    }
}

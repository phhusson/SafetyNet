package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.SortKeysImpl;
import java.util.HashSet;
import java.util.Set;

public class zzbo implements Creator<SortKeysImpl> {
    static void zza(SortKeysImpl sortKeysImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = sortKeysImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, sortKeysImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, sortKeysImpl.zzbDM, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, sortKeysImpl.mName, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjr(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznr(i);
    }

    public SortKeysImpl zzjr(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new SortKeysImpl(hashSet, i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public SortKeysImpl[] zznr(int i) {
        return new SortKeysImpl[i];
    }
}

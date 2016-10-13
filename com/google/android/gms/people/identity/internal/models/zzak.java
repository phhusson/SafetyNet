package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.SortKeys;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.SortKeys.Affinities;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzak implements Creator<SortKeys> {
    static void zza(SortKeys sortKeys, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = sortKeys.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, sortKeys.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, sortKeys.zzbCd, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, sortKeys.zzbDM, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, sortKeys.mName, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmJ(i);
    }

    public SortKeys zziP(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        List list = null;
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
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new SortKeys(hashSet, i, list, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public SortKeys[] zzmJ(int i) {
        return new SortKeys[i];
    }
}

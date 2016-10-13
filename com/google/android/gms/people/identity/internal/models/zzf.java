package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.CustomFieldsImpl;
import java.util.HashSet;
import java.util.Set;

public class zzf implements Creator<CustomFieldsImpl> {
    static void zza(CustomFieldsImpl customFieldsImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = customFieldsImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, customFieldsImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, customFieldsImpl.zzvV, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, customFieldsImpl.mValue, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzil(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmf(i);
    }

    public CustomFieldsImpl zzil(Parcel parcel) {
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
            return new CustomFieldsImpl(hashSet, i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public CustomFieldsImpl[] zzmf(int i) {
        return new CustomFieldsImpl[i];
    }
}

package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.LegacyFieldsImpl;
import java.util.HashSet;
import java.util.Set;

public class zzav implements Creator<LegacyFieldsImpl> {
    static void zza(LegacyFieldsImpl legacyFieldsImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = legacyFieldsImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, legacyFieldsImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, legacyFieldsImpl.zzbDa, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmU(i);
    }

    public LegacyFieldsImpl zziZ(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
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
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new LegacyFieldsImpl(hashSet, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public LegacyFieldsImpl[] zzmU(int i) {
        return new LegacyFieldsImpl[i];
    }
}

package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Genders;
import java.util.HashSet;
import java.util.Set;

public class zzs implements Creator<Genders> {
    static void zza(Genders genders, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = genders.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, genders.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, genders.zzaWt, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, genders.zzbCN, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, genders.mValue, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzix(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmr(i);
    }

    public Genders zzix(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        DefaultMetadataImpl defaultMetadataImpl = null;
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
                    DefaultMetadataImpl defaultMetadataImpl2 = (DefaultMetadataImpl) zza.zza(parcel, zzbc, DefaultMetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    defaultMetadataImpl = defaultMetadataImpl2;
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
            return new Genders(hashSet, i, str2, defaultMetadataImpl, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Genders[] zzmr(int i) {
        return new Genders[i];
    }
}

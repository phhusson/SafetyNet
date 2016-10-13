package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Occupations;
import java.util.HashSet;
import java.util.Set;

public class zzac implements Creator<Occupations> {
    static void zza(Occupations occupations, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = occupations.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, occupations.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, occupations.zzbCN, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, occupations.mValue, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmB(i);
    }

    public Occupations zziH(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        DefaultMetadataImpl defaultMetadataImpl = null;
        while (parcel.dataPosition() < zzbd) {
            DefaultMetadataImpl defaultMetadataImpl2;
            int i2;
            String str2;
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    zzbc = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    String str3 = str;
                    defaultMetadataImpl2 = defaultMetadataImpl;
                    i2 = zzbc;
                    str2 = str3;
                    break;
                case 2:
                    DefaultMetadataImpl defaultMetadataImpl3 = (DefaultMetadataImpl) zza.zza(parcel, zzbc, DefaultMetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    i2 = i;
                    DefaultMetadataImpl defaultMetadataImpl4 = defaultMetadataImpl3;
                    str2 = str;
                    defaultMetadataImpl2 = defaultMetadataImpl4;
                    break;
                case 3:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    defaultMetadataImpl2 = defaultMetadataImpl;
                    i2 = i;
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    str2 = str;
                    defaultMetadataImpl2 = defaultMetadataImpl;
                    i2 = i;
                    break;
            }
            i = i2;
            defaultMetadataImpl = defaultMetadataImpl2;
            str = str2;
        }
        if (parcel.dataPosition() == zzbd) {
            return new Occupations(hashSet, i, defaultMetadataImpl, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Occupations[] zzmB(int i) {
        return new Occupations[i];
    }
}

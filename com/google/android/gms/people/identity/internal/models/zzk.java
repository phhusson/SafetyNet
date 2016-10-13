package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Abouts;
import java.util.HashSet;
import java.util.Set;

public class zzk implements Creator<Abouts> {
    static void zza(Abouts abouts, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = abouts.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, abouts.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, abouts.zzbCN, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, abouts.zzKj, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, abouts.mValue, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzip(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmj(i);
    }

    public Abouts zzip(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        DefaultMetadataImpl defaultMetadataImpl = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    DefaultMetadataImpl defaultMetadataImpl2 = (DefaultMetadataImpl) zza.zza(parcel, zzbc, DefaultMetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    defaultMetadataImpl = defaultMetadataImpl2;
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
            return new Abouts(hashSet, i, defaultMetadataImpl, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Abouts[] zzmj(int i) {
        return new Abouts[i];
    }
}

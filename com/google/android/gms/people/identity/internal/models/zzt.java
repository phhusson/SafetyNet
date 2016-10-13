package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Images;
import java.util.HashSet;
import java.util.Set;

public class zzt implements Creator<Images> {
    static void zza(Images images, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = images.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, images.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, images.zzbCX);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, images.zzbCN, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, images.zzE, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzms(i);
    }

    public Images zziy(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        DefaultMetadataImpl defaultMetadataImpl = null;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    z = zza.zzc(parcel, zzbc);
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
            return new Images(hashSet, i, z, defaultMetadataImpl, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Images[] zzms(int i) {
        return new Images[i];
    }
}

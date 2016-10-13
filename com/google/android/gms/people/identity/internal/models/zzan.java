package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Urls;
import java.util.HashSet;
import java.util.Set;

public class zzan implements Creator<Urls> {
    static void zza(Urls urls, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = urls.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, urls.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, urls.zzbCR, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, urls.zzbCN, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, urls.zzKj, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, urls.mValue, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmM(i);
    }

    public Urls zziS(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        DefaultMetadataImpl defaultMetadataImpl = null;
        String str3 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    DefaultMetadataImpl defaultMetadataImpl2 = (DefaultMetadataImpl) zza.zza(parcel, zzbc, DefaultMetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    defaultMetadataImpl = defaultMetadataImpl2;
                    break;
                case 4:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new Urls(hashSet, i, str3, defaultMetadataImpl, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Urls[] zzmM(int i) {
        return new Urls[i];
    }
}

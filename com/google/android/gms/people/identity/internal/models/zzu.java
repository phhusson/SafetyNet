package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.InstantMessaging;
import java.util.HashSet;
import java.util.Set;

public class zzu implements Creator<InstantMessaging> {
    static void zza(InstantMessaging instantMessaging, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = instantMessaging.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, instantMessaging.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, instantMessaging.zzbCY, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, instantMessaging.zzbCR, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, instantMessaging.zzbCN, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, instantMessaging.zzbCZ, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, instantMessaging.zzKj, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, instantMessaging.mValue, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmt(i);
    }

    public InstantMessaging zziz(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        DefaultMetadataImpl defaultMetadataImpl = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str5 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str4 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    DefaultMetadataImpl defaultMetadataImpl2 = (DefaultMetadataImpl) zza.zza(parcel, zzbc, DefaultMetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    defaultMetadataImpl = defaultMetadataImpl2;
                    break;
                case 5:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new InstantMessaging(hashSet, i, str5, str4, defaultMetadataImpl, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public InstantMessaging[] zzmt(int i) {
        return new InstantMessaging[i];
    }
}

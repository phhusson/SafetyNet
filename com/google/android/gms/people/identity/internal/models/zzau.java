package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.InstantMessagingImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import java.util.HashSet;
import java.util.Set;

public class zzau implements Creator<InstantMessagingImpl> {
    static void zza(InstantMessagingImpl instantMessagingImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = instantMessagingImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, instantMessagingImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, instantMessagingImpl.zzbDR, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, instantMessagingImpl.zzbCY, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, instantMessagingImpl.zzbCR, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, instantMessagingImpl.zzbCZ, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, instantMessagingImpl.zzKj, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, instantMessagingImpl.mValue, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmT(i);
    }

    public InstantMessagingImpl zziY(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MetadataImpl metadataImpl = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    MetadataImpl metadataImpl2 = (MetadataImpl) zza.zza(parcel, zzbc, MetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    metadataImpl = metadataImpl2;
                    break;
                case 3:
                    str5 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str4 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
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
            return new InstantMessagingImpl(hashSet, i, metadataImpl, str5, str4, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public InstantMessagingImpl[] zzmT(int i) {
        return new InstantMessagingImpl[i];
    }
}

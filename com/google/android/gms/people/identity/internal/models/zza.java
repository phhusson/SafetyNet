package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.AboutsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import java.util.HashSet;
import java.util.Set;

public class zza implements Creator<AboutsImpl> {
    static void zza(AboutsImpl aboutsImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = aboutsImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, aboutsImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, aboutsImpl.zzbDR, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, aboutsImpl.zzKj, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, aboutsImpl.mValue, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzig(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzma(i);
    }

    public AboutsImpl zzig(Parcel parcel) {
        String str = null;
        int zzbd = com.google.android.gms.common.internal.safeparcel.zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        MetadataImpl metadataImpl = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = com.google.android.gms.common.internal.safeparcel.zza.zzbc(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzdr(zzbc)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    MetadataImpl metadataImpl2 = (MetadataImpl) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzbc, MetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    metadataImpl = metadataImpl2;
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AboutsImpl(hashSet, i, metadataImpl, str2, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AboutsImpl[] zzma(int i) {
        return new AboutsImpl[i];
    }
}

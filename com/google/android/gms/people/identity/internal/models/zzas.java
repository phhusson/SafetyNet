package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzas implements Creator<ImageReferenceImpl> {
    static void zza(ImageReferenceImpl imageReferenceImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = imageReferenceImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, imageReferenceImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, imageReferenceImpl.zzUO);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, imageReferenceImpl.zzbDH, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, imageReferenceImpl.mData, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziW(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmR(i);
    }

    public ImageReferenceImpl zziW(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i2 = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    bArr = zza.zzt(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new ImageReferenceImpl(hashSet, i2, i, str, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ImageReferenceImpl[] zzmR(int i) {
        return new ImageReferenceImpl[i];
    }
}

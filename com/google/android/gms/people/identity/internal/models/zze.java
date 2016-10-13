package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.CoverPhotosImpl;
import java.util.HashSet;
import java.util.Set;

public class zze implements Creator<CoverPhotosImpl> {
    static void zza(CoverPhotosImpl coverPhotosImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = coverPhotosImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, coverPhotosImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, coverPhotosImpl.zzoX);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, coverPhotosImpl.zzyU, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, coverPhotosImpl.zzbDS, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zzc(parcel, 5, coverPhotosImpl.zzoW);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, coverPhotosImpl.zzbDT);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzik(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzme(i);
    }

    public CoverPhotosImpl zzik(Parcel parcel) {
        ImageReferenceImpl imageReferenceImpl = null;
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i3 = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    ImageReferenceImpl imageReferenceImpl2 = (ImageReferenceImpl) zza.zza(parcel, zzbc, ImageReferenceImpl.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    imageReferenceImpl = imageReferenceImpl2;
                    break;
                case 5:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    z = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new CoverPhotosImpl(hashSet, i3, i2, str, imageReferenceImpl, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public CoverPhotosImpl[] zzme(int i) {
        return new CoverPhotosImpl[i];
    }
}

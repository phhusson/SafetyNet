package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.ImagesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import java.util.HashSet;
import java.util.Set;

public class zzat implements Creator<ImagesImpl> {
    static void zza(ImagesImpl imagesImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = imagesImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, imagesImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, imagesImpl.zzbDR, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, imagesImpl.zzbDS, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, imagesImpl.zzbDT);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziX(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmS(i);
    }

    public ImagesImpl zziX(Parcel parcel) {
        ImageReferenceImpl imageReferenceImpl = null;
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        MetadataImpl metadataImpl = null;
        int i = 0;
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
                    ImageReferenceImpl imageReferenceImpl2 = (ImageReferenceImpl) zza.zza(parcel, zzbc, ImageReferenceImpl.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    imageReferenceImpl = imageReferenceImpl2;
                    break;
                case 4:
                    z = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new ImagesImpl(hashSet, i, metadataImpl, imageReferenceImpl, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ImagesImpl[] zzmS(int i) {
        return new ImagesImpl[i];
    }
}

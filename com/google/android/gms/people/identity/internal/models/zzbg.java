package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzbg implements Creator<PersonReferenceImpl> {
    static void zza(PersonReferenceImpl personReferenceImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = personReferenceImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, personReferenceImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, personReferenceImpl.mName, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, personReferenceImpl.zzatl, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, personReferenceImpl.zzbDW, i, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznj(i);
    }

    public PersonReferenceImpl zzjj(Parcel parcel) {
        ImageReferenceImpl imageReferenceImpl = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str2 = zza.zzq(parcel, zzbc);
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
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new PersonReferenceImpl(hashSet, i, str2, str, imageReferenceImpl);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public PersonReferenceImpl[] zznj(int i) {
        return new PersonReferenceImpl[i];
    }
}

package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.PlacesLivedImpl;
import java.util.HashSet;
import java.util.Set;

public class zzbi implements Creator<PlacesLivedImpl> {
    static void zza(PlacesLivedImpl placesLivedImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = placesLivedImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, placesLivedImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, placesLivedImpl.zzbDR, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, placesLivedImpl.zzbDD);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, placesLivedImpl.mValue, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznl(i);
    }

    public PlacesLivedImpl zzjl(Parcel parcel) {
        String str = null;
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
                    z = zza.zzc(parcel, zzbc);
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
            return new PlacesLivedImpl(hashSet, i, metadataImpl, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public PlacesLivedImpl[] zznl(int i) {
        return new PlacesLivedImpl[i];
    }
}

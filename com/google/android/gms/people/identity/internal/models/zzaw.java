package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MembershipsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import java.util.HashSet;
import java.util.Set;

public class zzaw implements Creator<MembershipsImpl> {
    static void zza(MembershipsImpl membershipsImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = membershipsImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, membershipsImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, membershipsImpl.zzbDR, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, membershipsImpl.zzbDb, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, membershipsImpl.zzbDc, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, membershipsImpl.zzbDd, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzja(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmV(i);
    }

    public MembershipsImpl zzja(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
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
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
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
            return new MembershipsImpl(hashSet, i, metadataImpl, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public MembershipsImpl[] zzmV(int i) {
        return new MembershipsImpl[i];
    }
}

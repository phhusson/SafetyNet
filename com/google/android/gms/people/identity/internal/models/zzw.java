package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Memberships;
import java.util.HashSet;
import java.util.Set;

public class zzw implements Creator<Memberships> {
    static void zza(Memberships memberships, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = memberships.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, memberships.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, memberships.zzbDb, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, memberships.zzbDc, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, memberships.zzbCN, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, memberships.zzbDd, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmv(i);
    }

    public Memberships zziB(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        DefaultMetadataImpl defaultMetadataImpl = null;
        String str2 = null;
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
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    DefaultMetadataImpl defaultMetadataImpl2 = (DefaultMetadataImpl) zza.zza(parcel, zzbc, DefaultMetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    defaultMetadataImpl = defaultMetadataImpl2;
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
            return new Memberships(hashSet, i, str3, str2, defaultMetadataImpl, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Memberships[] zzmv(int i) {
        return new Memberships[i];
    }
}

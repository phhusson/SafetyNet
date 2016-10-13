package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Metadata.Affinities;
import java.util.HashSet;
import java.util.Set;

public class zzy implements Creator<Affinities> {
    static void zza(Affinities affinities, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = affinities.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, affinities.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, affinities.zzKj, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, affinities.zzbCl);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziD(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmx(i);
    }

    public Affinities zziD(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        double d = 0.0d;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    d = zza.zzn(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new Affinities(hashSet, i, str, d);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Affinities[] zzmx(int i) {
        return new Affinities[i];
    }
}

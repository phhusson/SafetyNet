package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Birthdays;
import java.util.HashSet;
import java.util.Set;

public class zzm implements Creator<Birthdays> {
    static void zza(Birthdays birthdays, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = birthdays.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, birthdays.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, birthdays.zzbCW, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, birthdays.zzbCN, i, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzir(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzml(i);
    }

    public Birthdays zzir(Parcel parcel) {
        DefaultMetadataImpl defaultMetadataImpl = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
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
                    defaultMetadataImpl = (DefaultMetadataImpl) zza.zza(parcel, zzbc, DefaultMetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new Birthdays(hashSet, i, str, defaultMetadataImpl);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Birthdays[] zzml(int i) {
        return new Birthdays[i];
    }
}

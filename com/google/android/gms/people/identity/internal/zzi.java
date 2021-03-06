package com.google.android.gms.people.identity.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<ParcelableGetOptions> {
    static void zza(ParcelableGetOptions parcelableGetOptions, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zza(parcel, 1, parcelableGetOptions.zzbBZ);
        zzb.zzc(parcel, 1000, parcelableGetOptions.getVersionCode());
        zzb.zza(parcel, 2, parcelableGetOptions.zzbAd);
        zzb.zza(parcel, 3, parcelableGetOptions.zzbzY, false);
        zzb.zza(parcel, 4, parcelableGetOptions.zzbCa);
        zzb.zza(parcel, 5, parcelableGetOptions.zzbzZ, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzie(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlY(i);
    }

    public ParcelableGetOptions zzie(Parcel parcel) {
        Bundle bundle = null;
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    z3 = zza.zzc(parcel, zzbc);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 3:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 5:
                    bundle = zza.zzs(parcel, zzbc);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new ParcelableGetOptions(i, z3, z2, z, str, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ParcelableGetOptions[] zzlY(int i) {
        return new ParcelableGetOptions[i];
    }
}

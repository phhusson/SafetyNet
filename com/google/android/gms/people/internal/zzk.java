package com.google.android.gms.people.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<ParcelableLoadImageOptions> {
    static void zza(ParcelableLoadImageOptions parcelableLoadImageOptions, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, parcelableLoadImageOptions.getImageSize());
        zzb.zzc(parcel, 1000, parcelableLoadImageOptions.getVersionCode());
        zzb.zzc(parcel, 2, parcelableLoadImageOptions.zzJn());
        zzb.zza(parcel, 3, parcelableLoadImageOptions.zzJo());
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzju(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznw(i);
    }

    public ParcelableLoadImageOptions zzju(Parcel parcel) {
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new ParcelableLoadImageOptions(i3, i2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ParcelableLoadImageOptions[] zznw(int i) {
        return new ParcelableLoadImageOptions[i];
    }
}

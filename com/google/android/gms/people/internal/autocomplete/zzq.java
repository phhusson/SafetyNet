package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<PhotoImpl> {
    static void zza(PhotoImpl photoImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, photoImpl.mVersionCode);
        zzb.zzc(parcel, 2, photoImpl.zzvU);
        zzb.zza(parcel, 3, photoImpl.zzbDH, false);
        zzb.zza(parcel, 4, photoImpl.zzbCX);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjJ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznN(i);
    }

    public PhotoImpl zzjJ(Parcel parcel) {
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
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
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new PhotoImpl(i2, i, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public PhotoImpl[] zznN(int i) {
        return new PhotoImpl[i];
    }
}

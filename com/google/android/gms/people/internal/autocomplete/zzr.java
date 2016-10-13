package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr implements Creator<SubstringImpl> {
    static void zza(SubstringImpl substringImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, substringImpl.mVersionCode);
        zzb.zzc(parcel, 2, substringImpl.zzbIr);
        zzb.zzc(parcel, 3, substringImpl.mLength);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznO(i);
    }

    public SubstringImpl zzjK(Parcel parcel) {
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i3 = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new SubstringImpl(i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public SubstringImpl[] zznO(int i) {
        return new SubstringImpl[i];
    }
}

package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<DisplayableFieldImpl> {
    static void zza(DisplayableFieldImpl displayableFieldImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, displayableFieldImpl.mVersionCode);
        zzb.zzc(parcel, 2, displayableFieldImpl.zzUO);
        zzb.zzc(parcel, 3, displayableFieldImpl.mIndex);
        zzb.zza(parcel, 4, displayableFieldImpl.mValue, false);
        zzb.zza(parcel, 5, displayableFieldImpl.zzbIj, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznE(i);
    }

    public DisplayableFieldImpl zzjA(Parcel parcel) {
        SubstringImpl[] substringImplArr = null;
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        String str = null;
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
                case 4:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    substringImplArr = (SubstringImpl[]) zza.zzb(parcel, zzbc, SubstringImpl.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new DisplayableFieldImpl(i3, i2, i, str, substringImplArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public DisplayableFieldImpl[] zznE(int i) {
        return new DisplayableFieldImpl[i];
    }
}

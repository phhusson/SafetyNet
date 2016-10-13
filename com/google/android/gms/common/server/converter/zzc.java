package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.converter.StringToIntConverter.Entry;

public class zzc implements Creator<Entry> {
    static void zza(Entry entry, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, entry.versionCode);
        zzb.zza(parcel, 2, entry.stringValue, false);
        zzb.zzc(parcel, 3, entry.zzaxA);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbi(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdx(i);
    }

    public Entry zzbi(Parcel parcel) {
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzbc);
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
            return new Entry(i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Entry[] zzdx(int i) {
        return new Entry[i];
    }
}

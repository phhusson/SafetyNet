package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzd implements Creator<TokenData> {
    static void zza(TokenData tokenData, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, tokenData.mVersionCode);
        zzb.zza(parcel, 2, tokenData.getToken(), false);
        zzb.zza(parcel, 3, tokenData.zzkh(), false);
        zzb.zza(parcel, 4, tokenData.zzki());
        zzb.zza(parcel, 5, tokenData.zzkj());
        zzb.zzb(parcel, 6, tokenData.zzkk(), false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaH(i);
    }

    public TokenData zzG(Parcel parcel) {
        List list = null;
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        boolean z2 = false;
        Long l = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    l = zza.zzj(parcel, zzbc);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 6:
                    list = zza.zzE(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new TokenData(i, str, l, z2, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public TokenData[] zzaH(int i) {
        return new TokenData[i];
    }
}

package com.google.android.gms.people.identity.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<AccountToken> {
    static void zza(AccountToken accountToken, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zza(parcel, 1, accountToken.getAccountName(), false);
        zzb.zzc(parcel, 1000, accountToken.getVersionCode());
        zzb.zza(parcel, 2, accountToken.zzGm(), false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzid(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlX(i);
    }

    public AccountToken zzid(Parcel parcel) {
        String str = null;
        int zzbd = com.google.android.gms.common.internal.safeparcel.zza.zzbd(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = com.google.android.gms.common.internal.safeparcel.zza.zzbc(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzdr(zzbc)) {
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzbc);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzbc);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzbc);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AccountToken(i, str2, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AccountToken[] zzlX(int i) {
        return new AccountToken[i];
    }
}

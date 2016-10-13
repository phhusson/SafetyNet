package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaa implements Creator<SignInButtonConfig> {
    static void zza(SignInButtonConfig signInButtonConfig, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, signInButtonConfig.mVersionCode);
        zzb.zzc(parcel, 2, signInButtonConfig.zzrv());
        zzb.zzc(parcel, 3, signInButtonConfig.zzrw());
        zzb.zza(parcel, 4, signInButtonConfig.zzrx(), i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzba(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdp(i);
    }

    public SignInButtonConfig zzba(Parcel parcel) {
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        Scope[] scopeArr = null;
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
                    scopeArr = (Scope[]) zza.zzb(parcel, zzbc, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new SignInButtonConfig(i3, i2, i, scopeArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public SignInButtonConfig[] zzdp(int i) {
        return new SignInButtonConfig[i];
    }
}

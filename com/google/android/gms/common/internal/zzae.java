package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzae implements Creator<ValidateAccountRequest> {
    static void zza(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, validateAccountRequest.mVersionCode);
        zzb.zzc(parcel, 2, validateAccountRequest.zzry());
        zzb.zza(parcel, 3, validateAccountRequest.zzavn, false);
        zzb.zza(parcel, 4, validateAccountRequest.zzrx(), i, false);
        zzb.zza(parcel, 5, validateAccountRequest.zzrz(), false);
        zzb.zza(parcel, 6, validateAccountRequest.getCallingPackage(), false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdq(i);
    }

    public ValidateAccountRequest zzbb(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
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
                    iBinder = zza.zzr(parcel, zzbc);
                    break;
                case 4:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzbc, Scope.CREATOR);
                    break;
                case 5:
                    bundle = zza.zzs(parcel, zzbc);
                    break;
                case 6:
                    str = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ValidateAccountRequest[] zzdq(int i) {
        return new ValidateAccountRequest[i];
    }
}

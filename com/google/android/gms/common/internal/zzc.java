package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<AuthAccountRequest> {
    static void zza(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, authAccountRequest.mVersionCode);
        zzb.zza(parcel, 2, authAccountRequest.zzavn, false);
        zzb.zza(parcel, 3, authAccountRequest.zzaqd, i, false);
        zzb.zza(parcel, 4, authAccountRequest.zzavo, false);
        zzb.zza(parcel, 5, authAccountRequest.zzavp, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdg(i);
    }

    public AuthAccountRequest zzaV(Parcel parcel) {
        Integer num = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    iBinder = zza.zzr(parcel, zzbc);
                    break;
                case 3:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzbc, Scope.CREATOR);
                    break;
                case 4:
                    num2 = zza.zzh(parcel, zzbc);
                    break;
                case 5:
                    num = zza.zzh(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num2, num);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AuthAccountRequest[] zzdg(int i) {
        return new AuthAccountRequest[i];
    }
}

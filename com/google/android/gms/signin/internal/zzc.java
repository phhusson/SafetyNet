package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzc implements Creator<CheckServerAuthResult> {
    static void zza(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, checkServerAuthResult.mVersionCode);
        zzb.zza(parcel, 2, checkServerAuthResult.zzbTS);
        zzb.zzc(parcel, 3, checkServerAuthResult.zzbTT, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzlg(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzps(i);
    }

    public CheckServerAuthResult zzlg(Parcel parcel) {
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzbc, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new CheckServerAuthResult(i, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public CheckServerAuthResult[] zzps(int i) {
        return new CheckServerAuthResult[i];
    }
}

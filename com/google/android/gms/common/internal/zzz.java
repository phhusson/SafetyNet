package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzz implements Creator<ResolveAccountResponse> {
    static void zza(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, resolveAccountResponse.mVersionCode);
        zzb.zza(parcel, 2, resolveAccountResponse.zzavn, false);
        zzb.zza(parcel, 3, resolveAccountResponse.zzrs(), i, false);
        zzb.zza(parcel, 4, resolveAccountResponse.zzrt());
        zzb.zza(parcel, 5, resolveAccountResponse.zzru());
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdo(i);
    }

    public ResolveAccountResponse zzaZ(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
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
                    connectionResult = (ConnectionResult) zza.zza(parcel, zzbc, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ResolveAccountResponse[] zzdo(int i) {
        return new ResolveAccountResponse[i];
    }
}

package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ClearTokenRequestCreator implements Creator<ClearTokenRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(ClearTokenRequest clearTokenRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, clearTokenRequest.version);
        zzb.zza(parcel, 2, clearTokenRequest.zzaaC, false);
        zzb.zzJ(parcel, zzbe);
    }

    public ClearTokenRequest createFromParcel(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new ClearTokenRequest(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ClearTokenRequest[] newArray(int size) {
        return new ClearTokenRequest[size];
    }
}

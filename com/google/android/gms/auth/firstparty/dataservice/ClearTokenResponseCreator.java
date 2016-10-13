package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ClearTokenResponseCreator implements Creator<ClearTokenResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(ClearTokenResponse clearTokenResponse, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, clearTokenResponse.version);
        zzb.zza(parcel, 2, clearTokenResponse.zzaah, false);
        zzb.zzJ(parcel, zzbe);
    }

    public ClearTokenResponse createFromParcel(Parcel parcel) {
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
            return new ClearTokenResponse(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ClearTokenResponse[] newArray(int size) {
        return new ClearTokenResponse[size];
    }
}

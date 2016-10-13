package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class RecoveryWriteResponseCreator implements Creator<RecoveryWriteResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(RecoveryWriteResponse recoveryWriteResponse, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, recoveryWriteResponse.mVersionCode);
        zzb.zza(parcel, 2, recoveryWriteResponse.mErrorCode, false);
        zzb.zzJ(parcel, zzbe);
    }

    public RecoveryWriteResponse createFromParcel(Parcel parcel) {
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
            return new RecoveryWriteResponse(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public RecoveryWriteResponse[] newArray(int size) {
        return new RecoveryWriteResponse[size];
    }
}

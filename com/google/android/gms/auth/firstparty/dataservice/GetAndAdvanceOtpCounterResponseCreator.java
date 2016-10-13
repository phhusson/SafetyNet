package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GetAndAdvanceOtpCounterResponseCreator implements Creator<GetAndAdvanceOtpCounterResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(GetAndAdvanceOtpCounterResponse getAndAdvanceOtpCounterResponse, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, getAndAdvanceOtpCounterResponse.mVersion);
        zzb.zza(parcel, 2, getAndAdvanceOtpCounterResponse.counter, false);
        zzb.zzJ(parcel, zzbe);
    }

    public GetAndAdvanceOtpCounterResponse createFromParcel(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        Long l = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    l = zza.zzj(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new GetAndAdvanceOtpCounterResponse(i, l);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public GetAndAdvanceOtpCounterResponse[] newArray(int size) {
        return new GetAndAdvanceOtpCounterResponse[size];
    }
}

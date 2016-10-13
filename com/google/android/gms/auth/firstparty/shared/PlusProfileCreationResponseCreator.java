package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlusProfileCreationResponseCreator implements Creator<PlusProfileCreationResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(PlusProfileCreationResponse plusProfileCreationResponse, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, plusProfileCreationResponse.version);
        zzb.zza(parcel, 2, plusProfileCreationResponse.zzacv, false);
        zzb.zzJ(parcel, zzbe);
    }

    public PlusProfileCreationResponse createFromParcel(Parcel parcel) {
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
            return new PlusProfileCreationResponse(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public PlusProfileCreationResponse[] newArray(int size) {
        return new PlusProfileCreationResponse[size];
    }
}

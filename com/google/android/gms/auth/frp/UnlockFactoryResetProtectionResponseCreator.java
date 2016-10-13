package com.google.android.gms.auth.frp;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class UnlockFactoryResetProtectionResponseCreator implements Creator<UnlockFactoryResetProtectionResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(UnlockFactoryResetProtectionResponse unlockFactoryResetProtectionResponse, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, unlockFactoryResetProtectionResponse.version);
        zzb.zzc(parcel, 2, unlockFactoryResetProtectionResponse.status);
        zzb.zzJ(parcel, zzbe);
    }

    public UnlockFactoryResetProtectionResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzbd = zza.zzbd(parcel);
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
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new UnlockFactoryResetProtectionResponse(i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public UnlockFactoryResetProtectionResponse[] newArray(int size) {
        return new UnlockFactoryResetProtectionResponse[size];
    }
}

package com.google.android.gms.auth.frp;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class UnlockFactoryResetProtectionRequestCreator implements Creator<UnlockFactoryResetProtectionRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(UnlockFactoryResetProtectionRequest unlockFactoryResetProtectionRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, unlockFactoryResetProtectionRequest.version);
        zzb.zza(parcel, 2, unlockFactoryResetProtectionRequest.accountName, false);
        zzb.zza(parcel, 3, unlockFactoryResetProtectionRequest.password, false);
        zzb.zza(parcel, 4, unlockFactoryResetProtectionRequest.accountType, false);
        zzb.zzJ(parcel, zzbe);
    }

    public UnlockFactoryResetProtectionRequest createFromParcel(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    str = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new UnlockFactoryResetProtectionRequest(i, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public UnlockFactoryResetProtectionRequest[] newArray(int size) {
        return new UnlockFactoryResetProtectionRequest[size];
    }
}

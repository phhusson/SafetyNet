package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class RecoveryWriteRequestCreator implements Creator<RecoveryWriteRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(RecoveryWriteRequest recoveryWriteRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, recoveryWriteRequest.mVersionCode);
        zzb.zza(parcel, 2, recoveryWriteRequest.mAccount, false);
        zzb.zza(parcel, 3, recoveryWriteRequest.mSecondaryEmail, false);
        zzb.zza(parcel, 4, recoveryWriteRequest.mPhoneNumber, false);
        zzb.zza(parcel, 5, recoveryWriteRequest.mPhoneCountryCode, false);
        zzb.zza(parcel, 6, recoveryWriteRequest.mIsBroadUse);
        zzb.zzJ(parcel, zzbe);
    }

    public RecoveryWriteRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzbd = zza.zzbd(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str4 = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new RecoveryWriteRequest(i, str4, str3, str2, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public RecoveryWriteRequest[] newArray(int size) {
        return new RecoveryWriteRequest[size];
    }
}

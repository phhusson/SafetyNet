package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class RecoveryReadResponseCreator implements Creator<RecoveryReadResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(RecoveryReadResponse recoveryReadResponse, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, recoveryReadResponse.mVersionCode);
        zzb.zza(parcel, 2, recoveryReadResponse.mSecondaryEmail, false);
        zzb.zza(parcel, 3, recoveryReadResponse.mPhoneNumber, false);
        zzb.zza(parcel, 4, recoveryReadResponse.mPhoneCountryCode, false);
        zzb.zzc(parcel, 5, recoveryReadResponse.mCountryList, false);
        zzb.zza(parcel, 6, recoveryReadResponse.mError, false);
        zzb.zza(parcel, 7, recoveryReadResponse.mAction, false);
        zzb.zza(parcel, 8, recoveryReadResponse.mAllowedOptions, false);
        zzb.zzJ(parcel, zzbe);
    }

    public RecoveryReadResponse createFromParcel(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        List list = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str6 = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    str5 = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    str4 = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    list = zza.zzc(parcel, zzbc, Country.CREATOR);
                    break;
                case 6:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 7:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 8:
                    str = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new RecoveryReadResponse(i, str6, str5, str4, list, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public RecoveryReadResponse[] newArray(int size) {
        return new RecoveryReadResponse[size];
    }
}

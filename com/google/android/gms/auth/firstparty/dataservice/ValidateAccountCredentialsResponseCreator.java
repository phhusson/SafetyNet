package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ValidateAccountCredentialsResponseCreator implements Creator<ValidateAccountCredentialsResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(ValidateAccountCredentialsResponse validateAccountCredentialsResponse, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, validateAccountCredentialsResponse.version);
        zzb.zzc(parcel, 2, validateAccountCredentialsResponse.status);
        zzb.zza(parcel, 3, validateAccountCredentialsResponse.accountId, false);
        zzb.zzJ(parcel, zzbe);
    }

    public ValidateAccountCredentialsResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        String str = null;
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
                case 3:
                    str = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new ValidateAccountCredentialsResponse(i2, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ValidateAccountCredentialsResponse[] newArray(int size) {
        return new ValidateAccountCredentialsResponse[size];
    }
}

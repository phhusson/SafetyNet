package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class OtpRequestCreator implements Creator<OtpRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(OtpRequest otpRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, otpRequest.mVersion);
        zzb.zza(parcel, 2, otpRequest.accountName, false);
        zzb.zza(parcel, 3, otpRequest.callerDescription, i, false);
        zzb.zza(parcel, 4, otpRequest.challenge, false);
        zzb.zza(parcel, 5, otpRequest.isLegacyRequest);
        zzb.zzJ(parcel, zzbe);
    }

    public OtpRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        byte[] bArr = null;
        int zzbd = zza.zzbd(parcel);
        AppDescription appDescription = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    appDescription = (AppDescription) zza.zza(parcel, zzbc, AppDescription.CREATOR);
                    break;
                case 4:
                    bArr = zza.zzt(parcel, zzbc);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new OtpRequest(i, str, appDescription, bArr, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public OtpRequest[] newArray(int size) {
        return new OtpRequest[size];
    }
}

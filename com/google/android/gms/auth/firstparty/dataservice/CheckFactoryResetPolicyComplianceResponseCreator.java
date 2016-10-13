package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class CheckFactoryResetPolicyComplianceResponseCreator implements Creator<CheckFactoryResetPolicyComplianceResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(CheckFactoryResetPolicyComplianceResponse checkFactoryResetPolicyComplianceResponse, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, checkFactoryResetPolicyComplianceResponse.version);
        zzb.zza(parcel, 2, checkFactoryResetPolicyComplianceResponse.isCompliant);
        zzb.zzJ(parcel, zzbe);
    }

    public CheckFactoryResetPolicyComplianceResponse createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new CheckFactoryResetPolicyComplianceResponse(i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public CheckFactoryResetPolicyComplianceResponse[] newArray(int size) {
        return new CheckFactoryResetPolicyComplianceResponse[size];
    }
}

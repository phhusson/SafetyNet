package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GplusInfoResponseCreator implements Creator<GplusInfoResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(GplusInfoResponse gplusInfoResponse, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, gplusInfoResponse.version);
        zzb.zza(parcel, 2, gplusInfoResponse.zzabi);
        zzb.zza(parcel, 3, gplusInfoResponse.firstName, false);
        zzb.zza(parcel, 4, gplusInfoResponse.lastName, false);
        zzb.zza(parcel, 5, gplusInfoResponse.zzabj, false);
        zzb.zza(parcel, 6, gplusInfoResponse.zzabk);
        zzb.zza(parcel, 7, gplusInfoResponse.zzabl);
        zzb.zza(parcel, 8, gplusInfoResponse.zzabm, false);
        zzb.zza(parcel, 9, gplusInfoResponse.zzabh, false);
        zzb.zza(parcel, 10, gplusInfoResponse.zzabn, false);
        zzb.zzJ(parcel, zzbe);
    }

    public GplusInfoResponse createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzbd = zza.zzbd(parcel);
        String str2 = null;
        String str3 = null;
        boolean z2 = false;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    z3 = zza.zzc(parcel, zzbc);
                    break;
                case 3:
                    str6 = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    str5 = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    str4 = zza.zzq(parcel, zzbc);
                    break;
                case 6:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 8:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 9:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 10:
                    str = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new GplusInfoResponse(i, z3, str6, str5, str4, z2, z, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public GplusInfoResponse[] newArray(int size) {
        return new GplusInfoResponse[size];
    }
}

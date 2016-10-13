package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class FACLDataCreator implements Creator<FACLData> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(FACLData fACLData, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, fACLData.version);
        zzb.zza(parcel, 2, fACLData.zzaco, i, false);
        zzb.zza(parcel, 3, fACLData.zzacp, false);
        zzb.zza(parcel, 4, fACLData.zzacq);
        zzb.zza(parcel, 5, fACLData.zzacr, false);
        zzb.zzJ(parcel, zzbe);
    }

    public FACLData createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzbd = zza.zzbd(parcel);
        String str2 = null;
        FACLConfig fACLConfig = null;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    fACLConfig = (FACLConfig) zza.zza(parcel, zzbc, FACLConfig.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 5:
                    str = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new FACLData(i, fACLConfig, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public FACLData[] newArray(int size) {
        return new FACLData[size];
    }
}

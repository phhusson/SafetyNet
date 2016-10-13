package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class FACLConfigCreator implements Creator<FACLConfig> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(FACLConfig fACLConfig, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, fACLConfig.version);
        zzb.zza(parcel, 2, fACLConfig.zzaci);
        zzb.zza(parcel, 3, fACLConfig.zzacj, false);
        zzb.zza(parcel, 4, fACLConfig.zzack);
        zzb.zza(parcel, 5, fACLConfig.zzacl);
        zzb.zza(parcel, 6, fACLConfig.zzacm);
        zzb.zza(parcel, 7, fACLConfig.zzacn);
        zzb.zzJ(parcel, zzbe);
    }

    public FACLConfig createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    z5 = zza.zzc(parcel, zzbc);
                    break;
                case 3:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    z4 = zza.zzc(parcel, zzbc);
                    break;
                case 5:
                    z3 = zza.zzc(parcel, zzbc);
                    break;
                case 6:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new FACLConfig(i, z5, str, z4, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public FACLConfig[] newArray(int size) {
        return new FACLConfig[size];
    }
}

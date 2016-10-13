package com.google.android.gms.auth.firstparty.proximity.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AuthorizationCreator implements Creator<Authorization> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(Authorization authorization, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, authorization.mVersion);
        zzb.zza(parcel, 2, authorization.mPermitId, false);
        zzb.zza(parcel, 3, authorization.mPermitAccessId, false);
        zzb.zza(parcel, 4, authorization.mData, false);
        zzb.zzJ(parcel, zzbe);
    }

    public Authorization createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    bArr = zza.zzt(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new Authorization(i, str2, str, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Authorization[] newArray(int size) {
        return new Authorization[size];
    }
}

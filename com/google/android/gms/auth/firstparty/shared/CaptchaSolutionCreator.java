package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class CaptchaSolutionCreator implements Creator<CaptchaSolution> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(CaptchaSolution captchaSolution, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, captchaSolution.version);
        zzb.zza(parcel, 2, captchaSolution.zzaaC, false);
        zzb.zza(parcel, 3, captchaSolution.zzach, false);
        zzb.zzJ(parcel, zzbe);
    }

    public CaptchaSolution createFromParcel(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
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
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new CaptchaSolution(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public CaptchaSolution[] newArray(int size) {
        return new CaptchaSolution[size];
    }
}

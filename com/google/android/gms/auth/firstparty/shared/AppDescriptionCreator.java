package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AppDescriptionCreator implements Creator<AppDescription> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AppDescription appDescription, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, appDescription.version);
        zzb.zzc(parcel, 2, appDescription.zzacd);
        zzb.zza(parcel, 3, appDescription.zzHT, false);
        zzb.zza(parcel, 4, appDescription.zzace, false);
        zzb.zza(parcel, 5, appDescription.zzacf, false);
        zzb.zza(parcel, 6, appDescription.zzaaA);
        zzb.zzJ(parcel, zzbe);
    }

    public AppDescription createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        String str2 = null;
        String str3 = null;
        int i = 0;
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
            return new AppDescription(i2, i, str3, str2, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AppDescription[] newArray(int size) {
        return new AppDescription[size];
    }
}

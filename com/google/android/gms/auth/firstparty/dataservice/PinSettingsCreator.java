package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PinSettingsCreator implements Creator<PinSettings> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(PinSettings pinSettings, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, pinSettings.version);
        zzb.zza(parcel, 2, pinSettings.status, false);
        zzb.zza(parcel, 3, pinSettings.resetUrl, false);
        zzb.zza(parcel, 4, pinSettings.setupUrl, false);
        zzb.zzc(parcel, 5, pinSettings.length);
        zzb.zza(parcel, 6, pinSettings.recoveryUrl, false);
        zzb.zzJ(parcel, zzbe);
    }

    public PinSettings createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzbd = zza.zzbd(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str4 = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 6:
                    str = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new PinSettings(i2, str4, str3, str2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public PinSettings[] newArray(int size) {
        return new PinSettings[size];
    }
}

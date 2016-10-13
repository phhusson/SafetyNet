package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ReauthSettingsResponseCreator implements Creator<ReauthSettingsResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(ReauthSettingsResponse reauthSettingsResponse, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, reauthSettingsResponse.version);
        zzb.zzc(parcel, 2, reauthSettingsResponse.status);
        zzb.zza(parcel, 3, reauthSettingsResponse.password, i, false);
        zzb.zza(parcel, 4, reauthSettingsResponse.pin, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public ReauthSettingsResponse createFromParcel(Parcel parcel) {
        PinSettings pinSettings = null;
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        PasswordSettings passwordSettings = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzbd) {
            PasswordSettings passwordSettings2;
            int i3;
            PinSettings pinSettings2;
            int zzbc = zza.zzbc(parcel);
            PinSettings pinSettings3;
            switch (zza.zzdr(zzbc)) {
                case 1:
                    pinSettings3 = pinSettings;
                    passwordSettings2 = passwordSettings;
                    i3 = i;
                    i = zza.zzg(parcel, zzbc);
                    pinSettings2 = pinSettings3;
                    break;
                case 2:
                    i = i2;
                    PasswordSettings passwordSettings3 = passwordSettings;
                    i3 = zza.zzg(parcel, zzbc);
                    pinSettings2 = pinSettings;
                    passwordSettings2 = passwordSettings3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    pinSettings3 = pinSettings;
                    passwordSettings2 = (PasswordSettings) zza.zza(parcel, zzbc, PasswordSettings.CREATOR);
                    pinSettings2 = pinSettings3;
                    break;
                case 4:
                    pinSettings2 = (PinSettings) zza.zza(parcel, zzbc, PinSettings.CREATOR);
                    passwordSettings2 = passwordSettings;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    pinSettings2 = pinSettings;
                    passwordSettings2 = passwordSettings;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            passwordSettings = passwordSettings2;
            pinSettings = pinSettings2;
        }
        if (parcel.dataPosition() == zzbd) {
            return new ReauthSettingsResponse(i2, i, passwordSettings, pinSettings);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ReauthSettingsResponse[] newArray(int size) {
        return new ReauthSettingsResponse[size];
    }
}

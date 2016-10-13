package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class WebSetupConfigRequestCreator implements Creator<WebSetupConfigRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(WebSetupConfigRequest webSetupConfigRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, webSetupConfigRequest.version);
        zzb.zza(parcel, 2, webSetupConfigRequest.callingAppDescription, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public WebSetupConfigRequest createFromParcel(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        AppDescription appDescription = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    appDescription = (AppDescription) zza.zza(parcel, zzbc, AppDescription.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new WebSetupConfigRequest(i, appDescription);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public WebSetupConfigRequest[] newArray(int size) {
        return new WebSetupConfigRequest[size];
    }
}

package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class CheckRealNameRequestCreator implements Creator<CheckRealNameRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(CheckRealNameRequest checkRealNameRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, checkRealNameRequest.version);
        zzb.zza(parcel, 2, checkRealNameRequest.callingAppDescription, i, false);
        zzb.zza(parcel, 3, checkRealNameRequest.firstName, false);
        zzb.zza(parcel, 4, checkRealNameRequest.lastName, false);
        zzb.zzJ(parcel, zzbe);
    }

    public CheckRealNameRequest createFromParcel(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str2 = null;
        AppDescription appDescription = null;
        while (parcel.dataPosition() < zzbd) {
            AppDescription appDescription2;
            int zzg;
            String str3;
            int zzbc = zza.zzbc(parcel);
            String str4;
            switch (zza.zzdr(zzbc)) {
                case 1:
                    str4 = str;
                    str = str2;
                    appDescription2 = appDescription;
                    zzg = zza.zzg(parcel, zzbc);
                    str3 = str4;
                    break;
                case 2:
                    zzg = i;
                    str4 = str2;
                    appDescription2 = (AppDescription) zza.zza(parcel, zzbc, AppDescription.CREATOR);
                    str3 = str;
                    str = str4;
                    break;
                case 3:
                    appDescription2 = appDescription;
                    zzg = i;
                    str4 = str;
                    str = zza.zzq(parcel, zzbc);
                    str3 = str4;
                    break;
                case 4:
                    str3 = zza.zzq(parcel, zzbc);
                    str = str2;
                    appDescription2 = appDescription;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    str3 = str;
                    str = str2;
                    appDescription2 = appDescription;
                    zzg = i;
                    break;
            }
            i = zzg;
            appDescription = appDescription2;
            str2 = str;
            str = str3;
        }
        if (parcel.dataPosition() == zzbd) {
            return new CheckRealNameRequest(i, appDescription, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public CheckRealNameRequest[] newArray(int size) {
        return new CheckRealNameRequest[size];
    }
}

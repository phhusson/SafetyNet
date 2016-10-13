package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PasswordCheckRequestCreator implements Creator<PasswordCheckRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(PasswordCheckRequest passwordCheckRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, passwordCheckRequest.version);
        zzb.zza(parcel, 2, passwordCheckRequest.accountName, false);
        zzb.zza(parcel, 3, passwordCheckRequest.password, false);
        zzb.zza(parcel, 4, passwordCheckRequest.zzaad, false);
        zzb.zza(parcel, 5, passwordCheckRequest.zzaae, false);
        zzb.zza(parcel, 6, passwordCheckRequest.zzabo, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public PasswordCheckRequest createFromParcel(Parcel parcel) {
        AppDescription appDescription = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
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
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 6:
                    appDescription = (AppDescription) zza.zza(parcel, zzbc, AppDescription.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new PasswordCheckRequest(i, str4, str3, str2, str, appDescription);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public PasswordCheckRequest[] newArray(int size) {
        return new PasswordCheckRequest[size];
    }
}

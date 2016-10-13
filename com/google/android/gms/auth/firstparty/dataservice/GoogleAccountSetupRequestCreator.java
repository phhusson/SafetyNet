package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GoogleAccountSetupRequestCreator implements Creator<GoogleAccountSetupRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(GoogleAccountSetupRequest googleAccountSetupRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, googleAccountSetupRequest.version);
        zzb.zza(parcel, 2, googleAccountSetupRequest.options, false);
        zzb.zza(parcel, 3, googleAccountSetupRequest.zzabd);
        zzb.zza(parcel, 4, googleAccountSetupRequest.zzabe);
        zzb.zza(parcel, 5, googleAccountSetupRequest.zzabf);
        zzb.zza(parcel, 6, googleAccountSetupRequest.firstName, false);
        zzb.zza(parcel, 7, googleAccountSetupRequest.lastName, false);
        zzb.zza(parcel, 8, googleAccountSetupRequest.secondaryEmail, false);
        zzb.zza(parcel, 9, googleAccountSetupRequest.gender, false);
        zzb.zza(parcel, 10, googleAccountSetupRequest.zzaaz);
        zzb.zza(parcel, 11, googleAccountSetupRequest.zzabg);
        zzb.zza(parcel, 12, googleAccountSetupRequest.zzaaA);
        zzb.zza(parcel, 13, googleAccountSetupRequest.zzabh, false);
        zzb.zza(parcel, 14, googleAccountSetupRequest.callingAppDescription, i, false);
        zzb.zza(parcel, 15, googleAccountSetupRequest.zzaaB, i, false);
        zzb.zza(parcel, 17, googleAccountSetupRequest.phoneNumber, false);
        zzb.zza(parcel, 16, googleAccountSetupRequest.zzaaf, i, false);
        zzb.zza(parcel, 18, googleAccountSetupRequest.phoneCountryCode, false);
        zzb.zzJ(parcel, zzbe);
    }

    public GoogleAccountSetupRequest createFromParcel(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        Bundle bundle = new Bundle();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        String str5 = null;
        AppDescription appDescription = null;
        AccountCredentials accountCredentials = null;
        CaptchaSolution captchaSolution = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    bundle = zza.zzs(parcel, zzbc);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 5:
                    z3 = zza.zzc(parcel, zzbc);
                    break;
                case 6:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 7:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 8:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 9:
                    str4 = zza.zzq(parcel, zzbc);
                    break;
                case 10:
                    z4 = zza.zzc(parcel, zzbc);
                    break;
                case 11:
                    z5 = zza.zzc(parcel, zzbc);
                    break;
                case 12:
                    z6 = zza.zzc(parcel, zzbc);
                    break;
                case 13:
                    str5 = zza.zzq(parcel, zzbc);
                    break;
                case 14:
                    appDescription = (AppDescription) zza.zza(parcel, zzbc, (Creator) AppDescription.CREATOR);
                    break;
                case 15:
                    accountCredentials = (AccountCredentials) zza.zza(parcel, zzbc, (Creator) AccountCredentials.CREATOR);
                    break;
                case 16:
                    captchaSolution = (CaptchaSolution) zza.zza(parcel, zzbc, (Creator) CaptchaSolution.CREATOR);
                    break;
                case 17:
                    str6 = zza.zzq(parcel, zzbc);
                    break;
                case 18:
                    str7 = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new GoogleAccountSetupRequest(i, bundle, z, z2, z3, str, str2, str3, str4, z4, z5, z6, str5, appDescription, accountCredentials, captchaSolution, str6, str7);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public GoogleAccountSetupRequest[] newArray(int size) {
        return new GoogleAccountSetupRequest[size];
    }
}

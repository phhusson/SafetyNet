package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class UpdateCredentialsRequestCreator implements Creator<UpdateCredentialsRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(UpdateCredentialsRequest updateCredentialsRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, updateCredentialsRequest.version);
        zzb.zza(parcel, 2, updateCredentialsRequest.zzaaB, i, false);
        zzb.zza(parcel, 3, updateCredentialsRequest.zzaaf, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public UpdateCredentialsRequest createFromParcel(Parcel parcel) {
        CaptchaSolution captchaSolution = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        AccountCredentials accountCredentials = null;
        while (parcel.dataPosition() < zzbd) {
            AccountCredentials accountCredentials2;
            int zzg;
            CaptchaSolution captchaSolution2;
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    CaptchaSolution captchaSolution3 = captchaSolution;
                    accountCredentials2 = accountCredentials;
                    zzg = zza.zzg(parcel, zzbc);
                    captchaSolution2 = captchaSolution3;
                    break;
                case 2:
                    zzg = i;
                    AccountCredentials accountCredentials3 = (AccountCredentials) zza.zza(parcel, zzbc, AccountCredentials.CREATOR);
                    captchaSolution2 = captchaSolution;
                    accountCredentials2 = accountCredentials3;
                    break;
                case 3:
                    captchaSolution2 = (CaptchaSolution) zza.zza(parcel, zzbc, CaptchaSolution.CREATOR);
                    accountCredentials2 = accountCredentials;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    captchaSolution2 = captchaSolution;
                    accountCredentials2 = accountCredentials;
                    zzg = i;
                    break;
            }
            i = zzg;
            accountCredentials = accountCredentials2;
            captchaSolution = captchaSolution2;
        }
        if (parcel.dataPosition() == zzbd) {
            return new UpdateCredentialsRequest(i, accountCredentials, captchaSolution);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public UpdateCredentialsRequest[] newArray(int size) {
        return new UpdateCredentialsRequest[size];
    }
}

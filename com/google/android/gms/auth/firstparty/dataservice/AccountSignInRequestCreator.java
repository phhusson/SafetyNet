package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AccountSignInRequestCreator implements Creator<AccountSignInRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AccountSignInRequest accountSignInRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, accountSignInRequest.version);
        zzb.zza(parcel, 2, accountSignInRequest.callingAppDescription, i, false);
        zzb.zza(parcel, 3, accountSignInRequest.zzaaz);
        zzb.zza(parcel, 4, accountSignInRequest.zzaaA);
        zzb.zza(parcel, 5, accountSignInRequest.zzaaf, i, false);
        zzb.zza(parcel, 6, accountSignInRequest.zzaaB, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public AccountSignInRequest createFromParcel(Parcel parcel) {
        AccountCredentials accountCredentials = null;
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        CaptchaSolution captchaSolution = null;
        boolean z2 = false;
        AppDescription appDescription = null;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    appDescription = (AppDescription) zza.zza(parcel, zzbc, AppDescription.CREATOR);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 5:
                    captchaSolution = (CaptchaSolution) zza.zza(parcel, zzbc, CaptchaSolution.CREATOR);
                    break;
                case 6:
                    accountCredentials = (AccountCredentials) zza.zza(parcel, zzbc, AccountCredentials.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AccountSignInRequest(i, appDescription, z2, z, captchaSolution, accountCredentials);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AccountSignInRequest[] newArray(int size) {
        return new AccountSignInRequest[size];
    }
}

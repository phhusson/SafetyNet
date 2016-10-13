package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.CaptchaChallenge;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class AccountNameCheckResponseCreator implements Creator<AccountNameCheckResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AccountNameCheckResponse accountNameCheckResponse, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, accountNameCheckResponse.version);
        zzb.zza(parcel, 2, accountNameCheckResponse.zzaah, false);
        zzb.zzb(parcel, 3, accountNameCheckResponse.zzaai, false);
        zzb.zza(parcel, 4, accountNameCheckResponse.zzaaj, false);
        zzb.zza(parcel, 5, accountNameCheckResponse.zzaak, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public AccountNameCheckResponse createFromParcel(Parcel parcel) {
        CaptchaChallenge captchaChallenge = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str = null;
        List list = null;
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
                    list = zza.zzE(parcel, zzbc);
                    break;
                case 4:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    captchaChallenge = (CaptchaChallenge) zza.zza(parcel, zzbc, CaptchaChallenge.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AccountNameCheckResponse(i, str2, list, str, captchaChallenge);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AccountNameCheckResponse[] newArray(int size) {
        return new AccountNameCheckResponse[size];
    }
}

package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AccountNameCheckRequestCreator implements Creator<AccountNameCheckRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AccountNameCheckRequest accountNameCheckRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, accountNameCheckRequest.version);
        zzb.zza(parcel, 2, accountNameCheckRequest.zzaac, false);
        zzb.zza(parcel, 3, accountNameCheckRequest.zzaad, false);
        zzb.zza(parcel, 4, accountNameCheckRequest.zzaae, false);
        zzb.zza(parcel, 5, accountNameCheckRequest.callingAppDescription, i, false);
        zzb.zza(parcel, 6, accountNameCheckRequest.zzaaf, i, false);
        zzb.zza(parcel, 7, accountNameCheckRequest.zzaag, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public AccountNameCheckRequest createFromParcel(Parcel parcel) {
        Account account = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        CaptchaSolution captchaSolution = null;
        AppDescription appDescription = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    appDescription = (AppDescription) zza.zza(parcel, zzbc, AppDescription.CREATOR);
                    break;
                case 6:
                    captchaSolution = (CaptchaSolution) zza.zza(parcel, zzbc, CaptchaSolution.CREATOR);
                    break;
                case 7:
                    account = (Account) zza.zza(parcel, zzbc, Account.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AccountNameCheckRequest(i, str3, str2, str, appDescription, captchaSolution, account);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AccountNameCheckRequest[] newArray(int size) {
        return new AccountNameCheckRequest[size];
    }
}

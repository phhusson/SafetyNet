package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AccountRecoveryDataRequestCreator implements Creator<AccountRecoveryDataRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AccountRecoveryDataRequest accountRecoveryDataRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, accountRecoveryDataRequest.version);
        zzb.zza(parcel, 2, accountRecoveryDataRequest.accountName, false);
        zzb.zza(parcel, 3, accountRecoveryDataRequest.isClearUpdateSuggested);
        zzb.zza(parcel, 4, accountRecoveryDataRequest.callingAppDescription, i, false);
        zzb.zza(parcel, 5, accountRecoveryDataRequest.requestDescription, false);
        zzb.zza(parcel, 6, accountRecoveryDataRequest.account, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public AccountRecoveryDataRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        Account account = null;
        int zzbd = zza.zzbd(parcel);
        String str = null;
        AppDescription appDescription = null;
        String str2 = null;
        int i = 0;
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
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 4:
                    appDescription = (AppDescription) zza.zza(parcel, zzbc, AppDescription.CREATOR);
                    break;
                case 5:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 6:
                    account = (Account) zza.zza(parcel, zzbc, Account.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AccountRecoveryDataRequest(i, str2, z, appDescription, str, account);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AccountRecoveryDataRequest[] newArray(int size) {
        return new AccountRecoveryDataRequest[size];
    }
}

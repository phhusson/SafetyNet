package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AccountRecoveryUpdateRequestCreator implements Creator<AccountRecoveryUpdateRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AccountRecoveryUpdateRequest accountRecoveryUpdateRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, accountRecoveryUpdateRequest.version);
        zzb.zza(parcel, 2, accountRecoveryUpdateRequest.accountName, false);
        zzb.zza(parcel, 3, accountRecoveryUpdateRequest.secondaryEmail, false);
        zzb.zza(parcel, 4, accountRecoveryUpdateRequest.phoneNumber, false);
        zzb.zza(parcel, 5, accountRecoveryUpdateRequest.phoneCountryCode, false);
        zzb.zza(parcel, 6, accountRecoveryUpdateRequest.isBroadUse);
        zzb.zza(parcel, 7, accountRecoveryUpdateRequest.callingAppDescription, i, false);
        zzb.zza(parcel, 8, accountRecoveryUpdateRequest.account, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public AccountRecoveryUpdateRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        Account account = null;
        int zzbd = zza.zzbd(parcel);
        AppDescription appDescription = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
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
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 7:
                    appDescription = (AppDescription) zza.zza(parcel, zzbc, AppDescription.CREATOR);
                    break;
                case 8:
                    account = (Account) zza.zza(parcel, zzbc, Account.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AccountRecoveryUpdateRequest(i, str4, str3, str2, str, z, appDescription, account);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AccountRecoveryUpdateRequest[] newArray(int size) {
        return new AccountRecoveryUpdateRequest[size];
    }
}

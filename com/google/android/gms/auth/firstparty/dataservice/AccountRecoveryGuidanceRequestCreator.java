package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AccountRecoveryGuidanceRequestCreator implements Creator<AccountRecoveryGuidanceRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AccountRecoveryGuidanceRequest accountRecoveryGuidanceRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, accountRecoveryGuidanceRequest.version);
        zzb.zza(parcel, 2, accountRecoveryGuidanceRequest.accountName, false);
        zzb.zza(parcel, 3, accountRecoveryGuidanceRequest.account, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public AccountRecoveryGuidanceRequest createFromParcel(Parcel parcel) {
        Account account = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    account = (Account) zza.zza(parcel, zzbc, Account.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AccountRecoveryGuidanceRequest(i, str, account);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AccountRecoveryGuidanceRequest[] newArray(int size) {
        return new AccountRecoveryGuidanceRequest[size];
    }
}

package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AccountRecoveryGuidanceCreator implements Creator<AccountRecoveryGuidance> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AccountRecoveryGuidance accountRecoveryGuidance, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, accountRecoveryGuidance.version);
        zzb.zza(parcel, 2, accountRecoveryGuidance.accountName, false);
        zzb.zza(parcel, 3, accountRecoveryGuidance.isRecoveryInfoNeeded);
        zzb.zza(parcel, 4, accountRecoveryGuidance.isRecoveryInterstitialSuggested);
        zzb.zza(parcel, 5, accountRecoveryGuidance.isRecoveryUpdateAllowed);
        zzb.zza(parcel, 6, accountRecoveryGuidance.account, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public AccountRecoveryGuidance createFromParcel(Parcel parcel) {
        Account account = null;
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        boolean z2 = false;
        boolean z3 = false;
        String str = null;
        int i = 0;
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
                    z3 = zza.zzc(parcel, zzbc);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzbc);
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
            return new AccountRecoveryGuidance(i, str, z3, z2, z, account);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AccountRecoveryGuidance[] newArray(int size) {
        return new AccountRecoveryGuidance[size];
    }
}

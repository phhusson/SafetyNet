package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.Country;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class AccountRecoveryDataCreator implements Creator<AccountRecoveryData> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AccountRecoveryData accountRecoveryData, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, accountRecoveryData.version);
        zzb.zza(parcel, 2, accountRecoveryData.guidance, i, false);
        zzb.zza(parcel, 3, accountRecoveryData.action, false);
        zzb.zza(parcel, 4, accountRecoveryData.allowedRecoveryOption, false);
        zzb.zza(parcel, 5, accountRecoveryData.accountName, false);
        zzb.zza(parcel, 6, accountRecoveryData.secondaryEmail, false);
        zzb.zza(parcel, 7, accountRecoveryData.phoneNumber, false);
        zzb.zzc(parcel, 8, accountRecoveryData.countries, false);
        zzb.zza(parcel, 9, accountRecoveryData.defaultCountryCode, false);
        zzb.zza(parcel, 10, accountRecoveryData.error, false);
        zzb.zza(parcel, 11, accountRecoveryData.account, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public AccountRecoveryData createFromParcel(Parcel parcel) {
        Account account = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        AccountRecoveryGuidance accountRecoveryGuidance = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    accountRecoveryGuidance = (AccountRecoveryGuidance) zza.zza(parcel, zzbc, AccountRecoveryGuidance.CREATOR);
                    break;
                case 3:
                    str7 = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    str6 = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    str5 = zza.zzq(parcel, zzbc);
                    break;
                case 6:
                    str4 = zza.zzq(parcel, zzbc);
                    break;
                case 7:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 8:
                    list = zza.zzc(parcel, zzbc, Country.CREATOR);
                    break;
                case 9:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 10:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 11:
                    account = (Account) zza.zza(parcel, zzbc, Account.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AccountRecoveryData(i, accountRecoveryGuidance, str7, str6, str5, str4, str3, list, str2, str, account);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AccountRecoveryData[] newArray(int size) {
        return new AccountRecoveryData[size];
    }
}

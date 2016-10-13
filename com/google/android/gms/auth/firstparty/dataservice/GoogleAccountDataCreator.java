package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class GoogleAccountDataCreator implements Creator<GoogleAccountData> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(GoogleAccountData googleAccountData, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, googleAccountData.version);
        zzb.zza(parcel, 2, googleAccountData.accountName, false);
        zzb.zza(parcel, 3, googleAccountData.zzaaD);
        zzb.zzb(parcel, 4, googleAccountData.services, false);
        zzb.zza(parcel, 5, googleAccountData.firstName, false);
        zzb.zza(parcel, 6, googleAccountData.lastName, false);
        zzb.zza(parcel, 7, googleAccountData.account, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public GoogleAccountData createFromParcel(Parcel parcel) {
        boolean z = false;
        Account account = null;
        int zzbd = zza.zzbd(parcel);
        String str = null;
        String str2 = null;
        List list = null;
        String str3 = null;
        int i = 0;
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
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 4:
                    list = zza.zzE(parcel, zzbc);
                    break;
                case 5:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 6:
                    str = zza.zzq(parcel, zzbc);
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
            return new GoogleAccountData(i, str3, z, list, str2, str, account);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public GoogleAccountData[] newArray(int size) {
        return new GoogleAccountData[size];
    }
}

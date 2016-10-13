package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AccountRemovalRequestCreator implements Creator<AccountRemovalRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AccountRemovalRequest accountRemovalRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, accountRemovalRequest.version);
        zzb.zza(parcel, 2, accountRemovalRequest.accountName, false);
        zzb.zza(parcel, 3, accountRemovalRequest.account, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public AccountRemovalRequest createFromParcel(Parcel parcel) {
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
            return new AccountRemovalRequest(i, str, account);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AccountRemovalRequest[] newArray(int size) {
        return new AccountRemovalRequest[size];
    }
}

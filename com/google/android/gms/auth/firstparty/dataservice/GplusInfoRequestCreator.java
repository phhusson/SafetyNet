package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GplusInfoRequestCreator implements Creator<GplusInfoRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(GplusInfoRequest gplusInfoRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, gplusInfoRequest.version);
        zzb.zza(parcel, 2, gplusInfoRequest.accountName, false);
        zzb.zza(parcel, 3, gplusInfoRequest.zzaaf, i, false);
        zzb.zza(parcel, 4, gplusInfoRequest.account, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public GplusInfoRequest createFromParcel(Parcel parcel) {
        Account account = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        CaptchaSolution captchaSolution = null;
        String str = null;
        while (parcel.dataPosition() < zzbd) {
            CaptchaSolution captchaSolution2;
            String str2;
            int zzg;
            Account account2;
            int zzbc = zza.zzbc(parcel);
            Account account3;
            switch (zza.zzdr(zzbc)) {
                case 1:
                    account3 = account;
                    captchaSolution2 = captchaSolution;
                    str2 = str;
                    zzg = zza.zzg(parcel, zzbc);
                    account2 = account3;
                    break;
                case 2:
                    zzg = i;
                    CaptchaSolution captchaSolution3 = captchaSolution;
                    str2 = zza.zzq(parcel, zzbc);
                    account2 = account;
                    captchaSolution2 = captchaSolution3;
                    break;
                case 3:
                    str2 = str;
                    zzg = i;
                    account3 = account;
                    captchaSolution2 = (CaptchaSolution) zza.zza(parcel, zzbc, CaptchaSolution.CREATOR);
                    account2 = account3;
                    break;
                case 4:
                    account2 = (Account) zza.zza(parcel, zzbc, Account.CREATOR);
                    captchaSolution2 = captchaSolution;
                    str2 = str;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    account2 = account;
                    captchaSolution2 = captchaSolution;
                    str2 = str;
                    zzg = i;
                    break;
            }
            i = zzg;
            str = str2;
            captchaSolution = captchaSolution2;
            account = account2;
        }
        if (parcel.dataPosition() == zzbd) {
            return new GplusInfoRequest(i, str, captchaSolution, account);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public GplusInfoRequest[] newArray(int size) {
        return new GplusInfoRequest[size];
    }
}

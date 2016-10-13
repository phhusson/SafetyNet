package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class VerifyPinRequestCreator implements Creator<VerifyPinRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(VerifyPinRequest verifyPinRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, verifyPinRequest.version);
        zzb.zza(parcel, 2, verifyPinRequest.accountName, false);
        zzb.zza(parcel, 3, verifyPinRequest.pin, false);
        zzb.zza(parcel, 4, verifyPinRequest.account, i, false);
        zzb.zza(parcel, 5, verifyPinRequest.callingPackageName, false);
        zzb.zzJ(parcel, zzbe);
    }

    public VerifyPinRequest createFromParcel(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        Account account = null;
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
                    account = (Account) zza.zza(parcel, zzbc, Account.CREATOR);
                    break;
                case 5:
                    str = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new VerifyPinRequest(i, str3, str2, account, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public VerifyPinRequest[] newArray(int size) {
        return new VerifyPinRequest[size];
    }
}

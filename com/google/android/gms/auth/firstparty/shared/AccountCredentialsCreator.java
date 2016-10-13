package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AccountCredentialsCreator implements Creator<AccountCredentials> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AccountCredentials accountCredentials, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, accountCredentials.version);
        zzb.zza(parcel, 2, accountCredentials.zzabX);
        zzb.zza(parcel, 3, accountCredentials.zzWD, false);
        zzb.zza(parcel, 4, accountCredentials.zzabY, false);
        zzb.zza(parcel, 5, accountCredentials.zzabZ, false);
        zzb.zza(parcel, 6, accountCredentials.zzXI, false);
        zzb.zza(parcel, 7, accountCredentials.zzaca, false);
        zzb.zza(parcel, 8, accountCredentials.zzacb, false);
        zzb.zza(parcel, 9, accountCredentials.mAccountType, false);
        zzb.zzJ(parcel, zzbe);
    }

    public AccountCredentials createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzbd = zza.zzbd(parcel);
        String str2 = "com.google";
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzbc);
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
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 9:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AccountCredentials(i, z, str7, str6, str5, str4, str3, str, str2);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AccountCredentials[] newArray(int size) {
        return new AccountCredentials[size];
    }
}

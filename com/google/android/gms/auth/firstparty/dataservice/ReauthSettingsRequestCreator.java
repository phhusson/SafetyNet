package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ReauthSettingsRequestCreator implements Creator<ReauthSettingsRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(ReauthSettingsRequest reauthSettingsRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, reauthSettingsRequest.version);
        zzb.zza(parcel, 2, reauthSettingsRequest.accountName, false);
        zzb.zza(parcel, 3, reauthSettingsRequest.force);
        zzb.zza(parcel, 4, reauthSettingsRequest.account, i, false);
        zzb.zza(parcel, 5, reauthSettingsRequest.callingPackageName, false);
        zzb.zzJ(parcel, zzbe);
    }

    public ReauthSettingsRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Account account = null;
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
            return new ReauthSettingsRequest(i, str2, z, account, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ReauthSettingsRequest[] newArray(int size) {
        return new ReauthSettingsRequest[size];
    }
}

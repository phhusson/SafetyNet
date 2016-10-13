package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ConfirmCredentialsWorkflowRequestCreator implements Creator<ConfirmCredentialsWorkflowRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(ConfirmCredentialsWorkflowRequest confirmCredentialsWorkflowRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, confirmCredentialsWorkflowRequest.version);
        zzb.zza(parcel, 2, confirmCredentialsWorkflowRequest.accountName, false);
        zzb.zza(parcel, 3, confirmCredentialsWorkflowRequest.callingAppDescription, i, false);
        zzb.zza(parcel, 4, confirmCredentialsWorkflowRequest.options, false);
        zzb.zza(parcel, 5, confirmCredentialsWorkflowRequest.account, i, false);
        zzb.zza(parcel, 6, confirmCredentialsWorkflowRequest.amResponse, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public ConfirmCredentialsWorkflowRequest createFromParcel(Parcel parcel) {
        AccountAuthenticatorResponse accountAuthenticatorResponse = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        Bundle bundle = new Bundle();
        Account account = null;
        AppDescription appDescription = null;
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
                    appDescription = (AppDescription) zza.zza(parcel, zzbc, AppDescription.CREATOR);
                    break;
                case 4:
                    bundle = zza.zzs(parcel, zzbc);
                    break;
                case 5:
                    account = (Account) zza.zza(parcel, zzbc, Account.CREATOR);
                    break;
                case 6:
                    accountAuthenticatorResponse = (AccountAuthenticatorResponse) zza.zza(parcel, zzbc, AccountAuthenticatorResponse.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new ConfirmCredentialsWorkflowRequest(i, str, appDescription, bundle, account, accountAuthenticatorResponse);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ConfirmCredentialsWorkflowRequest[] newArray(int size) {
        return new ConfirmCredentialsWorkflowRequest[size];
    }
}

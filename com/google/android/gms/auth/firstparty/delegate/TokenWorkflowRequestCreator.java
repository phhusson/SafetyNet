package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.PACLConfig;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class TokenWorkflowRequestCreator implements Creator<TokenWorkflowRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(TokenWorkflowRequest tokenWorkflowRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, tokenWorkflowRequest.version);
        zzb.zza(parcel, 2, tokenWorkflowRequest.zzabq, false);
        zzb.zza(parcel, 3, tokenWorkflowRequest.accountName, false);
        zzb.zza(parcel, 4, tokenWorkflowRequest.options, false);
        zzb.zza(parcel, 5, tokenWorkflowRequest.zzabr, i, false);
        zzb.zza(parcel, 6, tokenWorkflowRequest.zzabs, i, false);
        zzb.zza(parcel, 7, tokenWorkflowRequest.zzabO);
        zzb.zza(parcel, 8, tokenWorkflowRequest.callingAppDescription, i, false);
        zzb.zza(parcel, 9, tokenWorkflowRequest.account, i, false);
        zzb.zza(parcel, 10, tokenWorkflowRequest.amResponse, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public TokenWorkflowRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        AccountAuthenticatorResponse accountAuthenticatorResponse = null;
        int zzbd = zza.zzbd(parcel);
        Bundle bundle = new Bundle();
        Account account = null;
        AppDescription appDescription = null;
        PACLConfig pACLConfig = null;
        FACLConfig fACLConfig = null;
        String str = null;
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
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    bundle = zza.zzs(parcel, zzbc);
                    break;
                case 5:
                    fACLConfig = (FACLConfig) zza.zza(parcel, zzbc, FACLConfig.CREATOR);
                    break;
                case 6:
                    pACLConfig = (PACLConfig) zza.zza(parcel, zzbc, PACLConfig.CREATOR);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 8:
                    appDescription = (AppDescription) zza.zza(parcel, zzbc, AppDescription.CREATOR);
                    break;
                case 9:
                    account = (Account) zza.zza(parcel, zzbc, Account.CREATOR);
                    break;
                case 10:
                    accountAuthenticatorResponse = (AccountAuthenticatorResponse) zza.zza(parcel, zzbc, AccountAuthenticatorResponse.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new TokenWorkflowRequest(i, str2, str, bundle, fACLConfig, pACLConfig, z, appDescription, account, accountAuthenticatorResponse);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public TokenWorkflowRequest[] newArray(int size) {
        return new TokenWorkflowRequest[size];
    }
}

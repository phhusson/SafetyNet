package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class SetupAccountWorkflowRequestCreator implements Creator<SetupAccountWorkflowRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(SetupAccountWorkflowRequest setupAccountWorkflowRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, setupAccountWorkflowRequest.version);
        zzb.zza(parcel, 2, setupAccountWorkflowRequest.isMultiUser);
        zzb.zza(parcel, 3, setupAccountWorkflowRequest.isSetupWizard);
        zzb.zzb(parcel, 4, setupAccountWorkflowRequest.allowedDomains, false);
        zzb.zza(parcel, 5, setupAccountWorkflowRequest.options, false);
        zzb.zza(parcel, 6, setupAccountWorkflowRequest.callingAppDescription, i, false);
        zzb.zza(parcel, 7, setupAccountWorkflowRequest.isCreditCardAllowed);
        zzb.zza(parcel, 8, setupAccountWorkflowRequest.accountType, false);
        zzb.zza(parcel, 9, setupAccountWorkflowRequest.amResponse, i, false);
        zzb.zza(parcel, 10, setupAccountWorkflowRequest.suppressD2d);
        zzb.zza(parcel, 11, setupAccountWorkflowRequest.useImmersiveMode);
        zzb.zza(parcel, 12, setupAccountWorkflowRequest.purchaserGaiaEmail, false);
        zzb.zza(parcel, 13, setupAccountWorkflowRequest.purchaserName, false);
        zzb.zza(parcel, 14, setupAccountWorkflowRequest.accountName, false);
        zzb.zzJ(parcel, zzbe);
    }

    public SetupAccountWorkflowRequest createFromParcel(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        List list = null;
        Bundle bundle = new Bundle();
        AppDescription appDescription = null;
        boolean z3 = false;
        String str = null;
        AccountAuthenticatorResponse accountAuthenticatorResponse = null;
        boolean z4 = false;
        boolean z5 = false;
        String str2 = "null";
        String str3 = "null";
        String str4 = null;
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
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 4:
                    list = zza.zzE(parcel, zzbc);
                    break;
                case 5:
                    bundle = zza.zzs(parcel, zzbc);
                    break;
                case 6:
                    appDescription = (AppDescription) zza.zza(parcel, zzbc, AppDescription.CREATOR);
                    break;
                case 7:
                    z3 = zza.zzc(parcel, zzbc);
                    break;
                case 8:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 9:
                    accountAuthenticatorResponse = (AccountAuthenticatorResponse) zza.zza(parcel, zzbc, AccountAuthenticatorResponse.CREATOR);
                    break;
                case 10:
                    z4 = zza.zzc(parcel, zzbc);
                    break;
                case 11:
                    z5 = zza.zzc(parcel, zzbc);
                    break;
                case 12:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 13:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 14:
                    str4 = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new SetupAccountWorkflowRequest(i, z, z2, list, bundle, appDescription, z3, str, accountAuthenticatorResponse, z4, z5, str2, str3, str4);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public SetupAccountWorkflowRequest[] newArray(int size) {
        return new SetupAccountWorkflowRequest[size];
    }
}

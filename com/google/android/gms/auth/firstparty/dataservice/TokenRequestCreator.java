package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.TokenRequest.Consent;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.PACLConfig;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class TokenRequestCreator implements Creator<TokenRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(TokenRequest tokenRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, tokenRequest.version);
        zzb.zza(parcel, 2, tokenRequest.zzabq, false);
        zzb.zza(parcel, 3, tokenRequest.accountName, false);
        zzb.zza(parcel, 4, tokenRequest.options, false);
        zzb.zza(parcel, 5, tokenRequest.zzabr, i, false);
        zzb.zza(parcel, 6, tokenRequest.zzabs, i, false);
        zzb.zza(parcel, 7, tokenRequest.zzabg);
        zzb.zza(parcel, 8, tokenRequest.zzaaz);
        zzb.zza(parcel, 9, tokenRequest.zzabt, false);
        zzb.zza(parcel, 10, tokenRequest.callingAppDescription, i, false);
        zzb.zza(parcel, 11, tokenRequest.zzaaf, i, false);
        zzb.zza(parcel, 13, tokenRequest.zzabu);
        zzb.zza(parcel, 14, tokenRequest.zzabv);
        zzb.zza(parcel, 15, tokenRequest.accountType, false);
        zzb.zza(parcel, 17, tokenRequest.zzabx, false);
        zzb.zzc(parcel, 16, tokenRequest.zzabw);
        zzb.zza(parcel, 18, tokenRequest.zzaby, false);
        zzb.zzJ(parcel, zzbe);
    }

    public TokenRequest createFromParcel(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Bundle bundle = new Bundle();
        FACLConfig fACLConfig = null;
        PACLConfig pACLConfig = null;
        boolean z = false;
        boolean z2 = false;
        String consent = Consent.UNKNOWN.toString();
        AppDescription appDescription = null;
        CaptchaSolution captchaSolution = null;
        boolean z3 = false;
        boolean z4 = true;
        String str3 = "com.google";
        int i2 = 0;
        String str4 = null;
        String str5 = null;
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
                    str2 = zza.zzq(parcel, zzbc);
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
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 9:
                    consent = zza.zzq(parcel, zzbc);
                    break;
                case 10:
                    appDescription = (AppDescription) zza.zza(parcel, zzbc, AppDescription.CREATOR);
                    break;
                case 11:
                    captchaSolution = (CaptchaSolution) zza.zza(parcel, zzbc, CaptchaSolution.CREATOR);
                    break;
                case 13:
                    z3 = zza.zzc(parcel, zzbc);
                    break;
                case 14:
                    z4 = zza.zzc(parcel, zzbc);
                    break;
                case 15:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 16:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                case 17:
                    str4 = zza.zzq(parcel, zzbc);
                    break;
                case 18:
                    str5 = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new TokenRequest(i, str, str2, bundle, fACLConfig, pACLConfig, z, z2, consent, appDescription, captchaSolution, z3, z4, str3, i2, str4, str5);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public TokenRequest[] newArray(int size) {
        return new TokenRequest[size];
    }
}

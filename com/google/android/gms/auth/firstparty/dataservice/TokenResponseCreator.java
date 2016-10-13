package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.TokenData;
import com.google.android.gms.auth.firstparty.shared.CaptchaChallenge;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.playlog.PlayLogger.LogSource;
import java.util.ArrayList;
import java.util.List;

public class TokenResponseCreator implements Creator<TokenResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(TokenResponse tokenResponse, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, tokenResponse.version);
        zzb.zza(parcel, 2, tokenResponse.accountName, false);
        zzb.zza(parcel, 3, tokenResponse.zzaah, false);
        zzb.zza(parcel, 4, tokenResponse.zzaaC, false);
        zzb.zza(parcel, 5, tokenResponse.zzabA, false);
        zzb.zza(parcel, 6, tokenResponse.zzaaj, false);
        zzb.zza(parcel, 7, tokenResponse.zzabB, false);
        zzb.zza(parcel, 8, tokenResponse.firstName, false);
        zzb.zza(parcel, 9, tokenResponse.lastName, false);
        zzb.zza(parcel, 10, tokenResponse.zzabC);
        zzb.zza(parcel, 11, tokenResponse.zzabD);
        zzb.zza(parcel, 12, tokenResponse.zzabE);
        zzb.zza(parcel, 13, tokenResponse.zzabF);
        zzb.zza(parcel, 14, tokenResponse.zzaak, i, false);
        zzb.zzc(parcel, 15, tokenResponse.zzabG, false);
        zzb.zza(parcel, 17, tokenResponse.zzabh, false);
        zzb.zza(parcel, 16, tokenResponse.zzabm, false);
        zzb.zza(parcel, 19, tokenResponse.zzabH);
        zzb.zza(parcel, 21, tokenResponse.zzabI, i, false);
        zzb.zzc(parcel, 20, tokenResponse.title);
        zzb.zza(parcel, 22, tokenResponse.account, i, false);
        zzb.zza(parcel, 27, tokenResponse.zzabK, i, false);
        zzb.zza(parcel, 26, tokenResponse.zzabJ, false);
        zzb.zza(parcel, 29, tokenResponse.zzaby, false);
        zzb.zza(parcel, 28, tokenResponse.zzabL, false);
        zzb.zzJ(parcel, zzbe);
    }

    public TokenResponse createFromParcel(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        CaptchaChallenge captchaChallenge = null;
        List arrayList = new ArrayList();
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        int i2 = 0;
        PostSignInData postSignInData = null;
        Account account = null;
        String str11 = null;
        TokenData tokenData = null;
        Bundle bundle = new Bundle();
        String str12 = null;
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
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    str4 = zza.zzq(parcel, zzbc);
                    break;
                case 6:
                    str5 = zza.zzq(parcel, zzbc);
                    break;
                case 7:
                    str6 = zza.zzq(parcel, zzbc);
                    break;
                case 8:
                    str7 = zza.zzq(parcel, zzbc);
                    break;
                case 9:
                    str8 = zza.zzq(parcel, zzbc);
                    break;
                case 10:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 11:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 12:
                    z3 = zza.zzc(parcel, zzbc);
                    break;
                case 13:
                    z4 = zza.zzc(parcel, zzbc);
                    break;
                case 14:
                    captchaChallenge = (CaptchaChallenge) zza.zza(parcel, zzbc, (Creator) CaptchaChallenge.CREATOR);
                    break;
                case 15:
                    arrayList = zza.zzc(parcel, zzbc, ScopeDetail.CREATOR);
                    break;
                case 16:
                    str9 = zza.zzq(parcel, zzbc);
                    break;
                case 17:
                    str10 = zza.zzq(parcel, zzbc);
                    break;
                case 19:
                    z5 = zza.zzc(parcel, zzbc);
                    break;
                case 20:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                case 21:
                    postSignInData = (PostSignInData) zza.zza(parcel, zzbc, (Creator) PostSignInData.CREATOR);
                    break;
                case 22:
                    account = (Account) zza.zza(parcel, zzbc, Account.CREATOR);
                    break;
                case LogSource.ANDROID_CAMERA /*26*/:
                    str11 = zza.zzq(parcel, zzbc);
                    break;
                case LogSource.CW /*27*/:
                    tokenData = (TokenData) zza.zza(parcel, zzbc, (Creator) TokenData.CREATOR);
                    break;
                case LogSource.GEL /*28*/:
                    bundle = zza.zzs(parcel, zzbc);
                    break;
                case LogSource.DNA_PROBER /*29*/:
                    str12 = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new TokenResponse(i, str, str2, str3, str4, str5, str6, str7, str8, z, z2, z3, z4, captchaChallenge, arrayList, str9, str10, z5, i2, postSignInData, account, str11, tokenData, bundle, str12);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public TokenResponse[] newArray(int size) {
        return new TokenResponse[size];
    }
}

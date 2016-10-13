package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<SignInAccount> {
    static void zza(SignInAccount signInAccount, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, signInAccount.versionCode);
        zzb.zza(parcel, 2, signInAccount.getProviderId(), false);
        zzb.zza(parcel, 3, signInAccount.getIdToken(), false);
        zzb.zza(parcel, 4, signInAccount.getEmail(), false);
        zzb.zza(parcel, 5, signInAccount.getDisplayName(), false);
        zzb.zza(parcel, 6, signInAccount.getPhotoUrl(), i, false);
        zzb.zza(parcel, 7, signInAccount.zzkE(), i, false);
        zzb.zza(parcel, 8, signInAccount.getUserId(), false);
        zzb.zza(parcel, 9, signInAccount.zzkF(), false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzX(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaY(i);
    }

    public SignInAccount zzX(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str2 = "";
        GoogleSignInAccount googleSignInAccount = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str6 = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    str5 = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    str4 = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 6:
                    uri = (Uri) zza.zza(parcel, zzbc, Uri.CREATOR);
                    break;
                case 7:
                    googleSignInAccount = (GoogleSignInAccount) zza.zza(parcel, zzbc, GoogleSignInAccount.CREATOR);
                    break;
                case 8:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 9:
                    str = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new SignInAccount(i, str6, str5, str4, str3, uri, googleSignInAccount, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public SignInAccount[] zzaY(int i) {
        return new SignInAccount[i];
    }
}

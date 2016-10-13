package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr implements Creator<SignInConfiguration> {
    static void zza(SignInConfiguration signInConfiguration, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, signInConfiguration.versionCode);
        zzb.zza(parcel, 2, signInConfiguration.zzkT(), false);
        zzb.zza(parcel, 3, signInConfiguration.zzkC(), false);
        zzb.zza(parcel, 4, signInConfiguration.zzkU(), i, false);
        zzb.zza(parcel, 5, signInConfiguration.zzkV(), i, false);
        zzb.zza(parcel, 7, signInConfiguration.zzkW(), false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzba(i);
    }

    public SignInConfiguration zzZ(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        GoogleSignInOptions googleSignInOptions = null;
        EmailSignInOptions emailSignInOptions = null;
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
                    emailSignInOptions = (EmailSignInOptions) zza.zza(parcel, zzbc, EmailSignInOptions.CREATOR);
                    break;
                case 5:
                    googleSignInOptions = (GoogleSignInOptions) zza.zza(parcel, zzbc, GoogleSignInOptions.CREATOR);
                    break;
                case 7:
                    str = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new SignInConfiguration(i, str3, str2, emailSignInOptions, googleSignInOptions, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public SignInConfiguration[] zzba(int i) {
        return new SignInConfiguration[i];
    }
}

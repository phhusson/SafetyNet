package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzd implements Creator<GoogleSignInOptions> {
    static void zza(GoogleSignInOptions googleSignInOptions, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, googleSignInOptions.versionCode);
        zzb.zzc(parcel, 2, googleSignInOptions.getScopes(), false);
        zzb.zza(parcel, 3, googleSignInOptions.getAccount(), i, false);
        zzb.zza(parcel, 4, googleSignInOptions.zzkz());
        zzb.zza(parcel, 5, googleSignInOptions.zzkA());
        zzb.zza(parcel, 6, googleSignInOptions.zzkB());
        zzb.zza(parcel, 7, googleSignInOptions.zzkC(), false);
        zzb.zza(parcel, 8, googleSignInOptions.zzkD(), false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzW(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaX(i);
    }

    public GoogleSignInOptions zzW(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzbc, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) zza.zza(parcel, zzbc, Account.CREATOR);
                    break;
                case 4:
                    z3 = zza.zzc(parcel, zzbc);
                    break;
                case 5:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 7:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 8:
                    str = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new GoogleSignInOptions(i, arrayList, account, z3, z2, z, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public GoogleSignInOptions[] zzaX(int i) {
        return new GoogleSignInOptions[i];
    }
}

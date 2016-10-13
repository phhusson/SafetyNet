package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzc implements Creator<GoogleSignInAccount> {
    static void zza(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, googleSignInAccount.versionCode);
        zzb.zza(parcel, 2, googleSignInAccount.getId(), false);
        zzb.zza(parcel, 3, googleSignInAccount.getIdToken(), false);
        zzb.zza(parcel, 4, googleSignInAccount.getEmail(), false);
        zzb.zza(parcel, 5, googleSignInAccount.getDisplayName(), false);
        zzb.zza(parcel, 6, googleSignInAccount.getPhotoUrl(), i, false);
        zzb.zza(parcel, 7, googleSignInAccount.getServerAuthCode(), false);
        zzb.zza(parcel, 8, googleSignInAccount.zzkw());
        zzb.zza(parcel, 9, googleSignInAccount.zzkx(), false);
        zzb.zzc(parcel, 10, googleSignInAccount.zzXb, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaW(i);
    }

    public GoogleSignInAccount zzV(Parcel parcel) {
        List list = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
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
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 8:
                    j = zza.zzi(parcel, zzbc);
                    break;
                case 9:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 10:
                    list = zza.zzc(parcel, zzbc, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new GoogleSignInAccount(i, str6, str5, str4, str3, uri, str2, j, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public GoogleSignInAccount[] zzaW(int i) {
        return new GoogleSignInAccount[i];
    }
}

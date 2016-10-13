package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

public class zzb implements Creator<FacebookSignInOptions> {
    static void zza(FacebookSignInOptions facebookSignInOptions, Parcel parcel, int i) {
        int zzbe = com.google.android.gms.common.internal.safeparcel.zzb.zzbe(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, facebookSignInOptions.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, facebookSignInOptions.getCustomFacebookSignInActivityIntent(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 3, facebookSignInOptions.getScopes(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaV(i);
    }

    public FacebookSignInOptions zzU(Parcel parcel) {
        ArrayList arrayList = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        Intent intent = null;
        while (parcel.dataPosition() < zzbd) {
            Intent intent2;
            int zzg;
            ArrayList arrayList2;
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    ArrayList arrayList3 = arrayList;
                    intent2 = intent;
                    zzg = zza.zzg(parcel, zzbc);
                    arrayList2 = arrayList3;
                    break;
                case 2:
                    zzg = i;
                    Intent intent3 = (Intent) zza.zza(parcel, zzbc, Intent.CREATOR);
                    arrayList2 = arrayList;
                    intent2 = intent3;
                    break;
                case 3:
                    arrayList2 = zza.zzE(parcel, zzbc);
                    intent2 = intent;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    arrayList2 = arrayList;
                    intent2 = intent;
                    zzg = i;
                    break;
            }
            i = zzg;
            intent = intent2;
            arrayList = arrayList2;
        }
        if (parcel.dataPosition() == zzbd) {
            return new FacebookSignInOptions(i, intent, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public FacebookSignInOptions[] zzaV(int i) {
        return new FacebookSignInOptions[i];
    }
}

package com.google.android.gms.auth.firstparty.dataservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PostSignInDataCreator implements Creator<PostSignInData> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(PostSignInData postSignInData, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, postSignInData.version);
        zzb.zza(parcel, 2, postSignInData.postSignInForeignIntent, i, false);
        zzb.zza(parcel, 3, postSignInData.accountInstallationCompletionAction, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public PostSignInData createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        Intent intent = null;
        while (parcel.dataPosition() < zzbd) {
            Intent intent2;
            int zzg;
            PendingIntent pendingIntent2;
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    PendingIntent pendingIntent3 = pendingIntent;
                    intent2 = intent;
                    zzg = zza.zzg(parcel, zzbc);
                    pendingIntent2 = pendingIntent3;
                    break;
                case 2:
                    zzg = i;
                    Intent intent3 = (Intent) zza.zza(parcel, zzbc, Intent.CREATOR);
                    pendingIntent2 = pendingIntent;
                    intent2 = intent3;
                    break;
                case 3:
                    pendingIntent2 = (PendingIntent) zza.zza(parcel, zzbc, PendingIntent.CREATOR);
                    intent2 = intent;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    pendingIntent2 = pendingIntent;
                    intent2 = intent;
                    zzg = i;
                    break;
            }
            i = zzg;
            intent = intent2;
            pendingIntent = pendingIntent2;
        }
        if (parcel.dataPosition() == zzbd) {
            return new PostSignInData(i, intent, pendingIntent);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public PostSignInData[] newArray(int size) {
        return new PostSignInData[size];
    }
}

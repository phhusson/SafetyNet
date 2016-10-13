package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class RecoveryDecisionCreator implements Creator<RecoveryDecision> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(RecoveryDecision recoveryDecision, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, recoveryDecision.mVersionCode);
        zzb.zza(parcel, 2, recoveryDecision.recoveryIntent, i, false);
        zzb.zza(parcel, 3, recoveryDecision.showRecoveryInterstitial);
        zzb.zza(parcel, 4, recoveryDecision.isRecoveryInfoNeeded);
        zzb.zza(parcel, 5, recoveryDecision.isRecoveryInterstitialAllowed);
        zzb.zza(parcel, 6, recoveryDecision.recoveryIntentWithoutIntro, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public RecoveryDecision createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        boolean z2 = false;
        boolean z3 = false;
        PendingIntent pendingIntent2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    pendingIntent2 = (PendingIntent) zza.zza(parcel, zzbc, PendingIntent.CREATOR);
                    break;
                case 3:
                    z3 = zza.zzc(parcel, zzbc);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzbc, PendingIntent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new RecoveryDecision(i, pendingIntent2, z3, z2, z, pendingIntent);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public RecoveryDecision[] newArray(int size) {
        return new RecoveryDecision[size];
    }
}

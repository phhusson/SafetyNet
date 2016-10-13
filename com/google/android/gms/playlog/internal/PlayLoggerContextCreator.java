package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlayLoggerContextCreator implements Creator<PlayLoggerContext> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(PlayLoggerContext playLoggerContext, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, playLoggerContext.versionCode);
        zzb.zza(parcel, 2, playLoggerContext.packageName, false);
        zzb.zzc(parcel, 3, playLoggerContext.packageVersionCode);
        zzb.zzc(parcel, 4, playLoggerContext.logSource);
        zzb.zza(parcel, 5, playLoggerContext.uploadAccountName, false);
        zzb.zza(parcel, 6, playLoggerContext.loggingId, false);
        zzb.zza(parcel, 7, playLoggerContext.logAndroidId);
        zzb.zza(parcel, 8, playLoggerContext.logSourceName, false);
        zzb.zza(parcel, 9, playLoggerContext.isAnonymous);
        zzb.zzc(parcel, 10, playLoggerContext.qosTier);
        zzb.zzJ(parcel, zzbe);
    }

    public PlayLoggerContext createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i4 = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str4 = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzbc);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                case 5:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 6:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 8:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 9:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 10:
                    i = zza.zzg(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new PlayLoggerContext(i4, str4, i3, i2, str3, str2, z, str, z2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public PlayLoggerContext[] newArray(int size) {
        return new PlayLoggerContext[size];
    }
}

package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class LogEventParcelableCreator implements Creator<LogEventParcelable> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, logEventParcelable.versionCode);
        zzb.zza(parcel, 2, logEventParcelable.playLoggerContext, i, false);
        zzb.zza(parcel, 3, logEventParcelable.logEventBytes, false);
        zzb.zza(parcel, 4, logEventParcelable.testCodes, false);
        zzb.zzJ(parcel, zzbe);
    }

    public LogEventParcelable createFromParcel(Parcel parcel) {
        int[] iArr = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        byte[] bArr = null;
        PlayLoggerContext playLoggerContext = null;
        while (parcel.dataPosition() < zzbd) {
            byte[] bArr2;
            PlayLoggerContext playLoggerContext2;
            int zzg;
            int[] iArr2;
            int zzbc = zza.zzbc(parcel);
            int[] iArr3;
            switch (zza.zzdr(zzbc)) {
                case 1:
                    iArr3 = iArr;
                    bArr2 = bArr;
                    playLoggerContext2 = playLoggerContext;
                    zzg = zza.zzg(parcel, zzbc);
                    iArr2 = iArr3;
                    break;
                case 2:
                    zzg = i;
                    byte[] bArr3 = bArr;
                    playLoggerContext2 = (PlayLoggerContext) zza.zza(parcel, zzbc, PlayLoggerContext.CREATOR);
                    iArr2 = iArr;
                    bArr2 = bArr3;
                    break;
                case 3:
                    playLoggerContext2 = playLoggerContext;
                    zzg = i;
                    iArr3 = iArr;
                    bArr2 = zza.zzt(parcel, zzbc);
                    iArr2 = iArr3;
                    break;
                case 4:
                    iArr2 = zza.zzw(parcel, zzbc);
                    bArr2 = bArr;
                    playLoggerContext2 = playLoggerContext;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    iArr2 = iArr;
                    bArr2 = bArr;
                    playLoggerContext2 = playLoggerContext;
                    zzg = i;
                    break;
            }
            i = zzg;
            playLoggerContext = playLoggerContext2;
            bArr = bArr2;
            iArr = iArr2;
        }
        if (parcel.dataPosition() == zzbd) {
            return new LogEventParcelable(i, playLoggerContext, bArr, iArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public LogEventParcelable[] newArray(int size) {
        return new LogEventParcelable[size];
    }
}

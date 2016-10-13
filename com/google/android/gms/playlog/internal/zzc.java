package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<LogEvent> {
    static void zza(LogEvent logEvent, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, logEvent.versionCode);
        zzb.zza(parcel, 2, logEvent.zzbLA);
        zzb.zza(parcel, 3, logEvent.tag, false);
        zzb.zza(parcel, 4, logEvent.zzbLC, false);
        zzb.zza(parcel, 5, logEvent.zzbLD, false);
        zzb.zza(parcel, 6, logEvent.zzbLB);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzoi(i);
    }

    public LogEvent zzjY(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        byte[] bArr = null;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzbc);
                    break;
                case 3:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    bArr = zza.zzt(parcel, zzbc);
                    break;
                case 5:
                    bundle = zza.zzs(parcel, zzbc);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new LogEvent(i, j2, j, str, bArr, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public LogEvent[] zzoi(int i) {
        return new LogEvent[i];
    }
}

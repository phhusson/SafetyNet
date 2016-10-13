package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzh implements Creator<WakeLockEvent> {
    static void zza(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, wakeLockEvent.mVersionCode);
        zzb.zza(parcel, 2, wakeLockEvent.getTimeMillis());
        zzb.zza(parcel, 4, wakeLockEvent.zzrW(), false);
        zzb.zzc(parcel, 5, wakeLockEvent.zzrY());
        zzb.zzb(parcel, 6, wakeLockEvent.zzrZ(), false);
        zzb.zza(parcel, 8, wakeLockEvent.zzrS());
        zzb.zza(parcel, 10, wakeLockEvent.zzrX(), false);
        zzb.zzc(parcel, 11, wakeLockEvent.getEventType());
        zzb.zza(parcel, 12, wakeLockEvent.zzrQ(), false);
        zzb.zza(parcel, 13, wakeLockEvent.zzsb(), false);
        zzb.zzc(parcel, 14, wakeLockEvent.zzsa());
        zzb.zza(parcel, 15, wakeLockEvent.zzsc());
        zzb.zza(parcel, 16, wakeLockEvent.zzsd());
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdB(i);
    }

    public WakeLockEvent zzbl(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzbc);
                    break;
                case 4:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzbc);
                    break;
                case 6:
                    list = zza.zzE(parcel, zzbc);
                    break;
                case 8:
                    j2 = zza.zzi(parcel, zzbc);
                    break;
                case 10:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 11:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                case 12:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 13:
                    str4 = zza.zzq(parcel, zzbc);
                    break;
                case 14:
                    i4 = zza.zzg(parcel, zzbc);
                    break;
                case 15:
                    f = zza.zzl(parcel, zzbc);
                    break;
                case 16:
                    j3 = zza.zzi(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public WakeLockEvent[] zzdB(int i) {
        return new WakeLockEvent[i];
    }
}

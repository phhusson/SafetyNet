package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<Status> {
    static void zza(Status status, Parcel parcel, int i) {
        int zzbe = com.google.android.gms.common.internal.safeparcel.zzb.zzbe(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, status.getStatusCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, status.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, status.getStatusMessage(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, status.getPendingIntent(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcP(i);
    }

    public Status zzaR(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzbc, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Status[] zzcP(int i) {
        return new Status[i];
    }
}

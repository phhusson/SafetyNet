package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class LatencyTrackerCreator implements Creator<LatencyTracker> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(LatencyTracker latencyTracker, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, latencyTracker.mVersion);
        zzb.zza(parcel, 2, latencyTracker.mName, false);
        zzb.zza(parcel, 3, latencyTracker.zzacs);
        zzb.zza(parcel, 4, latencyTracker.parent, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public LatencyTracker createFromParcel(Parcel parcel) {
        LatencyTracker latencyTracker = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        long j = 0;
        String str = null;
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
                    j = zza.zzi(parcel, zzbc);
                    break;
                case 4:
                    latencyTracker = (LatencyTracker) zza.zza(parcel, zzbc, LatencyTracker.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new LatencyTracker(i, str, j, latencyTracker);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public LatencyTracker[] newArray(int size) {
        return new LatencyTracker[size];
    }
}

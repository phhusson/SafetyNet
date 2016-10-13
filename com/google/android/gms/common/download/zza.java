package com.google.android.gms.common.download;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<DownloadDetails> {
    static void zza(DownloadDetails downloadDetails, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, downloadDetails.versionCode);
        zzb.zza(parcel, 2, downloadDetails.filename, false);
        zzb.zza(parcel, 3, downloadDetails.url, false);
        zzb.zza(parcel, 4, downloadDetails.zzaud);
        zzb.zza(parcel, 5, downloadDetails.zzaue, false);
        zzb.zza(parcel, 6, downloadDetails.zzauf, false);
        zzb.zzc(parcel, 7, downloadDetails.zzaug);
        zzb.zzc(parcel, 8, downloadDetails.zzauh);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdc(i);
    }

    public DownloadDetails zzaT(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzbd = com.google.android.gms.common.internal.safeparcel.zza.zzbd(parcel);
        long j = 0;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = com.google.android.gms.common.internal.safeparcel.zza.zzbc(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzdr(zzbc)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzbc);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzbc);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzbc);
                    break;
                case 7:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzbc);
                    break;
                case 8:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzbc);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new DownloadDetails(i3, str4, str3, j, str2, str, i2, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public DownloadDetails[] zzdc(int i) {
        return new DownloadDetails[i];
    }
}

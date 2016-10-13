package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<Scope> {
    static void zza(Scope scope, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, scope.mVersionCode);
        zzb.zza(parcel, 2, scope.zzpq(), false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcO(i);
    }

    public Scope zzaQ(Parcel parcel) {
        int zzbd = com.google.android.gms.common.internal.safeparcel.zza.zzbd(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = com.google.android.gms.common.internal.safeparcel.zza.zzbc(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzdr(zzbc)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzbc);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new Scope(i, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Scope[] zzcO(int i) {
        return new Scope[i];
    }
}

package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<SafeParcelResponse> {
    static void zza(SafeParcelResponse safeParcelResponse, Parcel parcel, int i) {
        int zzbe = com.google.android.gms.common.internal.safeparcel.zzb.zzbe(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, safeParcelResponse.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, safeParcelResponse.zzrJ(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, safeParcelResponse.zzrK(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdz(i);
    }

    public SafeParcelResponse zzbj(Parcel parcel) {
        FieldMappingDictionary fieldMappingDictionary = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    parcel2 = zza.zzF(parcel, zzbc);
                    break;
                case 3:
                    fieldMappingDictionary = (FieldMappingDictionary) zza.zza(parcel, zzbc, FieldMappingDictionary.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public SafeParcelResponse[] zzdz(int i) {
        return new SafeParcelResponse[i];
    }
}

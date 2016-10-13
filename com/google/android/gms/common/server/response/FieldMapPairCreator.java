package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;

public class FieldMapPairCreator implements Creator<FieldMapPair> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(FieldMapPair fieldMapPair, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, fieldMapPair.versionCode);
        zzb.zza(parcel, 2, fieldMapPair.key, false);
        zzb.zza(parcel, 3, fieldMapPair.zzayf, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public FieldMapPair createFromParcel(Parcel parcel) {
        Field field = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
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
                    field = (Field) zza.zza(parcel, zzbc, Field.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new FieldMapPair(i, str, field);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public FieldMapPair[] newArray(int size) {
        return new FieldMapPair[size];
    }
}

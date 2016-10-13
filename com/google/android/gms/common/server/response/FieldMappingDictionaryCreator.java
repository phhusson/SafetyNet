package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import java.util.ArrayList;

public class FieldMappingDictionaryCreator implements Creator<FieldMappingDictionary> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(FieldMappingDictionary fieldMappingDictionary, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, fieldMappingDictionary.getVersionCode());
        zzb.zzc(parcel, 2, fieldMappingDictionary.zzrH(), false);
        zzb.zza(parcel, 3, fieldMappingDictionary.getRootClassName(), false);
        zzb.zzJ(parcel, zzbe);
    }

    public FieldMappingDictionary createFromParcel(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzbc, Entry.CREATOR);
                    break;
                case 3:
                    str = zza.zzq(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new FieldMappingDictionary(i, arrayList, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public FieldMappingDictionary[] newArray(int size) {
        return new FieldMappingDictionary[size];
    }
}

package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

public class FieldCreator implements Creator<Field> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(Field field, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, field.getVersionCode());
        zzb.zzc(parcel, 2, field.getTypeIn());
        zzb.zza(parcel, 3, field.isTypeInArray());
        zzb.zzc(parcel, 4, field.getTypeOut());
        zzb.zza(parcel, 5, field.isTypeOutArray());
        zzb.zza(parcel, 6, field.getOutputFieldName(), false);
        zzb.zzc(parcel, 7, field.getSafeParcelableFieldId());
        zzb.zza(parcel, 8, field.zzrF(), false);
        zzb.zza(parcel, 9, field.zzrG(), i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public Field createFromParcel(Parcel parcel) {
        ConverterWrapper converterWrapper = null;
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i4 = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    i3 = zza.zzg(parcel, zzbc);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzbc);
                    break;
                case 6:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 8:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 9:
                    converterWrapper = (ConverterWrapper) zza.zza(parcel, zzbc, ConverterWrapper.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new Field(i4, i3, z2, i2, z, str2, i, str, converterWrapper);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Field[] newArray(int size) {
        return new Field[size];
    }
}

package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<ContactPreferredFieldsEntity> {
    static void zza(ContactPreferredFieldsEntity contactPreferredFieldsEntity, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, contactPreferredFieldsEntity.mVersionCode);
        zzb.zza(parcel, 2, contactPreferredFieldsEntity.zzYA, false);
        zzb.zza(parcel, 3, contactPreferredFieldsEntity.mName, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznD(i);
    }

    public ContactPreferredFieldsEntity zzjz(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str2 = zza.zzq(parcel, zzbc);
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
            return new ContactPreferredFieldsEntity(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ContactPreferredFieldsEntity[] zznD(int i) {
        return new ContactPreferredFieldsEntity[i];
    }
}

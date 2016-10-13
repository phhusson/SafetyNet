package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<GroupExtendedDataImpl> {
    static void zza(GroupExtendedDataImpl groupExtendedDataImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, groupExtendedDataImpl.mVersionCode);
        zzb.zza(parcel, 2, groupExtendedDataImpl.zzbIk, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznG(i);
    }

    public GroupExtendedDataImpl zzjC(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        ContactPreferredFieldsEntity[] contactPreferredFieldsEntityArr = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    contactPreferredFieldsEntityArr = (ContactPreferredFieldsEntity[]) zza.zzb(parcel, zzbc, ContactPreferredFieldsEntity.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new GroupExtendedDataImpl(i, contactPreferredFieldsEntityArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public GroupExtendedDataImpl[] zznG(int i) {
        return new GroupExtendedDataImpl[i];
    }
}

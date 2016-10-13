package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<ContactGroupImpl> {
    static void zza(ContactGroupImpl contactGroupImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, contactGroupImpl.mVersionCode);
        zzb.zza(parcel, 2, contactGroupImpl.zzbIf, i, false);
        zzb.zza(parcel, 3, contactGroupImpl.zzbIg, i, false);
        zzb.zza(parcel, 4, contactGroupImpl.zzbIh, i, false);
        zzb.zzc(parcel, 5, contactGroupImpl.zzbIi);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznB(i);
    }

    public ContactGroupImpl zzjx(Parcel parcel) {
        int i = 0;
        GroupExtendedDataImpl groupExtendedDataImpl = null;
        int zzbd = zza.zzbd(parcel);
        ContactGroupNameImpl contactGroupNameImpl = null;
        ContactGroupIdImpl contactGroupIdImpl = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    contactGroupIdImpl = (ContactGroupIdImpl) zza.zza(parcel, zzbc, ContactGroupIdImpl.CREATOR);
                    break;
                case 3:
                    contactGroupNameImpl = (ContactGroupNameImpl) zza.zza(parcel, zzbc, ContactGroupNameImpl.CREATOR);
                    break;
                case 4:
                    groupExtendedDataImpl = (GroupExtendedDataImpl) zza.zza(parcel, zzbc, GroupExtendedDataImpl.CREATOR);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new ContactGroupImpl(i2, contactGroupIdImpl, contactGroupNameImpl, groupExtendedDataImpl, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ContactGroupImpl[] zznB(int i) {
        return new ContactGroupImpl[i];
    }
}

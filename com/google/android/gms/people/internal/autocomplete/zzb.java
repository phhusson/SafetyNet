package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<AutocompletionImpl> {
    static void zza(AutocompletionImpl autocompletionImpl, Parcel parcel, int i) {
        int zzbe = com.google.android.gms.common.internal.safeparcel.zzb.zzbe(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, autocompletionImpl.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, autocompletionImpl.zzbIa);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, autocompletionImpl.zzbIb, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, autocompletionImpl.zzbIc, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, autocompletionImpl.zzbId, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjv(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznz(i);
    }

    public AutocompletionImpl zzjv(Parcel parcel) {
        int i = 0;
        DisplayableFieldImpl[] displayableFieldImplArr = null;
        int zzbd = zza.zzbd(parcel);
        ContactGroupImpl contactGroupImpl = null;
        PersonImpl personImpl = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 3:
                    personImpl = (PersonImpl) zza.zza(parcel, zzbc, PersonImpl.CREATOR);
                    break;
                case 4:
                    contactGroupImpl = (ContactGroupImpl) zza.zza(parcel, zzbc, ContactGroupImpl.CREATOR);
                    break;
                case 5:
                    displayableFieldImplArr = (DisplayableFieldImpl[]) zza.zzb(parcel, zzbc, DisplayableFieldImpl.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AutocompletionImpl(i2, i, personImpl, contactGroupImpl, displayableFieldImplArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AutocompletionImpl[] zznz(int i) {
        return new AutocompletionImpl[i];
    }
}

package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<ContactGroupIdImpl> {
    static void zza(ContactGroupIdImpl contactGroupIdImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, contactGroupIdImpl.mVersionCode);
        zzb.zza(parcel, 2, contactGroupIdImpl.zzyU, false);
        zzb.zza(parcel, 3, contactGroupIdImpl.zzbIe, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznA(i);
    }

    public ContactGroupIdImpl zzjw(Parcel parcel) {
        String[] strArr = null;
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
                    strArr = zza.zzC(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new ContactGroupIdImpl(i, str, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ContactGroupIdImpl[] zznA(int i) {
        return new ContactGroupIdImpl[i];
    }
}

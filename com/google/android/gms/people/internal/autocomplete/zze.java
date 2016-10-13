package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<ContactGroupNameImpl> {
    static void zza(ContactGroupNameImpl contactGroupNameImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, contactGroupNameImpl.mVersionCode);
        zzb.zza(parcel, 2, contactGroupNameImpl.mValue, false);
        zzb.zza(parcel, 3, contactGroupNameImpl.zzaWt, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznC(i);
    }

    public ContactGroupNameImpl zzjy(Parcel parcel) {
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
            return new ContactGroupNameImpl(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ContactGroupNameImpl[] zznC(int i) {
        return new ContactGroupNameImpl[i];
    }
}

package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.people.identity.internal.models.PersonImpl.AddressesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import java.util.HashSet;
import java.util.Set;

public class zzb implements Creator<AddressesImpl> {
    static void zza(AddressesImpl addressesImpl, Parcel parcel, int i) {
        int zzbe = com.google.android.gms.common.internal.safeparcel.zzb.zzbe(parcel);
        Set set = addressesImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, addressesImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, addressesImpl.zzbDR, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, addressesImpl.zzbCO, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, addressesImpl.zzbCP, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, addressesImpl.zzbCQ, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, addressesImpl.zzbCR, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, addressesImpl.zzbCS, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, addressesImpl.zzbCT, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, addressesImpl.zzbCU, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, addressesImpl.zzbCV, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, addressesImpl.zzKj, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, addressesImpl.mValue, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzih(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmb(i);
    }

    public AddressesImpl zzih(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        MetadataImpl metadataImpl = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    MetadataImpl metadataImpl2 = (MetadataImpl) zza.zza(parcel, zzbc, MetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    metadataImpl = metadataImpl2;
                    break;
                case 3:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str4 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str5 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str6 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str7 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    str8 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    str9 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(11));
                    break;
                case 12:
                    str10 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(12));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AddressesImpl(hashSet, i, metadataImpl, str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AddressesImpl[] zzmb(int i) {
        return new AddressesImpl[i];
    }
}

package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.PhoneNumbersImpl;
import java.util.HashSet;
import java.util.Set;

public class zzbh implements Creator<PhoneNumbersImpl> {
    static void zza(PhoneNumbersImpl phoneNumbersImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = phoneNumbersImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, phoneNumbersImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, phoneNumbersImpl.zzbDR, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, phoneNumbersImpl.zzbDL, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, phoneNumbersImpl.zzbCR, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, phoneNumbersImpl.zzKj, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, phoneNumbersImpl.mValue, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zzc(parcel, 7, phoneNumbersImpl.zzbAq);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjk(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznk(i);
    }

    public PhoneNumbersImpl zzjk(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        String str3 = null;
        String str4 = null;
        MetadataImpl metadataImpl = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i2 = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    MetadataImpl metadataImpl2 = (MetadataImpl) zza.zza(parcel, zzbc, MetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    metadataImpl = metadataImpl2;
                    break;
                case 3:
                    str4 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new PhoneNumbersImpl(hashSet, i2, metadataImpl, str4, str3, str2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public PhoneNumbersImpl[] zznk(int i) {
        return new PhoneNumbersImpl[i];
    }
}

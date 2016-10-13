package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.PhoneNumbers;
import java.util.HashSet;
import java.util.Set;

public class zzae implements Creator<PhoneNumbers> {
    static void zza(PhoneNumbers phoneNumbers, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = phoneNumbers.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, phoneNumbers.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, phoneNumbers.zzbDL, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, phoneNumbers.zzbCR, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, phoneNumbers.zzbCN, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, phoneNumbers.zzKj, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, phoneNumbers.mValue, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziJ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmD(i);
    }

    public PhoneNumbers zziJ(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        DefaultMetadataImpl defaultMetadataImpl = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str4 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    DefaultMetadataImpl defaultMetadataImpl2 = (DefaultMetadataImpl) zza.zza(parcel, zzbc, DefaultMetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    defaultMetadataImpl = defaultMetadataImpl2;
                    break;
                case 5:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new PhoneNumbers(hashSet, i, str4, str3, defaultMetadataImpl, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public PhoneNumbers[] zzmD(int i) {
        return new PhoneNumbers[i];
    }
}

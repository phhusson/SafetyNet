package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Organizations;
import java.util.HashSet;
import java.util.Set;

public class zzad implements Creator<Organizations> {
    static void zza(Organizations organizations, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = organizations.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, organizations.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, organizations.zzbDD);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, organizations.zzbDE, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, organizations.mDescription, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, organizations.zzbDF, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, organizations.zzbDG, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, organizations.zzbDH, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, organizations.zzbCN, i, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, organizations.mName, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zza(parcel, 10, organizations.zzbDI, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            zzb.zza(parcel, 11, organizations.zzbDJ, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zza(parcel, 12, organizations.zzbDK, true);
        }
        if (set.contains(Integer.valueOf(13))) {
            zzb.zza(parcel, 13, organizations.zzaEg, true);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzb.zza(parcel, 14, organizations.zzKj, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmC(i);
    }

    public Organizations zziI(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        DefaultMetadataImpl defaultMetadataImpl = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    z = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(2));
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
                    DefaultMetadataImpl defaultMetadataImpl2 = (DefaultMetadataImpl) zza.zza(parcel, zzbc, DefaultMetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    defaultMetadataImpl = defaultMetadataImpl2;
                    break;
                case 9:
                    str6 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    str7 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    str8 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(11));
                    break;
                case 12:
                    str9 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 13:
                    str10 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    str11 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(14));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new Organizations(hashSet, i, z, str, str2, str3, str4, str5, defaultMetadataImpl, str6, str7, str8, str9, str10, str11);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Organizations[] zzmC(int i) {
        return new Organizations[i];
    }
}

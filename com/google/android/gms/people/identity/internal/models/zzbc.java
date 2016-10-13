package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.OrganizationsImpl;
import java.util.HashSet;
import java.util.Set;

public class zzbc implements Creator<OrganizationsImpl> {
    static void zza(OrganizationsImpl organizationsImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = organizationsImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, organizationsImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, organizationsImpl.zzbDR, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, organizationsImpl.zzbDD);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, organizationsImpl.zzbDE, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, organizationsImpl.mDescription, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, organizationsImpl.zzbDF, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, organizationsImpl.zzbDG, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, organizationsImpl.zzbDH, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, organizationsImpl.mName, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zza(parcel, 10, organizationsImpl.zzbDI, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            zzb.zza(parcel, 11, organizationsImpl.zzbDJ, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zza(parcel, 12, organizationsImpl.zzbDK, true);
        }
        if (set.contains(Integer.valueOf(13))) {
            zzb.zza(parcel, 13, organizationsImpl.zzaEg, true);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzb.zza(parcel, 14, organizationsImpl.zzKj, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjg(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznb(i);
    }

    public OrganizationsImpl zzjg(Parcel parcel) {
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        MetadataImpl metadataImpl = null;
        boolean z = false;
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
        String str11 = null;
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
                    z = zza.zzc(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str4 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str5 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(8));
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
            return new OrganizationsImpl(hashSet, i, metadataImpl, z, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public OrganizationsImpl[] zznb(int i) {
        return new OrganizationsImpl[i];
    }
}

package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.RelationshipInterestsImpl;
import java.util.HashSet;
import java.util.Set;

public class zzbl implements Creator<RelationshipInterestsImpl> {
    static void zza(RelationshipInterestsImpl relationshipInterestsImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = relationshipInterestsImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, relationshipInterestsImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, relationshipInterestsImpl.zzbDR, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, relationshipInterestsImpl.mValue, true);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzno(i);
    }

    public RelationshipInterestsImpl zzjo(Parcel parcel) {
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        MetadataImpl metadataImpl = null;
        while (parcel.dataPosition() < zzbd) {
            MetadataImpl metadataImpl2;
            int i2;
            String str2;
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    zzbc = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(1));
                    String str3 = str;
                    metadataImpl2 = metadataImpl;
                    i2 = zzbc;
                    str2 = str3;
                    break;
                case 2:
                    MetadataImpl metadataImpl3 = (MetadataImpl) zza.zza(parcel, zzbc, MetadataImpl.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    i2 = i;
                    MetadataImpl metadataImpl4 = metadataImpl3;
                    str2 = str;
                    metadataImpl2 = metadataImpl4;
                    break;
                case 3:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    metadataImpl2 = metadataImpl;
                    i2 = i;
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    str2 = str;
                    metadataImpl2 = metadataImpl;
                    i2 = i;
                    break;
            }
            i = i2;
            metadataImpl = metadataImpl2;
            str = str2;
        }
        if (parcel.dataPosition() == zzbd) {
            return new RelationshipInterestsImpl(hashSet, i, metadataImpl, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public RelationshipInterestsImpl[] zzno(int i) {
        return new RelationshipInterestsImpl[i];
    }
}

package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.people.identity.internal.models.PersonImpl.EmailsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import java.util.HashSet;
import java.util.Set;

public class zzap implements Creator<EmailsImpl> {
    static void zza(EmailsImpl emailsImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        Set set = emailsImpl.zzbCc;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, emailsImpl.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, emailsImpl.zzbDR, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, emailsImpl.zzbCR, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, emailsImpl.zzKj, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, emailsImpl.mValue, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zzc(parcel, 6, emailsImpl.zzbAq);
        }
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmN(i);
    }

    public EmailsImpl zziT(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzbd = zza.zzbd(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        String str3 = null;
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
                    str3 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str2 = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str = zza.zzq(parcel, zzbc);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i = zza.zzg(parcel, zzbc);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new EmailsImpl(hashSet, i2, metadataImpl, str3, str2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public EmailsImpl[] zzmN(int i) {
        return new EmailsImpl[i];
    }
}

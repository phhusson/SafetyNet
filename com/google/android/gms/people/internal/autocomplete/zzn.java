package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Creator<PersonImpl> {
    static void zza(PersonImpl personImpl, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, personImpl.mVersionCode);
        zzb.zza(parcel, 2, personImpl.zzbIm, i, false);
        zzb.zza(parcel, 3, personImpl.zzbIn, i, false);
        zzb.zza(parcel, 4, personImpl.zzbIo, i, false);
        zzb.zza(parcel, 5, personImpl.zzbIp, i, false);
        zzb.zza(parcel, 6, personImpl.zzbIq, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznK(i);
    }

    public PersonImpl zzjG(Parcel parcel) {
        PhotoImpl[] photoImplArr = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        PhoneImpl[] phoneImplArr = null;
        EmailImpl[] emailImplArr = null;
        NameImpl[] nameImplArr = null;
        PersonMetadataImpl personMetadataImpl = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    personMetadataImpl = (PersonMetadataImpl) zza.zza(parcel, zzbc, PersonMetadataImpl.CREATOR);
                    break;
                case 3:
                    nameImplArr = (NameImpl[]) zza.zzb(parcel, zzbc, NameImpl.CREATOR);
                    break;
                case 4:
                    emailImplArr = (EmailImpl[]) zza.zzb(parcel, zzbc, EmailImpl.CREATOR);
                    break;
                case 5:
                    phoneImplArr = (PhoneImpl[]) zza.zzb(parcel, zzbc, PhoneImpl.CREATOR);
                    break;
                case 6:
                    photoImplArr = (PhotoImpl[]) zza.zzb(parcel, zzbc, PhotoImpl.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new PersonImpl(i, personMetadataImpl, nameImplArr, emailImplArr, phoneImplArr, photoImplArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public PersonImpl[] zznK(int i) {
        return new PersonImpl[i];
    }
}

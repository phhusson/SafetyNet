package com.google.android.gms.people.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ParcelableAvatarReference implements Creator<AvatarReference> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AvatarReference avatarReference, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, avatarReference.getSource());
        zzb.zzc(parcel, 1000, avatarReference.getVersionCode());
        zzb.zza(parcel, 2, avatarReference.getLocation(), false);
        zzb.zzJ(parcel, zzbe);
    }

    public AvatarReference createFromParcel(Parcel parcel) {
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AvatarReference(i2, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AvatarReference[] newArray(int size) {
        return new AvatarReference[size];
    }
}

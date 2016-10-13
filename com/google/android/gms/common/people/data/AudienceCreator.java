package com.google.android.gms.common.people.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class AudienceCreator implements Creator<Audience> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(Audience audience, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, audience.getAudienceMemberList(), false);
        zzb.zzc(parcel, 1000, audience.getVersionCode());
        zzb.zzc(parcel, 2, audience.getDomainRestricted());
        zzb.zza(parcel, 3, audience.zzrA());
        zzb.zza(parcel, 4, audience.isReadOnly());
        zzb.zzJ(parcel, zzbe);
    }

    public Audience createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    list = zza.zzc(parcel, zzbc, AudienceMember.CREATOR);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzbc);
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
            return new Audience(i2, list, i, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Audience[] newArray(int size) {
        return new Audience[size];
    }
}

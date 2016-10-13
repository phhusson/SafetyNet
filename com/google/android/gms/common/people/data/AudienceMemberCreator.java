package com.google.android.gms.common.people.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AudienceMemberCreator implements Creator<AudienceMember> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AudienceMember audienceMember, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, audienceMember.getType());
        zzb.zzc(parcel, 1000, audienceMember.getVersionCode());
        zzb.zzc(parcel, 2, audienceMember.getCircleType());
        zzb.zza(parcel, 3, audienceMember.getCircleId(), false);
        zzb.zza(parcel, 4, audienceMember.getPeopleQualifiedId(), false);
        zzb.zza(parcel, 5, audienceMember.getDisplayName(), false);
        zzb.zza(parcel, 6, audienceMember.getAvatarUrl(), false);
        zzb.zza(parcel, 7, audienceMember.zzqt(), false);
        zzb.zzJ(parcel, zzbe);
    }

    public AudienceMember createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int zzbd = zza.zzbd(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 3:
                    str4 = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 6:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 7:
                    bundle = zza.zzs(parcel, zzbc);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AudienceMember(i3, i2, i, str4, str3, str2, str, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AudienceMember[] newArray(int size) {
        return new AudienceMember[size];
    }
}

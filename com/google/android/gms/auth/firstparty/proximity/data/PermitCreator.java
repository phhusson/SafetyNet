package com.google.android.gms.auth.firstparty.proximity.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class PermitCreator implements Creator<Permit> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(Permit permit, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, permit.mVersion);
        zzb.zza(parcel, 2, permit.zzyU, false);
        zzb.zza(parcel, 3, permit.zzabR, false);
        zzb.zza(parcel, 5, permit.zzKj, false);
        zzb.zza(parcel, 6, permit.zzabS, i, false);
        zzb.zzc(parcel, 7, permit.zzabT, false);
        zzb.zzb(parcel, 8, permit.zzabV, false);
        zzb.zzJ(parcel, zzbe);
    }

    public Permit createFromParcel(Parcel parcel) {
        List list = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        List list2 = null;
        PermitAccess permitAccess = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str3 = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 6:
                    permitAccess = (PermitAccess) zza.zza(parcel, zzbc, PermitAccess.CREATOR);
                    break;
                case 7:
                    list2 = zza.zzc(parcel, zzbc, PermitAccess.CREATOR);
                    break;
                case 8:
                    list = zza.zzE(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new Permit(i, str3, str2, str, permitAccess, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public Permit[] newArray(int size) {
        return new Permit[size];
    }
}

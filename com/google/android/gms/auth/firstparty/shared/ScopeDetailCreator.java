package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class ScopeDetailCreator implements Creator<ScopeDetail> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(ScopeDetail scopeDetail, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, scopeDetail.version);
        zzb.zza(parcel, 2, scopeDetail.description, false);
        zzb.zza(parcel, 3, scopeDetail.zzaaj, false);
        zzb.zza(parcel, 4, scopeDetail.zzacw, false);
        zzb.zza(parcel, 5, scopeDetail.zzacx, false);
        zzb.zza(parcel, 6, scopeDetail.zzabq, false);
        zzb.zzb(parcel, 7, scopeDetail.zzacy, false);
        zzb.zza(parcel, 8, scopeDetail.friendPickerData, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public ScopeDetail createFromParcel(Parcel parcel) {
        FACLData fACLData = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        List arrayList = new ArrayList();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str5 = zza.zzq(parcel, zzbc);
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
                    arrayList = zza.zzE(parcel, zzbc);
                    break;
                case 8:
                    fACLData = (FACLData) zza.zza(parcel, zzbc, FACLData.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new ScopeDetail(i, str5, str4, str3, str2, str, arrayList, fACLData);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ScopeDetail[] newArray(int size) {
        return new ScopeDetail[size];
    }
}

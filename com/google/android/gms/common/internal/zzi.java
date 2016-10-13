package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<GetServiceRequest> {
    static void zza(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, getServiceRequest.version);
        zzb.zzc(parcel, 2, getServiceRequest.zzavX);
        zzb.zzc(parcel, 3, getServiceRequest.zzavY);
        zzb.zza(parcel, 4, getServiceRequest.zzavZ, false);
        zzb.zza(parcel, 5, getServiceRequest.zzawa, false);
        zzb.zza(parcel, 6, getServiceRequest.zzawb, i, false);
        zzb.zza(parcel, 7, getServiceRequest.zzawc, false);
        zzb.zza(parcel, 8, getServiceRequest.zzawd, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaX(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdi(i);
    }

    public GetServiceRequest zzaX(Parcel parcel) {
        int i = 0;
        Account account = null;
        int zzbd = zza.zzbd(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i3 = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzbc);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 4:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 5:
                    iBinder = zza.zzr(parcel, zzbc);
                    break;
                case 6:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzbc, Scope.CREATOR);
                    break;
                case 7:
                    bundle = zza.zzs(parcel, zzbc);
                    break;
                case 8:
                    account = (Account) zza.zza(parcel, zzbc, Account.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public GetServiceRequest[] zzdi(int i) {
        return new GetServiceRequest[i];
    }
}

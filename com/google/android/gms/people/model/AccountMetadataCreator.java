package com.google.android.gms.people.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AccountMetadataCreator implements Creator<AccountMetadata> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AccountMetadata accountMetadata, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, accountMetadata.mVersionCode);
        zzb.zza(parcel, 2, accountMetadata.isPlusEnabled);
        zzb.zza(parcel, 3, accountMetadata.isSyncEnabled);
        zzb.zza(parcel, 4, accountMetadata.isPagePeriodicSyncEnabled);
        zzb.zza(parcel, 5, accountMetadata.isPageTickleSyncEnabled);
        zzb.zzJ(parcel, zzbe);
    }

    public AccountMetadata createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzbd = zza.zzbd(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i = 0;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    z4 = zza.zzc(parcel, zzbc);
                    break;
                case 3:
                    z3 = zza.zzc(parcel, zzbc);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzbc);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzbc);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new AccountMetadata(i, z4, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public AccountMetadata[] newArray(int size) {
        return new AccountMetadata[size];
    }
}

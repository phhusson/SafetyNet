package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy implements Creator<ResolveAccountRequest> {
    static void zza(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, resolveAccountRequest.mVersionCode);
        zzb.zza(parcel, 2, resolveAccountRequest.getAccount(), i, false);
        zzb.zzc(parcel, 3, resolveAccountRequest.getSessionId());
        zzb.zza(parcel, 4, resolveAccountRequest.zzrq(), i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdn(i);
    }

    public ResolveAccountRequest zzaY(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int zzbd = zza.zzbd(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzbd) {
            int i3;
            Account account2;
            int zzg;
            GoogleSignInAccount googleSignInAccount2;
            int zzbc = zza.zzbc(parcel);
            GoogleSignInAccount googleSignInAccount3;
            switch (zza.zzdr(zzbc)) {
                case 1:
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    zzg = zza.zzg(parcel, zzbc);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 2:
                    zzg = i2;
                    int i4 = i;
                    account2 = (Account) zza.zza(parcel, zzbc, Account.CREATOR);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i4;
                    break;
                case 3:
                    account2 = account;
                    zzg = i2;
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = zza.zzg(parcel, zzbc);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 4:
                    googleSignInAccount2 = (GoogleSignInAccount) zza.zza(parcel, zzbc, GoogleSignInAccount.CREATOR);
                    i3 = i;
                    account2 = account;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            account = account2;
            i = i3;
            googleSignInAccount = googleSignInAccount2;
        }
        if (parcel.dataPosition() == zzbd) {
            return new ResolveAccountRequest(i2, account, i, googleSignInAccount);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public ResolveAccountRequest[] zzdn(int i) {
        return new ResolveAccountRequest[i];
    }
}

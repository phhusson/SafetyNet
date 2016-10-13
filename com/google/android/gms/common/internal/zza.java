package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

public class zza extends com.google.android.gms.common.internal.zzp.zza {
    private Context mContext;
    private Account zzSX;
    int zzpA;

    public static Account zza(zzp com_google_android_gms_common_internal_zzp) {
        Account account = null;
        if (com_google_android_gms_common_internal_zzp != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = com_google_android_gms_common_internal_zzp.getAccount();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return !(o instanceof zza) ? false : this.zzSX.equals(((zza) o).zzSX);
    }

    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzpA) {
            return this.zzSX;
        }
        if (GooglePlayServicesUtilLight.zze(this.mContext, callingUid)) {
            this.zzpA = callingUid;
            return this.zzSX;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}

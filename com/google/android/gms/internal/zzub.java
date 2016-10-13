package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.people.People.zzb;
import com.google.android.gms.people.Sync;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.internal.zzn;

public class zzub implements Sync {
    private PendingResult<Result> zza(GoogleApiClient googleApiClient, String str, String str2, long j, boolean z, boolean z2) {
        final String str3 = str;
        final String str4 = str2;
        final long j2 = j;
        final boolean z3 = z;
        final boolean z4 = z2;
        return googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzub zzbHI;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zzb(str3, str4, j2, z3, z4);
                zza(Status.zzaqL);
            }
        });
    }

    public PendingResult<Result> requestSync(GoogleApiClient googleApiClient, String account, String pageId) {
        if (zzl.isEnabled()) {
            zzl.zzh("requestSync", account, pageId);
        }
        return zza(googleApiClient, account, pageId, 0, false, false);
    }

    public PendingResult<Result> requestSync(GoogleApiClient googleApiClient, String account, String pageId, long allowanceSecond) {
        if (zzl.isEnabled()) {
            zzl.zzh("requestSync", account, pageId, Long.valueOf(allowanceSecond));
        }
        return zza(googleApiClient, account, pageId, allowanceSecond, false, false);
    }

    public PendingResult<Result> requestSync(GoogleApiClient googleApiClient, String account, String pageId, long allowanceSecond, boolean isDisabledByBackgroundSync) {
        if (zzl.isEnabled()) {
            zzl.zzh("requestSync", account, pageId, Long.valueOf(allowanceSecond), Boolean.valueOf(isDisabledByBackgroundSync));
        }
        return zza(googleApiClient, account, pageId, allowanceSecond, false, isDisabledByBackgroundSync);
    }

    public PendingResult<Result> requestSyncByUserAction(GoogleApiClient googleApiClient, String account, String pageId) {
        if (zzl.isEnabled()) {
            zzl.zzh("requestSyncByUserAction", account, pageId);
        }
        return zza(googleApiClient, account, pageId, 0, true, false);
    }
}

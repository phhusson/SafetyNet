package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;

public final class zznv implements zznu {

    private static class zza extends zzns {
        private final zzb<Status> zzasO;

        public zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzasO = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzds(int i) throws RemoteException {
            this.zzasO.zzv(new Status(i));
        }
    }

    public PendingResult<Status> zzk(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zznv zzaxl;

            protected void zza(zznx com_google_android_gms_internal_zznx) throws RemoteException {
                ((zznz) com_google_android_gms_internal_zznx.zzrd()).zza(new zza(this));
            }
        });
    }
}

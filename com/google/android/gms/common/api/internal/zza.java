package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicReference;

public class zza {

    public interface zzb<R> {
        void zzF(Status status);

        void zzv(R r);
    }

    public static abstract class zza<R extends Result, A extends com.google.android.gms.common.api.Api.zzb> extends zzb<R> implements zzb<R>, zze<A> {
        private final zzc<A> zzanH;
        private AtomicReference<zzd> zzaqQ = new AtomicReference();

        protected zza(zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) zzx.zzb((Object) googleApiClient, (Object) "GoogleApiClient must not be null"));
            this.zzanH = (zzc) zzx.zzD(com_google_android_gms_common_api_Api_zzc_A);
        }

        private void zzc(RemoteException remoteException) {
            zzF(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        public final void zzF(Status status) {
            zzx.zzb(!status.isSuccess(), (Object) "Failed result must not be success");
            zza(zzb(status));
        }

        protected abstract void zza(A a) throws RemoteException;

        public void zza(zzd com_google_android_gms_common_api_internal_zzj_zzd) {
            this.zzaqQ.set(com_google_android_gms_common_api_internal_zzj_zzd);
        }

        public final void zzb(A a) throws DeadObjectException {
            try {
                zza((com.google.android.gms.common.api.Api.zzb) a);
            } catch (RemoteException e) {
                zzc(e);
                throw e;
            } catch (RemoteException e2) {
                zzc(e2);
            }
        }

        public final zzc<A> zzpg() {
            return this.zzanH;
        }

        public void zzps() {
            setResultCallback(null);
        }

        protected void zzpt() {
            zzd com_google_android_gms_common_api_internal_zzj_zzd = (zzd) this.zzaqQ.getAndSet(null);
            if (com_google_android_gms_common_api_internal_zzj_zzd != null) {
                com_google_android_gms_common_api_internal_zzj_zzd.zzc(this);
            }
        }

        public /* synthetic */ void zzv(Object obj) {
            super.zza((Result) obj);
        }
    }
}

package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.zzs;
import com.google.android.gms.common.api.internal.zzz;
import com.google.android.gms.common.internal.zzx;

public final class PendingResults {

    private static final class zza<R extends Result> extends com.google.android.gms.common.api.internal.zzb<R> {
        private final R zzaqG;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.zzaqG = r;
        }

        protected R zzb(Status status) {
            if (status.getStatusCode() == this.zzaqG.getStatus().getStatusCode()) {
                return this.zzaqG;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private static final class zzb<R extends Result> extends com.google.android.gms.common.api.internal.zzb<R> {
        private final R zzaqH;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.zzaqH = r;
        }

        protected R zzb(Status status) {
            return this.zzaqH;
        }
    }

    private static final class zzc<R extends Result> extends com.google.android.gms.common.api.internal.zzb<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected R zzb(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        PendingResult com_google_android_gms_common_api_internal_zzz = new zzz(Looper.getMainLooper());
        com_google_android_gms_common_api_internal_zzz.cancel();
        return com_google_android_gms_common_api_internal_zzz;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R result) {
        zzx.zzb((Object) result, (Object) "Result must not be null");
        zzx.zzb(result.getStatus().getStatusCode() == 16, (Object) "Status code must be CommonStatusCodes.CANCELED");
        PendingResult com_google_android_gms_common_api_PendingResults_zza = new zza(result);
        com_google_android_gms_common_api_PendingResults_zza.cancel();
        return com_google_android_gms_common_api_PendingResults_zza;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R result) {
        zzx.zzb((Object) result, (Object) "Result must not be null");
        PendingResult com_google_android_gms_common_api_PendingResults_zzc = new zzc(null);
        com_google_android_gms_common_api_PendingResults_zzc.zza((Result) result);
        return new zzs(com_google_android_gms_common_api_PendingResults_zzc);
    }

    public static PendingResult<Status> immediatePendingResult(Status result) {
        zzx.zzb((Object) result, (Object) "Result must not be null");
        PendingResult com_google_android_gms_common_api_internal_zzz = new zzz(Looper.getMainLooper());
        com_google_android_gms_common_api_internal_zzz.zza((Result) result);
        return com_google_android_gms_common_api_internal_zzz;
    }

    public static <R extends Result> PendingResult<R> zza(R r, GoogleApiClient googleApiClient) {
        zzx.zzb((Object) r, (Object) "Result must not be null");
        zzx.zzb(!r.getStatus().isSuccess(), (Object) "Status code must not be SUCCESS");
        PendingResult com_google_android_gms_common_api_PendingResults_zzb = new zzb(googleApiClient, r);
        com_google_android_gms_common_api_PendingResults_zzb.zza((Result) r);
        return com_google_android_gms_common_api_PendingResults_zzb;
    }

    public static PendingResult<Status> zza(Status status, GoogleApiClient googleApiClient) {
        zzx.zzb((Object) status, (Object) "Result must not be null");
        PendingResult com_google_android_gms_common_api_internal_zzz = new zzz(googleApiClient);
        com_google_android_gms_common_api_internal_zzz.zza((Result) status);
        return com_google_android_gms_common_api_internal_zzz;
    }

    public static <R extends Result> OptionalPendingResult<R> zzb(R r, GoogleApiClient googleApiClient) {
        zzx.zzb((Object) r, (Object) "Result must not be null");
        PendingResult com_google_android_gms_common_api_PendingResults_zzc = new zzc(googleApiClient);
        com_google_android_gms_common_api_PendingResults_zzc.zza((Result) r);
        return new zzs(com_google_android_gms_common_api_PendingResults_zzc);
    }
}

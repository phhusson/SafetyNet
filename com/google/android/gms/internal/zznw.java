package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zznw<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zznx> {

    static abstract class zza extends zznw<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    public zznw(GoogleApiClient googleApiClient) {
        super(zznt.zzVj, googleApiClient);
    }
}

package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzz extends zzb<Status> {
    @Deprecated
    public zzz(Looper looper) {
        super(looper);
    }

    public zzz(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    protected /* synthetic */ Result zzb(Status status) {
        return zzd(status);
    }

    protected Status zzd(Status status) {
        return status;
    }
}

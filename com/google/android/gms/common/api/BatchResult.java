package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final Status zzVy;
    private final PendingResult<?>[] zzaqm;

    BatchResult(Status status, PendingResult<?>[] pendingResults) {
        this.zzVy = status;
        this.zzaqm = pendingResults;
    }

    public Status getStatus() {
        return this.zzVy;
    }

    public <R extends Result> R take(BatchResultToken<R> resultToken) {
        zzx.zzb(resultToken.mId < this.zzaqm.length, (Object) "The result token does not belong to this batch");
        return this.zzaqm[resultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}

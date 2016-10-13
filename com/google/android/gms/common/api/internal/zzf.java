package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzf implements Releasable, Result {
    protected final Status zzVy;
    protected final DataHolder zzarr;

    protected zzf(DataHolder dataHolder, Status status) {
        this.zzVy = status;
        this.zzarr = dataHolder;
    }

    public Status getStatus() {
        return this.zzVy;
    }

    public void release() {
        if (this.zzarr != null) {
            this.zzarr.close();
        }
    }
}

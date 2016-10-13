package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zzr.zzb;
import com.google.android.gms.common.data.DataHolder;

public abstract class zze<L> implements zzb<L> {
    private final DataHolder zzarr;

    protected zze(DataHolder dataHolder) {
        this.zzarr = dataHolder;
    }

    protected abstract void zza(L l, DataHolder dataHolder);

    public void zzpF() {
        if (this.zzarr != null) {
            this.zzarr.close();
        }
    }

    public final void zzw(L l) {
        zza(l, this.zzarr);
    }
}

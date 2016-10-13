package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
    protected final DataHolder zzarr;

    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.zzarr = dataHolder;
        if (this.zzarr != null) {
            this.zzarr.zzx(this);
        }
    }

    @Deprecated
    public final void close() {
        release();
    }

    public abstract T get(int i);

    public int getCount() {
        return this.zzarr == null ? 0 : this.zzarr.getCount();
    }

    @Deprecated
    public boolean isClosed() {
        return this.zzarr == null || this.zzarr.isClosed();
    }

    public Iterator<T> iterator() {
        return new zzb(this);
    }

    public void release() {
        if (this.zzarr != null) {
            this.zzarr.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new zzf(this);
    }

    public Bundle zzqt() {
        return this.zzarr.zzqt();
    }
}

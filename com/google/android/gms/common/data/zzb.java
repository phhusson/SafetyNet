package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T> implements Iterator<T> {
    protected final DataBuffer<T> zzatE;
    protected int zzatF = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.zzatE = (DataBuffer) zzx.zzD(dataBuffer);
    }

    public boolean hasNext() {
        return this.zzatF < this.zzatE.getCount() + -1;
    }

    public T next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.zzatE;
            int i = this.zzatF + 1;
            this.zzatF = i;
            return dataBuffer.get(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzatF);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}

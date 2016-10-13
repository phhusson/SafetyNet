package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzf<T> extends zzb<T> {
    private T zzauc;

    public zzf(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (hasNext()) {
            this.zzatF++;
            if (this.zzatF == 0) {
                this.zzauc = this.zzatE.get(0);
                if (!(this.zzauc instanceof zzc)) {
                    throw new IllegalStateException("DataBuffer reference of type " + this.zzauc.getClass() + " is not movable");
                }
            }
            ((zzc) this.zzauc).zzcX(this.zzatF);
            return this.zzauc;
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzatF);
    }
}

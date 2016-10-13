package com.google.android.gms.people.model;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.people.internal.zzc;

public final class CircleBuffer extends DataBufferWithSyncInfo<Circle> {
    public CircleBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public Circle get(int position) {
        return new zzc(this.zzarr, position, zzqt());
    }

    public String toString() {
        return "Circles:size=" + getCount();
    }
}

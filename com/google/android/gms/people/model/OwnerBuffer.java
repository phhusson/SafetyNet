package com.google.android.gms.people.model;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.people.internal.zzj;

public final class OwnerBuffer extends AbstractDataBuffer<Owner> {
    public OwnerBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public Owner get(int position) {
        return new zzj(this.zzarr, position);
    }

    public String toString() {
        return "Owner:size=" + getCount();
    }
}

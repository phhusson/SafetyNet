package com.google.android.gms.people.model;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.people.internal.zzb;

public class AutocompleteBuffer extends DataBufferWithSyncInfo<AutocompleteEntry> {
    public AutocompleteBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public AutocompleteEntry get(int position) {
        return new zzb(this, this.zzarr, position, zzqt());
    }

    public String toString() {
        return "AutocompleteList:size=" + getCount();
    }

    public DataHolder zzuK() {
        return this.zzarr;
    }
}

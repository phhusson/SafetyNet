package com.google.android.gms.people.model;

import android.content.Context;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.people.internal.zzr;

public class PhoneNumberBuffer extends DataBufferWithSyncInfo<PhoneNumberEntry> {
    private final Context mContext;

    public PhoneNumberBuffer(DataHolder dataHolder, Context context) {
        super(dataHolder);
        this.mContext = context;
    }

    public PhoneNumberEntry get(int position) {
        return new zzr(this.zzarr, position, this.zzarr.zzqt(), this.mContext);
    }

    public String toString() {
        return "PhoneNumberBuffer:size=" + getCount();
    }
}

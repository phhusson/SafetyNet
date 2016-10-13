package com.google.android.gms.people.model;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.people.internal.agg.PhoneEmailDecoder.EmailDecoder;
import com.google.android.gms.people.internal.agg.PhoneEmailDecoder.PhoneDecoder;
import com.google.android.gms.people.internal.zzq;

public final class PersonBuffer extends DataBufferWithSyncInfo<Person> {
    private final PhoneDecoder zzbzT;
    private final EmailDecoder zzbzU;

    public PersonBuffer(DataHolder dataHolder, PhoneDecoder phoneDecoder, EmailDecoder emailDecoder) {
        super(dataHolder);
        this.zzbzT = phoneDecoder;
        this.zzbzU = emailDecoder;
    }

    public Person get(int position) {
        return new zzq(this.zzarr, position, zzqt(), this.zzbzT, this.zzbzU);
    }

    public String toString() {
        return "People:size=" + getCount();
    }
}

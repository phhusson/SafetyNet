package com.google.android.gms.people.exp;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;

public abstract class zza {
    private int mPos = -1;
    private final DataHolder zzarr;

    protected zza(DataHolder dataHolder) {
        zzx.zzD(dataHolder);
        this.zzarr = dataHolder;
    }

    public void close() {
        this.zzarr.close();
    }

    public double getDouble(String column) {
        return this.zzarr.getDouble(column, getPosition(), zzGf());
    }

    public int getInteger(String column) {
        return this.zzarr.getInteger(column, getPosition(), zzGf());
    }

    public long getLong(String column) {
        return this.zzarr.getLong(column, getPosition(), zzGf());
    }

    public int getPosition() {
        return this.mPos;
    }

    public String getString(String column) {
        return this.zzarr.getString(column, getPosition(), zzGf());
    }

    protected int zzGf() {
        return this.zzarr.zzcZ(this.mPos);
    }

    public Bundle zzqt() {
        return this.zzarr.zzqt();
    }
}

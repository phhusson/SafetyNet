package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public abstract class zzc {
    protected final DataHolder zzarr;
    protected int zzatH;
    private int zzatI;

    public zzc(DataHolder dataHolder, int i) {
        this.zzarr = (DataHolder) zzx.zzD(dataHolder);
        zzcX(i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc com_google_android_gms_common_data_zzc = (zzc) obj;
        return zzw.equal(Integer.valueOf(com_google_android_gms_common_data_zzc.zzatH), Integer.valueOf(this.zzatH)) && zzw.equal(Integer.valueOf(com_google_android_gms_common_data_zzc.zzatI), Integer.valueOf(this.zzatI)) && com_google_android_gms_common_data_zzc.zzarr == this.zzarr;
    }

    protected boolean getBoolean(String column) {
        return this.zzarr.getBoolean(column, this.zzatH, this.zzatI);
    }

    protected byte[] getByteArray(String column) {
        return this.zzarr.getByteArray(column, this.zzatH, this.zzatI);
    }

    protected double getDouble(String column) {
        return this.zzarr.getDouble(column, this.zzatH, this.zzatI);
    }

    protected float getFloat(String column) {
        return this.zzarr.getFloat(column, this.zzatH, this.zzatI);
    }

    protected int getInteger(String column) {
        return this.zzarr.getInteger(column, this.zzatH, this.zzatI);
    }

    protected long getLong(String column) {
        return this.zzarr.getLong(column, this.zzatH, this.zzatI);
    }

    protected String getString(String column) {
        return this.zzarr.getString(column, this.zzatH, this.zzatI);
    }

    public boolean hasColumn(String column) {
        return this.zzarr.hasColumn(column);
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzatH), Integer.valueOf(this.zzatI), this.zzarr);
    }

    public boolean isDataValid() {
        return !this.zzarr.isClosed();
    }

    protected void zza(String str, CharArrayBuffer charArrayBuffer) {
        this.zzarr.copyToBuffer(str, this.zzatH, this.zzatI, charArrayBuffer);
    }

    protected void zzcX(int i) {
        boolean z = i >= 0 && i < this.zzarr.getCount();
        zzx.zzad(z);
        this.zzatH = i;
        this.zzatI = this.zzarr.zzcZ(this.zzatH);
    }

    protected Uri zzcy(String str) {
        return this.zzarr.parseUri(str, this.zzatH, this.zzatI);
    }

    protected boolean zzcz(String str) {
        return this.zzarr.hasNull(str, this.zzatH, this.zzatI);
    }

    protected int zzqv() {
        return this.zzatH;
    }
}

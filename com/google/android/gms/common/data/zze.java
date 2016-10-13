package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zze<T> extends AbstractDataBuffer<T> {
    private boolean zzaua = false;
    private ArrayList<Integer> zzaub;

    protected zze(DataHolder dataHolder) {
        super(dataHolder);
    }

    private void zzqB() {
        synchronized (this) {
            if (!this.zzaua) {
                int count = this.zzarr.getCount();
                this.zzaub = new ArrayList();
                if (count > 0) {
                    this.zzaub.add(Integer.valueOf(0));
                    String zzqA = zzqA();
                    String string = this.zzarr.getString(zzqA, 0, this.zzarr.zzcZ(0));
                    int i = 1;
                    while (i < count) {
                        int zzcZ = this.zzarr.zzcZ(i);
                        String string2 = this.zzarr.getString(zzqA, i, zzcZ);
                        if (string2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + zzqA + ", at row: " + i + ", for window: " + zzcZ);
                        }
                        if (string2.equals(string)) {
                            string2 = string;
                        } else {
                            this.zzaub.add(Integer.valueOf(i));
                        }
                        i++;
                        string = string2;
                    }
                }
                this.zzaua = true;
            }
        }
    }

    public final T get(int position) {
        zzqB();
        return zzv(zzda(position), zzdb(position));
    }

    public int getCount() {
        zzqB();
        return this.zzaub.size();
    }

    int zzda(int i) {
        if (i >= 0 && i < this.zzaub.size()) {
            return ((Integer) this.zzaub.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    protected int zzdb(int i) {
        if (i < 0 || i == this.zzaub.size()) {
            return 0;
        }
        int count = i == this.zzaub.size() + -1 ? this.zzarr.getCount() - ((Integer) this.zzaub.get(i)).intValue() : ((Integer) this.zzaub.get(i + 1)).intValue() - ((Integer) this.zzaub.get(i)).intValue();
        if (count != 1) {
            return count;
        }
        int zzda = zzda(i);
        int zzcZ = this.zzarr.zzcZ(zzda);
        String zzqC = zzqC();
        return (zzqC == null || this.zzarr.getString(zzqC, zzda, zzcZ) != null) ? count : 0;
    }

    protected abstract String zzqA();

    protected String zzqC() {
        return null;
    }

    protected abstract T zzv(int i, int i2);
}

package com.google.android.gms.internal;

public final class zzaij implements Cloneable {
    private static final zzaik zzcqr = new zzaik();
    private int mSize;
    private boolean zzcqs;
    private int[] zzcqt;
    private zzaik[] zzcqu;

    zzaij() {
        this(10);
    }

    zzaij(int i) {
        this.zzcqs = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzcqt = new int[idealIntArraySize];
        this.zzcqu = new zzaik[idealIntArraySize];
        this.mSize = 0;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.zzcqt;
        zzaik[] com_google_android_gms_internal_zzaikArr = this.zzcqu;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzaik com_google_android_gms_internal_zzaik = com_google_android_gms_internal_zzaikArr[i3];
            if (com_google_android_gms_internal_zzaik != zzcqr) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    com_google_android_gms_internal_zzaikArr[i2] = com_google_android_gms_internal_zzaik;
                    com_google_android_gms_internal_zzaikArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzcqs = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    private int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzaik[] com_google_android_gms_internal_zzaikArr, zzaik[] com_google_android_gms_internal_zzaikArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!com_google_android_gms_internal_zzaikArr[i2].equals(com_google_android_gms_internal_zzaikArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zztp(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzcqt[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzRJ();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzaij)) {
            return false;
        }
        zzaij com_google_android_gms_internal_zzaij = (zzaij) o;
        if (size() != com_google_android_gms_internal_zzaij.size()) {
            return false;
        }
        return zza(this.zzcqt, com_google_android_gms_internal_zzaij.zzcqt, this.mSize) && zza(this.zzcqu, com_google_android_gms_internal_zzaij.zzcqu, this.mSize);
    }

    public int hashCode() {
        if (this.zzcqs) {
            gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzcqt[i2]) * 31) + this.zzcqu[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    int size() {
        if (this.zzcqs) {
            gc();
        }
        return this.mSize;
    }

    public final zzaij zzRJ() {
        int i = 0;
        int size = size();
        zzaij com_google_android_gms_internal_zzaij = new zzaij(size);
        System.arraycopy(this.zzcqt, 0, com_google_android_gms_internal_zzaij.zzcqt, 0, size);
        while (i < size) {
            if (this.zzcqu[i] != null) {
                com_google_android_gms_internal_zzaij.zzcqu[i] = this.zzcqu[i].zzRK();
            }
            i++;
        }
        com_google_android_gms_internal_zzaij.mSize = size;
        return com_google_android_gms_internal_zzaij;
    }

    void zza(int i, zzaik com_google_android_gms_internal_zzaik) {
        int zztp = zztp(i);
        if (zztp >= 0) {
            this.zzcqu[zztp] = com_google_android_gms_internal_zzaik;
            return;
        }
        zztp ^= -1;
        if (zztp >= this.mSize || this.zzcqu[zztp] != zzcqr) {
            if (this.zzcqs && this.mSize >= this.zzcqt.length) {
                gc();
                zztp = zztp(i) ^ -1;
            }
            if (this.mSize >= this.zzcqt.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                Object obj = new int[idealIntArraySize];
                Object obj2 = new zzaik[idealIntArraySize];
                System.arraycopy(this.zzcqt, 0, obj, 0, this.zzcqt.length);
                System.arraycopy(this.zzcqu, 0, obj2, 0, this.zzcqu.length);
                this.zzcqt = obj;
                this.zzcqu = obj2;
            }
            if (this.mSize - zztp != 0) {
                System.arraycopy(this.zzcqt, zztp, this.zzcqt, zztp + 1, this.mSize - zztp);
                System.arraycopy(this.zzcqu, zztp, this.zzcqu, zztp + 1, this.mSize - zztp);
            }
            this.zzcqt[zztp] = i;
            this.zzcqu[zztp] = com_google_android_gms_internal_zzaik;
            this.mSize++;
            return;
        }
        this.zzcqt[zztp] = i;
        this.zzcqu[zztp] = com_google_android_gms_internal_zzaik;
    }

    zzaik zztn(int i) {
        int zztp = zztp(i);
        return (zztp < 0 || this.zzcqu[zztp] == zzcqr) ? null : this.zzcqu[zztp];
    }

    zzaik zzto(int i) {
        if (this.zzcqs) {
            gc();
        }
        return this.zzcqu[i];
    }
}

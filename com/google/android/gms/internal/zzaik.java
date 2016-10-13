package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class zzaik implements Cloneable {
    private Object zzbIO;
    private zzaih<?, ?> zzcqv;
    private List<zzaip> zzcqw = new ArrayList();

    zzaik() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[computeSerializedSize()];
        writeTo(zzaif.zzW(bArr));
        return bArr;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzRK();
    }

    int computeSerializedSize() {
        if (this.zzbIO != null) {
            return this.zzcqv.zzan(this.zzbIO);
        }
        int i = 0;
        for (zzaip computeSerializedSize : this.zzcqw) {
            i = computeSerializedSize.computeSerializedSize() + i;
        }
        return i;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzaik)) {
            return false;
        }
        zzaik com_google_android_gms_internal_zzaik = (zzaik) o;
        if (this.zzbIO == null || com_google_android_gms_internal_zzaik.zzbIO == null) {
            if (this.zzcqw != null && com_google_android_gms_internal_zzaik.zzcqw != null) {
                return this.zzcqw.equals(com_google_android_gms_internal_zzaik.zzcqw);
            }
            try {
                return Arrays.equals(toByteArray(), com_google_android_gms_internal_zzaik.toByteArray());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzcqv != com_google_android_gms_internal_zzaik.zzcqv) {
            return false;
        } else {
            if (!this.zzcqv.zzcqp.isArray()) {
                return this.zzbIO.equals(com_google_android_gms_internal_zzaik.zzbIO);
            }
            if (this.zzbIO instanceof byte[]) {
                return Arrays.equals((byte[]) this.zzbIO, (byte[]) com_google_android_gms_internal_zzaik.zzbIO);
            }
            if (this.zzbIO instanceof int[]) {
                return Arrays.equals((int[]) this.zzbIO, (int[]) com_google_android_gms_internal_zzaik.zzbIO);
            }
            if (this.zzbIO instanceof long[]) {
                return Arrays.equals((long[]) this.zzbIO, (long[]) com_google_android_gms_internal_zzaik.zzbIO);
            }
            if (this.zzbIO instanceof float[]) {
                return Arrays.equals((float[]) this.zzbIO, (float[]) com_google_android_gms_internal_zzaik.zzbIO);
            }
            if (this.zzbIO instanceof double[]) {
                return Arrays.equals((double[]) this.zzbIO, (double[]) com_google_android_gms_internal_zzaik.zzbIO);
            }
            return this.zzbIO instanceof boolean[] ? Arrays.equals((boolean[]) this.zzbIO, (boolean[]) com_google_android_gms_internal_zzaik.zzbIO) : Arrays.deepEquals((Object[]) this.zzbIO, (Object[]) com_google_android_gms_internal_zzaik.zzbIO);
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    void writeTo(zzaif output) throws IOException {
        if (this.zzbIO != null) {
            this.zzcqv.zza(this.zzbIO, output);
            return;
        }
        for (zzaip writeTo : this.zzcqw) {
            writeTo.writeTo(output);
        }
    }

    public final zzaik zzRK() {
        int i = 0;
        zzaik com_google_android_gms_internal_zzaik = new zzaik();
        try {
            com_google_android_gms_internal_zzaik.zzcqv = this.zzcqv;
            if (this.zzcqw == null) {
                com_google_android_gms_internal_zzaik.zzcqw = null;
            } else {
                com_google_android_gms_internal_zzaik.zzcqw.addAll(this.zzcqw);
            }
            if (this.zzbIO != null) {
                if (this.zzbIO instanceof zzain) {
                    com_google_android_gms_internal_zzaik.zzbIO = ((zzain) this.zzbIO).clone();
                } else if (this.zzbIO instanceof byte[]) {
                    com_google_android_gms_internal_zzaik.zzbIO = ((byte[]) this.zzbIO).clone();
                } else if (this.zzbIO instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.zzbIO;
                    Object obj = new byte[bArr.length][];
                    com_google_android_gms_internal_zzaik.zzbIO = obj;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        obj[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.zzbIO instanceof boolean[]) {
                    com_google_android_gms_internal_zzaik.zzbIO = ((boolean[]) this.zzbIO).clone();
                } else if (this.zzbIO instanceof int[]) {
                    com_google_android_gms_internal_zzaik.zzbIO = ((int[]) this.zzbIO).clone();
                } else if (this.zzbIO instanceof long[]) {
                    com_google_android_gms_internal_zzaik.zzbIO = ((long[]) this.zzbIO).clone();
                } else if (this.zzbIO instanceof float[]) {
                    com_google_android_gms_internal_zzaik.zzbIO = ((float[]) this.zzbIO).clone();
                } else if (this.zzbIO instanceof double[]) {
                    com_google_android_gms_internal_zzaik.zzbIO = ((double[]) this.zzbIO).clone();
                } else if (this.zzbIO instanceof zzain[]) {
                    zzain[] com_google_android_gms_internal_zzainArr = (zzain[]) this.zzbIO;
                    Object obj2 = new zzain[com_google_android_gms_internal_zzainArr.length];
                    com_google_android_gms_internal_zzaik.zzbIO = obj2;
                    while (i < com_google_android_gms_internal_zzainArr.length) {
                        obj2[i] = com_google_android_gms_internal_zzainArr[i].clone();
                        i++;
                    }
                }
            }
            return com_google_android_gms_internal_zzaik;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    void zza(zzaip com_google_android_gms_internal_zzaip) {
        this.zzcqw.add(com_google_android_gms_internal_zzaip);
    }

    <T> T zzb(zzaih<?, T> com_google_android_gms_internal_zzaih___T) {
        if (this.zzbIO == null) {
            this.zzcqv = com_google_android_gms_internal_zzaih___T;
            this.zzbIO = com_google_android_gms_internal_zzaih___T.zzaa(this.zzcqw);
            this.zzcqw = null;
        } else if (this.zzcqv != com_google_android_gms_internal_zzaih___T) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return this.zzbIO;
    }

    zzaip zztq(int i) {
        return (this.zzcqw != null && i < this.zzcqw.size()) ? (zzaip) this.zzcqw.get(i) : null;
    }
}

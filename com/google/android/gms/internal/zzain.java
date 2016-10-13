package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract class zzain {
    protected volatile int zzcqy = -1;

    public static final <T extends zzain> T mergeFrom(T msg, byte[] data) throws zzaim {
        return mergeFrom(msg, data, 0, data.length);
    }

    public static final <T extends zzain> T mergeFrom(T msg, byte[] data, int off, int len) throws zzaim {
        try {
            zzaie zza = zzaie.zza(data, off, len);
            msg.mergeFrom(zza);
            zza.zzsV(0);
            return msg;
        } catch (zzaim e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final boolean messageNanoEquals(zzain a, zzain b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null || a.getClass() != b.getClass()) {
            return false;
        }
        int serializedSize = a.getSerializedSize();
        if (b.getSerializedSize() != serializedSize) {
            return false;
        }
        byte[] bArr = new byte[serializedSize];
        byte[] bArr2 = new byte[serializedSize];
        toByteArray(a, bArr, 0, serializedSize);
        toByteArray(b, bArr2, 0, serializedSize);
        return Arrays.equals(bArr, bArr2);
    }

    public static final void toByteArray(zzain msg, byte[] data, int offset, int length) {
        try {
            zzaif zzb = zzaif.zzb(data, offset, length);
            msg.writeTo(zzb);
            zzb.zzRH();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final byte[] toByteArray(zzain msg) {
        byte[] bArr = new byte[msg.getSerializedSize()];
        toByteArray(msg, bArr, 0, bArr.length);
        return bArr;
    }

    public zzain clone() throws CloneNotSupportedException {
        return (zzain) super.clone();
    }

    protected int computeSerializedSize() {
        return 0;
    }

    public int getCachedSize() {
        if (this.zzcqy < 0) {
            getSerializedSize();
        }
        return this.zzcqy;
    }

    public int getSerializedSize() {
        int computeSerializedSize = computeSerializedSize();
        this.zzcqy = computeSerializedSize;
        return computeSerializedSize;
    }

    public abstract zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException;

    public String toString() {
        return zzaio.zzf(this);
    }

    public void writeTo(zzaif output) throws IOException {
    }
}

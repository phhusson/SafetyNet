package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;

public final class zzaie {
    private final byte[] buffer;
    private int zzcqe;
    private int zzcqf;
    private int zzcqg;
    private int zzcqh;
    private int zzcqi;
    private int zzcqj = Integer.MAX_VALUE;
    private int zzcqk;
    private int zzcql = 64;
    private int zzcqm = 67108864;

    private zzaie(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzcqe = i;
        this.zzcqf = i + i2;
        this.zzcqh = i;
    }

    private void zzRC() {
        this.zzcqf += this.zzcqg;
        int i = this.zzcqf;
        if (i > this.zzcqj) {
            this.zzcqg = i - this.zzcqj;
            this.zzcqf -= this.zzcqg;
            return;
        }
        this.zzcqg = 0;
    }

    public static zzaie zzV(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static zzaie zza(byte[] bArr, int i, int i2) {
        return new zzaie(bArr, i, i2);
    }

    public static long zzaL(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static int zzsX(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public int getPosition() {
        return this.zzcqh - this.zzcqe;
    }

    public byte[] readBytes() throws IOException {
        int zzRy = zzRy();
        if (zzRy > this.zzcqf - this.zzcqh || zzRy <= 0) {
            return zzRy == 0 ? zzaiq.zzcqH : zztb(zzRy);
        } else {
            Object obj = new byte[zzRy];
            System.arraycopy(this.buffer, this.zzcqh, obj, 0, zzRy);
            this.zzcqh = zzRy + this.zzcqh;
            return obj;
        }
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(zzRB());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(zzRA());
    }

    public String readString() throws IOException {
        int zzRy = zzRy();
        if (zzRy > this.zzcqf - this.zzcqh || zzRy <= 0) {
            return new String(zztb(zzRy), "UTF-8");
        }
        String str = new String(this.buffer, this.zzcqh, zzRy, "UTF-8");
        this.zzcqh = zzRy + this.zzcqh;
        return str;
    }

    public byte[] zzQ(int i, int i2) {
        if (i2 == 0) {
            return zzaiq.zzcqH;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.buffer, this.zzcqe + i, obj, 0, i2);
        return obj;
    }

    public int zzRA() throws IOException {
        return (((zzRF() & 255) | ((zzRF() & 255) << 8)) | ((zzRF() & 255) << 16)) | ((zzRF() & 255) << 24);
    }

    public long zzRB() throws IOException {
        byte zzRF = zzRF();
        byte zzRF2 = zzRF();
        return ((((((((((long) zzRF2) & 255) << 8) | (((long) zzRF) & 255)) | ((((long) zzRF()) & 255) << 16)) | ((((long) zzRF()) & 255) << 24)) | ((((long) zzRF()) & 255) << 32)) | ((((long) zzRF()) & 255) << 40)) | ((((long) zzRF()) & 255) << 48)) | ((((long) zzRF()) & 255) << 56);
    }

    public int zzRD() {
        if (this.zzcqj == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzcqj - this.zzcqh;
    }

    public boolean zzRE() {
        return this.zzcqh == this.zzcqf;
    }

    public byte zzRF() throws IOException {
        if (this.zzcqh == this.zzcqf) {
            throw zzaim.zzRL();
        }
        byte[] bArr = this.buffer;
        int i = this.zzcqh;
        this.zzcqh = i + 1;
        return bArr[i];
    }

    public int zzRp() throws IOException {
        if (zzRE()) {
            this.zzcqi = 0;
            return 0;
        }
        this.zzcqi = zzRy();
        if (this.zzcqi != 0) {
            return this.zzcqi;
        }
        throw zzaim.zzRO();
    }

    public void zzRq() throws IOException {
        int zzRp;
        do {
            zzRp = zzRp();
            if (zzRp == 0) {
                return;
            }
        } while (zzsW(zzRp));
    }

    public long zzRr() throws IOException {
        return zzRz();
    }

    public long zzRs() throws IOException {
        return zzRz();
    }

    public int zzRt() throws IOException {
        return zzRy();
    }

    public long zzRu() throws IOException {
        return zzRB();
    }

    public boolean zzRv() throws IOException {
        return zzRy() != 0;
    }

    public int zzRw() throws IOException {
        return zzsX(zzRy());
    }

    public long zzRx() throws IOException {
        return zzaL(zzRz());
    }

    public int zzRy() throws IOException {
        byte zzRF = zzRF();
        if (zzRF >= (byte) 0) {
            return zzRF;
        }
        int i = zzRF & TransportMediator.KEYCODE_MEDIA_PAUSE;
        byte zzRF2 = zzRF();
        if (zzRF2 >= (byte) 0) {
            return i | (zzRF2 << 7);
        }
        i |= (zzRF2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 7;
        zzRF2 = zzRF();
        if (zzRF2 >= (byte) 0) {
            return i | (zzRF2 << 14);
        }
        i |= (zzRF2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 14;
        zzRF2 = zzRF();
        if (zzRF2 >= (byte) 0) {
            return i | (zzRF2 << 21);
        }
        i |= (zzRF2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 21;
        zzRF2 = zzRF();
        i |= zzRF2 << 28;
        if (zzRF2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (zzRF() >= (byte) 0) {
                return i;
            }
        }
        throw zzaim.zzRN();
    }

    public long zzRz() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzRF = zzRF();
            j |= ((long) (zzRF & TransportMediator.KEYCODE_MEDIA_PAUSE)) << i;
            if ((zzRF & 128) == 0) {
                return j;
            }
        }
        throw zzaim.zzRN();
    }

    public void zza(zzain com_google_android_gms_internal_zzain) throws IOException {
        int zzRy = zzRy();
        if (this.zzcqk >= this.zzcql) {
            throw zzaim.zzRR();
        }
        zzRy = zzsY(zzRy);
        this.zzcqk++;
        com_google_android_gms_internal_zzain.mergeFrom(this);
        zzsV(0);
        this.zzcqk--;
        zzsZ(zzRy);
    }

    public void zza(zzain com_google_android_gms_internal_zzain, int i) throws IOException {
        if (this.zzcqk >= this.zzcql) {
            throw zzaim.zzRR();
        }
        this.zzcqk++;
        com_google_android_gms_internal_zzain.mergeFrom(this);
        zzsV(zzaiq.zzW(i, 4));
        this.zzcqk--;
    }

    public void zzsV(int i) throws zzaim {
        if (this.zzcqi != i) {
            throw zzaim.zzRP();
        }
    }

    public boolean zzsW(int i) throws IOException {
        switch (zzaiq.zztr(i)) {
            case 0:
                zzRt();
                return true;
            case 1:
                zzRB();
                return true;
            case 2:
                zztc(zzRy());
                return true;
            case 3:
                zzRq();
                zzsV(zzaiq.zzW(zzaiq.zzts(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                zzRA();
                return true;
            default:
                throw zzaim.zzRQ();
        }
    }

    public int zzsY(int i) throws zzaim {
        if (i < 0) {
            throw zzaim.zzRM();
        }
        int i2 = this.zzcqh + i;
        int i3 = this.zzcqj;
        if (i2 > i3) {
            throw zzaim.zzRL();
        }
        this.zzcqj = i2;
        zzRC();
        return i3;
    }

    public void zzsZ(int i) {
        this.zzcqj = i;
        zzRC();
    }

    public void zzta(int i) {
        if (i > this.zzcqh - this.zzcqe) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzcqh - this.zzcqe));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.zzcqh = this.zzcqe + i;
        }
    }

    public byte[] zztb(int i) throws IOException {
        if (i < 0) {
            throw zzaim.zzRM();
        } else if (this.zzcqh + i > this.zzcqj) {
            zztc(this.zzcqj - this.zzcqh);
            throw zzaim.zzRL();
        } else if (i <= this.zzcqf - this.zzcqh) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.zzcqh, obj, 0, i);
            this.zzcqh += i;
            return obj;
        } else {
            throw zzaim.zzRL();
        }
    }

    public void zztc(int i) throws IOException {
        if (i < 0) {
            throw zzaim.zzRM();
        } else if (this.zzcqh + i > this.zzcqj) {
            zztc(this.zzcqj - this.zzcqh);
            throw zzaim.zzRL();
        } else if (i <= this.zzcqf - this.zzcqh) {
            this.zzcqh += i;
        } else {
            throw zzaim.zzRL();
        }
    }
}

package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzaif {
    private final ByteBuffer zzcqn;

    public static class zza extends IOException {
        zza(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private zzaif(ByteBuffer byteBuffer) {
        this.zzcqn = byteBuffer;
        this.zzcqn.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzaif(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int zzT(int i, int i2) {
        return zzti(i) + zztf(i2);
    }

    public static int zzU(int i, int i2) {
        return zzti(i) + zztg(i2);
    }

    public static zzaif zzW(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static int zzY(byte[] bArr) {
        return zztk(bArr.length) + bArr.length;
    }

    private static int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 'ࠀ') {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if ('?' <= charAt && charAt <= '?') {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < '?' || '?' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else if ('?' > charAt2 || charAt2 > '?' || (i3 + 1 != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3 + 1)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            } else {
                throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            zzb(charSequence, byteBuffer);
        }
    }

    public static int zzaQ(long j) {
        return zzaV(j);
    }

    public static int zzaR(long j) {
        return zzaV(j);
    }

    public static int zzaS(long j) {
        return 8;
    }

    public static int zzaT(long j) {
        return zzaV(zzaX(j));
    }

    public static int zzaV(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long zzaX(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzb(int i, double d) {
        return zzti(i) + zzp(d);
    }

    public static int zzb(int i, zzain com_google_android_gms_internal_zzain) {
        return (zzti(i) * 2) + zzd(com_google_android_gms_internal_zzain);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzti(i) + zzY(bArr);
    }

    public static zzaif zzb(byte[] bArr, int i, int i2) {
        return new zzaif(bArr, i, i2);
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else if (charAt < '?' || '?' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int zzbh(boolean z) {
        return 1;
    }

    public static int zzc(int i, float f) {
        return zzti(i) + zzj(f);
    }

    public static int zzc(int i, zzain com_google_android_gms_internal_zzain) {
        return zzti(i) + zze(com_google_android_gms_internal_zzain);
    }

    public static int zzd(zzain com_google_android_gms_internal_zzain) {
        return com_google_android_gms_internal_zzain.getSerializedSize();
    }

    private static int zzd(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < '') {
            i++;
        }
        int i2 = i;
        i = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= 'ࠀ') {
                i += zza(charSequence, i2);
                break;
            }
            i2++;
            i = ((127 - charAt) >>> 31) + i;
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    public static int zze(zzain com_google_android_gms_internal_zzain) {
        int serializedSize = com_google_android_gms_internal_zzain.getSerializedSize();
        return serializedSize + zztk(serializedSize);
    }

    public static int zzi(int i, boolean z) {
        return zzti(i) + zzbh(z);
    }

    public static int zzj(float f) {
        return 4;
    }

    public static int zzj(int i, long j) {
        return zzti(i) + zzaR(j);
    }

    public static int zzk(int i, long j) {
        return zzti(i) + zzaS(j);
    }

    public static int zzkm(String str) {
        int zzd = zzd((CharSequence) str);
        return zzd + zztk(zzd);
    }

    public static int zzl(int i, long j) {
        return zzti(i) + zzaT(j);
    }

    public static int zzp(double d) {
        return 8;
    }

    public static int zzp(int i, String str) {
        return zzti(i) + zzkm(str);
    }

    public static int zztf(int i) {
        return i >= 0 ? zztk(i) : 10;
    }

    public static int zztg(int i) {
        return zztk(zztm(i));
    }

    public static int zzti(int i) {
        return zztk(zzaiq.zzW(i, 0));
    }

    public static int zztk(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int zztm(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public void zzR(int i, int i2) throws IOException {
        zzV(i, 0);
        zztd(i2);
    }

    public int zzRG() {
        return this.zzcqn.remaining();
    }

    public void zzRH() {
        if (zzRG() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zzS(int i, int i2) throws IOException {
        zzV(i, 0);
        zzte(i2);
    }

    public void zzV(int i, int i2) throws IOException {
        zztj(zzaiq.zzW(i, i2));
    }

    public void zzX(byte[] bArr) throws IOException {
        zztj(bArr.length);
        zzZ(bArr);
    }

    public void zzZ(byte[] bArr) throws IOException {
        zzc(bArr, 0, bArr.length);
    }

    public void zza(int i, double d) throws IOException {
        zzV(i, 1);
        zzo(d);
    }

    public void zza(int i, zzain com_google_android_gms_internal_zzain) throws IOException {
        zzV(i, 2);
        zzc(com_google_android_gms_internal_zzain);
    }

    public void zza(int i, byte[] bArr) throws IOException {
        zzV(i, 2);
        zzX(bArr);
    }

    public void zzaM(long j) throws IOException {
        zzaU(j);
    }

    public void zzaN(long j) throws IOException {
        zzaU(j);
    }

    public void zzaO(long j) throws IOException {
        zzaW(j);
    }

    public void zzaP(long j) throws IOException {
        zzaU(zzaX(j));
    }

    public void zzaU(long j) throws IOException {
        while ((-128 & j) != 0) {
            zzth((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        zzth((int) j);
    }

    public void zzaW(long j) throws IOException {
        if (this.zzcqn.remaining() < 8) {
            throw new zza(this.zzcqn.position(), this.zzcqn.limit());
        }
        this.zzcqn.putLong(j);
    }

    public void zzb(int i, float f) throws IOException {
        zzV(i, 5);
        zzi(f);
    }

    public void zzb(zzain com_google_android_gms_internal_zzain) throws IOException {
        com_google_android_gms_internal_zzain.writeTo(this);
    }

    public void zzbg(boolean z) throws IOException {
        zzth(z ? 1 : 0);
    }

    public void zzc(byte b) throws IOException {
        if (this.zzcqn.hasRemaining()) {
            this.zzcqn.put(b);
            return;
        }
        throw new zza(this.zzcqn.position(), this.zzcqn.limit());
    }

    public void zzc(zzain com_google_android_gms_internal_zzain) throws IOException {
        zztj(com_google_android_gms_internal_zzain.getCachedSize());
        com_google_android_gms_internal_zzain.writeTo(this);
    }

    public void zzc(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzcqn.remaining() >= i2) {
            this.zzcqn.put(bArr, i, i2);
            return;
        }
        throw new zza(this.zzcqn.position(), this.zzcqn.limit());
    }

    public void zzf(int i, long j) throws IOException {
        zzV(i, 0);
        zzaM(j);
    }

    public void zzg(int i, long j) throws IOException {
        zzV(i, 0);
        zzaN(j);
    }

    public void zzh(int i, long j) throws IOException {
        zzV(i, 1);
        zzaO(j);
    }

    public void zzh(int i, boolean z) throws IOException {
        zzV(i, 0);
        zzbg(z);
    }

    public void zzi(float f) throws IOException {
        zztl(Float.floatToIntBits(f));
    }

    public void zzi(int i, long j) throws IOException {
        zzV(i, 0);
        zzaP(j);
    }

    public void zzkl(String str) throws IOException {
        try {
            int zztk = zztk(str.length());
            if (zztk == zztk(str.length() * 3)) {
                int position = this.zzcqn.position();
                if (this.zzcqn.remaining() < zztk) {
                    throw new zza(zztk + position, this.zzcqn.limit());
                }
                this.zzcqn.position(position + zztk);
                zza((CharSequence) str, this.zzcqn);
                int position2 = this.zzcqn.position();
                this.zzcqn.position(position);
                zztj((position2 - position) - zztk);
                this.zzcqn.position(position2);
                return;
            }
            zztj(zzd((CharSequence) str));
            zza((CharSequence) str, this.zzcqn);
        } catch (Throwable e) {
            zza com_google_android_gms_internal_zzaif_zza = new zza(this.zzcqn.position(), this.zzcqn.limit());
            com_google_android_gms_internal_zzaif_zza.initCause(e);
            throw com_google_android_gms_internal_zzaif_zza;
        }
    }

    public void zzo(double d) throws IOException {
        zzaW(Double.doubleToLongBits(d));
    }

    public void zzo(int i, String str) throws IOException {
        zzV(i, 2);
        zzkl(str);
    }

    public void zztd(int i) throws IOException {
        if (i >= 0) {
            zztj(i);
        } else {
            zzaU((long) i);
        }
    }

    public void zzte(int i) throws IOException {
        zztj(zztm(i));
    }

    public void zzth(int i) throws IOException {
        zzc((byte) i);
    }

    public void zztj(int i) throws IOException {
        while ((i & -128) != 0) {
            zzth((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        zzth(i);
    }

    public void zztl(int i) throws IOException {
        if (this.zzcqn.remaining() < 4) {
            throw new zza(this.zzcqn.position(), this.zzcqn.limit());
        }
        this.zzcqn.putInt(i);
    }
}

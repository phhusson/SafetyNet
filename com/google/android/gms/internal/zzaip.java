package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzaip {
    final int tag;
    final byte[] zzcqz;

    zzaip(int i, byte[] bArr) {
        this.tag = i;
        this.zzcqz = bArr;
    }

    int computeSerializedSize() {
        return (0 + zzaif.zztk(this.tag)) + this.zzcqz.length;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzaip)) {
            return false;
        }
        zzaip com_google_android_gms_internal_zzaip = (zzaip) o;
        return this.tag == com_google_android_gms_internal_zzaip.tag && Arrays.equals(this.zzcqz, com_google_android_gms_internal_zzaip.zzcqz);
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzcqz);
    }

    void writeTo(zzaif output) throws IOException {
        output.zztj(this.tag);
        output.zzZ(this.zzcqz);
    }
}

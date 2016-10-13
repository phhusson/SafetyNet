package com.google.android.gms.internal;

import java.io.IOException;

public final class zzlx extends zzain {
    public zzly zzacV;

    public zzlx() {
        zzlo();
    }

    public static zzlx zzh(byte[] bArr) throws zzaim {
        return (zzlx) zzain.mergeFrom(new zzlx(), bArr);
    }

    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return this.zzacV != null ? computeSerializedSize + zzaif.zzc(1, this.zzacV) : computeSerializedSize;
    }

    public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        return zzn(com_google_android_gms_internal_zzaie);
    }

    public void writeTo(zzaif output) throws IOException {
        if (this.zzacV != null) {
            output.zza(1, this.zzacV);
        }
        super.writeTo(output);
    }

    public zzlx zzlo() {
        this.zzacV = null;
        this.zzcqy = -1;
        return this;
    }

    public zzlx zzn(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        while (true) {
            int zzRp = com_google_android_gms_internal_zzaie.zzRp();
            switch (zzRp) {
                case 0:
                    break;
                case 10:
                    if (this.zzacV == null) {
                        this.zzacV = new zzly();
                    }
                    com_google_android_gms_internal_zzaie.zza(this.zzacV);
                    continue;
                default:
                    if (!zzaiq.zzb(com_google_android_gms_internal_zzaie, zzRp)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}

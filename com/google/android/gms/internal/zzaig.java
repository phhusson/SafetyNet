package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzaig<M extends zzaig<M>> extends zzain {
    protected zzaij zzcqo;

    public /* synthetic */ zzain clone() throws CloneNotSupportedException {
        return zzRI();
    }

    public /* synthetic */ Object m15clone() throws CloneNotSupportedException {
        return zzRI();
    }

    protected int computeSerializedSize() {
        int i = 0;
        if (this.zzcqo == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.zzcqo.size()) {
            i2 += this.zzcqo.zzto(i).computeSerializedSize();
            i++;
        }
        return i2;
    }

    public void writeTo(zzaif output) throws IOException {
        if (this.zzcqo != null) {
            for (int i = 0; i < this.zzcqo.size(); i++) {
                this.zzcqo.zzto(i).writeTo(output);
            }
        }
    }

    public M zzRI() throws CloneNotSupportedException {
        zzaig com_google_android_gms_internal_zzaig = (zzaig) super.clone();
        zzail.zza(this, com_google_android_gms_internal_zzaig);
        return com_google_android_gms_internal_zzaig;
    }

    public final <T> T zza(zzaih<M, T> com_google_android_gms_internal_zzaih_M__T) {
        if (this.zzcqo == null) {
            return null;
        }
        zzaik zztn = this.zzcqo.zztn(zzaiq.zzts(com_google_android_gms_internal_zzaih_M__T.tag));
        return zztn != null ? zztn.zzb(com_google_android_gms_internal_zzaih_M__T) : null;
    }

    protected final boolean zza(zzaie com_google_android_gms_internal_zzaie, int i) throws IOException {
        int position = com_google_android_gms_internal_zzaie.getPosition();
        if (!com_google_android_gms_internal_zzaie.zzsW(i)) {
            return false;
        }
        int zzts = zzaiq.zzts(i);
        zzaip com_google_android_gms_internal_zzaip = new zzaip(i, com_google_android_gms_internal_zzaie.zzQ(position, com_google_android_gms_internal_zzaie.getPosition() - position));
        zzaik com_google_android_gms_internal_zzaik = null;
        if (this.zzcqo == null) {
            this.zzcqo = new zzaij();
        } else {
            com_google_android_gms_internal_zzaik = this.zzcqo.zztn(zzts);
        }
        if (com_google_android_gms_internal_zzaik == null) {
            com_google_android_gms_internal_zzaik = new zzaik();
            this.zzcqo.zza(zzts, com_google_android_gms_internal_zzaik);
        }
        com_google_android_gms_internal_zzaik.zza(com_google_android_gms_internal_zzaip);
        return true;
    }
}

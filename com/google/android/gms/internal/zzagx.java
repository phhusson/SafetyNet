package com.google.android.gms.internal;

import java.io.IOException;

public final class zzagx extends zzaig<zzagx> {
    public String zzcgM;

    public zzagx() {
        zzPR();
    }

    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.zzcgM.equals("") ? computeSerializedSize + zzaif.zzp(1, this.zzcgM) : computeSerializedSize;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzagx)) {
            return false;
        }
        zzagx com_google_android_gms_internal_zzagx = (zzagx) o;
        if (this.zzcgM == null) {
            if (com_google_android_gms_internal_zzagx.zzcgM != null) {
                return false;
            }
        } else if (!this.zzcgM.equals(com_google_android_gms_internal_zzagx.zzcgM)) {
            return false;
        }
        if (this.zzcqo == null || this.zzcqo.isEmpty()) {
            return com_google_android_gms_internal_zzagx.zzcqo == null || com_google_android_gms_internal_zzagx.zzcqo.isEmpty();
        } else {
            return this.zzcqo.equals(com_google_android_gms_internal_zzagx.zzcqo);
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.zzcgM == null ? 0 : this.zzcgM.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
        if (!(this.zzcqo == null || this.zzcqo.isEmpty())) {
            i = this.zzcqo.hashCode();
        }
        return hashCode + i;
    }

    public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        return zzap(com_google_android_gms_internal_zzaie);
    }

    public void writeTo(zzaif output) throws IOException {
        if (!this.zzcgM.equals("")) {
            output.zzo(1, this.zzcgM);
        }
        super.writeTo(output);
    }

    public zzagx zzPR() {
        this.zzcgM = "";
        this.zzcqo = null;
        this.zzcqy = -1;
        return this;
    }

    public zzagx zzap(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        while (true) {
            int zzRp = com_google_android_gms_internal_zzaie.zzRp();
            switch (zzRp) {
                case 0:
                    break;
                case 10:
                    this.zzcgM = com_google_android_gms_internal_zzaie.readString();
                    continue;
                default:
                    if (!zza(com_google_android_gms_internal_zzaie, zzRp)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}

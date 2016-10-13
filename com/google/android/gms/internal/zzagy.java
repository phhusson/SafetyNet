package com.google.android.gms.internal;

import java.io.IOException;

public final class zzagy extends zzaig<zzagy> {
    private static volatile zzagy[] zzcgN;
    public int status;
    public int zzcgO;
    public int zzcgP;
    public zza zzcgQ;

    public static final class zza extends zzaig<zza> {
        public boolean zzcgR;
        public boolean zzcgS;
        public boolean zzcgT;

        public zza() {
            zzPU();
        }

        protected int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.zzcgR) {
                computeSerializedSize += zzaif.zzi(1, this.zzcgR);
            }
            if (this.zzcgS) {
                computeSerializedSize += zzaif.zzi(2, this.zzcgS);
            }
            return this.zzcgT ? computeSerializedSize + zzaif.zzi(3, this.zzcgT) : computeSerializedSize;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzagy_zza = (zza) o;
            if (this.zzcgR != com_google_android_gms_internal_zzagy_zza.zzcgR || this.zzcgS != com_google_android_gms_internal_zzagy_zza.zzcgS || this.zzcgT != com_google_android_gms_internal_zzagy_zza.zzcgT) {
                return false;
            }
            if (this.zzcqo == null || this.zzcqo.isEmpty()) {
                return com_google_android_gms_internal_zzagy_zza.zzcqo == null || com_google_android_gms_internal_zzagy_zza.zzcqo.isEmpty();
            } else {
                return this.zzcqo.equals(com_google_android_gms_internal_zzagy_zza.zzcqo);
            }
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zzcgS ? 1231 : 1237) + (((this.zzcgR ? 1231 : 1237) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!this.zzcgT) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            hashCode = (this.zzcqo == null || this.zzcqo.isEmpty()) ? 0 : this.zzcqo.hashCode();
            return hashCode + i;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzar(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            if (this.zzcgR) {
                output.zzh(1, this.zzcgR);
            }
            if (this.zzcgS) {
                output.zzh(2, this.zzcgS);
            }
            if (this.zzcgT) {
                output.zzh(3, this.zzcgT);
            }
            super.writeTo(output);
        }

        public zza zzPU() {
            this.zzcgR = false;
            this.zzcgS = false;
            this.zzcgT = false;
            this.zzcqo = null;
            this.zzcqy = -1;
            return this;
        }

        public zza zzar(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            while (true) {
                int zzRp = com_google_android_gms_internal_zzaie.zzRp();
                switch (zzRp) {
                    case 0:
                        break;
                    case 8:
                        this.zzcgR = com_google_android_gms_internal_zzaie.zzRv();
                        continue;
                    case 16:
                        this.zzcgS = com_google_android_gms_internal_zzaie.zzRv();
                        continue;
                    case 24:
                        this.zzcgT = com_google_android_gms_internal_zzaie.zzRv();
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

    public zzagy() {
        zzPT();
    }

    public static zzagy[] zzPS() {
        if (zzcgN == null) {
            synchronized (zzail.zzcqx) {
                if (zzcgN == null) {
                    zzcgN = new zzagy[0];
                }
            }
        }
        return zzcgN;
    }

    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (this.zzcgO != 0) {
            computeSerializedSize += zzaif.zzT(1, this.zzcgO);
        }
        if (this.status != 0) {
            computeSerializedSize += zzaif.zzT(2, this.status);
        }
        if (this.zzcgP != 0) {
            computeSerializedSize += zzaif.zzT(3, this.zzcgP);
        }
        return this.zzcgQ != null ? computeSerializedSize + zzaif.zzc(4, this.zzcgQ) : computeSerializedSize;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzagy)) {
            return false;
        }
        zzagy com_google_android_gms_internal_zzagy = (zzagy) o;
        if (this.zzcgO != com_google_android_gms_internal_zzagy.zzcgO || this.status != com_google_android_gms_internal_zzagy.status || this.zzcgP != com_google_android_gms_internal_zzagy.zzcgP) {
            return false;
        }
        if (this.zzcgQ == null) {
            if (com_google_android_gms_internal_zzagy.zzcgQ != null) {
                return false;
            }
        } else if (!this.zzcgQ.equals(com_google_android_gms_internal_zzagy.zzcgQ)) {
            return false;
        }
        if (this.zzcqo == null || this.zzcqo.isEmpty()) {
            return com_google_android_gms_internal_zzagy.zzcqo == null || com_google_android_gms_internal_zzagy.zzcqo.isEmpty();
        } else {
            return this.zzcqo.equals(com_google_android_gms_internal_zzagy.zzcqo);
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.zzcgQ == null ? 0 : this.zzcgQ.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + this.zzcgO) * 31) + this.status) * 31) + this.zzcgP) * 31)) * 31;
        if (!(this.zzcqo == null || this.zzcqo.isEmpty())) {
            i = this.zzcqo.hashCode();
        }
        return hashCode + i;
    }

    public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        return zzaq(com_google_android_gms_internal_zzaie);
    }

    public void writeTo(zzaif output) throws IOException {
        if (this.zzcgO != 0) {
            output.zzR(1, this.zzcgO);
        }
        if (this.status != 0) {
            output.zzR(2, this.status);
        }
        if (this.zzcgP != 0) {
            output.zzR(3, this.zzcgP);
        }
        if (this.zzcgQ != null) {
            output.zza(4, this.zzcgQ);
        }
        super.writeTo(output);
    }

    public zzagy zzPT() {
        this.zzcgO = 0;
        this.status = 0;
        this.zzcgP = 0;
        this.zzcgQ = null;
        this.zzcqo = null;
        this.zzcqy = -1;
        return this;
    }

    public zzagy zzaq(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        while (true) {
            int zzRp = com_google_android_gms_internal_zzaie.zzRp();
            switch (zzRp) {
                case 0:
                    break;
                case 8:
                    this.zzcgO = com_google_android_gms_internal_zzaie.zzRt();
                    continue;
                case 16:
                    zzRp = com_google_android_gms_internal_zzaie.zzRt();
                    switch (zzRp) {
                        case 0:
                        case 1:
                        case 2:
                            this.status = zzRp;
                            break;
                        default:
                            continue;
                    }
                case 24:
                    zzRp = com_google_android_gms_internal_zzaie.zzRt();
                    switch (zzRp) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            this.zzcgP = zzRp;
                            break;
                        default:
                            continue;
                    }
                case 34:
                    if (this.zzcgQ == null) {
                        this.zzcgQ = new zza();
                    }
                    com_google_android_gms_internal_zzaie.zza(this.zzcgQ);
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

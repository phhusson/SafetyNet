package com.google.android.gms.internal;

import com.google.android.gms.playlog.PlayLogger.LogSource;
import java.io.IOException;

public final class zzly extends zzain {
    public Integer zzacW;
    public zzlw[] zzacX;
    public zzlv[] zzacY;
    public zza[] zzacZ;

    public static final class zza extends zzain {
        private static volatile zza[] zzada;
        public String url;
        public String zzacM;
        public Integer zzacW;

        public zza() {
            zzlr();
        }

        public static zza[] zzlq() {
            if (zzada == null) {
                synchronized (zzail.zzcqx) {
                    if (zzada == null) {
                        zzada = new zza[0];
                    }
                }
            }
            return zzada;
        }

        protected int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.zzacM != null) {
                computeSerializedSize += zzaif.zzp(1, this.zzacM);
            }
            if (this.zzacW != null) {
                computeSerializedSize += zzaif.zzT(2, this.zzacW.intValue());
            }
            return this.url != null ? computeSerializedSize + zzaif.zzp(3, this.url) : computeSerializedSize;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzp(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            if (this.zzacM != null) {
                output.zzo(1, this.zzacM);
            }
            if (this.zzacW != null) {
                output.zzR(2, this.zzacW.intValue());
            }
            if (this.url != null) {
                output.zzo(3, this.url);
            }
            super.writeTo(output);
        }

        public zza zzlr() {
            this.zzacM = null;
            this.zzacW = null;
            this.url = null;
            this.zzcqy = -1;
            return this;
        }

        public zza zzp(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            while (true) {
                int zzRp = com_google_android_gms_internal_zzaie.zzRp();
                switch (zzRp) {
                    case 0:
                        break;
                    case 10:
                        this.zzacM = com_google_android_gms_internal_zzaie.readString();
                        continue;
                    case 16:
                        zzRp = com_google_android_gms_internal_zzaie.zzRt();
                        switch (zzRp) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                this.zzacW = Integer.valueOf(zzRp);
                                break;
                            default:
                                continue;
                        }
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.url = com_google_android_gms_internal_zzaie.readString();
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

    public zzly() {
        zzlp();
    }

    protected int computeSerializedSize() {
        int i;
        int i2 = 0;
        int computeSerializedSize = super.computeSerializedSize();
        if (this.zzacW != null) {
            computeSerializedSize += zzaif.zzT(1, this.zzacW.intValue());
        }
        if (this.zzacX != null && this.zzacX.length > 0) {
            i = computeSerializedSize;
            for (zzain com_google_android_gms_internal_zzain : this.zzacX) {
                if (com_google_android_gms_internal_zzain != null) {
                    i += zzaif.zzc(2, com_google_android_gms_internal_zzain);
                }
            }
            computeSerializedSize = i;
        }
        if (this.zzacY != null && this.zzacY.length > 0) {
            i = computeSerializedSize;
            for (zzain com_google_android_gms_internal_zzain2 : this.zzacY) {
                if (com_google_android_gms_internal_zzain2 != null) {
                    i += zzaif.zzc(3, com_google_android_gms_internal_zzain2);
                }
            }
            computeSerializedSize = i;
        }
        if (this.zzacZ != null && this.zzacZ.length > 0) {
            while (i2 < this.zzacZ.length) {
                zzain com_google_android_gms_internal_zzain3 = this.zzacZ[i2];
                if (com_google_android_gms_internal_zzain3 != null) {
                    computeSerializedSize += zzaif.zzc(4, com_google_android_gms_internal_zzain3);
                }
                i2++;
            }
        }
        return computeSerializedSize;
    }

    public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        return zzo(com_google_android_gms_internal_zzaie);
    }

    public void writeTo(zzaif output) throws IOException {
        int i = 0;
        if (this.zzacW != null) {
            output.zzR(1, this.zzacW.intValue());
        }
        if (this.zzacX != null && this.zzacX.length > 0) {
            for (zzain com_google_android_gms_internal_zzain : this.zzacX) {
                if (com_google_android_gms_internal_zzain != null) {
                    output.zza(2, com_google_android_gms_internal_zzain);
                }
            }
        }
        if (this.zzacY != null && this.zzacY.length > 0) {
            for (zzain com_google_android_gms_internal_zzain2 : this.zzacY) {
                if (com_google_android_gms_internal_zzain2 != null) {
                    output.zza(3, com_google_android_gms_internal_zzain2);
                }
            }
        }
        if (this.zzacZ != null && this.zzacZ.length > 0) {
            while (i < this.zzacZ.length) {
                zzain com_google_android_gms_internal_zzain3 = this.zzacZ[i];
                if (com_google_android_gms_internal_zzain3 != null) {
                    output.zza(4, com_google_android_gms_internal_zzain3);
                }
                i++;
            }
        }
        super.writeTo(output);
    }

    public zzly zzlp() {
        this.zzacW = null;
        this.zzacX = zzlw.zzlm();
        this.zzacY = zzlv.zzlk();
        this.zzacZ = zza.zzlq();
        this.zzcqy = -1;
        return this;
    }

    public zzly zzo(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        while (true) {
            int zzRp = com_google_android_gms_internal_zzaie.zzRp();
            int zzc;
            Object obj;
            switch (zzRp) {
                case 0:
                    break;
                case 8:
                    zzRp = com_google_android_gms_internal_zzaie.zzRt();
                    switch (zzRp) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            this.zzacW = Integer.valueOf(zzRp);
                            break;
                        default:
                            continue;
                    }
                case 18:
                    zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 18);
                    zzRp = this.zzacX == null ? 0 : this.zzacX.length;
                    obj = new zzlw[(zzc + zzRp)];
                    if (zzRp != 0) {
                        System.arraycopy(this.zzacX, 0, obj, 0, zzRp);
                    }
                    while (zzRp < obj.length - 1) {
                        obj[zzRp] = new zzlw();
                        com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                        com_google_android_gms_internal_zzaie.zzRp();
                        zzRp++;
                    }
                    obj[zzRp] = new zzlw();
                    com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                    this.zzacX = obj;
                    continue;
                case LogSource.ANDROID_CAMERA /*26*/:
                    zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 26);
                    zzRp = this.zzacY == null ? 0 : this.zzacY.length;
                    obj = new zzlv[(zzc + zzRp)];
                    if (zzRp != 0) {
                        System.arraycopy(this.zzacY, 0, obj, 0, zzRp);
                    }
                    while (zzRp < obj.length - 1) {
                        obj[zzRp] = new zzlv();
                        com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                        com_google_android_gms_internal_zzaie.zzRp();
                        zzRp++;
                    }
                    obj[zzRp] = new zzlv();
                    com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                    this.zzacY = obj;
                    continue;
                case 34:
                    zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 34);
                    zzRp = this.zzacZ == null ? 0 : this.zzacZ.length;
                    obj = new zza[(zzc + zzRp)];
                    if (zzRp != 0) {
                        System.arraycopy(this.zzacZ, 0, obj, 0, zzRp);
                    }
                    while (zzRp < obj.length - 1) {
                        obj[zzRp] = new zza();
                        com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                        com_google_android_gms_internal_zzaie.zzRp();
                        zzRp++;
                    }
                    obj[zzRp] = new zza();
                    com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                    this.zzacZ = obj;
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

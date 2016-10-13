package com.google.android.gms.internal;

import com.google.android.gms.playlog.PlayLogger.LogSource;
import java.io.IOException;
import java.util.Arrays;

public interface zzaiv {

    public static final class zza extends zzaig<zza> {
        private static volatile zza[] zzcrU;
        public long zzcrV;
        public long zzcrW;

        public zza() {
            zzSo();
        }

        public static zza[] zzSn() {
            if (zzcrU == null) {
                synchronized (zzail.zzcqx) {
                    if (zzcrU == null) {
                        zzcrU = new zza[0];
                    }
                }
            }
            return zzcrU;
        }

        protected int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.zzcrV != 0) {
                computeSerializedSize += zzaif.zzj(1, this.zzcrV);
            }
            return this.zzcrW != 0 ? computeSerializedSize + zzaif.zzj(2, this.zzcrW) : computeSerializedSize;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzaiv_zza = (zza) o;
            if (this.zzcrV != com_google_android_gms_internal_zzaiv_zza.zzcrV || this.zzcrW != com_google_android_gms_internal_zzaiv_zza.zzcrW) {
                return false;
            }
            if (this.zzcqo == null || this.zzcqo.isEmpty()) {
                return com_google_android_gms_internal_zzaiv_zza.zzcqo == null || com_google_android_gms_internal_zzaiv_zza.zzcqo.isEmpty();
            } else {
                return this.zzcqo.equals(com_google_android_gms_internal_zzaiv_zza.zzcqo);
            }
        }

        public int hashCode() {
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzcrV ^ (this.zzcrV >>> 32)))) * 31) + ((int) (this.zzcrW ^ (this.zzcrW >>> 32)))) * 31;
            int hashCode2 = (this.zzcqo == null || this.zzcqo.isEmpty()) ? 0 : this.zzcqo.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzaV(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            if (this.zzcrV != 0) {
                output.zzg(1, this.zzcrV);
            }
            if (this.zzcrW != 0) {
                output.zzg(2, this.zzcrW);
            }
            super.writeTo(output);
        }

        public zza zzSo() {
            this.zzcrV = 0;
            this.zzcrW = 0;
            this.zzcqo = null;
            this.zzcqy = -1;
            return this;
        }

        public zza zzaV(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            while (true) {
                int zzRp = com_google_android_gms_internal_zzaie.zzRp();
                switch (zzRp) {
                    case 0:
                        break;
                    case 8:
                        this.zzcrV = com_google_android_gms_internal_zzaie.zzRs();
                        continue;
                    case 16:
                        this.zzcrW = com_google_android_gms_internal_zzaie.zzRs();
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

    public static final class zzb extends zzaig<zzb> {
        private static volatile zzb[] zzcrX;
        public String name;
        public long zzcrY;
        public zza[] zzcrZ;

        public zzb() {
            zzSq();
        }

        public static zzb[] zzSp() {
            if (zzcrX == null) {
                synchronized (zzail.zzcqx) {
                    if (zzcrX == null) {
                        zzcrX = new zzb[0];
                    }
                }
            }
            return zzcrX;
        }

        protected int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.zzcrY != 0) {
                computeSerializedSize += zzaif.zzk(1, this.zzcrY);
            }
            if (!this.name.equals("")) {
                computeSerializedSize += zzaif.zzp(2, this.name);
            }
            if (this.zzcrZ == null || this.zzcrZ.length <= 0) {
                return computeSerializedSize;
            }
            int i = computeSerializedSize;
            for (zzain com_google_android_gms_internal_zzain : this.zzcrZ) {
                if (com_google_android_gms_internal_zzain != null) {
                    i += zzaif.zzc(3, com_google_android_gms_internal_zzain);
                }
            }
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzaiv_zzb = (zzb) o;
            if (this.zzcrY != com_google_android_gms_internal_zzaiv_zzb.zzcrY) {
                return false;
            }
            if (this.name == null) {
                if (com_google_android_gms_internal_zzaiv_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzaiv_zzb.name)) {
                return false;
            }
            if (!zzail.equals(this.zzcrZ, com_google_android_gms_internal_zzaiv_zzb.zzcrZ)) {
                return false;
            }
            if (this.zzcqo == null || this.zzcqo.isEmpty()) {
                return com_google_android_gms_internal_zzaiv_zzb.zzcqo == null || com_google_android_gms_internal_zzaiv_zzb.zzcqo.isEmpty();
            } else {
                return this.zzcqo.equals(com_google_android_gms_internal_zzaiv_zzb.zzcqo);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzcrY ^ (this.zzcrY >>> 32)))) * 31)) * 31) + zzail.hashCode(this.zzcrZ)) * 31;
            if (!(this.zzcqo == null || this.zzcqo.isEmpty())) {
                i = this.zzcqo.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzaW(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            if (this.zzcrY != 0) {
                output.zzh(1, this.zzcrY);
            }
            if (!this.name.equals("")) {
                output.zzo(2, this.name);
            }
            if (this.zzcrZ != null && this.zzcrZ.length > 0) {
                for (zzain com_google_android_gms_internal_zzain : this.zzcrZ) {
                    if (com_google_android_gms_internal_zzain != null) {
                        output.zza(3, com_google_android_gms_internal_zzain);
                    }
                }
            }
            super.writeTo(output);
        }

        public zzb zzSq() {
            this.zzcrY = 0;
            this.name = "";
            this.zzcrZ = zza.zzSn();
            this.zzcqo = null;
            this.zzcqy = -1;
            return this;
        }

        public zzb zzaW(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            while (true) {
                int zzRp = com_google_android_gms_internal_zzaie.zzRp();
                switch (zzRp) {
                    case 0:
                        break;
                    case 9:
                        this.zzcrY = com_google_android_gms_internal_zzaie.zzRu();
                        continue;
                    case 18:
                        this.name = com_google_android_gms_internal_zzaie.readString();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        int zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 26);
                        zzRp = this.zzcrZ == null ? 0 : this.zzcrZ.length;
                        Object obj = new zza[(zzc + zzRp)];
                        if (zzRp != 0) {
                            System.arraycopy(this.zzcrZ, 0, obj, 0, zzRp);
                        }
                        while (zzRp < obj.length - 1) {
                            obj[zzRp] = new zza();
                            com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                            com_google_android_gms_internal_zzaie.zzRp();
                            zzRp++;
                        }
                        obj[zzRp] = new zza();
                        com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                        this.zzcrZ = obj;
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

    public static final class zzc extends zzaig<zzc> {
        public long zzcsa;
        public zzb[] zzcsb;
        public byte[] zzcsc;

        public zzc() {
            zzSr();
        }

        protected int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.zzcsa != 0) {
                computeSerializedSize += zzaif.zzj(1, this.zzcsa);
            }
            if (this.zzcsb != null && this.zzcsb.length > 0) {
                int i = computeSerializedSize;
                for (zzain com_google_android_gms_internal_zzain : this.zzcsb) {
                    if (com_google_android_gms_internal_zzain != null) {
                        i += zzaif.zzc(2, com_google_android_gms_internal_zzain);
                    }
                }
                computeSerializedSize = i;
            }
            return !Arrays.equals(this.zzcsc, zzaiq.zzcqH) ? computeSerializedSize + zzaif.zzb(3, this.zzcsc) : computeSerializedSize;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzaiv_zzc = (zzc) o;
            if (this.zzcsa != com_google_android_gms_internal_zzaiv_zzc.zzcsa || !zzail.equals(this.zzcsb, com_google_android_gms_internal_zzaiv_zzc.zzcsb) || !Arrays.equals(this.zzcsc, com_google_android_gms_internal_zzaiv_zzc.zzcsc)) {
                return false;
            }
            if (this.zzcqo == null || this.zzcqo.isEmpty()) {
                return com_google_android_gms_internal_zzaiv_zzc.zzcqo == null || com_google_android_gms_internal_zzaiv_zzc.zzcqo.isEmpty();
            } else {
                return this.zzcqo.equals(com_google_android_gms_internal_zzaiv_zzc.zzcqo);
            }
        }

        public int hashCode() {
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzcsa ^ (this.zzcsa >>> 32)))) * 31) + zzail.hashCode(this.zzcsb)) * 31) + Arrays.hashCode(this.zzcsc)) * 31;
            int hashCode2 = (this.zzcqo == null || this.zzcqo.isEmpty()) ? 0 : this.zzcqo.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzaX(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            if (this.zzcsa != 0) {
                output.zzg(1, this.zzcsa);
            }
            if (this.zzcsb != null && this.zzcsb.length > 0) {
                for (zzain com_google_android_gms_internal_zzain : this.zzcsb) {
                    if (com_google_android_gms_internal_zzain != null) {
                        output.zza(2, com_google_android_gms_internal_zzain);
                    }
                }
            }
            if (!Arrays.equals(this.zzcsc, zzaiq.zzcqH)) {
                output.zza(3, this.zzcsc);
            }
            super.writeTo(output);
        }

        public zzc zzSr() {
            this.zzcsa = 0;
            this.zzcsb = zzb.zzSp();
            this.zzcsc = zzaiq.zzcqH;
            this.zzcqo = null;
            this.zzcqy = -1;
            return this;
        }

        public zzc zzaX(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            while (true) {
                int zzRp = com_google_android_gms_internal_zzaie.zzRp();
                switch (zzRp) {
                    case 0:
                        break;
                    case 8:
                        this.zzcsa = com_google_android_gms_internal_zzaie.zzRs();
                        continue;
                    case 18:
                        int zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 18);
                        zzRp = this.zzcsb == null ? 0 : this.zzcsb.length;
                        Object obj = new zzb[(zzc + zzRp)];
                        if (zzRp != 0) {
                            System.arraycopy(this.zzcsb, 0, obj, 0, zzRp);
                        }
                        while (zzRp < obj.length - 1) {
                            obj[zzRp] = new zzb();
                            com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                            com_google_android_gms_internal_zzaie.zzRp();
                            zzRp++;
                        }
                        obj[zzRp] = new zzb();
                        com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                        this.zzcsb = obj;
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.zzcsc = com_google_android_gms_internal_zzaie.readBytes();
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
}

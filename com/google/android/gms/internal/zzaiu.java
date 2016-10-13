package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.playlog.PlayLogger.LogSource;
import java.io.IOException;
import java.util.Arrays;

public interface zzaiu {

    public static final class zza extends zzaig<zza> {
        public String[] zzcrt;
        public String[] zzcru;
        public int[] zzcrv;
        public long[] zzcrw;

        public zza() {
            zzSh();
        }

        protected int computeSerializedSize() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int computeSerializedSize = super.computeSerializedSize();
            if (this.zzcrt == null || this.zzcrt.length <= 0) {
                i = computeSerializedSize;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.zzcrt) {
                    if (str != null) {
                        i3++;
                        i2 += zzaif.zzkm(str);
                    }
                }
                i = (computeSerializedSize + i2) + (i3 * 1);
            }
            if (this.zzcru != null && this.zzcru.length > 0) {
                i3 = 0;
                computeSerializedSize = 0;
                for (String str2 : this.zzcru) {
                    if (str2 != null) {
                        computeSerializedSize++;
                        i3 += zzaif.zzkm(str2);
                    }
                }
                i = (i + i3) + (computeSerializedSize * 1);
            }
            if (this.zzcrv != null && this.zzcrv.length > 0) {
                i3 = 0;
                for (int computeSerializedSize2 : this.zzcrv) {
                    i3 += zzaif.zztf(computeSerializedSize2);
                }
                i = (i + i3) + (this.zzcrv.length * 1);
            }
            if (this.zzcrw == null || this.zzcrw.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i4 < this.zzcrw.length) {
                i2 += zzaif.zzaR(this.zzcrw[i4]);
                i4++;
            }
            return (i + i2) + (this.zzcrw.length * 1);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzaiu_zza = (zza) o;
            if (!zzail.equals(this.zzcrt, com_google_android_gms_internal_zzaiu_zza.zzcrt) || !zzail.equals(this.zzcru, com_google_android_gms_internal_zzaiu_zza.zzcru) || !zzail.equals(this.zzcrv, com_google_android_gms_internal_zzaiu_zza.zzcrv) || !zzail.equals(this.zzcrw, com_google_android_gms_internal_zzaiu_zza.zzcrw)) {
                return false;
            }
            if (this.zzcqo == null || this.zzcqo.isEmpty()) {
                return com_google_android_gms_internal_zzaiu_zza.zzcqo == null || com_google_android_gms_internal_zzaiu_zza.zzcqo.isEmpty();
            } else {
                return this.zzcqo.equals(com_google_android_gms_internal_zzaiu_zza.zzcqo);
            }
        }

        public int hashCode() {
            int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + zzail.hashCode(this.zzcrt)) * 31) + zzail.hashCode(this.zzcru)) * 31) + zzail.hashCode(this.zzcrv)) * 31) + zzail.hashCode(this.zzcrw)) * 31;
            int hashCode2 = (this.zzcqo == null || this.zzcqo.isEmpty()) ? 0 : this.zzcqo.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzaQ(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            int i = 0;
            if (this.zzcrt != null && this.zzcrt.length > 0) {
                for (String str : this.zzcrt) {
                    if (str != null) {
                        output.zzo(1, str);
                    }
                }
            }
            if (this.zzcru != null && this.zzcru.length > 0) {
                for (String str2 : this.zzcru) {
                    if (str2 != null) {
                        output.zzo(2, str2);
                    }
                }
            }
            if (this.zzcrv != null && this.zzcrv.length > 0) {
                for (int zzR : this.zzcrv) {
                    output.zzR(3, zzR);
                }
            }
            if (this.zzcrw != null && this.zzcrw.length > 0) {
                while (i < this.zzcrw.length) {
                    output.zzg(4, this.zzcrw[i]);
                    i++;
                }
            }
            super.writeTo(output);
        }

        public zza zzSh() {
            this.zzcrt = zzaiq.zzcqF;
            this.zzcru = zzaiq.zzcqF;
            this.zzcrv = zzaiq.zzcqA;
            this.zzcrw = zzaiq.zzcqB;
            this.zzcqo = null;
            this.zzcqy = -1;
            return this;
        }

        public zza zzaQ(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            while (true) {
                int zzRp = com_google_android_gms_internal_zzaie.zzRp();
                int zzc;
                Object obj;
                int zzsY;
                Object obj2;
                switch (zzRp) {
                    case 0:
                        break;
                    case 10:
                        zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 10);
                        zzRp = this.zzcrt == null ? 0 : this.zzcrt.length;
                        obj = new String[(zzc + zzRp)];
                        if (zzRp != 0) {
                            System.arraycopy(this.zzcrt, 0, obj, 0, zzRp);
                        }
                        while (zzRp < obj.length - 1) {
                            obj[zzRp] = com_google_android_gms_internal_zzaie.readString();
                            com_google_android_gms_internal_zzaie.zzRp();
                            zzRp++;
                        }
                        obj[zzRp] = com_google_android_gms_internal_zzaie.readString();
                        this.zzcrt = obj;
                        continue;
                    case 18:
                        zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 18);
                        zzRp = this.zzcru == null ? 0 : this.zzcru.length;
                        obj = new String[(zzc + zzRp)];
                        if (zzRp != 0) {
                            System.arraycopy(this.zzcru, 0, obj, 0, zzRp);
                        }
                        while (zzRp < obj.length - 1) {
                            obj[zzRp] = com_google_android_gms_internal_zzaie.readString();
                            com_google_android_gms_internal_zzaie.zzRp();
                            zzRp++;
                        }
                        obj[zzRp] = com_google_android_gms_internal_zzaie.readString();
                        this.zzcru = obj;
                        continue;
                    case 24:
                        zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 24);
                        zzRp = this.zzcrv == null ? 0 : this.zzcrv.length;
                        obj = new int[(zzc + zzRp)];
                        if (zzRp != 0) {
                            System.arraycopy(this.zzcrv, 0, obj, 0, zzRp);
                        }
                        while (zzRp < obj.length - 1) {
                            obj[zzRp] = com_google_android_gms_internal_zzaie.zzRt();
                            com_google_android_gms_internal_zzaie.zzRp();
                            zzRp++;
                        }
                        obj[zzRp] = com_google_android_gms_internal_zzaie.zzRt();
                        this.zzcrv = obj;
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        zzsY = com_google_android_gms_internal_zzaie.zzsY(com_google_android_gms_internal_zzaie.zzRy());
                        zzc = com_google_android_gms_internal_zzaie.getPosition();
                        zzRp = 0;
                        while (com_google_android_gms_internal_zzaie.zzRD() > 0) {
                            com_google_android_gms_internal_zzaie.zzRt();
                            zzRp++;
                        }
                        com_google_android_gms_internal_zzaie.zzta(zzc);
                        zzc = this.zzcrv == null ? 0 : this.zzcrv.length;
                        obj2 = new int[(zzRp + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzcrv, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaie.zzRt();
                            zzc++;
                        }
                        this.zzcrv = obj2;
                        com_google_android_gms_internal_zzaie.zzsZ(zzsY);
                        continue;
                    case 32:
                        zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 32);
                        zzRp = this.zzcrw == null ? 0 : this.zzcrw.length;
                        obj = new long[(zzc + zzRp)];
                        if (zzRp != 0) {
                            System.arraycopy(this.zzcrw, 0, obj, 0, zzRp);
                        }
                        while (zzRp < obj.length - 1) {
                            obj[zzRp] = com_google_android_gms_internal_zzaie.zzRs();
                            com_google_android_gms_internal_zzaie.zzRp();
                            zzRp++;
                        }
                        obj[zzRp] = com_google_android_gms_internal_zzaie.zzRs();
                        this.zzcrw = obj;
                        continue;
                    case 34:
                        zzsY = com_google_android_gms_internal_zzaie.zzsY(com_google_android_gms_internal_zzaie.zzRy());
                        zzc = com_google_android_gms_internal_zzaie.getPosition();
                        zzRp = 0;
                        while (com_google_android_gms_internal_zzaie.zzRD() > 0) {
                            com_google_android_gms_internal_zzaie.zzRs();
                            zzRp++;
                        }
                        com_google_android_gms_internal_zzaie.zzta(zzc);
                        zzc = this.zzcrw == null ? 0 : this.zzcrw.length;
                        obj2 = new long[(zzRp + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzcrw, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaie.zzRs();
                            zzc++;
                        }
                        this.zzcrw = obj2;
                        com_google_android_gms_internal_zzaie.zzsZ(zzsY);
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
        public String version;
        public int zzcrx;
        public String zzcry;

        public zzb() {
            zzSi();
        }

        protected int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.zzcrx != 0) {
                computeSerializedSize += zzaif.zzT(1, this.zzcrx);
            }
            if (!this.zzcry.equals("")) {
                computeSerializedSize += zzaif.zzp(2, this.zzcry);
            }
            return !this.version.equals("") ? computeSerializedSize + zzaif.zzp(3, this.version) : computeSerializedSize;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzaiu_zzb = (zzb) o;
            if (this.zzcrx != com_google_android_gms_internal_zzaiu_zzb.zzcrx) {
                return false;
            }
            if (this.zzcry == null) {
                if (com_google_android_gms_internal_zzaiu_zzb.zzcry != null) {
                    return false;
                }
            } else if (!this.zzcry.equals(com_google_android_gms_internal_zzaiu_zzb.zzcry)) {
                return false;
            }
            if (this.version == null) {
                if (com_google_android_gms_internal_zzaiu_zzb.version != null) {
                    return false;
                }
            } else if (!this.version.equals(com_google_android_gms_internal_zzaiu_zzb.version)) {
                return false;
            }
            if (this.zzcqo == null || this.zzcqo.isEmpty()) {
                return com_google_android_gms_internal_zzaiu_zzb.zzcqo == null || com_google_android_gms_internal_zzaiu_zzb.zzcqo.isEmpty();
            } else {
                return this.zzcqo.equals(com_google_android_gms_internal_zzaiu_zzb.zzcqo);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.zzcry == null ? 0 : this.zzcry.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.zzcrx) * 31)) * 31)) * 31;
            if (!(this.zzcqo == null || this.zzcqo.isEmpty())) {
                i = this.zzcqo.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzaR(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            if (this.zzcrx != 0) {
                output.zzR(1, this.zzcrx);
            }
            if (!this.zzcry.equals("")) {
                output.zzo(2, this.zzcry);
            }
            if (!this.version.equals("")) {
                output.zzo(3, this.version);
            }
            super.writeTo(output);
        }

        public zzb zzSi() {
            this.zzcrx = 0;
            this.zzcry = "";
            this.version = "";
            this.zzcqo = null;
            this.zzcqy = -1;
            return this;
        }

        public zzb zzaR(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            while (true) {
                int zzRp = com_google_android_gms_internal_zzaie.zzRp();
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
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case LogSource.ANDROID_CAMERA /*26*/:
                                this.zzcrx = zzRp;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzcry = com_google_android_gms_internal_zzaie.readString();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.version = com_google_android_gms_internal_zzaie.readString();
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
        public byte[][] zzcrA;
        public boolean zzcrB;
        public byte[] zzcrz;

        public zzc() {
            zzSj();
        }

        protected int computeSerializedSize() {
            int i = 0;
            int computeSerializedSize = super.computeSerializedSize();
            if (!Arrays.equals(this.zzcrz, zzaiq.zzcqH)) {
                computeSerializedSize += zzaif.zzb(1, this.zzcrz);
            }
            if (this.zzcrA != null && this.zzcrA.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i < this.zzcrA.length) {
                    byte[] bArr = this.zzcrA[i];
                    if (bArr != null) {
                        i3++;
                        i2 += zzaif.zzY(bArr);
                    }
                    i++;
                }
                computeSerializedSize = (computeSerializedSize + i2) + (i3 * 1);
            }
            return this.zzcrB ? computeSerializedSize + zzaif.zzi(3, this.zzcrB) : computeSerializedSize;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzaiu_zzc = (zzc) o;
            if (!Arrays.equals(this.zzcrz, com_google_android_gms_internal_zzaiu_zzc.zzcrz) || !zzail.zza(this.zzcrA, com_google_android_gms_internal_zzaiu_zzc.zzcrA) || this.zzcrB != com_google_android_gms_internal_zzaiu_zzc.zzcrB) {
                return false;
            }
            if (this.zzcqo == null || this.zzcqo.isEmpty()) {
                return com_google_android_gms_internal_zzaiu_zzc.zzcqo == null || com_google_android_gms_internal_zzaiu_zzc.zzcqo.isEmpty();
            } else {
                return this.zzcqo.equals(com_google_android_gms_internal_zzaiu_zzc.zzcqo);
            }
        }

        public int hashCode() {
            int hashCode = ((this.zzcrB ? 1231 : 1237) + ((((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzcrz)) * 31) + zzail.zzd(this.zzcrA)) * 31)) * 31;
            int hashCode2 = (this.zzcqo == null || this.zzcqo.isEmpty()) ? 0 : this.zzcqo.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzaS(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            if (!Arrays.equals(this.zzcrz, zzaiq.zzcqH)) {
                output.zza(1, this.zzcrz);
            }
            if (this.zzcrA != null && this.zzcrA.length > 0) {
                for (byte[] bArr : this.zzcrA) {
                    if (bArr != null) {
                        output.zza(2, bArr);
                    }
                }
            }
            if (this.zzcrB) {
                output.zzh(3, this.zzcrB);
            }
            super.writeTo(output);
        }

        public zzc zzSj() {
            this.zzcrz = zzaiq.zzcqH;
            this.zzcrA = zzaiq.zzcqG;
            this.zzcrB = false;
            this.zzcqo = null;
            this.zzcqy = -1;
            return this;
        }

        public zzc zzaS(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            while (true) {
                int zzRp = com_google_android_gms_internal_zzaie.zzRp();
                switch (zzRp) {
                    case 0:
                        break;
                    case 10:
                        this.zzcrz = com_google_android_gms_internal_zzaie.readBytes();
                        continue;
                    case 18:
                        int zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 18);
                        zzRp = this.zzcrA == null ? 0 : this.zzcrA.length;
                        Object obj = new byte[(zzc + zzRp)][];
                        if (zzRp != 0) {
                            System.arraycopy(this.zzcrA, 0, obj, 0, zzRp);
                        }
                        while (zzRp < obj.length - 1) {
                            obj[zzRp] = com_google_android_gms_internal_zzaie.readBytes();
                            com_google_android_gms_internal_zzaie.zzRp();
                            zzRp++;
                        }
                        obj[zzRp] = com_google_android_gms_internal_zzaie.readBytes();
                        this.zzcrA = obj;
                        continue;
                    case 24:
                        this.zzcrB = com_google_android_gms_internal_zzaie.zzRv();
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

    public static final class zzd extends zzaig<zzd> {
        public int eventCode;
        public String tag;
        public long zzcrC;
        public long zzcrD;
        public long zzcrE;
        public boolean zzcrF;
        public zze[] zzcrG;
        public zzb zzcrH;
        public byte[] zzcrI;
        public byte[] zzcrJ;
        public byte[] zzcrK;
        public zza zzcrL;
        public String zzcrM;
        public long zzcrN;
        public zzc zzcrO;
        public byte[] zzcrP;
        public int zzcrQ;
        public int[] zzcrR;
        public long zzcrS;
        public int zzob;

        public zzd() {
            zzSk();
        }

        protected int computeSerializedSize() {
            int i;
            int i2 = 0;
            int computeSerializedSize = super.computeSerializedSize();
            if (this.zzcrC != 0) {
                computeSerializedSize += zzaif.zzj(1, this.zzcrC);
            }
            if (!this.tag.equals("")) {
                computeSerializedSize += zzaif.zzp(2, this.tag);
            }
            if (this.zzcrG != null && this.zzcrG.length > 0) {
                i = computeSerializedSize;
                for (zzain com_google_android_gms_internal_zzain : this.zzcrG) {
                    if (com_google_android_gms_internal_zzain != null) {
                        i += zzaif.zzc(3, com_google_android_gms_internal_zzain);
                    }
                }
                computeSerializedSize = i;
            }
            if (!Arrays.equals(this.zzcrI, zzaiq.zzcqH)) {
                computeSerializedSize += zzaif.zzb(6, this.zzcrI);
            }
            if (this.zzcrL != null) {
                computeSerializedSize += zzaif.zzc(7, this.zzcrL);
            }
            if (!Arrays.equals(this.zzcrJ, zzaiq.zzcqH)) {
                computeSerializedSize += zzaif.zzb(8, this.zzcrJ);
            }
            if (this.zzcrH != null) {
                computeSerializedSize += zzaif.zzc(9, this.zzcrH);
            }
            if (this.zzcrF) {
                computeSerializedSize += zzaif.zzi(10, this.zzcrF);
            }
            if (this.eventCode != 0) {
                computeSerializedSize += zzaif.zzT(11, this.eventCode);
            }
            if (this.zzob != 0) {
                computeSerializedSize += zzaif.zzT(12, this.zzob);
            }
            if (!Arrays.equals(this.zzcrK, zzaiq.zzcqH)) {
                computeSerializedSize += zzaif.zzb(13, this.zzcrK);
            }
            if (!this.zzcrM.equals("")) {
                computeSerializedSize += zzaif.zzp(14, this.zzcrM);
            }
            if (this.zzcrN != 180000) {
                computeSerializedSize += zzaif.zzl(15, this.zzcrN);
            }
            if (this.zzcrO != null) {
                computeSerializedSize += zzaif.zzc(16, this.zzcrO);
            }
            if (this.zzcrD != 0) {
                computeSerializedSize += zzaif.zzj(17, this.zzcrD);
            }
            if (!Arrays.equals(this.zzcrP, zzaiq.zzcqH)) {
                computeSerializedSize += zzaif.zzb(18, this.zzcrP);
            }
            if (this.zzcrQ != 0) {
                computeSerializedSize += zzaif.zzT(19, this.zzcrQ);
            }
            if (this.zzcrR != null && this.zzcrR.length > 0) {
                i = 0;
                while (i2 < this.zzcrR.length) {
                    i += zzaif.zztf(this.zzcrR[i2]);
                    i2++;
                }
                computeSerializedSize = (computeSerializedSize + i) + (this.zzcrR.length * 2);
            }
            if (this.zzcrE != 0) {
                computeSerializedSize += zzaif.zzj(21, this.zzcrE);
            }
            return this.zzcrS != 0 ? computeSerializedSize + zzaif.zzj(22, this.zzcrS) : computeSerializedSize;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzaiu_zzd = (zzd) o;
            if (this.zzcrC != com_google_android_gms_internal_zzaiu_zzd.zzcrC || this.zzcrD != com_google_android_gms_internal_zzaiu_zzd.zzcrD || this.zzcrE != com_google_android_gms_internal_zzaiu_zzd.zzcrE) {
                return false;
            }
            if (this.tag == null) {
                if (com_google_android_gms_internal_zzaiu_zzd.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(com_google_android_gms_internal_zzaiu_zzd.tag)) {
                return false;
            }
            if (this.eventCode != com_google_android_gms_internal_zzaiu_zzd.eventCode || this.zzob != com_google_android_gms_internal_zzaiu_zzd.zzob || this.zzcrF != com_google_android_gms_internal_zzaiu_zzd.zzcrF || !zzail.equals(this.zzcrG, com_google_android_gms_internal_zzaiu_zzd.zzcrG)) {
                return false;
            }
            if (this.zzcrH == null) {
                if (com_google_android_gms_internal_zzaiu_zzd.zzcrH != null) {
                    return false;
                }
            } else if (!this.zzcrH.equals(com_google_android_gms_internal_zzaiu_zzd.zzcrH)) {
                return false;
            }
            if (!Arrays.equals(this.zzcrI, com_google_android_gms_internal_zzaiu_zzd.zzcrI) || !Arrays.equals(this.zzcrJ, com_google_android_gms_internal_zzaiu_zzd.zzcrJ) || !Arrays.equals(this.zzcrK, com_google_android_gms_internal_zzaiu_zzd.zzcrK)) {
                return false;
            }
            if (this.zzcrL == null) {
                if (com_google_android_gms_internal_zzaiu_zzd.zzcrL != null) {
                    return false;
                }
            } else if (!this.zzcrL.equals(com_google_android_gms_internal_zzaiu_zzd.zzcrL)) {
                return false;
            }
            if (this.zzcrM == null) {
                if (com_google_android_gms_internal_zzaiu_zzd.zzcrM != null) {
                    return false;
                }
            } else if (!this.zzcrM.equals(com_google_android_gms_internal_zzaiu_zzd.zzcrM)) {
                return false;
            }
            if (this.zzcrN != com_google_android_gms_internal_zzaiu_zzd.zzcrN) {
                return false;
            }
            if (this.zzcrO == null) {
                if (com_google_android_gms_internal_zzaiu_zzd.zzcrO != null) {
                    return false;
                }
            } else if (!this.zzcrO.equals(com_google_android_gms_internal_zzaiu_zzd.zzcrO)) {
                return false;
            }
            if (!Arrays.equals(this.zzcrP, com_google_android_gms_internal_zzaiu_zzd.zzcrP) || this.zzcrQ != com_google_android_gms_internal_zzaiu_zzd.zzcrQ || !zzail.equals(this.zzcrR, com_google_android_gms_internal_zzaiu_zzd.zzcrR) || this.zzcrS != com_google_android_gms_internal_zzaiu_zzd.zzcrS) {
                return false;
            }
            if (this.zzcqo == null || this.zzcqo.isEmpty()) {
                return com_google_android_gms_internal_zzaiu_zzd.zzcqo == null || com_google_android_gms_internal_zzaiu_zzd.zzcqo.isEmpty();
            } else {
                return this.zzcqo.equals(com_google_android_gms_internal_zzaiu_zzd.zzcqo);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((((((this.zzcrO == null ? 0 : this.zzcrO.hashCode()) + (((((this.zzcrM == null ? 0 : this.zzcrM.hashCode()) + (((this.zzcrL == null ? 0 : this.zzcrL.hashCode()) + (((((((((this.zzcrH == null ? 0 : this.zzcrH.hashCode()) + (((((this.zzcrF ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzcrC ^ (this.zzcrC >>> 32)))) * 31) + ((int) (this.zzcrD ^ (this.zzcrD >>> 32)))) * 31) + ((int) (this.zzcrE ^ (this.zzcrE >>> 32)))) * 31)) * 31) + this.eventCode) * 31) + this.zzob) * 31)) * 31) + zzail.hashCode(this.zzcrG)) * 31)) * 31) + Arrays.hashCode(this.zzcrI)) * 31) + Arrays.hashCode(this.zzcrJ)) * 31) + Arrays.hashCode(this.zzcrK)) * 31)) * 31)) * 31) + ((int) (this.zzcrN ^ (this.zzcrN >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.zzcrP)) * 31) + this.zzcrQ) * 31) + zzail.hashCode(this.zzcrR)) * 31) + ((int) (this.zzcrS ^ (this.zzcrS >>> 32)))) * 31;
            if (!(this.zzcqo == null || this.zzcqo.isEmpty())) {
                i = this.zzcqo.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzaT(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            int i = 0;
            if (this.zzcrC != 0) {
                output.zzg(1, this.zzcrC);
            }
            if (!this.tag.equals("")) {
                output.zzo(2, this.tag);
            }
            if (this.zzcrG != null && this.zzcrG.length > 0) {
                for (zzain com_google_android_gms_internal_zzain : this.zzcrG) {
                    if (com_google_android_gms_internal_zzain != null) {
                        output.zza(3, com_google_android_gms_internal_zzain);
                    }
                }
            }
            if (!Arrays.equals(this.zzcrI, zzaiq.zzcqH)) {
                output.zza(6, this.zzcrI);
            }
            if (this.zzcrL != null) {
                output.zza(7, this.zzcrL);
            }
            if (!Arrays.equals(this.zzcrJ, zzaiq.zzcqH)) {
                output.zza(8, this.zzcrJ);
            }
            if (this.zzcrH != null) {
                output.zza(9, this.zzcrH);
            }
            if (this.zzcrF) {
                output.zzh(10, this.zzcrF);
            }
            if (this.eventCode != 0) {
                output.zzR(11, this.eventCode);
            }
            if (this.zzob != 0) {
                output.zzR(12, this.zzob);
            }
            if (!Arrays.equals(this.zzcrK, zzaiq.zzcqH)) {
                output.zza(13, this.zzcrK);
            }
            if (!this.zzcrM.equals("")) {
                output.zzo(14, this.zzcrM);
            }
            if (this.zzcrN != 180000) {
                output.zzi(15, this.zzcrN);
            }
            if (this.zzcrO != null) {
                output.zza(16, this.zzcrO);
            }
            if (this.zzcrD != 0) {
                output.zzg(17, this.zzcrD);
            }
            if (!Arrays.equals(this.zzcrP, zzaiq.zzcqH)) {
                output.zza(18, this.zzcrP);
            }
            if (this.zzcrQ != 0) {
                output.zzR(19, this.zzcrQ);
            }
            if (this.zzcrR != null && this.zzcrR.length > 0) {
                while (i < this.zzcrR.length) {
                    output.zzR(20, this.zzcrR[i]);
                    i++;
                }
            }
            if (this.zzcrE != 0) {
                output.zzg(21, this.zzcrE);
            }
            if (this.zzcrS != 0) {
                output.zzg(22, this.zzcrS);
            }
            super.writeTo(output);
        }

        public zzd zzSk() {
            this.zzcrC = 0;
            this.zzcrD = 0;
            this.zzcrE = 0;
            this.tag = "";
            this.eventCode = 0;
            this.zzob = 0;
            this.zzcrF = false;
            this.zzcrG = zze.zzSl();
            this.zzcrH = null;
            this.zzcrI = zzaiq.zzcqH;
            this.zzcrJ = zzaiq.zzcqH;
            this.zzcrK = zzaiq.zzcqH;
            this.zzcrL = null;
            this.zzcrM = "";
            this.zzcrN = 180000;
            this.zzcrO = null;
            this.zzcrP = zzaiq.zzcqH;
            this.zzcrQ = 0;
            this.zzcrR = zzaiq.zzcqA;
            this.zzcrS = 0;
            this.zzcqo = null;
            this.zzcqy = -1;
            return this;
        }

        public zzd zzaT(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            while (true) {
                int zzRp = com_google_android_gms_internal_zzaie.zzRp();
                int zzc;
                Object obj;
                switch (zzRp) {
                    case 0:
                        break;
                    case 8:
                        this.zzcrC = com_google_android_gms_internal_zzaie.zzRs();
                        continue;
                    case 18:
                        this.tag = com_google_android_gms_internal_zzaie.readString();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 26);
                        zzRp = this.zzcrG == null ? 0 : this.zzcrG.length;
                        obj = new zze[(zzc + zzRp)];
                        if (zzRp != 0) {
                            System.arraycopy(this.zzcrG, 0, obj, 0, zzRp);
                        }
                        while (zzRp < obj.length - 1) {
                            obj[zzRp] = new zze();
                            com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                            com_google_android_gms_internal_zzaie.zzRp();
                            zzRp++;
                        }
                        obj[zzRp] = new zze();
                        com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                        this.zzcrG = obj;
                        continue;
                    case 50:
                        this.zzcrI = com_google_android_gms_internal_zzaie.readBytes();
                        continue;
                    case 58:
                        if (this.zzcrL == null) {
                            this.zzcrL = new zza();
                        }
                        com_google_android_gms_internal_zzaie.zza(this.zzcrL);
                        continue;
                    case 66:
                        this.zzcrJ = com_google_android_gms_internal_zzaie.readBytes();
                        continue;
                    case 74:
                        if (this.zzcrH == null) {
                            this.zzcrH = new zzb();
                        }
                        com_google_android_gms_internal_zzaie.zza(this.zzcrH);
                        continue;
                    case 80:
                        this.zzcrF = com_google_android_gms_internal_zzaie.zzRv();
                        continue;
                    case 88:
                        this.eventCode = com_google_android_gms_internal_zzaie.zzRt();
                        continue;
                    case 96:
                        this.zzob = com_google_android_gms_internal_zzaie.zzRt();
                        continue;
                    case 106:
                        this.zzcrK = com_google_android_gms_internal_zzaie.readBytes();
                        continue;
                    case 114:
                        this.zzcrM = com_google_android_gms_internal_zzaie.readString();
                        continue;
                    case 120:
                        this.zzcrN = com_google_android_gms_internal_zzaie.zzRx();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        if (this.zzcrO == null) {
                            this.zzcrO = new zzc();
                        }
                        com_google_android_gms_internal_zzaie.zza(this.zzcrO);
                        continue;
                    case 136:
                        this.zzcrD = com_google_android_gms_internal_zzaie.zzRs();
                        continue;
                    case 146:
                        this.zzcrP = com_google_android_gms_internal_zzaie.readBytes();
                        continue;
                    case 152:
                        zzRp = com_google_android_gms_internal_zzaie.zzRt();
                        switch (zzRp) {
                            case 0:
                            case 1:
                            case 2:
                                this.zzcrQ = zzRp;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 160);
                        zzRp = this.zzcrR == null ? 0 : this.zzcrR.length;
                        obj = new int[(zzc + zzRp)];
                        if (zzRp != 0) {
                            System.arraycopy(this.zzcrR, 0, obj, 0, zzRp);
                        }
                        while (zzRp < obj.length - 1) {
                            obj[zzRp] = com_google_android_gms_internal_zzaie.zzRt();
                            com_google_android_gms_internal_zzaie.zzRp();
                            zzRp++;
                        }
                        obj[zzRp] = com_google_android_gms_internal_zzaie.zzRt();
                        this.zzcrR = obj;
                        continue;
                    case 162:
                        int zzsY = com_google_android_gms_internal_zzaie.zzsY(com_google_android_gms_internal_zzaie.zzRy());
                        zzc = com_google_android_gms_internal_zzaie.getPosition();
                        zzRp = 0;
                        while (com_google_android_gms_internal_zzaie.zzRD() > 0) {
                            com_google_android_gms_internal_zzaie.zzRt();
                            zzRp++;
                        }
                        com_google_android_gms_internal_zzaie.zzta(zzc);
                        zzc = this.zzcrR == null ? 0 : this.zzcrR.length;
                        Object obj2 = new int[(zzRp + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzcrR, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaie.zzRt();
                            zzc++;
                        }
                        this.zzcrR = obj2;
                        com_google_android_gms_internal_zzaie.zzsZ(zzsY);
                        continue;
                    case 168:
                        this.zzcrE = com_google_android_gms_internal_zzaie.zzRs();
                        continue;
                    case 176:
                        this.zzcrS = com_google_android_gms_internal_zzaie.zzRs();
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

    public static final class zze extends zzaig<zze> {
        private static volatile zze[] zzcrT;
        public String key;
        public String value;

        public zze() {
            zzSm();
        }

        public static zze[] zzSl() {
            if (zzcrT == null) {
                synchronized (zzail.zzcqx) {
                    if (zzcrT == null) {
                        zzcrT = new zze[0];
                    }
                }
            }
            return zzcrT;
        }

        protected int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (!this.key.equals("")) {
                computeSerializedSize += zzaif.zzp(1, this.key);
            }
            return !this.value.equals("") ? computeSerializedSize + zzaif.zzp(2, this.value) : computeSerializedSize;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzaiu_zze = (zze) o;
            if (this.key == null) {
                if (com_google_android_gms_internal_zzaiu_zze.key != null) {
                    return false;
                }
            } else if (!this.key.equals(com_google_android_gms_internal_zzaiu_zze.key)) {
                return false;
            }
            if (this.value == null) {
                if (com_google_android_gms_internal_zzaiu_zze.value != null) {
                    return false;
                }
            } else if (!this.value.equals(com_google_android_gms_internal_zzaiu_zze.value)) {
                return false;
            }
            if (this.zzcqo == null || this.zzcqo.isEmpty()) {
                return com_google_android_gms_internal_zzaiu_zze.zzcqo == null || com_google_android_gms_internal_zzaiu_zze.zzcqo.isEmpty();
            } else {
                return this.zzcqo.equals(com_google_android_gms_internal_zzaiu_zze.zzcqo);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.value == null ? 0 : this.value.hashCode()) + (((this.key == null ? 0 : this.key.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.zzcqo == null || this.zzcqo.isEmpty())) {
                i = this.zzcqo.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzaU(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            if (!this.key.equals("")) {
                output.zzo(1, this.key);
            }
            if (!this.value.equals("")) {
                output.zzo(2, this.value);
            }
            super.writeTo(output);
        }

        public zze zzSm() {
            this.key = "";
            this.value = "";
            this.zzcqo = null;
            this.zzcqy = -1;
            return this;
        }

        public zze zzaU(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            while (true) {
                int zzRp = com_google_android_gms_internal_zzaie.zzRp();
                switch (zzRp) {
                    case 0:
                        break;
                    case 10:
                        this.key = com_google_android_gms_internal_zzaie.readString();
                        continue;
                    case 18:
                        this.value = com_google_android_gms_internal_zzaie.readString();
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

package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.playlog.PlayLogger.LogSource;
import java.io.IOException;

public final class zzahb extends zzaig<zzahb> {
    public String zzKv;
    public zzd zzchc;
    public int zzchd;
    public String zzche;
    public String zzchf;
    public zzb zzchg;
    public zza zzchh;
    public zzc zzchi;

    public static final class zza extends zzaig<zza> {
        public String zzchj;

        public zza() {
            zzPY();
        }

        protected int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            return !this.zzchj.equals("") ? computeSerializedSize + zzaif.zzp(1, this.zzchj) : computeSerializedSize;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzahb_zza = (zza) o;
            if (this.zzchj == null) {
                if (com_google_android_gms_internal_zzahb_zza.zzchj != null) {
                    return false;
                }
            } else if (!this.zzchj.equals(com_google_android_gms_internal_zzahb_zza.zzchj)) {
                return false;
            }
            if (this.zzcqo == null || this.zzcqo.isEmpty()) {
                return com_google_android_gms_internal_zzahb_zza.zzcqo == null || com_google_android_gms_internal_zzahb_zza.zzcqo.isEmpty();
            } else {
                return this.zzcqo.equals(com_google_android_gms_internal_zzahb_zza.zzcqo);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzchj == null ? 0 : this.zzchj.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
            if (!(this.zzcqo == null || this.zzcqo.isEmpty())) {
                i = this.zzcqo.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzav(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            if (!this.zzchj.equals("")) {
                output.zzo(1, this.zzchj);
            }
            super.writeTo(output);
        }

        public zza zzPY() {
            this.zzchj = "";
            this.zzcqo = null;
            this.zzcqy = -1;
            return this;
        }

        public zza zzav(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            while (true) {
                int zzRp = com_google_android_gms_internal_zzaie.zzRp();
                switch (zzRp) {
                    case 0:
                        break;
                    case 10:
                        this.zzchj = com_google_android_gms_internal_zzaie.readString();
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
        public String zzchk;

        public zzb() {
            zzPZ();
        }

        protected int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            return !this.zzchk.equals("") ? computeSerializedSize + zzaif.zzp(1, this.zzchk) : computeSerializedSize;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzahb_zzb = (zzb) o;
            if (this.zzchk == null) {
                if (com_google_android_gms_internal_zzahb_zzb.zzchk != null) {
                    return false;
                }
            } else if (!this.zzchk.equals(com_google_android_gms_internal_zzahb_zzb.zzchk)) {
                return false;
            }
            if (this.zzcqo == null || this.zzcqo.isEmpty()) {
                return com_google_android_gms_internal_zzahb_zzb.zzcqo == null || com_google_android_gms_internal_zzahb_zzb.zzcqo.isEmpty();
            } else {
                return this.zzcqo.equals(com_google_android_gms_internal_zzahb_zzb.zzcqo);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzchk == null ? 0 : this.zzchk.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
            if (!(this.zzcqo == null || this.zzcqo.isEmpty())) {
                i = this.zzcqo.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzaw(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            if (!this.zzchk.equals("")) {
                output.zzo(1, this.zzchk);
            }
            super.writeTo(output);
        }

        public zzb zzPZ() {
            this.zzchk = "";
            this.zzcqo = null;
            this.zzcqy = -1;
            return this;
        }

        public zzb zzaw(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            while (true) {
                int zzRp = com_google_android_gms_internal_zzaie.zzRp();
                switch (zzRp) {
                    case 0:
                        break;
                    case 10:
                        this.zzchk = com_google_android_gms_internal_zzaie.readString();
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
        public int[] zzchl;

        public zzc() {
            zzQa();
        }

        protected int computeSerializedSize() {
            int i = 0;
            int computeSerializedSize = super.computeSerializedSize();
            if (this.zzchl == null || this.zzchl.length <= 0) {
                return computeSerializedSize;
            }
            int i2 = 0;
            while (i < this.zzchl.length) {
                i2 += zzaif.zztf(this.zzchl[i]);
                i++;
            }
            return (computeSerializedSize + i2) + (this.zzchl.length * 1);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzahb_zzc = (zzc) o;
            if (!zzail.equals(this.zzchl, com_google_android_gms_internal_zzahb_zzc.zzchl)) {
                return false;
            }
            if (this.zzcqo == null || this.zzcqo.isEmpty()) {
                return com_google_android_gms_internal_zzahb_zzc.zzcqo == null || com_google_android_gms_internal_zzahb_zzc.zzcqo.isEmpty();
            } else {
                return this.zzcqo.equals(com_google_android_gms_internal_zzahb_zzc.zzcqo);
            }
        }

        public int hashCode() {
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzail.hashCode(this.zzchl)) * 31;
            int hashCode2 = (this.zzcqo == null || this.zzcqo.isEmpty()) ? 0 : this.zzcqo.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzax(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            if (this.zzchl != null && this.zzchl.length > 0) {
                for (int zzR : this.zzchl) {
                    output.zzR(1, zzR);
                }
            }
            super.writeTo(output);
        }

        public zzc zzQa() {
            this.zzchl = zzaiq.zzcqA;
            this.zzcqo = null;
            this.zzcqy = -1;
            return this;
        }

        public zzc zzax(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            while (true) {
                int zzRp = com_google_android_gms_internal_zzaie.zzRp();
                int zzc;
                switch (zzRp) {
                    case 0:
                        break;
                    case 8:
                        zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 8);
                        zzRp = this.zzchl == null ? 0 : this.zzchl.length;
                        Object obj = new int[(zzc + zzRp)];
                        if (zzRp != 0) {
                            System.arraycopy(this.zzchl, 0, obj, 0, zzRp);
                        }
                        while (zzRp < obj.length - 1) {
                            obj[zzRp] = com_google_android_gms_internal_zzaie.zzRt();
                            com_google_android_gms_internal_zzaie.zzRp();
                            zzRp++;
                        }
                        obj[zzRp] = com_google_android_gms_internal_zzaie.zzRt();
                        this.zzchl = obj;
                        continue;
                    case 10:
                        int zzsY = com_google_android_gms_internal_zzaie.zzsY(com_google_android_gms_internal_zzaie.zzRy());
                        zzc = com_google_android_gms_internal_zzaie.getPosition();
                        zzRp = 0;
                        while (com_google_android_gms_internal_zzaie.zzRD() > 0) {
                            com_google_android_gms_internal_zzaie.zzRt();
                            zzRp++;
                        }
                        com_google_android_gms_internal_zzaie.zzta(zzc);
                        zzc = this.zzchl == null ? 0 : this.zzchl.length;
                        Object obj2 = new int[(zzRp + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzchl, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaie.zzRt();
                            zzc++;
                        }
                        this.zzchl = obj2;
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

    public static final class zzd extends zzaig<zzd> {
        public String osVersion;
        public int type;
        public int zzchm;

        public zzd() {
            zzQb();
        }

        protected int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.type != 0) {
                computeSerializedSize += zzaif.zzT(1, this.type);
            }
            if (this.zzchm != 0) {
                computeSerializedSize += zzaif.zzT(2, this.zzchm);
            }
            return !this.osVersion.equals("") ? computeSerializedSize + zzaif.zzp(3, this.osVersion) : computeSerializedSize;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzahb_zzd = (zzd) o;
            if (this.type != com_google_android_gms_internal_zzahb_zzd.type || this.zzchm != com_google_android_gms_internal_zzahb_zzd.zzchm) {
                return false;
            }
            if (this.osVersion == null) {
                if (com_google_android_gms_internal_zzahb_zzd.osVersion != null) {
                    return false;
                }
            } else if (!this.osVersion.equals(com_google_android_gms_internal_zzahb_zzd.osVersion)) {
                return false;
            }
            if (this.zzcqo == null || this.zzcqo.isEmpty()) {
                return com_google_android_gms_internal_zzahb_zzd.zzcqo == null || com_google_android_gms_internal_zzahb_zzd.zzcqo.isEmpty();
            } else {
                return this.zzcqo.equals(com_google_android_gms_internal_zzahb_zzd.zzcqo);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.osVersion == null ? 0 : this.osVersion.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31) + this.zzchm) * 31)) * 31;
            if (!(this.zzcqo == null || this.zzcqo.isEmpty())) {
                i = this.zzcqo.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
            return zzay(com_google_android_gms_internal_zzaie);
        }

        public void writeTo(zzaif output) throws IOException {
            if (this.type != 0) {
                output.zzR(1, this.type);
            }
            if (this.zzchm != 0) {
                output.zzR(2, this.zzchm);
            }
            if (!this.osVersion.equals("")) {
                output.zzo(3, this.osVersion);
            }
            super.writeTo(output);
        }

        public zzd zzQb() {
            this.type = 0;
            this.zzchm = 0;
            this.osVersion = "";
            this.zzcqo = null;
            this.zzcqy = -1;
            return this;
        }

        public zzd zzay(zzaie com_google_android_gms_internal_zzaie) throws IOException {
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
                                this.type = zzRp;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.zzchm = com_google_android_gms_internal_zzaie.zzRt();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.osVersion = com_google_android_gms_internal_zzaie.readString();
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

    public zzahb() {
        zzPX();
    }

    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.zzKv.equals("")) {
            computeSerializedSize += zzaif.zzp(1, this.zzKv);
        }
        if (this.zzchc != null) {
            computeSerializedSize += zzaif.zzc(2, this.zzchc);
        }
        if (this.zzchd != 0) {
            computeSerializedSize += zzaif.zzT(3, this.zzchd);
        }
        if (!this.zzche.equals("")) {
            computeSerializedSize += zzaif.zzp(4, this.zzche);
        }
        if (!this.zzchf.equals("")) {
            computeSerializedSize += zzaif.zzp(5, this.zzchf);
        }
        if (this.zzchg != null) {
            computeSerializedSize += zzaif.zzc(6, this.zzchg);
        }
        if (this.zzchh != null) {
            computeSerializedSize += zzaif.zzc(7, this.zzchh);
        }
        return this.zzchi != null ? computeSerializedSize + zzaif.zzc(8, this.zzchi) : computeSerializedSize;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzahb)) {
            return false;
        }
        zzahb com_google_android_gms_internal_zzahb = (zzahb) o;
        if (this.zzKv == null) {
            if (com_google_android_gms_internal_zzahb.zzKv != null) {
                return false;
            }
        } else if (!this.zzKv.equals(com_google_android_gms_internal_zzahb.zzKv)) {
            return false;
        }
        if (this.zzchc == null) {
            if (com_google_android_gms_internal_zzahb.zzchc != null) {
                return false;
            }
        } else if (!this.zzchc.equals(com_google_android_gms_internal_zzahb.zzchc)) {
            return false;
        }
        if (this.zzchd != com_google_android_gms_internal_zzahb.zzchd) {
            return false;
        }
        if (this.zzche == null) {
            if (com_google_android_gms_internal_zzahb.zzche != null) {
                return false;
            }
        } else if (!this.zzche.equals(com_google_android_gms_internal_zzahb.zzche)) {
            return false;
        }
        if (this.zzchf == null) {
            if (com_google_android_gms_internal_zzahb.zzchf != null) {
                return false;
            }
        } else if (!this.zzchf.equals(com_google_android_gms_internal_zzahb.zzchf)) {
            return false;
        }
        if (this.zzchg == null) {
            if (com_google_android_gms_internal_zzahb.zzchg != null) {
                return false;
            }
        } else if (!this.zzchg.equals(com_google_android_gms_internal_zzahb.zzchg)) {
            return false;
        }
        if (this.zzchh == null) {
            if (com_google_android_gms_internal_zzahb.zzchh != null) {
                return false;
            }
        } else if (!this.zzchh.equals(com_google_android_gms_internal_zzahb.zzchh)) {
            return false;
        }
        if (this.zzchi == null) {
            if (com_google_android_gms_internal_zzahb.zzchi != null) {
                return false;
            }
        } else if (!this.zzchi.equals(com_google_android_gms_internal_zzahb.zzchi)) {
            return false;
        }
        if (this.zzcqo == null || this.zzcqo.isEmpty()) {
            return com_google_android_gms_internal_zzahb.zzcqo == null || com_google_android_gms_internal_zzahb.zzcqo.isEmpty();
        } else {
            return this.zzcqo.equals(com_google_android_gms_internal_zzahb.zzcqo);
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.zzchi == null ? 0 : this.zzchi.hashCode()) + (((this.zzchh == null ? 0 : this.zzchh.hashCode()) + (((this.zzchg == null ? 0 : this.zzchg.hashCode()) + (((this.zzchf == null ? 0 : this.zzchf.hashCode()) + (((this.zzche == null ? 0 : this.zzche.hashCode()) + (((((this.zzchc == null ? 0 : this.zzchc.hashCode()) + (((this.zzKv == null ? 0 : this.zzKv.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + this.zzchd) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.zzcqo == null || this.zzcqo.isEmpty())) {
            i = this.zzcqo.hashCode();
        }
        return hashCode + i;
    }

    public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        return zzau(com_google_android_gms_internal_zzaie);
    }

    public void writeTo(zzaif output) throws IOException {
        if (!this.zzKv.equals("")) {
            output.zzo(1, this.zzKv);
        }
        if (this.zzchc != null) {
            output.zza(2, this.zzchc);
        }
        if (this.zzchd != 0) {
            output.zzR(3, this.zzchd);
        }
        if (!this.zzche.equals("")) {
            output.zzo(4, this.zzche);
        }
        if (!this.zzchf.equals("")) {
            output.zzo(5, this.zzchf);
        }
        if (this.zzchg != null) {
            output.zza(6, this.zzchg);
        }
        if (this.zzchh != null) {
            output.zza(7, this.zzchh);
        }
        if (this.zzchi != null) {
            output.zza(8, this.zzchi);
        }
        super.writeTo(output);
    }

    public zzahb zzPX() {
        this.zzKv = "";
        this.zzchc = null;
        this.zzchd = 0;
        this.zzche = "";
        this.zzchf = "";
        this.zzchg = null;
        this.zzchh = null;
        this.zzchi = null;
        this.zzcqo = null;
        this.zzcqy = -1;
        return this;
    }

    public zzahb zzau(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        while (true) {
            int zzRp = com_google_android_gms_internal_zzaie.zzRp();
            switch (zzRp) {
                case 0:
                    break;
                case 10:
                    this.zzKv = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case 18:
                    if (this.zzchc == null) {
                        this.zzchc = new zzd();
                    }
                    com_google_android_gms_internal_zzaie.zza(this.zzchc);
                    continue;
                case 24:
                    this.zzchd = com_google_android_gms_internal_zzaie.zzRt();
                    continue;
                case 34:
                    this.zzche = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                    this.zzchf = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case 50:
                    if (this.zzchg == null) {
                        this.zzchg = new zzb();
                    }
                    com_google_android_gms_internal_zzaie.zza(this.zzchg);
                    continue;
                case 58:
                    if (this.zzchh == null) {
                        this.zzchh = new zza();
                    }
                    com_google_android_gms_internal_zzaie.zza(this.zzchh);
                    continue;
                case 66:
                    if (this.zzchi == null) {
                        this.zzchi = new zzc();
                    }
                    com_google_android_gms_internal_zzaie.zza(this.zzchi);
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

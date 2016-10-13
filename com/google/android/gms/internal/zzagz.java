package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzagz extends zzaig<zzagz> {
    public zzagx zzcgU;
    public String zzcgV;
    public int[] zzcgW;
    public int zzcgX;
    public int zzcgY;
    public zzahb zzcgZ;
    public zzagy[] zzcha;

    public zzagz() {
        zzPV();
    }

    protected int computeSerializedSize() {
        int i;
        int i2 = 0;
        int computeSerializedSize = super.computeSerializedSize();
        if (this.zzcgW == null || this.zzcgW.length <= 0) {
            i = computeSerializedSize;
        } else {
            int i3 = 0;
            for (int zztf : this.zzcgW) {
                i3 += zzaif.zztf(zztf);
            }
            i = (computeSerializedSize + i3) + (this.zzcgW.length * 1);
        }
        if (this.zzcgX != 0) {
            i += zzaif.zzT(2, this.zzcgX);
        }
        if (this.zzcgY != 0) {
            i += zzaif.zzT(3, this.zzcgY);
        }
        if (this.zzcgZ != null) {
            i += zzaif.zzc(4, this.zzcgZ);
        }
        if (this.zzcgU != null) {
            i += zzaif.zzc(5, this.zzcgU);
        }
        if (!this.zzcgV.equals("")) {
            i += zzaif.zzp(6, this.zzcgV);
        }
        if (this.zzcha != null && this.zzcha.length > 0) {
            while (i2 < this.zzcha.length) {
                zzain com_google_android_gms_internal_zzain = this.zzcha[i2];
                if (com_google_android_gms_internal_zzain != null) {
                    i += zzaif.zzc(7, com_google_android_gms_internal_zzain);
                }
                i2++;
            }
        }
        return i;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzagz)) {
            return false;
        }
        zzagz com_google_android_gms_internal_zzagz = (zzagz) o;
        if (this.zzcgU == null) {
            if (com_google_android_gms_internal_zzagz.zzcgU != null) {
                return false;
            }
        } else if (!this.zzcgU.equals(com_google_android_gms_internal_zzagz.zzcgU)) {
            return false;
        }
        if (this.zzcgV == null) {
            if (com_google_android_gms_internal_zzagz.zzcgV != null) {
                return false;
            }
        } else if (!this.zzcgV.equals(com_google_android_gms_internal_zzagz.zzcgV)) {
            return false;
        }
        if (!zzail.equals(this.zzcgW, com_google_android_gms_internal_zzagz.zzcgW) || this.zzcgX != com_google_android_gms_internal_zzagz.zzcgX || this.zzcgY != com_google_android_gms_internal_zzagz.zzcgY) {
            return false;
        }
        if (this.zzcgZ == null) {
            if (com_google_android_gms_internal_zzagz.zzcgZ != null) {
                return false;
            }
        } else if (!this.zzcgZ.equals(com_google_android_gms_internal_zzagz.zzcgZ)) {
            return false;
        }
        if (!zzail.equals(this.zzcha, com_google_android_gms_internal_zzagz.zzcha)) {
            return false;
        }
        if (this.zzcqo == null || this.zzcqo.isEmpty()) {
            return com_google_android_gms_internal_zzagz.zzcqo == null || com_google_android_gms_internal_zzagz.zzcqo.isEmpty();
        } else {
            return this.zzcqo.equals(com_google_android_gms_internal_zzagz.zzcqo);
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.zzcgZ == null ? 0 : this.zzcgZ.hashCode()) + (((((((((this.zzcgV == null ? 0 : this.zzcgV.hashCode()) + (((this.zzcgU == null ? 0 : this.zzcgU.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + zzail.hashCode(this.zzcgW)) * 31) + this.zzcgX) * 31) + this.zzcgY) * 31)) * 31) + zzail.hashCode(this.zzcha)) * 31;
        if (!(this.zzcqo == null || this.zzcqo.isEmpty())) {
            i = this.zzcqo.hashCode();
        }
        return hashCode + i;
    }

    public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        return zzas(com_google_android_gms_internal_zzaie);
    }

    public void writeTo(zzaif output) throws IOException {
        int i = 0;
        if (this.zzcgW != null && this.zzcgW.length > 0) {
            for (int zzR : this.zzcgW) {
                output.zzR(1, zzR);
            }
        }
        if (this.zzcgX != 0) {
            output.zzR(2, this.zzcgX);
        }
        if (this.zzcgY != 0) {
            output.zzR(3, this.zzcgY);
        }
        if (this.zzcgZ != null) {
            output.zza(4, this.zzcgZ);
        }
        if (this.zzcgU != null) {
            output.zza(5, this.zzcgU);
        }
        if (!this.zzcgV.equals("")) {
            output.zzo(6, this.zzcgV);
        }
        if (this.zzcha != null && this.zzcha.length > 0) {
            while (i < this.zzcha.length) {
                zzain com_google_android_gms_internal_zzain = this.zzcha[i];
                if (com_google_android_gms_internal_zzain != null) {
                    output.zza(7, com_google_android_gms_internal_zzain);
                }
                i++;
            }
        }
        super.writeTo(output);
    }

    public zzagz zzPV() {
        this.zzcgU = null;
        this.zzcgV = "";
        this.zzcgW = zzaiq.zzcqA;
        this.zzcgX = 0;
        this.zzcgY = 0;
        this.zzcgZ = null;
        this.zzcha = zzagy.zzPS();
        this.zzcqo = null;
        this.zzcqy = -1;
        return this;
    }

    public zzagz zzas(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        while (true) {
            int zzRp = com_google_android_gms_internal_zzaie.zzRp();
            int zzc;
            Object obj;
            switch (zzRp) {
                case 0:
                    break;
                case 8:
                    zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 8);
                    zzRp = this.zzcgW == null ? 0 : this.zzcgW.length;
                    obj = new int[(zzc + zzRp)];
                    if (zzRp != 0) {
                        System.arraycopy(this.zzcgW, 0, obj, 0, zzRp);
                    }
                    while (zzRp < obj.length - 1) {
                        obj[zzRp] = com_google_android_gms_internal_zzaie.zzRt();
                        com_google_android_gms_internal_zzaie.zzRp();
                        zzRp++;
                    }
                    obj[zzRp] = com_google_android_gms_internal_zzaie.zzRt();
                    this.zzcgW = obj;
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
                    zzc = this.zzcgW == null ? 0 : this.zzcgW.length;
                    Object obj2 = new int[(zzRp + zzc)];
                    if (zzc != 0) {
                        System.arraycopy(this.zzcgW, 0, obj2, 0, zzc);
                    }
                    while (zzc < obj2.length) {
                        obj2[zzc] = com_google_android_gms_internal_zzaie.zzRt();
                        zzc++;
                    }
                    this.zzcgW = obj2;
                    com_google_android_gms_internal_zzaie.zzsZ(zzsY);
                    continue;
                case 16:
                    zzRp = com_google_android_gms_internal_zzaie.zzRt();
                    switch (zzRp) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            this.zzcgX = zzRp;
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
                            this.zzcgY = zzRp;
                            break;
                        default:
                            continue;
                    }
                case 34:
                    if (this.zzcgZ == null) {
                        this.zzcgZ = new zzahb();
                    }
                    com_google_android_gms_internal_zzaie.zza(this.zzcgZ);
                    continue;
                case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                    if (this.zzcgU == null) {
                        this.zzcgU = new zzagx();
                    }
                    com_google_android_gms_internal_zzaie.zza(this.zzcgU);
                    continue;
                case 50:
                    this.zzcgV = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case 58:
                    zzc = zzaiq.zzc(com_google_android_gms_internal_zzaie, 58);
                    zzRp = this.zzcha == null ? 0 : this.zzcha.length;
                    obj = new zzagy[(zzc + zzRp)];
                    if (zzRp != 0) {
                        System.arraycopy(this.zzcha, 0, obj, 0, zzRp);
                    }
                    while (zzRp < obj.length - 1) {
                        obj[zzRp] = new zzagy();
                        com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                        com_google_android_gms_internal_zzaie.zzRp();
                        zzRp++;
                    }
                    obj[zzRp] = new zzagy();
                    com_google_android_gms_internal_zzaie.zza(obj[zzRp]);
                    this.zzcha = obj;
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

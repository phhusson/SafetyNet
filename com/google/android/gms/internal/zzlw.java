package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.playlog.PlayLogger.LogSource;
import java.io.IOException;

public final class zzlw extends zzain {
    private static volatile zzlw[] zzacO;
    public String name;
    public String path;
    public String value;
    public String zzacP;
    public String zzacQ;
    public Boolean zzacR;
    public Boolean zzacS;
    public Integer zzacT;
    public Integer zzacU;

    public zzlw() {
        zzln();
    }

    public static zzlw[] zzlm() {
        if (zzacO == null) {
            synchronized (zzail.zzcqx) {
                if (zzacO == null) {
                    zzacO = new zzlw[0];
                }
            }
        }
        return zzacO;
    }

    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (this.name != null) {
            computeSerializedSize += zzaif.zzp(1, this.name);
        }
        if (this.value != null) {
            computeSerializedSize += zzaif.zzp(2, this.value);
        }
        if (this.zzacP != null) {
            computeSerializedSize += zzaif.zzp(3, this.zzacP);
        }
        if (this.zzacQ != null) {
            computeSerializedSize += zzaif.zzp(4, this.zzacQ);
        }
        if (this.path != null) {
            computeSerializedSize += zzaif.zzp(5, this.path);
        }
        if (this.zzacR != null) {
            computeSerializedSize += zzaif.zzi(6, this.zzacR.booleanValue());
        }
        if (this.zzacS != null) {
            computeSerializedSize += zzaif.zzi(7, this.zzacS.booleanValue());
        }
        if (this.zzacT != null) {
            computeSerializedSize += zzaif.zzT(8, this.zzacT.intValue());
        }
        return this.zzacU != null ? computeSerializedSize + zzaif.zzT(9, this.zzacU.intValue()) : computeSerializedSize;
    }

    public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        return zzm(com_google_android_gms_internal_zzaie);
    }

    public void writeTo(zzaif output) throws IOException {
        if (this.name != null) {
            output.zzo(1, this.name);
        }
        if (this.value != null) {
            output.zzo(2, this.value);
        }
        if (this.zzacP != null) {
            output.zzo(3, this.zzacP);
        }
        if (this.zzacQ != null) {
            output.zzo(4, this.zzacQ);
        }
        if (this.path != null) {
            output.zzo(5, this.path);
        }
        if (this.zzacR != null) {
            output.zzh(6, this.zzacR.booleanValue());
        }
        if (this.zzacS != null) {
            output.zzh(7, this.zzacS.booleanValue());
        }
        if (this.zzacT != null) {
            output.zzR(8, this.zzacT.intValue());
        }
        if (this.zzacU != null) {
            output.zzR(9, this.zzacU.intValue());
        }
        super.writeTo(output);
    }

    public zzlw zzln() {
        this.name = null;
        this.value = null;
        this.zzacP = null;
        this.zzacQ = null;
        this.path = null;
        this.zzacR = null;
        this.zzacS = null;
        this.zzacT = null;
        this.zzacU = null;
        this.zzcqy = -1;
        return this;
    }

    public zzlw zzm(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        while (true) {
            int zzRp = com_google_android_gms_internal_zzaie.zzRp();
            switch (zzRp) {
                case 0:
                    break;
                case 10:
                    this.name = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case 18:
                    this.value = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case LogSource.ANDROID_CAMERA /*26*/:
                    this.zzacP = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case 34:
                    this.zzacQ = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                    this.path = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case 48:
                    this.zzacR = Boolean.valueOf(com_google_android_gms_internal_zzaie.zzRv());
                    continue;
                case 56:
                    this.zzacS = Boolean.valueOf(com_google_android_gms_internal_zzaie.zzRv());
                    continue;
                case 64:
                    this.zzacT = Integer.valueOf(com_google_android_gms_internal_zzaie.zzRt());
                    continue;
                case 72:
                    zzRp = com_google_android_gms_internal_zzaie.zzRt();
                    switch (zzRp) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            this.zzacU = Integer.valueOf(zzRp);
                            break;
                        default:
                            continue;
                    }
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

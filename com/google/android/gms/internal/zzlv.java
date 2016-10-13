package com.google.android.gms.internal;

import com.google.android.gms.playlog.PlayLogger.LogSource;
import java.io.IOException;

public final class zzlv extends zzain {
    private static volatile zzlv[] zzacD;
    public String pageId;
    public Integer zzacE;
    public String zzacF;
    public String zzacG;
    public String zzacH;
    public Boolean zzacI;
    public Boolean zzacJ;
    public Integer zzacK;
    public Boolean zzacL;
    public String zzacM;
    public Boolean zzacN;

    public zzlv() {
        zzll();
    }

    public static zzlv[] zzlk() {
        if (zzacD == null) {
            synchronized (zzail.zzcqx) {
                if (zzacD == null) {
                    zzacD = new zzlv[0];
                }
            }
        }
        return zzacD;
    }

    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (this.zzacE != null) {
            computeSerializedSize += zzaif.zzT(1, this.zzacE.intValue());
        }
        if (this.zzacF != null) {
            computeSerializedSize += zzaif.zzp(2, this.zzacF);
        }
        if (this.zzacG != null) {
            computeSerializedSize += zzaif.zzp(3, this.zzacG);
        }
        if (this.zzacH != null) {
            computeSerializedSize += zzaif.zzp(4, this.zzacH);
        }
        if (this.zzacI != null) {
            computeSerializedSize += zzaif.zzi(5, this.zzacI.booleanValue());
        }
        if (this.zzacJ != null) {
            computeSerializedSize += zzaif.zzi(6, this.zzacJ.booleanValue());
        }
        if (this.zzacK != null) {
            computeSerializedSize += zzaif.zzT(7, this.zzacK.intValue());
        }
        if (this.pageId != null) {
            computeSerializedSize += zzaif.zzp(8, this.pageId);
        }
        if (this.zzacL != null) {
            computeSerializedSize += zzaif.zzi(9, this.zzacL.booleanValue());
        }
        if (this.zzacM != null) {
            computeSerializedSize += zzaif.zzp(10, this.zzacM);
        }
        return this.zzacN != null ? computeSerializedSize + zzaif.zzi(11, this.zzacN.booleanValue()) : computeSerializedSize;
    }

    public /* synthetic */ zzain mergeFrom(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        return zzl(com_google_android_gms_internal_zzaie);
    }

    public void writeTo(zzaif output) throws IOException {
        if (this.zzacE != null) {
            output.zzR(1, this.zzacE.intValue());
        }
        if (this.zzacF != null) {
            output.zzo(2, this.zzacF);
        }
        if (this.zzacG != null) {
            output.zzo(3, this.zzacG);
        }
        if (this.zzacH != null) {
            output.zzo(4, this.zzacH);
        }
        if (this.zzacI != null) {
            output.zzh(5, this.zzacI.booleanValue());
        }
        if (this.zzacJ != null) {
            output.zzh(6, this.zzacJ.booleanValue());
        }
        if (this.zzacK != null) {
            output.zzR(7, this.zzacK.intValue());
        }
        if (this.pageId != null) {
            output.zzo(8, this.pageId);
        }
        if (this.zzacL != null) {
            output.zzh(9, this.zzacL.booleanValue());
        }
        if (this.zzacM != null) {
            output.zzo(10, this.zzacM);
        }
        if (this.zzacN != null) {
            output.zzh(11, this.zzacN.booleanValue());
        }
        super.writeTo(output);
    }

    public zzlv zzl(zzaie com_google_android_gms_internal_zzaie) throws IOException {
        while (true) {
            int zzRp = com_google_android_gms_internal_zzaie.zzRp();
            switch (zzRp) {
                case 0:
                    break;
                case 8:
                    zzRp = com_google_android_gms_internal_zzaie.zzRt();
                    switch (zzRp) {
                        case 1:
                        case 2:
                        case 3:
                            this.zzacE = Integer.valueOf(zzRp);
                            break;
                        default:
                            continue;
                    }
                case 18:
                    this.zzacF = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case LogSource.ANDROID_CAMERA /*26*/:
                    this.zzacG = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case 34:
                    this.zzacH = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case 40:
                    this.zzacI = Boolean.valueOf(com_google_android_gms_internal_zzaie.zzRv());
                    continue;
                case 48:
                    this.zzacJ = Boolean.valueOf(com_google_android_gms_internal_zzaie.zzRv());
                    continue;
                case 56:
                    this.zzacK = Integer.valueOf(com_google_android_gms_internal_zzaie.zzRt());
                    continue;
                case 66:
                    this.pageId = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case 72:
                    this.zzacL = Boolean.valueOf(com_google_android_gms_internal_zzaie.zzRv());
                    continue;
                case 82:
                    this.zzacM = com_google_android_gms_internal_zzaie.readString();
                    continue;
                case 88:
                    this.zzacN = Boolean.valueOf(com_google_android_gms_internal_zzaie.zzRv());
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

    public zzlv zzll() {
        this.zzacE = null;
        this.zzacF = null;
        this.zzacG = null;
        this.zzacH = null;
        this.zzacI = null;
        this.zzacJ = null;
        this.zzacK = null;
        this.pageId = null;
        this.zzacL = null;
        this.zzacM = null;
        this.zzacN = null;
        this.zzcqy = -1;
        return this;
    }
}

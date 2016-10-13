package com.google.android.gms.playlog.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzaiu.zzd;
import java.util.ArrayList;

public class zzb {
    private final ArrayList<zza> zzbLE;
    private int zzbLF;

    public static class zza {
        public final PlayLoggerContext zzbLG;
        public final LogEvent zzbLH;
        public final zzd zzbLI;

        private zza(PlayLoggerContext playLoggerContext, zzd com_google_android_gms_internal_zzaiu_zzd) {
            this.zzbLG = (PlayLoggerContext) zzx.zzD(playLoggerContext);
            this.zzbLH = null;
            this.zzbLI = (zzd) zzx.zzD(com_google_android_gms_internal_zzaiu_zzd);
        }

        private zza(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
            this.zzbLG = (PlayLoggerContext) zzx.zzD(playLoggerContext);
            this.zzbLH = (LogEvent) zzx.zzD(logEvent);
            this.zzbLI = null;
        }
    }

    public zzb() {
        this(100);
    }

    public zzb(int i) {
        this.zzbLE = new ArrayList();
        this.zzbLF = i;
    }

    private void zzKc() {
        while (getSize() > getCapacity()) {
            this.zzbLE.remove(0);
        }
    }

    public void clear() {
        this.zzbLE.clear();
    }

    public int getCapacity() {
        return this.zzbLF;
    }

    public int getSize() {
        return this.zzbLE.size();
    }

    public boolean isEmpty() {
        return this.zzbLE.isEmpty();
    }

    public boolean isFull() {
        return getSize() >= getCapacity();
    }

    public ArrayList<zza> zzKb() {
        return this.zzbLE;
    }

    public void zza(PlayLoggerContext playLoggerContext, zzd com_google_android_gms_internal_zzaiu_zzd) {
        this.zzbLE.add(new zza(playLoggerContext, com_google_android_gms_internal_zzaiu_zzd));
        zzKc();
    }

    public void zza(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzbLE.add(new zza(playLoggerContext, logEvent));
        zzKc();
    }

    public void zzoh(int i) {
        this.zzbLF = i;
        zzKc();
    }
}

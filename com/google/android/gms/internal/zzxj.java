package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public final class zzxj implements Optional {
    public static final zzxj zzbTI = new zza().zzLx();
    private final boolean zzYJ;
    private final boolean zzYL;
    private final String zzYM;
    private final String zzYN;
    private final boolean zzbTJ;
    private final boolean zzbTK;

    public static final class zza {
        private String zzbLP;
        private boolean zzbTL;
        private boolean zzbTM;
        private boolean zzbTN;
        private String zzbTO;
        private boolean zzbTP;

        public zzxj zzLx() {
            return new zzxj(this.zzbTL, this.zzbTM, this.zzbLP, this.zzbTN, this.zzbTO, this.zzbTP);
        }
    }

    private zzxj(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4) {
        this.zzbTJ = z;
        this.zzYJ = z2;
        this.zzYM = str;
        this.zzYL = z3;
        this.zzbTK = z4;
        this.zzYN = str2;
    }

    public boolean zzLv() {
        return this.zzbTJ;
    }

    public boolean zzLw() {
        return this.zzbTK;
    }

    public boolean zzkB() {
        return this.zzYL;
    }

    public String zzkC() {
        return this.zzYM;
    }

    @Nullable
    public String zzkD() {
        return this.zzYN;
    }

    public boolean zzkz() {
        return this.zzYJ;
    }
}

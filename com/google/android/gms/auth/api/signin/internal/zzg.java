package com.google.android.gms.auth.api.signin.internal;

public class zzg {
    static int zzZg = 31;
    private int zzZh = 1;

    public zzg zzI(boolean z) {
        this.zzZh = (z ? 1 : 0) + (this.zzZh * zzZg);
        return this;
    }

    public int zzkM() {
        return this.zzZh;
    }

    public zzg zzs(Object obj) {
        this.zzZh = (obj == null ? 0 : obj.hashCode()) + (this.zzZh * zzZg);
        return this;
    }
}

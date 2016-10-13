package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import com.google.android.gms.common.internal.zzw;

public final class zznr extends LruCache<zza, Drawable> {

    public static final class zza {
        public final int zzavl;
        public final int zzavm;

        public zza(int i, int i2) {
            this.zzavl = i;
            this.zzavm = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza com_google_android_gms_internal_zznr_zza = (zza) obj;
            return com_google_android_gms_internal_zznr_zza.zzavl == this.zzavl && com_google_android_gms_internal_zznr_zza.zzavm == this.zzavm;
        }

        public int hashCode() {
            return zzw.hashCode(Integer.valueOf(this.zzavl), Integer.valueOf(this.zzavm));
        }
    }

    public zznr() {
        super(10);
    }
}

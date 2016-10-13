package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzw {

    public static final class zza {
        private final Object zzNd;
        private final List<String> zzawZ;

        private zza(Object obj) {
            this.zzNd = zzx.zzD(obj);
            this.zzawZ = new ArrayList();
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.zzNd.getClass().getSimpleName()).append('{');
            int size = this.zzawZ.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.zzawZ.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }

        public zza zzh(String str, Object obj) {
            this.zzawZ.add(((String) zzx.zzD(str)) + "=" + String.valueOf(obj));
            return this;
        }
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }

    public static zza zzC(Object obj) {
        return new zza(obj);
    }
}

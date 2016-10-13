package com.google.android.gms.people.internal;

import com.google.android.snet.Csv;
import java.util.ArrayList;

public class zzt {
    private final String mLabel;
    private final ArrayList<Long> zzbFf;
    private final ArrayList<String> zzbFg;

    private static class zza extends zzt {
        public static final zza zzbFh = new zza();

        public zza() {
            super(null);
        }

        public void zzE(String str, int i) {
        }

        public void zzia(String str) {
        }
    }

    private zzt(String str) {
        this.zzbFf = new ArrayList();
        this.zzbFg = new ArrayList();
        this.mLabel = str;
        zzia("");
    }

    public static zzt zzJC() {
        return zza.zzbFh;
    }

    public static zzt zzhZ(String str) {
        return new zzt(str);
    }

    public synchronized void zzE(String str, int i) {
        zzia("");
        long longValue = ((Long) this.zzbFf.get(0)).longValue();
        long longValue2 = ((Long) this.zzbFf.get(this.zzbFf.size() - 1)).longValue() - longValue;
        if (longValue2 >= ((long) i)) {
            StringBuilder zzJz = zzp.zzJz();
            zzJz.append(this.mLabel);
            zzJz.append(Csv.COMMA);
            zzJz.append(longValue2);
            zzJz.append("ms: ");
            int i2 = 1;
            while (i2 < this.zzbFf.size()) {
                long longValue3 = ((Long) this.zzbFf.get(i2)).longValue();
                zzJz.append((String) this.zzbFg.get(i2));
                zzJz.append(Csv.COMMA);
                zzJz.append(longValue3 - longValue);
                zzJz.append("ms ");
                i2++;
                longValue = longValue3;
            }
            zzo.zzaj(str, zzJz.toString());
        }
    }

    public synchronized void zzia(String str) {
        this.zzbFf.add(Long.valueOf(System.currentTimeMillis()));
        this.zzbFg.add(str);
    }
}

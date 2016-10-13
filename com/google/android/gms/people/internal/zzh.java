package com.google.android.gms.people.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.snet.Csv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class zzh {
    private static final Integer[] zzbDY = new Integer[0];
    private final HashMap<Integer, Object> zzoP = new HashMap();

    private Integer[] zzJk() {
        Integer[] numArr = (Integer[]) new ArrayList(this.zzoP.keySet()).toArray(zzbDY);
        Arrays.sort(numArr);
        return numArr;
    }

    public String toString() {
        StringBuilder zzJz = zzp.zzJz();
        for (Integer num : zzJk()) {
            if (zzJz.length() > 0) {
                zzJz.append(Csv.COMMA);
            }
            zzJz.append(num);
            zzJz.append("=");
            int zznu = zznu(num.intValue());
            for (int i = 0; i < zznu; i++) {
                if (i > 0) {
                    zzJz.append(".");
                }
                zzJz.append(zzI(num.intValue(), i));
            }
            zzJz.append("");
        }
        return zzJz.toString();
    }

    public String zzI(int i, int i2) {
        zzx.zzD(Integer.valueOf(i));
        zzx.zzae(i2 >= 0);
        Object obj = this.zzoP.get(Integer.valueOf(i));
        if (obj == null) {
            throw new IndexOutOfBoundsException("Size=0, requested=" + i2);
        } else if (!(obj instanceof String)) {
            ArrayList arrayList = (ArrayList) obj;
            if (i2 <= arrayList.size()) {
                return (String) arrayList.get(i2);
            }
            throw new IndexOutOfBoundsException("Size=" + arrayList.size() + ", requested=" + i2);
        } else if (i2 <= 0) {
            return (String) obj;
        } else {
            throw new IndexOutOfBoundsException("Size=1, requested=" + i2);
        }
    }

    public void zza(Integer num, String str) {
        zzx.zzD(num);
        Object obj = this.zzoP.get(num);
        if (obj == null) {
            this.zzoP.put(num, str);
        } else if (obj instanceof String) {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add((String) obj);
            arrayList.add(str);
            this.zzoP.put(num, arrayList);
        } else {
            ((ArrayList) obj).add(str);
        }
    }

    public int zznu(int i) {
        zzx.zzD(Integer.valueOf(i));
        Object obj = this.zzoP.get(Integer.valueOf(i));
        return obj == null ? 0 : obj instanceof String ? 1 : ((ArrayList) obj).size();
    }
}

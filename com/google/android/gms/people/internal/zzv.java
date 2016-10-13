package com.google.android.gms.people.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.snet.Csv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class zzv<T> {
    private final HashMap<String, Object> zzoP = new HashMap();

    private String[] zzJD() {
        String[] strArr = (String[]) new ArrayList(this.zzoP.keySet()).toArray(zzp.zzbEP);
        Arrays.sort(strArr);
        return strArr;
    }

    public void put(String key, T value) {
        zzx.zzD(key);
        Object obj = this.zzoP.get(key);
        if (obj == null) {
            this.zzoP.put(key, value);
        } else if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(value);
        } else {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(value);
            this.zzoP.put(key, arrayList);
        }
    }

    public String toString() {
        StringBuilder zzJz = zzp.zzJz();
        for (String str : zzJD()) {
            if (zzJz.length() > 0) {
                zzJz.append(Csv.COMMA);
            }
            zzJz.append(str);
            zzJz.append("=");
            int zzib = zzib(str);
            for (int i = 0; i < zzib; i++) {
                if (i > 0) {
                    zzJz.append(".");
                }
                zzJz.append(zzG(str, i));
            }
            zzJz.append("");
        }
        return zzJz.toString();
    }

    public T zzG(String str, int i) {
        zzx.zzD(str);
        zzx.zzae(i >= 0);
        T t = this.zzoP.get(str);
        if (t == null) {
            throw new IndexOutOfBoundsException("Size=0, requested=" + i);
        } else if (t instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) t;
            if (i <= arrayList.size()) {
                return arrayList.get(i);
            }
            throw new IndexOutOfBoundsException("Size=" + arrayList.size() + ", requested=" + i);
        } else if (i <= 0) {
            return t;
        } else {
            throw new IndexOutOfBoundsException("Size=1, requested=" + i);
        }
    }

    public int zzib(String str) {
        zzx.zzD(str);
        Object obj = this.zzoP.get(str);
        return obj == null ? 0 : obj instanceof ArrayList ? ((ArrayList) obj).size() : 1;
    }
}

package com.google.android.gms.people.internal;

import com.google.android.snet.Csv;
import java.util.ArrayList;

public class zzi {
    private final ArrayList<Object> zzbDZ = new ArrayList();

    private static IndexOutOfBoundsException zzJ(int i, int i2) {
        return new IndexOutOfBoundsException(String.format("Size=%d, requested=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public int get(int outerIndex, int innerIndex) {
        Object obj = this.zzbDZ.get(outerIndex);
        if (obj == null) {
            throw zzJ(0, innerIndex);
        } else if (!(obj instanceof Integer)) {
            ArrayList arrayList = (ArrayList) obj;
            if (innerIndex <= arrayList.size()) {
                return ((Integer) arrayList.get(innerIndex)).intValue();
            }
            throw zzJ(arrayList.size(), innerIndex);
        } else if (innerIndex <= 0) {
            return ((Integer) obj).intValue();
        } else {
            throw zzJ(1, innerIndex);
        }
    }

    public int size() {
        return this.zzbDZ.size();
    }

    public String toString() {
        StringBuilder zzJz = zzp.zzJz();
        for (int i = 0; i < size(); i++) {
            if (i > 0) {
                zzJz.append(Csv.COMMA);
            }
            zzJz.append("[");
            int zznu = zznu(i);
            for (int i2 = 0; i2 < zznu; i2++) {
                if (i2 > 0) {
                    zzJz.append(Csv.COMMA);
                }
                zzJz.append(get(i, i2));
            }
            zzJz.append("]");
        }
        return zzJz.toString();
    }

    public void zzJl() {
        this.zzbDZ.add(null);
    }

    public void zza(zzu com_google_android_gms_people_internal_zzu, String str) {
        int i = 0;
        int zzib = com_google_android_gms_people_internal_zzu.zzib(str);
        if (zzib != 0) {
            if (zzib == 1) {
                this.zzbDZ.add(Integer.valueOf(com_google_android_gms_people_internal_zzu.zzF(str, 0)));
                return;
            }
            ArrayList arrayList = new ArrayList(zzib);
            while (i < zzib) {
                arrayList.add(Integer.valueOf(com_google_android_gms_people_internal_zzu.zzF(str, i)));
                i++;
            }
            this.zzbDZ.add(arrayList);
        }
    }

    public int zznu(int i) {
        Object obj = this.zzbDZ.get(i);
        return obj == null ? 0 : obj instanceof Integer ? 1 : ((ArrayList) obj).size();
    }

    public void zznv(int i) {
        this.zzbDZ.add(Integer.valueOf(i));
    }
}

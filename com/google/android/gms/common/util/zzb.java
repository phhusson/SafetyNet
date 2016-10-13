package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.zzw;
import com.google.android.snet.Csv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public final class zzb {
    public static <T> int zza(T[] tArr, T t) {
        int i = 0;
        int length = tArr != null ? tArr.length : 0;
        while (i < length) {
            if (zzw.equal(tArr[i], t)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void zza(StringBuilder stringBuilder, double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Csv.COMMA);
            }
            stringBuilder.append(Double.toString(dArr[i]));
        }
    }

    public static void zza(StringBuilder stringBuilder, float[] fArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Csv.COMMA);
            }
            stringBuilder.append(Float.toString(fArr[i]));
        }
    }

    public static void zza(StringBuilder stringBuilder, int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Csv.COMMA);
            }
            stringBuilder.append(Integer.toString(iArr[i]));
        }
    }

    public static void zza(StringBuilder stringBuilder, long[] jArr) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Csv.COMMA);
            }
            stringBuilder.append(Long.toString(jArr[i]));
        }
    }

    public static <T> void zza(StringBuilder stringBuilder, T[] tArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Csv.COMMA);
            }
            stringBuilder.append(tArr[i].toString());
        }
    }

    public static void zza(StringBuilder stringBuilder, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Csv.COMMA);
            }
            stringBuilder.append("\"").append(strArr[i]).append("\"");
        }
    }

    public static void zza(StringBuilder stringBuilder, boolean[] zArr) {
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(Csv.COMMA);
            }
            stringBuilder.append(Boolean.toString(zArr[i]));
        }
    }

    public static byte[] zza(byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int i;
        int i2 = 0;
        for (byte[] length : bArr) {
            i2 += length.length;
        }
        Object copyOf = Arrays.copyOf(bArr[0], i2);
        i2 = bArr[0].length;
        for (i = 1; i < bArr.length; i++) {
            Object obj = bArr[i];
            System.arraycopy(obj, 0, copyOf, i2, obj.length);
            i2 += obj.length;
        }
        return copyOf;
    }

    public static Integer[] zza(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    public static <T> ArrayList<T> zzb(T[] tArr) {
        ArrayList<T> arrayList = new ArrayList(r1);
        for (Object add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static <T> boolean zzb(T[] tArr, T t) {
        return zza((Object[]) tArr, (Object) t) >= 0;
    }

    public static <T> ArrayList<T> zze(Collection<T> collection) {
        return collection == null ? null : new ArrayList(collection);
    }

    public static int[] zzf(Collection<Integer> collection) {
        if (collection == null || collection.size() == 0) {
            return new int[0];
        }
        int[] iArr = new int[collection.size()];
        int i = 0;
        for (Integer intValue : collection) {
            int i2 = i + 1;
            iArr[i] = intValue.intValue();
            i = i2;
        }
        return iArr;
    }

    public static <T> ArrayList<T> zzsf() {
        return new ArrayList();
    }
}

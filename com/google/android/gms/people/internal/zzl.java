package com.google.android.gms.people.internal;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;

public class zzl {
    public static boolean isEnabled() {
        return Log.isLoggable("PeopleClientCall", 3);
    }

    public static String zzd(Object... objArr) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        zzx.zzae(objArr.length % 2 == 0);
        String str = "";
        while (i < objArr.length) {
            stringBuilder.append(str);
            stringBuilder.append(objArr[i]);
            stringBuilder.append("=");
            stringBuilder.append(objArr[i + 1]);
            str = ", ";
            i += 2;
        }
        return stringBuilder.toString();
    }

    public static void zzh(String str, Object... objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("(");
        String str2 = "";
        for (Object obj : objArr) {
            stringBuilder.append(str2);
            if (obj instanceof Bundle) {
                stringBuilder.append(zzp.zzW((Bundle) obj));
            } else {
                stringBuilder.append(obj);
            }
            str2 = ", ";
        }
        stringBuilder.append(")");
        Log.d("PeopleClientCall", stringBuilder.toString(), Log.isLoggable("PeopleClientCall", 2) ? new Throwable("STACK TRACE (It's not crash!)") : null);
    }
}

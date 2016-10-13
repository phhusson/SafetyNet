package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.playlog.OneTimePlayLogger;
import com.google.android.snet.Csv;

public final class zzo {
    public static final int zzawV = (23 - " PII_LOG".length());
    private static final String zzawW = null;
    private final String zzawX;
    private final String zzawY;

    public zzo(String str) {
        this(str, zzawW);
    }

    public zzo(String str, String str2) {
        zzx.zzb((Object) str, (Object) "log tag cannot be null");
        zzx.zzb(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, Integer.valueOf(23));
        this.zzawX = str;
        if (str2 == null || str2.length() <= 0) {
            this.zzawY = zzawW;
        } else {
            this.zzawY = str2;
        }
    }

    private String zzcJ(String str) {
        return this.zzawY == null ? str : this.zzawY.concat(str);
    }

    public void zzG(String str, String str2) {
        if (zzdl(3)) {
            Log.d(str, zzcJ(str2));
        }
    }

    public void zzH(String str, String str2) {
        if (zzdl(4)) {
            Log.i(str, zzcJ(str2));
        }
    }

    public void zzI(String str, String str2) {
        if (zzdl(5)) {
            Log.w(str, zzcJ(str2));
        }
    }

    public void zzJ(String str, String str2) {
        if (zzdl(6)) {
            Log.e(str, zzcJ(str2));
        }
    }

    public void zza(Context context, String str, String str2, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < stackTrace.length && i < 2) {
            stringBuilder.append(stackTrace[i].toString());
            stringBuilder.append(Csv.NEWLINE);
            i++;
        }
        OneTimePlayLogger oneTimePlayLogger = new OneTimePlayLogger(context, 10);
        oneTimePlayLogger.cacheLogEvent("GMS_WTF", null, "GMS_WTF", stringBuilder.toString());
        oneTimePlayLogger.send();
        if (zzdl(7)) {
            Log.e(str, zzcJ(str2), th);
            Log.wtf(str, zzcJ(str2), th);
        }
    }

    public void zza(String str, String str2, Throwable th) {
        if (zzdl(4)) {
            Log.i(str, zzcJ(str2), th);
        }
    }

    public void zzb(String str, String str2, Throwable th) {
        if (zzdl(5)) {
            Log.w(str, zzcJ(str2), th);
        }
    }

    public void zzc(String str, String str2, Throwable th) {
        if (zzdl(6)) {
            Log.e(str, zzcJ(str2), th);
        }
    }

    public boolean zzdl(int i) {
        return Log.isLoggable(this.zzawX, i);
    }
}

package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.zzc.zzb;
import com.google.android.gms.common.util.zzd;
import java.util.Arrays;
import java.util.List;

public class zzi {
    private static String TAG = "WakeLockTracker";
    private static Integer zzayB;
    private static zzi zzaze = new zzi();

    private static int getLogLevel() {
        try {
            return zzd.isPackageSide() ? ((Integer) zzb.zzayF.get()).intValue() : zzd.LOG_LEVEL_OFF;
        } catch (SecurityException e) {
            return zzd.LOG_LEVEL_OFF;
        }
    }

    private static boolean zzaw(Context context) {
        if (zzayB == null) {
            zzayB = Integer.valueOf(getLogLevel());
        }
        return zzayB.intValue() != zzd.LOG_LEVEL_OFF;
    }

    public static zzi zzse() {
        return zzaze;
    }

    public void zza(Context context, Intent intent, String str, String str2, int i, String str3) {
        zza(context, intent, str, str2, i, Arrays.asList(new String[]{str3}));
    }

    public void zza(Context context, Intent intent, String str, String str2, int i, List<String> list) {
        zza(context, intent.getStringExtra("WAKE_LOCK_KEY"), 7, str, str2, i, list);
    }

    public void zza(Context context, String str, int i, String str2, String str3, int i2, List<String> list) {
        zza(context, str, i, str2, str3, i2, list, 0);
    }

    public void zza(Context context, String str, int i, String str2, String str3, int i2, List<String> list, long j) {
        if (!zzaw(context)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "missing wakeLock key. " + str);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (7 == i || 8 == i || 10 == i || 11 == i) {
            try {
                context.startService(new Intent().setComponent(zzd.zzayL).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, list, str, SystemClock.elapsedRealtime(), com.google.android.gms.common.util.zzi.zzay(context), str3, context.getPackageName(), com.google.android.gms.common.util.zzi.zzaz(context), j)));
            } catch (Throwable e) {
                Log.wtf(TAG, e);
            }
        }
    }

    public void zzf(Context context, Intent intent) {
        zza(context, intent.getStringExtra("WAKE_LOCK_KEY"), 8, null, null, 0, null);
    }
}

package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class zzh {
    @TargetApi(20)
    public static boolean zzax(Context context) {
        return zzr.zzsq() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static boolean zzb(Resources resources) {
        if (resources == null) {
            return false;
        }
        return (zzr.zzsi() && ((resources.getConfiguration().screenLayout & 15) > 3)) || zzc(resources);
    }

    @TargetApi(13)
    private static boolean zzc(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        return zzr.zzsk() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
    }
}

package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Process;
import com.google.android.gms.internal.zzni;

public class zzd {
    public static boolean isPackageSide() {
        return com.google.android.gms.common.internal.zzd.zzavq && zzni.isInitialized() && zzni.zzqn() == Process.myUid();
    }

    public static int zza(PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return -1;
        }
        Bundle bundle = packageInfo.applicationInfo.metaData;
        return bundle != null ? bundle.getInt("com.google.android.gms.version", -1) : -1;
    }

    public static int zzl(Context context, String str) {
        return zza(zzm(context, str));
    }

    public static PackageInfo zzm(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static boolean zzn(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}

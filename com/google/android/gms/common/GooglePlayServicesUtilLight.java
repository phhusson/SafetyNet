package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C0158R;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.common.util.zzk;
import com.google.android.gms.common.util.zzr;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class GooglePlayServicesUtilLight {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzpc();
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean zzapV = false;
    public static boolean zzapW = false;
    static int zzapX = -1;
    private static String zzapY = null;
    private static Integer zzapZ = null;
    static final AtomicBoolean zzaqa = new AtomicBoolean();
    private static final AtomicBoolean zzaqb = new AtomicBoolean();
    private static final Object zzrc = new Object();

    GooglePlayServicesUtilLight() {
    }

    public static void enableUsingApkIndependentContext() {
        zzaqb.set(true);
    }

    @Deprecated
    public static int getApkVersion(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return i;
        }
    }

    @Deprecated
    public static int getClientVersion(Context context) {
        zzx.zzad(!zzd.zzavq);
        return com.google.android.gms.common.util.zzd.zzl(context, context.getPackageName());
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int errorCode, Context context, int requestCode) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, errorCode, requestCode);
    }

    @Deprecated
    public static String getErrorString(int errorCode) {
        return ConnectionResult.getStatusString(errorCode);
    }

    @Deprecated
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int errorCode) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, errorCode, null);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream == null) {
                return next;
            }
            openInputStream.close();
            return next;
        } catch (NoSuchElementException e) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Exception e2) {
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static boolean honorsDebugCertificates(PackageManager packageManager) {
        return zzb(packageManager) || !zzpd();
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        if (zzd.zzavq) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C0158R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            zzao(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            GoogleSignatureVerifier instance = GoogleSignatureVerifier.getInstance();
            if (!zzh.zzax(context)) {
                try {
                    if (instance.zza(packageManager.getPackageInfo("com.android.vending", 8256), zzcm.zzapU) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (instance.zza(packageInfo, instance.zza(packageManager.getPackageInfo("com.android.vending", 8256), zzcm.zzapU)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                    return 9;
                }
            } else if (instance.zza(packageInfo, zzcm.zzapU) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (zzk.zzdD(packageInfo.versionCode) < zzk.zzdD(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isGoogleSignedPackage(PackageManager packageManager, PackageInfo packageInfo) {
        return GoogleSignatureVerifier.getInstance().isPackageGoogleSigned(packageManager, packageInfo);
    }

    @Deprecated
    public static boolean isGoogleSignedUid(PackageManager packageManager, int uid) {
        GoogleSignatureVerifier.getInstance().verifyUidIsGoogleSigned(packageManager, uid);
        return true;
    }

    @Deprecated
    public static boolean isPackageGoogleSigned(PackageManager packageManager, String callingPackage) {
        return GoogleSignatureVerifier.getInstance().isPackageGoogleSigned(packageManager, callingPackage);
    }

    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(Context context, int connectionStatusCode) {
        if (connectionStatusCode == 18) {
            return true;
        }
        return connectionStatusCode == 1 ? zzj(context, "com.google.android.gms") : false;
    }

    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(Context context, int connectionStatusCode) {
        return connectionStatusCode == 9 ? zzj(context, "com.android.vending") : false;
    }

    public static boolean isSidewinderDevice(Context context) {
        return zzr.zzsr() && context.getPackageManager().hasSystemFeature("cn.google");
    }

    @Deprecated
    public static boolean isUserRecoverableError(int errorCode) {
        switch (errorCode) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static void verifyPackageIsGoogleSigned(PackageManager packageManager, String callingPackage) throws SecurityException {
        GoogleSignatureVerifier.getInstance().verifyPackageIsGoogleSigned(packageManager, callingPackage);
    }

    @TargetApi(19)
    public static boolean zza(Context context, int i, String str) {
        if (zzr.zzsp()) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static void zzaf(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            Intent errorResolutionIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(context, isGooglePlayServicesAvailable, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + isGooglePlayServicesAvailable);
            if (errorResolutionIntent == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", errorResolutionIntent);
        }
    }

    @Deprecated
    public static void zzam(Context context) {
        if (!zzaqa.getAndSet(true)) {
            try {
                ((NotificationManager) context.getSystemService("notification")).cancel(10436);
            } catch (SecurityException e) {
            }
        }
    }

    private static void zzao(Context context) {
        if (!zzaqb.get()) {
            Integer num;
            synchronized (zzrc) {
                if (zzapY == null) {
                    zzapY = context.getPackageName();
                    try {
                        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle != null) {
                            zzapZ = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                        } else {
                            zzapZ = null;
                        }
                    } catch (Throwable e) {
                        Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                    }
                } else if (!zzapY.equals(context.getPackageName())) {
                    throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + zzapY + "' and this call used package '" + context.getPackageName() + "'.");
                }
                num = zzapZ;
            }
            if (num == null) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (num.intValue() != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but" + " found " + num + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
    }

    public static String zzap(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    @TargetApi(18)
    public static boolean zzaq(Context context) {
        if (zzr.zzso()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean zzb(PackageManager packageManager) {
        boolean z = true;
        synchronized (zzrc) {
            if (zzapX == -1) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
                    if (GoogleSignatureVerifier.getInstance().zza(packageInfo, zzcm.zzapU[1]) != null) {
                        zzapX = 1;
                    } else {
                        zzapX = 0;
                    }
                } catch (NameNotFoundException e) {
                    zzapX = 0;
                }
            }
            if (zzapX == 0) {
                z = false;
            }
        }
        return z;
    }

    static boolean zzcM(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 18:
            case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                return true;
            default:
                return false;
        }
    }

    public static boolean zze(Context context, int i) {
        boolean z = false;
        if (!zza(context, i, "com.google.android.gms")) {
            return z;
        }
        try {
            return GoogleSignatureVerifier.getInstance().zza(context.getPackageManager(), context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("GooglePlayServicesUtil", 3)) {
                return z;
            }
            Log.d("GooglePlayServicesUtil", "Package manager can't find google play services package, defaulting to false");
            return z;
        }
    }

    @TargetApi(21)
    static boolean zzj(Context context, String str) {
        if (zzr.zzsr()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        if (zzaq(context)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 8192).enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static int zzpc() {
        return 8487000;
    }

    public static boolean zzpd() {
        return zzapV ? zzapW : "user".equals(Build.TYPE);
    }
}

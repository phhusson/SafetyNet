package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompatExtras;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.base.C0187R;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.common.util.zzr;

public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private static class zza extends Handler {
        private final Context zzsE;

        zza(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.zzsE = context.getApplicationContext();
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzsE);
                    if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                        GooglePlayServicesUtil.zza(isGooglePlayServicesAvailable, this.zzsE);
                        return;
                    }
                    return;
                default:
                    Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + msg.what);
                    return;
            }
        }
    }

    private GooglePlayServicesUtil() {
    }

    public static void enableUsingApkIndependentContext() {
        GooglePlayServicesUtilLight.enableUsingApkIndependentContext();
    }

    @Deprecated
    public static int getApkVersion(Context context) {
        return GooglePlayServicesUtilLight.getApkVersion(context);
    }

    @Deprecated
    public static int getClientVersion(Context context) {
        return GooglePlayServicesUtilLight.getClientVersion(context);
    }

    @Deprecated
    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode) {
        return getErrorDialog(errorCode, activity, requestCode, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
        return zza(errorCode, activity, null, requestCode, cancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int errorCode, Context context, int requestCode) {
        return GooglePlayServicesUtilLight.getErrorPendingIntent(errorCode, context, requestCode);
    }

    @Deprecated
    public static String getErrorString(int errorCode) {
        return GooglePlayServicesUtilLight.getErrorString(errorCode);
    }

    @Deprecated
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int errorCode) {
        return GooglePlayServicesUtilLight.getGooglePlayServicesAvailabilityRecoveryIntent(errorCode);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        return GooglePlayServicesUtilLight.getOpenSourceSoftwareLicenseInfo(context);
    }

    public static Context getRemoteContext(Context context) {
        return GooglePlayServicesUtilLight.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return GooglePlayServicesUtilLight.getRemoteResource(context);
    }

    public static boolean honorsDebugCertificates(PackageManager packageManager) {
        return GooglePlayServicesUtilLight.honorsDebugCertificates(packageManager);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isGoogleSignedPackage(PackageManager packageManager, PackageInfo packageInfo) {
        return GooglePlayServicesUtilLight.isGoogleSignedPackage(packageManager, packageInfo);
    }

    @Deprecated
    public static boolean isGoogleSignedUid(PackageManager packageManager, int uid) {
        return GooglePlayServicesUtilLight.isGoogleSignedUid(packageManager, uid);
    }

    @Deprecated
    public static boolean isPackageGoogleSigned(PackageManager packageManager, String callingPackage) {
        return GooglePlayServicesUtilLight.isPackageGoogleSigned(packageManager, callingPackage);
    }

    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(Context context, int connectionStatusCode) {
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, connectionStatusCode);
    }

    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(Context context, int connectionStatusCode) {
        return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, connectionStatusCode);
    }

    public static boolean isSidewinderDevice(Context context) {
        return GooglePlayServicesUtilLight.isSidewinderDevice(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int errorCode) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(errorCode);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode) {
        return showErrorDialogFragment(errorCode, activity, requestCode, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
        return showErrorDialogFragment(errorCode, activity, null, requestCode, cancelListener);
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, Fragment fragment, int requestCode, OnCancelListener cancelListener) {
        Dialog zza = zza(errorCode, activity, fragment, requestCode, cancelListener);
        if (zza == null) {
            return false;
        }
        zza(activity, cancelListener, GMS_ERROR_DIALOG, zza);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int errorCode, Context context) {
        if (zzh.zzax(context) && errorCode == 2) {
            errorCode = 42;
        }
        if (isPlayServicesPossiblyUpdating(context, errorCode) || isPlayStorePossiblyUpdating(context, errorCode)) {
            zzan(context);
        } else {
            zza(errorCode, context);
        }
    }

    @Deprecated
    public static void verifyPackageIsGoogleSigned(PackageManager packageManager, String callingPackage) throws SecurityException {
        GooglePlayServicesUtilLight.verifyPackageIsGoogleSigned(packageManager, callingPackage);
    }

    @TargetApi(14)
    private static Dialog zza(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (zzh.zzax(activity) && i == 2) {
            i = 42;
        }
        if (isPlayServicesPossiblyUpdating(activity, i)) {
            i = 18;
        }
        if (zzr.zzsl()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new Builder(activity, 5);
            }
        }
        if (builder == null) {
            builder = new Builder(activity);
        }
        builder.setMessage(zzg.zzb(activity, i, GooglePlayServicesUtilLight.zzap(activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Intent errorResolutionIntent = GoogleApiAvailability.getInstance().getErrorResolutionIntent(activity, i, "d");
        OnClickListener com_google_android_gms_common_internal_zzh = fragment == null ? new com.google.android.gms.common.internal.zzh(activity, errorResolutionIntent, i2) : new com.google.android.gms.common.internal.zzh(fragment, errorResolutionIntent, i2);
        CharSequence zzg = zzg.zzg(activity, i);
        if (zzg != null) {
            builder.setPositiveButton(zzg, com_google_android_gms_common_internal_zzh);
        }
        CharSequence zzf = zzg.zzf(activity, i);
        if (zzf != null) {
            builder.setTitle(zzf);
        }
        return builder.create();
    }

    @TargetApi(21)
    private static void zza(int i, Context context) {
        zza(i, context, null);
    }

    @TargetApi(21)
    private static void zza(int i, Context context, String str) {
        Notification build;
        int i2;
        Resources resources = context.getResources();
        String zzap = GooglePlayServicesUtilLight.zzap(context);
        CharSequence zzf = zzg.zzf(context, i);
        if (zzf == null) {
            zzf = resources.getString(C0187R.string.common_google_play_services_notification_ticker);
        }
        CharSequence zzb = zzg.zzb(context, i, zzap);
        PendingIntent errorResolutionPendingIntent = GoogleApiAvailability.getInstance().getErrorResolutionPendingIntent(context, i, 0, "n");
        if (zzh.zzax(context)) {
            zzx.zzad(zzr.zzsm());
            build = new Notification.Builder(context).setSmallIcon(C0187R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new BigTextStyle().bigText(zzf + " " + zzb)).addAction(C0187R.drawable.common_full_open_on_phone, resources.getString(C0187R.string.common_open_on_phone), errorResolutionPendingIntent).build();
        } else {
            CharSequence string = resources.getString(C0187R.string.common_google_play_services_notification_ticker);
            if (zzr.zzsi()) {
                Notification build2;
                Notification.Builder autoCancel = new Notification.Builder(context).setSmallIcon(17301642).setContentTitle(zzf).setContentText(zzb).setContentIntent(errorResolutionPendingIntent).setTicker(string).setAutoCancel(true);
                if (zzr.zzsq()) {
                    autoCancel.setLocalOnly(true);
                }
                if (zzr.zzsm()) {
                    autoCancel.setStyle(new BigTextStyle().bigText(zzb));
                    build2 = autoCancel.build();
                } else {
                    build2 = autoCancel.getNotification();
                }
                if (VERSION.SDK_INT == 19) {
                    build2.extras.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
                build = build2;
            } else {
                build = new NotificationCompat.Builder(context).setSmallIcon(17301642).setTicker(string).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(errorResolutionPendingIntent).setContentTitle(zzf).setContentText(zzb).build();
            }
        }
        if (GooglePlayServicesUtilLight.zzcM(i)) {
            zzaqa.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (str != null) {
            notificationManager.notify(str, i2, build);
        } else {
            notificationManager.notify(i2, build);
        }
    }

    @TargetApi(11)
    public static void zza(Activity activity, OnCancelListener onCancelListener, String str, @NonNull Dialog dialog) {
        boolean z;
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
        } else if (zzr.zzsi()) {
            ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    private static void zzan(Context context) {
        Handler com_google_android_gms_common_GooglePlayServicesUtil_zza = new zza(context);
        com_google_android_gms_common_GooglePlayServicesUtil_zza.sendMessageDelayed(com_google_android_gms_common_GooglePlayServicesUtil_zza.obtainMessage(1), 120000);
    }
}

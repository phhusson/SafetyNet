package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzn;

public class GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final GoogleApiAvailabilityLight zzapN = new GoogleApiAvailabilityLight();

    GoogleApiAvailabilityLight() {
    }

    public static GoogleApiAvailabilityLight getInstance() {
        return zzapN;
    }

    private String zzk(@Nullable Context context, @Nullable String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public int getApkVersion(Context context) {
        return GooglePlayServicesUtilLight.getApkVersion(context);
    }

    public int getClientVersion(Context context) {
        return GooglePlayServicesUtilLight.getClientVersion(context);
    }

    @Nullable
    @Deprecated
    public Intent getErrorResolutionIntent(int errorCode) {
        return getErrorResolutionIntent(null, errorCode, null);
    }

    @Nullable
    public Intent getErrorResolutionIntent(Context context, int errorCode, @Nullable String trackingSource) {
        switch (errorCode) {
            case 1:
            case 2:
                return zzn.zzF("com.google.android.gms", zzk(context, trackingSource));
            case 3:
                return zzn.zzcI("com.google.android.gms");
            case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                return zzn.zzro();
            default:
                return null;
        }
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, int errorCode, int requestCode) {
        return getErrorResolutionPendingIntent(context, errorCode, requestCode, null);
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, int errorCode, int requestCode, @Nullable String trackingSource) {
        Intent errorResolutionIntent = getErrorResolutionIntent(context, errorCode, trackingSource);
        return errorResolutionIntent == null ? null : PendingIntent.getActivity(context, requestCode, errorResolutionIntent, 268435456);
    }

    public String getErrorString(int errorCode) {
        return GooglePlayServicesUtilLight.getErrorString(errorCode);
    }

    @Nullable
    public String getOpenSourceSoftwareLicenseInfo(Context context) {
        return GooglePlayServicesUtilLight.getOpenSourceSoftwareLicenseInfo(context);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable) ? 18 : isGooglePlayServicesAvailable;
    }

    public boolean isPlayServicesPossiblyUpdating(Context context, int errorCode) {
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, errorCode);
    }

    public boolean isPlayStorePossiblyUpdating(Context context, int errorCode) {
        return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, errorCode);
    }

    public boolean isUserResolvableError(int errorCode) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(errorCode);
    }

    public void zzal(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        GooglePlayServicesUtilLight.zzaf(context);
    }

    public void zzam(Context context) {
        GooglePlayServicesUtilLight.zzam(context);
    }

    public boolean zzj(Context context, String str) {
        return GooglePlayServicesUtilLight.zzj(context, str);
    }
}

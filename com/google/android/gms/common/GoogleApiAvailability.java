package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.base.C0187R;

public class GoogleApiAvailability extends GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final GoogleApiAvailability zzapM = new GoogleApiAvailability();

    GoogleApiAvailability() {
    }

    public static GoogleApiAvailability getInstance() {
        return zzapM;
    }

    public int getApkVersion(Context context) {
        return super.getApkVersion(context);
    }

    public int getClientVersion(Context context) {
        return super.getClientVersion(context);
    }

    public Dialog getErrorDialog(Activity activity, int errorCode, int requestCode) {
        return GooglePlayServicesUtil.getErrorDialog(errorCode, activity, requestCode);
    }

    public Dialog getErrorDialog(Activity activity, int errorCode, int requestCode, OnCancelListener cancelListener) {
        return GooglePlayServicesUtil.getErrorDialog(errorCode, activity, requestCode, cancelListener);
    }

    @Nullable
    @Deprecated
    public Intent getErrorResolutionIntent(int errorCode) {
        return super.getErrorResolutionIntent(errorCode);
    }

    @Nullable
    public Intent getErrorResolutionIntent(Context context, int errorCode, @Nullable String trackingSource) {
        return super.getErrorResolutionIntent(context, errorCode, trackingSource);
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, int errorCode, int requestCode) {
        return super.getErrorResolutionPendingIntent(context, errorCode, requestCode);
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, int errorCode, int requestCode, @Nullable String trackingSource) {
        return super.getErrorResolutionPendingIntent(context, errorCode, requestCode, trackingSource);
    }

    public final String getErrorString(int errorCode) {
        return super.getErrorString(errorCode);
    }

    @Nullable
    public String getOpenSourceSoftwareLicenseInfo(Context context) {
        return super.getOpenSourceSoftwareLicenseInfo(context);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    public boolean isPlayServicesPossiblyUpdating(Context context, int errorCode) {
        return super.isPlayServicesPossiblyUpdating(context, errorCode);
    }

    public boolean isPlayStorePossiblyUpdating(Context context, int errorCode) {
        return super.isPlayStorePossiblyUpdating(context, errorCode);
    }

    public final boolean isUserResolvableError(int errorCode) {
        return super.isUserResolvableError(errorCode);
    }

    public boolean showErrorDialogFragment(Activity activity, int errorCode, int requestCode) {
        return GooglePlayServicesUtil.showErrorDialogFragment(errorCode, activity, requestCode);
    }

    public boolean showErrorDialogFragment(Activity activity, int errorCode, int requestCode, OnCancelListener cancelListener) {
        return GooglePlayServicesUtil.showErrorDialogFragment(errorCode, activity, requestCode, cancelListener);
    }

    public void showErrorNotification(Context context, int errorCode) {
        GooglePlayServicesUtil.showErrorNotification(errorCode, context);
    }

    public Dialog zza(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        String zzap = GooglePlayServicesUtilLight.zzap(activity);
        builder.setMessage(activity.getResources().getString(C0187R.string.common_google_play_services_updating_text, new Object[]{zzap}));
        builder.setTitle(C0187R.string.common_google_play_services_updating_title);
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        GooglePlayServicesUtil.zza(activity, onCancelListener, "GooglePlayServicesUpdatingDialog", create);
        return create;
    }
}

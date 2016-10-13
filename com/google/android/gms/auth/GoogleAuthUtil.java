package com.google.android.gms.auth;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.zzx;
import java.io.IOException;
import java.util.List;

public final class GoogleAuthUtil extends GoogleAuthUtilLight {
    public static final String ACCOUNT_ID_SERVICE = "^^_account_id_^^";
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final int DELEGATION_TYPE_CHILD_IMPERSONATION = 1;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME = GoogleAuthUtilLight.KEY_ANDROID_PACKAGE_NAME;
    public static final String KEY_CALLER_UID = GoogleAuthUtilLight.KEY_CALLER_UID;
    public static final String KEY_CLIENT_PACKAGE_NAME = "clientPackageName";
    public static final String KEY_DELEGATEE_USER_ID = "delegatee_user_id";
    public static final String KEY_DELEGATION_TYPE = "delegation_type";
    public static final String KEY_HANDLE_NOTIFICATION = "handle_notification";
    public static final String KEY_NETWORK_TO_USE = "networkToUse";
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String KEY_TOKEN_USE_CACHE = "UseCache";
    public static final String OEM_ONLY_KEY_REDIRECT_URI = "oauth2_redirect_uri";
    public static final String OEM_ONLY_KEY_TARGET_ANDROID_ID = "oauth2_target_device_id";
    public static final String OEM_ONLY_KEY_VERIFIER = "oauth2_authcode_verifier";
    public static final String OEM_ONLY_SCOPE_ACCOUNT_BOOTSTRAP = "_account_setup";
    public static final String SIDEWINDER_ACCOUNT_TYPE = "cn.google";
    public static final String STATUS_CAPTCHA_REQUIRED = "CaptchaRequired";
    @Deprecated
    public static final String STATUS_DEVICE_MANAGEMENT = "DeviceManagementRequiredOrSyncDisabled";
    public static final String STATUS_INTERRUPTED = "Interrupted";
    public static final String STATUS_NEEDS_PERMISSION = "NeedPermission";
    public static final String STATUS_NEED_APP = "AppDownloadRequired";
    public static final String STATUS_NETWORK_ERROR = "NetworkError";
    public static final String STATUS_USER_CANCEL = "UserCancel";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";

    private GoogleAuthUtil() {
    }

    public static void clearPassword(Context context, Account account) throws RemoteException, GoogleAuthException, GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        GoogleAuthUtilLight.clearPassword(context, account);
    }

    public static void clearToken(Context context, String token) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        GoogleAuthUtilLight.clearToken(context, token);
    }

    public static RecoveryReadResponse fetchCurrentRecoveryData(Context ctx, String email) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return GoogleAuthUtilLight.fetchCurrentRecoveryData(ctx, email);
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int eventIndex, String accountName) throws GoogleAuthException, IOException {
        return GoogleAuthUtilLight.getAccountChangeEvents(context, eventIndex, accountName);
    }

    public static String getAccountId(Context ctx, String accountName) throws GoogleAuthException, IOException {
        return GoogleAuthUtilLight.getAccountId(ctx, accountName);
    }

    public static Account[] getAccounts(Context context, String accountType) throws RemoteException, GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        return GoogleAuthUtilLight.getAccounts(context, accountType);
    }

    public static Account[] getAccounts(Context context, String accountType, String[] optionalFeatures) throws GoogleAuthException, IOException {
        return GoogleAuthUtilLight.getAccounts(context, accountType, optionalFeatures);
    }

    public static RecoveryDecision getRecoveryDetails(Context ctx, String email, String displayMessage, boolean isMessageBroadUse) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return GoogleAuthUtilLight.getRecoveryDetails(ctx, email, displayMessage, isMessageBroadUse);
    }

    public static PendingIntent getRecoveryIfSuggested(Context ctx, String email, String displayMessage, boolean isMessageBroadUse) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return GoogleAuthUtilLight.getRecoveryIfSuggested(ctx, email, displayMessage, isMessageBroadUse);
    }

    public static String getToken(Context context, Account account, String scope) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return GoogleAuthUtilLight.getToken(context, account, scope);
    }

    public static String getToken(Context context, Account account, String scope, Bundle extras) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return GoogleAuthUtilLight.getToken(context, account, scope, extras);
    }

    @Deprecated
    public static String getToken(Context context, String accountName, String scope) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return GoogleAuthUtilLight.getToken(context, accountName, scope);
    }

    @Deprecated
    public static String getToken(Context context, String accountName, String scope, Bundle extras) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return GoogleAuthUtilLight.getToken(context, accountName, scope, extras);
    }

    public static String getTokenWithNotification(Context context, Account account, String scope, Bundle extras) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return zza(context, account, scope, extras).getToken();
    }

    public static String getTokenWithNotification(Context context, Account account, String scope, Bundle extras, Intent callback) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        GoogleAuthUtilLight.zzi(callback);
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putParcelable("callback_intent", callback);
        extras.putBoolean("handle_notification", true);
        return zzb(context, account, scope, extras).getToken();
    }

    public static String getTokenWithNotification(Context context, Account account, String scope, Bundle extras, String authority, Bundle syncBundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        zzx.zzi(authority, "Authority cannot be empty or null.");
        if (extras == null) {
            extras = new Bundle();
        }
        if (syncBundle == null) {
            syncBundle = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(syncBundle);
        extras.putString("authority", authority);
        extras.putBundle("sync_extras", syncBundle);
        extras.putBoolean("handle_notification", true);
        return zzb(context, account, scope, extras).getToken();
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String accountName, String scope, Bundle extras) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(accountName, "com.google"), scope, extras);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String accountName, String scope, Bundle extras, Intent callback) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(accountName, "com.google"), scope, extras, callback);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String accountName, String scope, Bundle extras, String authority, Bundle syncBundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(accountName, "com.google"), scope, extras, authority, syncBundle);
    }

    @RequiresPermission("android.permission.MANAGE_ACCOUNTS")
    @Deprecated
    public static void invalidateToken(Context context, String token) {
        GoogleAuthUtilLight.invalidateToken(context, token);
    }

    @TargetApi(23)
    public static Bundle removeAccount(Context context, Account account) throws GoogleAuthException, IOException {
        return GoogleAuthUtilLight.removeAccount(context, account);
    }

    public static RecoveryWriteResponse updateRecoveryData(Context ctx, RecoveryWriteRequest req) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return GoogleAuthUtilLight.updateRecoveryData(ctx, req);
    }

    public static TokenData zza(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("handle_notification", true);
        return zzb(context, account, str, bundle);
    }

    private static TokenData zzb(Context context, Account account, String str, Bundle bundle) throws IOException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            TokenData zzc = GoogleAuthUtilLight.zzc(context, account, str, bundle);
            GooglePlayServicesUtilLight.zzam(context);
            return zzc;
        } catch (GooglePlayServicesAvailabilityException e) {
            GooglePlayServicesUtil.showErrorNotification(e.getConnectionStatusCode(), context);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        } catch (UserRecoverableAuthException e2) {
            GooglePlayServicesUtilLight.zzam(context);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
    }
}

package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.firstparty.shared.Status;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.util.zzr;
import com.google.android.gms.internal.zzat;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class GoogleAuthUtilLight {
    public static final String ACCOUNT_ID_SERVICE = "^^_account_id_^^";
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final int DELEGATION_TYPE_CHILD_IMPERSONATION = 1;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME = (VERSION.SDK_INT >= 14 ? "androidPackageName" : "androidPackageName");
    public static final String KEY_CALLER_UID = (VERSION.SDK_INT >= 11 ? "callerUid" : "callerUid");
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
    private static final ComponentName zzWH = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final ComponentName zzWI = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");

    private interface zza<T> {
        T exec(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException;
    }

    GoogleAuthUtilLight() {
    }

    public static void clearPassword(Context context, Account account) throws RemoteException, GoogleAuthException, GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzx.zzD(account);
        if (zzr.zzst()) {
            zza(context, account);
        } else {
            AccountManager.get(context).clearPassword(account);
        }
    }

    public static void clearToken(Context context, final String token) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        zzx.zzcD("Calling this from your main thread can lead to deadlock");
        zzaf(context);
        final Bundle bundle = new Bundle();
        String str = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
        }
        zza(context, zzWH, new zza<Void>() {
            public /* synthetic */ Object exec(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return zzaA(iBinder);
            }

            public Void zzaA(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                Bundle bundle = (Bundle) GoogleAuthUtilLight.zzp(com.google.android.gms.internal.zzat.zza.zza(iBinder).zza(token, bundle));
                String string = bundle.getString(Status.EXTRA_KEY_STATUS);
                if (bundle.getBoolean("booleanResult")) {
                    return null;
                }
                throw new GoogleAuthException(string);
            }
        });
    }

    public static RecoveryReadResponse fetchCurrentRecoveryData(final Context ctx, final String email) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        zzx.zzcD("Calling this from your main thread can lead to deadlock");
        zzaf(ctx);
        return (RecoveryReadResponse) zza(ctx, zzWI, new zza<RecoveryReadResponse>() {
            public /* synthetic */ Object exec(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return zzaC(iBinder);
            }

            public RecoveryReadResponse zzaC(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return (RecoveryReadResponse) GoogleAuthUtilLight.zzp(com.google.android.gms.internal.zzau.zza.zzb(iBinder).zzb(email, ctx.getPackageName()));
            }
        });
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, final int eventIndex, final String accountName) throws GoogleAuthException, IOException {
        zzx.zzi(accountName, "accountName must be provided");
        zzx.zzcD("Calling this from your main thread can lead to deadlock");
        zzaf(context);
        return (List) zza(context, zzWH, new zza<List<AccountChangeEvent>>() {
            public /* synthetic */ Object exec(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return zzaE(iBinder);
            }

            public List<AccountChangeEvent> zzaE(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return ((AccountChangeEventsResponse) GoogleAuthUtilLight.zzp(com.google.android.gms.internal.zzat.zza.zza(iBinder).getAccountChangeEvents(new AccountChangeEventsRequest().setAccountName(accountName).setEventIndex(eventIndex)))).getEvents();
            }
        });
    }

    public static String getAccountId(Context ctx, String accountName) throws GoogleAuthException, IOException {
        zzx.zzi(accountName, "accountName must be provided");
        zzx.zzcD("Calling this from your main thread can lead to deadlock");
        zzaf(ctx);
        return getToken(ctx, accountName, "^^_account_id_^^", new Bundle());
    }

    public static Account[] getAccounts(Context context, String accountType) throws RemoteException, GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzx.zzcL(accountType);
        return zzr.zzst() ? zzi(context, accountType) : AccountManager.get(context).getAccountsByType(accountType);
    }

    public static Account[] getAccounts(Context context, final String accountType, final String[] optionalFeatures) throws GoogleAuthException, IOException {
        zzx.zzD(context);
        zzx.zzcL(accountType);
        zzaf(context);
        return (Account[]) zza(context, zzWH, new zza<Account[]>() {
            public /* synthetic */ Object exec(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return zzaF(iBinder);
            }

            public Account[] zzaF(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                zzat zza = com.google.android.gms.internal.zzat.zza.zza(iBinder);
                Bundle bundle = new Bundle();
                bundle.putString("accountType", accountType);
                bundle.putStringArray("account_features", optionalFeatures);
                Parcelable[] parcelableArray = ((Bundle) GoogleAuthUtilLight.zzp(zza.zza(bundle))).getParcelableArray("accounts");
                Account[] accountArr = new Account[parcelableArray.length];
                for (int i = 0; i < parcelableArray.length; i++) {
                    accountArr[i] = (Account) parcelableArray[i];
                }
                return accountArr;
            }
        });
    }

    public static RecoveryDecision getRecoveryDetails(Context ctx, final String email, final String displayMessage, final boolean isMessageBroadUse) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        zzx.zzcD("Calling this from your main thread can lead to deadlock");
        zzaf(ctx);
        final Bundle bundle = new Bundle();
        bundle.putString(KEY_ANDROID_PACKAGE_NAME, ctx.getPackageName());
        return (RecoveryDecision) zza(ctx, zzWI, new zza<RecoveryDecision>() {
            public /* synthetic */ Object exec(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return zzaB(iBinder);
            }

            public RecoveryDecision zzaB(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return (RecoveryDecision) GoogleAuthUtilLight.zzp(com.google.android.gms.internal.zzau.zza.zzb(iBinder).zza(email, displayMessage, isMessageBroadUse, bundle));
            }
        });
    }

    public static PendingIntent getRecoveryIfSuggested(Context ctx, String email, String displayMessage, boolean isMessageBroadUse) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        RecoveryDecision recoveryDetails = getRecoveryDetails(ctx, email, displayMessage, isMessageBroadUse);
        return (recoveryDetails.showRecoveryInterstitial && recoveryDetails.isRecoveryInterstitialAllowed) ? recoveryDetails.recoveryIntent : null;
    }

    public static String getToken(Context context, Account account, String scope) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, account, scope, new Bundle());
    }

    public static String getToken(Context context, Account account, String scope, Bundle extras) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzc(context, account, scope, extras).getToken();
    }

    @Deprecated
    public static String getToken(Context context, String accountName, String scope) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(accountName, "com.google"), scope);
    }

    @Deprecated
    public static String getToken(Context context, String accountName, String scope, Bundle extras) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(accountName, "com.google"), scope, extras);
    }

    @RequiresPermission("android.permission.MANAGE_ACCOUNTS")
    @Deprecated
    public static void invalidateToken(Context context, String token) {
        AccountManager.get(context).invalidateAuthToken("com.google", token);
    }

    @TargetApi(23)
    public static Bundle removeAccount(Context context, final Account account) throws GoogleAuthException, IOException {
        zzx.zzD(context);
        zzaf(context);
        return (Bundle) zza(context, zzWH, new zza<Bundle>() {
            public /* synthetic */ Object exec(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return zzaG(iBinder);
            }

            public Bundle zzaG(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return (Bundle) GoogleAuthUtilLight.zzp(com.google.android.gms.internal.zzat.zza.zza(iBinder).zza(account));
            }
        });
    }

    public static RecoveryWriteResponse updateRecoveryData(final Context ctx, final RecoveryWriteRequest req) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        zzx.zzcD("Calling this from your main thread can lead to deadlock");
        zzaf(ctx);
        return (RecoveryWriteResponse) zza(ctx, zzWI, new zza<RecoveryWriteResponse>() {
            public /* synthetic */ Object exec(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return zzaD(iBinder);
            }

            public RecoveryWriteResponse zzaD(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return (RecoveryWriteResponse) GoogleAuthUtilLight.zzp(com.google.android.gms.internal.zzau.zza.zzb(iBinder).zza(req, ctx.getPackageName()));
            }
        });
    }

    private static <T> T zza(Context context, ComponentName componentName, zza<T> com_google_android_gms_auth_GoogleAuthUtilLight_zza_T) throws IOException, GoogleAuthException {
        Throwable e;
        ServiceConnection com_google_android_gms_common_zza = new com.google.android.gms.common.zza();
        zzl zzav = zzl.zzav(context);
        if (zzav.zza(componentName, com_google_android_gms_common_zza, "GoogleAuthUtil")) {
            try {
                T exec = com_google_android_gms_auth_GoogleAuthUtilLight_zza_T.exec(com_google_android_gms_common_zza.zzoW());
                zzav.zzb(componentName, com_google_android_gms_common_zza, "GoogleAuthUtil");
                return exec;
            } catch (RemoteException e2) {
                e = e2;
                try {
                    Log.i("GoogleAuthUtil", "Error on service connection.", e);
                    throw new IOException("Error on service connection.", e);
                } catch (Throwable th) {
                    zzav.zzb(componentName, com_google_android_gms_common_zza, "GoogleAuthUtil");
                }
            } catch (InterruptedException e3) {
                e = e3;
                Log.i("GoogleAuthUtil", "Error on service connection.", e);
                throw new IOException("Error on service connection.", e);
            }
        }
        throw new IOException("Could not bind to service.");
    }

    @TargetApi(23)
    private static void zza(Context context, Account account) throws RemoteException, GoogleAuthException, GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzaf(context);
        ContentProviderClient acquireContentProviderClient = ((Context) zzx.zzD(context)).getContentResolver().acquireContentProviderClient("com.google.android.gms.auth.accounts");
        if (acquireContentProviderClient == null) {
            Log.w("GoogleAuthUtil", "ContentProviderClient is null. Can't clear password");
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putParcelable("clear_password", account);
            acquireContentProviderClient.call("clear_password", null, bundle);
        } finally {
            acquireContentProviderClient.release();
        }
    }

    private static void zzaf(Context context) throws GoogleAuthException {
        try {
            GooglePlayServicesUtilLight.zzaf(context.getApplicationContext());
        } catch (GooglePlayServicesRepairableException e) {
            throw new GooglePlayServicesAvailabilityException(e.getConnectionStatusCode(), e.getMessage(), e.getIntent());
        } catch (GooglePlayServicesNotAvailableException e2) {
            throw new GoogleAuthException(e2.getMessage());
        }
    }

    public static TokenData zzc(Context context, final Account account, final String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        zzx.zzcD("Calling this from your main thread can lead to deadlock");
        zzaf(context);
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(KEY_ANDROID_PACKAGE_NAME))) {
            bundle2.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return (TokenData) zza(context, zzWH, new zza<TokenData>() {
            public /* synthetic */ Object exec(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return zzaz(iBinder);
            }

            public TokenData zzaz(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                Bundle bundle = (Bundle) GoogleAuthUtilLight.zzp(com.google.android.gms.internal.zzat.zza.zza(iBinder).zza(account, str, bundle2));
                TokenData zzc = TokenData.zzc(bundle, "tokenDetails");
                if (zzc != null) {
                    return zzc;
                }
                String string = bundle.getString(Status.EXTRA_KEY_STATUS);
                Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
                Status fromWireCode = Status.fromWireCode(string);
                if (Status.isUserRecoverableError(fromWireCode)) {
                    throw new UserRecoverableAuthException(string, intent);
                } else if (Status.isRetryableError(fromWireCode)) {
                    throw new IOException(string);
                } else {
                    throw new GoogleAuthException(string);
                }
            }
        });
    }

    static void zzi(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    @TargetApi(23)
    private static Account[] zzi(Context context, String str) throws RemoteException, GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int i = 0;
        GoogleApiAvailabilityLight.getInstance().zzal(context);
        Account[] accountArr = "com.google.android.gms.auth.accounts";
        ContentProviderClient acquireContentProviderClient = ((Context) zzx.zzD(context)).getContentResolver().acquireContentProviderClient(accountArr);
        if (acquireContentProviderClient == null) {
            return new Account[0];
        }
        try {
            Parcelable[] parcelableArray = acquireContentProviderClient.call("get_accounts", str, new Bundle()).getParcelableArray("accounts");
            accountArr = new Account[parcelableArray.length];
            while (i < parcelableArray.length) {
                accountArr[i] = (Account) parcelableArray[i];
                i++;
            }
            return accountArr;
        } finally {
            acquireContentProviderClient.release();
        }
    }

    private static <T> T zzp(T t) throws IOException {
        if (t != null) {
            return t;
        }
        Log.w("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }
}

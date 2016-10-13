package com.google.android.gms.common.api;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.api.internal.zzab;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.util.zzr;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class ResultStore {
    private static final Map<Activity, ResultStore> zzaqJ = new WeakHashMap();
    private static final Object zzrc = new Object();

    @NonNull
    public static ResultStore getInstance(@NonNull Activity activity, @NonNull GoogleApiClient apiClient) {
        ResultStore resultStore;
        boolean z = false;
        zzx.zzb((Object) activity, (Object) "Activity must not be null.");
        zzx.zzb(Boolean.valueOf(apiClient != null), (Object) "GoogleApiClient must not be null.");
        try {
            boolean z2 = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
            z2 = false;
        }
        if (z2 || zzr.zzsi()) {
            z = true;
        }
        zzx.zza(z, (Object) "Expected at least Honeycomb (3.0) platform version.");
        synchronized (zzrc) {
            resultStore = (ResultStore) zzaqJ.get(activity);
            if (resultStore == null) {
                resultStore = z2 ? zza((FragmentActivity) activity) : zzp(activity);
                zzaqJ.put(activity, resultStore);
            }
            apiClient.zza(resultStore);
        }
        return resultStore;
    }

    private static ResultStore zza(FragmentActivity fragmentActivity) {
        String str = "GmsResultStoreFragment";
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            zzab com_google_android_gms_common_api_internal_zzab = (zzab) supportFragmentManager.findFragmentByTag(str);
            if (com_google_android_gms_common_api_internal_zzab == null) {
                com_google_android_gms_common_api_internal_zzab = new zzab();
                supportFragmentManager.beginTransaction().add((Fragment) com_google_android_gms_common_api_internal_zzab, str).commit();
            }
            return com_google_android_gms_common_api_internal_zzab.zzqc();
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment tag " + str + " is reserved for " + "ResultStore.");
        }
    }

    @TargetApi(11)
    private static ResultStore zzp(Activity activity) {
        String str = "GmsResultStoreFragment";
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            zzq com_google_android_gms_common_api_internal_zzq = (zzq) fragmentManager.findFragmentByTag(str);
            if (com_google_android_gms_common_api_internal_zzq == null) {
                com_google_android_gms_common_api_internal_zzq = new zzq();
                fragmentManager.beginTransaction().add(com_google_android_gms_common_api_internal_zzq, str).commit();
            }
            return com_google_android_gms_common_api_internal_zzq.zzqc();
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment tag " + str + " is reserved for " + "ResultStore.");
        }
    }

    protected static void zzq(Activity activity) {
        synchronized (zzrc) {
            zzaqJ.remove(activity);
        }
    }

    public abstract boolean hasPendingResult(int i);

    public abstract void remove(int i);

    public abstract void setResultCallbacks(int i, @NonNull ResultCallbacks<?> resultCallbacks);

    public <R extends Result> void zza(int i, @NonNull PendingResult<R> pendingResult) {
        throw new UnsupportedOperationException();
    }
}

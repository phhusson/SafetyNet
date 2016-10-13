package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

abstract class zzn extends BroadcastReceiver {
    protected Context mContext;

    zzn() {
    }

    @Nullable
    public static <T extends zzn> T zza(Context context, T t) {
        return zza(context, t, GoogleApiAvailabilityLight.getInstance());
    }

    @Nullable
    public static <T extends zzn> T zza(Context context, T t, GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(t, intentFilter);
        t.mContext = context;
        if (googleApiAvailabilityLight.zzj(context, "com.google.android.gms")) {
            return t;
        }
        t.zzpX();
        t.unregister();
        return null;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            zzpX();
            unregister();
        }
    }

    public synchronized void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this);
        }
        this.mContext = null;
    }

    protected abstract void zzpX();
}

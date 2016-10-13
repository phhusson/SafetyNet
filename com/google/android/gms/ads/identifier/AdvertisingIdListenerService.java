package com.google.android.gms.ads.identifier;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AdvertisingIdListenerService extends Service {
    private volatile int zzpA = -1;
    private ExecutorService zzpB;
    private IBinder zzpC;
    private final Object zzpD = new Object();
    private boolean zzpE;

    private class zza extends com.google.android.gms.internal.zzbb.zza {
        final /* synthetic */ AdvertisingIdListenerService zzpF;

        private zza(AdvertisingIdListenerService advertisingIdListenerService) {
            this.zzpF = advertisingIdListenerService;
        }

        public void zzb(final Bundle bundle) {
            synchronized (this.zzpF.zzpD) {
                if (this.zzpF.zzpE) {
                    return;
                }
                this.zzpF.zzaW();
                this.zzpF.zzpB.execute(new Runnable(this) {
                    final /* synthetic */ zza zzpH;

                    public void run() {
                        this.zzpH.zzpF.onAdvertisingIdInfoChanged(new Info(bundle.getString("ad_id"), bundle.getBoolean("lat_enabled")));
                    }
                });
            }
        }
    }

    private void zzaW() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.zzpA) {
            if (GooglePlayServicesUtilLight.zze(this, callingUid)) {
                this.zzpA = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices.");
        }
    }

    public abstract void onAdvertisingIdInfoChanged(Info info);

    public final IBinder onBind(Intent intent) {
        return "com.google.android.gms.ads.identifier.BIND_LISTENER".equals(intent.getAction()) ? this.zzpC : null;
    }

    public void onCreate() {
        super.onCreate();
        this.zzpB = Executors.newSingleThreadExecutor();
        this.zzpC = new zza();
    }

    public void onDestroy() {
        synchronized (this.zzpD) {
            this.zzpE = true;
            this.zzpB.shutdown();
        }
        super.onDestroy();
    }
}

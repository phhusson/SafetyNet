package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zzbc;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private final Context mContext;
    com.google.android.gms.common.zza zzpo;
    zzbc zzpp;
    boolean zzpq;
    Object zzpr;
    zza zzps;
    final long zzpt;

    public static final class Info {
        private final String zzpy;
        private final boolean zzpz;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.zzpy = advertisingId;
            this.zzpz = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.zzpy;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzpz;
        }

        public String toString() {
            return "{" + this.zzpy + "}" + this.zzpz;
        }
    }

    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzpu;
        private long zzpv;
        CountDownLatch zzpw = new CountDownLatch(1);
        boolean zzpx = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzpu = new WeakReference(advertisingIdClient);
            this.zzpv = j;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzpu.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzpx = true;
            }
        }

        public void cancel() {
            this.zzpw.countDown();
        }

        public void run() {
            try {
                if (!this.zzpw.await(this.zzpv, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }

        public boolean zzaV() {
            return this.zzpx;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long timeoutInMillis) {
        this.zzpr = new Object();
        zzx.zzD(context);
        this.mContext = context;
        this.zzpq = false;
        this.zzpt = timeoutInMillis;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.zzb(false);
            Info info = advertisingIdClient.getInfo();
            return info;
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean shouldSkipGmsCoreVersionCheck) {
    }

    static zzbc zza(Context context, com.google.android.gms.common.zza com_google_android_gms_common_zza) throws IOException {
        try {
            return com.google.android.gms.internal.zzbc.zza.zzg(com_google_android_gms_common_zza.zzoW());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private void zzaU() {
        synchronized (this.zzpr) {
            if (this.zzps != null) {
                this.zzps.cancel();
                try {
                    this.zzps.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzpt > 0) {
                this.zzps = new zza(this, this.zzpt);
            }
        }
    }

    static com.google.android.gms.common.zza zzq(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context)) {
                case 0:
                case 2:
                    ServiceConnection com_google_android_gms_common_zza = new com.google.android.gms.common.zza();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (zzb.zzrU().zza(context, intent, com_google_android_gms_common_zza, 1)) {
                            return com_google_android_gms_common_zza;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        IOException iOException = new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException e) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.zzx.zzcD(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.zzpo;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.zzpq;	 Catch:{ IllegalArgumentException -> 0x002d }
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = com.google.android.gms.common.stats.zzb.zzrU();	 Catch:{ IllegalArgumentException -> 0x002d }
        r1 = r3.mContext;	 Catch:{ IllegalArgumentException -> 0x002d }
        r2 = r3.zzpo;	 Catch:{ IllegalArgumentException -> 0x002d }
        r0.zza(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002d }
    L_0x001f:
        r0 = 0;
        r3.zzpq = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzpp = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzpo = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        goto L_0x000f;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x002a }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() throws IOException {
        Info info;
        zzx.zzcD("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzpq) {
                synchronized (this.zzpr) {
                    if (this.zzps == null || !this.zzps.zzaV()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zzb(false);
                    if (!this.zzpq) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzx.zzD(this.zzpo);
            zzx.zzD(this.zzpp);
            info = new Info(this.zzpp.getId(), this.zzpp.zzc(true));
        }
        zzaU();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb(true);
    }

    protected void zzb(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzx.zzcD("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzpq) {
                finish();
            }
            this.zzpo = zzq(this.mContext);
            this.zzpp = zza(this.mContext, this.zzpo);
            this.zzpq = true;
            if (z) {
                zzaU();
            }
        }
    }
}

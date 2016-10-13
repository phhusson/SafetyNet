package com.google.android.gms.internal;

import android.content.Context;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.ClearcutLoggerApi;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.zzg;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class zznc implements ClearcutLoggerApi {
    private static final Object zzapn = new Object();
    private static ScheduledExecutorService zzapo;
    private static final zze zzapp = new zze();
    private static final long zzapq = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    private GoogleApiClient mApiClient;
    private final zza zzapr;
    private final Object zzaps;
    private long zzapt;
    private final long zzapu;
    private ScheduledFuture<?> zzapv;
    private final Runnable zzapw;
    private final Clock zzrA;

    class C04821 implements Runnable {
        final /* synthetic */ zznc zzapx;

        C04821(zznc com_google_android_gms_internal_zznc) {
            this.zzapx = com_google_android_gms_internal_zznc;
        }

        public void run() {
            synchronized (this.zzapx.zzaps) {
                if (this.zzapx.zzapt <= this.zzapx.zzrA.elapsedRealtime() && this.zzapx.mApiClient != null) {
                    Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                    this.zzapx.mApiClient.disconnect();
                    this.zzapx.mApiClient = null;
                }
            }
        }
    }

    class C04842 implements ThreadFactory {
        final /* synthetic */ zznc zzapx;

        C04842(zznc com_google_android_gms_internal_zznc) {
            this.zzapx = com_google_android_gms_internal_zznc;
        }

        public Thread newThread(final Runnable r) {
            return new Thread(new Runnable(this) {
                final /* synthetic */ C04842 zzapz;

                public void run() {
                    Process.setThreadPriority(10);
                    r.run();
                }
            }, "ClearcutLoggerApiImpl");
        }
    }

    static abstract class zzc<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zznd> {
        public zzc(GoogleApiClient googleApiClient) {
            super(ClearcutLogger.zzVj, googleApiClient);
        }
    }

    class C04896 implements com.google.android.gms.common.api.PendingResult.zza {
        final /* synthetic */ zznc zzapx;

        C04896(zznc com_google_android_gms_internal_zznc) {
            this.zzapx = com_google_android_gms_internal_zznc;
        }

        public void zzD(Status status) {
            zznc.zzapp.zzoV();
        }
    }

    public interface zza {
        GoogleApiClient zzak(Context context);
    }

    public static class zzb implements zza {
        public GoogleApiClient zzak(Context context) {
            return new Builder(context).addApi(ClearcutLogger.API).build();
        }
    }

    final class zzd extends zzc<Status> {
        private final LogEventParcelable zzapF;
        final /* synthetic */ zznc zzapx;

        class C04901 extends com.google.android.gms.internal.zzne.zza {
            final /* synthetic */ zzd zzapG;

            C04901(zzd com_google_android_gms_internal_zznc_zzd) {
                this.zzapG = com_google_android_gms_internal_zznc_zzd;
            }

            public void zzE(Status status) {
                this.zzapG.zza((Result) status);
            }
        }

        zzd(zznc com_google_android_gms_internal_zznc, LogEventParcelable logEventParcelable, GoogleApiClient googleApiClient) {
            this.zzapx = com_google_android_gms_internal_zznc;
            super(googleApiClient);
            this.zzapF = logEventParcelable;
        }

        public boolean equals(Object rhs) {
            if (!(rhs instanceof zzd)) {
                return false;
            }
            return this.zzapF.equals(((zzd) rhs).zzapF);
        }

        public String toString() {
            return "MethodImpl(" + this.zzapF + ")";
        }

        protected void zza(zznd com_google_android_gms_internal_zznd) throws RemoteException {
            zzne c04901 = new C04901(this);
            try {
                zznc.zza(this.zzapF);
                com_google_android_gms_internal_zznd.zza(c04901, this.zzapF);
            } catch (Throwable th) {
                Log.e("ClearcutLoggerApiImpl", "MessageNanoProducer " + this.zzapF.extensionProducer.toString() + " threw: " + th.toString());
            }
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    private static final class zze {
        private int mSize;

        private zze() {
            this.mSize = 0;
        }

        public synchronized void increment() {
            this.mSize++;
        }

        public synchronized boolean isZero() {
            return this.mSize == 0;
        }

        public boolean zza(long j, TimeUnit timeUnit) throws InterruptedException {
            boolean z;
            long currentTimeMillis = System.currentTimeMillis();
            long convert = TimeUnit.MILLISECONDS.convert(j, timeUnit);
            synchronized (this) {
                while (this.mSize != 0) {
                    if (convert <= 0) {
                        z = false;
                        break;
                    }
                    wait(convert);
                    convert -= System.currentTimeMillis() - currentTimeMillis;
                }
                z = true;
            }
            return z;
        }

        public synchronized void zzoV() {
            if (this.mSize == 0) {
                throw new RuntimeException("too many decrements");
            }
            this.mSize--;
            if (this.mSize == 0) {
                notifyAll();
            }
        }
    }

    public zznc() {
        this(new zzg(), zzapq, new zzb());
    }

    public zznc(Clock clock, long j, zza com_google_android_gms_internal_zznc_zza) {
        this.zzaps = new Object();
        this.zzapt = 0;
        this.zzapv = null;
        this.mApiClient = null;
        this.zzapw = new C04821(this);
        this.zzrA = clock;
        this.zzapu = j;
        this.zzapr = com_google_android_gms_internal_zznc_zza;
    }

    private PendingResult<Status> zza(final GoogleApiClient googleApiClient, final zzc<Status> com_google_android_gms_internal_zznc_zzc_com_google_android_gms_common_api_Status) {
        zzoT().execute(new Runnable(this) {
            final /* synthetic */ zznc zzapx;

            public void run() {
                googleApiClient.zza(com_google_android_gms_internal_zznc_zzc_com_google_android_gms_common_api_Status);
            }
        });
        return com_google_android_gms_internal_zznc_zzc_com_google_android_gms_common_api_Status;
    }

    private zzd zza(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        zzapp.increment();
        zzd com_google_android_gms_internal_zznc_zzd = new zzd(this, logEventParcelable, googleApiClient);
        com_google_android_gms_internal_zznc_zzd.zza(new C04896(this));
        return com_google_android_gms_internal_zznc_zzd;
    }

    private static void zza(LogEventParcelable logEventParcelable) {
        if (logEventParcelable.extensionProducer != null && logEventParcelable.logEvent.zzcrI.length == 0) {
            logEventParcelable.logEvent.zzcrI = logEventParcelable.extensionProducer.toProtoBytes();
        }
        if (logEventParcelable.clientVisualElementsProducer != null && logEventParcelable.logEvent.zzcrP.length == 0) {
            logEventParcelable.logEvent.zzcrP = logEventParcelable.clientVisualElementsProducer.toProtoBytes();
        }
        logEventParcelable.logEventBytes = zzain.toByteArray(logEventParcelable.logEvent);
    }

    private ScheduledExecutorService zzoT() {
        synchronized (zzapn) {
            if (zzapo == null) {
                zzapo = Executors.newSingleThreadScheduledExecutor(new C04842(this));
            }
        }
        return zzapo;
    }

    public void disconnectAsync(final GoogleApiClient apiClient) {
        final com.google.android.gms.common.api.internal.zza.zza c04874 = new zzc<Status>(this, apiClient) {
            private int zzapB = 5;
            final /* synthetic */ zznc zzapx;

            protected void zza(zznd com_google_android_gms_internal_zznd) throws RemoteException {
                if (this.zzapB < 0) {
                    apiClient.disconnect();
                    return;
                }
                if (zznc.zzapp.isZero()) {
                    this.zzapB = 0;
                }
                this.zzapB--;
                this.zzapx.zzoT().schedule(new Runnable(this) {
                    final /* synthetic */ C04874 zzapD;

                    public void run() {
                        this.zzapD.zzapx.zza(apiClient, this);
                    }
                }, 200, TimeUnit.MILLISECONDS);
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzd(status);
            }

            protected Status zzd(Status status) {
                return status;
            }
        };
        synchronized (zzapn) {
            if (zzapo == null) {
                apiClient.zza(c04874);
            } else {
                zzapo.execute(new Runnable(this) {
                    final /* synthetic */ zznc zzapx;

                    public void run() {
                        apiClient.zza(c04874);
                    }
                });
            }
        }
    }

    public boolean flush(GoogleApiClient apiClient, long waitTime, TimeUnit unit) {
        try {
            return zzapp.zza(waitTime, unit);
        } catch (InterruptedException e) {
            Log.e("ClearcutLoggerApiImpl", "flush interrupted");
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public PendingResult<Status> logEvent(GoogleApiClient apiClient, LogEventParcelable logEvent) {
        zza(logEvent);
        return apiClient.zza(zza(apiClient, logEvent));
    }

    public PendingResult<Status> logEventAsync(Context context, LogEventParcelable logEvent) {
        PendingResult<Status> logEventAsync;
        synchronized (this.zzaps) {
            if (this.mApiClient == null) {
                this.mApiClient = this.zzapr.zzak(context);
                this.mApiClient.connect();
            }
            this.zzapt = this.zzrA.elapsedRealtime() + this.zzapu;
            if (this.zzapv != null) {
                this.zzapv.cancel(false);
            }
            this.zzapv = zzoT().schedule(this.zzapw, this.zzapu, TimeUnit.MILLISECONDS);
            logEventAsync = logEventAsync(this.mApiClient, logEvent);
        }
        return logEventAsync;
    }

    public PendingResult<Status> logEventAsync(GoogleApiClient apiClient, LogEventParcelable logEvent) {
        return zza(apiClient, zza(apiClient, logEvent));
    }
}

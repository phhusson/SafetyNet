package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultStore;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzb<R extends Result> extends PendingResult<R> {
    private boolean zzK;
    private volatile R zzaqH;
    private final Object zzaqR = new Object();
    protected final zza<R> zzaqS;
    private final WeakReference<GoogleApiClient> zzaqT;
    private final ArrayList<com.google.android.gms.common.api.PendingResult.zza> zzaqU = new ArrayList();
    private ResultCallback<? super R> zzaqV;
    private volatile boolean zzaqW;
    private boolean zzaqX;
    private boolean zzaqY;
    private zzq zzaqZ;
    private Integer zzara;
    private volatile zzac<R> zzarb;
    private final CountDownLatch zzqn = new CountDownLatch(1);

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((zzb) msg.obj).zzG(Status.zzaqO);
                    return;
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + msg.what, new Exception());
                    return;
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzb<R> com_google_android_gms_common_api_internal_zzb_R, long j) {
            sendMessageDelayed(obtainMessage(2, com_google_android_gms_common_api_internal_zzb_R), j);
        }

        protected void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzb.zzc(r);
                throw e;
            }
        }

        public void zzpv() {
            removeMessages(2);
        }
    }

    @Deprecated
    protected zzb(Looper looper) {
        this.zzaqS = new zza(looper);
        this.zzaqT = new WeakReference(null);
    }

    protected zzb(GoogleApiClient googleApiClient) {
        this.zzaqS = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zzaqT = new WeakReference(googleApiClient);
    }

    private R get() {
        R r;
        boolean z = true;
        synchronized (this.zzaqR) {
            if (this.zzaqW) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed.");
            zzx.zza(isReady(), (Object) "Result is not ready.");
            r = this.zzaqH;
            this.zzaqH = null;
            this.zzaqV = null;
            this.zzaqW = true;
        }
        zzpt();
        return r;
    }

    private void zzb(R r) {
        this.zzaqH = r;
        this.zzaqZ = null;
        this.zzqn.countDown();
        Status status = this.zzaqH.getStatus();
        if (this.zzaqV != null) {
            this.zzaqS.zzpv();
            if (!this.zzK) {
                this.zzaqS.zza(this.zzaqV, get());
            }
        }
        Iterator it = this.zzaqU.iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.PendingResult.zza) it.next()).zzD(status);
        }
        this.zzaqU.clear();
    }

    public static void zzc(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                Log.w("BasePendingResult", "Unable to release " + result, e);
            }
        }
    }

    public final R await() {
        boolean z = true;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        zzx.zza(!this.zzaqW, (Object) "Result has already been consumed");
        if (this.zzarb != null) {
            z = false;
        }
        zzx.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            this.zzqn.await();
        } catch (InterruptedException e) {
            zzG(Status.zzaqM);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public final R await(long time, TimeUnit units) {
        boolean z = true;
        boolean z2 = time <= 0 || Looper.myLooper() != Looper.getMainLooper();
        zzx.zza(z2, (Object) "await must not be called on the UI thread when time is greater than zero.");
        zzx.zza(!this.zzaqW, (Object) "Result has already been consumed.");
        if (this.zzarb != null) {
            z = false;
        }
        zzx.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.zzqn.await(time, units)) {
                zzG(Status.zzaqO);
            }
        } catch (InterruptedException e) {
            zzG(Status.zzaqM);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
        r2 = this;
        r1 = r2.zzaqR;
        monitor-enter(r1);
        r0 = r2.zzK;	 Catch:{ all -> 0x002c }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.zzaqW;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x002c }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.zzaqZ;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r2.zzaqZ;	 Catch:{ RemoteException -> 0x002f }
        r0.cancel();	 Catch:{ RemoteException -> 0x002f }
    L_0x0016:
        r0 = r2.zzaqH;	 Catch:{ all -> 0x002c }
        zzc(r0);	 Catch:{ all -> 0x002c }
        r0 = 0;
        r2.zzaqV = r0;	 Catch:{ all -> 0x002c }
        r0 = 1;
        r2.zzK = r0;	 Catch:{ all -> 0x002c }
        r0 = com.google.android.gms.common.api.Status.zzaqP;	 Catch:{ all -> 0x002c }
        r0 = r2.zzb(r0);	 Catch:{ all -> 0x002c }
        r2.zzb(r0);	 Catch:{ all -> 0x002c }
        monitor-exit(r1);	 Catch:{ all -> 0x002c }
        goto L_0x000c;
    L_0x002c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002c }
        throw r0;
    L_0x002f:
        r0 = move-exception;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzb.cancel():void");
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzaqR) {
            z = this.zzK;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzqn.getCount() == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r5) {
        /*
        r4 = this;
        r1 = 1;
        r2 = 0;
        r0 = r4.zzaqW;
        if (r0 != 0) goto L_0x0020;
    L_0x0006:
        r0 = r1;
    L_0x0007:
        r3 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzx.zza(r0, r3);
        r3 = r4.zzaqR;
        monitor-enter(r3);
        r0 = r4.zzarb;	 Catch:{ all -> 0x003b }
        if (r0 != 0) goto L_0x0022;
    L_0x0013:
        r0 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzx.zza(r1, r0);	 Catch:{ all -> 0x003b }
        r0 = r4.isCanceled();	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x0024;
    L_0x001e:
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
    L_0x001f:
        return;
    L_0x0020:
        r0 = r2;
        goto L_0x0007;
    L_0x0022:
        r1 = r2;
        goto L_0x0013;
    L_0x0024:
        r0 = r4.zzaqY;	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x003e;
    L_0x0028:
        r0 = r4.zzaqT;	 Catch:{ all -> 0x003b }
        r0 = r0.get();	 Catch:{ all -> 0x003b }
        r0 = (com.google.android.gms.common.api.GoogleApiClient) r0;	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x0036;
    L_0x0032:
        r0 = r5 instanceof com.google.android.gms.common.api.internal.zzac;	 Catch:{ all -> 0x003b }
        if (r0 != 0) goto L_0x003e;
    L_0x0036:
        r4.cancel();	 Catch:{ all -> 0x003b }
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
        goto L_0x001f;
    L_0x003b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
        throw r0;
    L_0x003e:
        r0 = r4.isReady();	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x004f;
    L_0x0044:
        r0 = r4.zzaqS;	 Catch:{ all -> 0x003b }
        r1 = r4.get();	 Catch:{ all -> 0x003b }
        r0.zza(r5, r1);	 Catch:{ all -> 0x003b }
    L_0x004d:
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
        goto L_0x001f;
    L_0x004f:
        r4.zzaqV = r5;	 Catch:{ all -> 0x003b }
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzb.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
        r6 = this;
        r1 = 1;
        r2 = 0;
        r0 = r6.zzaqW;
        if (r0 != 0) goto L_0x0020;
    L_0x0006:
        r0 = r1;
    L_0x0007:
        r3 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzx.zza(r0, r3);
        r3 = r6.zzaqR;
        monitor-enter(r3);
        r0 = r6.zzarb;	 Catch:{ all -> 0x003b }
        if (r0 != 0) goto L_0x0022;
    L_0x0013:
        r0 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzx.zza(r1, r0);	 Catch:{ all -> 0x003b }
        r0 = r6.isCanceled();	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x0024;
    L_0x001e:
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
    L_0x001f:
        return;
    L_0x0020:
        r0 = r2;
        goto L_0x0007;
    L_0x0022:
        r1 = r2;
        goto L_0x0013;
    L_0x0024:
        r0 = r6.zzaqY;	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x003e;
    L_0x0028:
        r0 = r6.zzaqT;	 Catch:{ all -> 0x003b }
        r0 = r0.get();	 Catch:{ all -> 0x003b }
        r0 = (com.google.android.gms.common.api.GoogleApiClient) r0;	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x0036;
    L_0x0032:
        r0 = r7 instanceof com.google.android.gms.common.api.internal.zzac;	 Catch:{ all -> 0x003b }
        if (r0 != 0) goto L_0x003e;
    L_0x0036:
        r6.cancel();	 Catch:{ all -> 0x003b }
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
        goto L_0x001f;
    L_0x003b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
        throw r0;
    L_0x003e:
        r0 = r6.isReady();	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x004f;
    L_0x0044:
        r0 = r6.zzaqS;	 Catch:{ all -> 0x003b }
        r1 = r6.get();	 Catch:{ all -> 0x003b }
        r0.zza(r7, r1);	 Catch:{ all -> 0x003b }
    L_0x004d:
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
        goto L_0x001f;
    L_0x004f:
        r6.zzaqV = r7;	 Catch:{ all -> 0x003b }
        r0 = r6.zzaqS;	 Catch:{ all -> 0x003b }
        r4 = r10.toMillis(r8);	 Catch:{ all -> 0x003b }
        r0.zza(r6, r4);	 Catch:{ all -> 0x003b }
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzb.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    public void store(ResultStore resultStore, int resultId) {
        zzx.zzb((Object) resultStore, (Object) "ResultStore must not be null.");
        synchronized (this.zzaqR) {
            zzx.zza(!this.zzaqW, (Object) "Result has already been consumed.");
            resultStore.zza(resultId, this);
        }
    }

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> transform) {
        TransformedResult<S> then;
        boolean z = true;
        zzx.zza(!this.zzaqW, (Object) "Result has already been consumed.");
        synchronized (this.zzaqR) {
            zzx.zza(this.zzarb == null, (Object) "Cannot call then() twice.");
            if (this.zzaqV != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot call then() if callbacks are set.");
            this.zzarb = new zzac(this.zzaqT);
            then = this.zzarb.then(transform);
            if (isReady()) {
                this.zzaqS.zza(this.zzarb, get());
            } else {
                this.zzaqV = this.zzarb;
            }
        }
        return then;
    }

    public final void zzG(Status status) {
        synchronized (this.zzaqR) {
            if (!isReady()) {
                zza(zzb(status));
                this.zzaqX = true;
            }
        }
    }

    public final void zza(com.google.android.gms.common.api.PendingResult.zza com_google_android_gms_common_api_PendingResult_zza) {
        boolean z = true;
        zzx.zza(!this.zzaqW, (Object) "Result has already been consumed.");
        if (com_google_android_gms_common_api_PendingResult_zza == null) {
            z = false;
        }
        zzx.zzb(z, (Object) "Callback cannot be null.");
        synchronized (this.zzaqR) {
            if (isReady()) {
                com_google_android_gms_common_api_PendingResult_zza.zzD(this.zzaqH.getStatus());
            } else {
                this.zzaqU.add(com_google_android_gms_common_api_PendingResult_zza);
            }
        }
    }

    public final void zza(R r) {
        boolean z = true;
        synchronized (this.zzaqR) {
            if (this.zzaqX || this.zzK) {
                zzc(r);
                return;
            }
            zzx.zza(!isReady(), (Object) "Results have already been set");
            if (this.zzaqW) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed");
            zzb((Result) r);
        }
    }

    protected final void zza(zzq com_google_android_gms_common_internal_zzq) {
        synchronized (this.zzaqR) {
            this.zzaqZ = com_google_android_gms_common_internal_zzq;
        }
    }

    protected abstract R zzb(Status status);

    public void zzcN(int i) {
        zzx.zzb(this.zzara == null, (Object) "PendingResult should only be stored once.");
        this.zzara = Integer.valueOf(i);
    }

    public Integer zzpp() {
        return this.zzara;
    }

    protected void zzpt() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzpu() {
        /*
        r2 = this;
        r1 = r2.zzaqR;
        monitor-enter(r1);
        r0 = r2.zzaqT;	 Catch:{ all -> 0x0021 }
        r0 = r0.get();	 Catch:{ all -> 0x0021 }
        r0 = (com.google.android.gms.common.api.GoogleApiClient) r0;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x0012;
    L_0x000d:
        r2.cancel();	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r2.zzaqV;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x001c;
    L_0x0016:
        r0 = r2.zzaqV;	 Catch:{ all -> 0x0021 }
        r0 = r0 instanceof com.google.android.gms.common.api.internal.zzac;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0024;
    L_0x001c:
        r0 = 1;
        r2.zzaqY = r0;	 Catch:{ all -> 0x0021 }
    L_0x001f:
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        goto L_0x0011;
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        throw r0;
    L_0x0024:
        r2.cancel();	 Catch:{ all -> 0x0021 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzb.zzpu():void");
    }
}

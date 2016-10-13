package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzxi;
import com.google.android.gms.internal.zzxj;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzl implements zzp {
    private final Context mContext;
    private final Lock zzZo;
    private final GoogleApiAvailabilityLight zzaqB;
    final com.google.android.gms.common.api.Api.zza<? extends zzxi, zzxj> zzaqC;
    final zzf zzarI;
    final Map<Api<?>, Integer> zzarJ;
    final zzj zzarf;
    final com.google.android.gms.common.api.internal.zzp.zza zzasA;
    final Map<zzc<?>, com.google.android.gms.common.api.Api.zzb> zzasc;
    private final Condition zzasu;
    private final zzb zzasv;
    final Map<zzc<?>, ConnectionResult> zzasw = new HashMap();
    private volatile zzk zzasx;
    private ConnectionResult zzasy = null;
    int zzasz;

    static abstract class zza {
        private final zzk zzasB;

        protected zza(zzk com_google_android_gms_common_api_internal_zzk) {
            this.zzasB = com_google_android_gms_common_api_internal_zzk;
        }

        public final void zzd(zzl com_google_android_gms_common_api_internal_zzl) {
            com_google_android_gms_common_api_internal_zzl.zzZo.lock();
            try {
                if (com_google_android_gms_common_api_internal_zzl.zzasx == this.zzasB) {
                    zzpH();
                    com_google_android_gms_common_api_internal_zzl.zzZo.unlock();
                }
            } finally {
                com_google_android_gms_common_api_internal_zzl.zzZo.unlock();
            }
        }

        protected abstract void zzpH();
    }

    final class zzb extends Handler {
        final /* synthetic */ zzl zzasC;

        zzb(zzl com_google_android_gms_common_api_internal_zzl, Looper looper) {
            this.zzasC = com_google_android_gms_common_api_internal_zzl;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    ((zza) msg.obj).zzd(this.zzasC);
                    return;
                case 2:
                    throw ((RuntimeException) msg.obj);
                default:
                    Log.w("GACStateManager", "Unknown message id: " + msg.what);
                    return;
            }
        }
    }

    public zzl(Context context, zzj com_google_android_gms_common_api_internal_zzj, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<zzc<?>, com.google.android.gms.common.api.Api.zzb> map, zzf com_google_android_gms_common_internal_zzf, Map<Api<?>, Integer> map2, com.google.android.gms.common.api.Api.zza<? extends zzxi, zzxj> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzxi__com_google_android_gms_internal_zzxj, ArrayList<zzc> arrayList, com.google.android.gms.common.api.internal.zzp.zza com_google_android_gms_common_api_internal_zzp_zza) {
        this.mContext = context;
        this.zzZo = lock;
        this.zzaqB = googleApiAvailabilityLight;
        this.zzasc = map;
        this.zzarI = com_google_android_gms_common_internal_zzf;
        this.zzarJ = map2;
        this.zzaqC = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzxi__com_google_android_gms_internal_zzxj;
        this.zzarf = com_google_android_gms_common_api_internal_zzj;
        this.zzasA = com_google_android_gms_common_api_internal_zzp_zza;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((zzc) it.next()).zza(this);
        }
        this.zzasv = new zzb(this, looper);
        this.zzasu = lock.newCondition();
        this.zzasx = new zzi(this);
    }

    public ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zzasu.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        return isConnected() ? ConnectionResult.zzapJ : this.zzasy != null ? this.zzasy : new ConnectionResult(13, null);
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        connect();
        long toNanos = unit.toNanos(timeout);
        while (isConnecting()) {
            if (toNanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, null);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, null);
                }
            }
            toNanos = this.zzasu.awaitNanos(toNanos);
        }
        if (isConnected()) {
            return ConnectionResult.zzapJ;
        }
        return this.zzasy != null ? this.zzasy : new ConnectionResult(13, null);
    }

    public void connect() {
        this.zzasx.connect();
    }

    public boolean disconnect() {
        boolean disconnect = this.zzasx.disconnect();
        if (disconnect) {
            this.zzasw.clear();
        }
        return disconnect;
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        String str = prefix + "  ";
        for (Api api : this.zzarJ.keySet()) {
            writer.append(prefix).append(api.getName()).println(":");
            ((com.google.android.gms.common.api.Api.zzb) this.zzasc.get(api.zzpg())).dump(str, fd, writer, args);
        }
    }

    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        zzc zzpg = api.zzpg();
        if (this.zzasc.containsKey(zzpg)) {
            if (((com.google.android.gms.common.api.Api.zzb) this.zzasc.get(zzpg)).isConnected()) {
                return ConnectionResult.zzapJ;
            }
            if (this.zzasw.containsKey(zzpg)) {
                return (ConnectionResult) this.zzasw.get(zzpg);
            }
        }
        return null;
    }

    public boolean isConnected() {
        return this.zzasx instanceof zzg;
    }

    public boolean isConnecting() {
        return this.zzasx instanceof zzh;
    }

    public void onConnected(@Nullable Bundle connectionHint) {
        this.zzZo.lock();
        try {
            this.zzasx.onConnected(connectionHint);
        } finally {
            this.zzZo.unlock();
        }
    }

    public void onConnectionSuspended(int cause) {
        this.zzZo.lock();
        try {
            this.zzasx.onConnectionSuspended(cause);
        } finally {
            this.zzZo.unlock();
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.common.api.internal.zza.zza<R, A>> T zza(@NonNull T t) {
        return this.zzasx.zza(t);
    }

    public void zza(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, int i) {
        this.zzZo.lock();
        try {
            this.zzasx.zza(connectionResult, api, i);
        } finally {
            this.zzZo.unlock();
        }
    }

    void zza(zza com_google_android_gms_common_api_internal_zzl_zza) {
        this.zzasv.sendMessage(this.zzasv.obtainMessage(1, com_google_android_gms_common_api_internal_zzl_zza));
    }

    public boolean zza(zzx com_google_android_gms_common_api_internal_zzx) {
        return false;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.common.api.internal.zza.zza<? extends Result, A>> T zzb(@NonNull T t) {
        return this.zzasx.zzb(t);
    }

    void zzb(RuntimeException runtimeException) {
        this.zzasv.sendMessage(this.zzasv.obtainMessage(2, runtimeException));
    }

    void zzh(ConnectionResult connectionResult) {
        this.zzZo.lock();
        try {
            this.zzasy = connectionResult;
            this.zzasx = new zzi(this);
            this.zzasx.begin();
            this.zzasu.signalAll();
        } finally {
            this.zzZo.unlock();
        }
    }

    void zzpY() {
        this.zzZo.lock();
        try {
            this.zzasx = new zzh(this, this.zzarI, this.zzarJ, this.zzaqB, this.zzaqC, this.zzZo, this.mContext);
            this.zzasx.begin();
            this.zzasu.signalAll();
        } finally {
            this.zzZo.unlock();
        }
    }

    void zzpZ() {
        this.zzZo.lock();
        try {
            this.zzarf.zzpT();
            this.zzasx = new zzg(this);
            this.zzasx.begin();
            this.zzasu.signalAll();
        } finally {
            this.zzZo.unlock();
        }
    }

    public void zzpl() {
    }

    public void zzpx() {
        if (isConnected()) {
            ((zzg) this.zzasx).zzpG();
        }
    }

    void zzqa() {
        for (com.google.android.gms.common.api.Api.zzb disconnect : this.zzasc.values()) {
            disconnect.disconnect();
        }
    }
}

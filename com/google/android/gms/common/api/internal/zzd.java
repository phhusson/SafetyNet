package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzp.zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzxi;
import com.google.android.gms.internal.zzxj;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class zzd implements zzp {
    private final Context mContext;
    private final Lock zzZo;
    private final zzj zzarf;
    private final zzl zzarg;
    private final zzl zzarh;
    private final Map<zzc<?>, zzl> zzari = new ArrayMap();
    private final Set<zzx> zzarj = Collections.newSetFromMap(new WeakHashMap());
    private final zzb zzark;
    private Bundle zzarl;
    private ConnectionResult zzarm = null;
    private ConnectionResult zzarn = null;
    private boolean zzaro = false;
    private int zzarp = 0;
    private final Looper zzoN;

    class C01961 implements zza {
        final /* synthetic */ zzd zzarq;

        C01961(zzd com_google_android_gms_common_api_internal_zzd) {
            this.zzarq = com_google_android_gms_common_api_internal_zzd;
        }

        public void zzd(@NonNull ConnectionResult connectionResult) {
            this.zzarq.zzZo.lock();
            try {
                this.zzarq.zzarm = connectionResult;
                this.zzarq.zzpA();
            } finally {
                this.zzarq.zzZo.unlock();
            }
        }

        public void zze(int i, boolean z) {
            this.zzarq.zzZo.lock();
            try {
                if (this.zzarq.zzaro || this.zzarq.zzarn == null || !this.zzarq.zzarn.isSuccess()) {
                    this.zzarq.zzaro = false;
                    this.zzarq.zzd(i, z);
                    return;
                }
                this.zzarq.zzaro = true;
                this.zzarq.zzarh.onConnectionSuspended(i);
                this.zzarq.zzZo.unlock();
            } finally {
                this.zzarq.zzZo.unlock();
            }
        }

        public void zzo(@Nullable Bundle bundle) {
            this.zzarq.zzZo.lock();
            try {
                this.zzarq.zzn(bundle);
                this.zzarq.zzarm = ConnectionResult.zzapJ;
                this.zzarq.zzpA();
            } finally {
                this.zzarq.zzZo.unlock();
            }
        }
    }

    class C01972 implements zza {
        final /* synthetic */ zzd zzarq;

        C01972(zzd com_google_android_gms_common_api_internal_zzd) {
            this.zzarq = com_google_android_gms_common_api_internal_zzd;
        }

        public void zzd(@NonNull ConnectionResult connectionResult) {
            this.zzarq.zzZo.lock();
            try {
                this.zzarq.zzarn = connectionResult;
                this.zzarq.zzpA();
            } finally {
                this.zzarq.zzZo.unlock();
            }
        }

        public void zze(int i, boolean z) {
            this.zzarq.zzZo.lock();
            try {
                if (this.zzarq.zzaro) {
                    this.zzarq.zzaro = false;
                    this.zzarq.zzd(i, z);
                    return;
                }
                this.zzarq.zzaro = true;
                this.zzarq.zzarg.onConnectionSuspended(i);
                this.zzarq.zzZo.unlock();
            } finally {
                this.zzarq.zzZo.unlock();
            }
        }

        public void zzo(@Nullable Bundle bundle) {
            this.zzarq.zzZo.lock();
            try {
                this.zzarq.zzarn = ConnectionResult.zzapJ;
                this.zzarq.zzpA();
            } finally {
                this.zzarq.zzZo.unlock();
            }
        }
    }

    class C01983 implements Runnable {
        final /* synthetic */ zzd zzarq;

        C01983(zzd com_google_android_gms_common_api_internal_zzd) {
            this.zzarq = com_google_android_gms_common_api_internal_zzd;
        }

        public void run() {
            this.zzarq.zzZo.lock();
            try {
                this.zzarq.zzpA();
            } finally {
                this.zzarq.zzZo.unlock();
            }
        }
    }

    public zzd(Context context, zzj com_google_android_gms_common_api_internal_zzj, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<zzc<?>, zzb> map, zzf com_google_android_gms_common_internal_zzf, Map<Api<?>, Integer> map2, Api.zza<? extends zzxi, zzxj> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzxi__com_google_android_gms_internal_zzxj, ArrayList<zzc> arrayList) {
        this.mContext = context;
        this.zzarf = com_google_android_gms_common_api_internal_zzj;
        this.zzZo = lock;
        this.zzoN = looper;
        zzb com_google_android_gms_common_api_Api_zzb = null;
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        for (zzc com_google_android_gms_common_api_Api_zzc : map.keySet()) {
            zzb com_google_android_gms_common_api_Api_zzb2 = (zzb) map.get(com_google_android_gms_common_api_Api_zzc);
            if (com_google_android_gms_common_api_Api_zzb2.zzkJ()) {
                com_google_android_gms_common_api_Api_zzb = com_google_android_gms_common_api_Api_zzb2;
            }
            if (com_google_android_gms_common_api_Api_zzb2.zzkt()) {
                arrayMap.put(com_google_android_gms_common_api_Api_zzc, com_google_android_gms_common_api_Api_zzb2);
            } else {
                arrayMap2.put(com_google_android_gms_common_api_Api_zzc, com_google_android_gms_common_api_Api_zzb2);
            }
        }
        this.zzark = com_google_android_gms_common_api_Api_zzb;
        if (arrayMap.isEmpty()) {
            throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        }
        Map arrayMap3 = new ArrayMap();
        Map arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            zzc zzpg = api.zzpg();
            if (arrayMap.containsKey(zzpg)) {
                arrayMap3.put(api, map2.get(api));
            } else if (arrayMap2.containsKey(zzpg)) {
                arrayMap4.put(api, map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzc com_google_android_gms_common_api_internal_zzc = (zzc) it.next();
            if (arrayMap3.containsKey(com_google_android_gms_common_api_internal_zzc.zzarc)) {
                arrayList2.add(com_google_android_gms_common_api_internal_zzc);
            } else if (arrayMap4.containsKey(com_google_android_gms_common_api_internal_zzc.zzarc)) {
                arrayList3.add(com_google_android_gms_common_api_internal_zzc);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        Context context2 = context;
        this.zzarg = new zzl(context2, this.zzarf, lock, looper, googleApiAvailabilityLight, arrayMap2, null, arrayMap4, null, arrayList3, new C01961(this));
        Context context3 = context;
        this.zzarh = new zzl(context3, this.zzarf, lock, looper, googleApiAvailabilityLight, arrayMap, com_google_android_gms_common_internal_zzf, arrayMap3, com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzxi__com_google_android_gms_internal_zzxj, arrayList2, new C01972(this));
        for (zzc com_google_android_gms_common_api_Api_zzc2 : arrayMap2.keySet()) {
            this.zzari.put(com_google_android_gms_common_api_Api_zzc2, this.zzarg);
        }
        for (zzc com_google_android_gms_common_api_Api_zzc22 : arrayMap.keySet()) {
            this.zzari.put(com_google_android_gms_common_api_Api_zzc22, this.zzarh);
        }
    }

    private void zzb(ConnectionResult connectionResult) {
        switch (this.zzarp) {
            case 1:
                break;
            case 2:
                this.zzarf.zzd(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        zzpC();
        this.zzarp = 0;
    }

    private static boolean zzc(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private boolean zzc(zza.zza<? extends Result, ? extends zzb> com_google_android_gms_common_api_internal_zza_zza__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb) {
        zzc zzpg = com_google_android_gms_common_api_internal_zza_zza__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb.zzpg();
        zzx.zzb(this.zzari.containsKey(zzpg), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        return ((zzl) this.zzari.get(zzpg)).equals(this.zzarh);
    }

    private void zzd(int i, boolean z) {
        this.zzarf.zze(i, z);
        this.zzarn = null;
        this.zzarm = null;
    }

    private void zzn(Bundle bundle) {
        if (this.zzarl == null) {
            this.zzarl = bundle;
        } else if (bundle != null) {
            this.zzarl.putAll(bundle);
        }
    }

    private void zzpA() {
        if (zzc(this.zzarm)) {
            if (zzc(this.zzarn) || zzpD()) {
                zzpB();
            } else if (this.zzarn == null) {
            } else {
                if (this.zzarp == 1) {
                    zzpC();
                    return;
                }
                zzb(this.zzarn);
                this.zzarg.disconnect();
            }
        } else if (this.zzarm != null && zzc(this.zzarn)) {
            this.zzarh.disconnect();
            zzb(this.zzarm);
        } else if (this.zzarm != null && this.zzarn != null) {
            ConnectionResult connectionResult = this.zzarm;
            if (this.zzarh.zzasz < this.zzarg.zzasz) {
                connectionResult = this.zzarn;
            }
            zzb(connectionResult);
        }
    }

    private void zzpB() {
        switch (this.zzarp) {
            case 1:
                break;
            case 2:
                this.zzarf.zzo(this.zzarl);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        zzpC();
        this.zzarp = 0;
    }

    private void zzpC() {
        for (zzx zzkI : this.zzarj) {
            zzkI.zzkI();
        }
        this.zzarj.clear();
    }

    private boolean zzpD() {
        return this.zzarn != null && this.zzarn.getErrorCode() == 4;
    }

    @Nullable
    private PendingIntent zzpE() {
        return this.zzark == null ? null : PendingIntent.getActivity(this.mContext, this.zzarf.getSessionId(), this.zzark.zzkK(), 134217728);
    }

    private void zzpz() {
        this.zzarn = null;
        this.zzarm = null;
        this.zzarg.connect();
        this.zzarh.connect();
    }

    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public ConnectionResult blockingConnect(long timeout, @NonNull TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    public void connect() {
        this.zzarp = 2;
        this.zzaro = false;
        zzpz();
    }

    public boolean disconnect() {
        this.zzarn = null;
        this.zzarm = null;
        this.zzarp = 0;
        boolean disconnect = this.zzarg.disconnect();
        boolean disconnect2 = this.zzarh.disconnect();
        zzpC();
        return disconnect && disconnect2;
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append(prefix).append("authClient").println(":");
        this.zzarh.dump(prefix + "  ", fd, writer, args);
        writer.append(prefix).append("anonClient").println(":");
        this.zzarg.dump(prefix + "  ", fd, writer, args);
    }

    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        if (((zzl) this.zzari.get(api.zzpg())).equals(this.zzarh)) {
            return zzpD() ? new ConnectionResult(4, zzpE()) : this.zzarh.getConnectionResult(api);
        } else {
            return this.zzarg.getConnectionResult(api);
        }
    }

    public boolean isConnected() {
        boolean z = true;
        this.zzZo.lock();
        try {
            if (!(this.zzarg.isConnected() && (zzpy() || zzpD() || this.zzarp == 1))) {
                z = false;
            }
            this.zzZo.unlock();
            return z;
        } catch (Throwable th) {
            this.zzZo.unlock();
        }
    }

    public boolean isConnecting() {
        this.zzZo.lock();
        try {
            boolean z = this.zzarp == 2;
            this.zzZo.unlock();
            return z;
        } catch (Throwable th) {
            this.zzZo.unlock();
        }
    }

    public <A extends zzb, R extends Result, T extends zza.zza<R, A>> T zza(@NonNull T t) {
        if (!zzc((zza.zza) t)) {
            return this.zzarg.zza((zza.zza) t);
        }
        if (!zzpD()) {
            return this.zzarh.zza((zza.zza) t);
        }
        t.zzF(new Status(4, null, zzpE()));
        return t;
    }

    public boolean zza(zzx com_google_android_gms_common_api_internal_zzx) {
        this.zzZo.lock();
        try {
            if ((isConnecting() || isConnected()) && !zzpy()) {
                this.zzarj.add(com_google_android_gms_common_api_internal_zzx);
                if (this.zzarp == 0) {
                    this.zzarp = 1;
                }
                this.zzarn = null;
                this.zzarh.connect();
                return true;
            }
            this.zzZo.unlock();
            return false;
        } finally {
            this.zzZo.unlock();
        }
    }

    public <A extends zzb, T extends zza.zza<? extends Result, A>> T zzb(@NonNull T t) {
        if (!zzc((zza.zza) t)) {
            return this.zzarg.zzb((zza.zza) t);
        }
        if (!zzpD()) {
            return this.zzarh.zzb((zza.zza) t);
        }
        t.zzF(new Status(4, null, zzpE()));
        return t;
    }

    public void zzpl() {
        this.zzZo.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zzarh.disconnect();
            this.zzarn = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzoN).post(new C01983(this));
            } else {
                zzpC();
            }
            this.zzZo.unlock();
        } catch (Throwable th) {
            this.zzZo.unlock();
        }
    }

    public void zzpx() {
        this.zzarg.zzpx();
        this.zzarh.zzpx();
    }

    public boolean zzpy() {
        return this.zzarh.isConnected();
    }
}

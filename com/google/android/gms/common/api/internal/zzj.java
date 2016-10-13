package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzt;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultStore;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzxi;
import com.google.android.gms.internal.zzxj;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzj extends GoogleApiClient implements com.google.android.gms.common.api.internal.zzp.zza {
    private final Context mContext;
    private final Lock zzZo;
    private final Set<zzr<?>> zzaeD = Collections.newSetFromMap(new WeakHashMap());
    private final GoogleApiAvailabilityLight zzaqB;
    final com.google.android.gms.common.api.Api.zza<? extends zzxi, zzxj> zzaqC;
    private final int zzaqz;
    final zzf zzarI;
    final Map<Api<?>, Integer> zzarJ;
    private final zzk zzarU;
    private zzp zzarV = null;
    final Queue<com.google.android.gms.common.api.internal.zza.zza<?, ?>> zzarW = new LinkedList();
    private volatile boolean zzarX;
    private long zzarY = 120000;
    private long zzarZ = 5000;
    private final zza zzasa;
    zzc zzasb;
    final Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.Api.zzb> zzasc;
    Set<Scope> zzasd = new HashSet();
    final Set<zze<?>> zzase = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    private ResultStore zzasf;
    private final ArrayList<zzc> zzasg;
    private Integer zzash = null;
    Set<zzac> zzasi = null;
    private final zzd zzasj = new C02041(this);
    private final com.google.android.gms.common.internal.zzk.zza zzask = new C02052(this);
    private final Looper zzoN;

    interface zze<A extends com.google.android.gms.common.api.Api.zzb> {
        void cancel();

        boolean isReady();

        void zzF(Status status);

        void zzG(Status status);

        void zza(zzd com_google_android_gms_common_api_internal_zzj_zzd);

        void zzb(A a) throws DeadObjectException;

        com.google.android.gms.common.api.Api.zzc<A> zzpg();

        Integer zzpp();

        void zzps();

        void zzpu();
    }

    interface zzd {
        void zzc(zze<?> com_google_android_gms_common_api_internal_zzj_zze_);
    }

    class C02041 implements zzd {
        final /* synthetic */ zzj zzasl;

        C02041(zzj com_google_android_gms_common_api_internal_zzj) {
            this.zzasl = com_google_android_gms_common_api_internal_zzj;
        }

        public void zzc(zze<?> com_google_android_gms_common_api_internal_zzj_zze_) {
            this.zzasl.zzase.remove(com_google_android_gms_common_api_internal_zzj_zze_);
            if (com_google_android_gms_common_api_internal_zzj_zze_.zzpp() != null && this.zzasl.zzasf != null) {
                this.zzasl.zzasf.remove(com_google_android_gms_common_api_internal_zzj_zze_.zzpp().intValue());
            }
        }
    }

    class C02052 implements com.google.android.gms.common.internal.zzk.zza {
        final /* synthetic */ zzj zzasl;

        C02052(zzj com_google_android_gms_common_api_internal_zzj) {
            this.zzasl = com_google_android_gms_common_api_internal_zzj;
        }

        public boolean isConnected() {
            return this.zzasl.isConnected();
        }

        public Bundle zzor() {
            return null;
        }
    }

    final class zza extends Handler {
        final /* synthetic */ zzj zzasl;

        zza(zzj com_google_android_gms_common_api_internal_zzj, Looper looper) {
            this.zzasl = com_google_android_gms_common_api_internal_zzj;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.zzasl.zzpR();
                    return;
                case 2:
                    this.zzasl.resume();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + msg.what);
                    return;
            }
        }
    }

    private static class zzb implements DeathRecipient, zzd {
        private final WeakReference<zze<?>> zzasq;
        private final WeakReference<ResultStore> zzasr;
        private final WeakReference<IBinder> zzass;

        private zzb(zze com_google_android_gms_common_api_internal_zzj_zze, ResultStore resultStore, IBinder iBinder) {
            this.zzasr = new WeakReference(resultStore);
            this.zzasq = new WeakReference(com_google_android_gms_common_api_internal_zzj_zze);
            this.zzass = new WeakReference(iBinder);
        }

        private void zzpW() {
            zze com_google_android_gms_common_api_internal_zzj_zze = (zze) this.zzasq.get();
            ResultStore resultStore = (ResultStore) this.zzasr.get();
            if (!(resultStore == null || com_google_android_gms_common_api_internal_zzj_zze == null)) {
                resultStore.remove(com_google_android_gms_common_api_internal_zzj_zze.zzpp().intValue());
            }
            IBinder iBinder = (IBinder) this.zzass.get();
            if (this.zzass != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void binderDied() {
            zzpW();
        }

        public void zzc(zze<?> com_google_android_gms_common_api_internal_zzj_zze_) {
            zzpW();
        }
    }

    static class zzc extends zzn {
        private WeakReference<zzj> zzast;

        zzc(zzj com_google_android_gms_common_api_internal_zzj) {
            this.zzast = new WeakReference(com_google_android_gms_common_api_internal_zzj);
        }

        public void zzpX() {
            zzj com_google_android_gms_common_api_internal_zzj = (zzj) this.zzast.get();
            if (com_google_android_gms_common_api_internal_zzj != null) {
                com_google_android_gms_common_api_internal_zzj.resume();
            }
        }
    }

    public zzj(Context context, Lock lock, Looper looper, zzf com_google_android_gms_common_internal_zzf, GoogleApiAvailabilityLight googleApiAvailabilityLight, com.google.android.gms.common.api.Api.zza<? extends zzxi, zzxj> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzxi__com_google_android_gms_internal_zzxj, Map<Api<?>, Integer> map, List<ConnectionCallbacks> list, List<OnConnectionFailedListener> list2, Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.Api.zzb> map2, int i, int i2, ArrayList<zzc> arrayList) {
        this.mContext = context;
        this.zzZo = lock;
        this.zzarU = new zzk(looper, this.zzask);
        this.zzoN = looper;
        this.zzasa = new zza(this, looper);
        this.zzaqB = googleApiAvailabilityLight;
        this.zzaqz = i;
        if (this.zzaqz >= 0) {
            this.zzash = Integer.valueOf(i2);
        }
        this.zzarJ = map;
        this.zzasc = map2;
        this.zzasg = arrayList;
        for (ConnectionCallbacks registerConnectionCallbacks : list) {
            this.zzarU.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : list2) {
            this.zzarU.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.zzarI = com_google_android_gms_common_internal_zzf;
        this.zzaqC = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzxi__com_google_android_gms_internal_zzxj;
    }

    private void resume() {
        this.zzZo.lock();
        try {
            if (zzpP()) {
                zzpQ();
            }
            this.zzZo.unlock();
        } catch (Throwable th) {
            this.zzZo.unlock();
        }
    }

    public static int zza(Iterable<com.google.android.gms.common.api.Api.zzb> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb : iterable) {
            if (com_google_android_gms_common_api_Api_zzb.zzkt()) {
                i2 = 1;
            }
            i = com_google_android_gms_common_api_Api_zzb.zzkJ() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    private void zza(final GoogleApiClient googleApiClient, final zzz com_google_android_gms_common_api_internal_zzz, final boolean z) {
        zznt.zzaxk.zzk(googleApiClient).setResultCallback(new ResultCallback<Status>(this) {
            final /* synthetic */ zzj zzasl;

            public /* synthetic */ void onResult(@NonNull Result result) {
                zzx((Status) result);
            }

            public void zzx(@NonNull Status status) {
                zzt.zzag(this.zzasl.mContext).zzlc();
                if (status.isSuccess() && this.zzasl.isConnected()) {
                    this.zzasl.reconnect();
                }
                com_google_android_gms_common_api_internal_zzz.zza((Result) status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private static void zza(zze<?> com_google_android_gms_common_api_internal_zzj_zze_, ResultStore resultStore, IBinder iBinder) {
        if (com_google_android_gms_common_api_internal_zzj_zze_.isReady()) {
            com_google_android_gms_common_api_internal_zzj_zze_.zza(new zzb(com_google_android_gms_common_api_internal_zzj_zze_, resultStore, iBinder));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            com_google_android_gms_common_api_internal_zzj_zze_.zza(null);
            com_google_android_gms_common_api_internal_zzj_zze_.cancel();
            resultStore.remove(com_google_android_gms_common_api_internal_zzj_zze_.zzpp().intValue());
        } else {
            Object com_google_android_gms_common_api_internal_zzj_zzb = new zzb(com_google_android_gms_common_api_internal_zzj_zze_, resultStore, iBinder);
            com_google_android_gms_common_api_internal_zzj_zze_.zza(com_google_android_gms_common_api_internal_zzj_zzb);
            try {
                iBinder.linkToDeath(com_google_android_gms_common_api_internal_zzj_zzb, 0);
            } catch (RemoteException e) {
                com_google_android_gms_common_api_internal_zzj_zze_.cancel();
                resultStore.remove(com_google_android_gms_common_api_internal_zzj_zze_.zzpp().intValue());
            }
        }
    }

    private void zzcS(int i) {
        if (this.zzash == null) {
            this.zzash = Integer.valueOf(i);
        } else if (this.zzash.intValue() != i) {
            throw new IllegalStateException("Cannot use sign-in mode: " + zzcT(i) + ". Mode was already set to " + zzcT(this.zzash.intValue()));
        }
        if (this.zzarV == null) {
            Object obj = null;
            Object obj2 = null;
            for (com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb : this.zzasc.values()) {
                if (com_google_android_gms_common_api_Api_zzb.zzkt()) {
                    obj2 = 1;
                }
                obj = com_google_android_gms_common_api_Api_zzb.zzkJ() ? 1 : obj;
            }
            switch (this.zzash.intValue()) {
                case 1:
                    if (obj2 == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (obj2 != null) {
                        this.zzarV = new zzd(this.mContext, this, this.zzZo, this.zzoN, this.zzaqB, this.zzasc, this.zzarI, this.zzarJ, this.zzaqC, this.zzasg);
                        return;
                    }
                    break;
            }
            this.zzarV = new zzl(this.mContext, this, this.zzZo, this.zzoN, this.zzaqB, this.zzasc, this.zzarI, this.zzarJ, this.zzaqC, this.zzasg, this);
        }
    }

    static String zzcT(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void zzpQ() {
        this.zzarU.zzrl();
        this.zzarV.connect();
    }

    private void zzpR() {
        this.zzZo.lock();
        try {
            if (zzpT()) {
                zzpQ();
            }
            this.zzZo.unlock();
        } catch (Throwable th) {
            this.zzZo.unlock();
        }
    }

    public ConnectionResult blockingConnect() {
        boolean z = true;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.zzZo.lock();
        try {
            if (this.zzaqz >= 0) {
                if (this.zzash == null) {
                    z = false;
                }
                zzx.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzash == null) {
                this.zzash = Integer.valueOf(zza(this.zzasc.values(), false));
            } else if (this.zzash.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzcS(this.zzash.intValue());
            this.zzarU.zzrl();
            ConnectionResult blockingConnect = this.zzarV.blockingConnect();
            return blockingConnect;
        } finally {
            this.zzZo.unlock();
        }
    }

    public ConnectionResult blockingConnect(long timeout, @NonNull TimeUnit unit) {
        boolean z = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        zzx.zza(z, (Object) "blockingConnect must not be called on the UI thread");
        zzx.zzb((Object) unit, (Object) "TimeUnit must not be null");
        this.zzZo.lock();
        try {
            if (this.zzash == null) {
                this.zzash = Integer.valueOf(zza(this.zzasc.values(), false));
            } else if (this.zzash.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzcS(this.zzash.intValue());
            this.zzarU.zzrl();
            ConnectionResult blockingConnect = this.zzarV.blockingConnect(timeout, unit);
            return blockingConnect;
        } finally {
            this.zzZo.unlock();
        }
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzx.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        zzx.zza(this.zzash.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        final zzz com_google_android_gms_common_api_internal_zzz = new zzz((GoogleApiClient) this);
        if (this.zzasc.containsKey(zznt.zzVj)) {
            zza((GoogleApiClient) this, com_google_android_gms_common_api_internal_zzz, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new Builder(this.mContext).addApi(zznt.API).addConnectionCallbacks(new ConnectionCallbacks(this) {
                final /* synthetic */ zzj zzasl;

                public void onConnected(Bundle connectionHint) {
                    this.zzasl.zza((GoogleApiClient) atomicReference.get(), com_google_android_gms_common_api_internal_zzz, true);
                }

                public void onConnectionSuspended(int cause) {
                }
            }).addOnConnectionFailedListener(new OnConnectionFailedListener(this) {
                final /* synthetic */ zzj zzasl;

                public void onConnectionFailed(@NonNull ConnectionResult result) {
                    com_google_android_gms_common_api_internal_zzz.zza(new Status(8));
                }
            }).setHandler(this.zzasa).build();
            atomicReference.set(build);
            build.connect();
        }
        return com_google_android_gms_common_api_internal_zzz;
    }

    public void connect() {
        boolean z = false;
        this.zzZo.lock();
        try {
            if (this.zzaqz >= 0) {
                if (this.zzash != null) {
                    z = true;
                }
                zzx.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzash == null) {
                this.zzash = Integer.valueOf(zza(this.zzasc.values(), false));
            } else if (this.zzash.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.zzash.intValue());
        } finally {
            this.zzZo.unlock();
        }
    }

    public void connect(int signInMode) {
        boolean z = true;
        this.zzZo.lock();
        if (!(signInMode == 3 || signInMode == 1 || signInMode == 2)) {
            z = false;
        }
        try {
            zzx.zzb(z, "Illegal sign-in mode: " + signInMode);
            zzcS(signInMode);
            zzpQ();
        } finally {
            this.zzZo.unlock();
        }
    }

    public void disconnect() {
        this.zzZo.lock();
        try {
            boolean z = (this.zzarV == null || this.zzarV.disconnect()) ? false : true;
            zzac(z);
            for (zzr clear : this.zzaeD) {
                clear.clear();
            }
            this.zzaeD.clear();
            for (zze com_google_android_gms_common_api_internal_zzj_zze : this.zzarW) {
                com_google_android_gms_common_api_internal_zzj_zze.zza(null);
                com_google_android_gms_common_api_internal_zzj_zze.cancel();
            }
            this.zzarW.clear();
            if (this.zzarV != null) {
                zzpT();
                this.zzarU.zzrk();
                this.zzZo.unlock();
            }
        } finally {
            this.zzZo.unlock();
        }
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append(prefix).append("mContext=").println(this.mContext);
        writer.append(prefix).append("mResuming=").print(this.zzarX);
        writer.append(" mWorkQueue.size()=").print(this.zzarW.size());
        writer.append(" mUnconsumedRunners.size()=").println(this.zzase.size());
        if (this.zzarV != null) {
            this.zzarV.dump(prefix, fd, writer, args);
        }
    }

    @NonNull
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        this.zzZo.lock();
        try {
            if (!isConnected() && !zzpP()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.zzasc.containsKey(api.zzpg())) {
                ConnectionResult connectionResult = this.zzarV.getConnectionResult(api);
                if (connectionResult != null) {
                    this.zzZo.unlock();
                } else if (zzpP()) {
                    connectionResult = ConnectionResult.zzapJ;
                } else {
                    Log.i("GoogleApiClientImpl", zzpV());
                    Log.wtf("GoogleApiClientImpl", api.getName() + " requested in getConnectionResult" + " is not connected but is not present in the failed " + " connections map", new Exception());
                    connectionResult = new ConnectionResult(8, null);
                    this.zzZo.unlock();
                }
                return connectionResult;
            } else {
                throw new IllegalArgumentException(api.getName() + " was never registered with GoogleApiClient");
            }
        } finally {
            this.zzZo.unlock();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Looper getLooper() {
        return this.zzoN;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean hasConnectedApi(@NonNull Api<?> api) {
        com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb = (com.google.android.gms.common.api.Api.zzb) this.zzasc.get(api.zzpg());
        return com_google_android_gms_common_api_Api_zzb != null && com_google_android_gms_common_api_Api_zzb.isConnected();
    }

    public boolean isConnected() {
        return this.zzarV != null && this.zzarV.isConnected();
    }

    public boolean isConnecting() {
        return this.zzarV != null && this.zzarV.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks listener) {
        return this.zzarU.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener listener) {
        return this.zzarU.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(@NonNull ConnectionCallbacks listener) {
        this.zzarU.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(@NonNull OnConnectionFailedListener listener) {
        this.zzarU.registerConnectionFailedListener(listener);
    }

    public void stopAutoManage(@NonNull final FragmentActivity lifecycleActivity) {
        if (this.zzaqz >= 0) {
            zzaa zzb = zzaa.zzb(lifecycleActivity);
            if (zzb == null) {
                new Handler(this.mContext.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ zzj zzasl;

                    public void run() {
                        if (!lifecycleActivity.isFinishing() && !lifecycleActivity.getSupportFragmentManager().isDestroyed()) {
                            zzaa.zzc(lifecycleActivity).zzcU(this.zzasl.zzaqz);
                        }
                    }
                });
                return;
            } else {
                zzb.zzcU(this.zzaqz);
                return;
            }
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    public void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks listener) {
        this.zzarU.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener listener) {
        this.zzarU.unregisterConnectionFailedListener(listener);
    }

    @NonNull
    public <C extends com.google.android.gms.common.api.Api.zzb> C zza(@NonNull com.google.android.gms.common.api.Api.zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        Object obj = (com.google.android.gms.common.api.Api.zzb) this.zzasc.get(com_google_android_gms_common_api_Api_zzc_C);
        zzx.zzb(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.common.api.internal.zza.zza<R, A>> T zza(@NonNull T t) {
        zzx.zzb(t.zzpg() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        zzx.zzb(this.zzasc.containsKey(t.zzpg()), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        this.zzZo.lock();
        try {
            if (this.zzarV == null) {
                this.zzarW.add(t);
            } else {
                t = this.zzarV.zza((com.google.android.gms.common.api.internal.zza.zza) t);
                this.zzZo.unlock();
            }
            return t;
        } finally {
            this.zzZo.unlock();
        }
    }

    public void zza(ResultStore resultStore) {
        this.zzasf = resultStore;
    }

    public void zza(zzac com_google_android_gms_common_api_internal_zzac) {
        this.zzZo.lock();
        try {
            if (this.zzasi == null) {
                this.zzasi = new HashSet();
            }
            this.zzasi.add(com_google_android_gms_common_api_internal_zzac);
        } finally {
            this.zzZo.unlock();
        }
    }

    public boolean zza(@NonNull Api<?> api) {
        return this.zzasc.containsKey(api.zzpg());
    }

    public boolean zza(zzx com_google_android_gms_common_api_internal_zzx) {
        return this.zzarV != null && this.zzarV.zza(com_google_android_gms_common_api_internal_zzx);
    }

    void zzac(boolean z) {
        for (zze com_google_android_gms_common_api_internal_zzj_zze : this.zzase) {
            if (com_google_android_gms_common_api_internal_zzj_zze.zzpp() != null) {
                com_google_android_gms_common_api_internal_zzj_zze.zzps();
                zza(com_google_android_gms_common_api_internal_zzj_zze, this.zzasf, zza(com_google_android_gms_common_api_internal_zzj_zze.zzpg()).zzpi());
                this.zzase.remove(com_google_android_gms_common_api_internal_zzj_zze);
            } else if (z) {
                com_google_android_gms_common_api_internal_zzj_zze.zzpu();
            } else {
                com_google_android_gms_common_api_internal_zzj_zze.cancel();
                this.zzase.remove(com_google_android_gms_common_api_internal_zzj_zze);
            }
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.common.api.internal.zza.zza<? extends Result, A>> T zzb(@NonNull T t) {
        zzx.zzb(t.zzpg() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        this.zzZo.lock();
        try {
            if (this.zzarV == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (zzpP()) {
                this.zzarW.add(t);
                while (!this.zzarW.isEmpty()) {
                    zze com_google_android_gms_common_api_internal_zzj_zze = (zze) this.zzarW.remove();
                    zzb(com_google_android_gms_common_api_internal_zzj_zze);
                    com_google_android_gms_common_api_internal_zzj_zze.zzF(Status.zzaqN);
                }
            } else {
                t = this.zzarV.zzb(t);
                this.zzZo.unlock();
            }
            return t;
        } finally {
            this.zzZo.unlock();
        }
    }

    public void zzb(zzac com_google_android_gms_common_api_internal_zzac) {
        this.zzZo.lock();
        try {
            if (this.zzasi == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.zzasi.remove(com_google_android_gms_common_api_internal_zzac)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zzpU()) {
                this.zzarV.zzpx();
            }
            this.zzZo.unlock();
        } catch (Throwable th) {
            this.zzZo.unlock();
        }
    }

    <A extends com.google.android.gms.common.api.Api.zzb> void zzb(zze<A> com_google_android_gms_common_api_internal_zzj_zze_A) {
        this.zzase.add(com_google_android_gms_common_api_internal_zzj_zze_A);
        com_google_android_gms_common_api_internal_zzj_zze_A.zza(this.zzasj);
    }

    public void zzd(ConnectionResult connectionResult) {
        if (!this.zzaqB.isPlayServicesPossiblyUpdating(this.mContext, connectionResult.getErrorCode())) {
            zzpT();
        }
        if (!zzpP()) {
            this.zzarU.zzk(connectionResult);
            this.zzarU.zzrk();
        }
    }

    public void zze(int i, boolean z) {
        if (i == 1 && !z) {
            zzpS();
        }
        for (zze com_google_android_gms_common_api_internal_zzj_zze : this.zzase) {
            if (z) {
                com_google_android_gms_common_api_internal_zzj_zze.zzps();
            }
            com_google_android_gms_common_api_internal_zzj_zze.zzG(new Status(8, "The connection to Google Play services was lost"));
        }
        this.zzase.clear();
        this.zzarU.zzdk(i);
        this.zzarU.zzrk();
        if (i == 2) {
            zzpQ();
        }
    }

    public void zzo(Bundle bundle) {
        while (!this.zzarW.isEmpty()) {
            zzb((com.google.android.gms.common.api.internal.zza.zza) this.zzarW.remove());
        }
        this.zzarU.zzq(bundle);
    }

    boolean zzpP() {
        return this.zzarX;
    }

    void zzpS() {
        if (!zzpP()) {
            this.zzarX = true;
            if (this.zzasb == null) {
                this.zzasb = (zzc) zzn.zza(this.mContext.getApplicationContext(), new zzc(this), this.zzaqB);
            }
            this.zzasa.sendMessageDelayed(this.zzasa.obtainMessage(1), this.zzarY);
            this.zzasa.sendMessageDelayed(this.zzasa.obtainMessage(2), this.zzarZ);
        }
    }

    boolean zzpT() {
        if (!zzpP()) {
            return false;
        }
        this.zzarX = false;
        this.zzasa.removeMessages(2);
        this.zzasa.removeMessages(1);
        if (this.zzasb != null) {
            this.zzasb.unregister();
            this.zzasb = null;
        }
        return true;
    }

    boolean zzpU() {
        boolean z = false;
        this.zzZo.lock();
        try {
            if (this.zzasi != null) {
                if (!this.zzasi.isEmpty()) {
                    z = true;
                }
                this.zzZo.unlock();
            }
            return z;
        } finally {
            this.zzZo.unlock();
        }
    }

    String zzpV() {
        Writer stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public void zzpl() {
        if (this.zzarV != null) {
            this.zzarV.zzpl();
        }
    }

    public <L> zzr<L> zzu(@NonNull L l) {
        zzx.zzb((Object) l, (Object) "Listener must not be null");
        this.zzZo.lock();
        try {
            zzr<L> com_google_android_gms_common_api_internal_zzr = new zzr(this.zzoN, l);
            this.zzaeD.add(com_google_android_gms_common_api_internal_zzr);
            return com_google_android_gms_common_api_internal_zzr;
        } finally {
            this.zzZo.unlock();
        }
    }
}

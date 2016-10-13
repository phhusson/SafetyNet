package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzj<T extends IInterface> implements com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.internal.zzk.zza {
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = new String[]{"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Account zzSX;
    private final Set<Scope> zzYO;
    private final GoogleApiAvailabilityLight zzaqB;
    private final zzf zzarI;
    private int zzawe;
    private long zzawf;
    private long zzawg;
    private int zzawh;
    private long zzawi;
    private final zzl zzawj;
    private final Object zzawk;
    private zzs zzawl;
    private com.google.android.gms.common.api.GoogleApiClient.zza zzawm;
    private T zzawn;
    private final ArrayList<zzc<?>> zzawo;
    private zze zzawp;
    private int zzawq;
    private final ConnectionCallbacks zzawr;
    private final OnConnectionFailedListener zzaws;
    private final int zzawt;
    protected AtomicInteger zzawu;
    private final Looper zzoN;
    private final Object zzqz;

    protected abstract class zzc<TListener> {
        private TListener mListener;
        final /* synthetic */ zzj zzaww;
        private boolean zzawx = false;

        public zzc(zzj com_google_android_gms_common_internal_zzj, TListener tListener) {
            this.zzaww = com_google_android_gms_common_internal_zzj;
            this.mListener = tListener;
        }

        public void unregister() {
            zzri();
            synchronized (this.zzaww.zzawo) {
                this.zzaww.zzawo.remove(this);
            }
        }

        protected abstract void zzA(TListener tListener);

        protected abstract void zzrg();

        public void zzrh() {
            synchronized (this) {
                Object obj = this.mListener;
                if (this.zzawx) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    zzA(obj);
                } catch (RuntimeException e) {
                    zzrg();
                    throw e;
                }
            }
            zzrg();
            synchronized (this) {
                this.zzawx = true;
            }
            unregister();
        }

        public void zzri() {
            synchronized (this) {
                this.mListener = null;
            }
        }
    }

    private abstract class zza extends zzc<Boolean> {
        public final int statusCode;
        public final Bundle zzawv;
        final /* synthetic */ zzj zzaww;

        @BinderThread
        protected zza(zzj com_google_android_gms_common_internal_zzj, int i, Bundle bundle) {
            this.zzaww = com_google_android_gms_common_internal_zzj;
            super(com_google_android_gms_common_internal_zzj, Boolean.valueOf(true));
            this.statusCode = i;
            this.zzawv = bundle;
        }

        protected /* synthetic */ void zzA(Object obj) {
            zzd((Boolean) obj);
        }

        protected void zzd(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                this.zzaww.zzb(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!zzrf()) {
                        this.zzaww.zzb(1, null);
                        zzj(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    this.zzaww.zzb(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    this.zzaww.zzb(1, null);
                    if (this.zzawv != null) {
                        pendingIntent = (PendingIntent) this.zzawv.getParcelable("pendingIntent");
                    }
                    zzj(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        protected abstract void zzj(ConnectionResult connectionResult);

        protected abstract boolean zzrf();

        protected void zzrg() {
        }
    }

    final class zzb extends Handler {
        final /* synthetic */ zzj zzaww;

        public zzb(zzj com_google_android_gms_common_internal_zzj, Looper looper) {
            this.zzaww = com_google_android_gms_common_internal_zzj;
            super(looper);
        }

        private void zza(Message message) {
            zzc com_google_android_gms_common_internal_zzj_zzc = (zzc) message.obj;
            com_google_android_gms_common_internal_zzj_zzc.zzrg();
            com_google_android_gms_common_internal_zzj_zzc.unregister();
        }

        private boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        public void handleMessage(Message msg) {
            if (this.zzaww.zzawu.get() != msg.arg1) {
                if (zzb(msg)) {
                    zza(msg);
                }
            } else if ((msg.what == 1 || msg.what == 5) && !this.zzaww.isConnecting()) {
                zza(msg);
            } else if (msg.what == 3) {
                ConnectionResult connectionResult = new ConnectionResult(msg.arg2, null);
                this.zzaww.zzawm.zza(connectionResult);
                this.zzaww.onConnectionFailed(connectionResult);
            } else if (msg.what == 4) {
                this.zzaww.zzb(4, null);
                if (this.zzaww.zzawr != null) {
                    this.zzaww.zzawr.onConnectionSuspended(msg.arg2);
                }
                this.zzaww.onConnectionSuspended(msg.arg2);
                this.zzaww.zza(4, 1, null);
            } else if (msg.what == 2 && !this.zzaww.isConnected()) {
                zza(msg);
            } else if (zzb(msg)) {
                ((zzc) msg.obj).zzrh();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + msg.what, new Exception());
            }
        }
    }

    public static final class zzd extends com.google.android.gms.common.internal.zzr.zza {
        private zzj zzawy;
        private final int zzawz;

        public zzd(@NonNull zzj com_google_android_gms_common_internal_zzj, int i) {
            this.zzawy = com_google_android_gms_common_internal_zzj;
            this.zzawz = i;
        }

        private void zzrj() {
            this.zzawy = null;
        }

        @BinderThread
        public void zza(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @BinderThread
        public void zza(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            zzx.zzb(this.zzawy, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzawy.zza(i, iBinder, bundle, this.zzawz);
            zzrj();
        }
    }

    public final class zze implements ServiceConnection {
        final /* synthetic */ zzj zzaww;
        private final int zzawz;

        public zze(zzj com_google_android_gms_common_internal_zzj, int i) {
            this.zzaww = com_google_android_gms_common_internal_zzj;
            this.zzawz = i;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            zzx.zzb((Object) binder, (Object) "Expecting a valid IBinder");
            synchronized (this.zzaww.zzawk) {
                this.zzaww.zzawl = com.google.android.gms.common.internal.zzs.zza.zzcv(binder);
            }
            this.zzaww.zzx(0, this.zzawz);
        }

        public void onServiceDisconnected(ComponentName component) {
            synchronized (this.zzaww.zzawk) {
                this.zzaww.zzawl = null;
            }
            this.zzaww.mHandler.sendMessage(this.zzaww.mHandler.obtainMessage(4, this.zzawz, 1));
        }
    }

    protected class zzf implements com.google.android.gms.common.api.GoogleApiClient.zza {
        final /* synthetic */ zzj zzaww;

        public zzf(zzj com_google_android_gms_common_internal_zzj) {
            this.zzaww = com_google_android_gms_common_internal_zzj;
        }

        public void zza(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                this.zzaww.zza(null, this.zzaww.zzYO);
            } else if (this.zzaww.zzaws != null) {
                this.zzaww.zzaws.onConnectionFailed(connectionResult);
            }
        }
    }

    protected final class zzg extends zza {
        public final IBinder zzawA;
        final /* synthetic */ zzj zzaww;

        @BinderThread
        public zzg(zzj com_google_android_gms_common_internal_zzj, int i, IBinder iBinder, Bundle bundle) {
            this.zzaww = com_google_android_gms_common_internal_zzj;
            super(com_google_android_gms_common_internal_zzj, i, bundle);
            this.zzawA = iBinder;
        }

        protected void zzj(ConnectionResult connectionResult) {
            if (this.zzaww.zzaws != null) {
                this.zzaww.zzaws.onConnectionFailed(connectionResult);
            }
            this.zzaww.onConnectionFailed(connectionResult);
        }

        protected boolean zzrf() {
            try {
                String interfaceDescriptor = this.zzawA.getInterfaceDescriptor();
                if (this.zzaww.zzgD().equals(interfaceDescriptor)) {
                    IInterface zzaa = this.zzaww.zzaa(this.zzawA);
                    if (zzaa == null || !this.zzaww.zza(2, 3, zzaa)) {
                        return false;
                    }
                    Bundle zzor = this.zzaww.zzor();
                    if (this.zzaww.zzawr != null) {
                        this.zzaww.zzawr.onConnected(zzor);
                    }
                    return true;
                }
                Log.e("GmsClient", "service descriptor mismatch: " + this.zzaww.zzgD() + " vs. " + interfaceDescriptor);
                return false;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class zzh extends zza {
        final /* synthetic */ zzj zzaww;

        @BinderThread
        public zzh(zzj com_google_android_gms_common_internal_zzj, int i) {
            this.zzaww = com_google_android_gms_common_internal_zzj;
            super(com_google_android_gms_common_internal_zzj, i, null);
        }

        protected void zzj(ConnectionResult connectionResult) {
            this.zzaww.zzawm.zza(connectionResult);
            this.zzaww.onConnectionFailed(connectionResult);
        }

        protected boolean zzrf() {
            this.zzaww.zzawm.zza(ConnectionResult.zzapJ);
            return true;
        }
    }

    protected zzj(Context context, Looper looper, int i, zzf com_google_android_gms_common_internal_zzf) {
        this(context, looper, zzl.zzav(context), GoogleApiAvailabilityLight.getInstance(), i, com_google_android_gms_common_internal_zzf, null, null);
    }

    protected zzj(Context context, Looper looper, int i, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzl.zzav(context), GoogleApiAvailabilityLight.getInstance(), i, com_google_android_gms_common_internal_zzf, (ConnectionCallbacks) zzx.zzD(connectionCallbacks), (OnConnectionFailedListener) zzx.zzD(onConnectionFailedListener));
    }

    protected zzj(Context context, Looper looper, zzl com_google_android_gms_common_internal_zzl, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this.zzqz = new Object();
        this.zzawk = new Object();
        this.zzawm = new zzf(this);
        this.zzawo = new ArrayList();
        this.zzawq = 1;
        this.zzawu = new AtomicInteger(0);
        this.mContext = (Context) zzx.zzb((Object) context, (Object) "Context must not be null");
        this.zzoN = (Looper) zzx.zzb((Object) looper, (Object) "Looper must not be null");
        this.zzawj = (zzl) zzx.zzb((Object) com_google_android_gms_common_internal_zzl, (Object) "Supervisor must not be null");
        this.zzaqB = (GoogleApiAvailabilityLight) zzx.zzb((Object) googleApiAvailabilityLight, (Object) "API availability must not be null");
        this.mHandler = new zzb(this, looper);
        this.zzawt = i;
        this.zzarI = (zzf) zzx.zzD(com_google_android_gms_common_internal_zzf);
        this.zzSX = com_google_android_gms_common_internal_zzf.getAccount();
        this.zzYO = zzb(com_google_android_gms_common_internal_zzf.zzqN());
        this.zzawr = connectionCallbacks;
        this.zzaws = onConnectionFailedListener;
    }

    private boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.zzqz) {
            if (this.zzawq != i) {
                z = false;
            } else {
                zzb(i2, t);
                z = true;
            }
        }
        return z;
    }

    private Set<Scope> zzb(Set<Scope> set) {
        Set<Scope> zzc = zzc((Set) set);
        if (zzc == null) {
            return zzc;
        }
        for (Scope contains : zzc) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zzc;
    }

    private void zzb(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        zzx.zzae(z);
        synchronized (this.zzqz) {
            this.zzawq = i;
            this.zzawn = t;
            zzc(i, t);
            switch (i) {
                case 1:
                    zzqZ();
                    break;
                case 2:
                    zzqY();
                    break;
                case 3:
                    zza((IInterface) t);
                    break;
            }
        }
    }

    private void zzqY() {
        if (this.zzawp != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzgC());
            this.zzawj.zzb(zzgC(), this.zzawp, zzqX());
            this.zzawu.incrementAndGet();
        }
        this.zzawp = new zze(this, this.zzawu.get());
        if (!this.zzawj.zza(zzgC(), this.zzawp, zzqX())) {
            Log.e("GmsClient", "unable to connect to service: " + zzgC());
            zzx(8, this.zzawu.get());
        }
    }

    private void zzqZ() {
        if (this.zzawp != null) {
            this.zzawj.zzb(zzgC(), this.zzawp, zzqX());
            this.zzawp = null;
        }
    }

    public void disconnect() {
        this.zzawu.incrementAndGet();
        synchronized (this.zzawo) {
            int size = this.zzawo.size();
            for (int i = 0; i < size; i++) {
                ((zzc) this.zzawo.get(i)).zzri();
            }
            this.zzawo.clear();
        }
        synchronized (this.zzawk) {
            this.zzawl = null;
        }
        zzb(1, null);
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        synchronized (this.zzqz) {
            int i = this.zzawq;
            IInterface iInterface = this.zzawn;
        }
        writer.append(prefix).append("mConnectState=");
        switch (i) {
            case 1:
                writer.print("DISCONNECTED");
                break;
            case 2:
                writer.print("CONNECTING");
                break;
            case 3:
                writer.print("CONNECTED");
                break;
            case 4:
                writer.print("DISCONNECTING");
                break;
            default:
                writer.print("UNKNOWN");
                break;
        }
        writer.append(" mService=");
        if (iInterface == null) {
            writer.println("null");
        } else {
            writer.append(zzgD()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzawg > 0) {
            writer.append(prefix).append("lastConnectedTime=").println(this.zzawg + " " + simpleDateFormat.format(new Date(this.zzawg)));
        }
        if (this.zzawf > 0) {
            writer.append(prefix).append("lastSuspendedCause=");
            switch (this.zzawe) {
                case 1:
                    writer.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    writer.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    writer.append(String.valueOf(this.zzawe));
                    break;
            }
            writer.append(" lastSuspendedTime=").println(this.zzawf + " " + simpleDateFormat.format(new Date(this.zzawf)));
        }
        if (this.zzawi > 0) {
            writer.append(prefix).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzawh));
            writer.append(" lastFailedTime=").println(this.zzawi + " " + simpleDateFormat.format(new Date(this.zzawi)));
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzoN;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzqz) {
            z = this.zzawq == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzqz) {
            z = this.zzawq == 2;
        }
        return z;
    }

    @CallSuper
    protected void onConnectionFailed(ConnectionResult result) {
        this.zzawh = result.getErrorCode();
        this.zzawi = System.currentTimeMillis();
    }

    @CallSuper
    protected void onConnectionSuspended(int cause) {
        this.zzawe = cause;
        this.zzawf = System.currentTimeMillis();
    }

    @BinderThread
    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzg(this, i, iBinder, bundle)));
    }

    @CallSuper
    protected void zza(@NonNull T t) {
        this.zzawg = System.currentTimeMillis();
    }

    public void zza(@NonNull com.google.android.gms.common.api.GoogleApiClient.zza com_google_android_gms_common_api_GoogleApiClient_zza) {
        this.zzawm = (com.google.android.gms.common.api.GoogleApiClient.zza) zzx.zzb((Object) com_google_android_gms_common_api_GoogleApiClient_zza, (Object) "Connection progress callbacks cannot be null.");
        zzb(2, null);
    }

    @Deprecated
    public final void zza(zzc<?> com_google_android_gms_common_internal_zzj_zzc_) {
        synchronized (this.zzawo) {
            this.zzawo.add(com_google_android_gms_common_internal_zzj_zzc_);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, this.zzawu.get(), -1, com_google_android_gms_common_internal_zzj_zzc_));
    }

    @WorkerThread
    public void zza(zzp com_google_android_gms_common_internal_zzp, Set<Scope> set) {
        try {
            GetServiceRequest zzp = new GetServiceRequest(this.zzawt).zzcF(this.mContext.getPackageName()).zzp(zzkd());
            if (set != null) {
                zzp.zzd(set);
            }
            if (zzkt()) {
                zzp.zzb(zzqK()).zzb(com_google_android_gms_common_internal_zzp);
            } else if (zzre()) {
                zzp.zzb(this.zzSX);
            }
            synchronized (this.zzawk) {
                if (this.zzawl != null) {
                    this.zzawl.zza(new zzd(this, this.zzawu.get()), zzp);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzdj(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    @Nullable
    protected abstract T zzaa(IBinder iBinder);

    @NonNull
    protected Set<Scope> zzc(@NonNull Set<Scope> set) {
        return set;
    }

    void zzc(int i, T t) {
    }

    public void zzdj(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.zzawu.get(), i));
    }

    @NonNull
    protected abstract String zzgC();

    @NonNull
    protected abstract String zzgD();

    public boolean zzkJ() {
        return false;
    }

    public Intent zzkK() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    protected Bundle zzkd() {
        return new Bundle();
    }

    public boolean zzkt() {
        return false;
    }

    public Bundle zzor() {
        return null;
    }

    @Nullable
    public IBinder zzpi() {
        IBinder iBinder;
        synchronized (this.zzawk) {
            if (this.zzawl == null) {
                iBinder = null;
            } else {
                iBinder = this.zzawl.asBinder();
            }
        }
        return iBinder;
    }

    public final Account zzqK() {
        return this.zzSX != null ? this.zzSX : new Account("<<default account>>", "com.google");
    }

    @Nullable
    protected final String zzqX() {
        return this.zzarI.zzqQ();
    }

    public void zzra() {
        int isGooglePlayServicesAvailable = this.zzaqB.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zzb(1, null);
            this.zzawm = new zzf(this);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzawu.get(), isGooglePlayServicesAvailable));
            return;
        }
        zza(new zzf(this));
    }

    protected final zzf zzrb() {
        return this.zzarI;
    }

    protected final void zzrc() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzrd() throws DeadObjectException {
        T t;
        synchronized (this.zzqz) {
            if (this.zzawq == 4) {
                throw new DeadObjectException();
            }
            zzrc();
            zzx.zza(this.zzawn != null, (Object) "Client is connected but service is null");
            t = this.zzawn;
        }
        return t;
    }

    public boolean zzre() {
        return false;
    }

    protected void zzx(int i, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i2, -1, new zzh(this, i)));
    }
}

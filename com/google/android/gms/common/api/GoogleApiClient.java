package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.internal.zzaa;
import com.google.android.gms.common.api.internal.zzac;
import com.google.android.gms.common.api.internal.zzc;
import com.google.android.gms.common.api.internal.zzj;
import com.google.android.gms.common.api.internal.zzr;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzxg;
import com.google.android.gms.internal.zzxi;
import com.google.android.gms.internal.zzxj;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private static final Set<GoogleApiClient> zzaqq = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {
        private final Context mContext;
        private Account zzSX;
        private String zzVx;
        private OnConnectionFailedListener zzaqA;
        private GoogleApiAvailabilityLight zzaqB;
        private com.google.android.gms.common.api.Api.zza<? extends zzxi, zzxj> zzaqC;
        private final ArrayList<ConnectionCallbacks> zzaqD;
        private final ArrayList<OnConnectionFailedListener> zzaqE;
        private final Set<Scope> zzaqr;
        private final Set<Scope> zzaqs;
        private int zzaqt;
        private View zzaqu;
        private String zzaqv;
        private final Map<Api<?>, com.google.android.gms.common.internal.zzf.zza> zzaqw;
        private final Map<Api<?>, ApiOptions> zzaqx;
        private FragmentActivity zzaqy;
        private int zzaqz;
        private Looper zzoN;

        public Builder(@NonNull Context context) {
            this.zzaqr = new HashSet();
            this.zzaqs = new HashSet();
            this.zzaqw = new ArrayMap();
            this.zzaqx = new ArrayMap();
            this.zzaqz = -1;
            this.zzaqB = GoogleApiAvailabilityLight.getInstance();
            this.zzaqC = zzxg.zzVk;
            this.zzaqD = new ArrayList();
            this.zzaqE = new ArrayList();
            this.mContext = context;
            this.zzoN = context.getMainLooper();
            this.zzVx = context.getPackageName();
            this.zzaqv = context.getClass().getName();
        }

        public Builder(@NonNull Context context, @NonNull ConnectionCallbacks connectedListener, @NonNull OnConnectionFailedListener connectionFailedListener) {
            this(context);
            zzx.zzb((Object) connectedListener, (Object) "Must provide a connected listener");
            this.zzaqD.add(connectedListener);
            zzx.zzb((Object) connectionFailedListener, (Object) "Must provide a connection failed listener");
            this.zzaqE.add(connectionFailedListener);
        }

        private static <C extends zzb, O> C zza(com.google.android.gms.common.api.Api.zza<C, O> com_google_android_gms_common_api_Api_zza_C__O, Object obj, Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return com_google_android_gms_common_api_Api_zza_C__O.zza(context, looper, com_google_android_gms_common_internal_zzf, obj, connectionCallbacks, onConnectionFailedListener);
        }

        private static <C extends zzd, O> zzad zza(zze<C, O> com_google_android_gms_common_api_Api_zze_C__O, Object obj, Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzad(context, looper, com_google_android_gms_common_api_Api_zze_C__O.zzpj(), connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf, com_google_android_gms_common_api_Api_zze_C__O.zzt(obj));
        }

        private <O extends ApiOptions> void zza(Api<O> api, O o, int i, Scope... scopeArr) {
            boolean z = true;
            int i2 = 0;
            if (i != 1) {
                if (i == 2) {
                    z = false;
                } else {
                    throw new IllegalArgumentException("Invalid resolution mode: '" + i + "', use a constant from GoogleApiClient.ResolutionMode");
                }
            }
            Set hashSet = new HashSet(api.zzpe().zzr(o));
            int length = scopeArr.length;
            while (i2 < length) {
                hashSet.add(scopeArr[i2]);
                i2++;
            }
            this.zzaqw.put(api, new com.google.android.gms.common.internal.zzf.zza(hashSet, z));
        }

        private void zza(zzaa com_google_android_gms_common_api_internal_zzaa, GoogleApiClient googleApiClient) {
            com_google_android_gms_common_api_internal_zzaa.zza(this.zzaqz, googleApiClient, this.zzaqA);
        }

        private void zzj(final GoogleApiClient googleApiClient) {
            zzaa zzb = zzaa.zzb(this.zzaqy);
            if (zzb == null) {
                new Handler(this.mContext.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ Builder zzaqF;

                    public void run() {
                        if (!this.zzaqF.zzaqy.isFinishing() && !this.zzaqF.zzaqy.getSupportFragmentManager().isDestroyed()) {
                            this.zzaqF.zza(zzaa.zzc(this.zzaqF.zzaqy), googleApiClient);
                        }
                    }
                });
            } else {
                zza(zzb, googleApiClient);
            }
        }

        private GoogleApiClient zzpo() {
            zzf zzpn = zzpn();
            Api api = null;
            Map zzqO = zzpn.zzqO();
            Map arrayMap = new ArrayMap();
            Map arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api api2 = null;
            for (Api api3 : this.zzaqx.keySet()) {
                Api api32;
                zzb zza;
                Api api4;
                Object obj = this.zzaqx.get(api32);
                int i = 0;
                if (zzqO.get(api32) != null) {
                    i = ((com.google.android.gms.common.internal.zzf.zza) zzqO.get(api32)).zzavR ? 1 : 2;
                }
                arrayMap.put(api32, Integer.valueOf(i));
                ConnectionCallbacks com_google_android_gms_common_api_internal_zzc = new zzc(api32, i);
                arrayList.add(com_google_android_gms_common_api_internal_zzc);
                Api api5;
                if (api32.zzph()) {
                    zze zzpf = api32.zzpf();
                    api5 = zzpf.getPriority() == 1 ? api32 : api2;
                    zza = zza(zzpf, obj, this.mContext, this.zzoN, zzpn, com_google_android_gms_common_api_internal_zzc, (OnConnectionFailedListener) com_google_android_gms_common_api_internal_zzc);
                    api4 = api5;
                } else {
                    com.google.android.gms.common.api.Api.zza zzpe = api32.zzpe();
                    api5 = zzpe.getPriority() == 1 ? api32 : api2;
                    zza = zza(zzpe, obj, this.mContext, this.zzoN, zzpn, com_google_android_gms_common_api_internal_zzc, (OnConnectionFailedListener) com_google_android_gms_common_api_internal_zzc);
                    api4 = api5;
                }
                arrayMap2.put(api32.zzpg(), zza);
                if (!zza.zzkJ()) {
                    api32 = api;
                } else if (api != null) {
                    throw new IllegalStateException(api32.getName() + " cannot be used with " + api.getName());
                }
                api2 = api4;
                api = api32;
            }
            if (api != null) {
                if (api2 != null) {
                    throw new IllegalStateException(api.getName() + " cannot be used with " + api2.getName());
                }
                zzx.zza(this.zzSX == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.getName());
                zzx.zza(this.zzaqr.equals(this.zzaqs), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.getName());
            }
            return new zzj(this.mContext, new ReentrantLock(), this.zzoN, zzpn, this.zzaqB, this.zzaqC, arrayMap, this.zzaqD, this.zzaqE, arrayMap2, this.zzaqz, zzj.zza(arrayMap2.values(), true), arrayList);
        }

        public Builder addApi(@NonNull Api<? extends NotRequiredOptions> api) {
            zzx.zzb((Object) api, (Object) "Api must not be null");
            this.zzaqx.put(api, null);
            Collection zzr = api.zzpe().zzr(null);
            this.zzaqs.addAll(zzr);
            this.zzaqr.addAll(zzr);
            return this;
        }

        public <O extends HasOptions> Builder addApi(@NonNull Api<O> api, @NonNull O options) {
            zzx.zzb((Object) api, (Object) "Api must not be null");
            zzx.zzb((Object) options, (Object) "Null options are not permitted for this Api");
            this.zzaqx.put(api, options);
            Collection zzr = api.zzpe().zzr(options);
            this.zzaqs.addAll(zzr);
            this.zzaqr.addAll(zzr);
            return this;
        }

        public <O extends HasOptions> Builder addApiIfAvailable(@NonNull Api<O> api, @NonNull O options, Scope... scopes) {
            zzx.zzb((Object) api, (Object) "Api must not be null");
            zzx.zzb((Object) options, (Object) "Null options are not permitted for this Api");
            this.zzaqx.put(api, options);
            zza(api, options, 1, scopes);
            return this;
        }

        public Builder addApiIfAvailable(@NonNull Api<? extends NotRequiredOptions> api, Scope... scopes) {
            zzx.zzb((Object) api, (Object) "Api must not be null");
            this.zzaqx.put(api, null);
            zza(api, null, 1, scopes);
            return this;
        }

        public Builder addConnectionCallbacks(@NonNull ConnectionCallbacks listener) {
            zzx.zzb((Object) listener, (Object) "Listener must not be null");
            this.zzaqD.add(listener);
            return this;
        }

        public Builder addOnConnectionFailedListener(@NonNull OnConnectionFailedListener listener) {
            zzx.zzb((Object) listener, (Object) "Listener must not be null");
            this.zzaqE.add(listener);
            return this;
        }

        public Builder addScope(@NonNull Scope scope) {
            zzx.zzb((Object) scope, (Object) "Scope must not be null");
            this.zzaqr.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzx.zzb(!this.zzaqx.isEmpty(), (Object) "must call addApi() to add at least one API");
            GoogleApiClient zzpo = zzpo();
            synchronized (GoogleApiClient.zzaqq) {
                GoogleApiClient.zzaqq.add(zzpo);
            }
            if (this.zzaqz >= 0) {
                zzj(zzpo);
            }
            return zzpo;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, int clientId, @Nullable OnConnectionFailedListener unresolvedConnectionFailedListener) {
            zzx.zzb(clientId >= 0, (Object) "clientId must be non-negative");
            this.zzaqz = clientId;
            this.zzaqy = (FragmentActivity) zzx.zzb((Object) fragmentActivity, (Object) "Null activity is not permitted.");
            this.zzaqA = unresolvedConnectionFailedListener;
            return this;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener unresolvedConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, unresolvedConnectionFailedListener);
        }

        public Builder setAccount(Account account) {
            this.zzSX = account;
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.zzSX = accountName == null ? null : new Account(accountName, "com.google");
            return this;
        }

        public Builder setGravityForPopups(int gravityForPopups) {
            this.zzaqt = gravityForPopups;
            return this;
        }

        public Builder setHandler(@NonNull Handler handler) {
            zzx.zzb((Object) handler, (Object) "Handler must not be null");
            this.zzoN = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(@NonNull View viewForPopups) {
            zzx.zzb((Object) viewForPopups, (Object) "View must not be null");
            this.zzaqu = viewForPopups;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzf zzpn() {
            zzxj com_google_android_gms_internal_zzxj = zzxj.zzbTI;
            if (this.zzaqx.containsKey(zzxg.API)) {
                com_google_android_gms_internal_zzxj = (zzxj) this.zzaqx.get(zzxg.API);
            }
            return new zzf(this.zzSX, this.zzaqr, this.zzaqw, this.zzaqt, this.zzaqu, this.zzVx, this.zzaqv, com_google_android_gms_internal_zzxj);
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    public interface zza {
        void zza(@NonNull ConnectionResult connectionResult);
    }

    public static void dumpAll(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        synchronized (zzaqq) {
            String str = prefix + "  ";
            int i = 0;
            for (GoogleApiClient googleApiClient : zzaqq) {
                int i2 = i + 1;
                writer.append(prefix).append("GoogleApiClient#").println(i);
                googleApiClient.dump(str, fd, writer, args);
                i = i2;
            }
        }
    }

    public static Set<GoogleApiClient> zzpk() {
        return zzaqq;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int signInMode) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @NonNull
    public abstract ConnectionResult getConnectionResult(@NonNull Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(@NonNull Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(@NonNull FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @NonNull
    public <C extends zzb> C zza(@NonNull Api.zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, R extends Result, T extends com.google.android.gms.common.api.internal.zza.zza<R, A>> T zza(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public void zza(ResultStore resultStore) {
        throw new UnsupportedOperationException();
    }

    public void zza(zzac com_google_android_gms_common_api_internal_zzac) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(@NonNull Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(com.google.android.gms.common.api.internal.zzx com_google_android_gms_common_api_internal_zzx) {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, T extends com.google.android.gms.common.api.internal.zza.zza<? extends Result, A>> T zzb(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public void zzb(zzac com_google_android_gms_common_api_internal_zzac) {
        throw new UnsupportedOperationException();
    }

    public void zzpl() {
        throw new UnsupportedOperationException();
    }

    public <L> zzr<L> zzu(@NonNull L l) {
        throw new UnsupportedOperationException();
    }
}

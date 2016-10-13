package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzxi;
import com.google.android.gms.internal.zzxj;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzh implements zzk {
    private final Context mContext;
    private final Lock zzZo;
    private final GoogleApiAvailabilityLight zzaqB;
    private final com.google.android.gms.common.api.Api.zza<? extends zzxi, zzxj> zzaqC;
    private final Set<com.google.android.gms.common.api.Api.zzc> zzarA = new HashSet();
    private zzxi zzarB;
    private int zzarC;
    private boolean zzarD;
    private boolean zzarE;
    private zzp zzarF;
    private boolean zzarG;
    private boolean zzarH;
    private final com.google.android.gms.common.internal.zzf zzarI;
    private final Map<Api<?>, Integer> zzarJ;
    private ArrayList<Future<?>> zzarK = new ArrayList();
    private final zzl zzars;
    private ConnectionResult zzarv;
    private int zzarw;
    private int zzarx = 0;
    private int zzary;
    private final Bundle zzarz = new Bundle();

    class C02011 implements Runnable {
        final /* synthetic */ zzh zzarL;

        C02011(zzh com_google_android_gms_common_api_internal_zzh) {
            this.zzarL = com_google_android_gms_common_api_internal_zzh;
        }

        public void run() {
            this.zzarL.zzaqB.zzam(this.zzarL.mContext);
        }
    }

    private static class zza implements com.google.android.gms.common.api.GoogleApiClient.zza {
        private final WeakReference<zzh> zzarM;
        private final Api<?> zzarc;
        private final int zzard;

        public zza(zzh com_google_android_gms_common_api_internal_zzh, Api<?> api, int i) {
            this.zzarM = new WeakReference(com_google_android_gms_common_api_internal_zzh);
            this.zzarc = api;
            this.zzard = i;
        }

        public void zza(@NonNull ConnectionResult connectionResult) {
            boolean z = false;
            zzh com_google_android_gms_common_api_internal_zzh = (zzh) this.zzarM.get();
            if (com_google_android_gms_common_api_internal_zzh != null) {
                if (Looper.myLooper() == com_google_android_gms_common_api_internal_zzh.zzars.zzarf.getLooper()) {
                    z = true;
                }
                zzx.zza(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                com_google_android_gms_common_api_internal_zzh.zzZo.lock();
                try {
                    if (com_google_android_gms_common_api_internal_zzh.zzcQ(0)) {
                        if (!connectionResult.isSuccess()) {
                            com_google_android_gms_common_api_internal_zzh.zzb(connectionResult, this.zzarc, this.zzard);
                        }
                        if (com_google_android_gms_common_api_internal_zzh.zzpI()) {
                            com_google_android_gms_common_api_internal_zzh.zzpJ();
                        }
                        com_google_android_gms_common_api_internal_zzh.zzZo.unlock();
                    }
                } finally {
                    com_google_android_gms_common_api_internal_zzh.zzZo.unlock();
                }
            }
        }
    }

    private abstract class zzf implements Runnable {
        final /* synthetic */ zzh zzarL;

        private zzf(zzh com_google_android_gms_common_api_internal_zzh) {
            this.zzarL = com_google_android_gms_common_api_internal_zzh;
        }

        @WorkerThread
        public void run() {
            this.zzarL.zzZo.lock();
            try {
                if (!Thread.interrupted()) {
                    zzpH();
                    this.zzarL.zzZo.unlock();
                }
            } catch (RuntimeException e) {
                this.zzarL.zzars.zzb(e);
            } finally {
                this.zzarL.zzZo.unlock();
            }
        }

        @WorkerThread
        protected abstract void zzpH();
    }

    private class zzb extends zzf {
        final /* synthetic */ zzh zzarL;
        private final Map<com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.api.GoogleApiClient.zza> zzarN;

        public zzb(zzh com_google_android_gms_common_api_internal_zzh, Map<com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.api.GoogleApiClient.zza> map) {
            this.zzarL = com_google_android_gms_common_api_internal_zzh;
            super();
            this.zzarN = map;
        }

        @WorkerThread
        public void zzpH() {
            int isGooglePlayServicesAvailable = this.zzarL.zzaqB.isGooglePlayServicesAvailable(this.zzarL.mContext);
            if (isGooglePlayServicesAvailable != 0) {
                final ConnectionResult connectionResult = new ConnectionResult(isGooglePlayServicesAvailable, null);
                this.zzarL.zzars.zza(new zza(this, this.zzarL) {
                    final /* synthetic */ zzb zzarP;

                    public void zzpH() {
                        this.zzarP.zzarL.zzg(connectionResult);
                    }
                });
                return;
            }
            if (this.zzarL.zzarD) {
                this.zzarL.zzarB.connect();
            }
            for (com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb : this.zzarN.keySet()) {
                com_google_android_gms_common_api_Api_zzb.zza((com.google.android.gms.common.api.GoogleApiClient.zza) this.zzarN.get(com_google_android_gms_common_api_Api_zzb));
            }
        }
    }

    private class zzc extends zzf {
        final /* synthetic */ zzh zzarL;
        private final ArrayList<com.google.android.gms.common.api.Api.zzb> zzarQ;

        public zzc(zzh com_google_android_gms_common_api_internal_zzh, ArrayList<com.google.android.gms.common.api.Api.zzb> arrayList) {
            this.zzarL = com_google_android_gms_common_api_internal_zzh;
            super();
            this.zzarQ = arrayList;
        }

        @WorkerThread
        public void zzpH() {
            this.zzarL.zzars.zzarf.zzasd = this.zzarL.zzpO();
            Iterator it = this.zzarQ.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.Api.zzb) it.next()).zza(this.zzarL.zzarF, this.zzarL.zzars.zzarf.zzasd);
            }
        }
    }

    private static class zzd extends com.google.android.gms.signin.internal.zzb {
        private final WeakReference<zzh> zzarM;

        zzd(zzh com_google_android_gms_common_api_internal_zzh) {
            this.zzarM = new WeakReference(com_google_android_gms_common_api_internal_zzh);
        }

        @BinderThread
        public void zzb(final SignInResponse signInResponse) {
            final zzh com_google_android_gms_common_api_internal_zzh = (zzh) this.zzarM.get();
            if (com_google_android_gms_common_api_internal_zzh != null) {
                com_google_android_gms_common_api_internal_zzh.zzars.zza(new zza(this, com_google_android_gms_common_api_internal_zzh) {
                    final /* synthetic */ zzd zzarT;

                    public void zzpH() {
                        com_google_android_gms_common_api_internal_zzh.zza(signInResponse);
                    }
                });
            }
        }
    }

    private class zze implements ConnectionCallbacks, OnConnectionFailedListener {
        final /* synthetic */ zzh zzarL;

        private zze(zzh com_google_android_gms_common_api_internal_zzh) {
            this.zzarL = com_google_android_gms_common_api_internal_zzh;
        }

        public void onConnected(Bundle connectionHint) {
            this.zzarL.zzarB.zza(new zzd(this.zzarL));
        }

        public void onConnectionFailed(@NonNull ConnectionResult result) {
            this.zzarL.zzZo.lock();
            try {
                if (this.zzarL.zzf(result)) {
                    this.zzarL.zzpM();
                    this.zzarL.zzpJ();
                } else {
                    this.zzarL.zzg(result);
                }
                this.zzarL.zzZo.unlock();
            } catch (Throwable th) {
                this.zzarL.zzZo.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
        }
    }

    public zzh(zzl com_google_android_gms_common_api_internal_zzl, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, Map<Api<?>, Integer> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, com.google.android.gms.common.api.Api.zza<? extends zzxi, zzxj> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzxi__com_google_android_gms_internal_zzxj, Lock lock, Context context) {
        this.zzars = com_google_android_gms_common_api_internal_zzl;
        this.zzarI = com_google_android_gms_common_internal_zzf;
        this.zzarJ = map;
        this.zzaqB = googleApiAvailabilityLight;
        this.zzaqC = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzxi__com_google_android_gms_internal_zzxj;
        this.zzZo = lock;
        this.mContext = context;
    }

    private void zza(SignInResponse signInResponse) {
        if (zzcQ(0)) {
            ConnectionResult zzrs = signInResponse.zzrs();
            if (zzrs.isSuccess()) {
                ResolveAccountResponse zzLD = signInResponse.zzLD();
                ConnectionResult zzrs2 = zzLD.zzrs();
                if (zzrs2.isSuccess()) {
                    this.zzarE = true;
                    this.zzarF = zzLD.zzrr();
                    this.zzarG = zzLD.zzrt();
                    this.zzarH = zzLD.zzru();
                    zzpJ();
                    return;
                }
                Log.wtf("GoogleApiClientConnecting", "Sign-in succeeded with resolve account failure: " + zzrs2, new Exception());
                zzg(zzrs2);
            } else if (zzf(zzrs)) {
                zzpM();
                zzpJ();
            } else {
                zzg(zzrs);
            }
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        return (i2 != 1 || zze(connectionResult)) ? this.zzarv == null || i < this.zzarw : false;
    }

    private void zzab(boolean z) {
        if (this.zzarB != null) {
            if (this.zzarB.isConnected() && z) {
                this.zzarB.zzLu();
            }
            this.zzarB.disconnect();
            this.zzarF = null;
        }
    }

    private void zzb(ConnectionResult connectionResult, Api<?> api, int i) {
        if (i != 2) {
            int priority = api.zzpe().getPriority();
            if (zza(priority, i, connectionResult)) {
                this.zzarv = connectionResult;
                this.zzarw = priority;
            }
        }
        this.zzars.zzasw.put(api.zzpg(), connectionResult);
    }

    private boolean zzcQ(int i) {
        if (this.zzarx == i) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", this.zzars.zzarf.zzpV());
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + zzcR(this.zzarx) + " but received callback for step " + zzcR(i), new Exception());
        zzg(new ConnectionResult(8, null));
        return false;
    }

    private String zzcR(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private boolean zze(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.zzaqB.getErrorResolutionIntent(connectionResult.getErrorCode()) != null;
    }

    private boolean zzf(ConnectionResult connectionResult) {
        return this.zzarC != 2 ? this.zzarC == 1 && !connectionResult.hasResolution() : true;
    }

    private void zzg(ConnectionResult connectionResult) {
        zzpN();
        zzab(!connectionResult.hasResolution());
        this.zzars.zzh(connectionResult);
        this.zzars.zzasA.zzd(connectionResult);
    }

    private boolean zzpI() {
        this.zzary--;
        if (this.zzary > 0) {
            return false;
        }
        if (this.zzary < 0) {
            Log.i("GoogleApiClientConnecting", this.zzars.zzarf.zzpV());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zzg(new ConnectionResult(8, null));
            return false;
        } else if (this.zzarv == null) {
            return true;
        } else {
            this.zzars.zzasz = this.zzarw;
            zzg(this.zzarv);
            return false;
        }
    }

    private void zzpJ() {
        if (this.zzary == 0) {
            if (!this.zzarD || this.zzarE) {
                zzpK();
            }
        }
    }

    private void zzpK() {
        ArrayList arrayList = new ArrayList();
        this.zzarx = 1;
        this.zzary = this.zzars.zzasc.size();
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.zzars.zzasc.keySet()) {
            if (!this.zzars.zzasw.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                arrayList.add(this.zzars.zzasc.get(com_google_android_gms_common_api_Api_zzc));
            } else if (zzpI()) {
                zzpL();
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzarK.add(zzm.zzqb().submit(new zzc(this, arrayList)));
        }
    }

    private void zzpL() {
        this.zzars.zzpZ();
        zzm.zzqb().execute(new C02011(this));
        if (this.zzarB != null) {
            if (this.zzarG) {
                this.zzarB.zza(this.zzarF, this.zzarH);
            }
            zzab(false);
        }
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.zzars.zzasw.keySet()) {
            ((com.google.android.gms.common.api.Api.zzb) this.zzars.zzasc.get(com_google_android_gms_common_api_Api_zzc)).disconnect();
        }
        this.zzars.zzasA.zzo(this.zzarz.isEmpty() ? null : this.zzarz);
    }

    private void zzpM() {
        this.zzarD = false;
        this.zzars.zzarf.zzasd = Collections.emptySet();
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.zzarA) {
            if (!this.zzars.zzasw.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                this.zzars.zzasw.put(com_google_android_gms_common_api_Api_zzc, new ConnectionResult(17, null));
            }
        }
    }

    private void zzpN() {
        Iterator it = this.zzarK.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.zzarK.clear();
    }

    private Set<Scope> zzpO() {
        if (this.zzarI == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.zzarI.zzqM());
        Map zzqO = this.zzarI.zzqO();
        for (Api api : zzqO.keySet()) {
            if (!this.zzars.zzasw.containsKey(api.zzpg())) {
                hashSet.addAll(((com.google.android.gms.common.internal.zzf.zza) zzqO.get(api)).zzYO);
            }
        }
        return hashSet;
    }

    public void begin() {
        this.zzars.zzasw.clear();
        this.zzarD = false;
        this.zzarv = null;
        this.zzarx = 0;
        this.zzarC = 2;
        this.zzarE = false;
        this.zzarG = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (Api api : this.zzarJ.keySet()) {
            com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb = (com.google.android.gms.common.api.Api.zzb) this.zzars.zzasc.get(api.zzpg());
            int intValue = ((Integer) this.zzarJ.get(api)).intValue();
            int i2 = (api.zzpe().getPriority() == 1 ? 1 : 0) | i;
            if (com_google_android_gms_common_api_Api_zzb.zzkt()) {
                this.zzarD = true;
                if (intValue < this.zzarC) {
                    this.zzarC = intValue;
                }
                if (intValue != 0) {
                    this.zzarA.add(api.zzpg());
                }
            }
            hashMap.put(com_google_android_gms_common_api_Api_zzb, new zza(this, api, intValue));
            i = i2;
        }
        if (i != 0) {
            this.zzarD = false;
        }
        if (this.zzarD) {
            this.zzarI.zzb(Integer.valueOf(this.zzars.zzarf.getSessionId()));
            ConnectionCallbacks com_google_android_gms_common_api_internal_zzh_zze = new zze();
            this.zzarB = (zzxi) this.zzaqC.zza(this.mContext, this.zzars.zzarf.getLooper(), this.zzarI, this.zzarI.zzqS(), com_google_android_gms_common_api_internal_zzh_zze, com_google_android_gms_common_api_internal_zzh_zze);
        }
        this.zzary = this.zzars.zzasc.size();
        this.zzarK.add(zzm.zzqb().submit(new zzb(this, hashMap)));
    }

    public void connect() {
    }

    public boolean disconnect() {
        zzpN();
        zzab(true);
        this.zzars.zzh(null);
        return true;
    }

    public void onConnected(Bundle connectionHint) {
        if (zzcQ(1)) {
            if (connectionHint != null) {
                this.zzarz.putAll(connectionHint);
            }
            if (zzpI()) {
                zzpL();
            }
        }
    }

    public void onConnectionSuspended(int cause) {
        zzg(new ConnectionResult(8, null));
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.common.api.internal.zza.zza<R, A>> T zza(T t) {
        this.zzars.zzarf.zzarW.add(t);
        return t;
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        if (zzcQ(1)) {
            zzb(connectionResult, api, i);
            if (zzpI()) {
                zzpL();
            }
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.common.api.internal.zza.zza<? extends Result, A>> T zzb(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}

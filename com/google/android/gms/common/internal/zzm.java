package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class zzm extends zzl implements Callback {
    private final Handler mHandler;
    private final HashMap<zza, zzb> zzawK = new HashMap();
    private final com.google.android.gms.common.stats.zzb zzawL;
    private final long zzawM;
    private final Context zzsE;

    private static final class zza {
        private final String mAction;
        private final ComponentName zzadE;

        public zza(ComponentName componentName) {
            this.mAction = null;
            this.zzadE = (ComponentName) zzx.zzD(componentName);
        }

        public zza(String str) {
            this.mAction = zzx.zzcL(str);
            this.zzadE = null;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_common_internal_zzm_zza = (zza) o;
            return zzw.equal(this.mAction, com_google_android_gms_common_internal_zzm_zza.mAction) && zzw.equal(this.zzadE, com_google_android_gms_common_internal_zzm_zza.zzadE);
        }

        public int hashCode() {
            return zzw.hashCode(this.mAction, this.zzadE);
        }

        public String toString() {
            return this.mAction == null ? this.zzadE.flattenToString() : this.mAction;
        }

        public Intent zzrm() {
            return this.mAction != null ? new Intent(this.mAction).setPackage("com.google.android.gms") : new Intent().setComponent(this.zzadE);
        }
    }

    private final class zzb {
        private int mState = 2;
        private ComponentName zzadE;
        private final zza zzawN = new zza(this);
        private final Set<ServiceConnection> zzawO = new HashSet();
        private boolean zzawP;
        private final zza zzawQ;
        final /* synthetic */ zzm zzawR;
        private IBinder zzpC;

        public class zza implements ServiceConnection {
            final /* synthetic */ zzb zzawS;

            public zza(zzb com_google_android_gms_common_internal_zzm_zzb) {
                this.zzawS = com_google_android_gms_common_internal_zzm_zzb;
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (this.zzawS.zzawR.zzawK) {
                    this.zzawS.zzpC = binder;
                    this.zzawS.zzadE = component;
                    for (ServiceConnection onServiceConnected : this.zzawS.zzawO) {
                        onServiceConnected.onServiceConnected(component, binder);
                    }
                    this.zzawS.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (this.zzawS.zzawR.zzawK) {
                    this.zzawS.zzpC = null;
                    this.zzawS.zzadE = component;
                    for (ServiceConnection onServiceDisconnected : this.zzawS.zzawO) {
                        onServiceDisconnected.onServiceDisconnected(component);
                    }
                    this.zzawS.mState = 2;
                }
            }
        }

        public zzb(zzm com_google_android_gms_common_internal_zzm, zza com_google_android_gms_common_internal_zzm_zza) {
            this.zzawR = com_google_android_gms_common_internal_zzm;
            this.zzawQ = com_google_android_gms_common_internal_zzm_zza;
        }

        public IBinder getBinder() {
            return this.zzpC;
        }

        public ComponentName getComponentName() {
            return this.zzadE;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.zzawP;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            this.zzawR.zzawL.zza(this.zzawR.zzsE, serviceConnection, str, this.zzawQ.zzrm());
            this.zzawO.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.zzawO.contains(serviceConnection);
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            this.zzawR.zzawL.zzb(this.zzawR.zzsE, serviceConnection);
            this.zzawO.remove(serviceConnection);
        }

        @TargetApi(14)
        public void zzcG(String str) {
            this.mState = 3;
            this.zzawP = this.zzawR.zzawL.zza(this.zzawR.zzsE, str, this.zzawQ.zzrm(), this.zzawN, 129);
            if (!this.zzawP) {
                this.mState = 2;
                try {
                    this.zzawR.zzawL.zza(this.zzawR.zzsE, this.zzawN);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public void zzcH(String str) {
            this.zzawR.zzawL.zza(this.zzawR.zzsE, this.zzawN);
            this.zzawP = false;
            this.mState = 2;
        }

        public boolean zzrn() {
            return this.zzawO.isEmpty();
        }
    }

    zzm(Context context) {
        this.zzsE = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzawL = com.google.android.gms.common.stats.zzb.zzrU();
        this.zzawM = 5000;
    }

    private boolean zza(zza com_google_android_gms_common_internal_zzm_zza, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzx.zzb((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzawK) {
            zzb com_google_android_gms_common_internal_zzm_zzb = (zzb) this.zzawK.get(com_google_android_gms_common_internal_zzm_zza);
            if (com_google_android_gms_common_internal_zzm_zzb != null) {
                this.mHandler.removeMessages(0, com_google_android_gms_common_internal_zzm_zzb);
                if (!com_google_android_gms_common_internal_zzm_zzb.zza(serviceConnection)) {
                    com_google_android_gms_common_internal_zzm_zzb.zza(serviceConnection, str);
                    switch (com_google_android_gms_common_internal_zzm_zzb.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(com_google_android_gms_common_internal_zzm_zzb.getComponentName(), com_google_android_gms_common_internal_zzm_zzb.getBinder());
                            break;
                        case 2:
                            com_google_android_gms_common_internal_zzm_zzb.zzcG(str);
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + com_google_android_gms_common_internal_zzm_zza);
            }
            com_google_android_gms_common_internal_zzm_zzb = new zzb(this, com_google_android_gms_common_internal_zzm_zza);
            com_google_android_gms_common_internal_zzm_zzb.zza(serviceConnection, str);
            com_google_android_gms_common_internal_zzm_zzb.zzcG(str);
            this.zzawK.put(com_google_android_gms_common_internal_zzm_zza, com_google_android_gms_common_internal_zzm_zzb);
            isBound = com_google_android_gms_common_internal_zzm_zzb.isBound();
        }
        return isBound;
    }

    private void zzb(zza com_google_android_gms_common_internal_zzm_zza, ServiceConnection serviceConnection, String str) {
        zzx.zzb((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzawK) {
            zzb com_google_android_gms_common_internal_zzm_zzb = (zzb) this.zzawK.get(com_google_android_gms_common_internal_zzm_zza);
            if (com_google_android_gms_common_internal_zzm_zzb == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + com_google_android_gms_common_internal_zzm_zza);
            } else if (com_google_android_gms_common_internal_zzm_zzb.zza(serviceConnection)) {
                com_google_android_gms_common_internal_zzm_zzb.zzb(serviceConnection, str);
                if (com_google_android_gms_common_internal_zzm_zzb.zzrn()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, com_google_android_gms_common_internal_zzm_zzb), this.zzawM);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + com_google_android_gms_common_internal_zzm_zza);
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                zzb com_google_android_gms_common_internal_zzm_zzb = (zzb) msg.obj;
                synchronized (this.zzawK) {
                    if (com_google_android_gms_common_internal_zzm_zzb.zzrn()) {
                        if (com_google_android_gms_common_internal_zzm_zzb.isBound()) {
                            com_google_android_gms_common_internal_zzm_zzb.zzcH("GmsClientSupervisor");
                        }
                        this.zzawK.remove(com_google_android_gms_common_internal_zzm_zzb.zzawQ);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    public boolean zza(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str), serviceConnection, str2);
    }

    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    public void zzb(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str), serviceConnection, str2);
    }
}

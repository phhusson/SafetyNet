package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzaa extends Fragment implements OnCancelListener {
    private boolean mStarted;
    private boolean zzasP;
    private int zzasQ = -1;
    private ConnectionResult zzasR;
    private final Handler zzasS = new Handler(Looper.getMainLooper());
    protected zzn zzasT;
    private final SparseArray<zza> zzasU = new SparseArray();

    private class zza implements OnConnectionFailedListener {
        public final int clientId;
        public final GoogleApiClient zzasV;
        public final OnConnectionFailedListener zzasW;
        final /* synthetic */ zzaa zzasX;

        public zza(zzaa com_google_android_gms_common_api_internal_zzaa, int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            this.zzasX = com_google_android_gms_common_api_internal_zzaa;
            this.clientId = i;
            this.zzasV = googleApiClient;
            this.zzasW = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            writer.append(prefix).append("GoogleApiClient #").print(this.clientId);
            writer.println(":");
            this.zzasV.dump(prefix + "  ", fd, writer, args);
        }

        public void onConnectionFailed(@NonNull ConnectionResult result) {
            this.zzasX.zzasS.post(new zzb(this.zzasX, this.clientId, result));
        }

        public void zzqh() {
            this.zzasV.unregisterConnectionFailedListener(this);
            this.zzasV.disconnect();
        }
    }

    private class zzb implements Runnable {
        final /* synthetic */ zzaa zzasX;
        private final int zzasY;
        private final ConnectionResult zzasZ;

        public zzb(zzaa com_google_android_gms_common_api_internal_zzaa, int i, ConnectionResult connectionResult) {
            this.zzasX = com_google_android_gms_common_api_internal_zzaa;
            this.zzasY = i;
            this.zzasZ = connectionResult;
        }

        @MainThread
        public void run() {
            if (this.zzasX.mStarted && !this.zzasX.zzasP) {
                this.zzasX.zzasP = true;
                this.zzasX.zzasQ = this.zzasY;
                this.zzasX.zzasR = this.zzasZ;
                if (this.zzasZ.hasResolution()) {
                    try {
                        this.zzasZ.startResolutionForResult(this.zzasX.getActivity(), ((this.zzasX.getActivity().getSupportFragmentManager().getFragments().indexOf(this.zzasX) + 1) << 16) + 1);
                    } catch (SendIntentException e) {
                        this.zzasX.zzqf();
                    }
                } else if (this.zzasX.zzqg().isUserResolvableError(this.zzasZ.getErrorCode())) {
                    this.zzasX.zzb(this.zzasY, this.zzasZ);
                } else if (this.zzasZ.getErrorCode() == 18) {
                    this.zzasX.zzc(this.zzasY, this.zzasZ);
                } else {
                    this.zzasX.zza(this.zzasY, this.zzasZ);
                }
            }
        }
    }

    private void zza(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unresolved error while connecting client. Stopping auto-manage.");
        zza com_google_android_gms_common_api_internal_zzaa_zza = (zza) this.zzasU.get(i);
        if (com_google_android_gms_common_api_internal_zzaa_zza != null) {
            zzcU(i);
            OnConnectionFailedListener onConnectionFailedListener = com_google_android_gms_common_api_internal_zzaa_zza.zzasW;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        zzqf();
    }

    @Nullable
    public static zzaa zzb(FragmentActivity fragmentActivity) {
        zzx.zzcC("Must be called from main thread of process");
        try {
            zzaa com_google_android_gms_common_api_internal_zzaa = (zzaa) fragmentActivity.getSupportFragmentManager().findFragmentByTag("GmsSupportLifecycleFrag");
            return (com_google_android_gms_common_api_internal_zzaa == null || com_google_android_gms_common_api_internal_zzaa.isRemoving()) ? null : com_google_android_gms_common_api_internal_zzaa;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFrag is not a SupportLifecycleFragment", e);
        }
    }

    public static zzaa zzc(FragmentActivity fragmentActivity) {
        zzaa zzb = zzb(fragmentActivity);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (zzb == null) {
            zzb = zzqe();
            if (zzb == null) {
                Log.w("GmsSupportLifecycleFrag", "Unable to find connection error message resources (Did you include play-services-base and the proper proguard rules?); error dialogs may be unavailable.");
                zzb = new zzaa();
            }
            supportFragmentManager.beginTransaction().add((Fragment) zzb, "GmsSupportLifecycleFrag").commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        }
        return zzb;
    }

    private static String zzi(ConnectionResult connectionResult) {
        return connectionResult.getErrorMessage() + " (" + connectionResult.getErrorCode() + ": " + GooglePlayServicesUtilLight.getErrorString(connectionResult.getErrorCode()) + ')';
    }

    @Nullable
    private static zzaa zzqe() {
        Class cls;
        Throwable e;
        try {
            cls = Class.forName("com.google.android.gms.common.api.internal.SupportLifecycleFragmentImpl");
        } catch (ClassNotFoundException e2) {
            e = e2;
            if (Log.isLoggable("GmsSupportLifecycleFrag", 3)) {
                Log.d("GmsSupportLifecycleFrag", "Unable to find SupportLifecycleFragmentImpl class", e);
            }
            cls = null;
            if (cls != null) {
                try {
                    return (zzaa) cls.newInstance();
                } catch (IllegalAccessException e3) {
                    e = e3;
                } catch (InstantiationException e4) {
                    e = e4;
                } catch (ExceptionInInitializerError e5) {
                    e = e5;
                } catch (RuntimeException e6) {
                    e = e6;
                }
            }
            return null;
        } catch (LinkageError e7) {
            e = e7;
            if (Log.isLoggable("GmsSupportLifecycleFrag", 3)) {
                Log.d("GmsSupportLifecycleFrag", "Unable to find SupportLifecycleFragmentImpl class", e);
            }
            cls = null;
            if (cls != null) {
                return (zzaa) cls.newInstance();
            }
            return null;
        } catch (SecurityException e8) {
            e = e8;
            if (Log.isLoggable("GmsSupportLifecycleFrag", 3)) {
                Log.d("GmsSupportLifecycleFrag", "Unable to find SupportLifecycleFragmentImpl class", e);
            }
            cls = null;
            if (cls != null) {
                return (zzaa) cls.newInstance();
            }
            return null;
        }
        if (cls != null) {
            return (zzaa) cls.newInstance();
        }
        return null;
        if (Log.isLoggable("GmsSupportLifecycleFrag", 3)) {
            Log.d("GmsSupportLifecycleFrag", "Unable to instantiate SupportLifecycleFragmentImpl class", e);
        }
        return null;
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
        for (int i = 0; i < this.zzasU.size(); i++) {
            ((zza) this.zzasU.valueAt(i)).dump(prefix, fd, writer, args);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        switch(r5) {
            case 1: goto L_0x001b;
            case 2: goto L_0x000c;
            default: goto L_0x0005;
        };
    L_0x0005:
        r0 = r1;
    L_0x0006:
        if (r0 == 0) goto L_0x002b;
    L_0x0008:
        r4.zzqf();
    L_0x000b:
        return;
    L_0x000c:
        r2 = r4.zzqg();
        r3 = r4.getActivity();
        r2 = r2.isGooglePlayServicesAvailable(r3);
        if (r2 != 0) goto L_0x0005;
    L_0x001a:
        goto L_0x0006;
    L_0x001b:
        r2 = -1;
        if (r6 == r2) goto L_0x0006;
    L_0x001e:
        if (r6 != 0) goto L_0x0005;
    L_0x0020:
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 13;
        r3 = 0;
        r0.<init>(r2, r3);
        r4.zzasR = r0;
        goto L_0x0005;
    L_0x002b:
        r0 = r4.zzasQ;
        r1 = r4.zzasR;
        r4.zza(r0, r1);
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzaa.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        zza(this.zzasQ, new ConnectionResult(13, null));
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.zzasP = savedInstanceState.getBoolean("resolving_error", false);
            this.zzasQ = savedInstanceState.getInt("failed_client_id", -1);
            if (this.zzasQ >= 0) {
                this.zzasR = new ConnectionResult(savedInstanceState.getInt("failed_status"), (PendingIntent) savedInstanceState.getParcelable("failed_resolution"));
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("resolving_error", this.zzasP);
        if (this.zzasQ >= 0) {
            outState.putInt("failed_client_id", this.zzasQ);
            outState.putInt("failed_status", this.zzasR.getErrorCode());
            outState.putParcelable("failed_resolution", this.zzasR.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.mStarted = true;
        if (!this.zzasP) {
            for (int i = 0; i < this.zzasU.size(); i++) {
                ((zza) this.zzasU.valueAt(i)).zzasV.connect();
            }
        }
    }

    public void onStop() {
        super.onStop();
        this.mStarted = false;
        for (int i = 0; i < this.zzasU.size(); i++) {
            ((zza) this.zzasU.valueAt(i)).zzasV.disconnect();
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzb((Object) googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        zzx.zza(this.zzasU.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        this.zzasU.put(i, new zza(this, i, googleApiClient, onConnectionFailedListener));
        if (this.mStarted && !this.zzasP) {
            googleApiClient.connect();
        }
    }

    protected void zzb(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Failed to connect due to user resolvable error " + zzi(connectionResult));
        zza(i, connectionResult);
    }

    protected void zzc(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unable to connect, GooglePlayServices is updating.");
        zza(i, connectionResult);
    }

    public void zzcU(int i) {
        zza com_google_android_gms_common_api_internal_zzaa_zza = (zza) this.zzasU.get(i);
        this.zzasU.remove(i);
        if (com_google_android_gms_common_api_internal_zzaa_zza != null) {
            com_google_android_gms_common_api_internal_zzaa_zza.zzqh();
        }
    }

    protected void zzqf() {
        this.zzasP = false;
        this.zzasQ = -1;
        this.zzasR = null;
        if (this.zzasT != null) {
            this.zzasT.unregister();
            this.zzasT = null;
        }
        for (int i = 0; i < this.zzasU.size(); i++) {
            ((zza) this.zzasU.valueAt(i)).zzasV.connect();
        }
    }

    protected GoogleApiAvailabilityLight zzqg() {
        return GoogleApiAvailabilityLight.getInstance();
    }
}

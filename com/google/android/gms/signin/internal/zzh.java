package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzt;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzxi;
import com.google.android.gms.internal.zzxj;
import com.google.android.gms.signin.internal.zze.zza;

public class zzh extends zzj<zze> implements zzxi {
    private final zzf zzarI;
    private Integer zzavQ;
    private final Bundle zzbTH;
    private final boolean zzbTV;

    public zzh(Context context, Looper looper, boolean z, zzf com_google_android_gms_common_internal_zzf, Bundle bundle, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzbTV = z;
        this.zzarI = com_google_android_gms_common_internal_zzf;
        this.zzbTH = bundle;
        this.zzavQ = com_google_android_gms_common_internal_zzf.zzqT();
    }

    public zzh(Context context, Looper looper, boolean z, zzf com_google_android_gms_common_internal_zzf, zzxj com_google_android_gms_internal_zzxj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, z, com_google_android_gms_common_internal_zzf, zza(com_google_android_gms_common_internal_zzf), connectionCallbacks, onConnectionFailedListener);
    }

    private ResolveAccountRequest zzLB() {
        Account zzqK = this.zzarI.zzqK();
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(zzqK.name)) {
            googleSignInAccount = zzt.zzag(getContext()).zzkZ();
        }
        return new ResolveAccountRequest(zzqK, this.zzavQ.intValue(), googleSignInAccount);
    }

    public static Bundle zza(zzf com_google_android_gms_common_internal_zzf) {
        zzxj zzqS = com_google_android_gms_common_internal_zzf.zzqS();
        Integer zzqT = com_google_android_gms_common_internal_zzf.zzqT();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", com_google_android_gms_common_internal_zzf.getAccount());
        if (zzqT != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zzqT.intValue());
        }
        if (zzqS != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzqS.zzLv());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzqS.zzkz());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzqS.zzkC());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzqS.zzkB());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zzqS.zzkD());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzqS.zzLw());
        }
        return bundle;
    }

    public void connect() {
        zza(new zzf(this));
    }

    public void zzLu() {
        try {
            ((zze) zzrd()).zzpt(this.zzavQ.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public void zza(zzp com_google_android_gms_common_internal_zzp, boolean z) {
        try {
            ((zze) zzrd()).zza(com_google_android_gms_common_internal_zzp, this.zzavQ.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void zza(zzd com_google_android_gms_signin_internal_zzd) {
        zzx.zzb((Object) com_google_android_gms_signin_internal_zzd, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((zze) zzrd()).zza(new SignInRequest(zzLB()), com_google_android_gms_signin_internal_zzd);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                com_google_android_gms_signin_internal_zzd.zzb(new SignInResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    protected /* synthetic */ IInterface zzaa(IBinder iBinder) {
        return zzhi(iBinder);
    }

    protected String zzgC() {
        return "com.google.android.gms.signin.service.START";
    }

    protected String zzgD() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected zze zzhi(IBinder iBinder) {
        return zza.zzhh(iBinder);
    }

    protected Bundle zzkd() {
        if (!getContext().getPackageName().equals(this.zzarI.zzqP())) {
            this.zzbTH.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzarI.zzqP());
        }
        return this.zzbTH;
    }

    public boolean zzkt() {
        return this.zzbTV;
    }
}

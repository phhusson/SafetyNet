package com.google.android.gms.auth.frp;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.stats.zzb;

public class FrpClient {
    private final Context mContext;

    private interface zza<R> {
        R zzb(zza com_google_android_gms_auth_frp_zza) throws RemoteException;
    }

    class C01841 implements zza<Boolean> {
        final /* synthetic */ FrpClient zzacB;

        C01841(FrpClient frpClient) {
            this.zzacB = frpClient;
        }

        public Boolean zza(zza com_google_android_gms_auth_frp_zza) throws RemoteException {
            return Boolean.valueOf(com_google_android_gms_auth_frp_zza.isChallengeSupported());
        }

        public /* synthetic */ Object zzb(zza com_google_android_gms_auth_frp_zza) throws RemoteException {
            return zza(com_google_android_gms_auth_frp_zza);
        }
    }

    class C01852 implements zza<Boolean> {
        final /* synthetic */ FrpClient zzacB;

        C01852(FrpClient frpClient) {
            this.zzacB = frpClient;
        }

        public Boolean zza(zza com_google_android_gms_auth_frp_zza) throws RemoteException {
            return Boolean.valueOf(com_google_android_gms_auth_frp_zza.isChallengeRequired());
        }

        public /* synthetic */ Object zzb(zza com_google_android_gms_auth_frp_zza) throws RemoteException {
            return zza(com_google_android_gms_auth_frp_zza);
        }
    }

    public FrpClient(Context context) {
        this.mContext = context;
    }

    private <R> R zza(zza<R> com_google_android_gms_auth_frp_FrpClient_zza_R) throws RemoteException, InterruptedException {
        Intent zzlj = zzlj();
        long clearCallingIdentity = Binder.clearCallingIdentity();
        ServiceConnection com_google_android_gms_common_zza;
        try {
            com_google_android_gms_common_zza = new com.google.android.gms.common.zza();
            if (zzb.zzrU().zza(this.mContext, zzlj, com_google_android_gms_common_zza, 1)) {
                R zzb = com_google_android_gms_auth_frp_FrpClient_zza_R.zzb(com.google.android.gms.auth.frp.zza.zza.zzaZ(com_google_android_gms_common_zza.zzoW()));
                zzb.zzrU().zza(this.mContext, com_google_android_gms_common_zza);
                Binder.restoreCallingIdentity(clearCallingIdentity);
                return zzb;
            }
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return null;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    private static Intent zzlj() {
        return new Intent().setPackage("com.google.android.gms").setAction("com.google.android.gms.auth.frp.FRP_BIND").addCategory("android.intent.category.DEFAULT");
    }

    public boolean isChallengeRequired() {
        Throwable e;
        try {
            return ((Boolean) zza(new C01852(this))).booleanValue();
        } catch (RemoteException e2) {
            e = e2;
            Log.w("FrpClient", e);
            return false;
        } catch (InterruptedException e3) {
            e = e3;
            Log.w("FrpClient", e);
            return false;
        }
    }

    public boolean isChallengeSupported() {
        Throwable e;
        try {
            return ((Boolean) zza(new C01841(this))).booleanValue();
        } catch (RemoteException e2) {
            e = e2;
            Log.w("FrpClient", e);
            return false;
        } catch (InterruptedException e3) {
            e = e3;
            Log.w("FrpClient", e);
            return false;
        }
    }

    public UnlockFactoryResetProtectionResponse unlockFactoryResetProtection(final UnlockFactoryResetProtectionRequest unlockRequest) {
        Throwable e;
        try {
            return (UnlockFactoryResetProtectionResponse) zza(new zza<UnlockFactoryResetProtectionResponse>(this) {
                final /* synthetic */ FrpClient zzacB;

                public /* synthetic */ Object zzb(zza com_google_android_gms_auth_frp_zza) throws RemoteException {
                    return zzc(com_google_android_gms_auth_frp_zza);
                }

                public UnlockFactoryResetProtectionResponse zzc(zza com_google_android_gms_auth_frp_zza) throws RemoteException {
                    return com_google_android_gms_auth_frp_zza.unlockFactoryResetProtection(unlockRequest);
                }
            });
        } catch (RemoteException e2) {
            e = e2;
        } catch (InterruptedException e3) {
            e = e3;
        }
        Log.w("FrpClient", e);
        return new UnlockFactoryResetProtectionResponse(1);
    }
}

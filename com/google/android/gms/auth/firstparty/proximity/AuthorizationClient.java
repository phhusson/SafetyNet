package com.google.android.gms.auth.firstparty.proximity;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.auth.firstparty.proximity.data.Authorization;
import com.google.android.gms.auth.firstparty.proximity.data.AuthorizationRequest;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.stats.zzb;

public class AuthorizationClient {
    public static final String BUNDLE_KEY_AUTHORIZATION = "authorization";
    public static final String BUNDLE_KEY_EXCEPTION = "exception";
    private final Context mContext;

    private interface zza {
        Bundle zza(zza com_google_android_gms_auth_firstparty_proximity_zza) throws RemoteException;
    }

    public AuthorizationClient(Context context) {
        this.mContext = context;
    }

    private Bundle zza(zza com_google_android_gms_auth_firstparty_proximity_AuthorizationClient_zza) throws ProximityAuthException {
        Intent zzli = zzli();
        zzl(zzli);
        ServiceConnection com_google_android_gms_common_zza = new com.google.android.gms.common.zza();
        if (zzb.zzrU().zza(this.mContext, zzli, com_google_android_gms_common_zza, 1)) {
            try {
                Bundle zza = com_google_android_gms_auth_firstparty_proximity_AuthorizationClient_zza.zza(com.google.android.gms.auth.firstparty.proximity.zza.zza.zzaY(com_google_android_gms_common_zza.zzoW()));
                zza.setClassLoader(getClass().getClassLoader());
                if (zza.containsKey(BUNDLE_KEY_EXCEPTION)) {
                    throw ((ProximityAuthException) zza.getSerializable(BUNDLE_KEY_EXCEPTION));
                }
                zzb.zzrU().zza(this.mContext, com_google_android_gms_common_zza);
                return zza;
            } catch (InterruptedException e) {
                throw new ProximityAuthException(e.getMessage());
            } catch (RemoteException e2) {
                throw new ProximityAuthException(e2.getMessage());
            } catch (Throwable th) {
                zzb.zzrU().zza(this.mContext, com_google_android_gms_common_zza);
            }
        } else {
            throw new ProximityAuthException("Cannot bind to " + zza.class.getSimpleName() + "!");
        }
    }

    private void zzl(Intent intent) {
        PackageManager packageManager = this.mContext.getPackageManager();
        for (ResolveInfo resolveInfo : this.mContext.getPackageManager().queryIntentServices(intent, 0)) {
            String str = resolveInfo.serviceInfo.packageName;
            if (!GooglePlayServicesUtilLight.isPackageGoogleSigned(packageManager, str)) {
                throw new SecurityException("AuthorizationClient appears to have been spoofed by: " + str);
            }
        }
    }

    private static Intent zzli() {
        return new Intent().setPackage("com.google.android.gms").setAction("com.google.android.gms.auth.proximity.AUTHORIZATION").addCategory("android.intent.category.DEFAULT");
    }

    public Authorization authorize(final AuthorizationRequest request) throws ProximityAuthException {
        return (Authorization) zza(new zza(this) {
            final /* synthetic */ AuthorizationClient zzabQ;

            public Bundle zza(zza com_google_android_gms_auth_firstparty_proximity_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_proximity_zza.zza(request);
            }
        }).getParcelable(BUNDLE_KEY_AUTHORIZATION);
    }
}

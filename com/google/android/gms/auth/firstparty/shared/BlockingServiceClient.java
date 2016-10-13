package com.google.android.gms.auth.firstparty.shared;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zza;

public abstract class BlockingServiceClient {
    private final String TAG = "BlockingServiceClient";
    private final Context mContext;

    protected interface Call<R> {
        R exec(IBinder iBinder) throws RemoteException;
    }

    protected BlockingServiceClient(Context context) {
        this.mContext = context.getApplicationContext();
    }

    protected <R> R exec(Call<R> call) {
        zzx.zzcD("Calling this from your main thread can lead to deadlock");
        Intent serviceIntent = getServiceIntent();
        PackageManager packageManager = this.mContext.getPackageManager();
        ResolveInfo resolveService = packageManager.resolveService(serviceIntent, 0);
        if (resolveService == null || resolveService.serviceInfo == null) {
            throw new IllegalStateException("Can't resolve a service for intent: " + serviceIntent.toString());
        }
        ServiceInfo serviceInfo = resolveService.serviceInfo;
        Throwable e;
        if (GooglePlayServicesUtilLight.isPackageGoogleSigned(packageManager, serviceInfo.packageName)) {
            serviceIntent.setPackage(serviceInfo.packageName);
            ServiceConnection com_google_android_gms_common_zza = new zza();
            if (!zzb.zzrU().zza(this.mContext, serviceIntent, com_google_android_gms_common_zza, 1)) {
                return null;
            }
            try {
                R exec = call.exec(com_google_android_gms_common_zza.zzoW());
                zzb.zzrU().zza(this.mContext, com_google_android_gms_common_zza);
                return exec;
            } catch (Throwable e2) {
                Log.w("BlockingServiceClient", e2);
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                Log.w("BlockingServiceClient", e22);
                throw new RuntimeException(e22);
            } catch (Throwable th) {
                zzb.zzrU().zza(this.mContext, com_google_android_gms_common_zza);
            }
        } else {
            e22 = new SecurityException("Resolving service is not provided by Google!");
            Log.w("BlockingServiceClient", e22);
            throw e22;
        }
    }

    protected abstract Intent getServiceIntent();
}

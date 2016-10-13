package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.zzx;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final GoogleApiAvailabilityLight zzbTC = GoogleApiAvailabilityLight.getInstance();
    private static Method zzbTD = null;
    private static final Object zzrc = new Object();

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzx.zzb((Object) context, (Object) "Context must not be null");
        zzbTC.zzal(context);
        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (zzrc) {
            try {
                if (zzbTD == null) {
                    zzaW(remoteContext);
                }
                zzbTD.invoke(null, new Object[]{remoteContext});
            } catch (Exception e) {
                Log.e("ProviderInstaller", "Failed to install provider: " + e.getMessage());
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void installIfNeededAsync(final Context context, final ProviderInstallListener listener) {
        zzx.zzb((Object) context, (Object) "Context must not be null");
        zzx.zzb((Object) listener, (Object) "Listener must not be null");
        zzx.zzcC("Must be called on the UI thread");
        new AsyncTask<Void, Void, Integer>() {
            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return zzc((Void[]) objArr);
            }

            protected /* synthetic */ void onPostExecute(Object obj) {
                zzg((Integer) obj);
            }

            protected Integer zzc(Void... voidArr) {
                try {
                    ProviderInstaller.installIfNeeded(context);
                    return Integer.valueOf(0);
                } catch (GooglePlayServicesRepairableException e) {
                    return Integer.valueOf(e.getConnectionStatusCode());
                } catch (GooglePlayServicesNotAvailableException e2) {
                    return Integer.valueOf(e2.errorCode);
                }
            }

            protected void zzg(Integer num) {
                if (num.intValue() == 0) {
                    listener.onProviderInstalled();
                    return;
                }
                listener.onProviderInstallFailed(num.intValue(), ProviderInstaller.zzbTC.getErrorResolutionIntent(context, num.intValue(), "pi"));
            }
        }.execute(new Void[0]);
    }

    private static void zzaW(Context context) throws ClassNotFoundException, NoSuchMethodException {
        zzbTD = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
    }
}

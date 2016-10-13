package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zznm.zza;

public class zznl extends zzj<zznm> {
    public zznl(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 43, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzaa(IBinder iBinder) {
        return zzco(iBinder);
    }

    protected zznm zzco(IBinder iBinder) {
        return zza.zzcp(iBinder);
    }

    protected String zzgC() {
        return "com.google.android.gms.common.download.START";
    }

    protected String zzgD() {
        return "com.google.android.gms.common.download.internal.IDownloadService";
    }
}

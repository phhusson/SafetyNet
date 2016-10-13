package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zznf.zza;

public class zznd extends zzj<zznf> {
    public zznd(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 40, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    public void zza(zzne com_google_android_gms_internal_zzne, LogEventParcelable logEventParcelable) throws RemoteException {
        ((zznf) zzrd()).zza(com_google_android_gms_internal_zzne, logEventParcelable);
    }

    protected /* synthetic */ IInterface zzaa(IBinder iBinder) {
        return zzci(iBinder);
    }

    protected zznf zzci(IBinder iBinder) {
        return zza.zzck(iBinder);
    }

    protected String zzgC() {
        return "com.google.android.gms.clearcut.service.START";
    }

    protected String zzgD() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }
}

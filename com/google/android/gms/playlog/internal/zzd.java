package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.playlog.PlayLogger.LoggerCallbacks;

public class zzd implements ConnectionCallbacks, OnConnectionFailedListener {
    private final LoggerCallbacks zzbLJ;
    private boolean zzbLK = true;
    private zze zzbLy = null;

    public zzd(LoggerCallbacks loggerCallbacks) {
        this.zzbLJ = loggerCallbacks;
    }

    public void onConnected(Bundle connectionHint) {
        this.zzbLy.zzaV(false);
        if (this.zzbLK && this.zzbLJ != null) {
            this.zzbLJ.onLoggerConnected();
        }
        this.zzbLK = false;
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.zzbLy.zzaV(true);
        if (this.zzbLK && this.zzbLJ != null) {
            if (result.hasResolution()) {
                this.zzbLJ.onLoggerFailedConnectionWithResolution(result.getResolution());
            } else {
                this.zzbLJ.onLoggerFailedConnection();
            }
        }
        this.zzbLK = false;
    }

    public void onConnectionSuspended(int cause) {
        this.zzbLy.zzaV(true);
    }

    public void zza(zze com_google_android_gms_playlog_internal_zze) {
        this.zzbLy = com_google_android_gms_playlog_internal_zze;
    }

    public void zzaU(boolean z) {
        this.zzbLK = z;
    }
}

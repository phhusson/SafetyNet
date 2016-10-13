package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;

public class zzc implements ConnectionCallbacks, OnConnectionFailedListener {
    public final Api<?> zzarc;
    private final int zzard;
    private zzl zzare;

    public zzc(Api<?> api, int i) {
        this.zzarc = api;
        this.zzard = i;
    }

    private void zzpw() {
        zzx.zzb(this.zzare, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public void onConnected(@Nullable Bundle connectionHint) {
        zzpw();
        this.zzare.onConnected(connectionHint);
    }

    public void onConnectionFailed(@NonNull ConnectionResult result) {
        zzpw();
        this.zzare.zza(result, this.zzarc, this.zzard);
    }

    public void onConnectionSuspended(int cause) {
        zzpw();
        this.zzare.onConnectionSuspended(cause);
    }

    public void zza(zzl com_google_android_gms_common_api_internal_zzl) {
        this.zzare = com_google_android_gms_common_api_internal_zzl;
    }
}

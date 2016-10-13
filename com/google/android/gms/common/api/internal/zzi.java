package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza.zza;
import java.util.Collections;

public class zzi implements zzk {
    private final zzl zzars;

    public zzi(zzl com_google_android_gms_common_api_internal_zzl) {
        this.zzars = com_google_android_gms_common_api_internal_zzl;
    }

    public void begin() {
        this.zzars.zzqa();
        this.zzars.zzarf.zzasd = Collections.emptySet();
    }

    public void connect() {
        this.zzars.zzpY();
    }

    public boolean disconnect() {
        return true;
    }

    public void onConnected(Bundle connectionHint) {
    }

    public void onConnectionSuspended(int cause) {
    }

    public <A extends zzb, R extends Result, T extends zza<R, A>> T zza(T t) {
        this.zzars.zzarf.zzarW.add(t);
        return t;
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzb(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}

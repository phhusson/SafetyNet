package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zza;

public class zzg implements zzk {
    private final zzl zzars;
    private boolean zzart = false;

    public zzg(zzl com_google_android_gms_common_api_internal_zzl) {
        this.zzars = com_google_android_gms_common_api_internal_zzl;
    }

    private <A extends zzb> void zza(zze<A> com_google_android_gms_common_api_internal_zzj_zze_A) throws DeadObjectException {
        this.zzars.zzarf.zzb((zze) com_google_android_gms_common_api_internal_zzj_zze_A);
        zzb zza = this.zzars.zzarf.zza(com_google_android_gms_common_api_internal_zzj_zze_A.zzpg());
        if (zza.isConnected() || !this.zzars.zzasw.containsKey(com_google_android_gms_common_api_internal_zzj_zze_A.zzpg())) {
            com_google_android_gms_common_api_internal_zzj_zze_A.zzb(zza);
        } else {
            com_google_android_gms_common_api_internal_zzj_zze_A.zzF(new Status(17));
        }
    }

    public void begin() {
    }

    public void connect() {
        if (this.zzart) {
            this.zzart = false;
            this.zzars.zza(new zza(this, this) {
                final /* synthetic */ zzg zzaru;

                public void zzpH() {
                    this.zzaru.zzars.zzasA.zzo(null);
                }
            });
        }
    }

    public boolean disconnect() {
        if (this.zzart) {
            return false;
        }
        if (this.zzars.zzarf.zzpU()) {
            this.zzart = true;
            for (zzac zzqk : this.zzars.zzarf.zzasi) {
                zzqk.zzqk();
            }
            return false;
        }
        this.zzars.zzh(null);
        return true;
    }

    public void onConnected(Bundle connectionHint) {
    }

    public void onConnectionSuspended(int cause) {
        this.zzars.zzh(null);
        this.zzars.zzasA.zze(cause, this.zzart);
    }

    public <A extends zzb, R extends Result, T extends zza<R, A>> T zza(T t) {
        return zzb(t);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzb(T t) {
        try {
            zza((zze) t);
        } catch (DeadObjectException e) {
            this.zzars.zza(new zza(this, this) {
                final /* synthetic */ zzg zzaru;

                public void zzpH() {
                    this.zzaru.onConnectionSuspended(1);
                }
            });
        }
        return t;
    }

    void zzpG() {
        if (this.zzart) {
            this.zzart = false;
            this.zzars.zzarf.zzac(false);
            disconnect();
        }
    }
}

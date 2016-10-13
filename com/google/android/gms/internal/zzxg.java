package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.signin.internal.zzg;
import com.google.android.gms.signin.internal.zzh;

public final class zzxg {
    public static final Api<zzxj> API = new Api("SignIn.API", zzVk, zzVj);
    public static final zzc<zzh> zzVj = new zzc();
    public static final com.google.android.gms.common.api.Api.zza<zzh, zzxj> zzVk = new C05581();
    public static final Scope zzYG = new Scope(Scopes.PROFILE);
    public static final Scope zzYH = new Scope("email");
    public static final Api<zza> zzaDK = new Api("SignIn.INTERNAL_API", zzbTF, zzaOg);
    public static final zzc<zzh> zzaOg = new zzc();
    static final com.google.android.gms.common.api.Api.zza<zzh, zza> zzbTF = new C05592();
    public static final zzxh zzbTG = new zzg();

    static class C05581 extends com.google.android.gms.common.api.Api.zza<zzh, zzxj> {
        C05581() {
        }

        public zzh zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zzxj com_google_android_gms_internal_zzxj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzh(context, looper, true, com_google_android_gms_common_internal_zzf, com_google_android_gms_internal_zzxj == null ? zzxj.zzbTI : com_google_android_gms_internal_zzxj, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static class C05592 extends com.google.android.gms.common.api.Api.zza<zzh, zza> {
        C05592() {
        }

        public zzh zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zza com_google_android_gms_internal_zzxg_zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzh(context, looper, false, com_google_android_gms_common_internal_zzf, com_google_android_gms_internal_zzxg_zza.zzLt(), connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static class zza implements HasOptions {
        private final Bundle zzbTH;

        public Bundle zzLt() {
            return this.zzbTH;
        }
    }
}

package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzx;

public final class zzr<L> {
    private volatile L mListener;
    private final zza zzasF;

    public interface zzb<L> {
        void zzpF();

        void zzw(L l);
    }

    private final class zza extends Handler {
        final /* synthetic */ zzr zzasG;

        public zza(zzr com_google_android_gms_common_api_internal_zzr, Looper looper) {
            this.zzasG = com_google_android_gms_common_api_internal_zzr;
            super(looper);
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            if (msg.what != 1) {
                z = false;
            }
            zzx.zzae(z);
            this.zzasG.zzb((zzb) msg.obj);
        }
    }

    zzr(Looper looper, L l) {
        this.zzasF = new zza(this, looper);
        this.mListener = zzx.zzb((Object) l, (Object) "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> com_google_android_gms_common_api_internal_zzr_zzb__super_L) {
        zzx.zzb((Object) com_google_android_gms_common_api_internal_zzr_zzb__super_L, (Object) "Notifier must not be null");
        this.zzasF.sendMessage(this.zzasF.obtainMessage(1, com_google_android_gms_common_api_internal_zzr_zzb__super_L));
    }

    void zzb(zzb<? super L> com_google_android_gms_common_api_internal_zzr_zzb__super_L) {
        Object obj = this.mListener;
        if (obj == null) {
            com_google_android_gms_common_api_internal_zzr_zzb__super_L.zzpF();
            return;
        }
        try {
            com_google_android_gms_common_api_internal_zzr_zzb__super_L.zzw(obj);
        } catch (RuntimeException e) {
            com_google_android_gms_common_api_internal_zzr_zzb__super_L.zzpF();
            throw e;
        }
    }
}

package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultStore;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

public abstract class zzt<A extends Result, B extends Result> extends PendingResult<B> {
    private final PendingResult<A> zzasI;

    public zzt(PendingResult<A> pendingResult) {
        zzx.zzD(pendingResult);
        this.zzasI = pendingResult;
    }

    private <T extends Result> ResultTransform<? super A, T> zza(final ResultTransform<? super B, T> resultTransform) {
        return new ResultTransform<A, T>(this) {
            final /* synthetic */ zzt zzasK;

            public Status onFailure(Status status) {
                return resultTransform.onFailure(status);
            }

            public PendingResult<T> onSuccess(A result) {
                return resultTransform.onSuccess(this.zzasK.zzd(result));
            }
        };
    }

    public B await() {
        return zzd(this.zzasI.await());
    }

    public B await(long time, TimeUnit units) {
        return zzd(this.zzasI.await(time, units));
    }

    public void cancel() {
        this.zzasI.cancel();
    }

    public boolean isCanceled() {
        return this.zzasI.isCanceled();
    }

    public void setResultCallback(final ResultCallback<? super B> callback) {
        this.zzasI.setResultCallback(new ResultCallback<A>(this) {
            final /* synthetic */ zzt zzasK;

            public void onResult(@NonNull A result) {
                callback.onResult(this.zzasK.zzd(result));
            }
        });
    }

    public void setResultCallback(final ResultCallback<? super B> callback, long time, TimeUnit units) {
        this.zzasI.setResultCallback(new ResultCallback<A>(this) {
            final /* synthetic */ zzt zzasK;

            public void onResult(@NonNull A result) {
                callback.onResult(this.zzasK.zzd(result));
            }
        }, time, units);
    }

    public void store(ResultStore resultStore, int resultId) {
        this.zzasI.store(resultStore, resultId);
    }

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super B, ? extends S> transform) {
        return this.zzasI.then(zza((ResultTransform) transform));
    }

    public void zza(zza com_google_android_gms_common_api_PendingResult_zza) {
        this.zzasI.zza(com_google_android_gms_common_api_PendingResult_zza);
    }

    public void zzcN(int i) {
        this.zzasI.zzcN(i);
    }

    protected abstract B zzd(A a);

    public Integer zzpp() {
        return this.zzasI.zzpp();
    }
}

package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzx;
import java.lang.ref.WeakReference;

public class zzac<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    private final Object zzaqR = new Object();
    private final WeakReference<GoogleApiClient> zzaqT;
    private ResultTransform<? super R, ? extends Result> zzatc = null;
    private zzac<? extends Result> zzatd = null;
    private ResultCallbacks<? super R> zzate = null;
    private PendingResult<R> zzatf = null;
    private Status zzatg = null;
    private final zza zzath;

    private final class zza extends Handler {
        final /* synthetic */ zzac zzatj;

        public zza(zzac com_google_android_gms_common_api_internal_zzac, Looper looper) {
            this.zzatj = com_google_android_gms_common_api_internal_zzac;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    PendingResult pendingResult = (PendingResult) msg.obj;
                    synchronized (this.zzatj.zzaqR) {
                        if (pendingResult == null) {
                            this.zzatj.zzatd.zzH(new Status(13, "Transform returned null"));
                        } else if (pendingResult instanceof zzw) {
                            this.zzatj.zzatd.zzH(((zzw) pendingResult).getStatus());
                        } else {
                            this.zzatj.zzatd.zza(pendingResult);
                        }
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) msg.obj;
                    Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: " + runtimeException.getMessage());
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + msg.what);
                    return;
            }
        }
    }

    public zzac(WeakReference<GoogleApiClient> weakReference) {
        zzx.zzb((Object) weakReference, (Object) "GoogleApiClient reference must not be null");
        this.zzaqT = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) this.zzaqT.get();
        this.zzath = new zza(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    private void zzH(Status status) {
        synchronized (this.zzaqR) {
            this.zzatg = status;
            zzI(this.zzatg);
        }
    }

    private void zzI(Status status) {
        synchronized (this.zzaqR) {
            if (this.zzatc != null) {
                Object onFailure = this.zzatc.onFailure(status);
                zzx.zzb(onFailure, (Object) "onFailure must not return null");
                this.zzatd.zzH(onFailure);
            } else if (zzql()) {
                this.zzate.onFailure(status);
            }
        }
    }

    private void zzc(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                Log.w("TransformedResultImpl", "Unable to release " + result, e);
            }
        }
    }

    private void zzqj() {
        if (this.zzatc != null || this.zzate != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zzaqT.get();
            if (!(this.zzatc == null || googleApiClient == null)) {
                googleApiClient.zza(this);
            }
            if (this.zzatg != null) {
                zzI(this.zzatg);
            } else if (this.zzatf != null) {
                this.zzatf.setResultCallback(this);
            }
        }
    }

    private boolean zzql() {
        return (this.zzate == null || ((GoogleApiClient) this.zzaqT.get()) == null) ? false : true;
    }

    public void andFinally(@NonNull ResultCallbacks<? super R> callbacks) {
        boolean z = true;
        synchronized (this.zzaqR) {
            zzx.zza(this.zzate == null, (Object) "Cannot call andFinally() twice.");
            if (this.zzatc != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zzate = callbacks;
            zzqj();
        }
    }

    public void onResult(final R result) {
        synchronized (this.zzaqR) {
            if (!result.getStatus().isSuccess()) {
                zzH(result.getStatus());
                zzc((Result) result);
            } else if (this.zzatc != null) {
                zzv.zzqb().submit(new Runnable(this) {
                    final /* synthetic */ zzac zzatj;

                    @WorkerThread
                    public void run() {
                        GoogleApiClient googleApiClient;
                        try {
                            this.zzatj.zzath.sendMessage(this.zzatj.zzath.obtainMessage(0, this.zzatj.zzatc.onSuccess(result)));
                            this.zzatj.zzc(result);
                            googleApiClient = (GoogleApiClient) this.zzatj.zzaqT.get();
                            if (googleApiClient != null) {
                                googleApiClient.zzb(this.zzatj);
                            }
                        } catch (RuntimeException e) {
                            this.zzatj.zzath.sendMessage(this.zzatj.zzath.obtainMessage(1, e));
                            this.zzatj.zzc(result);
                            googleApiClient = (GoogleApiClient) this.zzatj.zzaqT.get();
                            if (googleApiClient != null) {
                                googleApiClient.zzb(this.zzatj);
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            this.zzatj.zzc(result);
                            googleApiClient = (GoogleApiClient) this.zzatj.zzaqT.get();
                            if (googleApiClient != null) {
                                googleApiClient.zzb(this.zzatj);
                            }
                        }
                    }
                });
            } else if (zzql()) {
                this.zzate.onSuccess(result);
            }
        }
    }

    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> transform) {
        TransformedResult com_google_android_gms_common_api_internal_zzac;
        boolean z = true;
        synchronized (this.zzaqR) {
            zzx.zza(this.zzatc == null, (Object) "Cannot call then() twice.");
            if (this.zzate != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zzatc = transform;
            com_google_android_gms_common_api_internal_zzac = new zzac(this.zzaqT);
            this.zzatd = com_google_android_gms_common_api_internal_zzac;
            zzqj();
        }
        return com_google_android_gms_common_api_internal_zzac;
    }

    public void zza(PendingResult<?> pendingResult) {
        synchronized (this.zzaqR) {
            this.zzatf = pendingResult;
            zzqj();
        }
    }

    void zzqk() {
        synchronized (this.zzaqR) {
            this.zzate = null;
        }
    }
}

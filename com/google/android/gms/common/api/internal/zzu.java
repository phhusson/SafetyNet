package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.util.SparseArray;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultStore;
import com.google.android.gms.common.internal.zzx;

public class zzu extends ResultStore {
    private final SparseArray<PendingResult<?>> zzasM = new SparseArray();
    private final SparseArray<ResultCallbacks<?>> zzasN = new SparseArray();
    private final Object zzqz = new Object();

    public boolean hasPendingResult(int resultId) {
        boolean z;
        synchronized (this.zzqz) {
            z = this.zzasM.get(resultId) != null;
        }
        return z;
    }

    public void remove(int resultId) {
        synchronized (this.zzqz) {
            if (((PendingResult) this.zzasM.get(resultId)) != null) {
                this.zzasM.remove(resultId);
            }
        }
    }

    public void setResultCallbacks(int resultId, ResultCallbacks resultCallbacks) {
        zzx.zzb((Object) resultCallbacks, (Object) "ResultCallbacks cannot be null.");
        synchronized (this.zzqz) {
            this.zzasN.put(resultId, resultCallbacks);
            PendingResult pendingResult = (PendingResult) this.zzasM.get(resultId);
            if (pendingResult != null) {
                pendingResult.setResultCallback(resultCallbacks);
            }
        }
    }

    public <R extends Result> void zza(int i, PendingResult<R> pendingResult) {
        boolean z = true;
        synchronized (this.zzqz) {
            zzx.zzb(this.zzasM.get(i) == null, "ResultStore ResultId must be unique within the current activity. Violating ResultId: " + i);
            if (pendingResult.zzpp() != null) {
                z = false;
            }
            zzx.zzb(z, (Object) "PendingResult has already been saved.");
            pendingResult.zzcN(i);
            this.zzasM.put(i, pendingResult);
            ResultCallbacks resultCallbacks = (ResultCallbacks) this.zzasN.get(i);
            if (resultCallbacks != null) {
                pendingResult.setResultCallback(resultCallbacks);
            }
        }
    }

    public void zzqd() {
        synchronized (this.zzqz) {
            this.zzasN.clear();
            for (int i = 0; i < this.zzasM.size(); i++) {
                ((PendingResult) this.zzasM.valueAt(i)).setResultCallback(null);
            }
        }
    }

    public void zzr(Activity activity) {
        synchronized (this.zzqz) {
            for (int i = 0; i < this.zzasM.size(); i++) {
                ((PendingResult) this.zzasM.valueAt(i)).cancel();
            }
        }
        ResultStore.zzq(activity);
    }
}

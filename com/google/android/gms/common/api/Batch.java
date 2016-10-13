package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.internal.zzb;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zzb<BatchResult> {
    private int zzaqj;
    private boolean zzaqk;
    private boolean zzaql;
    private final PendingResult<?>[] zzaqm;
    private final Object zzqz;

    class C01921 implements zza {
        final /* synthetic */ Batch zzaqn;

        C01921(Batch batch) {
            this.zzaqn = batch;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zzD(com.google.android.gms.common.api.Status r6) {
            /*
            r5 = this;
            r0 = r5.zzaqn;
            r1 = r0.zzqz;
            monitor-enter(r1);
            r0 = r5.zzaqn;	 Catch:{ all -> 0x0039 }
            r0 = r0.isCanceled();	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0011;
        L_0x000f:
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        L_0x0010:
            return;
        L_0x0011:
            r0 = r6.isCanceled();	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x003c;
        L_0x0017:
            r0 = r5.zzaqn;	 Catch:{ all -> 0x0039 }
            r2 = 1;
            r0.zzaql = r2;	 Catch:{ all -> 0x0039 }
        L_0x001d:
            r0 = r5.zzaqn;	 Catch:{ all -> 0x0039 }
            r0.zzaqj = r0.zzaqj - 1;	 Catch:{ all -> 0x0039 }
            r0 = r5.zzaqn;	 Catch:{ all -> 0x0039 }
            r0 = r0.zzaqj;	 Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x0037;
        L_0x002a:
            r0 = r5.zzaqn;	 Catch:{ all -> 0x0039 }
            r0 = r0.zzaql;	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0049;
        L_0x0032:
            r0 = r5.zzaqn;	 Catch:{ all -> 0x0039 }
            super.cancel();	 Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            goto L_0x0010;
        L_0x0039:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            throw r0;
        L_0x003c:
            r0 = r6.isSuccess();	 Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x001d;
        L_0x0042:
            r0 = r5.zzaqn;	 Catch:{ all -> 0x0039 }
            r2 = 1;
            r0.zzaqk = r2;	 Catch:{ all -> 0x0039 }
            goto L_0x001d;
        L_0x0049:
            r0 = r5.zzaqn;	 Catch:{ all -> 0x0039 }
            r0 = r0.zzaqk;	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0069;
        L_0x0051:
            r0 = new com.google.android.gms.common.api.Status;	 Catch:{ all -> 0x0039 }
            r2 = 13;
            r0.<init>(r2);	 Catch:{ all -> 0x0039 }
        L_0x0058:
            r2 = r5.zzaqn;	 Catch:{ all -> 0x0039 }
            r3 = new com.google.android.gms.common.api.BatchResult;	 Catch:{ all -> 0x0039 }
            r4 = r5.zzaqn;	 Catch:{ all -> 0x0039 }
            r4 = r4.zzaqm;	 Catch:{ all -> 0x0039 }
            r3.<init>(r0, r4);	 Catch:{ all -> 0x0039 }
            r2.zza(r3);	 Catch:{ all -> 0x0039 }
            goto L_0x0037;
        L_0x0069:
            r0 = com.google.android.gms.common.api.Status.zzaqL;	 Catch:{ all -> 0x0039 }
            goto L_0x0058;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.Batch.1.zzD(com.google.android.gms.common.api.Status):void");
        }
    }

    public static final class Builder {
        private GoogleApiClient mApiClient;
        private List<PendingResult<?>> zzaqo = new ArrayList();

        public Builder(GoogleApiClient googleApiClient) {
            this.mApiClient = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken(this.zzaqo.size());
            this.zzaqo.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.zzaqo, this.mApiClient);
        }
    }

    private Batch(List<PendingResult<?>> pendingResultList, GoogleApiClient apiClient) {
        super(apiClient);
        this.zzqz = new Object();
        this.zzaqj = pendingResultList.size();
        this.zzaqm = new PendingResult[this.zzaqj];
        if (pendingResultList.isEmpty()) {
            zza(new BatchResult(Status.zzaqL, this.zzaqm));
            return;
        }
        for (int i = 0; i < pendingResultList.size(); i++) {
            PendingResult pendingResult = (PendingResult) pendingResultList.get(i);
            this.zzaqm[i] = pendingResult;
            pendingResult.zza(new C01921(this));
        }
    }

    public void cancel() {
        super.cancel();
        for (PendingResult cancel : this.zzaqm) {
            cancel.cancel();
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.zzaqm);
    }

    public /* synthetic */ Result zzb(Status status) {
        return createFailedResult(status);
    }
}

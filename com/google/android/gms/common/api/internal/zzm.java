package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzoa;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzm {
    private static final ExecutorService zzasD = Executors.newFixedThreadPool(2, new zzoa("GAC_Executor"));

    public static ExecutorService zzqb() {
        return zzasD;
    }
}

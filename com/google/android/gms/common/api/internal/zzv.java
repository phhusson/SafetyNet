package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzoa;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class zzv {
    private static final ExecutorService zzasD = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzoa("GAC_Transform"));

    public static ExecutorService zzqb() {
        return zzasD;
    }
}

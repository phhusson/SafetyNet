package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zzoa implements ThreadFactory {
    private final int mPriority;
    private final String zzazx;
    private final AtomicInteger zzazy;
    private final ThreadFactory zzazz;

    public zzoa(String str) {
        this(str, 0);
    }

    public zzoa(String str, int i) {
        this.zzazy = new AtomicInteger();
        this.zzazz = Executors.defaultThreadFactory();
        this.zzazx = (String) zzx.zzb((Object) str, (Object) "Name must not be null");
        this.mPriority = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.zzazz.newThread(new zzob(runnable, this.mPriority));
        newThread.setName(this.zzazx + "[" + this.zzazy.getAndIncrement() + "]");
        return newThread;
    }
}

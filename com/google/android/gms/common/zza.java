package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class zza implements ServiceConnection {
    boolean zzapH = false;
    private final BlockingQueue<IBinder> zzapI = new LinkedBlockingQueue();

    public void onServiceConnected(ComponentName name, IBinder service) {
        this.zzapI.add(service);
    }

    public void onServiceDisconnected(ComponentName name) {
    }

    public IBinder zzoW() throws InterruptedException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        } else if (this.zzapH) {
            throw new IllegalStateException();
        } else {
            this.zzapH = true;
            return (IBinder) this.zzapI.take();
        }
    }
}

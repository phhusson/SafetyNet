package com.google.android.gms.playlog;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.playlog.PlayLogger.LoggerCallbacks;

@Deprecated
public class OneTimePlayLogger implements LoggerCallbacks {
    private final PlayLogger zzbLw;
    private boolean zzbLx;

    public OneTimePlayLogger(Context context, int logSource) {
        this(context, logSource, null);
    }

    public OneTimePlayLogger(Context context, int logSource, String accountName) {
        this(context, logSource, accountName, null, true);
    }

    public OneTimePlayLogger(Context context, int logSource, String accountName, String loggingId) {
        this(context, logSource, accountName, loggingId, true);
    }

    public OneTimePlayLogger(Context context, int logSource, String accountName, String loggingId, boolean logAndroidId) {
        this.zzbLw = new PlayLogger(context, logSource, accountName, loggingId, this, logAndroidId, context != context.getApplicationContext() ? context.getClass().getName() : "OneTimePlayLogger");
        this.zzbLx = true;
    }

    private void zzKa() {
        if (!this.zzbLx) {
            throw new IllegalStateException("Cannot reuse one-time logger after sending.");
        }
    }

    public void cacheLogEvent(long eventTime, String tag, byte[] sourceExtensionBytes, String... extras) {
        zzKa();
        this.zzbLw.logEvent(eventTime, tag, sourceExtensionBytes, extras);
    }

    public void cacheLogEvent(String tag, byte[] sourceExtensionBytes, String... extras) {
        zzKa();
        this.zzbLw.logEvent(tag, sourceExtensionBytes, extras);
    }

    public void onLoggerConnected() {
        this.zzbLw.stop();
    }

    public void onLoggerFailedConnection() {
        Log.w("OneTimePlayLogger", "logger connection failed");
    }

    public void onLoggerFailedConnectionWithResolution(PendingIntent resolutionIntent) {
        Log.w("OneTimePlayLogger", "logger connection failed: " + resolutionIntent);
    }

    public void send() {
        zzKa();
        this.zzbLw.start();
        this.zzbLx = false;
    }
}

package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzrj;
import java.util.concurrent.Callable;

public class zzb {
    private static SharedPreferences zzaTY = null;

    public static SharedPreferences zzx(final Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (zzaTY == null) {
                zzaTY = (SharedPreferences) zzrj.zzb(new Callable<SharedPreferences>() {
                    public /* synthetic */ Object call() throws Exception {
                        return zzxQ();
                    }

                    public SharedPreferences zzxQ() {
                        return context.getSharedPreferences("google_sdk_flags", 1);
                    }
                });
            }
            sharedPreferences = zzaTY;
        }
        return sharedPreferences;
    }
}

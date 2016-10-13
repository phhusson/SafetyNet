package com.google.android.gms.internal;

import android.content.Context;
import java.util.List;

public abstract class zztq {
    private static final Object zzbAO = new Object();
    private static zztq zzbAP;

    public static zztq zzaT(Context context) {
        synchronized (zzbAO) {
            if (zzbAP == null) {
                zzbAP = new zztr(context.getApplicationContext());
            }
        }
        return zzbAP;
    }

    public abstract List<zztp> zzGl();
}

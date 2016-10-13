package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.flags.impl.zza.zzb;
import com.google.android.gms.flags.impl.zza.zzc;
import com.google.android.gms.flags.impl.zza.zzd;
import com.google.android.gms.internal.zzri.zza;

public class FlagProviderImpl extends zza {
    private boolean zzre = false;
    private SharedPreferences zzwa;

    public boolean getBooleanFlagValue(String key, boolean defaultVal, int source) {
        return zza.zza.zza(this.zzwa, key, Boolean.valueOf(defaultVal)).booleanValue();
    }

    public int getIntFlagValue(String key, int defaultVal, int source) {
        return zzb.zza(this.zzwa, key, Integer.valueOf(defaultVal)).intValue();
    }

    public long getLongFlagValue(String key, long defaultVal, int source) {
        return zzc.zza(this.zzwa, key, Long.valueOf(defaultVal)).longValue();
    }

    public String getStringFlagValue(String key, String defaultVal, int source) {
        return zzd.zza(this.zzwa, key, defaultVal);
    }

    public void init(com.google.android.gms.dynamic.zzd wrappedContext) {
        Context context = (Context) zze.zzu(wrappedContext);
        if (!this.zzre) {
            try {
                this.zzwa = zzb.zzx(context.createPackageContext("com.google.android.gms", 0));
                this.zzre = true;
            } catch (NameNotFoundException e) {
            }
        }
    }
}

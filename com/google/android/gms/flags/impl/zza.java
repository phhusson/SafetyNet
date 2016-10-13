package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzrj;
import java.util.concurrent.Callable;

public abstract class zza<T> {

    public static class zza extends zza<Boolean> {
        public static Boolean zza(final SharedPreferences sharedPreferences, final String str, final Boolean bool) {
            return (Boolean) zzrj.zzb(new Callable<Boolean>() {
                public /* synthetic */ Object call() throws Exception {
                    return zznE();
                }

                public Boolean zznE() {
                    return Boolean.valueOf(sharedPreferences.getBoolean(str, bool.booleanValue()));
                }
            });
        }
    }

    public static class zzb extends zza<Integer> {
        public static Integer zza(final SharedPreferences sharedPreferences, final String str, final Integer num) {
            return (Integer) zzrj.zzb(new Callable<Integer>() {
                public /* synthetic */ Object call() throws Exception {
                    return zznF();
                }

                public Integer zznF() {
                    return Integer.valueOf(sharedPreferences.getInt(str, num.intValue()));
                }
            });
        }
    }

    public static class zzc extends zza<Long> {
        public static Long zza(final SharedPreferences sharedPreferences, final String str, final Long l) {
            return (Long) zzrj.zzb(new Callable<Long>() {
                public /* synthetic */ Object call() throws Exception {
                    return zziV();
                }

                public Long zziV() {
                    return Long.valueOf(sharedPreferences.getLong(str, l.longValue()));
                }
            });
        }
    }

    public static class zzd extends zza<String> {
        public static String zza(final SharedPreferences sharedPreferences, final String str, final String str2) {
            return (String) zzrj.zzb(new Callable<String>() {
                public /* synthetic */ Object call() throws Exception {
                    return zzjv();
                }

                public String zzjv() {
                    return sharedPreferences.getString(str, str2);
                }
            });
        }
    }
}

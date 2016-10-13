package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.util.Log;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

public abstract class zzni<T> {
    private static zza zzatx = null;
    private static int zzaty = 0;
    private static String zzatz = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private static final Object zzrc = new Object();
    private T zzRW = null;
    protected final String zzvV;
    protected final T zzvW;

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    private static class zzb implements zza {
        private static final Collection<zzni<?>> zzatA = new HashSet();

        private zzb() {
        }

        public Long getLong(String key, Long defaultValue) {
            return defaultValue;
        }

        public String getString(String key, String defaultValue) {
            return defaultValue;
        }

        public Boolean zza(String str, Boolean bool) {
            return bool;
        }

        public Float zzb(String str, Float f) {
            return f;
        }

        public Integer zzb(String str, Integer num) {
            return num;
        }
    }

    @Deprecated
    private static class zzc implements zza {
        private final Map<String, ?> values;

        private <T> T zzg(String str, T t) {
            return this.values.containsKey(str) ? this.values.get(str) : t;
        }

        public Long getLong(String key, Long defaultValue) {
            return (Long) zzg(key, defaultValue);
        }

        public String getString(String key, String defaultValue) {
            return (String) zzg(key, defaultValue);
        }

        public Boolean zza(String str, Boolean bool) {
            return (Boolean) zzg(str, bool);
        }

        public Float zzb(String str, Float f) {
            return (Float) zzg(str, f);
        }

        public Integer zzb(String str, Integer num) {
            return (Integer) zzg(str, num);
        }
    }

    private static class zzd implements zza {
        private final ContentResolver mContentResolver;

        public zzd(ContentResolver contentResolver) {
            this.mContentResolver = contentResolver;
        }

        public Long getLong(String key, Long defaultValue) {
            return Long.valueOf(zzahx.getLong(this.mContentResolver, key, defaultValue.longValue()));
        }

        public String getString(String key, String defaultValue) {
            return zzahx.zza(this.mContentResolver, key, defaultValue);
        }

        public Boolean zza(String str, Boolean bool) {
            return Boolean.valueOf(zzahx.zza(this.mContentResolver, str, bool.booleanValue()));
        }

        public Float zzb(String str, Float f) {
            String zza = zzahx.zza(this.mContentResolver, str, null);
            if (zza != null) {
                try {
                    f = Float.valueOf(Float.parseFloat(zza));
                } catch (NumberFormatException e) {
                }
            }
            return f;
        }

        public Integer zzb(String str, Integer num) {
            return Integer.valueOf(zzahx.getInt(this.mContentResolver, str, num.intValue()));
        }
    }

    protected zzni(String str, T t) {
        this.zzvV = str;
        this.zzvW = t;
    }

    public static void init(Context context) {
        synchronized (zzrc) {
            if (zzatx == null) {
                zzatx = new zzd(context.getContentResolver());
            }
            if (zzaty == 0) {
                try {
                    zzaty = context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).uid;
                } catch (NameNotFoundException e) {
                    Log.e("GservicesValue", e.toString());
                }
            }
        }
    }

    public static boolean isInitialized() {
        return zzatx != null;
    }

    public static zzni<String> zzD(String str, String str2) {
        return new zzni<String>(str, str2) {
            protected /* synthetic */ Object zzcs(String str) {
                return zzcx(str);
            }

            protected String zzcx(String str) {
                return zzni.zzatx.getString(this.zzvV, (String) this.zzvW);
            }
        };
    }

    public static zzni<Float> zza(String str, Float f) {
        return new zzni<Float>(str, f) {
            protected /* synthetic */ Object zzcs(String str) {
                return zzcw(str);
            }

            protected Float zzcw(String str) {
                return zzni.zzatx.zzb(this.zzvV, (Float) this.zzvW);
            }
        };
    }

    public static zzni<Integer> zza(String str, Integer num) {
        return new zzni<Integer>(str, num) {
            protected /* synthetic */ Object zzcs(String str) {
                return zzcv(str);
            }

            protected Integer zzcv(String str) {
                return zzni.zzatx.zzb(this.zzvV, (Integer) this.zzvW);
            }
        };
    }

    public static zzni<Long> zza(String str, Long l) {
        return new zzni<Long>(str, l) {
            protected /* synthetic */ Object zzcs(String str) {
                return zzcu(str);
            }

            protected Long zzcu(String str) {
                return zzni.zzatx.getLong(this.zzvV, (Long) this.zzvW);
            }
        };
    }

    public static zzni<Boolean> zzn(String str, boolean z) {
        return new zzni<Boolean>(str, Boolean.valueOf(z)) {
            protected /* synthetic */ Object zzcs(String str) {
                return zzct(str);
            }

            protected Boolean zzct(String str) {
                return zzni.zzatx.zza(this.zzvV, (Boolean) this.zzvW);
            }
        };
    }

    public static int zzqn() {
        return zzaty;
    }

    public static void zzqo() {
        synchronized (zzrc) {
            zzatx = new zzb();
        }
    }

    private static boolean zzqp() {
        boolean z;
        synchronized (zzrc) {
            z = (zzatx instanceof zzb) || (zzatx instanceof zzc);
        }
        return z;
    }

    public static void zzqq() {
        synchronized (zzrc) {
            if (zzqp()) {
                for (zzni resetOverride : zzb.zzatA) {
                    resetOverride.resetOverride();
                }
                zzb.zzatA.clear();
            }
        }
    }

    public final T get() {
        return this.zzRW != null ? this.zzRW : zzcs(this.zzvV);
    }

    public final T getBinderSafe() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            T t = get();
            return t;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public void override(T value) {
        if (!(zzatx instanceof zzb)) {
            Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        }
        this.zzRW = value;
        synchronized (zzrc) {
            if (zzqp()) {
                zzb.zzatA.add(this);
            }
        }
    }

    public void resetOverride() {
        this.zzRW = null;
    }

    protected abstract T zzcs(String str);
}

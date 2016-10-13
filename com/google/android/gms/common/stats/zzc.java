package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzni;

public final class zzc {
    public static zzni<Integer> zzayD = zzni.zza("gms:common:stats:max_num_of_events", Integer.valueOf(100));
    public static zzni<Integer> zzayE = zzni.zza("gms:common:stats:max_chunk_size", Integer.valueOf(100));

    public static final class zza {
        public static zzni<Integer> zzayF = zzni.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
        public static zzni<String> zzayG = zzni.zzD("gms:common:stats:connections:ignored_calling_processes", "");
        public static zzni<String> zzayH = zzni.zzD("gms:common:stats:connections:ignored_calling_services", "");
        public static zzni<String> zzayI = zzni.zzD("gms:common:stats:connections:ignored_target_processes", "");
        public static zzni<String> zzayJ = zzni.zzD("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static zzni<Long> zzayK = zzni.zza("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
    }

    public static final class zzb {
        public static zzni<Integer> zzayF = zzni.zza("gms:common:stats:wakeLocks:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
        public static zzni<Long> zzayK = zzni.zza("gms:common:stats:wakelocks:time_out_duration", Long.valueOf(600000));
    }
}

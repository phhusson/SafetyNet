package com.google.android.gms.clearcut;

import com.google.android.gms.clearcut.ClearcutLogger.LogEventBuilder;
import com.google.android.gms.clearcut.ClearcutLogger.MessageProducer;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.zzg;
import com.google.android.gms.internal.zzain;
import com.google.android.snet.Csv;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Counters {
    public static final Alias IDENTITY = new BucketAlias(1);
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final ResultCallback<Status> zzapa = new C01891();
    private static final Comparator zzapb = new C01902();
    GoogleApiClient mApiClient;
    private final String zzaoC;
    private final int zzaoR;
    private boolean zzaoS;
    private long zzaoT;
    private final ClearcutLogger zzaoU;
    private final ReentrantReadWriteLock zzaoV;
    private Map<String, zza> zzaoW;
    private byte[] zzaoX;
    private Integer zzaoY;
    TreeMap<byte[], Integer> zzaoZ;
    private final Clock zzrA;

    static class C01891 implements ResultCallback<Status> {
        C01891() {
        }

        public /* synthetic */ void onResult(Result result) {
            zzx((Status) result);
        }

        public void zzx(Status status) {
        }
    }

    static class C01902 implements Comparator<byte[]> {
        C01902() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((byte[]) obj, (byte[]) obj2);
        }

        public boolean equals(Object rhs) {
            throw new UnsupportedOperationException("what are you doing?");
        }

        public int zza(byte[] bArr, byte[] bArr2) {
            int i = 0;
            if (bArr == null && bArr2 == null) {
                return 0;
            }
            if (bArr == null) {
                return -1;
            }
            if (bArr2 == null) {
                return 1;
            }
            int min = Math.min(bArr.length, bArr2.length);
            while (i < min) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
                i++;
            }
            return bArr.length - bArr2.length;
        }
    }

    public interface Alias {
        long alias(long j);
    }

    private abstract class zza {
        private final String mName;
        private int zzapc;
        private int zzapd;
        Map<Integer, Map<Long, long[]>> zzape;
        final /* synthetic */ Counters zzapf;
        private Object zzqz;

        protected zza(Counters counters, zza com_google_android_gms_clearcut_Counters_zza, boolean z) {
            this(counters, com_google_android_gms_clearcut_Counters_zza.mName);
            synchronized (com_google_android_gms_clearcut_Counters_zza.zzqz) {
                this.zzapc = com_google_android_gms_clearcut_Counters_zza.zzapc;
                if (z) {
                    Map map = this.zzape;
                    this.zzape = com_google_android_gms_clearcut_Counters_zza.zzape;
                    com_google_android_gms_clearcut_Counters_zza.zzape = map;
                    com_google_android_gms_clearcut_Counters_zza.zzapc = 0;
                    return;
                }
                this.zzape = new HashMap(com_google_android_gms_clearcut_Counters_zza.zzape.size());
                for (Entry entry : com_google_android_gms_clearcut_Counters_zza.zzape.entrySet()) {
                    Map hashMap = new HashMap(((Map) entry.getValue()).size());
                    for (Entry key : ((Map) entry.getValue()).entrySet()) {
                        hashMap.put(key.getKey(), new long[]{((long[]) key.getValue())[0]});
                    }
                    this.zzape.put(entry.getKey(), hashMap);
                }
            }
        }

        protected zza(Counters counters, String str) {
            this.zzapf = counters;
            this.zzapd = this.zzapf.zzaoR;
            this.zzape = new HashMap();
            this.zzqz = new Object();
            if (counters.zzaoW.containsKey(str)) {
                throw new IllegalStateException("counter/histogram already exists: " + str);
            }
            counters.zzaoW.put(str, this);
            this.mName = str;
        }

        private boolean zzc(long j, long j2) {
            Lock writeLock = this.zzapf.zzaoV.writeLock();
            writeLock.lock();
            try {
                this.zzapf.zzaoY = this.zzapf.zzi(this.zzapf.zzaoX);
                this.zzapf.zzaoV.readLock().lock();
                writeLock.unlock();
                writeLock = this.zzapf.zzaoV.readLock();
                boolean zzd = zzd(j, j2);
                return zzd;
            } finally {
                writeLock.unlock();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean zzd(long r10, long r12) {
            /*
            r9 = this;
            r2 = 1;
            r1 = 0;
            r4 = r9.zzqz;
            monitor-enter(r4);
            r0 = r9.zzape;	 Catch:{ all -> 0x0097 }
            r3 = r9.zzapf;	 Catch:{ all -> 0x0097 }
            r3 = r3.zzaoY;	 Catch:{ all -> 0x0097 }
            r0 = r0.get(r3);	 Catch:{ all -> 0x0097 }
            r0 = (java.util.Map) r0;	 Catch:{ all -> 0x0097 }
            if (r0 != 0) goto L_0x009c;
        L_0x0015:
            r0 = new java.util.HashMap;	 Catch:{ all -> 0x0097 }
            r0.<init>();	 Catch:{ all -> 0x0097 }
            r3 = r9.zzape;	 Catch:{ all -> 0x0097 }
            r5 = r9.zzapf;	 Catch:{ all -> 0x0097 }
            r5 = r5.zzaoY;	 Catch:{ all -> 0x0097 }
            r3.put(r5, r0);	 Catch:{ all -> 0x0097 }
            r3 = r0;
        L_0x0026:
            r0 = r9.zzapc;	 Catch:{ all -> 0x0097 }
            r5 = r9.zzapf;	 Catch:{ all -> 0x0097 }
            r5 = r5.zzaoR;	 Catch:{ all -> 0x0097 }
            if (r0 < r5) goto L_0x005f;
        L_0x0030:
            r0 = r9.zzapf;	 Catch:{ all -> 0x0097 }
            r0 = r0.zzaoS;	 Catch:{ all -> 0x0097 }
            if (r0 != 0) goto L_0x005f;
        L_0x0038:
            r0 = r9.zzapc;	 Catch:{ all -> 0x0097 }
            r2 = r9.zzapf;	 Catch:{ all -> 0x0097 }
            r2 = r2.zzaoR;	 Catch:{ all -> 0x0097 }
            if (r0 != r2) goto L_0x005c;
        L_0x0042:
            r0 = "Counters";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0097 }
            r2.<init>();	 Catch:{ all -> 0x0097 }
            r3 = "exceeded sample count in ";
            r2 = r2.append(r3);	 Catch:{ all -> 0x0097 }
            r3 = r9.mName;	 Catch:{ all -> 0x0097 }
            r2 = r2.append(r3);	 Catch:{ all -> 0x0097 }
            r2 = r2.toString();	 Catch:{ all -> 0x0097 }
            android.util.Log.i(r0, r2);	 Catch:{ all -> 0x0097 }
        L_0x005c:
            monitor-exit(r4);	 Catch:{ all -> 0x0097 }
            r0 = r1;
        L_0x005e:
            return r0;
        L_0x005f:
            r0 = r9.zzapc;	 Catch:{ all -> 0x0097 }
            r0 = r0 + 1;
            r9.zzapc = r0;	 Catch:{ all -> 0x0097 }
            r0 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x0097 }
            r0 = r3.get(r0);	 Catch:{ all -> 0x0097 }
            r0 = (long[]) r0;	 Catch:{ all -> 0x0097 }
            if (r0 != 0) goto L_0x0080;
        L_0x0071:
            r0 = 1;
            r0 = new long[r0];	 Catch:{ all -> 0x0097 }
            r5 = 0;
            r6 = 0;
            r0[r5] = r6;	 Catch:{ all -> 0x0097 }
            r5 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x0097 }
            r3.put(r5, r0);	 Catch:{ all -> 0x0097 }
        L_0x0080:
            r3 = 0;
            r6 = r0[r3];	 Catch:{ all -> 0x0097 }
            r6 = r6 + r12;
            r0[r3] = r6;	 Catch:{ all -> 0x0097 }
            r0 = r9.zzapf;	 Catch:{ all -> 0x0097 }
            r0 = r0.zzaoS;	 Catch:{ all -> 0x0097 }
            if (r0 == 0) goto L_0x009a;
        L_0x008e:
            r0 = r9.zzapc;	 Catch:{ all -> 0x0097 }
            r3 = r9.zzapd;	 Catch:{ all -> 0x0097 }
            if (r0 < r3) goto L_0x009a;
        L_0x0094:
            r0 = r2;
        L_0x0095:
            monitor-exit(r4);	 Catch:{ all -> 0x0097 }
            goto L_0x005e;
        L_0x0097:
            r0 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x0097 }
            throw r0;
        L_0x009a:
            r0 = r1;
            goto L_0x0095;
        L_0x009c:
            r3 = r0;
            goto L_0x0026;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.clearcut.Counters.zza.zzd(long, long):boolean");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AbstractCounter");
            stringBuilder.append("(");
            stringBuilder.append(this.mName);
            stringBuilder.append(")[");
            synchronized (this.zzqz) {
                for (Entry entry : this.zzape.entrySet()) {
                    stringBuilder.append(entry.getKey());
                    stringBuilder.append(" -> [");
                    for (Entry entry2 : ((Map) entry2.getValue()).entrySet()) {
                        stringBuilder.append(entry2.getKey());
                        stringBuilder.append(" = ");
                        stringBuilder.append(((long[]) entry2.getValue())[0]);
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append("], ");
                }
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected long zzA(long r6) {
            /*
            r5 = this;
            r2 = 0;
            r0 = r5.zzapf;
            r0 = r0.zzaoV;
            r0 = r0.readLock();
            r0.lock();
            r4 = r5.zzqz;	 Catch:{ all -> 0x007b }
            monitor-enter(r4);	 Catch:{ all -> 0x007b }
            r0 = r5.zzapf;	 Catch:{ all -> 0x0078 }
            r0 = r0.zzaoY;	 Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x002a;
        L_0x001a:
            monitor-exit(r4);	 Catch:{ all -> 0x0078 }
            r0 = r5.zzapf;
            r0 = r0.zzaoV;
            r0 = r0.readLock();
            r0.unlock();
            r0 = r2;
        L_0x0029:
            return r0;
        L_0x002a:
            r0 = r5.zzape;	 Catch:{ all -> 0x0078 }
            r1 = r5.zzapf;	 Catch:{ all -> 0x0078 }
            r1 = r1.zzaoY;	 Catch:{ all -> 0x0078 }
            r0 = r0.get(r1);	 Catch:{ all -> 0x0078 }
            r0 = (java.util.Map) r0;	 Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x004a;
        L_0x003a:
            monitor-exit(r4);	 Catch:{ all -> 0x0078 }
            r0 = r5.zzapf;
            r0 = r0.zzaoV;
            r0 = r0.readLock();
            r0.unlock();
            r0 = r2;
            goto L_0x0029;
        L_0x004a:
            r1 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0078 }
            r0 = r0.get(r1);	 Catch:{ all -> 0x0078 }
            r0 = (long[]) r0;	 Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0066;
        L_0x0056:
            monitor-exit(r4);	 Catch:{ all -> 0x0078 }
            r0 = r5.zzapf;
            r0 = r0.zzaoV;
            r0 = r0.readLock();
            r0.unlock();
            r0 = r2;
            goto L_0x0029;
        L_0x0066:
            r1 = 0;
            r0 = r0[r1];	 Catch:{ all -> 0x0078 }
            monitor-exit(r4);	 Catch:{ all -> 0x0078 }
            r2 = r5.zzapf;
            r2 = r2.zzaoV;
            r2 = r2.readLock();
            r2.unlock();
            goto L_0x0029;
        L_0x0078:
            r0 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x0078 }
            throw r0;	 Catch:{ all -> 0x007b }
        L_0x007b:
            r0 = move-exception;
            r1 = r5.zzapf;
            r1 = r1.zzaoV;
            r1 = r1.readLock();
            r1.unlock();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.clearcut.Counters.zza.zzA(long):long");
        }

        protected final void zzb(long j, long j2) {
            boolean z = false;
            this.zzapf.zzaoV.readLock().lock();
            try {
                boolean z2;
                if (this.zzapf.zzaoY == null) {
                    z2 = true;
                } else {
                    z2 = false;
                    z = zzd(j, j2);
                }
                this.zzapf.zzaoV.readLock().unlock();
                if (z2) {
                    z = zzc(j, j2);
                }
                if (z) {
                    PendingResult logAllAsync = this.zzapf.logAllAsync(this.zzapf.mApiClient);
                    if (logAllAsync != null) {
                        logAllAsync.setResultCallback(Counters.zzapa);
                    }
                }
            } catch (Throwable th) {
                this.zzapf.zzaoV.readLock().unlock();
            }
        }

        protected void zzz(long j) {
            zzb(j, 1);
        }
    }

    public class BooleanHistogram extends zza {
        final /* synthetic */ Counters zzapf;

        private BooleanHistogram(Counters counters, BooleanHistogram histogram, boolean swap) {
            this.zzapf = counters;
            super(counters, histogram, swap);
        }

        private BooleanHistogram(Counters counters, String name) {
            this.zzapf = counters;
            super(counters, name);
        }

        public long getCount(boolean key) {
            return zzA(key ? 1 : 0);
        }

        public void increment(boolean key) {
            zzz(key ? 1 : 0);
        }

        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public static class BucketAlias implements Alias {
        protected final int mAlias;

        public BucketAlias(int alias) {
            if (alias < 1) {
                throw new IllegalArgumentException("bad alias: " + alias);
            }
            this.mAlias = alias;
        }

        public long alias(long rawKey) {
            return ((long) this.mAlias) * (rawKey / ((long) this.mAlias));
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BucketAlias)) {
                return false;
            }
            return this.mAlias == ((BucketAlias) other).mAlias;
        }
    }

    public static class ClippedBucketAlias extends BucketAlias {
        private final long zzaph;
        private final long zzapi;

        public ClippedBucketAlias(int alias, int min, int max) {
            super(alias);
            this.zzaph = (long) min;
            this.zzapi = (long) max;
        }

        public long alias(long rawKey) {
            return super.alias(Math.max(Math.min(rawKey, this.zzapi), this.zzaph));
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClippedBucketAlias)) {
                return false;
            }
            return this.mAlias == ((ClippedBucketAlias) other).mAlias;
        }
    }

    public class Counter extends zza {
        final /* synthetic */ Counters zzapf;

        private Counter(Counters counters, Counter counter, boolean swap) {
            this.zzapf = counters;
            super(counters, counter, swap);
        }

        private Counter(Counters counters, String name) {
            this.zzapf = counters;
            super(counters, name);
        }

        public long getCount() {
            return zzA(0);
        }

        public void increment() {
            incrementBy(1);
        }

        public void incrementBy(long increment) {
            zzb(0, increment);
        }

        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public class IntegerHistogram extends zza {
        final /* synthetic */ Counters zzapf;

        private IntegerHistogram(Counters counters, IntegerHistogram histogram, boolean swap) {
            this.zzapf = counters;
            super(counters, histogram, swap);
        }

        private IntegerHistogram(Counters counters, String name) {
            this.zzapf = counters;
            super(counters, name);
        }

        public long getCount(int key) {
            return zzA((long) key);
        }

        public void increment(int key) {
            zzz((long) key);
        }

        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    protected class zzb extends zza {
        final /* synthetic */ Counters zzapf;
        final Alias zzapg;

        protected zzb(Counters counters, zzb com_google_android_gms_clearcut_Counters_zzb, boolean z) {
            this.zzapf = counters;
            super(counters, com_google_android_gms_clearcut_Counters_zzb, z);
            this.zzapg = com_google_android_gms_clearcut_Counters_zzb.zzapg;
        }

        protected zzb(Counters counters, String str, Alias alias) {
            this.zzapf = counters;
            super(counters, str);
            this.zzapg = alias;
        }

        private final long alias(long rawKey) {
            return this.zzapg.alias(rawKey);
        }

        protected long getCount(long key) {
            return zzA(alias(key));
        }

        protected void increment(long key) {
            zzb(alias(key), 1);
        }

        protected void incrementBy(long key, long increment) {
            zzb(alias(key), increment);
        }
    }

    public class LongHistogram extends zzb {
        final /* synthetic */ Counters zzapf;

        private LongHistogram(Counters counters, LongHistogram histogram, boolean swap) {
            this.zzapf = counters;
            super(counters, (zzb) histogram, swap);
        }

        private LongHistogram(Counters counters, String name, Alias alias) {
            this.zzapf = counters;
            super(counters, name, alias);
        }

        public long getCount(long key) {
            return super.getCount(key);
        }

        public void increment(long key) {
            super.increment(key);
        }

        public void incrementBy(long key, long increment) {
            super.incrementBy(key, increment);
        }

        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public final class Timer {
        private long zzRO = this.zzapf.zzrA.elapsedRealtime();
        final /* synthetic */ Counters zzapf;

        public Timer(Counters counters) {
            this.zzapf = counters;
        }

        public long getMilliseconds() {
            return this.zzapf.zzrA.elapsedRealtime() - this.zzRO;
        }

        public void incrementTo(TimerHistogram timerHistogram) {
            timerHistogram.increment(getMilliseconds());
        }

        public long reset() {
            long j = this.zzRO;
            this.zzRO = this.zzapf.zzrA.elapsedRealtime();
            return j;
        }
    }

    public class TimerHistogram extends zzb {
        final /* synthetic */ Counters zzapf;

        public class BoundTimer {
            private long zzRO;
            private final TimerHistogram zzapl;
            final /* synthetic */ TimerHistogram zzapm;

            private BoundTimer(TimerHistogram timerHistogram, TimerHistogram timerHistogram2) {
                this.zzapm = timerHistogram;
                this.zzapl = timerHistogram2;
                reset();
            }

            public long getMilliseconds() {
                return this.zzapm.zzapf.zzrA.elapsedRealtime() - this.zzRO;
            }

            public void incrementTo() {
                this.zzapl.increment(getMilliseconds());
            }

            public void reset() {
                this.zzRO = this.zzapm.zzapf.zzrA.elapsedRealtime();
            }
        }

        private TimerHistogram(Counters counters, TimerHistogram histogram, boolean swap) {
            this.zzapf = counters;
            super(counters, (zzb) histogram, swap);
        }

        private TimerHistogram(Counters counters, String name, Alias alias) {
            this.zzapf = counters;
            super(counters, name, alias);
        }

        public long getCount(long key) {
            return super.getCount(key);
        }

        public BoundTimer newTimer() {
            return new BoundTimer(this);
        }

        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    class zzc implements MessageProducer {
        private final byte[] zzaoX;
        final /* synthetic */ Counters zzapf;
        private final Integer zzapj;
        private final ArrayList<zza> zzapk = zza(this.zzapj);

        zzc(Counters counters, byte[] bArr) {
            this.zzapf = counters;
            this.zzaoX = bArr;
            this.zzapj = (Integer) counters.zzaoZ.get(this.zzaoX);
        }

        private ArrayList<zza> zza(Integer num) {
            ArrayList<zza> arrayList = new ArrayList(this.zzapf.zzaoW.size());
            for (zza com_google_android_gms_clearcut_Counters_zza : this.zzapf.zzaoW.values()) {
                if (com_google_android_gms_clearcut_Counters_zza.zzape.containsKey(num)) {
                    arrayList.add(com_google_android_gms_clearcut_Counters_zza);
                }
            }
            return arrayList;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof zzc)) {
                return false;
            }
            return zzoS().equals(((zzc) other).zzoS());
        }

        public int hashCode() {
            return 1;
        }

        public byte[] toProtoBytes() {
            return zzain.toByteArray(zzoS());
        }

        public String toString() {
            return zzoS().toString();
        }

        public com.google.android.gms.internal.zzaiv.zzb zzb(zza com_google_android_gms_clearcut_Counters_zza) {
            Map map = (Map) com_google_android_gms_clearcut_Counters_zza.zzape.get(this.zzapj);
            com.google.android.gms.internal.zzaiv.zzb com_google_android_gms_internal_zzaiv_zzb = new com.google.android.gms.internal.zzaiv.zzb();
            com_google_android_gms_internal_zzaiv_zzb.zzcrY = zzcq(com_google_android_gms_clearcut_Counters_zza.mName);
            com_google_android_gms_internal_zzaiv_zzb.zzcrZ = new com.google.android.gms.internal.zzaiv.zza[map.size()];
            int i = 0;
            for (Entry entry : map.entrySet()) {
                com.google.android.gms.internal.zzaiv.zza com_google_android_gms_internal_zzaiv_zza = new com.google.android.gms.internal.zzaiv.zza();
                com_google_android_gms_internal_zzaiv_zza.zzcrV = ((Long) entry.getKey()).longValue();
                com_google_android_gms_internal_zzaiv_zza.zzcrW = ((long[]) entry.getValue())[0];
                int i2 = i + 1;
                com_google_android_gms_internal_zzaiv_zzb.zzcrZ[i] = com_google_android_gms_internal_zzaiv_zza;
                i = i2;
            }
            return com_google_android_gms_internal_zzaiv_zzb;
        }

        public long zzcq(String str) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str.getBytes(Counters.UTF_8));
                return ByteBuffer.wrap(instance.digest()).getLong();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public com.google.android.gms.internal.zzaiv.zzc zzoS() {
            com.google.android.gms.internal.zzaiv.zzc com_google_android_gms_internal_zzaiv_zzc = new com.google.android.gms.internal.zzaiv.zzc();
            com_google_android_gms_internal_zzaiv_zzc.zzcsa = this.zzapf.zzaoT;
            if (this.zzaoX != null) {
                com_google_android_gms_internal_zzaiv_zzc.zzcsc = this.zzaoX;
            }
            com_google_android_gms_internal_zzaiv_zzc.zzcsb = new com.google.android.gms.internal.zzaiv.zzb[this.zzapk.size()];
            Iterator it = this.zzapk.iterator();
            int i = 0;
            while (it.hasNext()) {
                com_google_android_gms_internal_zzaiv_zzc.zzcsb[i] = zzb((zza) it.next());
                i++;
            }
            return com_google_android_gms_internal_zzaiv_zzc;
        }
    }

    public Counters(ClearcutLogger logger, String logSourceName, int maxSamplesPerCounter) {
        this(logger, logSourceName, maxSamplesPerCounter, zzg.zzsh());
    }

    public Counters(ClearcutLogger logger, String logSourceName, int maxSamplesPerCounter, Clock clock) {
        boolean z = true;
        this.zzaoS = false;
        this.mApiClient = null;
        this.zzaoV = new ReentrantReadWriteLock();
        this.zzaoW = new TreeMap();
        this.zzaoX = null;
        this.zzaoY = null;
        this.zzaoZ = new TreeMap(zzapb);
        zzx.zzD(logger);
        zzx.zzD(logSourceName);
        if (maxSamplesPerCounter <= 1) {
            z = false;
        }
        zzx.zzae(z);
        zzx.zzD(clock);
        this.zzaoU = logger;
        this.zzaoC = logSourceName;
        this.zzaoR = maxSamplesPerCounter;
        this.zzrA = clock;
        this.zzaoT = this.zzrA.elapsedRealtime();
    }

    private Counters(Counters from, boolean swap) {
        this(from.zzaoU, from.zzaoC, from.zzaoR, from.zzrA);
        Lock writeLock = swap ? from.zzaoV.writeLock() : from.zzaoV.readLock();
        writeLock.lock();
        try {
            this.zzaoX = from.zzaoX;
            this.zzaoY = from.zzaoY;
            this.zzaoT = from.zzaoT;
            this.zzaoW = new TreeMap();
            if (swap) {
                for (Entry entry : from.zzaoW.entrySet()) {
                    this.zzaoW.put(entry.getKey(), zza((zza) entry.getValue(), swap));
                }
                TreeMap treeMap = this.zzaoZ;
                this.zzaoZ = from.zzaoZ;
                from.zzaoZ = treeMap;
                from.zzaoY = null;
                from.zzaoT = this.zzrA.elapsedRealtime();
            } else {
                for (Entry entry2 : from.zzaoW.entrySet()) {
                    this.zzaoW.put(entry2.getKey(), zza((zza) entry2.getValue(), swap));
                }
                this.zzaoZ.putAll(from.zzaoZ);
            }
            writeLock.unlock();
        } catch (Throwable th) {
            writeLock.unlock();
        }
    }

    private PendingResult<Status> zzh(GoogleApiClient googleApiClient) {
        PendingResult<Status> pendingResult = null;
        for (byte[] makeProducer : this.zzaoZ.keySet()) {
            MessageProducer makeProducer2 = makeProducer(makeProducer);
            if (pendingResult != null) {
                pendingResult.setResultCallback(zzapa);
            }
            pendingResult = this.zzaoU.newEvent(makeProducer2.toProtoBytes()).setLogSourceName(this.zzaoC).log(googleApiClient);
        }
        return pendingResult;
    }

    private PendingResult<Status> zzi(GoogleApiClient googleApiClient) {
        PendingResult<Status> pendingResult = null;
        for (byte[] makeProducer : this.zzaoZ.keySet()) {
            LogEventBuilder logSourceName = this.zzaoU.newEvent(makeProducer(makeProducer)).setLogSourceName(this.zzaoC);
            if (pendingResult != null) {
                pendingResult.setResultCallback(zzapa);
            }
            pendingResult = googleApiClient != null ? logSourceName.logAsync(googleApiClient) : logSourceName.logAsync();
        }
        return pendingResult;
    }

    public BooleanHistogram getBooleanHistogram(String name) {
        this.zzaoV.writeLock().lock();
        try {
            BooleanHistogram newBooleanHistogram;
            zza com_google_android_gms_clearcut_Counters_zza = (zza) this.zzaoW.get(name);
            if (com_google_android_gms_clearcut_Counters_zza == null) {
                newBooleanHistogram = newBooleanHistogram(name);
                this.zzaoV.writeLock().unlock();
            } else {
                newBooleanHistogram = (BooleanHistogram) com_google_android_gms_clearcut_Counters_zza;
                this.zzaoV.writeLock().unlock();
            }
            return newBooleanHistogram;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("another type of counter exists with name: " + name);
        } catch (Throwable th) {
            this.zzaoV.writeLock().unlock();
        }
    }

    public Counter getCounter(String name) {
        this.zzaoV.writeLock().lock();
        try {
            Counter newCounter;
            zza com_google_android_gms_clearcut_Counters_zza = (zza) this.zzaoW.get(name);
            if (com_google_android_gms_clearcut_Counters_zza == null) {
                newCounter = newCounter(name);
                this.zzaoV.writeLock().unlock();
            } else {
                newCounter = (Counter) com_google_android_gms_clearcut_Counters_zza;
                this.zzaoV.writeLock().unlock();
            }
            return newCounter;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("another type of counter exists with name: " + name);
        } catch (Throwable th) {
            this.zzaoV.writeLock().unlock();
        }
    }

    public Collection<byte[]> getDimensionsInstances() {
        this.zzaoV.readLock().lock();
        try {
            Collection<byte[]> arrayList = new ArrayList(this.zzaoZ.keySet());
            return arrayList;
        } finally {
            this.zzaoV.readLock().unlock();
        }
    }

    public IntegerHistogram getIntegerHistogram(String name) {
        this.zzaoV.writeLock().lock();
        try {
            IntegerHistogram newIntegerHistogram;
            zza com_google_android_gms_clearcut_Counters_zza = (zza) this.zzaoW.get(name);
            if (com_google_android_gms_clearcut_Counters_zza == null) {
                newIntegerHistogram = newIntegerHistogram(name);
                this.zzaoV.writeLock().unlock();
            } else {
                newIntegerHistogram = (IntegerHistogram) com_google_android_gms_clearcut_Counters_zza;
                this.zzaoV.writeLock().unlock();
            }
            return newIntegerHistogram;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("another type of counter exists with name: " + name);
        } catch (Throwable th) {
            this.zzaoV.writeLock().unlock();
        }
    }

    public LongHistogram getLongHistogram(String name) {
        return getLongHistogram(name, IDENTITY);
    }

    public LongHistogram getLongHistogram(String name, Alias alias) {
        this.zzaoV.writeLock().lock();
        try {
            LongHistogram newLongHistogram;
            zza com_google_android_gms_clearcut_Counters_zza = (zza) this.zzaoW.get(name);
            if (com_google_android_gms_clearcut_Counters_zza == null) {
                newLongHistogram = newLongHistogram(name, alias);
                this.zzaoV.writeLock().unlock();
            } else {
                newLongHistogram = (LongHistogram) com_google_android_gms_clearcut_Counters_zza;
                if (alias.equals(newLongHistogram.zzapg)) {
                    this.zzaoV.writeLock().unlock();
                } else {
                    throw new IllegalArgumentException("alias mismatch: " + name);
                }
            }
            return newLongHistogram;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("another type of counter exists with name: " + name);
        } catch (Throwable th) {
            this.zzaoV.writeLock().unlock();
        }
    }

    public TimerHistogram getTimerHistogram(String name) {
        return getTimerHistogram(name, IDENTITY);
    }

    public TimerHistogram getTimerHistogram(String name, Alias alias) {
        this.zzaoV.writeLock().lock();
        try {
            TimerHistogram newTimerHistogram;
            zza com_google_android_gms_clearcut_Counters_zza = (zza) this.zzaoW.get(name);
            if (com_google_android_gms_clearcut_Counters_zza == null) {
                newTimerHistogram = newTimerHistogram(name, alias);
                this.zzaoV.writeLock().unlock();
            } else {
                newTimerHistogram = (TimerHistogram) com_google_android_gms_clearcut_Counters_zza;
                if (alias.equals(newTimerHistogram.zzapg)) {
                    this.zzaoV.writeLock().unlock();
                } else {
                    throw new IllegalArgumentException("alias mismatch: " + name);
                }
            }
            return newTimerHistogram;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("another type of counter exists with name: " + name);
        } catch (Throwable th) {
            this.zzaoV.writeLock().unlock();
        }
    }

    public PendingResult<Status> logAll(GoogleApiClient apiClient) {
        return snapshotAndReset().zzh(apiClient);
    }

    public PendingResult<Status> logAllAsync() {
        return snapshotAndReset().zzi(null);
    }

    public PendingResult<Status> logAllAsync(GoogleApiClient apiClient) {
        return snapshotAndReset().zzi(apiClient);
    }

    public MessageProducer makeProducer(byte[] dimensionInstance) {
        return zzj(dimensionInstance);
    }

    public BooleanHistogram newBooleanHistogram(String name) {
        this.zzaoV.writeLock().lock();
        try {
            BooleanHistogram booleanHistogram = new BooleanHistogram(name);
            return booleanHistogram;
        } finally {
            this.zzaoV.writeLock().unlock();
        }
    }

    public Counter newCounter(String name) {
        this.zzaoV.writeLock().lock();
        try {
            Counter counter = new Counter(name);
            return counter;
        } finally {
            this.zzaoV.writeLock().unlock();
        }
    }

    public IntegerHistogram newIntegerHistogram(String name) {
        this.zzaoV.writeLock().lock();
        try {
            IntegerHistogram integerHistogram = new IntegerHistogram(name);
            return integerHistogram;
        } finally {
            this.zzaoV.writeLock().unlock();
        }
    }

    public LongHistogram newLongHistogram(String name) {
        return newLongHistogram(name, IDENTITY);
    }

    public LongHistogram newLongHistogram(String name, Alias alias) {
        this.zzaoV.writeLock().lock();
        try {
            LongHistogram longHistogram = new LongHistogram(name, alias);
            return longHistogram;
        } finally {
            this.zzaoV.writeLock().unlock();
        }
    }

    public Timer newTimer() {
        return new Timer(this);
    }

    public TimerHistogram newTimerHistogram(String name) {
        return new TimerHistogram(name, IDENTITY);
    }

    public TimerHistogram newTimerHistogram(String name, Alias alias) {
        this.zzaoV.writeLock().lock();
        try {
            TimerHistogram timerHistogram = new TimerHistogram(name, alias);
            return timerHistogram;
        } finally {
            this.zzaoV.writeLock().unlock();
        }
    }

    public void setAutoLogAsync(GoogleApiClient apiClient) {
        this.zzaoV.writeLock().lock();
        if (apiClient == null) {
            try {
                this.zzaoS = false;
            } catch (Throwable th) {
                this.zzaoV.writeLock().unlock();
            }
        } else {
            this.zzaoS = true;
        }
        this.mApiClient = apiClient;
        this.zzaoV.writeLock().unlock();
    }

    public void setDimensionsInstance(byte[] serializedDimensionsProto) {
        this.zzaoV.writeLock().lock();
        try {
            this.zzaoX = serializedDimensionsProto;
            this.zzaoY = (Integer) this.zzaoZ.get(this.zzaoX);
        } finally {
            this.zzaoV.writeLock().unlock();
        }
    }

    public Counters snapshot() {
        return new Counters(this, false);
    }

    public Counters snapshotAndReset() {
        return new Counters(this, true);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.zzaoV.readLock().lock();
        try {
            stringBuilder.append("{");
            for (Entry entry : this.zzaoZ.entrySet()) {
                stringBuilder.append(entry.getKey() == null ? "null" : new String((byte[]) entry.getKey()));
                stringBuilder.append(", ");
            }
            stringBuilder.append("}\n");
            for (zza com_google_android_gms_clearcut_Counters_zza : this.zzaoW.values()) {
                stringBuilder.append(com_google_android_gms_clearcut_Counters_zza.toString());
                stringBuilder.append(Csv.NEWLINE);
            }
            return stringBuilder.toString();
        } finally {
            this.zzaoV.readLock().unlock();
        }
    }

    zza zza(zza com_google_android_gms_clearcut_Counters_zza, boolean z) {
        if (com_google_android_gms_clearcut_Counters_zza instanceof Counter) {
            return new Counter((Counter) com_google_android_gms_clearcut_Counters_zza, z);
        }
        if (com_google_android_gms_clearcut_Counters_zza instanceof TimerHistogram) {
            return new TimerHistogram((TimerHistogram) com_google_android_gms_clearcut_Counters_zza, z);
        }
        if (com_google_android_gms_clearcut_Counters_zza instanceof IntegerHistogram) {
            return new IntegerHistogram((IntegerHistogram) com_google_android_gms_clearcut_Counters_zza, z);
        }
        if (com_google_android_gms_clearcut_Counters_zza instanceof LongHistogram) {
            return new LongHistogram((LongHistogram) com_google_android_gms_clearcut_Counters_zza, z);
        }
        if (com_google_android_gms_clearcut_Counters_zza instanceof BooleanHistogram) {
            return new BooleanHistogram((BooleanHistogram) com_google_android_gms_clearcut_Counters_zza, z);
        }
        throw new IllegalArgumentException("Unkown counter type: " + com_google_android_gms_clearcut_Counters_zza);
    }

    Integer zzi(byte[] bArr) {
        Integer num = (Integer) this.zzaoZ.get(bArr);
        if (num != null) {
            return num;
        }
        num = Integer.valueOf(this.zzaoZ.size());
        this.zzaoZ.put(bArr, num);
        return num;
    }

    zzc zzj(byte[] bArr) {
        return new zzc(this, bArr);
    }
}

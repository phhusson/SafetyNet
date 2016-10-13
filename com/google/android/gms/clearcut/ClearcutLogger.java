package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.zzg;
import com.google.android.gms.internal.zzaiu.zzd;
import com.google.android.gms.internal.zznc;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public final class ClearcutLogger {
    public static final Api<NoOptions> API = new Api("ClearcutLogger.API", zzVk, zzVj);
    public static final ClearcutLoggerApi ClearcutLoggerApi = new zznc();
    public static final zzc<zznd> zzVj = new zzc();
    public static final zza<zznd, NoOptions> zzVk = new C01881();
    private final Context mContext;
    private final String mPackageName;
    private final int zzaoB;
    private String zzaoC;
    private int zzaoD;
    private String zzaoE;
    private String zzaoF;
    private final boolean zzaoG;
    private int zzaoH;
    private final ClearcutLoggerApi zzaoI;
    private final BootCount zzaoJ;
    private TimeZoneOffsetProvider zzaoK;
    private final Clock zzrA;

    static class C01881 extends zza<zznd, NoOptions> {
        C01881() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzh(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zznd zzh(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zznd(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public class LogEventBuilder {
        private String zzaoC;
        private int zzaoD;
        private String zzaoE;
        private String zzaoF;
        private int zzaoH;
        private final MessageProducer zzaoL;
        private MessageProducer zzaoM;
        private ArrayList<Integer> zzaoN;
        private final zzd zzaoO;
        private boolean zzaoP;
        final /* synthetic */ ClearcutLogger zzaoQ;

        private LogEventBuilder(ClearcutLogger clearcutLogger, MessageProducer extensionProducer) {
            this(clearcutLogger, null, extensionProducer);
        }

        private LogEventBuilder(ClearcutLogger clearcutLogger, byte[] extensionBytes) {
            this(clearcutLogger, extensionBytes, null);
        }

        private LogEventBuilder(ClearcutLogger clearcutLogger, byte[] extensionBytes, MessageProducer extensionProducer) {
            this.zzaoQ = clearcutLogger;
            this.zzaoD = this.zzaoQ.zzaoD;
            this.zzaoC = this.zzaoQ.zzaoC;
            this.zzaoE = this.zzaoQ.zzaoE;
            this.zzaoF = this.zzaoQ.zzaoF;
            this.zzaoH = this.zzaoQ.zzaoH;
            this.zzaoN = null;
            this.zzaoO = new zzd();
            this.zzaoP = false;
            this.zzaoE = clearcutLogger.zzaoE;
            this.zzaoF = clearcutLogger.zzaoF;
            this.zzaoO.zzcrC = clearcutLogger.zzrA.currentTimeMillis();
            this.zzaoO.zzcrD = clearcutLogger.zzrA.elapsedRealtime();
            this.zzaoO.zzcrS = (long) clearcutLogger.zzaoJ.getBootCount(clearcutLogger.mContext);
            this.zzaoO.zzcrN = clearcutLogger.zzaoK.getOffsetSeconds(this.zzaoO.zzcrC);
            if (extensionBytes != null) {
                this.zzaoO.zzcrI = extensionBytes;
            }
            this.zzaoL = extensionProducer;
        }

        public LogEventBuilder addTestCode(int testCode) {
            if (this.zzaoN == null) {
                this.zzaoN = new ArrayList();
            }
            this.zzaoN.add(Integer.valueOf(testCode));
            return this;
        }

        public LogEventParcelable getLogEventParcelable() {
            return new LogEventParcelable(new PlayLoggerContext(this.zzaoQ.mPackageName, this.zzaoQ.zzaoB, this.zzaoD, this.zzaoC, this.zzaoE, this.zzaoF, this.zzaoQ.zzaoG, this.zzaoH), this.zzaoO, this.zzaoL, this.zzaoM, ClearcutLogger.zzb(this.zzaoN));
        }

        public PendingResult<Status> log(GoogleApiClient apiClient) {
            if (this.zzaoP) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.zzaoP = true;
            return this.zzaoQ.zzaoI.logEvent(apiClient, getLogEventParcelable());
        }

        public PendingResult<Status> logAsync() {
            if (this.zzaoP) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.zzaoP = true;
            return this.zzaoQ.zzaoI.logEventAsync(this.zzaoQ.mContext, getLogEventParcelable());
        }

        public PendingResult<Status> logAsync(GoogleApiClient apiClient) {
            if (this.zzaoP) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.zzaoP = true;
            return this.zzaoQ.zzaoI.logEventAsync(apiClient, getLogEventParcelable());
        }

        public LogEventBuilder setClientVisualElements(byte[] clientVisualElements) {
            if (clientVisualElements != null) {
                this.zzaoO.zzcrP = clientVisualElements;
            }
            return this;
        }

        public LogEventBuilder setClientVisualElementsProducer(MessageProducer clientVisualElementsProducer) {
            this.zzaoM = clientVisualElementsProducer;
            return this;
        }

        public LogEventBuilder setEventCode(int eventCode) {
            this.zzaoO.eventCode = eventCode;
            return this;
        }

        public LogEventBuilder setEventFlowId(int eventFlowId) {
            this.zzaoO.zzob = eventFlowId;
            return this;
        }

        @Deprecated
        public LogEventBuilder setLogSource(int logSource) {
            this.zzaoD = logSource;
            return this;
        }

        public LogEventBuilder setLogSourceName(String logSourceName) {
            this.zzaoC = logSourceName;
            return this;
        }

        @Deprecated
        public LogEventBuilder setLoggingId(String loggingId) {
            this.zzaoF = loggingId;
            return this;
        }

        public LogEventBuilder setQosTier(int qosTier) {
            this.zzaoH = qosTier;
            return this;
        }

        @Deprecated
        public LogEventBuilder setTag(String tag) {
            this.zzaoO.tag = tag;
            return this;
        }

        public LogEventBuilder setUploadAccountName(String uploadAccountName) {
            if (this.zzaoQ.zzaoG) {
                throw new IllegalArgumentException("setUploadAccountName forbidden on anonymous logger");
            }
            this.zzaoE = uploadAccountName;
            return this;
        }
    }

    public interface MessageProducer {
        byte[] toProtoBytes();
    }

    public static class TimeZoneOffsetProvider {
        public long getOffsetSeconds(long timeMillis) {
            return (long) (TimeZone.getDefault().getOffset(timeMillis) / 1000);
        }
    }

    @Deprecated
    public ClearcutLogger(Context context, int logSource, String uploadAccountName, String loggingId) {
        this(context, logSource, uploadAccountName, loggingId, ClearcutLoggerApi, zzg.zzsh(), new TimeZoneOffsetProvider());
    }

    @Deprecated
    public ClearcutLogger(Context context, int logSource, String uploadAccountName, String loggingId, ClearcutLoggerApi loggerApi, Clock clock, TimeZoneOffsetProvider offsetProvider) {
        this(context, logSource, "", uploadAccountName, loggingId, false, loggerApi, clock, offsetProvider, BootCount.INSTANCE);
    }

    public ClearcutLogger(Context context, int logSource, String logSourceName, String uploadAccountName, String loggingId, boolean isAnonymous, ClearcutLoggerApi loggerApi, Clock clock, TimeZoneOffsetProvider offsetProvider, BootCount bootCount) {
        this.zzaoD = -1;
        this.zzaoH = 0;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.mContext = applicationContext;
        this.mPackageName = context.getPackageName();
        this.zzaoB = zzaj(context);
        this.zzaoD = logSource;
        this.zzaoC = logSourceName;
        this.zzaoE = uploadAccountName;
        this.zzaoF = loggingId;
        this.zzaoG = isAnonymous;
        this.zzaoI = loggerApi;
        this.zzrA = clock;
        if (offsetProvider == null) {
            offsetProvider = new TimeZoneOffsetProvider();
        }
        this.zzaoK = offsetProvider;
        this.zzaoJ = bootCount;
        this.zzaoH = 0;
        if (this.zzaoG) {
            zzx.zzb(this.zzaoE == null, (Object) "can't be anonymous with an upload account");
        }
    }

    public ClearcutLogger(Context context, String logSourceName, String uploadAccountName) {
        this(context, -1, logSourceName, uploadAccountName, null, false, ClearcutLoggerApi, zzg.zzsh(), null, BootCount.INSTANCE);
    }

    public ClearcutLogger(Context context, String logSourceName, String uploadAccountName, ClearcutLoggerApi loggerApi, Clock clock, TimeZoneOffsetProvider offsetProvider) {
        this(context, -1, logSourceName, uploadAccountName, null, false, loggerApi, clock != null ? clock : zzg.zzsh(), offsetProvider, BootCount.INSTANCE);
    }

    @Deprecated
    public ClearcutLogger(Context context, String logSourceName, String uploadAccountName, String loggingId) {
        this(context, -1, logSourceName, uploadAccountName, loggingId, false, ClearcutLoggerApi, zzg.zzsh(), null, BootCount.INSTANCE);
    }

    @Deprecated
    public ClearcutLogger(Context context, String logSourceName, String uploadAccountName, String loggingId, ClearcutLoggerApi loggerApi, Clock clock, TimeZoneOffsetProvider offsetProvider) {
        this(context, -1, logSourceName, uploadAccountName, loggingId, false, loggerApi, clock, offsetProvider, BootCount.INSTANCE);
    }

    public static ClearcutLogger anonymousLogger(Context context, String logSourceName) {
        return new ClearcutLogger(context, -1, logSourceName, null, null, true, ClearcutLoggerApi, zzg.zzsh(), null, BootCount.INSTANCE);
    }

    private int zzaj(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return i;
        }
    }

    private static int[] zzb(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            iArr[i] = ((Integer) it.next()).intValue();
            i = i2;
        }
        return iArr;
    }

    public void disconnectAsync(GoogleApiClient apiClient) {
        this.zzaoI.disconnectAsync(apiClient);
    }

    public boolean flush(GoogleApiClient apiClient, long time, TimeUnit unit) {
        return this.zzaoI.flush(apiClient, time, unit);
    }

    @Deprecated
    public int getLogSource() {
        return this.zzaoD;
    }

    public String getLogSourceName() {
        return this.zzaoC;
    }

    @Deprecated
    public String getLoggingId() {
        return this.zzaoF;
    }

    public String getUploadAccountName() {
        return this.zzaoE;
    }

    public boolean isAnonymous() {
        return this.zzaoG;
    }

    public LogEventBuilder newEvent(MessageProducer extensionProducer) {
        return new LogEventBuilder(extensionProducer);
    }

    public LogEventBuilder newEvent(byte[] extensionBytes) {
        return new LogEventBuilder(extensionBytes);
    }

    public ClearcutLogger setQosTier(int qosTier) {
        if (qosTier < 0 || qosTier > 4) {
            qosTier = 0;
        }
        this.zzaoH = qosTier;
        return this;
    }

    public ClearcutLogger setTimeZoneOffsetProvider(TimeZoneOffsetProvider provider) {
        if (provider == null) {
            provider = new TimeZoneOffsetProvider();
        }
        this.zzaoK = provider;
        return this;
    }
}

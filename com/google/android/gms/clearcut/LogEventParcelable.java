package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.ClearcutLogger.MessageProducer;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzaiu.zzd;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable implements SafeParcelable {
    public static final LogEventParcelableCreator CREATOR = new LogEventParcelableCreator();
    public final MessageProducer clientVisualElementsProducer;
    public final MessageProducer extensionProducer;
    public final zzd logEvent;
    public byte[] logEventBytes;
    public PlayLoggerContext playLoggerContext;
    public int[] testCodes;
    public final int versionCode;

    LogEventParcelable(int versionCode, PlayLoggerContext playLoggerContext, byte[] logEventBytes, int[] testCodes) {
        this.versionCode = versionCode;
        this.playLoggerContext = playLoggerContext;
        this.logEventBytes = logEventBytes;
        this.testCodes = testCodes;
        this.logEvent = null;
        this.extensionProducer = null;
        this.clientVisualElementsProducer = null;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, zzd logEvent, MessageProducer extensionProducer) {
        this(playLoggerContext, logEvent, extensionProducer, null);
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, zzd logEvent, MessageProducer extensionProducer, MessageProducer clientVisualElementsProducer) {
        this.versionCode = 1;
        this.playLoggerContext = playLoggerContext;
        this.logEvent = logEvent;
        this.extensionProducer = extensionProducer;
        this.clientVisualElementsProducer = clientVisualElementsProducer;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, zzd logEvent, MessageProducer extensionProducer, MessageProducer clientVisualElementsProducer, int[] testCodes) {
        this.versionCode = 1;
        this.playLoggerContext = playLoggerContext;
        this.logEvent = logEvent;
        this.extensionProducer = extensionProducer;
        this.clientVisualElementsProducer = clientVisualElementsProducer;
        this.testCodes = testCodes;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) other;
        return this.versionCode == logEventParcelable.versionCode && zzw.equal(this.playLoggerContext, logEventParcelable.playLoggerContext) && Arrays.equals(this.logEventBytes, logEventParcelable.logEventBytes) && Arrays.equals(this.testCodes, logEventParcelable.testCodes) && zzw.equal(this.logEvent, logEventParcelable.logEvent) && zzw.equal(this.extensionProducer, logEventParcelable.extensionProducer) && zzw.equal(this.clientVisualElementsProducer, logEventParcelable.clientVisualElementsProducer);
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), this.playLoggerContext, this.logEventBytes, this.testCodes, this.logEvent, this.extensionProducer, this.clientVisualElementsProducer);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LogEventParcelable[");
        stringBuilder.append(this.versionCode);
        stringBuilder.append(", ");
        stringBuilder.append(this.playLoggerContext);
        stringBuilder.append(", ");
        stringBuilder.append(this.logEventBytes == null ? null : new String(this.logEventBytes));
        stringBuilder.append(", ");
        stringBuilder.append(this.testCodes == null ? (String) null : zzv.zzcK(", ").zza(Arrays.asList(new int[][]{this.testCodes})));
        stringBuilder.append(", ");
        stringBuilder.append(this.logEvent);
        stringBuilder.append(", ");
        stringBuilder.append(this.extensionProducer);
        stringBuilder.append(", ");
        stringBuilder.append(this.clientVisualElementsProducer);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        LogEventParcelableCreator.zza(this, out, flags);
    }
}

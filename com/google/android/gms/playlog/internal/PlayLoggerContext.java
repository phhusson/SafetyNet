package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class PlayLoggerContext implements SafeParcelable {
    public static final PlayLoggerContextCreator CREATOR = new PlayLoggerContextCreator();
    public final boolean isAnonymous;
    public final boolean logAndroidId;
    public final int logSource;
    public final String logSourceName;
    public final String loggingId;
    public final String packageName;
    public final int packageVersionCode;
    public final int qosTier;
    public final String uploadAccountName;
    public final int versionCode;

    public PlayLoggerContext(int versionCode, String packageName, int packageVersionCode, int logSource, String uploadAccountName, String loggingId, boolean logAndroidId, String logSourceName, boolean isAnonymous, int qosTier) {
        this.versionCode = versionCode;
        this.packageName = packageName;
        this.packageVersionCode = packageVersionCode;
        this.logSource = logSource;
        this.uploadAccountName = uploadAccountName;
        this.loggingId = loggingId;
        this.logAndroidId = logAndroidId;
        this.logSourceName = logSourceName;
        this.isAnonymous = isAnonymous;
        this.qosTier = qosTier;
    }

    public PlayLoggerContext(String packageName, int packageVersionCode, int logSource, String logSourceName, String uploadAccountName, String loggingId, boolean isAnonymous, int qosTier) {
        this.versionCode = 1;
        this.packageName = (String) zzx.zzD(packageName);
        this.packageVersionCode = packageVersionCode;
        this.logSource = logSource;
        this.logSourceName = logSourceName;
        this.uploadAccountName = uploadAccountName;
        this.loggingId = loggingId;
        this.logAndroidId = !isAnonymous;
        this.isAnonymous = isAnonymous;
        this.qosTier = qosTier;
    }

    @Deprecated
    public PlayLoggerContext(String packageName, int packageVersionCode, int logSource, String uploadAccountName, String loggingId, boolean logAndroidId) {
        this.versionCode = 1;
        this.packageName = (String) zzx.zzD(packageName);
        this.packageVersionCode = packageVersionCode;
        this.logSource = logSource;
        this.logSourceName = null;
        this.uploadAccountName = uploadAccountName;
        this.loggingId = loggingId;
        this.logAndroidId = logAndroidId;
        this.isAnonymous = false;
        this.qosTier = 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) object;
        return this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.packageVersionCode == playLoggerContext.packageVersionCode && this.logSource == playLoggerContext.logSource && zzw.equal(this.logSourceName, playLoggerContext.logSourceName) && zzw.equal(this.uploadAccountName, playLoggerContext.uploadAccountName) && zzw.equal(this.loggingId, playLoggerContext.loggingId) && this.logAndroidId == playLoggerContext.logAndroidId && this.isAnonymous == playLoggerContext.isAnonymous && this.qosTier == playLoggerContext.qosTier;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.packageVersionCode), Integer.valueOf(this.logSource), this.logSourceName, this.uploadAccountName, this.loggingId, Boolean.valueOf(this.logAndroidId), Boolean.valueOf(this.isAnonymous), Integer.valueOf(this.qosTier));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("versionCode=").append(this.versionCode).append(',');
        stringBuilder.append("package=").append(this.packageName).append(',');
        stringBuilder.append("packageVersionCode=").append(this.packageVersionCode).append(',');
        stringBuilder.append("logSource=").append(this.logSource).append(',');
        stringBuilder.append("logSourceName=").append(this.logSourceName).append(',');
        stringBuilder.append("uploadAccount=").append(this.uploadAccountName).append(',');
        stringBuilder.append("loggingId=").append(this.loggingId).append(',');
        stringBuilder.append("logAndroidId=").append(this.logAndroidId).append(',');
        stringBuilder.append("isAnonymous=").append(this.isAnonymous).append(',');
        stringBuilder.append("qosTier=").append(this.qosTier);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayLoggerContextCreator.zza(this, out, flags);
    }
}

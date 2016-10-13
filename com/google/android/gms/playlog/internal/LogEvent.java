package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.snet.Csv;

public class LogEvent implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final String tag;
    public final int versionCode;
    public final long zzbLA;
    public final long zzbLB;
    public final byte[] zzbLC;
    public final Bundle zzbLD;

    LogEvent(int versionCode, long eventTime, long eventUptime, String tag, byte[] sourceExtensionBytes, Bundle keyValuePairs) {
        this.versionCode = versionCode;
        this.zzbLA = eventTime;
        this.zzbLB = eventUptime;
        this.tag = tag;
        this.zzbLC = sourceExtensionBytes;
        this.zzbLD = keyValuePairs;
    }

    public LogEvent(long eventTime, long eventUptime, String tag, byte[] sourceExtensionBytes, String... extras) {
        this.versionCode = 1;
        this.zzbLA = eventTime;
        this.zzbLB = eventUptime;
        this.tag = tag;
        this.zzbLC = sourceExtensionBytes;
        this.zzbLD = zze(extras);
    }

    private static Bundle zze(String... strArr) {
        Bundle bundle = null;
        if (strArr != null) {
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("extras must have an even number of elements");
            }
            int length = strArr.length / 2;
            if (length != 0) {
                bundle = new Bundle(length);
                for (int i = 0; i < length; i++) {
                    bundle.putString(strArr[i * 2], strArr[(i * 2) + 1]);
                }
            }
        }
        return bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag=").append(this.tag).append(Csv.COMMA);
        stringBuilder.append("eventTime=").append(this.zzbLA).append(Csv.COMMA);
        stringBuilder.append("eventUptime=").append(this.zzbLB).append(Csv.COMMA);
        if (!(this.zzbLD == null || this.zzbLD.isEmpty())) {
            stringBuilder.append("keyValues=");
            for (String str : this.zzbLD.keySet()) {
                stringBuilder.append("(").append(str).append(Csv.COMMA);
                stringBuilder.append(this.zzbLD.getString(str)).append(")");
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}

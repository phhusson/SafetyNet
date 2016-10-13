package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class Status implements Result, SafeParcelable {
    public static final Creator<Status> CREATOR = new zzb();
    public static final Status zzaqL = new Status(0);
    public static final Status zzaqM = new Status(14);
    public static final Status zzaqN = new Status(8);
    public static final Status zzaqO = new Status(15);
    public static final Status zzaqP = new Status(16);
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final int zzamh;
    private final String zzapK;

    public Status(int statusCode) {
        this(statusCode, null);
    }

    Status(int versionCode, int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this.mVersionCode = versionCode;
        this.zzamh = statusCode;
        this.zzapK = statusMessage;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int statusCode, String statusMessage) {
        this(1, statusCode, statusMessage, null);
    }

    public Status(int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this(1, statusCode, statusMessage, pendingIntent);
    }

    private String zzpr() {
        return this.zzapK != null ? this.zzapK : CommonStatusCodes.getStatusCodeString(this.zzamh);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.mVersionCode == status.mVersionCode && this.zzamh == status.zzamh && zzw.equal(this.zzapK, status.zzapK) && zzw.equal(this.mPendingIntent, status.mPendingIntent);
    }

    PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.zzamh;
    }

    public String getStatusMessage() {
        return this.zzapK;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), Integer.valueOf(this.zzamh), this.zzapK, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.zzamh == 16;
    }

    public boolean isInterrupted() {
        return this.zzamh == 14;
    }

    public boolean isSuccess() {
        return this.zzamh <= 0;
    }

    public void startResolutionForResult(Activity activity, int requestCode) throws SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), requestCode, null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzw.zzC(this).zzh("statusCode", zzpr()).zzh("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}

package com.google.android.gms.common.download;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class DownloadDetails implements SafeParcelable {
    public static final Creator<DownloadDetails> CREATOR = new zza();
    public final String filename;
    public final String url;
    final int versionCode;
    public final long zzaud;
    public final String zzaue;
    public final String zzauf;
    public final int zzaug;
    public final int zzauh;

    DownloadDetails(int versionCode, String filename, String url, long sizeBytes, String sha1, String destination, int minVersion, int maxVersion) {
        boolean z = true;
        zzx.zzb(minVersion <= maxVersion, "The minVersion (" + minVersion + ") must be less than or equal to the maxVersion" + " (" + maxVersion + ").");
        if (sizeBytes <= 0) {
            z = false;
        }
        zzx.zzb(z, "sizeBytes (" + sizeBytes + ") must be greater than zero");
        this.versionCode = versionCode;
        this.filename = (String) zzx.zzD(filename);
        this.url = (String) zzx.zzD(url);
        this.zzaud = sizeBytes;
        this.zzaue = (String) zzx.zzD(sha1);
        this.zzauf = destination;
        this.zzaug = minVersion;
        this.zzauh = maxVersion;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o instanceof DownloadDetails) {
            DownloadDetails downloadDetails = (DownloadDetails) o;
            if (this.filename.equals(downloadDetails.filename) && this.url.equals(downloadDetails.url) && this.zzaud == downloadDetails.zzaud && this.zzaue.equals(downloadDetails.zzaue) && (((this.zzauf == null && downloadDetails.zzauf == null) || this.zzauf.equals(downloadDetails.zzauf)) && this.zzaug == downloadDetails.zzaug && this.zzauh == downloadDetails.zzauh)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return zzw.hashCode(this.filename, this.url, Long.valueOf(this.zzaud), this.zzaue, this.zzauf, Integer.valueOf(this.zzaug), Integer.valueOf(this.zzauh));
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}

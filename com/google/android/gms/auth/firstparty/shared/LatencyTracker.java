package com.google.android.gms.auth.firstparty.shared;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class LatencyTracker implements SafeParcelable {
    public static final LatencyTrackerCreator CREATOR = new LatencyTrackerCreator();
    final String mName;
    final int mVersion;
    public final LatencyTracker parent;
    final long zzacs;

    LatencyTracker(int version, String name, long startRealtimeMillis, LatencyTracker parent) {
        this.mVersion = version;
        this.mName = name;
        this.zzacs = startRealtimeMillis;
        this.parent = parent;
        log(name, "constructed");
    }

    public static LatencyTracker create(String name) {
        return new LatencyTracker(1, name, SystemClock.elapsedRealtime(), null);
    }

    public static LatencyTracker fromBundle(Bundle bundle) {
        return (LatencyTracker) bundle.getParcelable("latency.tracker");
    }

    public static LatencyTracker fromIntent(Intent intent) {
        return (LatencyTracker) intent.getParcelableExtra("latency.tracker");
    }

    public LatencyTracker createChild(String name) {
        return new LatencyTracker(1, name, SystemClock.elapsedRealtime(), this);
    }

    public int describeContents() {
        return 0;
    }

    public void log(String prefix, String eventDescription) {
        if (Log.isLoggable("GLSLogging", 2)) {
            String str = "GLSLogging";
            Log.println(2, str, prefix + " " + zzt(SystemClock.elapsedRealtime()) + " > " + eventDescription);
        }
    }

    public void toBundle(Bundle bundle) {
        bundle.putParcelable("latency.tracker", this);
    }

    public void toIntent(Intent intent) {
        intent.putExtra("latency.tracker", this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        log(this.mName, "writing to parcel");
        LatencyTrackerCreator.zza(this, dest, flags);
    }

    String zzt(long j) {
        Iterable linkedList = new LinkedList();
        while (this != null) {
            long j2 = j - this.zzacs;
            j2 -= TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(j2));
            linkedList.addFirst(String.format("[%s, %,d.%03ds]", new Object[]{this.mName, Long.valueOf(r4), Long.valueOf(j2)}));
            this = this.parent;
        }
        return TextUtils.join(" > ", linkedList);
    }
}

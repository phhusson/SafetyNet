package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableLoadAutocompleteResultsOptions implements SafeParcelable {
    public static final zzl CREATOR = new zzl();
    final int mVersionCode;
    final String zzPe;
    final int zzasY;
    final long zzbHM;

    ParcelableLoadAutocompleteResultsOptions(int versionCode, int clientId, long sessionId, String query) {
        this.mVersionCode = versionCode;
        this.zzasY = clientId;
        this.zzbHM = sessionId;
        this.zzPe = query;
    }

    public ParcelableLoadAutocompleteResultsOptions(int clientId, long sessionId, String query) {
        this(1, clientId, sessionId, query);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }
}

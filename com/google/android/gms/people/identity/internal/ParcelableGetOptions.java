package com.google.android.gms.people.identity.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.people.identity.IdentityApi.GetOptions;

public final class ParcelableGetOptions implements SafeParcelable {
    public static final zzi CREATOR = new zzi();
    private final int mVersionCode;
    final boolean zzbAd;
    final boolean zzbBZ;
    final boolean zzbCa;
    final String zzbzY;
    final Bundle zzbzZ;

    ParcelableGetOptions(int versionCode, boolean useOfflineDatabase, boolean useWebData, boolean useCp2, String endpoint, Bundle endpointArguments) {
        this.mVersionCode = versionCode;
        this.zzbBZ = useOfflineDatabase;
        this.zzbAd = useWebData;
        this.zzbzY = endpoint;
        this.zzbCa = useCp2;
        if (endpointArguments == null) {
            endpointArguments = new Bundle();
        }
        this.zzbzZ = endpointArguments;
    }

    public ParcelableGetOptions(GetOptions options) {
        this(options.useCachedData, options.useWebData, options.useContactData, options.zzbAa.zzbzW, options.zzbAa.zzbzX);
    }

    public ParcelableGetOptions(boolean useOfflineDatabase, boolean useWebData, boolean useCp2, String endpoint, Bundle endpointArguments) {
        this(1, useOfflineDatabase, useWebData, useCp2, endpoint, endpointArguments);
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzw.zzC(this).zzh("useOfflineDatabase", Boolean.valueOf(this.zzbBZ)).zzh("useWebData", Boolean.valueOf(this.zzbAd)).zzh("endpoint", this.zzbzY).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzi.zza(this, out, flags);
    }
}

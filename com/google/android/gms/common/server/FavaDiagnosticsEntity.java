package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FavaDiagnosticsEntity implements SafeParcelable {
    public static final zza CREATOR = new zza();
    final int mVersionCode;
    public final String zzaxu;
    public final int zzaxv;

    public FavaDiagnosticsEntity(int versionCode, String namespace, int typeNum) {
        this.mVersionCode = versionCode;
        this.zzaxu = namespace;
        this.zzaxv = typeNum;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}

package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class Scope implements SafeParcelable {
    public static final Creator<Scope> CREATOR = new zza();
    final int mVersionCode;
    private final String zzaqK;

    Scope(int versionCode, String scopeUri) {
        zzx.zzi(scopeUri, "scopeUri must not be null or empty");
        this.mVersionCode = versionCode;
        this.zzaqK = scopeUri;
    }

    public Scope(String scopeUri) {
        this(1, scopeUri);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return !(o instanceof Scope) ? false : this.zzaqK.equals(((Scope) o).zzaqK);
    }

    public int hashCode() {
        return this.zzaqK.hashCode();
    }

    public String toString() {
        return this.zzaqK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public String zzpq() {
        return this.zzaqK;
    }
}

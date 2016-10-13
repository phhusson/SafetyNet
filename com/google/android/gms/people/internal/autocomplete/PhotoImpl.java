package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.Autocomplete.Photo;

public class PhotoImpl implements SafeParcelable, Photo {
    public static final Creator<PhotoImpl> CREATOR = new zzq();
    final int mVersionCode;
    final boolean zzbCX;
    final String zzbDH;
    final int zzvU;

    PhotoImpl(int versionCode, int source, String location, boolean isDefault) {
        this.mVersionCode = versionCode;
        this.zzvU = source;
        this.zzbDH = location;
        this.zzbCX = isDefault;
    }

    public int describeContents() {
        return 0;
    }

    public String getLocation() {
        return this.zzbDH;
    }

    public int getSource() {
        return this.zzvU;
    }

    public boolean isDefault() {
        return this.zzbCX;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }
}

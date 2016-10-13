package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.ImageReference;
import java.util.HashSet;
import java.util.Set;

public class ImageReferenceImpl implements SafeParcelable, ImageReference {
    public static final zzas CREATOR = new zzas();
    byte[] mData;
    final int mVersionCode;
    int zzUO;
    final Set<Integer> zzbCc;
    String zzbDH;

    public ImageReferenceImpl() {
        this.zzbCc = new HashSet();
        this.mVersionCode = 1;
    }

    ImageReferenceImpl(Set<Integer> indicatorSet, int versionCode, int type, String location, byte[] data) {
        this.zzbCc = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzUO = type;
        this.zzbDH = location;
        this.mData = data;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzas.zza(this, out, flags);
    }

    public ImageReferenceImpl zzfW(String str) {
        this.zzbDH = str;
        return this;
    }

    public ImageReferenceImpl zzmQ(int i) {
        this.zzbCc.add(Integer.valueOf(2));
        this.zzUO = i;
        return this;
    }
}

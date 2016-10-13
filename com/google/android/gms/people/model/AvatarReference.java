package com.google.android.gms.people.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.people.internal.zzp;

public final class AvatarReference implements SafeParcelable {
    public static final ParcelableAvatarReference CREATOR = new ParcelableAvatarReference();
    private final int mVersionCode;
    final String zzbDH;
    final int zzvU;

    AvatarReference(int versionCode, int source, String location) {
        zzx.zzad(source != 0);
        this.mVersionCode = versionCode;
        this.zzvU = source;
        this.zzbDH = location;
    }

    public AvatarReference(int source, String location) {
        this(1, source, location);
    }

    public static AvatarReference fromPersistableString(String s) {
        boolean z = true;
        zzx.zzcL(s);
        String[] split = zzp.zzbES.split(s);
        if (split.length != 3) {
            z = false;
        }
        zzx.zzb(z, (Object) "Malformed string");
        try {
            return new AvatarReference(Integer.parseInt(split[0]), Integer.parseInt(split[1]), split[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Malformed string");
        }
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

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toPersistableString() {
        return this.mVersionCode + '\u0001' + this.zzvU + '\u0001' + this.zzbDH;
    }

    public String toString() {
        return zzw.zzC(this).zzh("source", Integer.valueOf(this.zzvU)).zzh("location", this.zzbDH).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        ParcelableAvatarReference.zza(this, out, flags);
    }
}

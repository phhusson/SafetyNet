package com.google.android.gms.auth.firstparty.proximity.data;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;

public class PermitAccess implements SafeParcelable {
    public static final PermitAccessCreator CREATOR = new PermitAccessCreator();
    public static final String TYPE_AES = "AES";
    public static final String TYPE_AUTHZEN_PUBLIC_KEY = "AUTHZEN_PUBLIC_KEY";
    final byte[] mData;
    final int mVersion;
    final String zzKj;
    final String zzyU;

    PermitAccess(int version, String id, String type, byte[] data) {
        this.mVersion = version;
        this.zzyU = zzx.zzcL(id);
        this.zzKj = zzx.zzcL(type);
        this.mData = (byte[]) zzx.zzD(data);
    }

    public PermitAccess(String id, String type, byte[] data) {
        this(1, id, type, data);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PermitAccess)) {
            return false;
        }
        PermitAccess permitAccess = (PermitAccess) obj;
        if (!(TextUtils.equals(this.zzyU, permitAccess.zzyU) && TextUtils.equals(this.zzKj, permitAccess.zzKj) && Arrays.equals(this.mData, permitAccess.mData))) {
            z = false;
        }
        return z;
    }

    public byte[] getData() {
        return this.mData;
    }

    public String getId() {
        return this.zzyU;
    }

    public String getType() {
        return this.zzKj;
    }

    public int hashCode() {
        return (31 * (((this.zzyU.hashCode() + 527) * 31) + this.zzKj.hashCode())) + Arrays.hashCode(this.mData);
    }

    public void writeToParcel(Parcel dest, int flags) {
        PermitAccessCreator.zza(this, dest, flags);
    }
}

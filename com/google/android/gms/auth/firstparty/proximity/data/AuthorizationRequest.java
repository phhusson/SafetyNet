package com.google.android.gms.auth.firstparty.proximity.data;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;

public class AuthorizationRequest implements SafeParcelable {
    public static final AuthorizationRequestCreator CREATOR = new AuthorizationRequestCreator();
    final byte[] mData;
    final String mPermitAccessId;
    final String mPermitId;
    final int mVersion;

    AuthorizationRequest(int version, String permitId, String permitAccessId, byte[] data) {
        this.mVersion = version;
        this.mPermitId = zzx.zzcL(permitId);
        this.mPermitAccessId = zzx.zzcL(permitAccessId);
        this.mData = (byte[]) zzx.zzD(data);
    }

    public AuthorizationRequest(String permitId, String permitAccessId, byte[] data) {
        this(1, permitId, permitAccessId, data);
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
        if (!(obj instanceof AuthorizationRequest)) {
            return false;
        }
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) obj;
        if (!(TextUtils.equals(this.mPermitId, authorizationRequest.mPermitId) && TextUtils.equals(this.mPermitAccessId, authorizationRequest.mPermitAccessId) && Arrays.equals(this.mData, authorizationRequest.mData))) {
            z = false;
        }
        return z;
    }

    public byte[] getData() {
        return this.mData;
    }

    public String getPermitAccessId() {
        return this.mPermitAccessId;
    }

    public String getPermitId() {
        return this.mPermitId;
    }

    public int hashCode() {
        return (31 * (((this.mPermitId.hashCode() + 527) * 31) + this.mPermitAccessId.hashCode())) + Arrays.hashCode(this.mData);
    }

    public void writeToParcel(Parcel dest, int flags) {
        AuthorizationRequestCreator.zza(this, dest, flags);
    }
}

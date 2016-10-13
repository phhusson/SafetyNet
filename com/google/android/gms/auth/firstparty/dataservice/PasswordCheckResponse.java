package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class PasswordCheckResponse implements SafeParcelable {
    public static final PasswordCheckResponseCreator CREATOR = new PasswordCheckResponseCreator();
    String status;
    final int version;
    String zzaaj;
    String zzabp;

    PasswordCheckResponse(int version, String status, String passwordStrength, String detail) {
        this.version = version;
        this.status = status;
        this.zzabp = passwordStrength;
        this.zzaaj = detail;
    }

    public PasswordCheckResponse(Status status) {
        this(status, null, null);
    }

    public PasswordCheckResponse(Status status, String passwordStrength, String detail) {
        this.version = 1;
        this.status = ((Status) zzx.zzD(status)).getWire();
        this.zzabp = passwordStrength;
        this.zzaaj = detail;
    }

    public int describeContents() {
        return 0;
    }

    public String getDetail() {
        return this.zzaaj;
    }

    public String getPasswordStrength() {
        return this.zzabp;
    }

    public Status getStatus() {
        return Status.fromWireCode(this.status);
    }

    public void writeToParcel(Parcel dest, int flags) {
        PasswordCheckResponseCreator.zza(this, dest, flags);
    }
}

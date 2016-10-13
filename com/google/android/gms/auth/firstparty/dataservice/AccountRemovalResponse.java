package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class AccountRemovalResponse implements SafeParcelable {
    public static final AccountRemovalResponseCreator CREATOR = new AccountRemovalResponseCreator();
    final int version;
    final String zzaah;

    AccountRemovalResponse(int version, String statusWireCode) {
        this.version = version;
        this.zzaah = statusWireCode;
    }

    public AccountRemovalResponse(Status status) {
        this.version = 1;
        this.zzaah = ((Status) zzx.zzD(status)).getWire();
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return Status.fromWireCode(this.zzaah);
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountRemovalResponseCreator.zza(this, dest, flags);
    }
}

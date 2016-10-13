package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
    public static final Creator<AccountChangeEventsResponse> CREATOR = new zzc();
    final int mVersion;
    final List<AccountChangeEvent> zzql;

    AccountChangeEventsResponse(int version, List<AccountChangeEvent> events) {
        this.mVersion = version;
        this.zzql = (List) zzx.zzD(events);
    }

    public AccountChangeEventsResponse(List<AccountChangeEvent> events) {
        this.mVersion = 1;
        this.zzql = (List) zzx.zzD(events);
    }

    public int describeContents() {
        return 0;
    }

    public List<AccountChangeEvent> getEvents() {
        return this.zzql;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}

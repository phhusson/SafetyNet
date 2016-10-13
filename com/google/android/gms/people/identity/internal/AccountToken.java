package com.google.android.gms.people.identity.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class AccountToken implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    private final String zzWD;
    private final String zzbzd;

    AccountToken(int versionCode, String accountName, String pageId) {
        this.mVersionCode = versionCode;
        this.zzWD = accountName;
        this.zzbzd = pageId;
    }

    public AccountToken(String accountName, String pageId) {
        this(1, accountName, pageId);
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.zzWD;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public String zzGm() {
        return this.zzbzd;
    }
}

package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecordConsentRequest implements SafeParcelable {
    public static final Creator<RecordConsentRequest> CREATOR = new zzf();
    final int mVersionCode;
    private final Account zzSX;
    private final String zzYM;
    private final Scope[] zzbTU;

    RecordConsentRequest(int versionCode, Account account, Scope[] scopesToConsent, String serverClientId) {
        this.mVersionCode = versionCode;
        this.zzSX = account;
        this.zzbTU = scopesToConsent;
        this.zzYM = serverClientId;
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzSX;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public Scope[] zzLA() {
        return this.zzbTU;
    }

    public String zzkC() {
        return this.zzYM;
    }
}

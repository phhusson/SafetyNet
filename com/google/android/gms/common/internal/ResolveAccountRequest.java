package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountRequest implements SafeParcelable {
    public static final Creator<ResolveAccountRequest> CREATOR = new zzy();
    final int mVersionCode;
    private final Account zzSX;
    private final int zzaxa;
    private final GoogleSignInAccount zzaxb;

    ResolveAccountRequest(int versionCode, Account account, int sessionId, GoogleSignInAccount signInAccountHint) {
        this.mVersionCode = versionCode;
        this.zzSX = account;
        this.zzaxa = sessionId;
        this.zzaxb = signInAccountHint;
    }

    public ResolveAccountRequest(Account account, int sessionId, GoogleSignInAccount signInAccountHint) {
        this(2, account, sessionId, signInAccountHint);
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzSX;
    }

    public int getSessionId() {
        return this.zzaxa;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzy.zza(this, dest, flags);
    }

    @Nullable
    public GoogleSignInAccount zzrq() {
        return this.zzaxb;
    }
}

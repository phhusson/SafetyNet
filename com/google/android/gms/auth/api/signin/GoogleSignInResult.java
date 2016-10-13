package com.google.android.gms.auth.api.signin;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class GoogleSignInResult implements Result {
    private Status zzVy;
    private GoogleSignInAccount zzYP;

    public GoogleSignInResult(@Nullable GoogleSignInAccount SignInAccount, @NonNull Status status) {
        this.zzYP = SignInAccount;
        this.zzVy = status;
    }

    @Nullable
    public GoogleSignInAccount getSignInAccount() {
        return this.zzYP;
    }

    @NonNull
    public Status getStatus() {
        return this.zzVy;
    }

    public boolean isSuccess() {
        return this.zzVy.isSuccess();
    }
}

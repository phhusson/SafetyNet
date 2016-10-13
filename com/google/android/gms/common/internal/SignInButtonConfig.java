package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInButtonConfig implements SafeParcelable {
    public static final Creator<SignInButtonConfig> CREATOR = new zzaa();
    final int mVersionCode;
    private final Scope[] zzaqd;
    private final int zzaxe;
    private final int zzaxf;

    SignInButtonConfig(int versionCode, int buttonSize, int colorScheme, Scope[] scopes) {
        this.mVersionCode = versionCode;
        this.zzaxe = buttonSize;
        this.zzaxf = colorScheme;
        this.zzaqd = scopes;
    }

    public SignInButtonConfig(int buttonSize, int colorScheme, Scope[] scopes) {
        this(1, buttonSize, colorScheme, scopes);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaa.zza(this, dest, flags);
    }

    public int zzrv() {
        return this.zzaxe;
    }

    public int zzrw() {
        return this.zzaxf;
    }

    public Scope[] zzrx() {
        return this.zzaqd;
    }
}

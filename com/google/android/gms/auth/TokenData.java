package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class TokenData implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    final int mVersionCode;
    private final String zzWX;
    private final Long zzWY;
    private final boolean zzWZ;
    private final boolean zzXa;
    private final List<String> zzXb;

    public static class zza {
        private String zzWX = null;
        private Long zzWY = null;
        private boolean zzWZ = false;
        private boolean zzXa = false;
        private List<String> zzXb = null;

        public zza zzbq(String str) {
            this.zzWX = str;
            return this;
        }

        @Nullable
        public TokenData zzkl() {
            if (!this.zzXa || this.zzXb != null) {
                return TextUtils.isEmpty(this.zzWX) ? null : new TokenData(1, this.zzWX, this.zzWY, this.zzWZ, this.zzXa, this.zzXb);
            } else {
                throw new IllegalStateException("Granted scopes must be set if the token is snowballed.");
            }
        }
    }

    TokenData(int versionCode, String token, Long expirationTimeSecs, boolean isCached, boolean isSnowballed, List<String> grantedScopes) {
        this.mVersionCode = versionCode;
        this.zzWX = zzx.zzcL(token);
        this.zzWY = expirationTimeSecs;
        this.zzWZ = isCached;
        this.zzXa = isSnowballed;
        this.zzXb = grantedScopes;
    }

    @Nullable
    public static TokenData zzc(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle2.getParcelable("TokenData");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) o;
        return TextUtils.equals(this.zzWX, tokenData.zzWX) && zzw.equal(this.zzWY, tokenData.zzWY) && this.zzWZ == tokenData.zzWZ && this.zzXa == tokenData.zzXa && zzw.equal(this.zzXb, tokenData.zzXb);
    }

    public String getToken() {
        return this.zzWX;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzWX, this.zzWY, Boolean.valueOf(this.zzWZ), Boolean.valueOf(this.zzXa), this.zzXb);
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }

    @Nullable
    public Long zzkh() {
        return this.zzWY;
    }

    public boolean zzki() {
        return this.zzWZ;
    }

    public boolean zzkj() {
        return this.zzXa;
    }

    @Nullable
    public List<String> zzkk() {
        return this.zzXb;
    }
}

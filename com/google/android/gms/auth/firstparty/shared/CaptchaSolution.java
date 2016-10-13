package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CaptchaSolution implements SafeParcelable {
    public static final CaptchaSolutionCreator CREATOR = new CaptchaSolutionCreator();
    final int version;
    String zzaaC;
    String zzach;

    CaptchaSolution(int version, String token, String answer) {
        this.version = version;
        this.zzaaC = token;
        this.zzach = answer;
    }

    public CaptchaSolution(String captchaToken, String captchaAnswer) {
        this.version = 1;
        this.zzaaC = captchaToken;
        this.zzach = captchaAnswer;
    }

    public int describeContents() {
        return 0;
    }

    public String getAnswer() {
        return this.zzach;
    }

    public String getToken() {
        return this.zzaaC;
    }

    public void writeToParcel(Parcel dest, int flags) {
        CaptchaSolutionCreator.zza(this, dest, flags);
    }
}

package com.google.android.gms.auth.firstparty.shared;

import android.graphics.Bitmap;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class CaptchaChallenge implements SafeParcelable {
    public static final CaptchaChallengeCreator CREATOR = new CaptchaChallengeCreator();
    final int version;
    String zzaaC;
    String zzaah;
    Bitmap zzacg;

    CaptchaChallenge(int version, String statusWireCode, String token, Bitmap captcha) {
        this.version = version;
        this.zzaah = statusWireCode;
        this.zzaaC = token;
        this.zzacg = captcha;
    }

    public CaptchaChallenge(Status status) {
        this(status, null, null);
    }

    public CaptchaChallenge(Status status, String captchaToken, Bitmap captcha) {
        this.version = 1;
        this.zzaah = ((Status) zzx.zzD(status)).getWire();
        this.zzaaC = captchaToken;
        this.zzacg = captcha;
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getCaptcha() {
        return this.zzacg;
    }

    public String getCaptchaToken() {
        return this.zzaaC;
    }

    public Status getStatus() {
        return Status.fromWireCode(this.zzaah);
    }

    public void writeToParcel(Parcel dest, int flags) {
        CaptchaChallengeCreator.zza(this, dest, flags);
    }
}

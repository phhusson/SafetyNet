package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.CaptchaChallenge;
import com.google.android.gms.auth.firstparty.shared.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountNameCheckResponse implements SafeParcelable {
    public static final AccountNameCheckResponseCreator CREATOR = new AccountNameCheckResponseCreator();
    final int version;
    String zzaah;
    List<String> zzaai;
    String zzaaj;
    CaptchaChallenge zzaak;

    AccountNameCheckResponse(int version, String statusWireCode, List<String> suggestions, String detail, CaptchaChallenge captcha) {
        this.version = version;
        this.zzaah = statusWireCode;
        this.zzaai = suggestions;
        this.zzaaj = detail;
        this.zzaak = captcha;
    }

    public AccountNameCheckResponse(Status status) {
        this(status, Collections.EMPTY_LIST);
    }

    public AccountNameCheckResponse(Status status, String detail, CaptchaChallenge captchaChallenge, List<String> suggestions) {
        this.version = 1;
        this.zzaah = ((Status) zzx.zzD(status)).getWire();
        this.zzaaj = detail;
        this.zzaak = captchaChallenge;
        this.zzaai = Collections.unmodifiableList(new ArrayList(suggestions));
    }

    public AccountNameCheckResponse(Status status, String detail, List<String> suggestions) {
        this(status, detail, null, suggestions);
    }

    public AccountNameCheckResponse(Status status, List<String> suggestions) {
        this(status, null, suggestions);
    }

    public int describeContents() {
        return 0;
    }

    public List<String> getAccountNameSuggestions() {
        return this.zzaai;
    }

    public CaptchaChallenge getCaptchaChallenge() {
        return this.zzaak;
    }

    public String getDetail() {
        return this.zzaaj;
    }

    public Status getStatus() {
        return Status.fromWireCode(this.zzaah);
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountNameCheckResponseCreator.zza(this, dest, flags);
    }
}

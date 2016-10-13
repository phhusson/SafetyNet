package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailSignInOptions implements SafeParcelable {
    public static final Creator<EmailSignInOptions> CREATOR = new zza();
    final int versionCode;
    private final Uri zzYv;
    private String zzYw;
    private Uri zzYx;

    EmailSignInOptions(int versionCode, Uri serverWidgetUrl, String modeQueryName, Uri tosUrl) {
        zzx.zzb((Object) serverWidgetUrl, (Object) "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzi(serverWidgetUrl.toString(), "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzb(Patterns.WEB_URL.matcher(serverWidgetUrl.toString()).matches(), (Object) "Invalid server widget url");
        this.versionCode = versionCode;
        this.zzYv = serverWidgetUrl;
        this.zzYw = modeQueryName;
        this.zzYx = tosUrl;
    }

    public EmailSignInOptions(Uri serverWidgetUrl) {
        this(1, serverWidgetUrl, null, null);
    }

    public static EmailSignInOptions zzbr(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        EmailSignInOptions emailSignInOptions = new EmailSignInOptions(Uri.parse(jSONObject.getString("serverWidgetUrl")));
        Object optString = jSONObject.optString("tosUrl");
        if (!TextUtils.isEmpty(optString)) {
            emailSignInOptions.setTermsOfServiceUrl(Uri.parse(optString));
        }
        Object optString2 = jSONObject.optString("modeQueryName");
        if (TextUtils.isEmpty(optString2)) {
            return emailSignInOptions;
        }
        emailSignInOptions.setModeQueryName(optString2);
        return emailSignInOptions;
    }

    private JSONObject zzkv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serverWidgetUrl", this.zzYv.toString());
            if (!TextUtils.isEmpty(this.zzYw)) {
                jSONObject.put("modeQueryName", this.zzYw);
            }
            if (this.zzYx != null) {
                jSONObject.put("tosUrl", this.zzYx.toString());
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            EmailSignInOptions emailSignInOptions = (EmailSignInOptions) obj;
            if (!this.zzYv.equals(emailSignInOptions.getServerWidgetUrl())) {
                return false;
            }
            if (this.zzYx == null) {
                if (emailSignInOptions.getTermsOfServiceUrl() != null) {
                    return false;
                }
            } else if (!this.zzYx.equals(emailSignInOptions.getTermsOfServiceUrl())) {
                return false;
            }
            if (TextUtils.isEmpty(this.zzYw)) {
                if (!TextUtils.isEmpty(emailSignInOptions.getModeQueryName())) {
                    return false;
                }
            } else if (!this.zzYw.equals(emailSignInOptions.getModeQueryName())) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public String getModeQueryName() {
        return this.zzYw;
    }

    public Uri getServerWidgetUrl() {
        return this.zzYv;
    }

    public Uri getTermsOfServiceUrl() {
        return this.zzYx;
    }

    public int hashCode() {
        return new zzg().zzs(this.zzYv).zzs(this.zzYx).zzs(this.zzYw).zzkM();
    }

    public EmailSignInOptions setModeQueryName(String modeQueryName) {
        this.zzYw = zzx.zzcL(modeQueryName);
        return this;
    }

    public EmailSignInOptions setTermsOfServiceUrl(Uri url) {
        this.zzYx = (Uri) zzx.zzb((Object) url, (Object) "Uri cannot be null.");
        zzx.zzi(url.toString(), "Uri String cannot be empty.");
        zzx.zzb(Patterns.WEB_URL.matcher(url.toString()).matches(), (Object) "Invalid Terms of Service url");
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public String zzku() {
        return zzkv().toString();
    }
}

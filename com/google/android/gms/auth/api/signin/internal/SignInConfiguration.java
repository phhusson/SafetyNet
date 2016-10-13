package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public final class SignInConfiguration implements SafeParcelable {
    public static final Creator<SignInConfiguration> CREATOR = new zzr();
    final int versionCode;
    private String zzYM;
    private final String zzZB;
    private EmailSignInOptions zzZC;
    private GoogleSignInOptions zzZD;
    private String zzZE;

    SignInConfiguration(int versionCode, String consumerPkgName, String serverClientId, EmailSignInOptions emailConfig, GoogleSignInOptions googleConfig, String apiKey) {
        this.versionCode = versionCode;
        this.zzZB = zzx.zzcL(consumerPkgName);
        this.zzYM = serverClientId;
        this.zzZC = emailConfig;
        this.zzZD = googleConfig;
        this.zzZE = apiKey;
    }

    public SignInConfiguration(String consumerPkgName) {
        this(2, consumerPkgName, null, null, null, null);
    }

    public static SignInConfiguration zzbC(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        SignInConfiguration signInConfiguration = new SignInConfiguration(jSONObject.getString("consumerPackageName"));
        Object optString = jSONObject.optString("serverClientId");
        if (!TextUtils.isEmpty(optString)) {
            signInConfiguration.zzbD(optString);
        }
        optString = jSONObject.optString("emailSignInOptions");
        if (!TextUtils.isEmpty(optString)) {
            signInConfiguration.zza(EmailSignInOptions.zzbr(optString));
        }
        optString = jSONObject.optString("googleSignInOptions");
        if (!TextUtils.isEmpty(optString)) {
            signInConfiguration.zzi(GoogleSignInOptions.zzbu(optString));
        }
        Object optString2 = jSONObject.optString("apiKey");
        if (TextUtils.isEmpty(optString2)) {
            return signInConfiguration;
        }
        signInConfiguration.zzbE(optString2);
        return signInConfiguration;
    }

    private JSONObject zzkv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consumerPackageName", this.zzZB);
            if (!TextUtils.isEmpty(this.zzYM)) {
                jSONObject.put("serverClientId", this.zzYM);
            }
            if (this.zzZC != null) {
                jSONObject.put("emailSignInOptions", this.zzZC.zzku());
            }
            if (this.zzZD != null) {
                jSONObject.put("googleSignInOptions", this.zzZD.zzku());
            }
            if (!TextUtils.isEmpty(this.zzZE)) {
                jSONObject.put("apiKey", this.zzZE);
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
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (!this.zzZB.equals(signInConfiguration.zzkT())) {
                return false;
            }
            if (TextUtils.isEmpty(this.zzYM)) {
                if (!TextUtils.isEmpty(signInConfiguration.zzkC())) {
                    return false;
                }
            } else if (!this.zzYM.equals(signInConfiguration.zzkC())) {
                return false;
            }
            if (TextUtils.isEmpty(this.zzZE)) {
                if (!TextUtils.isEmpty(signInConfiguration.zzkW())) {
                    return false;
                }
            } else if (!this.zzZE.equals(signInConfiguration.zzkW())) {
                return false;
            }
            if (this.zzZC == null) {
                if (signInConfiguration.zzkU() != null) {
                    return false;
                }
            } else if (!this.zzZC.equals(signInConfiguration.zzkU())) {
                return false;
            }
            if (this.zzZD == null) {
                if (signInConfiguration.zzkV() != null) {
                    return false;
                }
            } else if (!this.zzZD.equals(signInConfiguration.zzkV())) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return new zzg().zzs(this.zzZB).zzs(this.zzYM).zzs(this.zzZE).zzs(this.zzZC).zzs(this.zzZD).zzkM();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzr.zza(this, out, flags);
    }

    public SignInConfiguration zza(EmailSignInOptions emailSignInOptions) {
        this.zzZC = (EmailSignInOptions) zzx.zzb((Object) emailSignInOptions, (Object) "EmailSignInOptions cannot be null.");
        return this;
    }

    public SignInConfiguration zzbD(String str) {
        this.zzYM = zzx.zzi(str, "Server client id cannot be empty.");
        return this;
    }

    public SignInConfiguration zzbE(String str) {
        this.zzZE = str;
        return this;
    }

    public SignInConfiguration zzi(GoogleSignInOptions googleSignInOptions) {
        this.zzZD = (GoogleSignInOptions) zzx.zzb((Object) googleSignInOptions, (Object) "GoogleSignInOptions cannot be null.");
        return this;
    }

    public String zzkC() {
        return this.zzYM;
    }

    public String zzkT() {
        return this.zzZB;
    }

    public EmailSignInOptions zzkU() {
        return this.zzZC;
    }

    public GoogleSignInOptions zzkV() {
        return this.zzZD;
    }

    public String zzkW() {
        return this.zzZE;
    }

    public String zzku() {
        return zzkv().toString();
    }
}

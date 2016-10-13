package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInAccount implements SafeParcelable {
    public static final Creator<SignInAccount> CREATOR = new zze();
    final int versionCode;
    private String zzVA;
    private String zzXU;
    private String zzYA;
    private Uri zzYB;
    private String zzYQ;
    private GoogleSignInAccount zzYT;
    private String zzYU;
    private String zzsk;

    SignInAccount(int versionCode, String providerId, String idToken, String email, String displayName, Uri photoUrl, GoogleSignInAccount googleSignInAccount, String userId, String refreshToken) {
        this.versionCode = versionCode;
        this.zzYA = zzx.zzi(email, "Email cannot be empty.");
        this.zzVA = displayName;
        this.zzYB = photoUrl;
        this.zzYQ = providerId;
        this.zzXU = idToken;
        this.zzYT = googleSignInAccount;
        this.zzsk = zzx.zzcL(userId);
        this.zzYU = refreshToken;
    }

    public static SignInAccount zza(IdProvider idProvider, String str, String str2, String str3, Uri uri, String str4, String str5) {
        String str6 = null;
        if (idProvider != null) {
            str6 = idProvider.getProviderId();
        }
        return new SignInAccount(2, str6, str, str2, str3, uri, null, str4, str5);
    }

    public static SignInAccount zzbw(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        return zza(IdProvider.fromProviderId(jSONObject.optString("providerId", null)), jSONObject.optString("tokenId", null), jSONObject.getString("email"), jSONObject.optString("displayName", null), !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null, jSONObject.getString("localId"), jSONObject.optString("refreshToken")).zza(GoogleSignInAccount.zzbs(jSONObject.optString("googleSignInAccount")));
    }

    private JSONObject zzkv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("email", getEmail());
            if (!TextUtils.isEmpty(this.zzVA)) {
                jSONObject.put("displayName", this.zzVA);
            }
            if (this.zzYB != null) {
                jSONObject.put("photoUrl", this.zzYB.toString());
            }
            if (!TextUtils.isEmpty(this.zzYQ)) {
                jSONObject.put("providerId", this.zzYQ);
            }
            if (!TextUtils.isEmpty(this.zzXU)) {
                jSONObject.put("tokenId", this.zzXU);
            }
            if (this.zzYT != null) {
                jSONObject.put("googleSignInAccount", this.zzYT.zzku());
            }
            if (!TextUtils.isEmpty(this.zzYU)) {
                jSONObject.put("refreshToken", this.zzYU);
            }
            jSONObject.put("localId", getUserId());
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getDisplayName() {
        return this.zzVA;
    }

    public String getEmail() {
        return this.zzYA;
    }

    public IdProvider getIdProvider() {
        return IdProvider.fromProviderId(this.zzYQ);
    }

    public String getIdToken() {
        return this.zzXU;
    }

    public Uri getPhotoUrl() {
        return this.zzYB;
    }

    String getProviderId() {
        return this.zzYQ;
    }

    public String getUserId() {
        return this.zzsk;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }

    public SignInAccount zza(GoogleSignInAccount googleSignInAccount) {
        this.zzYT = googleSignInAccount;
        return this;
    }

    public SignInAccount zzbx(String str) {
        this.zzYU = zzx.zzcL(str);
        return this;
    }

    public GoogleSignInAccount zzkE() {
        return this.zzYT;
    }

    public String zzkF() {
        return this.zzYU;
    }

    public String zzku() {
        return zzkv().toString();
    }
}

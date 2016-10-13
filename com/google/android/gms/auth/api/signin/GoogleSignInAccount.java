package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.zzg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount implements SafeParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new zzc();
    private static Comparator<Scope> zzYF = new C01701();
    public static Clock zzYz = zzg.zzsh();
    final int versionCode;
    private String zzVA;
    private String zzXU;
    List<Scope> zzXb;
    private String zzYA;
    private Uri zzYB;
    private String zzYC;
    private long zzYD;
    private String zzYE;
    private String zzyU;

    static class C01701 implements Comparator<Scope> {
        C01701() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((Scope) obj, (Scope) obj2);
        }

        public int zza(Scope scope, Scope scope2) {
            return scope.zzpq().compareTo(scope2.zzpq());
        }
    }

    GoogleSignInAccount(int versionCode, String id, String idToken, String email, String displayName, Uri photoUrl, String serverAuthCode, long expirationTimeSecs, String obfuscatedIdentifier, List<Scope> grantedScopes) {
        this.versionCode = versionCode;
        this.zzyU = id;
        this.zzXU = idToken;
        this.zzYA = email;
        this.zzVA = displayName;
        this.zzYB = photoUrl;
        this.zzYC = serverAuthCode;
        this.zzYD = expirationTimeSecs;
        this.zzYE = obfuscatedIdentifier;
        this.zzXb = grantedScopes;
    }

    public static GoogleSignInAccount zza(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Uri uri, @Nullable Long l, @NonNull String str5, @NonNull Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(zzYz.currentTimeMillis() / 1000);
        }
        return new GoogleSignInAccount(2, str, str2, str3, str4, uri, null, l.longValue(), zzx.zzcL(str5), new ArrayList((Collection) zzx.zzD(set)));
    }

    @Nullable
    public static GoogleSignInAccount zzbs(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return zza(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).zzbt(jSONObject.optString("serverAuthCode", null));
    }

    private JSONObject zzkv() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zzYD);
            jSONObject.put("obfuscatedIdentifier", zzkx());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzXb, zzYF);
            for (Scope zzpq : this.zzXb) {
                jSONArray.put(zzpq.zzpq());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).zzku().equals(zzku());
    }

    @Nullable
    public String getDisplayName() {
        return this.zzVA;
    }

    @Nullable
    public String getEmail() {
        return this.zzYA;
    }

    @NonNull
    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.zzXb);
    }

    @Nullable
    public String getId() {
        return this.zzyU;
    }

    @Nullable
    public String getIdToken() {
        return this.zzXU;
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.zzYB;
    }

    @Nullable
    public String getServerAuthCode() {
        return this.zzYC;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }

    public boolean zzb() {
        return zzYz.currentTimeMillis() / 1000 >= this.zzYD - 300;
    }

    public GoogleSignInAccount zzbt(String str) {
        this.zzYC = str;
        return this;
    }

    public String zzku() {
        return zzkv().toString();
    }

    public long zzkw() {
        return this.zzYD;
    }

    @NonNull
    public String zzkx() {
        return this.zzYE;
    }

    public String zzky() {
        JSONObject zzkv = zzkv();
        zzkv.remove("serverAuthCode");
        return zzkv.toString();
    }
}

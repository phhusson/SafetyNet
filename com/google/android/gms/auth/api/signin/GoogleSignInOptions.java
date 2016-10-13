package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions implements Optional, SafeParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR = new zzd();
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    private static Comparator<Scope> zzYF = new C01711();
    public static final Scope zzYG = new Scope(Scopes.PROFILE);
    public static final Scope zzYH = new Scope("email");
    public static final Scope zzYI = new Scope("openid");
    final int versionCode;
    private Account zzSX;
    private boolean zzYJ;
    private final boolean zzYK;
    private final boolean zzYL;
    private String zzYM;
    private String zzYN;
    private final ArrayList<Scope> zzYy;

    static class C01711 implements Comparator<Scope> {
        C01711() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((Scope) obj, (Scope) obj2);
        }

        public int zza(Scope scope, Scope scope2) {
            return scope.zzpq().compareTo(scope2.zzpq());
        }
    }

    public static final class Builder {
        private Account zzSX;
        private boolean zzYJ;
        private boolean zzYK;
        private boolean zzYL;
        private String zzYM;
        private String zzYN;
        private Set<Scope> zzYO = new HashSet();

        public Builder(@NonNull GoogleSignInOptions googleSignInOptions) {
            zzx.zzD(googleSignInOptions);
            this.zzYO = new HashSet(googleSignInOptions.zzYy);
            this.zzYK = googleSignInOptions.zzYK;
            this.zzYL = googleSignInOptions.zzYL;
            this.zzYJ = googleSignInOptions.zzYJ;
            this.zzYM = googleSignInOptions.zzYM;
            this.zzSX = googleSignInOptions.zzSX;
            this.zzYN = googleSignInOptions.zzYN;
        }

        private String zzbv(String str) {
            zzx.zzcL(str);
            boolean z = this.zzYM == null || this.zzYM.equals(str);
            zzx.zzb(z, (Object) "two different server client ids provided");
            return str;
        }

        public GoogleSignInOptions build() {
            if (this.zzYJ && (this.zzSX == null || !this.zzYO.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(this.zzYO, this.zzSX, this.zzYJ, this.zzYK, this.zzYL, this.zzYM, this.zzYN);
        }

        public Builder requestEmail() {
            this.zzYO.add(GoogleSignInOptions.zzYH);
            return this;
        }

        public Builder requestId() {
            this.zzYO.add(GoogleSignInOptions.zzYI);
            return this;
        }

        public Builder requestIdToken(String serverClientId) {
            this.zzYJ = true;
            this.zzYM = zzbv(serverClientId);
            return this;
        }

        public Builder requestProfile() {
            this.zzYO.add(GoogleSignInOptions.zzYG);
            return this;
        }

        public Builder requestScopes(Scope scope, Scope... scopes) {
            this.zzYO.add(scope);
            this.zzYO.addAll(Arrays.asList(scopes));
            return this;
        }

        public Builder requestServerAuthCode(String serverClientId) {
            return requestServerAuthCode(serverClientId, false);
        }

        public Builder requestServerAuthCode(String serverClientId, boolean forceCodeForRefreshToken) {
            this.zzYK = true;
            this.zzYM = zzbv(serverClientId);
            this.zzYL = forceCodeForRefreshToken;
            return this;
        }

        public Builder setAccount(Account account) {
            this.zzSX = (Account) zzx.zzD(account);
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.zzSX = new Account(zzx.zzcL(accountName), "com.google");
            return this;
        }

        public Builder setHostedDomain(String hostedDomain) {
            this.zzYN = zzx.zzcL(hostedDomain);
            return this;
        }
    }

    GoogleSignInOptions(int versionCode, ArrayList<Scope> scopes, Account account, boolean idTokenRequested, boolean serverAuthCodeRequested, boolean forceCodeForRefreshToken, String serverClientId, String hostedDomain) {
        this.versionCode = versionCode;
        this.zzYy = scopes;
        this.zzSX = account;
        this.zzYJ = idTokenRequested;
        this.zzYK = serverAuthCodeRequested;
        this.zzYL = forceCodeForRefreshToken;
        this.zzYM = serverClientId;
        this.zzYN = hostedDomain;
    }

    private GoogleSignInOptions(Set<Scope> scopes, Account account, boolean idTokenRequested, boolean serverAuthCodeRequested, boolean forceCodeForRefreshToken, String serverClientId, String hostedDomain) {
        this(2, new ArrayList(scopes), account, idTokenRequested, serverAuthCodeRequested, forceCodeForRefreshToken, serverClientId, hostedDomain);
    }

    @Nullable
    public static GoogleSignInOptions zzbu(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        Object optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(hashSet, !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null));
    }

    private JSONObject zzkv() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzYy, zzYF);
            Iterator it = this.zzYy.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Scope) it.next()).zzpq());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.zzSX != null) {
                jSONObject.put("accountName", this.zzSX.name);
            }
            jSONObject.put("idTokenRequested", this.zzYJ);
            jSONObject.put("forceCodeForRefreshToken", this.zzYL);
            jSONObject.put("serverAuthRequested", this.zzYK);
            if (!TextUtils.isEmpty(this.zzYM)) {
                jSONObject.put("serverClientId", this.zzYM);
            }
            if (!TextUtils.isEmpty(this.zzYN)) {
                jSONObject.put("hostedDomain", this.zzYN);
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
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.zzYy.size() != googleSignInOptions.getScopes().size() || !this.zzYy.containsAll(googleSignInOptions.getScopes())) {
                return false;
            }
            if (this.zzSX == null) {
                if (googleSignInOptions.getAccount() != null) {
                    return false;
                }
            } else if (!this.zzSX.equals(googleSignInOptions.getAccount())) {
                return false;
            }
            if (TextUtils.isEmpty(this.zzYM)) {
                if (!TextUtils.isEmpty(googleSignInOptions.zzkC())) {
                    return false;
                }
            } else if (!this.zzYM.equals(googleSignInOptions.zzkC())) {
                return false;
            }
            return this.zzYL == googleSignInOptions.zzkB() && this.zzYJ == googleSignInOptions.zzkz() && this.zzYK == googleSignInOptions.zzkA();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public Account getAccount() {
        return this.zzSX;
    }

    public Scope[] getScopeArray() {
        return (Scope[]) this.zzYy.toArray(new Scope[this.zzYy.size()]);
    }

    public ArrayList<Scope> getScopes() {
        return new ArrayList(this.zzYy);
    }

    public int hashCode() {
        List arrayList = new ArrayList();
        Iterator it = this.zzYy.iterator();
        while (it.hasNext()) {
            arrayList.add(((Scope) it.next()).zzpq());
        }
        Collections.sort(arrayList);
        return new zzg().zzs(arrayList).zzs(this.zzSX).zzs(this.zzYM).zzI(this.zzYL).zzI(this.zzYJ).zzI(this.zzYK).zzkM();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }

    public boolean zzkA() {
        return this.zzYK;
    }

    public boolean zzkB() {
        return this.zzYL;
    }

    public String zzkC() {
        return this.zzYM;
    }

    public String zzkD() {
        return this.zzYN;
    }

    public String zzku() {
        return zzkv().toString();
    }

    public boolean zzkz() {
        return this.zzYJ;
    }
}

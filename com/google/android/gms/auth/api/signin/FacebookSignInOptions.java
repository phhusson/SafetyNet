package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;

public class FacebookSignInOptions implements SafeParcelable {
    public static final Creator<FacebookSignInOptions> CREATOR = new zzb();
    private Intent mIntent;
    final int versionCode;
    private final ArrayList<String> zzYy;

    public FacebookSignInOptions() {
        this(1, null, new ArrayList());
    }

    FacebookSignInOptions(int versionCode, Intent intent, ArrayList<String> scopes) {
        this.versionCode = versionCode;
        this.mIntent = intent;
        this.zzYy = scopes;
    }

    public FacebookSignInOptions addScope(String scope) {
        if (!(TextUtils.isEmpty(scope) || this.zzYy.contains(scope))) {
            this.zzYy.add(scope);
        }
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            FacebookSignInOptions facebookSignInOptions = (FacebookSignInOptions) obj;
            return this.zzYy.size() == facebookSignInOptions.getScopes().size() && this.zzYy.containsAll(facebookSignInOptions.getScopes());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public Intent getCustomFacebookSignInActivityIntent() {
        return this.mIntent;
    }

    public ArrayList<String> getScopes() {
        return new ArrayList(this.zzYy);
    }

    public int hashCode() {
        Collections.sort(this.zzYy);
        return this.zzYy.hashCode();
    }

    public FacebookSignInOptions setCustomFacebookSignInActivityIntent(Intent intent) {
        this.mIntent = (Intent) zzx.zzb((Object) intent, (Object) "Intent cannot be null");
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}

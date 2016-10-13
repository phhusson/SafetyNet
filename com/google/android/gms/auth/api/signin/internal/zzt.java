package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzt {
    private static final Lock zzZQ = new ReentrantLock();
    private static zzt zzZR;
    private final Lock zzZS = new ReentrantLock();
    private final SharedPreferences zzZT;

    zzt(Context context) {
        this.zzZT = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static zzt zzag(Context context) {
        zzx.zzD(context);
        zzZQ.lock();
        try {
            if (zzZR == null) {
                zzZR = new zzt(context.getApplicationContext());
            }
            zzt com_google_android_gms_auth_api_signin_internal_zzt = zzZR;
            return com_google_android_gms_auth_api_signin_internal_zzt;
        } finally {
            zzZQ.unlock();
        }
    }

    private String zzy(String str, String str2) {
        return str + ":" + str2;
    }

    void zza(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.zzD(googleSignInAccount);
        zzx.zzD(googleSignInOptions);
        String zzkx = googleSignInAccount.zzkx();
        zzx(zzy("googleSignInAccount", zzkx), googleSignInAccount.zzky());
        zzx(zzy("googleSignInOptions", zzkx), googleSignInOptions.zzku());
    }

    void zza(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.zzD(signInAccount);
        zzx.zzD(signInConfiguration);
        String userId = signInAccount.getUserId();
        SignInAccount zzbH = zzbH(userId);
        if (!(zzbH == null || zzbH.zzkE() == null)) {
            zzbM(zzbH.zzkE().zzkx());
        }
        zzx(zzy("signInConfiguration", userId), signInConfiguration.zzku());
        zzx(zzy("signInAccount", userId), signInAccount.zzku());
        if (signInAccount.zzkE() != null) {
            zza(signInAccount.zzkE(), signInConfiguration.zzkV());
        }
    }

    public void zzb(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.zzD(googleSignInAccount);
        zzx.zzD(googleSignInOptions);
        zzx("defaultGoogleSignInAccount", googleSignInAccount.zzkx());
        zza(googleSignInAccount, googleSignInOptions);
    }

    public void zzb(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.zzD(signInAccount);
        zzx.zzD(signInConfiguration);
        zzlb();
        zzx("defaultSignInAccount", signInAccount.getUserId());
        if (signInAccount.zzkE() != null) {
            zzx("defaultGoogleSignInAccount", signInAccount.zzkE().zzkx());
        }
        zza(signInAccount, signInConfiguration);
    }

    SignInConfiguration zzbG(String str) {
        SignInConfiguration signInConfiguration = null;
        if (!TextUtils.isEmpty(str)) {
            Object zzbK = zzbK(zzy("signInConfiguration", str));
            if (!TextUtils.isEmpty(zzbK)) {
                try {
                    signInConfiguration = SignInConfiguration.zzbC(zzbK);
                } catch (JSONException e) {
                }
            }
        }
        return signInConfiguration;
    }

    SignInAccount zzbH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object zzbK = zzbK(zzy("signInAccount", str));
        if (TextUtils.isEmpty(zzbK)) {
            return null;
        }
        try {
            SignInAccount zzbw = SignInAccount.zzbw(zzbK);
            if (zzbw.zzkE() != null) {
                GoogleSignInAccount zzbI = zzbI(zzbw.zzkE().zzkx());
                if (zzbI != null) {
                    zzbw.zza(zzbI);
                }
            }
            return zzbw;
        } catch (JSONException e) {
            return null;
        }
    }

    GoogleSignInAccount zzbI(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String zzbK = zzbK(zzy("googleSignInAccount", str));
            if (zzbK != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.zzbs(zzbK);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    GoogleSignInOptions zzbJ(String str) {
        GoogleSignInOptions googleSignInOptions = null;
        if (!TextUtils.isEmpty(str)) {
            String zzbK = zzbK(zzy("googleSignInOptions", str));
            if (zzbK != null) {
                try {
                    googleSignInOptions = GoogleSignInOptions.zzbu(zzbK);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInOptions;
    }

    protected String zzbK(String str) {
        this.zzZS.lock();
        try {
            String string = this.zzZT.getString(str, null);
            return string;
        } finally {
            this.zzZS.unlock();
        }
    }

    void zzbL(String str) {
        if (!TextUtils.isEmpty(str)) {
            SignInAccount zzbH = zzbH(str);
            zzbN(zzy("signInAccount", str));
            zzbN(zzy("signInConfiguration", str));
            if (zzbH != null && zzbH.zzkE() != null) {
                zzbM(zzbH.zzkE().zzkx());
            }
        }
    }

    void zzbM(String str) {
        if (!TextUtils.isEmpty(str)) {
            zzbN(zzy("googleSignInAccount", str));
            zzbN(zzy("googleSignInOptions", str));
        }
    }

    protected void zzbN(String str) {
        this.zzZS.lock();
        try {
            this.zzZT.edit().remove(str).apply();
        } finally {
            this.zzZS.unlock();
        }
    }

    public SignInConfiguration zzkX() {
        return zzbG(zzbK("defaultSignInAccount"));
    }

    public SignInAccount zzkY() {
        return zzbH(zzbK("defaultSignInAccount"));
    }

    public GoogleSignInAccount zzkZ() {
        return zzbI(zzbK("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions zzla() {
        return zzbJ(zzbK("defaultGoogleSignInAccount"));
    }

    public void zzlb() {
        String zzbK = zzbK("defaultSignInAccount");
        zzbN("defaultSignInAccount");
        zzlc();
        zzbL(zzbK);
    }

    public void zzlc() {
        String zzbK = zzbK("defaultGoogleSignInAccount");
        zzbN("defaultGoogleSignInAccount");
        zzbM(zzbK);
    }

    protected void zzx(String str, String str2) {
        this.zzZS.lock();
        try {
            this.zzZT.edit().putString(str, str2).apply();
        } finally {
            this.zzZS.unlock();
        }
    }
}

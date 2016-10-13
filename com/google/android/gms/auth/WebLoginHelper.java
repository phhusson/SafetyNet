package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Context;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.CookieManager;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlw;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zzly;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WebLoginHelper {
    private final Context mContext;
    private final zza zzXc;
    private final CookieManager zzXd;

    public static class RecoverableException extends Exception {
        private final String zzXe;

        private RecoverableException(String recoveryUrl) {
            this.zzXe = recoveryUrl;
        }

        public String getRecoveryUrl() {
            return this.zzXe;
        }
    }

    static class zza {
        zza() {
        }

        public zzlx zza(Context context, Account account, String str) throws IOException, GoogleAuthException {
            try {
                return zzlx.zzh(Base64.decode(GoogleAuthUtilLight.getToken(context, account, str), 9));
            } catch (Throwable e) {
                throw new GoogleAuthException("Couldn't read data from server.", e);
            }
        }
    }

    public WebLoginHelper(Context context) {
        this(context, new zza(), CookieManager.getInstance());
    }

    WebLoginHelper(Context context, zza webLoginGetter, CookieManager cookieManager) {
        this.mContext = context;
        this.zzXc = webLoginGetter;
        this.zzXd = cookieManager;
    }

    static String zza(zzlw com_google_android_gms_internal_zzlw) {
        StringBuilder append = new StringBuilder(com_google_android_gms_internal_zzlw.name).append('=');
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzlw.value)) {
            append.append(com_google_android_gms_internal_zzlw.value);
        }
        if (zzc(com_google_android_gms_internal_zzlw.zzacS)) {
            append.append(";HttpOnly");
        }
        if (zzc(com_google_android_gms_internal_zzlw.zzacR)) {
            append.append(";Secure");
        }
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzlw.zzacP)) {
            append.append(";Domain=").append(com_google_android_gms_internal_zzlw.zzacP);
        }
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzlw.path)) {
            append.append(";Path=").append(com_google_android_gms_internal_zzlw.path);
        }
        if (com_google_android_gms_internal_zzlw.zzacT != null && com_google_android_gms_internal_zzlw.zzacT.intValue() > 0) {
            append.append(";Max-Age=").append(com_google_android_gms_internal_zzlw.zzacT);
        }
        return append.toString();
    }

    private void zza(zzlx com_google_android_gms_internal_zzlx) throws RecoverableException, IOException, GoogleAuthException {
        if (com_google_android_gms_internal_zzlx == null || com_google_android_gms_internal_zzlx.zzacV == null) {
            throw new GoogleAuthException("Invalid response.");
        }
        zzly com_google_android_gms_internal_zzly = com_google_android_gms_internal_zzlx.zzacV;
        switch (com_google_android_gms_internal_zzly.zzacW.intValue()) {
            case 1:
                zza(com_google_android_gms_internal_zzly.zzacX);
                return;
            case 2:
                throw new IOException("Request failed, but server said RETRY.");
            case 5:
                zza(com_google_android_gms_internal_zzly.zzacX);
                zza(com_google_android_gms_internal_zzly.zzacZ);
                return;
            default:
                Log.w("WebLoginHelper", "Unexpected response: " + com_google_android_gms_internal_zzly);
                throw new GoogleAuthException("Unknown response status: " + com_google_android_gms_internal_zzly.zzacW);
        }
    }

    private void zza(zzlw[] com_google_android_gms_internal_zzlwArr) {
        for (zzlw com_google_android_gms_internal_zzlw : com_google_android_gms_internal_zzlwArr) {
            Object obj = !TextUtils.isEmpty(com_google_android_gms_internal_zzlw.zzacQ) ? com_google_android_gms_internal_zzlw.zzacQ : com_google_android_gms_internal_zzlw.zzacP;
            if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(com_google_android_gms_internal_zzlw.name) || TextUtils.isEmpty(com_google_android_gms_internal_zzlw.value)) {
                Log.w("WebLoginHelper", "Invalid cookie.");
            } else {
                String str = (zzc(com_google_android_gms_internal_zzlw.zzacR) ? "https" : "http") + "://" + obj;
                String zza = zza(com_google_android_gms_internal_zzlw);
                Log.d("WebLoginHelper", "Setting cookie for url: " + str);
                this.zzXd.setCookie(str, zza);
            }
        }
    }

    private void zza(com.google.android.gms.internal.zzly.zza[] com_google_android_gms_internal_zzly_zzaArr) throws RecoverableException, GoogleAuthException {
        for (com.google.android.gms.internal.zzly.zza com_google_android_gms_internal_zzly_zza : com_google_android_gms_internal_zzly_zzaArr) {
            switch (com_google_android_gms_internal_zzly_zza.zzacW.intValue()) {
                case 1:
                case 3:
                    break;
                case 2:
                    throw new RecoverableException(com_google_android_gms_internal_zzly_zza.url);
                default:
                    Log.w("WebLoginHelper", "Unrecognized failed account status: " + com_google_android_gms_internal_zzly_zza.zzacW);
                    break;
            }
        }
        throw new GoogleAuthException("Authorization failed, but no recoverable accounts.");
    }

    static String zzb(String... strArr) {
        Builder builder = new Builder();
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                URL url = new URL(str);
                builder.appendQueryParameter("url", url.getProtocol() + "://" + url.getHost());
                i++;
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException("Invalid URL: " + str);
            }
        }
        return "weblogin:" + builder.build().getQuery();
    }

    private static boolean zzc(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public void getAndSetCookies(Account account, String... urls) throws RecoverableException, IOException, GoogleAuthException {
        zzx.zzD(account);
        boolean z = urls != null && urls.length > 0;
        zzx.zzb(z, (Object) "Must have at least one URL.");
        zza(this.zzXc.zza(this.mContext, account, zzb(urls)));
    }
}

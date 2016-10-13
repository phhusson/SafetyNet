package com.google.android.gms.people.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import java.util.regex.Pattern;

public class zzm {
    public static final zzm zzbEa = new zzm();
    private Pattern[] zzbEb = new Pattern[0];
    private String[] zzbEc = new String[0];

    private zzm() {
    }

    public void zzT(Bundle bundle) {
        zza(bundle.getStringArray("config.url_uncompress.patterns"), bundle.getStringArray("config.url_uncompress.replacements"));
    }

    public synchronized void zza(String[] strArr, String[] strArr2) {
        int i = 0;
        synchronized (this) {
            zzx.zzae(strArr.length == strArr2.length);
            this.zzbEb = new Pattern[strArr.length];
            this.zzbEc = strArr2;
            while (i < strArr.length) {
                this.zzbEb[i] = Pattern.compile(strArr[i]);
                i++;
            }
        }
    }

    public synchronized String zzhM(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            int i = 0;
            str2 = str;
            while (i < this.zzbEb.length) {
                str = this.zzbEb[i].matcher(str2).replaceAll(this.zzbEc[i]);
                i++;
                str2 = str;
            }
        }
        return str2;
    }
}

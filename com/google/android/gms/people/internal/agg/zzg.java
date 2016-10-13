package com.google.android.gms.people.internal.agg;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.people.internal.zzp;
import com.google.android.gms.people.model.PhoneNumber;

public class zzg implements PhoneNumber {
    private final String mValue;
    private final String zzKj;
    private String zzbGm;

    public zzg(String str, String str2) {
        this.zzKj = str;
        this.mValue = str2;
    }

    private String zzJU() {
        if (this.zzbGm == null) {
            this.zzbGm = zzig(this.mValue);
        }
        return this.zzbGm;
    }

    static String zzig(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder zzJz = zzp.zzJz();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.digit(charAt, 10) != -1 || charAt == '+' || charAt == ',' || charAt == ';' || (('a' <= charAt && charAt <= 'z') || ('A' <= charAt && charAt <= 'Z'))) {
                zzJz.append(charAt);
            }
        }
        return zzJz.toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof zzg)) {
            return false;
        }
        return zzw.equal(zzJU(), ((zzg) object).zzJU());
    }

    public String getType() {
        return this.zzKj;
    }

    public String getValue() {
        return this.mValue;
    }

    public String toString() {
        return "PhoneNumber:[Value=" + (this.mValue != null ? this.mValue : "null") + " Type=" + (this.zzKj != null ? this.zzKj : "null") + "]";
    }
}

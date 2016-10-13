package com.google.android.gms.people.internal;

import android.text.TextUtils;

public class zzs {
    private final StringBuilder zzbFd = new StringBuilder();
    private boolean zzbFe = false;

    public String toString() {
        return this.zzbFd.toString();
    }

    public void zzhX(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.zzbFd.append(str);
        }
    }

    public void zzhY(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.zzbFe) {
                this.zzbFd.append(" AND ");
            }
            this.zzbFd.append(str);
            this.zzbFe = true;
        }
    }
}

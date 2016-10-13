package com.google.android.gms.people.internal.agg;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.people.model.EmailAddress;
import com.google.android.snet.Csv;

public class zzc implements EmailAddress {
    private final String mValue;
    private final String zzKj;
    private final double zzbFF;
    private final double zzbFG;
    private final double zzbFH;
    private final double zzbFI;
    private final double zzbFJ;
    private final String zzbFK;
    private final String zzbFL;
    private final String zzbFM;
    private final String zzbFN;
    private final String zzbFO;

    public zzc(String str, String str2) {
        this(str, str2, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, null, null, null, null, null);
    }

    public zzc(String str, String str2, double d, double d2, double d3, double d4, double d5, String str3, String str4, String str5, String str6, String str7) {
        this.zzKj = str;
        this.mValue = str2;
        this.zzbFF = d;
        this.zzbFG = d2;
        this.zzbFH = d3;
        this.zzbFI = d4;
        this.zzbFJ = d5;
        this.zzbFK = str3;
        this.zzbFL = str4;
        this.zzbFM = str5;
        this.zzbFN = str6;
        this.zzbFO = str7;
    }

    public boolean equals(Object object) {
        if (!(object instanceof zzc)) {
            return false;
        }
        return zzw.equal(this.mValue, ((zzc) object).mValue);
    }

    public double getAffinity1() {
        return this.zzbFF;
    }

    public double getAffinity2() {
        return this.zzbFG;
    }

    public double getAffinity3() {
        return this.zzbFH;
    }

    public double getAffinity4() {
        return this.zzbFI;
    }

    public double getAffinity5() {
        return this.zzbFJ;
    }

    public String getLoggingId1() {
        return this.zzbFK;
    }

    public String getLoggingId2() {
        return this.zzbFL;
    }

    public String getLoggingId3() {
        return this.zzbFM;
    }

    public String getLoggingId4() {
        return this.zzbFN;
    }

    public String getLoggingId5() {
        return this.zzbFO;
    }

    public String getType() {
        return this.zzKj;
    }

    public String getValue() {
        return this.mValue;
    }

    public String toString() {
        return "EmailAddress:[Value=" + (this.mValue != null ? this.mValue : "null") + " Type=" + (this.zzKj != null ? this.zzKj : "null") + " a1=" + this.zzbFF + Csv.COMMA + this.zzbFK + " a2=" + this.zzbFG + Csv.COMMA + this.zzbFL + " a3=" + this.zzbFH + Csv.COMMA + this.zzbFM + " a4=" + this.zzbFI + Csv.COMMA + this.zzbFN + " a5=" + this.zzbFJ + Csv.COMMA + this.zzbFO + "]";
    }
}

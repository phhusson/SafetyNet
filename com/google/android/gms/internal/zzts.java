package com.google.android.gms.internal;

public final class zzts {
    public String mimeType;
    public String zzbAR;
    public String zzbAS;
    public String zzbAu;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataKind<");
        stringBuilder.append(" resourcePackageName=").append(this.zzbAu);
        stringBuilder.append(" mimeType=").append(this.mimeType);
        stringBuilder.append(" summaryColumn=").append(this.zzbAR);
        stringBuilder.append(" detailColumn=").append(this.zzbAS);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}

package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class FACLConfig implements SafeParcelable {
    public static final FACLConfigCreator CREATOR = new FACLConfigCreator();
    final int version;
    boolean zzaci;
    String zzacj;
    boolean zzack;
    boolean zzacl;
    boolean zzacm;
    boolean zzacn;

    FACLConfig(int version, boolean isAllCirclesVisible, String visibleEdges, boolean isAllContactsVisible, boolean showCircles, boolean showContacts, boolean hasShowCircles) {
        this.version = version;
        this.zzaci = isAllCirclesVisible;
        this.zzacj = visibleEdges;
        this.zzack = isAllContactsVisible;
        this.zzacl = showCircles;
        this.zzacm = showContacts;
        this.zzacn = hasShowCircles;
    }

    public FACLConfig(boolean isAllCirclesVisible, String visibleEdges, boolean isAllContactsVisible, boolean showCircles, boolean showContacts, boolean hasShowCircles) {
        this.version = 1;
        this.zzaci = isAllCirclesVisible;
        if (isAllCirclesVisible) {
            this.zzacj = "";
        } else {
            this.zzacj = visibleEdges;
        }
        this.zzack = isAllContactsVisible;
        this.zzacl = showCircles;
        this.zzacm = showContacts;
        this.zzacn = hasShowCircles;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof FACLConfig)) {
            return false;
        }
        FACLConfig fACLConfig = (FACLConfig) o;
        return this.zzaci == fACLConfig.zzaci && TextUtils.equals(this.zzacj, fACLConfig.zzacj) && this.zzack == fACLConfig.zzack && this.zzacl == fACLConfig.zzacl && this.zzacm == fACLConfig.zzacm && this.zzacn == fACLConfig.zzacn;
    }

    public boolean getShowCircles() {
        return this.zzacl;
    }

    public boolean getShowContacts() {
        return this.zzacm;
    }

    public String getVisibleEdges() {
        return this.zzacj;
    }

    public boolean hasShowCircles() {
        return this.zzacn;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.zzaci), this.zzacj, Boolean.valueOf(this.zzack), Boolean.valueOf(this.zzacl), Boolean.valueOf(this.zzacm), Boolean.valueOf(this.zzacn));
    }

    public boolean isAllCirclesVisible() {
        return this.zzaci;
    }

    public boolean isAllContactsVisible() {
        return this.zzack;
    }

    public void writeToParcel(Parcel dest, int flags) {
        FACLConfigCreator.zza(this, dest, flags);
    }
}

package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class PACLConfig implements SafeParcelable {
    public static final PACLConfigCreator CREATOR = new PACLConfigCreator();
    final int version;
    String zzact;
    String zzacu;

    PACLConfig(int version, String visibleActions, String pacl) {
        this.version = version;
        this.zzact = visibleActions;
        this.zzacu = pacl;
    }

    public PACLConfig(String visibleActions, String pacl) {
        this.version = 1;
        this.zzact = visibleActions;
        this.zzacu = pacl;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof PACLConfig)) {
            return false;
        }
        PACLConfig pACLConfig = (PACLConfig) o;
        return TextUtils.equals(this.zzact, pACLConfig.zzact) && TextUtils.equals(this.zzacu, pACLConfig.zzacu);
    }

    public String getPacl() {
        return this.zzacu;
    }

    public String getVisibleActions() {
        return this.zzact;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzact, this.zzacu);
    }

    public void writeToParcel(Parcel dest, int flags) {
        PACLConfigCreator.zza(this, dest, flags);
    }
}

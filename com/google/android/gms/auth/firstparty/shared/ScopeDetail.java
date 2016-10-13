package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScopeDetail implements SafeParcelable {
    public static final ScopeDetailCreator CREATOR = new ScopeDetailCreator();
    String description;
    public FACLData friendPickerData;
    final int version;
    String zzaaj;
    String zzabq;
    String zzacw;
    String zzacx;
    List<String> zzacy;

    ScopeDetail(int version, String description, String detail, String iconBase64, String paclPickerDataBase64, String service, List<String> warnings, FACLData friendPickerData) {
        this.version = version;
        this.description = description;
        this.zzaaj = detail;
        this.zzacw = iconBase64;
        this.zzacx = paclPickerDataBase64;
        this.zzabq = service;
        this.zzacy = warnings;
        this.friendPickerData = friendPickerData;
    }

    public ScopeDetail(String service, String description, String detail, String iconBase64, String paclPickerDataBase64, FACLData faclData, List<String> warnings) {
        this.version = 1;
        this.zzabq = service;
        this.description = description;
        this.zzaaj = detail;
        this.zzacw = iconBase64;
        this.zzacx = paclPickerDataBase64;
        this.friendPickerData = faclData;
        this.zzacy = new ArrayList();
        this.zzacy.addAll(warnings);
    }

    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDetail() {
        return this.zzaaj;
    }

    public FACLData getFriendPickerData() {
        return this.friendPickerData;
    }

    public String getIconBase64() {
        return this.zzacw;
    }

    public String getPaclPickerBase64() {
        return this.zzacx;
    }

    public String getService() {
        return this.zzabq;
    }

    public List<String> getUnmodifiableWarnings() {
        return Collections.unmodifiableList(this.zzacy);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ScopeDetailCreator.zza(this, dest, flags);
    }
}

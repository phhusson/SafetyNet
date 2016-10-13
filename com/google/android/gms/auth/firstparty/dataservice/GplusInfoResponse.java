package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GplusInfoResponse implements SafeParcelable {
    public static final GplusInfoResponseCreator CREATOR = new GplusInfoResponseCreator();
    String firstName;
    String lastName;
    final int version;
    String zzabh;
    boolean zzabi;
    String zzabj;
    boolean zzabk;
    boolean zzabl;
    String zzabm;
    String zzabn;

    GplusInfoResponse(int version, boolean isAllowed, String firstName, String lastName, String picasaUserName, boolean isGooglePlusEnabled, boolean isEsMobileEnabled, String ropText, String ropRevision, String wireCode) {
        this.version = version;
        this.zzabi = isAllowed;
        this.firstName = firstName;
        this.lastName = lastName;
        this.zzabj = picasaUserName;
        this.zzabk = isGooglePlusEnabled;
        this.zzabl = isEsMobileEnabled;
        this.zzabm = ropText;
        this.zzabh = ropRevision;
        this.zzabn = wireCode;
    }

    public GplusInfoResponse(boolean isAllowed, String firstName, String lastName, String picasaUserName, boolean isGooglePlusEnabled, boolean isEsMobileEnabled, String ropText, String ropRevision, String wireCode) {
        this.version = 1;
        this.zzabi = isAllowed;
        this.firstName = firstName;
        this.lastName = lastName;
        this.zzabj = picasaUserName;
        this.zzabm = ropText;
        this.zzabh = ropRevision;
        this.zzabk = isGooglePlusEnabled;
        this.zzabl = isEsMobileEnabled;
        this.zzabn = wireCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPicasaUser() {
        return this.zzabj;
    }

    public String getRopRevision() {
        return this.zzabh;
    }

    public String getRopText() {
        return this.zzabm;
    }

    public String getWireCode() {
        return this.zzabn;
    }

    public boolean hasEsMobile() {
        return this.zzabl;
    }

    public boolean hasGooglePlus() {
        return this.zzabk;
    }

    public boolean isAllowed() {
        return this.zzabi;
    }

    public void writeToParcel(Parcel dest, int flags) {
        GplusInfoResponseCreator.zza(this, dest, flags);
    }
}

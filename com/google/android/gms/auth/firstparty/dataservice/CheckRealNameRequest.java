package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CheckRealNameRequest implements SafeParcelable {
    public static final CheckRealNameRequestCreator CREATOR = new CheckRealNameRequestCreator();
    AppDescription callingAppDescription;
    String firstName;
    String lastName;
    final int version;

    public CheckRealNameRequest() {
        this.version = 1;
    }

    CheckRealNameRequest(int version, AppDescription callingAppDescription, String firstName, String lastName) {
        this.version = version;
        this.callingAppDescription = callingAppDescription;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int describeContents() {
        return 0;
    }

    public AppDescription getCallingAppDescription() {
        return this.callingAppDescription;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public CheckRealNameRequest setCallingAppDescription(AppDescription appDescription) {
        this.callingAppDescription = appDescription;
        return this;
    }

    public CheckRealNameRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CheckRealNameRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        CheckRealNameRequestCreator.zza(this, dest, flags);
    }
}

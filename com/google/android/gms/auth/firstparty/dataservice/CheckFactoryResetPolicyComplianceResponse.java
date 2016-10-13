package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CheckFactoryResetPolicyComplianceResponse implements SafeParcelable {
    public static final CheckFactoryResetPolicyComplianceResponseCreator CREATOR = new CheckFactoryResetPolicyComplianceResponseCreator();
    public final boolean isCompliant;
    final int version;

    CheckFactoryResetPolicyComplianceResponse(int version, boolean isCompliant) {
        this.version = version;
        this.isCompliant = isCompliant;
    }

    public static CheckFactoryResetPolicyComplianceResponse from(boolean isCompliant) {
        return new CheckFactoryResetPolicyComplianceResponse(1, isCompliant);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        CheckFactoryResetPolicyComplianceResponseCreator.zza(this, dest, flags);
    }
}

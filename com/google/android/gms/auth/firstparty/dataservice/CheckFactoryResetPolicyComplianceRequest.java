package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CheckFactoryResetPolicyComplianceRequest implements SafeParcelable {
    public static final CheckFactoryResetPolicyComplianceRequestCreator CREATOR = new CheckFactoryResetPolicyComplianceRequestCreator();
    public final String accountId;
    final int version;

    CheckFactoryResetPolicyComplianceRequest(int version, String accountId) {
        this.version = version;
        this.accountId = accountId;
    }

    public static CheckFactoryResetPolicyComplianceRequest from(String accountId) {
        return new CheckFactoryResetPolicyComplianceRequest(1, accountId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        CheckFactoryResetPolicyComplianceRequestCreator.zza(this, dest, flags);
    }
}

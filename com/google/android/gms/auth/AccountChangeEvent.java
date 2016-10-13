package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class AccountChangeEvent implements SafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR = new zza();
    final long mId;
    final int mVersion;
    final String zzWD;
    final int zzWE;
    final int zzWF;
    final String zzWG;

    AccountChangeEvent(int version, long id, String accountName, int changeType, int eventIndex, String changeData) {
        this.mVersion = version;
        this.mId = id;
        this.zzWD = (String) zzx.zzD(accountName);
        this.zzWE = changeType;
        this.zzWF = eventIndex;
        this.zzWG = changeData;
    }

    public AccountChangeEvent(long id, String accountName, int changeType, int eventIndex, String changeData) {
        this.mVersion = 1;
        this.mId = id;
        this.zzWD = (String) zzx.zzD(accountName);
        this.zzWE = changeType;
        this.zzWF = eventIndex;
        this.zzWG = changeData;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        if (that == this) {
            return true;
        }
        if (!(that instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) that;
        return this.mVersion == accountChangeEvent.mVersion && this.mId == accountChangeEvent.mId && zzw.equal(this.zzWD, accountChangeEvent.zzWD) && this.zzWE == accountChangeEvent.zzWE && this.zzWF == accountChangeEvent.zzWF && zzw.equal(this.zzWG, accountChangeEvent.zzWG);
    }

    public String getAccountName() {
        return this.zzWD;
    }

    public String getChangeData() {
        return this.zzWG;
    }

    public int getChangeType() {
        return this.zzWE;
    }

    public int getEventIndex() {
        return this.zzWF;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersion), Long.valueOf(this.mId), this.zzWD, Integer.valueOf(this.zzWE), Integer.valueOf(this.zzWF), this.zzWG);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.zzWE) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.zzWD + ", changeType = " + str + ", changeData = " + this.zzWG + ", eventIndex = " + this.zzWF + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}

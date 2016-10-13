package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp.zza;
import java.util.Collection;

public class GetServiceRequest implements SafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new zzi();
    final int version;
    final int zzavX;
    int zzavY;
    String zzavZ;
    IBinder zzawa;
    Scope[] zzawb;
    Bundle zzawc;
    Account zzawd;

    public GetServiceRequest(int serviceId) {
        this.version = 2;
        this.zzavY = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzavX = serviceId;
    }

    GetServiceRequest(int version, int serviceId, int clientVersion, String callingPackage, IBinder accountAccessorBinder, Scope[] scopes, Bundle extraArgs, Account clientRequestedAccount) {
        this.version = version;
        this.zzavX = serviceId;
        this.zzavY = clientVersion;
        this.zzavZ = callingPackage;
        if (version < 2) {
            this.zzawd = zzcr(accountAccessorBinder);
        } else {
            this.zzawa = accountAccessorBinder;
            this.zzawd = clientRequestedAccount;
        }
        this.zzawb = scopes;
        this.zzawc = extraArgs;
    }

    private Account zzcr(IBinder iBinder) {
        return iBinder != null ? zza.zza(zza.zzcs(iBinder)) : null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    public GetServiceRequest zzb(Account account) {
        this.zzawd = account;
        return this;
    }

    public GetServiceRequest zzb(zzp com_google_android_gms_common_internal_zzp) {
        if (com_google_android_gms_common_internal_zzp != null) {
            this.zzawa = com_google_android_gms_common_internal_zzp.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzcF(String str) {
        this.zzavZ = str;
        return this;
    }

    public GetServiceRequest zzd(Collection<Scope> collection) {
        this.zzawb = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzp(Bundle bundle) {
        this.zzawc = bundle;
        return this;
    }
}

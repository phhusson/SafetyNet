package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class SupportLifecycleFragmentImpl extends zzaa {
    protected void zzb(int i, ConnectionResult connectionResult) {
        GooglePlayServicesUtil.showErrorDialogFragment(connectionResult.getErrorCode(), getActivity(), this, 2, this);
    }

    protected void zzc(int i, ConnectionResult connectionResult) {
        final Dialog zza = zzqi().zza(getActivity(), this);
        this.zzasT = zzn.zza(getActivity().getApplicationContext(), new zzn(this) {
            final /* synthetic */ SupportLifecycleFragmentImpl zzatb;

            protected void zzpX() {
                this.zzatb.zzqf();
                zza.dismiss();
            }
        });
    }

    protected /* synthetic */ GoogleApiAvailabilityLight zzqg() {
        return zzqi();
    }

    protected GoogleApiAvailability zzqi() {
        return GoogleApiAvailability.getInstance();
    }
}

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.people.Notifications;
import com.google.android.gms.people.Notifications.OnDataChanged;
import com.google.android.gms.people.People;
import com.google.android.gms.people.People.zzb;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.internal.zzn;
import com.google.android.gms.people.internal.zzn.zzw;

public class zzua implements Notifications {
    private PendingResult<Result> zza(GoogleApiClient googleApiClient, OnDataChanged onDataChanged, String str, String str2, int i) {
        final zzw zza = ((zzn) googleApiClient.zza(People.zzbzL)).zza(googleApiClient, onDataChanged);
        final String str3 = str;
        final String str4 = str2;
        final int i2 = i;
        return googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzua zzbHD;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza(zza, str3, str4, i2);
                zza(Status.zzaqL);
            }
        });
    }

    public PendingResult<Result> registerOnDataChangedListenerForAllOwners(GoogleApiClient googleApiClient, OnDataChanged listener, int scopes) {
        if (zzl.isEnabled()) {
            zzl.zzh("registerOnDataChangedListenerForAllOwners", Integer.valueOf(scopes));
        }
        return zza(googleApiClient, listener, null, null, scopes);
    }

    public PendingResult<Result> registerOnDataChangedListenerForOwner(GoogleApiClient googleApiClient, OnDataChanged listener, String account, String pageId, int scopes) {
        if (account == null) {
            throw new IllegalArgumentException("account must not be null");
        }
        if (zzl.isEnabled()) {
            zzl.zzh("registerOnDataChangedListenerForOwner", account, pageId, Integer.valueOf(scopes));
        }
        return zza(googleApiClient, listener, account, pageId, scopes);
    }

    public PendingResult<Result> unregisterOnDataChangedListener(GoogleApiClient googleApiClient, final OnDataChanged listener) {
        if (zzl.isEnabled()) {
            zzl.zzh("unregisterOnDataChangedListener", new Object[0]);
        }
        return googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzua zzbHD;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza(listener);
                zza(Status.zzaqL);
            }
        });
    }
}

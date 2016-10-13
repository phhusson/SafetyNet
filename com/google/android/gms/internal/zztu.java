package com.google.android.gms.internal;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.people.ContactsSync;
import com.google.android.gms.people.People.zza;
import com.google.android.gms.people.People.zzb;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.internal.zzn;

public class zztu implements ContactsSync {
    public PendingResult<BooleanResult> isSyncToContactsEnabled(GoogleApiClient googleApiClient) {
        if (zzl.isEnabled()) {
            zzl.zzh("isSyncToContactsEnabled", new Object[0]);
        }
        return googleApiClient.zza(new zza<BooleanResult>(this, googleApiClient) {
            final /* synthetic */ zztu zzbGr;

            protected BooleanResult zzT(Status status) {
                return new BooleanResult(status, false);
            }

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                zza(new BooleanResult(Status.zzaqL, com_google_android_gms_people_internal_zzn.isSyncToContactsEnabled()));
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzT(status);
            }
        });
    }

    public PendingResult<Result> setSyncToContactsEnabled(GoogleApiClient googleApiClient, final boolean enable) {
        if (zzl.isEnabled()) {
            zzl.zzh("setSyncToContactsEnabled", Boolean.valueOf(enable));
        }
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ zztu zzbGr;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zzaS(enable);
                zza(Status.zzaqL);
            }
        });
    }

    public PendingResult<Result> setSyncToContactsSettings(GoogleApiClient googleApiClient, String account, boolean enableForAccount, String[] syncTarget) {
        if (zzl.isEnabled()) {
            zzl.zzh("setSyncToContactsSettings", account, Boolean.valueOf(enableForAccount), syncTarget);
        }
        final String str = account;
        final boolean z = enableForAccount;
        final String[] strArr = syncTarget;
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ zztu zzbGr;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((com.google.android.gms.common.api.internal.zza.zzb) this, str, z, strArr);
            }
        });
    }

    public PendingResult<Result> syncRawContact(GoogleApiClient googleApiClient, final Uri rawContactUri) {
        if (zzl.isEnabled()) {
            zzl.zzh("syncRawContact", rawContactUri);
        }
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ zztu zzbGr;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zzq(rawContactUri);
                zza(Status.zzaqL);
            }
        });
    }
}

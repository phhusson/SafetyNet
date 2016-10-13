package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.people.InternalApi;
import com.google.android.gms.people.InternalApi.LoadPeopleForAspenOptions;
import com.google.android.gms.people.InternalApi.LoadPeopleForAspenResult;
import com.google.android.gms.people.People.BundleResult;
import com.google.android.gms.people.People.zza;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.internal.zzn;
import com.google.android.gms.people.model.PersonBuffer;

public class zztz implements InternalApi {
    public PendingResult<BundleResult> internalCall(GoogleApiClient googleApiClient, final Bundle arguments) {
        if (zzl.isEnabled()) {
            zzl.zzh("internalCall", arguments);
        }
        return googleApiClient.zza(new zza<BundleResult>(this, googleApiClient) {
            final /* synthetic */ zztz zzbHx;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zzb) this, arguments);
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzcv(status);
            }

            protected BundleResult zzcv(final Status status) {
                return new BundleResult(this) {
                    final /* synthetic */ C05542 zzbHA;

                    public Bundle getBundle() {
                        return null;
                    }

                    public Status getStatus() {
                        return status;
                    }

                    public void release() {
                    }
                };
            }
        });
    }

    public PendingResult<LoadPeopleForAspenResult> loadPeopleForAspen(GoogleApiClient googleApiClient, String account, String pageId, LoadPeopleForAspenOptions options) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadPeopleForAspen", account, pageId, options);
        }
        final String str = account;
        final String str2 = pageId;
        final LoadPeopleForAspenOptions loadPeopleForAspenOptions = options;
        return googleApiClient.zza(new zza<LoadPeopleForAspenResult>(this, googleApiClient) {
            final /* synthetic */ zztz zzbHx;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zzb) this, str, str2, loadPeopleForAspenOptions);
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzcu(status);
            }

            protected LoadPeopleForAspenResult zzcu(final Status status) {
                return new LoadPeopleForAspenResult(this) {
                    final /* synthetic */ C05521 zzbHy;

                    public String getNextPageToken() {
                        return null;
                    }

                    public PersonBuffer getPeople() {
                        return null;
                    }

                    public Status getStatus() {
                        return status;
                    }

                    public void release() {
                    }
                };
            }
        });
    }
}

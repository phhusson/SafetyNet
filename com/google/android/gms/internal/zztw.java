package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.people.GraphUpdate;
import com.google.android.gms.people.GraphUpdate.AddCircleResult;
import com.google.android.gms.people.GraphUpdate.LoadAddToCircleConsentResult;
import com.google.android.gms.people.GraphUpdate.UpdatePersonCircleResult;
import com.google.android.gms.people.People;
import com.google.android.gms.people.People.zzb;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.internal.zzn;
import java.util.List;

public class zztw implements GraphUpdate {
    private PendingResult<Result> zza(GoogleApiClient googleApiClient, String str, String str2, String str3, boolean z) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final boolean z2 = z;
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ zztw zzbGN;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zza.zzb) this, str4, str5, str6, z2);
            }
        });
    }

    private PendingResult<Result> zza(GoogleApiClient googleApiClient, String str, String str2, boolean z) {
        final String str3 = str;
        final String str4 = str2;
        final boolean z2 = z;
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ zztw zzbGN;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zzd(this, str3, str4, z2);
            }
        });
    }

    public PendingResult<AddCircleResult> addCircle(GoogleApiClient googleApiClient, String account, String pageId, String circleName, String circleDescription) {
        return addCircle(googleApiClient, account, pageId, circleName, circleDescription, true);
    }

    public PendingResult<AddCircleResult> addCircle(GoogleApiClient googleApiClient, String account, String pageId, String circleName, String circleDescription, boolean enabledForSharing) {
        if (zzl.isEnabled()) {
            zzl.zzh("addCircle", account, pageId, circleName, circleDescription, Boolean.valueOf(enabledForSharing));
        }
        final String str = account;
        final String str2 = pageId;
        final String str3 = circleName;
        final String str4 = circleDescription;
        final boolean z = enabledForSharing;
        return googleApiClient.zzb(new People.zza<AddCircleResult>(this, googleApiClient) {
            final /* synthetic */ zztw zzbGN;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zza.zzb) this, str, str2, str3, str4, z);
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzcp(status);
            }

            protected AddCircleResult zzcp(final Status status) {
                return new AddCircleResult(this) {
                    final /* synthetic */ C05303 zzbGT;

                    public String getCircleId() {
                        return null;
                    }

                    public String getCircleName() {
                        return null;
                    }

                    public Status getStatus() {
                        return status;
                    }
                };
            }
        });
    }

    public PendingResult<Result> blockPerson(GoogleApiClient googleApiClient, String account, String pageId, String gaiaId) {
        if (zzl.isEnabled()) {
            zzl.zzh("blockPerson", account, pageId, gaiaId);
        }
        return zza(googleApiClient, account, pageId, gaiaId, true);
    }

    public PendingResult<LoadAddToCircleConsentResult> loadAddToCircleConsent(GoogleApiClient googleApiClient, final String account, final String pageId) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadAddToCircleConsent", account, pageId);
        }
        return googleApiClient.zza(new People.zza<LoadAddToCircleConsentResult>(this, googleApiClient) {
            final /* synthetic */ zztw zzbGN;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zze(this, account, pageId);
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzcr(status);
            }

            protected LoadAddToCircleConsentResult zzcr(final Status status) {
                return new LoadAddToCircleConsentResult(this) {
                    final /* synthetic */ C05367 zzbHd;

                    public String getConsentButtonText() {
                        return null;
                    }

                    public String getConsentHtml() {
                        return null;
                    }

                    public String getConsentTitleText() {
                        return null;
                    }

                    public boolean getShowConsent() {
                        return false;
                    }

                    public Status getStatus() {
                        return status;
                    }
                };
            }
        });
    }

    public PendingResult<Result> removeCircle(GoogleApiClient googleApiClient, String account, String pageId, String circleId) {
        if (zzl.isEnabled()) {
            zzl.zzh("removeCircle", account, pageId, circleId);
        }
        final String str = account;
        final String str2 = pageId;
        final String str3 = circleId;
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ zztw zzbGN;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zza.zzb) this, str, str2, str3);
            }
        });
    }

    public PendingResult<Result> setHasShownAddToCircleConsent(GoogleApiClient googleApiClient, final String account, final String pageId) {
        if (zzl.isEnabled()) {
            zzl.zzh("setHasShownAddToCircleConsent", account, pageId);
        }
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ zztw zzbGN;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zzf(this, account, pageId);
            }
        });
    }

    public PendingResult<Result> starPerson(GoogleApiClient googleApiClient, String account, String peopleV2PersonId) {
        if (zzl.isEnabled()) {
            zzl.zzh("starPerson", account, peopleV2PersonId);
        }
        return zza(googleApiClient, account, peopleV2PersonId, true);
    }

    public PendingResult<Result> unblockPerson(GoogleApiClient googleApiClient, String account, String pageId, String gaiaId) {
        if (zzl.isEnabled()) {
            zzl.zzh("unblockPerson", account, pageId, gaiaId);
        }
        return zza(googleApiClient, account, pageId, gaiaId, false);
    }

    public PendingResult<Result> unstarPerson(GoogleApiClient googleApiClient, String account, String peopleV2PersonId) {
        if (zzl.isEnabled()) {
            zzl.zzh("unstarPerson", account, peopleV2PersonId);
        }
        return zza(googleApiClient, account, peopleV2PersonId, false);
    }

    public PendingResult<Result> updateCircle(GoogleApiClient googleApiClient, String account, String pageId, String circleId, String newName, Boolean newEnabledForSharing, String newCircleDescription) {
        if (zzl.isEnabled()) {
            zzl.zzh("updateCircle", account, pageId, circleId, newName, newEnabledForSharing, newCircleDescription);
        }
        final String str = account;
        final String str2 = pageId;
        final String str3 = circleId;
        final String str4 = newName;
        final Boolean bool = newEnabledForSharing;
        final String str5 = newCircleDescription;
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ zztw zzbGN;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zza.zzb) this, str, str2, str3, str4, bool, str5);
            }
        });
    }

    public PendingResult<UpdatePersonCircleResult> updatePersonCircles(GoogleApiClient googleApiClient, String account, String pageId, String qualifiedId, List<String> circleIdsToAdd, List<String> circleIdsToRemove) {
        return zza(googleApiClient, account, pageId, qualifiedId, circleIdsToAdd, circleIdsToRemove, null);
    }

    public PendingResult<UpdatePersonCircleResult> zza(GoogleApiClient googleApiClient, String str, String str2, String str3, List<String> list, List<String> list2, FavaDiagnosticsEntity favaDiagnosticsEntity) {
        if (zzl.isEnabled()) {
            zzl.zzh("updatePersonCircles", str, str2, str3, list, list2, favaDiagnosticsEntity);
        }
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final List<String> list3 = list;
        final List<String> list4 = list2;
        final FavaDiagnosticsEntity favaDiagnosticsEntity2 = favaDiagnosticsEntity;
        return googleApiClient.zzb(new People.zza<UpdatePersonCircleResult>(this, googleApiClient) {
            final /* synthetic */ zztw zzbGN;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zza.zzb) this, str4, str5, str6, list3, list4, favaDiagnosticsEntity2);
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzcq(status);
            }

            protected UpdatePersonCircleResult zzcq(final Status status) {
                return new UpdatePersonCircleResult(this) {
                    final /* synthetic */ C05346 zzbHc;

                    public List<String> getAddedCircles() {
                        return null;
                    }

                    public List<String> getRemovedCircles() {
                        return null;
                    }

                    public Status getStatus() {
                        return status;
                    }
                };
            }
        });
    }
}

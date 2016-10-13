package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.people.Graph;
import com.google.android.gms.people.Graph.LoadAggregatedPeopleOptions;
import com.google.android.gms.people.Graph.LoadAggregatedPeopleResult;
import com.google.android.gms.people.Graph.LoadCirclesOptions;
import com.google.android.gms.people.Graph.LoadCirclesResult;
import com.google.android.gms.people.Graph.LoadContactsGaiaIdsOptions;
import com.google.android.gms.people.Graph.LoadContactsGaiaIdsResult;
import com.google.android.gms.people.Graph.LoadOwnersOptions;
import com.google.android.gms.people.Graph.LoadOwnersResult;
import com.google.android.gms.people.Graph.LoadPeopleForAggregationResult;
import com.google.android.gms.people.Graph.LoadPeopleOptions;
import com.google.android.gms.people.Graph.LoadPeopleResult;
import com.google.android.gms.people.Graph.LoadPhoneNumbersResult;
import com.google.android.gms.people.People.zza;
import com.google.android.gms.people.exp.ContactGaiaIdRawBuffer;
import com.google.android.gms.people.exp.PersonForAggregationRawBuffer;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.internal.zzn;
import com.google.android.gms.people.internal.zzp;
import com.google.android.gms.people.model.AggregatedPersonBuffer;
import com.google.android.gms.people.model.CircleBuffer;
import com.google.android.gms.people.model.ContactGaiaIdBuffer;
import com.google.android.gms.people.model.OwnerBuffer;
import com.google.android.gms.people.model.PersonBuffer;
import com.google.android.gms.people.model.PhoneNumberBuffer;

public class zztv implements Graph {
    public PendingResult<LoadPeopleForAggregationResult> expLoadPeopleForAggregation(GoogleApiClient googleApiClient, String account, String pageId, LoadAggregatedPeopleOptions options) {
        if (zzl.isEnabled()) {
            zzl.zzh("expLoadPeopleForAggregation", account, pageId, options);
        }
        final LoadAggregatedPeopleOptions loadAggregatedPeopleOptions = options != null ? options : LoadAggregatedPeopleOptions.zzbzm;
        final String str = account;
        final String str2 = pageId;
        return googleApiClient.zza(new zza<LoadPeopleForAggregationResult>(this, googleApiClient) {
            final /* synthetic */ zztv zzbGx;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zzb) this, str, str2, loadAggregatedPeopleOptions.getQuery(), loadAggregatedPeopleOptions.getSearchFields(), loadAggregatedPeopleOptions.isPeopleOnly(), loadAggregatedPeopleOptions.getProjection(), loadAggregatedPeopleOptions.getExtraColumns(), loadAggregatedPeopleOptions.getFilterGaiaId(), loadAggregatedPeopleOptions.isIncludeEvergreenPeople(), loadAggregatedPeopleOptions.getSortOrder(), loadAggregatedPeopleOptions.getFilterGaiaEdgeTypes());
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzcm(status);
            }

            protected LoadPeopleForAggregationResult zzcm(final Status status) {
                return new LoadPeopleForAggregationResult(this) {
                    final /* synthetic */ C05226 zzbGH;

                    public Bundle getEmailTypeMapBundle() {
                        return null;
                    }

                    public ContactGaiaIdRawBuffer getGaiaMap() {
                        return null;
                    }

                    public PersonForAggregationRawBuffer getPeople() {
                        return null;
                    }

                    public Bundle getPhoneTypeMapBundle() {
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

    public PendingResult<LoadAggregatedPeopleResult> loadAggregatedPeople(GoogleApiClient googleApiClient, String account, String pageId, LoadAggregatedPeopleOptions options) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadAggregatedPeople", account, pageId, options);
        }
        final LoadAggregatedPeopleOptions loadAggregatedPeopleOptions = options != null ? options : LoadAggregatedPeopleOptions.zzbzm;
        final String str = account;
        final String str2 = pageId;
        return googleApiClient.zza(new zza<LoadAggregatedPeopleResult>(this, googleApiClient) {
            final /* synthetic */ zztv zzbGx;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza(this, str, str2, loadAggregatedPeopleOptions.isIncludeInvisible(), loadAggregatedPeopleOptions.getQuery(), loadAggregatedPeopleOptions.isPeopleOnly(), loadAggregatedPeopleOptions.getProjection(), loadAggregatedPeopleOptions.getExtraColumns(), loadAggregatedPeopleOptions.getFilterGaiaId(), loadAggregatedPeopleOptions.isIncludeEvergreenPeople(), loadAggregatedPeopleOptions.getSortOrder());
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzcl(status);
            }

            protected LoadAggregatedPeopleResult zzcl(final Status status) {
                return new LoadAggregatedPeopleResult(this) {
                    final /* synthetic */ C05205 zzbGG;

                    public AggregatedPersonBuffer getAggregatedPeople() {
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

    public PendingResult<LoadCirclesResult> loadCircles(GoogleApiClient googleApiClient, String account, String pageId, LoadCirclesOptions options) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadCircles", account, pageId, options);
        }
        final LoadCirclesOptions loadCirclesOptions = options != null ? options : LoadCirclesOptions.zzbzw;
        final String str = account;
        final String str2 = pageId;
        return googleApiClient.zza(new zza<LoadCirclesResult>(this, googleApiClient) {
            final /* synthetic */ zztv zzbGx;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zzb) this, str, str2, loadCirclesOptions.getFilterCircleId(), loadCirclesOptions.getFilterCircleType(), loadCirclesOptions.getFilterCircleNamePrefix(), loadCirclesOptions.isGetVisibility());
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzcj(status);
            }

            protected LoadCirclesResult zzcj(final Status status) {
                return new LoadCirclesResult(this) {
                    final /* synthetic */ C05163 zzbGC;

                    public CircleBuffer getCircles() {
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

    public PendingResult<LoadContactsGaiaIdsResult> loadContactsGaiaIds(GoogleApiClient googleApiClient, LoadContactsGaiaIdsOptions options) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadContactsGaiaIds", options);
        }
        if (options == null) {
            options = LoadContactsGaiaIdsOptions.zzbzB;
        }
        return googleApiClient.zza(new zza<LoadContactsGaiaIdsResult>(this, googleApiClient) {
            final /* synthetic */ zztv zzbGx;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zzb(this, options.getFilterContactInfo(), options.getFilterGaiaId(), options.getFilterGaiaEdgeTypes());
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzcn(status);
            }

            protected LoadContactsGaiaIdsResult zzcn(final Status status) {
                return new LoadContactsGaiaIdsResult(this) {
                    final /* synthetic */ C05247 zzbGJ;

                    public ContactGaiaIdBuffer getContactsGaiaIds() {
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

    public PendingResult<LoadOwnersResult> loadOwner(GoogleApiClient googleApiClient, final String account, final String pageId) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadOwner", account, pageId);
        }
        return googleApiClient.zza(new zza<LoadOwnersResult>(this, googleApiClient) {
            final /* synthetic */ zztv zzbGx;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zzb) this, true, true, account, pageId, 0);
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzci(status);
            }

            protected LoadOwnersResult zzci(final Status status) {
                return new LoadOwnersResult(this) {
                    final /* synthetic */ C05142 zzbGA;

                    public OwnerBuffer getOwners() {
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

    public PendingResult<LoadOwnersResult> loadOwners(GoogleApiClient googleApiClient, LoadOwnersOptions options) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadOwners", options);
        }
        if (options == null) {
            options = LoadOwnersOptions.zzbzD;
        }
        return googleApiClient.zza(new zza<LoadOwnersResult>(this, googleApiClient) {
            final /* synthetic */ zztv zzbGx;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zzb) this, false, options.isIncludePlusPages(), null, null, options.getSortOrder());
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzci(status);
            }

            protected LoadOwnersResult zzci(final Status status) {
                return new LoadOwnersResult(this) {
                    final /* synthetic */ C05121 zzbGy;

                    public OwnerBuffer getOwners() {
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

    public PendingResult<LoadPeopleResult> loadPeople(GoogleApiClient googleApiClient, String account, String pageId, LoadPeopleOptions options) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadPeople", account, pageId, options);
        }
        final String str = account;
        final String str2 = pageId;
        final LoadPeopleOptions loadPeopleOptions = options;
        return googleApiClient.zza(new zza<LoadPeopleResult>(this, googleApiClient) {
            final /* synthetic */ zztv zzbGx;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zzb) this, str, str2, loadPeopleOptions);
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzck(status);
            }

            protected LoadPeopleResult zzck(final Status status) {
                return new LoadPeopleResult(this) {
                    final /* synthetic */ C05184 zzbGE;

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

    public PendingResult<LoadPhoneNumbersResult> loadPhoneNumbers(GoogleApiClient googleApiClient, final String account, final Bundle options) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadPhoneNumbers", account, zzp.zzW(options));
        }
        return googleApiClient.zza(new zza<LoadPhoneNumbersResult>(this, googleApiClient) {
            final /* synthetic */ zztv zzbGx;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zzb) this, account, options);
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzco(status);
            }

            protected LoadPhoneNumbersResult zzco(final Status status) {
                return new LoadPhoneNumbersResult(this) {
                    final /* synthetic */ C05268 zzbGK;

                    public PhoneNumberBuffer getPhoneNumbers() {
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

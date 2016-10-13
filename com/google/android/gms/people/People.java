package com.google.android.gms.people;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zztt;
import com.google.android.gms.internal.zztu;
import com.google.android.gms.internal.zztv;
import com.google.android.gms.internal.zztw;
import com.google.android.gms.internal.zztx;
import com.google.android.gms.internal.zzty;
import com.google.android.gms.internal.zztz;
import com.google.android.gms.internal.zzua;
import com.google.android.gms.internal.zzub;
import com.google.android.gms.people.identity.IdentityApi;
import com.google.android.gms.people.identity.internal.zzh;
import com.google.android.gms.people.internal.zzn;

public final class People {
    public static final Api<PeopleOptions1p> API_1P = new Api("People.API_1P", zzaUY, zzbzL);
    public static final Autocomplete AutocompleteApi = new zztt();
    public static final ContactsSync ContactsSyncApi = new zztu();
    public static final Graph GraphApi = new zztv();
    public static final GraphUpdate GraphUpdateApi = new zztw();
    public static final IdentityApi IdentityApi = new zzh();
    public static final Images ImageApi = new zztx();
    public static final InteractionFeedback InteractionFeedbackApi = new zzty();
    public static final InternalApi InternalApi = new zztz();
    public static final Notifications NotificationApi = new zzua();
    public static final int STATUS_INCOMPLETE = 100;
    public static final int STATUS_NOT_ALLOWED = 101;
    public static final Sync SyncApi = new zzub();
    static final com.google.android.gms.common.api.Api.zza<zzn, PeopleOptions1p> zzaUY = new C05631();
    public static final zzc<zzn> zzbzL = new zzc();

    public interface ReleasableResult extends Releasable, Result {
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zzn> {
        public zza(GoogleApiClient googleApiClient) {
            super(People.zzbzL, googleApiClient);
        }
    }

    public static abstract class zzb extends zza<Result> {
        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Result zzb(Status status) {
            return status;
        }
    }

    public interface BundleResult extends ReleasableResult {
        Bundle getBundle();
    }

    static class C05631 extends com.google.android.gms.common.api.Api.zza<zzn, PeopleOptions1p> {
        C05631() {
        }

        public zzn zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, PeopleOptions1p peopleOptions1p, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb((Object) peopleOptions1p, (Object) "Must provide valid PeopleOptions!");
            return new zzn(context, looper, connectionCallbacks, onConnectionFailedListener, String.valueOf(peopleOptions1p.zzbzM), com_google_android_gms_common_internal_zzf);
        }
    }

    public static final class PeopleOptions1p implements HasOptions {
        private final int zzbzM;

        public static final class Builder {
            int zzbzM = -1;

            public PeopleOptions1p build() {
                zzx.zzb(this.zzbzM >= 0, (Object) "Must provide valid client application ID!");
                return new PeopleOptions1p();
            }

            public Builder setClientApplicationId(int clientApplicationId) {
                this.zzbzM = clientApplicationId;
                return this;
            }
        }

        private PeopleOptions1p(Builder builder) {
            this.zzbzM = builder.zzbzM;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    private People() {
    }
}

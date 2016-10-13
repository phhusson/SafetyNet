package com.google.android.gms.people.identity;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.people.identity.models.Person;
import com.google.android.gms.people.identity.models.PersonReference;

public interface IdentityApi {

    public interface CustomPersonListResult<PersonRefType> extends Releasable, Result {
        PendingResult<CustomPersonListResult<PersonRefType>> getNextPendingResult();

        DataBuffer<PersonRefType> getPersonBuffer();

        boolean isResultComplete();

        void release();
    }

    public interface CustomPersonResult<PersonType> extends Releasable, Result {
        PendingResult<CustomPersonResult<PersonType>> getNextPendingResult();

        DataBuffer<PersonType> getPersonBuffer();

        boolean isLocalResultComplete();

        boolean isResultComplete();

        void release();
    }

    public static class GetOptions {
        public final boolean useCachedData;
        public final boolean useContactData;
        public final boolean useWebData;
        public final zza zzbAa;

        public static final class zza {
            private zza zzbAb = new zza().zzGg();
            private boolean zzbAc = true;
            private boolean zzbAd = false;
            private boolean zzbAe = true;

            public GetOptions zzGh() {
                return new GetOptions();
            }

            public zza zzaB(boolean z) {
                this.zzbAc = z;
                return this;
            }

            public zza zzaC(boolean z) {
                this.zzbAd = z;
                return this;
            }

            public zza zzaD(boolean z) {
                this.zzbAe = z;
                return this;
            }

            public zza zzb(zza com_google_android_gms_people_identity_IdentityApi_zza) {
                this.zzbAb = (zza) zzx.zzD(com_google_android_gms_people_identity_IdentityApi_zza);
                return this;
            }
        }

        private GetOptions(zza builder) {
            this.zzbAa = builder.zzbAb;
            this.useCachedData = builder.zzbAc;
            this.useWebData = builder.zzbAd;
            this.useContactData = builder.zzbAe;
        }
    }

    public static class ListOptions {
        public final boolean useCachedData;
        public final boolean useContactData;
        public final boolean useWebData;
        public final zza zzbAa;

        public static final class zza {
            private zza zzbAb = new zza().zzGg();
            private boolean zzbAc = true;
            private boolean zzbAd = false;
            private boolean zzbAe = true;

            public static zza zza(ListOptions listOptions) {
                return new zza().zzaE(listOptions.useCachedData).zzaF(listOptions.useWebData).zzaG(listOptions.useContactData).zza(zza.zza(listOptions.zzbAa));
            }

            public ListOptions zzGi() {
                return new ListOptions();
            }

            public zza zza(zza com_google_android_gms_people_identity_IdentityApi_zza_zza) {
                return zzc(com_google_android_gms_people_identity_IdentityApi_zza_zza.zzGg());
            }

            public zza zzaE(boolean z) {
                this.zzbAc = z;
                return this;
            }

            public zza zzaF(boolean z) {
                this.zzbAd = z;
                return this;
            }

            public zza zzaG(boolean z) {
                this.zzbAe = z;
                return this;
            }

            public zza zzc(zza com_google_android_gms_people_identity_IdentityApi_zza) {
                this.zzbAb = (zza) zzx.zzD(com_google_android_gms_people_identity_IdentityApi_zza);
                return this;
            }
        }

        private ListOptions(zza builder) {
            this.zzbAa = builder.zzbAb;
            this.useCachedData = builder.zzbAc;
            this.useWebData = builder.zzbAd;
            this.useContactData = builder.zzbAe;
        }
    }

    public interface PersonListResult extends Releasable, Result {
        PendingResult<PersonListResult> getNextPendingResult();

        DataBuffer<PersonReference> getPersonBuffer();

        boolean isResultComplete();

        void release();
    }

    public interface PersonResult extends Releasable, Result {
        PendingResult<PersonResult> getNextPendingResult();

        DataBuffer<Person> getPersonBuffer();

        boolean isLocalResultComplete();

        boolean isResultComplete();

        void release();
    }

    public static final class zza {
        public final String accountName;
        public final String pageId;
        public final String zzbzW;
        public final Bundle zzbzX;

        public static final class zza {
            public String zzWD;
            public String zzbzY;
            public Bundle zzbzZ = new Bundle();
            public String zzbzd;

            public static zza zza(zza com_google_android_gms_people_identity_IdentityApi_zza) {
                return new zza().zzfG(com_google_android_gms_people_identity_IdentityApi_zza.accountName).zzfH(com_google_android_gms_people_identity_IdentityApi_zza.pageId).zzfI(com_google_android_gms_people_identity_IdentityApi_zza.zzbzW);
            }

            public zza zzGg() {
                return new zza();
            }

            public zza zzag(String str, String str2) {
                this.zzbzZ.putString(str, str2);
                return this;
            }

            public zza zzfG(String str) {
                this.zzWD = str;
                return this;
            }

            public zza zzfH(String str) {
                this.zzbzd = str;
                return this;
            }

            public zza zzfI(String str) {
                this.zzbzY = str;
                return this;
            }
        }

        private zza(zza com_google_android_gms_people_identity_IdentityApi_zza_zza) {
            this.accountName = com_google_android_gms_people_identity_IdentityApi_zza_zza.zzWD;
            this.pageId = com_google_android_gms_people_identity_IdentityApi_zza_zza.zzbzd;
            this.zzbzW = com_google_android_gms_people_identity_IdentityApi_zza_zza.zzbzY;
            this.zzbzX = com_google_android_gms_people_identity_IdentityApi_zza_zza.zzbzZ;
        }
    }

    <PersonType> PendingResult<CustomPersonResult<PersonType>> getByIds(GoogleApiClient googleApiClient, GetOptions getOptions, PersonFactory<PersonType> personFactory, String... strArr);

    PendingResult<PersonResult> getByIds(GoogleApiClient googleApiClient, GetOptions getOptions, String... strArr);

    PendingResult<PersonListResult> list(GoogleApiClient googleApiClient, ListOptions listOptions);

    <PersonRefType> PendingResult<CustomPersonListResult<PersonRefType>> list(GoogleApiClient googleApiClient, ListOptions listOptions, PersonListFactory<PersonRefType> personListFactory);

    PendingResult<PersonListResult> listByEmail(GoogleApiClient googleApiClient, ListOptions listOptions, String str);

    PendingResult<PersonListResult> listByPhone(GoogleApiClient googleApiClient, ListOptions listOptions, String str);
}

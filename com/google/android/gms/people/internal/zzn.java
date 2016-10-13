package com.google.android.gms.people.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.people.Autocomplete.AutocompleteOptions;
import com.google.android.gms.people.Autocomplete.AutocompleteResult;
import com.google.android.gms.people.Autocomplete.PreferredFieldsResult;
import com.google.android.gms.people.Graph.LoadAggregatedPeopleResult;
import com.google.android.gms.people.Graph.LoadCirclesResult;
import com.google.android.gms.people.Graph.LoadContactsGaiaIdsResult;
import com.google.android.gms.people.Graph.LoadOwnersResult;
import com.google.android.gms.people.Graph.LoadPeopleForAggregationResult;
import com.google.android.gms.people.Graph.LoadPeopleOptions;
import com.google.android.gms.people.Graph.LoadPeopleResult;
import com.google.android.gms.people.Graph.LoadPhoneNumbersResult;
import com.google.android.gms.people.GraphUpdate.AddCircleResult;
import com.google.android.gms.people.GraphUpdate.LoadAddToCircleConsentResult;
import com.google.android.gms.people.GraphUpdate.UpdatePersonCircleResult;
import com.google.android.gms.people.Images.LoadImageOptions;
import com.google.android.gms.people.Images.LoadImageResult;
import com.google.android.gms.people.Images.SetAvatarResult;
import com.google.android.gms.people.InternalApi.LoadPeopleForAspenOptions;
import com.google.android.gms.people.InternalApi.LoadPeopleForAspenResult;
import com.google.android.gms.people.Notifications.OnDataChanged;
import com.google.android.gms.people.People.BundleResult;
import com.google.android.gms.people.People.ReleasableResult;
import com.google.android.gms.people.PeopleConstants;
import com.google.android.gms.people.exp.ContactGaiaIdRawBuffer;
import com.google.android.gms.people.exp.PersonForAggregationRawBuffer;
import com.google.android.gms.people.identity.IdentityApi.GetOptions;
import com.google.android.gms.people.identity.IdentityApi.ListOptions;
import com.google.android.gms.people.identity.internal.AccountToken;
import com.google.android.gms.people.identity.internal.ParcelableGetOptions;
import com.google.android.gms.people.identity.internal.ParcelableListOptions;
import com.google.android.gms.people.internal.agg.PhoneEmailDecoder.EmailDecoder;
import com.google.android.gms.people.internal.agg.PhoneEmailDecoder.PhoneDecoder;
import com.google.android.gms.people.internal.autocomplete.AutocompletionImpl;
import com.google.android.gms.people.internal.autocomplete.ParcelableLoadAutocompleteResultsOptions;
import com.google.android.gms.people.internal.autocomplete.ParcelableLoadContactGroupFieldsOptions;
import com.google.android.gms.people.model.AggregatedPersonBuffer;
import com.google.android.gms.people.model.AutocompleteBuffer;
import com.google.android.gms.people.model.AvatarReference;
import com.google.android.gms.people.model.CircleBuffer;
import com.google.android.gms.people.model.ContactGaiaIdBuffer;
import com.google.android.gms.people.model.ContactGroupPreferredFieldsBuffer;
import com.google.android.gms.people.model.OwnerBuffer;
import com.google.android.gms.people.model.PersonBuffer;
import com.google.android.gms.people.model.PhoneNumberBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class zzn extends com.google.android.gms.common.internal.zzj<zzg> {
    private static volatile Bundle zzbEf;
    private static volatile Bundle zzbEg;
    public final Context mContext;
    public final String zzVx;
    public final String zzbEd;
    private final HashMap<OnDataChanged, zzw> zzbEe = new HashMap();
    private Long zzbEh = null;

    public interface zzh {
        void zza(int i, Bundle bundle, Bundle bundle2);
    }

    public interface zzi {
        void zza(int i, Bundle bundle, Bundle bundle2);
    }

    public interface zzj extends ReleasableResult {
        ArrayList<AutocompletionImpl> zzJu();

        int zzJv();

        int zzJw();
    }

    public interface zzd {
        void zza(zzj com_google_android_gms_people_internal_zzn_zzj);

        void zzcg(Status status);
    }

    private static final class zza implements LoadAggregatedPeopleResult {
        private final Status zzVy;
        private final AggregatedPersonBuffer zzbEi;

        public zza(Status status, AggregatedPersonBuffer aggregatedPersonBuffer) {
            this.zzVy = status;
            this.zzbEi = aggregatedPersonBuffer;
        }

        public AggregatedPersonBuffer getAggregatedPeople() {
            return this.zzbEi;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public void release() {
            if (this.zzbEi != null) {
                this.zzbEi.close();
            }
        }
    }

    private static final class zzaa implements BundleResult {
        private final Status zzVy;
        private final Bundle zzbEz;

        public zzaa(Status status, Bundle bundle) {
            this.zzVy = status;
            this.zzbEz = bundle;
        }

        public Bundle getBundle() {
            return this.zzbEz;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public void release() {
        }
    }

    private static final class zzab extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<Result> zzbjh;

        public zzab(com.google.android.gms.common.api.internal.zza.zzb<Result> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result;
        }

        public void zza(int i, Bundle bundle, Bundle bundle2) {
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Bundle callback: status=" + i + "\nresolution=" + bundle + "\nbundle=" + bundle2);
            }
            this.zzbjh.zzv(new zzac(zzn.zza(i, null, bundle)));
        }
    }

    private static final class zzac implements Result {
        private final Status zzVy;

        public zzac(Status status) {
            this.zzVy = status;
        }

        public Status getStatus() {
            return this.zzVy;
        }
    }

    private static final class zzad extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<LoadOwnersResult> zzbjh;

        public zzad(com.google.android.gms.common.api.internal.zza.zzb<LoadOwnersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadOwnersResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadOwnersResult;
        }

        public void zza(int i, Bundle bundle, DataHolder dataHolder) {
            OwnerBuffer ownerBuffer = null;
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Owner callback: status=" + i + "\nresolution=" + bundle + "\nholder=" + dataHolder);
            }
            Status zzb = zzn.zza(i, null, bundle);
            if (dataHolder != null) {
                ownerBuffer = new OwnerBuffer(dataHolder);
            }
            this.zzbjh.zzv(new zzak(zzb, ownerBuffer));
        }
    }

    private static final class zzae extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<LoadImageResult> zzbjh;

        public zzae(com.google.android.gms.common.api.internal.zza.zzb<LoadImageResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult;
        }

        public void zza(int i, Bundle bundle, ParcelFileDescriptor parcelFileDescriptor, Bundle bundle2) {
            boolean z;
            int i2;
            int i3 = 0;
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Avatar callback: status=" + i + " resolution=" + bundle + " pfd=" + parcelFileDescriptor);
            }
            Status zzb = zzn.zza(i, null, bundle);
            if (bundle2 != null) {
                z = bundle2.getBoolean("rewindable");
                i2 = bundle2.getInt("width");
                i3 = bundle2.getInt("height");
            } else {
                i2 = 0;
                z = false;
            }
            this.zzbjh.zzv(new zzal(zzb, parcelFileDescriptor, z, i2, i3));
        }
    }

    private static final class zzaf extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleResult> zzbjh;

        public zzaf(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPeopleResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPeopleResult;
        }

        public void zza(int i, Bundle bundle, DataHolder dataHolder) {
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "People callback: status=" + i + "\nresolution=" + bundle + "\nholder=" + dataHolder);
            }
            this.zzbjh.zzv(new zzaq(zzn.zza(i, null, bundle), zzn.zzaj(dataHolder)));
        }
    }

    private static final class zzag extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleForAspenResult> zzbjh;

        public zzag(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleForAspenResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_InternalApi_LoadPeopleForAspenResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_InternalApi_LoadPeopleForAspenResult;
        }

        public void zza(int i, Bundle bundle, DataHolder dataHolder) {
            String str = null;
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "People callback: status=" + i + "\nresolution=" + bundle + "\nholder=" + dataHolder);
            }
            Status zzb = zzn.zza(i, null, bundle);
            PersonBuffer zzak = zzn.zzaj(dataHolder);
            if (dataHolder != null) {
                str = dataHolder.zzqt().getString("pageToken");
            }
            this.zzbjh.zzv(new zzap(zzb, zzak, str));
        }
    }

    private static final class zzah extends zza {
        private final Context zzbEA;
        private final com.google.android.gms.common.api.internal.zza.zzb<LoadPhoneNumbersResult> zzbjh;

        public zzah(com.google.android.gms.common.api.internal.zza.zzb<LoadPhoneNumbersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPhoneNumbersResult, Context context) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPhoneNumbersResult;
            this.zzbEA = context;
        }

        public void zza(int i, Bundle bundle, DataHolder dataHolder) {
            PhoneNumberBuffer phoneNumberBuffer = null;
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Phone number callback: status=" + i + "\nresolution=" + bundle + "\nholder=" + dataHolder);
            }
            Status zzb = zzn.zza(i, null, bundle);
            if (dataHolder != null) {
                phoneNumberBuffer = new PhoneNumberBuffer(dataHolder, this.zzbEA);
            }
            this.zzbjh.zzv(new zzar(zzb, phoneNumberBuffer));
        }
    }

    private static final class zzai extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<UpdatePersonCircleResult> zzbjh;

        public zzai(com.google.android.gms.common.api.internal.zza.zzb<UpdatePersonCircleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_GraphUpdate_UpdatePersonCircleResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_GraphUpdate_UpdatePersonCircleResult;
        }

        public void zza(int i, Bundle bundle, Bundle bundle2) {
            List stringArrayList;
            List list = null;
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Bundle callback: status=" + i + "\nresolution=" + bundle + "\nbundle=" + bundle2);
            }
            Status zzb = zzn.zza(i, null, bundle);
            if (zzb.isSuccess()) {
                stringArrayList = bundle2.getStringArrayList("added_circles");
                list = bundle2.getStringArrayList("removed_circles");
            } else {
                stringArrayList = null;
            }
            this.zzbjh.zzv(new zzaj(zzb, stringArrayList, list));
        }
    }

    private static final class zzaj implements UpdatePersonCircleResult {
        private final Status zzVy;
        private final List<String> zzbEB;
        private final List<String> zzbEC;

        public zzaj(Status status, List<String> list, List<String> list2) {
            this.zzVy = status;
            this.zzbEB = list;
            this.zzbEC = list2;
        }

        public List<String> getAddedCircles() {
            return this.zzbEB;
        }

        public List<String> getRemovedCircles() {
            return this.zzbEC;
        }

        public Status getStatus() {
            return this.zzVy;
        }
    }

    private static final class zzak implements LoadOwnersResult {
        private final Status zzVy;
        private final OwnerBuffer zzbED;

        public zzak(Status status, OwnerBuffer ownerBuffer) {
            this.zzVy = status;
            this.zzbED = ownerBuffer;
        }

        public OwnerBuffer getOwners() {
            return this.zzbED;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public void release() {
            if (this.zzbED != null) {
                this.zzbED.close();
            }
        }
    }

    private static final class zzal implements LoadImageResult {
        private final Status zzVy;
        private final ParcelFileDescriptor zzaHz;
        private final boolean zzbEE;
        private final int zzoW;
        private final int zzoX;

        public zzal(Status status, ParcelFileDescriptor parcelFileDescriptor, boolean z, int i, int i2) {
            this.zzVy = status;
            this.zzaHz = parcelFileDescriptor;
            this.zzbEE = z;
            this.zzoW = i;
            this.zzoX = i2;
        }

        public int getHeight() {
            return this.zzoX;
        }

        public ParcelFileDescriptor getParcelFileDescriptor() {
            return this.zzaHz;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public int getWidth() {
            return this.zzoW;
        }

        public boolean isRewindable() {
            return this.zzbEE;
        }

        public void release() {
            if (this.zzaHz != null) {
                IOUtils.closeQuietly(this.zzaHz);
            }
        }
    }

    private static final class zzam implements com.google.android.gms.people.internal.agg.zzd.zzd {
        private final com.google.android.gms.common.api.internal.zza.zzb<LoadAggregatedPeopleResult> zzbjh;

        public zzam(com.google.android.gms.common.api.internal.zza.zzb<LoadAggregatedPeopleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadAggregatedPeopleResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadAggregatedPeopleResult;
        }

        public void zza(int i, Bundle bundle, AggregatedPersonBuffer aggregatedPersonBuffer) {
            this.zzbjh.zzv(new zza(zzn.zza(i, null, bundle), aggregatedPersonBuffer));
        }
    }

    private static final class zzan extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleForAggregationResult> zzbjh;

        public zzan(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleForAggregationResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPeopleForAggregationResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPeopleForAggregationResult;
        }

        public void zza(int i, Bundle bundle, DataHolder[] dataHolderArr) {
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "People callback: status=" + i + "\nresolution=" + bundle + "\nholders=" + Arrays.toString(dataHolderArr));
            }
            Status zzb = zzn.zza(i, null, bundle);
            if (dataHolderArr != null) {
                this.zzbjh.zzv(new zzao(zzb, new PersonForAggregationRawBuffer(dataHolderArr[0], new PhoneDecoder(zzn.zzbEg), new EmailDecoder(zzn.zzbEf)), new ContactGaiaIdRawBuffer(dataHolderArr[1])));
            } else {
                this.zzbjh.zzv(new zzao(zzb, null, null));
            }
        }
    }

    private static final class zzao implements LoadPeopleForAggregationResult {
        private final Status zzVy;
        private final PersonForAggregationRawBuffer zzbEF;
        private final ContactGaiaIdRawBuffer zzbEG;

        public zzao(Status status, PersonForAggregationRawBuffer personForAggregationRawBuffer, ContactGaiaIdRawBuffer contactGaiaIdRawBuffer) {
            this.zzVy = status;
            this.zzbEF = personForAggregationRawBuffer;
            this.zzbEG = contactGaiaIdRawBuffer;
        }

        public Bundle getEmailTypeMapBundle() {
            return zzn.zzbEf;
        }

        public ContactGaiaIdRawBuffer getGaiaMap() {
            return this.zzbEG;
        }

        public PersonForAggregationRawBuffer getPeople() {
            return this.zzbEF;
        }

        public Bundle getPhoneTypeMapBundle() {
            return zzn.zzbEg;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public void release() {
            if (this.zzbEF != null) {
                this.zzbEF.close();
            }
            if (this.zzbEG != null) {
                this.zzbEG.close();
            }
        }
    }

    private static final class zzap implements LoadPeopleForAspenResult {
        private final Status zzVy;
        private final PersonBuffer zzbEH;
        private final String zzbEI;

        public zzap(Status status, PersonBuffer personBuffer, String str) {
            this.zzVy = status;
            this.zzbEH = personBuffer;
            this.zzbEI = str;
        }

        public String getNextPageToken() {
            return this.zzbEI;
        }

        public PersonBuffer getPeople() {
            return this.zzbEH;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public void release() {
            if (this.zzbEH != null) {
                this.zzbEH.close();
            }
        }
    }

    private static final class zzaq implements LoadPeopleResult {
        private final Status zzVy;
        private final PersonBuffer zzbEH;

        public zzaq(Status status, PersonBuffer personBuffer) {
            this.zzVy = status;
            this.zzbEH = personBuffer;
        }

        public PersonBuffer getPeople() {
            return this.zzbEH;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public void release() {
            if (this.zzbEH != null) {
                this.zzbEH.close();
            }
        }
    }

    private static final class zzar implements LoadPhoneNumbersResult {
        private final Status zzVy;
        private final PhoneNumberBuffer zzbEJ;

        public zzar(Status status, PhoneNumberBuffer phoneNumberBuffer) {
            this.zzVy = status;
            this.zzbEJ = phoneNumberBuffer;
        }

        public PhoneNumberBuffer getPhoneNumbers() {
            return this.zzbEJ;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public void release() {
            if (this.zzbEJ != null) {
                this.zzbEJ.close();
            }
        }
    }

    private static class zzas implements PreferredFieldsResult {
        private final Status zzVy;
        private final ContactGroupPreferredFieldsBuffer zzbEK;

        public zzas(Status status, ContactGroupPreferredFieldsBuffer contactGroupPreferredFieldsBuffer) {
            this.zzVy = status;
            this.zzbEK = contactGroupPreferredFieldsBuffer;
        }

        public ContactGroupPreferredFieldsBuffer getPreferredFields() {
            return this.zzbEK;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public void release() {
            if (this.zzbEK != null) {
                this.zzbEK.close();
            }
        }
    }

    private static final class zzb extends zza {
        private final zzd zzbEj;

        public zzb(zzd com_google_android_gms_people_internal_zzn_zzd) {
            this.zzbEj = com_google_android_gms_people_internal_zzn_zzd;
        }

        public void zza(int i, Bundle bundle, Bundle bundle2) {
            Status zzb = zzn.zza(i, null, bundle);
            if (bundle2 != null) {
                bundle2.setClassLoader(getClass().getClassLoader());
                this.zzbEj.zza(new zzk(bundle2.getParcelableArrayList("autocomplete_autocompletions"), zzb, bundle2.getInt("autocomplete_callback_number"), bundle2.getInt("autocomplete_callback_total")));
                return;
            }
            this.zzbEj.zzcg(zzb);
        }
    }

    private static final class zzc implements AutocompleteResult {
        private final Status zzVy;
        private final AutocompleteBuffer zzbDX;

        public zzc(Status status, AutocompleteBuffer autocompleteBuffer) {
            this.zzVy = status;
            this.zzbDX = autocompleteBuffer;
        }

        public AutocompleteBuffer getAutocompleteEntries() {
            return this.zzbDX;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public void release() {
            if (this.zzbDX != null) {
                this.zzbDX.close();
            }
        }
    }

    private static final class zze implements LoadCirclesResult {
        private final Status zzVy;
        private final CircleBuffer zzbEk;

        public zze(Status status, CircleBuffer circleBuffer) {
            this.zzVy = status;
            this.zzbEk = circleBuffer;
        }

        public CircleBuffer getCircles() {
            return this.zzbEk;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public void release() {
            if (this.zzbEk != null) {
                this.zzbEk.close();
            }
        }
    }

    private static final class zzf implements LoadContactsGaiaIdsResult {
        private final Status zzVy;
        private final ContactGaiaIdBuffer zzbEl;

        public zzf(Status status, ContactGaiaIdBuffer contactGaiaIdBuffer) {
            this.zzVy = status;
            this.zzbEl = contactGaiaIdBuffer;
        }

        public ContactGaiaIdBuffer getContactsGaiaIds() {
            return this.zzbEl;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public void release() {
            if (this.zzbEl != null) {
                this.zzbEl.close();
            }
        }
    }

    private static final class zzg implements com.google.android.gms.common.api.internal.zzr.zzb<OnDataChanged> {
        private final String mAccount;
        private final int zzbEm;
        private final String zzbzd;

        public zzg(String str, String str2, int i) {
            this.mAccount = str;
            this.zzbzd = str2;
            this.zzbEm = i;
        }

        public void zzb(OnDataChanged onDataChanged) {
            onDataChanged.onDataChanged(this.mAccount, this.zzbzd, this.zzbEm);
        }

        public void zzpF() {
        }

        public /* synthetic */ void zzw(Object obj) {
            zzb((OnDataChanged) obj);
        }
    }

    private static final class zzk implements zzj {
        private final Status zzVy;
        private final ArrayList<AutocompletionImpl> zzbEn;
        private final int zzbEo;
        private final int zzbEp;

        public zzk(ArrayList<AutocompletionImpl> arrayList, Status status, int i, int i2) {
            this.zzbEn = arrayList;
            this.zzVy = status;
            this.zzbEo = i;
            this.zzbEp = i2;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public void release() {
        }

        public ArrayList<AutocompletionImpl> zzJu() {
            return this.zzbEn;
        }

        public int zzJv() {
            return this.zzbEo;
        }

        public int zzJw() {
            return this.zzbEp;
        }
    }

    private static final class zzl extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<AddCircleResult> zzbjh;

        public zzl(com.google.android.gms.common.api.internal.zza.zzb<AddCircleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_GraphUpdate_AddCircleResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_GraphUpdate_AddCircleResult;
        }

        public void zza(int i, Bundle bundle, Bundle bundle2) {
            String str = null;
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Bundle callback: status=" + i + "\nresolution=" + bundle + "\nbundle=" + bundle2);
            }
            Status zzb = zzn.zza(i, null, bundle);
            String string = bundle2 == null ? null : bundle2.getString("circle_id");
            if (bundle2 != null) {
                str = bundle2.getString("circle_name");
            }
            this.zzbjh.zzv(new zzm(zzb, string, str));
        }
    }

    private static final class zzm implements AddCircleResult {
        private final Status zzVy;
        private final String zzaxr;
        private final String zzbEq;

        public zzm(Status status, String str, String str2) {
            this.zzVy = status;
            this.zzaxr = str;
            this.zzbEq = str2;
        }

        public String getCircleId() {
            return this.zzaxr;
        }

        public String getCircleName() {
            return this.zzbEq;
        }

        public Status getStatus() {
            return this.zzVy;
        }
    }

    private static final class zzn extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<LoadAddToCircleConsentResult> zzbjh;

        public zzn(com.google.android.gms.common.api.internal.zza.zzb<LoadAddToCircleConsentResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_GraphUpdate_LoadAddToCircleConsentResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_GraphUpdate_LoadAddToCircleConsentResult;
        }

        public void zza(int i, Bundle bundle, Bundle bundle2) {
            boolean z;
            String string;
            String string2;
            String str = null;
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Bundle callback: status=" + i + "\nresolution=" + bundle + "\nbundle=" + bundle2);
            }
            Status zzb = zzn.zza(i, null, bundle);
            if (bundle2 != null) {
                z = bundle2.getBoolean("circles.first_time_add_need_consent");
                string = bundle2.getString("circles.first_time_add_text");
                string2 = bundle2.getString("circles.first_time_add_title_text");
                str = bundle2.getString("circles.first_time_add_ok_text");
            } else {
                z = false;
                string2 = null;
                string = null;
            }
            this.zzbjh.zzv(new zzo(zzb, z, string, string2, str));
        }
    }

    private static final class zzo implements LoadAddToCircleConsentResult {
        private final Status zzVy;
        private final boolean zzbEr;
        private final String zzbEs;
        private final String zzbEt;
        private final String zzbEu;

        public zzo(Status status, boolean z, String str, String str2, String str3) {
            this.zzVy = status;
            this.zzbEr = z;
            this.zzbEs = str;
            this.zzbEt = str2;
            this.zzbEu = str3;
        }

        public String getConsentButtonText() {
            return this.zzbEu;
        }

        public String getConsentHtml() {
            return this.zzbEs;
        }

        public String getConsentTitleText() {
            return this.zzbEt;
        }

        public boolean getShowConsent() {
            return this.zzbEr;
        }

        public Status getStatus() {
            return this.zzVy;
        }
    }

    private static final class zzp extends zza {
        private final com.google.android.gms.people.internal.agg.zzd zzbEv;

        public zzp(com.google.android.gms.people.internal.agg.zzd com_google_android_gms_people_internal_agg_zzd) {
            this.zzbEv = com_google_android_gms_people_internal_agg_zzd;
        }

        public void zza(int i, Bundle bundle, DataHolder[] dataHolderArr) {
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "People callback: status=" + i + "\nresolution=" + bundle + "\nholders=" + Arrays.toString(dataHolderArr));
            }
            this.zzbEv.zza(zzn.zzh(i, bundle), dataHolderArr);
        }
    }

    private static final class zzq extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<AutocompleteResult> zzbjh;

        public zzq(com.google.android.gms.common.api.internal.zza.zzb<AutocompleteResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Autocomplete_AutocompleteResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Autocomplete_AutocompleteResult;
        }

        public void zza(int i, Bundle bundle, DataHolder dataHolder) {
            AutocompleteBuffer autocompleteBuffer = null;
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Autocomplete callback: status=" + i + "\nresolution=" + bundle + "\nholder=" + dataHolder);
            }
            Status zzb = zzn.zza(i, null, bundle);
            if (dataHolder != null) {
                autocompleteBuffer = new AutocompleteBuffer(dataHolder);
            }
            this.zzbjh.zzv(new zzc(zzb, autocompleteBuffer));
        }
    }

    private static final class zzr extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<SetAvatarResult> zzbjh;

        public zzr(com.google.android.gms.common.api.internal.zza.zzb<SetAvatarResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_SetAvatarResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_SetAvatarResult;
        }

        public void zza(int i, Bundle bundle, Bundle bundle2) {
            String str = null;
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Bundle callback: status=" + i + "\nresolution=" + bundle + "\nbundle=" + bundle2);
            }
            Status zzb = zzn.zza(i, null, bundle);
            if (bundle2 != null) {
                str = bundle2.getString("avatarurl");
            }
            this.zzbjh.zzv(new zzs(zzb, str));
        }
    }

    private static final class zzs implements SetAvatarResult {
        private final String zzE;
        private final Status zzVy;

        public zzs(Status status, String str) {
            this.zzVy = status;
            this.zzE = str;
        }

        public Status getStatus() {
            return this.zzVy;
        }

        public String getUrl() {
            return this.zzE;
        }
    }

    private static final class zzt extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<LoadCirclesResult> zzbjh;

        public zzt(com.google.android.gms.common.api.internal.zza.zzb<LoadCirclesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadCirclesResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadCirclesResult;
        }

        public void zza(int i, Bundle bundle, DataHolder dataHolder) {
            CircleBuffer circleBuffer = null;
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Circles callback: status=" + i + "\nresolution=" + bundle + "\nholder=" + dataHolder);
            }
            Status zzb = zzn.zza(i, null, bundle);
            if (dataHolder != null) {
                circleBuffer = new CircleBuffer(dataHolder);
            }
            this.zzbjh.zzv(new zze(zzb, circleBuffer));
        }
    }

    private static final class zzu extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<PreferredFieldsResult> zzbjh;

        public zzu(com.google.android.gms.common.api.internal.zza.zzb<PreferredFieldsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Autocomplete_PreferredFieldsResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Autocomplete_PreferredFieldsResult;
        }

        public void zza(int i, Bundle bundle, DataHolder dataHolder) {
            ContactGroupPreferredFieldsBuffer contactGroupPreferredFieldsBuffer = null;
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Contact group preferred field callback: status=" + i + "\nresolution=" + bundle + "\nholder=" + dataHolder);
            }
            Status zzb = zzn.zza(i, null, bundle);
            if (dataHolder != null) {
                contactGroupPreferredFieldsBuffer = new ContactGroupPreferredFieldsBuffer(dataHolder);
            }
            this.zzbjh.zzv(new zzas(zzb, contactGroupPreferredFieldsBuffer));
        }
    }

    private static final class zzv extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<LoadContactsGaiaIdsResult> zzbjh;

        public zzv(com.google.android.gms.common.api.internal.zza.zzb<LoadContactsGaiaIdsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadContactsGaiaIdsResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadContactsGaiaIdsResult;
        }

        public void zza(int i, Bundle bundle, DataHolder dataHolder) {
            ContactGaiaIdBuffer contactGaiaIdBuffer = null;
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "GaiaId callback: status=" + i + "\nresolution=" + bundle + "\nholder=" + dataHolder);
            }
            Status zzb = zzn.zza(i, null, bundle);
            if (dataHolder != null) {
                contactGaiaIdBuffer = new ContactGaiaIdBuffer(dataHolder);
            }
            this.zzbjh.zzv(new zzf(zzb, contactGaiaIdBuffer));
        }
    }

    public static final class zzw extends zza {
        private final com.google.android.gms.common.api.internal.zzr<OnDataChanged> zzbEw;

        public zzw(com.google.android.gms.common.api.internal.zzr<OnDataChanged> com_google_android_gms_common_api_internal_zzr_com_google_android_gms_people_Notifications_OnDataChanged) {
            this.zzbEw = com_google_android_gms_common_api_internal_zzr_com_google_android_gms_people_Notifications_OnDataChanged;
        }

        public void release() {
            this.zzbEw.clear();
        }

        public void zza(int i, Bundle bundle, Bundle bundle2) {
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Bundle callback: status=" + i + "\nresolution=" + bundle + "\nbundle=" + bundle2);
            }
            if (i != 0) {
                zzo.zzI("PeopleClient", "Non-success data changed callback received.");
            } else {
                this.zzbEw.zza(new zzg(bundle2.getString("account"), bundle2.getString("pagegaiaid"), bundle2.getInt("scope")));
            }
        }
    }

    private static final class zzx extends zza {
        private final zzh zzbEx;

        public zzx(zzh com_google_android_gms_people_internal_zzn_zzh) {
            this.zzbEx = com_google_android_gms_people_internal_zzn_zzh;
        }

        public synchronized void zza(int i, Bundle bundle, Bundle bundle2) {
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "GetById callback: status=" + i + "\nresolution=" + bundle + "\ncontent=" + bundle2);
            }
            this.zzbEx.zza(i, bundle, bundle2);
        }
    }

    private static final class zzy extends zza {
        private final zzi zzbEy;

        public zzy(zzi com_google_android_gms_people_internal_zzn_zzi) {
            this.zzbEy = com_google_android_gms_people_internal_zzn_zzi;
        }

        public synchronized void zza(int i, Bundle bundle, Bundle bundle2) {
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "identityList callback: status=" + i + "\nresolution=" + bundle + "\ncontent=" + bundle2);
            }
            this.zzbEy.zza(i, bundle, bundle2);
        }
    }

    private static final class zzz extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<BundleResult> zzbjh;

        public zzz(com.google.android.gms.common.api.internal.zza.zzb<BundleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_People_BundleResult) {
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_People_BundleResult;
        }

        public void zza(int i, Bundle bundle, Bundle bundle2) {
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Bundle callback: status=" + i + "\nresolution=" + bundle + "\nbundle=" + bundle2);
            }
            this.zzbjh.zzv(new zzaa(zzn.zza(i, null, bundle), bundle2));
        }
    }

    public zzn(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf) {
        super(context.getApplicationContext(), looper, 5, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.mContext = context;
        this.zzbEd = str;
        this.zzVx = com_google_android_gms_common_internal_zzf.zzqP();
    }

    private synchronized long zzJq() {
        if (this.zzbEh == null) {
            zzJr();
        }
        return this.zzbEh.longValue();
    }

    private synchronized void zzJr() {
        this.zzbEh = Long.valueOf(zzp.zzaU(getContext()).nextLong());
    }

    private static PendingIntent zzV(Bundle bundle) {
        return bundle == null ? null : (PendingIntent) bundle.getParcelable("pendingIntent");
    }

    private static Status zza(int i, String str, Bundle bundle) {
        return new Status(i, str, zzV(bundle));
    }

    private void zza(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleForAspenResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_InternalApi_LoadPeopleForAspenResult, String str, String str2, String str3, int i, String str4) {
        zzAL();
        Object com_google_android_gms_people_internal_zzn_zzag = new zzag(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_InternalApi_LoadPeopleForAspenResult);
        try {
            zzJp().zzb(com_google_android_gms_people_internal_zzn_zzag, str, str2, str3, i, str4);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzag.zza(8, null, null);
        }
    }

    private void zza(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPeopleResult, String str, String str2, String str3, Collection<String> collection, int i, boolean z, long j, String str4, int i2, int i3, int i4) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzaf = new zzaf(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPeopleResult);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzaf, str, str2, str3, com.google.android.gms.common.util.zzb.zze(collection), i, z, j, str4, i2, i3, i4);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzaf.zza(8, null, null);
        }
    }

    private static PersonBuffer zzaj(DataHolder dataHolder) {
        return dataHolder == null ? null : new PersonBuffer(dataHolder, new PhoneDecoder(zzbEg), new EmailDecoder(zzbEf));
    }

    private static ConnectionResult zzh(int i, Bundle bundle) {
        return new ConnectionResult(i, zzV(bundle));
    }

    public void disconnect() {
        synchronized (this.zzbEe) {
            if (isConnected()) {
                for (zzf com_google_android_gms_people_internal_zzf : this.zzbEe.values()) {
                    com_google_android_gms_people_internal_zzf.release();
                    try {
                        zzJp().zza(com_google_android_gms_people_internal_zzf, false, null, null, 0);
                    } catch (Throwable e) {
                        zzo.zzb("PeopleClient", "Failed to unregister listener", e);
                    } catch (Throwable e2) {
                        zzo.zzb("PeopleClient", "PeopleService is in unexpected state", e2);
                    }
                }
            }
            this.zzbEe.clear();
        }
        super.disconnect();
    }

    public boolean isSyncToContactsEnabled() throws RemoteException {
        zzAL();
        return zzJp().isSyncToContactsEnabled();
    }

    protected void zzAL() {
        super.zzrc();
    }

    protected zzg zzJp() throws DeadObjectException {
        return (zzg) super.zzrd();
    }

    public synchronized void zzU(Bundle bundle) {
        if (bundle != null) {
            com.google.android.gms.people.internal.agg.zzd.zzaT(bundle.getBoolean("use_contactables_api", true));
            zzm.zzbEa.zzT(bundle);
            zzbEf = bundle.getBundle("config.email_type_map");
            zzbEg = bundle.getBundle("config.phone_type_map");
        }
    }

    public com.google.android.gms.common.internal.zzq zza(com.google.android.gms.common.api.internal.zza.zzb<LoadImageResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult, long j) {
        com.google.android.gms.common.internal.zzq com_google_android_gms_common_internal_zzq = null;
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzae = new zzae(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult);
        try {
            com_google_android_gms_common_internal_zzq = zzJp().zzb(com_google_android_gms_people_internal_zzn_zzae, j, true);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzae.zza(8, com_google_android_gms_common_internal_zzq, com_google_android_gms_common_internal_zzq, com_google_android_gms_common_internal_zzq);
        }
        return com_google_android_gms_common_internal_zzq;
    }

    public com.google.android.gms.common.internal.zzq zza(com.google.android.gms.common.api.internal.zza.zzb<LoadImageResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult, AvatarReference avatarReference, LoadImageOptions loadImageOptions) {
        com.google.android.gms.common.internal.zzq com_google_android_gms_common_internal_zzq = null;
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzae = new zzae(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult);
        try {
            com_google_android_gms_common_internal_zzq = zzJp().zza(com_google_android_gms_people_internal_zzn_zzae, avatarReference, ParcelableLoadImageOptions.zza(loadImageOptions));
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzae.zza(8, com_google_android_gms_common_internal_zzq, com_google_android_gms_common_internal_zzq, com_google_android_gms_common_internal_zzq);
        }
        return com_google_android_gms_common_internal_zzq;
    }

    public com.google.android.gms.common.internal.zzq zza(com.google.android.gms.common.api.internal.zza.zzb<LoadImageResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult, String str, int i, int i2) {
        com.google.android.gms.common.internal.zzq com_google_android_gms_common_internal_zzq = null;
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzae = new zzae(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult);
        try {
            com_google_android_gms_common_internal_zzq = zzJp().zzb(com_google_android_gms_people_internal_zzn_zzae, str, i, i2);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzae.zza(8, com_google_android_gms_common_internal_zzq, com_google_android_gms_common_internal_zzq, com_google_android_gms_common_internal_zzq);
        }
        return com_google_android_gms_common_internal_zzq;
    }

    public com.google.android.gms.common.internal.zzq zza(com.google.android.gms.common.api.internal.zza.zzb<LoadPhoneNumbersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPhoneNumbersResult, String str, Bundle bundle) {
        com.google.android.gms.common.internal.zzq com_google_android_gms_common_internal_zzq = null;
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzah = new zzah(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPhoneNumbersResult, this.mContext);
        try {
            com_google_android_gms_common_internal_zzq = zzJp().zzb(com_google_android_gms_people_internal_zzn_zzah, str, null, bundle);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzah.zza(8, (Bundle) com_google_android_gms_common_internal_zzq, (Bundle) com_google_android_gms_common_internal_zzq);
        }
        return com_google_android_gms_common_internal_zzq;
    }

    public com.google.android.gms.common.internal.zzq zza(com.google.android.gms.common.api.internal.zza.zzb<LoadImageResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult, String str, String str2, int i) {
        com.google.android.gms.common.internal.zzq com_google_android_gms_common_internal_zzq = null;
        Object com_google_android_gms_people_internal_zzn_zzae = new zzae(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult);
        try {
            com_google_android_gms_common_internal_zzq = zzJp().zzc(com_google_android_gms_people_internal_zzn_zzae, str, str2, i);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzae.zza(8, com_google_android_gms_common_internal_zzq, com_google_android_gms_common_internal_zzq, com_google_android_gms_common_internal_zzq);
        }
        return com_google_android_gms_common_internal_zzq;
    }

    public com.google.android.gms.common.internal.zzq zza(zzd com_google_android_gms_people_internal_zzn_zzd, String str, String str2, long j, int i) {
        com.google.android.gms.common.internal.zzq com_google_android_gms_common_internal_zzq = null;
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzb = new zzb(com_google_android_gms_people_internal_zzn_zzd);
        try {
            com_google_android_gms_common_internal_zzq = zzJp().zza(com_google_android_gms_people_internal_zzn_zzb, str, new ParcelableLoadAutocompleteResultsOptions(i, j, str2));
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzb.zza(8, com_google_android_gms_common_internal_zzq, com_google_android_gms_common_internal_zzq);
        }
        return com_google_android_gms_common_internal_zzq;
    }

    public zzw zza(GoogleApiClient googleApiClient, OnDataChanged onDataChanged) {
        zzw com_google_android_gms_people_internal_zzn_zzw;
        synchronized (this.zzbEe) {
            if (this.zzbEe.containsKey(onDataChanged)) {
                com_google_android_gms_people_internal_zzn_zzw = (zzw) this.zzbEe.get(onDataChanged);
            } else {
                com_google_android_gms_people_internal_zzn_zzw = new zzw(googleApiClient.zzu(onDataChanged));
                this.zzbEe.put(onDataChanged, com_google_android_gms_people_internal_zzn_zzw);
            }
        }
        return com_google_android_gms_people_internal_zzn_zzw;
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            zzU(bundle.getBundle("post_init_configuration"));
        }
        super.zza(i, iBinder, bundle == null ? null : bundle.getBundle("post_init_resolution"), i2);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<BundleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_People_BundleResult, Bundle bundle) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzz = new zzz(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_People_BundleResult);
        try {
            zzJp().zzb(com_google_android_gms_people_internal_zzn_zzz, bundle);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzz.zza(8, null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<com.google.android.gms.common.api.Result> r10, com.google.android.gms.people.model.AutocompleteBuffer r11, int r12, int r13, long r14) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:80)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        r9.zzAL();
        r0 = r11.isClosed();
        if (r0 != 0) goto L_0x0031;
    L_0x0009:
        r0 = 1;
    L_0x000a:
        r1 = "AutocompleteBuffer is released.";
        com.google.android.gms.common.internal.zzx.zzb(r0, r1);
        r0 = 0;
        r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        if (r0 != 0) goto L_0x0048;
    L_0x0015:
        r6 = r9.zzJq();
    L_0x0019:
        r2 = new com.google.android.gms.people.internal.zzn$zzab;
        r2.<init>(r10);
        r1 = r9.zzJp();	 Catch:{ RemoteException -> 0x0033, all -> 0x0041 }
        r3 = r11.zzuK();	 Catch:{ RemoteException -> 0x0033, all -> 0x0041 }
        r4 = r12;	 Catch:{ RemoteException -> 0x0033, all -> 0x0041 }
        r5 = r13;	 Catch:{ RemoteException -> 0x0033, all -> 0x0041 }
        r1.zza(r2, r3, r4, r5, r6);	 Catch:{ RemoteException -> 0x0033, all -> 0x0041 }
        if (r12 < 0) goto L_0x0030;
    L_0x002d:
        r9.zzJr();
    L_0x0030:
        return;
    L_0x0031:
        r0 = 0;
        goto L_0x000a;
    L_0x0033:
        r0 = move-exception;
        r0 = 8;
        r1 = 0;
        r3 = 0;
        r2.zza(r0, r1, r3);	 Catch:{ RemoteException -> 0x0033, all -> 0x0041 }
        if (r12 < 0) goto L_0x0030;
    L_0x003d:
        r9.zzJr();
        goto L_0x0030;
    L_0x0041:
        r0 = move-exception;
        if (r12 < 0) goto L_0x0047;
    L_0x0044:
        r9.zzJr();
    L_0x0047:
        throw r0;
    L_0x0048:
        r6 = r14;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.people.internal.zzn.zza(com.google.android.gms.common.api.internal.zza$zzb, com.google.android.gms.people.model.AutocompleteBuffer, int, int, long):void");
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<AutocompleteResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Autocomplete_AutocompleteResult, String str, AutocompleteOptions autocompleteOptions) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzq = new zzq(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Autocomplete_AutocompleteResult);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzq, autocompleteOptions.account, autocompleteOptions.pageId, autocompleteOptions.isDirectorySearch, autocompleteOptions.directoryAccountType, str, autocompleteOptions.autocompleteType, autocompleteOptions.searchOptions, autocompleteOptions.numberOfResults, autocompleteOptions.useAndroidContactFallback);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzq.zza(8, null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<SetAvatarResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_SetAvatarResult, String str, String str2, Uri uri, boolean z) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzr = new zzr(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_SetAvatarResult);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzr, str, str2, uri, z);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzr.zza(8, null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPeopleResult, String str, String str2, LoadPeopleOptions loadPeopleOptions) {
        if (loadPeopleOptions == null) {
            loadPeopleOptions = LoadPeopleOptions.zzbzF;
        }
        zza((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPeopleResult, str, str2, loadPeopleOptions.getCircleId(), loadPeopleOptions.getQualifiedIds(), loadPeopleOptions.getProjection(), loadPeopleOptions.isPeopleOnly(), loadPeopleOptions.getChangedSince(), loadPeopleOptions.getQuery(), loadPeopleOptions.getSearchFields(), loadPeopleOptions.getSortOrder(), loadPeopleOptions.getExtraColumns());
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleForAspenResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_InternalApi_LoadPeopleForAspenResult, String str, String str2, LoadPeopleForAspenOptions loadPeopleForAspenOptions) {
        if (loadPeopleForAspenOptions == null) {
            loadPeopleForAspenOptions = LoadPeopleForAspenOptions.zzbzJ;
        }
        zza((com.google.android.gms.common.api.internal.zza.zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_InternalApi_LoadPeopleForAspenResult, str, str2, loadPeopleForAspenOptions.getQuery(), loadPeopleForAspenOptions.getPageSize(), loadPeopleForAspenOptions.getPageToken());
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Result> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result, String str, String str2, String str3) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzab = new zzab(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzab, str, str2, str3);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzab.zza(8, null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<LoadCirclesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadCirclesResult, String str, String str2, String str3, int i, String str4, boolean z) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzt = new zzt(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadCirclesResult);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzt, str, str2, str3, i, str4, z);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzt.zza(8, null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<LoadPeopleForAggregationResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPeopleForAggregationResult, String str, String str2, String str3, int i, boolean z, int i2, int i3, String str4, boolean z2, int i4, int i5) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzan = new zzan(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadPeopleForAggregationResult);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzan, str, str2, str3, i, z, i2, i3, str4, z2, i4, i5);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzan.zza(8, null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Result> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result, String str, String str2, String str3, String str4, Boolean bool, String str5) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzab = new zzab(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzab, str, str2, str3, str4, PeopleConstants.booleanToTriState(bool), str5);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzab.zza(8, null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<AddCircleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_GraphUpdate_AddCircleResult, String str, String str2, String str3, String str4, boolean z) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzl = new zzl(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_GraphUpdate_AddCircleResult);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzl, str, str2, str3, str4, z);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzl.zza(8, null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<UpdatePersonCircleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_GraphUpdate_UpdatePersonCircleResult, String str, String str2, String str3, List<String> list, List<String> list2, FavaDiagnosticsEntity favaDiagnosticsEntity) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzai = new zzai(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_GraphUpdate_UpdatePersonCircleResult);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzai, str, str2, str3, (List) list, (List) list2, favaDiagnosticsEntity);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzai.zza(8, null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Result> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result, String str, String str2, String str3, boolean z) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzab = new zzab(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzab, str, str2, str3, z);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzab.zza(8, null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<LoadAggregatedPeopleResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadAggregatedPeopleResult, String str, String str2, boolean z, String str3, boolean z2, int i, int i2, String str4, boolean z3, int i3) {
        int i4;
        zzAL();
        if (i3 == 0 || !TextUtils.isEmpty(str3)) {
            i4 = i3;
        } else {
            zzo.zzI("PeopleClient", "Ignoring custom sort order for all aggregation.");
            i4 = 0;
        }
        com.google.android.gms.people.internal.agg.zzd zza = com.google.android.gms.people.internal.agg.zzd.zza(getContext(), new zzam(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadAggregatedPeopleResult), z, i2, zzbEf, zzbEg, str3, str4);
        zzf com_google_android_gms_people_internal_zzn_zzp = new zzp(zza);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzp, str, str2, str3, 7, z2, i, i2, str4, z3, i4, 3);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzp.zza(8, null, null);
        }
        zza.zzJL();
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Result> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result, String str, boolean z, String[] strArr) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzab = new zzab(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzab, str, z, strArr);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzab.zza(8, null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<LoadOwnersResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadOwnersResult, boolean z, boolean z2, String str, String str2, int i) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzad = new zzad(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadOwnersResult);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzad, z, z2, str, str2, i);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzad.zza(8, null, null);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(com.google.android.gms.people.Notifications.OnDataChanged r8) throws android.os.RemoteException {
        /*
        r7 = this;
        r6 = r7.zzbEe;
        monitor-enter(r6);
        r7.zzAL();	 Catch:{ all -> 0x0035 }
        r0 = r7.zzbEe;	 Catch:{ all -> 0x0035 }
        r0 = r0.containsKey(r8);	 Catch:{ all -> 0x0035 }
        if (r0 != 0) goto L_0x0015;
    L_0x000e:
        r0 = r7.zzbEe;	 Catch:{ all -> 0x0032 }
        r0.remove(r8);	 Catch:{ all -> 0x0032 }
        monitor-exit(r6);	 Catch:{ all -> 0x0032 }
    L_0x0014:
        return;
    L_0x0015:
        r0 = r7.zzbEe;	 Catch:{ all -> 0x0035 }
        r1 = r0.get(r8);	 Catch:{ all -> 0x0035 }
        r1 = (com.google.android.gms.people.internal.zzn.zzw) r1;	 Catch:{ all -> 0x0035 }
        r1.release();	 Catch:{ all -> 0x0035 }
        r0 = r7.zzJp();	 Catch:{ all -> 0x0035 }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r0.zza(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0035 }
        r0 = r7.zzbEe;	 Catch:{ all -> 0x0032 }
        r0.remove(r8);	 Catch:{ all -> 0x0032 }
        monitor-exit(r6);	 Catch:{ all -> 0x0032 }
        goto L_0x0014;
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r0 = move-exception;
        r1 = r7.zzbEe;	 Catch:{ all -> 0x0032 }
        r1.remove(r8);	 Catch:{ all -> 0x0032 }
        throw r0;	 Catch:{ all -> 0x0032 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.people.internal.zzn.zza(com.google.android.gms.people.Notifications$OnDataChanged):void");
    }

    public <PersonType> void zza(zzh com_google_android_gms_people_internal_zzn_zzh, GetOptions getOptions, String... strArr) {
        com.google.android.gms.common.internal.zzx.zzD(strArr);
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzx = new zzx(com_google_android_gms_people_internal_zzn_zzh);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzx, new AccountToken(getOptions.zzbAa.accountName, getOptions.zzbAa.pageId), Arrays.asList(strArr), new ParcelableGetOptions(getOptions));
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzx.zza(8, null, new Bundle());
        }
    }

    public <PersonType> void zza(zzi com_google_android_gms_people_internal_zzn_zzi, ListOptions listOptions) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzy = new zzy(com_google_android_gms_people_internal_zzn_zzi);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzy, new AccountToken(listOptions.zzbAa.accountName, listOptions.zzbAa.pageId), new ParcelableListOptions(listOptions));
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzy.zza(8, null, new Bundle());
        }
    }

    public void zza(zzw com_google_android_gms_people_internal_zzn_zzw, String str, String str2, int i) throws RemoteException {
        zzAL();
        synchronized (this.zzbEe) {
            zzJp().zza((zzf) com_google_android_gms_people_internal_zzn_zzw, true, str, str2, i);
        }
    }

    public void zzaS(boolean z) throws RemoteException {
        zzAL();
        zzJp().zzaS(z);
    }

    protected /* synthetic */ IInterface zzaa(IBinder iBinder) {
        return zzgl(iBinder);
    }

    public com.google.android.gms.common.internal.zzq zzb(com.google.android.gms.common.api.internal.zza.zzb<LoadImageResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult, String str, String str2, int i, int i2) {
        zzf com_google_android_gms_people_internal_zzn_zzae = new zzae(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult);
        try {
            return zzJp().zzb(com_google_android_gms_people_internal_zzn_zzae, str, str2, i, i2);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzae.zza(8, null, null, null);
            return null;
        }
    }

    public void zzb(com.google.android.gms.common.api.internal.zza.zzb<LoadContactsGaiaIdsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadContactsGaiaIdsResult, String str, String str2, int i) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzv = new zzv(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Graph_LoadContactsGaiaIdsResult);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzv, str, str2, i);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzv.zza(8, null, null);
        }
    }

    public void zzb(String str, String str2, long j, boolean z, boolean z2) throws RemoteException {
        zzAL();
        zzJp().zza(str, str2, j, z, z2);
    }

    public void zzd(com.google.android.gms.common.api.internal.zza.zzb<Result> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result, String str, String str2, boolean z) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzab = new zzab(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result);
        try {
            zzJp().zzb(com_google_android_gms_people_internal_zzn_zzab, str, null, str2, z);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzab.zza(8, null, null);
        }
    }

    public void zze(com.google.android.gms.common.api.internal.zza.zzb<LoadAddToCircleConsentResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_GraphUpdate_LoadAddToCircleConsentResult, String str, String str2) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzn = new zzn(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_GraphUpdate_LoadAddToCircleConsentResult);
        try {
            zzJp().zzb(com_google_android_gms_people_internal_zzn_zzn, str, str2);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzn.zza(8, null, null);
        }
    }

    public void zzf(com.google.android.gms.common.api.internal.zza.zzb<Result> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result, String str, String str2) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzab = new zzab(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result);
        try {
            zzJp().zzc(com_google_android_gms_people_internal_zzn_zzab, str, str2);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzab.zza(8, null, null);
        }
    }

    public com.google.android.gms.common.internal.zzq zzg(com.google.android.gms.common.api.internal.zza.zzb<PreferredFieldsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Autocomplete_PreferredFieldsResult, String str, String str2) {
        com.google.android.gms.common.internal.zzq com_google_android_gms_common_internal_zzq = null;
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzu = new zzu(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Autocomplete_PreferredFieldsResult);
        try {
            com_google_android_gms_common_internal_zzq = zzJp().zza(com_google_android_gms_people_internal_zzn_zzu, str, new ParcelableLoadContactGroupFieldsOptions(str2));
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzu.zza(8, com_google_android_gms_common_internal_zzq, com_google_android_gms_common_internal_zzq);
        }
        return com_google_android_gms_common_internal_zzq;
    }

    public void zzg(com.google.android.gms.common.api.internal.zza.zzb<Result> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result, String str, int i) {
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzab = new zzab(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Result);
        try {
            zzJp().zza(com_google_android_gms_people_internal_zzn_zzab, str, i);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzab.zza(8, null, null);
        }
    }

    protected String zzgC() {
        return "com.google.android.gms.people.service.START";
    }

    protected String zzgD() {
        return "com.google.android.gms.people.internal.IPeopleService";
    }

    protected zzg zzgl(IBinder iBinder) {
        return com.google.android.gms.people.internal.zzg.zza.zzgk(iBinder);
    }

    protected Bundle zzkd() {
        Bundle bundle = new Bundle();
        bundle.putString("social_client_application_id", this.zzbEd);
        bundle.putString("real_client_package_name", this.zzVx);
        bundle.putBoolean("support_new_image_callback", true);
        return bundle;
    }

    public void zzq(Uri uri) throws RemoteException {
        zzAL();
        zzJp().zzp(uri);
    }

    public com.google.android.gms.common.internal.zzq zzr(com.google.android.gms.common.api.internal.zza.zzb<LoadImageResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult, String str) {
        com.google.android.gms.common.internal.zzq com_google_android_gms_common_internal_zzq = null;
        zzAL();
        zzf com_google_android_gms_people_internal_zzn_zzae = new zzae(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_people_Images_LoadImageResult);
        try {
            com_google_android_gms_common_internal_zzq = zzJp().zzb(com_google_android_gms_people_internal_zzn_zzae, str);
        } catch (RemoteException e) {
            com_google_android_gms_people_internal_zzn_zzae.zza(8, com_google_android_gms_common_internal_zzq, com_google_android_gms_common_internal_zzq, com_google_android_gms_common_internal_zzq);
        }
        return com_google_android_gms_common_internal_zzq;
    }
}

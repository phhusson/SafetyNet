package com.google.android.gms.people.identity.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzt;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.people.People;
import com.google.android.gms.people.PeopleConstants.Endpoints;
import com.google.android.gms.people.identity.IdentityApi;
import com.google.android.gms.people.identity.IdentityApi.CustomPersonListResult;
import com.google.android.gms.people.identity.IdentityApi.CustomPersonResult;
import com.google.android.gms.people.identity.IdentityApi.GetOptions;
import com.google.android.gms.people.identity.IdentityApi.ListOptions;
import com.google.android.gms.people.identity.IdentityApi.PersonListResult;
import com.google.android.gms.people.identity.IdentityApi.PersonResult;
import com.google.android.gms.people.identity.PersonFactory;
import com.google.android.gms.people.identity.PersonFactory.ContactData;
import com.google.android.gms.people.identity.PersonFactory.OfflineDatabaseData;
import com.google.android.gms.people.identity.PersonFactory.ServiceData;
import com.google.android.gms.people.identity.PersonListFactory;
import com.google.android.gms.people.identity.PersonListFactory.PersonListItemFactory;
import com.google.android.gms.people.identity.models.Person;
import com.google.android.gms.people.identity.models.PersonReference;
import com.google.android.gms.people.internal.zzn;
import com.google.android.gms.people.internal.zzn.zzi;
import com.google.android.gms.people.internal.zzo;
import com.google.android.gms.people.internal.zzp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzh implements IdentityApi {
    private static final PersonFactory<Person> zzbBm = new zzd();
    private static final PersonListFactory<PersonReference> zzbBn = new zzf();

    final class zza<PersonType> extends com.google.android.gms.people.People.zza<CustomPersonResult<PersonType>> implements com.google.android.gms.people.identity.internal.zzb.zza, com.google.android.gms.people.internal.zzn.zzh {
        private Context mContext;
        private ArrayList<Bundle> zzbBA;
        private DataHolder zzbBB;
        private DataHolder zzbBC;
        private DataHolder zzbBD;
        private DataHolder zzbBE;
        private DataHolder zzbBF;
        private DataHolder zzbBG;
        private DataHolder zzbBH;
        private DataHolder zzbBI;
        private DataHolder zzbBJ;
        private boolean zzbBK = false;
        private Status zzbBL;
        private ContactData[] zzbBM;
        final /* synthetic */ zzh zzbBN;
        private final PersonFactory<PersonType> zzbBs;
        private final Object[] zzbBt;
        private final GetOptions zzbBu;
        private final String[] zzbBv;
        private final Set<DataHolder> zzbBw = new HashSet();
        private final WeakReference<GoogleApiClient> zzbBx;
        private Status zzbBy;
        private boolean zzbBz = false;
        private com.google.android.gms.common.api.internal.zza.zzb<CustomPersonResult<PersonType>> zzbjh;

        public zza(zzh com_google_android_gms_people_identity_internal_zzh, GoogleApiClient googleApiClient, GetOptions getOptions, PersonFactory<PersonType> personFactory, String[] strArr) {
            int i = 0;
            this.zzbBN = com_google_android_gms_people_identity_internal_zzh;
            super(googleApiClient);
            this.zzbBx = new WeakReference(googleApiClient);
            this.zzbBu = getOptions;
            this.zzbBs = personFactory;
            this.zzbjh = this;
            this.zzbBv = strArr;
            this.zzbBt = new Object[strArr.length];
            while (i < this.zzbBt.length) {
                this.zzbBt[i] = new Object();
                i++;
            }
        }

        private void zzGo() {
            if (this.zzbjh != null) {
                com.google.android.gms.common.api.internal.zza.zza com_google_android_gms_common_api_internal_zza_zza;
                Status status = (this.zzbBu.useContactData && this.zzbBL == null) ? new Status(100) : (this.zzbBu.useWebData || this.zzbBu.useCachedData) ? !this.zzbBz ? new Status(100) : this.zzbBy : Status.zzaqL;
                final boolean z = status.getStatusCode() != 100;
                final boolean z2 = this.zzbBL != null;
                com.google.android.gms.common.api.internal.zza.zzb com_google_android_gms_common_api_internal_zza_zzb = this.zzbjh;
                GoogleApiClient googleApiClient = (GoogleApiClient) this.zzbBx.get();
                if (z || googleApiClient == null) {
                    com_google_android_gms_common_api_internal_zza_zza = null;
                } else {
                    com_google_android_gms_common_api_internal_zza_zza = new com.google.android.gms.common.api.internal.zza.zza<CustomPersonResult<PersonType>, zzn>(this, People.zzbzL, googleApiClient) {
                        final /* synthetic */ zza zzbBO;

                        protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                        }

                        protected /* synthetic */ Result zzb(Status status) {
                            return zzce(status);
                        }

                        protected CustomPersonResult<PersonType> zzce(Status status) {
                            return zzh.zzca(status);
                        }
                    };
                    if (googleApiClient.isConnected()) {
                        googleApiClient.zzb(com_google_android_gms_common_api_internal_zza_zza);
                    }
                }
                this.zzbjh = com_google_android_gms_common_api_internal_zza_zza;
                if (zzo.zzJx()) {
                    zzo.zzG("PeopleClient", "Status: " + status + (z ? " (Final Result)" : " (Staged Result)"));
                }
                if (zzo.zzJy()) {
                    zzo.zzaj("PeopleClient", "old callback: " + com_google_android_gms_common_api_internal_zza_zzb);
                    zzo.zzaj("PeopleClient", "new callback: " + com_google_android_gms_common_api_internal_zza_zza);
                }
                final DataBuffer c05732 = new DataBuffer<PersonType>(this) {
                    final /* synthetic */ zza zzbBO;

                    public void close() {
                        release();
                    }

                    public PersonType get(int position) {
                        return this.zzbBO.zzbBs.build(this.zzbBO.mContext, this.zzbBO.zzbBt[position], this.zzbBO.zzbBA == null ? null : ServiceData.zzS((Bundle) this.zzbBO.zzbBA.get(position)), this.zzbBO.zzbBM == null ? null : this.zzbBO.zzbBM[position], this.zzbBO.zzbBB == null ? null : OfflineDatabaseData.build(this.zzbBO.zzbBB, this.zzbBO.zzbBC, this.zzbBO.zzbBD, this.zzbBO.zzbBE, this.zzbBO.zzbBF, this.zzbBO.zzbBG, this.zzbBO.zzbBH, this.zzbBO.zzbBI, this.zzbBO.zzbBJ, position));
                    }

                    public int getCount() {
                        return this.zzbBO.zzbBt.length;
                    }

                    public boolean isClosed() {
                        return false;
                    }

                    public Iterator<PersonType> iterator() {
                        return new com.google.android.gms.common.data.zzb(this);
                    }

                    public void release() {
                        if (com_google_android_gms_common_api_internal_zza_zza != null) {
                            com_google_android_gms_common_api_internal_zza_zza.cancel();
                        }
                        for (DataHolder close : this.zzbBO.zzbBw) {
                            close.close();
                        }
                    }

                    public Iterator<PersonType> singleRefIterator() {
                        return iterator();
                    }

                    public Bundle zzqt() {
                        return null;
                    }
                };
                com_google_android_gms_common_api_internal_zza_zzb.zzv(new CustomPersonResult<PersonType>(this) {
                    final /* synthetic */ zza zzbBO;

                    public PendingResult<CustomPersonResult<PersonType>> getNextPendingResult() {
                        return com_google_android_gms_common_api_internal_zza_zza;
                    }

                    public DataBuffer<PersonType> getPersonBuffer() {
                        return c05732;
                    }

                    public Status getStatus() {
                        return status;
                    }

                    public boolean isLocalResultComplete() {
                        return z2;
                    }

                    public boolean isResultComplete() {
                        return z;
                    }

                    public void release() {
                        c05732.release();
                    }
                });
            }
        }

        private void zzai(DataHolder dataHolder) {
            int i;
            int i2 = 0;
            Set[] setArr = new Set[this.zzbBv.length];
            for (i = 0; i < setArr.length; i++) {
                setArr[i] = new HashSet();
                setArr[i].add(this.zzbBv[i]);
            }
            if (dataHolder != null) {
                Map hashMap = new HashMap();
                for (int i3 = 0; i3 < dataHolder.getCount(); i3++) {
                    i = dataHolder.zzcZ(i3);
                    String string = dataHolder.getString(Endpoints.KEY_TARGET_GAIA_ID, i3, i);
                    String string2 = dataHolder.getString("contact_id", i3, i);
                    Set set = (Set) hashMap.get(string);
                    if (set == null) {
                        set = new HashSet();
                        hashMap.put(string, set);
                    }
                    set.add(string2);
                }
                while (i2 < setArr.length) {
                    if (zzp.zzhU(this.zzbBv[i2])) {
                        Set<String> set2 = (Set) hashMap.get(zzp.zzhP(this.zzbBv[i2]));
                        if (set2 != null) {
                            for (String zzfU : set2) {
                                setArr[i2].add(zzc.zzfU(zzfU));
                            }
                        }
                    }
                    i2++;
                }
            }
            zzb.zza((com.google.android.gms.people.identity.internal.zzb.zza) this, this.mContext, this.zzbBu.zzbAa.accountName, setArr);
        }

        public synchronized void zza(int i, Bundle bundle, Bundle bundle2) {
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "GetById callback: status=" + i + "\nresolution=" + bundle + "\ncontent=" + bundle2);
            }
            try {
                bundle2.setClassLoader(getClass().getClassLoader());
                this.zzbBy = new Status(i);
                this.zzbBA = bundle2.getParcelableArrayList("get.server_blob");
                this.zzbBz = bundle2.getBoolean("response_complete");
                DataHolder dataHolder = (DataHolder) bundle2.getParcelable("gaia_map");
                if (dataHolder != null) {
                    if (this.zzbBu.useContactData && !this.zzbBK) {
                        this.zzbBK = true;
                        zzai(dataHolder);
                    }
                    this.zzbBw.add(dataHolder);
                }
                Bundle bundle3 = bundle2.getBundle("db");
                if (bundle3 != null) {
                    for (String parcelable : bundle3.keySet()) {
                        this.zzbBw.add((DataHolder) bundle3.getParcelable(parcelable));
                    }
                    this.zzbBB = (DataHolder) bundle3.getParcelable("people");
                    this.zzbBC = (DataHolder) bundle3.getParcelable("people_address");
                    this.zzbBD = (DataHolder) bundle3.getParcelable("people_email");
                    this.zzbBE = (DataHolder) bundle3.getParcelable("people_phone");
                    this.zzbBF = (DataHolder) bundle3.getParcelable("owner");
                    this.zzbBG = (DataHolder) bundle3.getParcelable("owner_address");
                    this.zzbBH = (DataHolder) bundle3.getParcelable("owner_email");
                    this.zzbBI = (DataHolder) bundle3.getParcelable("owner_phone");
                    this.zzbBJ = (DataHolder) bundle3.getParcelable("circles");
                }
                if (this.zzbBA != null) {
                    zzx.zzad(this.zzbBt.length == this.zzbBA.size());
                }
                zzGo();
            } catch (Throwable th) {
                zzo.zzb("PeopleClient", "GetById callback error:", th);
            }
        }

        public synchronized void zza(Status status, ContactData[] contactDataArr) {
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "GetById CP2 callback: status=" + status + " result=" + String.valueOf(contactDataArr));
            }
            try {
                this.zzbBL = status;
                this.zzbBM = contactDataArr;
                if (this.zzbBM != null) {
                    zzx.zzad(this.zzbBt.length == this.zzbBM.length);
                }
                zzGo();
            } catch (Throwable th) {
                zzo.zzb("PeopleClient", "GetById CP2 callback error:", th);
            }
        }

        protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
            this.mContext = com_google_android_gms_people_internal_zzn.getContext();
            if (this.zzbBu.zzbAa.accountName != null) {
                com_google_android_gms_people_internal_zzn.zza((com.google.android.gms.people.internal.zzn.zzh) this, this.zzbBu, this.zzbBv);
                return;
            }
            this.zzbBz = true;
            if (this.zzbBu.useCachedData || this.zzbBu.useWebData) {
                this.zzbBy = Status.zzaqN;
            } else {
                this.zzbBy = Status.zzaqL;
            }
            zzai(null);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzce(status);
        }

        protected CustomPersonResult<PersonType> zzce(Status status) {
            return zzh.zzca(status);
        }
    }

    final class zzb<PersonRefType> extends com.google.android.gms.people.People.zza<CustomPersonListResult<PersonRefType>> implements com.google.android.gms.people.identity.internal.zzb.zza {
        private Context mContext;
        private boolean zzbBK = false;
        private Status zzbBL;
        private ContactData[] zzbBM;
        final /* synthetic */ zzh zzbBN;
        private final PersonListFactory<PersonRefType> zzbBT;
        private final ListOptions zzbBU;
        private zzn zzbBV;
        private Bundle zzbBW;
        private final Set<DataHolder> zzbBw = new HashSet();
        private final WeakReference<GoogleApiClient> zzbBx;
        private Status zzbBy;
        private boolean zzbBz = false;
        private com.google.android.gms.common.api.internal.zza.zzb<CustomPersonListResult<PersonRefType>> zzbjh;

        private class zza implements com.google.android.gms.people.internal.zzn.zzh {
            final /* synthetic */ zzb zzbBX;

            private zza(zzb com_google_android_gms_people_identity_internal_zzh_zzb) {
                this.zzbBX = com_google_android_gms_people_identity_internal_zzh_zzb;
            }

            public void zza(int i, Bundle bundle, Bundle bundle2) {
                bundle2.setClassLoader(getClass().getClassLoader());
                DataHolder dataHolder = (DataHolder) bundle2.getParcelable("gaia_map");
                boolean z = bundle2.getBoolean("response_complete");
                if (dataHolder != null) {
                    this.zzbBX.zzbBw.add(dataHolder);
                }
                if (this.zzbBX.zzbBU.useContactData && !this.zzbBX.zzbBK) {
                    if (dataHolder != null || z) {
                        this.zzbBX.zzbBK = true;
                        this.zzbBX.zzai(dataHolder);
                    }
                }
            }
        }

        private class zzb implements zzi {
            final /* synthetic */ zzb zzbBX;

            private zzb(zzb com_google_android_gms_people_identity_internal_zzh_zzb) {
                this.zzbBX = com_google_android_gms_people_identity_internal_zzh_zzb;
            }

            public void zza(int i, Bundle bundle, Bundle bundle2) {
                bundle2.setClassLoader(getClass().getClassLoader());
                this.zzbBX.zzbBy = new Status(i);
                this.zzbBX.zzbBW = bundle2.getBundle("get.server_blob");
                this.zzbBX.zzbBz = bundle2.getBoolean("response_complete");
                String[] zzd = this.zzbBX.zzGp();
                if (this.zzbBX.zzbBU.useContactData && !this.zzbBX.zzbBK && zzd != null) {
                    if (zzd.length == 0) {
                        this.zzbBX.zzbBK = true;
                        this.zzbBX.zzai(null);
                        return;
                    }
                    this.zzbBX.zzbBV.zza(new zza(), new com.google.android.gms.people.identity.IdentityApi.GetOptions.zza().zzb(this.zzbBX.zzbBU.zzbAa).zzaB(false).zzaC(false).zzaD(true).zzGh(), zzd);
                }
            }
        }

        public zzb(zzh com_google_android_gms_people_identity_internal_zzh, GoogleApiClient googleApiClient, ListOptions listOptions, PersonListFactory<PersonRefType> personListFactory) {
            this.zzbBN = com_google_android_gms_people_identity_internal_zzh;
            super(googleApiClient);
            this.zzbBx = new WeakReference(googleApiClient);
            this.zzbBU = listOptions;
            this.zzbBT = personListFactory;
            this.zzbjh = this;
        }

        private String[] zzGp() {
            int i = 0;
            if (this.zzbjh == null) {
                return null;
            }
            com.google.android.gms.common.api.internal.zza.zza com_google_android_gms_common_api_internal_zza_zza;
            Status status = (this.zzbBU.useContactData && this.zzbBL == null) ? new Status(100) : (this.zzbBU.useWebData || this.zzbBU.useCachedData) ? !this.zzbBz ? new Status(100) : this.zzbBy : Status.zzaqL;
            final boolean z = status.getStatusCode() != 100;
            com.google.android.gms.common.api.internal.zza.zzb com_google_android_gms_common_api_internal_zza_zzb = this.zzbjh;
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zzbBx.get();
            if (z || googleApiClient == null) {
                com_google_android_gms_common_api_internal_zza_zza = null;
            } else {
                com_google_android_gms_common_api_internal_zza_zza = new com.google.android.gms.common.api.internal.zza.zza<CustomPersonListResult<PersonRefType>, zzn>(this, People.zzbzL, googleApiClient) {
                    final /* synthetic */ zzb zzbBX;

                    protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                    }

                    protected /* synthetic */ Result zzb(Status status) {
                        return zzcf(status);
                    }

                    protected CustomPersonListResult<PersonRefType> zzcf(Status status) {
                        return zzh.zzcb(status);
                    }
                };
                if (googleApiClient.isConnected()) {
                    googleApiClient.zzb(com_google_android_gms_common_api_internal_zza_zza);
                }
            }
            this.zzbjh = com_google_android_gms_common_api_internal_zza_zza;
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "Status: " + status + (z ? " (Final Result)" : " (Staged Result)"));
            }
            if (zzo.zzJy()) {
                zzo.zzaj("PeopleClient", "old callback: " + com_google_android_gms_common_api_internal_zza_zzb);
                zzo.zzaj("PeopleClient", "new callback: " + com_google_android_gms_common_api_internal_zza_zza);
            }
            final PersonListItemFactory buildList = this.zzbBT.buildList(ServiceData.zzS(this.zzbBW), this.zzbBM, null);
            Set hashSet = new HashSet();
            while (i < buildList.getCount()) {
                String qualifiedId = buildList.getQualifiedId(i);
                if (qualifiedId != null) {
                    hashSet.add(qualifiedId);
                }
                i++;
            }
            final DataBuffer c05762 = new DataBuffer<PersonRefType>(this) {
                final /* synthetic */ zzb zzbBX;

                public void close() {
                    release();
                }

                public PersonRefType get(int position) {
                    return buildList.get(position);
                }

                public int getCount() {
                    return buildList.getCount();
                }

                public boolean isClosed() {
                    return false;
                }

                public Iterator<PersonRefType> iterator() {
                    return new com.google.android.gms.common.data.zzb(this);
                }

                public void release() {
                    if (com_google_android_gms_common_api_internal_zza_zza != null) {
                        com_google_android_gms_common_api_internal_zza_zza.cancel();
                    }
                    for (DataHolder close : this.zzbBX.zzbBw) {
                        close.close();
                    }
                }

                public Iterator<PersonRefType> singleRefIterator() {
                    return iterator();
                }

                public Bundle zzqt() {
                    return null;
                }
            };
            com_google_android_gms_common_api_internal_zza_zzb.zzv(new CustomPersonListResult<PersonRefType>(this) {
                final /* synthetic */ zzb zzbBX;

                public PendingResult<CustomPersonListResult<PersonRefType>> getNextPendingResult() {
                    return com_google_android_gms_common_api_internal_zza_zza;
                }

                public DataBuffer<PersonRefType> getPersonBuffer() {
                    return c05762;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean isResultComplete() {
                    return z;
                }

                public void release() {
                    c05762.release();
                }
            });
            return (String[]) hashSet.toArray(new String[hashSet.size()]);
        }

        private void zzai(DataHolder dataHolder) {
            Set hashSet = new HashSet();
            if (dataHolder != null) {
                for (int i = 0; i < dataHolder.getCount(); i++) {
                    hashSet.add(zzc.zzfU(dataHolder.getString("contact_id", i, dataHolder.zzcZ(i))));
                }
            }
            zzb.zza((com.google.android.gms.people.identity.internal.zzb.zza) this, this.mContext, this.zzbBU.zzbAa.accountName, hashSet);
        }

        public void zza(Status status, ContactData[] contactDataArr) {
            if (zzo.zzJx()) {
                zzo.zzG("PeopleClient", "GetById CP2 callback: status=" + status + " result=" + String.valueOf(contactDataArr));
            }
            try {
                this.zzbBL = status;
                this.zzbBM = contactDataArr;
                zzGp();
            } catch (Throwable th) {
                zzo.zzb("PeopleClient", "GetById CP2 callback error:", th);
            }
        }

        protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
            this.zzbBV = com_google_android_gms_people_internal_zzn;
            this.mContext = com_google_android_gms_people_internal_zzn.mContext;
            if (this.zzbBU.zzbAa.accountName == null || !(this.zzbBU.useWebData || this.zzbBU.useCachedData)) {
                this.zzbBz = true;
                if (this.zzbBU.useCachedData || this.zzbBU.useWebData) {
                    this.zzbBy = Status.zzaqN;
                } else {
                    this.zzbBy = Status.zzaqL;
                }
                zzai(null);
                return;
            }
            com_google_android_gms_people_internal_zzn.zza(new zzb(), this.zzbBU);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzcf(status);
        }

        protected CustomPersonListResult<PersonRefType> zzcf(Status status) {
            return zzh.zzcb(status);
        }
    }

    private static PendingResult<PersonResult> zzb(PendingResult<CustomPersonResult<Person>> pendingResult) {
        return new zzt<CustomPersonResult<Person>, PersonResult>(pendingResult) {
            protected PersonResult zza(final CustomPersonResult<Person> customPersonResult) {
                return new PersonResult(this) {
                    final /* synthetic */ C05693 zzbBp;

                    public PendingResult<PersonResult> getNextPendingResult() {
                        return customPersonResult.getNextPendingResult() == null ? null : zzh.zzb(customPersonResult.getNextPendingResult());
                    }

                    public DataBuffer<Person> getPersonBuffer() {
                        return customPersonResult.getPersonBuffer();
                    }

                    public Status getStatus() {
                        return customPersonResult.getStatus();
                    }

                    public boolean isLocalResultComplete() {
                        return customPersonResult.isLocalResultComplete();
                    }

                    public boolean isResultComplete() {
                        return customPersonResult.isResultComplete();
                    }

                    public void release() {
                    }
                };
            }

            protected /* synthetic */ Result zzd(Result result) {
                return zza((CustomPersonResult) result);
            }
        };
    }

    private static PendingResult<PersonListResult> zzc(PendingResult<CustomPersonListResult<PersonReference>> pendingResult) {
        return new zzt<CustomPersonListResult<PersonReference>, PersonListResult>(pendingResult) {
            protected PersonListResult zza(final CustomPersonListResult<PersonReference> customPersonListResult) {
                return new PersonListResult(this) {
                    final /* synthetic */ C05714 zzbBr;

                    public PendingResult<PersonListResult> getNextPendingResult() {
                        return customPersonListResult.getNextPendingResult() == null ? null : zzh.zzc(customPersonListResult.getNextPendingResult());
                    }

                    public DataBuffer<PersonReference> getPersonBuffer() {
                        return customPersonListResult.getPersonBuffer();
                    }

                    public Status getStatus() {
                        return customPersonListResult.getStatus();
                    }

                    public boolean isResultComplete() {
                        return customPersonListResult.isResultComplete();
                    }

                    public void release() {
                    }
                };
            }

            protected /* synthetic */ Result zzd(Result result) {
                return zza((CustomPersonListResult) result);
            }
        };
    }

    private static <T> CustomPersonResult<T> zzca(final Status status) {
        return new CustomPersonResult<T>() {
            public PendingResult<CustomPersonResult<T>> getNextPendingResult() {
                return null;
            }

            public DataBuffer<T> getPersonBuffer() {
                return null;
            }

            public Status getStatus() {
                return status;
            }

            public boolean isLocalResultComplete() {
                return true;
            }

            public boolean isResultComplete() {
                return true;
            }

            public void release() {
            }
        };
    }

    private static <T> CustomPersonListResult<T> zzcb(final Status status) {
        return new CustomPersonListResult<T>() {
            public PendingResult<CustomPersonListResult<T>> getNextPendingResult() {
                return null;
            }

            public DataBuffer<T> getPersonBuffer() {
                return null;
            }

            public Status getStatus() {
                return status;
            }

            public boolean isResultComplete() {
                return true;
            }

            public void release() {
            }
        };
    }

    public <PersonType> PendingResult<CustomPersonResult<PersonType>> getByIds(GoogleApiClient googleApiClient, GetOptions options, PersonFactory<PersonType> factory, String... qualifiedIds) {
        for (CharSequence isEmpty : qualifiedIds) {
            zzx.zzae(!TextUtils.isEmpty(isEmpty));
        }
        return googleApiClient.zza(new zza(this, googleApiClient, options, factory, qualifiedIds));
    }

    public PendingResult<PersonResult> getByIds(GoogleApiClient apiClient, GetOptions options, String... qualifiedIds) {
        return zzb(getByIds(apiClient, options, zzbBm, qualifiedIds));
    }

    public PendingResult<PersonListResult> list(GoogleApiClient apiClient, ListOptions options) {
        return zzc(list(apiClient, options, zzbBn));
    }

    public <PersonRefType> PendingResult<CustomPersonListResult<PersonRefType>> list(GoogleApiClient googleApiClient, ListOptions options, PersonListFactory<PersonRefType> factory) {
        return googleApiClient.zza(new zzb(this, googleApiClient, options, factory));
    }

    public PendingResult<PersonListResult> listByEmail(GoogleApiClient apiClient, ListOptions options, String emailAddress) {
        if (zzp.zzhT(emailAddress)) {
            emailAddress = zzp.zzhR(emailAddress);
        }
        return list(apiClient, com.google.android.gms.people.identity.IdentityApi.ListOptions.zza.zza(options).zza(com.google.android.gms.people.identity.IdentityApi.zza.zza.zza(options.zzbAa).zzfI(Endpoints.ENDPOINT_LIST_BY_EMAIL).zzag("email", emailAddress)).zzGi());
    }

    public PendingResult<PersonListResult> listByPhone(GoogleApiClient apiClient, ListOptions options, String phoneNumber) {
        if (zzc.zzfS(phoneNumber)) {
            phoneNumber = zzc.zzfV(phoneNumber);
        }
        return list(apiClient, com.google.android.gms.people.identity.IdentityApi.ListOptions.zza.zza(options).zza(com.google.android.gms.people.identity.IdentityApi.zza.zza.zza(options.zzbAa).zzfI(Endpoints.ENDPOINT_LIST_BY_PHONE).zzag("phone", phoneNumber)).zzGi());
    }
}

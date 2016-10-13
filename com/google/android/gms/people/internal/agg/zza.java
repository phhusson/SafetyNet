package com.google.android.gms.people.internal.agg;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.people.PeopleConstants.ContactGroupPreferredFields;
import com.google.android.gms.people.PeopleConstants.PeopleEmail;
import com.google.android.gms.people.internal.agg.PhoneEmailDecoder.PhoneDecoder;
import com.google.android.gms.people.internal.zzi;
import com.google.android.gms.people.internal.zzm;
import com.google.android.gms.people.internal.zzo;
import com.google.android.gms.people.internal.zzp;
import com.google.android.gms.people.model.AggregatedPerson;
import com.google.android.gms.people.model.AggregatedPersonBuffer;
import com.google.android.gms.people.model.EmailAddress;
import com.google.android.gms.people.model.PhoneNumber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class zza extends AggregatedPersonBuffer {
    private Context mContext;
    private volatile boolean zzaem;
    private final int zzbFj;
    private DataHolder zzbFk;
    private Cursor zzbFl;
    private zzi zzbFm;
    private zzi zzbFn;
    private ArrayList<String> zzbFo;
    private HashMap<String, String> zzbFp;
    private zzb zzbFq;
    private zzb zzbFr;
    private final boolean zzbFs;
    private PhoneDecoder zzbzT;

    private static abstract class zzb {
        private final ConcurrentHashMap<Integer, String> zzbFA = new ConcurrentHashMap();
        private final Resources zzbFB;

        public zzb(Resources resources) {
            this.zzbFB = resources;
        }

        public String getLabel(int type) {
            if (type == 0) {
                return null;
            }
            String str = (String) this.zzbFA.get(Integer.valueOf(type));
            if (str != null) {
                return str;
            }
            str = zza(this.zzbFB, type);
            this.zzbFA.put(Integer.valueOf(type), str);
            return str;
        }

        protected abstract String zza(Resources resources, int i);
    }

    private class zza implements AggregatedPerson {
        private final int zzatF;
        final /* synthetic */ zza zzbFt;
        private boolean zzbFu;
        private ArrayList<Long> zzbFv;
        private ArrayList<EmailAddress> zzbFw;
        private ArrayList<PhoneNumber> zzbFx;
        private EmailAddress zzbFy;
        private final boolean zzbFz;

        public zza(zza com_google_android_gms_people_internal_agg_zza, int i) {
            this.zzbFt = com_google_android_gms_people_internal_agg_zza;
            this.zzatF = i;
            this.zzbFz = !TextUtils.isEmpty(getGaiaId());
        }

        private int zzJF() {
            return this.zzbFt.zzbFm.zznu(this.zzatF);
        }

        private int zzJG() {
            return this.zzbFt.zzbFn.zznu(this.zzatF);
        }

        private void zzJH() {
            if (!this.zzbFu) {
                this.zzbFu = true;
                int zzJG = zzJG();
                this.zzbFv = new ArrayList(zzJG);
                this.zzbFw = new ArrayList();
                this.zzbFx = null;
                if (hasPlusPerson() && this.zzbFt.zzbFs) {
                    this.zzbFx = this.zzbFt.zzbzT.decode(zzic("v_phones"), false);
                }
                if (this.zzbFx == null) {
                    this.zzbFx = new ArrayList();
                }
                this.zzbFy = null;
                String gaiaId = getGaiaId();
                for (int i = 0; i < zzJG; i++) {
                    if (this.zzbFt.zzbFl.moveToPosition(this.zzbFt.zzbFn.get(this.zzatF, i))) {
                        this.zzbFv.add(Long.valueOf(this.zzbFt.zzbFl.getLong(0)));
                        do {
                            String string = this.zzbFt.zzbFl.getString(2);
                            Object string2;
                            if ("vnd.android.cursor.item/email_v2".equals(string) && this.zzbFy == null) {
                                string = zza(this.zzbFt.zzbFl, this.zzbFt.zzbFq);
                                string2 = this.zzbFt.zzbFl.getString(3);
                                if (!TextUtils.isEmpty(string2)) {
                                    EmailAddress com_google_android_gms_people_internal_agg_zzc = new zzc(string, string2);
                                    if (!this.zzbFw.contains(com_google_android_gms_people_internal_agg_zzc)) {
                                        if (gaiaId != null && this.zzbFt.zzbFp.containsKey(com_google_android_gms_people_internal_agg_zzc.getValue()) && gaiaId.equals(this.zzbFt.zzbFp.get(com_google_android_gms_people_internal_agg_zzc.getValue()))) {
                                            this.zzbFy = com_google_android_gms_people_internal_agg_zzc;
                                            this.zzbFw.clear();
                                        } else {
                                            this.zzbFw.add(com_google_android_gms_people_internal_agg_zzc);
                                        }
                                    }
                                }
                            } else if ("vnd.android.cursor.item/phone_v2".equals(string)) {
                                string = zza(this.zzbFt.zzbFl, this.zzbFt.zzbFr);
                                string2 = this.zzbFt.zzbFl.getString(3);
                                if (!TextUtils.isEmpty(string2)) {
                                    zzg com_google_android_gms_people_internal_agg_zzg = new zzg(string, string2);
                                    if (!this.zzbFx.contains(com_google_android_gms_people_internal_agg_zzg)) {
                                        this.zzbFx.add(com_google_android_gms_people_internal_agg_zzg);
                                    }
                                }
                            }
                        } while (zzb.zzc(this.zzbFt.zzbFl));
                    }
                }
            }
        }

        private zza zzJI() {
            return this.zzbFt;
        }

        private Iterable<EmailAddress> zza(EmailAddress emailAddress) {
            Iterable arrayList = new ArrayList(1);
            arrayList.add(emailAddress);
            return arrayList;
        }

        private String zza(Cursor cursor, zzb com_google_android_gms_people_internal_agg_zza_zzb) {
            int i = this.zzbFt.zzbFl.getInt(4);
            return i == 0 ? cursor.getString(5) : com_google_android_gms_people_internal_agg_zza_zzb.getLabel(i);
        }

        private String zzic(String str) {
            if (!hasPlusPerson()) {
                return null;
            }
            int i = this.zzbFt.zzbFm.get(this.zzatF, 0);
            return this.zzbFt.zzbFk.getString(str, i, this.zzbFt.zzbFk.zzcZ(i));
        }

        private long zzid(String str) {
            if (!hasPlusPerson()) {
                return 0;
            }
            int i = this.zzbFt.zzbFm.get(this.zzatF, 0);
            return this.zzbFt.zzbFk.getLong(str, i, this.zzbFt.zzbFk.zzcZ(i));
        }

        private int zzie(String str) {
            if (!hasPlusPerson()) {
                return 0;
            }
            int i = this.zzbFt.zzbFm.get(this.zzatF, 0);
            return this.zzbFt.zzbFk.getInteger(str, i, this.zzbFt.zzbFk.zzcZ(i));
        }

        private double zzif(String str) {
            if (!hasPlusPerson()) {
                return 0.0d;
            }
            int i = this.zzbFt.zzbFm.get(this.zzatF, 0);
            return this.zzbFt.zzbFk.getDouble(str, i, this.zzbFt.zzbFk.zzcZ(i));
        }

        public boolean equals(Object o) {
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_people_internal_agg_zza_zza = (zza) o;
            return this.zzatF == com_google_android_gms_people_internal_agg_zza_zza.zzatF && zzJI() == com_google_android_gms_people_internal_agg_zza_zza.zzJI();
        }

        @Deprecated
        public String getAccountName() {
            this.zzbFt.zzJE();
            return getOwnerAccountName();
        }

        public double getAffinity1() {
            this.zzbFt.zzJE();
            return zzif(PeopleEmail.AFFINITY_1);
        }

        public double getAffinity2() {
            this.zzbFt.zzJE();
            return zzif(PeopleEmail.AFFINITY_2);
        }

        public double getAffinity3() {
            this.zzbFt.zzJE();
            return zzif(PeopleEmail.AFFINITY_3);
        }

        public double getAffinity4() {
            this.zzbFt.zzJE();
            return zzif(PeopleEmail.AFFINITY_4);
        }

        public double getAffinity5() {
            this.zzbFt.zzJE();
            return zzif(PeopleEmail.AFFINITY_5);
        }

        public String getAvatarUrl() {
            this.zzbFt.zzJE();
            return zzm.zzbEa.zzhM(zzic("avatar"));
        }

        public String[] getBelongingCircleIds() {
            this.zzbFt.zzJE();
            return zzp.zzhO(zzic("v_circle_ids"));
        }

        public Iterable<Long> getContactIds() {
            this.zzbFt.zzJE();
            zzJH();
            return this.zzbFv;
        }

        public Iterable<EmailAddress> getEmailAddresses() {
            this.zzbFt.zzJE();
            Object zzhR = zzp.zzhR(getQualifiedId());
            if (!TextUtils.isEmpty(zzhR)) {
                return zza(new zzc("", zzhR));
            }
            zzJH();
            if (this.zzbFz) {
                return this.zzbFy != null ? zza(this.zzbFy) : EmailAddress.EMPTY_EMAILS;
            } else {
                if (hasContact()) {
                    return this.zzbFw;
                }
                if (zzo.zzJx()) {
                    zzo.zzG("PeopleAggregator", "Row should have a contact: " + getQualifiedId());
                }
                return EmailAddress.EMPTY_EMAILS;
            }
        }

        public String getFamilyName() {
            this.zzbFt.zzJE();
            return zzic("family_name");
        }

        public String getGaiaId() {
            this.zzbFt.zzJE();
            return (String) this.zzbFt.zzbFo.get(this.zzatF);
        }

        public String getGivenName() {
            this.zzbFt.zzJE();
            return zzic("given_name");
        }

        public int getInViewerDomain() {
            this.zzbFt.zzJE();
            return zzie("in_viewer_domain");
        }

        public String getInteractionRankSortKey() {
            this.zzbFt.zzJE();
            return zzic("sort_key_irank");
        }

        public long getLastModifiedTime() {
            this.zzbFt.zzJE();
            return zzid("last_modified");
        }

        public String getLoggingId1() {
            this.zzbFt.zzJE();
            return zzic(PeopleEmail.LOGGING_ID_1);
        }

        public String getLoggingId2() {
            this.zzbFt.zzJE();
            return zzic(PeopleEmail.LOGGING_ID_2);
        }

        public String getLoggingId3() {
            this.zzbFt.zzJE();
            return zzic(PeopleEmail.LOGGING_ID_3);
        }

        public String getLoggingId4() {
            this.zzbFt.zzJE();
            return zzic(PeopleEmail.LOGGING_ID_4);
        }

        public String getLoggingId5() {
            this.zzbFt.zzJE();
            return zzic(PeopleEmail.LOGGING_ID_5);
        }

        public String getName() {
            this.zzbFt.zzJE();
            if (hasPlusPerson()) {
                return zzic(ContactGroupPreferredFields.NAME);
            }
            this.zzbFt.zzbFl.moveToPosition(this.zzbFt.zzbFn.get(this.zzatF, 0));
            return this.zzbFt.zzbFl.getString(1);
        }

        public String getNameSortKey() {
            this.zzbFt.zzJE();
            return zzic("sort_key");
        }

        public String getOwnerAccountName() {
            this.zzbFt.zzJE();
            return hasPlusPerson() ? this.zzbFt.zzbFk.zzqt().getString("account") : null;
        }

        public String getOwnerPlusPageId() {
            this.zzbFt.zzJE();
            return hasPlusPerson() ? this.zzbFt.zzbFk.zzqt().getString("pagegaiaid") : null;
        }

        public Iterable<PhoneNumber> getPhoneNumbers() {
            this.zzbFt.zzJE();
            if (zzp.zzhT(getQualifiedId())) {
                return PhoneNumber.EMPTY_PHONES;
            }
            zzJH();
            return this.zzbFx;
        }

        @Deprecated
        public String getPlusPageGaiaId() {
            this.zzbFt.zzJE();
            return getOwnerPlusPageId();
        }

        public int getProfileType() {
            this.zzbFt.zzJE();
            return zzie("profile_type");
        }

        public String getQualifiedId() {
            this.zzbFt.zzJE();
            return zzic("qualified_id");
        }

        public long getRowId() {
            throw new UnsupportedOperationException();
        }

        public boolean hasContact() {
            this.zzbFt.zzJE();
            return zzJG() > 0;
        }

        public boolean hasPlusPerson() {
            this.zzbFt.zzJE();
            return zzJF() > 0;
        }

        public int hashCode() {
            return (zzJI().hashCode() * 31) + this.zzatF;
        }

        public boolean isBlocked() {
            this.zzbFt.zzJE();
            return zzie("blocked") != 0;
        }

        public boolean isNameVerified() {
            this.zzbFt.zzJE();
            return zzie("name_verified") != 0;
        }
    }

    public zza(DataHolder dataHolder, Cursor cursor, Context context, int i, zzi com_google_android_gms_people_internal_zzi, zzi com_google_android_gms_people_internal_zzi2, ArrayList<String> arrayList, HashMap<String, String> hashMap, int i2, Bundle bundle, Bundle bundle2) {
        boolean z = true;
        super(dataHolder);
        zzx.zzD(dataHolder);
        zzx.zzD(cursor);
        zzx.zzD(hashMap);
        zzx.zzae(i == com_google_android_gms_people_internal_zzi.size());
        zzx.zzae(i == com_google_android_gms_people_internal_zzi2.size());
        zzx.zzae(i == arrayList.size());
        this.zzbFk = dataHolder;
        this.zzbFl = cursor;
        this.zzbFj = i;
        this.zzbFo = arrayList;
        this.mContext = context;
        this.zzbFp = hashMap;
        this.zzbFq = new zzb(this, this.mContext.getResources()) {
            final /* synthetic */ zza zzbFt;

            protected String zza(Resources resources, int i) {
                return (String) Email.getTypeLabel(resources, i, null);
            }
        };
        this.zzbFr = new zzb(this, this.mContext.getResources()) {
            final /* synthetic */ zza zzbFt;

            protected String zza(Resources resources, int i) {
                return (String) Phone.getTypeLabel(resources, i, null);
            }
        };
        this.zzbFm = com_google_android_gms_people_internal_zzi;
        this.zzbFn = com_google_android_gms_people_internal_zzi2;
        if ((i2 & 1) != 0) {
            zzo.zzJ("PeopleAggregator", "PeopleExtraColumnBitmask.EMAILS is not supported in aggregation.  Ignored.");
        }
        if ((i2 & 2) == 0) {
            z = false;
        }
        this.zzbFs = z;
        this.zzbzT = new PhoneDecoder(bundle2);
    }

    private void zzJE() {
        if (this.zzaem) {
            throw new IllegalStateException("Already released");
        }
    }

    public /* synthetic */ Object get(int i) {
        return zznx(i);
    }

    public int getCount() {
        zzJE();
        return this.zzbFj;
    }

    public void release() {
        if (!this.zzaem) {
            this.zzaem = true;
            this.zzbFk.close();
            this.zzbFl.close();
            this.zzbFk = null;
            this.zzbFl = null;
            this.zzbFm = null;
            this.zzbFn = null;
            this.zzbFo = null;
            this.zzbFp = null;
            this.mContext = null;
            this.zzbFq = null;
            this.zzbFr = null;
            this.zzbzT = null;
        }
    }

    public AggregatedPerson zznx(int i) {
        zzJE();
        return new zza(this, i);
    }
}

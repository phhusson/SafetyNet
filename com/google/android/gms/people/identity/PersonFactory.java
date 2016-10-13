package com.google.android.gms.people.identity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.people.PeopleConstants.ContactGroupPreferredFields;
import com.google.android.gms.people.PeopleConstants.Endpoints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface PersonFactory<PersonType> {

    public static class ContactData {
        private final List<RawContactData> zzbAf;

        public ContactData(List<RawContactData> rawData) {
            this.zzbAf = new ArrayList(rawData);
        }

        public ContactData(RawContactData... rawData) {
            this.zzbAf = Arrays.asList(rawData);
        }

        public List<RawContactData> getRawData() {
            return this.zzbAf;
        }
    }

    public static class ExternalContactData {
        protected final String mAccountType;
        protected final Uri mDataUri;
        protected final String mDetail;
        protected final String mHeader;
        protected final int mIconRes;
        protected final String mMimeType;
        protected final String mResourcePackageName;
        protected final int mTitleRes;

        public ExternalContactData(Uri dataUri, String header, int iconRes, String detail, String resourcePackageName, String mimeType, int titleRes, String accountType) {
            this.mDataUri = dataUri;
            this.mHeader = header;
            this.mIconRes = iconRes;
            this.mDetail = detail;
            this.mResourcePackageName = resourcePackageName;
            this.mMimeType = mimeType;
            this.mTitleRes = titleRes;
            this.mAccountType = accountType;
        }

        public String getAccountType() {
            return this.mAccountType;
        }

        public Uri getDataUri() {
            return this.mDataUri;
        }

        public String getDetail() {
            return this.mDetail;
        }

        public String getHeader() {
            return this.mHeader;
        }

        public int getIconRes() {
            return this.mIconRes;
        }

        public String getMimeType() {
            return this.mMimeType;
        }

        public String getResourcePackageName() {
            return this.mResourcePackageName;
        }

        public int getTitleRes() {
            return this.mTitleRes;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(ExternalContactData.class.getSimpleName());
            stringBuffer.append("<dataUri=").append(this.mDataUri);
            stringBuffer.append(" header=").append(this.mHeader);
            stringBuffer.append(" detail=").append(this.mDetail);
            stringBuffer.append(" resourcePackageName=").append(this.mResourcePackageName);
            stringBuffer.append(" mimeType=").append(this.mMimeType);
            stringBuffer.append(" titleRes=").append(this.mTitleRes);
            stringBuffer.append(" iconRes=").append(this.mIconRes);
            stringBuffer.append(" accountType=").append(this.mAccountType);
            stringBuffer.append(">");
            return stringBuffer.toString();
        }
    }

    public static abstract class OfflineDatabaseData {
        protected final VisibleDataBufferRef mRow;

        public static final class AddressData {
            private final String zzKj;
            private final String zzaOs;

            public AddressData(String address, String type) {
                this.zzaOs = address;
                this.zzKj = type;
            }

            public String getAddress() {
                return this.zzaOs;
            }

            public String getType() {
                return this.zzKj;
            }
        }

        public static class Circle {
            public static final int UNKNOWN_MEMBER_COUNT = -1;
            private final VisibleDataBufferRef mRow;

            public Circle(VisibleDataBufferRef row) {
                this.mRow = row;
            }

            public String getId() {
                return this.mRow.getString("circle_id");
            }

            public int getMemberCount() {
                return this.mRow.getInteger("people_count", -1);
            }

            public String getName() {
                return this.mRow.getString(ContactGroupPreferredFields.NAME);
            }
        }

        public static final class EmailData {
            private final String zzKj;
            private final String zzYA;

            public EmailData(String email, String type) {
                this.zzYA = email;
                this.zzKj = type;
            }

            public String getEmailAddress() {
                return this.zzYA;
            }

            public String getType() {
                return this.zzKj;
            }
        }

        public static final class PhoneData {
            private final String zzKj;
            private final String zzbAg;

            public PhoneData(String phone, String type) {
                this.zzbAg = phone;
                this.zzKj = type;
            }

            public String getPhone() {
                return this.zzbAg;
            }

            public String getType() {
                return this.zzKj;
            }
        }

        protected static final class VisibleDataBufferRef extends zzc {
            public VisibleDataBufferRef(DataHolder holder, int dataRow) {
                super(holder, dataRow);
            }

            public boolean getBoolean(String column, boolean defaultValue) {
                return !hasColumn(column) ? defaultValue : super.getBoolean(column);
            }

            public int getInteger(String column, int defaultValue) {
                return !hasColumn(column) ? defaultValue : super.getInteger(column);
            }

            public String getString(String column) {
                return getString(column, null);
            }

            public String getString(String column, String defaultValue) {
                return !hasColumn(column) ? defaultValue : super.getString(column);
            }
        }

        public OfflineDatabaseData(VisibleDataBufferRef row) {
            this.mRow = row;
        }

        public static OfflineDatabaseData build(DataHolder personHolder, DataHolder personAddressHolder, DataHolder personEmailHolder, DataHolder personPhoneHolder, DataHolder ownerHolder, DataHolder ownerAddressHolder, DataHolder ownerEmailHolder, DataHolder ownerPhoneHolder, DataHolder circleHolder, int ordinal) {
            VisibleDataBufferRef visibleDataBufferRef = (VisibleDataBufferRef) zzg(findRows(personHolder, ordinal));
            if (visibleDataBufferRef != null) {
                return new zzb(visibleDataBufferRef, personAddressHolder, personEmailHolder, personPhoneHolder, circleHolder, ordinal);
            }
            visibleDataBufferRef = (VisibleDataBufferRef) zzg(findRows(ownerHolder, ordinal));
            return visibleDataBufferRef != null ? new zza(visibleDataBufferRef, ownerAddressHolder, ownerEmailHolder, ownerPhoneHolder, ordinal) : null;
        }

        protected static ArrayList<VisibleDataBufferRef> findRows(DataHolder holder, int ordinal) {
            ArrayList<VisibleDataBufferRef> arrayList = new ArrayList();
            if (holder != null) {
                for (int i = 0; i < holder.getCount(); i++) {
                    if (ordinal == holder.getInteger("ordinal", i, holder.zzcZ(i))) {
                        arrayList.add(new VisibleDataBufferRef(holder, i));
                    } else if (!arrayList.isEmpty()) {
                        break;
                    }
                }
            }
            return arrayList;
        }

        private static <T> T zzg(ArrayList<T> arrayList) {
            boolean z = true;
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            if (arrayList.size() != 1) {
                z = false;
            }
            zzx.zzad(z);
            return arrayList.get(0);
        }

        public abstract List<AddressData> getAddresses();

        public abstract List<Circle> getCircles();

        public abstract String getCompressedAvatarUrl();

        public abstract String getDisplayName();

        public abstract List<EmailData> getEmails();

        public abstract String getGaiaId();

        public abstract boolean getNameVerified();

        protected boolean getPersonBoolean(String column, boolean defaultValue) {
            return this.mRow.getBoolean(column, defaultValue);
        }

        protected int getPersonInteger(String column, int defaultValue) {
            return this.mRow.getInteger(column, defaultValue);
        }

        protected String getPersonString(String column) {
            return getPersonString(column, null);
        }

        protected String getPersonString(String column, String defaultValue) {
            return this.mRow.getString(column, defaultValue);
        }

        public abstract List<PhoneData> getPhones();

        public abstract int getProfileType();

        public abstract String getTagline();
    }

    public static class RawContactData {
        private final String mMimeType;
        private final boolean zzaxp;
        private final String zzbAl;
        private final String zzbAm;
        private final String[] zzbAn;
        private final boolean zzbAo;
        private final ExternalContactData zzbAp;
        private final int zzbAq;

        public RawContactData(String contactId, String rawContactId, String mimeType, int timesUsed, String[] data, boolean readOnly, boolean primary, ExternalContactData externalContactData) {
            this.zzbAl = contactId;
            this.zzbAm = rawContactId;
            this.mMimeType = mimeType;
            this.zzbAn = data;
            this.zzaxp = readOnly;
            this.zzbAo = primary;
            this.zzbAp = externalContactData;
            this.zzbAq = timesUsed;
        }

        public String getContactId() {
            return this.zzbAl;
        }

        public String getData(int column) {
            return column < this.zzbAn.length ? this.zzbAn[column] : null;
        }

        public ExternalContactData getExternalContactData() {
            return this.zzbAp;
        }

        public String getMimeType() {
            return this.mMimeType;
        }

        public String getRawContactId() {
            return this.zzbAm;
        }

        public int getTimesUsed() {
            return this.zzbAq;
        }

        public boolean isPrimary() {
            return this.zzbAo;
        }

        public boolean isReadOnly() {
            return this.zzaxp;
        }
    }

    public static class ServiceData {
        public static final int FAILED_RESPONSE_CODE = -1;
        private static final ServiceData zzbAr = new ServiceData(-1, 0, null, null);
        public final byte[] blob;
        public final int format;
        public final Map<String, String> headers;
        public final int responseCode;

        public ServiceData(int responseCode, int format, byte[] blob, Map<String, String> headers) {
            this.responseCode = responseCode;
            this.format = format;
            this.blob = blob;
            this.headers = headers;
        }

        public static ServiceData zzS(Bundle bundle) {
            if (bundle == null) {
                return zzbAr;
            }
            int i = bundle.getInt("get.server_blob.code", -1);
            if (i == -1) {
                return zzbAr;
            }
            return new ServiceData(i, bundle.getInt("get.server_blob.format"), bundle.getByteArray("get.server_blob.body"), (HashMap) bundle.getSerializable("get.server_blob.headers"));
        }
    }

    public static class zza extends OfflineDatabaseData {
        private final List<AddressData> zzbAh;
        private final List<EmailData> zzbAi;
        private final List<PhoneData> zzbAj;

        public zza(VisibleDataBufferRef visibleDataBufferRef, DataHolder dataHolder, DataHolder dataHolder2, DataHolder dataHolder3, int i) {
            super(visibleDataBufferRef);
            List arrayList = new ArrayList();
            Iterator it = OfflineDatabaseData.findRows(dataHolder, i).iterator();
            while (it.hasNext()) {
                VisibleDataBufferRef visibleDataBufferRef2 = (VisibleDataBufferRef) it.next();
                arrayList.add(new AddressData(visibleDataBufferRef2.getString("postal_address"), visibleDataBufferRef2.getString("type")));
            }
            List arrayList2 = new ArrayList();
            Iterator it2 = OfflineDatabaseData.findRows(dataHolder2, i).iterator();
            while (it2.hasNext()) {
                visibleDataBufferRef2 = (VisibleDataBufferRef) it2.next();
                arrayList2.add(new EmailData(visibleDataBufferRef2.getString("email"), visibleDataBufferRef2.getString("type")));
            }
            List arrayList3 = new ArrayList();
            Iterator it3 = OfflineDatabaseData.findRows(dataHolder3, i).iterator();
            while (it3.hasNext()) {
                visibleDataBufferRef2 = (VisibleDataBufferRef) it3.next();
                arrayList3.add(new PhoneData(visibleDataBufferRef2.getString("phone"), visibleDataBufferRef2.getString("type")));
            }
            this.zzbAh = Collections.unmodifiableList(arrayList);
            this.zzbAi = Collections.unmodifiableList(arrayList2);
            this.zzbAj = Collections.unmodifiableList(arrayList3);
        }

        public List<AddressData> getAddresses() {
            return this.zzbAh;
        }

        public List<Circle> getCircles() {
            return null;
        }

        public String getCompressedAvatarUrl() {
            return null;
        }

        public String getDisplayName() {
            return getPersonString("display_name");
        }

        public List<EmailData> getEmails() {
            return this.zzbAi;
        }

        public String getGaiaId() {
            return getPersonString(Endpoints.KEY_TARGET_GAIA_ID);
        }

        public boolean getNameVerified() {
            return false;
        }

        public List<PhoneData> getPhones() {
            return this.zzbAj;
        }

        public int getProfileType() {
            return 0;
        }

        public String getTagline() {
            return null;
        }
    }

    public static class zzb extends OfflineDatabaseData {
        private final List<AddressData> zzbAh;
        private final List<EmailData> zzbAi;
        private final List<PhoneData> zzbAj;
        private final List<Circle> zzbAk;

        public zzb(VisibleDataBufferRef visibleDataBufferRef, DataHolder dataHolder, DataHolder dataHolder2, DataHolder dataHolder3, DataHolder dataHolder4, int i) {
            super(visibleDataBufferRef);
            List arrayList = new ArrayList();
            Iterator it = OfflineDatabaseData.findRows(dataHolder4, i).iterator();
            while (it.hasNext()) {
                arrayList.add(new Circle((VisibleDataBufferRef) it.next()));
            }
            List arrayList2 = new ArrayList();
            Iterator it2 = OfflineDatabaseData.findRows(dataHolder, i).iterator();
            while (it2.hasNext()) {
                VisibleDataBufferRef visibleDataBufferRef2 = (VisibleDataBufferRef) it2.next();
                arrayList2.add(new AddressData(visibleDataBufferRef2.getString("postal_address"), visibleDataBufferRef2.getString("type")));
            }
            List arrayList3 = new ArrayList();
            Iterator it3 = OfflineDatabaseData.findRows(dataHolder2, i).iterator();
            while (it3.hasNext()) {
                visibleDataBufferRef2 = (VisibleDataBufferRef) it3.next();
                arrayList3.add(new EmailData(visibleDataBufferRef2.getString("email"), visibleDataBufferRef2.getString("type")));
            }
            List arrayList4 = new ArrayList();
            Iterator it4 = OfflineDatabaseData.findRows(dataHolder3, i).iterator();
            while (it4.hasNext()) {
                visibleDataBufferRef2 = (VisibleDataBufferRef) it4.next();
                arrayList4.add(new PhoneData(visibleDataBufferRef2.getString("phone"), visibleDataBufferRef2.getString("type")));
            }
            this.zzbAk = Collections.unmodifiableList(arrayList);
            this.zzbAh = Collections.unmodifiableList(arrayList2);
            this.zzbAi = Collections.unmodifiableList(arrayList3);
            this.zzbAj = Collections.unmodifiableList(arrayList4);
        }

        public List<AddressData> getAddresses() {
            return this.zzbAh;
        }

        public List<Circle> getCircles() {
            return this.zzbAk;
        }

        public String getCompressedAvatarUrl() {
            return getPersonString("avatar");
        }

        public String getDisplayName() {
            return getPersonString(ContactGroupPreferredFields.NAME);
        }

        public List<EmailData> getEmails() {
            return this.zzbAi;
        }

        public String getGaiaId() {
            return getPersonString(Endpoints.KEY_TARGET_GAIA_ID);
        }

        public boolean getNameVerified() {
            return getPersonBoolean("name_verified", false);
        }

        public List<PhoneData> getPhones() {
            return this.zzbAj;
        }

        public int getProfileType() {
            return getPersonInteger("profile_type", -1);
        }

        public String getTagline() {
            return getPersonString("tagline");
        }
    }

    PersonType build(Context context, Object obj, ServiceData serviceData, ContactData contactData, OfflineDatabaseData offlineDatabaseData);
}

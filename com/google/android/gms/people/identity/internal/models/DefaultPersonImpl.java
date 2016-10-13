package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.people.data.AudienceMember;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.people.PeopleConstants.ContactGroupPreferredFields;
import com.google.android.gms.playlog.PlayLogger.LogSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefaultPersonImpl extends FastJsonResponse implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
    final int mVersionCode;
    String zzajR;
    List<Addresses> zzbAh;
    List<Emails> zzbAi;
    List<Nicknames> zzbCA;
    List<Occupations> zzbCB;
    List<Organizations> zzbCC;
    List<PhoneNumbers> zzbCD;
    List<PlacesLived> zzbCE;
    String zzbCF;
    List<Relations> zzbCG;
    List<RelationshipInterests> zzbCH;
    List<RelationshipStatuses> zzbCI;
    List<Skills> zzbCJ;
    SortKeys zzbCK;
    List<Taglines> zzbCL;
    List<Urls> zzbCM;
    final Set<Integer> zzbCc;
    List<Abouts> zzbCm;
    String zzbCn;
    List<Birthdays> zzbCo;
    List<BraggingRights> zzbCp;
    List<CoverPhotos> zzbCq;
    List<CustomFields> zzbCr;
    String zzbCs;
    List<Genders> zzbCt;
    List<InstantMessaging> zzbCu;
    LegacyFields zzbCv;
    List<DefaultPersonImpl> zzbCw;
    List<Memberships> zzbCx;
    Metadata zzbCy;
    List<Names> zzbCz;
    List<Events> zzql;
    String zzyU;
    List<Images> zzyw;

    public static final class Abouts extends FastJsonResponse implements SafeParcelable {
        public static final zzk CREATOR = new zzk();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        String zzKj;
        DefaultMetadataImpl zzbCN;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("metadata", Field.forConcreteType("metadata", 2, DefaultMetadataImpl.class));
            zzbCb.put("type", Field.forString("type", 3));
            zzbCb.put("value", Field.forString("value", 4));
        }

        public Abouts() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Abouts(Set<Integer> indicatorSet, int versionCode, DefaultMetadataImpl metadata, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCN = metadata;
            this.zzKj = type;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzk com_google_android_gms_people_identity_internal_models_zzk = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Abouts)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Abouts abouts = (Abouts) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!abouts.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(abouts.getFieldValue(field))) {
                        return false;
                    }
                } else if (abouts.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCN;
                case 3:
                    return this.zzKj;
                case 4:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getType() {
            return this.zzKj;
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasType() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzKj = value;
                    break;
                case 4:
                    this.mValue = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzk com_google_android_gms_people_identity_internal_models_zzk = CREATOR;
            zzk.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }
    }

    public static final class Addresses extends FastJsonResponse implements SafeParcelable {
        public static final zzl CREATOR = new zzl();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        String zzKj;
        DefaultMetadataImpl zzbCN;
        String zzbCO;
        String zzbCP;
        String zzbCQ;
        String zzbCR;
        String zzbCS;
        String zzbCT;
        String zzbCU;
        String zzbCV;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("city", Field.forString("city", 2));
            zzbCb.put("country", Field.forString("country", 3));
            zzbCb.put("countryCode", Field.forString("countryCode", 4));
            zzbCb.put("formattedType", Field.forString("formattedType", 5));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 6, DefaultMetadataImpl.class));
            zzbCb.put("poBox", Field.forString("poBox", 7));
            zzbCb.put("postalCode", Field.forString("postalCode", 8));
            zzbCb.put("region", Field.forString("region", 9));
            zzbCb.put("streetAddress", Field.forString("streetAddress", 10));
            zzbCb.put("type", Field.forString("type", 11));
            zzbCb.put("value", Field.forString("value", 12));
        }

        public Addresses() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Addresses(Set<Integer> indicatorSet, int versionCode, String city, String country, String countryCode, String formattedType, DefaultMetadataImpl metadata, String poBox, String postalCode, String region, String streetAddress, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCO = city;
            this.zzbCP = country;
            this.zzbCQ = countryCode;
            this.zzbCR = formattedType;
            this.zzbCN = metadata;
            this.zzbCS = poBox;
            this.zzbCT = postalCode;
            this.zzbCU = region;
            this.zzbCV = streetAddress;
            this.zzKj = type;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 6:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzl com_google_android_gms_people_identity_internal_models_zzl = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Addresses)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Addresses addresses = (Addresses) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!addresses.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(addresses.getFieldValue(field))) {
                        return false;
                    }
                } else if (addresses.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public String getCity() {
            return this.zzbCO;
        }

        public String getCountry() {
            return this.zzbCP;
        }

        public String getCountryCode() {
            return this.zzbCQ;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCO;
                case 3:
                    return this.zzbCP;
                case 4:
                    return this.zzbCQ;
                case 5:
                    return this.zzbCR;
                case 6:
                    return this.zzbCN;
                case 7:
                    return this.zzbCS;
                case 8:
                    return this.zzbCT;
                case 9:
                    return this.zzbCU;
                case 10:
                    return this.zzbCV;
                case 11:
                    return this.zzKj;
                case 12:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getPostalCode() {
            return this.zzbCT;
        }

        public String getRegion() {
            return this.zzbCU;
        }

        public String getStreetAddress() {
            return this.zzbCV;
        }

        public String getType() {
            return this.zzKj;
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasPostalCode() {
            return this.zzbCc.contains(Integer.valueOf(8));
        }

        public boolean hasStreetAddress() {
            return this.zzbCc.contains(Integer.valueOf(10));
        }

        public boolean hasType() {
            return this.zzbCc.contains(Integer.valueOf(11));
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(12));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCO = value;
                    break;
                case 3:
                    this.zzbCP = value;
                    break;
                case 4:
                    this.zzbCQ = value;
                    break;
                case 5:
                    this.zzbCR = value;
                    break;
                case 7:
                    this.zzbCS = value;
                    break;
                case 8:
                    this.zzbCT = value;
                    break;
                case 9:
                    this.zzbCU = value;
                    break;
                case 10:
                    this.zzbCV = value;
                    break;
                case 11:
                    this.zzKj = value;
                    break;
                case 12:
                    this.mValue = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzl com_google_android_gms_people_identity_internal_models_zzl = CREATOR;
            zzl.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(6));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public boolean zzHg() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public boolean zzHh() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public boolean zzHi() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public String zzHj() {
            return this.zzbCR;
        }

        public boolean zzHk() {
            return this.zzbCc.contains(Integer.valueOf(5));
        }

        public String zzHl() {
            return this.zzbCS;
        }

        public boolean zzHm() {
            return this.zzbCc.contains(Integer.valueOf(7));
        }

        public boolean zzHn() {
            return this.zzbCc.contains(Integer.valueOf(9));
        }
    }

    public static final class Birthdays extends FastJsonResponse implements SafeParcelable {
        public static final zzm CREATOR = new zzm();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        final int mVersionCode;
        DefaultMetadataImpl zzbCN;
        String zzbCW;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("date", Field.forString("date", 2));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 3, DefaultMetadataImpl.class));
        }

        public Birthdays() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Birthdays(Set<Integer> indicatorSet, int versionCode, String date, DefaultMetadataImpl metadata) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCW = date;
            this.zzbCN = metadata;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzm com_google_android_gms_people_identity_internal_models_zzm = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Birthdays)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Birthdays birthdays = (Birthdays) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!birthdays.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(birthdays.getFieldValue(field))) {
                        return false;
                    }
                } else if (birthdays.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCW;
                case 3:
                    return this.zzbCN;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCW = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
        }

        public void writeToParcel(Parcel out, int flags) {
            zzm com_google_android_gms_people_identity_internal_models_zzm = CREATOR;
            zzm.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public String zzHo() {
            return this.zzbCW;
        }

        public boolean zzHp() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }
    }

    public static final class BraggingRights extends FastJsonResponse implements SafeParcelable {
        public static final zzn CREATOR = new zzn();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        DefaultMetadataImpl zzbCN;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("metadata", Field.forConcreteType("metadata", 2, DefaultMetadataImpl.class));
            zzbCb.put("value", Field.forString("value", 3));
        }

        public BraggingRights() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        BraggingRights(Set<Integer> indicatorSet, int versionCode, DefaultMetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCN = metadata;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzn com_google_android_gms_people_identity_internal_models_zzn = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof BraggingRights)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            BraggingRights braggingRights = (BraggingRights) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!braggingRights.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(braggingRights.getFieldValue(field))) {
                        return false;
                    }
                } else if (braggingRights.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCN;
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.mValue = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
        }

        public void writeToParcel(Parcel out, int flags) {
            zzn com_google_android_gms_people_identity_internal_models_zzn = CREATOR;
            zzn.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }
    }

    public static final class CoverPhotos extends FastJsonResponse implements SafeParcelable {
        public static final zzo CREATOR = new zzo();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        final int mVersionCode;
        String zzE;
        boolean zzbCX;
        final Set<Integer> zzbCc;
        int zzoW;
        int zzoX;
        String zzyU;

        static {
            zzbCb.put("height", Field.forInteger("height", 2));
            zzbCb.put("id", Field.forString("id", 3));
            zzbCb.put("isDefault", Field.forBoolean("isDefault", 4));
            zzbCb.put("url", Field.forString("url", 5));
            zzbCb.put("width", Field.forInteger("width", 6));
        }

        public CoverPhotos() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        CoverPhotos(Set<Integer> indicatorSet, int versionCode, int height, String id, boolean isDefault, String url, int width) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzoX = height;
            this.zzyU = id;
            this.zzbCX = isDefault;
            this.zzE = url;
            this.zzoW = width;
        }

        public int describeContents() {
            zzo com_google_android_gms_people_identity_internal_models_zzo = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CoverPhotos)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            CoverPhotos coverPhotos = (CoverPhotos) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!coverPhotos.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(coverPhotos.getFieldValue(field))) {
                        return false;
                    }
                } else if (coverPhotos.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return Integer.valueOf(this.zzoX);
                case 3:
                    return this.zzyU;
                case 4:
                    return Boolean.valueOf(this.zzbCX);
                case 5:
                    return this.zzE;
                case 6:
                    return Integer.valueOf(this.zzoW);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public int getHeight() {
            return this.zzoX;
        }

        public String getId() {
            return this.zzyU;
        }

        public String getUrl() {
            return this.zzE;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public int getWidth() {
            return this.zzoW;
        }

        public boolean hasHeight() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public boolean hasId() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public boolean hasUrl() {
            return this.zzbCc.contains(Integer.valueOf(5));
        }

        public boolean hasWidth() {
            return this.zzbCc.contains(Integer.valueOf(6));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDefault() {
            return this.zzbCX;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setBooleanInternal(Field<?, ?> field, String outputField, boolean value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 4:
                    this.zzbCX = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a boolean.");
            }
        }

        protected void setIntegerInternal(Field<?, ?> field, String outputField, int value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzoX = value;
                    break;
                case 6:
                    this.zzoW = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be an int.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzyU = value;
                    break;
                case 5:
                    this.zzE = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzo com_google_android_gms_people_identity_internal_models_zzo = CREATOR;
            zzo.zza(this, out, flags);
        }

        public boolean zzHq() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }
    }

    public static final class CustomFields extends FastJsonResponse implements SafeParcelable {
        public static final zzp CREATOR = new zzp();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzbCc;
        String zzvV;

        static {
            zzbCb.put("key", Field.forString("key", 2));
            zzbCb.put("value", Field.forString("value", 3));
        }

        public CustomFields() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        CustomFields(Set<Integer> indicatorSet, int versionCode, String key, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzvV = key;
            this.mValue = value;
        }

        public int describeContents() {
            zzp com_google_android_gms_people_identity_internal_models_zzp = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CustomFields)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            CustomFields customFields = (CustomFields) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!customFields.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(customFields.getFieldValue(field))) {
                        return false;
                    }
                } else if (customFields.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzvV;
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getKey() {
            return this.zzvV;
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasKey() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzvV = value;
                    break;
                case 3:
                    this.mValue = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzp com_google_android_gms_people_identity_internal_models_zzp = CREATOR;
            zzp.zza(this, out, flags);
        }
    }

    public static final class Emails extends FastJsonResponse implements SafeParcelable {
        public static final zzq CREATOR = new zzq();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        String zzKj;
        DefaultMetadataImpl zzbCN;
        String zzbCR;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("formattedType", Field.forString("formattedType", 2));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 3, DefaultMetadataImpl.class));
            zzbCb.put("type", Field.forString("type", 4));
            zzbCb.put("value", Field.forString("value", 5));
        }

        public Emails() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Emails(Set<Integer> indicatorSet, int versionCode, String formattedType, DefaultMetadataImpl metadata, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCR = formattedType;
            this.zzbCN = metadata;
            this.zzKj = type;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzq com_google_android_gms_people_identity_internal_models_zzq = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Emails)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Emails emails = (Emails) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!emails.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(emails.getFieldValue(field))) {
                        return false;
                    }
                } else if (emails.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCR;
                case 3:
                    return this.zzbCN;
                case 4:
                    return this.zzKj;
                case 5:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getType() {
            return this.zzKj;
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasType() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(5));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCR = value;
                    break;
                case 4:
                    this.zzKj = value;
                    break;
                case 5:
                    this.mValue = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzq com_google_android_gms_people_identity_internal_models_zzq = CREATOR;
            zzq.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public String zzHj() {
            return this.zzbCR;
        }

        public boolean zzHk() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }
    }

    public static final class Events extends FastJsonResponse implements SafeParcelable {
        public static final zzr CREATOR = new zzr();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        final int mVersionCode;
        String zzKj;
        DefaultMetadataImpl zzbCN;
        String zzbCR;
        String zzbCW;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("date", Field.forString("date", 2));
            zzbCb.put("formattedType", Field.forString("formattedType", 3));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 4, DefaultMetadataImpl.class));
            zzbCb.put("type", Field.forString("type", 5));
        }

        public Events() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Events(Set<Integer> indicatorSet, int versionCode, String date, String formattedType, DefaultMetadataImpl metadata, String type) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCW = date;
            this.zzbCR = formattedType;
            this.zzbCN = metadata;
            this.zzKj = type;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 4:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzr com_google_android_gms_people_identity_internal_models_zzr = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Events)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Events events = (Events) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!events.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(events.getFieldValue(field))) {
                        return false;
                    }
                } else if (events.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCW;
                case 3:
                    return this.zzbCR;
                case 4:
                    return this.zzbCN;
                case 5:
                    return this.zzKj;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getType() {
            return this.zzKj;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasType() {
            return this.zzbCc.contains(Integer.valueOf(5));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCW = value;
                    break;
                case 3:
                    this.zzbCR = value;
                    break;
                case 5:
                    this.zzKj = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzr com_google_android_gms_people_identity_internal_models_zzr = CREATOR;
            zzr.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public String zzHj() {
            return this.zzbCR;
        }

        public boolean zzHk() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public String zzHo() {
            return this.zzbCW;
        }

        public boolean zzHp() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }
    }

    public static final class Genders extends FastJsonResponse implements SafeParcelable {
        public static final zzs CREATOR = new zzs();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        String zzaWt;
        DefaultMetadataImpl zzbCN;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("formattedValue", Field.forString("formattedValue", 2));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 3, DefaultMetadataImpl.class));
            zzbCb.put("value", Field.forString("value", 4));
        }

        public Genders() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Genders(Set<Integer> indicatorSet, int versionCode, String formattedValue, DefaultMetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzaWt = formattedValue;
            this.zzbCN = metadata;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzs com_google_android_gms_people_identity_internal_models_zzs = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Genders)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Genders genders = (Genders) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!genders.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(genders.getFieldValue(field))) {
                        return false;
                    }
                } else if (genders.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzaWt;
                case 3:
                    return this.zzbCN;
                case 4:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getFormattedValue() {
            return this.zzaWt;
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzaWt = value;
                    break;
                case 4:
                    this.mValue = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzs com_google_android_gms_people_identity_internal_models_zzs = CREATOR;
            zzs.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public boolean zzHr() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }
    }

    public static final class Images extends FastJsonResponse implements SafeParcelable {
        public static final zzt CREATOR = new zzt();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        final int mVersionCode;
        String zzE;
        DefaultMetadataImpl zzbCN;
        boolean zzbCX;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("isDefault", Field.forBoolean("isDefault", 2));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 3, DefaultMetadataImpl.class));
            zzbCb.put("url", Field.forString("url", 4));
        }

        public Images() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Images(Set<Integer> indicatorSet, int versionCode, boolean isDefault, DefaultMetadataImpl metadata, String url) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCX = isDefault;
            this.zzbCN = metadata;
            this.zzE = url;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzt com_google_android_gms_people_identity_internal_models_zzt = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Images)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Images images = (Images) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!images.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(images.getFieldValue(field))) {
                        return false;
                    }
                } else if (images.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return Boolean.valueOf(this.zzbCX);
                case 3:
                    return this.zzbCN;
                case 4:
                    return this.zzE;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getUrl() {
            return this.zzE;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasUrl() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDefault() {
            return this.zzbCX;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setBooleanInternal(Field<?, ?> field, String outputField, boolean value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCX = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a boolean.");
            }
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 4:
                    this.zzE = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
        }

        public void writeToParcel(Parcel out, int flags) {
            zzt com_google_android_gms_people_identity_internal_models_zzt = CREATOR;
            zzt.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public boolean zzHq() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }
    }

    public static final class InstantMessaging extends FastJsonResponse implements SafeParcelable {
        public static final zzu CREATOR = new zzu();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        String zzKj;
        DefaultMetadataImpl zzbCN;
        String zzbCR;
        String zzbCY;
        String zzbCZ;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("formattedProtocol", Field.forString("formattedProtocol", 2));
            zzbCb.put("formattedType", Field.forString("formattedType", 3));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 4, DefaultMetadataImpl.class));
            zzbCb.put("protocol", Field.forString("protocol", 5));
            zzbCb.put("type", Field.forString("type", 6));
            zzbCb.put("value", Field.forString("value", 7));
        }

        public InstantMessaging() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        InstantMessaging(Set<Integer> indicatorSet, int versionCode, String formattedProtocol, String formattedType, DefaultMetadataImpl metadata, String protocol, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCY = formattedProtocol;
            this.zzbCR = formattedType;
            this.zzbCN = metadata;
            this.zzbCZ = protocol;
            this.zzKj = type;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 4:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzu com_google_android_gms_people_identity_internal_models_zzu = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof InstantMessaging)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            InstantMessaging instantMessaging = (InstantMessaging) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!instantMessaging.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(instantMessaging.getFieldValue(field))) {
                        return false;
                    }
                } else if (instantMessaging.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCY;
                case 3:
                    return this.zzbCR;
                case 4:
                    return this.zzbCN;
                case 5:
                    return this.zzbCZ;
                case 6:
                    return this.zzKj;
                case 7:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getProtocol() {
            return this.zzbCZ;
        }

        public String getType() {
            return this.zzKj;
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasType() {
            return this.zzbCc.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCY = value;
                    break;
                case 3:
                    this.zzbCR = value;
                    break;
                case 5:
                    this.zzbCZ = value;
                    break;
                case 6:
                    this.zzKj = value;
                    break;
                case 7:
                    this.mValue = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzu com_google_android_gms_people_identity_internal_models_zzu = CREATOR;
            zzu.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public String zzHj() {
            return this.zzbCR;
        }

        public boolean zzHk() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public String zzHs() {
            return this.zzbCY;
        }

        public boolean zzHt() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public boolean zzHu() {
            return this.zzbCc.contains(Integer.valueOf(5));
        }
    }

    public static final class LegacyFields extends FastJsonResponse implements SafeParcelable {
        public static final zzv CREATOR = new zzv();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        final int mVersionCode;
        final Set<Integer> zzbCc;
        String zzbDa;

        static {
            zzbCb.put("mobileOwnerId", Field.forString("mobileOwnerId", 2));
        }

        public LegacyFields() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        LegacyFields(Set<Integer> indicatorSet, int versionCode, String mobileOwnerId) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDa = mobileOwnerId;
        }

        public int describeContents() {
            zzv com_google_android_gms_people_identity_internal_models_zzv = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LegacyFields)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            LegacyFields legacyFields = (LegacyFields) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!legacyFields.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(legacyFields.getFieldValue(field))) {
                        return false;
                    }
                } else if (legacyFields.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbDa;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbDa = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
        }

        public void writeToParcel(Parcel out, int flags) {
            zzv com_google_android_gms_people_identity_internal_models_zzv = CREATOR;
            zzv.zza(this, out, flags);
        }

        public String zzHv() {
            return this.zzbDa;
        }

        public boolean zzHw() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }
    }

    public static final class Memberships extends FastJsonResponse implements SafeParcelable {
        public static final zzw CREATOR = new zzw();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        final int mVersionCode;
        DefaultMetadataImpl zzbCN;
        final Set<Integer> zzbCc;
        String zzbDb;
        String zzbDc;
        String zzbDd;

        static {
            zzbCb.put("circle", Field.forString("circle", 2));
            zzbCb.put("contactGroup", Field.forString("contactGroup", 3));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 4, DefaultMetadataImpl.class));
            zzbCb.put("systemContactGroup", Field.forString("systemContactGroup", 5));
        }

        public Memberships() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Memberships(Set<Integer> indicatorSet, int versionCode, String circle, String contactGroup, DefaultMetadataImpl metadata, String systemContactGroup) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDb = circle;
            this.zzbDc = contactGroup;
            this.zzbCN = metadata;
            this.zzbDd = systemContactGroup;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 4:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzw com_google_android_gms_people_identity_internal_models_zzw = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Memberships)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Memberships memberships = (Memberships) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!memberships.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(memberships.getFieldValue(field))) {
                        return false;
                    }
                } else if (memberships.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbDb;
                case 3:
                    return this.zzbDc;
                case 4:
                    return this.zzbCN;
                case 5:
                    return this.zzbDd;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbDb = value;
                    break;
                case 3:
                    this.zzbDc = value;
                    break;
                case 5:
                    this.zzbDd = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzw com_google_android_gms_people_identity_internal_models_zzw = CREATOR;
            zzw.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public boolean zzHA() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public String zzHB() {
            return this.zzbDd;
        }

        public boolean zzHC() {
            return this.zzbCc.contains(Integer.valueOf(5));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public String zzHx() {
            return this.zzbDb;
        }

        public boolean zzHy() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public String zzHz() {
            return this.zzbDc;
        }
    }

    public static final class Metadata extends FastJsonResponse implements SafeParcelable {
        public static final zzx CREATOR = new zzx();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        final int mVersionCode;
        String zzaMS;
        List<String> zzbAk;
        final Set<Integer> zzbCc;
        List<Affinities> zzbCd;
        List<String> zzbDe;
        boolean zzbDf;
        List<String> zzbDg;
        boolean zzbDh;
        List<String> zzbDi;
        boolean zzbDj;
        List<String> zzbDk;
        long zzbDl;
        String zzbDm;
        List<String> zzbDn;
        List<DefaultPersonImpl> zzbDo;
        String zzbDp;
        ProfileOwnerStats zzbDq;
        List<String> zzblg;

        public static final class Affinities extends FastJsonResponse implements SafeParcelable {
            public static final zzy CREATOR = new zzy();
            private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
            final int mVersionCode;
            String zzKj;
            final Set<Integer> zzbCc;
            double zzbCl;

            static {
                zzbCb.put("type", Field.forString("type", 2));
                zzbCb.put("value", Field.forDouble("value", 3));
            }

            public Affinities() {
                this.mVersionCode = 1;
                this.zzbCc = new HashSet();
            }

            Affinities(Set<Integer> indicatorSet, int versionCode, String type, double value) {
                this.zzbCc = indicatorSet;
                this.mVersionCode = versionCode;
                this.zzKj = type;
                this.zzbCl = value;
            }

            public int describeContents() {
                zzy com_google_android_gms_people_identity_internal_models_zzy = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof Affinities)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                Affinities affinities = (Affinities) obj;
                for (Field field : zzbCb.values()) {
                    if (isFieldSet(field)) {
                        if (!affinities.isFieldSet(field)) {
                            return false;
                        }
                        if (!getFieldValue(field).equals(affinities.getFieldValue(field))) {
                            return false;
                        }
                    } else if (affinities.isFieldSet(field)) {
                        return false;
                    }
                }
                return true;
            }

            public HashMap<String, Field<?, ?>> getFieldMappings() {
                return zzbCb;
            }

            protected Object getFieldValue(Field field) {
                switch (field.getSafeParcelableFieldId()) {
                    case 2:
                        return this.zzKj;
                    case 3:
                        return Double.valueOf(this.zzbCl);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
                }
            }

            protected Object getValueObject(String key) {
                return null;
            }

            public int hashCode() {
                int i = 0;
                for (Field field : zzbCb.values()) {
                    int hashCode;
                    if (isFieldSet(field)) {
                        hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            protected boolean isFieldSet(Field field) {
                return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
            }

            protected boolean isPrimitiveFieldSet(String outputField) {
                return false;
            }

            protected void setDoubleInternal(Field<?, ?> field, String outputField, double value) {
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                switch (safeParcelableFieldId) {
                    case 3:
                        this.zzbCl = value;
                        this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                        return;
                    default:
                        throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a double.");
                }
            }

            protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                switch (safeParcelableFieldId) {
                    case 2:
                        this.zzKj = value;
                        this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                        return;
                    default:
                        throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
                }
            }

            public void writeToParcel(Parcel out, int flags) {
                zzy com_google_android_gms_people_identity_internal_models_zzy = CREATOR;
                zzy.zza(this, out, flags);
            }
        }

        public static final class ProfileOwnerStats extends FastJsonResponse implements SafeParcelable {
            public static final zzz CREATOR = new zzz();
            private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
            final int mVersionCode;
            final Set<Integer> zzbCc;
            long zzbDr;
            long zzbDs;

            static {
                zzbCb.put("incomingAnyCircleCount", Field.forLong("incomingAnyCircleCount", 2));
                zzbCb.put("viewCount", Field.forLong("viewCount", 3));
            }

            public ProfileOwnerStats() {
                this.mVersionCode = 1;
                this.zzbCc = new HashSet();
            }

            ProfileOwnerStats(Set<Integer> indicatorSet, int versionCode, long incomingAnyCircleCount, long viewCount) {
                this.zzbCc = indicatorSet;
                this.mVersionCode = versionCode;
                this.zzbDr = incomingAnyCircleCount;
                this.zzbDs = viewCount;
            }

            public int describeContents() {
                zzz com_google_android_gms_people_identity_internal_models_zzz = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof ProfileOwnerStats)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                ProfileOwnerStats profileOwnerStats = (ProfileOwnerStats) obj;
                for (Field field : zzbCb.values()) {
                    if (isFieldSet(field)) {
                        if (!profileOwnerStats.isFieldSet(field)) {
                            return false;
                        }
                        if (!getFieldValue(field).equals(profileOwnerStats.getFieldValue(field))) {
                            return false;
                        }
                    } else if (profileOwnerStats.isFieldSet(field)) {
                        return false;
                    }
                }
                return true;
            }

            public HashMap<String, Field<?, ?>> getFieldMappings() {
                return zzbCb;
            }

            protected Object getFieldValue(Field field) {
                switch (field.getSafeParcelableFieldId()) {
                    case 2:
                        return Long.valueOf(this.zzbDr);
                    case 3:
                        return Long.valueOf(this.zzbDs);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
                }
            }

            protected Object getValueObject(String key) {
                return null;
            }

            public int hashCode() {
                int i = 0;
                for (Field field : zzbCb.values()) {
                    int hashCode;
                    if (isFieldSet(field)) {
                        hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            protected boolean isFieldSet(Field field) {
                return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
            }

            protected boolean isPrimitiveFieldSet(String outputField) {
                return false;
            }

            protected void setLongInternal(Field<?, ?> field, String outputField, long value) {
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                switch (safeParcelableFieldId) {
                    case 2:
                        this.zzbDr = value;
                        break;
                    case 3:
                        this.zzbDs = value;
                        break;
                    default:
                        throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a double.");
                }
                this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
            }

            public void writeToParcel(Parcel out, int flags) {
                zzz com_google_android_gms_people_identity_internal_models_zzz = CREATOR;
                zzz.zza(this, out, flags);
            }

            public long zzIa() {
                return this.zzbDr;
            }

            public boolean zzIb() {
                return this.zzbCc.contains(Integer.valueOf(2));
            }

            public long zzIc() {
                return this.zzbDs;
            }

            public boolean zzId() {
                return this.zzbCc.contains(Integer.valueOf(3));
            }
        }

        static {
            zzbCb.put("affinities", Field.forConcreteTypeArray("affinities", 2, Affinities.class));
            zzbCb.put("attributions", Field.forStrings("attributions", 3));
            zzbCb.put("blockTypes", Field.forStrings("blockTypes", 4));
            zzbCb.put("blocked", Field.forBoolean("blocked", 5));
            zzbCb.put("circles", Field.forStrings("circles", 6));
            zzbCb.put("contacts", Field.forStrings("contacts", 7));
            zzbCb.put("deleted", Field.forBoolean("deleted", 8));
            zzbCb.put("groups", Field.forStrings("groups", 9));
            zzbCb.put("inViewerDomain", Field.forBoolean("inViewerDomain", 10));
            zzbCb.put("incomingBlockTypes", Field.forStrings("incomingBlockTypes", 11));
            zzbCb.put("lastUpdateTimeMicros", Field.forLong("lastUpdateTimeMicros", 12));
            zzbCb.put("objectType", Field.forString("objectType", 13));
            zzbCb.put("ownerId", Field.forString("ownerId", 14));
            zzbCb.put("ownerUserTypes", Field.forStrings("ownerUserTypes", 15));
            zzbCb.put("peopleInCommon", Field.forConcreteTypeArray("peopleInCommon", 16, DefaultPersonImpl.class));
            zzbCb.put("plusPageType", Field.forString("plusPageType", 17));
            zzbCb.put("profileOwnerStats", Field.forConcreteType("profileOwnerStats", 18, ProfileOwnerStats.class));
        }

        public Metadata() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Metadata(Set<Integer> indicatorSet, int versionCode, List<Affinities> affinities, List<String> attributions, List<String> blockTypes, boolean blocked, List<String> circles, List<String> contacts, boolean deleted, List<String> groups, boolean inViewerDomain, List<String> incomingBlockTypes, long lastUpdateTimeMicros, String objectType, String ownerId, List<String> ownerUserTypes, List<DefaultPersonImpl> peopleInCommon, String plusPageType, ProfileOwnerStats profileOwnerStats) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCd = affinities;
            this.zzblg = attributions;
            this.zzbDe = blockTypes;
            this.zzbDf = blocked;
            this.zzbAk = circles;
            this.zzbDg = contacts;
            this.zzbDh = deleted;
            this.zzbDi = groups;
            this.zzbDj = inViewerDomain;
            this.zzbDk = incomingBlockTypes;
            this.zzbDl = lastUpdateTimeMicros;
            this.zzaMS = objectType;
            this.zzbDm = ownerId;
            this.zzbDn = ownerUserTypes;
            this.zzbDo = peopleInCommon;
            this.zzbDp = plusPageType;
            this.zzbDq = profileOwnerStats;
        }

        public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> field, String outputField, ArrayList<T> value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCd = value;
                    break;
                case 16:
                    this.zzbDo = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known array of" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 18:
                    this.zzbDq = (ProfileOwnerStats) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzx com_google_android_gms_people_identity_internal_models_zzx = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Metadata)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Metadata metadata = (Metadata) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!metadata.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(metadata.getFieldValue(field))) {
                        return false;
                    }
                } else if (metadata.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public List<String> getCircles() {
            return this.zzbAk;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCd;
                case 3:
                    return this.zzblg;
                case 4:
                    return this.zzbDe;
                case 5:
                    return Boolean.valueOf(this.zzbDf);
                case 6:
                    return this.zzbAk;
                case 7:
                    return this.zzbDg;
                case 8:
                    return Boolean.valueOf(this.zzbDh);
                case 9:
                    return this.zzbDi;
                case 10:
                    return Boolean.valueOf(this.zzbDj);
                case 11:
                    return this.zzbDk;
                case 12:
                    return Long.valueOf(this.zzbDl);
                case 13:
                    return this.zzaMS;
                case 14:
                    return this.zzbDm;
                case 15:
                    return this.zzbDn;
                case 16:
                    return this.zzbDo;
                case 17:
                    return this.zzbDp;
                case 18:
                    return this.zzbDq;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getOwnerId() {
            return this.zzbDm;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasObjectType() {
            return this.zzbCc.contains(Integer.valueOf(13));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isBlocked() {
            return this.zzbDf;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setBooleanInternal(Field<?, ?> field, String outputField, boolean value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 5:
                    this.zzbDf = value;
                    break;
                case 8:
                    this.zzbDh = value;
                    break;
                case 10:
                    this.zzbDj = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a boolean.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        protected void setLongInternal(Field<?, ?> field, String outputField, long value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 12:
                    this.zzbDl = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a long.");
            }
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 13:
                    this.zzaMS = value;
                    break;
                case 14:
                    this.zzbDm = value;
                    break;
                case 17:
                    this.zzbDp = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        protected void setStringsInternal(Field<?, ?> field, String outputField, ArrayList<String> value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzblg = value;
                    break;
                case 4:
                    this.zzbDe = value;
                    break;
                case 6:
                    this.zzbAk = value;
                    break;
                case 7:
                    this.zzbDg = value;
                    break;
                case 9:
                    this.zzbDi = value;
                    break;
                case 11:
                    this.zzbDk = value;
                    break;
                case 15:
                    this.zzbDn = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be an array of " + "String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzx com_google_android_gms_people_identity_internal_models_zzx = CREATOR;
            zzx.zza(this, out, flags);
        }

        public List<String> zzHD() {
            return this.zzblg;
        }

        public boolean zzHE() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public List<String> zzHF() {
            return this.zzbDe;
        }

        public boolean zzHG() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public boolean zzHH() {
            return this.zzbCc.contains(Integer.valueOf(5));
        }

        public boolean zzHI() {
            return this.zzbCc.contains(Integer.valueOf(6));
        }

        public List<String> zzHJ() {
            return this.zzbDg;
        }

        public boolean zzHK() {
            return this.zzbCc.contains(Integer.valueOf(7));
        }

        public boolean zzHL() {
            return this.zzbDh;
        }

        public boolean zzHM() {
            return this.zzbCc.contains(Integer.valueOf(8));
        }

        public List<String> zzHN() {
            return this.zzbDi;
        }

        public boolean zzHO() {
            return this.zzbCc.contains(Integer.valueOf(9));
        }

        public boolean zzHP() {
            return this.zzbDj;
        }

        public boolean zzHQ() {
            return this.zzbCc.contains(Integer.valueOf(10));
        }

        public List<String> zzHR() {
            return this.zzbDk;
        }

        public boolean zzHS() {
            return this.zzbCc.contains(Integer.valueOf(11));
        }

        public boolean zzHT() {
            return this.zzbCc.contains(Integer.valueOf(14));
        }

        public List<String> zzHU() {
            return this.zzbDn;
        }

        public boolean zzHV() {
            return this.zzbCc.contains(Integer.valueOf(15));
        }

        public String zzHW() {
            return this.zzbDp;
        }

        public boolean zzHX() {
            return this.zzbCc.contains(Integer.valueOf(17));
        }

        public ProfileOwnerStats zzHY() {
            return this.zzbDq;
        }

        public boolean zzHZ() {
            return this.zzbCc.contains(Integer.valueOf(18));
        }

        public String zzwm() {
            return this.zzaMS;
        }
    }

    public static final class Names extends FastJsonResponse implements SafeParcelable {
        public static final zzaa CREATOR = new zzaa();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        final int mVersionCode;
        String zzVA;
        DefaultMetadataImpl zzbCN;
        final Set<Integer> zzbCc;
        String zzbDA;
        String zzbDB;
        String zzbDC;
        String zzbDt;
        String zzbDu;
        String zzbDv;
        String zzbDw;
        String zzbDx;
        String zzbDy;
        String zzbDz;

        static {
            zzbCb.put("displayName", Field.forString("displayName", 2));
            zzbCb.put("familyName", Field.forString("familyName", 3));
            zzbCb.put("formatted", Field.forString("formatted", 4));
            zzbCb.put("givenName", Field.forString("givenName", 5));
            zzbCb.put("honorificPrefix", Field.forString("honorificPrefix", 6));
            zzbCb.put("honorificSuffix", Field.forString("honorificSuffix", 7));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 8, DefaultMetadataImpl.class));
            zzbCb.put("middleName", Field.forString("middleName", 9));
            zzbCb.put("phoneticFamilyName", Field.forString("phoneticFamilyName", 10));
            zzbCb.put("phoneticGivenName", Field.forString("phoneticGivenName", 11));
            zzbCb.put("phoneticHonorificPrefix", Field.forString("phoneticHonorificPrefix", 12));
            zzbCb.put("phoneticHonorificSuffix", Field.forString("phoneticHonorificSuffix", 13));
        }

        public Names() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Names(Set<Integer> indicatorSet, int versionCode, String displayName, String familyName, String formatted, String givenName, String honorificPrefix, String honorificSuffix, DefaultMetadataImpl metadata, String middleName, String phoneticFamilyName, String phoneticGivenName, String phoneticHonorificPrefix, String phoneticHonorificSuffix) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzVA = displayName;
            this.zzbDt = familyName;
            this.zzbDu = formatted;
            this.zzbDv = givenName;
            this.zzbDw = honorificPrefix;
            this.zzbDx = honorificSuffix;
            this.zzbCN = metadata;
            this.zzbDy = middleName;
            this.zzbDz = phoneticFamilyName;
            this.zzbDA = phoneticGivenName;
            this.zzbDB = phoneticHonorificPrefix;
            this.zzbDC = phoneticHonorificSuffix;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 8:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzaa com_google_android_gms_people_identity_internal_models_zzaa = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Names)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Names names = (Names) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!names.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(names.getFieldValue(field))) {
                        return false;
                    }
                } else if (names.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public String getDisplayName() {
            return this.zzVA;
        }

        public String getFamilyName() {
            return this.zzbDt;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzVA;
                case 3:
                    return this.zzbDt;
                case 4:
                    return this.zzbDu;
                case 5:
                    return this.zzbDv;
                case 6:
                    return this.zzbDw;
                case 7:
                    return this.zzbDx;
                case 8:
                    return this.zzbCN;
                case 9:
                    return this.zzbDy;
                case 10:
                    return this.zzbDz;
                case 11:
                    return this.zzbDA;
                case 12:
                    return this.zzbDB;
                case 13:
                    return this.zzbDC;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getFormatted() {
            return this.zzbDu;
        }

        public String getGivenName() {
            return this.zzbDv;
        }

        public String getHonorificPrefix() {
            return this.zzbDw;
        }

        public String getHonorificSuffix() {
            return this.zzbDx;
        }

        public String getMiddleName() {
            return this.zzbDy;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasDisplayName() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public boolean hasFamilyName() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public boolean hasFormatted() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public boolean hasGivenName() {
            return this.zzbCc.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificPrefix() {
            return this.zzbCc.contains(Integer.valueOf(6));
        }

        public boolean hasHonorificSuffix() {
            return this.zzbCc.contains(Integer.valueOf(7));
        }

        public boolean hasMiddleName() {
            return this.zzbCc.contains(Integer.valueOf(9));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzVA = value;
                    break;
                case 3:
                    this.zzbDt = value;
                    break;
                case 4:
                    this.zzbDu = value;
                    break;
                case 5:
                    this.zzbDv = value;
                    break;
                case 6:
                    this.zzbDw = value;
                    break;
                case 7:
                    this.zzbDx = value;
                    break;
                case 9:
                    this.zzbDy = value;
                    break;
                case 10:
                    this.zzbDz = value;
                    break;
                case 11:
                    this.zzbDA = value;
                    break;
                case 12:
                    this.zzbDB = value;
                    break;
                case 13:
                    this.zzbDC = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzaa com_google_android_gms_people_identity_internal_models_zzaa = CREATOR;
            zzaa.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(8));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public String zzIe() {
            return this.zzbDz;
        }

        public boolean zzIf() {
            return this.zzbCc.contains(Integer.valueOf(10));
        }

        public String zzIg() {
            return this.zzbDA;
        }

        public boolean zzIh() {
            return this.zzbCc.contains(Integer.valueOf(11));
        }

        public String zzIi() {
            return this.zzbDB;
        }

        public boolean zzIj() {
            return this.zzbCc.contains(Integer.valueOf(12));
        }

        public String zzIk() {
            return this.zzbDC;
        }

        public boolean zzIl() {
            return this.zzbCc.contains(Integer.valueOf(13));
        }
    }

    public static final class Nicknames extends FastJsonResponse implements SafeParcelable {
        public static final zzab CREATOR = new zzab();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        String zzKj;
        DefaultMetadataImpl zzbCN;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("metadata", Field.forConcreteType("metadata", 2, DefaultMetadataImpl.class));
            zzbCb.put("type", Field.forString("type", 3));
            zzbCb.put("value", Field.forString("value", 4));
        }

        public Nicknames() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Nicknames(Set<Integer> indicatorSet, int versionCode, DefaultMetadataImpl metadata, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCN = metadata;
            this.zzKj = type;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzab com_google_android_gms_people_identity_internal_models_zzab = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Nicknames)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Nicknames nicknames = (Nicknames) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!nicknames.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(nicknames.getFieldValue(field))) {
                        return false;
                    }
                } else if (nicknames.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCN;
                case 3:
                    return this.zzKj;
                case 4:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getType() {
            return this.zzKj;
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasType() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzKj = value;
                    break;
                case 4:
                    this.mValue = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzab com_google_android_gms_people_identity_internal_models_zzab = CREATOR;
            zzab.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }
    }

    public static final class Occupations extends FastJsonResponse implements SafeParcelable {
        public static final zzac CREATOR = new zzac();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        DefaultMetadataImpl zzbCN;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("metadata", Field.forConcreteType("metadata", 2, DefaultMetadataImpl.class));
            zzbCb.put("value", Field.forString("value", 3));
        }

        public Occupations() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Occupations(Set<Integer> indicatorSet, int versionCode, DefaultMetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCN = metadata;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzac com_google_android_gms_people_identity_internal_models_zzac = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Occupations)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Occupations occupations = (Occupations) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!occupations.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(occupations.getFieldValue(field))) {
                        return false;
                    }
                } else if (occupations.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCN;
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.mValue = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
        }

        public void writeToParcel(Parcel out, int flags) {
            zzac com_google_android_gms_people_identity_internal_models_zzac = CREATOR;
            zzac.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }
    }

    public static final class Organizations extends FastJsonResponse implements SafeParcelable {
        public static final zzad CREATOR = new zzad();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mDescription;
        String mName;
        final int mVersionCode;
        String zzKj;
        String zzaEg;
        DefaultMetadataImpl zzbCN;
        final Set<Integer> zzbCc;
        boolean zzbDD;
        String zzbDE;
        String zzbDF;
        String zzbDG;
        String zzbDH;
        String zzbDI;
        String zzbDJ;
        String zzbDK;

        static {
            zzbCb.put("current", Field.forBoolean("current", 2));
            zzbCb.put("department", Field.forString("department", 3));
            zzbCb.put("description", Field.forString("description", 4));
            zzbCb.put(AudienceMember.AUDIENCE_GROUP_DOMAIN, Field.forString(AudienceMember.AUDIENCE_GROUP_DOMAIN, 5));
            zzbCb.put("endDate", Field.forString("endDate", 6));
            zzbCb.put("location", Field.forString("location", 7));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 8, DefaultMetadataImpl.class));
            zzbCb.put(ContactGroupPreferredFields.NAME, Field.forString(ContactGroupPreferredFields.NAME, 9));
            zzbCb.put("phoneticName", Field.forString("phoneticName", 10));
            zzbCb.put("startDate", Field.forString("startDate", 11));
            zzbCb.put("symbol", Field.forString("symbol", 12));
            zzbCb.put("title", Field.forString("title", 13));
            zzbCb.put("type", Field.forString("type", 14));
        }

        public Organizations() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Organizations(Set<Integer> indicatorSet, int versionCode, boolean current, String department, String description, String domain, String endDate, String location, DefaultMetadataImpl metadata, String name, String phoneticName, String startDate, String symbol, String title, String type) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDD = current;
            this.zzbDE = department;
            this.mDescription = description;
            this.zzbDF = domain;
            this.zzbDG = endDate;
            this.zzbDH = location;
            this.zzbCN = metadata;
            this.mName = name;
            this.zzbDI = phoneticName;
            this.zzbDJ = startDate;
            this.zzbDK = symbol;
            this.zzaEg = title;
            this.zzKj = type;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 8:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzad com_google_android_gms_people_identity_internal_models_zzad = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Organizations)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Organizations organizations = (Organizations) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!organizations.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(organizations.getFieldValue(field))) {
                        return false;
                    }
                } else if (organizations.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public String getDepartment() {
            return this.zzbDE;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public String getDomain() {
            return this.zzbDF;
        }

        public String getEndDate() {
            return this.zzbDG;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return Boolean.valueOf(this.zzbDD);
                case 3:
                    return this.zzbDE;
                case 4:
                    return this.mDescription;
                case 5:
                    return this.zzbDF;
                case 6:
                    return this.zzbDG;
                case 7:
                    return this.zzbDH;
                case 8:
                    return this.zzbCN;
                case 9:
                    return this.mName;
                case 10:
                    return this.zzbDI;
                case 11:
                    return this.zzbDJ;
                case 12:
                    return this.zzbDK;
                case 13:
                    return this.zzaEg;
                case 14:
                    return this.zzKj;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getLocation() {
            return this.zzbDH;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.zzbDJ;
        }

        public String getSymbol() {
            return this.zzbDK;
        }

        public String getTitle() {
            return this.zzaEg;
        }

        public String getType() {
            return this.zzKj;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasDepartment() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public boolean hasDescription() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public boolean hasEndDate() {
            return this.zzbCc.contains(Integer.valueOf(6));
        }

        public boolean hasLocation() {
            return this.zzbCc.contains(Integer.valueOf(7));
        }

        public boolean hasName() {
            return this.zzbCc.contains(Integer.valueOf(9));
        }

        public boolean hasStartDate() {
            return this.zzbCc.contains(Integer.valueOf(11));
        }

        public boolean hasTitle() {
            return this.zzbCc.contains(Integer.valueOf(13));
        }

        public boolean hasType() {
            return this.zzbCc.contains(Integer.valueOf(14));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setBooleanInternal(Field<?, ?> field, String outputField, boolean value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbDD = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a boolean.");
            }
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzbDE = value;
                    break;
                case 4:
                    this.mDescription = value;
                    break;
                case 5:
                    this.zzbDF = value;
                    break;
                case 6:
                    this.zzbDG = value;
                    break;
                case 7:
                    this.zzbDH = value;
                    break;
                case 9:
                    this.mName = value;
                    break;
                case 10:
                    this.zzbDI = value;
                    break;
                case 11:
                    this.zzbDJ = value;
                    break;
                case 12:
                    this.zzbDK = value;
                    break;
                case 13:
                    this.zzaEg = value;
                    break;
                case 14:
                    this.zzKj = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzad com_google_android_gms_people_identity_internal_models_zzad = CREATOR;
            zzad.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(8));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public boolean zzIm() {
            return this.zzbDD;
        }

        public boolean zzIn() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public boolean zzIo() {
            return this.zzbCc.contains(Integer.valueOf(5));
        }

        public String zzIp() {
            return this.zzbDI;
        }

        public boolean zzIq() {
            return this.zzbCc.contains(Integer.valueOf(10));
        }

        public boolean zzIr() {
            return this.zzbCc.contains(Integer.valueOf(12));
        }
    }

    public static final class PhoneNumbers extends FastJsonResponse implements SafeParcelable {
        public static final zzae CREATOR = new zzae();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        String zzKj;
        DefaultMetadataImpl zzbCN;
        String zzbCR;
        final Set<Integer> zzbCc;
        String zzbDL;

        static {
            zzbCb.put("canonicalizedForm", Field.forString("canonicalizedForm", 2));
            zzbCb.put("formattedType", Field.forString("formattedType", 3));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 4, DefaultMetadataImpl.class));
            zzbCb.put("type", Field.forString("type", 5));
            zzbCb.put("value", Field.forString("value", 6));
        }

        public PhoneNumbers() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        PhoneNumbers(Set<Integer> indicatorSet, int versionCode, String canonicalizedForm, String formattedType, DefaultMetadataImpl metadata, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDL = canonicalizedForm;
            this.zzbCR = formattedType;
            this.zzbCN = metadata;
            this.zzKj = type;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 4:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzae com_google_android_gms_people_identity_internal_models_zzae = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PhoneNumbers)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PhoneNumbers phoneNumbers = (PhoneNumbers) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!phoneNumbers.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(phoneNumbers.getFieldValue(field))) {
                        return false;
                    }
                } else if (phoneNumbers.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbDL;
                case 3:
                    return this.zzbCR;
                case 4:
                    return this.zzbCN;
                case 5:
                    return this.zzKj;
                case 6:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getType() {
            return this.zzKj;
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasType() {
            return this.zzbCc.contains(Integer.valueOf(5));
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(6));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbDL = value;
                    break;
                case 3:
                    this.zzbCR = value;
                    break;
                case 5:
                    this.zzKj = value;
                    break;
                case 6:
                    this.mValue = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzae com_google_android_gms_people_identity_internal_models_zzae = CREATOR;
            zzae.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public String zzHj() {
            return this.zzbCR;
        }

        public boolean zzHk() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public String zzIs() {
            return this.zzbDL;
        }

        public boolean zzIt() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }
    }

    public static final class PlacesLived extends FastJsonResponse implements SafeParcelable {
        public static final zzaf CREATOR = new zzaf();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        DefaultMetadataImpl zzbCN;
        final Set<Integer> zzbCc;
        boolean zzbDD;

        static {
            zzbCb.put("current", Field.forBoolean("current", 2));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 3, DefaultMetadataImpl.class));
            zzbCb.put("value", Field.forString("value", 4));
        }

        public PlacesLived() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        PlacesLived(Set<Integer> indicatorSet, int versionCode, boolean current, DefaultMetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDD = current;
            this.zzbCN = metadata;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzaf com_google_android_gms_people_identity_internal_models_zzaf = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PlacesLived)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PlacesLived placesLived = (PlacesLived) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!placesLived.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(placesLived.getFieldValue(field))) {
                        return false;
                    }
                } else if (placesLived.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return Boolean.valueOf(this.zzbDD);
                case 3:
                    return this.zzbCN;
                case 4:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setBooleanInternal(Field<?, ?> field, String outputField, boolean value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbDD = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a boolean.");
            }
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 4:
                    this.mValue = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
        }

        public void writeToParcel(Parcel out, int flags) {
            zzaf com_google_android_gms_people_identity_internal_models_zzaf = CREATOR;
            zzaf.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public boolean zzIm() {
            return this.zzbDD;
        }

        public boolean zzIn() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }
    }

    public static final class Relations extends FastJsonResponse implements SafeParcelable {
        public static final zzag CREATOR = new zzag();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        String zzKj;
        DefaultMetadataImpl zzbCN;
        String zzbCR;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("formattedType", Field.forString("formattedType", 2));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 3, DefaultMetadataImpl.class));
            zzbCb.put("type", Field.forString("type", 4));
            zzbCb.put("value", Field.forString("value", 5));
        }

        public Relations() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Relations(Set<Integer> indicatorSet, int versionCode, String formattedType, DefaultMetadataImpl metadata, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCR = formattedType;
            this.zzbCN = metadata;
            this.zzKj = type;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzag com_google_android_gms_people_identity_internal_models_zzag = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Relations)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Relations relations = (Relations) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!relations.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(relations.getFieldValue(field))) {
                        return false;
                    }
                } else if (relations.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCR;
                case 3:
                    return this.zzbCN;
                case 4:
                    return this.zzKj;
                case 5:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getType() {
            return this.zzKj;
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasType() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(5));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCR = value;
                    break;
                case 4:
                    this.zzKj = value;
                    break;
                case 5:
                    this.mValue = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzag com_google_android_gms_people_identity_internal_models_zzag = CREATOR;
            zzag.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public String zzHj() {
            return this.zzbCR;
        }

        public boolean zzHk() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }
    }

    public static final class RelationshipInterests extends FastJsonResponse implements SafeParcelable {
        public static final zzah CREATOR = new zzah();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        DefaultMetadataImpl zzbCN;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("metadata", Field.forConcreteType("metadata", 2, DefaultMetadataImpl.class));
            zzbCb.put("value", Field.forString("value", 3));
        }

        public RelationshipInterests() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        RelationshipInterests(Set<Integer> indicatorSet, int versionCode, DefaultMetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCN = metadata;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzah com_google_android_gms_people_identity_internal_models_zzah = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof RelationshipInterests)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            RelationshipInterests relationshipInterests = (RelationshipInterests) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!relationshipInterests.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(relationshipInterests.getFieldValue(field))) {
                        return false;
                    }
                } else if (relationshipInterests.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCN;
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.mValue = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
        }

        public void writeToParcel(Parcel out, int flags) {
            zzah com_google_android_gms_people_identity_internal_models_zzah = CREATOR;
            zzah.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }
    }

    public static final class RelationshipStatuses extends FastJsonResponse implements SafeParcelable {
        public static final zzai CREATOR = new zzai();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        String zzaWt;
        DefaultMetadataImpl zzbCN;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("formattedValue", Field.forString("formattedValue", 2));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 3, DefaultMetadataImpl.class));
            zzbCb.put("value", Field.forString("value", 4));
        }

        public RelationshipStatuses() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        RelationshipStatuses(Set<Integer> indicatorSet, int versionCode, String formattedValue, DefaultMetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzaWt = formattedValue;
            this.zzbCN = metadata;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzai com_google_android_gms_people_identity_internal_models_zzai = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof RelationshipStatuses)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            RelationshipStatuses relationshipStatuses = (RelationshipStatuses) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!relationshipStatuses.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(relationshipStatuses.getFieldValue(field))) {
                        return false;
                    }
                } else if (relationshipStatuses.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzaWt;
                case 3:
                    return this.zzbCN;
                case 4:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getFormattedValue() {
            return this.zzaWt;
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzaWt = value;
                    break;
                case 4:
                    this.mValue = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzai com_google_android_gms_people_identity_internal_models_zzai = CREATOR;
            zzai.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public boolean zzHr() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }
    }

    public static final class Skills extends FastJsonResponse implements SafeParcelable {
        public static final zzaj CREATOR = new zzaj();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        DefaultMetadataImpl zzbCN;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("metadata", Field.forConcreteType("metadata", 2, DefaultMetadataImpl.class));
            zzbCb.put("value", Field.forString("value", 3));
        }

        public Skills() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Skills(Set<Integer> indicatorSet, int versionCode, DefaultMetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCN = metadata;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzaj com_google_android_gms_people_identity_internal_models_zzaj = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Skills)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Skills skills = (Skills) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!skills.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(skills.getFieldValue(field))) {
                        return false;
                    }
                } else if (skills.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCN;
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.mValue = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
        }

        public void writeToParcel(Parcel out, int flags) {
            zzaj com_google_android_gms_people_identity_internal_models_zzaj = CREATOR;
            zzaj.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }
    }

    public static final class SortKeys extends FastJsonResponse implements SafeParcelable {
        public static final zzak CREATOR = new zzak();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mName;
        final int mVersionCode;
        final Set<Integer> zzbCc;
        List<Affinities> zzbCd;
        String zzbDM;

        public static final class Affinities extends FastJsonResponse implements SafeParcelable {
            public static final zzal CREATOR = new zzal();
            private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
            final int mVersionCode;
            String zzKj;
            final Set<Integer> zzbCc;
            double zzbCl;

            static {
                zzbCb.put("type", Field.forString("type", 2));
                zzbCb.put("value", Field.forDouble("value", 3));
            }

            public Affinities() {
                this.mVersionCode = 1;
                this.zzbCc = new HashSet();
            }

            Affinities(Set<Integer> indicatorSet, int versionCode, String type, double value) {
                this.zzbCc = indicatorSet;
                this.mVersionCode = versionCode;
                this.zzKj = type;
                this.zzbCl = value;
            }

            public int describeContents() {
                zzal com_google_android_gms_people_identity_internal_models_zzal = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof Affinities)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                Affinities affinities = (Affinities) obj;
                for (Field field : zzbCb.values()) {
                    if (isFieldSet(field)) {
                        if (!affinities.isFieldSet(field)) {
                            return false;
                        }
                        if (!getFieldValue(field).equals(affinities.getFieldValue(field))) {
                            return false;
                        }
                    } else if (affinities.isFieldSet(field)) {
                        return false;
                    }
                }
                return true;
            }

            public HashMap<String, Field<?, ?>> getFieldMappings() {
                return zzbCb;
            }

            protected Object getFieldValue(Field field) {
                switch (field.getSafeParcelableFieldId()) {
                    case 2:
                        return this.zzKj;
                    case 3:
                        return Double.valueOf(this.zzbCl);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
                }
            }

            protected Object getValueObject(String key) {
                return null;
            }

            public int hashCode() {
                int i = 0;
                for (Field field : zzbCb.values()) {
                    int hashCode;
                    if (isFieldSet(field)) {
                        hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            protected boolean isFieldSet(Field field) {
                return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
            }

            protected boolean isPrimitiveFieldSet(String outputField) {
                return false;
            }

            protected void setDoubleInternal(Field<?, ?> field, String outputField, double value) {
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                switch (safeParcelableFieldId) {
                    case 3:
                        this.zzbCl = value;
                        this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                        return;
                    default:
                        throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a double.");
                }
            }

            protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                switch (safeParcelableFieldId) {
                    case 2:
                        this.zzKj = value;
                        this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                        return;
                    default:
                        throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
                }
            }

            public void writeToParcel(Parcel out, int flags) {
                zzal com_google_android_gms_people_identity_internal_models_zzal = CREATOR;
                zzal.zza(this, out, flags);
            }
        }

        static {
            zzbCb.put("affinities", Field.forConcreteTypeArray("affinities", 2, Affinities.class));
            zzbCb.put("interactionRank", Field.forString("interactionRank", 3));
            zzbCb.put(ContactGroupPreferredFields.NAME, Field.forString(ContactGroupPreferredFields.NAME, 4));
        }

        public SortKeys() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        SortKeys(Set<Integer> indicatorSet, int versionCode, List<Affinities> affinities, String interactionRank, String name) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCd = affinities;
            this.zzbDM = interactionRank;
            this.mName = name;
        }

        public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> field, String outputField, ArrayList<T> value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCd = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known array of" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzak com_google_android_gms_people_identity_internal_models_zzak = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SortKeys)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            SortKeys sortKeys = (SortKeys) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!sortKeys.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(sortKeys.getFieldValue(field))) {
                        return false;
                    }
                } else if (sortKeys.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCd;
                case 3:
                    return this.zzbDM;
                case 4:
                    return this.mName;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getName() {
            return this.mName;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasName() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzbDM = value;
                    break;
                case 4:
                    this.mName = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzak com_google_android_gms_people_identity_internal_models_zzak = CREATOR;
            zzak.zza(this, out, flags);
        }

        public String zzIu() {
            return this.zzbDM;
        }

        public boolean zzIv() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }
    }

    public static final class Taglines extends FastJsonResponse implements SafeParcelable {
        public static final zzam CREATOR = new zzam();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        DefaultMetadataImpl zzbCN;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("metadata", Field.forConcreteType("metadata", 2, DefaultMetadataImpl.class));
            zzbCb.put("value", Field.forString("value", 3));
        }

        public Taglines() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Taglines(Set<Integer> indicatorSet, int versionCode, DefaultMetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCN = metadata;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzam com_google_android_gms_people_identity_internal_models_zzam = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Taglines)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Taglines taglines = (Taglines) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!taglines.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(taglines.getFieldValue(field))) {
                        return false;
                    }
                } else if (taglines.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCN;
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.mValue = value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
        }

        public void writeToParcel(Parcel out, int flags) {
            zzam com_google_android_gms_people_identity_internal_models_zzam = CREATOR;
            zzam.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }
    }

    public static final class Urls extends FastJsonResponse implements SafeParcelable {
        public static final zzan CREATOR = new zzan();
        private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
        String mValue;
        final int mVersionCode;
        String zzKj;
        DefaultMetadataImpl zzbCN;
        String zzbCR;
        final Set<Integer> zzbCc;

        static {
            zzbCb.put("formattedType", Field.forString("formattedType", 2));
            zzbCb.put("metadata", Field.forConcreteType("metadata", 3, DefaultMetadataImpl.class));
            zzbCb.put("type", Field.forString("type", 4));
            zzbCb.put("value", Field.forString("value", 5));
        }

        public Urls() {
            this.mVersionCode = 1;
            this.zzbCc = new HashSet();
        }

        Urls(Set<Integer> indicatorSet, int versionCode, String formattedType, DefaultMetadataImpl metadata, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCR = formattedType;
            this.zzbCN = metadata;
            this.zzKj = type;
            this.mValue = value;
        }

        public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 3:
                    this.zzbCN = (DefaultMetadataImpl) value;
                    this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                    return;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
            }
        }

        public int describeContents() {
            zzan com_google_android_gms_people_identity_internal_models_zzan = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Urls)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Urls urls = (Urls) obj;
            for (Field field : zzbCb.values()) {
                if (isFieldSet(field)) {
                    if (!urls.isFieldSet(field)) {
                        return false;
                    }
                    if (!getFieldValue(field).equals(urls.getFieldValue(field))) {
                        return false;
                    }
                } else if (urls.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, Field<?, ?>> getFieldMappings() {
            return zzbCb;
        }

        protected Object getFieldValue(Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.zzbCR;
                case 3:
                    return this.zzbCN;
                case 4:
                    return this.zzKj;
                case 5:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
            }
        }

        public String getType() {
            return this.zzKj;
        }

        public String getValue() {
            return this.mValue;
        }

        protected Object getValueObject(String key) {
            return null;
        }

        public boolean hasType() {
            return this.zzbCc.contains(Integer.valueOf(4));
        }

        public boolean hasValue() {
            return this.zzbCc.contains(Integer.valueOf(5));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzbCb.values()) {
                int hashCode;
                if (isFieldSet(field)) {
                    hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        protected boolean isFieldSet(Field field) {
            return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        protected boolean isPrimitiveFieldSet(String outputField) {
            return false;
        }

        protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.zzbCR = value;
                    break;
                case 4:
                    this.zzKj = value;
                    break;
                case 5:
                    this.mValue = value;
                    break;
                default:
                    throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
            }
            this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
        }

        public void writeToParcel(Parcel out, int flags) {
            zzan com_google_android_gms_people_identity_internal_models_zzan = CREATOR;
            zzan.zza(this, out, flags);
        }

        public boolean zzGR() {
            return this.zzbCc.contains(Integer.valueOf(3));
        }

        public DefaultMetadataImpl zzHf() {
            return this.zzbCN;
        }

        public String zzHj() {
            return this.zzbCR;
        }

        public boolean zzHk() {
            return this.zzbCc.contains(Integer.valueOf(2));
        }
    }

    static {
        zzbCb.put("abouts", Field.forConcreteTypeArray("abouts", 2, Abouts.class));
        zzbCb.put("addresses", Field.forConcreteTypeArray("addresses", 3, Addresses.class));
        zzbCb.put("ageRange", Field.forString("ageRange", 4));
        zzbCb.put("birthdays", Field.forConcreteTypeArray("birthdays", 5, Birthdays.class));
        zzbCb.put("braggingRights", Field.forConcreteTypeArray("braggingRights", 6, BraggingRights.class));
        zzbCb.put("coverPhotos", Field.forConcreteTypeArray("coverPhotos", 7, CoverPhotos.class));
        zzbCb.put("customFields", Field.forConcreteTypeArray("customFields", 8, CustomFields.class));
        zzbCb.put("emails", Field.forConcreteTypeArray("emails", 9, Emails.class));
        zzbCb.put("etag", Field.forString("etag", 10));
        zzbCb.put("events", Field.forConcreteTypeArray("events", 11, Events.class));
        zzbCb.put("genders", Field.forConcreteTypeArray("genders", 12, Genders.class));
        zzbCb.put("id", Field.forString("id", 13));
        zzbCb.put("images", Field.forConcreteTypeArray("images", 14, Images.class));
        zzbCb.put("instantMessaging", Field.forConcreteTypeArray("instantMessaging", 15, InstantMessaging.class));
        zzbCb.put("language", Field.forString("language", 17));
        zzbCb.put("legacyFields", Field.forConcreteType("legacyFields", 18, LegacyFields.class));
        zzbCb.put("linkedPeople", Field.forConcreteTypeArray("linkedPeople", 19, DefaultPersonImpl.class));
        zzbCb.put("memberships", Field.forConcreteTypeArray("memberships", 20, Memberships.class));
        zzbCb.put("metadata", Field.forConcreteType("metadata", 21, Metadata.class));
        zzbCb.put("names", Field.forConcreteTypeArray("names", 22, Names.class));
        zzbCb.put("nicknames", Field.forConcreteTypeArray("nicknames", 23, Nicknames.class));
        zzbCb.put("occupations", Field.forConcreteTypeArray("occupations", 24, Occupations.class));
        zzbCb.put("organizations", Field.forConcreteTypeArray("organizations", 25, Organizations.class));
        zzbCb.put("phoneNumbers", Field.forConcreteTypeArray("phoneNumbers", 26, PhoneNumbers.class));
        zzbCb.put("placesLived", Field.forConcreteTypeArray("placesLived", 27, PlacesLived.class));
        zzbCb.put("profileUrl", Field.forString("profileUrl", 28));
        zzbCb.put("relations", Field.forConcreteTypeArray("relations", 29, Relations.class));
        zzbCb.put("relationshipInterests", Field.forConcreteTypeArray("relationshipInterests", 30, RelationshipInterests.class));
        zzbCb.put("relationshipStatuses", Field.forConcreteTypeArray("relationshipStatuses", 31, RelationshipStatuses.class));
        zzbCb.put("skills", Field.forConcreteTypeArray("skills", 32, Skills.class));
        zzbCb.put("sortKeys", Field.forConcreteType("sortKeys", 33, SortKeys.class));
        zzbCb.put("taglines", Field.forConcreteTypeArray("taglines", 34, Taglines.class));
        zzbCb.put("urls", Field.forConcreteTypeArray("urls", 35, Urls.class));
    }

    public DefaultPersonImpl() {
        this.mVersionCode = 1;
        this.zzbCc = new HashSet();
    }

    DefaultPersonImpl(Set<Integer> indicatorSet, int versionCode, List<Abouts> abouts, List<Addresses> addresses, String ageRange, List<Birthdays> birthdays, List<BraggingRights> braggingRights, List<CoverPhotos> coverPhotos, List<CustomFields> customFields, List<Emails> emails, String etag, List<Events> events, List<Genders> genders, String id, List<Images> images, List<InstantMessaging> instantMessaging, String language, LegacyFields legacyFields, List<DefaultPersonImpl> linkedPeople, List<Memberships> memberships, Metadata metadata, List<Names> names, List<Nicknames> nicknames, List<Occupations> occupations, List<Organizations> organizations, List<PhoneNumbers> phoneNumbers, List<PlacesLived> placesLived, String profileUrl, List<Relations> relations, List<RelationshipInterests> relationshipInterests, List<RelationshipStatuses> relationshipStatuses, List<Skills> skills, SortKeys sortKeys, List<Taglines> taglines, List<Urls> urls) {
        this.zzbCc = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzbCm = abouts;
        this.zzbAh = addresses;
        this.zzbCn = ageRange;
        this.zzbCo = birthdays;
        this.zzbCp = braggingRights;
        this.zzbCq = coverPhotos;
        this.zzbCr = customFields;
        this.zzbAi = emails;
        this.zzbCs = etag;
        this.zzql = events;
        this.zzbCt = genders;
        this.zzyU = id;
        this.zzyw = images;
        this.zzbCu = instantMessaging;
        this.zzajR = language;
        this.zzbCv = legacyFields;
        this.zzbCw = linkedPeople;
        this.zzbCx = memberships;
        this.zzbCy = metadata;
        this.zzbCz = names;
        this.zzbCA = nicknames;
        this.zzbCB = occupations;
        this.zzbCC = organizations;
        this.zzbCD = phoneNumbers;
        this.zzbCE = placesLived;
        this.zzbCF = profileUrl;
        this.zzbCG = relations;
        this.zzbCH = relationshipInterests;
        this.zzbCI = relationshipStatuses;
        this.zzbCJ = skills;
        this.zzbCK = sortKeys;
        this.zzbCL = taglines;
        this.zzbCM = urls;
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> field, String outputField, ArrayList<T> value) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 2:
                this.zzbCm = value;
                break;
            case 3:
                this.zzbAh = value;
                break;
            case 5:
                this.zzbCo = value;
                break;
            case 6:
                this.zzbCp = value;
                break;
            case 7:
                this.zzbCq = value;
                break;
            case 8:
                this.zzbCr = value;
                break;
            case 9:
                this.zzbAi = value;
                break;
            case 11:
                this.zzql = value;
                break;
            case 12:
                this.zzbCt = value;
                break;
            case 14:
                this.zzyw = value;
                break;
            case 15:
                this.zzbCu = value;
                break;
            case 19:
                this.zzbCw = value;
                break;
            case 20:
                this.zzbCx = value;
                break;
            case 22:
                this.zzbCz = value;
                break;
            case 23:
                this.zzbCA = value;
                break;
            case 24:
                this.zzbCB = value;
                break;
            case 25:
                this.zzbCC = value;
                break;
            case LogSource.ANDROID_CAMERA /*26*/:
                this.zzbCD = value;
                break;
            case LogSource.CW /*27*/:
                this.zzbCE = value;
                break;
            case LogSource.DNA_PROBER /*29*/:
                this.zzbCG = value;
                break;
            case LogSource.UDR /*30*/:
                this.zzbCH = value;
                break;
            case LogSource.GMS_CORE_WALLET /*31*/:
                this.zzbCI = value;
                break;
            case 32:
                this.zzbCJ = value;
                break;
            case 34:
                this.zzbCL = value;
                break;
            case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                this.zzbCM = value;
                break;
            default:
                throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known array of" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
        }
        this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 18:
                this.zzbCv = (LegacyFields) value;
                break;
            case 21:
                this.zzbCy = (Metadata) value;
                break;
            case 33:
                this.zzbCK = (SortKeys) value;
                break;
            default:
                throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
        }
        this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
    }

    public int describeContents() {
        zzj com_google_android_gms_people_identity_internal_models_zzj = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultPersonImpl)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        DefaultPersonImpl defaultPersonImpl = (DefaultPersonImpl) obj;
        for (Field field : zzbCb.values()) {
            if (isFieldSet(field)) {
                if (!defaultPersonImpl.isFieldSet(field)) {
                    return false;
                }
                if (!getFieldValue(field).equals(defaultPersonImpl.getFieldValue(field))) {
                    return false;
                }
            } else if (defaultPersonImpl.isFieldSet(field)) {
                return false;
            }
        }
        return true;
    }

    public List<Abouts> getAbouts() {
        return this.zzbCm;
    }

    public List<Addresses> getAddresses() {
        return this.zzbAh;
    }

    public List<Birthdays> getBirthdays() {
        return this.zzbCo;
    }

    public List<BraggingRights> getBraggingRights() {
        return this.zzbCp;
    }

    public List<CoverPhotos> getCoverPhotos() {
        return this.zzbCq;
    }

    public List<CustomFields> getCustomFields() {
        return this.zzbCr;
    }

    public List<Emails> getEmails() {
        return this.zzbAi;
    }

    public String getEtag() {
        return this.zzbCs;
    }

    public List<Events> getEvents() {
        return this.zzql;
    }

    public HashMap<String, Field<?, ?>> getFieldMappings() {
        return zzbCb;
    }

    protected Object getFieldValue(Field field) {
        switch (field.getSafeParcelableFieldId()) {
            case 2:
                return this.zzbCm;
            case 3:
                return this.zzbAh;
            case 4:
                return this.zzbCn;
            case 5:
                return this.zzbCo;
            case 6:
                return this.zzbCp;
            case 7:
                return this.zzbCq;
            case 8:
                return this.zzbCr;
            case 9:
                return this.zzbAi;
            case 10:
                return this.zzbCs;
            case 11:
                return this.zzql;
            case 12:
                return this.zzbCt;
            case 13:
                return this.zzyU;
            case 14:
                return this.zzyw;
            case 15:
                return this.zzbCu;
            case 17:
                return this.zzajR;
            case 18:
                return this.zzbCv;
            case 19:
                return this.zzbCw;
            case 20:
                return this.zzbCx;
            case 21:
                return this.zzbCy;
            case 22:
                return this.zzbCz;
            case 23:
                return this.zzbCA;
            case 24:
                return this.zzbCB;
            case 25:
                return this.zzbCC;
            case LogSource.ANDROID_CAMERA /*26*/:
                return this.zzbCD;
            case LogSource.CW /*27*/:
                return this.zzbCE;
            case LogSource.GEL /*28*/:
                return this.zzbCF;
            case LogSource.DNA_PROBER /*29*/:
                return this.zzbCG;
            case LogSource.UDR /*30*/:
                return this.zzbCH;
            case LogSource.GMS_CORE_WALLET /*31*/:
                return this.zzbCI;
            case 32:
                return this.zzbCJ;
            case 33:
                return this.zzbCK;
            case 34:
                return this.zzbCL;
            case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                return this.zzbCM;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
        }
    }

    public List<Genders> getGenders() {
        return this.zzbCt;
    }

    public String getId() {
        return this.zzyU;
    }

    public List<Images> getImages() {
        return this.zzyw;
    }

    public List<InstantMessaging> getInstantMessaging() {
        return this.zzbCu;
    }

    public String getLanguage() {
        return this.zzajR;
    }

    public List<DefaultPersonImpl> getLinkedPeople() {
        return this.zzbCw;
    }

    public List<Memberships> getMemberships() {
        return this.zzbCx;
    }

    public List<Names> getNames() {
        return this.zzbCz;
    }

    public List<Nicknames> getNicknames() {
        return this.zzbCA;
    }

    public List<Occupations> getOccupations() {
        return this.zzbCB;
    }

    public List<Organizations> getOrganizations() {
        return this.zzbCC;
    }

    public List<PhoneNumbers> getPhoneNumbers() {
        return this.zzbCD;
    }

    public List<PlacesLived> getPlacesLived() {
        return this.zzbCE;
    }

    public List<Relations> getRelations() {
        return this.zzbCG;
    }

    public List<RelationshipInterests> getRelationshipInterests() {
        return this.zzbCH;
    }

    public List<RelationshipStatuses> getRelationshipStatuses() {
        return this.zzbCI;
    }

    public List<Skills> getSkills() {
        return this.zzbCJ;
    }

    public List<Taglines> getTaglines() {
        return this.zzbCL;
    }

    public List<Urls> getUrls() {
        return this.zzbCM;
    }

    protected Object getValueObject(String key) {
        return null;
    }

    public boolean hasAgeRange() {
        return this.zzbCc.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.zzbCc.contains(Integer.valueOf(6));
    }

    public boolean hasId() {
        return this.zzbCc.contains(Integer.valueOf(13));
    }

    public boolean hasImages() {
        return this.zzbCc.contains(Integer.valueOf(14));
    }

    public boolean hasLanguage() {
        return this.zzbCc.contains(Integer.valueOf(17));
    }

    public boolean hasOrganizations() {
        return this.zzbCc.contains(Integer.valueOf(25));
    }

    public boolean hasPlacesLived() {
        return this.zzbCc.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.zzbCc.contains(Integer.valueOf(35));
    }

    public int hashCode() {
        int i = 0;
        for (Field field : zzbCb.values()) {
            int hashCode;
            if (isFieldSet(field)) {
                hashCode = getFieldValue(field).hashCode() + (i + field.getSafeParcelableFieldId());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    protected boolean isFieldSet(Field field) {
        return this.zzbCc.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    protected boolean isPrimitiveFieldSet(String outputField) {
        return false;
    }

    protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 4:
                this.zzbCn = value;
                break;
            case 10:
                this.zzbCs = value;
                break;
            case 13:
                this.zzyU = value;
                break;
            case 17:
                this.zzajR = value;
                break;
            case LogSource.GEL /*28*/:
                this.zzbCF = value;
                break;
            default:
                throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
        }
        this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
    }

    public void writeToParcel(Parcel out, int flags) {
        zzj com_google_android_gms_people_identity_internal_models_zzj = CREATOR;
        zzj.zza(this, out, flags);
    }

    public boolean zzGB() {
        return this.zzbCc.contains(Integer.valueOf(2));
    }

    public boolean zzGC() {
        return this.zzbCc.contains(Integer.valueOf(3));
    }

    public String zzGD() {
        return this.zzbCn;
    }

    public boolean zzGE() {
        return this.zzbCc.contains(Integer.valueOf(5));
    }

    public boolean zzGF() {
        return this.zzbCc.contains(Integer.valueOf(7));
    }

    public boolean zzGG() {
        return this.zzbCc.contains(Integer.valueOf(8));
    }

    public boolean zzGH() {
        return this.zzbCc.contains(Integer.valueOf(9));
    }

    public boolean zzGI() {
        return this.zzbCc.contains(Integer.valueOf(10));
    }

    public boolean zzGJ() {
        return this.zzbCc.contains(Integer.valueOf(11));
    }

    public boolean zzGK() {
        return this.zzbCc.contains(Integer.valueOf(12));
    }

    public boolean zzGL() {
        return this.zzbCc.contains(Integer.valueOf(15));
    }

    public LegacyFields zzGM() {
        return this.zzbCv;
    }

    public boolean zzGN() {
        return this.zzbCc.contains(Integer.valueOf(18));
    }

    public boolean zzGO() {
        return this.zzbCc.contains(Integer.valueOf(19));
    }

    public boolean zzGP() {
        return this.zzbCc.contains(Integer.valueOf(20));
    }

    public Metadata zzGQ() {
        return this.zzbCy;
    }

    public boolean zzGR() {
        return this.zzbCc.contains(Integer.valueOf(21));
    }

    public boolean zzGS() {
        return this.zzbCc.contains(Integer.valueOf(22));
    }

    public boolean zzGT() {
        return this.zzbCc.contains(Integer.valueOf(23));
    }

    public boolean zzGU() {
        return this.zzbCc.contains(Integer.valueOf(24));
    }

    public boolean zzGV() {
        return this.zzbCc.contains(Integer.valueOf(26));
    }

    public String zzGW() {
        return this.zzbCF;
    }

    public boolean zzGX() {
        return this.zzbCc.contains(Integer.valueOf(28));
    }

    public boolean zzGY() {
        return this.zzbCc.contains(Integer.valueOf(29));
    }

    public boolean zzGZ() {
        return this.zzbCc.contains(Integer.valueOf(30));
    }

    public boolean zzHa() {
        return this.zzbCc.contains(Integer.valueOf(31));
    }

    public boolean zzHb() {
        return this.zzbCc.contains(Integer.valueOf(32));
    }

    public SortKeys zzHc() {
        return this.zzbCK;
    }

    public boolean zzHd() {
        return this.zzbCc.contains(Integer.valueOf(33));
    }

    public boolean zzHe() {
        return this.zzbCc.contains(Integer.valueOf(34));
    }
}

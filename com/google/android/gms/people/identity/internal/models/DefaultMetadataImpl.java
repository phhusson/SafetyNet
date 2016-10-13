package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DefaultMetadataImpl extends FastJsonResponse implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
    final int mVersionCode;
    boolean zzbAo;
    final Set<Integer> zzbCc;
    List<Affinities> zzbCd;
    String zzbCe;
    String zzbCf;
    String zzbCg;
    boolean zzbCh;
    boolean zzbCi;
    String zzbCj;
    boolean zzbCk;

    public static final class Affinities extends FastJsonResponse implements SafeParcelable {
        public static final zzh CREATOR = new zzh();
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
            zzh com_google_android_gms_people_identity_internal_models_zzh = CREATOR;
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
            zzh com_google_android_gms_people_identity_internal_models_zzh = CREATOR;
            zzh.zza(this, out, flags);
        }
    }

    static {
        zzbCb.put("affinities", Field.forConcreteTypeArray("affinities", 2, Affinities.class));
        zzbCb.put("container", Field.forString("container", 3));
        zzbCb.put("containerContactId", Field.forString("containerContactId", 4));
        zzbCb.put("containerId", Field.forString("containerId", 5));
        zzbCb.put("edgeKey", Field.forBoolean("edgeKey", 6));
        zzbCb.put("primary", Field.forBoolean("primary", 7));
        zzbCb.put("verified", Field.forBoolean("verified", 8));
        zzbCb.put("visibility", Field.forString("visibility", 9));
        zzbCb.put("writeable", Field.forBoolean("writeable", 10));
    }

    public DefaultMetadataImpl() {
        this.mVersionCode = 1;
        this.zzbCc = new HashSet();
    }

    DefaultMetadataImpl(Set<Integer> indicatorSet, int versionCode, List<Affinities> affinities, String container, String containerContactId, String containerId, boolean edgeKey, boolean primary, boolean verified, String visibility, boolean writeable) {
        this.zzbCc = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzbCd = affinities;
        this.zzbCe = container;
        this.zzbCf = containerContactId;
        this.zzbCg = containerId;
        this.zzbCh = edgeKey;
        this.zzbAo = primary;
        this.zzbCi = verified;
        this.zzbCj = visibility;
        this.zzbCk = writeable;
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
        zzg com_google_android_gms_people_identity_internal_models_zzg = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultMetadataImpl)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        DefaultMetadataImpl defaultMetadataImpl = (DefaultMetadataImpl) obj;
        for (Field field : zzbCb.values()) {
            if (isFieldSet(field)) {
                if (!defaultMetadataImpl.isFieldSet(field)) {
                    return false;
                }
                if (!getFieldValue(field).equals(defaultMetadataImpl.getFieldValue(field))) {
                    return false;
                }
            } else if (defaultMetadataImpl.isFieldSet(field)) {
                return false;
            }
        }
        return true;
    }

    public String getContainerId() {
        return this.zzbCg;
    }

    public HashMap<String, Field<?, ?>> getFieldMappings() {
        return zzbCb;
    }

    protected Object getFieldValue(Field field) {
        switch (field.getSafeParcelableFieldId()) {
            case 2:
                return this.zzbCd;
            case 3:
                return this.zzbCe;
            case 4:
                return this.zzbCf;
            case 5:
                return this.zzbCg;
            case 6:
                return Boolean.valueOf(this.zzbCh);
            case 7:
                return Boolean.valueOf(this.zzbAo);
            case 8:
                return Boolean.valueOf(this.zzbCi);
            case 9:
                return this.zzbCj;
            case 10:
                return Boolean.valueOf(this.zzbCk);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.getSafeParcelableFieldId());
        }
    }

    protected Object getValueObject(String key) {
        return null;
    }

    public boolean hasPrimary() {
        return this.zzbCc.contains(Integer.valueOf(7));
    }

    public boolean hasVerified() {
        return this.zzbCc.contains(Integer.valueOf(8));
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

    public boolean isPrimary() {
        return this.zzbAo;
    }

    protected boolean isPrimitiveFieldSet(String outputField) {
        return false;
    }

    public boolean isVerified() {
        return this.zzbCi;
    }

    protected void setBooleanInternal(Field<?, ?> field, String outputField, boolean value) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 6:
                this.zzbCh = value;
                break;
            case 7:
                this.zzbAo = value;
                break;
            case 8:
                this.zzbCi = value;
                break;
            case 10:
                this.zzbCk = value;
                break;
            default:
                throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a boolean.");
        }
        this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
    }

    protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 3:
                this.zzbCe = value;
                break;
            case 4:
                this.zzbCf = value;
                break;
            case 5:
                this.zzbCg = value;
                break;
            case 9:
                this.zzbCj = value;
                break;
            default:
                throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not known to be a String.");
        }
        this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg com_google_android_gms_people_identity_internal_models_zzg = CREATOR;
        zzg.zza(this, out, flags);
    }

    public boolean zzGA() {
        return this.zzbCc.contains(Integer.valueOf(10));
    }

    public String zzGq() {
        return this.zzbCe;
    }

    public boolean zzGr() {
        return this.zzbCc.contains(Integer.valueOf(3));
    }

    public String zzGs() {
        return this.zzbCf;
    }

    public boolean zzGt() {
        return this.zzbCc.contains(Integer.valueOf(4));
    }

    public boolean zzGu() {
        return this.zzbCc.contains(Integer.valueOf(5));
    }

    public boolean zzGv() {
        return this.zzbCh;
    }

    public boolean zzGw() {
        return this.zzbCc.contains(Integer.valueOf(6));
    }

    public String zzGx() {
        return this.zzbCj;
    }

    public boolean zzGy() {
        return this.zzbCc.contains(Integer.valueOf(9));
    }

    public boolean zzGz() {
        return this.zzbCk;
    }
}

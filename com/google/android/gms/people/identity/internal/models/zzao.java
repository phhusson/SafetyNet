package com.google.android.gms.people.identity.internal.models;

import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class zzao extends FastJsonResponse {
    private static final HashMap<String, Field<?, ?>> zzbCb = new HashMap();
    List<DefaultPersonImpl> zzakD;
    final Set<Integer> zzbCc = new HashSet();

    static {
        zzbCb.put("items", Field.forConcreteTypeArray("items", 2, DefaultPersonImpl.class));
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> field, String outputField, ArrayList<T> value) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 2:
                this.zzakD = value;
                this.zzbCc.add(Integer.valueOf(safeParcelableFieldId));
                return;
            default:
                throw new IllegalArgumentException("Field with id=" + safeParcelableFieldId + " is not a known array of" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
        }
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
        throw new IllegalArgumentException("Field with id=" + field.getSafeParcelableFieldId() + " is not a known" + " custom type.  Found " + value.getClass().getCanonicalName() + ".");
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

    public HashMap<String, Field<?, ?>> getFieldMappings() {
        return zzbCb;
    }

    protected Object getFieldValue(Field field) {
        switch (field.getSafeParcelableFieldId()) {
            case 2:
                return this.zzakD;
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
        throw new IllegalArgumentException("Field with id=" + field.getSafeParcelableFieldId() + " is not known to be a String.");
    }

    public boolean zzIw() {
        return this.zzbCc.contains(Integer.valueOf(2));
    }

    public List<DefaultPersonImpl> zznY() {
        return this.zzakD;
    }
}

package com.google.android.gms.common.server.response;

import android.content.ContentValues;

public abstract class FastContentValuesJsonResponse extends FastJsonResponse {
    private final ContentValues zzaxB;

    public FastContentValuesJsonResponse() {
        this.zzaxB = new ContentValues();
    }

    public FastContentValuesJsonResponse(ContentValues values) {
        this.zzaxB = values;
    }

    protected Object getValueObject(String key) {
        return this.zzaxB.get(key);
    }

    public ContentValues getValues() {
        return this.zzaxB;
    }

    protected boolean isPrimitiveFieldSet(String field) {
        return this.zzaxB.containsKey(field);
    }

    protected void setBoolean(String outputField, boolean value) {
        this.zzaxB.put(outputField, Boolean.valueOf(value));
    }

    protected void setDecodedBytes(String outputField, byte[] value) {
        this.zzaxB.put(outputField, value);
    }

    protected void setDouble(String outputField, double value) {
        this.zzaxB.put(outputField, Double.valueOf(value));
    }

    protected void setFloat(String outputField, float value) {
        this.zzaxB.put(outputField, Float.valueOf(value));
    }

    protected void setInteger(String outputField, int value) {
        this.zzaxB.put(outputField, Integer.valueOf(value));
    }

    protected void setLong(String outputField, long value) {
        this.zzaxB.put(outputField, Long.valueOf(value));
    }

    protected void setString(String outputField, String value) {
        this.zzaxB.put(outputField, value);
    }
}

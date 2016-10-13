package com.google.android.gms.common.server.response;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastMapJsonResponse extends FastJsonResponse {
    private final HashMap<String, Object> zzaxG = new HashMap();

    public Object getValueObject(String key) {
        return this.zzaxG.get(key);
    }

    public HashMap<String, Object> getValues() {
        return this.zzaxG;
    }

    protected boolean isPrimitiveFieldSet(String key) {
        return this.zzaxG.containsKey(key);
    }

    public void setBigDecimal(String outputField, BigDecimal value) {
        this.zzaxG.put(outputField, value);
    }

    public void setBigDecimals(String outputField, ArrayList<BigDecimal> values) {
        this.zzaxG.put(outputField, values);
    }

    public void setBigInteger(String outputField, BigInteger value) {
        this.zzaxG.put(outputField, value);
    }

    public void setBigIntegers(String outputField, ArrayList<BigInteger> values) {
        this.zzaxG.put(outputField, values);
    }

    public void setBoolean(String outputField, boolean value) {
        this.zzaxG.put(outputField, Boolean.valueOf(value));
    }

    public void setBooleans(String outputField, ArrayList<Boolean> values) {
        this.zzaxG.put(outputField, values);
    }

    public void setDecodedBytes(String outputField, byte[] value) {
        this.zzaxG.put(outputField, value);
    }

    public void setDouble(String outputField, double value) {
        this.zzaxG.put(outputField, Double.valueOf(value));
    }

    public void setDoubles(String outputField, ArrayList<Double> values) {
        this.zzaxG.put(outputField, values);
    }

    protected void setFloat(String outputField, float value) {
        this.zzaxG.put(outputField, Float.valueOf(value));
    }

    protected void setFloats(String outputField, ArrayList<Float> values) {
        this.zzaxG.put(outputField, values);
    }

    public void setInteger(String outputField, int value) {
        this.zzaxG.put(outputField, Integer.valueOf(value));
    }

    public void setIntegers(String outputField, ArrayList<Integer> values) {
        this.zzaxG.put(outputField, values);
    }

    public void setLong(String outputField, long value) {
        this.zzaxG.put(outputField, Long.valueOf(value));
    }

    public void setLongs(String outputField, ArrayList<Long> values) {
        this.zzaxG.put(outputField, values);
    }

    public void setString(String outputField, String value) {
        this.zzaxG.put(outputField, value);
    }

    public void setStringMap(String outputField, Map<String, String> value) {
        this.zzaxG.put(outputField, value);
    }

    public void setStrings(String outputField, ArrayList<String> values) {
        this.zzaxG.put(outputField, values);
    }
}

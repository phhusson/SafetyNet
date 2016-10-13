package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastParser.ParseException;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzn;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.people.PeopleConstants.Endpoints;
import com.google.android.snet.Csv;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public abstract class FastJsonResponse {
    protected static final String QUOTE = "\"";
    private byte[] zzaxC;
    private boolean zzaxD;
    private int zzzV;

    public interface FieldConverter<I, O> {
        O convert(I i);

        I convertBack(O o);

        int getTypeIn();

        int getTypeOut();
    }

    public static class Field<I, O> implements SafeParcelable {
        public static final FieldCreator CREATOR = new FieldCreator();
        protected final Class<? extends FastJsonResponse> mConcreteType;
        protected final String mConcreteTypeName;
        protected final String mOutputFieldName;
        protected final int mSafeParcelableFieldId;
        protected final int mTypeIn;
        protected final boolean mTypeInArray;
        protected final int mTypeOut;
        protected final boolean mTypeOutArray;
        private final int mVersionCode;
        private FieldMappingDictionary zzaxE;
        private FieldConverter<I, O> zzaxF;

        Field(int versionCode, int typeIn, boolean typeInArray, int typeOut, boolean typeOutArray, String outputFieldName, int safeParcelableFieldId, String concreteTypeName, ConverterWrapper wrappedConverter) {
            this.mVersionCode = versionCode;
            this.mTypeIn = typeIn;
            this.mTypeInArray = typeInArray;
            this.mTypeOut = typeOut;
            this.mTypeOutArray = typeOutArray;
            this.mOutputFieldName = outputFieldName;
            this.mSafeParcelableFieldId = safeParcelableFieldId;
            if (concreteTypeName == null) {
                this.mConcreteType = null;
                this.mConcreteTypeName = null;
            } else {
                this.mConcreteType = SafeParcelResponse.class;
                this.mConcreteTypeName = concreteTypeName;
            }
            if (wrappedConverter == null) {
                this.zzaxF = null;
            } else {
                this.zzaxF = wrappedConverter.zzrC();
            }
        }

        protected Field(int typeIn, boolean typeInArray, int typeOut, boolean typeOutArray, String outputFieldName, int safeParcelableFieldId, Class<? extends FastJsonResponse> concreteType, FieldConverter<I, O> converter) {
            this.mVersionCode = 1;
            this.mTypeIn = typeIn;
            this.mTypeInArray = typeInArray;
            this.mTypeOut = typeOut;
            this.mTypeOutArray = typeOutArray;
            this.mOutputFieldName = outputFieldName;
            this.mSafeParcelableFieldId = safeParcelableFieldId;
            this.mConcreteType = concreteType;
            if (concreteType == null) {
                this.mConcreteTypeName = null;
            } else {
                this.mConcreteTypeName = concreteType.getCanonicalName();
            }
            this.zzaxF = converter;
        }

        public static Field<byte[], byte[]> forBase64(String outputFieldName) {
            return new Field(8, false, 8, false, outputFieldName, -1, null, null);
        }

        public static Field<byte[], byte[]> forBase64(String outputFieldName, int safeParcelableId) {
            return new Field(8, false, 8, false, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<byte[], byte[]> forBase64UrlSafe(String outputFieldName) {
            return new Field(9, false, 9, false, outputFieldName, -1, null, null);
        }

        public static Field<byte[], byte[]> forBase64UrlSafe(String outputFieldName, int safeParcelableId) {
            return new Field(9, false, 9, false, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<BigDecimal, BigDecimal> forBigDecimal(String outputFieldName) {
            return new Field(5, false, 5, false, outputFieldName, -1, null, null);
        }

        public static Field<BigDecimal, BigDecimal> forBigDecimal(String outputFieldName, int safeParcelableId) {
            return new Field(5, false, 5, false, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<ArrayList<BigDecimal>, ArrayList<BigDecimal>> forBigDecimals(String outputFieldName) {
            return new Field(5, true, 5, true, outputFieldName, -1, null, null);
        }

        public static Field<ArrayList<BigDecimal>, ArrayList<BigDecimal>> forBigDecimals(String outputFieldName, int safeParcelableId) {
            return new Field(5, true, 5, true, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<BigInteger, BigInteger> forBigInteger(String outputFieldName) {
            return new Field(1, false, 1, false, outputFieldName, -1, null, null);
        }

        public static Field<BigInteger, BigInteger> forBigInteger(String outputFieldName, int safeParcelableId) {
            return new Field(1, false, 1, false, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<ArrayList<BigInteger>, ArrayList<BigInteger>> forBigIntegers(String outputFieldName) {
            return new Field(0, true, 1, true, outputFieldName, -1, null, null);
        }

        public static Field<ArrayList<BigInteger>, ArrayList<BigInteger>> forBigIntegers(String outputFieldName, int safeParcelableId) {
            return new Field(0, true, 1, true, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<Boolean, Boolean> forBoolean(String outputFieldName) {
            return new Field(6, false, 6, false, outputFieldName, -1, null, null);
        }

        public static Field<Boolean, Boolean> forBoolean(String outputFieldName, int safeParcelableId) {
            return new Field(6, false, 6, false, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<ArrayList<Boolean>, ArrayList<Boolean>> forBooleans(String outputFieldName) {
            return new Field(6, true, 6, true, outputFieldName, -1, null, null);
        }

        public static Field<ArrayList<Boolean>, ArrayList<Boolean>> forBooleans(String outputFieldName, int safeParcelableId) {
            return new Field(6, true, 6, true, outputFieldName, safeParcelableId, null, null);
        }

        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String fieldName, int safeParcelableId, Class<T> type) {
            return new Field(11, false, 11, false, fieldName, safeParcelableId, type, null);
        }

        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String fieldName, Class<T> type) {
            return new Field(11, false, 11, false, fieldName, -1, type, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String fieldName, int safeParcelableId, Class<T> type) {
            return new Field(11, true, 11, true, fieldName, safeParcelableId, type, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String fieldName, Class<T> type) {
            return new Field(11, true, 11, true, fieldName, -1, type, null);
        }

        public static Field<Double, Double> forDouble(String outputFieldName) {
            return new Field(4, false, 4, false, outputFieldName, -1, null, null);
        }

        public static Field<Double, Double> forDouble(String outputFieldName, int safeParcelableId) {
            return new Field(4, false, 4, false, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<ArrayList<Double>, ArrayList<Double>> forDoubles(String outputFieldName) {
            return new Field(4, true, 4, true, outputFieldName, -1, null, null);
        }

        public static Field<ArrayList<Double>, ArrayList<Double>> forDoubles(String outputFieldName, int safeParcelableId) {
            return new Field(4, true, 4, true, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<Float, Float> forFloat(String outputFieldName) {
            return new Field(3, false, 3, false, outputFieldName, -1, null, null);
        }

        public static Field<Float, Float> forFloat(String outputFieldName, int safeParcelableId) {
            return new Field(3, false, 3, false, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<ArrayList<Float>, ArrayList<Float>> forFloats(String outputFieldName) {
            return new Field(3, true, 3, true, outputFieldName, -1, null, null);
        }

        public static Field<ArrayList<Float>, ArrayList<Float>> forFloats(String outputFieldName, int safeParcelableId) {
            return new Field(3, true, 3, true, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<Integer, Integer> forInteger(String outputFieldName) {
            return new Field(0, false, 0, false, outputFieldName, -1, null, null);
        }

        public static Field<Integer, Integer> forInteger(String outputFieldName, int safeParcelableId) {
            return new Field(0, false, 0, false, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<ArrayList<Integer>, ArrayList<Integer>> forIntegers(String outputFieldName) {
            return new Field(0, true, 0, true, outputFieldName, -1, null, null);
        }

        public static Field<ArrayList<Integer>, ArrayList<Integer>> forIntegers(String outputFieldName, int safeParcelableId) {
            return new Field(0, true, 0, true, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<Long, Long> forLong(String outputFieldName) {
            return new Field(2, false, 2, false, outputFieldName, -1, null, null);
        }

        public static Field<Long, Long> forLong(String outputFieldName, int safeParcelableId) {
            return new Field(2, false, 2, false, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<ArrayList<Long>, ArrayList<Long>> forLongs(String outputFieldName) {
            return new Field(2, true, 2, true, outputFieldName, -1, null, null);
        }

        public static Field<ArrayList<Long>, ArrayList<Long>> forLongs(String outputFieldName, int safeParcelableId) {
            return new Field(2, true, 2, true, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<String, String> forString(String outputFieldName) {
            return new Field(7, false, 7, false, outputFieldName, -1, null, null);
        }

        public static Field<String, String> forString(String outputFieldName, int safeParcelableId) {
            return new Field(7, false, 7, false, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String outputFieldName) {
            return new Field(10, false, 10, false, outputFieldName, -1, null, null);
        }

        public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String outputFieldName, int safeParcelableId) {
            return new Field(10, false, 10, false, outputFieldName, safeParcelableId, null, null);
        }

        public static Field<ArrayList<String>, ArrayList<String>> forStrings(String outputFieldName) {
            return new Field(7, true, 7, true, outputFieldName, -1, null, null);
        }

        public static Field<ArrayList<String>, ArrayList<String>> forStrings(String outputFieldName, int safeParcelableId) {
            return new Field(7, true, 7, true, outputFieldName, safeParcelableId, null, null);
        }

        public static Field withConverter(String outputFieldName, int safeParcelableId, FieldConverter<?, ?> converter, boolean inputArrayType) {
            return new Field(converter.getTypeIn(), inputArrayType, converter.getTypeOut(), false, outputFieldName, safeParcelableId, null, converter);
        }

        public static <T extends FieldConverter> Field withConverter(String outputFieldName, int safeParcelableId, Class<T> converterClass, boolean inputArrayType) {
            try {
                return withConverter(outputFieldName, safeParcelableId, (FieldConverter) converterClass.newInstance(), inputArrayType);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            }
        }

        public static Field withConverter(String outputFieldName, FieldConverter<?, ?> converter, boolean inputArrayType) {
            return withConverter(outputFieldName, -1, (FieldConverter) converter, inputArrayType);
        }

        public static <T extends FieldConverter> Field withConverter(String outputFieldName, Class<T> converterClass, boolean inputArrayType) {
            return withConverter(outputFieldName, -1, (Class) converterClass, inputArrayType);
        }

        public O convert(I input) {
            return this.zzaxF.convert(input);
        }

        public I convertBack(O output) {
            return this.zzaxF.convertBack(output);
        }

        public Field<I, O> copyForDictionary() {
            return new Field(this.mVersionCode, this.mTypeIn, this.mTypeInArray, this.mTypeOut, this.mTypeOutArray, this.mOutputFieldName, this.mSafeParcelableFieldId, this.mConcreteTypeName, zzrG());
        }

        public int describeContents() {
            FieldCreator fieldCreator = CREATOR;
            return 0;
        }

        public Class<? extends FastJsonResponse> getConcreteType() {
            return this.mConcreteType;
        }

        public Map<String, Field<?, ?>> getConcreteTypeFieldMappingFromDictionary() {
            zzx.zzD(this.mConcreteTypeName);
            zzx.zzD(this.zzaxE);
            return this.zzaxE.getFieldMapping(this.mConcreteTypeName);
        }

        public String getOutputFieldName() {
            return this.mOutputFieldName;
        }

        public int getSafeParcelableFieldId() {
            return this.mSafeParcelableFieldId;
        }

        public int getTypeIn() {
            return this.mTypeIn;
        }

        public int getTypeOut() {
            return this.mTypeOut;
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public boolean hasConverter() {
            return this.zzaxF != null;
        }

        public boolean isTypeInArray() {
            return this.mTypeInArray;
        }

        public boolean isTypeOutArray() {
            return this.mTypeOutArray;
        }

        public boolean isValidSafeParcelableFieldId() {
            return this.mSafeParcelableFieldId != -1;
        }

        public FastJsonResponse newConcreteTypeInstance() throws InstantiationException, IllegalAccessException {
            if (this.mConcreteType != SafeParcelResponse.class) {
                return (FastJsonResponse) this.mConcreteType.newInstance();
            }
            zzx.zzb(this.zzaxE, (Object) "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
            return new SafeParcelResponse(this.zzaxE, this.mConcreteTypeName);
        }

        public void setFieldMappingDictionary(FieldMappingDictionary dictionary) {
            this.zzaxE = dictionary;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.mVersionCode).append('\n');
            stringBuilder.append("                 typeIn=").append(this.mTypeIn).append('\n');
            stringBuilder.append("            typeInArray=").append(this.mTypeInArray).append('\n');
            stringBuilder.append("                typeOut=").append(this.mTypeOut).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.mTypeOutArray).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.mOutputFieldName).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.mSafeParcelableFieldId).append('\n');
            stringBuilder.append("       concreteTypeName=").append(zzrF()).append('\n');
            if (getConcreteType() != null) {
                stringBuilder.append("     concreteType.class=").append(getConcreteType().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.zzaxF == null ? "null" : this.zzaxF.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            FieldCreator fieldCreator = CREATOR;
            FieldCreator.zza(this, out, flags);
        }

        String zzrF() {
            return this.mConcreteTypeName == null ? null : this.mConcreteTypeName;
        }

        ConverterWrapper zzrG() {
            return this.zzaxF == null ? null : ConverterWrapper.zza(this.zzaxF);
        }
    }

    public static InputStream getUnzippedStream(byte[] data) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(data);
        if (IOUtils.isGzipByteBuffer(data)) {
            try {
                return new GZIPInputStream(byteArrayInputStream);
            } catch (IOException e) {
            }
        }
        return byteArrayInputStream;
    }

    private <I, O> void zza(Field<I, O> field, I i) {
        String outputFieldName = field.getOutputFieldName();
        Object convert = field.convert(i);
        switch (field.getTypeOut()) {
            case 0:
                if (zzj(outputFieldName, convert)) {
                    setIntegerInternal(field, outputFieldName, ((Integer) convert).intValue());
                    return;
                }
                return;
            case 1:
                setBigIntegerInternal(field, outputFieldName, (BigInteger) convert);
                return;
            case 2:
                if (zzj(outputFieldName, convert)) {
                    setLongInternal(field, outputFieldName, ((Long) convert).longValue());
                    return;
                }
                return;
            case 4:
                if (zzj(outputFieldName, convert)) {
                    setDoubleInternal(field, outputFieldName, ((Double) convert).doubleValue());
                    return;
                }
                return;
            case 5:
                setBigDecimalInternal(field, outputFieldName, (BigDecimal) convert);
                return;
            case 6:
                if (zzj(outputFieldName, convert)) {
                    setBooleanInternal(field, outputFieldName, ((Boolean) convert).booleanValue());
                    return;
                }
                return;
            case 7:
                setStringInternal(field, outputFieldName, (String) convert);
                return;
            case 8:
            case 9:
                if (zzj(outputFieldName, convert)) {
                    setDecodedBytesInternal(field, outputFieldName, (byte[]) convert);
                    return;
                }
                return;
            default:
                throw new IllegalStateException("Unsupported type for conversion: " + field.getTypeOut());
        }
    }

    private void zza(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.getTypeIn() == 11) {
            stringBuilder.append(((FastJsonResponse) field.getConcreteType().cast(obj)).toString());
        } else if (field.getTypeIn() == 7) {
            stringBuilder.append(QUOTE);
            stringBuilder.append(zzn.zzcR((String) obj));
            stringBuilder.append(QUOTE);
        } else {
            stringBuilder.append(obj);
        }
    }

    private void zza(StringBuilder stringBuilder, Field field, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(Csv.COMMA);
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(stringBuilder, field, obj);
            }
        }
        stringBuilder.append("]");
    }

    private <O> boolean zzj(String str, O o) {
        if (o != null) {
            return true;
        }
        if (Log.isLoggable("FastJsonResponse", 6)) {
            Log.e("FastJsonResponse", "Output field (" + str + ") has a null value," + " but expected a primitive");
        }
        return false;
    }

    public <T extends FastJsonResponse> void addConcreteType(String field, T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    public <T extends FastJsonResponse> void addConcreteTypeArray(String field, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> field, String outputField, ArrayList<T> values) {
        addConcreteTypeArray(outputField, values);
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
        addConcreteType(outputField, value);
    }

    public HashMap<String, Object> getConcreteTypeArrays() {
        return null;
    }

    public HashMap<String, Object> getConcreteTypes() {
        return null;
    }

    public abstract Map<String, Field<?, ?>> getFieldMappings();

    protected Object getFieldValue(Field field) {
        String outputFieldName = field.getOutputFieldName();
        if (field.getConcreteType() == null) {
            return getValueObject(field.getOutputFieldName());
        }
        zzx.zza(getValueObject(field.getOutputFieldName()) == null, "Concrete field shouldn't be value object: %s", field.getOutputFieldName());
        Map concreteTypeArrays = field.isTypeOutArray() ? getConcreteTypeArrays() : getConcreteTypes();
        if (concreteTypeArrays != null) {
            return concreteTypeArrays.get(outputFieldName);
        }
        try {
            return getClass().getMethod(Endpoints.ENDPOINT_GET + Character.toUpperCase(outputFieldName.charAt(0)) + outputFieldName.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected <O, I> I getOriginalValue(Field<I, O> field, Object convertedValue) {
        return field.zzaxF != null ? field.convertBack(convertedValue) : convertedValue;
    }

    public byte[] getResponseBody() {
        InputStream gZIPInputStream;
        byte[] bArr;
        Throwable th;
        zzx.zzad(this.zzaxD);
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(this.zzaxC));
            try {
                bArr = new byte[4096];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = gZIPInputStream.read(bArr, 0, bArr.length);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (IOException e2) {
                try {
                    bArr = this.zzaxC;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            gZIPInputStream = null;
            bArr = this.zzaxC;
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            gZIPInputStream = null;
            th = th4;
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            throw th;
        }
        return bArr;
    }

    public int getResponseCode() {
        zzx.zzad(this.zzaxD);
        return this.zzzV;
    }

    protected abstract Object getValueObject(String str);

    protected boolean isConcreteTypeArrayFieldSet(String outputField) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    protected boolean isConcreteTypeFieldSet(String outputField) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean isFieldSet(Field field) {
        if (field.getTypeOut() == 11) {
            return field.isTypeOutArray() ? isConcreteTypeArrayFieldSet(field.getOutputFieldName()) : isConcreteTypeFieldSet(field.getOutputFieldName());
        } else {
            return isPrimitiveFieldSet(field.getOutputFieldName());
        }
    }

    protected abstract boolean isPrimitiveFieldSet(String str);

    public <T extends FastJsonResponse> void parseNetworkResponse(int code, byte[] body) throws ParseException {
        this.zzzV = code;
        this.zzaxC = body;
        this.zzaxD = true;
        InputStream unzippedStream = getUnzippedStream(body);
        try {
            new FastParser().parse(unzippedStream, this);
        } finally {
            try {
                unzippedStream.close();
            } catch (IOException e) {
            }
        }
    }

    public final <O> void setBigDecimal(Field<BigDecimal, O> field, BigDecimal value) {
        if (field.zzaxF != null) {
            zza(field, value);
        } else {
            setBigDecimalInternal(field, field.getOutputFieldName(), value);
        }
    }

    protected void setBigDecimal(String outputField, BigDecimal value) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    protected void setBigDecimalInternal(Field<?, ?> field, String outputField, BigDecimal value) {
        setBigDecimal(outputField, value);
    }

    public final <O> void setBigDecimals(Field<ArrayList<BigDecimal>, O> field, ArrayList<BigDecimal> values) {
        if (field.zzaxF != null) {
            zza(field, values);
        } else {
            setBigDecimalsInternal(field, field.getOutputFieldName(), values);
        }
    }

    protected void setBigDecimals(String outputField, ArrayList<BigDecimal> arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    protected void setBigDecimalsInternal(Field<?, ?> field, String outputField, ArrayList<BigDecimal> values) {
        setBigDecimals(outputField, (ArrayList) values);
    }

    public final <O> void setBigInteger(Field<BigInteger, O> field, BigInteger value) {
        if (field.zzaxF != null) {
            zza(field, value);
        } else {
            setBigIntegerInternal(field, field.getOutputFieldName(), value);
        }
    }

    protected void setBigInteger(String outputField, BigInteger value) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    protected void setBigIntegerInternal(Field<?, ?> field, String outputField, BigInteger value) {
        setBigInteger(outputField, value);
    }

    public final <O> void setBigIntegers(Field<ArrayList<BigInteger>, O> field, ArrayList<BigInteger> values) {
        if (field.zzaxF != null) {
            zza(field, values);
        } else {
            setBigIntegersInternal(field, field.getOutputFieldName(), values);
        }
    }

    protected void setBigIntegers(String outputField, ArrayList<BigInteger> arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    protected void setBigIntegersInternal(Field<?, ?> field, String outputField, ArrayList<BigInteger> values) {
        setBigIntegers(outputField, (ArrayList) values);
    }

    public final <O> void setBoolean(Field<Boolean, O> field, boolean value) {
        if (field.zzaxF != null) {
            zza(field, Boolean.valueOf(value));
        } else {
            setBooleanInternal(field, field.getOutputFieldName(), value);
        }
    }

    protected void setBoolean(String outputField, boolean value) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    protected void setBooleanInternal(Field<?, ?> field, String outputField, boolean value) {
        setBoolean(outputField, value);
    }

    public final <O> void setBooleans(Field<ArrayList<Boolean>, O> field, ArrayList<Boolean> values) {
        if (field.zzaxF != null) {
            zza(field, values);
        } else {
            setBooleansInternal(field, field.getOutputFieldName(), values);
        }
    }

    protected void setBooleans(String outputField, ArrayList<Boolean> arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    protected void setBooleansInternal(Field<?, ?> field, String outputField, ArrayList<Boolean> values) {
        setBooleans(outputField, (ArrayList) values);
    }

    public final <O> void setDecodedBytes(Field<byte[], O> field, byte[] value) {
        if (field.zzaxF != null) {
            zza(field, value);
        } else {
            setDecodedBytesInternal(field, field.getOutputFieldName(), value);
        }
    }

    protected void setDecodedBytes(String outputField, byte[] value) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    protected void setDecodedBytesInternal(Field<?, ?> field, String outputField, byte[] value) {
        setDecodedBytes(outputField, value);
    }

    public final <O> void setDouble(Field<Double, O> field, double value) {
        if (field.zzaxF != null) {
            zza(field, Double.valueOf(value));
        } else {
            setDoubleInternal(field, field.getOutputFieldName(), value);
        }
    }

    protected void setDouble(String outputField, double value) {
        throw new UnsupportedOperationException("Double not supported");
    }

    protected void setDoubleInternal(Field<?, ?> field, String outputField, double value) {
        setDouble(outputField, value);
    }

    public final <O> void setDoubles(Field<ArrayList<Double>, O> field, ArrayList<Double> values) {
        if (field.zzaxF != null) {
            zza(field, values);
        } else {
            setDoublesInternal(field, field.getOutputFieldName(), values);
        }
    }

    protected void setDoubles(String outputField, ArrayList<Double> arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    protected void setDoublesInternal(Field<?, ?> field, String outputField, ArrayList<Double> values) {
        setDoubles(outputField, (ArrayList) values);
    }

    public final <O> void setFloat(Field<Float, O> field, float value) {
        if (field.zzaxF != null) {
            zza(field, Float.valueOf(value));
        } else {
            setFloatInternal(field, field.getOutputFieldName(), value);
        }
    }

    protected void setFloat(String outputField, float value) {
        throw new UnsupportedOperationException("Float not supported");
    }

    protected void setFloatInternal(Field<?, ?> field, String outputField, float value) {
        setFloat(outputField, value);
    }

    public final <O> void setFloats(Field<ArrayList<Float>, O> field, ArrayList<Float> values) {
        if (field.zzaxF != null) {
            zza(field, values);
        } else {
            setFloatsInternal(field, field.getOutputFieldName(), values);
        }
    }

    protected void setFloats(String outputField, ArrayList<Float> arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    protected void setFloatsInternal(Field<?, ?> field, String outputField, ArrayList<Float> values) {
        setFloats(outputField, (ArrayList) values);
    }

    public final <O> void setInteger(Field<Integer, O> field, int value) {
        if (field.zzaxF != null) {
            zza(field, Integer.valueOf(value));
        } else {
            setIntegerInternal(field, field.getOutputFieldName(), value);
        }
    }

    protected void setInteger(String outputField, int value) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    protected void setIntegerInternal(Field<?, ?> field, String outputField, int value) {
        setInteger(outputField, value);
    }

    public final <O> void setIntegers(Field<ArrayList<Integer>, O> field, ArrayList<Integer> values) {
        if (field.zzaxF != null) {
            zza(field, values);
        } else {
            setIntegersInternal(field, field.getOutputFieldName(), values);
        }
    }

    protected void setIntegers(String outputField, ArrayList<Integer> arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    protected void setIntegersInternal(Field<?, ?> field, String outputField, ArrayList<Integer> values) {
        setIntegers(outputField, (ArrayList) values);
    }

    public final <O> void setLong(Field<Long, O> field, long value) {
        if (field.zzaxF != null) {
            zza(field, Long.valueOf(value));
        } else {
            setLongInternal(field, field.getOutputFieldName(), value);
        }
    }

    protected void setLong(String outputField, long value) {
        throw new UnsupportedOperationException("Long not supported");
    }

    protected void setLongInternal(Field<?, ?> field, String outputField, long value) {
        setLong(outputField, value);
    }

    public final <O> void setLongs(Field<ArrayList<Long>, O> field, ArrayList<Long> values) {
        if (field.zzaxF != null) {
            zza(field, values);
        } else {
            setLongsInternal(field, field.getOutputFieldName(), values);
        }
    }

    protected void setLongs(String outputField, ArrayList<Long> arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    protected void setLongsInternal(Field<?, ?> field, String outputField, ArrayList<Long> values) {
        setLongs(outputField, (ArrayList) values);
    }

    public final <O> void setString(Field<String, O> field, String value) {
        if (field.zzaxF != null) {
            zza(field, value);
        } else {
            setStringInternal(field, field.getOutputFieldName(), value);
        }
    }

    protected void setString(String outputField, String value) {
        throw new UnsupportedOperationException("String not supported");
    }

    protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
        setString(outputField, value);
    }

    public final <O> void setStringMap(Field<Map<String, String>, O> field, Map<String, String> value) {
        if (field.zzaxF != null) {
            zza(field, value);
        } else {
            setStringMapInternal(field, field.getOutputFieldName(), value);
        }
    }

    protected void setStringMap(String outputField, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    protected void setStringMapInternal(Field<?, ?> field, String outputField, Map<String, String> value) {
        setStringMap(outputField, (Map) value);
    }

    public final <O> void setStrings(Field<ArrayList<String>, O> field, ArrayList<String> values) {
        if (field.zzaxF != null) {
            zza(field, values);
        } else {
            setStringsInternal(field, field.getOutputFieldName(), values);
        }
    }

    protected void setStrings(String outputField, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    protected void setStringsInternal(Field<?, ?> field, String outputField, ArrayList<String> values) {
        setStrings(outputField, (ArrayList) values);
    }

    public String toString() {
        Map fieldMappings = getFieldMappings();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            Field field = (Field) fieldMappings.get(str);
            if (isFieldSet(field)) {
                Object originalValue = getOriginalValue(field, getFieldValue(field));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(Csv.COMMA);
                }
                stringBuilder.append(QUOTE).append(str).append("\":");
                if (originalValue != null) {
                    switch (field.getTypeOut()) {
                        case 8:
                            stringBuilder.append(QUOTE).append(zzc.encode((byte[]) originalValue)).append(QUOTE);
                            break;
                        case 9:
                            stringBuilder.append(QUOTE).append(zzc.zzk((byte[]) originalValue)).append(QUOTE);
                            break;
                        case 10:
                            zzo.zza(stringBuilder, (HashMap) originalValue);
                            break;
                        default:
                            if (!field.isTypeInArray()) {
                                zza(stringBuilder, field, originalValue);
                                break;
                            }
                            zza(stringBuilder, field, (ArrayList) originalValue);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }

    public zza<? extends FastJsonResponse> zzrE() {
        return null;
    }
}

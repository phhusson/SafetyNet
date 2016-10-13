package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzn;
import com.google.android.gms.common.util.zzo;
import com.google.android.snet.Csv;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private final String mClassName;
    private final int mVersionCode;
    private final FieldMappingDictionary zzaxE;
    private final Parcel zzayg;
    private final int zzayh;
    private int zzayi;
    private int zzayj;

    SafeParcelResponse(int versionCode, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.mVersionCode = versionCode;
        this.zzayg = (Parcel) zzx.zzD(parcel);
        this.zzayh = 2;
        this.zzaxE = fieldMappingDictionary;
        if (this.zzaxE == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zzaxE.getRootClassName();
        }
        this.zzayi = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary dictionary, String className) {
        this.mVersionCode = 1;
        this.zzayg = Parcel.obtain();
        safeParcelable.writeToParcel(this.zzayg, 0);
        this.zzayh = 1;
        this.zzaxE = (FieldMappingDictionary) zzx.zzD(dictionary);
        this.mClassName = (String) zzx.zzD(className);
        this.zzayi = 2;
    }

    public SafeParcelResponse(FieldMappingDictionary dictionary, String className) {
        this.mVersionCode = 1;
        this.zzayg = Parcel.obtain();
        this.zzayh = 0;
        this.zzaxE = (FieldMappingDictionary) zzx.zzD(dictionary);
        this.mClassName = (String) zzx.zzD(className);
        this.zzayi = 0;
    }

    private static HashMap<Integer, Entry<String, Field<?, ?>>> zzN(Map<String, Field<?, ?>> map) {
        HashMap<Integer, Entry<String, Field<?, ?>>> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put(Integer.valueOf(((Field) entry.getValue()).getSafeParcelableFieldId()), entry);
        }
        return hashMap;
    }

    private static void zza(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        Class cls = fastJsonResponse.getClass();
        if (!fieldMappingDictionary.hasFieldMappingForClass(cls)) {
            Map fieldMappings = fastJsonResponse.getFieldMappings();
            fieldMappingDictionary.put(cls, fieldMappings);
            for (String str : fieldMappings.keySet()) {
                Field field = (Field) fieldMappings.get(str);
                Class concreteType = field.getConcreteType();
                if (concreteType != null) {
                    try {
                        zza(fieldMappingDictionary, (FastJsonResponse) concreteType.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + field.getConcreteType().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + field.getConcreteType().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void zza(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(zzn.zzcR(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(zzc.encode((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(zzc.zzk((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                zzo.zza(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void zza(StringBuilder stringBuilder, Field<?, ?> field, Parcel parcel, int i) {
        switch (field.getTypeOut()) {
            case 0:
                zzb(stringBuilder, (Field) field, getOriginalValue(field, Integer.valueOf(zza.zzg(parcel, i))));
                return;
            case 1:
                zzb(stringBuilder, (Field) field, getOriginalValue(field, zza.zzk(parcel, i)));
                return;
            case 2:
                zzb(stringBuilder, (Field) field, getOriginalValue(field, Long.valueOf(zza.zzi(parcel, i))));
                return;
            case 3:
                zzb(stringBuilder, (Field) field, getOriginalValue(field, Float.valueOf(zza.zzl(parcel, i))));
                return;
            case 4:
                zzb(stringBuilder, (Field) field, getOriginalValue(field, Double.valueOf(zza.zzn(parcel, i))));
                return;
            case 5:
                zzb(stringBuilder, (Field) field, getOriginalValue(field, zza.zzp(parcel, i)));
                return;
            case 6:
                zzb(stringBuilder, (Field) field, getOriginalValue(field, Boolean.valueOf(zza.zzc(parcel, i))));
                return;
            case 7:
                zzb(stringBuilder, (Field) field, getOriginalValue(field, zza.zzq(parcel, i)));
                return;
            case 8:
            case 9:
                zzb(stringBuilder, (Field) field, getOriginalValue(field, zza.zzt(parcel, i)));
                return;
            case 10:
                zzb(stringBuilder, (Field) field, getOriginalValue(field, zzr(zza.zzs(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + field.getTypeOut());
        }
    }

    private void zza(StringBuilder stringBuilder, String str, Field<?, ?> field, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (field.hasConverter()) {
            zza(stringBuilder, field, parcel, i);
        } else {
            zzb(stringBuilder, field, parcel, i);
        }
    }

    private void zza(StringBuilder stringBuilder, Map<String, Field<?, ?>> map, Parcel parcel) {
        HashMap zzN = zzN(map);
        stringBuilder.append('{');
        int zzbd = zza.zzbd(parcel);
        Object obj = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            Entry entry = (Entry) zzN.get(Integer.valueOf(zza.zzdr(zzbc)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(Csv.COMMA);
                }
                zza(stringBuilder, (String) entry.getKey(), (Field) entry.getValue(), parcel, zzbc);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != zzbd) {
            throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
        }
        stringBuilder.append('}');
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse zzb(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new SafeParcelResponse((SafeParcelable) t, zzc(t), canonicalName);
    }

    private void zzb(Field<?, ?> field) {
        if (!field.isValidSafeParcelableFieldId()) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        } else if (this.zzayg == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        } else {
            switch (this.zzayi) {
                case 0:
                    this.zzayj = zzb.zzbe(this.zzayg);
                    this.zzayi = 1;
                    return;
                case 1:
                    return;
                case 2:
                    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                default:
                    throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
            }
        }
    }

    private void zzb(StringBuilder stringBuilder, Field<?, ?> field, Parcel parcel, int i) {
        if (field.isTypeOutArray()) {
            stringBuilder.append("[");
            switch (field.getTypeOut()) {
                case 0:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zza.zzw(parcel, i));
                    break;
                case 1:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zza.zzy(parcel, i));
                    break;
                case 2:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zza.zzx(parcel, i));
                    break;
                case 3:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zza.zzz(parcel, i));
                    break;
                case 4:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zza.zzA(parcel, i));
                    break;
                case 5:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zza.zzB(parcel, i));
                    break;
                case 6:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zza.zzv(parcel, i));
                    break;
                case 7:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zza.zzC(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] zzG = zza.zzG(parcel, i);
                    int length = zzG.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(Csv.COMMA);
                        }
                        zzG[i2].setDataPosition(0);
                        zza(stringBuilder, field.getConcreteTypeFieldMappingFromDictionary(), zzG[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (field.getTypeOut()) {
            case 0:
                stringBuilder.append(zza.zzg(parcel, i));
                return;
            case 1:
                stringBuilder.append(zza.zzk(parcel, i));
                return;
            case 2:
                stringBuilder.append(zza.zzi(parcel, i));
                return;
            case 3:
                stringBuilder.append(zza.zzl(parcel, i));
                return;
            case 4:
                stringBuilder.append(zza.zzn(parcel, i));
                return;
            case 5:
                stringBuilder.append(zza.zzp(parcel, i));
                return;
            case 6:
                stringBuilder.append(zza.zzc(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(zzn.zzcR(zza.zzq(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(zzc.encode(zza.zzt(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(zzc.zzk(zza.zzt(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle zzs = zza.zzs(parcel, i);
                Set<String> keySet = zzs.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(Csv.COMMA);
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(zzn.zzcR(zzs.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel zzF = zza.zzF(parcel, i);
                zzF.setDataPosition(0);
                zza(stringBuilder, field.getConcreteTypeFieldMappingFromDictionary(), zzF);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void zzb(StringBuilder stringBuilder, Field<?, ?> field, Object obj) {
        if (field.isTypeInArray()) {
            zzb(stringBuilder, (Field) field, (ArrayList) obj);
        } else {
            zza(stringBuilder, field.getTypeIn(), obj);
        }
    }

    private void zzb(StringBuilder stringBuilder, Field<?, ?> field, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(Csv.COMMA);
            }
            zza(stringBuilder, field.getTypeIn(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    private static FieldMappingDictionary zzc(FastJsonResponse fastJsonResponse) {
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(fastJsonResponse.getClass());
        zza(fieldMappingDictionary, fastJsonResponse);
        fieldMappingDictionary.copyInternalFieldMappings();
        fieldMappingDictionary.linkFields();
        return fieldMappingDictionary;
    }

    public static HashMap<String, String> zzr(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> field, String outputField, ArrayList<T> values) {
        zzb((Field) field);
        List arrayList = new ArrayList();
        values.size();
        Iterator it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(((SafeParcelResponse) ((FastJsonResponse) it.next())).zzrJ());
        }
        zzb.zzd(this.zzayg, field.getSafeParcelableFieldId(), arrayList, true);
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String outputField, T value) {
        zzb((Field) field);
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), ((SafeParcelResponse) value).zzrJ(), true);
    }

    public int describeContents() {
        zzb com_google_android_gms_common_server_response_zzb = CREATOR;
        return 0;
    }

    public Map<String, Field<?, ?>> getFieldMappings() {
        return this.zzaxE == null ? null : this.zzaxE.getFieldMapping(this.mClassName);
    }

    protected Object getValueObject(String key) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    protected boolean isPrimitiveFieldSet(String outputField) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected void setBigDecimalInternal(Field<?, ?> field, String outputField, BigDecimal value) {
        zzb((Field) field);
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), value, true);
    }

    protected void setBigDecimalsInternal(Field<?, ?> field, String outputField, ArrayList<BigDecimal> values) {
        zzb((Field) field);
        int size = values.size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i = 0; i < size; i++) {
            bigDecimalArr[i] = (BigDecimal) values.get(i);
        }
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), bigDecimalArr, true);
    }

    protected void setBigIntegerInternal(Field<?, ?> field, String outputField, BigInteger value) {
        zzb((Field) field);
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), value, true);
    }

    protected void setBigIntegersInternal(Field<?, ?> field, String outputField, ArrayList<BigInteger> values) {
        zzb((Field) field);
        int size = values.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            bigIntegerArr[i] = (BigInteger) values.get(i);
        }
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), bigIntegerArr, true);
    }

    protected void setBooleanInternal(Field<?, ?> field, String outputField, boolean value) {
        zzb((Field) field);
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), value);
    }

    protected void setBooleansInternal(Field<?, ?> field, String outputField, ArrayList<Boolean> values) {
        zzb((Field) field);
        int size = values.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = ((Boolean) values.get(i)).booleanValue();
        }
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), zArr, true);
    }

    protected void setDecodedBytesInternal(Field<?, ?> field, String outputField, byte[] value) {
        zzb((Field) field);
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), value, true);
    }

    protected void setDoubleInternal(Field<?, ?> field, String outputField, double value) {
        zzb((Field) field);
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), value);
    }

    protected void setDoublesInternal(Field<?, ?> field, String outputField, ArrayList<Double> values) {
        zzb((Field) field);
        int size = values.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = ((Double) values.get(i)).doubleValue();
        }
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), dArr, true);
    }

    protected void setFloatInternal(Field<?, ?> field, String outputField, float value) {
        zzb((Field) field);
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), value);
    }

    protected void setFloatsInternal(Field<?, ?> field, String outputField, ArrayList<Float> values) {
        zzb((Field) field);
        int size = values.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = ((Float) values.get(i)).floatValue();
        }
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), fArr, true);
    }

    protected void setIntegerInternal(Field<?, ?> field, String outputField, int value) {
        zzb((Field) field);
        zzb.zzc(this.zzayg, field.getSafeParcelableFieldId(), value);
    }

    protected void setIntegersInternal(Field<?, ?> field, String outputField, ArrayList<Integer> values) {
        zzb((Field) field);
        int size = values.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) values.get(i)).intValue();
        }
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), iArr, true);
    }

    protected void setLongInternal(Field<?, ?> field, String outputField, long value) {
        zzb((Field) field);
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), value);
    }

    protected void setLongsInternal(Field<?, ?> field, String outputField, ArrayList<Long> values) {
        zzb((Field) field);
        int size = values.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = ((Long) values.get(i)).longValue();
        }
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), jArr, true);
    }

    protected void setStringInternal(Field<?, ?> field, String outputField, String value) {
        zzb((Field) field);
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), value, true);
    }

    protected void setStringMapInternal(Field<?, ?> field, String outputField, Map<String, String> value) {
        zzb((Field) field);
        Bundle bundle = new Bundle();
        for (String str : value.keySet()) {
            bundle.putString(str, (String) value.get(str));
        }
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), bundle, true);
    }

    protected void setStringsInternal(Field<?, ?> field, String outputField, ArrayList<String> values) {
        zzb((Field) field);
        int size = values.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) values.get(i);
        }
        zzb.zza(this.zzayg, field.getSafeParcelableFieldId(), strArr, true);
    }

    public String toString() {
        zzx.zzb(this.zzaxE, (Object) "Cannot convert to JSON on client side.");
        Parcel zzrJ = zzrJ();
        zzrJ.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        zza(stringBuilder, this.zzaxE.getFieldMapping(this.mClassName), zzrJ);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb com_google_android_gms_common_server_response_zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    public Parcel zzrJ() {
        switch (this.zzayi) {
            case 0:
                this.zzayj = zzb.zzbe(this.zzayg);
                zzb.zzJ(this.zzayg, this.zzayj);
                this.zzayi = 2;
                break;
            case 1:
                zzb.zzJ(this.zzayg, this.zzayj);
                this.zzayi = 2;
                break;
        }
        return this.zzayg;
    }

    FieldMappingDictionary zzrK() {
        switch (this.zzayh) {
            case 0:
                return null;
            case 1:
                return this.zzaxE;
            case 2:
                return this.zzaxE;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.zzayh);
        }
    }
}

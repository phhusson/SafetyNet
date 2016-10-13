package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
    public static final FieldMappingDictionaryCreator CREATOR = new FieldMappingDictionaryCreator();
    private final int mVersionCode;
    private final HashMap<String, Map<String, Field<?, ?>>> zzayb;
    private final ArrayList<Entry> zzayc;
    private final String zzayd;

    public static class Entry implements SafeParcelable {
        public static final FieldMappingDictionaryEntryCreator CREATOR = new FieldMappingDictionaryEntryCreator();
        final String className;
        final int versionCode;
        final ArrayList<FieldMapPair> zzaye;

        Entry(int versionCode, String className, ArrayList<FieldMapPair> fieldMapping) {
            this.versionCode = versionCode;
            this.className = className;
            this.zzaye = fieldMapping;
        }

        Entry(String className, Map<String, Field<?, ?>> fieldMap) {
            this.versionCode = 1;
            this.className = className;
            this.zzaye = zzM(fieldMap);
        }

        private static ArrayList<FieldMapPair> zzM(Map<String, Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<FieldMapPair> arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, (Field) map.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            FieldMappingDictionaryEntryCreator fieldMappingDictionaryEntryCreator = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            FieldMappingDictionaryEntryCreator fieldMappingDictionaryEntryCreator = CREATOR;
            FieldMappingDictionaryEntryCreator.zza(this, out, flags);
        }

        HashMap<String, Field<?, ?>> zzrI() {
            HashMap<String, Field<?, ?>> hashMap = new HashMap();
            int size = this.zzaye.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = (FieldMapPair) this.zzaye.get(i);
                hashMap.put(fieldMapPair.key, fieldMapPair.zzayf);
            }
            return hashMap;
        }
    }

    public static class FieldMapPair implements SafeParcelable {
        public static final FieldMapPairCreator CREATOR = new FieldMapPairCreator();
        final String key;
        final int versionCode;
        final Field<?, ?> zzayf;

        FieldMapPair(int versionCode, String key, Field<?, ?> value) {
            this.versionCode = versionCode;
            this.key = key;
            this.zzayf = value;
        }

        FieldMapPair(String key, Field<?, ?> value) {
            this.versionCode = 1;
            this.key = key;
            this.zzayf = value;
        }

        public int describeContents() {
            FieldMapPairCreator fieldMapPairCreator = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            FieldMapPairCreator fieldMapPairCreator = CREATOR;
            FieldMapPairCreator.zza(this, out, flags);
        }
    }

    FieldMappingDictionary(int versionCode, ArrayList<Entry> serializedDictionary, String rootClassName) {
        this.mVersionCode = versionCode;
        this.zzayc = null;
        this.zzayb = zze(serializedDictionary);
        this.zzayd = (String) zzx.zzD(rootClassName);
        linkFields();
    }

    public FieldMappingDictionary(Class<? extends FastJsonResponse> rootClazz) {
        this.mVersionCode = 1;
        this.zzayc = null;
        this.zzayb = new HashMap();
        this.zzayd = rootClazz.getCanonicalName();
    }

    private static HashMap<String, Map<String, Field<?, ?>>> zze(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, Field<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            hashMap.put(entry.className, entry.zzrI());
        }
        return hashMap;
    }

    public void copyInternalFieldMappings() {
        for (String str : this.zzayb.keySet()) {
            Map map = (Map) this.zzayb.get(str);
            HashMap hashMap = new HashMap();
            for (String str2 : map.keySet()) {
                hashMap.put(str2, ((Field) map.get(str2)).copyForDictionary());
            }
            this.zzayb.put(str, hashMap);
        }
    }

    public int describeContents() {
        FieldMappingDictionaryCreator fieldMappingDictionaryCreator = CREATOR;
        return 0;
    }

    public Map<String, Field<?, ?>> getFieldMapping(Class<? extends FastJsonResponse> clazz) {
        return (Map) this.zzayb.get(clazz.getCanonicalName());
    }

    public Map<String, Field<?, ?>> getFieldMapping(String className) {
        return (Map) this.zzayb.get(className);
    }

    public String getRootClassName() {
        return this.zzayd;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasFieldMappingForClass(Class<? extends FastJsonResponse> clazz) {
        return this.zzayb.containsKey(clazz.getCanonicalName());
    }

    public void linkFields() {
        for (String str : this.zzayb.keySet()) {
            Map map = (Map) this.zzayb.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).setFieldMappingDictionary(this);
            }
        }
    }

    public void put(Class<? extends FastJsonResponse> clazz, Map<String, Field<?, ?>> fieldMap) {
        this.zzayb.put(clazz.getCanonicalName(), fieldMap);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.zzayb.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.zzayb.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        FieldMappingDictionaryCreator fieldMappingDictionaryCreator = CREATOR;
        FieldMappingDictionaryCreator.zza(this, out, flags);
    }

    ArrayList<Entry> zzrH() {
        ArrayList<Entry> arrayList = new ArrayList();
        for (String str : this.zzayb.keySet()) {
            arrayList.add(new Entry(str, (Map) this.zzayb.get(str)));
        }
        return arrayList;
    }
}

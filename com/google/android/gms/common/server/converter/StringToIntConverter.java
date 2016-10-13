package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, FieldConverter<String, Integer> {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private final HashMap<String, Integer> zzaxx;
    private final HashMap<Integer, String> zzaxy;
    private final ArrayList<Entry> zzaxz;

    public static final class Entry implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        final String stringValue;
        final int versionCode;
        final int zzaxA;

        Entry(int versionCode, String stringValue, int intValue) {
            this.versionCode = versionCode;
            this.stringValue = stringValue;
            this.zzaxA = intValue;
        }

        Entry(String stringValue, int intValue) {
            this.versionCode = 1;
            this.stringValue = stringValue;
            this.zzaxA = intValue;
        }

        public int describeContents() {
            zzc com_google_android_gms_common_server_converter_zzc = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzc com_google_android_gms_common_server_converter_zzc = CREATOR;
            zzc.zza(this, out, flags);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.zzaxx = new HashMap();
        this.zzaxy = new HashMap();
        this.zzaxz = null;
    }

    StringToIntConverter(int versionCode, ArrayList<Entry> serializedMap) {
        this.mVersionCode = versionCode;
        this.zzaxx = new HashMap();
        this.zzaxy = new HashMap();
        this.zzaxz = null;
        zzd(serializedMap);
    }

    private void zzd(ArrayList<Entry> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzj(entry.stringValue, entry.zzaxA);
        }
    }

    public /* synthetic */ Object convert(Object obj) {
        return zzcM((String) obj);
    }

    public /* synthetic */ Object convertBack(Object obj) {
        return zzc((Integer) obj);
    }

    public int describeContents() {
        zzb com_google_android_gms_common_server_converter_zzb = CREATOR;
        return 0;
    }

    public int getTypeIn() {
        return 7;
    }

    public int getTypeOut() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb com_google_android_gms_common_server_converter_zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    public String zzc(Integer num) {
        String str = (String) this.zzaxy.get(num);
        return (str == null && this.zzaxx.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public Integer zzcM(String str) {
        Integer num = (Integer) this.zzaxx.get(str);
        return num == null ? (Integer) this.zzaxx.get("gms_unknown") : num;
    }

    public StringToIntConverter zzj(String str, int i) {
        this.zzaxx.put(str, Integer.valueOf(i));
        this.zzaxy.put(Integer.valueOf(i), str);
        return this;
    }

    ArrayList<Entry> zzrD() {
        ArrayList<Entry> arrayList = new ArrayList();
        for (String str : this.zzaxx.keySet()) {
            arrayList.add(new Entry(str, ((Integer) this.zzaxx.get(str)).intValue()));
        }
        return arrayList;
    }
}

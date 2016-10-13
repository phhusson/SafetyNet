package com.google.android.gms.people.internal.agg;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.people.internal.zzo;
import com.google.android.gms.people.internal.zzp;
import com.google.android.gms.people.model.EmailAddress;
import com.google.android.gms.people.model.PhoneNumber;
import java.util.ArrayList;
import java.util.regex.Pattern;

public abstract class PhoneEmailDecoder<T> {
    public static EmailDecoder DummyEmailDecoder = new EmailDecoder(Bundle.EMPTY);
    public static PhoneDecoder DummyPhoneDecoder = new PhoneDecoder(Bundle.EMPTY);
    private final char zzbGh;
    private final char zzbGi;
    private final String zzbGj = Pattern.quote(String.valueOf(this.zzbGh));
    private final String zzbGk = Pattern.quote(String.valueOf(this.zzbGi));
    private final Bundle zzbGl;

    public static class EmailDecoder extends PhoneEmailDecoder<EmailAddress> {
        public EmailDecoder(Bundle typeLabelMap) {
            super(typeLabelMap, '\u0001', '\u0002');
        }

        protected EmailAddress build(String value, String label, double affinity1, double affinity2, double affinity3, double affinity4, double affinity5, String loggingId1, String loggingId2, String loggingId3, String loggingId4, String loggingId5) {
            return new zzc(label, value, affinity1, affinity2, affinity3, affinity4, affinity5, loggingId1, loggingId2, loggingId3, loggingId4, loggingId5);
        }
    }

    public static class PhoneDecoder extends PhoneEmailDecoder<PhoneNumber> {
        public PhoneDecoder(Bundle typeLabelMap) {
            super(typeLabelMap, '\u0001', '\u0002');
        }

        protected PhoneNumber build(String value, String label, double affinity1, double affinity2, double affinity3, double affinity4, double affinity5, String loggingId1, String loggingId2, String loggingId3, String loggingId4, String loggingId5) {
            return new zzg(label, value);
        }
    }

    PhoneEmailDecoder(Bundle typeLabelMap, char sep1, char sep2) {
        this.zzbGl = typeLabelMap;
        this.zzbGh = sep1;
        this.zzbGi = sep2;
    }

    private static double parseDouble(String s) {
        double d = 0.0d;
        if (!TextUtils.isEmpty(s)) {
            try {
                d = Double.parseDouble(s);
            } catch (Throwable e) {
                zzo.zzc("PhoneEmailDecoder", "NumberFormatException", e);
            }
        }
        return d;
    }

    private static int zza(String str, char c, int i, int i2) {
        int indexOf = str.indexOf(c, i);
        return (indexOf < 0 || indexOf >= i2) ? -1 : indexOf;
    }

    private final void zza(ArrayList<T> arrayList, String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int indexOf = str.indexOf(this.zzbGi, i);
            if (indexOf < 0) {
                indexOf = str.length();
            }
            int zza = zza(str, this.zzbGh, i, indexOf);
            int zza2 = zza(str, this.zzbGh, zza + 1, indexOf);
            if (zza >= 0 && zza2 >= 0) {
                zza(arrayList, str.substring(i, zza), str.substring(zza + 1, zza2), str.substring(zza2 + 1, indexOf), 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, null, null, null, null, null);
            }
            i = indexOf + 1;
        }
    }

    private void zza(ArrayList<T> arrayList, String str, String str2, String str3, double d, double d2, double d3, double d4, double d5, String str4, String str5, String str6, String str7, String str8) {
        if (!TextUtils.isEmpty(str3)) {
            String string = this.zzbGl.getString(str);
            if (TextUtils.isEmpty(string)) {
                string = str2;
            }
            arrayList.add(build(str3, string, d, d2, d3, d4, d5, str4, str5, str6, str7, str8));
        }
    }

    private final void zzb(ArrayList<T> arrayList, String str) {
        for (String split : TextUtils.split(str, this.zzbGk)) {
            String[] split2 = TextUtils.split(split, this.zzbGj);
            if (split2.length < 13) {
                zzo.zzI("PhoneEmailDecoder", "Invalid string");
            } else {
                zza(arrayList, split2[0], split2[1], split2[2], parseDouble(split2[3]), parseDouble(split2[4]), parseDouble(split2[5]), parseDouble(split2[6]), parseDouble(split2[7]), zzp.zzhN(split2[8]), zzp.zzhN(split2[9]), zzp.zzhN(split2[10]), zzp.zzhN(split2[11]), zzp.zzhN(split2[12]));
            }
        }
    }

    protected abstract T build(String str, String str2, double d, double d2, double d3, double d4, double d5, String str3, String str4, String str5, String str6, String str7);

    public final ArrayList<T> decode(String s, boolean hasAffinities) {
        ArrayList<T> arrayList = new ArrayList();
        if (!TextUtils.isEmpty(s)) {
            if (hasAffinities) {
                zzb(arrayList, s);
            } else {
                zza(arrayList, s);
            }
        }
        return arrayList;
    }
}

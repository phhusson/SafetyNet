package com.google.android.gms.people.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.people.data.AudienceMember;
import com.google.android.snet.Csv;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class zzp {
    public static final Map<String, Integer> zzbEM = new HashMap();
    public static Iterable<?> zzbEN = new zze();
    public static final Handler zzbEO = new Handler(Looper.getMainLooper());
    public static final String[] zzbEP = new String[0];
    public static final Pattern zzbEQ = Pattern.compile("\\,");
    public static final Pattern zzbER = Pattern.compile("[     ᠎             　\t\u000b\f\u001c\u001d\u001e\u001f\n\r]+");
    public static final Pattern zzbES = Pattern.compile(Pattern.quote(String.valueOf('\u0001')));
    public static final Pattern zzbET = Pattern.compile(Pattern.quote(String.valueOf('\u0002')));
    public static final String zzbEU = String.valueOf('\u0001');
    public static final String zzbEV = String.valueOf('\u0002');
    public static final SecureRandom zzbEW = new SecureRandom();
    private static final ThreadLocal<StringBuilder> zzbEX = new C05851();
    private static final ThreadLocal<String[]> zzbEY = new C05862();
    private static final ThreadLocal<String[]> zzbEZ = new C05873();
    private static final ThreadLocal<String[]> zzbFa = new C05884();
    private static final ThreadLocal<String[]> zzbFb = new C05895();
    private static final ThreadLocal<String[]> zzbFc = new C05906();

    static class C05851 extends ThreadLocal<StringBuilder> {
        C05851() {
        }

        protected /* synthetic */ Object initialValue() {
            return zzJA();
        }

        protected StringBuilder zzJA() {
            return new StringBuilder();
        }
    }

    static class C05862 extends ThreadLocal<String[]> {
        C05862() {
        }

        protected /* synthetic */ Object initialValue() {
            return zzJB();
        }

        protected String[] zzJB() {
            return new String[1];
        }
    }

    static class C05873 extends ThreadLocal<String[]> {
        C05873() {
        }

        protected /* synthetic */ Object initialValue() {
            return zzJB();
        }

        protected String[] zzJB() {
            return new String[2];
        }
    }

    static class C05884 extends ThreadLocal<String[]> {
        C05884() {
        }

        protected /* synthetic */ Object initialValue() {
            return zzJB();
        }

        protected String[] zzJB() {
            return new String[3];
        }
    }

    static class C05895 extends ThreadLocal<String[]> {
        C05895() {
        }

        protected /* synthetic */ Object initialValue() {
            return zzJB();
        }

        protected String[] zzJB() {
            return new String[4];
        }
    }

    static class C05906 extends ThreadLocal<String[]> {
        C05906() {
        }

        protected /* synthetic */ Object initialValue() {
            return zzJB();
        }

        protected String[] zzJB() {
            return new String[5];
        }
    }

    static {
        zzbEM.put("circle", Integer.valueOf(-1));
        zzbEM.put(AudienceMember.AUDIENCE_GROUP_EXTENDED, Integer.valueOf(4));
        zzbEM.put(AudienceMember.AUDIENCE_GROUP_YOUR_CIRCLES, Integer.valueOf(3));
        zzbEM.put(AudienceMember.AUDIENCE_GROUP_DOMAIN, Integer.valueOf(2));
        zzbEM.put(AudienceMember.AUDIENCE_GROUP_PUBLIC, Integer.valueOf(1));
        zzbEM.put(null, Integer.valueOf(-2));
    }

    public static StringBuilder zzJz() {
        StringBuilder stringBuilder = (StringBuilder) zzbEX.get();
        stringBuilder.setLength(0);
        return stringBuilder;
    }

    public static String zzW(Bundle bundle) {
        return zza(bundle, "", new StringBuilder()).toString();
    }

    private static StringBuilder zza(Object obj, String str, StringBuilder stringBuilder) {
        if (obj == null) {
            stringBuilder.append("[null]\n");
        } else {
            String str2 = str + "  ";
            stringBuilder.append("(").append(obj.getClass().getSimpleName()).append(") ");
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                if (bundle.isEmpty()) {
                    stringBuilder.append("{ }").append(Csv.NEWLINE);
                } else {
                    stringBuilder.append("{\n");
                    for (String str3 : bundle.keySet()) {
                        stringBuilder.append(str2).append(str3).append(" : ");
                        zza(bundle.get(str3), str2, stringBuilder);
                    }
                    stringBuilder.append(str).append("}\n");
                }
            } else if (obj instanceof DataHolder) {
                DataHolder dataHolder = (DataHolder) obj;
                stringBuilder.append(" [");
                if (dataHolder.isClosed()) {
                    stringBuilder.append("CLOSED");
                } else {
                    stringBuilder.append(dataHolder.getCount());
                }
                stringBuilder.append("] ").append(obj).append(Csv.NEWLINE);
            } else if (obj instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList.isEmpty()) {
                    stringBuilder.append("[ ]\n");
                } else {
                    stringBuilder.append("[\n");
                    for (r0 = 0; r0 < arrayList.size(); r0++) {
                        stringBuilder.append(str2).append(r0).append(" : ");
                        zza(arrayList.get(r0), str2, stringBuilder);
                    }
                    stringBuilder.append(str).append("]\n");
                }
            } else if (obj instanceof byte[]) {
                r0 = ((byte[]) obj).length;
                stringBuilder.append(" [").append(r0).append("] ");
                Object obj2 = new byte[Math.min(r0, 56)];
                System.arraycopy(obj, 0, obj2, 0, obj2.length);
                stringBuilder.append(Base64.encodeToString(obj2, 0));
            } else if (obj instanceof char[]) {
                stringBuilder.append("\"").append(new String((char[]) obj)).append("\"\n");
            } else if (obj.getClass().isArray()) {
                if (Array.getLength(obj) == 0) {
                    stringBuilder.append("[ ]\n");
                } else {
                    stringBuilder.append("[ ");
                    stringBuilder.append(Array.get(obj, 0));
                    for (r0 = 1; r0 < Array.getLength(obj); r0++) {
                        stringBuilder.append(", ").append(Array.get(obj, r0));
                    }
                    stringBuilder.append(" ]\n");
                }
            } else if (obj instanceof String) {
                stringBuilder.append("\"").append(obj).append("\"\n");
            } else {
                stringBuilder.append(obj).append(Csv.NEWLINE);
            }
        }
        return stringBuilder;
    }

    public static Random zzaU(Context context) {
        Random random = (Random) context.getSystemService("gms.people.random");
        return random != null ? random : zzbEW;
    }

    public static void zzak(String str, String str2) {
        zzx.zzi(str, str2);
        boolean z = str.startsWith("g:") || str.startsWith("e:");
        zzx.zzb(z, str2 + ": Expecting qualified-id, not gaia-id");
    }

    public static String[] zzal(String str, String str2) {
        String[] strArr = (String[]) zzbEZ.get();
        strArr[0] = str;
        strArr[1] = str2;
        return strArr;
    }

    public static String zzhN(String str) {
        return (str == null || str.length() == 0) ? null : str;
    }

    public static String[] zzhO(String str) {
        return TextUtils.isEmpty(str) ? zzbEP : zzbEQ.split(str, 0);
    }

    public static String zzhP(String str) {
        return (str == null || !str.startsWith("g:")) ? null : str.substring("g:".length());
    }

    public static String zzhQ(String str) {
        zzx.zzD(str);
        return "g:" + str;
    }

    public static String zzhR(String str) {
        return (str == null || !str.startsWith("e:")) ? null : str.substring("e:".length());
    }

    public static String zzhS(String str) {
        zzx.zzcL(str);
        return "e:" + str;
    }

    public static boolean zzhT(String str) {
        return str != null && str.startsWith("e:");
    }

    public static boolean zzhU(String str) {
        return str != null && str.startsWith("g:");
    }

    public static boolean zzhV(String str) {
        return zzhT(str) || zzhU(str);
    }

    public static String zzhW(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        return str.substring(i);
    }
}

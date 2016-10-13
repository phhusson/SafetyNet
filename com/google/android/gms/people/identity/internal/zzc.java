package com.google.android.gms.people.identity.internal;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.Relation;
import android.provider.ContactsContract.CommonDataKinds.StructuredPostal;
import android.provider.ContactsContract.DisplayPhoto;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.util.zzr;
import com.google.android.gms.people.identity.PersonFactory.RawContactData;
import com.google.android.gms.people.internal.zzo;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class zzc {

    public static final class zza {
        private static final Map<Integer, String> zzbAZ;

        static {
            Map hashMap = new HashMap();
            hashMap.put(Integer.valueOf(1), "home");
            hashMap.put(Integer.valueOf(3), "other");
            hashMap.put(Integer.valueOf(2), "work");
            hashMap.put(Integer.valueOf(0), "custom");
            zzbAZ = Collections.unmodifiableMap(hashMap);
        }

        public static String zza(Context context, RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            return zzb == null ? null : StructuredPostal.getTypeLabel(context.getResources(), zzb.intValue(), rawContactData.getData(2)).toString();
        }

        public static String zza(RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            if (zzb != null && zzbAZ.containsKey(zzb)) {
                return (String) zzbAZ.get(zzb);
            }
            zzo.zzI("ContactData", "Invalid StructuredPostal Type: " + zzb);
            return null;
        }

        public static final String zzb(RawContactData rawContactData) {
            return rawContactData.getData(3);
        }

        public static final String zzc(RawContactData rawContactData) {
            return rawContactData.getData(4);
        }

        public static final String zzd(RawContactData rawContactData) {
            return rawContactData.getData(6);
        }

        public static final String zze(RawContactData rawContactData) {
            return rawContactData.getData(7);
        }

        public static final String zzf(RawContactData rawContactData) {
            return rawContactData.getData(8);
        }

        public static final String zzg(RawContactData rawContactData) {
            String data = rawContactData.getData(9);
            return (data == null || !TextUtils.isDigitsOnly(data)) ? data : null;
        }

        public static final String zzh(RawContactData rawContactData) {
            Object data = rawContactData.getData(9);
            return (data == null || !TextUtils.isDigitsOnly(data)) ? null : data;
        }
    }

    public static final class zzb {
        private static final Map<Integer, String> zzbBa;

        static {
            Map hashMap = new HashMap();
            hashMap.put(Integer.valueOf(1), "home");
            hashMap.put(Integer.valueOf(4), "mobile");
            hashMap.put(Integer.valueOf(3), "other");
            hashMap.put(Integer.valueOf(2), "work");
            hashMap.put(Integer.valueOf(0), "custom");
            zzbBa = Collections.unmodifiableMap(hashMap);
        }

        public static String zza(Context context, RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            return zzb == null ? null : Email.getTypeLabel(context.getResources(), zzb.intValue(), rawContactData.getData(2)).toString();
        }

        public static String zza(RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            if (zzb != null && zzbBa.containsKey(zzb)) {
                return (String) zzbBa.get(zzb);
            }
            zzo.zzI("ContactData", "Invalid Email Type: " + zzb);
            return null;
        }

        public static final String zzi(RawContactData rawContactData) {
            return rawContactData.getData(0);
        }
    }

    public static final class zzc {
        private static final Map<Integer, String> zzbBb;

        static {
            Map hashMap = new HashMap();
            hashMap.put(Integer.valueOf(1), "anniversary");
            hashMap.put(Integer.valueOf(3), "birthday");
            hashMap.put(Integer.valueOf(2), "other");
            hashMap.put(Integer.valueOf(0), "custom");
            zzbBb = Collections.unmodifiableMap(hashMap);
        }

        public static final String zzb(Context context, RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            return zzb == null ? null : context.getString(Event.getTypeResource(zzb));
        }

        public static final String zzj(RawContactData rawContactData) {
            return rawContactData.getData(0);
        }

        public static final String zzk(RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            if (zzb != null && zzbBb.containsKey(zzb)) {
                return (String) zzbBb.get(zzb);
            }
            zzo.zzI("ContactData", "Invalid Event Type: " + zzb);
            return null;
        }
    }

    public static final class zzd {
        private static final Map<Integer, String> zzbBc;
        private static final Map<Integer, String> zzbBd;

        static {
            Map hashMap = new HashMap();
            hashMap.put(Integer.valueOf(1), "home");
            hashMap.put(Integer.valueOf(3), "other");
            hashMap.put(Integer.valueOf(2), "work");
            hashMap.put(Integer.valueOf(0), "custom");
            zzbBc = Collections.unmodifiableMap(hashMap);
            hashMap = new HashMap();
            hashMap.put(Integer.valueOf(0), "aim");
            hashMap.put(Integer.valueOf(-1), "custom");
            hashMap.put(Integer.valueOf(5), "googleTalk");
            hashMap.put(Integer.valueOf(6), "icq");
            hashMap.put(Integer.valueOf(7), "jabber");
            hashMap.put(Integer.valueOf(1), "msn");
            hashMap.put(Integer.valueOf(8), "netMeeting");
            hashMap.put(Integer.valueOf(4), "qq");
            hashMap.put(Integer.valueOf(3), "skype");
            hashMap.put(Integer.valueOf(2), "yahoo");
            zzbBd = Collections.unmodifiableMap(hashMap);
        }

        public static String zza(Context context, RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            return zzb == null ? null : Im.getTypeLabel(context.getResources(), zzb.intValue(), rawContactData.getData(2)).toString();
        }

        public static String zza(RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            if (zzb != null && zzbBc.containsKey(zzb)) {
                return (String) zzbBc.get(zzb);
            }
            zzo.zzI("ContactData", "Invalid IM Type: " + zzb);
            return null;
        }

        public static String zzc(Context context, RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 4);
            return zzb == null ? null : Im.getProtocolLabel(context.getResources(), zzb.intValue(), rawContactData.getData(5)).toString();
        }

        public static String zzi(RawContactData rawContactData) {
            return rawContactData.getData(0);
        }

        public static String zzl(RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 4);
            if (zzb != null && zzbBd.containsKey(zzb)) {
                return (String) zzbBd.get(zzb);
            }
            zzo.zzI("ContactData", "Invalid IM Protocol: " + zzb);
            return null;
        }
    }

    public static final class zze {
        @TargetApi(14)
        public static final String zzm(RawContactData rawContactData) {
            String str = null;
            String data = rawContactData.getData(13);
            if (data != null && zzr.zzsl()) {
                try {
                    str = ContentUris.withAppendedId(DisplayPhoto.CONTENT_URI, Long.valueOf(data).longValue()).toString();
                } catch (NumberFormatException e) {
                }
            }
            return str;
        }
    }

    public static final class zzf {
        public static final String zzn(RawContactData rawContactData) {
            return rawContactData.getData(0);
        }

        public static final String zzo(RawContactData rawContactData) {
            return rawContactData.getData(1);
        }

        @TargetApi(14)
        public static final String zzp(RawContactData rawContactData) {
            String str = null;
            String data = rawContactData.getData(2);
            if (data != null && zzr.zzsl()) {
                try {
                    str = ContentUris.withAppendedId(DisplayPhoto.CONTENT_URI, Long.valueOf(data).longValue()).toString();
                } catch (NumberFormatException e) {
                }
            }
            return str;
        }
    }

    public static final class zzg {
        public static final String zzq(RawContactData rawContactData) {
            return rawContactData.getData(0);
        }

        public static final String zzr(RawContactData rawContactData) {
            return rawContactData.getData(1);
        }

        public static final String zzs(RawContactData rawContactData) {
            return rawContactData.getData(2);
        }

        public static final String zzt(RawContactData rawContactData) {
            return rawContactData.getData(3);
        }

        public static final String zzu(RawContactData rawContactData) {
            return rawContactData.getData(4);
        }

        public static final String zzv(RawContactData rawContactData) {
            return rawContactData.getData(5);
        }

        public static final String zzw(RawContactData rawContactData) {
            return rawContactData.getData(6);
        }

        public static final String zzx(RawContactData rawContactData) {
            return rawContactData.getData(8);
        }
    }

    public static final class zzh {
        private static final Map<Integer, String> zzbBe;

        static {
            Map hashMap = new HashMap();
            hashMap.put(Integer.valueOf(1), "default");
            hashMap.put(Integer.valueOf(5), "initials");
            hashMap.put(Integer.valueOf(3), "maidenName");
            hashMap.put(Integer.valueOf(2), "otherName");
            hashMap.put(Integer.valueOf(4), "shortName");
            hashMap.put(Integer.valueOf(0), "custom");
            zzbBe = Collections.unmodifiableMap(hashMap);
        }

        public static String zza(RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            if (zzb != null && zzbBe.containsKey(zzb)) {
                return (String) zzbBe.get(zzb);
            }
            zzo.zzI("ContactData", "Invalid Nickname Type: " + zzb);
            return null;
        }

        public static final String zzo(RawContactData rawContactData) {
            return rawContactData.getData(0);
        }
    }

    public static final class zzi {
        public static final String zzy(RawContactData rawContactData) {
            return rawContactData.getData(0);
        }
    }

    public static final class zzj {
        private static final Map<Integer, String> zzbBf;

        static {
            Map hashMap = new HashMap();
            hashMap.put(Integer.valueOf(2), "other");
            hashMap.put(Integer.valueOf(1), "work");
            hashMap.put(Integer.valueOf(0), "custom");
            zzbBf = Collections.unmodifiableMap(hashMap);
        }

        public static final String zzA(RawContactData rawContactData) {
            return rawContactData.getData(4);
        }

        public static final String zzB(RawContactData rawContactData) {
            return rawContactData.getData(5);
        }

        public static final String zzC(RawContactData rawContactData) {
            return rawContactData.getData(6);
        }

        public static final String zzD(RawContactData rawContactData) {
            return rawContactData.getData(7);
        }

        public static final String zzE(RawContactData rawContactData) {
            return rawContactData.getData(8);
        }

        public static String zza(RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            if (zzb != null && zzbBf.containsKey(zzb)) {
                return (String) zzbBf.get(zzb);
            }
            zzo.zzI("ContactData", "Invalid Organization Type: " + zzb);
            return null;
        }

        public static final String zzo(RawContactData rawContactData) {
            return rawContactData.getData(0);
        }

        public static final String zzz(RawContactData rawContactData) {
            return rawContactData.getData(3);
        }
    }

    public static final class zzk {
        private static final Map<Integer, String> zzbBg;

        static {
            Map hashMap = new HashMap();
            hashMap.put(Integer.valueOf(19), "assistant");
            hashMap.put(Integer.valueOf(8), "callback");
            hashMap.put(Integer.valueOf(9), "car");
            hashMap.put(Integer.valueOf(10), "mainCompany");
            hashMap.put(Integer.valueOf(5), "homeFax");
            hashMap.put(Integer.valueOf(4), "workFax");
            hashMap.put(Integer.valueOf(1), "home");
            hashMap.put(Integer.valueOf(11), "isdn");
            hashMap.put(Integer.valueOf(12), "main");
            hashMap.put(Integer.valueOf(20), "mms");
            hashMap.put(Integer.valueOf(2), "mobile");
            hashMap.put(Integer.valueOf(7), "other");
            hashMap.put(Integer.valueOf(13), "otherFax");
            hashMap.put(Integer.valueOf(6), "pager");
            hashMap.put(Integer.valueOf(14), "radio");
            hashMap.put(Integer.valueOf(15), "telex");
            hashMap.put(Integer.valueOf(16), "ttytdd");
            hashMap.put(Integer.valueOf(3), "work");
            hashMap.put(Integer.valueOf(17), "workMobile");
            hashMap.put(Integer.valueOf(18), "workPager");
            hashMap.put(Integer.valueOf(0), "custom");
            zzbBg = Collections.unmodifiableMap(hashMap);
        }

        public static final String zzF(RawContactData rawContactData) {
            return rawContactData.getData(0);
        }

        public static String zza(Context context, RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            return zzb == null ? null : Phone.getTypeLabel(context.getResources(), zzb.intValue(), rawContactData.getData(2)).toString();
        }

        public static String zza(RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            if (zzb != null && zzbBg.containsKey(zzb)) {
                return (String) zzbBg.get(zzb);
            }
            zzo.zzI("ContactData", "Invalid Phone Type: " + zzb);
            return null;
        }
    }

    public static final class zzl {
        private static final Map<Integer, String> zzbBh;

        static {
            Map hashMap = new HashMap();
            hashMap.put(Integer.valueOf(1), "assistant");
            hashMap.put(Integer.valueOf(2), "brother");
            hashMap.put(Integer.valueOf(3), "child");
            hashMap.put(Integer.valueOf(4), "domesticPartner");
            hashMap.put(Integer.valueOf(5), "father");
            hashMap.put(Integer.valueOf(6), "friend");
            hashMap.put(Integer.valueOf(7), "manager");
            hashMap.put(Integer.valueOf(8), "mother");
            hashMap.put(Integer.valueOf(9), "parent");
            hashMap.put(Integer.valueOf(10), "partner");
            hashMap.put(Integer.valueOf(11), "referredBy");
            hashMap.put(Integer.valueOf(12), "relative");
            hashMap.put(Integer.valueOf(13), "sister");
            hashMap.put(Integer.valueOf(14), "spouse");
            hashMap.put(Integer.valueOf(0), "custom");
            zzbBh = Collections.unmodifiableMap(hashMap);
        }

        public static final String zzG(RawContactData rawContactData) {
            return rawContactData.getData(0);
        }

        @TargetApi(11)
        public static String zza(Context context, RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            return (zzb == null || !zzr.zzsi()) ? null : Relation.getTypeLabel(context.getResources(), zzb.intValue(), rawContactData.getData(2)).toString();
        }

        public static String zza(RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            if (zzb != null && zzbBh.containsKey(zzb)) {
                return (String) zzbBh.get(zzb);
            }
            zzo.zzI("ContactData", "Invalid Relation Type: " + zzb);
            return null;
        }
    }

    public static final class zzm {
        private static final Map<Integer, String> zzbBi;

        static {
            Map hashMap = new HashMap();
            hashMap.put(Integer.valueOf(2), "blog");
            hashMap.put(Integer.valueOf(6), "ftp");
            hashMap.put(Integer.valueOf(4), "home");
            hashMap.put(Integer.valueOf(1), "homePage");
            hashMap.put(Integer.valueOf(7), "other");
            hashMap.put(Integer.valueOf(3), Scopes.PROFILE);
            hashMap.put(Integer.valueOf(5), "work");
            hashMap.put(Integer.valueOf(0), "custom");
            zzbBi = Collections.unmodifiableMap(hashMap);
        }

        public static String zza(RawContactData rawContactData) {
            Integer zzb = zzc.zza(rawContactData, 1);
            if (zzb != null && zzbBi.containsKey(zzb)) {
                return (String) zzbBi.get(zzb);
            }
            zzo.zzI("ContactData", "Invalid Organization Type: " + zzb);
            return null;
        }

        public static final String zzm(RawContactData rawContactData) {
            return rawContactData.getData(0);
        }
    }

    private static Integer zza(RawContactData rawContactData, int i) {
        String data = rawContactData.getData(i);
        if (!TextUtils.isEmpty(data)) {
            try {
                return Integer.valueOf(Integer.parseInt(data));
            } catch (Throwable e) {
                zzo.zzb("ContactData", "Invalid ID: " + rawContactData.getMimeType() + "[" + i + "] = " + data, e);
            }
        }
        return null;
    }

    public static boolean zzfN(String str) {
        return str != null && str.startsWith("c:");
    }

    public static String zzfO(String str) {
        return !zzfN(str) ? null : str.substring("c:".length());
    }

    public static String zzfP(String str) {
        return "c:" + str;
    }

    public static Set<String> zzfQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptySet();
        }
        Set<String> hashSet = new HashSet();
        hashSet.add(str);
        return hashSet;
    }

    public static boolean zzfR(String str) {
        return str != null && str.startsWith("f:");
    }

    public static boolean zzfS(String str) {
        return str != null && str.startsWith("p:");
    }

    public static String zzfT(String str) {
        return !zzfR(str) ? null : str.substring("f:".length());
    }

    public static String zzfU(String str) {
        return "f:" + str;
    }

    public static String zzfV(String str) {
        return !zzfS(str) ? null : str.substring("p:".length());
    }
}

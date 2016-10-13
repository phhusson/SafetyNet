package com.google.android.gms.people.identity.internal;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.PhoneLookup;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.util.zzr;
import com.google.android.gms.internal.zztp;
import com.google.android.gms.internal.zztq;
import com.google.android.gms.internal.zzts;
import com.google.android.gms.people.identity.PersonFactory.ContactData;
import com.google.android.gms.people.identity.PersonFactory.ExternalContactData;
import com.google.android.gms.people.identity.PersonFactory.RawContactData;
import com.google.android.gms.people.internal.zzo;
import com.google.android.gms.people.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzb {

    public interface zza {
        void zza(Status status, ContactData[] contactDataArr);
    }

    private interface zzb {
        public static final String[] zzbAT = new String[]{"contact_id"};
    }

    private static class zzc implements Runnable {
        private static final String[] zzbAU;
        private final Context mContext;
        private final zza zzbAV;
        private final String zzbAW;
        private final Set<String>[] zzbAX;

        static {
            ArrayList arrayList = new ArrayList();
            arrayList.add("data_id");
            arrayList.add("mimetype");
            arrayList.add("data1");
            arrayList.add("data2");
            arrayList.add("data3");
            arrayList.add("data4");
            arrayList.add("data5");
            arrayList.add("data6");
            arrayList.add("data7");
            arrayList.add("data8");
            arrayList.add("data9");
            arrayList.add("data10");
            arrayList.add("data11");
            arrayList.add("data12");
            arrayList.add("data13");
            arrayList.add("data14");
            arrayList.add("data15");
            arrayList.add("is_primary");
            arrayList.add("contact_id");
            arrayList.add("account_type");
            if (zzr.zzsl()) {
                arrayList.add("data_set");
            }
            if (zzr.zzsr()) {
                arrayList.add("times_used");
            }
            zzbAU = (String[]) arrayList.toArray(new String[0]);
        }

        public zzc(zza com_google_android_gms_people_identity_internal_zzb_zza, Context context, String str, Set<String>[] setArr) {
            this.zzbAV = com_google_android_gms_people_identity_internal_zzb_zza;
            this.mContext = context;
            this.zzbAW = str;
            this.zzbAX = setArr;
        }

        private ContactData zza(Set<String> set, List<zztp> list) {
            List arrayList = new ArrayList();
            if (set != null) {
                for (String zza : set) {
                    zza(arrayList, zza, list);
                }
            }
            return arrayList.isEmpty() ? null : new ContactData(arrayList);
        }

        private ExternalContactData zza(List<zztp> list, String str, String str2, String str3, Cursor cursor) {
            for (zztp com_google_android_gms_internal_zztp : list) {
                if (zzw.equal(com_google_android_gms_internal_zztp.accountType, str2) && zzw.equal(com_google_android_gms_internal_zztp.zzbAt, str3)) {
                    zzts zzfJ = com_google_android_gms_internal_zztp.zzfJ(str);
                    if (zzfJ != null) {
                        return new ExternalContactData(ContentUris.withAppendedId(Data.CONTENT_URI, cursor.getLong(0)), cursor.getString(cursor.getColumnIndex(zzfJ.zzbAR)), com_google_android_gms_internal_zztp.iconRes, cursor.getString(cursor.getColumnIndex(zzfJ.zzbAS)), zzfJ.zzbAu, zzfJ.mimeType, com_google_android_gms_internal_zztp.titleRes, com_google_android_gms_internal_zztp.accountType);
                    }
                }
            }
            return null;
        }

        @TargetApi(14)
        private static String zza(int i, Cursor cursor) {
            if (zzr.zzsl()) {
                if (cursor.getType(i) == 0) {
                    return null;
                }
                if (cursor.getType(i) == 4) {
                    return new String(cursor.getBlob(i));
                }
            } else if (cursor.isNull(i)) {
                return null;
            } else {
                try {
                    if (cursor.getBlob(i) != null) {
                        return null;
                    }
                } catch (Exception e) {
                }
            }
            return cursor.getString(i);
        }

        @RequiresPermission("android.permission.READ_CONTACTS")
        private void zza(List<RawContactData> list, String str, List<zztp> list2) {
            if (zzr.zzsi()) {
                Cursor query = this.mContext.getContentResolver().query(Contacts.CONTENT_URI.buildUpon().appendEncodedPath(str).appendEncodedPath("entities").build(), zzbAU, null, null, null);
                if (query != null) {
                    while (query.moveToNext()) {
                        try {
                            String string = query.getString(0);
                            if (string != null) {
                                String string2 = query.getString(1);
                                String[] strArr = new String[15];
                                int i = 0;
                                int i2 = 2;
                                while (i2 <= 16) {
                                    int i3 = i + 1;
                                    strArr[i] = zza(i2, query);
                                    i2++;
                                    i = i3;
                                }
                                list.add(new RawContactData(str, str, string2, zzr.zzsr() ? query.getInt(21) : zzfM(string), strArr, false, query.getInt(17) == 1, zza(list2, string2, query.getString(19), zzr.zzsl() ? query.getString(20) : null, query)));
                            }
                        } finally {
                            try {
                                query.close();
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
        }

        @TargetApi(18)
        @RequiresPermission("android.permission.READ_CONTACTS")
        private int zzfM(String str) {
            if (!zzr.zzso()) {
                return 0;
            }
            Uri withAppendedId = ContentUris.withAppendedId(Data.CONTENT_URI, Long.parseLong(str));
            Cursor query = this.mContext.getContentResolver().query(withAppendedId, new String[]{"times_used"}, null, null, null);
            if (query == null) {
                zzo.zzI("ContactsDataLoader", "null getTimesUsed cursor");
                return 0;
            }
            try {
                if (query.moveToFirst()) {
                    int i = query.getInt(0);
                    return i;
                }
                query.close();
                return 0;
            } finally {
                query.close();
            }
        }

        @RequiresPermission("android.permission.READ_CONTACTS")
        public void run() {
            List zzGl = zztq.zzaT(this.mContext).zzGl();
            ContactData[] contactDataArr = new ContactData[this.zzbAX.length];
            int i = 0;
            while (i < contactDataArr.length) {
                try {
                    Set hashSet = new HashSet();
                    for (String str : this.zzbAX[i]) {
                        if (zzp.zzhT(str)) {
                            hashSet.addAll(zzb.zzs(this.mContext, zzp.zzhR(str)));
                        } else if (zzp.zzhU(str)) {
                            hashSet.addAll(zzb.zzfK(zzp.zzhP(str)));
                        } else if (zzc.zzfS(str)) {
                            hashSet.addAll(zzb.zzt(this.mContext, zzc.zzfV(str)));
                        } else if (zzc.zzfR(str)) {
                            hashSet.addAll(zzb.zzj(this.mContext, this.zzbAW, zzc.zzfT(str)));
                        } else if (zzc.zzfN(str)) {
                            hashSet.addAll(zzc.zzfQ(zzc.zzfO(str)));
                        } else if (zzp.zzhV(str)) {
                            zzo.zzI("ContactsDataLoader", "Unknown qualified ID type");
                        } else {
                            zzo.zzI("ContactsDataLoader", "Invalid qualified ID");
                        }
                    }
                    contactDataArr[i] = zza(hashSet, zzGl);
                    i++;
                } catch (Throwable e) {
                    zzo.zzc("ContactsDataLoader", "Error querying contact data:", e);
                } finally {
                    this.zzbAV.zza(Status.zzaqL, contactDataArr);
                }
            }
        }
    }

    private static class zzd implements Runnable {
        private final Context mContext;
        private final zza zzbAV;
        private final String zzbAW;
        private final Set<String> zzbAY;

        private interface zza {
            public static final String[] zzbAT = new String[]{"_id", "display_name", "photo_id"};
        }

        public zzd(zza com_google_android_gms_people_identity_internal_zzb_zza, Context context, String str, Set<String> set) {
            this.zzbAV = com_google_android_gms_people_identity_internal_zzb_zza;
            this.mContext = context;
            this.zzbAW = str;
            this.zzbAY = set;
        }

        @RequiresPermission("android.permission.READ_CONTACTS")
        public void run() {
            ArrayList arrayList = new ArrayList();
            Set hashSet = new HashSet();
            for (String str : this.zzbAY) {
                if (zzp.zzhT(str)) {
                    hashSet.addAll(zzb.zzs(this.mContext, zzp.zzhR(str)));
                } else if (zzp.zzhU(str)) {
                    hashSet.addAll(zzb.zzfK(zzp.zzhP(str)));
                } else {
                    try {
                        if (zzc.zzfS(str)) {
                            hashSet.addAll(zzb.zzt(this.mContext, zzc.zzfV(str)));
                        } else if (zzc.zzfR(str)) {
                            hashSet.addAll(zzb.zzj(this.mContext, this.zzbAW, zzc.zzfT(str)));
                        } else if (zzc.zzfN(str)) {
                            hashSet.addAll(zzc.zzfQ(zzc.zzfO(str)));
                        } else if (zzp.zzhV(str)) {
                            zzo.zzI("ContactsDataLoader", "Unknown qualified ID type");
                        } else {
                            zzo.zzI("ContactsDataLoader", "Invalid qualified ID");
                        }
                    } catch (Throwable e) {
                        zzo.zzc("ContactsDataLoader", "Error querying contact data:", e);
                        this.zzbAV.zza(Status.zzaqL, (ContactData[]) arrayList.toArray(new ContactData[arrayList.size()]));
                        return;
                    } catch (Throwable e2) {
                        Throwable th = e2;
                        this.zzbAV.zza(Status.zzaqL, (ContactData[]) arrayList.toArray(new ContactData[arrayList.size()]));
                    }
                }
            }
            Cursor query = this.mContext.getContentResolver().query(Contacts.CONTENT_URI, zza.zzbAT, null, null, null);
            query.move(-1);
            while (query.moveToNext()) {
                if (!hashSet.contains(query.getString(0))) {
                    String[] strArr = new String[zza.zzbAT.length];
                    for (int i = 0; i < zza.zzbAT.length; i++) {
                        strArr[i] = query.getString(i);
                    }
                    arrayList.add(new ContactData(new RawContactData(query.getString(0), null, null, 0, strArr, true, true, null)));
                }
            }
            query.close();
            this.zzbAV.zza(Status.zzaqL, (ContactData[]) arrayList.toArray(new ContactData[arrayList.size()]));
        }
    }

    private interface zze {
        public static final String[] zzbAT = new String[]{"_id"};
    }

    public static void zza(zza com_google_android_gms_people_identity_internal_zzb_zza, Context context, String str, Set<String> set) {
        new Thread(new zzd(com_google_android_gms_people_identity_internal_zzb_zza, context, str, set)).start();
    }

    public static void zza(zza com_google_android_gms_people_identity_internal_zzb_zza, Context context, String str, Set<String>[] setArr) {
        new Thread(new zzc(com_google_android_gms_people_identity_internal_zzb_zza, context, str, setArr)).start();
    }

    private static Set<String> zzfK(String str) {
        return Collections.emptySet();
    }

    private static Set<String> zzj(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            zzo.zzI("ContactsDataLoader", "empty focus ID");
            return Collections.emptySet();
        }
        long zzg = com.google.android.gms.people.cp2.zza.zzg(context, str, str2);
        return zzg >= 0 ? Collections.singleton(String.valueOf(zzg)) : Collections.emptySet();
    }

    @RequiresPermission("android.permission.READ_CONTACTS")
    private static Set<String> zzs(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            zzo.zzI("ContactsDataLoader", "empty email address");
            return Collections.emptySet();
        }
        Cursor query = context.getContentResolver().query(Uri.withAppendedPath(Email.CONTENT_LOOKUP_URI, Uri.encode(str)), zzb.zzbAT, null, null, null);
        if (query == null) {
            zzo.zzI("ContactsDataLoader", "null retrieveContactsFromEmailId cursor");
            return Collections.emptySet();
        }
        try {
            Set<String> hashSet = new HashSet();
            while (query.moveToNext()) {
                hashSet.add(query.getString(0));
            }
            return hashSet;
        } finally {
            query.close();
        }
    }

    @RequiresPermission("android.permission.READ_CONTACTS")
    private static Set<String> zzt(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            zzo.zzI("ContactsDataLoader", "empty phone number");
            return Collections.emptySet();
        }
        Cursor query = context.getContentResolver().query(Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), zze.zzbAT, null, null, null);
        if (query == null) {
            zzo.zzI("ContactsDataLoader", "null retrieveContactsFromPhoneNumberId cursor");
            return Collections.emptySet();
        }
        try {
            Set<String> hashSet = new HashSet();
            while (query.moveToNext()) {
                hashSet.add(query.getString(0));
            }
            return hashSet;
        } finally {
            query.close();
        }
    }
}

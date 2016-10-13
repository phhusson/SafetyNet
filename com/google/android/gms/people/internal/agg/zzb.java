package com.google.android.gms.people.internal.agg;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.Groups;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.people.internal.zzo;
import com.google.android.gms.people.internal.zzs;

public final class zzb {
    public static final String[] zzbFC = new String[]{"contact_id", "display_name", "mimetype", "data1", "data2", "data3"};
    private static boolean zzbFD = false;
    private static boolean zzbFE = false;

    public interface zza {
        public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI, "filter");
        public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI, "contactables");
    }

    public static final String zzJJ() {
        return VERSION.SDK_INT < 14 ? null : "((data_set IS NULL) OR (account_type='com.google' AND data_set!='plus'))";
    }

    public static final void zza(zzs com_google_android_gms_people_internal_zzs) {
        com_google_android_gms_people_internal_zzs.zzhY("(mimetype IN ('vnd.android.cursor.item/email_v2','vnd.android.cursor.item/phone_v2'))");
    }

    public static final void zza(zzs com_google_android_gms_people_internal_zzs, boolean z, Context context) {
        if (!z) {
            if (VERSION.SDK_INT < 11) {
                com_google_android_gms_people_internal_zzs.zzhY("(in_visible_group=1)");
            } else if (zzaV(context)) {
                com_google_android_gms_people_internal_zzs.zzhY("(contact_id IN (SELECT _id FROM default_directory))");
            }
        }
        Object zzJJ = zzJJ();
        if (!TextUtils.isEmpty(zzJJ)) {
            com_google_android_gms_people_internal_zzs.zzhY(zzJJ);
        }
    }

    private static final synchronized boolean zzaV(Context context) {
        boolean z;
        Exception e;
        Throwable th;
        synchronized (zzb.class) {
            if (zzbFE) {
                z = zzbFD;
            } else {
                zzbFE = true;
                Cursor query;
                try {
                    query = context.getContentResolver().query(Groups.CONTENT_URI, null, "EXISTS (SELECT _id FROM default_directory LIMIT 1)", null, null);
                    if (query != null) {
                        try {
                            zzbFD = true;
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                zzo.zzI("PeopleAggregator", "Error occurred when checking for default_directory table.");
                                zzo.zzG("PeopleAggregator", e.getMessage());
                                if (query != null) {
                                    query.close();
                                }
                                z = zzbFD;
                                return z;
                            } catch (Throwable th2) {
                                th = th2;
                                if (query != null) {
                                    query.close();
                                }
                                throw th;
                            }
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e3) {
                    e = e3;
                    query = null;
                    zzo.zzI("PeopleAggregator", "Error occurred when checking for default_directory table.");
                    zzo.zzG("PeopleAggregator", e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    z = zzbFD;
                    return z;
                } catch (Throwable th3) {
                    th = th3;
                    query = null;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
                z = zzbFD;
            }
        }
        return z;
    }

    public static boolean zzb(Cursor cursor) {
        if (cursor.isAfterLast()) {
            return false;
        }
        long j = cursor.getLong(0);
        while (cursor.moveToNext()) {
            if (j != cursor.getLong(0)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zzc(Cursor cursor) {
        boolean z = true;
        zzx.zzae(!cursor.isBeforeFirst());
        if (cursor.isAfterLast()) {
            return false;
        }
        long j = cursor.getLong(0);
        if (!cursor.moveToNext()) {
            return false;
        }
        if (j != cursor.getLong(0)) {
            z = false;
        }
        return z;
    }
}

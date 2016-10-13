package com.google.android.gms.people.cp2;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import com.google.android.gms.people.internal.zzo;
import com.google.android.gms.people.internal.zzp;

public class zza {
    private static final String[] zzbzN = new String[]{"_id"};
    private static final String[] zzbzO = new String[]{"contact_id"};
    private static final String[] zzbzP = new String[]{"lookup"};
    private static final String[] zzbzQ = new String[]{"photo_uri"};
    static final String[] zzbzR = new String[]{"photo_id"};
    static final String[] zzbzS = new String[]{"data15"};

    public static Uri getContactLookupUriFromAndroidContactId(Context context, long contactId) {
        String zza = zza(context, contactId, zzbzP);
        return zza == null ? null : Contacts.CONTENT_LOOKUP_URI.buildUpon().appendPath(zza).appendPath(String.valueOf(contactId)).build();
    }

    private static long zza(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        String zzhW = zzp.zzhW(str2);
        Cursor query = context.getContentResolver().query(RawContacts.CONTENT_URI, strArr, VERSION.SDK_INT >= 15 ? "account_name=?1 AND account_type='com.google' AND sourceid=?2 AND data_set IS NULL" : "account_name=?1 AND account_type='com.google' AND sourceid=?2", zzp.zzal(str, zzhW), null);
        if (query == null) {
            zzo.zzI(AndroidContactsUtils.TAG, "Contacts query failed.");
            return -1;
        }
        try {
            if (query.moveToFirst()) {
                long j = (long) query.getInt(0);
                return j;
            }
            query.close();
            zzo.zzG(AndroidContactsUtils.TAG, "Raw contact not found.");
            return -1;
        } finally {
            query.close();
        }
    }

    private static String zza(Context context, long j, String[] strArr) {
        if (j < 0) {
            return null;
        }
        Cursor query = context.getContentResolver().query(ContentUris.withAppendedId(Contacts.CONTENT_URI, j), strArr, null, null, null);
        if (query == null) {
            zzo.zzI(AndroidContactsUtils.TAG, "Contacts query failed.");
            return null;
        }
        try {
            if (query.moveToFirst()) {
                CharSequence string = query.getString(0);
                if (TextUtils.isEmpty(string)) {
                    zzo.zzG(AndroidContactsUtils.TAG, "Contacts query with projection = " + strArr.toString() + " not found.");
                    return null;
                }
                query.close();
                return string;
            }
            query.close();
            zzo.zzG(AndroidContactsUtils.TAG, "Contact not found.");
            return null;
        } finally {
            query.close();
        }
    }

    private static long zzb(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (VERSION.SDK_INT < 15) {
            return -1;
        }
        String[] zzal = zzp.zzal(str, zzp.zzhQ(str2));
        Cursor query = context.getContentResolver().query(RawContacts.CONTENT_URI, strArr, "account_name=?1 AND account_type='com.google' AND sourceid=?2 AND data_set IS 'plus'", zzal, null);
        if (query == null) {
            zzo.zzI(AndroidContactsUtils.TAG, "Contacts query failed.");
            return -1;
        }
        try {
            if (query.moveToFirst()) {
                long j = (long) query.getInt(0);
                return j;
            }
            query.close();
            zzo.zzG(AndroidContactsUtils.TAG, "Raw contact not found.");
            return -1;
        } finally {
            query.close();
        }
    }

    public static long zzg(Context context, String str, String str2) {
        return zza(context, str, str2, zzbzO);
    }

    public static long zzh(Context context, String str, String str2) {
        return zzb(context, str, str2, zzbzO);
    }

    public static String zzi(Context context, String str, String str2) {
        return zza(context, zzg(context, str, str2), zzbzQ);
    }
}

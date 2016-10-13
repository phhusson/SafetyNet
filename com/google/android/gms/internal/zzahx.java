package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class zzahx {
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri zzcpG = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzcpH = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzcpI = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static HashMap<String, String> zzcpJ;
    private static Object zzcpK;
    private static String[] zzcpL = new String[0];
    private static Context zzcpM = null;

    public static int getInt(ContentResolver cr, String key, int defValue) {
        String string = getString(cr, key);
        if (string != null) {
            try {
                defValue = Integer.parseInt(string);
            } catch (NumberFormatException e) {
            }
        }
        return defValue;
    }

    public static long getLong(ContentResolver cr, String key, long defValue) {
        String string = getString(cr, key);
        if (string != null) {
            try {
                defValue = Long.parseLong(string);
            } catch (NumberFormatException e) {
            }
        }
        return defValue;
    }

    public static String getString(ContentResolver cr, String key) {
        return zza(cr, key, null);
    }

    private static void zzQN() {
        if (zzcpM != null) {
            zzcpM.enforceCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES", "attempting to read gservices without permission");
        }
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        zzQN();
        synchronized (zzahx.class) {
            zza(contentResolver);
            Object obj = zzcpK;
            String str3;
            if (zzcpJ.containsKey(str)) {
                str3 = (String) zzcpJ.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            } else {
                for (String startsWith : zzcpL) {
                    if (str.startsWith(startsWith)) {
                        break;
                    }
                }
                Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str3 = query.getString(1);
                            synchronized (zzahx.class) {
                                if (obj == zzcpK) {
                                    zzcpJ.put(str, str3);
                                }
                            }
                            if (str3 != null) {
                                str2 = str3;
                            }
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                    }
                }
                zzcpJ.put(str, null);
                if (query != null) {
                    query.close();
                }
            }
        }
        return str2;
    }

    public static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        zzQN();
        Cursor query = contentResolver.query(zzcpG, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return treeMap;
    }

    private static void zza(final ContentResolver contentResolver) {
        if (zzcpJ == null) {
            zzcpJ = new HashMap();
            zzcpK = new Object();
            new Thread("Gservices") {
                public void run() {
                    Looper.prepare();
                    contentResolver.registerContentObserver(zzahx.CONTENT_URI, true, new ContentObserver(this, new Handler(Looper.myLooper())) {
                        final /* synthetic */ C04811 zzcpO;

                        public void onChange(boolean selfChange) {
                            synchronized (zzahx.class) {
                                zzahx.zzcpJ.clear();
                                zzahx.zzcpK = new Object();
                                if (zzahx.zzcpL.length > 0) {
                                    zzahx.zzb(contentResolver, zzahx.zzcpL);
                                }
                            }
                        }
                    });
                    Looper.loop();
                }
            }.start();
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object string = getString(contentResolver, str);
        if (string == null || string.equals("")) {
            return z;
        }
        if (zzcpH.matcher(string).matches()) {
            return true;
        }
        if (zzcpI.matcher(string).matches()) {
            return false;
        }
        Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + string + "\") as boolean");
        return z;
    }

    public static void zzb(ContentResolver contentResolver, String... strArr) {
        zzQN();
        Map zza = zza(contentResolver, strArr);
        synchronized (zzahx.class) {
            zza(contentResolver);
            zzcpL = strArr;
            for (Entry entry : zza.entrySet()) {
                zzcpJ.put(entry.getKey(), entry.getValue());
            }
        }
    }
}

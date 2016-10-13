package com.google.android.gms.people.cp2;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.people.model.AggregatedPerson;
import com.google.android.gms.people.model.AutocompleteEntry;
import java.util.Iterator;

public class AndroidContactsUtils {
    public static final String TAG = "PeopleCp2Helper";

    private AndroidContactsUtils() {
    }

    public static Uri getContactLookupUri(Context context, AggregatedPerson item) {
        try {
            Long zza = zza(item);
            if (zza != null) {
                return getContactLookupUriFromAndroidContactId(context, zza.longValue());
            }
            if (item.getGaiaId() != null) {
                return getContactLookupUriFromGaiaId(context, item.getOwnerAccountName(), item.getGaiaId());
            }
            return null;
        } catch (SecurityException e) {
        }
    }

    @RequiresPermission("android.permission.READ_CONTACTS")
    public static Uri getContactLookupUri(Context context, AutocompleteEntry item) {
        try {
            if (item.getAndroidContactId() > 0) {
                return getContactLookupUriFromAndroidContactId(context, item.getAndroidContactId());
            }
            if (item.getFocusContactId() != null) {
                return getContactLookupUriFromFocusContactId(context, item.getOwnerAccountName(), item.getFocusContactId());
            }
            if (item.getGaiaId() != null) {
                return getContactLookupUriFromGaiaId(context, item.getOwnerAccountName(), item.getGaiaId());
            }
            return null;
        } catch (SecurityException e) {
        }
    }

    @RequiresPermission("android.permission.READ_CONTACTS")
    public static Uri getContactLookupUriFromAndroidContactId(Context context, long contactId) {
        try {
            return zza.getContactLookupUriFromAndroidContactId(context, contactId);
        } catch (SecurityException e) {
            return null;
        }
    }

    @RequiresPermission("android.permission.READ_CONTACTS")
    public static Uri getContactLookupUriFromFocusContactId(Context context, String account, String focusId) {
        try {
            return zza.getContactLookupUriFromAndroidContactId(context, zza.zzg(context, account, focusId));
        } catch (SecurityException e) {
            return null;
        }
    }

    @RequiresPermission("android.permission.READ_CONTACTS")
    public static Uri getContactLookupUriFromGaiaId(Context context, String account, String gaiaId) {
        try {
            return zza.getContactLookupUriFromAndroidContactId(context, zza.zzh(context, account, gaiaId));
        } catch (SecurityException e) {
            return null;
        }
    }

    @RequiresPermission("android.permission.READ_CONTACTS")
    public static String getPhotoUriFromFocusContactId(Context context, String account, String focusId) {
        try {
            return zza.zzi(context, account, focusId);
        } catch (SecurityException e) {
            return null;
        }
    }

    private static Long zza(AggregatedPerson aggregatedPerson) {
        Iterable contactIds = aggregatedPerson.getContactIds();
        if (contactIds == null) {
            return null;
        }
        Iterator it = contactIds.iterator();
        return it.hasNext() ? (Long) it.next() : null;
    }
}

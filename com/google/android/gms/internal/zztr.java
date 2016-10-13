package com.google.android.gms.internal;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncAdapterType;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class zztr extends zztq {
    private final Context mContext;
    private final AccountManager zzbAQ = AccountManager.get(this.mContext);

    public zztr(Context context) {
        this.mContext = context;
    }

    private static AuthenticatorDescription zza(AuthenticatorDescription[] authenticatorDescriptionArr, String str) {
        for (AuthenticatorDescription authenticatorDescription : authenticatorDescriptionArr) {
            if (str.equals(authenticatorDescription.type)) {
                return authenticatorDescription;
            }
        }
        return null;
    }

    public List<zztp> zzGl() {
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        List<zztp> arrayList = new ArrayList();
        Set<String> hashSet = new HashSet();
        AccountManager accountManager = this.zzbAQ;
        SyncAdapterType[] syncAdapterTypes = ContentResolver.getSyncAdapterTypes();
        AuthenticatorDescription[] authenticatorTypes = accountManager.getAuthenticatorTypes();
        for (SyncAdapterType syncAdapterType : syncAdapterTypes) {
            if ("com.android.contacts".equals(syncAdapterType.authority)) {
                String str = syncAdapterType.accountType;
                AuthenticatorDescription zza = zza(authenticatorTypes, str);
                if (zza == null) {
                    Log.w("ExAccountTypeManager", "No authenticator found for type=" + str + ", ignoring it.");
                } else {
                    Log.d("ExAccountTypeManager", "Registering external account type=" + str + ", resourcePackageName=" + zza.packageName);
                    zztp com_google_android_gms_internal_zztp = new zztp(this.mContext, zza.packageName, false);
                    if (com_google_android_gms_internal_zztp.isInitialized()) {
                        com_google_android_gms_internal_zztp.accountType = zza.type;
                        com_google_android_gms_internal_zztp.titleRes = zza.labelId;
                        com_google_android_gms_internal_zztp.iconRes = zza.iconId;
                        arrayList.add(com_google_android_gms_internal_zztp);
                        hashSet.addAll(com_google_android_gms_internal_zztp.zzGk());
                    }
                }
            }
        }
        if (!hashSet.isEmpty()) {
            Log.d("ExAccountTypeManager", "Registering " + hashSet.size() + " extension packages");
            for (String str2 : hashSet) {
                zztp com_google_android_gms_internal_zztp2 = new zztp(this.mContext, str2, true);
                if (com_google_android_gms_internal_zztp2.isInitialized()) {
                    if (!com_google_android_gms_internal_zztp2.zzGj()) {
                        Log.w("ExAccountTypeManager", "Skipping extension package " + str2 + " because" + " it doesn't have the CONTACTS_STRUCTURE metadata");
                    } else if (TextUtils.isEmpty(com_google_android_gms_internal_zztp2.accountType)) {
                        Log.w("ExAccountTypeManager", "Skipping extension package " + str2 + " because" + " the CONTACTS_STRUCTURE metadata doesn't have the accountType" + " attribute");
                    } else {
                        Log.d("ExAccountTypeManager", "Registering extension package account type=" + com_google_android_gms_internal_zztp2.accountType + ", dataSet=" + com_google_android_gms_internal_zztp2.zzbAt + ", packageName=" + str2);
                        arrayList.add(com_google_android_gms_internal_zztp2);
                    }
                }
            }
        }
        Log.i("ExAccountTypeManager", "Loaded meta-data for " + arrayList.size() + " account types in " + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms(wall) " + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis) + "ms(cpu)");
        return arrayList;
    }
}

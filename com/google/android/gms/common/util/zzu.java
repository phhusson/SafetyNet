package com.google.android.gms.common.util;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import java.util.Set;

public final class zzu {
    public static String[] zzb(Scope[] scopeArr) {
        zzx.zzb((Object) scopeArr, (Object) "scopes can't be null.");
        String[] strArr = new String[scopeArr.length];
        for (int i = 0; i < scopeArr.length; i++) {
            strArr[i] = scopeArr[i].zzpq();
        }
        return strArr;
    }

    public static String[] zzd(Set<Scope> set) {
        zzx.zzb((Object) set, (Object) "scopes can't be null.");
        return zzb((Scope[]) set.toArray(new Scope[set.size()]));
    }
}

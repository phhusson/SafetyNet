package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzxj;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzf {
    private final Account zzSX;
    private final String zzVx;
    private final Set<Scope> zzaqr;
    private final int zzaqt;
    private final View zzaqu;
    private final String zzaqv;
    private final Set<Scope> zzavN;
    private final Map<Api<?>, zza> zzavO;
    private final zzxj zzavP;
    private Integer zzavQ;

    public static final class zza {
        public final Set<Scope> zzYO;
        public final boolean zzavR;

        public zza(Set<Scope> set, boolean z) {
            zzx.zzD(set);
            this.zzYO = Collections.unmodifiableSet(set);
            this.zzavR = z;
        }
    }

    public zzf(Account account, Set<Scope> set, Map<Api<?>, zza> map, int i, View view, String str, String str2, zzxj com_google_android_gms_internal_zzxj) {
        Map map2;
        this.zzSX = account;
        this.zzaqr = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.zzavO = map2;
        this.zzaqu = view;
        this.zzaqt = i;
        this.zzVx = str;
        this.zzaqv = str2;
        this.zzavP = com_google_android_gms_internal_zzxj;
        Set hashSet = new HashSet(this.zzaqr);
        for (zza com_google_android_gms_common_internal_zzf_zza : this.zzavO.values()) {
            hashSet.addAll(com_google_android_gms_common_internal_zzf_zza.zzYO);
        }
        this.zzavN = Collections.unmodifiableSet(hashSet);
    }

    public static zzf zzau(Context context) {
        return new Builder(context).zzpn();
    }

    public Account getAccount() {
        return this.zzSX;
    }

    @Deprecated
    public String getAccountName() {
        return this.zzSX != null ? this.zzSX.name : null;
    }

    public Set<Scope> zzb(Api<?> api) {
        zza com_google_android_gms_common_internal_zzf_zza = (zza) this.zzavO.get(api);
        if (com_google_android_gms_common_internal_zzf_zza == null || com_google_android_gms_common_internal_zzf_zza.zzYO.isEmpty()) {
            return this.zzaqr;
        }
        Set<Scope> hashSet = new HashSet(this.zzaqr);
        hashSet.addAll(com_google_android_gms_common_internal_zzf_zza.zzYO);
        return hashSet;
    }

    public void zzb(Integer num) {
        this.zzavQ = num;
    }

    public Account zzqK() {
        return this.zzSX != null ? this.zzSX : new Account("<<default account>>", "com.google");
    }

    public int zzqL() {
        return this.zzaqt;
    }

    public Set<Scope> zzqM() {
        return this.zzaqr;
    }

    public Set<Scope> zzqN() {
        return this.zzavN;
    }

    public Map<Api<?>, zza> zzqO() {
        return this.zzavO;
    }

    public String zzqP() {
        return this.zzVx;
    }

    public String zzqQ() {
        return this.zzaqv;
    }

    public View zzqR() {
        return this.zzaqu;
    }

    public zzxj zzqS() {
        return this.zzavP;
    }

    public Integer zzqT() {
        return this.zzavQ;
    }
}

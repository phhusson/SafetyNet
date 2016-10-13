package com.google.android.gms.people.internal.agg;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.people.PeopleConstants.Endpoints;
import com.google.android.gms.people.internal.zzh;
import com.google.android.gms.people.internal.zzo;
import com.google.android.gms.people.internal.zzt;
import com.google.android.gms.people.internal.zzu;
import com.google.android.gms.people.model.AggregatedPersonBuffer;
import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class zzd {
    static volatile boolean zzbFZ = true;
    protected final Context mContext;
    private final zzd zzbFP;
    protected final Bundle zzbFQ;
    protected final Bundle zzbFR;
    protected final boolean zzbFS;
    protected final zzt zzbFT;
    private boolean zzbFU;
    private ConnectionResult zzbFV;
    private DataHolder zzbFW;
    private boolean zzbFX;
    private Exception zzbFY;
    private DataHolder zzbFk;
    private Cursor zzbFl;
    private boolean zzbGa;
    private final Collator zzbGb = Collator.getInstance();
    protected final boolean zzbzn;
    protected final int zzbzq;
    protected final String zzbzr;
    private final Object zzqz = new Object();

    private class zza extends Thread {
        final /* synthetic */ zzd zzbGc;

        public zza(zzd com_google_android_gms_people_internal_agg_zzd) {
            this.zzbGc = com_google_android_gms_people_internal_agg_zzd;
            super("PeopleAggregator-aggregator");
        }

        public final void run() {
            try {
                this.zzbGc.zzJQ();
            } catch (Throwable e) {
                zzo.zzc("PeopleAggregator", "Unknown exception during aggregation", e);
                this.zzbGc.zzJO();
            }
        }
    }

    private class zzb extends Thread {
        final /* synthetic */ zzd zzbGc;

        public zzb(zzd com_google_android_gms_people_internal_agg_zzd) {
            this.zzbGc = com_google_android_gms_people_internal_agg_zzd;
            super("PeopleAggregator-contacts");
        }

        public final void run() {
            this.zzbGc.zzbFT.zzia("contacts query start");
            try {
                this.zzbGc.zza(this.zzbGc.zzJN(), null);
            } catch (Exception e) {
                zzo.zzc("PeopleAggregator", "Error while quering contacts", e);
                this.zzbGc.zza(null, e);
            }
        }
    }

    protected static class zzc {
        private int zzatF = -1;
        public final DataHolder zzbGd;
        private final int zzbhX;

        public zzc(DataHolder dataHolder) {
            this.zzbGd = dataHolder;
            this.zzbhX = dataHolder.getCount();
        }

        public int getCount() {
            return this.zzbhX;
        }

        public int getPosition() {
            return this.zzatF;
        }

        public String getString(String column) {
            return this.zzbGd.getString(column, this.zzatF, this.zzbGd.zzcZ(this.zzatF));
        }

        public boolean isAfterLast() {
            return this.zzatF >= this.zzbhX;
        }

        public boolean moveToNext() {
            this.zzatF++;
            return this.zzatF >= 0 && this.zzatF < this.zzbhX;
        }

        public void zzny(int i) {
            this.zzatF = i;
        }
    }

    public interface zzd {
        void zza(int i, Bundle bundle, AggregatedPersonBuffer aggregatedPersonBuffer);
    }

    protected zzd(Context context, zzd com_google_android_gms_people_internal_agg_zzd_zzd, boolean z, int i, Bundle bundle, Bundle bundle2, String str) {
        this.mContext = context;
        this.zzbFP = com_google_android_gms_people_internal_agg_zzd_zzd;
        this.zzbzn = z;
        this.zzbzq = i;
        this.zzbFQ = bundle;
        this.zzbFR = bundle2;
        this.zzbFS = !TextUtils.isEmpty(str);
        if (!this.zzbFS) {
            str = null;
        }
        this.zzbzr = str;
        this.zzbFT = zzo.zzJx() ? zzt.zzhZ("aggregator") : zzt.zzJC();
    }

    private void zzJM() {
        try {
            new zzb(this).start();
        } catch (Exception e) {
            zzo.zzc("PeopleAggregator", "Unable to start thread", e);
            zza(null, e);
        }
    }

    private void zzJO() {
        synchronized (this.zzqz) {
            zzx.zzae(this.zzbFU);
            zzx.zzae(this.zzbFX);
            if (this.zzbFk != null) {
                this.zzbFk.close();
            }
            if (this.zzbFW != null) {
                this.zzbFW.close();
            }
            if (this.zzbFl != null) {
                this.zzbFl.close();
            }
            if (this.zzbGa) {
                return;
            }
            this.zzbGa = true;
            this.zzbFP.zza(8, null, null);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzJP() {
        /*
        r3 = this;
        r1 = r3.zzqz;
        monitor-enter(r1);
        r0 = r3.zzbFU;	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r3.zzbFX;	 Catch:{ all -> 0x001a }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
    L_0x000c:
        return;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        r0 = r3.zzbFV;
        r0 = r0.isSuccess();
        if (r0 != 0) goto L_0x001d;
    L_0x0016:
        r3.zzJO();
        goto L_0x000c;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        throw r0;
    L_0x001d:
        r0 = new com.google.android.gms.people.internal.agg.zzd$zza;	 Catch:{ Exception -> 0x0026 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x0026 }
        r0.start();	 Catch:{ Exception -> 0x0026 }
        goto L_0x000c;
    L_0x0026:
        r0 = move-exception;
        r1 = "PeopleAggregator";
        r2 = "Unable to start thread";
        com.google.android.gms.people.internal.zzo.zzc(r1, r2, r0);
        r3.zzJO();
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.people.internal.agg.zzd.zzJP():void");
    }

    private void zzJQ() {
        zzx.zzae(this.zzbFV.isSuccess());
        this.zzbFT.zzia("agg start");
        AggregatedPersonBuffer zza = zza(new zzc(this.zzbFk), new zzc(this.zzbFW), this.zzbFl != null ? this.zzbFl : new MatrixCursor(zzb.zzbFC));
        this.zzbFT.zzia("agg finish");
        this.zzbFT.zzE("PeopleAggregator", 0);
        this.zzbFP.zza(0, null, zza);
    }

    public static zzd zza(Context context, zzd com_google_android_gms_people_internal_agg_zzd_zzd, boolean z, int i, Bundle bundle, Bundle bundle2, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return new zze(context, com_google_android_gms_people_internal_agg_zzd_zzd, z, i, bundle, bundle2, str2);
        }
        if (TextUtils.isEmpty(str2)) {
            return new zzf(context, com_google_android_gms_people_internal_agg_zzd_zzd, z, i, bundle, bundle2, str);
        }
        throw new IllegalArgumentException("Search aggregation doesn't support filtering by gaia-id");
    }

    protected static void zza(zzc com_google_android_gms_people_internal_agg_zzd_zzc, HashMap<String, Integer> hashMap) {
        com_google_android_gms_people_internal_agg_zzd_zzc.zzny(-1);
        while (com_google_android_gms_people_internal_agg_zzd_zzc.moveToNext()) {
            CharSequence string = com_google_android_gms_people_internal_agg_zzd_zzc.getString(Endpoints.KEY_TARGET_GAIA_ID);
            if (!TextUtils.isEmpty(string)) {
                hashMap.put(string, Integer.valueOf(com_google_android_gms_people_internal_agg_zzd_zzc.getPosition()));
            }
        }
    }

    public static void zzaT(boolean z) {
        zzbFZ = z;
    }

    protected DataHolder zzJK() {
        return this.zzbFW;
    }

    public void zzJL() {
        if (!this.zzbFS) {
            zzJM();
        }
    }

    protected abstract Cursor zzJN();

    protected int zza(Cursor cursor, zzu com_google_android_gms_people_internal_zzu, zzh com_google_android_gms_people_internal_zzh, HashMap<String, String> hashMap) {
        int i = -1;
        long j = -1;
        cursor.moveToPosition(-1);
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(6);
        int i2 = 0;
        while (cursor.moveToNext()) {
            int i3;
            long j2 = cursor.getLong(0);
            if (j2 != j) {
                arrayList.clear();
                arrayList2.clear();
                i3 = i2 + 1;
                i2 = cursor.getPosition();
                j = j2;
            } else {
                i3 = i2;
                i2 = i;
            }
            String string = cursor.getString(2);
            if ("vnd.android.cursor.item/email_v2".equals(string) || "vnd.android.cursor.item/phone_v2".equals(string)) {
                CharSequence string2 = cursor.getString(3);
                if (TextUtils.isEmpty(string2)) {
                    i = i2;
                    i2 = i3;
                } else if (arrayList2.contains(string2)) {
                    i = i2;
                    i2 = i3;
                } else {
                    arrayList2.add(string2);
                    string = (String) hashMap.get(string2);
                    if (!(TextUtils.isEmpty(string) || arrayList.contains(string))) {
                        arrayList.add(string);
                        com_google_android_gms_people_internal_zzu.put(string, i2);
                        com_google_android_gms_people_internal_zzh.zza(Integer.valueOf(i2), string);
                    }
                }
            }
            i = i2;
            i2 = i3;
        }
        return i2;
    }

    protected abstract zza zza(zzc com_google_android_gms_people_internal_agg_zzd_zzc, zzc com_google_android_gms_people_internal_agg_zzd_zzc2, Cursor cursor);

    void zza(Cursor cursor, Exception exception) {
        if (cursor != null) {
            this.zzbFT.zzia("contacts loaded");
        } else {
            this.zzbFT.zzia("contacts load failure");
        }
        if (zzo.zzJx()) {
            zzo.zzG("PeopleAggregator", "Contacts loaded.  exception=" + exception + "  size=" + (cursor == null ? -1 : cursor.getCount()));
        }
        synchronized (this.zzqz) {
            this.zzbFX = true;
            this.zzbFl = cursor;
            this.zzbFY = exception;
        }
        zzJP();
    }

    public void zza(ConnectionResult connectionResult, DataHolder[] dataHolderArr) {
        if (connectionResult.isSuccess()) {
            this.zzbFT.zzia("people loaded");
        } else {
            this.zzbFT.zzia("people load failure");
        }
        if (zzo.zzJx()) {
            String str = "PeopleAggregator";
            StringBuilder append = new StringBuilder().append("People loaded.  status=").append(connectionResult).append("  size=");
            int count = (dataHolderArr == null || dataHolderArr.length < 2 || dataHolderArr[0] == null) ? -1 : dataHolderArr[0].getCount();
            zzo.zzG(str, append.append(count).toString());
        }
        synchronized (this.zzqz) {
            this.zzbFU = true;
            this.zzbFV = connectionResult;
            if (this.zzbFV.isSuccess()) {
                this.zzbFk = dataHolderArr[0];
                this.zzbFW = dataHolderArr[1];
            }
        }
        if (!this.zzbFS) {
            zzJP();
        } else if (this.zzbFV.isSuccess()) {
            zzJM();
        } else {
            synchronized (this.zzqz) {
                this.zzbFX = true;
            }
            zzJO();
        }
    }

    protected int zzam(String str, String str2) {
        return TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) ? 0 : -1 : TextUtils.isEmpty(str2) ? 1 : this.zzbGb.compare(str, str2);
    }

    protected void zzb(zzc com_google_android_gms_people_internal_agg_zzd_zzc, HashMap<String, String> hashMap) {
        com_google_android_gms_people_internal_agg_zzd_zzc.zzny(-1);
        while (com_google_android_gms_people_internal_agg_zzd_zzc.moveToNext()) {
            hashMap.put(com_google_android_gms_people_internal_agg_zzd_zzc.getString("value"), com_google_android_gms_people_internal_agg_zzd_zzc.getString(Endpoints.KEY_TARGET_GAIA_ID));
        }
    }
}

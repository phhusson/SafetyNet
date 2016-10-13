package com.google.android.gms.people.internal.agg;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.MergeCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.people.PeopleConstants.Endpoints;
import com.google.android.gms.people.internal.agg.zzd.zzd;
import com.google.android.gms.people.internal.zzh;
import com.google.android.gms.people.internal.zzi;
import com.google.android.gms.people.internal.zzo;
import com.google.android.gms.people.internal.zzs;
import com.google.android.gms.people.internal.zzu;
import com.google.android.snet.Csv;
import java.util.ArrayList;
import java.util.HashMap;

class zzf extends zzd {
    public static final String[] zzbGf = new String[]{"contact_id"};
    private final String zzPe;

    private static class zza extends CursorWrapper {
        private int zzbGg;

        public zza(Cursor cursor, int i) {
            super(cursor);
            this.zzbGg = i;
        }

        public int getCount() {
            return Math.min(super.getCount(), this.zzbGg);
        }
    }

    public zzf(Context context, zzd com_google_android_gms_people_internal_agg_zzd_zzd, boolean z, int i, Bundle bundle, Bundle bundle2, String str) {
        super(context, com_google_android_gms_people_internal_agg_zzd_zzd, z, i, bundle, bundle2, null);
        this.zzPe = str;
    }

    private Cursor zzJT() {
        Cursor query = this.mContext.getContentResolver().query(Phone.CONTENT_FILTER_URI.buildUpon().appendPath(this.zzPe).appendQueryParameter("limit", Integer.toString(100)).build(), zzbGf, "(data1 IS NOT NULL AND data1!='')", null, null);
        Cursor query2 = this.mContext.getContentResolver().query(Email.CONTENT_FILTER_URI.buildUpon().appendPath(this.zzPe).appendQueryParameter("limit", Integer.toString(100)).build(), zzbGf, "(data1 IS NOT NULL AND data1!='')", null, null);
        zza com_google_android_gms_people_internal_agg_zzf_zza = new zza(query, 100);
        zza com_google_android_gms_people_internal_agg_zzf_zza2 = new zza(query2, 100);
        return new MergeCursor(new Cursor[]{com_google_android_gms_people_internal_agg_zzf_zza, com_google_android_gms_people_internal_agg_zzf_zza2});
    }

    protected Cursor zzJN() {
        boolean z = false;
        Cursor cursor = null;
        zzs com_google_android_gms_people_internal_zzs;
        if (!zzbFZ || VERSION.SDK_INT < 18) {
            com_google_android_gms_people_internal_zzs = new zzs();
            zzb.zza(com_google_android_gms_people_internal_zzs, this.zzbzn, this.mContext);
            zzb.zza(com_google_android_gms_people_internal_zzs);
            this.zzbFT.zzia("lookup start");
            Cursor zzJT = zzJT();
            if (zzJT != null) {
                try {
                    int count = zzJT.getCount();
                    this.zzbFT.zzia("lookup finish");
                    if (count != 0) {
                        com_google_android_gms_people_internal_zzs.zzhY("contact_id IN (");
                        String str = "";
                        while (zzJT.moveToNext()) {
                            com_google_android_gms_people_internal_zzs.zzhX(str);
                            com_google_android_gms_people_internal_zzs.zzhX(Long.toString(zzJT.getLong(0)));
                            str = Csv.COMMA;
                        }
                        com_google_android_gms_people_internal_zzs.zzhX(")");
                        zzJT.close();
                        cursor = this.mContext.getContentResolver().query(Data.CONTENT_URI, zzb.zzbFC, com_google_android_gms_people_internal_zzs.toString(), null, "display_name COLLATE LOCALIZED,contact_id");
                    }
                } finally {
                    zzJT.close();
                }
            }
            return cursor;
        }
        Builder appendPath = com.google.android.gms.people.internal.agg.zzb.zza.CONTENT_FILTER_URI.buildUpon().appendPath(this.zzPe);
        String str2 = "visible_contacts_only";
        if (!this.zzbzn) {
            z = true;
        }
        Uri build = appendPath.appendQueryParameter(str2, String.valueOf(z)).build();
        com_google_android_gms_people_internal_zzs = new zzs();
        com_google_android_gms_people_internal_zzs.zzhY(zzb.zzJJ());
        com_google_android_gms_people_internal_zzs.zzhY("(data1 IS NOT NULL AND data1!='')");
        cursor = this.mContext.getContentResolver().query(build, zzb.zzbFC, com_google_android_gms_people_internal_zzs.toString(), null, "display_name COLLATE LOCALIZED,contact_id");
        if (cursor != null) {
            cursor.getCount();
        }
        return cursor;
    }

    protected zza zza(zzc com_google_android_gms_people_internal_agg_zzd_zzc, zzc com_google_android_gms_people_internal_agg_zzd_zzc2, Cursor cursor) {
        zzx.zzD(com_google_android_gms_people_internal_agg_zzd_zzc);
        zzx.zzD(cursor);
        zzi com_google_android_gms_people_internal_zzi = new zzi();
        zzi com_google_android_gms_people_internal_zzi2 = new zzi();
        int count = com_google_android_gms_people_internal_agg_zzd_zzc.getCount();
        cursor.getCount();
        HashMap hashMap = new HashMap();
        this.zzbFT.zzia("people-map start");
        zzd.zza(com_google_android_gms_people_internal_agg_zzd_zzc, hashMap);
        this.zzbFT.zzia("people-map finish");
        zzu com_google_android_gms_people_internal_zzu = new zzu();
        zzh com_google_android_gms_people_internal_zzh = new zzh();
        HashMap hashMap2 = new HashMap();
        zzb(com_google_android_gms_people_internal_agg_zzd_zzc2, hashMap2);
        this.zzbFT.zzia("contact-map start");
        int zza = zza(cursor, com_google_android_gms_people_internal_zzu, com_google_android_gms_people_internal_zzh, hashMap2);
        this.zzbFT.zzia("contact-map finish");
        if (zzo.zzJx()) {
            zzo.zzG("PeopleAggregator", "#people=" + count + ", #contacts=" + zza);
        }
        this.zzbFT.zzia("merge start");
        ArrayList zzsf = zzb.zzsf();
        com_google_android_gms_people_internal_agg_zzd_zzc.zzny(-1);
        while (com_google_android_gms_people_internal_agg_zzd_zzc.moveToNext()) {
            count = com_google_android_gms_people_internal_agg_zzd_zzc.getPosition();
            String string = com_google_android_gms_people_internal_agg_zzd_zzc.getString(Endpoints.KEY_TARGET_GAIA_ID);
            com_google_android_gms_people_internal_zzi.zznv(count);
            zzsf.add(string);
            if (string == null || com_google_android_gms_people_internal_zzu.zzib(string) == 0) {
                com_google_android_gms_people_internal_zzi2.zzJl();
            } else {
                com_google_android_gms_people_internal_zzi2.zza(com_google_android_gms_people_internal_zzu, string);
            }
        }
        cursor.moveToPosition(0);
        while (!cursor.isAfterLast()) {
            int position = cursor.getPosition();
            int zznu = com_google_android_gms_people_internal_zzh.zznu(position);
            if (zznu == 0) {
                com_google_android_gms_people_internal_zzi.zzJl();
                com_google_android_gms_people_internal_zzi2.zznv(position);
                zzsf.add(null);
            } else {
                for (count = 0; count < zznu; count++) {
                    String zzI = com_google_android_gms_people_internal_zzh.zzI(position, count);
                    if (!hashMap.containsKey(zzI)) {
                        com_google_android_gms_people_internal_zzi.zzJl();
                        com_google_android_gms_people_internal_zzi2.zznv(position);
                        zzsf.add(zzI);
                    }
                }
            }
            zzb.zzb(cursor);
        }
        this.zzbFT.zzia("merge finish");
        return new zza(com_google_android_gms_people_internal_agg_zzd_zzc.zzbGd, cursor, this.mContext, com_google_android_gms_people_internal_zzi.size(), com_google_android_gms_people_internal_zzi, com_google_android_gms_people_internal_zzi2, zzsf, hashMap2, this.zzbzq, this.zzbFQ, this.zzbFR);
    }
}

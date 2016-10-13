package com.google.android.gms.people.internal.agg;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.ContactsContract.Data;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.people.PeopleConstants.ContactGroupPreferredFields;
import com.google.android.gms.people.PeopleConstants.Endpoints;
import com.google.android.gms.people.internal.agg.zzb.zza;
import com.google.android.gms.people.internal.agg.zzd.zzd;
import com.google.android.gms.people.internal.zzh;
import com.google.android.gms.people.internal.zzi;
import com.google.android.gms.people.internal.zzo;
import com.google.android.gms.people.internal.zzs;
import com.google.android.gms.people.internal.zzu;
import com.google.android.snet.Csv;
import java.util.ArrayList;
import java.util.HashMap;

class zze extends zzd {
    private static final String[] zzbGe = new String[]{"contact_id"};

    public zze(Context context, zzd com_google_android_gms_people_internal_agg_zzd_zzd, boolean z, int i, Bundle bundle, Bundle bundle2, String str) {
        super(context, com_google_android_gms_people_internal_agg_zzd_zzd, z, i, bundle, bundle2, str);
    }

    private String zzJR() {
        if (!this.zzbFS) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("contact_id IN(");
        Cursor query = this.mContext.getContentResolver().query(Data.CONTENT_URI, zzbGe, zzJS(), null, null);
        if (query == null) {
            return null;
        }
        Object obj = 1;
        while (query.moveToNext()) {
            try {
                if (obj == null) {
                    stringBuilder.append(Csv.COMMA);
                }
                stringBuilder.append(query.getLong(0));
                obj = null;
            } finally {
                query.close();
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private String zzJS() {
        zzx.zzad(this.zzbFS);
        DataHolder zzJK = zzJK();
        zzx.zzD(zzJK);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("data1 IN(");
        zzc com_google_android_gms_people_internal_agg_zzd_zzc = new zzc(zzJK);
        Object obj = 1;
        while (com_google_android_gms_people_internal_agg_zzd_zzc.moveToNext()) {
            if (obj == null) {
                stringBuilder.append(Csv.COMMA);
            }
            obj = null;
            DatabaseUtils.appendEscapedSQLString(stringBuilder, com_google_android_gms_people_internal_agg_zzd_zzc.getString("value"));
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    protected Cursor zzJN() {
        Cursor cursor = null;
        String zzJR = zzJR();
        if (zzJR != null) {
            zzs com_google_android_gms_people_internal_zzs;
            if (!zzbFZ || VERSION.SDK_INT < 18) {
                com_google_android_gms_people_internal_zzs = new zzs();
                zzb.zza(com_google_android_gms_people_internal_zzs, this.zzbzn, this.mContext);
                zzb.zza(com_google_android_gms_people_internal_zzs);
                com_google_android_gms_people_internal_zzs.zzhY(zzJR);
                com_google_android_gms_people_internal_zzs.zzhY("(data1 IS NOT NULL AND data1!='')");
                cursor = this.mContext.getContentResolver().query(Data.CONTENT_URI, zzb.zzbFC, com_google_android_gms_people_internal_zzs.toString(), null, "display_name COLLATE LOCALIZED,contact_id");
            } else {
                Uri build = zza.CONTENT_URI.buildUpon().appendQueryParameter("visible_contacts_only", String.valueOf(!this.zzbzn)).build();
                com_google_android_gms_people_internal_zzs = new zzs();
                com_google_android_gms_people_internal_zzs.zzhY(zzb.zzJJ());
                com_google_android_gms_people_internal_zzs.zzhY(zzJR);
                com_google_android_gms_people_internal_zzs.zzhY("(data1 IS NOT NULL AND data1!='')");
                cursor = this.mContext.getContentResolver().query(build, zzb.zzbFC, com_google_android_gms_people_internal_zzs.toString(), null, "display_name COLLATE LOCALIZED,contact_id");
            }
            if (cursor != null) {
                cursor.getCount();
            }
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
        com_google_android_gms_people_internal_agg_zzd_zzc.zzny(0);
        cursor.moveToPosition(0);
        ArrayList zzsf = zzb.zzsf();
        while (true) {
            Object obj = !com_google_android_gms_people_internal_agg_zzd_zzc.isAfterLast() ? 1 : null;
            Object obj2 = !cursor.isAfterLast() ? 1 : null;
            if (obj == null && obj2 == null) {
                this.zzbFT.zzia("merge finish");
                return new zza(com_google_android_gms_people_internal_agg_zzd_zzc.zzbGd, cursor, this.mContext, com_google_android_gms_people_internal_zzi.size(), com_google_android_gms_people_internal_zzi, com_google_android_gms_people_internal_zzi2, zzsf, hashMap2, this.zzbzq, this.zzbFQ, this.zzbFR);
            }
            count = (obj == null || obj2 == null) ? obj != null ? -1 : 1 : zzam(obj != null ? com_google_android_gms_people_internal_agg_zzd_zzc.getString(ContactGroupPreferredFields.NAME) : null, obj2 != null ? cursor.getString(1) : null);
            if (count <= 0) {
                zza = com_google_android_gms_people_internal_agg_zzd_zzc.getPosition();
                String string = com_google_android_gms_people_internal_agg_zzd_zzc.getString(Endpoints.KEY_TARGET_GAIA_ID);
                com_google_android_gms_people_internal_zzi.zznv(zza);
                zzsf.add(string);
                if (string == null || com_google_android_gms_people_internal_zzu.zzib(string) == 0) {
                    com_google_android_gms_people_internal_zzi2.zzJl();
                } else {
                    com_google_android_gms_people_internal_zzi2.zza(com_google_android_gms_people_internal_zzu, string);
                }
                com_google_android_gms_people_internal_agg_zzd_zzc.moveToNext();
            }
            if (count >= 0) {
                zza = cursor.getPosition();
                int zznu = com_google_android_gms_people_internal_zzh.zznu(zza);
                if (zznu == 0) {
                    com_google_android_gms_people_internal_zzi.zzJl();
                    com_google_android_gms_people_internal_zzi2.zznv(zza);
                    zzsf.add(null);
                } else {
                    for (count = 0; count < zznu; count++) {
                        String zzI = com_google_android_gms_people_internal_zzh.zzI(zza, count);
                        if (!hashMap.containsKey(zzI)) {
                            com_google_android_gms_people_internal_zzi.zzJl();
                            com_google_android_gms_people_internal_zzi2.zznv(zza);
                            zzsf.add(zzI);
                        }
                    }
                }
                zzb.zzb(cursor);
            }
        }
    }
}

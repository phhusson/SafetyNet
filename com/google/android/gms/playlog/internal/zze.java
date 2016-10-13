package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzain;
import com.google.android.gms.internal.zzaiu.zzd;
import com.google.android.gms.playlog.internal.zzb.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zze extends zzj<zza> {
    private final String mPackageName;
    private final zzd zzbLL;
    private final zzb zzbLM = new zzb();
    private boolean zzbLN = true;
    private final Object zzqz = new Object();

    public zze(Context context, Looper looper, zzd com_google_android_gms_playlog_internal_zzd, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 24, com_google_android_gms_common_internal_zzf, com_google_android_gms_playlog_internal_zzd, com_google_android_gms_playlog_internal_zzd);
        this.mPackageName = context.getPackageName();
        this.zzbLL = (zzd) zzx.zzD(com_google_android_gms_playlog_internal_zzd);
        this.zzbLL.zza(this);
    }

    private void zzKd() {
        zzb.zzad(!this.zzbLN);
        if (!this.zzbLM.isEmpty()) {
            PlayLoggerContext playLoggerContext = null;
            try {
                List arrayList = new ArrayList();
                Iterator it = this.zzbLM.zzKb().iterator();
                while (it.hasNext()) {
                    zza com_google_android_gms_playlog_internal_zzb_zza = (zza) it.next();
                    if (com_google_android_gms_playlog_internal_zzb_zza.zzbLI != null) {
                        ((zza) zzrd()).zza(this.mPackageName, com_google_android_gms_playlog_internal_zzb_zza.zzbLG, zzain.toByteArray(com_google_android_gms_playlog_internal_zzb_zza.zzbLI));
                    } else {
                        PlayLoggerContext playLoggerContext2;
                        if (com_google_android_gms_playlog_internal_zzb_zza.zzbLG.equals(playLoggerContext)) {
                            arrayList.add(com_google_android_gms_playlog_internal_zzb_zza.zzbLH);
                            playLoggerContext2 = playLoggerContext;
                        } else {
                            if (!arrayList.isEmpty()) {
                                ((zza) zzrd()).zza(this.mPackageName, playLoggerContext, arrayList);
                                arrayList.clear();
                            }
                            PlayLoggerContext playLoggerContext3 = com_google_android_gms_playlog_internal_zzb_zza.zzbLG;
                            arrayList.add(com_google_android_gms_playlog_internal_zzb_zza.zzbLH);
                            playLoggerContext2 = playLoggerContext3;
                        }
                        playLoggerContext = playLoggerContext2;
                    }
                }
                if (!arrayList.isEmpty()) {
                    ((zza) zzrd()).zza(this.mPackageName, playLoggerContext, arrayList);
                }
                this.zzbLM.clear();
            } catch (RemoteException e) {
                Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
            }
        }
    }

    private void zzc(PlayLoggerContext playLoggerContext, zzd com_google_android_gms_internal_zzaiu_zzd) {
        this.zzbLM.zza(playLoggerContext, com_google_android_gms_internal_zzaiu_zzd);
    }

    private void zzc(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzbLM.zza(playLoggerContext, logEvent);
    }

    private void zzd(PlayLoggerContext playLoggerContext, zzd com_google_android_gms_internal_zzaiu_zzd) {
        try {
            zzKd();
            ((zza) zzrd()).zza(this.mPackageName, playLoggerContext, zzain.toByteArray(com_google_android_gms_internal_zzaiu_zzd));
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            zzc(playLoggerContext, com_google_android_gms_internal_zzaiu_zzd);
        } catch (IllegalStateException e2) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            zzc(playLoggerContext, com_google_android_gms_internal_zzaiu_zzd);
        }
    }

    private void zzd(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        try {
            zzKd();
            ((zza) zzrd()).zza(this.mPackageName, playLoggerContext, logEvent);
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            zzc(playLoggerContext, logEvent);
        } catch (IllegalStateException e2) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            zzc(playLoggerContext, logEvent);
        }
    }

    public int getCacheCapacity() {
        int capacity;
        synchronized (this.zzqz) {
            capacity = this.zzbLM.getCapacity();
        }
        return capacity;
    }

    public int getCacheSize() {
        int size;
        synchronized (this.zzqz) {
            size = this.zzbLM.getSize();
        }
        return size;
    }

    public boolean isCacheEmpty() {
        boolean isEmpty;
        synchronized (this.zzqz) {
            isEmpty = this.zzbLM.isEmpty();
        }
        return isEmpty;
    }

    public boolean isCacheFull() {
        boolean isFull;
        synchronized (this.zzqz) {
            isFull = this.zzbLM.isFull();
        }
        return isFull;
    }

    public void setCacheCapacity(int capacity) {
        synchronized (this.zzqz) {
            this.zzbLM.zzoh(capacity);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
        r3 = this;
        r1 = r3.zzqz;
        monitor-enter(r1);
        r0 = r3.isConnecting();	 Catch:{ all -> 0x001c }
        if (r0 != 0) goto L_0x000f;
    L_0x0009:
        r0 = r3.isConnected();	 Catch:{ all -> 0x001c }
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
    L_0x0010:
        return;
    L_0x0011:
        r0 = r3.zzbLL;	 Catch:{ all -> 0x001c }
        r2 = 1;
        r0.zzaU(r2);	 Catch:{ all -> 0x001c }
        r3.zzra();	 Catch:{ all -> 0x001c }
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
        goto L_0x0010;
    L_0x001c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.playlog.internal.zze.start():void");
    }

    public void stop() {
        synchronized (this.zzqz) {
            this.zzbLL.zzaU(false);
            disconnect();
        }
    }

    void zzaV(boolean z) {
        synchronized (this.zzqz) {
            boolean z2 = this.zzbLN;
            this.zzbLN = z;
            if (z2 && !this.zzbLN) {
                zzKd();
            }
        }
    }

    protected /* synthetic */ IInterface zzaa(IBinder iBinder) {
        return zzgt(iBinder);
    }

    public void zzb(PlayLoggerContext playLoggerContext, zzd com_google_android_gms_internal_zzaiu_zzd) {
        synchronized (this.zzqz) {
            if (this.zzbLN) {
                zzc(playLoggerContext, com_google_android_gms_internal_zzaiu_zzd);
            } else {
                zzd(playLoggerContext, com_google_android_gms_internal_zzaiu_zzd);
            }
        }
    }

    public void zzb(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        synchronized (this.zzqz) {
            if (this.zzbLN) {
                zzc(playLoggerContext, logEvent);
            } else {
                zzd(playLoggerContext, logEvent);
            }
        }
    }

    protected String zzgC() {
        return "com.google.android.gms.playlog.service.START";
    }

    protected String zzgD() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }

    protected zza zzgt(IBinder iBinder) {
        return zza.zza.zzgs(iBinder);
    }
}

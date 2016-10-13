package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.stats.zzc.zza;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzs;
import com.google.android.snet.Csv;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zzb {
    private static final Object zzawI = new Object();
    private static Integer zzayB;
    private static zzb zzayv;
    private zze zzayA;
    private zze zzayC;
    private final List<String> zzayw;
    private final List<String> zzayx;
    private final List<String> zzayy;
    private final List<String> zzayz;

    private zzb() {
        if (getLogLevel() == zzd.LOG_LEVEL_OFF) {
            this.zzayw = Collections.EMPTY_LIST;
            this.zzayx = Collections.EMPTY_LIST;
            this.zzayy = Collections.EMPTY_LIST;
            this.zzayz = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) zza.zzayG.get();
        this.zzayw = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(Csv.COMMA));
        str = (String) zza.zzayH.get();
        this.zzayx = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(Csv.COMMA));
        str = (String) zza.zzayI.get();
        this.zzayy = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(Csv.COMMA));
        str = (String) zza.zzayJ.get();
        this.zzayz = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(Csv.COMMA));
        this.zzayA = new zze(1024, ((Long) zza.zzayK.get()).longValue());
        this.zzayC = new zze(1024, ((Long) zza.zzayK.get()).longValue());
    }

    private static int getLogLevel() {
        if (zzayB == null) {
            try {
                zzayB = Integer.valueOf(zzd.isPackageSide() ? ((Integer) zza.zzayF.get()).intValue() : zzd.LOG_LEVEL_OFF);
            } catch (SecurityException e) {
                zzayB = Integer.valueOf(zzd.LOG_LEVEL_OFF);
            }
        }
        return zzayB.intValue();
    }

    private void zza(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        Parcelable connectionEvent;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if (!((getLogLevel() & zzd.zzayP) == 0 || i == 13)) {
            str6 = zzs.zzy(3, 5);
        }
        long j = 0;
        if ((getLogLevel() & zzd.zzayR) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14) {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str6, str, SystemClock.elapsedRealtime(), j);
        } else {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), j);
        }
        context.startService(new Intent().setComponent(zzd.zzayL).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    private void zza(Context context, String str, String str2, Intent intent, int i) {
        String str3 = null;
        if (zzrV() && this.zzayA != null) {
            String str4;
            String str5;
            if (i != 4 && i != 1) {
                ServiceInfo zzd = zzd(context, intent);
                if (zzd == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str4 = zzd.processName;
                str5 = zzd.name;
                str3 = zzs.zzaA(context);
                if (zzb(str3, str2, str4, str5)) {
                    this.zzayA.zzcN(str);
                } else {
                    return;
                }
            } else if (this.zzayA.zzcO(str)) {
                str5 = null;
                str4 = null;
            } else {
                return;
            }
            zza(context, str, i, str3, str2, str4, str5);
        }
    }

    private String zzb(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private boolean zzb(String str, String str2, String str3, String str4) {
        return (this.zzayw.contains(str) || this.zzayx.contains(str2) || this.zzayy.contains(str3) || this.zzayz.contains(str4) || (str3.equals(str) && (getLogLevel() & zzd.zzayQ) != 0)) ? false : true;
    }

    private boolean zzc(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        return (component == null || (com.google.android.gms.common.internal.zzd.zzavq && "com.google.android.gms".equals(component.getPackageName()))) ? false : zzd.zzn(context, component.getPackageName());
    }

    private static ServiceInfo zzd(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zzs.zzy(3, 20)}));
            return null;
        }
        if (queryIntentServices.size() > 1) {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zzs.zzy(3, 20)}));
            Iterator it = queryIntentServices.iterator();
            if (it.hasNext()) {
                Log.w("ConnectionTracker", ((ResolveInfo) it.next()).serviceInfo.name);
                return null;
            }
        }
        return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
    }

    public static zzb zzrU() {
        synchronized (zzawI) {
            if (zzayv == null) {
                zzayv = new zzb();
            }
        }
        return zzayv;
    }

    private boolean zzrV() {
        return com.google.android.gms.common.internal.zzd.zzavq && getLogLevel() != zzd.LOG_LEVEL_OFF;
    }

    @SuppressLint({"UntrackedBindService"})
    public void zza(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        zza(context, zzb(serviceConnection), null, null, 1);
    }

    public void zza(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        zza(context, zzb(serviceConnection), str, intent, 3);
    }

    public boolean zza(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (zzc(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            zza(context, zzb(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void zzb(Context context, ServiceConnection serviceConnection) {
        zza(context, zzb(serviceConnection), null, null, 4);
    }
}

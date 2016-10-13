package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Log;
import java.io.File;

public class zzw {
    @TargetApi(21)
    public static File getNoBackupFilesDir(Context context) {
        return zzr.zzsr() ? context.getNoBackupFilesDir() : zzd(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File zzd(File file) {
        synchronized (zzw.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                Log.w("SupportV4Utils", "Unable to create no-backup dir " + file.getPath());
                file = null;
            }
        }
        return file;
    }
}

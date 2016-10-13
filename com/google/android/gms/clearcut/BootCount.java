package com.google.android.gms.clearcut;

import android.content.Context;

public class BootCount {
    public static final BootCount INSTANCE = new BootCount();
    private static int zzaoA = -1;

    protected BootCount() {
    }

    public int getBootCount(Context context) {
        if (zzaoA < 0) {
            zzaoA = context.getSharedPreferences("bootCount", 0).getInt("bootCount", 1);
        }
        return zzaoA;
    }
}

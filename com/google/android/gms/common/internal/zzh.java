package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class zzh implements OnClickListener {
    private final Activity mActivity;
    private final Intent mIntent;
    private final int zzaqI;
    private final Fragment zzavS;

    public zzh(Activity activity, Intent intent, int i) {
        this.mActivity = activity;
        this.zzavS = null;
        this.mIntent = intent;
        this.zzaqI = i;
    }

    public zzh(Fragment fragment, Intent intent, int i) {
        this.mActivity = null;
        this.zzavS = fragment;
        this.mIntent = intent;
        this.zzaqI = i;
    }

    public void onClick(DialogInterface dialog, int which) {
        try {
            if (this.mIntent != null && this.zzavS != null) {
                this.zzavS.startActivityForResult(this.mIntent, this.zzaqI);
            } else if (this.mIntent != null) {
                this.mActivity.startActivityForResult(this.mIntent, this.zzaqI);
            }
            dialog.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}

package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.api.ResultStore;

public class zzab extends Fragment {
    private zzu zzasE = new zzu();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void onDestroy() {
        super.onDestroy();
        this.zzasE.zzr(getActivity());
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.zzasE.zzqd();
    }

    public ResultStore zzqc() {
        return this.zzasE;
    }
}

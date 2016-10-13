package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.zzc.zza;

public final class zzh extends zza {
    private Fragment zzavS;

    private zzh(Fragment fragment) {
        this.zzavS = fragment;
    }

    public static zzh zza(Fragment fragment) {
        return fragment != null ? new zzh(fragment) : null;
    }

    public Bundle getArguments() {
        return this.zzavS.getArguments();
    }

    public int getId() {
        return this.zzavS.getId();
    }

    public boolean getRetainInstance() {
        return this.zzavS.getRetainInstance();
    }

    public String getTag() {
        return this.zzavS.getTag();
    }

    public int getTargetRequestCode() {
        return this.zzavS.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.zzavS.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzJ(this.zzavS.getView());
    }

    public boolean isAdded() {
        return this.zzavS.isAdded();
    }

    public boolean isDetached() {
        return this.zzavS.isDetached();
    }

    public boolean isHidden() {
        return this.zzavS.isHidden();
    }

    public boolean isInLayout() {
        return this.zzavS.isInLayout();
    }

    public boolean isRemoving() {
        return this.zzavS.isRemoving();
    }

    public boolean isResumed() {
        return this.zzavS.isResumed();
    }

    public boolean isVisible() {
        return this.zzavS.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.zzavS.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.zzavS.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.zzavS.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.zzavS.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.zzavS.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.zzavS.startActivityForResult(intent, requestCode);
    }

    public void zzs(zzd com_google_android_gms_dynamic_zzd) {
        this.zzavS.registerForContextMenu((View) zze.zzu(com_google_android_gms_dynamic_zzd));
    }

    public void zzt(zzd com_google_android_gms_dynamic_zzd) {
        this.zzavS.unregisterForContextMenu((View) zze.zzu(com_google_android_gms_dynamic_zzd));
    }

    public zzd zzwH() {
        return zze.zzJ(this.zzavS.getActivity());
    }

    public zzc zzwI() {
        return zza(this.zzavS.getParentFragment());
    }

    public zzd zzwJ() {
        return zze.zzJ(this.zzavS.getResources());
    }

    public zzc zzwK() {
        return zza(this.zzavS.getTargetFragment());
    }
}

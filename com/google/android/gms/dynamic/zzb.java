package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.zzc.zza;

@SuppressLint({"NewApi"})
public final class zzb extends zza {
    private Fragment zzaNP;

    private zzb(Fragment fragment) {
        this.zzaNP = fragment;
    }

    public static zzb zza(Fragment fragment) {
        return fragment != null ? new zzb(fragment) : null;
    }

    public Bundle getArguments() {
        return this.zzaNP.getArguments();
    }

    public int getId() {
        return this.zzaNP.getId();
    }

    public boolean getRetainInstance() {
        return this.zzaNP.getRetainInstance();
    }

    public String getTag() {
        return this.zzaNP.getTag();
    }

    public int getTargetRequestCode() {
        return this.zzaNP.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.zzaNP.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzJ(this.zzaNP.getView());
    }

    public boolean isAdded() {
        return this.zzaNP.isAdded();
    }

    public boolean isDetached() {
        return this.zzaNP.isDetached();
    }

    public boolean isHidden() {
        return this.zzaNP.isHidden();
    }

    public boolean isInLayout() {
        return this.zzaNP.isInLayout();
    }

    public boolean isRemoving() {
        return this.zzaNP.isRemoving();
    }

    public boolean isResumed() {
        return this.zzaNP.isResumed();
    }

    public boolean isVisible() {
        return this.zzaNP.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.zzaNP.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.zzaNP.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.zzaNP.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.zzaNP.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.zzaNP.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.zzaNP.startActivityForResult(intent, requestCode);
    }

    public void zzs(zzd com_google_android_gms_dynamic_zzd) {
        this.zzaNP.registerForContextMenu((View) zze.zzu(com_google_android_gms_dynamic_zzd));
    }

    public void zzt(zzd com_google_android_gms_dynamic_zzd) {
        this.zzaNP.unregisterForContextMenu((View) zze.zzu(com_google_android_gms_dynamic_zzd));
    }

    public zzd zzwH() {
        return zze.zzJ(this.zzaNP.getActivity());
    }

    public zzc zzwI() {
        return zza(this.zzaNP.getParentFragment());
    }

    public zzd zzwJ() {
        return zze.zzJ(this.zzaNP.getResources());
    }

    public zzc zzwK() {
        return zza(this.zzaNP.getTargetFragment());
    }
}

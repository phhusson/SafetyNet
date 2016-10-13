package com.google.android.gms.people.model;

import android.support.annotation.RequiresPermission;

public interface PhoneNumberEntry {
    String getFocusContactId();

    Long getLastUpdateTime();

    String getName();

    String getOwnerAccountName();

    String getPhoneNumber();

    @RequiresPermission("android.permission.READ_CONTACTS")
    String getPhotoUri();
}

package com.google.android.snet;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.admin.DevicePolicyManager;
import android.content.ContentResolver;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

class SettingsFinder {
    private static final int FINGERPRINT_ENROLLED = 1;
    private static final int FINGERPRINT_NOT_SUPPORTED = 0;
    private static final int FINGERPRINT_UNENROLLED = 2;
    private static final int LOCK_SCREEN_TYPE_FACE_PATTERN = 5;
    private static final int LOCK_SCREEN_TYPE_FACE_PIN = 4;
    private static final int LOCK_SCREEN_TYPE_NONE = 0;
    private static final int LOCK_SCREEN_TYPE_PASSWORD = 6;
    private static final int LOCK_SCREEN_TYPE_PATTERN = 3;
    private static final int LOCK_SCREEN_TYPE_PIN = 2;
    private static final int LOCK_SCREEN_TYPE_SECURE_UNKNOWN = 1;
    private static final int NOTIFICATION_TYPE_NONE = 0;
    private static final int NOTIFICATION_TYPE_PRIVATE = 1;
    private static final int NOTIFICATION_TYPE_PUBLIC = 2;
    private static final int NOTIFICATION_TYPE_SECRET = 3;
    private static final String SETTINGS_GLOBAL_CLASS_NAME = "android.provider.Settings$Global";
    private static final String SETTINGS_SECURE_CLASS_NAME = "android.provider.Settings$Secure";
    private static final String TAG = SettingsFinder.class.getCanonicalName();
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private DeviceSettings mDeviceSettings = new DeviceSettings();
    private final GBundle mGBundle;
    private final String mSettingsClass;

    public static class DeviceSettings {
        public boolean adbEnabled;
        public int fingerprintStatus;
        public int lockScreenTimeout;
        public int lockScreenType;
        public boolean nonMarketAppsEnabled;
        public int notificationVisibility;
        public boolean smartLockEnabled;
        public boolean smartLockStatusObtained;
        public int storageEncryptionStatus;
    }

    SettingsFinder(Context context, GBundle gBundle) {
        this.mContext = context;
        this.mGBundle = gBundle;
        this.mContentResolver = context.getContentResolver();
        if (VERSION.SDK_INT < 17) {
            this.mSettingsClass = SETTINGS_SECURE_CLASS_NAME;
        } else {
            this.mSettingsClass = SETTINGS_GLOBAL_CLASS_NAME;
        }
    }

    DeviceSettings deviceSettings() {
        this.mDeviceSettings.adbEnabled = adbEnabled();
        this.mDeviceSettings.nonMarketAppsEnabled = nonMarketAppsEnabled();
        if (VERSION.SDK_INT >= 16) {
            getLockScreenSettings();
        } else {
            getLockScreenSettingsPreJb();
        }
        if (VERSION.SDK_INT >= 21) {
            Bundle smartLockBundle = this.mGBundle.getSmartLockBundle();
            if (smartLockBundle != null && TextUtils.isEmpty(smartLockBundle.getString("errorMsg")) && smartLockBundle.getInt("statusCode") == 0) {
                this.mDeviceSettings.smartLockStatusObtained = true;
                this.mDeviceSettings.smartLockEnabled = smartLockBundle.getBoolean("smartLockStatus");
            }
        }
        getStorageEncryptionStatus();
        if (VERSION.SDK_INT >= 23) {
            getFingerprintStatus();
        }
        return this.mDeviceSettings;
    }

    private boolean adbEnabled() {
        return getInt(this.mSettingsClass, "adb_enabled", 0) != 0;
    }

    private boolean nonMarketAppsEnabled() {
        return getInt(this.mSettingsClass, "install_non_market_apps", 0) != 0;
    }

    private int getInt(String settingsClass, String setting, int defaultValue) {
        try {
            defaultValue = ((Integer) Class.forName(settingsClass).getMethod("getInt", new Class[]{ContentResolver.class, String.class, Integer.TYPE}).invoke(null, new Object[]{this.mContentResolver, setting, Integer.valueOf(defaultValue)})).intValue();
        } catch (ClassNotFoundException e) {
            Log.e(TAG, e.getMessage());
        } catch (NoSuchMethodException e2) {
            Log.e(TAG, e2.getMessage());
        } catch (IllegalAccessException e3) {
            Log.e(TAG, e3.getMessage());
        } catch (InvocationTargetException e4) {
            Log.e(TAG, e4.getMessage());
        }
        return defaultValue;
    }

    @TargetApi(16)
    private void getLockScreenSettings() {
        if (((KeyguardManager) this.mContext.getSystemService("keyguard")).isKeyguardSecure()) {
            this.mDeviceSettings.lockScreenType = 1;
            if (VERSION.SDK_INT >= 21) {
                this.mDeviceSettings.notificationVisibility = getNotificationVisibility();
            }
        } else {
            this.mDeviceSettings.lockScreenType = 0;
        }
        this.mDeviceSettings.lockScreenTimeout = getInt(this.mSettingsClass, "lock_screen_lock_after_timeout", 0);
    }

    @TargetApi(21)
    private int getNotificationVisibility() {
        Notification notification = new Builder(this.mContext).build();
        if (notification == null) {
            return 0;
        }
        switch (notification.visibility) {
            case -1:
                return 3;
            case 0:
                return 1;
            case 1:
                return 2;
            default:
                return 0;
        }
    }

    private void getLockScreenSettingsPreJb() {
        switch (getInt(this.mSettingsClass, "lockscreen.password_type", -1)) {
            case 32768:
                if (!new File(Environment.getDataDirectory().getAbsolutePath(), "/system/password.key").exists()) {
                    this.mDeviceSettings.lockScreenType = 5;
                    break;
                } else {
                    this.mDeviceSettings.lockScreenType = 4;
                    break;
                }
            case 65536:
                if (getInt(this.mSettingsClass, "lock_pattern_autolock", 0) == 0) {
                    this.mDeviceSettings.lockScreenType = 0;
                    break;
                } else {
                    this.mDeviceSettings.lockScreenType = 3;
                    break;
                }
            case 131072:
                this.mDeviceSettings.lockScreenType = 2;
                break;
            case 262144:
            case 327680:
                this.mDeviceSettings.lockScreenType = 6;
                break;
            default:
                this.mDeviceSettings.lockScreenType = 0;
                break;
        }
        this.mDeviceSettings.lockScreenTimeout = getInt(this.mSettingsClass, "lock_screen_lock_after_timeout", 0);
    }

    private void getStorageEncryptionStatus() {
        if (VERSION.SDK_INT >= 11) {
            getStorageEncryptionStatusGEHoneycomb();
        } else {
            this.mDeviceSettings.storageEncryptionStatus = -1;
        }
    }

    @TargetApi(11)
    private void getStorageEncryptionStatusGEHoneycomb() {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) this.mContext.getSystemService("device_policy");
        this.mDeviceSettings.storageEncryptionStatus = devicePolicyManager.getStorageEncryptionStatus();
    }

    @TargetApi(23)
    private void getFingerprintStatus() {
        FingerprintManager fingerprintManager = (FingerprintManager) this.mContext.getSystemService("fingerprint");
        if (!fingerprintManager.isHardwareDetected()) {
            this.mDeviceSettings.fingerprintStatus = 0;
        } else if (fingerprintManager.hasEnrolledFingerprints()) {
            this.mDeviceSettings.fingerprintStatus = 1;
        } else {
            this.mDeviceSettings.fingerprintStatus = 2;
        }
    }
}

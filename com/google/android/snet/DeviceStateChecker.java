package com.google.android.snet;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.people.PeopleConstants.Endpoints;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

class DeviceStateChecker {
    private static final boolean DEBUG = false;
    public static final int FLASH_LOCK_UNKNOWN = -1;
    private static final String SYSTEM_PROPERTY_UNKNOWN = "Unknown";
    private static final String TAG = DeviceStateChecker.class.getCanonicalName();

    static class ClientIdBase {
        String roComGoogleClientidbase;
        String roComGoogleClientidbaseAm;
        String roComGoogleClientidbaseGmm;
        String roComGoogleClientidbaseMs;
        String roComGoogleClientidbaseYt;

        ClientIdBase() {
        }
    }

    static class DeviceState {
        String kernelVersion;
        int oemLocked;
        int oemUnlockSupported;
        String productBrand;
        String productModel;
        String securityPatchLevel;
        List<SystemProperty> systemPropertyList;
        String verifiedBootState;
        String verityMode;

        DeviceState() {
        }
    }

    static class SystemProperty {
        String name;
        String value;

        SystemProperty() {
        }
    }

    DeviceStateChecker() {
    }

    private static String systemPropertyStringValue(String propertyName) {
        try {
            String result = (String) Class.forName("android.os.SystemProperties").getMethod(Endpoints.ENDPOINT_GET, new Class[]{String.class}).invoke(null, new Object[]{propertyName});
            if (TextUtils.isEmpty(result)) {
                return SYSTEM_PROPERTY_UNKNOWN;
            }
            return result;
        } catch (ClassNotFoundException e) {
            return SYSTEM_PROPERTY_UNKNOWN;
        } catch (NoSuchMethodException e2) {
            return SYSTEM_PROPERTY_UNKNOWN;
        } catch (IllegalArgumentException e3) {
            return SYSTEM_PROPERTY_UNKNOWN;
        } catch (IllegalAccessException e4) {
            return SYSTEM_PROPERTY_UNKNOWN;
        } catch (InvocationTargetException e5) {
            return SYSTEM_PROPERTY_UNKNOWN;
        }
    }

    private static int systemPropertyIntValue(String propertyName) {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(null, new Object[]{propertyName, Integer.valueOf(-1)})).intValue();
        } catch (ClassNotFoundException e) {
            return -1;
        } catch (NoSuchMethodException e2) {
            return -1;
        } catch (IllegalArgumentException e3) {
            return -1;
        } catch (IllegalAccessException e4) {
            return -1;
        } catch (InvocationTargetException e5) {
            return -1;
        }
    }

    private static int getFlashLockState(Context context) {
        try {
            Class<?> cPersistentDataBlockManager = Class.forName("android.service.persistentdata.PersistentDataBlockManager");
            Object oPersistentDataBlockManager = context.getSystemService((String) Class.forName("android.content.Context").getField("PERSISTENT_DATA_BLOCK_SERVICE").get(null));
            return oPersistentDataBlockManager != null ? ((Integer) cPersistentDataBlockManager.getDeclaredMethod("getFlashLockState", new Class[0]).invoke(oPersistentDataBlockManager, new Object[0])).intValue() : -1;
        } catch (ClassNotFoundException e) {
            return -1;
        } catch (NoSuchFieldException e2) {
            return -1;
        } catch (NoSuchMethodException e3) {
            return -1;
        } catch (IllegalArgumentException e4) {
            return -1;
        } catch (IllegalAccessException e5) {
            return -1;
        } catch (InvocationTargetException e6) {
            return -1;
        } catch (SecurityException e7) {
            return -1;
        }
    }

    static DeviceState getDeviceState(Context context, GBundle gBundle) {
        DeviceState deviceState = new DeviceState();
        deviceState.verifiedBootState = systemPropertyStringValue("ro.boot.verifiedbootstate");
        deviceState.verityMode = systemPropertyStringValue("ro.boot.veritymode");
        deviceState.securityPatchLevel = systemPropertyStringValue("ro.build.version.security_patch");
        deviceState.oemUnlockSupported = systemPropertyIntValue("ro.oem_unlock_supported");
        if (VERSION.SDK_INT > 23) {
            deviceState.oemLocked = getFlashLockState(context);
        } else {
            deviceState.oemLocked = systemPropertyIntValue("ro.boot.flash.locked");
        }
        deviceState.productBrand = systemPropertyStringValue("ro.product.brand");
        deviceState.productModel = systemPropertyStringValue("ro.product.model");
        deviceState.kernelVersion = Utils.readVirtualFile("/proc/version");
        List<String> systemPropertyNames = gBundle.getSystemPropertyNames();
        if (systemPropertyNames.size() > 0) {
            deviceState.systemPropertyList = new ArrayList();
            for (String propertyName : systemPropertyNames) {
                SystemProperty sp = new SystemProperty();
                sp.name = propertyName;
                sp.value = systemPropertyStringValue(propertyName);
                deviceState.systemPropertyList.add(sp);
            }
        }
        return deviceState;
    }
}

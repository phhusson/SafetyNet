package com.google.android.snet;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.math.BigInteger;
import java.security.SecureRandom;

class PreferredPackageFinder {
    private static final String PACKAGE_MIME_TYPE = "application/vnd.android.package-archive";
    private static final String RANDOM_NAME = getRandomName();
    private static final int RANDOM_NAME_BITS = 130;
    private static final int RANDOM_NAME_RADIX = 16;
    private PackageManager mPackageManager;

    private static String getRandomName() {
        return new BigInteger(130, new SecureRandom()).toString(16);
    }

    PreferredPackageFinder(Context ctx) {
        this.mPackageManager = ctx.getPackageManager();
    }

    PackageInfo findWebBrowser() {
        String str = RANDOM_NAME;
        return getPreferredPackage(new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(String.valueOf(str).length() + 11).append("http://").append(str).append(".com").toString())));
    }

    PackageInfo findPackageInstaller() {
        String str = RANDOM_NAME;
        Uri uri = Uri.parse(new StringBuilder(String.valueOf(str).length() + 11).append("file://").append(str).append(".apk").toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, PACKAGE_MIME_TYPE);
        return getPreferredPackage(intent);
    }

    private PackageInfo getPreferredPackage(Intent intent) {
        PackageInfo packageInfo = null;
        ResolveInfo resolveInfo = this.mPackageManager.resolveActivity(intent, 65536);
        if (!(resolveInfo == null || resolveInfo.activityInfo == null)) {
            try {
                packageInfo = this.mPackageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 0);
            } catch (NameNotFoundException e) {
            }
        }
        return packageInfo;
    }
}

package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import android.util.Log;

public class GoogleSignatureVerifier {
    private static final GoogleSignatureVerifier zzaqc = new GoogleSignatureVerifier();

    private GoogleSignatureVerifier() {
    }

    public static GoogleSignatureVerifier getInstance() {
        return zzaqc;
    }

    private boolean zzb(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        zza com_google_android_gms_common_zzc_zzb = new zzb(packageInfo.signatures[0].toByteArray());
        if ((z ? zzc.zzoZ() : zzc.zzpa()).contains(com_google_android_gms_common_zzc_zzb)) {
            return true;
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(com_google_android_gms_common_zzc_zzb.getBytes(), 0));
        }
        return false;
    }

    public boolean isPackageGoogleSigned(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (GooglePlayServicesUtilLight.honorsDebugCertificates(packageManager)) {
            return zzb(packageInfo, true);
        }
        boolean zzb = zzb(packageInfo, false);
        if (zzb || !zzb(packageInfo, true)) {
            return zzb;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return zzb;
    }

    public boolean isPackageGoogleSigned(PackageManager packageManager, String callingPackage) {
        try {
            return isPackageGoogleSigned(packageManager, packageManager.getPackageInfo(callingPackage, 64));
        } catch (NameNotFoundException e) {
            if (Log.isLoggable("GoogleSignatureVerifier", 3)) {
                Log.d("GoogleSignatureVerifier", "Package manager can't find package " + callingPackage + ", defaulting to false");
            }
            return false;
        }
    }

    public boolean isUidGoogleSigned(PackageManager packageManager, int uid) {
        String[] packagesForUid = packageManager.getPackagesForUid(uid);
        if (packagesForUid == null || packagesForUid.length == 0) {
            return false;
        }
        for (String isPackageGoogleSigned : packagesForUid) {
            if (isPackageGoogleSigned(packageManager, isPackageGoogleSigned)) {
                return true;
            }
        }
        return false;
    }

    public void verifyPackageIsGoogleSigned(PackageManager packageManager, String callingPackage) throws SecurityException {
        if (!isPackageGoogleSigned(packageManager, callingPackage)) {
            throw new SecurityException("Signature check failed for " + callingPackage);
        }
    }

    public void verifyUidIsGoogleSigned(PackageManager packageManager, int uid) throws SecurityException {
        if (packageManager == null) {
            throw new SecurityException("Unknown error: invalid Package Manager");
        } else if (!isUidGoogleSigned(packageManager, uid)) {
            throw new SecurityException("Uid is not Google Signed");
        }
    }

    zza zza(PackageInfo packageInfo, zza... com_google_android_gms_common_zzc_zzaArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zza com_google_android_gms_common_zzc_zzb = new zzb(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < com_google_android_gms_common_zzc_zzaArr.length; i++) {
            if (com_google_android_gms_common_zzc_zzaArr[i].equals(com_google_android_gms_common_zzc_zzb)) {
                return com_google_android_gms_common_zzc_zzaArr[i];
            }
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(com_google_android_gms_common_zzc_zzb.getBytes(), 0));
        }
        return null;
    }

    public boolean zza(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            zza zza;
            if (z) {
                zza = zza(packageInfo, zzcm.zzapU);
            } else {
                zza = zza(packageInfo, zzcm.zzapU[0]);
            }
            if (zza != null) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (GooglePlayServicesUtilLight.honorsDebugCertificates(packageManager)) {
            return zza(packageInfo, true);
        }
        boolean zza = zza(packageInfo, false);
        if (zza || !zza(packageInfo, true)) {
            return zza;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return zza;
    }
}

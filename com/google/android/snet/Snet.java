package com.google.android.snet;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.snet.FileFinder.FilesInfo;
import com.google.android.snet.MxRecordHijackAnalyzer.MxInfo;
import com.google.android.snet.NetworkAnalyzer.SslRedirectInfo;
import com.google.android.snet.ProxyAnalyzer.ProxyInfo;
import com.google.android.snet.SnetLogcat.LogcatInfo;
import com.google.android.snet.SslHandshakeAnalyzer.SslInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Snet {
    private static final String DEFAULT_IDLE_WHITELIST_TAGS = "system_partition_files,system_ca_cert_store,setuid_files,dalvik_cache_monitor,device_state,locale,selinux_status,logcat,event_log";
    private static final String DEFAULT_WHITELIST_TAGS = "default_packages,su_files,settings,locale,ssl_redirect,ssl_handshake,proxy,selinux_status,sd_card_test,google_page_info,captive_portal_test,attest,gmscore,device_state,carrier_info,logcat,event_log";
    static final String DONE_TAG = "done";
    private static final String GOOGLE_ACCOUNT_SUFFIX = "@google.com";
    private static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    private static final String LOG_APPS_TAG = "apps";
    private static final String LOG_ATTESTATION_TAG = "attest";
    private static final String LOG_CAPTIVE_PORTAL_TEST_TAG = "captive_portal_test";
    private static final String LOG_CARRIER_INFO_TAG = "carrier_info";
    private static final String LOG_DALVIK_CACHE_TAG = "dalvik_cache_monitor";
    private static final String LOG_DEVICE_ADMIN_TAG = "device_admin_deactivator";
    private static final String LOG_DEVICE_STATE_TAG = "device_state";
    private static final String LOG_EVENT_LOG_TAG = "event_log";
    private static final String LOG_FILES_TAG = "su_files";
    private static final String LOG_GMSCORE_INFO_TAG = "gmscore";
    private static final String LOG_GOOGLE_PAGE_INFO_TAG = "google_page_info";
    private static final String LOG_GOOGLE_PAGE_TAG = "google_page";
    private static final String LOG_HANDSHAKE_TAG = "ssl_handshake";
    private static final String LOG_LOCALE_TAG = "locale";
    private static final String LOG_LOGCAT_TAG = "logcat";
    private static final String LOG_MX_RECORDS_TAG = "mx_record";
    private static final String LOG_PACKAGES_TAG = "default_packages";
    private static final String LOG_PROXY_TAG = "proxy";
    private static final String LOG_REDIRECT_TAG = "ssl_redirect";
    private static final String LOG_SD_CARD_TAG = "sd_card_test";
    private static final String LOG_SELINUX_TAG = "selinux_status";
    private static final String LOG_SETTINGS_TAG = "settings";
    private static final String LOG_SETUID_TAG = "setuid_files";
    private static final String LOG_SSLV3_TAG = "sslv3_fallback";
    private static final String LOG_SUSPICIOUS_PAGE_TAG = "suspicious_google_page";
    private static final String LOG_SYSTEM_CA_CERT_STORE_TAG = "system_ca_cert_store";
    private static final String LOG_SYSTEM_PARTITION_FILES_TAG = "system_partition_files";
    private static final String TAG = Snet.class.getCanonicalName();
    static final int VERSION_INVALID = -1;
    private Context mCtx;
    private GBundle mGBundle;
    private SnetIdleLogger mSnetIdleLogger;
    private SnetLogger mSnetLogger;

    static int getVersion() {
        IOException ex;
        Throwable th;
        NumberFormatException ex2;
        int i = -1;
        BufferedReader reader = null;
        try {
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(Snet.class.getResourceAsStream("/version")));
            try {
                i = Integer.parseInt(reader2.readLine());
                if (reader2 != null) {
                    try {
                        reader2.close();
                    } catch (IOException ex3) {
                        Log.e(TAG, "Error occurred while closing version file", ex3);
                    }
                }
            } catch (IOException e) {
                ex3 = e;
                reader = reader2;
                try {
                    Log.e(TAG, "Error occurred while reading version", ex3);
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException ex32) {
                            Log.e(TAG, "Error occurred while closing version file", ex32);
                        }
                    }
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException ex322) {
                            Log.e(TAG, "Error occurred while closing version file", ex322);
                        }
                    }
                    throw th;
                }
            } catch (NumberFormatException e2) {
                ex2 = e2;
                reader = reader2;
                Log.e(TAG, "Error occurred while parsing version", ex2);
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException ex3222) {
                        Log.e(TAG, "Error occurred while closing version file", ex3222);
                    }
                }
                return i;
            } catch (Throwable th3) {
                th = th3;
                reader = reader2;
                if (reader != null) {
                    reader.close();
                }
                throw th;
            }
        } catch (IOException e3) {
            ex3222 = e3;
            Log.e(TAG, "Error occurred while reading version", ex3222);
            if (reader != null) {
                reader.close();
            }
            return i;
        } catch (NumberFormatException e4) {
            ex2 = e4;
            Log.e(TAG, "Error occurred while parsing version", ex2);
            if (reader != null) {
                reader.close();
            }
            return i;
        }
        return i;
    }

    public static void enterSnet(Context ctx, Bundle bundle) {
        if (bundle == null) {
            Log.e(TAG, "Missing bundle.");
        } else {
            new Snet(ctx, bundle).logAllInfoNormalMode();
        }
    }

    public static void enterSnetIdle(Context ctx, Bundle bundle) {
        if (bundle == null) {
            Log.e(TAG, "Missing bundle.");
        } else {
            new Snet(ctx, bundle).logAllInfoIdleMode();
        }
    }

    private Snet(Context ctx, Bundle bundle) {
        this.mCtx = ctx;
        this.mGBundle = new GBundle(bundle);
        this.mSnetLogger = new SnetLogger(ctx, this.mGBundle);
        this.mSnetIdleLogger = new SnetIdleLogger(ctx, this.mGBundle);
    }

    private void logAllInfoNormalMode() {
        long startTimeMs = System.currentTimeMillis();
        Log.d(TAG, "Hello Snet!");
        String signalTags = whitelistTags();
        this.mSnetLogger.setSignalTagsWhitelist(signalTags);
        if (signalTags != null) {
            List<SslRedirectInfo> sslRedirectInfoList = null;
            List<SslInfo> sslHandshakeInfoList = null;
            String googleWebpageHtml = null;
            for (String signalTag : signalTags.split(Csv.COMMA)) {
                updateExecutionPoint(signalTag);
                if (LOG_PACKAGES_TAG.equals(signalTag)) {
                    logPreferredPackages();
                } else if (LOG_FILES_TAG.equals(signalTag)) {
                    logFiles();
                } else {
                    try {
                        if (LOG_SETTINGS_TAG.equals(signalTag)) {
                            logSettings();
                        } else if (LOG_LOCALE_TAG.equals(signalTag)) {
                            logLocale();
                        } else if (LOG_REDIRECT_TAG.equals(signalTag)) {
                            sslRedirectInfoList = logSslRedirectAnalysis();
                        } else if (LOG_HANDSHAKE_TAG.equals(signalTag)) {
                            sslHandshakeInfoList = logSslHandshakeAnalysis();
                        } else if (LOG_MX_RECORDS_TAG.equals(signalTag)) {
                            logMxRecords();
                        } else if (LOG_SSLV3_TAG.equals(signalTag)) {
                            logHttpsSslv3FallbackAnalysis();
                        } else if (LOG_PROXY_TAG.equals(signalTag)) {
                            logProxyInfo();
                        } else if (LOG_SELINUX_TAG.equals(signalTag)) {
                            logSeLinuxInfo();
                        } else if (LOG_SD_CARD_TAG.equals(signalTag)) {
                            logSdCardAnalysis();
                        } else if (LOG_APPS_TAG.equals(signalTag)) {
                            if (hasGoogleAccount()) {
                                logApps();
                            }
                        } else if (LOG_GOOGLE_PAGE_TAG.equals(signalTag)) {
                            if (googleWebpageHtml == null) {
                                googleWebpageHtml = getGoogleWebpageHtml();
                            }
                            logGoogleWebpageHtml(googleWebpageHtml);
                        } else if (LOG_SUSPICIOUS_PAGE_TAG.equals(signalTag)) {
                            if (SuspiciousGoogleWebPageDetector.isSuspicious(sslHandshakeInfoList, sslRedirectInfoList)) {
                                if (googleWebpageHtml == null) {
                                    googleWebpageHtml = getGoogleWebpageHtml();
                                }
                                logGoogleWebpageHtml(googleWebpageHtml);
                            }
                        } else if (LOG_GOOGLE_PAGE_INFO_TAG.equals(signalTag)) {
                            if (googleWebpageHtml == null) {
                                googleWebpageHtml = getGoogleWebpageHtml();
                            }
                            logGooglePageInfo(googleWebpageHtml);
                        } else if (LOG_CAPTIVE_PORTAL_TEST_TAG.equals(signalTag)) {
                            logCaptivePortalTest();
                        } else if (LOG_GMSCORE_INFO_TAG.equals(signalTag)) {
                            logGmsCoreInfo();
                        } else if (LOG_ATTESTATION_TAG.equals(signalTag)) {
                            logAttestationResult();
                        } else if (LOG_EVENT_LOG_TAG.equals(signalTag)) {
                            logEventLogTagsOfInterestNormalMode();
                        } else if (LOG_DEVICE_ADMIN_TAG.equals(signalTag)) {
                            logDeactivateDeviceAdmins();
                        } else if (LOG_DEVICE_STATE_TAG.equals(signalTag)) {
                            logDeviceState();
                        } else if (LOG_CARRIER_INFO_TAG.equals(signalTag)) {
                            logCarrierInfo();
                        } else {
                            Log.e(TAG, String.format("Unknown tag: %s", new Object[]{signalTag}));
                        }
                    } catch (Exception e) {
                        this.mSnetLogger.writeExceptionDetailed(e);
                    } finally {
                        this.mSnetLogger.writeToBackend(getVersion(), startTimeMs);
                    }
                }
            }
        }
        updateExecutionPoint(DONE_TAG);
    }

    private String whitelistTags() {
        return this.mGBundle.getIsTargetedByGservices() ? this.mGBundle.getSignalTagsWhitelist() : DEFAULT_WHITELIST_TAGS;
    }

    private void logAllInfoIdleMode() {
        long startTimeMs = System.currentTimeMillis();
        SnetSharedPreferences preferences = new SnetSharedPreferences(this.mCtx);
        String lastSignalTag = preferences.lastIdleModeTag();
        Log.d(TAG, "Hi Snet!");
        String signalTags = idleWhitelistTags();
        this.mSnetIdleLogger.setSignalTagsWhitelist(signalTags);
        if (signalTags != null) {
            String[] signalTagsArray = signalTags.split(Csv.COMMA);
            if (!DONE_TAG.equals(lastSignalTag)) {
                this.mSnetIdleLogger.loadSavedProto();
                List<String> updatedSignalTags = new ArrayList();
                boolean addFiles = false;
                for (String signalTag : signalTagsArray) {
                    if (addFiles) {
                        updatedSignalTags.add(signalTag);
                    }
                    if (lastSignalTag.equals(signalTag)) {
                        addFiles = true;
                    }
                }
                signalTagsArray = (String[]) updatedSignalTags.toArray(new String[0]);
            }
            boolean interrupted = false;
            for (String signalTag2 : signalTagsArray) {
                lastSignalTag = signalTag2;
                if (LOG_SYSTEM_PARTITION_FILES_TAG.equals(signalTag2)) {
                    logSystemPartitionFiles(startTimeMs);
                } else if (LOG_SYSTEM_CA_CERT_STORE_TAG.equals(signalTag2)) {
                    logSystemCaCertStore();
                } else {
                    try {
                        if (LOG_SETUID_TAG.equals(signalTag2)) {
                            logSetuidFiles(startTimeMs);
                        } else if (LOG_LOGCAT_TAG.equals(signalTag2)) {
                            logLogcatTagsOfInterest();
                        } else if (LOG_EVENT_LOG_TAG.equals(signalTag2)) {
                            logEventLogTagsOfInterestIdleMode();
                        } else if (LOG_DALVIK_CACHE_TAG.equals(signalTag2)) {
                            logDalvikCacheFiles();
                        } else if (LOG_DEVICE_STATE_TAG.equals(signalTag2)) {
                            logDeviceStateIdleMode();
                        } else if (LOG_LOCALE_TAG.equals(signalTag2)) {
                            logLocaleIdleMode();
                        } else if (LOG_SELINUX_TAG.equals(signalTag2)) {
                            logSeLinuxInfoIdleMode();
                        } else {
                            Log.e(TAG, String.format("Unknown tag: %s", new Object[]{signalTag2}));
                        }
                    } catch (Exception e) {
                        this.mSnetIdleLogger.writeExceptionDetailed(e);
                        if (DONE_TAG.equals(lastSignalTag)) {
                            this.mSnetIdleLogger.writeToBackend(getVersion(), startTimeMs);
                        } else {
                            this.mSnetIdleLogger.saveProto(getVersion(), startTimeMs);
                        }
                        preferences.saveLastIdleModeTag(lastSignalTag);
                        return;
                    } catch (Throwable th) {
                        if (DONE_TAG.equals(lastSignalTag)) {
                            this.mSnetIdleLogger.writeToBackend(getVersion(), startTimeMs);
                        } else {
                            this.mSnetIdleLogger.saveProto(getVersion(), startTimeMs);
                        }
                        preferences.saveLastIdleModeTag(lastSignalTag);
                    }
                }
                int plugged = this.mCtx.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1);
                if (plugged != 1 && plugged != 2 && !signalTag2.equals(signalTagsArray[signalTagsArray.length - 1])) {
                    interrupted = true;
                    break;
                }
            }
            if (!interrupted) {
                lastSignalTag = DONE_TAG;
            }
        }
        if (DONE_TAG.equals(lastSignalTag)) {
            this.mSnetIdleLogger.writeToBackend(getVersion(), startTimeMs);
        } else {
            this.mSnetIdleLogger.saveProto(getVersion(), startTimeMs);
        }
        preferences.saveLastIdleModeTag(lastSignalTag);
    }

    private String idleWhitelistTags() {
        return this.mGBundle.getIsTargetedByGservices() ? this.mGBundle.getIdleSignalTagsWhitelist() : DEFAULT_IDLE_WHITELIST_TAGS;
    }

    private void updateExecutionPoint(String signalTag) {
        if (this.mGBundle.getLogExecutionPoints()) {
            EventLogger.writeExecutionCheckpointTag(signalTag);
        }
    }

    private void logPreferredPackages() {
        PreferredPackageFinder finder = new PreferredPackageFinder(this.mCtx);
        this.mSnetLogger.setPreferredBrowser(finder.findWebBrowser());
        this.mSnetLogger.setPreferredInstaller(finder.findPackageInstaller());
    }

    private void logFiles() {
        List<FilesInfo> filesInfoList = new ArrayList();
        filesInfoList.addAll(RootingFileFinder.findRootingFiles());
        List<String> selectedFiles = this.mGBundle.getSelectedFilePathList();
        if (selectedFiles != null && selectedFiles.size() > 0) {
            filesInfoList.addAll(FileFinder.findFiles(selectedFiles));
        }
        this.mSnetLogger.setFiles(filesInfoList);
    }

    private void logSettings() {
        this.mSnetLogger.setDeviceSettings(new SettingsFinder(this.mCtx, this.mGBundle).deviceSettings());
    }

    private void logLocale() {
        Resources resources = this.mCtx.getResources();
        if (resources != null) {
            this.mSnetLogger.setLocale(resources.getConfiguration().locale.toString());
        }
        this.mSnetLogger.setCountry(this.mGBundle.getDeviceCountry());
    }

    private List<SslRedirectInfo> logSslRedirectAnalysis() {
        NetworkAnalyzer networkAnalyzer = new NetworkAnalyzer(this.mCtx, this.mSnetLogger, this.mGBundle);
        this.mSnetLogger.setConnectionInfo(networkAnalyzer.connectionInfo());
        List<SslRedirectInfo> infoList = networkAnalyzer.analyzeSslRedirects();
        this.mSnetLogger.setSslRedirectInfo(infoList);
        return infoList;
    }

    private List<SslInfo> logSslHandshakeAnalysis() {
        SslHandshakeAnalyzer sslHandshakeAnalyzer = new SslHandshakeAnalyzer(this.mCtx, this.mSnetLogger, new SslHandshakeAnalyzerValues(), this.mGBundle);
        sslHandshakeAnalyzer.analyzeSslHandshake();
        List<SslInfo> infoList = sslHandshakeAnalyzer.sslInfoList();
        if (!infoList.isEmpty()) {
            this.mSnetLogger.setSslHandshakeInfo(infoList);
        }
        return infoList;
    }

    private void logHttpsSslv3FallbackAnalysis() {
        this.mSnetLogger.setSslv3Fallback(new HttpsSslv3FallbackAnalyzer(this.mCtx).analyze());
    }

    private void logSeLinuxInfo() {
        this.mSnetLogger.setSeLinuxInfo(SeLinuxCheckerSingleton.getInfo());
    }

    private void logSeLinuxInfoIdleMode() {
        this.mSnetIdleLogger.setSeLinuxInfo(SeLinuxCheckerSingleton.getInfo());
    }

    private void logEventLogTagsOfInterestNormalMode() {
        EventLogInfo eventLogInfo = new EventLogger(this.mCtx, this.mGBundle, this.mSnetLogger).getEventLogLogs();
        if (eventLogInfo != null) {
            this.mSnetLogger.setEventLogInfo(eventLogInfo);
        }
    }

    private void logProxyInfo() {
        ProxyInfo proxyInfo = new ProxyAnalyzer(this.mCtx).proxyInfo();
        if (proxyInfo != null) {
            proxyInfo.address = null;
            this.mSnetLogger.setProxyInfo(proxyInfo);
        }
    }

    private void logSdCardAnalysis() {
        this.mSnetLogger.setSdCardTampered(new SdCardAnalyzer(this.mCtx, this.mGBundle).sdCardTampered());
    }

    private void logApps() {
        this.mSnetLogger.setInstalledApps(new ApplicationInfoUtils(this.mCtx, this.mGBundle).apps());
    }

    private boolean hasGoogleAccount() {
        for (Account account : AccountManager.get(this.mCtx).getAccountsByType("com.google")) {
            if (account.name.endsWith(GOOGLE_ACCOUNT_SUFFIX)) {
                return true;
            }
        }
        return false;
    }

    private String getGoogleWebpageHtml() {
        return new NetworkAnalyzer(this.mCtx, this.mSnetLogger, this.mGBundle).getGoogleWebPage();
    }

    private void logGoogleWebpageHtml(String googleWebpageHtml) {
        this.mSnetLogger.setGoogleWebpageHtml(googleWebpageHtml);
    }

    private void logGooglePageInfo(String googleWebpageHtml) {
        if (googleWebpageHtml != null) {
            int threshold = this.mGBundle.getGoogleWebpageThreshold();
            if (threshold > 0) {
                this.mSnetLogger.setGoogleWebpageInfo(googleWebpageHtml.length(), threshold);
            }
        }
    }

    private void logMxRecords() {
        List<MxInfo> mxInfoList = new MxRecordHijackAnalyzer().getMxRecords();
        if (mxInfoList != null && !mxInfoList.isEmpty()) {
            this.mSnetLogger.setMxRecords(mxInfoList);
        }
    }

    private void logCaptivePortalTest() {
        this.mSnetLogger.setCaptivePortalTestResults(CaptivePortalDetector.captivePortalTest());
    }

    private void logAttestationResult() {
        Bundle attestBundle = this.mGBundle.getAttestBundle();
        if (attestBundle != null) {
            this.mSnetLogger.setAttestationResult(AttestationClient.attest(attestBundle));
        }
    }

    private void logGmsCoreInfo() {
        this.mSnetLogger.setGmsCoreInfo(new ApplicationInfoUtils(this.mCtx, this.mGBundle).appInfo("com.google.android.gms"));
    }

    private void logDeactivateDeviceAdmins() {
        try {
            this.mSnetLogger.setDeactivatedAdmins(DeviceAdminDeactivator.deactivateDeviceAdmins(this.mCtx));
        } catch (BadBlacklistException ex) {
            this.mSnetLogger.setInvalidBlacklistedDeviceAdmins(ex.blacklist);
        }
    }

    private void logSetuidFiles(long currentTimeMs) {
        this.mSnetIdleLogger.setSetuidFileInfo(new SetuidFileFinder(this.mCtx, new Os(), currentTimeMs).find());
    }

    private void logSystemPartitionFiles(long currentTimeMs) {
        SystemPartitionFileFinder systemPartitionFileFinder = new SystemPartitionFileFinder(this.mCtx, new Os(), currentTimeMs);
        String systemPartitionFilesOfInterest = this.mGBundle.getSystemPartitionFilesOfInterest();
        int numRandomSystemPartitionFiles = this.mGBundle.getNumRandomSystemPartitionFiles();
        this.mSnetIdleLogger.setSystemPartitionFileInfo(new SystemIntegrityChecker(this.mCtx, this.mGBundle).systemPartitionState(), systemPartitionFileFinder.getHashes(systemPartitionFilesOfInterest, numRandomSystemPartitionFiles));
    }

    private void logSystemCaCertStore() {
        this.mSnetIdleLogger.setSystemCaCertsInfo(new SystemCaStoreAnalyzer(this.mCtx, this.mGBundle).getSystemCaCerts(this.mGBundle.getNumRandomSystemCaCerts()));
    }

    private void logLogcatTagsOfInterest() {
        LogcatInfo info = new SnetLogcat(this.mCtx, this.mGBundle).scrape();
        if (info != null) {
            this.mSnetIdleLogger.setLogcatInfo(info);
        }
    }

    private void logEventLogTagsOfInterestIdleMode() {
        EventLogInfo eventLogInfo = new EventLogger(this.mCtx, this.mGBundle, this.mSnetLogger).getEventLogLogs();
        if (eventLogInfo != null) {
            this.mSnetIdleLogger.setEventLogInfo(eventLogInfo);
        }
    }

    private void logDalvikCacheFiles() {
        this.mSnetIdleLogger.setDalvikCacheChangedFiles(new DalvikCacheMonitor(this.mCtx).findModifiedDalvikCacheFiles(5));
    }

    private void logDeviceStateIdleMode() {
        this.mSnetIdleLogger.setDeviceState(DeviceStateChecker.getDeviceState(this.mCtx, this.mGBundle));
        if (VERSION.SDK_INT > 23) {
            this.mSnetIdleLogger.setDMVerityCorrectionInfo(new DMVerityFileFinder(this.mSnetIdleLogger).findCorrectionFiles());
        }
    }

    private void logDeviceState() {
        this.mSnetLogger.setDeviceState(DeviceStateChecker.getDeviceState(this.mCtx, this.mGBundle));
    }

    private void logLocaleIdleMode() {
        Resources resources = this.mCtx.getResources();
        if (resources != null) {
            this.mSnetIdleLogger.setLocale(resources.getConfiguration().locale.toString());
        }
        this.mSnetIdleLogger.setCountry(this.mGBundle.getDeviceCountry());
    }

    private void logCarrierInfo() {
        this.mSnetLogger.setCarrierName(((TelephonyManager) this.mCtx.getSystemService("phone")).getNetworkOperatorName());
    }
}

package com.google.android.snet;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.DropBoxManager;
import android.text.TextUtils;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.snet.FileFinder.FilesInfo;
import com.google.android.snet.MxRecordHijackAnalyzer.MxInfo;
import com.google.android.snet.MxRecordHijackAnalyzer.MxRecord;
import com.google.android.snet.NetworkAnalyzer.ConnectionInfo;
import com.google.android.snet.NetworkAnalyzer.SslRedirectInfo;
import com.google.android.snet.ProxyAnalyzer.ProxyInfo;
import com.google.android.snet.SdCardAnalyzer.SdCardAnalysisInfo;
import com.google.android.snet.SeLinuxCheckerSingleton.SeLinuxInfo;
import com.google.android.snet.SettingsFinder.DeviceSettings;
import com.google.android.snet.SslHandshakeAnalyzer.SslInfo;
import com.google.android.snet.nano.Logs;
import com.google.android.snet.nano.Logs.AppInfoNormal;
import com.google.android.snet.nano.Logs.AppsList;
import com.google.android.snet.nano.Logs.AttestationResult;
import com.google.android.snet.nano.Logs.CaptivePortalTestResults;
import com.google.android.snet.nano.Logs.CarrierInfo;
import com.google.android.snet.nano.Logs.DeviceStateNormal;
import com.google.android.snet.nano.Logs.DnsMxRecord;
import com.google.android.snet.nano.Logs.DnsMxRecords;
import com.google.android.snet.nano.Logs.EventLogNormal;
import com.google.android.snet.nano.Logs.FilePresence;
import com.google.android.snet.nano.Logs.GoogleWebpageInfo;
import com.google.android.snet.nano.Logs.OkHttpSslv3FallbackInfo;
import com.google.android.snet.nano.Logs.RunSettingsNormal;
import com.google.android.snet.nano.Logs.SdCardInfo;
import com.google.android.snet.nano.Logs.SeLinuxInfoNormal;
import com.google.android.snet.nano.Logs.SnetLog;
import com.google.android.snet.nano.Logs.SslHandshakeInfo;
import com.google.android.snet.nano.Logs.SystemPropertyNormal;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

class SnetLogger {
    private static final int APP_SHA256_LOGGING_ONLY = 1;
    private static final String CLEARCUT_ANDROID_SNET_JAR_LOG_SOURCE = "ANDROID_SNET_JAR";
    private static final boolean DEBUG = false;
    private static final int DROPBOX_FLAG_NONE = 0;
    private static final String DROPBOX_SNET_TAG = "snet";
    private static final int FULL_LOGGING = 2;
    private static final String TAG = SnetLogger.class.getCanonicalName();
    private final Context mContext;
    private DropBoxManager mDropBoxManager;
    private List<String> mExceptionsList;
    private GBundle mGBundle;
    private SnetLog mSnetLog = new SnetLog();

    SnetLogger(Context context, GBundle gBundle) {
        this.mDropBoxManager = (DropBoxManager) context.getSystemService("dropbox");
        this.mGBundle = gBundle;
        this.mContext = context;
        this.mExceptionsList = new ArrayList();
    }

    void writeException(Exception e) {
        this.mExceptionsList.add(e.toString());
    }

    void writeExceptionDetailed(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        String exceptionString = stringWriter.toString();
        if (this.mGBundle != null) {
            this.mExceptionsList.add(exceptionString.substring(0, Math.min(this.mGBundle.getMaxExceptionStringLength(), exceptionString.length())));
            return;
        }
        this.mExceptionsList.add(exceptionString);
    }

    void setPreferredBrowser(PackageInfo packageInfo) {
        if (packageInfo != null) {
            this.mSnetLog.preferredBrowser = new Logs.PackageInfo();
            if (packageInfo.packageName != null) {
                this.mSnetLog.preferredBrowser.packageName = packageInfo.packageName;
            }
            this.mSnetLog.preferredBrowser.versionCode = packageInfo.versionCode;
            if (packageInfo.versionName != null) {
                this.mSnetLog.preferredBrowser.versionName = packageInfo.versionName;
            }
            if ("android".equalsIgnoreCase(packageInfo.packageName)) {
                this.mSnetLog.preferredBrowser.noDefault = true;
            }
        }
    }

    void setPreferredInstaller(PackageInfo packageInfo) {
        if (packageInfo != null) {
            this.mSnetLog.preferredInstaller = new Logs.PackageInfo();
            if (packageInfo.packageName != null) {
                this.mSnetLog.preferredInstaller.packageName = packageInfo.packageName;
            }
            this.mSnetLog.preferredInstaller.versionCode = packageInfo.versionCode;
            if (packageInfo.versionName != null) {
                this.mSnetLog.preferredInstaller.versionName = packageInfo.versionName;
            }
            if ("android".equalsIgnoreCase(packageInfo.packageName)) {
                this.mSnetLog.preferredInstaller.noDefault = true;
            }
        }
    }

    void setFiles(List<FilesInfo> filesInfoList) {
        if (filesInfoList != null && filesInfoList.size() != 0) {
            FilePresence[] filePresence = new FilePresence[filesInfoList.size()];
            FilesInfo[] filesInfoArray = (FilesInfo[]) filesInfoList.toArray(new FilesInfo[0]);
            for (int i = 0; i < filesInfoArray.length; i++) {
                filePresence[i] = new FilePresence();
                if (filesInfoArray[i].filename != null) {
                    filePresence[i].filename = filesInfoArray[i].filename;
                }
                filePresence[i].present = filesInfoArray[i].present;
                if (filesInfoArray[i].sha256 != null) {
                    filePresence[i].sha256 = filesInfoArray[i].sha256;
                }
                filePresence[i].executable = filesInfoArray[i].executable;
                if (filesInfoArray[i].lstatStruct != null) {
                    LstatStruct lstatStruct = filesInfoArray[i].lstatStruct;
                    filePresence[i].mtime = lstatStruct.mtime;
                    filePresence[i].permissions = lstatStruct.mode;
                    filePresence[i].fileOwner = lstatStruct.uid;
                    filePresence[i].fileGroup = lstatStruct.gid;
                    if (lstatStruct.seLinuxSecurityContext != null) {
                        filePresence[i].seLinuxSecurityContext = lstatStruct.seLinuxSecurityContext;
                    }
                }
                filePresence[i].symlink = filesInfoArray[i].symlink;
                if (filesInfoArray[i].symlinkTarget != null) {
                    filePresence[i].symlinkTarget = filesInfoArray[i].symlinkTarget;
                }
            }
            this.mSnetLog.files = filePresence;
        }
    }

    void setDeviceSettings(DeviceSettings deviceSettings) {
        this.mSnetLog.settings = new Logs.DeviceSettings();
        this.mSnetLog.settings.adbEnabled = deviceSettings.adbEnabled;
        this.mSnetLog.settings.nonMarketAppsEnabled = deviceSettings.nonMarketAppsEnabled;
        this.mSnetLog.settings.lockScreenType = deviceSettings.lockScreenType;
        this.mSnetLog.settings.lockScreenTimeout = deviceSettings.lockScreenTimeout;
        this.mSnetLog.settings.lockScreenNotificationType = deviceSettings.notificationVisibility;
        this.mSnetLog.settings.smartLockStatusObtained = deviceSettings.smartLockStatusObtained;
        this.mSnetLog.settings.smartLockEnabled = deviceSettings.smartLockEnabled;
        this.mSnetLog.settings.storageEncryptionStatus = deviceSettings.storageEncryptionStatus;
    }

    void setLocale(String locale) {
        if (locale != null) {
            this.mSnetLog.locale = locale;
        }
    }

    void setCountry(String country) {
        if (country != null) {
            this.mSnetLog.country = country;
        }
    }

    void setConnectionInfo(ConnectionInfo connectionInfo) {
        if (connectionInfo != null) {
            this.mSnetLog.connectionInfo = new Logs.ConnectionInfo();
            this.mSnetLog.connectionInfo.activeConnectionType = connectionInfo.activeConnectionType;
            this.mSnetLog.connectionInfo.availableNetworkTypes = connectionInfo.availableNetworkTypes;
            if (connectionInfo.operatorName != null) {
                this.mSnetLog.connectionInfo.operatorName = connectionInfo.operatorName;
            }
            if (connectionInfo.dnsServers != null && connectionInfo.dnsServers.length > 0) {
                this.mSnetLog.connectionInfo.dnsServers = connectionInfo.dnsServers;
            }
        }
    }

    void setSslRedirectInfo(List<SslRedirectInfo> redirectInfoList) {
        if (redirectInfoList != null && redirectInfoList.size() != 0) {
            this.mSnetLog.sslRedirectList = new Logs.SslRedirectInfo[redirectInfoList.size()];
            SslRedirectInfo[] redirectInfoArray = (SslRedirectInfo[]) redirectInfoList.toArray(new SslRedirectInfo[0]);
            int i = 0;
            while (i < redirectInfoArray.length) {
                this.mSnetLog.sslRedirectList[i] = new Logs.SslRedirectInfo();
                if (redirectInfoArray[i].host != null) {
                    this.mSnetLog.sslRedirectList[i].host = redirectInfoArray[i].host;
                }
                this.mSnetLog.sslRedirectList[i].httpClientUsed = redirectInfoArray[i].httpClientUsed;
                this.mSnetLog.sslRedirectList[i].userAgentUsed = redirectInfoArray[i].userAgentUsed;
                this.mSnetLog.sslRedirectList[i].responseCode = redirectInfoArray[i].responseCode;
                this.mSnetLog.sslRedirectList[i].endPointConnected = redirectInfoArray[i].endPointConnected;
                if (redirectInfoArray[i].redirectHeaderValue != null) {
                    this.mSnetLog.sslRedirectList[i].redirectHeaderValue = redirectInfoArray[i].redirectHeaderValue;
                }
                if (redirectInfoArray[i].endPointUrl != null) {
                    this.mSnetLog.sslRedirectList[i].endPointUrl = redirectInfoArray[i].endPointUrl;
                }
                if (redirectInfoArray[i].ipAddressesForEndPointUrl != null && redirectInfoArray[i].ipAddressesForEndPointUrl.length > 0) {
                    this.mSnetLog.sslRedirectList[i].ipAddressesForEndPointUrl = redirectInfoArray[i].ipAddressesForEndPointUrl;
                }
                i++;
            }
        }
    }

    void setSslHandshakeInfo(List<SslInfo> sslInfoList) {
        if (sslInfoList != null && sslInfoList.size() != 0) {
            this.mSnetLog.sslHandshakeList = new SslHandshakeInfo[sslInfoList.size()];
            SslInfo[] sslInfoArray = (SslInfo[]) sslInfoList.toArray(new SslInfo[0]);
            for (int i = 0; i < sslInfoArray.length; i++) {
                this.mSnetLog.sslHandshakeList[i] = new SslHandshakeInfo();
                if (sslInfoArray[i].host != null) {
                    this.mSnetLog.sslHandshakeList[i].host = sslInfoArray[i].host;
                }
                this.mSnetLog.sslHandshakeList[i].sslConnectionMethod = sslInfoArray[i].sslConnectionMethod;
                if (sslInfoArray[i].peerCertificates != null) {
                    this.mSnetLog.sslHandshakeList[i].peerCertificates = logPeerCertificates(sslInfoArray[i].peerCertificates);
                }
                this.mSnetLog.sslHandshakeList[i].socketCreated = sslInfoArray[i].sslSocketCreated;
                this.mSnetLog.sslHandshakeList[i].sslConnectionSucceeded = sslInfoArray[i].sslConnectionSucceeded;
                this.mSnetLog.sslHandshakeList[i].sessionEstablished = sslInfoArray[i].sslSessionValid;
                if (sslInfoArray[i].protocol != null) {
                    this.mSnetLog.sslHandshakeList[i].protocol = sslInfoArray[i].protocol;
                }
                if (sslInfoArray[i].cipherSuite != null) {
                    this.mSnetLog.sslHandshakeList[i].cipherSuite = sslInfoArray[i].cipherSuite;
                }
                this.mSnetLog.sslHandshakeList[i].peerCertificatesAcquired = sslInfoArray[i].sslPeerCertificatesRetrieved;
                this.mSnetLog.sslHandshakeList[i].systemTrustManagerExists = sslInfoArray[i].x509TrustManagerExists;
                if (sslInfoArray[i].x509TrustManagerExists) {
                    this.mSnetLog.sslHandshakeList[i].systemTrustManagerAcceptedConnection = sslInfoArray[i].x509TrustManagerAcceptedConnection;
                }
                this.mSnetLog.sslHandshakeList[i].hostnameVerified = sslInfoArray[i].hostnameVerificationSucceeded;
                this.mSnetLog.sslHandshakeList[i].chainValid = sslInfoArray[i].chainIsValid;
                this.mSnetLog.sslHandshakeList[i].chainTrusted = sslInfoArray[i].chainIsTrusted;
                this.mSnetLog.sslHandshakeList[i].pinTestError = sslInfoArray[i].pinTestError;
                this.mSnetLog.sslHandshakeList[i].certUserAdded = sslInfoArray[i].certUserAdded;
                this.mSnetLog.sslHandshakeList[i].certInCaStore = sslInfoArray[i].certInCaStore;
                this.mSnetLog.sslHandshakeList[i].extendedKeyUsageFieldValid = sslInfoArray[i].extendedKeyUsageVerified;
            }
        }
    }

    void setSslv3Fallback(Result result) {
        this.mSnetLog.sslv3Fallback = new OkHttpSslv3FallbackInfo();
        this.mSnetLog.sslv3Fallback.initialConnAttempted = result.initialConnectionAttempted;
        this.mSnetLog.sslv3Fallback.initialConnSucceeded = result.initialConnectionSucceeded;
        this.mSnetLog.sslv3Fallback.retryAttempted = result.retryAttempted;
        this.mSnetLog.sslv3Fallback.retrySucceeded = result.retrySucceeded;
        this.mSnetLog.sslv3Fallback.retryUsedModernTls = result.retryUsedModernTls;
    }

    byte[][] logPeerCertificates(Certificate[] peerCertificates) {
        if (peerCertificates == null || peerCertificates.length == 0) {
            return WireFormatNano.EMPTY_BYTES_ARRAY;
        }
        byte[][] outPeerCertificates = new byte[peerCertificates.length][];
        int certIndex = 0;
        for (Certificate cert : peerCertificates) {
            try {
                outPeerCertificates[certIndex] = cert.getEncoded();
                certIndex++;
            } catch (CertificateEncodingException e) {
            }
        }
        return outPeerCertificates;
    }

    void setSeLinuxInfo(SeLinuxInfo info) {
        this.mSnetLog.seLinuxInfo = new SeLinuxInfoNormal();
        this.mSnetLog.seLinuxInfo.present = info.present;
        this.mSnetLog.seLinuxInfo.enforcing = info.enforcing;
    }

    void setEventLogInfo(EventLogInfo eventLogInfo) {
        this.mSnetLog.firstEventLogTimeNano = eventLogInfo.firstEventLogTimeNano;
        List<EventData> events = eventLogInfo.eventDataList;
        if (events != null && !events.isEmpty()) {
            this.mSnetLog.events = new EventLogNormal[events.size()];
            EventData[] eventsArray = (EventData[]) events.toArray(new EventData[0]);
            int i = 0;
            while (i < eventsArray.length) {
                this.mSnetLog.events[i] = new EventLogNormal();
                if (eventsArray[i] != null) {
                    this.mSnetLog.events[i].tag = eventsArray[i].tag;
                    this.mSnetLog.events[i].subTag = eventsArray[i].subTag == null ? "" : eventsArray[i].subTag;
                    this.mSnetLog.events[i].data = eventsArray[i].data == null ? "" : eventsArray[i].data;
                    this.mSnetLog.events[i].timeNanos = eventsArray[i].timeNanos;
                    if (!(eventsArray[i].appInfoList == null || eventsArray[i].appInfoList.size() == 0)) {
                        this.mSnetLog.events[i].appInfo = new AppInfoNormal[eventsArray[i].appInfoList.size()];
                        List<AppInfo> appInfoList = eventsArray[i].appInfoList;
                        for (int j = 0; j < appInfoList.size(); j++) {
                            this.mSnetLog.events[i].appInfo[j] = convertAppInfo((AppInfo) appInfoList.get(j), true);
                        }
                    }
                }
                i++;
            }
        }
    }

    void setProxyInfo(ProxyInfo proxyInfo) {
        this.mSnetLog.proxyInfo = new Logs.ProxyInfo();
        this.mSnetLog.proxyInfo.present = proxyInfo.present;
        this.mSnetLog.proxyInfo.localIp = proxyInfo.localIp;
        if (proxyInfo.address != null) {
            this.mSnetLog.proxyInfo.address = proxyInfo.address;
        }
    }

    void setSdCardTampered(SdCardAnalysisInfo sdCardTamperedInfo) {
        if (sdCardTamperedInfo != null) {
            this.mSnetLog.sdCardTamperedInfo = new SdCardInfo();
            this.mSnetLog.sdCardTamperedInfo.jpegMissing = sdCardTamperedInfo.jpegMissing;
            this.mSnetLog.sdCardTamperedInfo.jpegTampered = sdCardTamperedInfo.jpegTampered;
            this.mSnetLog.sdCardTamperedInfo.jpegWrongLength = sdCardTamperedInfo.jpegWrongLength;
            this.mSnetLog.sdCardTamperedInfo.jpegTamperedBytes = sdCardTamperedInfo.jpegTamperedBytes;
            this.mSnetLog.sdCardTamperedInfo.jpegNewlyTampered = sdCardTamperedInfo.jpegNewlyTampered;
            if (sdCardTamperedInfo.jpegFileName != null) {
                this.mSnetLog.sdCardTamperedInfo.jpegFileName = sdCardTamperedInfo.jpegFileName;
            }
            this.mSnetLog.sdCardTamperedInfo.jpegModificationTime = sdCardTamperedInfo.jpegModificationTime;
        }
    }

    void setInstalledApps(List<AppInfo> appsInfo) {
        if (!appsInfo.isEmpty()) {
            this.mSnetLog.appsList = new AppsList();
            boolean logMoreAppInfo = this.mGBundle.getReportMoreAppInfo();
            this.mSnetLog.appsList.loggingOptions = logMoreAppInfo ? 2 : 1;
            this.mSnetLog.appsList.reportSystemApps = this.mGBundle.getReportSystemApps();
            this.mSnetLog.appsList.reportNonSystemApps = this.mGBundle.getReportNonSystemApps();
            this.mSnetLog.appsList.appsInfo = new AppInfoNormal[appsInfo.size()];
            for (int i = 0; i < appsInfo.size(); i++) {
                this.mSnetLog.appsList.appsInfo[i] = convertAppInfo((AppInfo) appsInfo.get(i), logMoreAppInfo);
            }
        }
    }

    void setGoogleWebpageHtml(String html) {
        if (html != null) {
            this.mSnetLog.googleWebpageHtml = html;
        }
    }

    void setGoogleWebpageInfo(int webpageLength, int lengthThreshold) {
        boolean z = true;
        this.mSnetLog.googleWebpageInfo = new GoogleWebpageInfo();
        this.mSnetLog.googleWebpageInfo.fetched = true;
        GoogleWebpageInfo googleWebpageInfo = this.mSnetLog.googleWebpageInfo;
        if (webpageLength <= lengthThreshold) {
            z = DEBUG;
        }
        googleWebpageInfo.lengthExceedsThreshold = z;
        this.mSnetLog.googleWebpageInfo.lengthThreshold = lengthThreshold;
    }

    void setMxRecords(List<MxInfo> mxRecordsList) {
        this.mSnetLog.dnsMxRecords = new DnsMxRecords[mxRecordsList.size()];
        for (int i = 0; i < this.mSnetLog.dnsMxRecords.length; i++) {
            int j;
            MxInfo currentRecords = (MxInfo) mxRecordsList.get(i);
            this.mSnetLog.dnsMxRecords[i] = new DnsMxRecords();
            if (currentRecords.domainName != null) {
                this.mSnetLog.dnsMxRecords[i].domainName = currentRecords.domainName;
            }
            if (currentRecords.dnsServer != null) {
                this.mSnetLog.dnsMxRecords[i].dnsServerQueried = currentRecords.dnsServer;
            }
            if (currentRecords.rawDnsQueryResponse != null) {
                int maxLength = this.mGBundle.getMaxDnsQueryResponseLength();
                if (maxLength == 0 || currentRecords.rawDnsQueryResponse.length <= maxLength) {
                    this.mSnetLog.dnsMxRecords[i].rawDnsQueryResponse = currentRecords.rawDnsQueryResponse;
                } else {
                    this.mSnetLog.dnsMxRecords[i].rawDnsQueryResponse = new byte[maxLength];
                    for (j = 0; j < maxLength; j++) {
                        this.mSnetLog.dnsMxRecords[i].rawDnsQueryResponse[j] = currentRecords.rawDnsQueryResponse[j];
                    }
                }
            }
            if (!(currentRecords.mxRecordsList == null || currentRecords.mxRecordsList.isEmpty())) {
                int numServers = currentRecords.mxRecordsList.size();
                this.mSnetLog.dnsMxRecords[i].servers = new DnsMxRecord[numServers];
                for (j = 0; j < numServers; j++) {
                    MxRecord currentRecord = (MxRecord) currentRecords.mxRecordsList.get(j);
                    this.mSnetLog.dnsMxRecords[i].servers[j] = new DnsMxRecord();
                    if (currentRecord.mailServerName != null) {
                        this.mSnetLog.dnsMxRecords[i].servers[j].mailServerName = currentRecord.mailServerName;
                    }
                    if (!(currentRecord.ipAddressesList == null || currentRecord.ipAddressesList.isEmpty())) {
                        this.mSnetLog.dnsMxRecords[i].servers[j].mailServerIpAddresses = (String[]) currentRecord.ipAddressesList.toArray(new String[0]);
                    }
                }
            }
        }
    }

    void setFeaturesBitField(byte[] bitField) {
        if (bitField != null) {
            this.mSnetLog.featuresBitField = bitField;
        }
    }

    void setBuildFingerprint(String buildFingerprint) {
        if (buildFingerprint != null) {
            this.mSnetLog.buildFingerprint = buildFingerprint;
        }
    }

    void setCaptivePortalTestResults(Results results) {
        if (results != null) {
            this.mSnetLog.captivePortalTestResults = new CaptivePortalTestResults();
            if (results.ipAddressUsed != null) {
                this.mSnetLog.captivePortalTestResults.ipAddressUsed = results.ipAddressUsed;
            }
            this.mSnetLog.captivePortalTestResults.responseCode = results.responseCode;
            this.mSnetLog.captivePortalTestResults.bodyEmpty = results.bodyEmpty;
            this.mSnetLog.captivePortalTestResults.userAgentUsed = results.userAgentIndex;
        }
    }

    void setSignalTagsWhitelist(String signalTagsWhitelist) {
        if (signalTagsWhitelist != null) {
            this.mSnetLog.signalTagsWhitelist = signalTagsWhitelist;
        }
    }

    void setAttestationResult(AttestationInfo info) {
        this.mSnetLog.attestationResult = new AttestationResult();
        if (info == null) {
            this.mSnetLog.attestationResult.errorMsg = "Null info";
            return;
        }
        if (info.errorMsg != null) {
            this.mSnetLog.attestationResult.errorMsg = info.errorMsg;
        }
        this.mSnetLog.attestationResult.statusCode = info.statusCode;
        if (info.certChainSha256 != null) {
            this.mSnetLog.attestationResult.certChainSha256 = info.certChainSha256;
        }
        if (info.data != null) {
            this.mSnetLog.attestationResult.jsonData = info.data;
        }
        if (info.signature != null) {
            this.mSnetLog.attestationResult.signature = info.signature;
        }
    }

    void setGmsCoreInfo(AppInfo appInfo) {
        if (appInfo != null && appInfo.packageName != null) {
            this.mSnetLog.gmsCoreInfo = convertAppInfo(appInfo, true);
        }
    }

    void setDeactivatedAdmins(List<AppInfo> deactivatedDeviceAdmins) {
        this.mSnetLog.deactivatedDeviceAdmins = new AppInfoNormal[deactivatedDeviceAdmins.size()];
        for (int i = 0; i < deactivatedDeviceAdmins.size(); i++) {
            this.mSnetLog.deactivatedDeviceAdmins[i] = convertAppInfo((AppInfo) deactivatedDeviceAdmins.get(i), true);
        }
    }

    void setInvalidBlacklistedDeviceAdmins(DeviceAdminBlacklist blacklist) {
        List<String> allPackageNames = new ArrayList(blacklist.getAllPackageNames());
        Collections.shuffle(allPackageNames);
        List<String> includedPackageNames = new ArrayList();
        int charCount = 0;
        for (String packageName : allPackageNames) {
            charCount += packageName.length();
            if (charCount > 1024) {
                if (packageName.length() > 1024) {
                    includedPackageNames.add(String.valueOf(packageName.substring(1021)).concat("..."));
                } else {
                    includedPackageNames.add(packageName);
                }
                this.mSnetLog.invalidBlacklistedDeviceAdmins = (String[]) includedPackageNames.toArray(new String[includedPackageNames.size()]);
            }
            includedPackageNames.add(packageName);
        }
        this.mSnetLog.invalidBlacklistedDeviceAdmins = (String[]) includedPackageNames.toArray(new String[includedPackageNames.size()]);
    }

    private static AppInfoNormal convertAppInfo(AppInfo appInfo, boolean logMoreAppInfo) {
        if (appInfo == null) {
            return null;
        }
        AppInfoNormal appInfoProto = new AppInfoNormal();
        appInfoProto.systemApp = appInfo.systemApp;
        if (appInfo.apkSha256Bytes != null) {
            appInfoProto.apkSha256Bytes = appInfo.apkSha256Bytes;
        }
        if (!logMoreAppInfo) {
            return appInfoProto;
        }
        if (appInfo.packageName != null) {
            appInfoProto.packageName = appInfo.packageName;
        }
        if (appInfo.signatureSha256Bytes == null || appInfo.signatureSha256Bytes.length == 0) {
            return appInfoProto;
        }
        int numSignatures = appInfo.signatureSha256Bytes.length;
        appInfoProto.signatureSha256Bytes = new byte[numSignatures][];
        for (int i = 0; i < numSignatures; i++) {
            if (appInfo.signatureSha256Bytes[i] != null) {
                appInfoProto.signatureSha256Bytes[i] = appInfo.signatureSha256Bytes[i];
            }
        }
        return appInfoProto;
    }

    void writeToBackend(int version, long startTimeMs) {
        this.mSnetLog.jarVersion = (long) version;
        String sharedUuid = this.mGBundle.getSharedUuid();
        if (sharedUuid != null) {
            this.mSnetLog.sharedUuid = sharedUuid;
        }
        String sessionUuid = this.mGBundle.getUuid();
        if (TextUtils.isEmpty(sessionUuid)) {
            this.mSnetLog.uuid = UUID.randomUUID().toString();
            this.mSnetLog.gmsCoreUuidUsed = DEBUG;
        } else {
            this.mSnetLog.uuid = sessionUuid;
            this.mSnetLog.gmsCoreUuidUsed = true;
        }
        setBuildFingerprint(Build.FINGERPRINT);
        String debugStatus = this.mGBundle.getDebugStatus();
        if (!TextUtils.isEmpty(debugStatus)) {
            this.mSnetLog.debugStatus = debugStatus;
        }
        setRunSettings(startTimeMs);
        this.mSnetLog.isSidewinderDevice = this.mGBundle.getIsSidewinderDevice();
        if (this.mExceptionsList.size() > 0) {
            this.mSnetLog.jarExceptions = (String[]) this.mExceptionsList.toArray(new String[0]);
        }
        if (this.mGBundle.getClearcutJarLoggingEnabled()) {
            GoogleApiClient googleApiClient = new Builder(this.mContext).addApi(ClearcutLogger.API).build();
            googleApiClient.connect();
            ClearcutLogger clearcutLogger = ClearcutLogger.anonymousLogger(this.mContext, CLEARCUT_ANDROID_SNET_JAR_LOG_SOURCE);
            clearcutLogger.newEvent(MessageNano.toByteArray(this.mSnetLog)).logAsync(googleApiClient);
            clearcutLogger.disconnectAsync(googleApiClient);
        }
        if (this.mGBundle.getDropboxJarLoggingEnabled()) {
            this.mDropBoxManager.addData(DROPBOX_SNET_TAG, MessageNano.toByteArray(this.mSnetLog), 0);
        }
        this.mSnetLog = new SnetLog();
    }

    SnetLog proto() {
        return this.mSnetLog;
    }

    private void setRunSettings(long startTimeMs) {
        this.mSnetLog.runSettings = new RunSettingsNormal();
        long currentTimeMs = System.currentTimeMillis();
        this.mSnetLog.runSettings.currentTimeMs = currentTimeMs;
        this.mSnetLog.runSettings.executionTimeMs = currentTimeMs - startTimeMs;
        this.mSnetLog.runSettings.wakeIntervalMs = this.mGBundle.getWakeIntervalMs();
        SnetSharedPreferences preferences = new SnetSharedPreferences(this.mContext);
        if (preferences != null) {
            long lastRunTimestampMs = preferences.lastNormalModeRunTimestampMs();
            if (lastRunTimestampMs == -1) {
                preferences.saveLastNormalModeRunTimestampMs(currentTimeMs);
                return;
            }
            this.mSnetLog.runSettings.durationSinceLastRunMs = currentTimeMs - lastRunTimestampMs;
            preferences.saveLastNormalModeRunTimestampMs(currentTimeMs);
        }
    }

    private static void logProto(MessageNano message) {
    }

    void setDeviceState(DeviceState deviceState) {
        this.mSnetLog.deviceState = new DeviceStateNormal();
        if (deviceState.verifiedBootState != null) {
            this.mSnetLog.deviceState.verifiedBootState = deviceState.verifiedBootState;
        }
        if (deviceState.verityMode != null) {
            this.mSnetLog.deviceState.verityMode = deviceState.verityMode;
        }
        this.mSnetLog.deviceState.oemUnlockSupported = deviceState.oemUnlockSupported;
        this.mSnetLog.deviceState.oemLocked = deviceState.oemLocked;
        if (deviceState.securityPatchLevel != null) {
            this.mSnetLog.deviceState.securityPatchLevel = deviceState.securityPatchLevel;
        }
        if (deviceState.productBrand != null) {
            this.mSnetLog.deviceState.productBrand = deviceState.productBrand;
        }
        if (deviceState.productModel != null) {
            this.mSnetLog.deviceState.productModel = deviceState.productModel;
        }
        if (deviceState.kernelVersion != null) {
            this.mSnetLog.deviceState.kernelVersion = deviceState.kernelVersion;
        }
        if (deviceState.systemPropertyList != null && !deviceState.systemPropertyList.isEmpty()) {
            SystemPropertyNormal[] systemProperties = new SystemPropertyNormal[deviceState.systemPropertyList.size()];
            SystemProperty[] systemPropertyArray = (SystemProperty[]) deviceState.systemPropertyList.toArray(new SystemProperty[0]);
            for (int i = 0; i < systemProperties.length; i++) {
                systemProperties[i] = new SystemPropertyNormal();
                if (systemPropertyArray[i].name != null) {
                    systemProperties[i].name = systemPropertyArray[i].name;
                }
                if (systemPropertyArray[i].value != null) {
                    systemProperties[i].value = systemPropertyArray[i].value;
                }
            }
            this.mSnetLog.deviceState.systemProperty = systemProperties;
        }
    }

    void setCarrierName(String name) {
        this.mSnetLog.carrierInfo = new CarrierInfo();
        if (name != null) {
            this.mSnetLog.carrierInfo.carrierName = name;
        }
    }
}

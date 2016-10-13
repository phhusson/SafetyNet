package com.google.android.gms.common.download;

import com.google.android.gms.common.api.CommonStatusCodes;

public class DownloadStatusCodes extends CommonStatusCodes {
    public static final int DONE = 0;
    public static final int ERROR = 13;
    public static final int IN_PROGRESS = 7001;
    public static final int NOT_ALLOWED = 7002;
    public static final int PENDING = 7000;

    private DownloadStatusCodes() {
    }

    public static String getStatusCodeString(int statusCode) {
        switch (statusCode) {
            case PENDING /*7000*/:
                return "PENDING";
            case IN_PROGRESS /*7001*/:
                return "IN_PROGRESS";
            case NOT_ALLOWED /*7002*/:
                return "NOT_ALLOWED";
            default:
                return CommonStatusCodes.getStatusCodeString(statusCode);
        }
    }
}

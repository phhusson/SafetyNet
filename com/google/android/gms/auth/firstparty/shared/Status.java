package com.google.android.gms.auth.firstparty.shared;

public enum Status {
    CLIENT_LOGIN_DISABLED("ClientLoginDisabled"),
    DEVICE_MANAGEMENT_REQUIRED("DeviceManagementRequiredOrSyncDisabled"),
    SOCKET_TIMEOUT("SocketTimeout"),
    SUCCESS("Ok"),
    UNKNOWN_ERROR("UNKNOWN_ERR"),
    NETWORK_ERROR("NetworkError"),
    SERVICE_UNAVAILABLE("ServiceUnavailable"),
    INTNERNAL_ERROR("InternalError"),
    BAD_AUTHENTICATION("BadAuthentication"),
    EMPTY_CONSUMER_PKG_OR_SIG("EmptyConsumerPackageOrSig"),
    NEEDS_2F("InvalidSecondFactor"),
    NEEDS_POST_SIGN_IN_FLOW("PostSignInFlowRequired"),
    NEEDS_BROWSER("NeedsBrowser"),
    UNKNOWN("Unknown"),
    NOT_VERIFIED("NotVerified"),
    TERMS_NOT_AGREED("TermsNotAgreed"),
    ACCOUNT_DISABLED("AccountDisabled"),
    CAPTCHA("CaptchaRequired"),
    ACCOUNT_DELETED("AccountDeleted"),
    SERVICE_DISABLED("ServiceDisabled"),
    NEED_PERMISSION("NeedPermission"),
    INVALID_SCOPE("INVALID_SCOPE"),
    USER_CANCEL("UserCancel"),
    PERMISSION_DENIED("PermissionDenied"),
    THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED("ThirdPartyDeviceManagementRequired"),
    DM_INTERNAL_ERROR("DeviceManagementInternalError"),
    DM_SYNC_DISABLED("DeviceManagementSyncDisabled"),
    DM_ADMIN_BLOCKED("DeviceManagementAdminBlocked"),
    DM_ADMIN_PENDING_APPROVAL("DeviceManagementAdminPendingApproval"),
    DM_STALE_SYNC_REQUIRED("DeviceManagementStaleSyncRequired"),
    DM_DEACTIVATED("DeviceManagementDeactivated"),
    DM_REQUIRED("DeviceManagementRequired"),
    REAUTH_REQUIRED("ReauthRequired"),
    ALREADY_HAS_GMAIL("ALREADY_HAS_GMAIL"),
    BAD_PASSWORD("WeakPassword"),
    BAD_REQUEST("BadRequest"),
    BAD_USERNAME("BadUsername"),
    DELETED_GMAIL("DeletedGmail"),
    EXISTING_USERNAME("ExistingUsername"),
    LOGIN_FAIL("LoginFail"),
    NOT_LOGGED_IN("NotLoggedIn"),
    NO_GMAIL("NoGmail"),
    REQUEST_DENIED("RequestDenied"),
    SERVER_ERROR("ServerError"),
    USERNAME_UNAVAILABLE("UsernameUnavailable"),
    GPLUS_OTHER("GPlusOther"),
    GPLUS_NICKNAME("GPlusNickname"),
    GPLUS_INVALID_CHAR("GPlusInvalidChar"),
    GPLUS_INTERSTITIAL("GPlusInterstitial"),
    GPLUS_PROFILE_ERROR("ProfileUpgradeError");
    
    public static final String EXTRA_KEY_STATUS = "Error";
    public static final String JSON_KEY_STATUS = "status";
    private final String zzacz;

    private Status(String gaiaErrorCode) {
        this.zzacz = gaiaErrorCode;
    }

    public static final Status fromWireCode(String wireCode) {
        Status status = null;
        Status[] values = values();
        int length = values.length;
        int i = 0;
        while (i < length) {
            Status status2 = values[i];
            if (!status2.zzacz.equals(wireCode)) {
                status2 = status;
            }
            i++;
            status = status2;
        }
        return status;
    }

    public static boolean isDmAgentError(Status status) {
        return DEVICE_MANAGEMENT_REQUIRED.equals(status) || DM_INTERNAL_ERROR.equals(status) || DM_SYNC_DISABLED.equals(status) || DM_ADMIN_BLOCKED.equals(status) || DM_ADMIN_PENDING_APPROVAL.equals(status) || DM_STALE_SYNC_REQUIRED.equals(status) || DM_DEACTIVATED.equals(status) || DM_REQUIRED.equals(status);
    }

    public static boolean isRetryableError(Status status) {
        return NETWORK_ERROR.equals(status) || SERVICE_UNAVAILABLE.equals(status);
    }

    public static boolean isUserRecoverableError(Status status) {
        return BAD_AUTHENTICATION.equals(status) || CAPTCHA.equals(status) || NEED_PERMISSION.equals(status) || NEEDS_BROWSER.equals(status) || USER_CANCEL.equals(status) || THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.equals(status) || isDmAgentError(status);
    }

    public boolean equals(String err) {
        return this.zzacz.equals(err);
    }

    public String getWire() {
        return this.zzacz;
    }
}

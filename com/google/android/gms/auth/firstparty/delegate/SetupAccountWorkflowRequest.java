package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SetupAccountWorkflowRequest implements SafeParcelable {
    public static final SetupAccountWorkflowRequestCreator CREATOR = new SetupAccountWorkflowRequestCreator();
    public String accountName;
    public final String accountType;
    public List<String> allowedDomains;
    public AccountAuthenticatorResponse amResponse;
    public final AppDescription callingAppDescription;
    public boolean isCreditCardAllowed;
    public boolean isMultiUser;
    public boolean isSetupWizard;
    public Bundle options;
    public String purchaserGaiaEmail;
    public String purchaserName;
    public boolean suppressD2d;
    public boolean useImmersiveMode;
    public final int version;

    public SetupAccountWorkflowRequest(int version, boolean isMultiUser, boolean isSetupWizard, List<String> allowedDomains, Bundle options, AppDescription callingAppDescription, boolean isCreditCardAllowed, String accountType, AccountAuthenticatorResponse amResponse, boolean suppressD2d, boolean useImmersiveMode, String purchaserGaiaEmail, String purchaserName, String accountName) {
        this.version = version;
        this.isMultiUser = isMultiUser;
        this.isSetupWizard = isSetupWizard;
        this.allowedDomains = allowedDomains;
        this.options = options;
        this.callingAppDescription = (AppDescription) zzx.zzD(callingAppDescription);
        this.isCreditCardAllowed = isCreditCardAllowed;
        this.accountType = accountType;
        this.amResponse = amResponse;
        this.suppressD2d = suppressD2d;
        this.useImmersiveMode = useImmersiveMode;
        this.purchaserGaiaEmail = purchaserGaiaEmail;
        this.purchaserName = purchaserName;
        this.accountName = accountName;
    }

    public SetupAccountWorkflowRequest(AppDescription callingAppDescription, String accountType) {
        this.version = 5;
        this.options = new Bundle();
        this.callingAppDescription = callingAppDescription;
        this.accountType = accountType;
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getAccountName() {
        return this.accountName;
    }

    public List<String> getAllowedDomains() {
        return this.allowedDomains == null ? null : Collections.unmodifiableList(this.allowedDomains);
    }

    public AccountAuthenticatorResponse getAmResponse() {
        return this.amResponse;
    }

    public Bundle getOptions() {
        return new Bundle(this.options);
    }

    public String getPurchaserGaiaEmail() {
        return this.purchaserGaiaEmail;
    }

    public String getPurchaserName() {
        return this.purchaserName;
    }

    @Deprecated
    public boolean isBackupAccount() {
        return this.isSetupWizard;
    }

    public boolean isCreditCardAllowed() {
        return this.isCreditCardAllowed;
    }

    public boolean isMultiUser() {
        return this.isMultiUser;
    }

    public boolean isSetupWizard() {
        return this.isSetupWizard;
    }

    public SetupAccountWorkflowRequest setAccountName(@Nullable String accountName) {
        this.accountName = accountName;
        return this;
    }

    public SetupAccountWorkflowRequest setAllowedDomains(Collection<String> allowedDomains) {
        if (allowedDomains != null) {
            this.allowedDomains = new ArrayList(allowedDomains);
        } else {
            this.allowedDomains = null;
        }
        return this;
    }

    public SetupAccountWorkflowRequest setAmResponse(AccountAuthenticatorResponse amResponse) {
        this.amResponse = amResponse;
        return this;
    }

    @Deprecated
    public SetupAccountWorkflowRequest setBackupAccount(boolean isBackup) {
        return setIsSetupWizard(isBackup);
    }

    public SetupAccountWorkflowRequest setIsCreditCardAllowed(boolean isCreditCardAllowed) {
        this.isCreditCardAllowed = isCreditCardAllowed;
        return this;
    }

    public SetupAccountWorkflowRequest setIsSetupWizard(boolean isSetupWizard) {
        this.isSetupWizard = isSetupWizard;
        return this;
    }

    public SetupAccountWorkflowRequest setMultiUser(boolean isMultiUser) {
        this.isMultiUser = isMultiUser;
        return this;
    }

    public SetupAccountWorkflowRequest setOptions(Bundle options) {
        this.options.clear();
        if (options != null) {
            this.options.putAll(options);
        }
        return this;
    }

    public SetupAccountWorkflowRequest setPurchaserGaiaEmail(String purchaserGaiaEmail) {
        this.purchaserGaiaEmail = purchaserGaiaEmail;
        return this;
    }

    public SetupAccountWorkflowRequest setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
        return this;
    }

    public SetupAccountWorkflowRequest setSuppressD2d(boolean suppressD2d) {
        this.suppressD2d = suppressD2d;
        return this;
    }

    public SetupAccountWorkflowRequest setUseImmersiveMode(boolean useImmersiveMode) {
        this.useImmersiveMode = useImmersiveMode;
        return this;
    }

    public boolean suppressD2d() {
        return this.suppressD2d;
    }

    public boolean useImmersiveMode() {
        return this.useImmersiveMode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        SetupAccountWorkflowRequestCreator.zza(this, dest, flags);
    }
}

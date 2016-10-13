package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GoogleAccountSetupRequest implements SafeParcelable {
    public static final GoogleAccountSetupRequestCreator CREATOR = new GoogleAccountSetupRequestCreator();
    AppDescription callingAppDescription;
    String firstName;
    String gender;
    String lastName;
    Bundle options;
    String phoneCountryCode;
    String phoneNumber;
    String secondaryEmail;
    final int version;
    boolean zzaaA;
    AccountCredentials zzaaB;
    CaptchaSolution zzaaf;
    boolean zzaaz;
    boolean zzabd;
    boolean zzabe;
    boolean zzabf;
    boolean zzabg;
    String zzabh;

    public GoogleAccountSetupRequest() {
        this.version = 1;
        this.options = new Bundle();
    }

    GoogleAccountSetupRequest(int version, Bundle options, boolean isAgreedToWebHistory, boolean isAgreedToPersonalizedContent, boolean isAgreedToMobileTos, String firstName, String lastName, String secondaryEmail, String gender, boolean isCreatingAccount, boolean isAddingAccount, boolean isSetupWizardInProgress, String ropRevision, AppDescription callingAppDescription, AccountCredentials accountCredentials, CaptchaSolution optionalCaptchaSolution, String phoneNumber, String phoneCountryCode) {
        this.version = version;
        this.options = options;
        this.zzabd = isAgreedToWebHistory;
        this.zzabe = isAgreedToPersonalizedContent;
        this.zzabf = isAgreedToMobileTos;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondaryEmail = secondaryEmail;
        this.gender = gender;
        this.zzaaz = isCreatingAccount;
        this.zzabg = isAddingAccount;
        this.zzaaA = isSetupWizardInProgress;
        this.zzabh = ropRevision;
        this.callingAppDescription = callingAppDescription;
        this.zzaaB = accountCredentials;
        this.zzaaf = optionalCaptchaSolution;
        this.phoneNumber = phoneNumber;
        this.phoneCountryCode = phoneCountryCode;
    }

    public int describeContents() {
        return 0;
    }

    public AccountCredentials getAccountCredentials() {
        return this.zzaaB;
    }

    public AppDescription getCallingAppDescription() {
        return this.callingAppDescription;
    }

    public CaptchaSolution getCaptchaSolution() {
        return this.zzaaf;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getGender() {
        return this.gender;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Bundle getOptions() {
        return new Bundle(this.options);
    }

    public String getPhoneCountryCode() {
        return this.phoneCountryCode;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getRopRevision() {
        return this.zzabh;
    }

    public String getSecondaryEmail() {
        return this.secondaryEmail;
    }

    public boolean isAddingAccount() {
        return this.zzabg;
    }

    public boolean isAgreedToMobileTos() {
        return this.zzabf;
    }

    public boolean isAgreedToPersonalizedContent() {
        return this.zzabe;
    }

    public boolean isAgreedToWebHistory() {
        return this.zzabd;
    }

    public boolean isCreatingAccount() {
        return this.zzaaz;
    }

    public boolean isSetupWizardInProgress() {
        return this.zzaaA;
    }

    public GoogleAccountSetupRequest setAccountCredentials(AccountCredentials accountCredentials) {
        this.zzaaB = accountCredentials;
        return this;
    }

    public GoogleAccountSetupRequest setAddingAccount(boolean isAdding) {
        this.zzabg = isAdding;
        return this;
    }

    public GoogleAccountSetupRequest setAgreedToMobileTos(boolean isAgreed) {
        this.zzabf = isAgreed;
        return this;
    }

    public GoogleAccountSetupRequest setAgreedToPersonalizedContent(boolean isAgreedToPersonalizedContent) {
        this.zzabe = isAgreedToPersonalizedContent;
        return this;
    }

    public GoogleAccountSetupRequest setAgreedToWebHistory(boolean isAgreedToWebHistory) {
        this.zzabd = isAgreedToWebHistory;
        return this;
    }

    public GoogleAccountSetupRequest setCallingAppDescription(AppDescription appDescription) {
        this.callingAppDescription = appDescription;
        return this;
    }

    public GoogleAccountSetupRequest setCaptchaSolution(CaptchaSolution captchaSolution) {
        this.zzaaf = captchaSolution;
        return this;
    }

    public GoogleAccountSetupRequest setCreatingAccount(boolean isCreating) {
        this.zzaaz = isCreating;
        return this;
    }

    public GoogleAccountSetupRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public GoogleAccountSetupRequest setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public GoogleAccountSetupRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public GoogleAccountSetupRequest setOptions(Bundle options) {
        this.options.clear();
        this.options.putAll(options);
        return this;
    }

    public GoogleAccountSetupRequest setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
        return this;
    }

    public GoogleAccountSetupRequest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public GoogleAccountSetupRequest setRopRevision(String ropRevision) {
        this.zzabh = ropRevision;
        return this;
    }

    public GoogleAccountSetupRequest setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
        return this;
    }

    public GoogleAccountSetupRequest setSetupWizardInProgress(boolean isProgress) {
        this.zzaaA = isProgress;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        GoogleAccountSetupRequestCreator.zza(this, dest, flags);
    }
}

package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecoveryDecision implements SafeParcelable {
    public static final RecoveryDecisionCreator CREATOR = new RecoveryDecisionCreator();
    public boolean isRecoveryInfoNeeded;
    public boolean isRecoveryInterstitialAllowed;
    final int mVersionCode;
    public PendingIntent recoveryIntent;
    public PendingIntent recoveryIntentWithoutIntro;
    public boolean showRecoveryInterstitial;

    public RecoveryDecision() {
        this.mVersionCode = 1;
    }

    RecoveryDecision(int versionCode, PendingIntent recoveryIntent, boolean showRecoveryInterstitial, boolean isRecoveryInfoNeeded, boolean isRecoveryInterstitialAllowed, PendingIntent recoveryIntentWithoutIntro) {
        this.mVersionCode = versionCode;
        this.recoveryIntent = recoveryIntent;
        this.showRecoveryInterstitial = showRecoveryInterstitial;
        this.isRecoveryInfoNeeded = isRecoveryInfoNeeded;
        this.isRecoveryInterstitialAllowed = isRecoveryInterstitialAllowed;
        this.recoveryIntentWithoutIntro = recoveryIntentWithoutIntro;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        RecoveryDecisionCreator.zza(this, out, flags);
    }
}

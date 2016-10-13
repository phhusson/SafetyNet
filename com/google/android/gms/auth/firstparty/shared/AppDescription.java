package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class AppDescription implements SafeParcelable {
    public static final AppDescriptionCreator CREATOR = new AppDescriptionCreator();
    protected static final String TAG = "GLSSession";
    private static final String zzaav = ("[" + AppDescription.class.getSimpleName() + "]");
    final int version;
    String zzHT;
    boolean zzaaA;
    private final String zzacc;
    int zzacd;
    String zzace;
    String zzacf;

    AppDescription(int version, int callingUid, String sessionId, String sessionSig, String callingPkg, boolean isSetupWizardInProgress) {
        this.zzacc = "[" + getClass().getSimpleName() + "] %s - %s: %s";
        this.version = version;
        this.zzHT = sessionId;
        this.zzace = sessionSig;
        this.zzacf = zzx.zzi(callingPkg, zzaav + " callingPkg cannot be null or empty!");
        zzx.zzb(callingUid != 0, (Object) "Invalid callingUid! Cannot be 0!");
        this.zzacd = callingUid;
        this.zzaaA = isSetupWizardInProgress;
    }

    public AppDescription(String callingPkg, int callingUid) {
        this(callingPkg, callingUid, null, null);
    }

    public AppDescription(String callingPkg, int callingUid, String sessionId, String sessionSig) {
        this(1, callingUid, sessionId, sessionSig, callingPkg, false);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "New " + getClass().getSimpleName() + " (" + "sessiondId: " + this.zzHT + ", " + "sessiondSig: " + this.zzace + ", " + "callingPkg: " + this.zzacf + ", " + "callingUid: " + this.zzacd + ", ");
        }
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getCallingPackage() {
        return this.zzacf;
    }

    @Deprecated
    public int getCallingUid() {
        return this.zzacd;
    }

    public String getPackageName() {
        return this.zzacf;
    }

    public String getSessionId() {
        return this.zzHT;
    }

    public String getSessionSignature() {
        return this.zzace;
    }

    public int getUid() {
        return this.zzacd;
    }

    public boolean isSetupWizardInProgress() {
        return this.zzaaA;
    }

    protected void log(String methodName, int value) {
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, String.format(this.zzacc, new Object[]{this.zzHT, methodName, Integer.valueOf(value)}));
        }
    }

    protected void log(String methodName, String value) {
        if (Log.isLoggable(TAG, 2)) {
            String str = value == null ? "<NULL>" : value.isEmpty() ? "<EMPTY>" : "<MEANINFGUL>";
            Log.v(TAG, String.format(this.zzacc, new Object[]{this.zzHT, methodName, str}));
        }
    }

    protected void log(String methodName, boolean value) {
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, String.format(this.zzacc, new Object[]{this.zzHT, methodName, Boolean.valueOf(value)}));
        }
    }

    public AppDescription setSetupWizardInProgress(boolean isSetupWizard) {
        this.zzaaA = isSetupWizard;
        return this;
    }

    public String toString() {
        return new StringBuilder(getClass().getSimpleName()).append("<").append(this.zzacf).append(", ").append(this.zzacd).append(">").toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        AppDescriptionCreator.zza(this, dest, flags);
    }
}

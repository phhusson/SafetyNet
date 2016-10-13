package com.google.android.gms.auth.firstparty.dataservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PostSignInData implements SafeParcelable {
    public static final PostSignInDataCreator CREATOR = new PostSignInDataCreator();
    public final PendingIntent accountInstallationCompletionAction;
    public final Intent postSignInForeignIntent;
    final int version;

    PostSignInData(int version, Intent postSignInForeignIntent, PendingIntent accountInstallationCompletionAction) {
        this.version = version;
        this.postSignInForeignIntent = postSignInForeignIntent;
        this.accountInstallationCompletionAction = accountInstallationCompletionAction;
    }

    public PostSignInData(Intent postSignInForeignIntent, PendingIntent accountInstallationCompletionAction) {
        this(1, postSignInForeignIntent, accountInstallationCompletionAction);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        PostSignInDataCreator.zza(this, dest, flags);
    }
}

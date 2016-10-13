package com.google.android.gms.people;

import android.net.Uri;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public interface ContactsSync {
    PendingResult<BooleanResult> isSyncToContactsEnabled(GoogleApiClient googleApiClient);

    PendingResult<Result> setSyncToContactsEnabled(GoogleApiClient googleApiClient, boolean z);

    PendingResult<Result> setSyncToContactsSettings(GoogleApiClient googleApiClient, String str, boolean z, String[] strArr);

    PendingResult<Result> syncRawContact(GoogleApiClient googleApiClient, Uri uri);
}

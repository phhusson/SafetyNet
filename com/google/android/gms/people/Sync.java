package com.google.android.gms.people;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public interface Sync {
    PendingResult<Result> requestSync(GoogleApiClient googleApiClient, String str, String str2);

    PendingResult<Result> requestSync(GoogleApiClient googleApiClient, String str, String str2, long j);

    PendingResult<Result> requestSync(GoogleApiClient googleApiClient, String str, String str2, long j, boolean z);

    PendingResult<Result> requestSyncByUserAction(GoogleApiClient googleApiClient, String str, String str2);
}

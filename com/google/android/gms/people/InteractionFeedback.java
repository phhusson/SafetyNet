package com.google.android.gms.people;

import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.people.model.AutocompleteBuffer;

public interface InteractionFeedback {
    PendingResult<Result> sendAutocompleteSelectedFeedback(GoogleApiClient googleApiClient, AutocompleteBuffer autocompleteBuffer, int i, int i2);

    PendingResult<Result> sendAutocompleteSelectedFeedback(GoogleApiClient googleApiClient, AutocompleteBuffer autocompleteBuffer, int i, int i2, long j);

    PendingResult<Result> sendAutocompleteShownFeedback(GoogleApiClient googleApiClient, AutocompleteBuffer autocompleteBuffer, int i);

    PendingResult<Result> sendAutocompleteShownFeedback(GoogleApiClient googleApiClient, AutocompleteBuffer autocompleteBuffer, int i, long j);

    @RequiresPermission("android.permission.WRITE_CONTACTS")
    PendingResult<Result> sendFeedback(GoogleApiClient googleApiClient, String str, int i);

    @RequiresPermission("android.permission.WRITE_CONTACTS")
    PendingResult<Result> sendFeedback(GoogleApiClient googleApiClient, String[] strArr, int i);
}

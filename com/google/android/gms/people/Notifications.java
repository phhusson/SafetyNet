package com.google.android.gms.people;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public interface Notifications {

    public interface OnDataChanged {
        void onDataChanged(String str, String str2, int i);
    }

    PendingResult<Result> registerOnDataChangedListenerForAllOwners(GoogleApiClient googleApiClient, OnDataChanged onDataChanged, int i);

    PendingResult<Result> registerOnDataChangedListenerForOwner(GoogleApiClient googleApiClient, OnDataChanged onDataChanged, String str, String str2, int i);

    PendingResult<Result> unregisterOnDataChangedListener(GoogleApiClient googleApiClient, OnDataChanged onDataChanged);
}

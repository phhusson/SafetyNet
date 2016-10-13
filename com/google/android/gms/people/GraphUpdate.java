package com.google.android.gms.people;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.util.List;

public interface GraphUpdate {

    public interface AddCircleResult extends Result {
        String getCircleId();

        String getCircleName();
    }

    public interface UpdatePersonCircleResult extends Result {
        List<String> getAddedCircles();

        List<String> getRemovedCircles();
    }

    public interface LoadAddToCircleConsentResult extends Result {
        String getConsentButtonText();

        String getConsentHtml();

        String getConsentTitleText();

        boolean getShowConsent();
    }

    PendingResult<AddCircleResult> addCircle(GoogleApiClient googleApiClient, String str, String str2, String str3, String str4);

    PendingResult<AddCircleResult> addCircle(GoogleApiClient googleApiClient, String str, String str2, String str3, String str4, boolean z);

    PendingResult<Result> blockPerson(GoogleApiClient googleApiClient, String str, String str2, String str3);

    PendingResult<LoadAddToCircleConsentResult> loadAddToCircleConsent(GoogleApiClient googleApiClient, String str, String str2);

    PendingResult<Result> removeCircle(GoogleApiClient googleApiClient, String str, String str2, String str3);

    PendingResult<Result> setHasShownAddToCircleConsent(GoogleApiClient googleApiClient, String str, String str2);

    PendingResult<Result> starPerson(GoogleApiClient googleApiClient, String str, String str2);

    PendingResult<Result> unblockPerson(GoogleApiClient googleApiClient, String str, String str2, String str3);

    PendingResult<Result> unstarPerson(GoogleApiClient googleApiClient, String str, String str2);

    PendingResult<Result> updateCircle(GoogleApiClient googleApiClient, String str, String str2, String str3, String str4, Boolean bool, String str5);

    PendingResult<UpdatePersonCircleResult> updatePersonCircles(GoogleApiClient googleApiClient, String str, String str2, String str3, List<String> list, List<String> list2);
}

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.people.InteractionFeedback;
import com.google.android.gms.people.People.zzb;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.internal.zzn;
import com.google.android.gms.people.internal.zzp;
import com.google.android.gms.people.model.AutocompleteBuffer;

public class zzty implements InteractionFeedback {
    public PendingResult<Result> sendAutocompleteSelectedFeedback(GoogleApiClient client, AutocompleteBuffer autocompleteBuffer, int selectedIndex, int interactionType) {
        return sendAutocompleteSelectedFeedback(client, autocompleteBuffer, selectedIndex, interactionType, 0);
    }

    public PendingResult<Result> sendAutocompleteSelectedFeedback(GoogleApiClient client, AutocompleteBuffer autocompleteBuffer, int selectedIndex, int interactionType, long sessionId) {
        if (zzl.isEnabled()) {
            zzl.zzh("sendAutocompleteSelectedFeedback", autocompleteBuffer, Integer.valueOf(interactionType), Long.valueOf(sessionId));
        }
        final AutocompleteBuffer autocompleteBuffer2 = autocompleteBuffer;
        final int i = selectedIndex;
        final int i2 = interactionType;
        final long j = sessionId;
        return client.zzb(new zzb(this, client) {
            final /* synthetic */ zzty zzbHr;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zza.zzb) this, autocompleteBuffer2, i, i2, j);
            }
        });
    }

    public PendingResult<Result> sendAutocompleteShownFeedback(GoogleApiClient client, AutocompleteBuffer autocompleteBuffer, int interactionType) {
        return sendAutocompleteShownFeedback(client, autocompleteBuffer, interactionType, 0);
    }

    public PendingResult<Result> sendAutocompleteShownFeedback(GoogleApiClient client, AutocompleteBuffer autocompleteBuffer, int interactionType, long sessionId) {
        if (zzl.isEnabled()) {
            zzl.zzh("sendAutocompleteShownFeedback", autocompleteBuffer, Integer.valueOf(interactionType), Long.valueOf(sessionId));
        }
        final AutocompleteBuffer autocompleteBuffer2 = autocompleteBuffer;
        final int i = interactionType;
        final long j = sessionId;
        return client.zzb(new zzb(this, client) {
            final /* synthetic */ zzty zzbHr;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zza.zzb) this, autocompleteBuffer2, -1, i, j);
            }
        });
    }

    public PendingResult<Result> sendFeedback(GoogleApiClient googleApiClient, final String contactItem, final int interactionType) {
        if (zzl.isEnabled()) {
            zzl.zzh("sendFeedback", contactItem, Integer.valueOf(interactionType));
        }
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ zzty zzbHr;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zzg((zza.zzb) this, contactItem, interactionType);
            }
        });
    }

    public PendingResult<Result> sendFeedback(GoogleApiClient googleApiClient, String[] contactItems, final int interactionType) {
        if (zzl.isEnabled()) {
            zzl.zzh("sendFeedback", contactItems, Integer.valueOf(interactionType));
        }
        final String join = TextUtils.join(zzp.zzbEU, contactItems);
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ zzty zzbHr;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zzg((zza.zzb) this, join, interactionType);
            }
        });
    }
}

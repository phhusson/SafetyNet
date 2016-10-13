package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.people.Autocomplete;
import com.google.android.gms.people.Autocomplete.AutocompleteOptions;
import com.google.android.gms.people.Autocomplete.AutocompleteResult;
import com.google.android.gms.people.Autocomplete.AutocompleteSession;
import com.google.android.gms.people.Autocomplete.AutocompletionListener;
import com.google.android.gms.people.Autocomplete.ClientConfig;
import com.google.android.gms.people.People;
import com.google.android.gms.people.internal.autocomplete.zza;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.internal.zzn;
import com.google.android.gms.people.model.AutocompleteBuffer;

public class zztt implements Autocomplete {
    public AutocompleteSession beginAutocompleteSession(GoogleApiClient googleApiClient, ClientConfig clientConfig, String account, AutocompletionListener autocompletionListener) {
        return new zza(googleApiClient, clientConfig, account, autocompletionListener);
    }

    public PendingResult<AutocompleteResult> loadAutocompleteList(GoogleApiClient googleApiClient, final String query, final AutocompleteOptions options) {
        zzx.zzD(options);
        if (zzl.isEnabled()) {
            zzl.zzh("loadAutocompleteList", query, options);
        }
        return googleApiClient.zza(new People.zza<AutocompleteResult>(this, googleApiClient) {
            final /* synthetic */ zztt zzbGo;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zza((zzb) this, query, options);
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzch(status);
            }

            protected AutocompleteResult zzch(final Status status) {
                return new AutocompleteResult(this) {
                    final /* synthetic */ C05061 zzbGp;

                    public AutocompleteBuffer getAutocompleteEntries() {
                        return null;
                    }

                    public Status getStatus() {
                        return status;
                    }

                    public void release() {
                    }
                };
            }
        });
    }
}

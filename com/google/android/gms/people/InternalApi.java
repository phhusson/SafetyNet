package com.google.android.gms.people;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.people.Graph.LoadPeopleResult;
import com.google.android.gms.people.People.BundleResult;
import com.google.android.gms.people.internal.zzl;

public interface InternalApi {

    public interface LoadPeopleForAspenResult extends LoadPeopleResult {
        String getNextPageToken();
    }

    public static class LoadPeopleForAspenOptions {
        public static final LoadPeopleForAspenOptions zzbzJ = new LoadPeopleForAspenOptions();
        private String zzPe;
        private String zzaJX;
        private int zzbzK = 20;

        public int getPageSize() {
            return this.zzbzK;
        }

        public String getPageToken() {
            return this.zzaJX;
        }

        public String getQuery() {
            return this.zzPe;
        }

        public LoadPeopleForAspenOptions setPageSize(int pageSize) {
            this.zzbzK = pageSize;
            return this;
        }

        public LoadPeopleForAspenOptions setPageToken(String pageToken) {
            this.zzaJX = pageToken;
            return this;
        }

        public LoadPeopleForAspenOptions setQuery(String query) {
            this.zzPe = query;
            return this;
        }

        public String toString() {
            return zzl.zzd("mQuery", this.zzPe, "mPageToken", this.zzaJX, "mPageSize", Integer.valueOf(this.zzbzK));
        }
    }

    PendingResult<BundleResult> internalCall(GoogleApiClient googleApiClient, Bundle bundle);

    PendingResult<LoadPeopleForAspenResult> loadPeopleForAspen(GoogleApiClient googleApiClient, String str, String str2, LoadPeopleForAspenOptions loadPeopleForAspenOptions);
}

package com.google.android.gms.people;

import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.people.People.ReleasableResult;
import com.google.android.gms.people.PeopleConstants.CircleTypes;
import com.google.android.gms.people.PeopleConstants.PeopleColumnBitmask;
import com.google.android.gms.people.exp.ContactGaiaIdRawBuffer;
import com.google.android.gms.people.exp.PersonForAggregationRawBuffer;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.model.AggregatedPersonBuffer;
import com.google.android.gms.people.model.CircleBuffer;
import com.google.android.gms.people.model.ContactGaiaIdBuffer;
import com.google.android.gms.people.model.OwnerBuffer;
import com.google.android.gms.people.model.PersonBuffer;
import com.google.android.gms.people.model.PhoneNumberBuffer;
import java.util.Collection;

public interface Graph {

    public interface LoadOwnersResult extends ReleasableResult {
        OwnerBuffer getOwners();
    }

    public interface LoadCirclesResult extends ReleasableResult {
        CircleBuffer getCircles();
    }

    public interface LoadPeopleResult extends ReleasableResult {
        PersonBuffer getPeople();
    }

    public interface LoadAggregatedPeopleResult extends ReleasableResult {
        AggregatedPersonBuffer getAggregatedPeople();
    }

    public interface LoadPeopleForAggregationResult extends ReleasableResult {
        Bundle getEmailTypeMapBundle();

        ContactGaiaIdRawBuffer getGaiaMap();

        PersonForAggregationRawBuffer getPeople();

        Bundle getPhoneTypeMapBundle();
    }

    public interface LoadContactsGaiaIdsResult extends ReleasableResult {
        ContactGaiaIdBuffer getContactsGaiaIds();
    }

    public interface LoadPhoneNumbersResult extends ReleasableResult {
        PhoneNumberBuffer getPhoneNumbers();
    }

    public static class LoadAggregatedPeopleOptions {
        public static final LoadAggregatedPeopleOptions zzbzm = new LoadAggregatedPeopleOptions();
        private String zzPe;
        private boolean zzbzn;
        private boolean zzbzo;
        private int zzbzp = PeopleColumnBitmask.ALL;
        private int zzbzq;
        private String zzbzr;
        private boolean zzbzs;
        private int zzbzt = 7;
        private int zzbzu = 3;
        private int zzbzv = 0;

        public int getExtraColumns() {
            return this.zzbzq;
        }

        public int getFilterGaiaEdgeTypes() {
            return this.zzbzu;
        }

        public String getFilterGaiaId() {
            return this.zzbzr;
        }

        public int getProjection() {
            return this.zzbzp;
        }

        public String getQuery() {
            return this.zzPe;
        }

        public int getSearchFields() {
            return this.zzbzt;
        }

        public int getSortOrder() {
            return this.zzbzv;
        }

        public boolean isIncludeEvergreenPeople() {
            return this.zzbzs;
        }

        public boolean isIncludeInvisible() {
            return this.zzbzn;
        }

        public boolean isPeopleOnly() {
            return this.zzbzo;
        }

        public LoadAggregatedPeopleOptions setExtraColumns(int extraColumns) {
            this.zzbzq = extraColumns;
            return this;
        }

        public LoadAggregatedPeopleOptions setFilterGaiaEdgeType(int filterGaiaEdgeTypes) {
            this.zzbzu = filterGaiaEdgeTypes;
            return this;
        }

        public LoadAggregatedPeopleOptions setFilterGaiaId(String filterGaiaId) {
            this.zzbzr = filterGaiaId;
            return this;
        }

        public LoadAggregatedPeopleOptions setIncludeEvergreenPeople(boolean includeEvergreenPeople) {
            this.zzbzs = includeEvergreenPeople;
            return this;
        }

        public LoadAggregatedPeopleOptions setIncludeInvisible(boolean includeInvisible) {
            this.zzbzn = includeInvisible;
            return this;
        }

        public LoadAggregatedPeopleOptions setPeopleOnly(boolean peopleOnly) {
            this.zzbzo = peopleOnly;
            return this;
        }

        public LoadAggregatedPeopleOptions setProjection(int projection) {
            this.zzbzp = projection;
            return this;
        }

        public LoadAggregatedPeopleOptions setQuery(String query) {
            this.zzPe = query;
            return this;
        }

        public LoadAggregatedPeopleOptions setSearchFields(int searchFields) {
            this.zzbzt = searchFields;
            return this;
        }

        public LoadAggregatedPeopleOptions setSortOrder(int sortOrder) {
            this.zzbzv = sortOrder;
            return this;
        }

        public String toString() {
            return zzl.zzd("mIncludeInvisible", Boolean.valueOf(this.zzbzn), "mQuery", this.zzPe, "mPeopleOnly", Boolean.valueOf(this.zzbzo), "mProjection", Integer.valueOf(this.zzbzp), "mExtraColumns", Integer.valueOf(this.zzbzq), "mFilterGaiaId", this.zzbzr, "mIncludeEvergreenPeople", Boolean.valueOf(this.zzbzs), "mSearchFields", Integer.valueOf(this.zzbzt), "mFilterGaiaEdgeTypes", Integer.valueOf(this.zzbzu), "mSortOrder", Integer.valueOf(this.zzbzv));
        }
    }

    public static class LoadCirclesOptions {
        public static final LoadCirclesOptions zzbzw = new LoadCirclesOptions();
        private boolean zzbzA;
        private int zzbzx = CircleTypes.ALL;
        private String zzbzy;
        private String zzbzz;

        public String getFilterCircleId() {
            return this.zzbzy;
        }

        public String getFilterCircleNamePrefix() {
            return this.zzbzz;
        }

        public int getFilterCircleType() {
            return this.zzbzx;
        }

        public boolean isGetVisibility() {
            return this.zzbzA;
        }

        public LoadCirclesOptions setFilterCircleId(String filterCircleId) {
            this.zzbzy = filterCircleId;
            return this;
        }

        public LoadCirclesOptions setFilterCircleNamePrefix(String filterCircleNamePrefix) {
            this.zzbzz = filterCircleNamePrefix;
            return this;
        }

        public LoadCirclesOptions setFilterCircleType(int filterCircleType) {
            this.zzbzx = filterCircleType;
            return this;
        }

        public LoadCirclesOptions setGetVisibility(boolean getVisibility) {
            this.zzbzA = getVisibility;
            return this;
        }

        public String toString() {
            return zzl.zzd("mFilterCircleType", Integer.valueOf(this.zzbzx), "mFilterCircleId", this.zzbzy, "mFilterCircleNamePrefix", this.zzbzz, "mGetVisibility", Boolean.valueOf(this.zzbzA));
        }
    }

    public static class LoadContactsGaiaIdsOptions {
        public static final LoadContactsGaiaIdsOptions zzbzB = new LoadContactsGaiaIdsOptions();
        private String zzbzC;
        private String zzbzr;
        private int zzbzu = 3;

        public String getFilterContactInfo() {
            return this.zzbzC;
        }

        public int getFilterGaiaEdgeTypes() {
            return this.zzbzu;
        }

        public String getFilterGaiaId() {
            return this.zzbzr;
        }

        public LoadContactsGaiaIdsOptions setFilterContactInfo(String filterContactInfo) {
            this.zzbzC = filterContactInfo;
            return this;
        }

        public LoadContactsGaiaIdsOptions setFilterGaiaEdgeTypes(int filterGaiaEdgeTypes) {
            this.zzbzu = filterGaiaEdgeTypes;
            return this;
        }

        public LoadContactsGaiaIdsOptions setFilterGaiaId(String filterGaiaId) {
            this.zzbzr = filterGaiaId;
            return this;
        }

        public String toString() {
            return zzl.zzd("mFilterContactInfo", this.zzbzC, "mFilterGaiaId", this.zzbzr, "mFilterGaiaEdgeTypes", Integer.valueOf(this.zzbzu));
        }
    }

    public static class LoadOwnersOptions {
        public static final LoadOwnersOptions zzbzD = new LoadOwnersOptions();
        private boolean zzbzE;
        private int zzbzv = 0;

        public int getSortOrder() {
            return this.zzbzv;
        }

        public boolean isIncludePlusPages() {
            return this.zzbzE;
        }

        public LoadOwnersOptions setIncludePlusPages(boolean includePlusPages) {
            this.zzbzE = includePlusPages;
            return this;
        }

        public LoadOwnersOptions setSortOrder(int sortOrder) {
            this.zzbzv = sortOrder;
            return this;
        }

        public String toString() {
            return zzl.zzd("mIncludePlusPages", Boolean.valueOf(this.zzbzE), "mSortOrder", Integer.valueOf(this.zzbzv));
        }
    }

    public static class LoadPeopleOptions {
        public static final LoadPeopleOptions zzbzF = new LoadPeopleOptions();
        private String zzPe;
        private String zzaxr;
        private Collection<String> zzbzG;
        private long zzbzH;
        private boolean zzbzo;
        private int zzbzp = PeopleColumnBitmask.ALL;
        private int zzbzq;
        private int zzbzt = 7;
        private int zzbzv = 0;

        public long getChangedSince() {
            return this.zzbzH;
        }

        public String getCircleId() {
            return this.zzaxr;
        }

        public int getExtraColumns() {
            return this.zzbzq;
        }

        public int getProjection() {
            return this.zzbzp;
        }

        public Collection<String> getQualifiedIds() {
            return this.zzbzG;
        }

        public String getQuery() {
            return this.zzPe;
        }

        public int getSearchFields() {
            return this.zzbzt;
        }

        public int getSortOrder() {
            return this.zzbzv;
        }

        public boolean isPeopleOnly() {
            return this.zzbzo;
        }

        public LoadPeopleOptions setChangedSince(long changedSince) {
            this.zzbzH = changedSince;
            return this;
        }

        public LoadPeopleOptions setCircleId(String circleId) {
            this.zzaxr = circleId;
            return this;
        }

        public LoadPeopleOptions setExtraColumns(int extraColumns) {
            this.zzbzq = extraColumns;
            return this;
        }

        public LoadPeopleOptions setPeopleOnly(boolean peopleOnly) {
            this.zzbzo = peopleOnly;
            return this;
        }

        public LoadPeopleOptions setProjection(int projection) {
            this.zzbzp = projection;
            return this;
        }

        public LoadPeopleOptions setQualifiedIds(Collection<String> qualifiedIds) {
            this.zzbzG = qualifiedIds;
            return this;
        }

        public LoadPeopleOptions setQuery(String query) {
            this.zzPe = query;
            return this;
        }

        public LoadPeopleOptions setSearchFields(int searchFields) {
            this.zzbzt = searchFields;
            return this;
        }

        public LoadPeopleOptions setSortOrder(int sortOrder) {
            this.zzbzv = sortOrder;
            return this;
        }

        public String toString() {
            return zzl.zzd("mCircleId", this.zzaxr, "mQualifiedIds", this.zzbzG, "mProjection", Integer.valueOf(this.zzbzp), "mPeopleOnly", Boolean.valueOf(this.zzbzo), "mChangedSince", Long.valueOf(this.zzbzH), "mQuery", this.zzPe, "mSearchFields", Integer.valueOf(this.zzbzt), "mSortOrder", Integer.valueOf(this.zzbzv), "mExtraColumns", Integer.valueOf(this.zzbzq));
        }
    }

    PendingResult<LoadPeopleForAggregationResult> expLoadPeopleForAggregation(GoogleApiClient googleApiClient, String str, String str2, LoadAggregatedPeopleOptions loadAggregatedPeopleOptions);

    @RequiresPermission("android.permission.READ_CONTACTS")
    PendingResult<LoadAggregatedPeopleResult> loadAggregatedPeople(GoogleApiClient googleApiClient, String str, String str2, LoadAggregatedPeopleOptions loadAggregatedPeopleOptions);

    PendingResult<LoadCirclesResult> loadCircles(GoogleApiClient googleApiClient, String str, String str2, LoadCirclesOptions loadCirclesOptions);

    PendingResult<LoadContactsGaiaIdsResult> loadContactsGaiaIds(GoogleApiClient googleApiClient, LoadContactsGaiaIdsOptions loadContactsGaiaIdsOptions);

    PendingResult<LoadOwnersResult> loadOwner(GoogleApiClient googleApiClient, String str, String str2);

    PendingResult<LoadOwnersResult> loadOwners(GoogleApiClient googleApiClient, LoadOwnersOptions loadOwnersOptions);

    PendingResult<LoadPeopleResult> loadPeople(GoogleApiClient googleApiClient, String str, String str2, LoadPeopleOptions loadPeopleOptions);

    PendingResult<LoadPhoneNumbersResult> loadPhoneNumbers(GoogleApiClient googleApiClient, String str, Bundle bundle);
}

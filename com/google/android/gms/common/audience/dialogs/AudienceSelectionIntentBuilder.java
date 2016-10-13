package com.google.android.gms.common.audience.dialogs;

import android.content.Intent;
import com.google.android.gms.common.audience.dialogs.AclSelection.Builder;
import com.google.android.gms.common.audience.dialogs.AclSelection.Results;
import com.google.android.gms.common.audience.dialogs.CircleSelection.SelectBuilder;
import com.google.android.gms.common.audience.dialogs.CircleSelection.UpdateBuilder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.people.data.Audience;
import com.google.android.gms.common.people.data.AudienceMember;
import com.google.android.gms.people.internal.zzp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AudienceSelectionIntentBuilder implements Builder, Results, CircleSelection.Results, SelectBuilder, UpdateBuilder, FaclSelection.Builder, FaclSelection.Results {
    public static final int DOMAIN_RESTRICTED_NOT_VISIBLE = 0;
    public static final int DOMAIN_RESTRICTED_OFF = 2;
    public static final int DOMAIN_RESTRICTED_ON = 1;
    private final Intent mIntent;

    public AudienceSelectionIntentBuilder(Intent intent) {
        this.mIntent = new Intent(intent);
    }

    public AudienceSelectionIntentBuilder(String action) {
        this(new Intent(action).setPackage("com.google.android.gms"));
    }

    public static String getAccountName(Intent intent) {
        return intent.getStringExtra("com.google.android.gms.common.acl.EXTRA_ACCOUNT_NAME");
    }

    public static ArrayList<AudienceMember> getAddedAudienceDelta(Intent intent) {
        return intent.getParcelableArrayListExtra("com.google.android.gms.common.acl.EXTRA_ADDED_AUDIENCE");
    }

    public static String getAllCirclesCheckboxText(Intent intent) {
        return intent.getStringExtra("ALL_CIRCLES_CHECKBOX_TEXT");
    }

    public static boolean getAllCirclesChecked(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("ALL_CIRCLES_CHECKED", defaultValue);
    }

    public static String getAllContactsCheckboxText(Intent intent) {
        return intent.getStringExtra("ALL_CONTACTS_CHECKBOX_TEXT");
    }

    public static boolean getAllContactsChecked(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("ALL_CONTACTS_CHECKED", defaultValue);
    }

    public static boolean getAllowEmptySelection(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("ALLOW_EMPTY", defaultValue);
    }

    public static String getCancelText(Intent intent) {
        return intent.getStringExtra("CANCEL_TEXT");
    }

    public static String getClientApplicationId(Intent intent) {
        return intent.getStringExtra("com.google.android.gms.common.acl.EXTRA_CLIENT_APPLICATION_ID");
    }

    public static String getDescription(Intent intent) {
        return intent.getStringExtra("DESCRIPTION_TEXT");
    }

    public static int getDomainRestricted(Intent intent, int defaultValue) {
        return intent.getIntExtra("com.google.android.gms.common.acl.EXTRA_DOMAIN_RESTRICTED", defaultValue);
    }

    public static boolean getHasShowCircles(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("HAS_SHOW_CIRCLES", defaultValue);
    }

    public static int getHeaderBackgroundColor(Intent intent, int defaultColor) {
        return intent.getIntExtra("com.google.android.gms.common.acl.EXTRA_HEADER_BACKGROUND_COLOR", defaultColor);
    }

    public static int getHeaderTextColor(Intent intent, int defaultColor) {
        return intent.getIntExtra("com.google.android.gms.common.acl.EXTRA_HEADER_TEXT_COLOR", defaultColor);
    }

    public static boolean getIncludeSuggestionsWithPeople(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("EXTRA_INCLUDE_SUGGESTIONS_WITH_PEOPLE", defaultValue);
    }

    public static List<AudienceMember> getInitialAudienceMembers(Intent intent) {
        return intent.hasExtra("com.google.android.gms.common.acl.EXTRA_INITIAL_AUDIENCE") ? intent.getParcelableArrayListExtra("com.google.android.gms.common.acl.EXTRA_INITIAL_AUDIENCE") : Collections.emptyList();
    }

    public static ArrayList<AudienceMember> getKnownAudienceMembers(Intent intent) {
        return intent.getParcelableArrayListExtra("INITIAL_ACL");
    }

    public static boolean getLoadCircles(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("LOAD_CIRCLES", defaultValue);
    }

    public static boolean getLoadPeople(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("LOAD_PEOPLE", defaultValue);
    }

    public static int getLoadPeopleType(Intent intent, int defaultValue) {
        return intent.getIntExtra("LOAD_PEOPLE_TYPE", defaultValue);
    }

    public static boolean getLoadSuggested(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("SHOULD_LOAD_SUGGESTED", defaultValue);
    }

    public static boolean getLoadSystemGroups(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("SHOULD_LOAD_GROUPS", defaultValue);
    }

    public static int getMaxSuggestedDeviceContacts(Intent intent, int defaultValue) {
        return intent.getIntExtra("EXTRA_MAX_SUGGESTED_DEVICE", defaultValue);
    }

    public static int getMaxSuggestedImages(Intent intent, int defaultValue) {
        return intent.getIntExtra("EXTRA_MAX_SUGGESTED_IMAGES", defaultValue);
    }

    public static int getMaxSuggestedListItems(Intent intent, int defaultValue) {
        return intent.getIntExtra("EXTRA_MAX_SUGGESTED_LIST_ITEMS", defaultValue);
    }

    public static String getOkText(Intent intent) {
        return intent.getStringExtra("OK_TEXT");
    }

    public static String getPlusPageId(Intent intent) {
        return intent.getStringExtra("com.google.android.gms.common.acl.EXTRA_PLUS_PAGE_ID");
    }

    public static ArrayList<AudienceMember> getRemovedAudienceDelta(Intent intent) {
        return intent.getParcelableArrayListExtra("com.google.android.gms.common.acl.EXTRA_REMOVED_AUDIENCE");
    }

    public static boolean getSearchDeviceContacts(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("EXTRA_SEARCH_DEVICE", defaultValue);
    }

    public static boolean getSearchEmail(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("EXTRA_SEARCH_EMAIL", defaultValue);
    }

    public static ArrayList<AudienceMember> getSelectedAudienceMembers(Intent intent) {
        ArrayList<AudienceMember> arrayList = new ArrayList();
        Collection initialAudienceMembers = getInitialAudienceMembers(intent);
        if (!(initialAudienceMembers == null || initialAudienceMembers.isEmpty())) {
            arrayList.addAll(initialAudienceMembers);
        }
        initialAudienceMembers = getRemovedAudienceDelta(intent);
        if (initialAudienceMembers != null) {
            arrayList.removeAll(initialAudienceMembers);
        }
        initialAudienceMembers = getAddedAudienceDelta(intent);
        if (initialAudienceMembers != null) {
            arrayList.addAll(initialAudienceMembers);
        }
        return arrayList;
    }

    public static boolean getShowCancel(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("SHOW_CANCEL_VISIBLE", defaultValue);
    }

    public static boolean getShowChips(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("SHOW_CHIPS_VISIBLE", defaultValue);
    }

    public static boolean getShowCircles(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("SHOW_ALL_CIRCLES_CHECKBOX", defaultValue);
    }

    public static boolean getShowContacts(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("SHOW_ALL_CONTACTS_CHECKBOX", defaultValue);
    }

    public static boolean getShowHiddenCirclesText(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("SHOW_HIDDEN_CIRCLES_TEXT", defaultValue);
    }

    public static String getTitle(Intent intent) {
        return intent.getStringExtra("com.google.android.gms.common.acl.EXTRA_TITLE_TEXT");
    }

    public static String getTitleLogo(Intent intent) {
        return intent.getStringExtra("TITLE_LOGO");
    }

    public static AudienceMember getUpdatePerson(Intent intent) {
        if (intent.hasExtra("com.google.android.gms.common.acl.EXTRA_UPDATE_PERSON")) {
            return (AudienceMember) zzc.zza(intent, "com.google.android.gms.common.acl.EXTRA_UPDATE_PERSON", AudienceMember.CREATOR);
        }
        return !intent.hasExtra("com.google.android.gms.common.acl.EXTRA_UPDATE_PERSON_ID") ? null : AudienceMember.forPersonWithPeopleQualifiedId(intent.getStringExtra("com.google.android.gms.common.acl.EXTRA_UPDATE_PERSON_ID"), null, null);
    }

    public static String getUpdatePersonId(Intent intent) {
        return (intent.hasExtra("com.google.android.gms.common.acl.EXTRA_UPDATE_PERSON") || intent.hasExtra("com.google.android.gms.common.acl.EXTRA_UPDATE_PERSON_ID")) ? getUpdatePerson(intent).getPeopleQualifiedId() : null;
    }

    public static boolean shouldShowSectionTitles(Intent intent, boolean defaultValue) {
        return intent.getBooleanExtra("SHOW_SECTION_TITLES", defaultValue);
    }

    private static <T> ArrayList<T> zzt(List<T> list) {
        return list instanceof ArrayList ? (ArrayList) list : new ArrayList(list);
    }

    public Intent build() {
        return this.mIntent;
    }

    public ArrayList<AudienceMember> getAddedAudienceDelta() {
        return getAddedAudienceDelta(this.mIntent);
    }

    public ArrayList<AudienceMember> getAddedCirclesDelta() {
        return getAddedAudienceDelta();
    }

    public boolean getAllCirclesChecked() {
        return getAllCirclesChecked(this.mIntent, false);
    }

    public boolean getAllContactsChecked() {
        return getAllContactsChecked(this.mIntent, false);
    }

    public int getDomainRestricted() {
        return getDomainRestricted(this.mIntent, 0);
    }

    public List<AudienceMember> getInitialAudienceMembers() {
        return getInitialAudienceMembers(this.mIntent);
    }

    public List<AudienceMember> getInitialCircles() {
        return getInitialAudienceMembers();
    }

    public ArrayList<AudienceMember> getRemovedAudienceDelta() {
        return getRemovedAudienceDelta(this.mIntent);
    }

    public ArrayList<AudienceMember> getRemovedCirclesDelta() {
        return getRemovedAudienceDelta();
    }

    public ArrayList<AudienceMember> getSelectedAudienceMembers() {
        return getSelectedAudienceMembers(this.mIntent);
    }

    public ArrayList<AudienceMember> getSelectedCircles() {
        return getSelectedAudienceMembers();
    }

    public AudienceMember getUpdatePerson() {
        return getUpdatePerson(this.mIntent);
    }

    public AudienceSelectionIntentBuilder setAccountName(String accountName) {
        this.mIntent.putExtra("com.google.android.gms.common.acl.EXTRA_ACCOUNT_NAME", accountName);
        return this;
    }

    public AudienceSelectionIntentBuilder setAddedAudienceDelta(ArrayList<AudienceMember> audience) {
        this.mIntent.putParcelableArrayListExtra("com.google.android.gms.common.acl.EXTRA_ADDED_AUDIENCE", audience);
        return this;
    }

    public AudienceSelectionIntentBuilder setAllCirclesCheckboxText(String allCirclesCheckBoxText) {
        this.mIntent.putExtra("ALL_CIRCLES_CHECKBOX_TEXT", allCirclesCheckBoxText);
        return this;
    }

    public AudienceSelectionIntentBuilder setAllCirclesChecked(boolean checked) {
        this.mIntent.putExtra("ALL_CIRCLES_CHECKED", checked);
        return this;
    }

    public AudienceSelectionIntentBuilder setAllContactsCheckboxText(String text) {
        this.mIntent.putExtra("ALL_CONTACTS_CHECKBOX_TEXT", text);
        return this;
    }

    public AudienceSelectionIntentBuilder setAllContactsChecked(boolean checked) {
        this.mIntent.putExtra("ALL_CONTACTS_CHECKED", checked);
        return this;
    }

    public AudienceSelectionIntentBuilder setAllowEmptySelection(boolean allowed) {
        this.mIntent.putExtra("ALLOW_EMPTY", allowed);
        return this;
    }

    public AudienceSelectionIntentBuilder setCancelText(String cancelText) {
        this.mIntent.putExtra("CANCEL_TEXT", cancelText);
        return this;
    }

    public AudienceSelectionIntentBuilder setClientApplicationId(String clientApplicationId) {
        this.mIntent.putExtra("com.google.android.gms.common.acl.EXTRA_CLIENT_APPLICATION_ID", clientApplicationId);
        return this;
    }

    public AudienceSelectionIntentBuilder setDescription(String description) {
        this.mIntent.putExtra("DESCRIPTION_TEXT", description);
        return this;
    }

    public AudienceSelectionIntentBuilder setDomainRestricted(int flag) {
        this.mIntent.putExtra("com.google.android.gms.common.acl.EXTRA_DOMAIN_RESTRICTED", flag);
        return this;
    }

    public AudienceSelectionIntentBuilder setHasShowCircles(boolean has) {
        this.mIntent.putExtra("HAS_SHOW_CIRCLES", has);
        return this;
    }

    public UpdateBuilder setHeaderBackgroundColor(int color) {
        this.mIntent.putExtra("com.google.android.gms.common.acl.EXTRA_HEADER_BACKGROUND_COLOR", color);
        return this;
    }

    public UpdateBuilder setHeaderTextColor(int color) {
        this.mIntent.putExtra("com.google.android.gms.common.acl.EXTRA_HEADER_TEXT_COLOR", color);
        return this;
    }

    public AudienceSelectionIntentBuilder setIncludeSuggestionsWithPeople(boolean includeSuggestions) {
        this.mIntent.putExtra("EXTRA_INCLUDE_SUGGESTIONS_WITH_PEOPLE", includeSuggestions);
        return this;
    }

    public AudienceSelectionIntentBuilder setInitialAcl(Audience audience) {
        setInitialAudience(audience);
        return this;
    }

    public AudienceSelectionIntentBuilder setInitialAcl(List<AudienceMember> acl) {
        setInitialAudience((List) acl);
        return this;
    }

    public AudienceSelectionIntentBuilder setInitialAudience(Audience audience) {
        setInitialAudience(audience.getAudienceMemberList());
        return this;
    }

    public AudienceSelectionIntentBuilder setInitialAudience(List<AudienceMember> audience) {
        if (audience == null) {
            audience = Collections.EMPTY_LIST;
        }
        this.mIntent.putParcelableArrayListExtra("com.google.android.gms.common.acl.EXTRA_INITIAL_AUDIENCE", zzt(audience));
        return this;
    }

    public AudienceSelectionIntentBuilder setInitialCircles(List<AudienceMember> circles) {
        setInitialAudience((List) circles);
        return this;
    }

    public AudienceSelectionIntentBuilder setKnownAudienceMembers(List<AudienceMember> audience) {
        this.mIntent.putParcelableArrayListExtra("INITIAL_ACL", zzt(audience));
        return this;
    }

    public AudienceSelectionIntentBuilder setLoadCircles(boolean loadCircles) {
        this.mIntent.putExtra("LOAD_CIRCLES", loadCircles);
        return this;
    }

    public AudienceSelectionIntentBuilder setLoadPeople(boolean loadPeople) {
        this.mIntent.putExtra("LOAD_PEOPLE", loadPeople);
        return this;
    }

    public AudienceSelectionIntentBuilder setLoadPeopleType(int peopleType) {
        this.mIntent.putExtra("LOAD_PEOPLE_TYPE", peopleType);
        return this;
    }

    public AudienceSelectionIntentBuilder setLoadSuggested(boolean loadSuggested) {
        this.mIntent.putExtra("SHOULD_LOAD_SUGGESTED", loadSuggested);
        return this;
    }

    public AudienceSelectionIntentBuilder setLoadSystemGroups(boolean loadGroups) {
        this.mIntent.putExtra("SHOULD_LOAD_GROUPS", loadGroups);
        return this;
    }

    public AudienceSelectionIntentBuilder setMaxSuggestedDeviceContacts(int maxSuggestedDevice) {
        this.mIntent.putExtra("EXTRA_MAX_SUGGESTED_DEVICE", maxSuggestedDevice);
        return this;
    }

    public AudienceSelectionIntentBuilder setMaxSuggestedImages(int maxSuggestedImages) {
        this.mIntent.putExtra("EXTRA_MAX_SUGGESTED_IMAGES", maxSuggestedImages);
        return this;
    }

    public AudienceSelectionIntentBuilder setMaxSuggestedListItems(int maxSuggestedListItems) {
        this.mIntent.putExtra("EXTRA_MAX_SUGGESTED_LIST_ITEMS", maxSuggestedListItems);
        return this;
    }

    public AudienceSelectionIntentBuilder setOkText(String okText) {
        this.mIntent.putExtra("OK_TEXT", okText);
        return this;
    }

    public AudienceSelectionIntentBuilder setPlusPageId(String plusPageId) {
        this.mIntent.putExtra("com.google.android.gms.common.acl.EXTRA_PLUS_PAGE_ID", plusPageId);
        return this;
    }

    public AudienceSelectionIntentBuilder setRemovedAudienceDelta(ArrayList<AudienceMember> audience) {
        this.mIntent.putParcelableArrayListExtra("com.google.android.gms.common.acl.EXTRA_REMOVED_AUDIENCE", audience);
        return this;
    }

    public AudienceSelectionIntentBuilder setSearchDeviceContacts(boolean searchDeviceContacts) {
        this.mIntent.putExtra("EXTRA_SEARCH_DEVICE", searchDeviceContacts);
        return this;
    }

    public AudienceSelectionIntentBuilder setSearchEmail(boolean searchEmail) {
        this.mIntent.putExtra("EXTRA_SEARCH_EMAIL", searchEmail);
        return this;
    }

    public AudienceSelectionIntentBuilder setShowCancel(boolean cancelVisible) {
        this.mIntent.putExtra("SHOW_CANCEL_VISIBLE", cancelVisible);
        return this;
    }

    public AudienceSelectionIntentBuilder setShowChips(boolean chipsVisible) {
        this.mIntent.putExtra("SHOW_CHIPS_VISIBLE", chipsVisible);
        return this;
    }

    public AudienceSelectionIntentBuilder setShowCircles(boolean show) {
        this.mIntent.putExtra("SHOW_ALL_CIRCLES_CHECKBOX", show);
        return this;
    }

    public AudienceSelectionIntentBuilder setShowContacts(boolean show) {
        this.mIntent.putExtra("SHOW_ALL_CONTACTS_CHECKBOX", show);
        return this;
    }

    public AudienceSelectionIntentBuilder setShowHiddenCirclesText(boolean showText) {
        this.mIntent.putExtra("SHOW_HIDDEN_CIRCLES_TEXT", showText);
        return this;
    }

    public AudienceSelectionIntentBuilder setShowSectionTitles(boolean showSectionTitles) {
        this.mIntent.putExtra("SHOW_SECTION_TITLES", showSectionTitles);
        return this;
    }

    public AudienceSelectionIntentBuilder setTitleLogo(String title) {
        this.mIntent.putExtra("TITLE_LOGO", title);
        return this;
    }

    public AudienceSelectionIntentBuilder setTitleText(String title) {
        this.mIntent.putExtra("com.google.android.gms.common.acl.EXTRA_TITLE_TEXT", title);
        return this;
    }

    public AudienceSelectionIntentBuilder setUpdatePerson(AudienceMember person) {
        zzc.zza((SafeParcelable) person, this.mIntent, "com.google.android.gms.common.acl.EXTRA_UPDATE_PERSON");
        return this;
    }

    @Deprecated
    public AudienceSelectionIntentBuilder setUpdatePersonId(String peopleQualifiedId) {
        zzp.zzak(peopleQualifiedId, "People qualified ID");
        zzc.zza(AudienceMember.forPersonWithPeopleQualifiedId(peopleQualifiedId, null, null), this.mIntent, "com.google.android.gms.common.acl.EXTRA_UPDATE_PERSON");
        return this;
    }
}

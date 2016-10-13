package com.google.android.gms.people.identity.models;

import android.os.Parcelable;
import java.util.List;

public interface Person extends Parcelable {

    public interface MetadataHolder extends Parcelable {
    }

    public interface Abouts extends Parcelable, MetadataHolder {
    }

    public interface Addresses extends Parcelable, MetadataHolder {
    }

    public interface Birthdays extends Parcelable, MetadataHolder {
    }

    public interface BraggingRights extends Parcelable, MetadataHolder {
    }

    public interface CoverPhotos extends Parcelable {
        ImageReference getImageReference();
    }

    public interface CustomFields extends Parcelable {
    }

    public interface Emails extends Parcelable, MetadataHolder {
    }

    public interface Events extends Parcelable, MetadataHolder {
    }

    public interface Genders extends Parcelable, MetadataHolder {
    }

    public interface Images extends Parcelable, MetadataHolder {
        ImageReference getImageReference();
    }

    public interface InstantMessaging extends Parcelable, MetadataHolder {
    }

    public interface LegacyFields extends Parcelable {
    }

    public interface Memberships extends Parcelable, MetadataHolder {
    }

    public interface Metadata extends Parcelable {
    }

    public interface Names extends Parcelable, MetadataHolder {
    }

    public interface Nicknames extends Parcelable, MetadataHolder {
    }

    public interface Notes extends Parcelable, MetadataHolder {
    }

    public interface Occupations extends Parcelable, MetadataHolder {
    }

    public interface Organizations extends Parcelable, MetadataHolder {
    }

    public interface PersonMetadata extends Parcelable {
        ProfileOwnerStats getProfileOwnerStats();
    }

    public interface PhoneNumbers extends Parcelable, MetadataHolder {
    }

    public interface PlacesLived extends Parcelable, MetadataHolder {
    }

    public interface ProfileOwnerStats extends Parcelable {
    }

    public interface Relations extends Parcelable, MetadataHolder {
    }

    public interface RelationshipInterests extends Parcelable, MetadataHolder {
    }

    public interface RelationshipStatuses extends Parcelable, MetadataHolder {
    }

    public interface Skills extends Parcelable, MetadataHolder {
    }

    public interface SortKeys extends Parcelable {
    }

    public interface Taglines extends Parcelable, MetadataHolder {
    }

    public interface Urls extends Parcelable, MetadataHolder {
    }

    List<? extends Abouts> getAbouts();

    List<? extends Addresses> getAddresses();

    List<? extends Birthdays> getBirthdays();

    List<? extends BraggingRights> getBraggingRights();

    List<? extends CoverPhotos> getCoverPhotos();

    List<? extends CustomFields> getCustomFields();

    List<? extends Emails> getEmails();

    List<? extends Events> getEvents();

    List<? extends Genders> getGenders();

    List<? extends Images> getImages();

    List<? extends InstantMessaging> getInstantMessaging();

    LegacyFields getLegacyFields();

    List<? extends Person> getLinkedPeople();

    List<? extends Memberships> getMemberships();

    PersonMetadata getMetadata();

    List<? extends Names> getNames();

    List<? extends Nicknames> getNicknames();

    List<? extends Notes> getNotes();

    List<? extends Occupations> getOccupations();

    List<? extends Organizations> getOrganizations();

    List<? extends PhoneNumbers> getPhoneNumbers();

    List<? extends PlacesLived> getPlacesLived();

    List<? extends Relations> getRelations();

    List<? extends RelationshipInterests> getRelationshipInterests();

    List<? extends RelationshipStatuses> getRelationshipStatuses();

    List<? extends Skills> getSkills();

    SortKeys getSortKeys();

    List<? extends Taglines> getTaglines();

    List<? extends Urls> getUrls();
}

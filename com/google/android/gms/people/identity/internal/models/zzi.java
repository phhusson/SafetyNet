package com.google.android.gms.people.identity.internal.models;

import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Abouts;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Addresses;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Birthdays;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.BraggingRights;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.CoverPhotos;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.CustomFields;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Emails;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Events;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Genders;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Images;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.InstantMessaging;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.LegacyFields;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Memberships;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Metadata;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Metadata.ProfileOwnerStats;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Names;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Nicknames;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Occupations;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Organizations;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.PhoneNumbers;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.PlacesLived;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Relations;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.RelationshipInterests;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.RelationshipStatuses;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Skills;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.SortKeys;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Taglines;
import com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Urls;
import com.google.android.gms.people.identity.internal.models.PersonImpl.AboutsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.AddressesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.BirthdaysImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.BraggingRightsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.CoverPhotosImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.CustomFieldsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.EmailsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.EventsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.GendersImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.ImagesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.InstantMessagingImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.LegacyFieldsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MembershipsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.NamesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.NicknamesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.OccupationsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.OrganizationsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.PersonMetadataImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.PhoneNumbersImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.PlacesLivedImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.ProfileOwnerStatsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.RelationsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.RelationshipInterestsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.RelationshipStatusesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.SkillsImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.SortKeysImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.TaglinesImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.UrlsImpl;

public class zzi {
    private static AboutsImpl zza(Abouts abouts) {
        AboutsImpl aboutsImpl = new AboutsImpl();
        if (abouts.zzGR()) {
            aboutsImpl.zza(zza(abouts.zzHf()));
        }
        if (abouts.hasType()) {
            aboutsImpl.zzgc(abouts.getType());
        }
        if (abouts.hasValue()) {
            aboutsImpl.zzgd(abouts.getValue());
        }
        return aboutsImpl;
    }

    private static AddressesImpl zza(Addresses addresses) {
        AddressesImpl addressesImpl = new AddressesImpl();
        if (addresses.zzGR()) {
            addressesImpl.zzb(zza(addresses.zzHf()));
        }
        if (addresses.zzHg()) {
            addressesImpl.zzge(addresses.getCity());
        }
        if (addresses.zzHh()) {
            addressesImpl.zzgf(addresses.getCountry());
        }
        if (addresses.zzHi()) {
            addressesImpl.zzgg(addresses.getCountryCode());
        }
        if (addresses.zzHk()) {
            addressesImpl.zzgh(addresses.zzHj());
        }
        if (addresses.zzHm()) {
            addressesImpl.zzgi(addresses.zzHl());
        }
        if (addresses.hasPostalCode()) {
            addressesImpl.zzgj(addresses.getPostalCode());
        }
        if (addresses.zzHn()) {
            addressesImpl.zzgk(addresses.getRegion());
        }
        if (addresses.hasStreetAddress()) {
            addressesImpl.zzgl(addresses.getStreetAddress());
        }
        if (addresses.hasType()) {
            addressesImpl.zzgm(addresses.getType());
        }
        if (addresses.hasValue()) {
            addressesImpl.zzgn(addresses.getValue());
        }
        return addressesImpl;
    }

    private static BirthdaysImpl zza(Birthdays birthdays) {
        BirthdaysImpl birthdaysImpl = new BirthdaysImpl();
        if (birthdays.zzGR()) {
            birthdaysImpl.zzc(zza(birthdays.zzHf()));
        }
        if (birthdays.zzHp()) {
            birthdaysImpl.zzgo(birthdays.zzHo());
        }
        return birthdaysImpl;
    }

    private static BraggingRightsImpl zza(BraggingRights braggingRights) {
        BraggingRightsImpl braggingRightsImpl = new BraggingRightsImpl();
        if (braggingRights.zzGR()) {
            braggingRightsImpl.zzd(zza(braggingRights.zzHf()));
        }
        if (braggingRights.hasValue()) {
            braggingRightsImpl.zzgp(braggingRights.getValue());
        }
        return braggingRightsImpl;
    }

    private static CoverPhotosImpl zza(CoverPhotos coverPhotos) {
        CoverPhotosImpl coverPhotosImpl = new CoverPhotosImpl();
        if (coverPhotos.hasHeight()) {
            coverPhotosImpl.zznc(coverPhotos.getHeight());
        }
        if (coverPhotos.hasId()) {
            coverPhotosImpl.zzgq(coverPhotos.getId());
        }
        if (coverPhotos.hasUrl()) {
            coverPhotosImpl.zza(new ImageReferenceImpl().zzfW(coverPhotos.getUrl()).zzmQ(1));
        }
        if (coverPhotos.hasWidth()) {
            coverPhotosImpl.zznd(coverPhotos.getWidth());
        }
        if (coverPhotos.zzHq()) {
            coverPhotosImpl.zzaH(coverPhotos.isDefault());
        }
        return coverPhotosImpl;
    }

    private static CustomFieldsImpl zza(CustomFields customFields) {
        CustomFieldsImpl customFieldsImpl = new CustomFieldsImpl();
        if (customFields.hasKey()) {
            customFieldsImpl.zzgr(customFields.getKey());
        }
        if (customFields.hasValue()) {
            customFieldsImpl.zzgs(customFields.getValue());
        }
        return customFieldsImpl;
    }

    private static EmailsImpl zza(Emails emails) {
        EmailsImpl emailsImpl = new EmailsImpl();
        if (emails.zzGR()) {
            emailsImpl.zze(zza(emails.zzHf()));
        }
        if (emails.zzHk()) {
            emailsImpl.zzgt(emails.zzHj());
        }
        if (emails.hasType()) {
            emailsImpl.zzgu(emails.getType());
        }
        if (emails.hasValue()) {
            emailsImpl.zzgv(emails.getValue());
        }
        return emailsImpl;
    }

    private static EventsImpl zza(Events events) {
        EventsImpl eventsImpl = new EventsImpl();
        if (events.zzGR()) {
            eventsImpl.zzf(zza(events.zzHf()));
        }
        if (events.zzHk()) {
            eventsImpl.zzgw(events.zzHj());
        }
        if (events.hasType()) {
            eventsImpl.zzgx(events.getType());
        }
        if (events.zzHp()) {
            eventsImpl.zzgy(events.zzHo());
        }
        return eventsImpl;
    }

    private static GendersImpl zza(Genders genders) {
        GendersImpl gendersImpl = new GendersImpl();
        if (genders.zzGR()) {
            gendersImpl.zzg(zza(genders.zzHf()));
        }
        if (genders.zzHr()) {
            gendersImpl.zzgz(genders.getFormattedValue());
        }
        if (genders.hasValue()) {
            gendersImpl.zzgA(genders.getValue());
        }
        return gendersImpl;
    }

    private static ImagesImpl zza(Images images) {
        ImagesImpl imagesImpl = new ImagesImpl();
        if (images.zzGR()) {
            imagesImpl.zzh(zza(images.zzHf()));
        }
        if (images.hasUrl()) {
            imagesImpl.zzb(new ImageReferenceImpl().zzfW(images.getUrl()).zzmQ(1));
        }
        if (images.zzHq()) {
            imagesImpl.zzaI(images.isDefault());
        }
        return imagesImpl;
    }

    private static InstantMessagingImpl zza(InstantMessaging instantMessaging) {
        InstantMessagingImpl instantMessagingImpl = new InstantMessagingImpl();
        if (instantMessaging.zzGR()) {
            instantMessagingImpl.zzi(zza(instantMessaging.zzHf()));
        }
        if (instantMessaging.zzHt()) {
            instantMessagingImpl.zzgB(instantMessaging.zzHs());
        }
        if (instantMessaging.zzHk()) {
            instantMessagingImpl.zzgC(instantMessaging.zzHj());
        }
        if (instantMessaging.zzHu()) {
            instantMessagingImpl.zzgD(instantMessaging.getProtocol());
        }
        if (instantMessaging.hasType()) {
            instantMessagingImpl.zzgE(instantMessaging.getType());
        }
        if (instantMessaging.hasValue()) {
            instantMessagingImpl.zzgF(instantMessaging.getValue());
        }
        return instantMessagingImpl;
    }

    private static LegacyFieldsImpl zza(LegacyFields legacyFields) {
        LegacyFieldsImpl legacyFieldsImpl = new LegacyFieldsImpl();
        if (legacyFields.zzHw()) {
            legacyFieldsImpl.zzgG(legacyFields.zzHv());
        }
        return legacyFieldsImpl;
    }

    private static MembershipsImpl zza(Memberships memberships) {
        MembershipsImpl membershipsImpl = new MembershipsImpl();
        if (memberships.zzGR()) {
            membershipsImpl.zzj(zza(memberships.zzHf()));
        }
        if (memberships.zzHy()) {
            membershipsImpl.zzgH(memberships.zzHx());
        }
        if (memberships.zzHA()) {
            membershipsImpl.zzgI(memberships.zzHz());
        }
        if (memberships.zzHC()) {
            membershipsImpl.zzgJ(memberships.zzHB());
        }
        return membershipsImpl;
    }

    private static MetadataImpl zza(DefaultMetadataImpl defaultMetadataImpl) {
        MetadataImpl metadataImpl = new MetadataImpl();
        if (defaultMetadataImpl.zzGr()) {
            metadataImpl.zzgK(defaultMetadataImpl.zzGq());
        }
        if (defaultMetadataImpl.zzGt()) {
            metadataImpl.zzgL(defaultMetadataImpl.zzGs());
        }
        if (defaultMetadataImpl.zzGu()) {
            metadataImpl.zzgM(defaultMetadataImpl.getContainerId());
        }
        if (defaultMetadataImpl.zzGy()) {
            metadataImpl.zzgN(defaultMetadataImpl.zzGx());
        }
        if (defaultMetadataImpl.zzGw()) {
            metadataImpl.zzaJ(defaultMetadataImpl.zzGv());
        }
        if (defaultMetadataImpl.hasPrimary()) {
            metadataImpl.zzaK(defaultMetadataImpl.isPrimary());
        }
        if (defaultMetadataImpl.hasVerified()) {
            metadataImpl.zzaL(defaultMetadataImpl.isVerified());
        }
        if (defaultMetadataImpl.zzGA()) {
            metadataImpl.zzaM(defaultMetadataImpl.zzGz());
        }
        return metadataImpl;
    }

    private static NamesImpl zza(Names names) {
        NamesImpl namesImpl = new NamesImpl();
        if (names.zzGR()) {
            namesImpl.zzk(zza(names.zzHf()));
        }
        if (names.hasDisplayName()) {
            namesImpl.zzgO(names.getDisplayName());
        }
        if (names.hasFamilyName()) {
            namesImpl.zzgP(names.getFamilyName());
        }
        if (names.hasFormatted()) {
            namesImpl.zzgQ(names.getFormatted());
        }
        if (names.hasGivenName()) {
            namesImpl.zzgR(names.getGivenName());
        }
        if (names.hasHonorificPrefix()) {
            namesImpl.zzgS(names.getHonorificPrefix());
        }
        if (names.hasHonorificSuffix()) {
            namesImpl.zzgT(names.getHonorificSuffix());
        }
        if (names.hasMiddleName()) {
            namesImpl.zzgU(names.getMiddleName());
        }
        if (names.zzIf()) {
            namesImpl.zzgV(names.zzIe());
        }
        if (names.zzIh()) {
            namesImpl.zzgW(names.zzIg());
        }
        if (names.zzIj()) {
            namesImpl.zzgX(names.zzIi());
        }
        if (names.zzIl()) {
            namesImpl.zzgY(names.zzIk());
        }
        return namesImpl;
    }

    private static NicknamesImpl zza(Nicknames nicknames) {
        NicknamesImpl nicknamesImpl = new NicknamesImpl();
        if (nicknames.zzGR()) {
            nicknamesImpl.zzl(zza(nicknames.zzHf()));
        }
        if (nicknames.hasType()) {
            nicknamesImpl.zzgZ(nicknames.getType());
        }
        if (nicknames.hasValue()) {
            nicknamesImpl.zzha(nicknames.getValue());
        }
        return nicknamesImpl;
    }

    private static OccupationsImpl zza(Occupations occupations) {
        OccupationsImpl occupationsImpl = new OccupationsImpl();
        if (occupations.zzGR()) {
            occupationsImpl.zzn(zza(occupations.zzHf()));
        }
        if (occupations.hasValue()) {
            occupationsImpl.zzhc(occupations.getValue());
        }
        return occupationsImpl;
    }

    private static OrganizationsImpl zza(Organizations organizations) {
        OrganizationsImpl organizationsImpl = new OrganizationsImpl();
        if (organizations.zzGR()) {
            organizationsImpl.zzo(zza(organizations.zzHf()));
        }
        if (organizations.zzIn()) {
            organizationsImpl.zzaN(organizations.zzIm());
        }
        if (organizations.hasDepartment()) {
            organizationsImpl.zzhd(organizations.getDepartment());
        }
        if (organizations.hasDescription()) {
            organizationsImpl.zzhe(organizations.getDescription());
        }
        if (organizations.zzIo()) {
            organizationsImpl.zzhf(organizations.getDomain());
        }
        if (organizations.hasEndDate()) {
            organizationsImpl.zzhg(organizations.getEndDate());
        }
        if (organizations.hasLocation()) {
            organizationsImpl.zzhh(organizations.getLocation());
        }
        if (organizations.hasName()) {
            organizationsImpl.zzhi(organizations.getName());
        }
        if (organizations.zzIq()) {
            organizationsImpl.zzhj(organizations.zzIp());
        }
        if (organizations.hasStartDate()) {
            organizationsImpl.zzhk(organizations.getStartDate());
        }
        if (organizations.zzIr()) {
            organizationsImpl.zzhl(organizations.getSymbol());
        }
        if (organizations.hasTitle()) {
            organizationsImpl.zzhm(organizations.getTitle());
        }
        if (organizations.hasType()) {
            organizationsImpl.zzhn(organizations.getType());
        }
        return organizationsImpl;
    }

    private static PersonMetadataImpl zza(Metadata metadata) {
        PersonMetadataImpl personMetadataImpl = new PersonMetadataImpl();
        if (metadata.zzHE()) {
            personMetadataImpl.zzv(metadata.zzHD());
        }
        if (metadata.zzHG()) {
            personMetadataImpl.zzw(metadata.zzHF());
        }
        if (metadata.zzHI()) {
            personMetadataImpl.zzx(metadata.getCircles());
        }
        if (metadata.zzHK()) {
            personMetadataImpl.zzy(metadata.zzHJ());
        }
        if (metadata.zzHO()) {
            personMetadataImpl.zzz(metadata.zzHN());
        }
        if (metadata.zzHS()) {
            personMetadataImpl.zzA(metadata.zzHR());
        }
        if (metadata.hasObjectType()) {
            personMetadataImpl.zzhp(metadata.zzwm());
        }
        if (metadata.zzHT()) {
            personMetadataImpl.zzhq(metadata.getOwnerId());
        }
        if (metadata.zzHV()) {
            personMetadataImpl.zzB(metadata.zzHU());
        }
        if (metadata.zzHX()) {
            personMetadataImpl.zzhr(metadata.zzHW());
        }
        if (metadata.zzHZ()) {
            personMetadataImpl.zza(zza(metadata.zzHY()));
        }
        if (metadata.zzHH()) {
            personMetadataImpl.zzaO(metadata.isBlocked());
        }
        if (metadata.zzHM()) {
            personMetadataImpl.zzaP(metadata.zzHL());
        }
        if (metadata.zzHQ()) {
            personMetadataImpl.zzaQ(metadata.zzHP());
        }
        return personMetadataImpl;
    }

    private static PhoneNumbersImpl zza(PhoneNumbers phoneNumbers) {
        PhoneNumbersImpl phoneNumbersImpl = new PhoneNumbersImpl();
        if (phoneNumbers.zzGR()) {
            phoneNumbersImpl.zzp(zza(phoneNumbers.zzHf()));
        }
        if (phoneNumbers.zzIt()) {
            phoneNumbersImpl.zzhs(phoneNumbers.zzIs());
        }
        if (phoneNumbers.zzHk()) {
            phoneNumbersImpl.zzht(phoneNumbers.zzHj());
        }
        if (phoneNumbers.hasType()) {
            phoneNumbersImpl.zzhu(phoneNumbers.getType());
        }
        if (phoneNumbers.hasValue()) {
            phoneNumbersImpl.zzhv(phoneNumbers.getValue());
        }
        return phoneNumbersImpl;
    }

    private static PlacesLivedImpl zza(PlacesLived placesLived) {
        PlacesLivedImpl placesLivedImpl = new PlacesLivedImpl();
        if (placesLived.zzGR()) {
            placesLivedImpl.zzq(zza(placesLived.zzHf()));
        }
        if (placesLived.zzIn()) {
            placesLivedImpl.zzaR(placesLived.zzIm());
        }
        if (placesLived.hasValue()) {
            placesLivedImpl.zzhw(placesLived.getValue());
        }
        return placesLivedImpl;
    }

    private static ProfileOwnerStatsImpl zza(ProfileOwnerStats profileOwnerStats) {
        ProfileOwnerStatsImpl profileOwnerStatsImpl = new ProfileOwnerStatsImpl();
        if (profileOwnerStats.zzIb()) {
            profileOwnerStatsImpl.zzaE(profileOwnerStats.zzIa());
        }
        if (profileOwnerStats.zzId()) {
            profileOwnerStatsImpl.zzaF(profileOwnerStats.zzIc());
        }
        return profileOwnerStatsImpl;
    }

    private static RelationsImpl zza(Relations relations) {
        RelationsImpl relationsImpl = new RelationsImpl();
        if (relations.zzGR()) {
            relationsImpl.zzr(zza(relations.zzHf()));
        }
        if (relations.zzHk()) {
            relationsImpl.zzhx(relations.zzHj());
        }
        if (relations.hasType()) {
            relationsImpl.zzhy(relations.getType());
        }
        if (relations.hasValue()) {
            relationsImpl.zzhz(relations.getValue());
        }
        return relationsImpl;
    }

    private static RelationshipInterestsImpl zza(RelationshipInterests relationshipInterests) {
        RelationshipInterestsImpl relationshipInterestsImpl = new RelationshipInterestsImpl();
        if (relationshipInterests.zzGR()) {
            relationshipInterestsImpl.zzs(zza(relationshipInterests.zzHf()));
        }
        if (relationshipInterests.hasValue()) {
            relationshipInterestsImpl.zzhA(relationshipInterests.getValue());
        }
        return relationshipInterestsImpl;
    }

    private static RelationshipStatusesImpl zza(RelationshipStatuses relationshipStatuses) {
        RelationshipStatusesImpl relationshipStatusesImpl = new RelationshipStatusesImpl();
        if (relationshipStatuses.zzGR()) {
            relationshipStatusesImpl.zzt(zza(relationshipStatuses.zzHf()));
        }
        if (relationshipStatuses.zzHr()) {
            relationshipStatusesImpl.zzhB(relationshipStatuses.getFormattedValue());
        }
        if (relationshipStatuses.hasValue()) {
            relationshipStatusesImpl.zzhC(relationshipStatuses.getValue());
        }
        return relationshipStatusesImpl;
    }

    private static SkillsImpl zza(Skills skills) {
        SkillsImpl skillsImpl = new SkillsImpl();
        if (skills.zzGR()) {
            skillsImpl.zzu(zza(skills.zzHf()));
        }
        if (skills.hasValue()) {
            skillsImpl.zzhD(skills.getValue());
        }
        return skillsImpl;
    }

    private static SortKeysImpl zza(SortKeys sortKeys) {
        SortKeysImpl sortKeysImpl = new SortKeysImpl();
        if (sortKeys.zzIv()) {
            sortKeysImpl.zzhE(sortKeys.zzIu());
        }
        if (sortKeys.hasName()) {
            sortKeysImpl.zzhF(sortKeys.getName());
        }
        return sortKeysImpl;
    }

    private static TaglinesImpl zza(Taglines taglines) {
        TaglinesImpl taglinesImpl = new TaglinesImpl();
        if (taglines.zzGR()) {
            taglinesImpl.zzv(zza(taglines.zzHf()));
        }
        if (taglines.hasValue()) {
            taglinesImpl.zzhG(taglines.getValue());
        }
        return taglinesImpl;
    }

    private static UrlsImpl zza(Urls urls) {
        UrlsImpl urlsImpl = new UrlsImpl();
        if (urls.zzGR()) {
            urlsImpl.zzw(zza(urls.zzHf()));
        }
        if (urls.zzHk()) {
            urlsImpl.zzhH(urls.zzHj());
        }
        if (urls.hasType()) {
            urlsImpl.zzhI(urls.getType());
        }
        if (urls.hasValue()) {
            urlsImpl.zzhJ(urls.getValue());
        }
        return urlsImpl;
    }

    public static PersonImpl zza(DefaultPersonImpl defaultPersonImpl, PersonImpl personImpl) {
        if (defaultPersonImpl.zzGB()) {
            for (Abouts zza : defaultPersonImpl.getAbouts()) {
                personImpl.zza(zza(zza));
            }
        }
        if (defaultPersonImpl.zzGC()) {
            for (Addresses zza2 : defaultPersonImpl.getAddresses()) {
                personImpl.zza(zza(zza2));
            }
        }
        if (defaultPersonImpl.hasAgeRange()) {
            personImpl.zzfX(defaultPersonImpl.zzGD());
        }
        if (defaultPersonImpl.zzGE()) {
            for (Birthdays zza3 : defaultPersonImpl.getBirthdays()) {
                personImpl.zza(zza(zza3));
            }
        }
        if (defaultPersonImpl.hasBraggingRights()) {
            for (BraggingRights zza4 : defaultPersonImpl.getBraggingRights()) {
                personImpl.zza(zza(zza4));
            }
        }
        if (defaultPersonImpl.zzGF()) {
            for (CoverPhotos zza5 : defaultPersonImpl.getCoverPhotos()) {
                personImpl.zza(zza(zza5));
            }
        }
        if (defaultPersonImpl.zzGG()) {
            for (CustomFields zza6 : defaultPersonImpl.getCustomFields()) {
                personImpl.zza(zza(zza6));
            }
        }
        if (defaultPersonImpl.zzGH()) {
            for (Emails zza7 : defaultPersonImpl.getEmails()) {
                personImpl.zza(zza(zza7));
            }
        }
        if (defaultPersonImpl.zzGI()) {
            personImpl.zzfY(defaultPersonImpl.getEtag());
        }
        if (defaultPersonImpl.zzGJ()) {
            for (Events zza8 : defaultPersonImpl.getEvents()) {
                personImpl.zza(zza(zza8));
            }
        }
        if (defaultPersonImpl.zzGK()) {
            for (Genders zza9 : defaultPersonImpl.getGenders()) {
                personImpl.zza(zza(zza9));
            }
        }
        if (defaultPersonImpl.hasId()) {
            personImpl.zzfZ(defaultPersonImpl.getId());
        }
        if (defaultPersonImpl.hasImages()) {
            for (Images zza10 : defaultPersonImpl.getImages()) {
                personImpl.zza(zza(zza10));
            }
        }
        if (defaultPersonImpl.zzGL()) {
            for (InstantMessaging zza11 : defaultPersonImpl.getInstantMessaging()) {
                personImpl.zza(zza(zza11));
            }
        }
        if (defaultPersonImpl.hasLanguage()) {
            personImpl.zzga(defaultPersonImpl.getLanguage());
        }
        if (defaultPersonImpl.zzGN()) {
            personImpl.zza(zza(defaultPersonImpl.zzGM()));
        }
        if (defaultPersonImpl.zzGO()) {
            for (DefaultPersonImpl zza12 : defaultPersonImpl.getLinkedPeople()) {
                personImpl.zza(zza(zza12, new PersonImpl()));
            }
        }
        if (defaultPersonImpl.zzGP()) {
            for (Memberships zza13 : defaultPersonImpl.getMemberships()) {
                personImpl.zza(zza(zza13));
            }
        }
        if (defaultPersonImpl.zzGR()) {
            personImpl.zza(zza(defaultPersonImpl.zzGQ()));
        }
        if (defaultPersonImpl.zzGS()) {
            for (Names zza14 : defaultPersonImpl.getNames()) {
                personImpl.zza(zza(zza14));
            }
        }
        if (defaultPersonImpl.zzGT()) {
            for (Nicknames zza15 : defaultPersonImpl.getNicknames()) {
                personImpl.zza(zza(zza15));
            }
        }
        if (defaultPersonImpl.zzGU()) {
            for (Occupations zza16 : defaultPersonImpl.getOccupations()) {
                personImpl.zza(zza(zza16));
            }
        }
        if (defaultPersonImpl.hasOrganizations()) {
            for (Organizations zza17 : defaultPersonImpl.getOrganizations()) {
                personImpl.zza(zza(zza17));
            }
        }
        if (defaultPersonImpl.zzGV()) {
            for (PhoneNumbers zza18 : defaultPersonImpl.getPhoneNumbers()) {
                personImpl.zza(zza(zza18));
            }
        }
        if (defaultPersonImpl.hasPlacesLived()) {
            for (PlacesLived zza19 : defaultPersonImpl.getPlacesLived()) {
                personImpl.zza(zza(zza19));
            }
        }
        if (defaultPersonImpl.zzGX()) {
            personImpl.zzgb(defaultPersonImpl.zzGW());
        }
        if (defaultPersonImpl.zzGY()) {
            for (Relations zza20 : defaultPersonImpl.getRelations()) {
                personImpl.zza(zza(zza20));
            }
        }
        if (defaultPersonImpl.zzGZ()) {
            for (RelationshipInterests zza21 : defaultPersonImpl.getRelationshipInterests()) {
                personImpl.zza(zza(zza21));
            }
        }
        if (defaultPersonImpl.zzHa()) {
            for (RelationshipStatuses zza22 : defaultPersonImpl.getRelationshipStatuses()) {
                personImpl.zza(zza(zza22));
            }
        }
        if (defaultPersonImpl.zzHb()) {
            for (Skills zza23 : defaultPersonImpl.getSkills()) {
                personImpl.zza(zza(zza23));
            }
        }
        if (defaultPersonImpl.zzHd()) {
            personImpl.zza(zza(defaultPersonImpl.zzHc()));
        }
        if (defaultPersonImpl.zzHe()) {
            for (Taglines zza24 : defaultPersonImpl.getTaglines()) {
                personImpl.zza(zza(zza24));
            }
        }
        if (defaultPersonImpl.hasUrls()) {
            for (Urls zza25 : defaultPersonImpl.getUrls()) {
                personImpl.zza(zza(zza25));
            }
        }
        return personImpl;
    }
}

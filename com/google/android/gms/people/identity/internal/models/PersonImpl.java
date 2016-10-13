package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.ImageReference;
import com.google.android.gms.people.identity.models.Person;
import com.google.android.gms.people.identity.models.Person.Abouts;
import com.google.android.gms.people.identity.models.Person.Addresses;
import com.google.android.gms.people.identity.models.Person.Birthdays;
import com.google.android.gms.people.identity.models.Person.BraggingRights;
import com.google.android.gms.people.identity.models.Person.CoverPhotos;
import com.google.android.gms.people.identity.models.Person.CustomFields;
import com.google.android.gms.people.identity.models.Person.Emails;
import com.google.android.gms.people.identity.models.Person.Events;
import com.google.android.gms.people.identity.models.Person.Genders;
import com.google.android.gms.people.identity.models.Person.Images;
import com.google.android.gms.people.identity.models.Person.InstantMessaging;
import com.google.android.gms.people.identity.models.Person.LegacyFields;
import com.google.android.gms.people.identity.models.Person.Memberships;
import com.google.android.gms.people.identity.models.Person.Metadata;
import com.google.android.gms.people.identity.models.Person.Names;
import com.google.android.gms.people.identity.models.Person.Nicknames;
import com.google.android.gms.people.identity.models.Person.Notes;
import com.google.android.gms.people.identity.models.Person.Occupations;
import com.google.android.gms.people.identity.models.Person.Organizations;
import com.google.android.gms.people.identity.models.Person.PersonMetadata;
import com.google.android.gms.people.identity.models.Person.PhoneNumbers;
import com.google.android.gms.people.identity.models.Person.PlacesLived;
import com.google.android.gms.people.identity.models.Person.ProfileOwnerStats;
import com.google.android.gms.people.identity.models.Person.Relations;
import com.google.android.gms.people.identity.models.Person.RelationshipInterests;
import com.google.android.gms.people.identity.models.Person.RelationshipStatuses;
import com.google.android.gms.people.identity.models.Person.Skills;
import com.google.android.gms.people.identity.models.Person.SortKeys;
import com.google.android.gms.people.identity.models.Person.Taglines;
import com.google.android.gms.people.identity.models.Person.Urls;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonImpl implements SafeParcelable, Person {
    public static final zzbd CREATOR = new zzbd();
    final int mVersionCode;
    String zzajR;
    List<AddressesImpl> zzbAh;
    List<EmailsImpl> zzbAi;
    List<NicknamesImpl> zzbCA;
    List<OccupationsImpl> zzbCB;
    List<OrganizationsImpl> zzbCC;
    List<PhoneNumbersImpl> zzbCD;
    List<PlacesLivedImpl> zzbCE;
    String zzbCF;
    List<RelationsImpl> zzbCG;
    List<RelationshipInterestsImpl> zzbCH;
    List<RelationshipStatusesImpl> zzbCI;
    List<SkillsImpl> zzbCJ;
    List<TaglinesImpl> zzbCL;
    List<UrlsImpl> zzbCM;
    final Set<Integer> zzbCc;
    List<AboutsImpl> zzbCm;
    String zzbCn;
    List<BirthdaysImpl> zzbCo;
    List<BraggingRightsImpl> zzbCp;
    List<CoverPhotosImpl> zzbCq;
    List<CustomFieldsImpl> zzbCr;
    String zzbCs;
    List<GendersImpl> zzbCt;
    List<InstantMessagingImpl> zzbCu;
    List<PersonImpl> zzbCw;
    List<MembershipsImpl> zzbCx;
    List<NamesImpl> zzbCz;
    LegacyFieldsImpl zzbDN;
    PersonMetadataImpl zzbDO;
    SortKeysImpl zzbDP;
    List<NotesImpl> zzbDQ;
    List<EventsImpl> zzql;
    String zzyU;
    List<ImagesImpl> zzyw;

    public static class AboutsImpl implements SafeParcelable, Abouts {
        public static final zza CREATOR = new zza();
        String mValue;
        final int mVersionCode;
        String zzKj;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public AboutsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        AboutsImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzKj = type;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zza.zza(this, out, flags);
        }

        public AboutsImpl zza(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }

        public AboutsImpl zzgc(String str) {
            this.zzKj = str;
            return this;
        }

        public AboutsImpl zzgd(String str) {
            this.mValue = str;
            return this;
        }
    }

    public static class AddressesImpl implements SafeParcelable, Addresses {
        public static final zzb CREATOR = new zzb();
        String mValue;
        final int mVersionCode;
        String zzKj;
        String zzbCO;
        String zzbCP;
        String zzbCQ;
        String zzbCR;
        String zzbCS;
        String zzbCT;
        String zzbCU;
        String zzbCV;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public AddressesImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        AddressesImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String city, String country, String countryCode, String formattedType, String poBox, String postalCode, String region, String streetAddress, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzbCO = city;
            this.zzbCP = country;
            this.zzbCQ = countryCode;
            this.zzbCR = formattedType;
            this.zzbCS = poBox;
            this.zzbCT = postalCode;
            this.zzbCU = region;
            this.zzbCV = streetAddress;
            this.zzKj = type;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzb.zza(this, out, flags);
        }

        public AddressesImpl zzb(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }

        public AddressesImpl zzge(String str) {
            this.zzbCO = str;
            return this;
        }

        public AddressesImpl zzgf(String str) {
            this.zzbCP = str;
            return this;
        }

        public AddressesImpl zzgg(String str) {
            this.zzbCQ = str;
            return this;
        }

        public AddressesImpl zzgh(String str) {
            this.zzbCR = str;
            return this;
        }

        public AddressesImpl zzgi(String str) {
            this.zzbCS = str;
            return this;
        }

        public AddressesImpl zzgj(String str) {
            this.zzbCT = str;
            return this;
        }

        public AddressesImpl zzgk(String str) {
            this.zzbCU = str;
            return this;
        }

        public AddressesImpl zzgl(String str) {
            this.zzbCV = str;
            return this;
        }

        public AddressesImpl zzgm(String str) {
            this.zzKj = str;
            return this;
        }

        public AddressesImpl zzgn(String str) {
            this.mValue = str;
            return this;
        }
    }

    public static class BirthdaysImpl implements SafeParcelable, Birthdays {
        public static final zzc CREATOR = new zzc();
        final int mVersionCode;
        String zzbCW;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public BirthdaysImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        BirthdaysImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String date) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzbCW = date;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzc.zza(this, out, flags);
        }

        public BirthdaysImpl zzc(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }

        public BirthdaysImpl zzgo(String str) {
            this.zzbCW = str;
            return this;
        }
    }

    public static class BraggingRightsImpl implements SafeParcelable, BraggingRights {
        public static final zzd CREATOR = new zzd();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public BraggingRightsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        BraggingRightsImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzd.zza(this, out, flags);
        }

        public BraggingRightsImpl zzd(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }

        public BraggingRightsImpl zzgp(String str) {
            this.mValue = str;
            return this;
        }
    }

    public static class CoverPhotosImpl implements SafeParcelable, CoverPhotos {
        public static final zze CREATOR = new zze();
        final int mVersionCode;
        final Set<Integer> zzbCc;
        ImageReferenceImpl zzbDS;
        boolean zzbDT;
        int zzoW;
        int zzoX;
        String zzyU;

        public CoverPhotosImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        CoverPhotosImpl(Set<Integer> indicatorSet, int versionCode, int height, String id, ImageReferenceImpl imageReference, int width, boolean isDefault) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzoX = height;
            this.zzyU = id;
            this.zzbDS = imageReference;
            this.zzoW = width;
            this.zzbDT = isDefault;
        }

        public int describeContents() {
            return 0;
        }

        public /* synthetic */ ImageReference getImageReference() {
            return zzJa();
        }

        public void writeToParcel(Parcel out, int flags) {
            zze.zza(this, out, flags);
        }

        public ImageReferenceImpl zzJa() {
            return this.zzbDS;
        }

        public CoverPhotosImpl zza(ImageReferenceImpl imageReferenceImpl) {
            this.zzbDS = imageReferenceImpl;
            return this;
        }

        public CoverPhotosImpl zzaH(boolean z) {
            this.zzbCc.add(Integer.valueOf(6));
            this.zzbDT = z;
            return this;
        }

        public CoverPhotosImpl zzgq(String str) {
            this.zzyU = str;
            return this;
        }

        public CoverPhotosImpl zznc(int i) {
            this.zzbCc.add(Integer.valueOf(2));
            this.zzoX = i;
            return this;
        }

        public CoverPhotosImpl zznd(int i) {
            this.zzbCc.add(Integer.valueOf(5));
            this.zzoW = i;
            return this;
        }
    }

    public static class CustomFieldsImpl implements SafeParcelable, CustomFields {
        public static final zzf CREATOR = new zzf();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzbCc;
        String zzvV;

        public CustomFieldsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        CustomFieldsImpl(Set<Integer> indicatorSet, int versionCode, String key, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzvV = key;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzf.zza(this, out, flags);
        }

        public CustomFieldsImpl zzgr(String str) {
            this.zzvV = str;
            return this;
        }

        public CustomFieldsImpl zzgs(String str) {
            this.mValue = str;
            return this;
        }
    }

    public static class EmailsImpl implements SafeParcelable, Emails {
        public static final zzap CREATOR = new zzap();
        String mValue;
        final int mVersionCode;
        String zzKj;
        int zzbAq;
        String zzbCR;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public EmailsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        EmailsImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String formattedType, String type, String value, int timesUsed) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzbCR = formattedType;
            this.zzKj = type;
            this.mValue = value;
            this.zzbAq = timesUsed;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzap.zza(this, out, flags);
        }

        public EmailsImpl zze(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }

        public EmailsImpl zzgt(String str) {
            this.zzbCR = str;
            return this;
        }

        public EmailsImpl zzgu(String str) {
            this.zzKj = str;
            return this;
        }

        public EmailsImpl zzgv(String str) {
            this.mValue = str;
            return this;
        }

        public EmailsImpl zzne(int i) {
            this.zzbCc.add(Integer.valueOf(6));
            this.zzbAq = i;
            return this;
        }
    }

    public static class EventsImpl implements SafeParcelable, Events {
        public static final zzaq CREATOR = new zzaq();
        final int mVersionCode;
        String zzKj;
        String zzbCR;
        String zzbCW;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public EventsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        EventsImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String formattedType, String type, String date) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzbCR = formattedType;
            this.zzKj = type;
            this.zzbCW = date;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzaq.zza(this, out, flags);
        }

        public EventsImpl zzf(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }

        public EventsImpl zzgw(String str) {
            this.zzbCR = str;
            return this;
        }

        public EventsImpl zzgx(String str) {
            this.zzKj = str;
            return this;
        }

        public EventsImpl zzgy(String str) {
            this.zzbCW = str;
            return this;
        }
    }

    public static class GendersImpl implements SafeParcelable, Genders {
        public static final zzar CREATOR = new zzar();
        String mValue;
        final int mVersionCode;
        String zzaWt;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public GendersImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        GendersImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String formattedValue, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzaWt = formattedValue;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzar.zza(this, out, flags);
        }

        public GendersImpl zzg(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }

        public GendersImpl zzgA(String str) {
            this.mValue = str;
            return this;
        }

        public GendersImpl zzgz(String str) {
            this.zzaWt = str;
            return this;
        }
    }

    public static class ImagesImpl implements SafeParcelable, Images {
        public static final zzat CREATOR = new zzat();
        final int mVersionCode;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;
        ImageReferenceImpl zzbDS;
        boolean zzbDT;

        public ImagesImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        ImagesImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, ImageReferenceImpl imageReference, boolean isDefault) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzbDS = imageReference;
            this.zzbDT = isDefault;
        }

        public int describeContents() {
            return 0;
        }

        public /* synthetic */ ImageReference getImageReference() {
            return zzJa();
        }

        public void writeToParcel(Parcel out, int flags) {
            zzat.zza(this, out, flags);
        }

        public ImageReferenceImpl zzJa() {
            return this.zzbDS;
        }

        public ImagesImpl zzaI(boolean z) {
            this.zzbCc.add(Integer.valueOf(4));
            this.zzbDT = z;
            return this;
        }

        public ImagesImpl zzb(ImageReferenceImpl imageReferenceImpl) {
            this.zzbDS = imageReferenceImpl;
            return this;
        }

        public ImagesImpl zzh(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class InstantMessagingImpl implements SafeParcelable, InstantMessaging {
        public static final zzau CREATOR = new zzau();
        String mValue;
        final int mVersionCode;
        String zzKj;
        String zzbCR;
        String zzbCY;
        String zzbCZ;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public InstantMessagingImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        InstantMessagingImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String formattedProtocol, String formattedType, String protocol, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzbCY = formattedProtocol;
            this.zzbCR = formattedType;
            this.zzbCZ = protocol;
            this.zzKj = type;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzau.zza(this, out, flags);
        }

        public InstantMessagingImpl zzgB(String str) {
            this.zzbCY = str;
            return this;
        }

        public InstantMessagingImpl zzgC(String str) {
            this.zzbCR = str;
            return this;
        }

        public InstantMessagingImpl zzgD(String str) {
            this.zzbCZ = str;
            return this;
        }

        public InstantMessagingImpl zzgE(String str) {
            this.zzKj = str;
            return this;
        }

        public InstantMessagingImpl zzgF(String str) {
            this.mValue = str;
            return this;
        }

        public InstantMessagingImpl zzi(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class LegacyFieldsImpl implements SafeParcelable, LegacyFields {
        public static final zzav CREATOR = new zzav();
        final int mVersionCode;
        final Set<Integer> zzbCc;
        String zzbDa;

        public LegacyFieldsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        LegacyFieldsImpl(Set<Integer> indicatorSet, int versionCode, String mobileOwnerId) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDa = mobileOwnerId;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzav.zza(this, out, flags);
        }

        public LegacyFieldsImpl zzgG(String str) {
            this.zzbDa = str;
            return this;
        }
    }

    public static class MembershipsImpl implements SafeParcelable, Memberships {
        public static final zzaw CREATOR = new zzaw();
        final int mVersionCode;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;
        String zzbDb;
        String zzbDc;
        String zzbDd;

        public MembershipsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        MembershipsImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String circle, String contactGroup, String systemContactGroup) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzbDb = circle;
            this.zzbDc = contactGroup;
            this.zzbDd = systemContactGroup;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzaw.zza(this, out, flags);
        }

        public MembershipsImpl zzgH(String str) {
            this.zzbDb = str;
            return this;
        }

        public MembershipsImpl zzgI(String str) {
            this.zzbDc = str;
            return this;
        }

        public MembershipsImpl zzgJ(String str) {
            this.zzbDd = str;
            return this;
        }

        public MembershipsImpl zzj(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class MetadataImpl implements SafeParcelable, Metadata {
        public static final zzax CREATOR = new zzax();
        final int mVersionCode;
        boolean zzbAo;
        final Set<Integer> zzbCc;
        String zzbCe;
        String zzbCf;
        String zzbCg;
        boolean zzbCh;
        boolean zzbCi;
        String zzbCj;
        boolean zzbCk;
        int zzbDU;

        public MetadataImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        MetadataImpl(Set<Integer> indicatorSet, int versionCode, String container, String containerContactId, String containerId, String visibility, boolean edgeKey, boolean primary, boolean verified, boolean writeable, int rawContactId) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbCe = container;
            this.zzbCf = containerContactId;
            this.zzbCg = containerId;
            this.zzbCj = visibility;
            this.zzbCh = edgeKey;
            this.zzbAo = primary;
            this.zzbCi = verified;
            this.zzbCk = writeable;
            this.zzbDU = rawContactId;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzax.zza(this, out, flags);
        }

        public MetadataImpl zzaJ(boolean z) {
            this.zzbCc.add(Integer.valueOf(6));
            this.zzbCh = z;
            return this;
        }

        public MetadataImpl zzaK(boolean z) {
            this.zzbCc.add(Integer.valueOf(7));
            this.zzbAo = z;
            return this;
        }

        public MetadataImpl zzaL(boolean z) {
            this.zzbCc.add(Integer.valueOf(8));
            this.zzbCi = z;
            return this;
        }

        public MetadataImpl zzaM(boolean z) {
            this.zzbCc.add(Integer.valueOf(9));
            this.zzbCk = z;
            return this;
        }

        public MetadataImpl zzgK(String str) {
            this.zzbCe = str;
            return this;
        }

        public MetadataImpl zzgL(String str) {
            this.zzbCf = str;
            return this;
        }

        public MetadataImpl zzgM(String str) {
            this.zzbCg = str;
            return this;
        }

        public MetadataImpl zzgN(String str) {
            this.zzbCj = str;
            return this;
        }

        public MetadataImpl zznf(int i) {
            this.zzbCc.add(Integer.valueOf(10));
            this.zzbDU = i;
            return this;
        }
    }

    public static class NamesImpl implements SafeParcelable, Names {
        public static final zzay CREATOR = new zzay();
        final int mVersionCode;
        String zzVA;
        final Set<Integer> zzbCc;
        String zzbDA;
        String zzbDB;
        String zzbDC;
        MetadataImpl zzbDR;
        String zzbDt;
        String zzbDu;
        String zzbDv;
        String zzbDw;
        String zzbDx;
        String zzbDy;
        String zzbDz;

        public NamesImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        NamesImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String displayName, String familyName, String formatted, String givenName, String honorificPrefix, String honorificSuffix, String middleName, String phoneticFamilyName, String phoneticGivenName, String phoneticHonorificPrefix, String phoneticHonorificSuffix) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzVA = displayName;
            this.zzbDt = familyName;
            this.zzbDu = formatted;
            this.zzbDv = givenName;
            this.zzbDw = honorificPrefix;
            this.zzbDx = honorificSuffix;
            this.zzbDy = middleName;
            this.zzbDz = phoneticFamilyName;
            this.zzbDA = phoneticGivenName;
            this.zzbDB = phoneticHonorificPrefix;
            this.zzbDC = phoneticHonorificSuffix;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzay.zza(this, out, flags);
        }

        public NamesImpl zzgO(String str) {
            this.zzVA = str;
            return this;
        }

        public NamesImpl zzgP(String str) {
            this.zzbDt = str;
            return this;
        }

        public NamesImpl zzgQ(String str) {
            this.zzbDu = str;
            return this;
        }

        public NamesImpl zzgR(String str) {
            this.zzbDv = str;
            return this;
        }

        public NamesImpl zzgS(String str) {
            this.zzbDw = str;
            return this;
        }

        public NamesImpl zzgT(String str) {
            this.zzbDx = str;
            return this;
        }

        public NamesImpl zzgU(String str) {
            this.zzbDy = str;
            return this;
        }

        public NamesImpl zzgV(String str) {
            this.zzbDz = str;
            return this;
        }

        public NamesImpl zzgW(String str) {
            this.zzbDA = str;
            return this;
        }

        public NamesImpl zzgX(String str) {
            this.zzbDB = str;
            return this;
        }

        public NamesImpl zzgY(String str) {
            this.zzbDC = str;
            return this;
        }

        public NamesImpl zzk(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class NicknamesImpl implements SafeParcelable, Nicknames {
        public static final zzaz CREATOR = new zzaz();
        String mValue;
        final int mVersionCode;
        String zzKj;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public NicknamesImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        NicknamesImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzKj = type;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzaz.zza(this, out, flags);
        }

        public NicknamesImpl zzgZ(String str) {
            this.zzKj = str;
            return this;
        }

        public NicknamesImpl zzha(String str) {
            this.mValue = str;
            return this;
        }

        public NicknamesImpl zzl(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class NotesImpl implements SafeParcelable, Notes {
        public static final zzba CREATOR = new zzba();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public NotesImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        NotesImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzba.zza(this, out, flags);
        }

        public NotesImpl zzhb(String str) {
            this.mValue = str;
            return this;
        }

        public NotesImpl zzm(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class OccupationsImpl implements SafeParcelable, Occupations {
        public static final zzbb CREATOR = new zzbb();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public OccupationsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        OccupationsImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzbb.zza(this, out, flags);
        }

        public OccupationsImpl zzhc(String str) {
            this.mValue = str;
            return this;
        }

        public OccupationsImpl zzn(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class OrganizationsImpl implements SafeParcelable, Organizations {
        public static final zzbc CREATOR = new zzbc();
        String mDescription;
        String mName;
        final int mVersionCode;
        String zzKj;
        String zzaEg;
        final Set<Integer> zzbCc;
        boolean zzbDD;
        String zzbDE;
        String zzbDF;
        String zzbDG;
        String zzbDH;
        String zzbDI;
        String zzbDJ;
        String zzbDK;
        MetadataImpl zzbDR;

        public OrganizationsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        OrganizationsImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, boolean current, String department, String description, String domain, String endDate, String location, String name, String phoneticName, String startDate, String symbol, String title, String type) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzbDD = current;
            this.zzbDE = department;
            this.mDescription = description;
            this.zzbDF = domain;
            this.zzbDG = endDate;
            this.zzbDH = location;
            this.mName = name;
            this.zzbDI = phoneticName;
            this.zzbDJ = startDate;
            this.zzbDK = symbol;
            this.zzaEg = title;
            this.zzKj = type;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzbc.zza(this, out, flags);
        }

        public OrganizationsImpl zzaN(boolean z) {
            this.zzbCc.add(Integer.valueOf(3));
            this.zzbDD = z;
            return this;
        }

        public OrganizationsImpl zzhd(String str) {
            this.zzbDE = str;
            return this;
        }

        public OrganizationsImpl zzhe(String str) {
            this.mDescription = str;
            return this;
        }

        public OrganizationsImpl zzhf(String str) {
            this.zzbDF = str;
            return this;
        }

        public OrganizationsImpl zzhg(String str) {
            this.zzbDG = str;
            return this;
        }

        public OrganizationsImpl zzhh(String str) {
            this.zzbDH = str;
            return this;
        }

        public OrganizationsImpl zzhi(String str) {
            this.mName = str;
            return this;
        }

        public OrganizationsImpl zzhj(String str) {
            this.zzbDI = str;
            return this;
        }

        public OrganizationsImpl zzhk(String str) {
            this.zzbDJ = str;
            return this;
        }

        public OrganizationsImpl zzhl(String str) {
            this.zzbDK = str;
            return this;
        }

        public OrganizationsImpl zzhm(String str) {
            this.zzaEg = str;
            return this;
        }

        public OrganizationsImpl zzhn(String str) {
            this.zzKj = str;
            return this;
        }

        public OrganizationsImpl zzo(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class PersonMetadataImpl implements SafeParcelable, PersonMetadata {
        public static final zzbe CREATOR = new zzbe();
        final int mVersionCode;
        String zzaMS;
        List<String> zzbAk;
        final Set<Integer> zzbCc;
        ProfileOwnerStatsImpl zzbDV;
        List<String> zzbDe;
        boolean zzbDf;
        List<String> zzbDg;
        boolean zzbDh;
        List<String> zzbDi;
        boolean zzbDj;
        List<String> zzbDk;
        String zzbDm;
        List<String> zzbDn;
        String zzbDp;
        List<String> zzblg;

        public PersonMetadataImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        PersonMetadataImpl(Set<Integer> indicatorSet, int versionCode, List<String> attributions, List<String> blockTypes, List<String> circles, List<String> contacts, List<String> groups, List<String> incomingBlockTypes, String objectType, String ownerId, List<String> ownerUserTypes, String plusPageType, ProfileOwnerStatsImpl profileOwnerStats, boolean blocked, boolean deleted, boolean inViewerDomain) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzblg = attributions;
            this.zzbDe = blockTypes;
            this.zzbAk = circles;
            this.zzbDg = contacts;
            this.zzbDi = groups;
            this.zzbDk = incomingBlockTypes;
            this.zzaMS = objectType;
            this.zzbDm = ownerId;
            this.zzbDn = ownerUserTypes;
            this.zzbDp = plusPageType;
            this.zzbDV = profileOwnerStats;
            this.zzbDf = blocked;
            this.zzbDh = deleted;
            this.zzbDj = inViewerDomain;
        }

        private List<String> zzJb() {
            if (this.zzblg == null) {
                this.zzblg = new ArrayList();
            }
            return this.zzblg;
        }

        private List<String> zzJc() {
            if (this.zzbDe == null) {
                this.zzbDe = new ArrayList();
            }
            return this.zzbDe;
        }

        private List<String> zzJd() {
            if (this.zzbAk == null) {
                this.zzbAk = new ArrayList();
            }
            return this.zzbAk;
        }

        private List<String> zzJe() {
            if (this.zzbDg == null) {
                this.zzbDg = new ArrayList();
            }
            return this.zzbDg;
        }

        private List<String> zzJf() {
            if (this.zzbDi == null) {
                this.zzbDi = new ArrayList();
            }
            return this.zzbDi;
        }

        private List<String> zzJg() {
            if (this.zzbDk == null) {
                this.zzbDk = new ArrayList();
            }
            return this.zzbDk;
        }

        private List<String> zzJh() {
            if (this.zzbDn == null) {
                this.zzbDn = new ArrayList();
            }
            return this.zzbDn;
        }

        public int describeContents() {
            return 0;
        }

        public /* synthetic */ ProfileOwnerStats getProfileOwnerStats() {
            return zzJi();
        }

        public void writeToParcel(Parcel out, int flags) {
            zzbe.zza(this, out, flags);
        }

        public PersonMetadataImpl zzA(Collection<String> collection) {
            zzJg().addAll(collection);
            return this;
        }

        public PersonMetadataImpl zzB(Collection<String> collection) {
            zzJh().addAll(collection);
            return this;
        }

        public ProfileOwnerStatsImpl zzJi() {
            return this.zzbDV;
        }

        public PersonMetadataImpl zza(ProfileOwnerStatsImpl profileOwnerStatsImpl) {
            this.zzbDV = profileOwnerStatsImpl;
            return this;
        }

        public PersonMetadataImpl zzaO(boolean z) {
            this.zzbCc.add(Integer.valueOf(13));
            this.zzbDf = z;
            return this;
        }

        public PersonMetadataImpl zzaP(boolean z) {
            this.zzbCc.add(Integer.valueOf(14));
            this.zzbDh = z;
            return this;
        }

        public PersonMetadataImpl zzaQ(boolean z) {
            this.zzbCc.add(Integer.valueOf(15));
            this.zzbDj = z;
            return this;
        }

        public PersonMetadataImpl zzho(String str) {
            zzJd().add(str);
            return this;
        }

        public PersonMetadataImpl zzhp(String str) {
            this.zzaMS = str;
            return this;
        }

        public PersonMetadataImpl zzhq(String str) {
            this.zzbDm = str;
            return this;
        }

        public PersonMetadataImpl zzhr(String str) {
            this.zzbDp = str;
            return this;
        }

        public PersonMetadataImpl zzv(Collection<String> collection) {
            zzJb().addAll(collection);
            return this;
        }

        public PersonMetadataImpl zzw(Collection<String> collection) {
            zzJc().addAll(collection);
            return this;
        }

        public PersonMetadataImpl zzx(Collection<String> collection) {
            zzJd().addAll(collection);
            return this;
        }

        public PersonMetadataImpl zzy(Collection<String> collection) {
            zzJe().addAll(collection);
            return this;
        }

        public PersonMetadataImpl zzz(Collection<String> collection) {
            zzJf().addAll(collection);
            return this;
        }
    }

    public static class PhoneNumbersImpl implements SafeParcelable, PhoneNumbers {
        public static final zzbh CREATOR = new zzbh();
        String mValue;
        final int mVersionCode;
        String zzKj;
        int zzbAq;
        String zzbCR;
        final Set<Integer> zzbCc;
        String zzbDL;
        MetadataImpl zzbDR;

        public PhoneNumbersImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        PhoneNumbersImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String canonicalizedForm, String formattedType, String type, String value, int timesUsed) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzbDL = canonicalizedForm;
            this.zzbCR = formattedType;
            this.zzKj = type;
            this.mValue = value;
            this.zzbAq = timesUsed;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzbh.zza(this, out, flags);
        }

        public PhoneNumbersImpl zzhs(String str) {
            this.zzbDL = str;
            return this;
        }

        public PhoneNumbersImpl zzht(String str) {
            this.zzbCR = str;
            return this;
        }

        public PhoneNumbersImpl zzhu(String str) {
            this.zzKj = str;
            return this;
        }

        public PhoneNumbersImpl zzhv(String str) {
            this.mValue = str;
            return this;
        }

        public PhoneNumbersImpl zzng(int i) {
            this.zzbCc.add(Integer.valueOf(7));
            this.zzbAq = i;
            return this;
        }

        public PhoneNumbersImpl zzp(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class PlacesLivedImpl implements SafeParcelable, PlacesLived {
        public static final zzbi CREATOR = new zzbi();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzbCc;
        boolean zzbDD;
        MetadataImpl zzbDR;

        public PlacesLivedImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        PlacesLivedImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, boolean current, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzbDD = current;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzbi.zza(this, out, flags);
        }

        public PlacesLivedImpl zzaR(boolean z) {
            this.zzbCc.add(Integer.valueOf(3));
            this.zzbDD = z;
            return this;
        }

        public PlacesLivedImpl zzhw(String str) {
            this.mValue = str;
            return this;
        }

        public PlacesLivedImpl zzq(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class ProfileOwnerStatsImpl implements SafeParcelable, ProfileOwnerStats {
        public static final zzbj CREATOR = new zzbj();
        final int mVersionCode;
        final Set<Integer> zzbCc;
        long zzbDr;
        long zzbDs;

        public ProfileOwnerStatsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        ProfileOwnerStatsImpl(Set<Integer> indicatorSet, int versionCode, long incomingAnyCircleCount, long viewCount) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDr = incomingAnyCircleCount;
            this.zzbDs = viewCount;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzbj.zza(this, out, flags);
        }

        public ProfileOwnerStatsImpl zzaE(long j) {
            this.zzbCc.add(Integer.valueOf(2));
            this.zzbDr = j;
            return this;
        }

        public ProfileOwnerStatsImpl zzaF(long j) {
            this.zzbCc.add(Integer.valueOf(3));
            this.zzbDs = j;
            return this;
        }
    }

    public static class RelationsImpl implements SafeParcelable, Relations {
        public static final zzbk CREATOR = new zzbk();
        String mValue;
        final int mVersionCode;
        String zzKj;
        String zzbCR;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public RelationsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        RelationsImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String formattedType, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzbCR = formattedType;
            this.zzKj = type;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzbk.zza(this, out, flags);
        }

        public RelationsImpl zzhx(String str) {
            this.zzbCR = str;
            return this;
        }

        public RelationsImpl zzhy(String str) {
            this.zzKj = str;
            return this;
        }

        public RelationsImpl zzhz(String str) {
            this.mValue = str;
            return this;
        }

        public RelationsImpl zzr(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class RelationshipInterestsImpl implements SafeParcelable, RelationshipInterests {
        public static final zzbl CREATOR = new zzbl();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public RelationshipInterestsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        RelationshipInterestsImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzbl.zza(this, out, flags);
        }

        public RelationshipInterestsImpl zzhA(String str) {
            this.mValue = str;
            return this;
        }

        public RelationshipInterestsImpl zzs(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class RelationshipStatusesImpl implements SafeParcelable, RelationshipStatuses {
        public static final zzbm CREATOR = new zzbm();
        String mValue;
        final int mVersionCode;
        String zzaWt;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public RelationshipStatusesImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        RelationshipStatusesImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String formattedValue, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzaWt = formattedValue;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzbm.zza(this, out, flags);
        }

        public RelationshipStatusesImpl zzhB(String str) {
            this.zzaWt = str;
            return this;
        }

        public RelationshipStatusesImpl zzhC(String str) {
            this.mValue = str;
            return this;
        }

        public RelationshipStatusesImpl zzt(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class SkillsImpl implements SafeParcelable, Skills {
        public static final zzbn CREATOR = new zzbn();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public SkillsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        SkillsImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzbn.zza(this, out, flags);
        }

        public SkillsImpl zzhD(String str) {
            this.mValue = str;
            return this;
        }

        public SkillsImpl zzu(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class SortKeysImpl implements SafeParcelable, SortKeys {
        public static final zzbo CREATOR = new zzbo();
        String mName;
        final int mVersionCode;
        final Set<Integer> zzbCc;
        String zzbDM;

        public SortKeysImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        SortKeysImpl(Set<Integer> indicatorSet, int versionCode, String interactionRank, String name) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDM = interactionRank;
            this.mName = name;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzbo.zza(this, out, flags);
        }

        public SortKeysImpl zzhE(String str) {
            this.zzbDM = str;
            return this;
        }

        public SortKeysImpl zzhF(String str) {
            this.mName = str;
            return this;
        }
    }

    public static class TaglinesImpl implements SafeParcelable, Taglines {
        public static final zzbp CREATOR = new zzbp();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public TaglinesImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        TaglinesImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzbp.zza(this, out, flags);
        }

        public TaglinesImpl zzhG(String str) {
            this.mValue = str;
            return this;
        }

        public TaglinesImpl zzv(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public static class UrlsImpl implements SafeParcelable, Urls {
        public static final zzbq CREATOR = new zzbq();
        String mValue;
        final int mVersionCode;
        String zzKj;
        String zzbCR;
        final Set<Integer> zzbCc;
        MetadataImpl zzbDR;

        public UrlsImpl() {
            this.zzbCc = new HashSet();
            this.mVersionCode = 1;
        }

        UrlsImpl(Set<Integer> indicatorSet, int versionCode, MetadataImpl metadata, String formattedType, String type, String value) {
            this.zzbCc = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbDR = metadata;
            this.zzbCR = formattedType;
            this.zzKj = type;
            this.mValue = value;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzbq.zza(this, out, flags);
        }

        public UrlsImpl zzhH(String str) {
            this.zzbCR = str;
            return this;
        }

        public UrlsImpl zzhI(String str) {
            this.zzKj = str;
            return this;
        }

        public UrlsImpl zzhJ(String str) {
            this.mValue = str;
            return this;
        }

        public UrlsImpl zzw(MetadataImpl metadataImpl) {
            this.zzbDR = metadataImpl;
            return this;
        }
    }

    public PersonImpl() {
        this.zzbCc = new HashSet();
        this.mVersionCode = 1;
    }

    PersonImpl(Set<Integer> indicatorSet, int versionCode, List<AboutsImpl> abouts, List<AddressesImpl> addresses, String ageRange, List<BirthdaysImpl> birthdays, List<BraggingRightsImpl> braggingRights, List<CoverPhotosImpl> coverPhotos, List<CustomFieldsImpl> customFields, List<EmailsImpl> emails, String etag, List<EventsImpl> events, List<GendersImpl> genders, String id, List<ImagesImpl> images, List<InstantMessagingImpl> instantMessaging, String language, LegacyFieldsImpl legacyFields, List<PersonImpl> linkedPeople, List<MembershipsImpl> memberships, PersonMetadataImpl metadata, List<NamesImpl> names, List<NicknamesImpl> nicknames, List<OccupationsImpl> occupations, List<OrganizationsImpl> organizations, List<PhoneNumbersImpl> phoneNumbers, List<PlacesLivedImpl> placesLived, String profileUrl, List<RelationsImpl> relations, List<RelationshipInterestsImpl> relationshipInterests, List<RelationshipStatusesImpl> relationshipStatuses, List<SkillsImpl> skills, SortKeysImpl sortKeys, List<TaglinesImpl> taglines, List<UrlsImpl> urls, List<NotesImpl> notes) {
        this.zzbCc = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzbCm = abouts;
        this.zzbAh = addresses;
        this.zzbCn = ageRange;
        this.zzbCo = birthdays;
        this.zzbCp = braggingRights;
        this.zzbCq = coverPhotos;
        this.zzbCr = customFields;
        this.zzbAi = emails;
        this.zzbCs = etag;
        this.zzql = events;
        this.zzbCt = genders;
        this.zzyU = id;
        this.zzyw = images;
        this.zzbCu = instantMessaging;
        this.zzajR = language;
        this.zzbDN = legacyFields;
        this.zzbCw = linkedPeople;
        this.zzbCx = memberships;
        this.zzbDO = metadata;
        this.zzbCz = names;
        this.zzbCA = nicknames;
        this.zzbCB = occupations;
        this.zzbCC = organizations;
        this.zzbCD = phoneNumbers;
        this.zzbCE = placesLived;
        this.zzbCF = profileUrl;
        this.zzbCG = relations;
        this.zzbCH = relationshipInterests;
        this.zzbCI = relationshipStatuses;
        this.zzbCJ = skills;
        this.zzbDP = sortKeys;
        this.zzbCL = taglines;
        this.zzbCM = urls;
        this.zzbDQ = notes;
    }

    private List<BraggingRightsImpl> zzIA() {
        if (this.zzbCp == null) {
            this.zzbCp = new ArrayList();
        }
        return this.zzbCp;
    }

    private List<CoverPhotosImpl> zzIB() {
        if (this.zzbCq == null) {
            this.zzbCq = new ArrayList();
        }
        return this.zzbCq;
    }

    private List<CustomFieldsImpl> zzIC() {
        if (this.zzbCr == null) {
            this.zzbCr = new ArrayList();
        }
        return this.zzbCr;
    }

    private List<EmailsImpl> zzID() {
        if (this.zzbAi == null) {
            this.zzbAi = new ArrayList();
        }
        return this.zzbAi;
    }

    private List<EventsImpl> zzIE() {
        if (this.zzql == null) {
            this.zzql = new ArrayList();
        }
        return this.zzql;
    }

    private List<GendersImpl> zzIF() {
        if (this.zzbCt == null) {
            this.zzbCt = new ArrayList();
        }
        return this.zzbCt;
    }

    private List<ImagesImpl> zzIG() {
        if (this.zzyw == null) {
            this.zzyw = new ArrayList();
        }
        return this.zzyw;
    }

    private List<InstantMessagingImpl> zzIH() {
        if (this.zzbCu == null) {
            this.zzbCu = new ArrayList();
        }
        return this.zzbCu;
    }

    private List<PersonImpl> zzIJ() {
        if (this.zzbCw == null) {
            this.zzbCw = new ArrayList();
        }
        return this.zzbCw;
    }

    private List<MembershipsImpl> zzIK() {
        if (this.zzbCx == null) {
            this.zzbCx = new ArrayList();
        }
        return this.zzbCx;
    }

    private List<NamesImpl> zzIM() {
        if (this.zzbCz == null) {
            this.zzbCz = new ArrayList();
        }
        return this.zzbCz;
    }

    private List<NicknamesImpl> zzIN() {
        if (this.zzbCA == null) {
            this.zzbCA = new ArrayList();
        }
        return this.zzbCA;
    }

    private List<OccupationsImpl> zzIO() {
        if (this.zzbCB == null) {
            this.zzbCB = new ArrayList();
        }
        return this.zzbCB;
    }

    private List<OrganizationsImpl> zzIP() {
        if (this.zzbCC == null) {
            this.zzbCC = new ArrayList();
        }
        return this.zzbCC;
    }

    private List<PhoneNumbersImpl> zzIQ() {
        if (this.zzbCD == null) {
            this.zzbCD = new ArrayList();
        }
        return this.zzbCD;
    }

    private List<PlacesLivedImpl> zzIR() {
        if (this.zzbCE == null) {
            this.zzbCE = new ArrayList();
        }
        return this.zzbCE;
    }

    private List<RelationsImpl> zzIS() {
        if (this.zzbCG == null) {
            this.zzbCG = new ArrayList();
        }
        return this.zzbCG;
    }

    private List<RelationshipInterestsImpl> zzIT() {
        if (this.zzbCH == null) {
            this.zzbCH = new ArrayList();
        }
        return this.zzbCH;
    }

    private List<RelationshipStatusesImpl> zzIU() {
        if (this.zzbCI == null) {
            this.zzbCI = new ArrayList();
        }
        return this.zzbCI;
    }

    private List<SkillsImpl> zzIV() {
        if (this.zzbCJ == null) {
            this.zzbCJ = new ArrayList();
        }
        return this.zzbCJ;
    }

    private List<TaglinesImpl> zzIX() {
        if (this.zzbCL == null) {
            this.zzbCL = new ArrayList();
        }
        return this.zzbCL;
    }

    private List<UrlsImpl> zzIY() {
        if (this.zzbCM == null) {
            this.zzbCM = new ArrayList();
        }
        return this.zzbCM;
    }

    private List<NotesImpl> zzIZ() {
        if (this.zzbDQ == null) {
            this.zzbDQ = new ArrayList();
        }
        return this.zzbDQ;
    }

    private List<AboutsImpl> zzIx() {
        if (this.zzbCm == null) {
            this.zzbCm = new ArrayList();
        }
        return this.zzbCm;
    }

    private List<AddressesImpl> zzIy() {
        if (this.zzbAh == null) {
            this.zzbAh = new ArrayList();
        }
        return this.zzbAh;
    }

    private List<BirthdaysImpl> zzIz() {
        if (this.zzbCo == null) {
            this.zzbCo = new ArrayList();
        }
        return this.zzbCo;
    }

    public int describeContents() {
        return 0;
    }

    public List<AboutsImpl> getAbouts() {
        return this.zzbCm;
    }

    public List<AddressesImpl> getAddresses() {
        return this.zzbAh;
    }

    public List<BirthdaysImpl> getBirthdays() {
        return this.zzbCo;
    }

    public List<BraggingRightsImpl> getBraggingRights() {
        return this.zzbCp;
    }

    public List<CoverPhotosImpl> getCoverPhotos() {
        return this.zzbCq;
    }

    public List<CustomFieldsImpl> getCustomFields() {
        return this.zzbCr;
    }

    public List<EmailsImpl> getEmails() {
        return this.zzbAi;
    }

    public List<EventsImpl> getEvents() {
        return this.zzql;
    }

    public List<GendersImpl> getGenders() {
        return this.zzbCt;
    }

    public List<ImagesImpl> getImages() {
        return this.zzyw;
    }

    public List<InstantMessagingImpl> getInstantMessaging() {
        return this.zzbCu;
    }

    public /* synthetic */ LegacyFields getLegacyFields() {
        return zzII();
    }

    public List<PersonImpl> getLinkedPeople() {
        return this.zzbCw;
    }

    public List<MembershipsImpl> getMemberships() {
        return this.zzbCx;
    }

    public /* synthetic */ PersonMetadata getMetadata() {
        return zzIL();
    }

    public List<NamesImpl> getNames() {
        return this.zzbCz;
    }

    public List<NicknamesImpl> getNicknames() {
        return this.zzbCA;
    }

    public List<NotesImpl> getNotes() {
        return this.zzbDQ;
    }

    public List<OccupationsImpl> getOccupations() {
        return this.zzbCB;
    }

    public List<OrganizationsImpl> getOrganizations() {
        return this.zzbCC;
    }

    public List<PhoneNumbersImpl> getPhoneNumbers() {
        return this.zzbCD;
    }

    public List<PlacesLivedImpl> getPlacesLived() {
        return this.zzbCE;
    }

    public List<RelationsImpl> getRelations() {
        return this.zzbCG;
    }

    public List<RelationshipInterestsImpl> getRelationshipInterests() {
        return this.zzbCH;
    }

    public List<RelationshipStatusesImpl> getRelationshipStatuses() {
        return this.zzbCI;
    }

    public List<SkillsImpl> getSkills() {
        return this.zzbCJ;
    }

    public /* synthetic */ SortKeys getSortKeys() {
        return zzIW();
    }

    public List<TaglinesImpl> getTaglines() {
        return this.zzbCL;
    }

    public List<UrlsImpl> getUrls() {
        return this.zzbCM;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzbd.zza(this, out, flags);
    }

    public boolean zzGR() {
        return this.zzbDO != null;
    }

    public LegacyFieldsImpl zzII() {
        return this.zzbDN;
    }

    public PersonMetadataImpl zzIL() {
        return this.zzbDO;
    }

    public SortKeysImpl zzIW() {
        return this.zzbDP;
    }

    public PersonImpl zza(AboutsImpl aboutsImpl) {
        zzIx().add(aboutsImpl);
        return this;
    }

    public PersonImpl zza(AddressesImpl addressesImpl) {
        zzIy().add(addressesImpl);
        return this;
    }

    public PersonImpl zza(BirthdaysImpl birthdaysImpl) {
        zzIz().add(birthdaysImpl);
        return this;
    }

    public PersonImpl zza(BraggingRightsImpl braggingRightsImpl) {
        zzIA().add(braggingRightsImpl);
        return this;
    }

    public PersonImpl zza(CoverPhotosImpl coverPhotosImpl) {
        zzIB().add(coverPhotosImpl);
        return this;
    }

    public PersonImpl zza(CustomFieldsImpl customFieldsImpl) {
        zzIC().add(customFieldsImpl);
        return this;
    }

    public PersonImpl zza(EmailsImpl emailsImpl) {
        zzID().add(emailsImpl);
        return this;
    }

    public PersonImpl zza(EventsImpl eventsImpl) {
        zzIE().add(eventsImpl);
        return this;
    }

    public PersonImpl zza(GendersImpl gendersImpl) {
        zzIF().add(gendersImpl);
        return this;
    }

    public PersonImpl zza(ImagesImpl imagesImpl) {
        zzIG().add(imagesImpl);
        return this;
    }

    public PersonImpl zza(InstantMessagingImpl instantMessagingImpl) {
        zzIH().add(instantMessagingImpl);
        return this;
    }

    public PersonImpl zza(LegacyFieldsImpl legacyFieldsImpl) {
        this.zzbDN = legacyFieldsImpl;
        return this;
    }

    public PersonImpl zza(MembershipsImpl membershipsImpl) {
        zzIK().add(membershipsImpl);
        return this;
    }

    public PersonImpl zza(NamesImpl namesImpl) {
        zzIM().add(namesImpl);
        return this;
    }

    public PersonImpl zza(NicknamesImpl nicknamesImpl) {
        zzIN().add(nicknamesImpl);
        return this;
    }

    public PersonImpl zza(NotesImpl notesImpl) {
        zzIZ().add(notesImpl);
        return this;
    }

    public PersonImpl zza(OccupationsImpl occupationsImpl) {
        zzIO().add(occupationsImpl);
        return this;
    }

    public PersonImpl zza(OrganizationsImpl organizationsImpl) {
        zzIP().add(organizationsImpl);
        return this;
    }

    public PersonImpl zza(PersonMetadataImpl personMetadataImpl) {
        this.zzbDO = personMetadataImpl;
        return this;
    }

    public PersonImpl zza(PhoneNumbersImpl phoneNumbersImpl) {
        zzIQ().add(phoneNumbersImpl);
        return this;
    }

    public PersonImpl zza(PlacesLivedImpl placesLivedImpl) {
        zzIR().add(placesLivedImpl);
        return this;
    }

    public PersonImpl zza(RelationsImpl relationsImpl) {
        zzIS().add(relationsImpl);
        return this;
    }

    public PersonImpl zza(RelationshipInterestsImpl relationshipInterestsImpl) {
        zzIT().add(relationshipInterestsImpl);
        return this;
    }

    public PersonImpl zza(RelationshipStatusesImpl relationshipStatusesImpl) {
        zzIU().add(relationshipStatusesImpl);
        return this;
    }

    public PersonImpl zza(SkillsImpl skillsImpl) {
        zzIV().add(skillsImpl);
        return this;
    }

    public PersonImpl zza(SortKeysImpl sortKeysImpl) {
        this.zzbDP = sortKeysImpl;
        return this;
    }

    public PersonImpl zza(TaglinesImpl taglinesImpl) {
        zzIX().add(taglinesImpl);
        return this;
    }

    public PersonImpl zza(UrlsImpl urlsImpl) {
        zzIY().add(urlsImpl);
        return this;
    }

    public PersonImpl zza(PersonImpl personImpl) {
        zzIJ().add(personImpl);
        return this;
    }

    public PersonImpl zzfX(String str) {
        this.zzbCn = str;
        return this;
    }

    public PersonImpl zzfY(String str) {
        this.zzbCs = str;
        return this;
    }

    public PersonImpl zzfZ(String str) {
        this.zzyU = str;
        return this;
    }

    public PersonImpl zzga(String str) {
        this.zzajR = str;
        return this;
    }

    public PersonImpl zzgb(String str) {
        this.zzbCF = str;
        return this;
    }
}

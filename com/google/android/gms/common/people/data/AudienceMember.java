package com.google.android.gms.common.people.data;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.people.internal.zzp;

public final class AudienceMember implements SafeParcelable {
    public static final String AUDIENCE_GROUP_DOMAIN = "domain";
    public static final String AUDIENCE_GROUP_EXTENDED = "extendedCircles";
    public static final String AUDIENCE_GROUP_PUBLIC = "public";
    public static final String AUDIENCE_GROUP_YOUR_CIRCLES = "myCircles";
    public static final AudienceMemberCreator CREATOR = new AudienceMemberCreator();
    public static final int TYPE_CIRCLE = 1;
    public static final int TYPE_PERSON = 2;
    private final int mVersionCode;
    private final int zzUO;
    private final String zzVA;
    @Deprecated
    private final Bundle zzatO;
    private final int zzaxq;
    private final String zzaxr;
    private final String zzaxs;
    private final String zzaxt;

    AudienceMember(int versionCode, int type, int circleType, String circleId, String peopleQualifiedId, String displayName, String avatarUrl, Bundle metadata) {
        this.mVersionCode = versionCode;
        this.zzUO = type;
        this.zzaxq = circleType;
        this.zzaxr = circleId;
        this.zzaxs = peopleQualifiedId;
        this.zzVA = displayName;
        this.zzaxt = avatarUrl;
        if (metadata == null) {
            metadata = new Bundle();
        }
        this.zzatO = metadata;
    }

    private AudienceMember(int type, int circleType, String circleId, String qualifiedPersonId, String displayName, String avatarUrl) {
        this(1, type, circleType, circleId, qualifiedPersonId, displayName, avatarUrl, null);
    }

    public static AudienceMember forCircle(String circleId, String displayName) {
        return new AudienceMember(1, -1, circleId, null, displayName, null);
    }

    public static AudienceMember forGroup(String groupName, String displayName) {
        Integer num = (Integer) zzp.zzbEM.get(groupName);
        return new AudienceMember(1, (num == null ? (Integer) zzp.zzbEM.get(null) : num).intValue(), groupName, null, displayName, null);
    }

    public static AudienceMember forPersonWithEmail(String email, String displayName) {
        return forPersonWithPeopleQualifiedId(zzp.zzhS(email), displayName, null);
    }

    public static AudienceMember forPersonWithGaiaId(String gaiaId, String displayName, String avatarUrl) {
        zzx.zzi(gaiaId, "Person ID must not be empty.");
        return forPersonWithPeopleQualifiedId(zzp.zzhQ(gaiaId), displayName, avatarUrl);
    }

    public static AudienceMember forPersonWithPeopleQualifiedId(String peopleQualifiedId, String displayName, String avatarUrl) {
        return new AudienceMember(2, 0, null, peopleQualifiedId, displayName, avatarUrl);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudienceMember)) {
            return false;
        }
        AudienceMember audienceMember = (AudienceMember) obj;
        return this.mVersionCode == audienceMember.mVersionCode && this.zzUO == audienceMember.zzUO && this.zzaxq == audienceMember.zzaxq && zzw.equal(this.zzaxr, audienceMember.zzaxr) && zzw.equal(this.zzaxs, audienceMember.zzaxs);
    }

    public String getAvatarUrl() {
        return this.zzaxt;
    }

    public String getCircleId() {
        return this.zzaxr;
    }

    public int getCircleType() {
        return this.zzaxq;
    }

    public String getDisplayName() {
        return this.zzVA;
    }

    public String getPeopleQualifiedId() {
        return this.zzaxs;
    }

    public int getType() {
        return this.zzUO;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), Integer.valueOf(this.zzUO), Integer.valueOf(this.zzaxq), this.zzaxr, this.zzaxs);
    }

    public boolean isPerson() {
        return this.zzUO == 2;
    }

    public boolean isPersonalCircle() {
        return this.zzUO == 1 && this.zzaxq == -1;
    }

    public boolean isPublicSystemGroup() {
        return this.zzUO == 1 && this.zzaxq == 1;
    }

    public boolean isSystemGroup() {
        return this.zzUO == 1 && this.zzaxq != -1;
    }

    public String toString() {
        if (isPerson()) {
            return String.format("Person [%s] %s", new Object[]{getPeopleQualifiedId(), getDisplayName()});
        } else if (isPersonalCircle()) {
            return String.format("Circle [%s] %s", new Object[]{getCircleId(), getDisplayName()});
        } else {
            return String.format("Group [%s] %s", new Object[]{getCircleId(), getDisplayName()});
        }
    }

    public void writeToParcel(Parcel out, int flags) {
        AudienceMemberCreator.zza(this, out, flags);
    }

    @Deprecated
    public Bundle zzqt() {
        return this.zzatO;
    }
}

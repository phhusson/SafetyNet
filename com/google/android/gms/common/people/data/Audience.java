package com.google.android.gms.common.people.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Audience implements SafeParcelable {
    public static final AudienceCreator CREATOR = new AudienceCreator();
    public static final int DOMAIN_RESTRICTED_NOT_SET = 0;
    public static final int DOMAIN_RESTRICTED_RESTRICTED = 1;
    public static final int DOMAIN_RESTRICTED_UNRESTRICTED = 2;
    private final int mVersionCode;
    private final List<AudienceMember> zzaxm;
    private final int zzaxn;
    @Deprecated
    private final boolean zzaxo;
    private final boolean zzaxp;

    Audience(int versionCode, List<AudienceMember> audienceMembers, int domainRestricted, boolean fullyUnderstood, boolean readOnly) {
        boolean z = true;
        if (versionCode == 1 && audienceMembers == null) {
            audienceMembers = Collections.emptyList();
        }
        this.mVersionCode = versionCode;
        this.zzaxm = domainRestricted == 1 ? zzy(audienceMembers) : Collections.unmodifiableList(audienceMembers);
        this.zzaxn = domainRestricted;
        if (versionCode == 1) {
            this.zzaxo = fullyUnderstood;
            this.zzaxp = !fullyUnderstood;
            return;
        }
        this.zzaxp = readOnly;
        if (readOnly) {
            z = false;
        }
        this.zzaxo = z;
    }

    Audience(List<AudienceMember> audienceMembers, int domainRestricted, boolean readOnly) {
        boolean z = true;
        this.mVersionCode = 2;
        if (domainRestricted == 1) {
            audienceMembers = zzy(audienceMembers);
        }
        this.zzaxm = audienceMembers;
        this.zzaxn = domainRestricted;
        this.zzaxp = readOnly;
        if (readOnly) {
            z = false;
        }
        this.zzaxo = z;
    }

    private static List<AudienceMember> zzy(List<AudienceMember> list) {
        List arrayList = new ArrayList();
        for (AudienceMember audienceMember : list) {
            if (!audienceMember.isPublicSystemGroup()) {
                arrayList.add(audienceMember);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Audience)) {
            return false;
        }
        Audience audience = (Audience) obj;
        return this.mVersionCode == audience.mVersionCode && zzw.equal(this.zzaxm, audience.zzaxm) && this.zzaxn == audience.zzaxn && this.zzaxp == audience.zzaxp;
    }

    public List<AudienceMember> getAudienceMemberList() {
        return this.zzaxm;
    }

    public int getDomainRestricted() {
        return this.zzaxn;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzaxm, Integer.valueOf(this.zzaxn), Boolean.valueOf(this.zzaxp));
    }

    public boolean isReadOnly() {
        return this.zzaxp;
    }

    public void writeToParcel(Parcel out, int flags) {
        AudienceCreator.zza(this, out, flags);
    }

    @Deprecated
    boolean zzrA() {
        return this.zzaxo;
    }
}

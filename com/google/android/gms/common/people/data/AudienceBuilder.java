package com.google.android.gms.common.people.data;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class AudienceBuilder {
    public static final Audience EMPTY_AUDIENCE = new AudienceBuilder().build();
    private List<AudienceMember> zzaxm;
    private int zzaxn;
    private boolean zzaxp;

    public AudienceBuilder() {
        this.zzaxm = Collections.emptyList();
        this.zzaxn = 0;
        this.zzaxp = false;
    }

    public AudienceBuilder(Audience audience) {
        zzx.zzb((Object) audience, (Object) "Audience must not be null.");
        this.zzaxm = audience.getAudienceMemberList();
        this.zzaxn = audience.getDomainRestricted();
        this.zzaxp = audience.isReadOnly();
    }

    private int zzdt(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
                return i;
            default:
                throw new IllegalArgumentException("Unknown domain restriction setting: " + i);
        }
    }

    public Audience build() {
        return new Audience(this.zzaxm, this.zzaxn, this.zzaxp);
    }

    public AudienceBuilder setAudienceMembers(Collection<AudienceMember> audienceMembers) {
        this.zzaxm = Collections.unmodifiableList(new ArrayList((Collection) zzx.zzb((Object) audienceMembers, (Object) "Audience members must not be null.")));
        return this;
    }

    public AudienceBuilder setDomainRestricted(int domainRestricted) {
        this.zzaxn = zzdt(domainRestricted);
        return this;
    }

    public AudienceBuilder setReadOnly(boolean readOnly) {
        this.zzaxp = readOnly;
        return this;
    }
}

package com.google.android.gms.common.people.data;

import android.content.Intent;
import com.google.android.gms.common.audience.dialogs.AudienceSelectionIntentBuilder;
import com.google.android.gms.common.internal.zzx;
import java.util.Collection;
import java.util.LinkedHashSet;

public final class Audiences {
    private Audiences() {
    }

    public static Audience addMember(Audience audience, AudienceMember audienceMember) {
        zzx.zzb((Object) audience, (Object) "Audience must not be null.");
        zzx.zzb((Object) audienceMember, (Object) "Audience member must not be null.");
        Collection linkedHashSet = new LinkedHashSet(audience.getAudienceMemberList());
        linkedHashSet.add(audienceMember);
        return new AudienceBuilder(audience).setAudienceMembers(linkedHashSet).build();
    }

    public static Audience addMemberList(Audience audience, Collection<AudienceMember> newMembers) {
        Collection linkedHashSet = new LinkedHashSet(audience.getAudienceMemberList());
        linkedHashSet.addAll(newMembers);
        return new AudienceBuilder(audience).setAudienceMembers(linkedHashSet).build();
    }

    public static Audience fromAudienceSelectionIntent(Intent intent, Audience baseAudience) {
        if (baseAudience == null) {
            baseAudience = new AudienceBuilder().build();
        }
        return new AudienceBuilder(baseAudience).setAudienceMembers(AudienceSelectionIntentBuilder.getSelectedAudienceMembers(intent)).build();
    }

    public static boolean hasMember(Audience audience, AudienceMember audienceMember) {
        zzx.zzb((Object) audience, (Object) "Audience must not be null.");
        zzx.zzb((Object) audienceMember, (Object) "Audience member must not be null.");
        return audience.getAudienceMemberList().contains(audienceMember);
    }

    public static boolean isEmpty(Audience audience) {
        zzx.zzb((Object) audience, (Object) "Audience must not be null.");
        return !audience.isReadOnly() && audience.getAudienceMemberList().isEmpty();
    }

    public static Audience removeMember(Audience audience, AudienceMember audienceMember) {
        zzx.zzb((Object) audience, (Object) "Audience must not be null.");
        zzx.zzb((Object) audienceMember, (Object) "Audience member must not be null.");
        Collection linkedHashSet = new LinkedHashSet(audience.getAudienceMemberList());
        linkedHashSet.remove(audienceMember);
        return new AudienceBuilder(audience).setAudienceMembers(linkedHashSet).build();
    }
}

package com.google.android.gms.auth.firstparty.proximity.data;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Permit implements SafeParcelable {
    public static final String CHANNEL_BLUETOOTH_CLASSIC = "bluetooth_classic";
    public static final PermitCreator CREATOR = new PermitCreator();
    public static final String TYPE_UNLOCK = "unlock";
    final int mVersion;
    final String zzKj;
    final String zzabR;
    final PermitAccess zzabS;
    List<PermitAccess> zzabT;
    final Map<String, PermitAccess> zzabU;
    List<String> zzabV;
    final Set<String> zzabW;
    final String zzyU;

    public static class Builder {
        private String zzKj;
        private String zzabR;
        private PermitAccess zzabS;
        private Map<String, PermitAccess> zzabU = new HashMap();
        private Set<String> zzabW = new HashSet();
        private String zzyU;

        public Builder addAllowedChannel(String allowedChannel) {
            this.zzabW.add(allowedChannel);
            return this;
        }

        public Builder addRequesterAccess(PermitAccess requesterAccess) {
            this.zzabU.put(requesterAccess.getId(), requesterAccess);
            return this;
        }

        public Permit build() {
            return new Permit();
        }

        public Builder setAccountId(String accountId) {
            this.zzabR = accountId;
            return this;
        }

        public Builder setId(String id) {
            this.zzyU = id;
            return this;
        }

        public Builder setLicense(PermitAccess license) {
            this.zzabS = license;
            return this;
        }

        public Builder setType(String type) {
            this.zzKj = type;
            return this;
        }
    }

    Permit(int version, String id, String accountId, String type, PermitAccess license, List<PermitAccess> requesterAccessesCache, List<String> allowedChannelsCache) {
        this(version, id, accountId, type, license, zzv(requesterAccessesCache), new HashSet(allowedChannelsCache));
    }

    private Permit(int version, String id, String accountId, String type, PermitAccess license, Map<String, PermitAccess> requesterAccesses, Set<String> allowedChannels) {
        this.mVersion = version;
        this.zzyU = zzx.zzcL(id);
        this.zzabR = zzx.zzcL(accountId);
        this.zzKj = zzx.zzcL(type);
        this.zzabS = (PermitAccess) zzx.zzD(license);
        this.zzabU = requesterAccesses == null ? new HashMap() : new HashMap(requesterAccesses);
        this.zzabW = allowedChannels == null ? new HashSet() : new HashSet(allowedChannels);
    }

    private Permit(Builder builder) {
        this(1, builder.zzyU, builder.zzabR, builder.zzKj, builder.zzabS, builder.zzabU, builder.zzabW);
    }

    private static Map<String, PermitAccess> zzv(List<PermitAccess> list) {
        Map<String, PermitAccess> hashMap = new HashMap();
        for (PermitAccess permitAccess : list) {
            hashMap.put(permitAccess.getId(), permitAccess);
        }
        return hashMap;
    }

    public void addAllowedChannel(String allowedChannel) {
        this.zzabW.add(allowedChannel);
    }

    public void addRequesterAccess(PermitAccess requesterAccess) {
        this.zzabU.put(requesterAccess.getId(), requesterAccess);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Permit)) {
            return false;
        }
        Permit permit = (Permit) obj;
        return TextUtils.equals(this.zzabR, permit.zzabR) && TextUtils.equals(this.zzyU, permit.zzyU) && TextUtils.equals(this.zzKj, permit.zzKj) && this.zzabS.equals(permit.zzabS) && this.zzabW.equals(permit.zzabW) && this.zzabU.equals(permit.zzabU);
    }

    public String getAccountId() {
        return this.zzabR;
    }

    public List<String> getAllowedChannels() {
        return Collections.unmodifiableList(new ArrayList(this.zzabW));
    }

    public String getId() {
        return this.zzyU;
    }

    public PermitAccess getLicense() {
        return this.zzabS;
    }

    public PermitAccess getRequesterAccessById(String id) {
        return (PermitAccess) this.zzabU.get(id);
    }

    public List<PermitAccess> getRequesterAccesses() {
        return Collections.unmodifiableList(new ArrayList(this.zzabU.values()));
    }

    public List<PermitAccess> getRequesterAccesses(String type) {
        List arrayList = new ArrayList();
        for (PermitAccess permitAccess : this.zzabU.values()) {
            if (TextUtils.equals(type, permitAccess.getType())) {
                arrayList.add(permitAccess);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String getType() {
        return this.zzKj;
    }

    public boolean hasAllowedChannel(String allowedChannel) {
        return this.zzabW.contains(allowedChannel);
    }

    public int hashCode() {
        return (31 * (((((((((this.zzyU.hashCode() + 527) * 31) + this.zzabR.hashCode()) * 31) + this.zzKj.hashCode()) * 31) + this.zzabW.hashCode()) * 31) + this.zzabS.hashCode())) + this.zzabU.hashCode();
    }

    public void removeAllowedChannel(String allowedChannel) {
        this.zzabW.remove(allowedChannel);
    }

    public PermitAccess removeRequesterAccess(String id) {
        return (PermitAccess) this.zzabU.remove(id);
    }

    public void writeToParcel(Parcel dest, int flags) {
        this.zzabT = new ArrayList(this.zzabU.values());
        this.zzabV = new ArrayList(this.zzabW);
        PermitCreator.zza(this, dest, flags);
    }
}

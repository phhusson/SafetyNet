package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;

public class BooleanResult implements Result {
    private final Status zzVy;
    private final boolean zzaqp;

    public BooleanResult(Status status, boolean value) {
        this.zzVy = (Status) zzx.zzb((Object) status, (Object) "Status must not be null");
        this.zzaqp = value;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.zzVy.equals(booleanResult.zzVy) && this.zzaqp == booleanResult.zzaqp;
    }

    public Status getStatus() {
        return this.zzVy;
    }

    public boolean getValue() {
        return this.zzaqp;
    }

    public final int hashCode() {
        return (this.zzaqp ? 1 : 0) + ((this.zzVy.hashCode() + 527) * 31);
    }
}

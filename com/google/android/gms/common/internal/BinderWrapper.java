package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new C02161();
    private IBinder zzpC;

    static class C02161 implements Creator<BinderWrapper> {
        C02161() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzaW(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzdh(i);
        }

        public BinderWrapper zzaW(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        public BinderWrapper[] zzdh(int i) {
            return new BinderWrapper[i];
        }
    }

    public BinderWrapper() {
        this.zzpC = null;
    }

    public BinderWrapper(IBinder binder) {
        this.zzpC = null;
        this.zzpC = binder;
    }

    private BinderWrapper(Parcel in) {
        this.zzpC = null;
        this.zzpC = in.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(this.zzpC);
    }
}

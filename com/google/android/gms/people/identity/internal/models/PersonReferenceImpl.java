package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.ImageReference;
import com.google.android.gms.people.identity.models.PersonReference;
import java.util.HashSet;
import java.util.Set;

public class PersonReferenceImpl implements SafeParcelable, PersonReference {
    public static final zzbg CREATOR = new zzbg();
    String mName;
    final int mVersionCode;
    String zzatl;
    final Set<Integer> zzbCc;
    ImageReferenceImpl zzbDW;

    public PersonReferenceImpl() {
        this.zzbCc = new HashSet();
        this.mVersionCode = 1;
    }

    PersonReferenceImpl(Set<Integer> indicatorSet, int versionCode, String name, String qualifiedId, ImageReferenceImpl avatarReference) {
        this.zzbCc = indicatorSet;
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzatl = qualifiedId;
        this.zzbDW = avatarReference;
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ ImageReference getAvatarReference() {
        return zzJj();
    }

    public String getQualifiedId() {
        return this.zzatl;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzbg.zza(this, out, flags);
    }

    public ImageReferenceImpl zzJj() {
        return this.zzbDW;
    }

    public PersonReferenceImpl zzc(ImageReferenceImpl imageReferenceImpl) {
        this.zzbDW = imageReferenceImpl;
        return this;
    }

    public PersonReferenceImpl zzhK(String str) {
        this.mName = str;
        return this;
    }

    public PersonReferenceImpl zzhL(String str) {
        this.zzatl = str;
        return this;
    }
}

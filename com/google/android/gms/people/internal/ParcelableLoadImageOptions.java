package com.google.android.gms.people.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.people.Images.LoadImageOptions;

public class ParcelableLoadImageOptions implements SafeParcelable {
    public static final zzk CREATOR = new zzk();
    private final boolean mUseLargePictureForCp2Images;
    private final int mVersionCode;
    private final int zzbzI;
    private final int zzbzj;

    ParcelableLoadImageOptions(int versionCode, int imageSize, int avatarOptions, boolean useLargePictureForCp2Images) {
        this.mVersionCode = versionCode;
        this.zzbzj = imageSize;
        this.zzbzI = avatarOptions;
        this.mUseLargePictureForCp2Images = useLargePictureForCp2Images;
    }

    public static ParcelableLoadImageOptions zza(LoadImageOptions loadImageOptions) {
        if (loadImageOptions == null) {
            loadImageOptions = LoadImageOptions.DEFAULT;
        }
        return new ParcelableLoadImageOptions(1, loadImageOptions.imageSize, loadImageOptions.avatarOptions, loadImageOptions.useLargePictureForCp2Images);
    }

    public int describeContents() {
        return 0;
    }

    public int getImageSize() {
        return this.zzbzj;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzw.zzC(this).zzh("imageSize", Integer.valueOf(this.zzbzj)).zzh("avatarOptions", Integer.valueOf(this.zzbzI)).zzh("useLargePictureForCp2Images", Boolean.valueOf(this.mUseLargePictureForCp2Images)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzk.zza(this, out, flags);
    }

    public int zzJn() {
        return this.zzbzI;
    }

    public boolean zzJo() {
        return this.mUseLargePictureForCp2Images;
    }
}

package com.google.android.gms.people;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.people.People.ReleasableResult;
import com.google.android.gms.people.model.AvatarReference;

public interface Images {

    public interface SetAvatarResult extends Result {
        String getUrl();
    }

    public interface LoadImageResult extends ReleasableResult {
        int getHeight();

        ParcelFileDescriptor getParcelFileDescriptor();

        int getWidth();

        boolean isRewindable();
    }

    public static class LoadImageOptions {
        public static final LoadImageOptions DEFAULT = new Builder().build();
        public final int avatarOptions;
        public final int imageSize;
        public final boolean useLargePictureForCp2Images;

        public static class Builder {
            public boolean mUseLargePictureForCp2Images;
            private int zzbzI = 0;
            private int zzbzj = 1;

            public final LoadImageOptions build() {
                return new LoadImageOptions();
            }

            public Builder setAvatarOptions(int options) {
                this.zzbzI = options;
                return this;
            }

            public Builder setImageSize(int size) {
                this.zzbzj = size;
                return this;
            }

            public Builder setUseLargePictureForCp2Images(boolean useLargePicture) {
                this.mUseLargePictureForCp2Images = useLargePicture;
                return this;
            }
        }

        private LoadImageOptions(Builder b) {
            this.imageSize = b.zzbzj;
            this.avatarOptions = b.zzbzI;
            this.useLargePictureForCp2Images = b.mUseLargePictureForCp2Images;
        }
    }

    public interface OnAvatarSetCallback {
        void onAvatarSet(SetAvatarResult setAvatarResult);
    }

    PendingResult<LoadImageResult> loadByReference(GoogleApiClient googleApiClient, AvatarReference avatarReference, LoadImageOptions loadImageOptions);

    PendingResult<LoadImageResult> loadByUrl(GoogleApiClient googleApiClient, String str, int i, int i2);

    PendingResult<LoadImageResult> loadContactThumbnailByContactId(GoogleApiClient googleApiClient, long j);

    PendingResult<LoadImageResult> loadOwnerAvatar(GoogleApiClient googleApiClient, String str, String str2, int i, int i2);

    PendingResult<LoadImageResult> loadOwnerCoverPhoto(GoogleApiClient googleApiClient, String str, String str2);

    PendingResult<LoadImageResult> loadOwnerCoverPhoto(GoogleApiClient googleApiClient, String str, String str2, int i);

    PendingResult<LoadImageResult> loadRemoteImage(GoogleApiClient googleApiClient, String str);

    PendingResult<SetAvatarResult> setAvatar(GoogleApiClient googleApiClient, String str, String str2, Uri uri, boolean z);
}

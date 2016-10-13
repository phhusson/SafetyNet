package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.people.Images;
import com.google.android.gms.people.Images.LoadImageOptions;
import com.google.android.gms.people.Images.LoadImageResult;
import com.google.android.gms.people.Images.SetAvatarResult;
import com.google.android.gms.people.internal.zzl;
import com.google.android.gms.people.internal.zzn;
import com.google.android.gms.people.model.AvatarReference;

@SuppressLint({"MissingRemoteException"})
public class zztx implements Images {

    private static abstract class zza extends com.google.android.gms.people.People.zza<LoadImageResult> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzct(status);
        }

        public final LoadImageResult zzct(final Status status) {
            return new LoadImageResult(this) {
                final /* synthetic */ zza zzbHo;

                public int getHeight() {
                    return 0;
                }

                public ParcelFileDescriptor getParcelFileDescriptor() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public int getWidth() {
                    return 0;
                }

                public boolean isRewindable() {
                    return false;
                }

                public void release() {
                }
            };
        }
    }

    public PendingResult<LoadImageResult> loadByReference(GoogleApiClient googleApiClient, final AvatarReference ref, final LoadImageOptions options) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadByReference", ref, options);
        }
        return googleApiClient.zza(new zza(this, googleApiClient) {
            final /* synthetic */ zztx zzbHg;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) {
                zza(com_google_android_gms_people_internal_zzn.zza((zzb) this, ref, options));
            }
        });
    }

    public PendingResult<LoadImageResult> loadByUrl(GoogleApiClient googleApiClient, String url, int avatarSize, int options) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadByUrl", url, Integer.valueOf(avatarSize), Integer.valueOf(options));
        }
        final String str = url;
        final int i = avatarSize;
        final int i2 = options;
        return googleApiClient.zza(new zza(this, googleApiClient) {
            final /* synthetic */ zztx zzbHg;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) {
                zza(com_google_android_gms_people_internal_zzn.zza((zzb) this, str, i, i2));
            }
        });
    }

    public PendingResult<LoadImageResult> loadContactThumbnailByContactId(GoogleApiClient googleApiClient, final long contactId) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadContactThumbnailByContactId", Long.valueOf(contactId));
        }
        return googleApiClient.zza(new zza(this, googleApiClient) {
            final /* synthetic */ zztx zzbHg;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) {
                zza(com_google_android_gms_people_internal_zzn.zza((zzb) this, contactId));
            }
        });
    }

    public PendingResult<LoadImageResult> loadOwnerAvatar(GoogleApiClient googleApiClient, String account, String pageId, int avatarSize, int avatarOptions) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadOwnerAvatar", account, pageId, Integer.valueOf(avatarSize), Integer.valueOf(avatarOptions));
        }
        final String str = account;
        final String str2 = pageId;
        final int i = avatarSize;
        final int i2 = avatarOptions;
        return googleApiClient.zza(new zza(this, googleApiClient) {
            final /* synthetic */ zztx zzbHg;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) {
                zza(com_google_android_gms_people_internal_zzn.zzb((zzb) this, str, str2, i, i2));
            }
        });
    }

    public PendingResult<LoadImageResult> loadOwnerCoverPhoto(GoogleApiClient googleApiClient, final String account, final String pageId) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadOwnerCoverPhoto", account, pageId);
        }
        return googleApiClient.zza(new zza(this, googleApiClient) {
            final /* synthetic */ zztx zzbHg;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) {
                zza(com_google_android_gms_people_internal_zzn.zza((zzb) this, account, pageId, 0));
            }
        });
    }

    public PendingResult<LoadImageResult> loadOwnerCoverPhoto(GoogleApiClient googleApiClient, String account, String pageId, int minimumWidth) {
        return loadOwnerCoverPhoto(googleApiClient, account, pageId);
    }

    public PendingResult<LoadImageResult> loadRemoteImage(GoogleApiClient googleApiClient, final String url) {
        if (zzl.isEnabled()) {
            zzl.zzh("loadRemoteImage", url);
        }
        return googleApiClient.zza(new zza(this, googleApiClient) {
            final /* synthetic */ zztx zzbHg;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) {
                zza(com_google_android_gms_people_internal_zzn.zzr(this, url));
            }
        });
    }

    public PendingResult<SetAvatarResult> setAvatar(GoogleApiClient googleApiClient, String account, String pageId, Uri imageUri, boolean insertCameraImage) {
        if (zzl.isEnabled()) {
            zzl.zzh("setAvatar", account, pageId, imageUri, Boolean.valueOf(insertCameraImage));
        }
        final String str = account;
        final String str2 = pageId;
        final Uri uri = imageUri;
        final boolean z = insertCameraImage;
        return googleApiClient.zzb(new com.google.android.gms.people.People.zza<SetAvatarResult>(this, googleApiClient) {
            final /* synthetic */ zztx zzbHg;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) {
                com_google_android_gms_people_internal_zzn.zza((zzb) this, str, str2, uri, z);
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzcs(status);
            }

            protected SetAvatarResult zzcs(final Status status) {
                return new SetAvatarResult(this) {
                    final /* synthetic */ C05391 zzbHh;

                    public Status getStatus() {
                        return status;
                    }

                    public String getUrl() {
                        return null;
                    }
                };
            }
        });
    }
}

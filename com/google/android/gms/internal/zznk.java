package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.download.Download;
import com.google.android.gms.common.download.DownloadApi;

public class zznk implements DownloadApi {

    public static abstract class zza extends com.google.android.gms.common.api.internal.zza.zza<Status, zznl> {
        public zza(GoogleApiClient googleApiClient) {
            super(Download.zzVj, googleApiClient);
        }

        protected abstract void zza(Context context, zznm com_google_android_gms_internal_zznm) throws RemoteException;

        protected final void zza(zznl com_google_android_gms_internal_zznl) throws RemoteException {
            zza(com_google_android_gms_internal_zznl.getContext(), (zznm) com_google_android_gms_internal_zznl.zzrd());
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    public PendingResult<Status> getDownloadStatus(GoogleApiClient client, final String filename) {
        return client.zza(new zza(this, client) {
            final /* synthetic */ zznk zzauj;

            class C04961 extends zznj {
                final /* synthetic */ C04971 zzauk;

                C04961(C04971 c04971) {
                    this.zzauk = c04971;
                }

                public void zzJ(Status status) throws RemoteException {
                    this.zzauk.zza((Result) status);
                }
            }

            protected void zza(Context context, zznm com_google_android_gms_internal_zznm) throws RemoteException {
                com_google_android_gms_internal_zznm.zza(new C04961(this), filename);
            }
        });
    }

    public PendingResult<Status> registerDownloadStatusUpdates(GoogleApiClient client, final String filename) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zznk zzauj;

            class C05001 extends zznj {
                final /* synthetic */ C05013 zzaum;

                C05001(C05013 c05013) {
                    this.zzaum = c05013;
                }

                public void zzK(Status status) throws RemoteException {
                    this.zzaum.zza((Result) status);
                }
            }

            protected void zza(Context context, zznm com_google_android_gms_internal_zznm) throws RemoteException {
                com_google_android_gms_internal_zznm.zzc(new C05001(this), filename);
            }
        });
    }

    public PendingResult<Status> tryDownload(GoogleApiClient client, final String filename) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zznk zzauj;

            class C04981 extends zznj {
                final /* synthetic */ C04992 zzaul;

                C04981(C04992 c04992) {
                    this.zzaul = c04992;
                }

                public void zzJ(Status status) throws RemoteException {
                    this.zzaul.zza((Result) status);
                }
            }

            protected void zza(Context context, zznm com_google_android_gms_internal_zznm) throws RemoteException {
                com_google_android_gms_internal_zznm.zzb(new C04981(this), filename);
            }
        });
    }
}

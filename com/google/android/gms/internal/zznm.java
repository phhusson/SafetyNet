package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.download.DownloadDetails;

public interface zznm extends IInterface {

    public static abstract class zza extends Binder implements zznm {

        private static class zza implements zznm {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zznn com_google_android_gms_internal_zznn, DownloadDetails downloadDetails) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.download.internal.IDownloadService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zznn != null ? com_google_android_gms_internal_zznn.asBinder() : null);
                    if (downloadDetails != null) {
                        obtain.writeInt(1);
                        downloadDetails.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zznn com_google_android_gms_internal_zznn, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.download.internal.IDownloadService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zznn != null ? com_google_android_gms_internal_zznn.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zznn com_google_android_gms_internal_zznn, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.download.internal.IDownloadService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zznn != null ? com_google_android_gms_internal_zznn.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zznn com_google_android_gms_internal_zznn, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.download.internal.IDownloadService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zznn != null ? com_google_android_gms_internal_zznn.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zznn com_google_android_gms_internal_zznn, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.download.internal.IDownloadService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zznn != null ? com_google_android_gms_internal_zznn.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zznm zzcp(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.download.internal.IDownloadService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznm)) ? new zza(iBinder) : (zznm) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.common.download.internal.IDownloadService");
                    zza(com.google.android.gms.internal.zznn.zza.zzcq(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.common.download.internal.IDownloadService");
                    zzb(com.google.android.gms.internal.zznn.zza.zzcq(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.common.download.internal.IDownloadService");
                    zzc(com.google.android.gms.internal.zznn.zza.zzcq(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.common.download.internal.IDownloadService");
                    zza(com.google.android.gms.internal.zznn.zza.zzcq(data.readStrongBinder()), data.readInt() != 0 ? (DownloadDetails) DownloadDetails.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.common.download.internal.IDownloadService");
                    zzd(com.google.android.gms.internal.zznn.zza.zzcq(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.download.internal.IDownloadService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zznn com_google_android_gms_internal_zznn, DownloadDetails downloadDetails) throws RemoteException;

    void zza(zznn com_google_android_gms_internal_zznn, String str) throws RemoteException;

    void zzb(zznn com_google_android_gms_internal_zznn, String str) throws RemoteException;

    void zzc(zznn com_google_android_gms_internal_zznn, String str) throws RemoteException;

    void zzd(zznn com_google_android_gms_internal_zznn, String str) throws RemoteException;
}

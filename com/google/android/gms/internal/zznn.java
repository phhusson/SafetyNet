package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface zznn extends IInterface {

    public static abstract class zza extends Binder implements zznn {

        private static class zza implements zznn {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zzJ(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.download.internal.IDownloadServiceCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzK(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.download.internal.IDownloadServiceCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.common.download.internal.IDownloadServiceCallbacks");
        }

        public static zznn zzcq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.download.internal.IDownloadServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznn)) ? new zza(iBinder) : (zznn) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Status status = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.common.download.internal.IDownloadServiceCallbacks");
                    if (data.readInt() != 0) {
                        status = (Status) Status.CREATOR.createFromParcel(data);
                    }
                    zzJ(status);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.common.download.internal.IDownloadServiceCallbacks");
                    if (data.readInt() != 0) {
                        status = (Status) Status.CREATOR.createFromParcel(data);
                    }
                    zzK(status);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.download.internal.IDownloadServiceCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzJ(Status status) throws RemoteException;

    void zzK(Status status) throws RemoteException;
}

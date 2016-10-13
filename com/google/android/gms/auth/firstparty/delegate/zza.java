package com.google.android.gms.auth.firstparty.delegate;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zza extends IInterface {

    public static abstract class zza extends Binder implements zza {

        private static class zza implements zza {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public PendingIntent getAccountSetupWorkflowIntent(SetupAccountWorkflowRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.delegate.IAccountSetupWorkflowService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    PendingIntent pendingIntent = obtain2.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return pendingIntent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zza zzaX(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.firstparty.delegate.IAccountSetupWorkflowService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new zza(iBinder) : (zza) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.delegate.IAccountSetupWorkflowService");
                    PendingIntent accountSetupWorkflowIntent = getAccountSetupWorkflowIntent(data.readInt() != 0 ? SetupAccountWorkflowRequest.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (accountSetupWorkflowIntent != null) {
                        reply.writeInt(1);
                        accountSetupWorkflowIntent.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.firstparty.delegate.IAccountSetupWorkflowService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    PendingIntent getAccountSetupWorkflowIntent(SetupAccountWorkflowRequest setupAccountWorkflowRequest) throws RemoteException;
}

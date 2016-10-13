package com.google.android.gms.auth.firstparty.delegate;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAuthDelegateService extends IInterface {

    public static abstract class Stub extends Binder implements IAuthDelegateService {

        private static class Proxy implements IAuthDelegateService {
            private IBinder zzoz;

            Proxy(IBinder remote) {
                this.zzoz = remote;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public PendingIntent getConfirmCredentialsWorkflowIntent(ConfirmCredentialsWorkflowRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.delegate.IAuthDelegateService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(4, obtain, obtain2, 0);
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

            public String getInterfaceDescriptor() {
                return "com.google.android.gms.auth.firstparty.delegate.IAuthDelegateService";
            }

            public PendingIntent getSetupAccountWorkflowIntent(SetupAccountWorkflowRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.delegate.IAuthDelegateService");
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

            public PendingIntent getTokenRetrievalWorkflowIntent(TokenWorkflowRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.delegate.IAuthDelegateService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, obtain2, 0);
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

            public PendingIntent getUpdateCredentialsWorkflowIntent(UpdateCredentialsWorkflowRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.delegate.IAuthDelegateService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(3, obtain, obtain2, 0);
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

        public Stub() {
            attachInterface(this, "com.google.android.gms.auth.firstparty.delegate.IAuthDelegateService");
        }

        public static IAuthDelegateService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface queryLocalInterface = obj.queryLocalInterface("com.google.android.gms.auth.firstparty.delegate.IAuthDelegateService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAuthDelegateService)) ? new Proxy(obj) : (IAuthDelegateService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ConfirmCredentialsWorkflowRequest confirmCredentialsWorkflowRequest = null;
            PendingIntent setupAccountWorkflowIntent;
            switch (code) {
                case 1:
                    SetupAccountWorkflowRequest createFromParcel;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.delegate.IAuthDelegateService");
                    if (data.readInt() != 0) {
                        createFromParcel = SetupAccountWorkflowRequest.CREATOR.createFromParcel(data);
                    }
                    setupAccountWorkflowIntent = getSetupAccountWorkflowIntent(createFromParcel);
                    reply.writeNoException();
                    if (setupAccountWorkflowIntent != null) {
                        reply.writeInt(1);
                        setupAccountWorkflowIntent.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 2:
                    TokenWorkflowRequest createFromParcel2;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.delegate.IAuthDelegateService");
                    if (data.readInt() != 0) {
                        createFromParcel2 = TokenWorkflowRequest.CREATOR.createFromParcel(data);
                    }
                    setupAccountWorkflowIntent = getTokenRetrievalWorkflowIntent(createFromParcel2);
                    reply.writeNoException();
                    if (setupAccountWorkflowIntent != null) {
                        reply.writeInt(1);
                        setupAccountWorkflowIntent.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 3:
                    UpdateCredentialsWorkflowRequest createFromParcel3;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.delegate.IAuthDelegateService");
                    if (data.readInt() != 0) {
                        createFromParcel3 = UpdateCredentialsWorkflowRequest.CREATOR.createFromParcel(data);
                    }
                    setupAccountWorkflowIntent = getUpdateCredentialsWorkflowIntent(createFromParcel3);
                    reply.writeNoException();
                    if (setupAccountWorkflowIntent != null) {
                        reply.writeInt(1);
                        setupAccountWorkflowIntent.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.delegate.IAuthDelegateService");
                    if (data.readInt() != 0) {
                        confirmCredentialsWorkflowRequest = ConfirmCredentialsWorkflowRequest.CREATOR.createFromParcel(data);
                    }
                    setupAccountWorkflowIntent = getConfirmCredentialsWorkflowIntent(confirmCredentialsWorkflowRequest);
                    reply.writeNoException();
                    if (setupAccountWorkflowIntent != null) {
                        reply.writeInt(1);
                        setupAccountWorkflowIntent.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.firstparty.delegate.IAuthDelegateService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    PendingIntent getConfirmCredentialsWorkflowIntent(ConfirmCredentialsWorkflowRequest confirmCredentialsWorkflowRequest) throws RemoteException;

    PendingIntent getSetupAccountWorkflowIntent(SetupAccountWorkflowRequest setupAccountWorkflowRequest) throws RemoteException;

    PendingIntent getTokenRetrievalWorkflowIntent(TokenWorkflowRequest tokenWorkflowRequest) throws RemoteException;

    PendingIntent getUpdateCredentialsWorkflowIntent(UpdateCredentialsWorkflowRequest updateCredentialsWorkflowRequest) throws RemoteException;
}

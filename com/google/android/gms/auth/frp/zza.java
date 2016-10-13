package com.google.android.gms.auth.frp;

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

            public boolean isChallengeRequired() throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.frp.IFrpService");
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isChallengeSupported() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.frp.IFrpService");
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public UnlockFactoryResetProtectionResponse unlockFactoryResetProtection(UnlockFactoryResetProtectionRequest unlockRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.frp.IFrpService");
                    if (unlockRequest != null) {
                        obtain.writeInt(1);
                        unlockRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    UnlockFactoryResetProtectionResponse createFromParcel = obtain2.readInt() != 0 ? UnlockFactoryResetProtectionResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zza zzaZ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.frp.IFrpService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new zza(iBinder) : (zza) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean isChallengeRequired;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.auth.frp.IFrpService");
                    isChallengeRequired = isChallengeRequired();
                    reply.writeNoException();
                    if (isChallengeRequired) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.auth.frp.IFrpService");
                    isChallengeRequired = isChallengeSupported();
                    reply.writeNoException();
                    if (isChallengeRequired) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.auth.frp.IFrpService");
                    UnlockFactoryResetProtectionResponse unlockFactoryResetProtection = unlockFactoryResetProtection(data.readInt() != 0 ? UnlockFactoryResetProtectionRequest.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (unlockFactoryResetProtection != null) {
                        reply.writeInt(1);
                        unlockFactoryResetProtection.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.frp.IFrpService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    boolean isChallengeRequired() throws RemoteException;

    boolean isChallengeSupported() throws RemoteException;

    UnlockFactoryResetProtectionResponse unlockFactoryResetProtection(UnlockFactoryResetProtectionRequest unlockFactoryResetProtectionRequest) throws RemoteException;
}

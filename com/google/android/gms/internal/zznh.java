package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.people.data.AudienceMember;

public interface zznh extends IInterface {

    public static abstract class zza extends Binder implements zznh {

        private static class zza implements zznh {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void editAudience() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.audience.dynamite.IAudienceViewCallbacks");
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeAudienceMember(AudienceMember member) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.audience.dynamite.IAudienceViewCallbacks");
                    if (member != null) {
                        obtain.writeInt(1);
                        member.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.common.audience.dynamite.IAudienceViewCallbacks");
        }

        public static zznh zzcn(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.audience.dynamite.IAudienceViewCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznh)) ? new zza(iBinder) : (zznh) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 3:
                    data.enforceInterface("com.google.android.gms.common.audience.dynamite.IAudienceViewCallbacks");
                    removeAudienceMember(data.readInt() != 0 ? AudienceMember.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.common.audience.dynamite.IAudienceViewCallbacks");
                    editAudience();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.audience.dynamite.IAudienceViewCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void editAudience() throws RemoteException;

    void removeAudienceMember(AudienceMember audienceMember) throws RemoteException;
}

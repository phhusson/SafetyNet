package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.people.data.Audience;
import com.google.android.gms.dynamic.zzd;

public interface zzng extends IInterface {

    public static abstract class zza extends Binder implements zzng {

        private static class zza implements zzng {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public zzd getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzdk = com.google.android.gms.dynamic.zzd.zza.zzdk(obtain2.readStrongBinder());
                    return zzdk;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRestoreInstanceState(Bundle state) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    if (state != null) {
                        obtain.writeInt(1);
                        state.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle onSaveInstanceState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAudience(Audience audience) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    if (audience != null) {
                        obtain.writeInt(1);
                        audience.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setIsUnderageAccount(boolean isUnderageAccount) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    if (isUnderageAccount) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setShowEmptyText(boolean showEmptyText) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    if (showEmptyText) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd com_google_android_gms_dynamic_zzd, zzd com_google_android_gms_dynamic_zzd2, zznh com_google_android_gms_internal_zznh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd2 != null ? com_google_android_gms_dynamic_zzd2.asBinder() : null);
                    if (com_google_android_gms_internal_zznh != null) {
                        iBinder = com_google_android_gms_internal_zznh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzcV(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    obtain.writeInt(i);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.common.audience.dynamite.IAudienceView");
        }

        public static zzng zzcm(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.audience.dynamite.IAudienceView");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzng)) ? new zza(iBinder) : (zzng) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            boolean z = false;
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    zza(com.google.android.gms.dynamic.zzd.zza.zzdk(data.readStrongBinder()), com.google.android.gms.dynamic.zzd.zza.zzdk(data.readStrongBinder()), com.google.android.gms.internal.zznh.zza.zzcn(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    zzcV(data.readInt());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setShowEmptyText(z);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    setAudience(data.readInt() != 0 ? Audience.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    Bundle onSaveInstanceState = onSaveInstanceState();
                    reply.writeNoException();
                    if (onSaveInstanceState != null) {
                        reply.writeInt(1);
                        onSaveInstanceState.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    onRestoreInstanceState(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    zzd view = getView();
                    reply.writeNoException();
                    if (view != null) {
                        iBinder = view.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setIsUnderageAccount(z);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.audience.dynamite.IAudienceView");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    zzd getView() throws RemoteException;

    void onRestoreInstanceState(Bundle bundle) throws RemoteException;

    Bundle onSaveInstanceState() throws RemoteException;

    void setAudience(Audience audience) throws RemoteException;

    void setIsUnderageAccount(boolean z) throws RemoteException;

    void setShowEmptyText(boolean z) throws RemoteException;

    void zza(zzd com_google_android_gms_dynamic_zzd, zzd com_google_android_gms_dynamic_zzd2, zznh com_google_android_gms_internal_zznh) throws RemoteException;

    void zzcV(int i) throws RemoteException;
}

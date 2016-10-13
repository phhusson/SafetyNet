package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.RecoveryDecision;
import com.google.android.gms.auth.RecoveryReadResponse;
import com.google.android.gms.auth.RecoveryWriteRequest;
import com.google.android.gms.auth.RecoveryWriteResponse;

public interface zzau extends IInterface {

    public static abstract class zza extends Binder implements zzau {

        private static class zza implements zzau {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public RecoveryDecision zza(String str, String str2, boolean z, Bundle bundle) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IRecoveryService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    RecoveryDecision createFromParcel = obtain2.readInt() != 0 ? RecoveryDecision.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public RecoveryWriteResponse zza(RecoveryWriteRequest recoveryWriteRequest, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IRecoveryService");
                    if (recoveryWriteRequest != null) {
                        obtain.writeInt(1);
                        recoveryWriteRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    RecoveryWriteResponse createFromParcel = obtain2.readInt() != 0 ? RecoveryWriteResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public RecoveryReadResponse zzb(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IRecoveryService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    RecoveryReadResponse createFromParcel = obtain2.readInt() != 0 ? RecoveryReadResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzau zzb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.auth.IRecoveryService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzau)) ? new zza(iBinder) : (zzau) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            RecoveryWriteRequest recoveryWriteRequest = null;
            switch (code) {
                case 1:
                    Bundle bundle;
                    data.enforceInterface("com.google.android.auth.IRecoveryService");
                    String readString = data.readString();
                    String readString2 = data.readString();
                    boolean z = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    RecoveryDecision zza = zza(readString, readString2, z, bundle);
                    reply.writeNoException();
                    if (zza != null) {
                        reply.writeInt(1);
                        zza.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.auth.IRecoveryService");
                    RecoveryReadResponse zzb = zzb(data.readString(), data.readString());
                    reply.writeNoException();
                    if (zzb != null) {
                        reply.writeInt(1);
                        zzb.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.auth.IRecoveryService");
                    if (data.readInt() != 0) {
                        recoveryWriteRequest = RecoveryWriteRequest.CREATOR.createFromParcel(data);
                    }
                    RecoveryWriteResponse zza2 = zza(recoveryWriteRequest, data.readString());
                    reply.writeNoException();
                    if (zza2 != null) {
                        reply.writeInt(1);
                        zza2.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.auth.IRecoveryService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    RecoveryDecision zza(String str, String str2, boolean z, Bundle bundle) throws RemoteException;

    RecoveryWriteResponse zza(RecoveryWriteRequest recoveryWriteRequest, String str) throws RemoteException;

    RecoveryReadResponse zzb(String str, String str2) throws RemoteException;
}

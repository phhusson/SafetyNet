package com.google.android.gms.people.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.people.People;
import com.google.android.gms.people.identity.internal.AccountToken;
import com.google.android.gms.people.identity.internal.ParcelableGetOptions;
import com.google.android.gms.people.identity.internal.ParcelableListOptions;
import com.google.android.gms.people.internal.autocomplete.ParcelableLoadAutocompleteResultsOptions;
import com.google.android.gms.people.internal.autocomplete.ParcelableLoadContactGroupFieldsOptions;
import com.google.android.gms.people.model.AvatarReference;
import com.google.android.gms.playlog.PlayLogger.LogSource;
import java.util.List;

public interface zzg extends IInterface {

    public static abstract class zza extends Binder implements zzg {

        private static class zza implements zzg {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public boolean isSyncToContactsEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    this.zzoz.transact(16, obtain, obtain2, 0);
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

            public Bundle zza(zzf com_google_android_gms_people_internal_zzf, boolean z, String str, String str2, int i) throws RemoteException {
                Bundle bundle = null;
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle zza(String str, String str2, long j, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(26, obtain, obtain2, 0);
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

            public Bundle zza(String str, String str2, long j, boolean z, boolean z2) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(205, obtain, obtain2, 0);
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

            public zzq zza(zzf com_google_android_gms_people_internal_zzf, DataHolder dataHolder, int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.zzoz.transact(602, obtain, obtain2, 0);
                    obtain2.readException();
                    zzq zzct = com.google.android.gms.common.internal.zzq.zza.zzct(obtain2.readStrongBinder());
                    return zzct;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzq zza(zzf com_google_android_gms_people_internal_zzf, AccountToken accountToken, ParcelableListOptions parcelableListOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    if (accountToken != null) {
                        obtain.writeInt(1);
                        accountToken.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelableListOptions != null) {
                        obtain.writeInt(1);
                        parcelableListOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(601, obtain, obtain2, 0);
                    obtain2.readException();
                    zzq zzct = com.google.android.gms.common.internal.zzq.zza.zzct(obtain2.readStrongBinder());
                    return zzct;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzq zza(zzf com_google_android_gms_people_internal_zzf, AvatarReference avatarReference, ParcelableLoadImageOptions parcelableLoadImageOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    if (avatarReference != null) {
                        obtain.writeInt(1);
                        avatarReference.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelableLoadImageOptions != null) {
                        obtain.writeInt(1);
                        parcelableLoadImageOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(508, obtain, obtain2, 0);
                    obtain2.readException();
                    zzq zzct = com.google.android.gms.common.internal.zzq.zza.zzct(obtain2.readStrongBinder());
                    return zzct;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzq zza(zzf com_google_android_gms_people_internal_zzf, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(509, obtain, obtain2, 0);
                    obtain2.readException();
                    zzq zzct = com.google.android.gms.common.internal.zzq.zza.zzct(obtain2.readStrongBinder());
                    return zzct;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzq zza(zzf com_google_android_gms_people_internal_zzf, String str, ParcelableLoadAutocompleteResultsOptions parcelableLoadAutocompleteResultsOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelableLoadAutocompleteResultsOptions != null) {
                        obtain.writeInt(1);
                        parcelableLoadAutocompleteResultsOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1301, obtain, obtain2, 0);
                    obtain2.readException();
                    zzq zzct = com.google.android.gms.common.internal.zzq.zza.zzct(obtain2.readStrongBinder());
                    return zzct;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzq zza(zzf com_google_android_gms_people_internal_zzf, String str, ParcelableLoadContactGroupFieldsOptions parcelableLoadContactGroupFieldsOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelableLoadContactGroupFieldsOptions != null) {
                        obtain.writeInt(1);
                        parcelableLoadContactGroupFieldsOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1302, obtain, obtain2, 0);
                    obtain2.readException();
                    zzq zzct = com.google.android.gms.common.internal.zzq.zza.zzct(obtain2.readStrongBinder());
                    return zzct;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzq zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, boolean z, String str3, String str4, int i, int i2, int i3, boolean z2) throws RemoteException {
                int i4 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!z2) {
                        i4 = 0;
                    }
                    obtain.writeInt(i4);
                    this.zzoz.transact(507, obtain, obtain2, 0);
                    obtain2.readException();
                    zzq zzct = com.google.android.gms.common.internal.zzq.zza.zzct(obtain2.readStrongBinder());
                    return zzct;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, long j, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeLong(j);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(302, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, AccountToken accountToken, List<String> list, ParcelableGetOptions parcelableGetOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    if (accountToken != null) {
                        obtain.writeInt(1);
                        accountToken.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list);
                    if (parcelableGetOptions != null) {
                        obtain.writeInt(1);
                        parcelableGetOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.zzoz.transact(403, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.zzoz.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, Uri uri, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1102, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zzoz.transact(204, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, int i, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    obtain.writeString(str4);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, int i, String str4, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    obtain.writeString(str4);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, int i, boolean z, int i2, int i3, String str4) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str4);
                    this.zzoz.transact(202, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, int i, boolean z, int i2, int i3, String str4, boolean z2) throws RemoteException {
                int i4 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str4);
                    if (!z2) {
                        i4 = 0;
                    }
                    obtain.writeInt(i4);
                    this.zzoz.transact(203, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, int i, boolean z, int i2, int i3, String str4, boolean z2, int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str4);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    this.zzoz.transact(402, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.zzoz.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, String str4, int i, String str5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeInt(i);
                    obtain.writeString(str5);
                    this.zzoz.transact(303, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, String str4, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(701, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringList(list);
                    this.zzoz.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list, int i, boolean z, long j) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringList(list);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list, int i, boolean z, long j, String str4, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringList(list);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeLong(j);
                    obtain.writeString(str4);
                    obtain.writeInt(i2);
                    this.zzoz.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list, int i, boolean z, long j, String str4, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringList(list);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeLong(j);
                    obtain.writeString(str4);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.zzoz.transact(401, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list, int i, boolean z, long j, String str4, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringList(list);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeLong(j);
                    obtain.writeString(str4);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.zzoz.transact(404, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list, List<String> list2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringList(list);
                    obtain.writeStringList(list2);
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list, List<String> list2, FavaDiagnosticsEntity favaDiagnosticsEntity) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringList(list);
                    obtain.writeStringList(list2);
                    if (favaDiagnosticsEntity != null) {
                        obtain.writeInt(1);
                        favaDiagnosticsEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, boolean z, int i) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i);
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, boolean z, int i, int i2) throws RemoteException {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.zzoz.transact(201, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, String str, boolean z, String[] strArr) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, boolean z, boolean z2, String str, String str2) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_people_internal_zzf, boolean z, boolean z2, String str, String str2, int i) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.zzoz.transact(305, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzaS(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle zzah(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(12, obtain, obtain2, 0);
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

            public Bundle zzai(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(17, obtain, obtain2, 0);
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

            public zzq zzb(zzf com_google_android_gms_people_internal_zzf, long j, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeLong(j);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(503, obtain, obtain2, 0);
                    obtain2.readException();
                    zzq zzct = com.google.android.gms.common.internal.zzq.zza.zzct(obtain2.readStrongBinder());
                    return zzct;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzq zzb(zzf com_google_android_gms_people_internal_zzf, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(504, obtain, obtain2, 0);
                    obtain2.readException();
                    zzq zzct = com.google.android.gms.common.internal.zzq.zza.zzct(obtain2.readStrongBinder());
                    return zzct;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzq zzb(zzf com_google_android_gms_people_internal_zzf, String str, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.zzoz.transact(502, obtain, obtain2, 0);
                    obtain2.readException();
                    zzq zzct = com.google.android.gms.common.internal.zzq.zza.zzct(obtain2.readStrongBinder());
                    return zzct;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzq zzb(zzf com_google_android_gms_people_internal_zzf, String str, String str2, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.zzoz.transact(505, obtain, obtain2, 0);
                    obtain2.readException();
                    zzq zzct = com.google.android.gms.common.internal.zzq.zza.zzct(obtain2.readStrongBinder());
                    return zzct;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzq zzb(zzf com_google_android_gms_people_internal_zzf, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1201, obtain, obtain2, 0);
                    obtain2.readException();
                    zzq zzct = com.google.android.gms.common.internal.zzq.zza.zzct(obtain2.readStrongBinder());
                    return zzct;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzf com_google_android_gms_people_internal_zzf, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(304, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzf com_google_android_gms_people_internal_zzf, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(People.STATUS_NOT_ALLOWED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzf com_google_android_gms_people_internal_zzf, String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.zzoz.transact(301, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, int i, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    obtain.writeString(str4);
                    this.zzoz.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(603, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle zzc(String str, String str2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    this.zzoz.transact(20, obtain, obtain2, 0);
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

            public zzq zzc(zzf com_google_android_gms_people_internal_zzf, String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.zzoz.transact(506, obtain, obtain2, 0);
                    obtain2.readException();
                    zzq zzct = com.google.android.gms.common.internal.zzq.zza.zzct(obtain2.readStrongBinder());
                    return zzct;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzf com_google_android_gms_people_internal_zzf, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(102, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzf com_google_android_gms_people_internal_zzf, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    obtain.writeStrongBinder(com_google_android_gms_people_internal_zzf != null ? com_google_android_gms_people_internal_zzf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(1101, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle zzp(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleService");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(8, obtain, obtain2, 0);
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
        }

        public static zzg zzgk(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.people.internal.IPeopleService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzg)) ? new zza(iBinder) : (zzg) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Bundle zzp;
            zzq zzb;
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readInt() != 0, data.readInt() != 0, data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.createStringArrayList(), data.readInt(), data.readInt() != 0, data.readLong());
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readLong(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzp = zzp(data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (zzp != null) {
                        reply.writeInt(1);
                        zzp.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.readInt() != 0, data.readInt());
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readInt() != 0, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzp = zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readInt() != 0, data.readString(), data.readString(), data.readInt());
                    reply.writeNoException();
                    if (zzp != null) {
                        reply.writeInt(1);
                        zzp.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzp = zzah(data.readString(), data.readString());
                    reply.writeNoException();
                    if (zzp != null) {
                        reply.writeInt(1);
                        zzp.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.createStringArrayList(), data.createStringArrayList());
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzaS(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    boolean isSyncToContactsEnabled = isSyncToContactsEnabled();
                    reply.writeNoException();
                    reply.writeInt(isSyncToContactsEnabled ? 1 : 0);
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzp = zzai(data.readString(), data.readString());
                    reply.writeNoException();
                    if (zzp != null) {
                        reply.writeInt(1);
                        zzp.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.readInt(), data.readString(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzp = zzc(data.readString(), data.readString(), data.readLong());
                    reply.writeNoException();
                    if (zzp != null) {
                        reply.writeInt(1);
                        zzp.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.createStringArrayList(), data.readInt(), data.readInt() != 0, data.readLong(), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.createStringArrayList(), data.createStringArrayList(), data.readInt() != 0 ? FavaDiagnosticsEntity.CREATOR.zzbf(data) : null);
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case LogSource.ANDROID_CAMERA /*26*/:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzp = zza(data.readString(), data.readString(), data.readLong(), data.readInt() != 0);
                    reply.writeNoException();
                    if (zzp != null) {
                        reply.writeInt(1);
                        zzp.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case LogSource.CW /*27*/:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case LogSource.GEL /*28*/:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.createStringArrayList());
                    reply.writeNoException();
                    return true;
                case LogSource.DNA_PROBER /*29*/:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case People.STATUS_NOT_ALLOWED /*101*/:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 102:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzc(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 201:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.readInt() != 0, data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 202:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.readInt(), data.readInt() != 0, data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 203:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.readInt(), data.readInt() != 0, data.readInt(), data.readInt(), data.readString(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 204:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 205:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzp = zza(data.readString(), data.readString(), data.readLong(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    if (zzp != null) {
                        reply.writeInt(1);
                        zzp.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 301:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 302:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 303:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.readString(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 304:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 305:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readInt() != 0, data.readInt() != 0, data.readString(), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 401:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.createStringArrayList(), data.readInt(), data.readInt() != 0, data.readLong(), data.readString(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 402:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.readInt(), data.readInt() != 0, data.readInt(), data.readInt(), data.readString(), data.readInt() != 0, data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 403:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 404:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.createStringArrayList(), data.readInt(), data.readInt() != 0, data.readLong(), data.readString(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 501:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readInt() != 0 ? AccountToken.CREATOR.zzid(data) : null, data.createStringArrayList(), data.readInt() != 0 ? ParcelableGetOptions.CREATOR.zzie(data) : null);
                    reply.writeNoException();
                    return true;
                case 502:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb = zzb(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 503:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb = zzb(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readLong(), data.readInt() != 0);
                    reply.writeNoException();
                    reply.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 504:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb = zzb(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    reply.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 505:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb = zzb(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 506:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb = zzc(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 507:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb = zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readInt() != 0, data.readString(), data.readString(), data.readInt(), data.readInt(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    reply.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 508:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb = zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readInt() != 0 ? AvatarReference.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? ParcelableLoadImageOptions.CREATOR.zzju(data) : null);
                    reply.writeNoException();
                    reply.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 509:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb = zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 601:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb = zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readInt() != 0 ? AccountToken.CREATOR.zzid(data) : null, data.readInt() != 0 ? ParcelableListOptions.CREATOR.zzif(data) : null);
                    reply.writeNoException();
                    reply.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 602:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb = zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(data) : null, data.readInt(), data.readInt(), data.readLong());
                    reply.writeNoException();
                    reply.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 603:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 701:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.readString(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 1101:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzd(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 1102:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1201:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb = zzb(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    reply.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 1301:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb = zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readInt() != 0 ? ParcelableLoadAutocompleteResultsOptions.CREATOR.zzjE(data) : null);
                    reply.writeNoException();
                    reply.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 1302:
                    data.enforceInterface("com.google.android.gms.people.internal.IPeopleService");
                    zzb = zza(com.google.android.gms.people.internal.zzf.zza.zzgj(data.readStrongBinder()), data.readString(), data.readInt() != 0 ? ParcelableLoadContactGroupFieldsOptions.CREATOR.zzjF(data) : null);
                    reply.writeNoException();
                    reply.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.people.internal.IPeopleService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    boolean isSyncToContactsEnabled() throws RemoteException;

    Bundle zza(zzf com_google_android_gms_people_internal_zzf, boolean z, String str, String str2, int i) throws RemoteException;

    Bundle zza(String str, String str2, long j, boolean z) throws RemoteException;

    Bundle zza(String str, String str2, long j, boolean z, boolean z2) throws RemoteException;

    zzq zza(zzf com_google_android_gms_people_internal_zzf, DataHolder dataHolder, int i, int i2, long j) throws RemoteException;

    zzq zza(zzf com_google_android_gms_people_internal_zzf, AccountToken accountToken, ParcelableListOptions parcelableListOptions) throws RemoteException;

    zzq zza(zzf com_google_android_gms_people_internal_zzf, AvatarReference avatarReference, ParcelableLoadImageOptions parcelableLoadImageOptions) throws RemoteException;

    zzq zza(zzf com_google_android_gms_people_internal_zzf, String str, int i) throws RemoteException;

    zzq zza(zzf com_google_android_gms_people_internal_zzf, String str, ParcelableLoadAutocompleteResultsOptions parcelableLoadAutocompleteResultsOptions) throws RemoteException;

    zzq zza(zzf com_google_android_gms_people_internal_zzf, String str, ParcelableLoadContactGroupFieldsOptions parcelableLoadContactGroupFieldsOptions) throws RemoteException;

    zzq zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, boolean z, String str3, String str4, int i, int i2, int i3, boolean z2) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, long j, boolean z) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, Bundle bundle) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, AccountToken accountToken, List<String> list, ParcelableGetOptions parcelableGetOptions) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, int i, int i2) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, int i) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, int i, int i2) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, Uri uri) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, Uri uri, boolean z) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, Bundle bundle) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, int i, String str4) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, int i, String str4, boolean z) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, int i, boolean z, int i2, int i3, String str4) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, int i, boolean z, int i2, int i3, String str4, boolean z2) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, int i, boolean z, int i2, int i3, String str4, boolean z2, int i4, int i5) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, String str4) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, String str4, int i, String str5) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, String str4, boolean z) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list, int i, boolean z, long j) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list, int i, boolean z, long j, String str4, int i2) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list, int i, boolean z, long j, String str4, int i2, int i3) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list, int i, boolean z, long j, String str4, int i2, int i3, int i4) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list, List<String> list2) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, List<String> list, List<String> list2, FavaDiagnosticsEntity favaDiagnosticsEntity) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, boolean z) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, boolean z, int i) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, boolean z, int i, int i2) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, String str, boolean z, String[] strArr) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, boolean z, boolean z2, String str, String str2) throws RemoteException;

    void zza(zzf com_google_android_gms_people_internal_zzf, boolean z, boolean z2, String str, String str2, int i) throws RemoteException;

    void zzaS(boolean z) throws RemoteException;

    Bundle zzah(String str, String str2) throws RemoteException;

    Bundle zzai(String str, String str2) throws RemoteException;

    zzq zzb(zzf com_google_android_gms_people_internal_zzf, long j, boolean z) throws RemoteException;

    zzq zzb(zzf com_google_android_gms_people_internal_zzf, String str) throws RemoteException;

    zzq zzb(zzf com_google_android_gms_people_internal_zzf, String str, int i, int i2) throws RemoteException;

    zzq zzb(zzf com_google_android_gms_people_internal_zzf, String str, String str2, int i, int i2) throws RemoteException;

    zzq zzb(zzf com_google_android_gms_people_internal_zzf, String str, String str2, Bundle bundle) throws RemoteException;

    void zzb(zzf com_google_android_gms_people_internal_zzf, Bundle bundle) throws RemoteException;

    void zzb(zzf com_google_android_gms_people_internal_zzf, String str, String str2) throws RemoteException;

    void zzb(zzf com_google_android_gms_people_internal_zzf, String str, String str2, int i) throws RemoteException;

    void zzb(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, int i, String str4) throws RemoteException;

    void zzb(zzf com_google_android_gms_people_internal_zzf, String str, String str2, String str3, boolean z) throws RemoteException;

    Bundle zzc(String str, String str2, long j) throws RemoteException;

    zzq zzc(zzf com_google_android_gms_people_internal_zzf, String str, String str2, int i) throws RemoteException;

    void zzc(zzf com_google_android_gms_people_internal_zzf, String str, String str2) throws RemoteException;

    void zzd(zzf com_google_android_gms_people_internal_zzf, String str, String str2) throws RemoteException;

    Bundle zzp(Uri uri) throws RemoteException;
}

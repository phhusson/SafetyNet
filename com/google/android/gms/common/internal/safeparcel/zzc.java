package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public final class zzc {
    public static <T extends SafeParcelable> T zza(Intent intent, String str, Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        return byteArrayExtra == null ? null : zza(byteArrayExtra, creator);
    }

    public static <T extends SafeParcelable> T zza(byte[] bArr, Creator<T> creator) {
        zzx.zzD(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }

    public static <T extends SafeParcelable> void zza(T t, Intent intent, String str) {
        intent.putExtra(str, zza(t));
    }

    public static <T extends SafeParcelable> void zza(Iterable<T> iterable, Intent intent, String str) {
        Serializable arrayList = new ArrayList();
        for (T zza : iterable) {
            arrayList.add(zza(zza));
        }
        intent.putExtra(str, arrayList);
    }

    public static <T extends SafeParcelable> byte[] zza(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <T extends SafeParcelable> ArrayList<T> zzb(Intent intent, String str, Creator<T> creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<T> arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(zza((byte[]) it.next(), creator));
        }
        return arrayList2;
    }
}

package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder.Builder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] zzatJ = new String[]{"data"};
    private final Creator<T> zzatK;

    public zzd(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.zzatK = creator;
    }

    public static <T extends SafeParcelable> void zza(Builder builder, T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        builder.withRow(contentValues);
        obtain.recycle();
    }

    public static Builder zzqw() {
        return DataHolder.builder(zzatJ);
    }

    public /* synthetic */ Object get(int i) {
        return zzcY(i);
    }

    public T zzcY(int i) {
        byte[] byteArray = this.zzarr.getByteArray("data", i, this.zzarr.zzcZ(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArray, 0, byteArray.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.zzatK.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }
}

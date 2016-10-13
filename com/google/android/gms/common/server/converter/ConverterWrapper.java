package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;

public class ConverterWrapper implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    private final StringToIntConverter zzaxw;

    ConverterWrapper(int versionCode, StringToIntConverter stringToIntConverter) {
        this.mVersionCode = versionCode;
        this.zzaxw = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.mVersionCode = 1;
        this.zzaxw = stringToIntConverter;
    }

    public static ConverterWrapper zza(FieldConverter<?, ?> fieldConverter) {
        if (fieldConverter instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) fieldConverter);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public int describeContents() {
        zza com_google_android_gms_common_server_converter_zza = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza com_google_android_gms_common_server_converter_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    StringToIntConverter zzrB() {
        return this.zzaxw;
    }

    public FieldConverter<?, ?> zzrC() {
        if (this.zzaxw != null) {
            return this.zzaxw;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}

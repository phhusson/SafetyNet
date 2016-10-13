package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<EmailSignInOptions> {
    static void zza(EmailSignInOptions emailSignInOptions, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, emailSignInOptions.versionCode);
        zzb.zza(parcel, 2, emailSignInOptions.getServerWidgetUrl(), i, false);
        zzb.zza(parcel, 3, emailSignInOptions.getModeQueryName(), false);
        zzb.zza(parcel, 4, emailSignInOptions.getTermsOfServiceUrl(), i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaU(i);
    }

    public EmailSignInOptions zzT(Parcel parcel) {
        Uri uri = null;
        int zzbd = com.google.android.gms.common.internal.safeparcel.zza.zzbd(parcel);
        int i = 0;
        String str = null;
        Uri uri2 = null;
        while (parcel.dataPosition() < zzbd) {
            String str2;
            Uri uri3;
            int zzg;
            Uri uri4;
            int zzbc = com.google.android.gms.common.internal.safeparcel.zza.zzbc(parcel);
            Uri uri5;
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzdr(zzbc)) {
                case 1:
                    uri5 = uri;
                    str2 = str;
                    uri3 = uri2;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzbc);
                    uri4 = uri5;
                    break;
                case 2:
                    zzg = i;
                    String str3 = str;
                    uri3 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzbc, Uri.CREATOR);
                    uri4 = uri;
                    str2 = str3;
                    break;
                case 3:
                    uri3 = uri2;
                    zzg = i;
                    uri5 = uri;
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzbc);
                    uri4 = uri5;
                    break;
                case 4:
                    uri4 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzbc, Uri.CREATOR);
                    str2 = str;
                    uri3 = uri2;
                    zzg = i;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzbc);
                    uri4 = uri;
                    str2 = str;
                    uri3 = uri2;
                    zzg = i;
                    break;
            }
            i = zzg;
            uri2 = uri3;
            str = str2;
            uri = uri4;
        }
        if (parcel.dataPosition() == zzbd) {
            return new EmailSignInOptions(i, uri2, str, uri);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public EmailSignInOptions[] zzaU(int i) {
        return new EmailSignInOptions[i];
    }
}

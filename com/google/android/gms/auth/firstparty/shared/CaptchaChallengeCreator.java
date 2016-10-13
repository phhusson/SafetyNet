package com.google.android.gms.auth.firstparty.shared;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class CaptchaChallengeCreator implements Creator<CaptchaChallenge> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(CaptchaChallenge captchaChallenge, Parcel parcel, int i) {
        int zzbe = zzb.zzbe(parcel);
        zzb.zzc(parcel, 1, captchaChallenge.version);
        zzb.zza(parcel, 2, captchaChallenge.zzaah, false);
        zzb.zza(parcel, 3, captchaChallenge.zzaaC, false);
        zzb.zza(parcel, 4, captchaChallenge.zzacg, i, false);
        zzb.zzJ(parcel, zzbe);
    }

    public CaptchaChallenge createFromParcel(Parcel parcel) {
        Bitmap bitmap = null;
        int zzbd = zza.zzbd(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzbd) {
            int zzbc = zza.zzbc(parcel);
            switch (zza.zzdr(zzbc)) {
                case 1:
                    i = zza.zzg(parcel, zzbc);
                    break;
                case 2:
                    str2 = zza.zzq(parcel, zzbc);
                    break;
                case 3:
                    str = zza.zzq(parcel, zzbc);
                    break;
                case 4:
                    bitmap = (Bitmap) zza.zza(parcel, zzbc, Bitmap.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzbc);
                    break;
            }
        }
        if (parcel.dataPosition() == zzbd) {
            return new CaptchaChallenge(i, str2, str, bitmap);
        }
        throw new zza.zza("Overread allowed size end=" + zzbd, parcel);
    }

    public CaptchaChallenge[] newArray(int size) {
        return new CaptchaChallenge[size];
    }
}

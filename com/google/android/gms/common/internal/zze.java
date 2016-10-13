package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zze {
    public static final zze zzavA = new C02248();
    public static final zze zzavB = zza('\u0000', '\u001f').zza(zza('', ''));
    public static final zze zzavC = zza('\u0000', ' ').zza(zza('', ' ')).zza(zzc('­')).zza(zza('؀', '؃')).zza(zza((CharSequence) "۝܏ ឴឵᠎")).zza(zza(' ', '‏')).zza(zza(' ', ' ')).zza(zza(' ', '⁤')).zza(zza('⁪', '⁯')).zza(zzc('　')).zza(zza('?', '')).zza(zza((CharSequence) "﻿￹￺￻"));
    public static final zze zzavD = zza('\u0000', 'ӹ').zza(zzc('־')).zza(zza('א', 'ת')).zza(zzc('׳')).zza(zzc('״')).zza(zza('؀', 'ۿ')).zza(zza('ݐ', 'ݿ')).zza(zza('฀', '๿')).zza(zza('Ḁ', '₯')).zza(zza('℀', '℺')).zza(zza('ﭐ', '﷿')).zza(zza('ﹰ', '﻿')).zza(zza('｡', 'ￜ'));
    public static final zze zzavE = new C02259();
    public static final zze zzavF = new zze() {
        public zze zza(zze com_google_android_gms_common_internal_zze) {
            return (zze) zzx.zzD(com_google_android_gms_common_internal_zze);
        }

        public boolean zzb(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public boolean zzd(char c) {
            return false;
        }
    };
    public static final zze zzavr = zza((CharSequence) "\t\n\u000b\f\r     　 ᠎ ").zza(zza(' ', ' '));
    public static final zze zzavs = zza((CharSequence) "\t\n\u000b\f\r     　").zza(zza(' ', ' ')).zza(zza(' ', ' '));
    public static final zze zzavt = zza('\u0000', '');
    public static final zze zzavu;
    public static final zze zzavv = zza('\t', '\r').zza(zza('\u001c', ' ')).zza(zzc(' ')).zza(zzc('᠎')).zza(zza(' ', ' ')).zza(zza(' ', '​')).zza(zza(' ', ' ')).zza(zzc(' ')).zza(zzc('　'));
    public static final zze zzavw = new C02171();
    public static final zze zzavx = new C02215();
    public static final zze zzavy = new C02226();
    public static final zze zzavz = new C02237();

    static class C02171 extends zze {
        C02171() {
        }

        public boolean zzd(char c) {
            return Character.isDigit(c);
        }
    }

    static class C02215 extends zze {
        C02215() {
        }

        public boolean zzd(char c) {
            return Character.isLetter(c);
        }
    }

    static class C02226 extends zze {
        C02226() {
        }

        public boolean zzd(char c) {
            return Character.isLetterOrDigit(c);
        }
    }

    static class C02237 extends zze {
        C02237() {
        }

        public boolean zzd(char c) {
            return Character.isUpperCase(c);
        }
    }

    static class C02248 extends zze {
        C02248() {
        }

        public boolean zzd(char c) {
            return Character.isLowerCase(c);
        }
    }

    static class C02259 extends zze {
        C02259() {
        }

        public zze zza(zze com_google_android_gms_common_internal_zze) {
            zzx.zzD(com_google_android_gms_common_internal_zze);
            return this;
        }

        public boolean zzb(CharSequence charSequence) {
            zzx.zzD(charSequence);
            return true;
        }

        public boolean zzd(char c) {
            return true;
        }
    }

    private static class zza extends zze {
        List<zze> zzavM;

        zza(List<zze> list) {
            this.zzavM = list;
        }

        public zze zza(zze com_google_android_gms_common_internal_zze) {
            List arrayList = new ArrayList(this.zzavM);
            arrayList.add(zzx.zzD(com_google_android_gms_common_internal_zze));
            return new zza(arrayList);
        }

        public boolean zzd(char c) {
            for (zze zzd : this.zzavM) {
                if (zzd.zzd(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        zze zza = zza('0', '9');
        zze com_google_android_gms_common_internal_zze = zza;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            com_google_android_gms_common_internal_zze = com_google_android_gms_common_internal_zze.zza(zza(c, (char) (c + 9)));
        }
        zzavu = com_google_android_gms_common_internal_zze;
    }

    public static zze zza(final char c, final char c2) {
        zzx.zzae(c2 >= c);
        return new zze() {
            public boolean zzd(char c) {
                return c <= c && c <= c2;
            }
        };
    }

    public static zze zza(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return zzavF;
            case 1:
                return zzc(charSequence.charAt(0));
            case 2:
                final char charAt = charSequence.charAt(0);
                final char charAt2 = charSequence.charAt(1);
                return new zze() {
                    public boolean zzd(char c) {
                        return c == charAt || c == charAt2;
                    }
                };
            default:
                final char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new zze() {
                    public boolean zzd(char c) {
                        return Arrays.binarySearch(toCharArray, c) >= 0;
                    }
                };
        }
    }

    public static zze zzc(final char c) {
        return new zze() {
            public zze zza(zze com_google_android_gms_common_internal_zze) {
                return com_google_android_gms_common_internal_zze.zzd(c) ? com_google_android_gms_common_internal_zze : super.zza(com_google_android_gms_common_internal_zze);
            }

            public boolean zzd(char c) {
                return c == c;
            }
        };
    }

    public zze zza(zze com_google_android_gms_common_internal_zze) {
        return new zza(Arrays.asList(new zze[]{this, (zze) zzx.zzD(com_google_android_gms_common_internal_zze)}));
    }

    public boolean zzb(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!zzd(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c);
}

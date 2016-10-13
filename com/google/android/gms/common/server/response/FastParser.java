package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzn;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class FastParser<T extends FastJsonResponse> {
    private static final char[] zzaxM = new char[]{'u', 'l', 'l'};
    private static final char[] zzaxN = new char[]{'r', 'u', 'e'};
    private static final char[] zzaxO = new char[]{'r', 'u', 'e', '\"'};
    private static final char[] zzaxP = new char[]{'a', 'l', 's', 'e'};
    private static final char[] zzaxQ = new char[]{'a', 'l', 's', 'e', '\"'};
    private static final char[] zzaxR = new char[]{'\n'};
    private static final zza<Integer> zzaxT = new C02271();
    private static final zza<Long> zzaxU = new C02282();
    private static final zza<Float> zzaxV = new C02293();
    private static final zza<Double> zzaxW = new C02304();
    private static final zza<Boolean> zzaxX = new C02315();
    private static final zza<String> zzaxY = new C02326();
    private static final zza<BigInteger> zzaxZ = new C02337();
    private static final zza<BigDecimal> zzaya = new C02348();
    private final char[] zzaxH = new char[1];
    private final char[] zzaxI = new char[32];
    private final char[] zzaxJ = new char[1024];
    private final StringBuilder zzaxK = new StringBuilder(32);
    private final StringBuilder zzaxL = new StringBuilder(1024);
    private final Stack<Integer> zzaxS = new Stack();

    private interface zza<O> {
        O zzi(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException;
    }

    static class C02271 implements zza<Integer> {
        C02271() {
        }

        public Integer zzh(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return Integer.valueOf(fastParser.zze(bufferedReader));
        }

        public /* synthetic */ Object zzi(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return zzh(fastParser, bufferedReader);
        }
    }

    static class C02282 implements zza<Long> {
        C02282() {
        }

        public /* synthetic */ Object zzi(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return zzj(fastParser, bufferedReader);
        }

        public Long zzj(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return Long.valueOf(fastParser.zzf(bufferedReader));
        }
    }

    static class C02293 implements zza<Float> {
        C02293() {
        }

        public /* synthetic */ Object zzi(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return zzk(fastParser, bufferedReader);
        }

        public Float zzk(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return Float.valueOf(fastParser.zzh(bufferedReader));
        }
    }

    static class C02304 implements zza<Double> {
        C02304() {
        }

        public /* synthetic */ Object zzi(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return zzl(fastParser, bufferedReader);
        }

        public Double zzl(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return Double.valueOf(fastParser.zzi(bufferedReader));
        }
    }

    static class C02315 implements zza<Boolean> {
        C02315() {
        }

        public /* synthetic */ Object zzi(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return zzm(fastParser, bufferedReader);
        }

        public Boolean zzm(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return Boolean.valueOf(fastParser.zza(bufferedReader, false));
        }
    }

    static class C02326 implements zza<String> {
        C02326() {
        }

        public /* synthetic */ Object zzi(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return zzn(fastParser, bufferedReader);
        }

        public String zzn(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return fastParser.zzc(bufferedReader);
        }
    }

    static class C02337 implements zza<BigInteger> {
        C02337() {
        }

        public /* synthetic */ Object zzi(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return zzo(fastParser, bufferedReader);
        }

        public BigInteger zzo(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return fastParser.zzg(bufferedReader);
        }
    }

    static class C02348 implements zza<BigDecimal> {
        C02348() {
        }

        public /* synthetic */ Object zzi(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return zzp(fastParser, bufferedReader);
        }

        public BigDecimal zzp(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
            return fastParser.zzj(bufferedReader);
        }
    }

    public static class ParseException extends Exception {
        public ParseException(String message) {
            super(message);
        }

        public ParseException(String message, Throwable cause) {
            super(message, cause);
        }

        public ParseException(Throwable cause) {
            super(cause);
        }
    }

    private int zza(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        char zzk = zzk(bufferedReader);
        if (zzk == '\u0000') {
            throw new ParseException("Unexpected EOF");
        } else if (zzk == ',') {
            throw new ParseException("Missing value");
        } else if (zzk == 'n') {
            zzb(bufferedReader, zzaxM);
            return 0;
        } else {
            int i;
            bufferedReader.mark(1024);
            if (zzk == '\"') {
                zzk = '\u0000';
                int i2 = 0;
                while (i2 < cArr.length && bufferedReader.read(cArr, i2, 1) != -1) {
                    char c = cArr[i2];
                    if (Character.isISOControl(c)) {
                        throw new ParseException("Unexpected control character while reading string");
                    } else if (c == '\"' && zzk == '\u0000') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i2 + 1));
                        return i2;
                    } else {
                        zzk = c == '\\' ? zzk == '\u0000' ? '\u0001' : '\u0000' : '\u0000';
                        i2++;
                    }
                }
                i = i2;
            } else {
                cArr[0] = zzk;
                i = 1;
                while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                    if (cArr[i] == '}' || cArr[i] == ',' || Character.isWhitespace(cArr[i]) || cArr[i] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i - 1));
                        cArr[i] = '\u0000';
                        return i;
                    }
                    i++;
                }
            }
            if (i == cArr.length) {
                throw new ParseException("Absurdly long value");
            }
            throw new ParseException("Unexpected EOF");
        }
    }

    private static int zza(char[] cArr, int i) throws ParseException {
        if (i > 0) {
            int i2;
            int i3;
            int i4;
            int i5;
            if (cArr[0] == '-') {
                i2 = Integer.MIN_VALUE;
                i3 = 1;
                i4 = 1;
            } else {
                i2 = -2147483647;
                i3 = 0;
                i4 = 0;
            }
            int i6 = i2 / 10;
            if (i3 < i) {
                i5 = i3 + 1;
                i3 = Character.digit(cArr[i3], 10);
                if (i3 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                i3 = -i3;
            } else {
                int i7 = i3;
                i3 = 0;
                i5 = i7;
            }
            while (i5 < i) {
                int i8 = i5 + 1;
                i5 = Character.digit(cArr[i5], 10);
                if (i5 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (i3 < i6) {
                    throw new ParseException("Number too large");
                } else {
                    i3 *= 10;
                    if (i3 < i2 + i5) {
                        throw new ParseException("Number too large");
                    }
                    i3 -= i5;
                    i5 = i8;
                }
            }
            if (i4 == 0) {
                return -i3;
            }
            if (i5 > 1) {
                return i3;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    private String zza(BufferedReader bufferedReader) throws ParseException, IOException {
        String str = null;
        this.zzaxS.push(Integer.valueOf(2));
        char zzk = zzk(bufferedReader);
        switch (zzk) {
            case '\"':
                this.zzaxS.push(Integer.valueOf(3));
                str = zzb(bufferedReader, this.zzaxI, this.zzaxK, null);
                zzdy(3);
                if (zzk(bufferedReader) != ':') {
                    throw new ParseException("Expected key/value separator");
                }
                break;
            case ']':
                zzdy(2);
                zzdy(1);
                zzdy(5);
                break;
            case '}':
                zzdy(2);
                break;
            default:
                throw new ParseException("Unexpected token: " + zzk);
        }
        return str;
    }

    private String zza(BufferedReader bufferedReader, char[] cArr, StringBuilder stringBuilder, char[] cArr2) throws ParseException, IOException {
        switch (zzk(bufferedReader)) {
            case '\"':
                return zzb(bufferedReader, cArr, stringBuilder, cArr2);
            case 'n':
                zzb(bufferedReader, zzaxM);
                return null;
            default:
                throw new ParseException("Expected string");
        }
    }

    private <T extends FastJsonResponse> ArrayList<T> zza(BufferedReader bufferedReader, Field<?, ?> field) throws ParseException, IOException {
        ArrayList<T> arrayList = new ArrayList();
        char zzk = zzk(bufferedReader);
        switch (zzk) {
            case ']':
                zzdy(5);
                return arrayList;
            case 'n':
                zzb(bufferedReader, zzaxM);
                zzdy(5);
                return null;
            case '{':
                this.zzaxS.push(Integer.valueOf(1));
                while (true) {
                    try {
                        FastJsonResponse newConcreteTypeInstance = field.newConcreteTypeInstance();
                        if (!zzc(bufferedReader, newConcreteTypeInstance)) {
                            return arrayList;
                        }
                        arrayList.add(newConcreteTypeInstance);
                        zzk = zzk(bufferedReader);
                        switch (zzk) {
                            case ',':
                                if (zzk(bufferedReader) != '{') {
                                    throw new ParseException("Expected start of next object in array");
                                }
                                this.zzaxS.push(Integer.valueOf(1));
                            case ']':
                                zzdy(5);
                                return arrayList;
                            default:
                                throw new ParseException("Unexpected token: " + zzk);
                        }
                    } catch (Throwable e) {
                        throw new ParseException("Error instantiating inner object", e);
                    } catch (Throwable e2) {
                        throw new ParseException("Error instantiating inner object", e2);
                    }
                }
            default:
                throw new ParseException("Unexpected token: " + zzk);
        }
    }

    private <O> ArrayList<O> zza(BufferedReader bufferedReader, zza<O> com_google_android_gms_common_server_response_FastParser_zza_O) throws ParseException, IOException {
        char zzk = zzk(bufferedReader);
        if (zzk != 'n') {
            if (zzk == '[') {
                this.zzaxS.push(Integer.valueOf(5));
                ArrayList<O> arrayList = new ArrayList();
                while (true) {
                    bufferedReader.mark(1024);
                    switch (zzk(bufferedReader)) {
                        case '\u0000':
                            throw new ParseException("Unexpected EOF");
                        case ',':
                            break;
                        case ']':
                            zzdy(5);
                            return arrayList;
                        default:
                            bufferedReader.reset();
                            arrayList.add(com_google_android_gms_common_server_response_FastParser_zza_O.zzi(this, bufferedReader));
                            break;
                    }
                }
            }
            throw new ParseException("Expected start of array");
        }
        zzb(bufferedReader, zzaxM);
        return null;
    }

    private void zza(BufferedReader bufferedReader, T t) throws ParseException, IOException {
        char zzk = zzk(bufferedReader);
        switch (zzk) {
            case '\u0000':
                throw new ParseException("No data to parse");
            case '[':
                this.zzaxS.push(Integer.valueOf(5));
                zzb(bufferedReader, (FastJsonResponse) t);
                return;
            case '{':
                this.zzaxS.push(Integer.valueOf(1));
                zzc(bufferedReader, (FastJsonResponse) t);
                return;
            default:
                throw new ParseException("Unexpected token: " + zzk);
        }
    }

    private boolean zza(BufferedReader bufferedReader, boolean z) throws ParseException, IOException {
        char zzk = zzk(bufferedReader);
        switch (zzk) {
            case '\"':
                if (!z) {
                    return zza(bufferedReader, true);
                }
                throw new ParseException("No boolean value found in string");
            case 'f':
                zzb(bufferedReader, z ? zzaxQ : zzaxP);
                return false;
            case 'n':
                zzb(bufferedReader, zzaxM);
                return false;
            case 't':
                zzb(bufferedReader, z ? zzaxO : zzaxN);
                return true;
            default:
                throw new ParseException("Unexpected token: " + zzk);
        }
    }

    private boolean zza(char[] cArr, char c) {
        if (cArr == null) {
            return false;
        }
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    private static long zzb(char[] cArr, int i) throws ParseException {
        long j = 0;
        Object obj = null;
        int i2 = 0;
        if (i > 0) {
            long j2;
            if (cArr[0] == '-') {
                obj = 1;
                j2 = Long.MIN_VALUE;
                i2 = 1;
            } else {
                j2 = -9223372036854775807L;
            }
            long j3 = j2 / 10;
            if (i2 < i) {
                int i3 = i2 + 1;
                i2 = Character.digit(cArr[i2], 10);
                if (i2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                long j4 = (long) (-i2);
                i2 = i3;
                j = j4;
            }
            while (i2 < i) {
                int i4 = i2 + 1;
                i2 = Character.digit(cArr[i2], 10);
                if (i2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (j < j3) {
                    throw new ParseException("Number too large");
                } else {
                    j *= 10;
                    if (j < ((long) i2) + j2) {
                        throw new ParseException("Number too large");
                    }
                    j -= (long) i2;
                    i2 = i4;
                }
            }
            if (obj == null) {
                return -j;
            }
            if (i2 > 1) {
                return j;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    private String zzb(BufferedReader bufferedReader) throws ParseException, IOException {
        char c;
        bufferedReader.mark(1024);
        int i;
        int i2;
        switch (zzk(bufferedReader)) {
            case '\"':
                if (bufferedReader.read(this.zzaxH) != -1) {
                    c = this.zzaxH[0];
                    i = 0;
                    while (true) {
                        if (c == '\"' && i == 0) {
                            break;
                        }
                        i2 = c == '\\' ? i == 0 ? 1 : 0 : 0;
                        if (bufferedReader.read(this.zzaxH) == -1) {
                            throw new ParseException("Unexpected EOF while parsing string");
                        }
                        char c2 = this.zzaxH[0];
                        if (Character.isISOControl(c2)) {
                            throw new ParseException("Unexpected control character while reading string");
                        }
                        char c3 = c2;
                        i = i2;
                        c = c3;
                    }
                } else {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
                break;
            case ',':
                throw new ParseException("Missing value");
            case '[':
                this.zzaxS.push(Integer.valueOf(5));
                bufferedReader.mark(32);
                if (zzk(bufferedReader) != ']') {
                    bufferedReader.reset();
                    i = 1;
                    i2 = 0;
                    int i3 = 0;
                    while (i > 0) {
                        char zzk = zzk(bufferedReader);
                        if (zzk == '\u0000') {
                            throw new ParseException("Unexpected EOF while parsing array");
                        } else if (Character.isISOControl(zzk)) {
                            throw new ParseException("Unexpected control character while reading array");
                        } else {
                            int i4;
                            if (zzk == '\"' && i3 == 0) {
                                i4 = i2 == 0 ? 1 : 0;
                            } else {
                                i4 = i2;
                            }
                            i2 = (zzk == '[' && i4 == 0) ? i + 1 : i;
                            i = (zzk == ']' && i4 == 0) ? i2 - 1 : i2;
                            if (zzk != '\\' || i4 == 0) {
                                i2 = i4;
                                i3 = 0;
                            } else {
                                i3 = i3 == 0 ? 1 : 0;
                                i2 = i4;
                            }
                        }
                    }
                    zzdy(5);
                    break;
                }
                zzdy(5);
                break;
                break;
            case '{':
                this.zzaxS.push(Integer.valueOf(1));
                bufferedReader.mark(32);
                c = zzk(bufferedReader);
                if (c == '}') {
                    zzdy(1);
                    break;
                } else if (c == '\"') {
                    bufferedReader.reset();
                    zza(bufferedReader);
                    do {
                    } while (zzb(bufferedReader) != null);
                    zzdy(1);
                    break;
                } else {
                    throw new ParseException("Unexpected token " + c);
                }
            default:
                bufferedReader.reset();
                zza(bufferedReader, this.zzaxJ);
                break;
        }
        c = zzk(bufferedReader);
        switch (c) {
            case ',':
                zzdy(2);
                return zza(bufferedReader);
            case '}':
                zzdy(2);
                return null;
            default:
                throw new ParseException("Unexpected token " + c);
        }
    }

    private String zzb(BufferedReader bufferedReader, char[] cArr, StringBuilder stringBuilder, char[] cArr2) throws ParseException, IOException {
        int i;
        stringBuilder.setLength(0);
        bufferedReader.mark(cArr.length);
        int i2 = 0;
        int i3 = 0;
        loop0:
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                i = 0;
                while (i < read) {
                    char c = cArr[i];
                    if (!Character.isISOControl(c) || zza(cArr2, c)) {
                        if (c == '\"' && i3 == 0) {
                            break loop0;
                        }
                        if (c == '\\') {
                            i3 = i3 == 0 ? 1 : 0;
                            i2 = 1;
                        } else {
                            i3 = 0;
                        }
                        i++;
                    } else {
                        throw new ParseException("Unexpected control character while reading string");
                    }
                }
                stringBuilder.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
            } else {
                throw new ParseException("Unexpected EOF while parsing string");
            }
        }
        stringBuilder.append(cArr, 0, i);
        bufferedReader.reset();
        bufferedReader.skip((long) (i + 1));
        return i2 != 0 ? zzn.zzcQ(stringBuilder.toString()) : stringBuilder.toString();
    }

    private void zzb(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        Map fieldMappings = fastJsonResponse.getFieldMappings();
        if (fieldMappings.size() != 1) {
            throw new ParseException("Object array response class must have a single Field");
        }
        Field field = (Field) ((Entry) fieldMappings.entrySet().iterator().next()).getValue();
        fastJsonResponse.addConcreteTypeArrayInternal(field, field.getOutputFieldName(), zza(bufferedReader, field));
    }

    private void zzb(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i = 0;
        while (i < cArr.length) {
            int read = bufferedReader.read(this.zzaxI, 0, cArr.length - i);
            if (read == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i2 = 0; i2 < read; i2++) {
                if (cArr[i2 + i] != this.zzaxI[i2]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i += read;
        }
    }

    private String zzc(BufferedReader bufferedReader) throws ParseException, IOException {
        return zza(bufferedReader, this.zzaxI, this.zzaxK, null);
    }

    private boolean zzc(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        Map fieldMappings = fastJsonResponse.getFieldMappings();
        Object zza = zza(bufferedReader);
        if (zza == null) {
            zzdy(1);
            return false;
        }
        while (zza != null) {
            Field field = (Field) fieldMappings.get(zza);
            if (field == null) {
                zza = zzb(bufferedReader);
            } else {
                this.zzaxS.push(Integer.valueOf(4));
                switch (field.getTypeIn()) {
                    case 0:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setInteger(field, zze(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setIntegers(field, zza(bufferedReader, zzaxT));
                        break;
                    case 1:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setBigInteger(field, zzg(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setBigIntegers(field, zza(bufferedReader, zzaxZ));
                        break;
                    case 2:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setLong(field, zzf(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setLongs(field, zza(bufferedReader, zzaxU));
                        break;
                    case 3:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setFloat(field, zzh(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setFloats(field, zza(bufferedReader, zzaxV));
                        break;
                    case 4:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setDouble(field, zzi(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setDoubles(field, zza(bufferedReader, zzaxW));
                        break;
                    case 5:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setBigDecimal(field, zzj(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setBigDecimals(field, zza(bufferedReader, zzaya));
                        break;
                    case 6:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setBoolean(field, zza(bufferedReader, false));
                            break;
                        }
                        fastJsonResponse.setBooleans(field, zza(bufferedReader, zzaxX));
                        break;
                    case 7:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setString(field, zzc(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setStrings(field, zza(bufferedReader, zzaxY));
                        break;
                    case 8:
                        fastJsonResponse.setDecodedBytes(field, zzc.decode(zza(bufferedReader, this.zzaxJ, this.zzaxL, zzaxR)));
                        break;
                    case 9:
                        fastJsonResponse.setDecodedBytes(field, zzc.zzcP(zza(bufferedReader, this.zzaxJ, this.zzaxL, zzaxR)));
                        break;
                    case 10:
                        fastJsonResponse.setStringMap(field, zzd(bufferedReader));
                        break;
                    case 11:
                        char zzk;
                        if (field.isTypeInArray()) {
                            zzk = zzk(bufferedReader);
                            if (zzk != 'n') {
                                this.zzaxS.push(Integer.valueOf(5));
                                if (zzk == '[') {
                                    fastJsonResponse.addConcreteTypeArrayInternal(field, field.getOutputFieldName(), zza(bufferedReader, field));
                                    break;
                                }
                                throw new ParseException("Expected array start");
                            }
                            zzb(bufferedReader, zzaxM);
                            fastJsonResponse.addConcreteTypeArrayInternal(field, field.getOutputFieldName(), null);
                            break;
                        }
                        zzk = zzk(bufferedReader);
                        if (zzk == 'n') {
                            zzb(bufferedReader, zzaxM);
                            fastJsonResponse.addConcreteTypeInternal(field, field.getOutputFieldName(), null);
                            break;
                        }
                        this.zzaxS.push(Integer.valueOf(1));
                        if (zzk != '{') {
                            throw new ParseException("Expected start of object");
                        }
                        try {
                            FastJsonResponse newConcreteTypeInstance = field.newConcreteTypeInstance();
                            zzc(bufferedReader, newConcreteTypeInstance);
                            fastJsonResponse.addConcreteTypeInternal(field, field.getOutputFieldName(), newConcreteTypeInstance);
                            break;
                        } catch (Throwable e) {
                            throw new ParseException("Error instantiating inner object", e);
                        } catch (Throwable e2) {
                            throw new ParseException("Error instantiating inner object", e2);
                        }
                    default:
                        throw new ParseException("Invalid field type " + field.getTypeIn());
                }
                zzdy(4);
                zzdy(2);
                char zzk2 = zzk(bufferedReader);
                switch (zzk2) {
                    case ',':
                        zza = zza(bufferedReader);
                        break;
                    case '}':
                        zza = null;
                        break;
                    default:
                        throw new ParseException("Expected end of object or field separator, but found: " + zzk2);
                }
            }
        }
        zza zzrE = fastJsonResponse.zzrE();
        if (zzrE != null) {
            zzrE.zza(fastJsonResponse);
        }
        zzdy(1);
        return true;
    }

    private HashMap<String, String> zzd(BufferedReader bufferedReader) throws ParseException, IOException {
        char zzk = zzk(bufferedReader);
        if (zzk != 'n') {
            if (zzk == '{') {
                this.zzaxS.push(Integer.valueOf(1));
                HashMap<String, String> hashMap = new HashMap();
                while (true) {
                    switch (zzk(bufferedReader)) {
                        case '\u0000':
                            throw new ParseException("Unexpected EOF");
                        case '\"':
                            String zzb = zzb(bufferedReader, this.zzaxI, this.zzaxK, null);
                            if (zzk(bufferedReader) == ':') {
                                if (zzk(bufferedReader) == '\"') {
                                    hashMap.put(zzb, zzb(bufferedReader, this.zzaxI, this.zzaxK, null));
                                    char zzk2 = zzk(bufferedReader);
                                    if (zzk2 == ',') {
                                        break;
                                    } else if (zzk2 == '}') {
                                        zzdy(1);
                                        return hashMap;
                                    } else {
                                        throw new ParseException("Unexpected character while parsing string map: " + zzk2);
                                    }
                                }
                                throw new ParseException("Expected String value for key " + zzb);
                            }
                            throw new ParseException("No map value found for key " + zzb);
                        case '}':
                            zzdy(1);
                            return hashMap;
                        default:
                            break;
                    }
                }
            }
            throw new ParseException("Expected start of a map object");
        }
        zzb(bufferedReader, zzaxM);
        return null;
    }

    private void zzdy(int i) throws ParseException {
        if (this.zzaxS.isEmpty()) {
            throw new ParseException("Expected state " + i + " but had empty stack");
        }
        int intValue = ((Integer) this.zzaxS.pop()).intValue();
        if (intValue != i) {
            throw new ParseException("Expected state " + i + " but had " + intValue);
        }
    }

    private int zze(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza = zza(bufferedReader, this.zzaxJ);
        return zza == 0 ? 0 : zza(this.zzaxJ, zza);
    }

    private long zzf(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza = zza(bufferedReader, this.zzaxJ);
        return zza == 0 ? 0 : zzb(this.zzaxJ, zza);
    }

    private BigInteger zzg(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza = zza(bufferedReader, this.zzaxJ);
        return zza == 0 ? null : new BigInteger(new String(this.zzaxJ, 0, zza));
    }

    private float zzh(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza = zza(bufferedReader, this.zzaxJ);
        return zza == 0 ? 0.0f : Float.parseFloat(new String(this.zzaxJ, 0, zza));
    }

    private double zzi(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza = zza(bufferedReader, this.zzaxJ);
        return zza == 0 ? 0.0d : Double.parseDouble(new String(this.zzaxJ, 0, zza));
    }

    private BigDecimal zzj(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza = zza(bufferedReader, this.zzaxJ);
        return zza == 0 ? null : new BigDecimal(new String(this.zzaxJ, 0, zza));
    }

    private char zzk(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.zzaxH) == -1) {
            return '\u0000';
        }
        while (Character.isWhitespace(this.zzaxH[0])) {
            if (bufferedReader.read(this.zzaxH) == -1) {
                return '\u0000';
            }
        }
        return this.zzaxH[0];
    }

    public void parse(InputStream is, T response) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is), 1024);
        try {
            this.zzaxS.push(Integer.valueOf(0));
            zza(bufferedReader, (FastJsonResponse) response);
            zzdy(0);
            try {
                bufferedReader.close();
            } catch (IOException e) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
        } catch (Throwable e2) {
            throw new ParseException(e2);
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
        }
    }

    public void parse(String json, T response) throws ParseException {
        InputStream byteArrayInputStream = new ByteArrayInputStream(json.getBytes());
        try {
            parse(byteArrayInputStream, (FastJsonResponse) response);
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                Log.w("FastParser", "Failed to close the input stream while parsing.");
            }
        }
    }
}

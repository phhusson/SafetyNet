package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zzx {
    private static final Pattern zzazr = Pattern.compile("\\\\u[0-9a-fA-F]{4}");

    public static String unescape(String text) {
        if (TextUtils.isEmpty(text)) {
            return text;
        }
        Matcher matcher = zzazr.matcher(text);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            matcher.appendReplacement(stringBuffer, new String(Character.toChars(Integer.parseInt(matcher.group().substring(2), 16))));
        }
        if (stringBuffer == null) {
            return text;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}

package com.google.android.snet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Csv {
    public static final String COMMA = ",";
    public static final String NEWLINE = "\n";

    public static boolean parseLine(BufferedReader reader, List<String> out) throws IOException {
        String text = reader.readLine();
        if (text == null) {
            return false;
        }
        int pos = 0;
        do {
            int comma;
            int length;
            StringBuilder buf = new StringBuilder();
            while (true) {
                comma = text.indexOf(44, pos);
                int quote = text.indexOf(34, pos);
                if (quote != -1 && (comma == -1 || comma >= quote)) {
                    if (pos > 0 && text.charAt(pos - 1) == '\"') {
                        buf.append('\"');
                    }
                    buf.append(text, pos, quote);
                    while (true) {
                        pos = quote + 1;
                        quote = text.indexOf(34, pos);
                        if (quote != -1) {
                            break;
                        }
                        buf.append(text, pos, text.length()).append('\n');
                        text = reader.readLine();
                        if (text == null) {
                            out.add(buf.toString());
                            return true;
                        }
                        quote = -1;
                    }
                    buf.append(text, pos, quote);
                    pos = quote + 1;
                } else if (comma != -1) {
                    length = text.length();
                } else {
                    length = comma;
                }
            }
            if (comma != -1) {
                length = comma;
            } else {
                length = text.length();
            }
            buf.append(text, pos, length);
            out.add(buf.toString());
            pos = comma + 1;
        } while (pos > 0);
        return true;
    }

    private Csv() {
    }
}

package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.ArrayList;

public final class DataBufferUtils {
    private DataBufferUtils() {
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> buffer) {
        ArrayList<T> arrayList = new ArrayList(buffer.getCount());
        try {
            for (E freeze : buffer) {
                arrayList.add(freeze.freeze());
            }
            return arrayList;
        } finally {
            buffer.close();
        }
    }

    public static boolean hasData(DataBuffer<?> buffer) {
        return buffer != null && buffer.getCount() > 0;
    }

    public static boolean hasNextPage(DataBuffer<?> buffer) {
        Bundle zzqt = buffer.zzqt();
        return (zzqt == null || zzqt.getString("next_page_token") == null) ? false : true;
    }

    public static boolean hasPrevPage(DataBuffer<?> buffer) {
        Bundle zzqt = buffer.zzqt();
        return (zzqt == null || zzqt.getString("prev_page_token") == null) ? false : true;
    }
}

package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.AbstractWindowedCursor;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@KeepName
public final class DataHolder implements SafeParcelable {
    public static final DataHolderCreator CREATOR = new DataHolderCreator();
    private static final Builder zzatT = new Builder(new String[0], null) {
        public Builder withRow(ContentValues values) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }

        public Builder withRow(HashMap<String, Object> hashMap) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }
    };
    boolean mClosed;
    private final int mVersionCode;
    private final int zzamh;
    private final String[] zzatL;
    Bundle zzatM;
    private final CursorWindow[] zzatN;
    private final Bundle zzatO;
    int[] zzatP;
    int zzatQ;
    private Object zzatR;
    private boolean zzatS;

    public static class Builder {
        private final String[] zzatL;
        private final ArrayList<HashMap<String, Object>> zzatU;
        private final String zzatV;
        private final HashMap<Object, Integer> zzatW;
        private boolean zzatX;
        private String zzatY;

        private Builder(String[] columns, String uniqueColumn) {
            this.zzatL = (String[]) zzx.zzD(columns);
            this.zzatU = new ArrayList();
            this.zzatV = uniqueColumn;
            this.zzatW = new HashMap();
            this.zzatX = false;
            this.zzatY = null;
        }

        private int zza(HashMap<String, Object> hashMap) {
            if (this.zzatV == null) {
                return -1;
            }
            Object obj = hashMap.get(this.zzatV);
            if (obj == null) {
                return -1;
            }
            Integer num = (Integer) this.zzatW.get(obj);
            if (num != null) {
                return num.intValue();
            }
            this.zzatW.put(obj, Integer.valueOf(this.zzatU.size()));
            return -1;
        }

        private boolean zzcA(String str) {
            com.google.android.gms.common.internal.zzb.zzz(str);
            return this.zzatX && str.equals(this.zzatY);
        }

        private void zzqz() {
            if (this.zzatV != null) {
                this.zzatW.clear();
                int size = this.zzatU.size();
                for (int i = 0; i < size; i++) {
                    Object obj = ((HashMap) this.zzatU.get(i)).get(this.zzatV);
                    if (obj != null) {
                        this.zzatW.put(obj, Integer.valueOf(i));
                    }
                }
            }
        }

        public DataHolder build(int statusCode) {
            return new DataHolder(this, statusCode, null);
        }

        public DataHolder build(int statusCode, Bundle metadata) {
            return new DataHolder(this, statusCode, metadata, -1);
        }

        public DataHolder build(int statusCode, Bundle metadata, int maxResults) {
            return new DataHolder(this, statusCode, metadata, maxResults);
        }

        public boolean containsRowWithValue(String column, Object value) {
            int size = this.zzatU.size();
            for (int i = 0; i < size; i++) {
                if (zzw.equal(((HashMap) this.zzatU.get(i)).get(column), value)) {
                    return true;
                }
            }
            return false;
        }

        public Builder descendingSort(String sortColumn) {
            if (!zzcA(sortColumn)) {
                sort(sortColumn);
                Collections.reverse(this.zzatU);
            }
            return this;
        }

        public int getCount() {
            return this.zzatU.size();
        }

        public void modifyUniqueRowValue(Object uniqueValue, String columnName, Object newValue) {
            if (this.zzatV != null) {
                Integer num = (Integer) this.zzatW.get(uniqueValue);
                if (num != null) {
                    ((HashMap) this.zzatU.get(num.intValue())).put(columnName, newValue);
                }
            }
        }

        public Builder removeRowsWithValue(String column, Object value) {
            for (int size = this.zzatU.size() - 1; size >= 0; size--) {
                if (zzw.equal(((HashMap) this.zzatU.get(size)).get(column), value)) {
                    this.zzatU.remove(size);
                }
            }
            return this;
        }

        public Builder sort(String sortColumn) {
            if (!zzcA(sortColumn)) {
                Collections.sort(this.zzatU, new zza(sortColumn));
                zzqz();
                this.zzatX = true;
                this.zzatY = sortColumn;
            }
            return this;
        }

        public Builder withRow(ContentValues values) {
            com.google.android.gms.common.internal.zzb.zzz(values);
            HashMap hashMap = new HashMap(values.size());
            for (Entry entry : values.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return withRow(hashMap);
        }

        public Builder withRow(HashMap<String, Object> row) {
            com.google.android.gms.common.internal.zzb.zzz(row);
            int zza = zza((HashMap) row);
            if (zza == -1) {
                this.zzatU.add(row);
            } else {
                this.zzatU.remove(zza);
                this.zzatU.add(zza, row);
            }
            this.zzatX = false;
            return this;
        }
    }

    private static final class zza implements Comparator<HashMap<String, Object>> {
        private final String zzatZ;

        zza(String str) {
            this.zzatZ = (String) zzx.zzD(str);
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((HashMap) obj, (HashMap) obj2);
        }

        public int zza(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
            Object zzD = zzx.zzD(hashMap.get(this.zzatZ));
            Object zzD2 = zzx.zzD(hashMap2.get(this.zzatZ));
            if (zzD.equals(zzD2)) {
                return 0;
            }
            if (zzD instanceof Boolean) {
                return ((Boolean) zzD).compareTo((Boolean) zzD2);
            }
            if (zzD instanceof Long) {
                return ((Long) zzD).compareTo((Long) zzD2);
            }
            if (zzD instanceof Integer) {
                return ((Integer) zzD).compareTo((Integer) zzD2);
            }
            if (zzD instanceof String) {
                return ((String) zzD).compareTo((String) zzD2);
            }
            if (zzD instanceof Double) {
                return ((Double) zzD).compareTo((Double) zzD2);
            }
            if (zzD instanceof Float) {
                return ((Float) zzD).compareTo((Float) zzD2);
            }
            throw new IllegalArgumentException("Unknown type for lValue " + zzD);
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int versionCode, String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.zzatS = true;
        this.mVersionCode = versionCode;
        this.zzatL = columns;
        this.zzatN = windows;
        this.zzamh = statusCode;
        this.zzatO = metadata;
    }

    public DataHolder(AbstractWindowedCursor cursor, int statusCode, Bundle metadata) {
        this(cursor.getColumnNames(), zza(cursor), statusCode, metadata);
    }

    private DataHolder(Builder builder, int statusCode, Bundle metadata) {
        this(builder.zzatL, zza(builder, -1), statusCode, metadata);
    }

    private DataHolder(Builder builder, int statusCode, Bundle metadata, int maxResults) {
        this(builder.zzatL, zza(builder, maxResults), statusCode, metadata);
    }

    public DataHolder(String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.zzatS = true;
        this.mVersionCode = 1;
        this.zzatL = (String[]) zzx.zzD(columns);
        this.zzatN = (CursorWindow[]) zzx.zzD(windows);
        this.zzamh = statusCode;
        this.zzatO = metadata;
        validateContents();
    }

    public static Builder builder(String[] columns) {
        return new Builder(columns, null);
    }

    public static Builder builder(String[] columns, String uniqueColumn) {
        zzx.zzD(uniqueColumn);
        return new Builder(columns, uniqueColumn);
    }

    public static DataHolder empty(int statusCode) {
        return empty(statusCode, null);
    }

    public static DataHolder empty(int statusCode, Bundle metadata) {
        return new DataHolder(zzatT, statusCode, metadata);
    }

    private static CursorWindow[] zza(AbstractWindowedCursor abstractWindowedCursor) {
        int i;
        ArrayList arrayList = new ArrayList();
        int count = abstractWindowedCursor.getCount();
        CursorWindow window = abstractWindowedCursor.getWindow();
        if (window == null || window.getStartPosition() != 0) {
            i = 0;
        } else {
            window.acquireReference();
            abstractWindowedCursor.setWindow(null);
            arrayList.add(window);
            i = window.getNumRows();
        }
        while (i < count && abstractWindowedCursor.moveToPosition(i)) {
            CursorWindow window2 = abstractWindowedCursor.getWindow();
            if (window2 != null) {
                window2.acquireReference();
                abstractWindowedCursor.setWindow(null);
            } else {
                try {
                    window2 = new CursorWindow(false);
                    window2.setStartPosition(i);
                    abstractWindowedCursor.fillWindow(i, window2);
                } catch (Throwable th) {
                    abstractWindowedCursor.close();
                }
            }
            if (window2.getNumRows() == 0) {
                break;
            }
            arrayList.add(window2);
            i = window2.getNumRows() + window2.getStartPosition();
        }
        abstractWindowedCursor.close();
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    private static CursorWindow[] zza(Builder builder, int i) {
        int size;
        int i2 = 0;
        if (builder.zzatL.length == 0) {
            return new CursorWindow[0];
        }
        List zzb = (i < 0 || i >= builder.zzatU.size()) ? builder.zzatU : builder.zzatU.subList(0, i);
        int size2 = zzb.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(builder.zzatL.length);
        int i3 = 0;
        int i4 = 0;
        while (i3 < size2) {
            if (!cursorWindow.allocRow()) {
                Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                cursorWindow = new CursorWindow(false);
                cursorWindow.setStartPosition(i3);
                cursorWindow.setNumColumns(builder.zzatL.length);
                arrayList.add(cursorWindow);
                if (!cursorWindow.allocRow()) {
                    Log.e("DataHolder", "Unable to allocate row to hold data.");
                    arrayList.remove(cursorWindow);
                    return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                }
            }
            try {
                int i5;
                int i6;
                CursorWindow cursorWindow2;
                Map map = (Map) zzb.get(i3);
                boolean z = true;
                for (int i7 = 0; i7 < builder.zzatL.length && z; i7++) {
                    String str = builder.zzatL[i7];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow.putNull(i3, i7);
                    } else if (obj instanceof String) {
                        z = cursorWindow.putString((String) obj, i3, i7);
                    } else if (obj instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj).longValue(), i3, i7);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i3, i7);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i7);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj, i3, i7);
                    } else if (obj instanceof Double) {
                        z = cursorWindow.putDouble(((Double) obj).doubleValue(), i3, i7);
                    } else if (obj instanceof Float) {
                        z = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i3, i7);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (z) {
                    i5 = i3;
                    i6 = 0;
                    cursorWindow2 = cursorWindow;
                } else if (i4 != 0) {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(builder.zzatL.length);
                    arrayList.add(cursorWindow3);
                    i5 = i3 - 1;
                    cursorWindow2 = cursorWindow3;
                    i6 = 1;
                }
                i4 = i6;
                cursorWindow = cursorWindow2;
                i3 = i5 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                size = arrayList.size();
                while (i2 < size) {
                    ((CursorWindow) arrayList.get(i2)).close();
                    i2++;
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    private void zzi(String str, int i) {
        if (this.zzatM == null || !this.zzatM.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.zzatQ) {
            throw new CursorIndexOutOfBoundsException(i, this.zzatQ);
        }
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.zzatN) {
                    close.close();
                }
            }
        }
    }

    public void copyToBuffer(String column, int row, int windowIndex, CharArrayBuffer dataOut) {
        zzi(column, row);
        this.zzatN[windowIndex].copyStringToBuffer(row, this.zzatM.getInt(column), dataOut);
    }

    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.zzatS && this.zzatN.length > 0 && !isClosed()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.zzatR == null ? "internal object: " + toString() : this.zzatR.toString()) + ")");
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public boolean getBoolean(String column, int row, int windowIndex) {
        zzi(column, row);
        return Long.valueOf(this.zzatN[windowIndex].getLong(row, this.zzatM.getInt(column))).longValue() == 1;
    }

    public byte[] getByteArray(String column, int row, int windowIndex) {
        zzi(column, row);
        return this.zzatN[windowIndex].getBlob(row, this.zzatM.getInt(column));
    }

    public int getCount() {
        return this.zzatQ;
    }

    public double getDouble(String column, int row, int windowIndex) {
        zzi(column, row);
        return this.zzatN[windowIndex].getDouble(row, this.zzatM.getInt(column));
    }

    public float getFloat(String column, int row, int windowIndex) {
        zzi(column, row);
        return this.zzatN[windowIndex].getFloat(row, this.zzatM.getInt(column));
    }

    public int getInteger(String column, int row, int windowIndex) {
        zzi(column, row);
        return this.zzatN[windowIndex].getInt(row, this.zzatM.getInt(column));
    }

    public long getLong(String column, int row, int windowIndex) {
        zzi(column, row);
        return this.zzatN[windowIndex].getLong(row, this.zzatM.getInt(column));
    }

    public int getStatusCode() {
        return this.zzamh;
    }

    public String getString(String column, int row, int windowIndex) {
        zzi(column, row);
        return this.zzatN[windowIndex].getString(row, this.zzatM.getInt(column));
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasColumn(String column) {
        return this.zzatM.containsKey(column);
    }

    public boolean hasNull(String column, int row, int windowIndex) {
        zzi(column, row);
        return this.zzatN[windowIndex].isNull(row, this.zzatM.getInt(column));
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public void logCursorMetadataForDebugging() {
        Log.d("DataHolder", "*******************************************");
        Log.d("DataHolder", "num cursor windows : " + this.zzatN.length);
        Log.d("DataHolder", "total number of objects in holder: " + this.zzatQ);
        Log.d("DataHolder", "total mumber of windowOffsets: " + this.zzatP.length);
        for (int i = 0; i < this.zzatP.length; i++) {
            Log.d("DataHolder", "offset for window " + i + " : " + this.zzatP[i]);
            Log.d("DataHolder", "num rows for window " + i + " : " + this.zzatN[i].getNumRows());
            Log.d("DataHolder", "start pos for window " + i + " : " + this.zzatN[i].getStartPosition());
        }
        Log.d("DataHolder", "*******************************************");
    }

    public Uri parseUri(String column, int row, int windowIndex) {
        String string = getString(column, row, windowIndex);
        return string == null ? null : Uri.parse(string);
    }

    public void validateContents() {
        int i;
        int i2 = 0;
        this.zzatM = new Bundle();
        for (i = 0; i < this.zzatL.length; i++) {
            this.zzatM.putInt(this.zzatL[i], i);
        }
        this.zzatP = new int[this.zzatN.length];
        i = 0;
        while (i2 < this.zzatN.length) {
            this.zzatP[i2] = i;
            i += this.zzatN[i2].getNumRows() - (i - this.zzatN[i2].getStartPosition());
            i2++;
        }
        this.zzatQ = i;
    }

    public void writeToParcel(Parcel dest, int flags) {
        DataHolderCreator.zza(this, dest, flags);
    }

    public int zzcZ(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.zzatQ;
        zzx.zzad(z);
        while (i2 < this.zzatP.length) {
            if (i < this.zzatP[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.zzatP.length ? i2 - 1 : i2;
    }

    public Bundle zzqt() {
        return this.zzatO;
    }

    String[] zzqx() {
        return this.zzatL;
    }

    CursorWindow[] zzqy() {
        return this.zzatN;
    }

    public void zzx(Object obj) {
        this.zzatR = obj;
    }
}

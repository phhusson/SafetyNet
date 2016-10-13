package com.google.android.gms.common.images;

public final class Size {
    private final int zzoW;
    private final int zzoX;

    public Size(int width, int height) {
        this.zzoW = width;
        this.zzoX = height;
    }

    public static Size parseSize(String string) throws NumberFormatException {
        if (string == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int indexOf = string.indexOf(42);
        if (indexOf < 0) {
            indexOf = string.indexOf(120);
        }
        if (indexOf < 0) {
            throw zzcB(string);
        }
        try {
            return new Size(Integer.parseInt(string.substring(0, indexOf)), Integer.parseInt(string.substring(indexOf + 1)));
        } catch (NumberFormatException e) {
            throw zzcB(string);
        }
    }

    private static NumberFormatException zzcB(String str) {
        throw new NumberFormatException("Invalid Size: \"" + str + "\"");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (!(this.zzoW == size.zzoW && this.zzoX == size.zzoX)) {
            z = false;
        }
        return z;
    }

    public int getHeight() {
        return this.zzoX;
    }

    public int getWidth() {
        return this.zzoW;
    }

    public int hashCode() {
        return this.zzoX ^ ((this.zzoW << 16) | (this.zzoW >>> 16));
    }

    public String toString() {
        return this.zzoW + "x" + this.zzoX;
    }
}

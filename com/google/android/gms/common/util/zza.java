package com.google.android.gms.common.util;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class zza<E> extends AbstractSet<E> {
    private final ArrayMap<E, E> zzazf;

    public zza() {
        this.zzazf = new ArrayMap();
    }

    public zza(int i) {
        this.zzazf = new ArrayMap(i);
    }

    public zza(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    public boolean add(E object) {
        if (this.zzazf.containsKey(object)) {
            return false;
        }
        this.zzazf.put(object, object);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof zza ? zza((zza) collection) : super.addAll(collection);
    }

    public void clear() {
        this.zzazf.clear();
    }

    public boolean contains(Object object) {
        return this.zzazf.containsKey(object);
    }

    public Iterator<E> iterator() {
        return this.zzazf.keySet().iterator();
    }

    public boolean remove(Object object) {
        if (!this.zzazf.containsKey(object)) {
            return false;
        }
        this.zzazf.remove(object);
        return true;
    }

    public int size() {
        return this.zzazf.size();
    }

    public boolean zza(zza<? extends E> com_google_android_gms_common_util_zza__extends_E) {
        int size = size();
        this.zzazf.putAll(com_google_android_gms_common_util_zza__extends_E.zzazf);
        return size() > size;
    }
}

package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver.Observable;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, Observable {
    private HashSet<DataBufferObserver> zzatG = new HashSet();

    public void addObserver(DataBufferObserver observer) {
        this.zzatG.add(observer);
    }

    public void clear() {
        this.zzatG.clear();
    }

    public boolean hasObservers() {
        return !this.zzatG.isEmpty();
    }

    public void onDataChanged() {
        Iterator it = this.zzatG.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataChanged();
        }
    }

    public void onDataRangeChanged(int position, int count) {
        Iterator it = this.zzatG.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeChanged(position, count);
        }
    }

    public void onDataRangeInserted(int position, int count) {
        Iterator it = this.zzatG.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeInserted(position, count);
        }
    }

    public void onDataRangeMoved(int fromPosition, int toPosition, int count) {
        Iterator it = this.zzatG.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeMoved(fromPosition, toPosition, count);
        }
    }

    public void onDataRangeRemoved(int position, int count) {
        Iterator it = this.zzatG.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeRemoved(position, count);
        }
    }

    public void removeObserver(DataBufferObserver observer) {
        this.zzatG.remove(observer);
    }
}

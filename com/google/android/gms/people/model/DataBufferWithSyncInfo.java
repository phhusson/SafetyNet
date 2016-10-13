package com.google.android.gms.people.model;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public abstract class DataBufferWithSyncInfo<T> extends AbstractDataBuffer<T> {
    protected DataBufferWithSyncInfo(DataHolder dataHolder) {
        super(dataHolder);
    }

    public long getLastSuccessfulSyncFinishTimestamp() {
        return this.zzarr.zzqt().getLong("last_successful_sync_finish_timestamp");
    }

    public long getLastSyncFinishTimestamp() {
        return this.zzarr.zzqt().getLong("last_sync_finish_timestamp");
    }

    public long getLastSyncStartTimestamp() {
        return this.zzarr.zzqt().getLong("last_sync_start_timestamp");
    }

    public int getLastSyncStatus() {
        return this.zzarr.zzqt().getInt("last_sync_status");
    }

    public boolean isPeriodicSyncEnabled() {
        return this.zzarr.zzqt().getBoolean("is_periodic_sync_enabled");
    }

    public boolean isTickleSyncEnabled() {
        return this.zzarr.zzqt().getBoolean("is_tickle_sync_enabled");
    }
}

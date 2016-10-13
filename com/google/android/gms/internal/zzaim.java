package com.google.android.gms.internal;

import java.io.IOException;

public class zzaim extends IOException {
    public zzaim(String str) {
        super(str);
    }

    static zzaim zzRL() {
        return new zzaim("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzaim zzRM() {
        return new zzaim("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzaim zzRN() {
        return new zzaim("CodedInputStream encountered a malformed varint.");
    }

    static zzaim zzRO() {
        return new zzaim("Protocol message contained an invalid tag (zero).");
    }

    static zzaim zzRP() {
        return new zzaim("Protocol message end-group tag did not match expected tag.");
    }

    static zzaim zzRQ() {
        return new zzaim("Protocol message tag had invalid wire type.");
    }

    static zzaim zzRR() {
        return new zzaim("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}

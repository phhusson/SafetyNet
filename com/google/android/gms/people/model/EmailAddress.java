package com.google.android.gms.people.model;

import com.google.android.gms.people.internal.zze;

public interface EmailAddress extends Affinities, ValueAndType {
    public static final Iterable<EmailAddress> EMPTY_EMAILS = new zze();

    String getType();

    String getValue();
}

package com.google.android.gms.people.model;

import com.google.android.gms.people.internal.zze;

public interface PhoneNumber extends ValueAndType {
    public static final Iterable<PhoneNumber> EMPTY_PHONES = new zze();

    String getType();

    String getValue();
}

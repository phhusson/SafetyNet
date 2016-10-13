package com.google.android.gms.auth.firstparty.proximity;

import com.google.android.gms.auth.GoogleAuthException;

public class ProximityAuthException extends GoogleAuthException {
    public ProximityAuthException(String msg) {
        super(msg);
    }

    public ProximityAuthException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public ProximityAuthException(Throwable throwable) {
        super(throwable);
    }
}

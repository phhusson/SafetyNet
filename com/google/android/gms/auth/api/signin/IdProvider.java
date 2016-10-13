package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.C0158R;
import com.google.android.gms.auth.api.credentials.IdentityProviders;

public enum IdProvider {
    GOOGLE("google.com", C0158R.string.auth_google_play_services_client_google_display_name, IdentityProviders.GOOGLE),
    FACEBOOK("facebook.com", C0158R.string.auth_google_play_services_client_facebook_display_name, IdentityProviders.FACEBOOK);
    
    private final String mAccountType;
    private final String zzYQ;
    private final int zzYR;

    private IdProvider(String providerId, int displayNameId, String accountType) {
        this.zzYQ = providerId;
        this.zzYR = displayNameId;
        this.mAccountType = accountType;
    }

    public static IdProvider fromProviderId(String providerId) {
        if (providerId != null) {
            for (IdProvider idProvider : values()) {
                if (idProvider.getProviderId().equals(providerId)) {
                    return idProvider;
                }
            }
            Log.w("IdProvider", "Unrecognized providerId: " + providerId);
        }
        return null;
    }

    public CharSequence getDisplayName(Context context) {
        return context.getResources().getString(this.zzYR);
    }

    public String getProviderId() {
        return this.zzYQ;
    }

    public String toString() {
        return this.zzYQ;
    }
}

package com.google.android.gms.common.oob;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import java.io.IOException;

public class SignUp {
    public static final String ACTION_OOB_SIGN_UP = "com.google.android.gms.common.oob.OOB_SIGN_UP";
    public static final String EXTRAS_CALLING_APP_DESCRIPTION = "com.google.android.gms.common.oob.EXTRAS_APP_DESCRIPTION";
    public static final String EXTRAS_CLIENT_CALLING_APP_PACKAGE = "com.google.android.gms.common.oob.EXTRAS_CLIENT_CALLING_APP_PACKAGE";
    public static final String EXTRAS_PROMO_APP_PACKAGE = "com.google.android.gms.common.oob.EXTRAS_PROMO_APP_PACKAGE";
    public static final String EXTRAS_PROMO_APP_TEXT = "com.google.android.gms.common.oob.EXTRAS_PROMO_APP_TEXT";
    public static final String EXTRA_ACCOUNT_NAME = "com.google.android.gms.common.oob.EXTRA_ACCOUNT_NAME";
    public static final String EXTRA_BACK_BUTTON_NAME = "com.google.android.gms.common.oob.EXTRA_BACK_BUTTON_NAME";
    public static final String EXTRA_GPSRC = "com.google.android.gms.plus.GPSRC";
    public static final String EXTRA_OVERRIDE_THEME = "com.google.android.gms.plus.OVERRIDE_THEME";
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = zzj.GOOGLE_PLUS_REQUIRED_FEATURES;
    public static final int THEME_DEFAULT = 0;
    public static final int THEME_FULL = 1;
    public static final int THEME_SETUP_WIZARD = 2;

    private SignUp() {
    }

    public static AccountManagerFuture<Boolean> checkSignUpState(Context context, String accountName, String[] requiredFeatures, AccountManagerCallback<Boolean> callback, Handler handler) {
        int i = 0;
        zzx.zzb(!TextUtils.isEmpty(accountName), (Object) "The accountName is required");
        zzx.zzb(requiredFeatures != null, (Object) "The requiredFeatures parameter is required");
        AccountManager accountManager = AccountManager.get(context);
        Account[] accountsByType = accountManager.getAccountsByType("com.google");
        int length = accountsByType.length;
        int i2 = 0;
        while (i < length) {
            if (accountName.equals(accountsByType[i].name)) {
                i2 = 1;
            }
            i++;
        }
        if (i2 != 0) {
            return accountManager.hasFeatures(new Account(accountName, "com.google"), requiredFeatures, callback, handler);
        }
        throw new IllegalStateException("Given account does not exist on the device");
    }

    public static boolean isSignedUpBlocking(Context context, String accountName, String[] requiredFeatures) throws AuthenticatorException, OperationCanceledException, IOException {
        return ((Boolean) checkSignUpState(context, accountName, requiredFeatures, null, null).getResult()).booleanValue();
    }

    public static Intent newSignUpIntent(String accountName) {
        return newSignUpIntent(accountName, null);
    }

    public static Intent newSignUpIntent(String accountName, String backButtonName) {
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        intent.setAction(ACTION_OOB_SIGN_UP);
        intent.putExtra(EXTRA_ACCOUNT_NAME, accountName);
        intent.putExtra(EXTRA_BACK_BUTTON_NAME, backButtonName);
        return intent;
    }

    public static Intent newSignUpIntent(String accountName, String backButtonName, String iconPackage, String promoText) {
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        intent.setAction(ACTION_OOB_SIGN_UP);
        intent.putExtra(EXTRA_ACCOUNT_NAME, accountName);
        intent.putExtra(EXTRA_BACK_BUTTON_NAME, backButtonName);
        intent.putExtra(EXTRAS_PROMO_APP_PACKAGE, iconPackage);
        intent.putExtra(EXTRAS_PROMO_APP_TEXT, promoText);
        return intent;
    }
}

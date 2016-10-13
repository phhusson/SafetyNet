package com.google.android.gms.common.audience.dialogs;

import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.people.data.AudienceMember;

public final class CircleCreation {
    public static final String ACTION = "com.google.android.gms.plus.audience.ACTION_CIRCLE_CREATION";

    public static class IntentBuilder {
        private final Intent mIntent = new Intent(CircleCreation.ACTION);

        public IntentBuilder(String accountName, String clientApplicationId) {
            setAccountName(accountName);
            setClientApplicationId(clientApplicationId);
        }

        public Intent build() {
            return this.mIntent;
        }

        public IntentBuilder setAccountName(String accountName) {
            if (TextUtils.isEmpty(accountName)) {
                throw new IllegalArgumentException("The account name is required.");
            }
            this.mIntent.putExtra("com.google.android.gms.common.audience.EXTRA_ACCOUNT_NAME", accountName);
            return this;
        }

        public IntentBuilder setClientApplicationId(String clientApplicationId) {
            this.mIntent.putExtra("com.google.android.gms.common.audience.EXTRA_APP_ID", clientApplicationId);
            return this;
        }

        public IntentBuilder setHeaderBackgroundColor(int color) {
            this.mIntent.putExtra("com.google.android.gms.common.audience.EXTRA_HEADER_BACKGROUND_COLOR", color);
            return this;
        }

        public IntentBuilder setHeaderTextColor(int color) {
            this.mIntent.putExtra("com.google.android.gms.common.audience.EXTRA_HEADER_TEXT_COLOR", color);
            return this;
        }

        public IntentBuilder setPageId(String pageId) {
            this.mIntent.putExtra("com.google.android.gms.common.audience.EXTRA_PAGE_ID", pageId);
            return this;
        }

        public IntentBuilder setTargetPerson(AudienceMember targetPerson) {
            if (!TextUtils.isEmpty(targetPerson.getPeopleQualifiedId())) {
                this.mIntent.putExtra("com.google.android.gms.common.audience.EXTRA_TARGET_PERSON", targetPerson);
            }
            return this;
        }
    }

    public static class IntentInterpreter {
        public static String getAccountName(Intent intent) {
            return intent.getStringExtra("com.google.android.gms.common.audience.EXTRA_ACCOUNT_NAME");
        }

        public static String getClientApplicationId(Intent intent) {
            return "" + getClientApplicationIdInt(intent);
        }

        public static int getClientApplicationIdInt(Intent intent) {
            Object stringExtra = intent.getStringExtra("com.google.android.gms.common.audience.EXTRA_APP_ID");
            return TextUtils.isEmpty(stringExtra) ? 80 : Integer.parseInt(stringExtra);
        }

        public static int getHeaderBackgroundColor(Intent intent, int defaultColor) {
            return intent.getIntExtra("com.google.android.gms.common.audience.EXTRA_HEADER_BACKGROUND_COLOR", defaultColor);
        }

        public static int getHeaderTextColor(Intent intent, int defaultColor) {
            return intent.getIntExtra("com.google.android.gms.common.audience.EXTRA_HEADER_TEXT_COLOR", defaultColor);
        }

        public static String getPageId(Intent intent) {
            return intent.getStringExtra("com.google.android.gms.common.audience.EXTRA_PAGE_ID");
        }

        public static AudienceMember getTargetPerson(Intent intent) {
            return (AudienceMember) intent.getParcelableExtra("com.google.android.gms.common.audience.EXTRA_TARGET_PERSON");
        }
    }

    private CircleCreation() {
    }
}

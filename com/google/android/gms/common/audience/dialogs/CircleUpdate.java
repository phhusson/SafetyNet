package com.google.android.gms.common.audience.dialogs;

import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.people.data.AudienceMember;

public final class CircleUpdate {

    public static class IntentBuilder {
        private final Intent mIntent = new Intent("com.google.android.gms.common.acl.ACTION_ONLY_UPDATE");

        public IntentBuilder(String accountName, String clientApplicationId) {
            setAccountName(accountName);
            setClientApplicationId(clientApplicationId);
        }

        public static String getAccountName(Intent intent) {
            return intent.getStringExtra("EXTRA_ACCOUNT_NAME");
        }

        public static String getClientApplicationId(Intent intent) {
            return intent.getStringExtra("EXTRA_CLIENT_APPLICATION_ID");
        }

        public static String getPageId(Intent intent) {
            return intent.getStringExtra("EXTRA_PLUS_PAGE_ID");
        }

        public static String getStartViewNamespace(Intent intent) {
            String stringExtra = intent.getStringExtra("EXTRA_START_VIEW_NAMESPACE");
            return TextUtils.isEmpty(stringExtra) ? "sg" : stringExtra;
        }

        public static int getStartViewTypeNum(Intent intent) {
            return intent.getIntExtra("EXTRA_START_VIEW_TYPE_NUM", 0);
        }

        public static String getTargetCircleId(Intent intent) {
            return intent.getStringExtra("EXTRA_TARGET_CIRCLE_ID");
        }

        public static AudienceMember getUpdatePerson(Intent intent) {
            return (AudienceMember) intent.getParcelableExtra("EXTRA_UPDATE_PERSON");
        }

        public Intent build() {
            return this.mIntent;
        }

        public IntentBuilder setAccountName(String accountName) {
            if (TextUtils.isEmpty(accountName)) {
                throw new IllegalArgumentException("The account name is required.");
            }
            this.mIntent.putExtra("EXTRA_ACCOUNT_NAME", accountName);
            return this;
        }

        public IntentBuilder setClientApplicationId(String clientApplicationId) {
            this.mIntent.putExtra("EXTRA_CLIENT_APPLICATION_ID", clientApplicationId);
            return this;
        }

        public IntentBuilder setPageId(String pageId) {
            this.mIntent.putExtra("EXTRA_PLUS_PAGE_ID", pageId);
            return this;
        }

        public IntentBuilder setStartViewNamespace(String namespace) {
            this.mIntent.putExtra("EXTRA_START_VIEW_NAMESPACE", namespace);
            return this;
        }

        public IntentBuilder setStartViewTypeNum(int typeNum) {
            this.mIntent.putExtra("EXTRA_START_VIEW_TYPE_NUM", typeNum);
            return this;
        }

        public IntentBuilder setTargetCircleId(String targetCircleId) {
            this.mIntent.putExtra("EXTRA_TARGET_CIRCLE_ID", targetCircleId);
            return this;
        }

        public IntentBuilder setUpdatePerson(AudienceMember updatePerson) {
            this.mIntent.putExtra("EXTRA_UPDATE_PERSON", updatePerson);
            return this;
        }
    }

    public static class ResultBuilder {
        private final Intent zzato = new Intent();

        public static String getTargetCircle(Intent result) {
            return result.getStringExtra("EXTRA_TARGET_CIRCLE_ID");
        }

        public static AudienceMember getUpdatePerson(Intent result) {
            return (AudienceMember) result.getParcelableExtra("EXTRA_UPDATE_PERSON");
        }

        public Intent build() {
            return this.zzato;
        }

        public ResultBuilder setTargetCircleId(String targetCircleId) {
            this.zzato.putExtra("EXTRA_TARGET_CIRCLE_ID", targetCircleId);
            return this;
        }

        public ResultBuilder setUpdatePerson(AudienceMember updatePerson) {
            this.zzato.putExtra("EXTRA_UPDATE_PERSON", updatePerson);
            return this;
        }
    }

    private CircleUpdate() {
    }
}

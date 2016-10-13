package com.google.android.snet;

import android.content.Context;
import android.text.TextUtils;
import android.util.EventLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class EventLogger {
    private static final String DO_NOT_LOG_EVENT_LOG_SUBTAG_PREFIX = "do-not-log-";
    private static final int LOG_OPERATION = 1;
    private static final int PACKAGES_OPERATION = 2;
    private static final int SNET_EVENT_LOG_TAG = 1397638484;
    private static final int SNET_OPERATION = 3;
    private static final Set<Integer> SUPPORTED_OPERATIONS = new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)}));
    private static final String TAG = EventLogger.class.getCanonicalName();
    private static final String WATCHDOG_TRACKING_SUBTAG = "do-not-log-execution-checkpoint-tag";
    private final Context mContext;
    private final GBundle mGBundle;
    private final SnetLogger mSnetLogger;
    private Map<Integer, Integer> mTagToOperationMap;
    private int[] mTagsOfInterest;

    static class EventData {
        public List<AppInfo> appInfoList;
        public String data;
        public String subTag;
        public int tag;
        public long timeNanos;

        EventData() {
        }
    }

    static class EventLogInfo {
        List<EventData> eventDataList;
        long firstEventLogTimeNano;

        EventLogInfo() {
        }
    }

    EventLogger(Context context, GBundle gBundle, SnetLogger snetLogger) {
        this.mContext = context;
        this.mGBundle = gBundle;
        this.mSnetLogger = snetLogger;
        String tagsOfInterest = this.mGBundle.getEventLogTags();
        if (!TextUtils.isEmpty(tagsOfInterest)) {
            parseTagsAndSubTagsOfInterest(tagsOfInterest);
        }
    }

    public static void writeSnetEventLog(String subTag, int uid, String data) {
        if (subTag != null && data != null) {
            EventLog.writeEvent(SNET_EVENT_LOG_TAG, new Object[]{subTag, Integer.valueOf(uid), data});
        }
    }

    static void writeExecutionCheckpointTag(String signalTag) {
        writeSnetEventLog(WATCHDOG_TRACKING_SUBTAG, -1, signalTag);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    com.google.android.snet.EventLogger.EventLogInfo getEventLogLogs() {
        /*
        r32 = this;
        r0 = r32;
        r0 = r0.mTagsOfInterest;
        r27 = r0;
        if (r27 == 0) goto L_0x0015;
    L_0x0008:
        r0 = r32;
        r0 = r0.mTagsOfInterest;
        r27 = r0;
        r0 = r27;
        r0 = r0.length;
        r27 = r0;
        if (r27 != 0) goto L_0x0017;
    L_0x0015:
        r11 = 0;
    L_0x0016:
        return r11;
    L_0x0017:
        r12 = new java.util.ArrayList;
        r12.<init>();
        r0 = r32;
        r0 = r0.mTagsOfInterest;	 Catch:{ IOException -> 0x012a }
        r27 = r0;
        r0 = r27;
        android.util.EventLog.readEvents(r0, r12);	 Catch:{ IOException -> 0x012a }
        r4 = new com.google.android.snet.ApplicationInfoUtils;
        r0 = r32;
        r0 = r0.mContext;
        r27 = r0;
        r0 = r32;
        r0 = r0.mGBundle;
        r28 = r0;
        r0 = r27;
        r1 = r28;
        r4.<init>(r0, r1);
        r22 = r4.pidToUidMap();
        r10 = new java.util.ArrayList;
        r10.<init>();
        r23 = new com.google.android.snet.SnetSharedPreferences;
        r0 = r32;
        r0 = r0.mContext;
        r27 = r0;
        r0 = r23;
        r1 = r27;
        r0.<init>(r1);
        r14 = -1;
        r16 = r23.lastEventLogTimestampMs();
        r6 = -1;
        r0 = r32;
        r0 = r0.mContext;
        r27 = r0;
        r18 = r27.getPackageManager();
        r28 = r12.iterator();
    L_0x006a:
        r27 = r28.hasNext();
        if (r27 == 0) goto L_0x01cc;
    L_0x0070:
        r8 = r28.next();
        r8 = (android.util.EventLog.Event) r8;
        r6 = r8.getTimeNanos();
        r30 = -1;
        r27 = (r14 > r30 ? 1 : (r14 == r30 ? 0 : -1));
        if (r27 != 0) goto L_0x0081;
    L_0x0080:
        r14 = r6;
    L_0x0081:
        r27 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1));
        if (r27 <= 0) goto L_0x006a;
    L_0x0085:
        r9 = new com.google.android.snet.EventLogger$EventData;
        r9.<init>();
        r27 = r8.getTag();
        r0 = r27;
        r9.tag = r0;
        r30 = r8.getTimeNanos();
        r0 = r30;
        r9.timeNanos = r0;
        r0 = r32;
        r0 = r0.mTagToOperationMap;
        r27 = r0;
        r29 = r8.getTag();
        r29 = java.lang.Integer.valueOf(r29);
        r0 = r27;
        r1 = r29;
        r27 = r0.get(r1);
        r27 = (java.lang.Integer) r27;
        r13 = r27.intValue();
        r26 = -1;
        switch(r13) {
            case 1: goto L_0x00bc;
            case 2: goto L_0x0139;
            case 3: goto L_0x0150;
            default: goto L_0x00bb;
        };
    L_0x00bb:
        goto L_0x006a;
    L_0x00bc:
        r27 = r8.getData();
        r0 = r27;
        r0 = r0 instanceof java.lang.String;
        r27 = r0;
        if (r27 == 0) goto L_0x00d2;
    L_0x00c8:
        r27 = r8.getData();
        r27 = (java.lang.String) r27;
        r0 = r27;
        r9.data = r0;
    L_0x00d2:
        r21 = r8.getProcessId();
        r27 = java.lang.Integer.valueOf(r21);
        r0 = r22;
        r1 = r27;
        r27 = r0.containsKey(r1);
        if (r27 == 0) goto L_0x00f6;
    L_0x00e4:
        r27 = java.lang.Integer.valueOf(r21);
        r0 = r22;
        r1 = r27;
        r27 = r0.get(r1);
        r27 = (java.lang.Integer) r27;
        r26 = r27.intValue();
    L_0x00f6:
        r27 = -1;
        r0 = r26;
        r1 = r27;
        if (r0 == r1) goto L_0x01c7;
    L_0x00fe:
        r0 = r18;
        r1 = r26;
        r20 = r0.getPackagesForUid(r1);
        if (r20 == 0) goto L_0x01c7;
    L_0x0108:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r0 = r20;
        r0 = r0.length;
        r29 = r0;
        r27 = 0;
    L_0x0114:
        r0 = r27;
        r1 = r29;
        if (r0 >= r1) goto L_0x01bf;
    L_0x011a:
        r19 = r20[r27];
        r0 = r19;
        r2 = r4.appInfo(r0);
        if (r2 == 0) goto L_0x0127;
    L_0x0124:
        r3.add(r2);
    L_0x0127:
        r27 = r27 + 1;
        goto L_0x0114;
    L_0x012a:
        r5 = move-exception;
        r0 = r32;
        r0 = r0.mSnetLogger;
        r27 = r0;
        r0 = r27;
        r0.writeException(r5);
        r11 = 0;
        goto L_0x0016;
    L_0x0139:
        r27 = r8.getData();
        r0 = r27;
        r0 = r0 instanceof java.lang.Integer;
        r27 = r0;
        if (r27 == 0) goto L_0x006a;
    L_0x0145:
        r27 = r8.getData();
        r27 = (java.lang.Integer) r27;
        r26 = r27.intValue();
        goto L_0x00f6;
    L_0x0150:
        r24 = 0;
        r24 = r8.getData();	 Catch:{ ClassCastException -> 0x01b9 }
        r24 = (java.lang.Object[]) r24;	 Catch:{ ClassCastException -> 0x01b9 }
        if (r24 == 0) goto L_0x006a;
    L_0x015a:
        r0 = r24;
        r0 = r0.length;
        r27 = r0;
        r29 = 3;
        r0 = r27;
        r1 = r29;
        if (r0 != r1) goto L_0x006a;
    L_0x0167:
        r27 = 0;
        r27 = r24[r27];
        r0 = r27;
        r0 = r0 instanceof java.lang.String;
        r27 = r0;
        if (r27 == 0) goto L_0x006a;
    L_0x0173:
        r27 = 0;
        r25 = r24[r27];
        r25 = (java.lang.String) r25;
        if (r25 == 0) goto L_0x006a;
    L_0x017b:
        r27 = "do-not-log-";
        r0 = r25;
        r1 = r27;
        r27 = r0.startsWith(r1);
        if (r27 != 0) goto L_0x006a;
    L_0x0187:
        r0 = r25;
        r9.subTag = r0;
        r27 = 1;
        r27 = r24[r27];
        r0 = r27;
        r0 = r0 instanceof java.lang.Integer;
        r27 = r0;
        if (r27 == 0) goto L_0x01bc;
    L_0x0197:
        r27 = 1;
        r27 = r24[r27];
        r27 = (java.lang.Integer) r27;
        r26 = r27.intValue();
    L_0x01a1:
        r27 = 2;
        r27 = r24[r27];
        r0 = r27;
        r0 = r0 instanceof java.lang.String;
        r27 = r0;
        if (r27 == 0) goto L_0x00f6;
    L_0x01ad:
        r27 = 2;
        r27 = r24[r27];
        r27 = (java.lang.String) r27;
        r0 = r27;
        r9.data = r0;
        goto L_0x00f6;
    L_0x01b9:
        r5 = move-exception;
        goto L_0x006a;
    L_0x01bc:
        r26 = -1;
        goto L_0x01a1;
    L_0x01bf:
        r27 = r3.size();
        if (r27 == 0) goto L_0x01c7;
    L_0x01c5:
        r9.appInfoList = r3;
    L_0x01c7:
        r10.add(r9);
        goto L_0x006a;
    L_0x01cc:
        r28 = -1;
        r27 = (r6 > r28 ? 1 : (r6 == r28 ? 0 : -1));
        if (r27 == 0) goto L_0x01d7;
    L_0x01d2:
        r0 = r23;
        r0.saveLastEventLogTimestampMs(r6);
    L_0x01d7:
        r11 = new com.google.android.snet.EventLogger$EventLogInfo;
        r11.<init>();
        r11.firstEventLogTimeNano = r14;
        r11.eventDataList = r10;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.snet.EventLogger.getEventLogLogs():com.google.android.snet.EventLogger$EventLogInfo");
    }

    private void parseTagsAndSubTagsOfInterest(String tagsOfInterestString) {
        String[] tagsOpStringArray = tagsOfInterestString.split(Csv.COMMA);
        this.mTagsOfInterest = new int[tagsOpStringArray.length];
        this.mTagToOperationMap = new HashMap();
        this.mTagToOperationMap.put(Integer.valueOf(SNET_EVENT_LOG_TAG), Integer.valueOf(3));
        for (int i = 0; i < tagsOpStringArray.length; i++) {
            try {
                String[] parts = tagsOpStringArray[i].split(":");
                if (parts.length != 2) {
                    this.mTagsOfInterest[i] = -1;
                } else {
                    String tag = parts[0];
                    int operationInt = Integer.parseInt(parts[1]);
                    if (operationInt == 3) {
                        this.mTagsOfInterest[i] = SNET_EVENT_LOG_TAG;
                    } else if (SUPPORTED_OPERATIONS.contains(Integer.valueOf(operationInt))) {
                        int tagInt = Integer.parseInt(tag);
                        this.mTagsOfInterest[i] = tagInt;
                        if (!this.mTagToOperationMap.containsKey(Integer.valueOf(tagInt))) {
                            this.mTagToOperationMap.put(Integer.valueOf(tagInt), Integer.valueOf(operationInt));
                        }
                    } else {
                        this.mTagsOfInterest[i] = -1;
                    }
                }
            } catch (NumberFormatException e) {
                this.mTagsOfInterest[i] = -1;
            }
        }
    }
}

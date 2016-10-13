package com.google.android.snet;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SnetLogcat {
    private static final int LOG_APP_OPERATION = 1;
    private static final int LOG_APP_USING_INLINED_UID_OPERATION = 2;
    private static final int LOG_LINE_WITH_REGEX = 3;
    private static final int NO_OPERATION = 0;
    private static String SNET_LOGCAT_SCRAPER_MARKER = "snet-mark";
    private static final Set<Integer> SUPPORTED_OPERATIONS = new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)}));
    private static final String TAG = SnetLogcat.class.getCanonicalName();
    private final Context mContext;
    private final GBundle mGBundle;
    private PackageManager mPackageManager;
    private Map<String, SearchSettings> mStringToTagOpMap;

    public static class LogcatInfo {
        public int numLogcatLines;
        public Map<String, List<Value>> results = new HashMap();

        LogcatInfo() {
        }

        void reset() {
            this.results = new HashMap();
        }
    }

    private static class SearchSettings {
        int op;
        Pattern pattern;
        String tag;

        SearchSettings(String regEx, String t, int o) {
            this.tag = t;
            this.op = o;
            if (this.op == 2 || this.op == 3) {
                this.pattern = Pattern.compile(regEx);
            }
        }
    }

    public static class Value {
        public List<AppInfo> appInfoList;
        public String line;
    }

    SnetLogcat(Context context, GBundle gBundle) {
        this.mContext = context;
        this.mGBundle = gBundle;
        String logcatTags = this.mGBundle.getLogcatTags();
        if (!TextUtils.isEmpty(logcatTags)) {
            parseGservicesFlag(logcatTags);
        }
        this.mPackageManager = this.mContext.getPackageManager();
    }

    private void parseGservicesFlag(String gservicesFlag) {
        List<String> tagStringOpList = parseIntoParts(gservicesFlag, ',');
        this.mStringToTagOpMap = new HashMap();
        for (String tagsOpString : tagStringOpList) {
            String tag = null;
            String stringOfInterest = null;
            int operation = 0;
            try {
                List<String> parts = parseIntoParts(tagsOpString, ':');
                if (parts.size() == 3) {
                    tag = ((String) parts.get(0)).trim();
                    stringOfInterest = removeEscapeCharacters((String) parts.get(1));
                    operation = Integer.parseInt((String) parts.get(2));
                    if (!SUPPORTED_OPERATIONS.contains(Integer.valueOf(operation))) {
                        operation = 0;
                    }
                    if (!(TextUtils.isEmpty(tag) || stringOfInterest == null || TextUtils.isEmpty(stringOfInterest.trim()))) {
                        this.mStringToTagOpMap.put(stringOfInterest, new SearchSettings(stringOfInterest, tag, operation));
                    }
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    LogcatInfo scrape() {
        if (this.mStringToTagOpMap == null || this.mStringToTagOpMap.isEmpty()) {
            return null;
        }
        LogcatInfo info = new LogcatInfo();
        try {
            Process process;
            info.numLogcatLines = this.mGBundle.getNumLogcatLines();
            if (info.numLogcatLines <= 0) {
                process = Runtime.getRuntime().exec("logcat -d");
            } else {
                process = Runtime.getRuntime().exec(String.format("logcat -t %d", new Object[]{Integer.valueOf(info.numLogcatLines)}));
            }
            if (process == null) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            ApplicationInfoUtils appInfoUtils = new ApplicationInfoUtils(this.mContext, this.mGBundle);
            while (true) {
                line = bufferedReader.readLine();
                if (line != null) {
                    String processName = getProcessNameFromLogcatLine(line);
                    int pid = -1;
                    int uid = -1;
                    if (TAG.equals(processName) && line.contains(SNET_LOGCAT_SCRAPER_MARKER)) {
                        info.reset();
                    } else {
                        for (Entry<String, SearchSettings> mapEntry : this.mStringToTagOpMap.entrySet()) {
                            String stringOfInterest = (String) mapEntry.getKey();
                            SearchSettings searchSettings = (SearchSettings) mapEntry.getValue();
                            if (searchSettings.tag.equals("*") || (processName != null && processName.equals(searchSettings.tag))) {
                                boolean logLine = false;
                                if (searchSettings.op == 0) {
                                    logLine = line.contains(stringOfInterest);
                                    pid = -1;
                                    uid = -1;
                                } else if (searchSettings.op == 1) {
                                    logLine = line.contains(stringOfInterest);
                                    pid = getPidFromLogcatLine(line);
                                    uid = -1;
                                } else if (searchSettings.op == 2) {
                                    if (searchSettings.pattern != null) {
                                        Matcher matcher = searchSettings.pattern.matcher(line);
                                        logLine = matcher.matches();
                                        pid = -1;
                                        if (logLine) {
                                            try {
                                                uid = Integer.valueOf(matcher.group(1)).intValue();
                                            } catch (IllegalStateException e) {
                                                uid = -1;
                                            } catch (NumberFormatException e2) {
                                                uid = -1;
                                            }
                                        } else {
                                            uid = -1;
                                        }
                                    }
                                } else if (searchSettings.op == 3 && searchSettings.pattern != null) {
                                    logLine = searchSettings.pattern.matcher(line).matches();
                                    pid = -1;
                                    uid = -1;
                                }
                                if (logLine) {
                                    List<Value> valuesList = (List) info.results.get(stringOfInterest);
                                    Value valueToAdd = new Value();
                                    valueToAdd.line = line;
                                    List<AppInfo> appInfoList;
                                    if (uid != -1) {
                                        if (uid >= 10000) {
                                            appInfoList = appInfoUtils.appsForUid(uid);
                                            if (!(appInfoList == null || appInfoList.isEmpty())) {
                                                valueToAdd.appInfoList = appInfoList;
                                            }
                                        }
                                    } else if (pid != -1) {
                                        appInfoList = appInfoUtils.appsForPid(pid);
                                        if (!(appInfoList == null || appInfoList.isEmpty())) {
                                            valueToAdd.appInfoList = appInfoList;
                                        }
                                    }
                                    if (valuesList == null) {
                                        List<Value> list = new ArrayList();
                                        list.add(valueToAdd);
                                        info.results.put(stringOfInterest, list);
                                    } else {
                                        valuesList.add(valueToAdd);
                                    }
                                }
                            }
                        }
                        continue;
                    }
                } else {
                    Log.d(TAG, SNET_LOGCAT_SCRAPER_MARKER);
                    return info;
                }
            }
        } catch (IOException e3) {
            return null;
        }
    }

    private static int getPidFromLogcatLine(String logcatLine) {
        int i = -1;
        try {
            int firstBracket = logcatLine.indexOf("(");
            i = Integer.valueOf(logcatLine.substring(firstBracket + 1, logcatLine.indexOf(")")).trim()).intValue();
        } catch (IndexOutOfBoundsException e) {
        } catch (NumberFormatException e2) {
        }
        return i;
    }

    private static String getProcessNameFromLogcatLine(String logcatLine) {
        try {
            return logcatLine.substring(2, logcatLine.indexOf("(")).trim();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    private static List<String> parseIntoParts(String text, char separator) {
        List<String> parts = new ArrayList();
        int start = 0;
        int numBackslashes = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character == '\\') {
                numBackslashes++;
            } else {
                if (character == separator && numBackslashes % 2 == 0) {
                    parts.add(text.substring(start, i));
                    start = i + 1;
                }
                numBackslashes = 0;
            }
        }
        parts.add(text.substring(start));
        return parts;
    }

    private static String removeEscapeCharacters(String text) {
        return text.replace("\\\\", "\\").replace("\\,", Csv.COMMA).replace("\\:", ":");
    }
}

package com.google.android.snet;

import android.util.Pair;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;

class CaptivePortalDetector {
    private static final String CAPTIVE_PORTAL_TEST_ENDPOINT = "generate_204";
    private static final String CAPTIVE_PORTAL_TEST_HOST = "clients3.google.com";
    private static final String TAG = CaptivePortalDetector.class.getCanonicalName();

    static class Results {
        boolean bodyEmpty;
        String ipAddressUsed;
        int responseCode;
        int userAgentIndex;

        Results() {
        }
    }

    CaptivePortalDetector() {
    }

    static Results captivePortalTest() {
        Results results = new Results();
        try {
            for (InetAddress ipAddress : InetAddress.getAllByName(CAPTIVE_PORTAL_TEST_HOST)) {
                if (ipAddress instanceof Inet4Address) {
                    results.ipAddressUsed = ipAddress.getHostAddress();
                    break;
                }
            }
            if (results.ipAddressUsed == null) {
                return null;
            }
            HttpURLConnection connection = null;
            InputStream inputStream = null;
            Pair<String, Integer> userAgentInfo = NetworkAnalyzer.randomUserAgentFromList(new SecureRandom());
            String userAgent = userAgentInfo.first;
            results.userAgentIndex = ((Integer) userAgentInfo.second).intValue();
            try {
                String str = results.ipAddressUsed;
                String valueOf = String.valueOf(CAPTIVE_PORTAL_TEST_ENDPOINT);
                connection = (HttpURLConnection) new URL(new StringBuilder((String.valueOf(str).length() + 8) + String.valueOf(valueOf).length()).append("http://").append(str).append("/").append(valueOf).toString()).openConnection();
                connection.setRequestProperty("User-Agent", userAgent);
                results.responseCode = connection.getResponseCode();
                inputStream = connection.getInputStream();
                if (inputStream.read() == -1) {
                    results.bodyEmpty = true;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                if (connection == null) {
                    return results;
                }
                connection.disconnect();
                return results;
            } catch (IOException e2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
                if (connection != null) {
                    connection.disconnect();
                }
                return null;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                if (connection != null) {
                    connection.disconnect();
                }
            }
        } catch (UnknownHostException e5) {
            return null;
        }
    }
}

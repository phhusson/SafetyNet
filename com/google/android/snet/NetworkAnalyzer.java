package com.google.android.snet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.people.PeopleConstants.Endpoints;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

class NetworkAnalyzer {
    private static final int ANDROID_HTTP_CLIENT = 2;
    private static final int HTTP_URL_CONNECTION_CLIENT = 1;
    private static final String[] KEY_DNS_ENTRIES = new String[]{"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
    private static final String KEY_HTTP_HEADER_LOCATION = "Location";
    static final String KEY_USER_AGENT = "User-Agent";
    private static final String TAG = NetworkAnalyzer.class.getCanonicalName();
    private static final String[] USER_AGENTS = new String[]{"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.102 Safari/537.36", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_1 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11D201 Safari/9537.53"};
    private final Context mContext;
    private final GBundle mGBundle;
    private final SnetLogger mSnetLogger;

    public static class ConnectionInfo {
        public int activeConnectionType;
        public int availableNetworkTypes;
        public String[] dnsServers;
        public String operatorName;
    }

    public static class RedirectResults {
        public boolean endPointReached;
        public URL lastRequestUrl;

        public RedirectResults(boolean success, URL url) {
            this.endPointReached = success;
            this.lastRequestUrl = url;
        }
    }

    public static class SslRedirectInfo {
        public boolean endPointConnected;
        public String endPointUrl;
        public String host;
        public int httpClientUsed;
        public String[] ipAddressesForEndPointUrl;
        public String redirectHeaderValue;
        public int responseCode;
        public int userAgentUsed;
    }

    private com.google.android.snet.NetworkAnalyzer.RedirectResults getNextRedirectUrl(java.net.URL r13, java.lang.String r14) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:80)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r12 = this;
        r11 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r8 = 0;
        r0 = 0;
        r9 = r13.toString();	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r10 = " ";	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r9 = r9.contains(r10);	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        if (r9 == 0) goto L_0x0016;
    L_0x0010:
        if (r0 == 0) goto L_0x0015;
    L_0x0012:
        r0.close();
    L_0x0015:
        return r8;
    L_0x0016:
        r0 = android.net.http.AndroidHttpClient.newInstance(r14);	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r3 = new org.apache.http.client.methods.HttpGet;	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r9 = r13.toString();	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r3.<init>(r9);	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r4 = r0.execute(r3);	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r6 = r4.getStatusLine();	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        if (r6 != 0) goto L_0x0033;
    L_0x002d:
        if (r0 == 0) goto L_0x0015;
    L_0x002f:
        r0.close();
        goto L_0x0015;
    L_0x0033:
        r5 = r6.getStatusCode();	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r7 = r13;	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        if (r5 == r11) goto L_0x0053;	 Catch:{ IOException -> 0x0064, all -> 0x006b }
    L_0x003a:
        r9 = "Location";	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r2 = r4.getHeaders(r9);	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        if (r2 == 0) goto L_0x0053;	 Catch:{ IOException -> 0x0064, all -> 0x006b }
    L_0x0042:
        r9 = r2.length;	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        if (r9 == 0) goto L_0x0053;	 Catch:{ IOException -> 0x0064, all -> 0x006b }
    L_0x0045:
        r7 = new java.net.URL;	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r9 = r2.length;	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r9 = r9 + -1;	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r9 = r2[r9];	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r9 = r9.getValue();	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        r7.<init>(r9);	 Catch:{ IOException -> 0x0064, all -> 0x006b }
    L_0x0053:
        r9 = new com.google.android.snet.NetworkAnalyzer$RedirectResults;	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        if (r5 != r11) goto L_0x0062;	 Catch:{ IOException -> 0x0064, all -> 0x006b }
    L_0x0057:
        r10 = 1;	 Catch:{ IOException -> 0x0064, all -> 0x006b }
    L_0x0058:
        r9.<init>(r10, r7);	 Catch:{ IOException -> 0x0064, all -> 0x006b }
        if (r0 == 0) goto L_0x0060;
    L_0x005d:
        r0.close();
    L_0x0060:
        r8 = r9;
        goto L_0x0015;
    L_0x0062:
        r10 = 0;
        goto L_0x0058;
    L_0x0064:
        r1 = move-exception;
        if (r0 == 0) goto L_0x0015;
    L_0x0067:
        r0.close();
        goto L_0x0015;
    L_0x006b:
        r8 = move-exception;
        if (r0 == 0) goto L_0x0071;
    L_0x006e:
        r0.close();
    L_0x0071:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.snet.NetworkAnalyzer.getNextRedirectUrl(java.net.URL, java.lang.String):com.google.android.snet.NetworkAnalyzer$RedirectResults");
    }

    NetworkAnalyzer(Context context, SnetLogger snetLogger, GBundle gBundle) {
        this.mContext = context;
        this.mSnetLogger = snetLogger;
        this.mGBundle = gBundle;
    }

    ConnectionInfo connectionInfo() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        ConnectionInfo connectInfo = new ConnectionInfo();
        if (activeNetworkInfo != null) {
            connectInfo.activeConnectionType = activeNetworkInfo.getType();
        }
        if (connectInfo.activeConnectionType == 0) {
            connectInfo.operatorName = ((TelephonyManager) this.mContext.getSystemService("phone")).getNetworkOperatorName();
        }
        int capabilitiesBitField = 0;
        for (NetworkInfo networkInfo : connectivityManager.getAllNetworkInfo()) {
            int type = networkInfo.getType();
            if (type <= 30) {
                capabilitiesBitField |= 1 << type;
            }
        }
        connectInfo.availableNetworkTypes = capabilitiesBitField;
        List<String> dnsServersList = dnsServers();
        if (dnsServersList.size() > 0) {
            connectInfo.dnsServers = (String[]) dnsServersList.toArray(new String[dnsServersList.size()]);
        }
        return connectInfo;
    }

    List<SslRedirectInfo> analyzeSslRedirects() {
        HttpURLConnection urlConnection;
        URL url;
        Throwable th;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return null;
        }
        List<SslRedirectInfo> redirectInfoList = new ArrayList();
        SecureRandom random = new SecureRandom();
        for (String requestAddress : this.mGBundle.getSslRedirectsTestHosts().split(Csv.COMMA)) {
            InputStream inputStream;
            if (!TextUtils.isEmpty(requestAddress)) {
                SslRedirectInfo redirectInfo = new SslRedirectInfo();
                urlConnection = null;
                inputStream = null;
                Pair<String, Integer> userAgentInfo = randomUserAgentFromList(random);
                String userAgent = userAgentInfo.first;
                int userAgentIndex = ((Integer) userAgentInfo.second).intValue();
                try {
                    URL url2 = new URL(requestAddress);
                    try {
                        int redirectClient;
                        URL endPointHost;
                        boolean endPointConnected;
                        urlConnection = (HttpURLConnection) url2.openConnection();
                        urlConnection.setInstanceFollowRedirects(false);
                        urlConnection.setRequestProperty(KEY_USER_AGENT, userAgent);
                        inputStream = urlConnection.getInputStream();
                        int responseCode = urlConnection.getResponseCode();
                        String redirectHeaderValue = urlConnection.getHeaderField(KEY_HTTP_HEADER_LOCATION);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                            }
                        }
                        if (urlConnection != null) {
                            urlConnection.disconnect();
                        }
                        if (random.nextBoolean()) {
                            redirectClient = 1;
                            endPointHost = getUrlRedirect(url2, userAgent);
                            endPointConnected = endPointHost != null;
                        } else {
                            redirectClient = 2;
                            RedirectResults response = getUrlRedirectAndroidHttpClient(url2, userAgent);
                            endPointConnected = response.endPointReached;
                            endPointHost = response.lastRequestUrl;
                        }
                        redirectInfo.host = requestAddress;
                        redirectInfo.httpClientUsed = redirectClient;
                        redirectInfo.userAgentUsed = userAgentIndex;
                        redirectInfo.responseCode = responseCode;
                        redirectInfo.redirectHeaderValue = redirectHeaderValue;
                        if (endPointHost != null) {
                            redirectInfo.endPointUrl = endPointHost.toString();
                        }
                        redirectInfo.endPointConnected = endPointConnected;
                        List<String> ipAddressesList = ipAddresses(endPointHost);
                        if (ipAddressesList != null && ipAddressesList.size() > 0) {
                            redirectInfo.ipAddressesForEndPointUrl = (String[]) ipAddressesList.toArray(new String[ipAddressesList.size()]);
                        }
                        redirectInfoList.add(redirectInfo);
                    } catch (UnknownHostException e2) {
                        url = url2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (urlConnection != null) {
                            urlConnection.disconnect();
                        }
                    } catch (ConnectException e4) {
                        url = url2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (urlConnection != null) {
                            urlConnection.disconnect();
                        }
                    } catch (MalformedURLException e6) {
                        url = url2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (urlConnection != null) {
                            urlConnection.disconnect();
                        }
                    } catch (IOException e8) {
                        url = url2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (urlConnection != null) {
                            urlConnection.disconnect();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        url = url2;
                    }
                } catch (UnknownHostException e10) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                } catch (ConnectException e11) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                } catch (MalformedURLException e12) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                } catch (IOException e13) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
        return redirectInfoList;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e14) {
            }
        }
        if (urlConnection != null) {
            urlConnection.disconnect();
        }
        throw th;
        if (urlConnection != null) {
            urlConnection.disconnect();
        }
        throw th;
    }

    static Pair<String, Integer> randomUserAgentFromList(SecureRandom random) {
        int userAgentIndex = random.nextBoolean() ? 0 : 1;
        return Pair.create(USER_AGENTS[userAgentIndex], Integer.valueOf(userAgentIndex));
    }

    String getGoogleWebPage() {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try {
            connection = (HttpURLConnection) new URL("http://www.google.com").openConnection();
            connection.setRequestProperty(KEY_USER_AGENT, randomUserAgentFromList(new SecureRandom()).first);
            inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder strBuilder = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                strBuilder.append(line);
            }
            String stringBuilder = strBuilder.toString();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            if (connection == null) {
                return stringBuilder;
            }
            connection.disconnect();
            return stringBuilder;
        } catch (MalformedURLException e2) {
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
        } catch (IOException e4) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
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
                } catch (IOException e6) {
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    static List<String> dnsServers() {
        List<String> dnsServersList = new ArrayList();
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod(Endpoints.ENDPOINT_GET, new Class[]{String.class});
            int length = KEY_DNS_ENTRIES.length;
            for (int i = 0; i < length; i++) {
                String value = (String) method.invoke(null, new Object[]{r6[i]});
                if (!TextUtils.isEmpty(value)) {
                    dnsServersList.add(value);
                }
            }
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        } catch (IllegalAccessException e3) {
        } catch (InvocationTargetException e4) {
        }
        return dnsServersList;
    }

    static List<String> ipAddresses(URL url) {
        if (url == null) {
            return null;
        }
        List<String> ipAddressesList = new ArrayList();
        try {
            for (InetAddress ipAddress : InetAddress.getAllByName(url.getHost())) {
                ipAddressesList.add(ipAddress.getHostAddress());
            }
            return ipAddressesList;
        } catch (UnknownHostException e) {
            return null;
        }
    }

    private URL getUrlRedirect(URL requestUrl, String userAgent) {
        if (requestUrl == null) {
            return null;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) requestUrl.openConnection();
            urlConnection.setInstanceFollowRedirects(true);
            urlConnection.setRequestProperty(KEY_USER_AGENT, userAgent);
            inputStream = urlConnection.getInputStream();
            URL url = urlConnection.getURL();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            if (urlConnection == null) {
                return url;
            }
            urlConnection.disconnect();
            return url;
        } catch (UnknownHostException e2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            return null;
        } catch (ConnectException e4) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            return null;
        } catch (MalformedURLException e6) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            return null;
        } catch (IOException e8) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            return null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    RedirectResults getUrlRedirectAndroidHttpClient(URL requestUrl, String userAgent) {
        if (requestUrl == null) {
            return null;
        }
        for (int i = 0; i < 5; i++) {
            RedirectResults response = getNextRedirectUrl(requestUrl, userAgent);
            if (response == null) {
                return new RedirectResults(false, requestUrl);
            }
            if (response.endPointReached) {
                return new RedirectResults(true, response.lastRequestUrl);
            }
            requestUrl = response.lastRequestUrl;
        }
        return new RedirectResults(false, requestUrl);
    }
}

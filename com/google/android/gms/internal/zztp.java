package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class zztp {
    private static final String[] zzbAs = new String[]{"android.provider.ALTERNATE_CONTACTS_STRUCTURE", "android.provider.CONTACTS_STRUCTURE"};
    public String accountType;
    public int iconRes;
    public int titleRes;
    private String zzbAA;
    private String zzbAB;
    private int zzbAC;
    private String zzbAD;
    private String zzbAE;
    private String zzbAF;
    private int zzbAG;
    private String zzbAH;
    private String zzbAI;
    private List<String> zzbAJ;
    private String zzbAK;
    private String zzbAL;
    private String zzbAM;
    private boolean zzbAN;
    public String zzbAt;
    public String zzbAu;
    private ArrayList<zzts> zzbAv;
    private HashMap<String, zzts> zzbAw;
    private final boolean zzbAx;
    private String zzbAy;
    private String zzbAz;
    private boolean zzre;

    private static class zza extends Exception {
        public zza(String str) {
            super(str);
        }

        public zza(String str, Exception exception) {
            super(str, exception);
        }
    }

    public zztp(Context context, String str, boolean z) {
        this(context, str, z, null);
    }

    zztp(android.content.Context r4, java.lang.String r5, boolean r6, android.content.res.XmlResourceParser r7) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r1 = 0;
        r0 = -1;
        r3.<init>();
        r3.accountType = r1;
        r3.zzbAt = r1;
        r3.titleRes = r0;
        r3.iconRes = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r3.zzbAv = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r3.zzbAw = r0;
        r3.zzbAx = r6;
        r3.zzbAu = r5;
        r4.getPackageManager();
        if (r7 != 0) goto L_0x0028;
    L_0x0024:
        r7 = r3.zzr(r4, r5);
    L_0x0028:
        if (r7 == 0) goto L_0x002d;
    L_0x002a:
        r3.zza(r4, r7);	 Catch:{ zza -> 0x0065, all -> 0x0095 }
    L_0x002d:
        if (r7 == 0) goto L_0x0032;
    L_0x002f:
        r7.close();
    L_0x0032:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r3.zzbAJ = r0;
        r0 = r3.zzbAB;
        r1 = "inviteContactActionLabel";
        r0 = zzb(r4, r0, r5, r1);
        r3.zzbAC = r0;
        r0 = r3.zzbAF;
        r1 = "viewGroupActionLabel";
        r0 = zzb(r4, r0, r5, r1);
        r3.zzbAG = r0;
        r0 = r3.zzbAK;
        r1 = "accountTypeLabel";
        r0 = zzb(r4, r0, r5, r1);
        r3.titleRes = r0;
        r0 = r3.zzbAL;
        r1 = "accountTypeIcon";
        r0 = zzb(r4, r0, r5, r1);
        r3.iconRes = r0;
        r0 = 1;
        r3.zzre = r0;
    L_0x0064:
        return;
    L_0x0065:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ zza -> 0x0065, all -> 0x0095 }
        r1.<init>();	 Catch:{ zza -> 0x0065, all -> 0x0095 }
        r2 = "Problem reading XML";	 Catch:{ zza -> 0x0065, all -> 0x0095 }
        r1.append(r2);	 Catch:{ zza -> 0x0065, all -> 0x0095 }
        if (r7 == 0) goto L_0x007e;	 Catch:{ zza -> 0x0065, all -> 0x0095 }
    L_0x0072:
        r2 = " in line ";	 Catch:{ zza -> 0x0065, all -> 0x0095 }
        r1.append(r2);	 Catch:{ zza -> 0x0065, all -> 0x0095 }
        r2 = r7.getLineNumber();	 Catch:{ zza -> 0x0065, all -> 0x0095 }
        r1.append(r2);	 Catch:{ zza -> 0x0065, all -> 0x0095 }
    L_0x007e:
        r2 = " for external package ";	 Catch:{ zza -> 0x0065, all -> 0x0095 }
        r1.append(r2);	 Catch:{ zza -> 0x0065, all -> 0x0095 }
        r1.append(r5);	 Catch:{ zza -> 0x0065, all -> 0x0095 }
        r2 = "ExAccountType";	 Catch:{ zza -> 0x0065, all -> 0x0095 }
        r1 = r1.toString();	 Catch:{ zza -> 0x0065, all -> 0x0095 }
        android.util.Log.e(r2, r1, r0);	 Catch:{ zza -> 0x0065, all -> 0x0095 }
        if (r7 == 0) goto L_0x0064;
    L_0x0091:
        r7.close();
        goto L_0x0064;
    L_0x0095:
        r0 = move-exception;
        if (r7 == 0) goto L_0x009b;
    L_0x0098:
        r7.close();
    L_0x009b:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zztp.<init>(android.content.Context, java.lang.String, boolean, android.content.res.XmlResourceParser):void");
    }

    private zzts zza(zzts com_google_android_gms_internal_zzts) throws zza {
        if (com_google_android_gms_internal_zzts.mimeType == null) {
            throw new zza("null is not a valid mime type");
        } else if (this.zzbAw.get(com_google_android_gms_internal_zzts.mimeType) != null) {
            throw new zza("mime type '" + com_google_android_gms_internal_zzts.mimeType + "' is already registered");
        } else {
            com_google_android_gms_internal_zzts.zzbAu = this.zzbAu;
            this.zzbAv.add(com_google_android_gms_internal_zzts);
            this.zzbAw.put(com_google_android_gms_internal_zzts.mimeType, com_google_android_gms_internal_zzts);
            return com_google_android_gms_internal_zzts;
        }
    }

    private void zza(Context context, XmlPullParser xmlPullParser) throws zza {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            try {
                next = xmlPullParser.next();
                if (next == 2) {
                    break;
                }
            } catch (Exception e) {
                throw new zza("Problem reading XML", e);
            } catch (Exception e2) {
                throw new zza("Problem reading XML", e2);
            }
        } while (next != 1);
        if (next != 2) {
            throw new IllegalStateException("No start tag found");
        }
        String name = xmlPullParser.getName();
        if ("ContactsAccountType".equals(name) || "ContactsSource".equals(name)) {
            int i;
            String attributeName;
            this.zzbAN = true;
            next = xmlPullParser.getAttributeCount();
            for (i = 0; i < next; i++) {
                attributeName = xmlPullParser.getAttributeName(i);
                String attributeValue = xmlPullParser.getAttributeValue(i);
                if (Log.isLoggable("ExAccountType", 3)) {
                    Log.d("ExAccountType", attributeName + "=" + attributeValue);
                }
                if ("editContactActivity".equals(attributeName)) {
                    this.zzbAy = attributeValue;
                } else if ("createContactActivity".equals(attributeName)) {
                    this.zzbAz = attributeValue;
                } else if ("inviteContactActivity".equals(attributeName)) {
                    this.zzbAA = attributeValue;
                } else if ("inviteContactActionLabel".equals(attributeName)) {
                    this.zzbAB = attributeValue;
                } else if ("viewContactNotifyService".equals(attributeName)) {
                    this.zzbAD = attributeValue;
                } else if ("viewGroupActivity".equals(attributeName)) {
                    this.zzbAE = attributeValue;
                } else if ("viewGroupActionLabel".equals(attributeName)) {
                    this.zzbAF = attributeValue;
                } else if ("viewStreamItemActivity".equals(attributeName)) {
                    this.zzbAH = attributeValue;
                } else if ("viewStreamItemPhotoActivity".equals(attributeName)) {
                    this.zzbAI = attributeValue;
                } else if ("dataSet".equals(attributeName)) {
                    this.zzbAt = attributeValue;
                } else if ("extensionPackageNames".equals(attributeName)) {
                    this.zzbAJ.add(attributeValue);
                } else if ("accountType".equals(attributeName)) {
                    this.accountType = attributeValue;
                } else if ("accountTypeLabel".equals(attributeName)) {
                    this.zzbAK = attributeValue;
                } else if ("accountTypeIcon".equals(attributeName)) {
                    this.zzbAL = attributeValue;
                } else if ("readOnly".equals(attributeName)) {
                    this.zzbAM = attributeValue;
                } else {
                    Log.e("ExAccountType", "Unsupported attribute " + attributeName);
                }
            }
            i = xmlPullParser.getDepth();
            while (true) {
                next = xmlPullParser.next();
                if ((next == 3 && xmlPullParser.getDepth() <= i) || next == 1) {
                    return;
                }
                if (next == 2 && xmlPullParser.getDepth() == i + 1) {
                    if ("ContactsDataKind".equals(xmlPullParser.getName())) {
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, new int[]{16842790, 16843426, 16843427});
                        if (obtainStyledAttributes == null) {
                            Log.e("ExAccountType", "Failed to obtain ContactsDataKind styled attributes");
                        } else {
                            attributeName = obtainStyledAttributes.getString(0);
                            if (attributeName == null) {
                                Log.e("ExAccountType", "Failed to obtain mimeType from ContactsDataKind styled attributes");
                            } else {
                                zzts com_google_android_gms_internal_zzts = new zzts();
                                com_google_android_gms_internal_zzts.mimeType = attributeName;
                                attributeName = obtainStyledAttributes.getString(1);
                                if (attributeName != null) {
                                    com_google_android_gms_internal_zzts.zzbAR = attributeName;
                                }
                                attributeName = obtainStyledAttributes.getString(2);
                                if (attributeName != null) {
                                    com_google_android_gms_internal_zzts.zzbAS = attributeName;
                                }
                                obtainStyledAttributes.recycle();
                                zza(com_google_android_gms_internal_zzts);
                            }
                        }
                    }
                }
            }
        } else {
            throw new IllegalStateException("Top level element must be ContactsAccountType, not " + name);
        }
    }

    static int zzb(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.charAt(0) != '@') {
            Log.e("ExAccountType", str3 + " must be a resource name beginning with '@'");
            return -1;
        }
        try {
            int identifier = context.getPackageManager().getResourcesForApplication(str2).getIdentifier(str.substring(1), null, str2);
            if (identifier != 0) {
                return identifier;
            }
            Log.e("ExAccountType", "Unable to load " + str + " from package " + str2);
            return -1;
        } catch (NameNotFoundException e) {
            Log.e("ExAccountType", "Unable to load package " + str2);
            return -1;
        }
    }

    private XmlResourceParser zzr(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(new Intent("android.content.SyncAdapter").setPackage(str), 132);
        if (queryIntentServices != null) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null) {
                    String[] strArr = zzbAs;
                    int length = strArr.length;
                    int i = 0;
                    while (i < length) {
                        XmlResourceParser loadXmlMetaData = serviceInfo.loadXmlMetaData(packageManager, strArr[i]);
                        if (loadXmlMetaData == null) {
                            i++;
                        } else if (!Log.isLoggable("ExAccountType", 3)) {
                            return loadXmlMetaData;
                        } else {
                            Log.d("ExAccountType", String.format("Metadata loaded from: %s, %s, %s", new Object[]{serviceInfo.packageName, serviceInfo.name, r8}));
                            return loadXmlMetaData;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public final boolean isInitialized() {
        return this.zzre;
    }

    public String toString() {
        return String.format("AccountType<accountType=%s, dataSet=%s, resourcePackgeName=%s>", new Object[]{this.accountType, this.zzbAt, this.zzbAu});
    }

    public boolean zzGj() {
        return this.zzbAN;
    }

    public List<String> zzGk() {
        return this.zzbAJ;
    }

    public zzts zzfJ(String str) {
        return (zzts) this.zzbAw.get(str);
    }
}

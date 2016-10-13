package com.google.android.snet;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Os {
    private final Method mAccessMethod;
    private final boolean mApiPresent;
    private final int mIsuid;
    private final Object mLibcoreOsInstance;
    private final Method mLstatMethod;
    private final Method mReadLinkMethod;
    private final Method mSIslnkMethod;
    private final Field mStGidField;
    private final Field mStModeField;
    private final Field mStMtimeField;
    private final Field mStUidField;
    private final int mXOk;

    static class LstatStruct {
        int gid;
        int mode;
        long mtime;
        String seLinuxSecurityContext;
        int uid;

        LstatStruct() {
        }
    }

    static final class OsException extends Exception {
        private static final long serialVersionUID = 1;

        OsException() {
        }

        OsException(Throwable cause) {
            super(cause);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    Os() {
        /*
        r28 = this;
        r28.<init>();
        r8 = 0;
        r9 = 0;
        r13 = 0;
        r12 = 0;
        r2 = 0;
        r17 = 0;
        r16 = 0;
        r19 = 0;
        r18 = 0;
        r21 = 0;
        r14 = 0;
        r3 = 1;
        r11 = "libcore.io";
        r23 = java.lang.String.valueOf(r11);	 Catch:{ ClassNotFoundException -> 0x0158 }
        r24 = ".StructStat";
        r23 = r23.concat(r24);	 Catch:{ ClassNotFoundException -> 0x0158 }
        java.lang.Class.forName(r23);	 Catch:{ ClassNotFoundException -> 0x0158 }
    L_0x0023:
        r23 = java.lang.String.valueOf(r11);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r24 = ".StructStat";
        r23 = r23.concat(r24);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r20 = java.lang.Class.forName(r23);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = java.lang.String.valueOf(r11);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r24 = ".OsConstants";
        r23 = r23.concat(r24);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r10 = java.lang.Class.forName(r23);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = java.lang.String.valueOf(r11);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r24 = ".Os";
        r23 = r23.concat(r24);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r6 = java.lang.Class.forName(r23);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = "libcore.io.Libcore";
        r5 = java.lang.Class.forName(r23);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = "os";
        r0 = r23;
        r7 = r5.getField(r0);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = 0;
        r0 = r23;
        r8 = r7.get(r0);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = "lstat";
        r24 = 1;
        r0 = r24;
        r0 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r24 = r0;
        r25 = 0;
        r26 = java.lang.String.class;
        r24[r25] = r26;	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r0 = r23;
        r1 = r24;
        r9 = r6.getMethod(r0, r1);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = "S_ISLNK";
        r24 = 1;
        r0 = r24;
        r0 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r24 = r0;
        r25 = 0;
        r26 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r24[r25] = r26;	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r0 = r23;
        r1 = r24;
        r13 = r10.getMethod(r0, r1);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = "access";
        r24 = 2;
        r0 = r24;
        r0 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r24 = r0;
        r25 = 0;
        r26 = java.lang.String.class;
        r24[r25] = r26;	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r25 = 1;
        r26 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r24[r25] = r26;	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r0 = r23;
        r1 = r24;
        r2 = r6.getMethod(r0, r1);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = "X_OK";
        r0 = r23;
        r22 = r10.getField(r0);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = 0;
        r21 = r22.getInt(r23);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = "st_mode";
        r0 = r20;
        r1 = r23;
        r17 = r0.getField(r1);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = "st_gid";
        r0 = r20;
        r1 = r23;
        r16 = r0.getField(r1);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = "st_uid";
        r0 = r20;
        r1 = r23;
        r19 = r0.getField(r1);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = "st_mtime";
        r0 = r20;
        r1 = r23;
        r18 = r0.getField(r1);	 Catch:{ NoSuchFieldException -> 0x0191, NoSuchMethodException -> 0x015d, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
    L_0x00e7:
        r23 = "S_ISUID";
        r0 = r23;
        r15 = r10.getField(r0);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
        r23 = 0;
        r0 = r23;
        r14 = r15.getInt(r0);	 Catch:{ NoSuchMethodException -> 0x015d, NoSuchFieldException -> 0x0160, ClassNotFoundException -> 0x0163, IllegalAccessException -> 0x0166, IllegalArgumentException -> 0x0169 }
    L_0x00f7:
        r23 = java.lang.String.valueOf(r11);	 Catch:{ NoSuchMethodException -> 0x016c, ClassNotFoundException -> 0x018f }
        r24 = ".Os";
        r23 = r23.concat(r24);	 Catch:{ NoSuchMethodException -> 0x016c, ClassNotFoundException -> 0x018f }
        r6 = java.lang.Class.forName(r23);	 Catch:{ NoSuchMethodException -> 0x016c, ClassNotFoundException -> 0x018f }
        r23 = "readlink";
        r24 = 1;
        r0 = r24;
        r0 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x016c, ClassNotFoundException -> 0x018f }
        r24 = r0;
        r25 = 0;
        r26 = java.lang.String.class;
        r24[r25] = r26;	 Catch:{ NoSuchMethodException -> 0x016c, ClassNotFoundException -> 0x018f }
        r0 = r23;
        r1 = r24;
        r12 = r6.getMethod(r0, r1);	 Catch:{ NoSuchMethodException -> 0x016c, ClassNotFoundException -> 0x018f }
    L_0x011d:
        r0 = r28;
        r0.mLibcoreOsInstance = r8;
        r0 = r28;
        r0.mLstatMethod = r9;
        r0 = r28;
        r0.mSIslnkMethod = r13;
        r0 = r28;
        r0.mReadLinkMethod = r12;
        r0 = r28;
        r0.mAccessMethod = r2;
        r0 = r17;
        r1 = r28;
        r1.mStModeField = r0;
        r0 = r16;
        r1 = r28;
        r1.mStGidField = r0;
        r0 = r19;
        r1 = r28;
        r1.mStUidField = r0;
        r0 = r18;
        r1 = r28;
        r1.mStMtimeField = r0;
        r0 = r21;
        r1 = r28;
        r1.mXOk = r0;
        r0 = r28;
        r0.mIsuid = r14;
        r0 = r28;
        r0.mApiPresent = r3;
        return;
    L_0x0158:
        r4 = move-exception;
        r11 = "android.system";
        goto L_0x0023;
    L_0x015d:
        r4 = move-exception;
        r3 = 0;
        goto L_0x00f7;
    L_0x0160:
        r4 = move-exception;
        r3 = 0;
        goto L_0x00f7;
    L_0x0163:
        r4 = move-exception;
        r3 = 0;
        goto L_0x00f7;
    L_0x0166:
        r4 = move-exception;
        r3 = 0;
        goto L_0x00f7;
    L_0x0169:
        r4 = move-exception;
        r3 = 0;
        goto L_0x00f7;
    L_0x016c:
        r4 = move-exception;
        r23 = java.io.File.class;
        r24 = "readlink";
        r25 = 1;
        r0 = r25;
        r0 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x018d }
        r25 = r0;
        r26 = 0;
        r27 = java.lang.String.class;
        r25[r26] = r27;	 Catch:{ NoSuchMethodException -> 0x018d }
        r12 = r23.getDeclaredMethod(r24, r25);	 Catch:{ NoSuchMethodException -> 0x018d }
        if (r12 == 0) goto L_0x011d;
    L_0x0185:
        r23 = 1;
        r0 = r23;
        r12.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x018d }
        goto L_0x011d;
    L_0x018d:
        r23 = move-exception;
        goto L_0x011d;
    L_0x018f:
        r23 = move-exception;
        goto L_0x011d;
    L_0x0191:
        r23 = move-exception;
        goto L_0x00e7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.snet.Os.<init>():void");
    }

    boolean apiPresent() {
        return this.mApiPresent;
    }

    boolean isSetuidRoot(File file) throws OsException {
        return isSetuidRoot(getLstatStruct(file));
    }

    boolean isSetuidRoot(LstatStruct lstatStruct) {
        if (lstatStruct == null || (lstatStruct.mode & this.mIsuid) == 0 || lstatStruct.uid != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    com.google.android.snet.Os.LstatStruct getLstatStruct(java.io.File r14) throws com.google.android.snet.Os.OsException {
        /*
        r13 = this;
        r9 = r13.mApiPresent;
        if (r9 != 0) goto L_0x000a;
    L_0x0004:
        r9 = new com.google.android.snet.Os$OsException;
        r9.<init>();
        throw r9;
    L_0x000a:
        r3 = r14.getAbsolutePath();
        r9 = r13.mLstatMethod;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r10 = r13.mLibcoreOsInstance;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r11 = 1;
        r11 = new java.lang.Object[r11];	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r12 = 0;
        r11[r12] = r3;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r8 = r9.invoke(r10, r11);	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r5 = new com.google.android.snet.Os$LstatStruct;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r5.<init>();	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r9 = r13.mStUidField;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r9 = r9.getInt(r8);	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r5.uid = r9;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r9 = r13.mStGidField;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r9 = r9.getInt(r8);	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r5.gid = r9;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r9 = r13.mStModeField;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r9 = r9.getInt(r8);	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r5.mode = r9;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r9 = r13.mStMtimeField;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        if (r9 == 0) goto L_0x0045;
    L_0x003d:
        r9 = r13.mStMtimeField;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r10 = r9.getLong(r8);	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        r5.mtime = r10;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
    L_0x0045:
        r7 = 0;
        r9 = "android.os.SELinux";
        r6 = java.lang.Class.forName(r9);	 Catch:{ NoSuchMethodException -> 0x0087, ClassNotFoundException -> 0x0085, IllegalAccessException -> 0x0083, IllegalArgumentException -> 0x0081, InvocationTargetException -> 0x007a }
        r9 = "getFileContext";
        r10 = 1;
        r10 = new java.lang.Class[r10];	 Catch:{ NoSuchMethodException -> 0x0087, ClassNotFoundException -> 0x0085, IllegalAccessException -> 0x0083, IllegalArgumentException -> 0x0081, InvocationTargetException -> 0x007a }
        r11 = 0;
        r12 = java.lang.String.class;
        r10[r11] = r12;	 Catch:{ NoSuchMethodException -> 0x0087, ClassNotFoundException -> 0x0085, IllegalAccessException -> 0x0083, IllegalArgumentException -> 0x0081, InvocationTargetException -> 0x007a }
        r4 = r6.getMethod(r9, r10);	 Catch:{ NoSuchMethodException -> 0x0087, ClassNotFoundException -> 0x0085, IllegalAccessException -> 0x0083, IllegalArgumentException -> 0x0081, InvocationTargetException -> 0x007a }
        r9 = 0;
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ NoSuchMethodException -> 0x0087, ClassNotFoundException -> 0x0085, IllegalAccessException -> 0x0083, IllegalArgumentException -> 0x0081, InvocationTargetException -> 0x007a }
        r11 = 0;
        r10[r11] = r3;	 Catch:{ NoSuchMethodException -> 0x0087, ClassNotFoundException -> 0x0085, IllegalAccessException -> 0x0083, IllegalArgumentException -> 0x0081, InvocationTargetException -> 0x007a }
        r9 = r4.invoke(r9, r10);	 Catch:{ NoSuchMethodException -> 0x0087, ClassNotFoundException -> 0x0085, IllegalAccessException -> 0x0083, IllegalArgumentException -> 0x0081, InvocationTargetException -> 0x007a }
        r0 = r9;
        r0 = (java.lang.String) r0;	 Catch:{ NoSuchMethodException -> 0x0087, ClassNotFoundException -> 0x0085, IllegalAccessException -> 0x0083, IllegalArgumentException -> 0x0081, InvocationTargetException -> 0x007a }
        r7 = r0;
    L_0x0069:
        r5.seLinuxSecurityContext = r7;	 Catch:{ IllegalAccessException -> 0x006c, IllegalArgumentException -> 0x0073, InvocationTargetException -> 0x007a }
        return r5;
    L_0x006c:
        r2 = move-exception;
        r9 = new com.google.android.snet.Os$OsException;
        r9.<init>(r2);
        throw r9;
    L_0x0073:
        r2 = move-exception;
        r9 = new com.google.android.snet.Os$OsException;
        r9.<init>(r2);
        throw r9;
    L_0x007a:
        r2 = move-exception;
        r9 = new com.google.android.snet.Os$OsException;
        r9.<init>(r2);
        throw r9;
    L_0x0081:
        r9 = move-exception;
        goto L_0x0069;
    L_0x0083:
        r9 = move-exception;
        goto L_0x0069;
    L_0x0085:
        r9 = move-exception;
        goto L_0x0069;
    L_0x0087:
        r9 = move-exception;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.snet.Os.getLstatStruct(java.io.File):com.google.android.snet.Os$LstatStruct");
    }

    boolean isSymlink(File file) throws OsException {
        int filePermissionsCode = getFilePermissionsCode(file);
        try {
            return ((Boolean) this.mSIslnkMethod.invoke(null, new Object[]{Integer.valueOf(filePermissionsCode)})).booleanValue();
        } catch (IllegalAccessException e) {
            throw new OsException(e);
        } catch (IllegalArgumentException e2) {
            throw new OsException(e2);
        } catch (InvocationTargetException e3) {
            throw new OsException(e3);
        }
    }

    String readLink(File file) throws OsException {
        if (!this.mApiPresent || this.mReadLinkMethod == null) {
            throw new OsException();
        }
        String filename = file.getAbsolutePath();
        try {
            return (String) this.mReadLinkMethod.invoke(this.mLibcoreOsInstance, new Object[]{filename});
        } catch (IllegalAccessException e) {
            throw new OsException(e);
        } catch (IllegalArgumentException e2) {
            throw new OsException(e2);
        } catch (InvocationTargetException e3) {
            throw new OsException(e3);
        }
    }

    private int getFilePermissionsCode(File file) throws OsException {
        if (this.mApiPresent) {
            String filename = file.getAbsolutePath();
            try {
                return this.mStModeField.getInt(this.mLstatMethod.invoke(this.mLibcoreOsInstance, new Object[]{filename}));
            } catch (IllegalAccessException e) {
                throw new OsException(e);
            } catch (IllegalArgumentException e2) {
                throw new OsException(e2);
            } catch (InvocationTargetException e3) {
                throw new OsException(e3);
            }
        }
        throw new OsException();
    }

    boolean canExecute(String path) throws OsException {
        if (this.mApiPresent) {
            try {
                return ((Boolean) this.mAccessMethod.invoke(this.mLibcoreOsInstance, new Object[]{path, Integer.valueOf(this.mXOk)})).booleanValue();
            } catch (IllegalAccessException e) {
                throw new OsException(e);
            } catch (IllegalArgumentException e2) {
                throw new OsException(e2);
            } catch (InvocationTargetException e3) {
                throw new OsException(e3);
            }
        }
        throw new OsException();
    }

    long getLastModificationTime(File file) throws OsException {
        if (!this.mApiPresent || this.mLstatMethod == null) {
            throw new OsException();
        }
        String filename = file.getAbsolutePath();
        try {
            return this.mStMtimeField.getLong(this.mLstatMethod.invoke(this.mLibcoreOsInstance, new Object[]{filename}));
        } catch (IllegalAccessException e) {
            throw new OsException(e);
        } catch (IllegalArgumentException e2) {
            throw new OsException(e2);
        } catch (InvocationTargetException e3) {
            throw new OsException(e3);
        }
    }
}

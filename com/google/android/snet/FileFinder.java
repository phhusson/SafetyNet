package com.google.android.snet;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

class FileFinder {
    private static final String TAG = FileFinder.class.getCanonicalName();

    public static class DMVerityCorrection {
        public int errorCorrection;
        public String partitionName;
    }

    static class DMVerityFileFinder {
        private static final String DM_DIRECTORY_PREFIX = "/sys/block/dm-";
        private static final String DM_PARTITION_NAME = "dm/name";
        private static final String ERROR_CORRECTION_FILE = "fec/corrected";
        private static final String ERROR_CORRECTION_SUB_DIRECTORY_NAME = "fec";
        private SnetIdleLogger mSnetIdleLogger;

        DMVerityFileFinder(SnetIdleLogger snetIdleLogger) {
            this.mSnetIdleLogger = snetIdleLogger;
        }

        List<DMVerityCorrection> findCorrectionFiles() {
            List<DMVerityCorrection> recordList = new ArrayList();
            int index = 0;
            while (true) {
                String valueOf = String.valueOf(DM_DIRECTORY_PREFIX);
                File dmDirectory = new File(new StringBuilder(String.valueOf(valueOf).length() + 11).append(valueOf).append(index).toString());
                if (!dmDirectory.exists()) {
                    return recordList;
                }
                if (new File(dmDirectory, ERROR_CORRECTION_SUB_DIRECTORY_NAME).exists()) {
                    File pnFile = new File(dmDirectory, DM_PARTITION_NAME);
                    File recordFile = new File(dmDirectory, ERROR_CORRECTION_FILE);
                    if (pnFile.exists() && recordFile.exists()) {
                        DMVerityCorrection dmVerityCorrection = new DMVerityCorrection();
                        try {
                            dmVerityCorrection.partitionName = Utils.readVirtualFile(pnFile);
                            dmVerityCorrection.errorCorrection = Integer.parseInt(Utils.readVirtualFile(recordFile), 10);
                            recordList.add(dmVerityCorrection);
                        } catch (NumberFormatException e) {
                            this.mSnetIdleLogger.writeException(e);
                        }
                    }
                }
                index++;
            }
        }
    }

    static class DifferingFiles {
        FilesInfo currentFilesInfo;
        FilesInfo previousFilesInfo;

        DifferingFiles() {
        }
    }

    public static class FilesInfo {
        public boolean executable;
        public String filename;
        public long foundAtTimeMs;
        public boolean isSetuidRoot;
        public LstatStruct lstatStruct;
        public boolean present;
        public byte[] sha256;
        public boolean symlink;
        public String symlinkTarget;
    }

    static class SetuidFileFinder {
        private static final Set<String> PATH_BLACK_LIST = new HashSet(Arrays.asList(new String[]{"/dev", "/proc", "/sys", "/system"}));
        private long mCurrentTimeMs;
        private Stack<File> mDirectoriesToSearch;
        private SnetFilesDataStore mFilesDataStore;
        private Os mOs;
        private List<FilesInfo> mSetuidFiles;

        SetuidFileFinder(Context context, Os os, long currentTimeMs) {
            this.mOs = os;
            this.mCurrentTimeMs = currentTimeMs;
            this.mFilesDataStore = new SnetFilesDataStore(context);
        }

        List<FilesInfo> find() {
            if (!this.mOs.apiPresent()) {
                return null;
            }
            this.mSetuidFiles = new ArrayList();
            this.mDirectoriesToSearch = new Stack();
            File[] roots = File.listRoots();
            try {
                this.mFilesDataStore.open();
                this.mFilesDataStore.beginTransaction();
                processFile(roots[0]);
                while (!this.mDirectoriesToSearch.empty()) {
                    File[] files = ((File) this.mDirectoriesToSearch.pop()).listFiles();
                    if (files != null) {
                        for (File file : files) {
                            processFile(file);
                        }
                    }
                }
                this.mFilesDataStore.setTransactionSuccessful();
                List<FilesInfo> systemPartitionFiles = this.mFilesDataStore.getSetuidFiles();
                if (systemPartitionFiles != null) {
                    this.mSetuidFiles.addAll(systemPartitionFiles);
                }
                return this.mSetuidFiles;
            } finally {
                this.mFilesDataStore.endTransaction();
                this.mFilesDataStore.close();
            }
        }

        private void processFile(File file) {
            try {
                if (!this.mOs.isSymlink(file) && !PATH_BLACK_LIST.contains(file.getAbsolutePath())) {
                    if (file.isFile() && this.mOs.isSetuidRoot(file)) {
                        byte[] sha256 = Utils.getSha256(file);
                        FilesInfo filesInfo = new FilesInfo();
                        filesInfo.filename = file.getAbsolutePath();
                        filesInfo.present = true;
                        filesInfo.sha256 = sha256;
                        filesInfo.isSetuidRoot = true;
                        filesInfo.foundAtTimeMs = this.mCurrentTimeMs;
                        try {
                            filesInfo.lstatStruct = this.mOs.getLstatStruct(file);
                        } catch (OsException e) {
                        }
                        this.mSetuidFiles.add(filesInfo);
                        this.mFilesDataStore.putStayOpen(filesInfo);
                    } else if (file.isDirectory()) {
                        this.mDirectoriesToSearch.push(file);
                    }
                }
            } catch (OsException e2) {
            }
        }
    }

    static class SystemPartitionFileFinder {
        private static byte[] defaultSha256;
        Map<String, FilesInfo> mAllFiles = new HashMap();
        private long mCurrentTimeMs;
        List<DifferingFiles> mDifferingFilesList = new ArrayList();
        private SnetFilesDataStore mFilesDataStore;
        private final Os mOs;

        private static class HashTreeDirectoryNode {
            private MessageDigest mDigester;
            private File mFile;
            private int mIndex;
            private File[] mSubFiles;

            HashTreeDirectoryNode(File directory) throws NoSuchAlgorithmException {
                if (directory.isDirectory()) {
                    this.mFile = directory;
                    this.mSubFiles = directory.listFiles();
                    if (this.mSubFiles == null) {
                        this.mSubFiles = new File[0];
                    } else {
                        Arrays.sort(this.mSubFiles);
                    }
                    this.mDigester = MessageDigest.getInstance("SHA-256");
                    return;
                }
                String valueOf = String.valueOf(directory);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 56).append("Directory node constructor expects a directory, but got ").append(valueOf).toString());
            }

            File getFile() {
                return this.mFile;
            }

            File getCurrentSubFile() {
                if (this.mIndex < this.mSubFiles.length) {
                    return this.mSubFiles[this.mIndex];
                }
                return null;
            }

            File getNextSubFile() {
                if (this.mIndex < this.mSubFiles.length) {
                    this.mIndex++;
                }
                if (this.mIndex < this.mSubFiles.length) {
                    return this.mSubFiles[this.mIndex];
                }
                return null;
            }

            void updateHash(byte[] hash, LstatStruct lstatStruct) {
                if (hash != null) {
                    this.mDigester.update(hash);
                    byte[] lstatBlob = SystemPartitionFileFinder.getLstatBlob(lstatStruct);
                    if (lstatBlob != null) {
                        this.mDigester.update(lstatBlob);
                    }
                }
            }

            void updateHash(FilesInfo filesInfo) {
                if (filesInfo.sha256 != null) {
                    this.mDigester.update(filesInfo.sha256);
                    byte[] lstatBlob = SystemPartitionFileFinder.getLstatBlob(filesInfo.lstatStruct);
                    if (lstatBlob != null) {
                        this.mDigester.update(lstatBlob);
                    }
                }
            }

            byte[] getHash() {
                return this.mDigester.digest();
            }
        }

        SystemPartitionFileFinder(Context context, Os os, long currentTimeMs) {
            this.mOs = os;
            this.mCurrentTimeMs = currentTimeMs;
            defaultSha256 = new byte[32];
            Arrays.fill(defaultSha256, (byte) -86);
            this.mFilesDataStore = new SnetFilesDataStore(context);
        }

        Set<FilesInfo> getHashes(String pathsOfInterest, int numRandomFiles) {
            if (!this.mOs.apiPresent()) {
                return null;
            }
            buildHashTree(new File("/system"));
            if (this.mAllFiles.isEmpty()) {
                return null;
            }
            FilesInfo filesInfo;
            Set<FilesInfo> returnedFiles = new HashSet();
            FilesInfo rootFilesInfo = (FilesInfo) this.mAllFiles.get("/system");
            if (rootFilesInfo != null) {
                returnedFiles.add(rootFilesInfo);
            }
            if (pathsOfInterest != null) {
                for (String path : pathsOfInterest.split(Csv.COMMA)) {
                    filesInfo = (FilesInfo) this.mAllFiles.get(path);
                    if (filesInfo != null) {
                        returnedFiles.add(filesInfo);
                    }
                }
            }
            if (numRandomFiles == 0) {
                return returnedFiles;
            }
            Random random = new Random();
            List<String> systemPartitionFiles = new ArrayList(this.mAllFiles.keySet());
            int numFiles = 0;
            for (int i = 0; i < numRandomFiles * 2 && numFiles < numRandomFiles; i++) {
                filesInfo = (FilesInfo) this.mAllFiles.get((String) systemPartitionFiles.get(random.nextInt(this.mAllFiles.size())));
                if (!returnedFiles.contains(filesInfo)) {
                    returnedFiles.add(filesInfo);
                    numFiles++;
                }
            }
            return returnedFiles;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void buildHashTree(java.io.File r13) {
            /*
            r12 = this;
            r7 = new java.util.Stack;
            r7.<init>();
            r10 = r12.mFilesDataStore;	 Catch:{ all -> 0x0137 }
            r10.open();	 Catch:{ all -> 0x0137 }
            r10 = r12.mFilesDataStore;	 Catch:{ all -> 0x0137 }
            r10.beginTransaction();	 Catch:{ all -> 0x0137 }
            r5 = r13;
        L_0x0010:
            r10 = r12.mOs;	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r10 = r10.isSymlink(r5);	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            if (r10 == 0) goto L_0x0046;
        L_0x0018:
            r10 = r12.mOs;	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r3 = r10.getLstatStruct(r5);	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r10 = r12.hashSymlink(r5);	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r11 = 1;
            r12.updateFilesInfo(r5, r10, r3, r11);	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r10 = r12.mOs;	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r9 = r10.readLink(r5);	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r13 = new java.io.File;	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r13.<init>(r9);	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r10 = r12.mAllFiles;	 Catch:{ NoSuchAlgorithmException -> 0x0144, OsException -> 0x0141 }
            r10 = r10.containsKey(r9);	 Catch:{ NoSuchAlgorithmException -> 0x0144, OsException -> 0x0141 }
            if (r10 == 0) goto L_0x0044;
        L_0x0039:
            r10 = r12.mFilesDataStore;
            r10.endTransaction();
            r10 = r12.mFilesDataStore;
            r10.close();
        L_0x0043:
            return;
        L_0x0044:
            r5 = r13;
            goto L_0x0010;
        L_0x0046:
            r10 = r5.isDirectory();	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            if (r10 == 0) goto L_0x008d;
        L_0x004c:
            r10 = new com.google.android.snet.FileFinder$SystemPartitionFileFinder$HashTreeDirectoryNode;	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r10.<init>(r5);	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r7.push(r10);	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
        L_0x0054:
            r10 = r7.isEmpty();	 Catch:{ all -> 0x0080 }
            if (r10 != 0) goto L_0x0125;
        L_0x005a:
            r4 = r7.peek();	 Catch:{ all -> 0x0080 }
            r4 = (com.google.android.snet.FileFinder.SystemPartitionFileFinder.HashTreeDirectoryNode) r4;	 Catch:{ all -> 0x0080 }
            r0 = r4.getCurrentSubFile();	 Catch:{ all -> 0x0080 }
            if (r0 != 0) goto L_0x00bb;
        L_0x0066:
            r2 = r4.getHash();	 Catch:{ all -> 0x0080 }
            r3 = 0;
            r10 = r12.mOs;	 Catch:{ OsException -> 0x013e }
            r11 = r4.getFile();	 Catch:{ OsException -> 0x013e }
            r3 = r10.getLstatStruct(r11);	 Catch:{ OsException -> 0x013e }
        L_0x0075:
            r10 = r4.getFile();	 Catch:{ all -> 0x0080 }
            r12.updateFilesInfo(r10, r2, r3);	 Catch:{ all -> 0x0080 }
            r7.pop();	 Catch:{ all -> 0x0080 }
            goto L_0x0054;
        L_0x0080:
            r10 = move-exception;
            r13 = r5;
        L_0x0082:
            r11 = r12.mFilesDataStore;
            r11.endTransaction();
            r11 = r12.mFilesDataStore;
            r11.close();
            throw r10;
        L_0x008d:
            r10 = r5.isFile();	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            if (r10 == 0) goto L_0x0010;
        L_0x0093:
            r10 = r12.mOs;	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r3 = r10.getLstatStruct(r5);	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r10 = r12.hashFile(r5);	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            r12.updateFilesInfo(r5, r10, r3);	 Catch:{ NoSuchAlgorithmException -> 0x00a1, OsException -> 0x00ae }
            goto L_0x0054;
        L_0x00a1:
            r1 = move-exception;
            r13 = r5;
        L_0x00a3:
            r10 = r12.mFilesDataStore;
            r10.endTransaction();
            r10 = r12.mFilesDataStore;
            r10.close();
            goto L_0x0043;
        L_0x00ae:
            r1 = move-exception;
            r13 = r5;
        L_0x00b0:
            r10 = r12.mFilesDataStore;
            r10.endTransaction();
            r10 = r12.mFilesDataStore;
            r10.close();
            goto L_0x0043;
        L_0x00bb:
            r10 = r12.mOs;	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            r10 = r10.isSymlink(r0);	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            if (r10 == 0) goto L_0x00dd;
        L_0x00c3:
            r8 = r12.hashSymlink(r0);	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            r3 = 0;
            r10 = r12.mOs;	 Catch:{ OsException -> 0x013c, NoSuchAlgorithmException -> 0x00ff }
            r3 = r10.getLstatStruct(r0);	 Catch:{ OsException -> 0x013c, NoSuchAlgorithmException -> 0x00ff }
        L_0x00ce:
            r10 = 1;
            r12.updateFilesInfo(r0, r8, r3, r10);	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            r4.updateHash(r8, r3);	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
        L_0x00d5:
            r0 = r4.getNextSubFile();	 Catch:{ all -> 0x0080 }
            if (r0 != 0) goto L_0x00bb;
        L_0x00db:
            goto L_0x0054;
        L_0x00dd:
            r10 = r0.isDirectory();	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            if (r10 == 0) goto L_0x010d;
        L_0x00e3:
            r10 = r12.mAllFiles;	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            r11 = r0.getAbsolutePath();	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            r10 = r10.containsKey(r11);	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            if (r10 == 0) goto L_0x0101;
        L_0x00ef:
            r10 = r12.mAllFiles;	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            r11 = r0.getAbsolutePath();	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            r6 = r10.get(r11);	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            r6 = (com.google.android.snet.FileFinder.FilesInfo) r6;	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            r4.updateHash(r6);	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            goto L_0x00d5;
        L_0x00ff:
            r1 = move-exception;
            goto L_0x00d5;
        L_0x0101:
            r10 = new com.google.android.snet.FileFinder$SystemPartitionFileFinder$HashTreeDirectoryNode;	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            r10.<init>(r0);	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            r7.push(r10);	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            goto L_0x0054;
        L_0x010b:
            r1 = move-exception;
            goto L_0x00d5;
        L_0x010d:
            r10 = r0.isFile();	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            if (r10 == 0) goto L_0x00d5;
        L_0x0113:
            r2 = r12.hashFile(r0);	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            r3 = 0;
            r10 = r12.mOs;	 Catch:{ OsException -> 0x013a, NoSuchAlgorithmException -> 0x00ff }
            r3 = r10.getLstatStruct(r0);	 Catch:{ OsException -> 0x013a, NoSuchAlgorithmException -> 0x00ff }
        L_0x011e:
            r12.updateFilesInfo(r0, r2, r3);	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            r4.updateHash(r2, r3);	 Catch:{ NoSuchAlgorithmException -> 0x00ff, OsException -> 0x010b }
            goto L_0x00d5;
        L_0x0125:
            r10 = r12.mFilesDataStore;	 Catch:{ all -> 0x0080 }
            r10.setTransactionSuccessful();	 Catch:{ all -> 0x0080 }
            r10 = r12.mFilesDataStore;
            r10.endTransaction();
            r10 = r12.mFilesDataStore;
            r10.close();
            r13 = r5;
            goto L_0x0043;
        L_0x0137:
            r10 = move-exception;
            goto L_0x0082;
        L_0x013a:
            r10 = move-exception;
            goto L_0x011e;
        L_0x013c:
            r10 = move-exception;
            goto L_0x00ce;
        L_0x013e:
            r10 = move-exception;
            goto L_0x0075;
        L_0x0141:
            r1 = move-exception;
            goto L_0x00b0;
        L_0x0144:
            r1 = move-exception;
            goto L_0x00a3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.snet.FileFinder.SystemPartitionFileFinder.buildHashTree(java.io.File):void");
        }

        private byte[] hashFile(File file) {
            return Utils.getSha256(file);
        }

        private byte[] hashSymlink(File file) {
            try {
                String target = this.mOs.readLink(file);
                if (target == null) {
                    return defaultSha256;
                }
                byte[] hash = MessageDigest.getInstance("SHA-256").digest(target.getBytes("UTF-8"));
                if (hash == null) {
                    return defaultSha256;
                }
                return hash;
            } catch (NoSuchAlgorithmException e) {
                return defaultSha256;
            } catch (UnsupportedEncodingException e2) {
                return defaultSha256;
            } catch (OsException e3) {
                return defaultSha256;
            }
        }

        static byte[] getLstatBlob(LstatStruct lstatStruct) {
            if (lstatStruct == null) {
                return null;
            }
            int numBytes = 12;
            byte[] seLinuxBytes = null;
            if (lstatStruct.seLinuxSecurityContext != null) {
                try {
                    seLinuxBytes = lstatStruct.seLinuxSecurityContext.getBytes("UTF-8");
                    numBytes = 12 + seLinuxBytes.length;
                } catch (UnsupportedEncodingException e) {
                }
            }
            ByteBuffer byteBuffer = ByteBuffer.allocate(numBytes);
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
            byteBuffer.putInt(lstatStruct.mode);
            byteBuffer.putInt(lstatStruct.uid);
            byteBuffer.putInt(lstatStruct.gid);
            if (seLinuxBytes != null) {
                byteBuffer.put(seLinuxBytes);
            }
            return byteBuffer.array();
        }

        private void updateFilesInfo(File file, byte[] hash, LstatStruct lstatStruct) {
            updateFilesInfo(file, hash, lstatStruct, false);
        }

        private void updateFilesInfo(File file, byte[] hash, LstatStruct lstatStruct, boolean isSymlink) {
            FilesInfo filesInfo = new FilesInfo();
            filesInfo.filename = file.getAbsolutePath();
            filesInfo.foundAtTimeMs = this.mCurrentTimeMs;
            filesInfo.lstatStruct = lstatStruct;
            filesInfo.present = true;
            filesInfo.sha256 = hash;
            if (lstatStruct != null) {
                filesInfo.isSetuidRoot = this.mOs.isSetuidRoot(lstatStruct);
            }
            if (isSymlink) {
                filesInfo.symlink = true;
                try {
                    filesInfo.symlinkTarget = this.mOs.readLink(file);
                } catch (OsException e) {
                }
            }
            this.mAllFiles.put(filesInfo.filename, filesInfo);
            FilesInfo previousInfo = this.mFilesDataStore.getStayOpen(filesInfo.filename);
            if (!(previousInfo == null || previousInfo.foundAtTimeMs == filesInfo.foundAtTimeMs || Arrays.equals(previousInfo.sha256, filesInfo.sha256))) {
                DifferingFiles differingFiles = new DifferingFiles();
                differingFiles.previousFilesInfo = previousInfo;
                differingFiles.currentFilesInfo = filesInfo;
                this.mDifferingFilesList.add(differingFiles);
            }
            this.mFilesDataStore.putStayOpen(filesInfo);
        }
    }

    FileFinder() {
    }

    static List<FilesInfo> findFiles(List<String> filePaths) {
        List<FilesInfo> filesInfoList = new ArrayList();
        Os os = new Os();
        LinkedList<String> list = new LinkedList(filePaths);
        while (!list.isEmpty()) {
            String name = (String) list.poll();
            File file = new File(name);
            if (file.exists() && file.isFile()) {
                FilesInfo fileInfo = new FilesInfo();
                fileInfo.filename = name;
                fileInfo.present = file.exists();
                fileInfo.sha256 = Utils.getSha256(file);
                try {
                    fileInfo.executable = os.canExecute(name);
                } catch (OsException e) {
                }
                try {
                    fileInfo.lstatStruct = os.getLstatStruct(file);
                    fileInfo.symlink = os.isSymlink(file);
                    if (fileInfo.symlink) {
                        fileInfo.symlinkTarget = os.readLink(file);
                        if (!(TextUtils.isEmpty(fileInfo.symlinkTarget) || filePaths.contains(fileInfo.symlinkTarget))) {
                            filePaths.add(fileInfo.symlinkTarget);
                            list.offer(fileInfo.symlinkTarget);
                        }
                    }
                } catch (OsException e2) {
                }
                filesInfoList.add(fileInfo);
            }
        }
        return filesInfoList;
    }
}

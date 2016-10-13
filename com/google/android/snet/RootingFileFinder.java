package com.google.android.snet;

import android.text.TextUtils;
import com.google.android.snet.FileFinder.FilesInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RootingFileFinder {
    private static final boolean DEBUG = false;
    private static final String[] FILE_DIRECTORIES = new String[]{"/system/bin", "/system/xbin"};
    private static final String[] FILE_NAMES = new String[]{"su"};
    private static final String LOOP_MOUNT_SOURCE_PREFIX = "/dev/block/loop";
    private static final String MOUNT_INFO = "/proc/self/mountinfo";
    private static final String[] RELATIVE_FILE_DIRECTORIES = new String[]{"/bin", "/xbin"};
    private static final String TAG = RootingFileFinder.class.getCanonicalName();

    static List<FilesInfo> findRootingFiles() {
        List<FilesInfo> filesInfoList = new ArrayList();
        Os os = new Os();
        Set<String> filePaths = getAbsoluteFilePaths(concat(getInterestedDirectories(), getSystemLessRootingDirectories()), FILE_NAMES);
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

    private static Set<String> getAbsoluteFilePaths(String[] fileDirectories, String[] fileNames) {
        Set<String> filePaths = new HashSet();
        if (!(fileDirectories == null || fileNames == null)) {
            for (String directory : fileDirectories) {
                for (String file : fileNames) {
                    filePaths.add(String.format("%s/%s", new Object[]{directory, file}));
                }
            }
        }
        return filePaths;
    }

    private static String[] getInterestedDirectories() {
        String[] envPaths = null;
        String value = System.getenv("PATH");
        if (!TextUtils.isEmpty(value)) {
            envPaths = value.split(":");
        }
        if (envPaths == null || envPaths.length == 0) {
            return FILE_DIRECTORIES;
        }
        String[] paths = (String[]) Arrays.copyOf(FILE_DIRECTORIES, FILE_DIRECTORIES.length + envPaths.length);
        System.arraycopy(envPaths, 0, paths, FILE_DIRECTORIES.length, envPaths.length);
        return paths;
    }

    private static String[] getSystemLessRootingDirectories() {
        Throwable th;
        File mountInfoFile = new File(MOUNT_INFO);
        List<String> mountPoints = new ArrayList();
        if (mountInfoFile.exists()) {
            BufferedReader reader = null;
            try {
                BufferedReader reader2 = new BufferedReader(new FileReader(mountInfoFile));
                while (true) {
                    try {
                        String line = reader2.readLine();
                        if (line == null) {
                            break;
                        }
                        String[] mount = line.split("\\s+");
                        if (mount.length >= 10 && !TextUtils.isEmpty(mount[9]) && mount[9].startsWith(LOOP_MOUNT_SOURCE_PREFIX) && !TextUtils.isEmpty(mount[4])) {
                            mountPoints.add(mount[4]);
                        }
                    } catch (IOException e) {
                        reader = reader2;
                    } catch (Throwable th2) {
                        th = th2;
                        reader = reader2;
                    }
                }
                if (reader2 != null) {
                    try {
                        reader2.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (IOException e3) {
                if (reader == null) {
                    return null;
                }
                try {
                    reader.close();
                    return null;
                } catch (IOException e4) {
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        }
        if (mountPoints.size() <= 0) {
            return null;
        }
        List<String> rootingDirectories = new ArrayList();
        for (String path : mountPoints) {
            if (new File(path).isDirectory()) {
                for (String relativeDirectory : RELATIVE_FILE_DIRECTORIES) {
                    String valueOf = String.valueOf(path);
                    String valueOf2 = String.valueOf(relativeDirectory);
                    rootingDirectories.add(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                }
            }
        }
        return (String[]) rootingDirectories.toArray(new String[0]);
    }

    static String[] concat(String[] first, String[] second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        String[] result = (String[]) Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}

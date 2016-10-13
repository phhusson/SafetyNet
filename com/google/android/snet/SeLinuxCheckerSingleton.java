package com.google.android.snet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public enum SeLinuxCheckerSingleton {
    INSTANCE;
    
    private static final String ENFORCING_FILE_NAME = "/sys/fs/selinux/enforce";
    private static final String SE_LINUX_POLICY_FILE_NAME = "/sepolicy";
    private static final String SE_LINUX_VERSION_FILE_NAME = "/selinux_version";
    private final File mEnforcingFile;

    public static final class SeLinuxInfo {
        public boolean enforcing;
        public boolean present;
        public byte[] selinuxPolicyHash;
        public String selinuxVersion;
    }

    static SeLinuxInfo getInfo() {
        SeLinuxInfo info = new SeLinuxInfo();
        info.present = INSTANCE.isPresent();
        info.enforcing = INSTANCE.isEnforcing();
        info.selinuxVersion = INSTANCE.getVersion();
        info.selinuxPolicyHash = INSTANCE.getPolicyHash();
        return info;
    }

    boolean isPresent() {
        return this.mEnforcingFile.exists();
    }

    boolean isEnforcing() {
        Throwable th;
        boolean z = false;
        if (isPresent()) {
            InputStreamReader reader = null;
            try {
                InputStreamReader reader2 = new InputStreamReader(new FileInputStream(this.mEnforcingFile));
                try {
                    if (((char) reader2.read()) == '1') {
                        z = true;
                        if (reader2 != null) {
                            try {
                                reader2.close();
                            } catch (IOException e) {
                            }
                        }
                    } else if (reader2 != null) {
                        try {
                            reader2.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (FileNotFoundException e3) {
                    reader = reader2;
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e4) {
                        }
                    }
                    return z;
                } catch (IOException e5) {
                    reader = reader2;
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e6) {
                        }
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    reader = reader2;
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e7) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e8) {
                if (reader != null) {
                    reader.close();
                }
                return z;
            } catch (IOException e9) {
                if (reader != null) {
                    reader.close();
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                if (reader != null) {
                    reader.close();
                }
                throw th;
            }
        }
        return z;
    }

    String getVersion() {
        File versionFile = new File(SE_LINUX_VERSION_FILE_NAME);
        if (versionFile.exists()) {
            return Utils.readString(versionFile);
        }
        return null;
    }

    byte[] getPolicyHash() {
        File policyFile = new File(SE_LINUX_POLICY_FILE_NAME);
        if (policyFile.exists()) {
            return Utils.getSha256(policyFile);
        }
        return null;
    }
}

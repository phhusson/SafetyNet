package com.google.android.snet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

class Utils {
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    static class Bytes {
        private static final String TAG = Bytes.class.getSimpleName();
        private final byte[] mBytes;

        Bytes(byte[] bytes) {
            this.mBytes = bytes;
        }

        byte[] getBytes() {
            return this.mBytes;
        }

        public boolean equals(Object o) {
            boolean z = false;
            if (o == null) {
                return z;
            }
            if (o == this) {
                return true;
            }
            try {
                return Arrays.equals(this.mBytes, ((Bytes) o).getBytes());
            } catch (ClassCastException e) {
                return z;
            }
        }

        public int hashCode() {
            return Arrays.hashCode(this.mBytes) + 527;
        }
    }

    Utils() {
    }

    static byte[] getSha256(File file) {
        return getSha256(null, file);
    }

    static byte[] getSha256(byte[] blob, File file) {
        Throwable th;
        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-256");
            if (blob != null) {
                digester.update(blob);
            }
            InputStream inputStream = null;
            try {
                InputStream inputStream2 = new FileInputStream(file);
                try {
                    byte[] buf = new byte[1024];
                    while (true) {
                        int bytesRead = inputStream2.read(buf);
                        if (bytesRead <= 0) {
                            break;
                        }
                        digester.update(buf, 0, bytesRead);
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e) {
                        }
                    }
                    return digester.digest();
                } catch (IOException e2) {
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        return null;
                    }
                    try {
                        inputStream.close();
                        return null;
                    } catch (IOException e3) {
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                if (inputStream != null) {
                    return null;
                }
                inputStream.close();
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (NoSuchAlgorithmException e6) {
            return null;
        }
    }

    static byte[] getSha256(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        try {
            return MessageDigest.getInstance("SHA-256").digest(bytes);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    static String toHexString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(hexDigits[(b >> 4) & 15]).append(hexDigits[b & 15]);
        }
        return sb.toString();
    }

    static byte[] readBytes(File file) {
        Throwable th;
        byte[] data = new byte[((int) file.length())];
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            int pos = 0;
            int byteCount = 0;
            while (byteCount != -1) {
                try {
                    if (pos >= ((int) file.length())) {
                        break;
                    }
                    byteCount = bufferedInputStream2.read(data, pos, ((int) file.length()) - pos);
                    pos += byteCount;
                } catch (IOException e) {
                    bufferedInputStream = bufferedInputStream2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                }
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e2) {
                }
            }
            bufferedInputStream = bufferedInputStream2;
        } catch (IOException e3) {
            data = null;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e4) {
                }
            }
            return data;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
        return data;
    }

    static byte[] readInputStream(InputStream inputStream) {
        byte[] bArr = null;
        if (inputStream != null) {
            try {
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                byte[] buffer = new byte[16384];
                while (true) {
                    int chunkSize = inputStream.read(buffer);
                    if (chunkSize < 0) {
                        break;
                    } else if (chunkSize > 0) {
                        result.write(buffer, 0, chunkSize);
                    }
                }
                bArr = result.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (IOException e2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        }
        return bArr;
    }

    static boolean writeBytes(byte[] data, File file) {
        Throwable th;
        if (data == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                bufferedOutputStream2.write(data);
                bufferedOutputStream2.flush();
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e) {
                    }
                }
                return true;
            } catch (IOException e2) {
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    return false;
                }
                try {
                    bufferedOutputStream.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            if (bufferedOutputStream != null) {
                return false;
            }
            bufferedOutputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    static byte[] hexStringToByteArray(String hexString) {
        int resultLen = hexString.length() / 2;
        byte[] result = new byte[resultLen];
        for (int i = 0; i < resultLen; i++) {
            result[i] = (byte) ((Character.digit(hexString.charAt(i * 2), 16) << 4) + Character.digit(hexString.charAt((i * 2) + 1), 16));
        }
        return result;
    }

    static byte[] httpRequest(String url, byte[] requestBytes, int connectionTimeOutMs, int readTimeOutMs) {
        byte[] bArr = null;
        if (!(url == null || requestBytes == null)) {
            InputStream inputStream = null;
            HttpURLConnection urlConnection = null;
            try {
                urlConnection = (HttpURLConnection) new URL(url).openConnection();
                urlConnection.setDoOutput(true);
                urlConnection.setConnectTimeout(connectionTimeOutMs);
                urlConnection.setReadTimeout(readTimeOutMs);
                urlConnection.setFixedLengthStreamingMode(requestBytes.length);
                OutputStream outputStream = urlConnection.getOutputStream();
                outputStream.write(requestBytes);
                outputStream.close();
                if (urlConnection.getResponseCode() != 200) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                } else {
                    inputStream = urlConnection.getInputStream();
                    ByteArrayOutputStream result = new ByteArrayOutputStream();
                    byte[] buffer = new byte[16384];
                    while (true) {
                        int chunkSize = inputStream.read(buffer);
                        if (chunkSize < 0) {
                            break;
                        } else if (chunkSize > 0) {
                            result.write(buffer, 0, chunkSize);
                        }
                    }
                    bArr = result.toByteArray();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (IOException e3) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
        }
        return bArr;
    }

    static String readString(File file) {
        byte[] data = readBytes(file);
        if (data == null) {
            return null;
        }
        try {
            return new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    static String readVirtualFile(File file) {
        String stringBuilder;
        Throwable th;
        BufferedReader reader = null;
        try {
            BufferedReader reader2 = new BufferedReader(new FileReader(file));
            try {
                StringBuilder stringBuilder2 = new StringBuilder();
                while (true) {
                    String line = reader2.readLine();
                    if (line == null) {
                        break;
                    }
                    stringBuilder2.append(line);
                }
                stringBuilder = stringBuilder2.toString();
                if (reader2 != null) {
                    try {
                        reader2.close();
                    } catch (IOException e) {
                    }
                }
                reader = reader2;
            } catch (IOException e2) {
                reader = reader2;
                stringBuilder = null;
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e3) {
                    }
                }
                return stringBuilder;
            } catch (Throwable th2) {
                th = th2;
                reader = reader2;
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            stringBuilder = null;
            if (reader != null) {
                reader.close();
            }
            return stringBuilder;
        } catch (Throwable th3) {
            th = th3;
            if (reader != null) {
                reader.close();
            }
            throw th;
        }
        return stringBuilder;
    }

    static String readVirtualFile(String path) {
        return readVirtualFile(new File(path));
    }
}

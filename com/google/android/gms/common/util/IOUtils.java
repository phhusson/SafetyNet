package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public final class IOUtils {

    private static final class zza extends ByteArrayOutputStream {
        private zza() {
        }

        void zzc(byte[] bArr, int i) {
            System.arraycopy(this.buf, 0, bArr, i, this.count);
        }
    }

    private static final class zzb {
        private final File file;

        private zzb(File file) {
            this.file = (File) zzx.zzD(file);
        }

        public byte[] read() throws IOException {
            Throwable th;
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(this.file);
                try {
                    byte[] zzb = IOUtils.zza((InputStream) fileInputStream, fileInputStream.getChannel().size());
                    IOUtils.closeQuietly(fileInputStream);
                    return zzb;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                IOUtils.closeQuietly(fileInputStream);
                throw th;
            }
        }
    }

    private IOUtils() {
    }

    public static void close(Closeable c, String tag, String message) {
        if (c != null) {
            try {
                c.close();
            } catch (Throwable e) {
                Log.d(tag, message, e);
            }
        }
    }

    public static void closeQuietly(ParcelFileDescriptor p) {
        if (p != null) {
            try {
                p.close();
            } catch (IOException e) {
            }
        }
    }

    public static void closeQuietly(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
            }
        }
    }

    public static void closeQuietly(ServerSocket s) {
        if (s != null) {
            try {
                s.close();
            } catch (IOException e) {
            }
        }
    }

    public static void closeQuietly(Socket s) {
        if (s != null) {
            try {
                s.close();
            } catch (IOException e) {
            }
        }
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copyStream(inputStream, outputStream, false);
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream, boolean closeWhenDone) throws IOException {
        return copyStream(inputStream, outputStream, closeWhenDone, 1024);
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream, boolean closeWhenDone, int bufferSizeBytes) throws IOException {
        byte[] bArr = new byte[bufferSizeBytes];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (closeWhenDone) {
                    closeQuietly((Closeable) inputStream);
                    closeQuietly((Closeable) outputStream);
                }
            }
        }
        return j;
    }

    public static boolean isGzipByteBuffer(byte[] inputBytes) {
        return inputBytes.length > 1 && ((inputBytes[0] & 255) | ((inputBytes[1] & 255) << 8)) == 35615;
    }

    public static byte[] readInputStreamFully(InputStream is) throws IOException {
        return readInputStreamFully(is, true);
    }

    public static byte[] readInputStreamFully(InputStream is, boolean closeWhenDone) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyStream(is, byteArrayOutputStream, closeWhenDone);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(File file) throws IOException {
        return zzc(file).read();
    }

    private static long zza(InputStream inputStream, OutputStream outputStream) throws IOException {
        zzx.zzD(inputStream);
        zzx.zzD(outputStream);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    private static byte[] zza(InputStream inputStream, long j) throws IOException {
        if (j <= 2147483647L) {
            return j == 0 ? zzk(inputStream) : zzb(inputStream, (int) j);
        } else {
            throw new OutOfMemoryError("file is too large to fit in a byte array: " + j + " bytes");
        }
    }

    private static byte[] zzb(InputStream inputStream, int i) throws IOException {
        Object obj = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            int i3 = i - i2;
            int read = inputStream.read(obj, i3, i2);
            if (read == -1) {
                return Arrays.copyOf(obj, i3);
            }
            i2 -= read;
        }
        i2 = inputStream.read();
        if (i2 == -1) {
            return obj;
        }
        OutputStream com_google_android_gms_common_util_IOUtils_zza = new zza();
        com_google_android_gms_common_util_IOUtils_zza.write(i2);
        zza(inputStream, com_google_android_gms_common_util_IOUtils_zza);
        Object obj2 = new byte[(obj.length + com_google_android_gms_common_util_IOUtils_zza.size())];
        System.arraycopy(obj, 0, obj2, 0, obj.length);
        com_google_android_gms_common_util_IOUtils_zza.zzc(obj2, obj.length);
        return obj2;
    }

    private static zzb zzc(File file) {
        return new zzb(file);
    }

    private static byte[] zzk(InputStream inputStream) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zza(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}

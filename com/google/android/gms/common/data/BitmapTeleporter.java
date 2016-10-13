package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BitmapTeleporter implements SafeParcelable {
    public static final Creator<BitmapTeleporter> CREATOR = new zza();
    final int mVersionCode;
    ParcelFileDescriptor zzIM;
    final int zzUO;
    private Bitmap zzatB;
    private boolean zzatC;
    private File zzatD;

    BitmapTeleporter(int versionCode, ParcelFileDescriptor parcelFileDescriptor, int type) {
        this.mVersionCode = versionCode;
        this.zzIM = parcelFileDescriptor;
        this.zzUO = type;
        this.zzatB = null;
        this.zzatC = false;
    }

    public BitmapTeleporter(Bitmap teleportee) {
        this.mVersionCode = 1;
        this.zzIM = null;
        this.zzUO = 0;
        this.zzatB = teleportee;
        this.zzatC = true;
    }

    private void zza(Closeable closeable) {
        try {
            closeable.close();
        } catch (Throwable e) {
            Log.w("BitmapTeleporter", "Could not close stream", e);
        }
    }

    private FileOutputStream zzqu() {
        if (this.zzatD == null) {
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
        try {
            File createTempFile = File.createTempFile("teleporter", ".tmp", this.zzatD);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                this.zzIM = ParcelFileDescriptor.open(createTempFile, 268435456);
                createTempFile.delete();
                return fileOutputStream;
            } catch (FileNotFoundException e) {
                throw new IllegalStateException("Temporary file is somehow already deleted");
            }
        } catch (Throwable e2) {
            throw new IllegalStateException("Could not create temporary file", e2);
        }
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap get() {
        if (!this.zzatC) {
            Closeable dataInputStream = new DataInputStream(new AutoCloseInputStream(this.zzIM));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                int readInt = dataInputStream.readInt();
                int readInt2 = dataInputStream.readInt();
                Config valueOf = Config.valueOf(dataInputStream.readUTF());
                dataInputStream.read(bArr);
                zza(dataInputStream);
                Buffer wrap = ByteBuffer.wrap(bArr);
                Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                createBitmap.copyPixelsFromBuffer(wrap);
                this.zzatB = createBitmap;
                this.zzatC = true;
            } catch (Throwable e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                zza(dataInputStream);
            }
        }
        return this.zzatB;
    }

    public void release() {
        if (!this.zzatC) {
            try {
                this.zzIM.close();
            } catch (Throwable e) {
                Log.w("BitmapTeleporter", "Could not close PFD", e);
            }
        }
    }

    public void setTempDir(File tempDir) {
        if (tempDir == null) {
            throw new NullPointerException("Cannot set null temp directory");
        }
        this.zzatD = tempDir;
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (this.zzIM == null) {
            Bitmap bitmap = this.zzatB;
            Buffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            Closeable dataOutputStream = new DataOutputStream(zzqu());
            try {
                dataOutputStream.writeInt(array.length);
                dataOutputStream.writeInt(bitmap.getWidth());
                dataOutputStream.writeInt(bitmap.getHeight());
                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                dataOutputStream.write(array);
                zza(dataOutputStream);
            } catch (Throwable e) {
                throw new IllegalStateException("Could not write into unlinked file", e);
            } catch (Throwable th) {
                zza(dataOutputStream);
            }
        }
        zza.zza(this, dest, flags | 1);
        this.zzIM = null;
    }
}

package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.auth.firstparty.recovery.RecoveryParamConstants;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.zzr;
import com.google.android.gms.internal.zznr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object zzaun = new Object();
    private static HashSet<Uri> zzauo = new HashSet();
    private static ImageManager zzaup;
    private static ImageManager zzauq;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzaur = Executors.newFixedThreadPool(4);
    private final zzb zzaus;
    private final zznr zzaut;
    private final Map<zza, ImageReceiver> zzauu;
    private final Map<Uri, ImageReceiver> zzauv;
    private final Map<Uri, Long> zzauw;

    @KeepName
    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<zza> zzaux = new ArrayList();
        final /* synthetic */ ImageManager zzauy;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.zzauy = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            this.zzauy.zzaur.execute(new zzc(this.zzauy, this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzb(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzb.zzcC("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzaux.add(com_google_android_gms_common_images_zza);
        }

        public void zzc(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzb.zzcC("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzaux.remove(com_google_android_gms_common_images_zza);
        }

        public void zzqG() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.zzauy.mContext.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    @TargetApi(11)
    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private static final class zzb extends LruCache<zza, Bitmap> {
        public zzb(Context context) {
            super(zzat(context));
        }

        @TargetApi(11)
        private static int zzat(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(RecoveryParamConstants.VALUE_ACTIVITY);
            int memoryClass = (((context.getApplicationInfo().flags & 1048576) != 0 ? 1 : null) == null || !zzr.zzsi()) ? activityManager.getMemoryClass() : zza.zza(activityManager);
            return (int) (((float) (memoryClass * 1048576)) * 0.33f);
        }

        protected /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            zza(z, (zza) obj, (Bitmap) obj2, (Bitmap) obj3);
        }

        protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return zza((zza) obj, (Bitmap) obj2);
        }

        protected int zza(zza com_google_android_gms_common_images_zza_zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void zza(boolean z, zza com_google_android_gms_common_images_zza_zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, com_google_android_gms_common_images_zza_zza, bitmap, bitmap2);
        }
    }

    private final class zzc implements Runnable {
        private final Uri mUri;
        final /* synthetic */ ImageManager zzauy;
        private final ParcelFileDescriptor zzauz;

        public zzc(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzauy = imageManager;
            this.mUri = uri;
            this.zzauz = parcelFileDescriptor;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzcD("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.zzauz != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.zzauz.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.zzauz.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.zzauy.mHandler.post(new zzf(this.zzauy, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    private final class zzd implements Runnable {
        private final zza zzauA;
        final /* synthetic */ ImageManager zzauy;

        public zzd(ImageManager imageManager, zza com_google_android_gms_common_images_zza) {
            this.zzauy = imageManager;
            this.zzauA = com_google_android_gms_common_images_zza;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzcC("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.zzauy.zzauu.get(this.zzauA);
            if (imageReceiver != null) {
                this.zzauy.zzauu.remove(this.zzauA);
                imageReceiver.zzc(this.zzauA);
            }
            zza com_google_android_gms_common_images_zza_zza = this.zzauA.zzauC;
            if (com_google_android_gms_common_images_zza_zza.uri == null) {
                this.zzauA.zza(this.zzauy.mContext, this.zzauy.zzaut, true);
                return;
            }
            Bitmap zza = this.zzauy.zza(com_google_android_gms_common_images_zza_zza);
            if (zza != null) {
                this.zzauA.zza(this.zzauy.mContext, zza, true);
                return;
            }
            Long l = (Long) this.zzauy.zzauw.get(com_google_android_gms_common_images_zza_zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzauA.zza(this.zzauy.mContext, this.zzauy.zzaut, true);
                    return;
                }
                this.zzauy.zzauw.remove(com_google_android_gms_common_images_zza_zza.uri);
            }
            this.zzauA.zza(this.zzauy.mContext, this.zzauy.zzaut);
            imageReceiver = (ImageReceiver) this.zzauy.zzauv.get(com_google_android_gms_common_images_zza_zza.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.zzauy, com_google_android_gms_common_images_zza_zza.uri);
                this.zzauy.zzauv.put(com_google_android_gms_common_images_zza_zza.uri, imageReceiver);
            }
            imageReceiver.zzb(this.zzauA);
            if (!(this.zzauA instanceof com.google.android.gms.common.images.zza.zzc)) {
                this.zzauy.zzauu.put(this.zzauA, imageReceiver);
            }
            synchronized (ImageManager.zzaun) {
                if (!ImageManager.zzauo.contains(com_google_android_gms_common_images_zza_zza.uri)) {
                    ImageManager.zzauo.add(com_google_android_gms_common_images_zza_zza.uri);
                    imageReceiver.zzqG();
                }
            }
        }
    }

    @TargetApi(14)
    private static final class zze implements ComponentCallbacks2 {
        private final zzb zzaus;

        public zze(zzb com_google_android_gms_common_images_ImageManager_zzb) {
            this.zzaus = com_google_android_gms_common_images_ImageManager_zzb;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.zzaus.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.zzaus.evictAll();
            } else if (level >= 20) {
                this.zzaus.trimToSize(this.zzaus.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private boolean zzauB;
        final /* synthetic */ ImageManager zzauy;
        private final CountDownLatch zzqn;

        public zzf(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.zzauy = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzauB = z;
            this.zzqn = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList zza = imageReceiver.zzaux;
            int size = zza.size();
            for (int i = 0; i < size; i++) {
                zza com_google_android_gms_common_images_zza = (zza) zza.get(i);
                if (z) {
                    com_google_android_gms_common_images_zza.zza(this.zzauy.mContext, this.mBitmap, false);
                } else {
                    this.zzauy.zzauw.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    com_google_android_gms_common_images_zza.zza(this.zzauy.mContext, this.zzauy.zzaut, false);
                }
                if (!(com_google_android_gms_common_images_zza instanceof com.google.android.gms.common.images.zza.zzc)) {
                    this.zzauy.zzauu.remove(com_google_android_gms_common_images_zza);
                }
            }
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzcC("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.zzauy.zzaus != null) {
                if (this.zzauB) {
                    this.zzauy.zzaus.evictAll();
                    System.gc();
                    this.zzauB = false;
                    this.zzauy.mHandler.post(this);
                    return;
                } else if (z) {
                    this.zzauy.zzaus.put(new zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.zzauy.zzauv.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzqn.countDown();
            synchronized (ImageManager.zzaun) {
                ImageManager.zzauo.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        if (withMemoryCache) {
            this.zzaus = new zzb(this.mContext);
            if (zzr.zzsl()) {
                zzqD();
            }
        } else {
            this.zzaus = null;
        }
        this.zzaut = new zznr();
        this.zzauu = new HashMap();
        this.zzauv = new HashMap();
        this.zzauw = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzc(context, false);
    }

    private Bitmap zza(zza com_google_android_gms_common_images_zza_zza) {
        return this.zzaus == null ? null : (Bitmap) this.zzaus.get(com_google_android_gms_common_images_zza_zza);
    }

    public static ImageManager zzc(Context context, boolean z) {
        if (z) {
            if (zzauq == null) {
                zzauq = new ImageManager(context, true);
            }
            return zzauq;
        }
        if (zzaup == null) {
            zzaup = new ImageManager(context, false);
        }
        return zzaup;
    }

    @TargetApi(14)
    private void zzqD() {
        this.mContext.registerComponentCallbacks(new zze(this.zzaus));
    }

    public void loadImage(ImageView imageView, int resId) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, resId));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        zza com_google_android_gms_common_images_zza_zzb = new com.google.android.gms.common.images.zza.zzb(imageView, uri);
        com_google_android_gms_common_images_zza_zzb.zzdd(defaultResId);
        zza(com_google_android_gms_common_images_zza_zzb);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzc(listener, uri));
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        zza com_google_android_gms_common_images_zza_zzc = new com.google.android.gms.common.images.zza.zzc(listener, uri);
        com_google_android_gms_common_images_zza_zzc.zzdd(defaultResId);
        zza(com_google_android_gms_common_images_zza_zzc);
    }

    public void zza(zza com_google_android_gms_common_images_zza) {
        com.google.android.gms.common.internal.zzb.zzcC("ImageManager.loadImage() must be called in the main thread");
        new zzd(this, com_google_android_gms_common_images_zza).run();
    }
}

package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zznp;
import com.google.android.gms.internal.zznq;
import com.google.android.gms.internal.zznr;
import java.lang.ref.WeakReference;

public abstract class zza {
    final zza zzauC;
    protected int zzauD = 0;
    protected int zzauE = 0;
    protected boolean zzauF = false;
    protected OnImageLoadedListener zzauG;
    private boolean zzauH = true;
    private boolean zzauI = false;
    private boolean zzauJ = true;
    protected int zzauK;

    static final class zza {
        public final Uri uri;

        public zza(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (obj instanceof zza) {
                return this == obj ? true : zzw.equal(((zza) obj).uri, this.uri);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return zzw.hashCode(this.uri);
        }
    }

    public static final class zzb extends zza {
        private WeakReference<ImageView> zzauL;

        public zzb(ImageView imageView, int i) {
            super(null, i);
            com.google.android.gms.common.internal.zzb.zzz(imageView);
            this.zzauL = new WeakReference(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzz(imageView);
            this.zzauL = new WeakReference(imageView);
        }

        private void zza(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof zznq)) {
                int zzqJ = ((zznq) imageView).zzqJ();
                if (this.zzauE != 0 && zzqJ == this.zzauE) {
                    return;
                }
            }
            boolean zzc = zzc(z, z2);
            Drawable newDrawable = (!this.zzauF || drawable == null) ? drawable : drawable.getConstantState().newDrawable();
            if (zzc) {
                newDrawable = zza(imageView.getDrawable(), newDrawable);
            }
            imageView.setImageDrawable(newDrawable);
            if (imageView instanceof zznq) {
                zznq com_google_android_gms_internal_zznq = (zznq) imageView;
                com_google_android_gms_internal_zznq.zzm(z3 ? this.zzauC.uri : null);
                com_google_android_gms_internal_zznq.zzdf(obj != null ? this.zzauE : 0);
            }
            if (zzc) {
                ((zzno) newDrawable).startTransition(250);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.zzauL.get();
            ImageView imageView2 = (ImageView) ((zzb) obj).zzauL.get();
            boolean z = (imageView2 == null || imageView == null || !zzw.equal(imageView2, imageView)) ? false : true;
            return z;
        }

        public int hashCode() {
            return 0;
        }

        protected void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.zzauL.get();
            if (imageView != null) {
                zza(imageView, drawable, z, z2, z3);
            }
        }
    }

    public static final class zzc extends zza {
        private WeakReference<OnImageLoadedListener> zzauM;

        public zzc(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzz(onImageLoadedListener);
            this.zzauM = new WeakReference(onImageLoadedListener);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc com_google_android_gms_common_images_zza_zzc = (zzc) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.zzauM.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) com_google_android_gms_common_images_zza_zzc.zzauM.get();
            boolean z = onImageLoadedListener2 != null && onImageLoadedListener != null && zzw.equal(onImageLoadedListener2, onImageLoadedListener) && zzw.equal(com_google_android_gms_common_images_zza_zzc.zzauC, this.zzauC);
            return z;
        }

        public int hashCode() {
            return zzw.hashCode(this.zzauC);
        }

        protected void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.zzauM.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.zzauC.uri, drawable, z3);
                }
            }
        }
    }

    public zza(Uri uri, int i) {
        this.zzauC = new zza(uri);
        this.zzauE = i;
    }

    private Drawable zza(Context context, zznr com_google_android_gms_internal_zznr, int i) {
        Resources resources = context.getResources();
        if (this.zzauK <= 0) {
            return resources.getDrawable(i);
        }
        com.google.android.gms.internal.zznr.zza com_google_android_gms_internal_zznr_zza = new com.google.android.gms.internal.zznr.zza(i, this.zzauK);
        Drawable drawable = (Drawable) com_google_android_gms_internal_zznr.get(com_google_android_gms_internal_zznr_zza);
        if (drawable != null) {
            return drawable;
        }
        drawable = resources.getDrawable(i);
        if ((this.zzauK & 1) != 0) {
            drawable = zza(resources, drawable);
        }
        com_google_android_gms_internal_zznr.put(com_google_android_gms_internal_zznr_zza, drawable);
        return drawable;
    }

    protected Drawable zza(Resources resources, Drawable drawable) {
        return zznp.zza(resources, drawable);
    }

    protected zzno zza(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzno) {
            drawable = ((zzno) drawable).zzqH();
        }
        return new zzno(drawable, drawable2);
    }

    void zza(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzb.zzz(bitmap);
        if ((this.zzauK & 1) != 0) {
            bitmap = zznp.zzc(bitmap);
        }
        Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.zzauG != null) {
            this.zzauG.onImageLoaded(this.zzauC.uri, bitmapDrawable, true);
        }
        zza(bitmapDrawable, z, false, true);
    }

    void zza(Context context, zznr com_google_android_gms_internal_zznr) {
        if (this.zzauJ) {
            Drawable drawable = null;
            if (this.zzauD != 0) {
                drawable = zza(context, com_google_android_gms_internal_zznr, this.zzauD);
            }
            zza(drawable, false, true, false);
        }
    }

    void zza(Context context, zznr com_google_android_gms_internal_zznr, boolean z) {
        Drawable drawable = null;
        if (this.zzauE != 0) {
            drawable = zza(context, com_google_android_gms_internal_zznr, this.zzauE);
        }
        if (this.zzauG != null) {
            this.zzauG.onImageLoaded(this.zzauC.uri, drawable, false);
        }
        zza(drawable, z, false, false);
    }

    protected abstract void zza(Drawable drawable, boolean z, boolean z2, boolean z3);

    protected boolean zzc(boolean z, boolean z2) {
        return this.zzauH && !z2 && (!z || this.zzauI);
    }

    public void zzdd(int i) {
        this.zzauE = i;
    }
}

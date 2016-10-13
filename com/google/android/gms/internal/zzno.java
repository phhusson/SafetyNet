package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import com.google.android.gms.common.util.zzr;

public final class zzno extends Drawable implements Callback {
    private int mFrom;
    private long zzRO;
    private boolean zzauH;
    private int zzauO;
    private int zzauP;
    private int zzauQ;
    private int zzauR;
    private int zzauS;
    private boolean zzauT;
    private zzb zzauU;
    private Drawable zzauV;
    private Drawable zzauW;
    private boolean zzauX;
    private boolean zzauY;
    private boolean zzauZ;
    private int zzava;

    private static final class zza extends Drawable {
        private static final zza zzavb = new zza();
        private static final zza zzavc = new zza();

        private static final class zza extends ConstantState {
            private zza() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return zza.zzavb;
            }
        }

        private zza() {
        }

        public void draw(Canvas canvas) {
        }

        public ConstantState getConstantState() {
            return zzavc;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }
    }

    static final class zzb extends ConstantState {
        int zzavd;
        int zzave;

        zzb(zzb com_google_android_gms_internal_zzno_zzb) {
            if (com_google_android_gms_internal_zzno_zzb != null) {
                this.zzavd = com_google_android_gms_internal_zzno_zzb.zzavd;
                this.zzave = com_google_android_gms_internal_zzno_zzb.zzave;
            }
        }

        public int getChangingConfigurations() {
            return this.zzavd;
        }

        public Drawable newDrawable() {
            return new zzno(this);
        }
    }

    public zzno(Drawable drawable, Drawable drawable2) {
        this(null);
        if (drawable == null) {
            drawable = zza.zzavb;
        }
        this.zzauV = drawable;
        drawable.setCallback(this);
        zzb com_google_android_gms_internal_zzno_zzb = this.zzauU;
        com_google_android_gms_internal_zzno_zzb.zzave |= drawable.getChangingConfigurations();
        if (drawable2 == null) {
            drawable2 = zza.zzavb;
        }
        this.zzauW = drawable2;
        drawable2.setCallback(this);
        com_google_android_gms_internal_zzno_zzb = this.zzauU;
        com_google_android_gms_internal_zzno_zzb.zzave |= drawable2.getChangingConfigurations();
    }

    zzno(zzb com_google_android_gms_internal_zzno_zzb) {
        this.zzauO = 0;
        this.zzauQ = 255;
        this.zzauS = 0;
        this.zzauH = true;
        this.zzauU = new zzb(com_google_android_gms_internal_zzno_zzb);
    }

    public boolean canConstantState() {
        if (!this.zzauX) {
            boolean z = (this.zzauV.getConstantState() == null || this.zzauW.getConstantState() == null) ? false : true;
            this.zzauY = z;
            this.zzauX = true;
        }
        return this.zzauY;
    }

    public void draw(Canvas canvas) {
        int i = 1;
        int i2 = 0;
        switch (this.zzauO) {
            case 1:
                this.zzRO = SystemClock.uptimeMillis();
                this.zzauO = 2;
                break;
            case 2:
                if (this.zzRO >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zzRO)) / ((float) this.zzauR);
                    if (uptimeMillis < 1.0f) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.zzauO = 0;
                    }
                    float min = Math.min(uptimeMillis, 1.0f);
                    this.zzauS = (int) ((min * ((float) (this.zzauP - this.mFrom))) + ((float) this.mFrom));
                    break;
                }
                break;
        }
        i2 = i;
        i = this.zzauS;
        boolean z = this.zzauH;
        Drawable drawable = this.zzauV;
        Drawable drawable2 = this.zzauW;
        if (i2 != 0) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.zzauQ) {
                drawable2.setAlpha(this.zzauQ);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.zzauQ - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.zzauQ);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzauQ);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return (super.getChangingConfigurations() | this.zzauU.zzavd) | this.zzauU.zzave;
    }

    public ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zzauU.zzavd = getChangingConfigurations();
        return this.zzauU;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.zzauV.getIntrinsicHeight(), this.zzauW.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.zzauV.getIntrinsicWidth(), this.zzauW.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.zzauZ) {
            this.zzava = Drawable.resolveOpacity(this.zzauV.getOpacity(), this.zzauW.getOpacity());
            this.zzauZ = true;
        }
        return this.zzava;
    }

    @TargetApi(11)
    public void invalidateDrawable(Drawable who) {
        if (zzr.zzsi()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public Drawable mutate() {
        if (!this.zzauT && super.mutate() == this) {
            if (canConstantState()) {
                this.zzauV.mutate();
                this.zzauW.mutate();
                this.zzauT = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    protected void onBoundsChange(Rect bounds) {
        this.zzauV.setBounds(bounds);
        this.zzauW.setBounds(bounds);
    }

    @TargetApi(11)
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        if (zzr.zzsi()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.scheduleDrawable(this, what, when);
            }
        }
    }

    public void setAlpha(int alpha) {
        if (this.zzauS == this.zzauQ) {
            this.zzauS = alpha;
        }
        this.zzauQ = alpha;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter cf) {
        this.zzauV.setColorFilter(cf);
        this.zzauW.setColorFilter(cf);
    }

    public void startTransition(int durationMillis) {
        this.mFrom = 0;
        this.zzauP = this.zzauQ;
        this.zzauS = 0;
        this.zzauR = durationMillis;
        this.zzauO = 1;
        invalidateSelf();
    }

    @TargetApi(11)
    public void unscheduleDrawable(Drawable who, Runnable what) {
        if (zzr.zzsi()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.unscheduleDrawable(this, what);
            }
        }
    }

    public Drawable zzqH() {
        return this.zzauW;
    }
}

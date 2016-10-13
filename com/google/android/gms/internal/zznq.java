package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class zznq extends ImageView {
    private Uri zzavf;
    private int zzavg;
    private int zzavh;
    private zza zzavi;
    private int zzavj;
    private float zzavk;

    public interface zza {
        Path zzw(int i, int i2);
    }

    protected void onDraw(Canvas canvas) {
        if (this.zzavi != null) {
            canvas.clipPath(this.zzavi.zzw(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzavh != 0) {
            canvas.drawColor(this.zzavh);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredHeight;
        int i;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        switch (this.zzavj) {
            case 1:
                measuredHeight = getMeasuredHeight();
                i = (int) (((float) measuredHeight) * this.zzavk);
                break;
            case 2:
                i = getMeasuredWidth();
                measuredHeight = (int) (((float) i) / this.zzavk);
                break;
            default:
                return;
        }
        setMeasuredDimension(i, measuredHeight);
    }

    public void zzdf(int i) {
        this.zzavg = i;
    }

    public void zzm(Uri uri) {
        this.zzavf = uri;
    }

    public int zzqJ() {
        return this.zzavg;
    }
}
